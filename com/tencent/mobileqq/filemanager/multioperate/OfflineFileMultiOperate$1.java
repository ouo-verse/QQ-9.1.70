package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
class OfflineFileMultiOperate$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f208649d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ List f208650e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c f208651f;
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f208649d.size() == 1) {
            b.a(null).getMessageFacade().z0((MessageRecord) this.f208649d.get(0), false);
        } else if (this.f208649d.size() > 1) {
            b.a(null).getMessageFacade().B0(this.f208649d, false);
        }
        List list = this.f208650e;
        if (list != null && list.size() > 0) {
            for (FileManagerEntity fileManagerEntity : this.f208650e) {
                fileManagerEntity.bDelInAio = true;
                if (QLog.isDevelopLevel()) {
                    QLog.d("OfflineFileMultiOperate", 1, "ChatHistory entity[" + fileManagerEntity.getId() + "] del File:" + fileManagerEntity.nSessionId);
                }
                b.a(null).getFileManagerEngine().i(fileManagerEntity.nSessionId);
            }
        }
        c cVar = this.f208651f;
        if (cVar != null) {
            cVar.a(3, 0);
        }
    }
}
