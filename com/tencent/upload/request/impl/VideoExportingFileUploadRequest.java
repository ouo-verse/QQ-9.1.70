package com.tencent.upload.request.impl;

import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileUploadReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.task.data.UploadDataSource;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoExportingFileUploadRequest extends FileUploadRequest {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoExportingFileUploadRequest";

    public VideoExportingFileUploadRequest(UploadDataSource uploadDataSource, String str, String str2, String str3, long j3, long j16, CheckType checkType, boolean z16) {
        super(uploadDataSource, str, str2, str3, j3, j16, checkType, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uploadDataSource, str, str2, str3, Long.valueOf(j3), Long.valueOf(j16), checkType, Boolean.valueOf(z16));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    @Override // com.tencent.upload.request.impl.FileUploadRequest, com.tencent.upload.request.UploadRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected JceStruct createJceRequest() throws IOException {
        long j3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JceStruct) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FileUploadReq fileUploadReq = new FileUploadReq();
        fileUploadReq.uin = this.mUin;
        fileUploadReq.appid = this.mAppid;
        fileUploadReq.offset = this.mOffset;
        fileUploadReq.session = this.mSession;
        fileUploadReq.check_type = this.mCheckType.value();
        fileUploadReq.data_type = this.dataType;
        long j16 = this.mDataLength;
        byte[] bArr2 = new byte[(int) j16];
        this.mDataSource.readData(this.mOffset, (int) j16, bArr2, 0);
        this.mTempFileData = bArr2;
        fileUploadReq.check_type = this.mCheckType.value();
        fileUploadReq.checksum = FileUtils.getMd5(bArr2);
        UploadLog.d(TAG, "checksum:" + fileUploadReq.checksum + " mDataLength:" + this.mDataLength);
        try {
            try {
                long j17 = this.mDataLength;
                bArr = new byte[(int) j17];
                try {
                    byte[] bArr3 = this.mTempFileData;
                    if (bArr3 != null && bArr3.length > 0) {
                        System.arraycopy(bArr3, 0, bArr, 0, (int) j17);
                        j3 = this.mDataLength;
                        try {
                            this.mTempFileData = null;
                        } catch (OutOfMemoryError unused) {
                            UploadLog.e(TAG, "encode request OOM. gc, then retry");
                            System.gc();
                            long j18 = this.mDataLength;
                            byte[] bArr4 = new byte[(int) j18];
                            byte[] bArr5 = this.mTempFileData;
                            if (bArr5 != null && bArr5.length > 0) {
                                System.arraycopy(bArr5, 0, bArr4, 0, (int) j18);
                                this.mTempFileData = null;
                            } else {
                                j3 = this.mDataSource.readData((int) this.mOffset, (int) j18, bArr4, 0);
                            }
                            bArr = bArr4;
                            if (bArr == null) {
                            }
                            UploadLog.e(TAG, "encode data == null");
                            return null;
                        } catch (Throwable th5) {
                            th = th5;
                            UploadLog.e(TAG, "encode exception. reqId=" + getRequestId(), th);
                            if (bArr == null) {
                            }
                            UploadLog.e(TAG, "encode data == null");
                            return null;
                        }
                    } else {
                        j3 = this.mDataSource.readData((int) this.mOffset, (int) j17, bArr, 0);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    j3 = 0;
                }
            } catch (OutOfMemoryError unused2) {
                j3 = 0;
            }
        } catch (Throwable th7) {
            th = th7;
            j3 = 0;
            bArr = null;
        }
        if (bArr == null && j3 != 0) {
            fileUploadReq.data = bArr;
            return fileUploadReq;
        }
        UploadLog.e(TAG, "encode data == null");
        return null;
    }
}
