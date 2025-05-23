package com.tencent.mobileqq.zplan.utils;

import android.content.Context;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ba;", "", "Landroid/content/Context;", "ctx", "", "from", "", "a", "", "b", "Z", "mLoaded", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    public static final ba f335809a = new ba();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mLoaded;

    ba() {
    }

    public final void a(Context ctx, String from) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(from, "from");
        if (mLoaded) {
            QLog.i("ZPlanSoLoadHelper_", 1, "load from:" + from + ", already load.");
            return;
        }
        ZPlanAppInterface.Companion companion = ZPlanAppInterface.INSTANCE;
        Context applicationContext = ctx.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "ctx.applicationContext");
        companion.e(applicationContext);
        QLog.i("ZPlanSoLoadHelper_", 1, "before-load-ue4 from:" + from);
        ad adVar = ad.f335757a;
        if (adVar.g() && !adVar.h()) {
            adVar.e();
        }
        mLoaded = com.tencent.zplan.common.soloader.c.INSTANCE.b("UE4");
        EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine_zplan_process", "runtime_load_ue4_zplan", null, 4, null);
        QLog.i("ZPlanSoLoadHelper_", 1, "after-load-ue4 from:" + from + ", mLoaded:" + mLoaded);
    }
}
