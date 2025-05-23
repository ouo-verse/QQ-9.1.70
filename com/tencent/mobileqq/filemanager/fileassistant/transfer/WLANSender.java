package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;

/* compiled from: P */
/* loaded from: classes12.dex */
public class WLANSender implements ah.d {

    /* renamed from: a, reason: collision with root package name */
    FileManagerEntity f208038a;

    /* renamed from: b, reason: collision with root package name */
    QQAppInterface f208039b;

    /* renamed from: c, reason: collision with root package name */
    Session f208040c = null;

    /* renamed from: d, reason: collision with root package name */
    boolean f208041d = false;

    public boolean a(long j3) {
        Session session = this.f208040c;
        if (session == null || session.uSessionID != j3) {
            return false;
        }
        return true;
    }

    public void b() {
        ((DataLineHandler) this.f208039b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).h3(32);
    }

    public void c(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, boolean z16) {
        this.f208038a = fileManagerEntity;
        this.f208039b = qQAppInterface;
        this.f208041d = z16;
        FileManagerUtil.createMediaThumbnail(fileManagerEntity.getFilePath(), MsgConstant.KRMFILETHUMBSIZE384, MsgConstant.KRMFILETHUMBSIZE384, this);
    }

    public void d() {
        DataLineHandler dataLineHandler = (DataLineHandler) this.f208039b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        FileManagerEntity fileManagerEntity = this.f208038a;
        dataLineHandler.j3(fileManagerEntity.dlGroupId, fileManagerEntity.nSessionId, false);
    }

    @Override // com.tencent.mobileqq.filemanager.util.ah.d
    public void onResult(String str) {
        final DataLineHandler dataLineHandler = (DataLineHandler) this.f208039b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileassistant.transfer.WLANSender.1
            @Override // java.lang.Runnable
            public void run() {
                WLANSender wLANSender = WLANSender.this;
                wLANSender.f208040c = dataLineHandler.p4(wLANSender.f208038a, wLANSender.f208041d);
            }
        });
    }
}
