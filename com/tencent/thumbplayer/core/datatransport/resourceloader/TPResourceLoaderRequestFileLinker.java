package com.tencent.thumbplayer.core.datatransport.resourceloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes26.dex */
public class TPResourceLoaderRequestFileLinker {
    private static final String RESOURCE_LOADER_DIR_NAME = "resourceLoader";
    private static final String TAG = "TPResourceLoaderFileLinker";
    private DataWriteHandler mDataWriteHandler;
    private String mDataWritePath;
    private final ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();
    private long mPendingWriteOffset;
    private long mReadyDataTotalSize;
    private final RequestParams mRequestParams;
    private long mWrittenOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class DataWriteHandler extends Handler {
        private static final int MSG_RESPOND_WITH_DATA = 1280;
        private final WeakReference<TPResourceLoaderRequestFileLinker> mRequesterRef;

        DataWriteHandler(Looper looper, TPResourceLoaderRequestFileLinker tPResourceLoaderRequestFileLinker) {
            super(looper);
            this.mRequesterRef = new WeakReference<>(tPResourceLoaderRequestFileLinker);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TPResourceLoaderRequestFileLinker tPResourceLoaderRequestFileLinker = this.mRequesterRef.get();
            if (tPResourceLoaderRequestFileLinker != null && message.what == 1280) {
                tPResourceLoaderRequestFileLinker.handleResponseWithDataMsg(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class DataWriteParams {
        byte[] mData;
        long mWriteOffset;

        DataWriteParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class RequestParams {
        private final int mFileId;
        private final long mRequestLength;
        private final int mRequestNum;
        private final long mRequestStartOffset;
        private final String mUri;

        /* loaded from: classes26.dex */
        static class Builder {
            private int mFileId;
            private long mRequestLength;
            private int mRequestNum;
            private long mRequestStartOffset;
            private String mUri;

            public Builder(int i3, String str) {
                this.mRequestNum = i3;
                this.mUri = str;
            }

            public RequestParams build() {
                return new RequestParams(this);
            }

            public Builder setFileId(int i3) {
                this.mFileId = i3;
                return this;
            }

            public Builder setRequestLength(long j3) {
                this.mRequestLength = j3;
                return this;
            }

            public Builder setRequestStartOffset(long j3) {
                this.mRequestStartOffset = j3;
                return this;
            }
        }

        RequestParams(Builder builder) {
            this.mRequestNum = builder.mRequestNum;
            this.mFileId = builder.mFileId;
            this.mUri = builder.mUri;
            this.mRequestStartOffset = builder.mRequestStartOffset;
            this.mRequestLength = builder.mRequestLength;
        }
    }

    public TPResourceLoaderRequestFileLinker(@NonNull Context context, @NonNull RequestParams requestParams, @NonNull Looper looper) {
        this.mRequestParams = requestParams;
        this.mPendingWriteOffset = requestParams.mRequestStartOffset;
        this.mWrittenOffset = requestParams.mRequestStartOffset;
        this.mDataWritePath = getDataFilePath(context);
        this.mDataWriteHandler = new DataWriteHandler(looper, this);
    }

    private void dispatchEventMessage(int i3, int i16, int i17, Object obj) {
        DataWriteHandler dataWriteHandler = this.mDataWriteHandler;
        if (dataWriteHandler != null) {
            Message obtainMessage = dataWriteHandler.obtainMessage();
            obtainMessage.what = i3;
            obtainMessage.arg1 = i16;
            obtainMessage.arg2 = i17;
            obtainMessage.obj = obj;
            this.mDataWriteHandler.sendMessage(obtainMessage);
        }
    }

    static String getCacheFilePathAndCreateFile(@NonNull Context context, int i3) {
        String str = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date()) + " - " + i3 + ".mp4";
        File file = new File(context.getExternalCacheDir().getAbsoluteFile() + File.separator + RESOURCE_LOADER_DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (IOException unused) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "createNewFile, fail to create file: " + file2.getAbsolutePath());
        }
        return file2.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponseWithDataMsg(Message message) {
        DataWriteParams dataWriteParams = (DataWriteParams) message.obj;
        long j3 = dataWriteParams.mWriteOffset;
        byte[] bArr = dataWriteParams.mData;
        int i3 = message.arg1;
        if (!writeDataToPath(bArr, j3, this.mDataWritePath)) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "writeDataToPath, write data failed");
            return;
        }
        this.mLock.writeLock().lock();
        this.mWrittenOffset = i3 + j3;
        this.mLock.writeLock().unlock();
        TPDLProxyLog.d(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "write data from " + j3 + ", with dataLength: " + i3 + ", pos: " + this.mWrittenOffset);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        if (r4 == null) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean writeDataToPath(byte[] bArr, long j3, String str) {
        ?? r36 = 0;
        r36 = 0;
        r36 = 0;
        r36 = 0;
        r36 = 0;
        r36 = 0;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile2.seek(j3);
                    randomAccessFile2.write(bArr);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                        TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "writeDataToPath, fail to close randomAccessFile");
                    }
                    r36 = 1;
                } catch (FileNotFoundException unused2) {
                    randomAccessFile = randomAccessFile2;
                    TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "writeDataToPath, file not found: " + str);
                } catch (IOException e16) {
                    e = e16;
                    randomAccessFile = randomAccessFile2;
                    TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "writeDataToPath, fail to write data: " + e);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused3) {
                            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "writeDataToPath, fail to close randomAccessFile");
                        }
                    }
                    return r36;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                            TPDLProxyLog.e(TAG, r36, ITPDLProxyLogListener.COMMON_TAG, "writeDataToPath, fail to close randomAccessFile");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException e17) {
                e = e17;
            }
            return r36;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String getDataFilePath(@NonNull Context context) {
        if (TextUtils.isEmpty(this.mDataWritePath)) {
            this.mDataWritePath = getCacheFilePathAndCreateFile(context, this.mRequestParams.mFileId);
        }
        return this.mDataWritePath;
    }

    public int getDataReadyLength(long j3, long j16) {
        this.mLock.readLock().lock();
        long j17 = this.mWrittenOffset;
        this.mLock.readLock().unlock();
        if (j3 >= j17) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataReadyLength, No data for request, offset:" + j3 + ", length:" + j16 + ", writtenOffset:" + j17);
            return -1;
        }
        if (j3 < this.mRequestParams.mRequestStartOffset) {
            TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataReadyLength, Offset less than RequestedStartOffset, offset:" + j3 + ", RequestedStartOffset:" + this.mRequestParams.mRequestStartOffset);
            return -1;
        }
        return (int) Math.min(j17 - j3, j16);
    }

    public int getFileId() {
        return this.mRequestParams.mFileId;
    }

    public int getRequestNum() {
        return this.mRequestParams.mRequestNum;
    }

    public long getRequestedLength() {
        return this.mRequestParams.mRequestLength;
    }

    public long getRequestedOffset() {
        this.mLock.readLock().lock();
        long j3 = this.mPendingWriteOffset;
        this.mLock.readLock().unlock();
        return j3;
    }

    public int respond(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            if (this.mRequestParams.mRequestLength != -1 && this.mReadyDataTotalSize > this.mRequestParams.mRequestLength) {
                TPDLProxyLog.i(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "respond full data");
                return 0;
            }
            int length = bArr.length;
            DataWriteParams dataWriteParams = new DataWriteParams();
            dataWriteParams.mWriteOffset = this.mPendingWriteOffset;
            dataWriteParams.mData = bArr;
            dispatchEventMessage(1280, length, 0, dataWriteParams);
            TPDLProxyLog.d(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "respond data from:" + this.mPendingWriteOffset + ", dataLength:" + length);
            this.mLock.writeLock().lock();
            long j3 = (long) length;
            this.mPendingWriteOffset = this.mPendingWriteOffset + j3;
            this.mReadyDataTotalSize = this.mReadyDataTotalSize + j3;
            TPDLProxyLog.d(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "respond data, current offset:" + this.mPendingWriteOffset + ", dataLength:" + length);
            this.mLock.writeLock().unlock();
            return length;
        }
        TPDLProxyLog.d(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "respond empty data");
        return 0;
    }

    public void stop() {
        TPDLProxyLog.i(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "ResourceLoader RequestLinker stop, requestNum: " + this.mRequestParams.mRequestNum);
        DataWriteHandler dataWriteHandler = this.mDataWriteHandler;
        if (dataWriteHandler != null) {
            dataWriteHandler.removeCallbacksAndMessages(null);
            this.mDataWriteHandler = null;
        }
        if (!TextUtils.isEmpty(this.mDataWritePath)) {
            try {
                new File(this.mDataWritePath).deleteOnExit();
                this.mDataWritePath = "";
            } catch (Exception e16) {
                TPDLProxyLog.e(TAG, 0, ITPDLProxyLogListener.COMMON_TAG, "stop, delete cache file has exception:" + e16);
            }
        }
        this.mPendingWriteOffset = 0L;
        this.mWrittenOffset = 0L;
    }
}
