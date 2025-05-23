package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ad;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0011\u0012\b\b\u0002\u00101\u001a\u00020\u0013\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\tJ\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H\u0016J \u0010+\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\tH\u0016R\u0017\u00101\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010;\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00058\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b8\u00105\"\u0004\b9\u0010:R*\u0010@\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00105\u001a\u0004\b=\u0010>\"\u0004\b?\u0010:R*\u0010G\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00158\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010K\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010H8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/kuikly/core/views/RefreshView;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/bk;", "Lcom/tencent/kuikly/core/views/bl;", "Lcom/tencent/kuikly/core/views/ad;", "", "y", "r", "w", "", BdhLogUtil.LogTag.Tag_Conn, "contentOffsetX", "contentOffsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "t", ReportConstant.COSTREPORT_PREFIX, "pullingPercent", HippyTKDListViewAdapter.X, "", "v", "Lcom/tencent/kuikly/core/views/RefreshViewState;", "newState", "oldState", "u", "state", "o", "animated", "k", "p", "didInit", "didMoveToParentView", "willRemoveFromParentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "viewName", "width", "height", "contentSizeDidChanged", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "onContentOffsetDidChanged", "subViewsDidLayout", "a", "Z", "getInFooter", "()Z", "inFooter", "b", "isDraging", "c", UserInfo.SEX_FEMALE, "contentHeight", "value", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(F)V", "contentInsetTop", "e", "getContentInsetTopWhenEndDrag", "()F", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "contentInsetTopWhenEndDrag", "f", "Lcom/tencent/kuikly/core/views/RefreshViewState;", "getRefreshState", "()Lcom/tencent/kuikly/core/views/RefreshViewState;", "B", "(Lcom/tencent/kuikly/core/views/RefreshViewState;)V", "refreshState", "Lcom/tencent/kuikly/core/views/aq;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/kuikly/core/views/aq;", "listView", "<init>", "(Z)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RefreshView extends ViewContainer<bk, bl> implements ad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean inFooter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDraging;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float contentHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float contentInsetTop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float contentInsetTopWhenEndDrag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RefreshViewState refreshState;

    public RefreshView() {
        this(false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        if (this.inFooter) {
            aq<?, ?> q16 = q();
            ((bk) getViewAttr()).transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, Math.max((q16 == null || (flexNode = q16.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getHeight(), this.contentHeight)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void o(RefreshViewState state) {
        Function1<RefreshViewState, Unit> i3 = ((bl) getEvent()).i();
        if (i3 != null) {
            i3.invoke(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final aq<?, ?> q() {
        ViewContainer<?, ?> parent = getParent();
        ViewContainer<?, ?> parent2 = parent != null ? parent.getParent() : null;
        if (parent2 instanceof aq) {
            return (aq) parent2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float r() {
        if (this.inFooter) {
            return w() + y();
        }
        return -y();
    }

    private final void s(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        float y16 = y();
        aq<?, ?> q16 = q();
        float max = Math.max(this.contentHeight - ((q16 == null || (flexNode = q16.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getHeight()), 0.0f);
        if (contentOffsetY < max) {
            return;
        }
        float f16 = max + y16;
        float f17 = (contentOffsetY - max) / y16;
        RefreshViewState refreshViewState = this.refreshState;
        RefreshViewState refreshViewState2 = RefreshViewState.REFRESHING;
        if (refreshViewState == refreshViewState2) {
            x(f17);
            return;
        }
        if (params.getIsDragging()) {
            RefreshViewState refreshViewState3 = this.refreshState;
            RefreshViewState refreshViewState4 = RefreshViewState.IDLE;
            if (refreshViewState3 == refreshViewState4 && contentOffsetY > f16) {
                B(RefreshViewState.PULLING);
            } else if (refreshViewState3 == RefreshViewState.PULLING && contentOffsetY <= f16) {
                this.isDraging = true;
                B(refreshViewState4);
                this.isDraging = false;
            }
        } else if (this.refreshState == RefreshViewState.PULLING) {
            B(refreshViewState2);
        }
        x(f17);
    }

    private final void t(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        float y16 = y();
        float f16 = 0;
        if (contentOffsetY > f16) {
            return;
        }
        float f17 = f16 - y16;
        float f18 = (f16 - contentOffsetY) / y16;
        RefreshViewState refreshViewState = this.refreshState;
        RefreshViewState refreshViewState2 = RefreshViewState.REFRESHING;
        if (refreshViewState == refreshViewState2) {
            x(f18);
            return;
        }
        if (params.getIsDragging()) {
            RefreshViewState refreshViewState3 = this.refreshState;
            RefreshViewState refreshViewState4 = RefreshViewState.IDLE;
            if (refreshViewState3 == refreshViewState4 && contentOffsetY < f17) {
                B(RefreshViewState.PULLING);
            } else if (refreshViewState3 == RefreshViewState.PULLING && contentOffsetY >= f17) {
                this.isDraging = true;
                B(refreshViewState4);
                this.isDraging = false;
            }
        } else if (this.refreshState == RefreshViewState.PULLING) {
            B(refreshViewState2);
        }
        x(f18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(RefreshViewState newState, RefreshViewState oldState) {
        float y16;
        if (!(((bk) getViewAttr()).getRefreshHeight() == 0.0f)) {
            y16 = ((bk) getViewAttr()).getRefreshHeight();
        } else {
            y16 = y();
        }
        RefreshViewState refreshViewState = RefreshViewState.IDLE;
        if (newState == refreshViewState && oldState == RefreshViewState.REFRESHING) {
            z(0.0f);
            A(0.0f);
            if (v()) {
                o(refreshViewState);
                return;
            } else {
                TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.RefreshView$handleStateDidChange$1
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
                        RefreshViewState refreshState = RefreshView.this.getRefreshState();
                        RefreshViewState refreshViewState2 = RefreshViewState.IDLE;
                        if (refreshState == refreshViewState2) {
                            RefreshView.this.o(refreshViewState2);
                        }
                    }
                });
                return;
            }
        }
        RefreshViewState refreshViewState2 = RefreshViewState.REFRESHING;
        if (newState == refreshViewState2) {
            o(refreshViewState2);
            return;
        }
        RefreshViewState refreshViewState3 = RefreshViewState.PULLING;
        if (newState == refreshViewState3) {
            A(y16);
            o(refreshViewState3);
        } else if (newState == refreshViewState) {
            if (!this.isDraging) {
                z(0.0f);
            }
            A(0.0f);
            o(refreshViewState);
        }
    }

    private final boolean v() {
        if (this.inFooter) {
            aq<?, ?> q16 = q();
            return (q16 != null ? q16.getCurOffsetY() : 0.0f) < w();
        }
        aq<?, ?> q17 = q();
        return (q17 != null ? q17.getCurOffsetY() : 0.0f) >= 0.0f;
    }

    private final float w() {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        float f16 = this.contentHeight;
        aq<?, ?> q16 = q();
        return Math.max(f16 - ((q16 == null || (flexNode = q16.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getHeight()), 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(float pullingPercent) {
        Function1<Float, Unit> h16 = ((bl) getEvent()).h();
        if (h16 != null) {
            h16.invoke(Float.valueOf(pullingPercent));
        }
    }

    private final float y() {
        return getFlexNode().getLayoutFrame().getHeight();
    }

    private final void z(float f16) {
        this.contentInsetTop = f16;
        if (this.inFooter) {
            aq<?, ?> q16 = q();
            if (q16 != null) {
                ScrollerView.setContentInset$default(q16, 0.0f, 0.0f, f16, 0.0f, true, 11, null);
                return;
            }
            return;
        }
        aq<?, ?> q17 = q();
        if (q17 != null) {
            ScrollerView.setContentInset$default(q17, f16, 0.0f, 0.0f, 0.0f, true, 14, null);
        }
    }

    public final void A(float f16) {
        this.contentInsetTopWhenEndDrag = f16;
        if (this.inFooter) {
            aq<?, ?> q16 = q();
            if (q16 != null) {
                ScrollerView.setContentInsetWhenEndDrag$default(q16, 0.0f, 0.0f, f16, 0.0f, 11, null);
                return;
            }
            return;
        }
        aq<?, ?> q17 = q();
        if (q17 != null) {
            ScrollerView.setContentInsetWhenEndDrag$default(q17, f16, 0.0f, 0.0f, 0.0f, 14, null);
        }
    }

    public final void B(RefreshViewState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        RefreshViewState refreshViewState = this.refreshState;
        if (value != refreshViewState) {
            this.refreshState = value;
            u(value, refreshViewState);
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentSizeDidChanged(float width, float height) {
        ad.a.a(this, width, height);
        this.contentHeight = height;
        C();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentViewDidSetFrameToRenderView() {
        ad.a.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        bk bkVar = (bk) getAttr();
        Attr m150top = bkVar.positionAbsolute().m142left(0.0f).m149right(0.0f).m150top(0.0f);
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        m150top.m138bottom(Float.NaN);
        bkVar.transform(new com.tencent.kuikly.core.base.y(0.0f, -1.0f, 0.0f, 0.0f, 12, null));
        bkVar.setKeepAlive(true);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        super.didMoveToParentView();
        aq<?, ?> q16 = q();
        if (q16 != null) {
            q16.addScrollerViewEventObserver(this);
        }
    }

    public final RefreshViewState getRefreshState() {
        return this.refreshState;
    }

    public final void k(final boolean animated) {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.RefreshView$beginRefresh$1
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
                aq q16;
                float r16;
                RefreshViewState refreshState = RefreshView.this.getRefreshState();
                RefreshViewState refreshViewState = RefreshViewState.REFRESHING;
                if (refreshState != refreshViewState) {
                    q16 = RefreshView.this.q();
                    if (q16 != null) {
                        r16 = RefreshView.this.r();
                        ScrollerView.setContentOffset$default(q16, 0.0f, r16, animated, null, 8, null);
                    }
                    RefreshView.this.B(refreshViewState);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.layoutFrameDidChanged(frame);
        C();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public bk createAttr() {
        return new bk();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public bl createEvent() {
        return new bl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.ad
    public void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (getFlexNode().getLayoutFrame().f()) {
            return;
        }
        if (getFlexNode().getLayoutFrame().getHeight() == 0.0f) {
            return;
        }
        if (!((bk) getAttr()).getRefreshEnable()) {
            B(RefreshViewState.IDLE);
        } else if (this.inFooter) {
            s(contentOffsetX, contentOffsetY, params);
        } else {
            t(contentOffsetX, contentOffsetY, params);
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
    }

    public final void p() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.RefreshView$endRefresh$1
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
                RefreshViewState refreshState = RefreshView.this.getRefreshState();
                RefreshViewState refreshViewState = RefreshViewState.IDLE;
                if (refreshState != refreshViewState) {
                    RefreshView.this.B(refreshViewState);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollFrameDidChanged(com.tencent.kuikly.core.layout.d dVar) {
        ad.a.d(this, dVar);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollerDragBegin(ScrollParams scrollParams) {
        ad.a.e(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollerScrollDidEnd(ScrollParams scrollParams) {
        ad.a.f(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void willRemoveFromParentView() {
        super.willRemoveFromParentView();
        aq<?, ?> q16 = q();
        if (q16 != null) {
            q16.removeScrollerViewEventObserver(this);
        }
    }

    public /* synthetic */ RefreshView(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public RefreshView(boolean z16) {
        this.inFooter = z16;
        this.refreshState = RefreshViewState.IDLE;
    }

    public static /* synthetic */ void l(RefreshView refreshView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        refreshView.k(z16);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void subViewsDidLayout() {
    }
}
