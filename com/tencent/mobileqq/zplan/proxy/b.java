package com.tencent.mobileqq.zplan.proxy;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/b;", "Lzx4/b;", "", "openFaceCamera", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b implements zx4.b {
    @Override // zx4.b
    public void openFaceCamera() {
        QLog.i("ZPlanCamera", 1, "open face camera");
        ((com.tencent.mobileqq.zplan.ipc.business.b) k74.i.INSTANCE.a(com.tencent.mobileqq.zplan.ipc.business.b.class)).openFaceCamera();
    }
}
