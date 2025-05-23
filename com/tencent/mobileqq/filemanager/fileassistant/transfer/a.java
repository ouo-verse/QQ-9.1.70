package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f208043a;

    /* renamed from: b, reason: collision with root package name */
    FileManagerEntity f208044b;

    public a(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        this.f208043a = qQAppInterface;
        this.f208044b = fileManagerEntity;
    }

    public void a() {
        ((DataLineHandler) this.f208043a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).h3(32);
    }

    public void b() {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f208043a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        FileManagerEntity fileManagerEntity = this.f208044b;
        dataLineHandler.j3(fileManagerEntity.dlGroupId, fileManagerEntity.nSessionId, false);
        QLog.w("WLANRecver<FileAssistant>", 1, "userCancel:" + this.f208044b.nSessionId + ", grpId:" + this.f208044b.dlGroupId + ",");
    }
}
