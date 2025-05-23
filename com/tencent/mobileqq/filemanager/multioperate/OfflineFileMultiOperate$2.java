package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
class OfflineFileMultiOperate$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f208652d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c f208653e;
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        List list = this.f208652d;
        if (list != null && list.size() > 0) {
            QLog.d("OfflineFileMultiOperate", 1, "doFileMutiDelete: can not find any msg,but delete.");
            for (FileManagerEntity fileManagerEntity : this.f208652d) {
                fileManagerEntity.bDelInAio = true;
                if (QLog.isDevelopLevel()) {
                    QLog.d("OfflineFileMultiOperate", 1, "ChatHistory entity[" + fileManagerEntity.getId() + "] del File:" + fileManagerEntity.nSessionId);
                }
                b.a(null).getFileManagerEngine().i(fileManagerEntity.nSessionId);
            }
        }
        c cVar = this.f208653e;
        if (cVar != null) {
            cVar.a(3, 0);
        }
    }
}
