package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForScribble extends ChatMessage {
    public static final String TAG = "MessageForScribbleMSg";
    public static final int TRANS_STAUS_DEFAULT = 0;
    public static final int TRANS_STAUS_DOWNLOADING = 3;
    public static final int TRANS_STAUS_DOWNLOAD_FAILED = 2;
    public static final int TRANS_STAUS_DOWNLOAD_SUC = 1;
    public static final int TRANS_STAUS_UP_FAILED = 2;
    public static final int TRANS_STAUS_UP_SENDING = 3;
    public static final int TRANS_STAUS_UP_SUC = 1;
    public aj mProgressPie;
    public int mRealProgress;
    public int mUiProgress;
    public Runnable mUpdateProgressRunnable;
    public String combineFileUrl = "";
    public String combineFileMd5 = "";
    public int gifId = 0;
    public int offSet = 0;
    public int fileUploadStatus = 0;
    public int fileDownloadStatus = 0;
    public String localFildPath = "";
    public FileExistInfo mExistInfo = new FileExistInfo();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class FileExistInfo {
        public boolean mLocalPathExist = false;
        public boolean mDataFileExist = false;
        public boolean mCombineFileExist = false;
        public boolean mInit = false;

        public FileExistInfo() {
        }
    }

    private void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.combineFileUrl = objectInput.readUTF();
        this.combineFileMd5 = objectInput.readUTF();
        this.gifId = objectInput.readInt();
        this.offSet = objectInput.readInt();
        this.fileUploadStatus = objectInput.readInt();
        this.fileDownloadStatus = objectInput.readInt();
        this.localFildPath = objectInput.readUTF();
    }

    private void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.combineFileUrl);
        objectOutput.writeUTF(this.combineFileMd5);
        objectOutput.writeInt(this.gifId);
        objectOutput.writeInt(this.offSet);
        objectOutput.writeInt(this.fileUploadStatus);
        objectOutput.writeInt(this.fileDownloadStatus);
        objectOutput.writeUTF(this.localFildPath);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        ObjectInputStream objectInputStream = null;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            try {
                if (this.msgData != null) {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                    try {
                        readExternal(objectInputStream2);
                        this.mExistInfo.mLocalPathExist = ((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(this.localFildPath);
                        this.mExistInfo.mDataFileExist = ((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(((IScribbleMsgUtils) QRoute.api(IScribbleMsgUtils.class)).getScribbleDataFilePath(this));
                        this.mExistInfo.mCombineFileExist = ((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(((IScribbleMsgUtils) QRoute.api(IScribbleMsgUtils.class)).getScribbleCombineFile(this));
                        this.mExistInfo.mInit = true;
                        objectInputStream = objectInputStream2;
                    } catch (Exception e17) {
                        e = e17;
                        objectInputStream = objectInputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "convert byte array to MessageForScribbleMsg failed", e);
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        QLog.d(TAG, 2, "dopare end:" + this.mExistInfo.mLocalPathExist + "-" + this.mExistInfo.mDataFileExist + "-" + this.mExistInfo.mCombineFileExist);
                    } catch (Throwable th5) {
                        th = th5;
                        objectInputStream = objectInputStream2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                this.f203106msg = getSummaryMsg();
            } catch (Exception e19) {
                e = e19;
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            QLog.d(TAG, 2, "dopare end:" + this.mExistInfo.mLocalPathExist + "-" + this.mExistInfo.mDataFileExist + "-" + this.mExistInfo.mCombineFileExist);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.f208785dn);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        ObjectOutputStream objectOutputStream;
        Throwable th5;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e17) {
                objectOutputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                objectOutputStream = null;
                th5 = th6;
                if (objectOutputStream != null) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e18) {
                    QLog.d(TAG, 2, "convert MessageForScribbleMsg to byte array failed", e18);
                }
                throw th5;
            }
            try {
                try {
                    writeExternal(objectOutputStream);
                    objectOutputStream.close();
                    this.msgData = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (Exception e19) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "convert MessageForScribbleMsg to byte array failed", e19);
                        }
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th7) {
                    th5 = th7;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e26) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "convert MessageForScribbleMsg to byte array failed", e26);
                            }
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th5;
                }
            } catch (Exception e27) {
                e16 = e27;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "convert MessageForScribbleMsg to byte array failed", e16);
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e28) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "convert MessageForScribbleMsg to byte array failed", e28);
                        }
                    }
                }
                byteArrayOutputStream.close();
            }
        } catch (Exception e29) {
            QLog.d(TAG, 2, "convert MessageForScribbleMsg to byte array failed", e29);
        }
    }
}
