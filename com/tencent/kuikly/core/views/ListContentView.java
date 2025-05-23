package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0018\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0015\u001a\u00020\u00022\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J \u0010#\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\u000f\u0010*\u001a\u00020'H\u0010\u00a2\u0006\u0004\b(\u0010)J\u0016\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040+H\u0004J\u001d\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040+H\u0000\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\u0006\u00101\u001a\u00020\u0006J\b\u00102\u001a\u00020\fH\u0004J\b\u00103\u001a\u00020\u0002H\u0016R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00105R\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/kuikly/core/views/ListContentView;", "Lcom/tencent/kuikly/core/views/ScrollerContentView;", "", "v", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", ReportConstant.COSTREPORT_PREFIX, "isRowFlexDirection", "Lkotlin/Pair;", "", BdhLogUtil.LogTag.Tag_Conn, "B", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "setFrameToRenderView", "child", "", "index", "didInsertDomChild", "Lcom/tencent/kuikly/core/views/ScrollerAttr;", "createAttr", "Lcom/tencent/kuikly/core/base/event/Event;", "createEvent", "createRenderView", "renderViewDidMoveToParentRenderView", "subView", "insertSubRenderView", "removeRenderView", "offsetX", "offsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", tl.h.F, DomainData.DOMAIN_NAME, "onPagerWillCalculateLayoutFinish", "didSetFrameToRenderView", "Lcom/tencent/kuikly/core/layout/FlexNode;", "internalCreateFlexNode$core_release", "()Lcom/tencent/kuikly/core/layout/FlexNode;", "internalCreateFlexNode", "", HippyTKDListViewAdapter.X, "w", "()Ljava/util/List;", "onPagerCalculateLayoutFinish", "onPagerDidLayout", "t", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "e", "Z", "didFirstLayout", "f", "waitingToNextTickLayout", "g", "didAddNextTickUpdateVisibleOffset", "didInitContentOffset", "i", "I", "firstContentLoadMaxIndex", "<init>", "()V", "j", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ListContentView extends ScrollerContentView {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean didFirstLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean waitingToNextTickLayout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean didAddNextTickUpdateVisibleOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean didInitContentOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int firstContentLoadMaxIndex;

    private final void B() {
        ViewContainer<?, ?> parent;
        if (getFlexNode().getLayoutFrame().f() || (parent = getParent()) == null) {
            return;
        }
        float height = getFlexNode().getLayoutFrame().getHeight() - parent.getFlexNode().getLayoutFrame().getHeight();
        float offsetY = getOffsetY();
        if (isRowFlexDirection()) {
            height = getFlexNode().getLayoutFrame().getWidth() - parent.getFlexNode().getLayoutFrame().getWidth();
            offsetY = getOffsetX();
        }
        if (height < 0.0f) {
            height = 0.0f;
        }
        if (offsetY < 0.0f || offsetY <= height) {
            return;
        }
        if (isRowFlexDirection()) {
            p(height);
        } else {
            q(height);
        }
        ScrollerView.setContentOffset$default((ScrollerView) parent, getOffsetX(), getOffsetY(), false, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Pair<Float, Float> C(boolean isRowFlexDirection) {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        float height;
        FlexNode flexNode2;
        com.tencent.kuikly.core.layout.d layoutFrame2;
        ao aoVar;
        float offsetY;
        float offsetY2;
        float y16;
        float f16 = 0.0f;
        if (com.tencent.kuikly.core.pager.h.b()) {
            com.tencent.kuikly.core.pager.g pageData = getPager().getPageData();
            if (isRowFlexDirection) {
                height = pageData.m();
            } else {
                height = pageData.l();
            }
        } else {
            ViewContainer<?, ?> parent = getParent();
            if (isRowFlexDirection) {
                if (parent != null && (flexNode2 = parent.getFlexNode()) != null && (layoutFrame2 = flexNode2.getLayoutFrame()) != null) {
                    height = layoutFrame2.getWidth();
                }
                height = 0.0f;
            } else {
                if (parent != null && (flexNode = parent.getFlexNode()) != null && (layoutFrame = flexNode.getLayoutFrame()) != null) {
                    height = layoutFrame.getHeight();
                }
                height = 0.0f;
            }
        }
        com.tencent.kuikly.core.pager.b pager = getPager();
        if (!(pager instanceof com.tencent.kuikly.core.pager.b)) {
            pager = null;
        }
        if ((pager == null || pager.getInnerDidCreateBody()) ? false : true) {
            s();
        } else {
            ViewContainer<?, ?> parent2 = getParent();
            aq aqVar = parent2 instanceof aq ? (aq) parent2 : null;
            float preloadViewDistance = (aqVar == null || (aoVar = (ao) aqVar.getViewAttr()) == null) ? 0.0f : aoVar.getPreloadViewDistance();
            f16 = !(preloadViewDistance == 0.0f) ? preloadViewDistance : 0.85f * height;
        }
        if (isRowFlexDirection) {
            if (com.tencent.kuikly.core.pager.h.b()) {
                offsetY2 = getOffsetX();
                ViewContainer<?, ?> parent3 = getParent();
                Intrinsics.checkNotNull(parent3);
                ViewContainer<?, ?> parent4 = getParent();
                Intrinsics.checkNotNull(parent4);
                y16 = parent3.convertFrame(parent4.getFlexNode().getLayoutFrame(), null).getX();
                offsetY = offsetY2 - y16;
            } else {
                offsetY = getOffsetX();
            }
        } else if (com.tencent.kuikly.core.pager.h.b()) {
            offsetY2 = getOffsetY();
            ViewContainer<?, ?> parent5 = getParent();
            Intrinsics.checkNotNull(parent5);
            ViewContainer<?, ?> parent6 = getParent();
            Intrinsics.checkNotNull(parent6);
            y16 = parent5.convertFrame(parent6.getFlexNode().getLayoutFrame(), null).getY();
            offsetY = offsetY2 - y16;
        } else {
            offsetY = getOffsetY();
        }
        return new Pair<>(Float.valueOf(offsetY - f16), Float.valueOf(offsetY + height + f16));
    }

    private final void s() {
        if (this.didAddNextTickUpdateVisibleOffset) {
            return;
        }
        this.didAddNextTickUpdateVisibleOffset = true;
        getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ListContentView$addNextTickUpdateVisibleOffsetIfNeed$1
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
                ListContentView.this.t();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        if (this.didInitContentOffset) {
            return;
        }
        this.didInitContentOffset = true;
        ViewContainer<?, ?> parent = getParent();
        aq aqVar = parent instanceof aq ? (aq) parent : null;
        if (aqVar == null || ((ao) aqVar.getViewAttr()).getInitContentOffset() <= 0.0f) {
            return;
        }
        if (isRowFlexDirection()) {
            ScrollerView.setContentOffset$default(aqVar, ((ao) aqVar.getViewAttr()).getInitContentOffset(), 0.0f, false, null, 12, null);
        } else {
            ScrollerView.setContentOffset$default(aqVar, 0.0f, ((ao) aqVar.getViewAttr()).getInitContentOffset(), false, null, 12, null);
        }
    }

    private final boolean y(DeclarativeBaseView<?, ?> view) {
        return view.getRenderView() == null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.kuikly.core.base.Attr] */
    private final boolean z(DeclarativeBaseView<?, ?> view) {
        return (view.getRenderView() == null || view.getViewAttr().getKeepAlive()) ? false : true;
    }

    public void A() {
        if (this.didFirstLayout) {
            getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ListContentView$updateChildLayout$1
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
                    Iterator<T> it = ListContentView.this.x().iterator();
                    while (it.hasNext()) {
                        ((DeclarativeBaseView) it.next()).getFlexNode().a0();
                    }
                    ListContentView.this.t();
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        createComponentRenderViewIfNeed();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.kuikly.core.base.Attr] */
    @Override // com.tencent.kuikly.core.base.ViewContainer
    public void didInsertDomChild(DeclarativeBaseView<?, ?> child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.didInsertDomChild(child, index);
        child.getViewAttr().setProp("scrollIndex", Integer.valueOf(index));
        FlexNode flexNode = getFlexNode();
        if (child.getFlexNode().G() == FlexPositionType.ABSOLUTE) {
            child.setAbsoluteFlexNode$core_release(true);
            return;
        }
        ?? viewAttr = child.getViewAttr();
        if (isRowFlexDirection()) {
            viewAttr.positionAbsolute();
            viewAttr.m150top(Math.max(flexNode.E(StyleSpace.Type.TOP), 0.0f));
            viewAttr.m142left(0.0f);
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            viewAttr.m149right(Float.NaN);
            viewAttr.m138bottom(Math.max(flexNode.E(StyleSpace.Type.BOTTOM), 0.0f));
            return;
        }
        viewAttr.positionAbsolute();
        viewAttr.m150top(0.0f);
        viewAttr.m142left(Math.max(flexNode.E(StyleSpace.Type.LEFT), 0.0f));
        viewAttr.m149right(Math.max(flexNode.E(StyleSpace.Type.RIGHT), 0.0f));
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        viewAttr.m138bottom(Float.NaN);
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didSetFrameToRenderView() {
        super.didSetFrameToRenderView();
        v();
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView
    public void h(float offsetX, float offsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        super.h(offsetX, offsetY, params);
        t();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public void insertSubRenderView(DeclarativeBaseView<?, ?> subView) {
        Intrinsics.checkNotNullParameter(subView, "subView");
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public FlexNode internalCreateFlexNode$core_release() {
        FlexNode internalCreateFlexNode$core_release = super.internalCreateFlexNode$core_release();
        internalCreateFlexNode$core_release.J0(true);
        return internalCreateFlexNode$core_release;
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView
    public void n() {
        super.n();
        t();
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.pager.e
    public void onPagerCalculateLayoutFinish() {
        float max;
        float f16;
        float max2;
        if (isRowFlexDirection()) {
            max = Math.max(getFlexNode().E(StyleSpace.Type.LEFT), 0.0f);
            float max3 = Math.max(getFlexNode().E(StyleSpace.Type.TOP), 0.0f);
            Iterator<T> it = x().iterator();
            f16 = 0.0f;
            while (it.hasNext()) {
                DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) it.next();
                if (declarativeBaseView.getAbsoluteFlexNode()) {
                    f16 = Math.max(declarativeBaseView.getFlexNode().getLayoutFrame().g(), f16);
                } else {
                    com.tencent.kuikly.core.layout.h k3 = declarativeBaseView.getFlexNode().getLayoutFrame().k();
                    k3.g(max + declarativeBaseView.getFlexNode().z(StyleSpace.Type.LEFT));
                    k3.h(declarativeBaseView.getFlexNode().z(StyleSpace.Type.TOP) + max3);
                    max = k3.getX() + k3.getWidth() + declarativeBaseView.getFlexNode().z(StyleSpace.Type.RIGHT);
                    FlexNode.X0(declarativeBaseView.getFlexNode(), k3.i(), false, false, 6, null);
                }
            }
            max2 = Math.max(getFlexNode().E(StyleSpace.Type.RIGHT), 0.0f);
        } else {
            max = Math.max(getFlexNode().E(StyleSpace.Type.TOP), 0.0f);
            float max4 = Math.max(getFlexNode().E(StyleSpace.Type.LEFT), 0.0f);
            Iterator<T> it5 = x().iterator();
            f16 = 0.0f;
            while (it5.hasNext()) {
                DeclarativeBaseView declarativeBaseView2 = (DeclarativeBaseView) it5.next();
                if (declarativeBaseView2.getAbsoluteFlexNode()) {
                    f16 = Math.max(declarativeBaseView2.getFlexNode().getLayoutFrame().h(), f16);
                } else {
                    com.tencent.kuikly.core.layout.h k16 = declarativeBaseView2.getFlexNode().getLayoutFrame().k();
                    k16.h(max + declarativeBaseView2.getFlexNode().z(StyleSpace.Type.TOP));
                    k16.g(declarativeBaseView2.getFlexNode().z(StyleSpace.Type.LEFT) + max4);
                    max = k16.getY() + k16.getHeight() + declarativeBaseView2.getFlexNode().z(StyleSpace.Type.BOTTOM);
                    FlexNode.X0(declarativeBaseView2.getFlexNode(), k16.i(), false, false, 6, null);
                }
            }
            max2 = Math.max(getFlexNode().E(StyleSpace.Type.BOTTOM), 0.0f);
        }
        float max5 = Math.max(Math.max(max + max2, f16), u());
        com.tencent.kuikly.core.layout.h k17 = getFlexNode().getLayoutFrame().k();
        if (isRowFlexDirection()) {
            k17.f(max5);
        } else {
            k17.e(max5);
        }
        FlexNode.X0(getFlexNode(), k17.i(), false, false, 6, null);
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.pager.e
    public void onPagerDidLayout() {
        if (getNeedLayout()) {
            boolean t16 = t();
            if (getParent() != null && (getParent() instanceof aq)) {
                ViewContainer<?, ?> parent = getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ListView<*, *>");
                ((aq) parent).subViewsDidLayout$core_release();
            }
            if (!t16 || this.waitingToNextTickLayout) {
                return;
            }
            o(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0194  */
    @Override // com.tencent.kuikly.core.views.ScrollerContentView, com.tencent.kuikly.core.pager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPagerWillCalculateLayoutFinish() {
        FlexNode flexNode;
        ViewContainer<?, ?> parent = getParent();
        Boolean valueOf = (parent == null || (flexNode = parent.getFlexNode()) == null) ? null : Boolean.valueOf(flexNode.getIsDirty());
        if (!getNeedLayout() && Intrinsics.areEqual(valueOf, Boolean.FALSE) && !getFlexNode().getIsDirty()) {
            getFlexNode().g0();
            return;
        }
        int i3 = 0;
        boolean z16 = Intrinsics.areEqual(valueOf, Boolean.TRUE) && !getFlexNode().getIsDirty();
        ArrayList<FlexNode> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(this);
        int i16 = 0;
        for (Object obj : a16) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) obj;
            if (z16 || declarativeBaseView.getFlexNode().getIsDirty()) {
                if (declarativeBaseView.getAbsoluteFlexNode()) {
                    arrayList2.add(declarativeBaseView.getFlexNode());
                } else {
                    arrayList.add(declarativeBaseView.getFlexNode());
                }
            }
            i16 = i17;
        }
        getFlexNode().g0();
        ViewContainer<?, ?> parent2 = getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ListView<*, *>");
        this.firstContentLoadMaxIndex = Math.max(((ao) ((aq) parent2).getViewAttr()).getFirstContentLoadMaxIndex(), this.firstContentLoadMaxIndex);
        if (!this.didFirstLayout) {
            int size = arrayList.size();
            int i18 = this.firstContentLoadMaxIndex;
            if (size > i18) {
                this.didFirstLayout = true;
                List subList = arrayList.subList(0, i18);
                Intrinsics.checkNotNullExpressionValue(subList, "dirtyChildren.subList(0, firstContentLoadMaxIndex)");
                int i19 = 0;
                for (Object obj2 : subList) {
                    int i26 = i19 + 1;
                    if (i19 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    FlexNode subFlexNode = (FlexNode) obj2;
                    FlexNode flexNode2 = getFlexNode();
                    Intrinsics.checkNotNullExpressionValue(subFlexNode, "subFlexNode");
                    flexNode2.f0(subFlexNode);
                    i19 = i26;
                }
                this.waitingToNextTickLayout = true;
                getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ListContentView$onPagerWillCalculateLayoutFinish$3
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
                        ListContentView.this.waitingToNextTickLayout = false;
                        ListContentView.this.getFlexNode().a0();
                    }
                });
                for (Object obj3 : arrayList2) {
                    int i27 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    getFlexNode().f0((FlexNode) obj3);
                    i3 = i27;
                }
            }
        }
        if (this.waitingToNextTickLayout) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                arrayList3.add(((DeclarativeBaseView) it.next()).getFlexNode());
            }
            for (FlexNode flexNode3 : arrayList) {
                int indexOf = arrayList3.indexOf(flexNode3);
                if ((indexOf >= 0 && indexOf < this.firstContentLoadMaxIndex) || !flexNode3.getLayoutFrame().f()) {
                    getFlexNode().f0(flexNode3);
                }
            }
        } else {
            if (!arrayList.isEmpty()) {
                this.didFirstLayout = true;
            }
            int i28 = 0;
            for (Object obj4 : arrayList) {
                int i29 = i28 + 1;
                if (i28 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                getFlexNode().f0((FlexNode) obj4);
                i28 = i29;
            }
        }
        while (r0.hasNext()) {
        }
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void removeRenderView() {
        super.removeRenderView();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void renderViewDidMoveToParentRenderView() {
        super.renderViewDidMoveToParentRenderView();
        if (getFlexNode().getLayoutFrame().f()) {
            return;
        }
        t();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void setFrameToRenderView(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.setFrameToRenderView(frame);
        B();
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r9v9, types: [com.tencent.kuikly.core.base.Attr] */
    public final boolean t() {
        if (getParent() != null) {
            ViewContainer<?, ?> parent = getParent();
            Intrinsics.checkNotNull(parent);
            if (!parent.getFlexNode().getLayoutFrame().f() && getRenderView() != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList<DeclarativeBaseView> arrayList2 = new ArrayList();
                boolean z16 = false;
                if (isRowFlexDirection()) {
                    Pair<Float, Float> C = C(true);
                    float floatValue = C.getFirst().floatValue();
                    float floatValue2 = C.getSecond().floatValue();
                    List<DeclarativeBaseView<?, ?>> renderChildren = renderChildren();
                    ArrayList<DeclarativeBaseView<?, ?>> arrayList3 = new ArrayList();
                    for (Object obj : renderChildren) {
                        boolean f16 = ((DeclarativeBaseView) obj).getFlexNode().getLayoutFrame().f();
                        if (f16) {
                            z16 = true;
                        }
                        if (!f16) {
                            arrayList3.add(obj);
                        }
                    }
                    for (DeclarativeBaseView<?, ?> declarativeBaseView : arrayList3) {
                        com.tencent.kuikly.core.layout.d layoutFrame = declarativeBaseView.getFlexNode().getLayoutFrame();
                        if (!declarativeBaseView.getViewAttr().getLazyLoadViewDisable() && (layoutFrame.g() < floatValue || layoutFrame.i() > floatValue2)) {
                            if (z(declarativeBaseView)) {
                                arrayList.add(declarativeBaseView);
                            }
                        } else if (y(declarativeBaseView)) {
                            arrayList2.add(declarativeBaseView);
                        }
                    }
                } else {
                    Pair<Float, Float> C2 = C(false);
                    float floatValue3 = C2.getFirst().floatValue();
                    float floatValue4 = C2.getSecond().floatValue();
                    List<DeclarativeBaseView<?, ?>> renderChildren2 = renderChildren();
                    ArrayList<DeclarativeBaseView<?, ?>> arrayList4 = new ArrayList();
                    for (Object obj2 : renderChildren2) {
                        boolean f17 = ((DeclarativeBaseView) obj2).getFlexNode().getLayoutFrame().f();
                        if (f17) {
                            z16 = true;
                        }
                        if (!f17) {
                            arrayList4.add(obj2);
                        }
                    }
                    for (DeclarativeBaseView<?, ?> declarativeBaseView2 : arrayList4) {
                        com.tencent.kuikly.core.layout.d layoutFrame2 = declarativeBaseView2.getFlexNode().getLayoutFrame();
                        if (!declarativeBaseView2.getViewAttr().getLazyLoadViewDisable() && (layoutFrame2.h() < floatValue3 || layoutFrame2.j() > floatValue4)) {
                            if (z(declarativeBaseView2)) {
                                arrayList.add(declarativeBaseView2);
                            }
                        } else if (y(declarativeBaseView2)) {
                            arrayList2.add(declarativeBaseView2);
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((DeclarativeBaseView) it.next()).removeRenderView();
                }
                for (DeclarativeBaseView declarativeBaseView3 : arrayList2) {
                    declarativeBaseView3.createRenderView();
                    RenderView renderView = getRenderView();
                    Intrinsics.checkNotNull(renderView);
                    renderView.e(declarativeBaseView3.getNativeRef(), -1);
                }
                return !z16;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final float u() {
        float height;
        float max;
        ViewContainer<?, ?> parent = getParent();
        aq aqVar = parent instanceof aq ? (aq) parent : null;
        if (aqVar == null) {
            return 0.0f;
        }
        if (((ao) aqVar.getViewAttr()).getInitContentOffset() <= 0.0f && ((ao) aqVar.getViewAttr()).getContentInsetTop() <= 0.0f) {
            return 0.0f;
        }
        if (isRowFlexDirection()) {
            height = aqVar.getFlexNode().getLayoutFrame().getWidth();
            max = Math.max(((ao) aqVar.getViewAttr()).getInitContentOffset(), ((ao) aqVar.getViewAttr()).getContentInsetTop());
        } else {
            height = aqVar.getFlexNode().getLayoutFrame().getHeight();
            max = Math.max(((ao) aqVar.getViewAttr()).getInitContentOffset(), ((ao) aqVar.getViewAttr()).getContentInsetTop());
        }
        return height + max;
    }

    public final List<DeclarativeBaseView<?, ?>> w() {
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(this);
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            if (!((DeclarativeBaseView) obj).getAbsoluteFlexNode()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<DeclarativeBaseView<?, ?>> x() {
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(this);
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            if (!((DeclarativeBaseView) obj).getFlexNode().getLayoutFrame().f()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.kuikly.core.views.ScrollerContentView
    public ScrollerAttr createAttr() {
        return new ScrollerAttr();
    }
}
