package com.tencent.libra.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.download.RFWAbsPicDW;
import com.tencent.libra.request.CustomDownloadRequest;
import com.tencent.libra.request.Option;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.libra.util.LibraLogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFWOkHttpDW extends RFWAbsPicDW {
    private static final String CONTENT_LENGTH = "Content-Length";

    @NonNull
    private final OkHttpClient mClient;

    @NonNull
    private final LibraDns mDns;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RFWOkHttpDW");
    private static final RFWPicOKHttpDynamicTimeout sTimeOut = new RFWPicOKHttpDynamicTimeout();
    private static final long sMaxDownloadFileSize = LibraConfigUtil.INSTANCE.maxDownloadContentLength();

    public RFWOkHttpDW(@NonNull ILibraBaseStrategy iLibraBaseStrategy) {
        boolean z16;
        if (Build.VERSION.SDK_INT == 27) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = z16 ? 1 : 2;
        LibraDns libraDns = new LibraDns(iLibraBaseStrategy);
        this.mDns = libraDns;
        int i16 = i3 * 5;
        this.mClient = RFWPicDownloadOkHttpFactory.createOkHttpClient(i16, i3 * 64, i16, new ArrayList(), getInterceptors(iLibraBaseStrategy), libraDns);
    }

    private void closeStream(FileOutputStream fileOutputStream, InputStream inputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e16) {
                e16.printStackTrace();
                RFWLog.d(TAG, RFWLog.USR, "closeStream exception" + e16.getMessage());
                return;
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private void decodeBitmapByNetInputStream(Option option, InputStream inputStream, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (decodeByteArray != null) {
                    option.setResultBitMap(decodeByteArray);
                    iCallBackListener.callBack(option, true, 0);
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[decodeBitmapByNetInputStream] success cacheKey = ", option.getCacheKey());
                } else {
                    iCallBackListener.callBack(option, false, -1);
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[decodeBitmapByNetInputStream] failed cacheKey = ", option.getCacheKey());
                }
                RFWIOUtil.closeAll(byteArrayOutputStream, inputStream);
            } catch (Exception e16) {
                handleRetry(option, iCallBackListener);
                LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[decodeBitmapByNetInputStream] read stream exception:", e16);
                RFWIOUtil.closeAll(byteArrayOutputStream, inputStream);
            }
        } catch (Throwable th5) {
            RFWIOUtil.closeAll(byteArrayOutputStream, inputStream);
            throw th5;
        }
    }

    public static long getAvailableCount() {
        StatFs statFs = new StatFs(LibraPicLoaderFactory.getPrivateFilePath().getAbsolutePath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    private ArrayList<Interceptor> getInterceptors(@NonNull ILibraBaseStrategy iLibraBaseStrategy) {
        ArrayList<Interceptor> arrayList = new ArrayList<>();
        if (iLibraBaseStrategy.getLibraIpStrategyBean().getIsSupportIpRaceStrategy()) {
            arrayList.add(new x01.b());
        }
        return arrayList;
    }

    private File getTempFile(Option option, long j3) {
        File createNewFile = RFWFileUtils.createNewFile(option.getTmpFilePath());
        if (createNewFile == null || getAvailableCount() < j3) {
            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[getTempFile] create tempFile error fileLength = ", Long.valueOf(j3));
            RFWFileUtils.deleteFile(new File(option.getLocalPath()).getParentFile());
            return RFWFileUtils.createNewFile(option.getTmpFilePath());
        }
        return createNewFile;
    }

    private void handleException(Option option, File file, File file2, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        if (file != null && file.exists()) {
            file.delete();
        }
        if (file2 != null && file2.exists()) {
            file2.delete();
        }
        handleRetry(option, iCallBackListener);
    }

    private void handleRetry(Option option, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        option.updateRetryCount();
        boolean continueRetry = option.continueRetry();
        LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[handleRetry] continue try:", Boolean.valueOf(continueRetry), " retry currentTimes:", Integer.valueOf(option.getRetryCount()));
        if (continueRetry) {
            okHttpDownload(option, iCallBackListener);
        } else {
            iCallBackListener.callBack(option, false, 1);
        }
    }

    private void okHttpDownload(Option option, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        Request.Builder tag = new Request.Builder().addHeader("Connection", "close").get().url(this.mDns.getHttpUrl(option)).tag(Option.class, option);
        CustomDownloadRequest b16 = com.tencent.libra.util.a.f118813a.b(option);
        if (b16 != null) {
            for (Map.Entry<String, String> entry : b16.a().entrySet()) {
                tag.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Call newCall = this.mClient.newCall(tag.build());
        try {
            Response execute = newCall.execute();
            try {
                if (execute.isSuccessful()) {
                    String str = execute.headers().get("Content-Length");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            long parseLong = Long.parseLong(str);
                            long j3 = sMaxDownloadFileSize;
                            if (j3 != 0 && parseLong > j3) {
                                iCallBackListener.callBack(option, false, 2);
                                LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[okHttpDownload] failed ", Long.valueOf(parseLong), " over max file size:", Long.valueOf(j3));
                                execute.close();
                                return;
                            }
                        } catch (NumberFormatException unused) {
                            LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[okHttpDownload] getContentLength failed");
                        }
                    }
                    writeToFile(option, execute, iCallBackListener);
                } else {
                    if (!execute.isRedirect() && execute.code() >= 200 && execute.code() < 500) {
                        LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[okHttpDownload] result failed code:", Integer.valueOf(execute.code()));
                        iCallBackListener.callBack(option, false, 1);
                    }
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[okHttpDownload] failed code:", Integer.valueOf(execute.code()));
                    handleRetry(option, iCallBackListener);
                }
                execute.close();
            } finally {
            }
        } catch (IOException e16) {
            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[okHttpDownload] IOException:", e16);
            if (!newCall.getCanceled() || !RFWConfig.getConfigValue("enable_pic_loader_cancel_download", false)) {
                handleRetry(option, iCallBackListener);
            }
        } catch (RuntimeException e17) {
            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[okHttpDownload] RuntimeException:", e17);
            iCallBackListener.callBack(option, false, 1);
        }
    }

    private void upDateTimeOut(Option option, boolean z16) {
        sTimeOut.upDateTimeOut(z16, option.getSeq());
    }

    private void writeToFile(Option option, Response response, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        File file;
        File tempFile;
        if (option != null && response != null && response.body() != null && iCallBackListener != null) {
            FileOutputStream fileOutputStream2 = null;
            r8 = null;
            File file2 = null;
            fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    inputStream = response.body().byteStream();
                } catch (Exception e16) {
                    e = e16;
                    inputStream = null;
                    fileOutputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
                try {
                    try {
                        tempFile = getTempFile(option, response.body().getContentLength());
                        try {
                        } catch (Exception e18) {
                            e = e18;
                            fileOutputStream = null;
                            file = null;
                        }
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                    }
                } catch (Exception e26) {
                    e = e26;
                    fileOutputStream = null;
                    file = fileOutputStream;
                    LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[writeToFile] error cacheKey = ", option.getCacheKey(), " exception = ", e);
                    upDateTimeOut(option, e instanceof TimeoutException);
                    handleException(option, file2, file, iCallBackListener);
                    closeStream(fileOutputStream, inputStream);
                }
                if (tempFile == null) {
                    decodeBitmapByNetInputStream(option, inputStream, iCallBackListener);
                    closeStream(null, inputStream);
                    return;
                }
                RFWFileUtils.createNoMediaFile(option.getLocalPath());
                fileOutputStream = new FileOutputStream(tempFile, true);
                try {
                    try {
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = inputStream.read(bArr, 0, 8192);
                                if (read <= 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            file = new File(option.getLocalPath());
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            fileOutputStream3 = fileOutputStream;
                            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[writeToFile] error cacheKey = ", option.getCacheKey(), " OutOfMemoryError = ", e);
                            handleRetry(option, iCallBackListener);
                            closeStream(fileOutputStream3, inputStream);
                            return;
                        }
                    } catch (Exception e28) {
                        e = e28;
                        file = null;
                    }
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                        if (!tempFile.renameTo(file)) {
                            boolean copyFile = RFWFileUtils.copyFile(tempFile, file);
                            RFWFileUtils.deleteFile(tempFile);
                            if (!copyFile) {
                                LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[writeToFile] failed cacheKey = ", option.getCacheKey());
                                iCallBackListener.callBack(option, false, 1);
                                closeStream(fileOutputStream, inputStream);
                                return;
                            }
                        }
                        LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[writeToFile] has download cacheKey = ", option.getCacheKey(), " url = ", option.getUrl());
                        iCallBackListener.callBack(option, true, 0);
                        upDateTimeOut(option, false);
                    } catch (Exception e29) {
                        e = e29;
                        file2 = tempFile;
                        LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[writeToFile] error cacheKey = ", option.getCacheKey(), " exception = ", e);
                        upDateTimeOut(option, e instanceof TimeoutException);
                        handleException(option, file2, file, iCallBackListener);
                        closeStream(fileOutputStream, inputStream);
                    }
                    closeStream(fileOutputStream, inputStream);
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = fileOutputStream;
                    closeStream(fileOutputStream2, inputStream);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public void cancel(Option option) {
        try {
            List<Call> runningCalls = this.mClient.dispatcher().runningCalls();
            LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[cancel] running size=", Integer.valueOf(runningCalls.size()));
            for (Call call : runningCalls) {
                if (option == ((Option) call.request().tag(Option.class))) {
                    call.cancel();
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[cancel] success");
                    return;
                }
            }
        } catch (Exception e16) {
            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[cancel] exception" + e16.getMessage());
        }
    }

    @Override // com.tencent.libra.download.RFWAbsPicDW
    public void handlerDownLoad(Option option, RFWAbsPicDW.ICallBackListener iCallBackListener) {
        this.mDns.handleIpConnect(option);
        okHttpDownload(option, iCallBackListener);
    }

    public void release() {
        try {
            List<Call> runningCalls = this.mClient.dispatcher().runningCalls();
            Iterator<Call> it = runningCalls.iterator();
            RFWLog.d(TAG, RFWLog.USR, "[release] running size:", Integer.valueOf(runningCalls.size()));
            while (it.hasNext()) {
                it.next().cancel();
            }
        } catch (Exception e16) {
            RFWLog.d(TAG, RFWLog.USR, "[release] exception" + e16.getMessage());
        }
    }
}
