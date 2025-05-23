package com.tencent.ntcompose.core;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.ntcompose.animation.ComposeAnimationManager;
import com.tencent.ntcompose.animation.ComposeAnimationManager$animateIfNeed$1$1;
import com.tencent.ntcompose.core.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018j\u0002`\u0019\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\t\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0000J\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u0002R#\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018j\u0002`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)RV\u00107\u001a6\u0012\u0002\b\u0003\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0002\u0018\u00010+j\b\u0012\u0002\b\u0003\u0018\u0001`0\u00a2\u0006\u0002\b18\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00109R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00109R*\u0010?\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#RR\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010%\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u0092\u0001\u0010E\u001a6\u0012\u0002\b\u0003\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0002\u0018\u00010+j\b\u0012\u0002\b\u0003\u0018\u0001`0\u00a2\u0006\u0002\b12:\u0010<\u001a6\u0012\u0002\b\u0003\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0002\u0018\u00010+j\b\u0012\u0002\b\u0003\u0018\u0001`0\u00a2\u0006\u0002\b18\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u00102\u001a\u0004\bC\u00104\"\u0004\bD\u00106\u00a8\u0006H"}, d2 = {"Lcom/tencent/ntcompose/core/ComposeRenderView;", "", "", "c", "Ljava/util/ArrayList;", "Lcom/tencent/ntcompose/core/k;", "Lkotlin/collections/ArrayList;", "previous", "next", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/ntcompose/core/i;", "o", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/core/i;)V", "", "index", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "d", "count", "g", "from", "to", "e", "f", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/ntcompose/core/BaseRenderView;", "a", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "b", "()Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "Lcom/tencent/ntcompose/core/i;", "getInitModifier", "()Lcom/tencent/ntcompose/core/i;", tl.h.F, "(Lcom/tencent/ntcompose/core/i;)V", "initModifier", "Ljava/util/ArrayList;", "getInitOtherProps", "()Ljava/util/ArrayList;", "i", "(Ljava/util/ArrayList;)V", "initOtherProps", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function2;", "getInitRef", "()Lkotlin/jvm/functions/Function2;", "j", "(Lkotlin/jvm/functions/Function2;)V", "initRef", "", "Z", "didInitView", "didInitRef", "value", "getModifier", "k", "modifier", "getOtherProps", "l", "otherProps", "getRef", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ref", "<init>", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeRenderView {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final DeclarativeBaseView<?, ?> view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private i initModifier;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ArrayList<k> initOtherProps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function2<?, ? super aa<?>, Unit> initRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean didInitView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean didInitRef;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private i modifier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<k> otherProps;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function2<?, ? super aa<?>, Unit> ref;

    public ComposeRenderView(DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.modifier = i.INSTANCE;
    }

    private final void n() {
        DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
        if (declarativeBaseView instanceof ViewContainer) {
            ViewContainer<?, ?> realContainerView = ((ViewContainer) declarativeBaseView).realContainerView();
            Iterator<T> it = VirtualViewKt.a(realContainerView).iterator();
            while (it.hasNext()) {
                realContainerView.removeDomSubView((DeclarativeBaseView) it.next());
            }
            realContainerView.removeChildren();
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.tencent.kuikly.core.base.event.Event] */
    private final void p(ArrayList<k> previous, ArrayList<k> next) {
        String lazyAnimationKey;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (previous != null) {
            for (k kVar : previous) {
                linkedHashMap.put(kVar.getPropKey(), kVar);
            }
        }
        if (next != null) {
            for (k kVar2 : next) {
                k kVar3 = (k) linkedHashMap.get(kVar2.getPropKey());
                if (kVar3 != null) {
                    linkedHashMap.remove(kVar2.getPropKey());
                }
                if (!Intrinsics.areEqual(kVar2, kVar3)) {
                    ComposeAnimationManager composeAnimationManager = ComposeAnimationManager.f339152a;
                    DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
                    if (composeAnimationManager.g() != null && !declarativeBaseView.getFlexNode().getLayoutFrame().f()) {
                        RenderView renderView = declarativeBaseView.getRenderView();
                        boolean z16 = false;
                        if (renderView != null && renderView.getDidLayout()) {
                            z16 = true;
                        }
                        if (z16) {
                            ?? viewAttr = declarativeBaseView.getViewAttr();
                            com.tencent.ntcompose.animation.d g16 = composeAnimationManager.g();
                            if (g16 != null && g16.b() != null) {
                                declarativeBaseView.getViewEvent().animationCompletion(ComposeAnimationManager$animateIfNeed$1$1.INSTANCE);
                            }
                            com.tencent.ntcompose.animation.d g17 = composeAnimationManager.g();
                            if (g17 != null && (lazyAnimationKey = g17.getLazyAnimationKey()) != null) {
                                viewAttr.setProp("lazyAnimationKey", lazyAnimationKey);
                            }
                            viewAttr.setProp("animation", String.valueOf(composeAnimationManager.g()));
                            ComposeAnimationManager.a().add(declarativeBaseView);
                        }
                    }
                    kVar2.i(this);
                }
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            ((k) ((Map.Entry) it.next()).getValue()).h(this);
        }
    }

    public final DeclarativeBaseView<?, ?> b() {
        return this.view;
    }

    public final void d(int index, final ComposeRenderView instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
        if (declarativeBaseView instanceof ViewContainer) {
            ((ViewContainer) declarativeBaseView).realContainerView().addChild(instance.view, new Function1<DeclarativeBaseView<?, ?>, Unit>() { // from class: com.tencent.ntcompose.core.ComposeRenderView$insert$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DeclarativeBaseView<?, ?> declarativeBaseView2) {
                    invoke2(declarativeBaseView2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DeclarativeBaseView<?, ?> addChild) {
                    Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                    ComposeRenderView.this.c();
                }
            }, index);
            ((ViewContainer) this.view).realContainerView().insertDomSubView(instance.view, index);
        }
    }

    public final void f() {
        n();
    }

    public final void h(i iVar) {
        this.initModifier = iVar;
    }

    public final void i(ArrayList<k> arrayList) {
        this.initOtherProps = arrayList;
    }

    public final void j(Function2<?, ? super aa<?>, Unit> function2) {
        this.initRef = function2;
    }

    public final void k(i value) {
        i iVar;
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.didInitView && value != (iVar = this.modifier)) {
            o(iVar, value);
            this.modifier = value;
        }
    }

    public final void l(ArrayList<k> arrayList) {
        ArrayList<k> arrayList2;
        if (this.didInitView && arrayList != (arrayList2 = this.otherProps)) {
            if (arrayList2 != null) {
                Intrinsics.checkNotNull(arrayList2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.ntcompose.core.PropModifier>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.ntcompose.core.PropModifier> }");
                if (c.a(arrayList2, arrayList)) {
                    this.otherProps = arrayList;
                    return;
                }
            }
            p(this.otherProps, arrayList);
            this.otherProps = arrayList;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.tencent.kuikly.core.base.Attr] */
    public final void m(Function2<?, ? super aa<?>, Unit> function2) {
        if (!this.didInitView || this.didInitRef) {
            return;
        }
        this.ref = function2;
        if (function2 != null) {
            this.didInitRef = true;
            this.initRef = null;
            this.ref = null;
            Function2 function22 = (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2);
            DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
            function22.invoke(declarativeBaseView, new aa(declarativeBaseView.getPagerId(), declarativeBaseView.getNativeRef()));
            declarativeBaseView.getViewAttr().markToFlatLayerDisable();
        }
    }

    public final void o(i previous, i next) {
        Intrinsics.checkNotNullParameter(previous, "previous");
        Intrinsics.checkNotNullParameter(next, "next");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Unit unit = Unit.INSTANCE;
        previous.a(unit, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.core.ComposeRenderView$updateModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar, Unit unit2) {
                invoke2(cVar, unit2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c mod, Unit unit2) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
                if (mod instanceof k) {
                    linkedHashMap.put(((k) mod).getPropKey(), mod);
                }
            }
        });
        next.a(unit, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.core.ComposeRenderView$updateModifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar, Unit unit2) {
                invoke2(cVar, unit2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
            /* JADX WARN: Type inference failed for: r3v7, types: [com.tencent.kuikly.core.base.event.Event] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c mod, Unit unit2) {
                String lazyAnimationKey;
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
                if (mod instanceof k) {
                    k kVar = (k) mod;
                    k kVar2 = linkedHashMap.get(kVar.getPropKey());
                    if (kVar2 != null) {
                        linkedHashMap.remove(kVar.getPropKey());
                    }
                    if (Intrinsics.areEqual(mod, kVar2)) {
                        return;
                    }
                    ComposeAnimationManager composeAnimationManager = ComposeAnimationManager.f339152a;
                    DeclarativeBaseView<?, ?> b16 = this.b();
                    ComposeRenderView composeRenderView = this;
                    if (composeAnimationManager.g() != null && !b16.getFlexNode().getLayoutFrame().f()) {
                        RenderView renderView = b16.getRenderView();
                        boolean z16 = false;
                        if (renderView != null && renderView.getDidLayout()) {
                            z16 = true;
                        }
                        if (z16) {
                            ?? viewAttr = b16.getViewAttr();
                            com.tencent.ntcompose.animation.d g16 = composeAnimationManager.g();
                            if (g16 != null && g16.b() != null) {
                                b16.getViewEvent().animationCompletion(ComposeAnimationManager$animateIfNeed$1$1.INSTANCE);
                            }
                            com.tencent.ntcompose.animation.d g17 = composeAnimationManager.g();
                            if (g17 != null && (lazyAnimationKey = g17.getLazyAnimationKey()) != null) {
                                viewAttr.setProp("lazyAnimationKey", lazyAnimationKey);
                            }
                            viewAttr.setProp("animation", String.valueOf(composeAnimationManager.g()));
                            ComposeAnimationManager.a().add(b16);
                        }
                    }
                    kVar.i(composeRenderView);
                }
            }
        });
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            ((k) ((Map.Entry) it.next()).getValue()).h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.didInitView = true;
        Function2<?, ? super aa<?>, Unit> function2 = this.initRef;
        if (function2 != null) {
            m(function2);
        }
        i iVar = this.initModifier;
        if (iVar != null) {
            k(iVar);
        }
        ArrayList<k> arrayList = this.initOtherProps;
        if (arrayList != null) {
            l(arrayList);
        }
    }

    public final void g(int index, int count) {
        DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
        if (declarativeBaseView instanceof ViewContainer) {
            ViewContainer<?, ?> realContainerView = ((ViewContainer) declarativeBaseView).realContainerView();
            for (int max = Math.max(count, 1); max > 0; max--) {
                DeclarativeBaseView<?, ?> child = realContainerView.getChild(index);
                realContainerView.removeDomSubView(child);
                realContainerView.removeChild(child);
            }
        }
    }

    public final void e(int from, int to5, int count) {
        if (from == to5) {
            return;
        }
        DeclarativeBaseView<?, ?> declarativeBaseView = this.view;
        if (declarativeBaseView instanceof ViewContainer) {
            ViewContainer<?, ?> realContainerView = ((ViewContainer) declarativeBaseView).realContainerView();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < count; i3++) {
                arrayList.add(realContainerView.getChild(from + i3));
            }
            g(from, count);
            if (to5 > from) {
                to5 -= count;
            }
            for (int i16 = 0; i16 < count; i16++) {
                d(to5 + i16, c.b((DeclarativeBaseView) arrayList.get(i16)));
            }
        }
    }
}
