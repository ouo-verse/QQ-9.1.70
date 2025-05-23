package com.tencent.zplan.engine.service;

import android.content.Context;
import com.epicgames.ue4.UE4;
import com.tencent.zplan.common.utils.f;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\f\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/engine/service/e;", "", "Landroid/content/Context;", "context", "", "a", "", "Z", "b", "()Z", "setPurgeEngineHelperPurging$zplan_debug", "(Z)V", "isPurgeEngineHelperPurging", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isPurgeEngineHelperPurging;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final e f385642b = new e();

    e() {
    }

    public final void a(@Nullable Context context) {
        Boolean bool;
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanPurgeEngineHelper", "checkPurgeEngine, context: " + context);
        if (context == null) {
            zLog.k("ZPlanPurgeEngineHelper", "context is null, return.");
            return;
        }
        if (!f.f385292a.e(context, ":zplan")) {
            zLog.k("ZPlanPurgeEngineHelper", "not zplan process, return.");
            return;
        }
        zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
        if (dVar != null) {
            bool = Boolean.valueOf(dVar.b());
        } else {
            bool = null;
        }
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            zLog.k("ZPlanPurgeEngineHelper", "isPurgeEngineEnable false, return.");
            return;
        }
        if (ZPlanServiceHelper.I.R()) {
            zLog.k("ZPlanPurgeEngineHelper", "zplan is using, return.");
            return;
        }
        Context context2 = UE4.getContext();
        if (context2 != null) {
            context = context2;
        }
        if (UE4.isEnginePause) {
            UE4.resumeEngine(context);
        }
        zLog.k("ZPlanPurgeEngineHelper", "purgeEngine");
        long currentTimeMillis = System.currentTimeMillis();
        isPurgeEngineHelperPurging = true;
        UE4.purgeEngine();
        isPurgeEngineHelperPurging = false;
        zLog.k("ZPlanPurgeEngineHelper", "purgeEngine, const: " + (System.currentTimeMillis() - currentTimeMillis));
        UE4.pauseEngine(context);
    }

    public final boolean b() {
        return isPurgeEngineHelperPurging;
    }
}
