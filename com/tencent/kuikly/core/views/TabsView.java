package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.pager.e;
import com.tencent.kuikly.core.views.bz;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b#\u0010\rJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u000f\u0010\f\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/kuikly/core/views/TabsView;", "Lcom/tencent/kuikly/core/views/aq;", "Lcom/tencent/kuikly/core/views/ca;", "Lcom/tencent/kuikly/core/views/cb;", "Lcom/tencent/kuikly/core/pager/e;", "", "i", DomainData.DOMAIN_NAME, "j", "k", "didMoveToParentView", "didRemoveFromParentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()V", "", "tolerance", "", "l", "willInit", "didInit", "onPagerWillCalculateLayoutFinish", "onPagerCalculateLayoutFinish", "onPagerDidLayout", "Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/views/v;", "a", "Lcom/tencent/kuikly/core/base/aa;", "indicatorViewRef", "Lcom/tencent/kuikly/core/layout/d;", "b", "Lcom/tencent/kuikly/core/layout/d;", "contentViewFrame", "c", "Z", "didInitContentOffset", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TabsView extends aq<ca, cb> implements com.tencent.kuikly.core.pager.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.aa<v> indicatorViewRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.layout.d contentViewFrame = com.tencent.kuikly.core.layout.d.INSTANCE.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean didInitContentOffset;

    private final void i() {
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        ((ca) getAttr()).flexDirectionRow();
        FlexNode flexNode = ((ca) getAttr()).getFlexNode();
        Intrinsics.checkNotNull(flexNode);
        float K = flexNode.K();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (Float.isNaN(K) || Float.isNaN(Float.NaN) ? !Float.isNaN(K) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - K) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            PagerNotFoundExceptionKt.a("Tabs need setup height , like attr { height(50f) }");
        }
        final Function1<ViewContainer<?, ?>, Unit> i3 = ((ca) getAttr()).i();
        if (i3 != null) {
            w.a(this, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.TabsView$didInit$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                    invoke2(vVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(v View) {
                    Intrinsics.checkNotNullParameter(View, "$this$View");
                    final TabsView tabsView = this;
                    View.ref(View, new Function1<com.tencent.kuikly.core.base.aa<v>, Unit>() { // from class: com.tencent.kuikly.core.views.TabsView$didInit$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.aa<v> aaVar) {
                            invoke2(aaVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.base.aa<v> it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            TabsView.this.indicatorViewRef = it;
                        }
                    });
                    View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.TabsView$didInit$1$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                            invoke2(tVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(t attr) {
                            Intrinsics.checkNotNullParameter(attr, "$this$attr");
                            Attr.absolutePosition$default(attr, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                            attr.m154zIndex(-1);
                            attr.m152visibility(false);
                        }
                    });
                    i3.invoke(View);
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        super.didMoveToParentView();
        getPager().addPagerLayoutEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerLayoutEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ca createAttr() {
        return new ca();
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public cb createEvent() {
        return new cb();
    }

    public final void m() {
        n();
    }

    @Override // com.tencent.kuikly.core.pager.e
    public void onPagerDidLayout() {
        FlexNode flexNode;
        ScrollerContentView contentView = getContentView();
        if (contentView == null || (flexNode = contentView.getFlexNode()) == null || flexNode.getLayoutFrame().equals(this.contentViewFrame)) {
            return;
        }
        this.contentViewFrame = flexNode.getLayoutFrame();
        i();
    }

    @Override // com.tencent.kuikly.core.pager.e
    public void onPagerDidScroll(Object obj) {
        e.a.a(this, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        ((ca) getAttr()).flexDirectionRow();
        ScrollerAttr.bouncesEnable$default((ScrollerAttr) getAttr(), false, false, 2, null);
        ((ca) getAttr()).showScrollerIndicator(false);
    }

    public final boolean l(float f16, float f17) {
        return Math.abs(f16 - ((float) Math.rint((double) f16))) <= f17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        ArrayList<DeclarativeBaseView> arrayList;
        float f16;
        float width;
        v b16;
        t tVar;
        v b17;
        RenderView renderView;
        bz.a state;
        v b18;
        t tVar2;
        v b19;
        t tVar3;
        List<DeclarativeBaseView<?, ?>> a16;
        if (this.contentViewFrame == com.tencent.kuikly.core.layout.d.INSTANCE.a()) {
            return;
        }
        ScrollerContentView contentView = getContentView();
        if (contentView != null && (a16 = VirtualViewKt.a(contentView)) != null) {
            arrayList = new ArrayList();
            for (Object obj : a16) {
                if (((DeclarativeBaseView) obj) instanceof bz) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = new ArrayList();
        }
        boolean z16 = false;
        if (arrayList.isEmpty()) {
            com.tencent.kuikly.core.base.aa<v> aaVar = this.indicatorViewRef;
            if (aaVar == null || (b19 = aaVar.b()) == null || (tVar3 = (t) b19.getViewAttr()) == null) {
                return;
            }
            tVar3.m152visibility(false);
            return;
        }
        com.tencent.kuikly.core.base.aa<v> aaVar2 = this.indicatorViewRef;
        if (aaVar2 != null && (b18 = aaVar2.b()) != null && (tVar2 = (t) b18.getViewAttr()) != null) {
            tVar2.m152visibility(true);
        }
        int min = Math.min(((ca) getAttr()).getInitIndex(), arrayList.size() - 1);
        float x16 = ((DeclarativeBaseView) arrayList.get(min)).getFlexNode().getLayoutFrame().getX();
        float width2 = ((DeclarativeBaseView) arrayList.get(min)).getFlexNode().getLayoutFrame().getWidth();
        float size = arrayList.size() - 1 <= 0 ? 0.0f : min / (arrayList.size() - 1);
        ScrollParams scrollParams = ((ca) getAttr()).getScrollParams();
        if (scrollParams != null) {
            min = Math.min((int) ((scrollParams.getOffsetX() / scrollParams.getViewWidth()) + 0.5f), arrayList.size() - 1);
            int min2 = Math.min((int) (scrollParams.getOffsetX() / scrollParams.getViewWidth()), arrayList.size() - 1);
            int min3 = Math.min(min2 + 1, arrayList.size() - 1);
            com.tencent.kuikly.core.layout.d layoutFrame = ((DeclarativeBaseView) arrayList.get(min2)).getFlexNode().getLayoutFrame();
            com.tencent.kuikly.core.layout.d layoutFrame2 = ((DeclarativeBaseView) arrayList.get(min3)).getFlexNode().getLayoutFrame();
            float offsetX = (scrollParams.getOffsetX() / scrollParams.getViewWidth()) - ((int) (scrollParams.getOffsetX() / scrollParams.getViewWidth()));
            f16 = layoutFrame.getX() + ((layoutFrame2.getX() - layoutFrame.getX()) * offsetX);
            width2 = ((layoutFrame2.getWidth() - layoutFrame.getWidth()) * offsetX) + layoutFrame.getWidth();
            size = scrollParams.getOffsetX() / (scrollParams.getContentWidth() - scrollParams.getViewWidth());
        } else {
            f16 = x16;
        }
        float f17 = width2;
        Object obj2 = arrayList.get(min);
        bz bzVar = obj2 instanceof bz ? (bz) obj2 : null;
        boolean z17 = false;
        for (DeclarativeBaseView declarativeBaseView : arrayList) {
            bz bzVar2 = declarativeBaseView instanceof bz ? (bz) declarativeBaseView : null;
            boolean z18 = bzVar2 == bzVar;
            if (!((bzVar2 == null || (state = bzVar2.getState()) == null || state.a() != z18) ? false : true)) {
                bz.a state2 = bzVar2 != null ? bzVar2.getState() : null;
                if (state2 != null) {
                    state2.b(z18);
                }
                z17 = true;
            }
        }
        if (((ca) getAttr()).getTabAlignCenter()) {
            width = f16 - ((getFlexNode().getLayoutFrame().getWidth() - f17) * 0.5f);
        } else {
            width = (this.contentViewFrame.getWidth() - getFlexNode().getLayoutFrame().getWidth()) * size;
        }
        float max = Math.max(Math.min(width, this.contentViewFrame.getWidth() - getFlexNode().getLayoutFrame().getWidth()), 0.0f);
        if (!(getCurOffsetX() == max)) {
            ScrollParams scrollParams2 = ((ca) getAttr()).getScrollParams();
            boolean z19 = this.didInitContentOffset && z17 && (scrollParams2 != null ? l(scrollParams2.getOffsetX() / scrollParams2.getViewWidth(), 0.05f) : false);
            ScrollerView.setContentOffset$default(this, max, 0.0f, z19, null, 8, null);
            z16 = z19;
        }
        com.tencent.kuikly.core.base.aa<v> aaVar3 = this.indicatorViewRef;
        if (aaVar3 != null && (b16 = aaVar3.b()) != null && (tVar = (t) b16.getViewAttr()) != null) {
            if (z16) {
                tVar.setProp("animation", b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null).toString());
            }
            FlexNode flexNode = tVar.getFlexNode();
            if (flexNode != null) {
                flexNode.Q0(Float.valueOf(f16));
            }
            tVar.m150top(0.0f);
            tVar.size(f17, this.contentViewFrame.getHeight());
            FlexNode flexNode2 = tVar.getFlexNode();
            if (flexNode2 != null) {
                FlexNode.X0(flexNode2, new com.tencent.kuikly.core.layout.d(0.0f, 0.0f, f17, this.contentViewFrame.getHeight()), false, false, 6, null);
            }
            com.tencent.kuikly.core.base.aa<v> aaVar4 = this.indicatorViewRef;
            if (aaVar4 != null && (b17 = aaVar4.b()) != null && (renderView = b17.getRenderView()) != null) {
                renderView.j(f16, 0.0f, f17, this.contentViewFrame.getHeight());
            }
            if (z16) {
                tVar.setProp("animation", "");
            }
        }
        this.didInitContentOffset = true;
    }

    @Override // com.tencent.kuikly.core.pager.e
    public void onPagerCalculateLayoutFinish() {
    }

    @Override // com.tencent.kuikly.core.pager.e
    public void onPagerWillCalculateLayoutFinish() {
    }
}
