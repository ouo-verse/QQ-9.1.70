package com.tencent.mobileqq.zplan.proxy;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.model.ZPlanHitScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/o;", "Lzx4/i;", "", "begin", "Lcom/tencent/zplan/model/ZPlanHitScene;", "scene", "a", "end", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o implements zx4.i {

    /* renamed from: b, reason: collision with root package name */
    private static final com.tencent.mobileqq.hitrate.d f335010b = new com.tencent.mobileqq.hitrate.d("zplan", "com.tencent.mobileqq:zplan");

    @Override // zx4.i
    public void a(ZPlanHitScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        QLog.i("[zplan]_QQZPlanPreloadProcHitSession", 2, "hit " + scene);
        f335010b.d();
    }

    @Override // zx4.i
    public void begin() {
        QLog.i("[zplan]_QQZPlanPreloadProcHitSession", 2, "begin");
        f335010b.a();
        nb4.c.f419781a.a();
    }

    @Override // zx4.i
    public void end() {
        QLog.i("[zplan]_QQZPlanPreloadProcHitSession", 2, "end");
        f335010b.b();
    }
}
