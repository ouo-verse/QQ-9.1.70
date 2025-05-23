package com.tencent.zplan.world.manager;

import android.content.Context;
import com.tencent.zplan.common.utils.f;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.world.render.normal.MainProcessNormalRender;
import com.tencent.zplan.world.render.normal.ZPlanProcessNormalRender;
import com.tencent.zplan.world.render.parallel.MainProcessWorldRender;
import com.tencent.zplan.world.render.parallel.PeakProcessWorldRender;
import com.tencent.zplan.world.render.parallel.ZPlanProcessWorldRender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/world/manager/b;", "", "Landroid/content/Context;", "context", "", "gameInMainWorld", "inZPlanProcess", "inPeakProcess", "Ldy4/a;", "b", "a", "c", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f386323a = new b();

    b() {
    }

    private final dy4.a a(Context context, boolean inZPlanProcess, boolean inPeakProcess) {
        if (inZPlanProcess && !inPeakProcess) {
            return new ZPlanProcessNormalRender(context);
        }
        if (!inZPlanProcess && inPeakProcess) {
            return new com.tencent.zplan.world.render.normal.b(context);
        }
        return new MainProcessNormalRender(context);
    }

    private final dy4.a b(Context context, boolean gameInMainWorld, boolean inZPlanProcess, boolean inPeakProcess) {
        if (inZPlanProcess && !inPeakProcess) {
            return new ZPlanProcessWorldRender(context, gameInMainWorld);
        }
        if (!inZPlanProcess && inPeakProcess) {
            return new PeakProcessWorldRender(context, gameInMainWorld);
        }
        return new MainProcessWorldRender(context, gameInMainWorld);
    }

    public static /* synthetic */ dy4.a d(b bVar, Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return bVar.c(context, z16);
    }

    @NotNull
    public final dy4.a c(@NotNull Context context, boolean gameInMainWorld) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanRenderManager", "getZPlanRender context: " + context + ", gameInMainWorld: " + gameInMainWorld);
        d dVar = (d) mx4.a.f417748a.a(d.class);
        if (dVar != null) {
            z16 = dVar.o();
        } else {
            z16 = false;
        }
        zLog.k("ZPlanRenderManager", "getZPlanRender EnableParallelWorld : " + z16);
        f fVar = f.f385292a;
        boolean e16 = fVar.e(context, ":zplan");
        boolean e17 = fVar.e(context, ":peak");
        zLog.k("ZPlanRenderManager", "getZPlanRender inZPlanProcess : " + e16 + ", inPeakProcess : " + e17);
        if (z16) {
            return b(context, gameInMainWorld, e16, e17);
        }
        return a(context, e16, e17);
    }
}
