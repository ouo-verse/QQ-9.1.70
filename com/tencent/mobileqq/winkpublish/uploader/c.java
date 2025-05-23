package com.tencent.mobileqq.winkpublish.uploader;

import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c implements IUploadLog {
    @Override // com.tencent.upload.uinterface.IUploadLog
    public int d(String str, String str2) {
        QLog.i(str, 1, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int e(String str, String str2) {
        QLog.e(str, 1, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int i(String str, String str2) {
        QLog.i(str, 1, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int v(String str, String str2) {
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.d(str, 2, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int w(String str, String str2) {
        QLog.w(str, 1, str2);
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int d(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2 + th5.getMessage());
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2 + th5.getMessage());
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int i(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2 + th5.getMessage());
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int w(String str, Throwable th5) {
        QLog.w(str, 1, th5.getMessage());
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int v(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2 + th5.getMessage());
        return 0;
    }

    @Override // com.tencent.upload.uinterface.IUploadLog
    public int w(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2 + th5.getMessage());
        return 0;
    }
}
