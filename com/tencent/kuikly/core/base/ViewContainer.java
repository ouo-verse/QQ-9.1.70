package com.tencent.kuikly.core.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.views.ScrollerContentView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\bD\u0010EJ&\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00072\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0002J \u0010\r\u001a\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0002J\u0012\u0010\u000f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0000H\u0002JB\u0010\u0014\u001a\u00020\f\"\u0010\b\u0002\u0010\u0010*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u00022\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\u0002\b\u0012H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015JJ\u0010\u0016\u001a\u00020\f\"\u0010\b\u0002\u0010\u0010*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u00022\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\u0002\b\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0016JJ\u0010\u0014\u001a\u00020\f\"\u0010\b\u0002\u0010\u0010*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u00022\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\u0002\b\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0017J=\u0010\u001a\u001a\u00020\f\"\u0010\b\u0002\u0010\u0010*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0007H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\f2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016JF\u0010$\u001a\u00020\f2>\u0010#\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0 J1\u0010$\u001a\u00020\f2)\u0010#\u001a%\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u0011J\u0016\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0007J\u0006\u0010'\u001a\u00020\nJ\u0018\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010)\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J \u0010*\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010+\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\fH\u0016J\b\u0010/\u001a\u00020\fH\u0016J\u0010\u00102\u001a\u00020\f2\u0006\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u00020\fH\u0016J\u0014\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0007J\u000f\u00108\u001a\u000205H\u0000\u00a2\u0006\u0004\b6\u00107R:\u0010;\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000509j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005`:8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/m;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/base/event/Event;", "E", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "subView", "", "renderViews", "child", "", "index", "", "internalAddChild", "internalRemoveChild", "currentRenderView", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "addChild", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;)V", "addChildToDom", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;I)V", "realContainerView", "Lcom/tencent/kuikly/core/base/o;", "insertChild", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lcom/tencent/kuikly/core/base/o;I)V", "removeChild", "templateChildren", "removeChildren", "didInsertDomChild", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEachChild", "getChild", "getSubviews", "childrenSize", "getSubview", "insertSubRenderView", "insertDomSubView", "removeDomSubView", "createRenderView", "removeRenderView", "createFlexNode", "removeFlexNode", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "didRemoveFromParentView", "renderChildren", "", "isRenderViewForFlatLayer$core_release", "()Z", "isRenderViewForFlatLayer", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Node.CHILDREN_ATTR, "Ljava/util/ArrayList;", "getChildren", "()Ljava/util/ArrayList;", "lastFrame", "Lcom/tencent/kuikly/core/layout/d;", "didCreateFlexNode", "Z", "createRenderViewing", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class ViewContainer<A extends m, E extends Event> extends DeclarativeBaseView<A, E> {
    private boolean createRenderViewing;
    private boolean didCreateFlexNode;
    private final ArrayList<DeclarativeBaseView<?, ?>> children = new ArrayList<>();
    private com.tencent.kuikly.core.layout.d lastFrame = new com.tencent.kuikly.core.layout.d(0.0f, 0.0f, 0.0f, 0.0f);

    private final void internalAddChild(DeclarativeBaseView<?, ?> child, int index) {
        child.setPagerId(getPagerId());
        child.willMoveToParentComponent();
        if (index < 0) {
            this.children.add(child);
        } else {
            this.children.add(index, child);
        }
        child.setParentRef(getNativeRef());
        child.didMoveToParentView();
    }

    private final void internalRemoveChild(DeclarativeBaseView<?, ?> child) {
        child.willRemoveFromParentView();
        this.children.remove(child);
        child.didRemoveFromParentView();
        child.setParentRef(0);
    }

    private final List<DeclarativeBaseView<?, ?>> renderViews(DeclarativeBaseView<?, ?> subView) {
        ArrayList arrayList = new ArrayList();
        if (subView.isRenderView()) {
            arrayList.add(subView);
        } else if (subView instanceof ViewContainer) {
            arrayList.addAll(((ViewContainer) subView).renderChildren());
        }
        return arrayList;
    }

    public <T extends DeclarativeBaseView<?, ?>> void addChild(T child, Function1<? super T, Unit> init) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
        addChild(child, init, -1);
    }

    public <T extends DeclarativeBaseView<?, ?>> void addChildToDom(T child, Function1<? super T, Unit> init, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
        addChild(child, init, index);
        if (VirtualViewKt.a(this).indexOf(child) >= 0) {
            insertDomSubView(child, index);
            return;
        }
        PagerNotFoundExceptionKt.a("dom not found when addChild to dom with index:" + index + ", viewName:" + child.viewName());
    }

    public final int childrenSize() {
        return this.children.size();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void createFlexNode() {
        super.createFlexNode();
        if (!this.didCreateFlexNode) {
            this.didCreateFlexNode = true;
            int i3 = 0;
            for (DeclarativeBaseView<?, ?> declarativeBaseView : VirtualViewKt.a(this)) {
                declarativeBaseView.createFlexNode();
                getFlexNode().a(declarativeBaseView.getFlexNode(), i3);
                didInsertDomChild(declarativeBaseView, i3);
                i3++;
            }
            return;
        }
        throw new RuntimeException("error: duplicate createFlexNode");
    }

    public void didInsertDomChild(DeclarativeBaseView<?, ?> child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        removeChildren();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void forEachChild(Function2<? super Integer, ? super DeclarativeBaseView<?, ?>, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = 0;
        for (Object obj : templateChildren()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i3), obj);
            i3 = i16;
        }
    }

    public final DeclarativeBaseView<?, ?> getChild(int index) {
        DeclarativeBaseView<?, ?> declarativeBaseView = this.children.get(index);
        Intrinsics.checkNotNullExpressionValue(declarativeBaseView, "children[index]");
        return declarativeBaseView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<DeclarativeBaseView<?, ?>> getChildren() {
        return this.children;
    }

    public final DeclarativeBaseView<?, ?> getSubview(int index) {
        List<DeclarativeBaseView<?, ?>> subviews = getSubviews();
        if (index < subviews.size()) {
            return subviews.get(index);
        }
        return null;
    }

    public final List<DeclarativeBaseView<?, ?>> getSubviews() {
        return VirtualViewKt.a(this);
    }

    public final <T extends DeclarativeBaseView<?, ?>> void insertChild(T child, o<T> init, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
        internalAddChild(child, index);
        child.willInit();
        init.a(child);
        child.didInit();
    }

    public void insertDomSubView(DeclarativeBaseView<?, ?> subView, int index) {
        Intrinsics.checkNotNullParameter(subView, "subView");
        if (this.didCreateFlexNode) {
            insertSubRenderView(subView);
            subView.createFlexNode();
            getFlexNode().a(subView.getFlexNode(), index);
            didInsertDomChild(subView, index);
            getFlexNode().a0();
        }
    }

    public void insertSubRenderView(DeclarativeBaseView<?, ?> subView) {
        RenderView renderView;
        Intrinsics.checkNotNullParameter(subView, "subView");
        ViewContainer<?, ?> currentRenderView = currentRenderView();
        if (currentRenderView == null || currentRenderView.createRenderViewing || (renderView = currentRenderView.getRenderView()) == null) {
            return;
        }
        List<DeclarativeBaseView<?, ?>> renderViews = renderViews(subView);
        List<DeclarativeBaseView<?, ?>> renderChildren = currentRenderView.renderChildren();
        Iterator<T> it = renderViews.iterator();
        while (it.hasNext()) {
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
            int indexOf = renderChildren.indexOf(declarativeBaseView);
            if (indexOf >= 0) {
                declarativeBaseView.createRenderView();
                renderView.e(declarativeBaseView.getNativeRef(), indexOf);
                declarativeBaseView.renderViewDidMoveToParentRenderView();
            } else {
                throw new RuntimeException("renderChildren.indexOf(it) not found");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isRenderViewForFlatLayer$core_release() {
        if (getPager().isDebugUIInspector()) {
            return true;
        }
        ViewContainer<?, ?> parent = getParent();
        while (true) {
            if (!(parent != null && VirtualViewKt.b(parent))) {
                break;
            }
            parent = parent.getParent();
        }
        if ((parent instanceof ScrollerContentView) || ((m) getAttr()).getFlatLayerDisable()) {
            return true;
        }
        if (((m) getViewAttr()).isEmpty() && ((m) getViewAttr()).getIsStaticAttr() && getViewEvent().isEmpty()) {
            return false;
        }
        return super.isRenderView();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.layoutFrameDidChanged(frame);
        if (!isRenderView() && !this.lastFrame.f()) {
            Iterator<T> it = renderChildren().iterator();
            while (it.hasNext()) {
                DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
                declarativeBaseView.setFrameToRenderView(declarativeBaseView.getFlexNode().getLayoutFrame());
            }
        }
        this.lastFrame = frame;
    }

    public void removeChild(DeclarativeBaseView<?, ?> child) {
        Intrinsics.checkNotNullParameter(child, "child");
        internalRemoveChild(child);
    }

    public void removeChildren() {
        forEachChild(new Function1<DeclarativeBaseView<?, ?>, Unit>(this) { // from class: com.tencent.kuikly.core.base.ViewContainer$removeChildren$1
            final /* synthetic */ ViewContainer<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DeclarativeBaseView<?, ?> declarativeBaseView) {
                invoke2(declarativeBaseView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DeclarativeBaseView<?, ?> child) {
                Intrinsics.checkNotNullParameter(child, "child");
                this.this$0.removeChild(child);
            }
        });
    }

    public void removeDomSubView(DeclarativeBaseView<?, ?> subView) {
        Intrinsics.checkNotNullParameter(subView, "subView");
        if (this.didCreateFlexNode) {
            Iterator<T> it = renderViews(subView).iterator();
            while (it.hasNext()) {
                ((DeclarativeBaseView) it.next()).removeRenderView();
            }
            subView.removeFlexNode();
            getFlexNode().a0();
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void removeFlexNode() {
        super.removeFlexNode();
        this.didCreateFlexNode = false;
        Iterator<T> it = VirtualViewKt.a(this).iterator();
        while (it.hasNext()) {
            ((DeclarativeBaseView) it.next()).removeFlexNode();
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void removeRenderView() {
        super.removeRenderView();
        Iterator<T> it = renderChildren().iterator();
        while (it.hasNext()) {
            ((DeclarativeBaseView) it.next()).removeRenderView();
        }
    }

    public final List<DeclarativeBaseView<?, ?>> renderChildren() {
        final ArrayList arrayList = new ArrayList();
        forEachChild(new Function1<DeclarativeBaseView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.base.ViewContainer$renderChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DeclarativeBaseView<?, ?> declarativeBaseView) {
                invoke2(declarativeBaseView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DeclarativeBaseView<?, ?> child) {
                Intrinsics.checkNotNullParameter(child, "child");
                if (child.isRenderView()) {
                    arrayList.add(child);
                } else if (child instanceof ViewContainer) {
                    arrayList.addAll(((ViewContainer) child).renderChildren());
                }
            }
        });
        return arrayList;
    }

    public List<DeclarativeBaseView<?, ?>> templateChildren() {
        List<DeclarativeBaseView<?, ?>> list;
        list = CollectionsKt___CollectionsKt.toList(this.children);
        return list;
    }

    public <T extends DeclarativeBaseView<?, ?>> void addChild(T child, Function1<? super T, Unit> init, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
        internalAddChild(child, index);
        child.willInit();
        init.invoke(child);
        child.didInit();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        this.createRenderViewing = true;
        super.createRenderView();
        int i3 = 0;
        this.createRenderViewing = false;
        Iterator<T> it = renderChildren().iterator();
        while (it.hasNext()) {
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
            declarativeBaseView.createRenderView();
            RenderView renderView = getRenderView();
            if (renderView != null) {
                renderView.e(declarativeBaseView.getNativeRef(), i3);
                i3++;
            }
            declarativeBaseView.renderViewDidMoveToParentRenderView();
        }
    }

    public final void removeChild(int index) {
        DeclarativeBaseView<?, ?> declarativeBaseView = this.children.get(index);
        Intrinsics.checkNotNullExpressionValue(declarativeBaseView, "children[index]");
        internalRemoveChild(declarativeBaseView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void forEachChild(Function1<? super DeclarativeBaseView<?, ?>, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = templateChildren().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ViewContainer<?, ?> currentRenderView() {
        ViewContainer viewContainer = this;
        while (true) {
            boolean z16 = false;
            if (viewContainer != null && !viewContainer.isRenderView()) {
                z16 = true;
            }
            if (!z16) {
                return viewContainer;
            }
            viewContainer = viewContainer.getParent();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewContainer<?, ?> realContainerView() {
        return this;
    }
}
