package com.tencent.mobileqq.mini.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.open.adapter.a;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReportLogUtil {
    private static final String TAG = "ReportLogUtil";
    private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH_mm_ss");

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniAppTransHandler extends TransProcessorHandler {
        UploadLogListener uploadLogListener;

        public MiniAppTransHandler(Looper looper, UploadLogListener uploadLogListener) {
            super(looper);
            this.uploadLogListener = uploadLogListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null && fileMsg.commandId == 65 && fileMsg.fileType == 24) {
                int i3 = message.what;
                if (i3 != 1007 && i3 != 1003) {
                    if (i3 == 1005) {
                        QLog.d("BDH", 2, "handleMessage  STATUS_SEND_ERROR");
                        UploadLogListener uploadLogListener = this.uploadLogListener;
                        if (uploadLogListener != null) {
                            uploadLogListener.onFail("send error, code:1005");
                            return;
                        }
                        return;
                    }
                    if (i3 == 1001) {
                        QLog.d("BDH", 2, "handleMessage  STATUS_SEND_START");
                        return;
                    }
                    QLog.d("BDH", 2, "handleMessage  unkown:" + message.what);
                    return;
                }
                QLog.d("BDH", 2, "handleMessage  STATUS_UPLOAD_FINISHED");
                Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                try {
                    uploadPicExtInfo.mergeFrom(fileMsg.bdhExtendInfo);
                    String stringUtf8 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                    UploadLogListener uploadLogListener2 = this.uploadLogListener;
                    if (uploadLogListener2 != null) {
                        uploadLogListener2.onSuccess(stringUtf8);
                    }
                    QLog.d("BDH", 2, "handleMessage :" + stringUtf8);
                } catch (Exception e16) {
                    QLog.d("BDH", 2, "handleMessage " + e16);
                    UploadLogListener uploadLogListener3 = this.uploadLogListener;
                    if (uploadLogListener3 != null) {
                        uploadLogListener3.onFail(e16.getMessage());
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface UploadLogListener {
        void onFail(String str);

        void onSuccess(String str);
    }

    public static void compressAndUploadLog(final String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        final String miniLogFolderPath = MiniLog.getMiniLogFolderPath(str);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.utils.ReportLogUtil.2
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = new File(miniLogFolderPath).listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.length() == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(ReportLogUtil.TAG, 2, HippyBridge.URI_SCHEME_FILE + file.getName() + " size is 0");
                        }
                        file.delete();
                    } else {
                        String name = file.getName();
                        if (name.contains("log") && !name.endsWith(".zip")) {
                            arrayList.add(new MiniLogManager.LogFile(file.getPath()));
                        }
                    }
                }
                try {
                    String str2 = miniLogFolderPath + "miniLog_" + ReportLogUtil.timeFormatter.format(Long.valueOf(System.currentTimeMillis())) + ".zip";
                    if (arrayList.size() > 0) {
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file2.createNewFile();
                        ReportLogUtil.zipFiles(arrayList, str2);
                        ReportLogUtil.uploadLogAndReport(str, str2);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(ReportLogUtil.TAG, 1, "compressAndUploadLog error " + th5);
                    }
                }
            }
        });
    }

    public static void uploadLog(String str, UploadLogListener uploadLogListener) {
        if (!new File(str).exists()) {
            QLog.d(TAG, 2, "file not exist. ");
            return;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mCommandId = 65;
        transferRequest.mUniseq = (long) (Math.random() * 1000000.0d);
        transferRequest.mPeerUin = "0";
        transferRequest.mSelfUin = String.valueOf(a.f().l());
        transferRequest.mFileType = 24;
        transferRequest.mRichTag = StatisticCollector.MINI_APP_USER_LOG_UPLOAD;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + ".zip"));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            MiniAppTransHandler miniAppTransHandler = new MiniAppTransHandler(ThreadManagerV2.getFileThreadLooper(), uploadLogListener);
            miniAppTransHandler.addFilter(BDHCommonUploadProcessor.class);
            ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(miniAppTransHandler);
            ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        }
    }

    public static void uploadLogAndReport(final String str, final String str2) {
        File file = new File(str2);
        if (!file.exists()) {
            QLog.e(TAG, 1, "log not exist.");
            return;
        }
        final long length = file.length();
        if (length <= 0) {
            QLog.e(TAG, 1, "log file size error: " + length);
            return;
        }
        uploadLog(str2, new UploadLogListener() { // from class: com.tencent.mobileqq.mini.utils.ReportLogUtil.1
            @Override // com.tencent.mobileqq.mini.utils.ReportLogUtil.UploadLogListener
            public void onFail(String str3) {
                if (QLog.isColorLevel()) {
                    QLog.d(ReportLogUtil.TAG, 2, "upload log fail: " + str2);
                }
                File file2 = new File(str2);
                if (file2.exists()) {
                    file2.delete();
                }
            }

            @Override // com.tencent.mobileqq.mini.utils.ReportLogUtil.UploadLogListener
            public void onSuccess(final String str3) {
                if (QLog.isColorLevel()) {
                    QLog.d(ReportLogUtil.TAG, 2, " upload log success: " + str2);
                }
                MiniAppCmdUtil.getInstance().reportLogFileUrl(null, str, str3, length, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.utils.ReportLogUtil.1.1
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z16, JSONObject jSONObject) {
                        QLog.d(ReportLogUtil.TAG, 1, "report upload log success: " + z16 + "  url:" + str3);
                    }
                });
                File file2 = new File(str2);
                if (file2.exists()) {
                    file2.delete();
                }
            }
        });
    }

    public static void zipFiles(ArrayList<MiniLogManager.LogFile> arrayList, String str) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str)));
            ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
            try {
                try {
                    Iterator<MiniLogManager.LogFile> it = arrayList.iterator();
                    boolean z16 = false;
                    while (it.hasNext()) {
                        MiniLogManager.LogFile next = it.next();
                        if (next.exists()) {
                            zipOutputStream.putNextEntry(new ZipEntry(next.getName() + next.stuffix));
                            zipOutputStream.setLevel(9);
                            long length = next.length();
                            FileInputStream fileInputStream = new FileInputStream(next);
                            int i3 = 20480;
                            try {
                                byte[] bArr = new byte[20480];
                                long j3 = 0;
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, i3);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                    j3 += read;
                                    if (j3 >= length) {
                                        z16 = true;
                                        break;
                                    } else {
                                        z16 = true;
                                        i3 = 20480;
                                    }
                                }
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                            } catch (Throwable th5) {
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                throw th5;
                            }
                        }
                    }
                    if (z16) {
                        zipOutputStream.close();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " zip stream close.");
                    }
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, " zip file error " + e16, e16);
                    }
                    bufferedOutputStream.close();
                    if (QLog.isColorLevel()) {
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "zip file finish");
                    }
                }
            } finally {
                bufferedOutputStream.close();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " file out stream close.");
                }
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }
}
