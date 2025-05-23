package com.tencent.upload.request.impl;

import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileUploadReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileUploadRequest extends UploadRequest {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FileUploadRequest";
    public int dataType;
    public HashMap<String, String> extendInfo;
    protected String mAppid;
    protected CheckType mCheckType;
    protected long mDataLength;
    protected UploadDataSource mDataSource;
    public long mFileLength;
    protected boolean mNeedCheckSha1;
    public long mOffset;
    protected String mSession;
    protected byte[] mTempFileData;
    protected String mUin;

    public FileUploadRequest(UploadDataSource uploadDataSource, String str, String str2, String str3, long j3, long j16, CheckType checkType, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uploadDataSource, str, str2, str3, Long.valueOf(j3), Long.valueOf(j16), checkType, Boolean.valueOf(z16));
            return;
        }
        this.mFileLength = 0L;
        this.dataType = 0;
        this.mDataSource = uploadDataSource;
        this.mUin = str;
        this.mAppid = str2;
        this.mSession = str3;
        this.mOffset = j3;
        this.mDataLength = j16;
        this.mCheckType = checkType;
        this.mNeedCheckSha1 = z16;
        this.mFileLength = uploadDataSource.getDataLength();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    @Override // com.tencent.upload.request.UploadRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected JceStruct createJceRequest() throws IOException {
        byte[] bArr;
        long readData;
        long j3;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JceStruct) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FileUploadReq fileUploadReq = new FileUploadReq();
        fileUploadReq.uin = this.mUin;
        fileUploadReq.appid = this.mAppid;
        long j16 = this.mOffset;
        fileUploadReq.offset = j16;
        fileUploadReq.session = this.mSession;
        fileUploadReq.check_type = 1;
        fileUploadReq.data_type = this.dataType;
        HashMap<String, String> hashMap = this.extendInfo;
        if (hashMap != null) {
            fileUploadReq.extend_info = hashMap;
        }
        if (this.mNeedCheckSha1) {
            long j17 = this.mDataLength;
            byte[] bArr3 = new byte[(int) j17];
            this.mDataSource.readData(j16, (int) j17, bArr3, 0);
            this.mTempFileData = bArr3;
            fileUploadReq.check_type = this.mCheckType.value();
            fileUploadReq.checksum = FileUtils.getFileSha1(fileUploadReq.data);
        }
        try {
            try {
                j3 = this.mDataLength;
                bArr = new byte[(int) j3];
            } catch (OutOfMemoryError unused) {
                UploadLog.e(TAG, "encode request OOM. gc, then retry");
                System.gc();
                long j18 = this.mDataLength;
                bArr = new byte[(int) j18];
                byte[] bArr4 = this.mTempFileData;
                if (bArr4 != null && bArr4.length > 0) {
                    System.arraycopy(bArr4, 0, bArr, 0, (int) j18);
                    this.mTempFileData = null;
                } else {
                    readData = this.mDataSource.readData((int) this.mOffset, (int) j18, bArr, 0);
                }
            }
        } catch (Throwable th5) {
            th = th5;
            bArr = null;
        }
        try {
            bArr2 = this.mTempFileData;
        } catch (Throwable th6) {
            th = th6;
            UploadLog.e(TAG, "encode exception. reqId=" + getRequestId(), th);
            readData = 0;
            if (bArr == null) {
            }
            UploadLog.e(TAG, "encode data == null");
            return null;
        }
        if (bArr2 != null && bArr2.length > 0) {
            System.arraycopy(bArr2, 0, bArr, 0, (int) j3);
            this.mTempFileData = null;
            readData = 0;
            if (bArr == null) {
            }
            UploadLog.e(TAG, "encode data == null");
            return null;
        }
        readData = this.mDataSource.readData((int) this.mOffset, (int) j3, bArr, 0);
        if (bArr == null && readData != 0) {
            fileUploadReq.data = bArr;
            return fileUploadReq;
        }
        UploadLog.e(TAG, "encode data == null");
        return null;
    }

    @Override // com.tencent.upload.request.UploadRequest, com.tencent.upload.request.IActionRequest
    public int getCmdId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 2;
    }

    public long getRealDataSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mDataLength;
    }

    @Override // com.tencent.upload.request.UploadRequest, com.tencent.upload.request.IActionRequest
    public boolean needTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.upload.request.UploadRequest
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "taskId=" + getTaskId() + " reqId=" + getRequestId() + " cmd=" + getCmdId() + " offset=" + this.mOffset + " dataSize=" + this.mDataLength;
    }
}
