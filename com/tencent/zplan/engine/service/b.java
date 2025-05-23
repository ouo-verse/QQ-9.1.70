package com.tencent.zplan.engine.service;

import com.epicgames.ue4.GameActivityThunk;
import com.tencent.zplan.utils.ZLog;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/engine/service/b;", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineFirstFrameListener;", "", "onFirstFrame", "<init>", "()V", "b", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b implements GameActivityThunk.CMShowEngineFirstFrameListener {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static final List<GameActivityThunk.CMShowEngineFirstFrameListener> f385628a = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/engine/service/b$a;", "", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineFirstFrameListener;", "zplanListener", "", "a", "b", "", "TAG", "Ljava/lang/String;", "", "zPlanEngineFirstFrameListenerList", "Ljava/util/List;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.engine.service.b$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final void a(@NotNull GameActivityThunk.CMShowEngineFirstFrameListener zplanListener) {
            Intrinsics.checkNotNullParameter(zplanListener, "zplanListener");
            ZLog zLog = ZLog.f386189b;
            zLog.k("ZPlanEngineFirstFrameListener", "registerZPlanEngineFirstFrameListener start " + b.f385628a.size());
            b.f385628a.add(zplanListener);
            zLog.k("ZPlanEngineFirstFrameListener", "registerZPlanEngineFirstFrameListener end " + b.f385628a.size());
        }

        @JvmStatic
        public final void b(@NotNull GameActivityThunk.CMShowEngineFirstFrameListener zplanListener) {
            Intrinsics.checkNotNullParameter(zplanListener, "zplanListener");
            b.f385628a.remove(zplanListener);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineFirstFrameListener
    public void onFirstFrame() {
        List list;
        ZLog zLog = ZLog.f386189b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onFirstFrame ");
        List<GameActivityThunk.CMShowEngineFirstFrameListener> list2 = f385628a;
        sb5.append(list2.size());
        zLog.k("ZPlanEngineFirstFrameListener", sb5.toString());
        list = CollectionsKt___CollectionsKt.toList(list2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((GameActivityThunk.CMShowEngineFirstFrameListener) it.next()).onFirstFrame();
        }
    }
}
