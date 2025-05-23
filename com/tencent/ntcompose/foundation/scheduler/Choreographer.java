package com.tencent.ntcompose.foundation.scheduler;

import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.h;
import com.tencent.ntcompose.foundation.scheduler.Choreographer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000f\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ntcompose/foundation/scheduler/Choreographer;", "", "", "c", "f", "Lcom/tencent/kuikly/core/pager/Pager;", "pager", "g", "(Lcom/tencent/kuikly/core/pager/Pager;)V", "Lcom/tencent/ntcompose/foundation/scheduler/Choreographer$b;", "callback", "d", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "screenFrameCallbackArray", "", "b", "Z", "didSetup", "Lcom/tencent/kuikly/core/pager/Pager;", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Choreographer {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f339321e = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<b> screenFrameCallbackArray;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean didSetup;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Pager pager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/foundation/scheduler/Choreographer$a;", "", "Lcom/tencent/ntcompose/foundation/scheduler/Choreographer;", "a", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.foundation.scheduler.Choreographer$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Choreographer a() {
            Choreographer a16 = a.a(h.a());
            if (a16 != null) {
                return a16;
            }
            Choreographer choreographer = new Choreographer(null);
            a.b(h.a(), choreographer);
            return choreographer;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/foundation/scheduler/Choreographer$b;", "", "", "frameTimeNanos", "", "doFrame", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void doFrame(long frameTimeNanos);
    }

    public /* synthetic */ Choreographer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        k kVar;
        Pager pager = this.pager;
        if (pager == null || (kVar = (k) pager.getViewAttr()) == null) {
            return;
        }
        kVar.screenFramePause(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f() {
        k kVar;
        Pager pager = this.pager;
        if (pager == null || (kVar = (k) pager.getViewAttr()) == null) {
            return;
        }
        kVar.screenFramePause(false);
    }

    public final void d(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.screenFrameCallbackArray.contains(callback)) {
            return;
        }
        this.screenFrameCallbackArray.add(callback);
        f();
    }

    public final void e(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.screenFrameCallbackArray.remove(callback);
        if (this.screenFrameCallbackArray.isEmpty()) {
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(Pager pager) {
        Intrinsics.checkNotNullParameter(pager, "pager");
        if (this.didSetup) {
            return;
        }
        this.didSetup = true;
        this.pager = pager;
        ((l) pager.getViewEvent()).screenFrame(new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.scheduler.Choreographer$setup$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ArrayList arrayList;
                List list;
                ArrayList arrayList2;
                ArrayList arrayList3;
                long a16 = zz0.a.f453719a.a();
                arrayList = Choreographer.this.screenFrameCallbackArray;
                list = CollectionsKt___CollectionsKt.toList(arrayList);
                arrayList2 = Choreographer.this.screenFrameCallbackArray;
                arrayList2.clear();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Choreographer.b) it.next()).doFrame(1000 * a16);
                }
                arrayList3 = Choreographer.this.screenFrameCallbackArray;
                if (arrayList3.isEmpty()) {
                    Choreographer.this.c();
                }
            }
        });
        c();
    }

    Choreographer() {
        this.screenFrameCallbackArray = new ArrayList<>();
    }
}
