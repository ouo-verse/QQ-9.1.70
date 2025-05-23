package com.tencent.zplan.engine.service;

import com.epicgames.ue4.GameActivityThunk;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.utils.ZPlanConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/engine/service/c;", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "", "sucess", "", "onEngineInitFinish", "<init>", "()V", "f", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c implements GameActivityThunk.CMShowEngineInitFinishListener {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f385630d;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final List<GameActivityThunk.CMShowEngineInitFinishListener> f385631e = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/engine/service/c$a;", "", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "zplanInitListener", "", "a", "b", "", "TAG", "Ljava/lang/String;", "", "isInited", "Z", "", "zPlanEngineInitListenerList", "Ljava/util/List;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.engine.service.c$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final void a(@NotNull GameActivityThunk.CMShowEngineInitFinishListener zplanInitListener) {
            Intrinsics.checkNotNullParameter(zplanInitListener, "zplanInitListener");
            if (c.f385631e.contains(zplanInitListener)) {
                ZLog.f386189b.k("ZPlanEngineInitListener", "zplanInitListener has register, return. " + zplanInitListener);
                return;
            }
            c.f385631e.add(zplanInitListener);
            if (c.f385630d) {
                zplanInitListener.onEngineInitFinish(true);
            }
        }

        @JvmStatic
        public final void b(@NotNull GameActivityThunk.CMShowEngineInitFinishListener zplanInitListener) {
            Intrinsics.checkNotNullParameter(zplanInitListener, "zplanInitListener");
            c.f385631e.remove(zplanInitListener);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
    public void onEngineInitFinish(boolean sucess) {
        List list;
        ZLog.f386189b.k("ZPlanEngineInitListener", "onEngineInitFinish " + sucess);
        f385630d = sucess;
        list = CollectionsKt___CollectionsKt.toList(f385631e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((GameActivityThunk.CMShowEngineInitFinishListener) it.next()).onEngineInitFinish(sucess);
        }
        if (!sucess) {
            com.tencent.zplan.utils.e.f386205a.a("[zplan][error]", -1003, ZPlanConstant.a.INSTANCE.a().get(-1003));
        }
    }
}
