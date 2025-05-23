package com.tencent.ntcompose.animation;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.ntcompose.core.GlobalSnapshotManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002JS\u0010\u0010\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00072\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\t0\b2\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0004J\\\u0010'\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030!2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00040\"H\u0000\u00a2\u0006\u0004\b'\u0010(R&\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030*j\u0002`+0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R9\u00104\u001a \u0012\u0004\u0012\u000200\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00105R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u00107\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010:\u00a8\u0006<"}, d2 = {"Lcom/tencent/ntcompose/animation/ComposeAnimationManager;", "", "Lcom/tencent/ntcompose/animation/d;", "animation", "", "c", "f", "T", "", "Lkotlin/Pair;", "composeAnimations", "target", "Lcom/tencent/ntcompose/animation/k;", "animationSpec", "Lkotlin/Function0;", "finishedListener", tl.h.F, "(Ljava/util/List;Ljava/lang/Object;Lcom/tencent/ntcompose/animation/k;Lkotlin/jvm/functions/Function0;)V", "j", "()V", "", "d", "()Z", "", "tag", "", HippyTKDListViewAdapter.X, "y", "width", "height", "k", "(IFFFF)V", "e", "Lcom/tencent/ntcompose/animation/a;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newTarget", "updateTargetValueTask", "l", "(Ljava/lang/Object;Lcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/ntcompose/core/BaseRenderView;", "b", "Ljava/util/Set;", "animationViews", "", "", "Lkotlin/Lazy;", "i", "()Ljava/util/Map;", "finishedListenMap", "Z", "triggerGetterValue", "<set-?>", "Lcom/tencent/ntcompose/animation/d;", "g", "()Lcom/tencent/ntcompose/animation/d;", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeAnimationManager {

    /* renamed from: a */
    public static final ComposeAnimationManager f339152a = new ComposeAnimationManager();

    /* renamed from: b, reason: from kotlin metadata */
    private static final Set<DeclarativeBaseView<?, ?>> animationViews = new LinkedHashSet();

    /* renamed from: c, reason: from kotlin metadata */
    private static final Lazy finishedListenMap;

    /* renamed from: d, reason: from kotlin metadata */
    private static boolean triggerGetterValue;

    /* renamed from: e, reason: from kotlin metadata */
    private static d animation;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Map<String, Map<String, Function0<? extends Unit>>>>() { // from class: com.tencent.ntcompose.animation.ComposeAnimationManager$finishedListenMap$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, Map<String, Function0<? extends Unit>>> invoke() {
                return new LinkedHashMap();
            }
        });
        finishedListenMap = lazy;
    }

    ComposeAnimationManager() {
    }

    public static final /* synthetic */ Set a() {
        return animationViews;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.LinkedHashMap, T] */
    private final void c(d animation2) {
        animation = animation2;
        final Function0<Unit> b16 = animation2.b();
        if (b16 != null) {
            String u16 = BridgeManager.f117344a.u();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ComposeAnimationManager composeAnimationManager = f339152a;
            ?? r46 = composeAnimationManager.i().get(u16);
            objectRef.element = r46;
            if (r46 == 0) {
                objectRef.element = new LinkedHashMap();
                composeAnimationManager.i().put(u16, objectRef.element);
            }
            final String animationKey = animation2.getAnimationKey();
            ((Map) objectRef.element).put(animationKey, new Function0<Unit>() { // from class: com.tencent.ntcompose.animation.ComposeAnimationManager$beginAnimation$1$1
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
                    objectRef.element.remove(animationKey);
                    b16.invoke();
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    private final void f() {
        d dVar = animation;
        boolean z16 = (dVar != null ? dVar.getLazyAnimationKey() : null) != null;
        animation = null;
        Iterator<T> it = animationViews.iterator();
        while (it.hasNext()) {
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
            declarativeBaseView.getViewAttr().setProp("animation", "");
            if (z16) {
                declarativeBaseView.getViewAttr().setProp("lazyAnimationKey", "");
            }
        }
        animationViews.clear();
    }

    private final <T> void h(List<Pair<T, d>> list, T t16, k<?> kVar, Function0<Unit> function0) {
        kVar.a();
        throw null;
    }

    public final Map<String, Map<String, Function0<Unit>>> i() {
        return (Map) finishedListenMap.getValue();
    }

    public final boolean d() {
        boolean z16 = triggerGetterValue;
        triggerGetterValue = false;
        return z16;
    }

    public final void e() {
        i().remove(BridgeManager.f117344a.u());
    }

    public final d g() {
        return animation;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.tencent.kuikly.core.base.event.Event] */
    public final void k(int tag, float r26, float y16, float width, float height) {
        AbstractBaseView<?, ?> viewWithNativeRef;
        String lazyAnimationKey;
        if (animation == null || (viewWithNativeRef = com.tencent.kuikly.core.manager.c.f117352a.g().getViewWithNativeRef(tag)) == null) {
            return;
        }
        RenderView renderView = viewWithNativeRef.getRenderView();
        if (renderView != null && renderView.getDidLayout()) {
            ComposeAnimationManager composeAnimationManager = f339152a;
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) viewWithNativeRef;
            if (composeAnimationManager.g() == null || declarativeBaseView.getFlexNode().getLayoutFrame().f()) {
                return;
            }
            RenderView renderView2 = declarativeBaseView.getRenderView();
            if (renderView2 != null && renderView2.getDidLayout()) {
                ?? viewAttr = declarativeBaseView.getViewAttr();
                d g16 = composeAnimationManager.g();
                if (g16 != null && g16.b() != null) {
                    declarativeBaseView.getViewEvent().animationCompletion(ComposeAnimationManager$animateIfNeed$1$1.INSTANCE);
                }
                d g17 = composeAnimationManager.g();
                if (g17 != null && (lazyAnimationKey = g17.getLazyAnimationKey()) != null) {
                    viewAttr.setProp("lazyAnimationKey", lazyAnimationKey);
                }
                viewAttr.setProp("animation", String.valueOf(composeAnimationManager.g()));
                animationViews.add(declarativeBaseView);
            }
        }
    }

    public final <T> void l(T target, a<?> animationSpec, Function0<Unit> finishedListener, Function1<? super T, Unit> updateTargetValueTask) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(updateTargetValueTask, "updateTargetValueTask");
        ArrayList<Pair> arrayList = new ArrayList();
        if (animationSpec instanceof k) {
            h(arrayList, target, (k) animationSpec, finishedListener);
        } else {
            arrayList.add(new Pair<>(target, new d(animationSpec, null, finishedListener)));
        }
        for (Pair pair : arrayList) {
            ComposeAnimationManager composeAnimationManager = f339152a;
            composeAnimationManager.c((d) pair.getSecond());
            updateTargetValueTask.invoke((Object) pair.getFirst());
            GlobalSnapshotManager.f339199a.f(true);
            composeAnimationManager.f();
        }
    }

    public final void j() {
        triggerGetterValue = true;
    }
}
