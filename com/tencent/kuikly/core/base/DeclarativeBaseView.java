package com.tencent.kuikly.core.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\bE\u0010FJ<\u0010\f\u001a6\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0006j\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b`\u000bH\u0002J\u000f\u0010\r\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJN\u0010\u0014\u001a\u00020\n\"\u0010\b\u0002\u0010\u000f*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000*\u00028\u00022'\u0010\u0014\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00020\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\bH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\n2\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\b\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J#\u0010!\u001a\u0004\u0018\u00018\u0002\"\b\b\u0002\u0010\u000f*\u00020 2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00028\u0002\"\b\b\u0002\u0010\u000f*\u00020 2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b#\u0010\"J\b\u0010$\u001a\u00020\nH\u0004J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0016J\"\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0010\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010,H\u0016J?\u00103\u001a\u00020\n2\u0006\u00100\u001a\u00020/2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\b\u0016H\u0016J\b\u00104\u001a\u00020\tH\u0016J\u001a\u00106\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u00105\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\n2\u0006\u0010)\u001a\u00020(H\u0016J\b\u00108\u001a\u00020\nH\u0016J\u0010\u00109\u001a\u00020\n2\u0006\u0010)\u001a\u00020(H\u0016R\"\u0010:\u001a\u00020\t8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010B\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010,8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u001e\u0010D\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/base/Attr;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/base/event/Event;", "E", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "", "", "Lkotlin/collections/HashMap;", "getAnimateCompletionMap", "internalCreateEvent", "()Lcom/tencent/kuikly/core/base/event/Event;", "T", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "ref", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/ExtensionFunctionType;", "init", "attr", "Lcom/tencent/kuikly/core/pager/b;", "getPager", "willMoveToParentComponent", "didMoveToParentView", "willRemoveFromParentView", "didRemoveFromParentView", "isPager", "Lcom/tencent/kuikly/core/module/Module;", "getModule", "(Ljava/lang/String;)Lcom/tencent/kuikly/core/module/Module;", "acquireModule", "createComponentRenderViewIfNeed", "createRenderView", "renderViewDidMoveToParentRenderView", "removeRenderView", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "Lcom/tencent/kuikly/core/layout/h;", "frameInParentRenderComponentCoordinate", "Lcom/tencent/kuikly/core/base/ViewContainer;", "toView", "convertFrame", "Lcom/tencent/kuikly/core/base/b;", "animation", "completion", "attrBlock", "animateToAttr", "isRenderView", "viewClassName", "createViewFromRegister", "layoutFrameDidChanged", "didSetFrameToRenderView", "setFrameToRenderView", "absoluteFlexNode", "Z", "getAbsoluteFlexNode$core_release", "()Z", "setAbsoluteFlexNode$core_release", "(Z)V", "getParent", "()Lcom/tencent/kuikly/core/base/ViewContainer;", HippyNestedScrollComponent.PRIORITY_PARENT, "getDomParent", "domParent", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class DeclarativeBaseView<A extends Attr, E extends Event> extends AbstractBaseView<A, E> {
    private boolean absoluteFlexNode;

    private final HashMap<String, Function1<Boolean, Unit>> getAnimateCompletionMap() {
        Object obj = getExtProps().get("animateCompletionMapKey");
        HashMap<String, Function1<Boolean, Unit>> hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap != null) {
            return hashMap;
        }
        HashMap<String, Function1<Boolean, Unit>> hashMap2 = new HashMap<>();
        getExtProps().put("animateCompletionMapKey", hashMap2);
        return hashMap2;
    }

    private final E internalCreateEvent() {
        E createEvent = createEvent();
        createEvent.init(getPagerId(), getNativeRef());
        return createEvent;
    }

    public <T extends Module> T acquireModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) com.tencent.kuikly.core.manager.c.f117352a.k(getPagerId()).acquireModule(name);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.q
    public void animateToAttr(final b animation, Function1<? super Boolean, Unit> completion, final Function1<? super Attr, Unit> attrBlock) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(attrBlock, "attrBlock");
        final String str = "animationAttrTask_" + animation.hashCode();
        if (completion != 0) {
            animation.j(str);
            final HashMap<String, Function1<Boolean, Unit>> animateCompletionMap = getAnimateCompletionMap();
            animateCompletionMap.put(str, completion);
            getViewEvent().listenInternalAnimationCompletion$core_release(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.kuikly.core.base.DeclarativeBaseView$animateToAttr$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationCompletionParams animationCompletionParams) {
                    invoke2(animationCompletionParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationCompletionParams params) {
                    Intrinsics.checkNotNullParameter(params, "params");
                    Function1<Boolean, Unit> function1 = animateCompletionMap.get(params.getAnimationKey());
                    if (function1 != null) {
                        function1.invoke(Boolean.valueOf(d.a(params.getFinish())));
                    }
                }
            });
        }
        final A viewAttr = getViewAttr();
        viewAttr.setPropByFrameTask(str, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.kuikly.core.base.DeclarativeBaseView$animateToAttr$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (TA;Ljava/lang/String;Lcom/tencent/kuikly/core/base/b;Lkotlin/jvm/functions/Function1<-Lcom/tencent/kuikly/core/base/Attr;Lkotlin/Unit;>;)V */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Attr.this.removePropFrameTask(str);
                Object prop = Attr.this.getProp("animation");
                String str2 = prop instanceof String ? (String) prop : null;
                if (str2 == null) {
                    str2 = "";
                }
                Attr.this.setProp("animation", animation.toString());
                Attr.this.setForceUpdate(true);
                attrBlock.invoke(Attr.this);
                Attr.this.setForceUpdate(false);
                FlexNode flexNode = Attr.this.getFlexNode();
                if (flexNode != null && flexNode.getIsDirty()) {
                    Attr.this.getPager().onLayoutView();
                }
                Attr.this.setProp("animation", str2);
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.q
    public void attr(final Function1<? super A, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        if (getPagerId().length() == 0) {
            return;
        }
        getAttr().setStaticAttr$core_release(!ReactiveObserver.INSTANCE.b(this, new Function1<Boolean, Unit>(this) { // from class: com.tencent.kuikly.core.base.DeclarativeBaseView$attr$observable$1
            final /* synthetic */ DeclarativeBaseView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Attr attr = this.this$0.getAttr();
                Function1<A, Unit> function1 = init;
                if (z16) {
                    function1.invoke(attr);
                    return;
                }
                attr.beginApplyAttrProperty();
                function1.invoke(attr);
                attr.endApplyAttrProperty();
            }
        }));
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public com.tencent.kuikly.core.layout.d convertFrame(com.tencent.kuikly.core.layout.d frame, ViewContainer<?, ?> toView) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if (toView == null) {
            Object pager = getPager();
            Intrinsics.checkNotNull(pager, "null cannot be cast to non-null type com.tencent.kuikly.core.base.ViewContainer<*, *>");
            toView = (ViewContainer) pager;
        }
        while (true) {
            boolean z16 = false;
            if (toView != null && VirtualViewKt.b(toView)) {
                z16 = true;
            }
            if (!z16) {
                break;
            }
            toView = toView.getParent();
        }
        ViewContainer<?, ?> domParent = getDomParent();
        com.tencent.kuikly.core.layout.h k3 = frame.k();
        com.tencent.kuikly.core.pager.b pager2 = getPager();
        while (!Intrinsics.areEqual(domParent, toView) && domParent != null) {
            k3.g(k3.getX() + domParent.getFrame().getX());
            k3.h(k3.getY() + domParent.getFrame().getY());
            if (domParent instanceof ScrollerView) {
                ScrollerView scrollerView = (ScrollerView) domParent;
                k3.g(k3.getX() - scrollerView.getContentViewOffsetX());
                k3.h(k3.getY() - scrollerView.getContentViewOffsetY());
            }
            domParent = domParent.getDomParent();
            if (domParent == pager2) {
                break;
            }
        }
        return k3.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void createComponentRenderViewIfNeed() {
        if (getRenderView() != null) {
            return;
        }
        setRenderView(new RenderView(getPagerId(), getNativeRef(), viewName()));
        getAttr().setPropsToRenderView();
        getEvent().onRenderViewDidCreated();
        FlexNode flexNode = getFlexNode();
        if (!flexNode.getLayoutFrame().f()) {
            setFrameToRenderView(flexNode.getLayoutFrame());
        }
        performRenderViewLazyTasks();
    }

    public void createRenderView() {
        createComponentRenderViewIfNeed();
    }

    public DeclarativeBaseView<?, ?> createViewFromRegister(String viewClassName) {
        Intrinsics.checkNotNullParameter(viewClassName, "viewClassName");
        com.tencent.kuikly.core.pager.b pager = getPager();
        Pager pager2 = pager instanceof Pager ? (Pager) pager : null;
        if (pager2 != null) {
            return pager2.createViewFromRegister(viewClassName);
        }
        return null;
    }

    public void didMoveToParentView() {
        getPager().putNativeViewRef(getNativeRef(), this);
    }

    public void didRemoveFromParentView() {
        getPager().removeNativeViewRef(getNativeRef());
        ReactiveObserver.INSTANCE.e(this);
        getAttr().viewDidRemove();
        getEvent().onViewDidRemove();
        getFlexNode().u0(null);
        setRenderView(null);
    }

    public com.tencent.kuikly.core.layout.h frameInParentRenderComponentCoordinate(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        ViewContainer<?, ?> parent = getParent();
        com.tencent.kuikly.core.layout.h hVar = new com.tencent.kuikly.core.layout.h(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
        while (true) {
            boolean z16 = false;
            if (parent != null && !parent.isRenderView()) {
                z16 = true;
            }
            if (!z16) {
                return hVar;
            }
            hVar.g(hVar.getX() + parent.getFlexNode().getLayoutFrame().getX());
            hVar.h(hVar.getY() + parent.getFlexNode().getLayoutFrame().getY());
            parent = parent.getParent();
        }
    }

    /* renamed from: getAbsoluteFlexNode$core_release, reason: from getter */
    public final boolean getAbsoluteFlexNode() {
        return this.absoluteFlexNode;
    }

    public ViewContainer<?, ?> getDomParent() {
        ViewContainer<?, ?> parent = getParent();
        while (true) {
            boolean z16 = false;
            if (parent != null && VirtualViewKt.b(parent)) {
                z16 = true;
            }
            if (!z16) {
                return parent;
            }
            parent = parent.getParent();
        }
    }

    public <T extends Module> T getModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) com.tencent.kuikly.core.manager.c.f117352a.k(getPagerId()).getModule(name);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public com.tencent.kuikly.core.pager.b getPager() {
        return com.tencent.kuikly.core.manager.c.f117352a.k(getPagerId());
    }

    public final ViewContainer<?, ?> getParent() {
        AbstractBaseView<?, ?> viewWithNativeRef = getPager().getViewWithNativeRef(getParentRef());
        if (viewWithNativeRef instanceof ViewContainer) {
            return (ViewContainer) viewWithNativeRef;
        }
        return null;
    }

    public boolean isPager() {
        return this instanceof com.tencent.kuikly.core.pager.b;
    }

    public boolean isRenderView() {
        return true;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        setFrameToRenderView(frame);
        getAttr().onViewLayoutFrameDidChanged(this);
        getEvent().onViewLayoutFrameDidChanged(this);
    }

    public <T extends DeclarativeBaseView<?, ?>> void ref(T t16, Function1<? super aa<T>, Unit> ref) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(ref, "ref");
        ref.invoke(new aa(t16.getPagerId(), t16.getNativeRef()));
        t16.getAttr().markToFlatLayerDisable();
    }

    public void removeRenderView() {
        RenderView renderView = getRenderView();
        if (renderView != null) {
            renderView.g();
        }
        setRenderView(null);
        getEvent().onRenderViewDidRemoved();
    }

    public final void setAbsoluteFlexNode$core_release(boolean z16) {
        this.absoluteFlexNode = z16;
    }

    public void setFrameToRenderView(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        RenderView renderView = getRenderView();
        if (renderView != null) {
            AnimationManager animationManager = getPager().getAnimationManager();
            b c16 = animationManager != null ? animationManager.c(getNativeRef()) : null;
            if (c16 != null) {
                getAttr().setProp("animation", c16.toString());
            }
            com.tencent.kuikly.core.layout.h frameInParentRenderComponentCoordinate = frameInParentRenderComponentCoordinate(frame);
            renderView.j(frameInParentRenderComponentCoordinate.getX(), frameInParentRenderComponentCoordinate.getY(), frameInParentRenderComponentCoordinate.getWidth(), frameInParentRenderComponentCoordinate.getHeight());
            didSetFrameToRenderView();
            getEvent().onRelativeCoordinatesDidChanged(this);
            if (c16 != null) {
                getAttr().setProp("animation", "");
            }
        }
    }

    public void willMoveToParentComponent() {
        if (getPagerId().length() == 0) {
            PagerNotFoundExceptionKt.a("pager id is empty");
        }
    }

    public void didSetFrameToRenderView() {
    }

    public void renderViewDidMoveToParentRenderView() {
    }

    public void willRemoveFromParentView() {
    }
}
