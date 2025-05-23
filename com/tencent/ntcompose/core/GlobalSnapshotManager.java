package com.tencent.ntcompose.core;

import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.b;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.ComposeAnimationManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c7\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0006\u0010\u000b\u001a\u00020\u0003J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J/\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0017J0\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0006R<\u0010'\u001a*\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"j\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010.\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/ntcompose/core/GlobalSnapshotManager;", "Lcom/tencent/kuikly/core/pager/c;", "Lcom/tencent/kuikly/core/manager/b;", "", "k", "d", "", tl.h.F, "c", "j", "i", "e", "", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "onPagerEvent", "", "methodId", "", "", "args", "onCallNative", "(I[Ljava/lang/Object;)V", "onCallKotlin", "tag", "", HippyTKDListViewAdapter.X, "y", "width", "height", "onSetRenderViewFrame", "needLayout", "f", "Ljava/util/HashMap;", "Lkotlin/Function0;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "needCommitApplyTasks", "pagerEventRegisterMap", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "globalWriteObserver", "g", "()Ljava/lang/String;", "currentPagerId", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GlobalSnapshotManager implements com.tencent.kuikly.core.pager.c, com.tencent.kuikly.core.manager.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ObserverHandle globalWriteObserver;

    /* renamed from: a, reason: collision with root package name */
    public static final GlobalSnapshotManager f339199a = new GlobalSnapshotManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Function0<Unit>> needCommitApplyTasks = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Boolean> pagerEventRegisterMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static final int f339203e = 8;

    GlobalSnapshotManager() {
    }

    private final void c() {
        Function0<Unit> function0 = needCommitApplyTasks.get(g());
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final String g() {
        return BridgeManager.f117344a.u();
    }

    private final boolean h() {
        return needCommitApplyTasks.containsKey(g());
    }

    private final void i() {
        String g16 = g();
        pagerEventRegisterMap.remove(g16);
        needCommitApplyTasks.remove(g16);
        ComposeAnimationManager.f339152a.e();
    }

    private final void j() {
        String g16 = g();
        HashMap<String, Boolean> hashMap = pagerEventRegisterMap;
        if (hashMap.containsKey(g16)) {
            return;
        }
        hashMap.put(g16, Boolean.TRUE);
        com.tencent.kuikly.core.manager.c.f117352a.g().addPagerEventObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        final String g16 = g();
        HashMap<String, Function0<Unit>> hashMap = needCommitApplyTasks;
        if (hashMap.containsKey(g16)) {
            return;
        }
        hashMap.put(g16, new Function0<Unit>() { // from class: com.tencent.ntcompose.core.GlobalSnapshotManager$setNeedCommitApply$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap hashMap2;
                hashMap2 = GlobalSnapshotManager.needCommitApplyTasks;
                hashMap2.remove(g16);
                Snapshot.INSTANCE.sendApplyNotifications();
                a.a(com.tencent.kuikly.core.manager.c.f117352a.k(g16));
            }
        });
    }

    public final void e() {
        if (globalWriteObserver == null) {
            globalWriteObserver = Snapshot.INSTANCE.registerGlobalWriteObserver(new Function1<Object, Unit>() { // from class: com.tencent.ntcompose.core.GlobalSnapshotManager$ensureInitialized$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GlobalSnapshotManager.f339199a.k();
                }
            });
            BridgeManager.f117344a.I(this);
        }
        j();
    }

    public final void f(boolean needLayout) {
        d();
        if (needLayout) {
            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
            cVar.g().onLayoutView();
            d();
            cVar.g().onLayoutView();
        }
    }

    @Override // com.tencent.kuikly.core.manager.b
    public void onCallKotlin(int methodId, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        f(methodId == 6);
    }

    @Override // com.tencent.kuikly.core.manager.b
    public void onCallNative(int methodId, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onPagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (Intrinsics.areEqual(pagerEvent, Pager.PAGER_EVENT_WILL_DESTROY)) {
            i();
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.manager.b
    public void onSetRenderViewFrame(int tag, float x16, float y16, float width, float height) {
        b.a.a(this, tag, x16, y16, width, height);
        ComposeAnimationManager.f339152a.k(tag, x16, y16, width, height);
    }

    private final void d() {
        int i3 = 3;
        while (h() && i3 - 1 >= 0) {
            c();
        }
        if (h()) {
            TimerKt.d(0, new Function0<Unit>() { // from class: com.tencent.ntcompose.core.GlobalSnapshotManager$commitApplyTaskIfNeed$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
