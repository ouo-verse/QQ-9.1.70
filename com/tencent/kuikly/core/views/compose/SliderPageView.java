package com.tencent.kuikly.core.views.compose;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J%\u0010\u0011\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00040\rj\u0002`\u000f\u00a2\u0006\u0002\b\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aR0\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e0\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u00101\u001a\u00060-j\u0002`.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00103R\u0016\u0010>\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00103\u00a8\u0006A"}, d2 = {"Lcom/tencent/kuikly/core/views/compose/SliderPageView;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/views/compose/SliderPageAttr;", "Lcom/tencent/kuikly/core/views/compose/d;", "", "p", "v", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "data", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/kuikly/core/views/bn;", "scrollParams", "u", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "viewDidLoad", "didRemoveFromParentView", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "index", "", "animation", "w", "Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/views/PageListView;", "a", "Lcom/tencent/kuikly/core/base/aa;", "t", "()Lcom/tencent/kuikly/core/base/aa;", HippyTKDListViewAdapter.X, "(Lcom/tencent/kuikly/core/base/aa;)V", "pageListRef", "b", "I", "getCurrentPageIndex", "()I", "setCurrentPageIndex", "(I)V", "currentPageIndex", "", "Lcom/tencent/kuikly/core/global/GlobalFunctionRef;", "c", "Ljava/lang/String;", "timeoutTaskCallbackId", "d", "Z", "isDragging", "", "e", UserInfo.SEX_FEMALE, "currentOffsetX", "f", "currentOffsetY", "g", "isAutoPlaying", h.F, "isAppear", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SliderPageView extends ComposeView<SliderPageAttr, d> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public aa<PageListView<?, ?>> pageListRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentPageIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String timeoutTaskCallbackId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDragging;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float currentOffsetX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float currentOffsetY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoPlaying;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAppear;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SliderPageAttr j(SliderPageView sliderPageView) {
        return (SliderPageAttr) sliderPageView.getAttr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s(com.tencent.kuikly.core.nvi.serialization.json.e data) {
        int j3 = data.j("index");
        if (((SliderPageAttr) getAttr()).getItemCount() > 1) {
            if (j3 == 0) {
                j3 = ((SliderPageAttr) getAttr()).getItemCount() - 1;
            } else {
                j3 = j3 == ((SliderPageAttr) getAttr()).getItemCount() + 1 ? 0 : j3 - 1;
            }
        }
        if (this.currentPageIndex != j3) {
            this.currentPageIndex = j3;
            data.t("index", j3);
            ((d) getEvent()).onFireEvent("pageIndexDidChanged", data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void u(ScrollParams scrollParams) {
        PageListView<?, ?> b16;
        PageListView<?, ?> b17;
        float contentWidth = scrollParams.getContentWidth();
        float contentHeight = scrollParams.getContentHeight();
        float viewWidth = scrollParams.getViewWidth();
        float viewHeight = scrollParams.getViewHeight();
        float offsetX = scrollParams.getOffsetX();
        float offsetY = scrollParams.getOffsetY();
        if (((SliderPageAttr) getAttr()).getIsHorizontal() && contentWidth > (3 * viewWidth) - 1) {
            float f16 = contentWidth - (2 * viewWidth);
            double d16 = offsetX;
            if (d16 <= 0.1d) {
                PageListView<?, ?> b18 = t().b();
                if (b18 != null) {
                    ScrollerView.setContentOffset$default(b18, offsetX + f16, 0.0f, false, null, 12, null);
                }
            } else if (d16 + 0.1d >= contentWidth - viewWidth && (b17 = t().b()) != null) {
                ScrollerView.setContentOffset$default(b17, offsetX - f16, 0.0f, false, null, 12, null);
            }
        } else if (contentHeight > (3 * viewHeight) - 1) {
            float f17 = contentHeight - (2 * viewHeight);
            double d17 = offsetY;
            if (d17 <= 0.1d) {
                PageListView<?, ?> b19 = t().b();
                if (b19 != null) {
                    ScrollerView.setContentOffset$default(b19, 0.0f, offsetY + f17, false, null, 12, null);
                }
            } else if (d17 + 0.1d >= contentHeight - viewHeight && (b16 = t().b()) != null) {
                ScrollerView.setContentOffset$default(b16, 0.0f, offsetY - f17, false, null, 12, null);
            }
        }
        this.currentOffsetX = offsetX;
        this.currentOffsetY = offsetY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        w(this.currentPageIndex + 1, true);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView$body$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                final SliderPageView sliderPageView = SliderPageView.this;
                bf.a(viewContainer, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PageListView<?, ?> pageListView) {
                        invoke2(pageListView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PageListView<?, ?> PageList) {
                        Intrinsics.checkNotNullParameter(PageList, "$this$PageList");
                        final SliderPageView sliderPageView2 = SliderPageView.this;
                        PageList.ref(PageList, new Function1<aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(aa<PageListView<?, ?>> aaVar) {
                                invoke2(aaVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(aa<PageListView<?, ?>> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                SliderPageView.this.x(it);
                            }
                        });
                        final SliderPageView sliderPageView3 = SliderPageView.this;
                        PageList.attr(new Function1<be, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(be beVar) {
                                invoke2(beVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(be attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.scrollEnable(SliderPageView.j(SliderPageView.this).getScrollEnable());
                                attr.pageItemWidth(SliderPageView.j(SliderPageView.this).getPageItemWidth());
                                attr.pageItemHeight(SliderPageView.j(SliderPageView.this).getPageItemHeight());
                                attr.defaultPageIndex(SliderPageView.j(SliderPageView.this).getDefaultPageIndex() + (SliderPageView.j(SliderPageView.this).getItemCount() > 1 ? 1 : 0));
                                if (SliderPageView.j(SliderPageView.this).getItemCount() > 1 && SliderPageView.j(SliderPageView.this).getDefaultPageIndex() > 0) {
                                    attr.setFirstContentLoadMaxIndex(SliderPageView.j(SliderPageView.this).getDefaultPageIndex() + 3);
                                }
                                attr.pageDirection(SliderPageView.j(SliderPageView.this).getIsHorizontal());
                                attr.showScrollerIndicator(false);
                                attr.setKeepItemAlive(true);
                            }
                        });
                        if (SliderPageView.j(SliderPageView.this).j() != null) {
                            Function1<PageListView<?, ?>, Unit> j3 = SliderPageView.j(SliderPageView.this).j();
                            Intrinsics.checkNotNull(j3);
                            j3.invoke(PageList);
                        }
                        final SliderPageView sliderPageView4 = SliderPageView.this;
                        PageList.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PageListEvent pageListEvent) {
                                invoke2(pageListEvent);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PageListEvent event) {
                                Intrinsics.checkNotNullParameter(event, "$this$event");
                                final SliderPageView sliderPageView5 = SliderPageView.this;
                                event.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                        invoke2(scrollParams);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ScrollParams it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        SliderPageView.this.u(it);
                                    }
                                });
                                final SliderPageView sliderPageView6 = SliderPageView.this;
                                VisibilityEventKt.e(event, new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                        invoke2(obj);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Object obj) {
                                        SliderPageView.this.isAppear = true;
                                        SliderPageView.this.y();
                                    }
                                });
                                final SliderPageView sliderPageView7 = SliderPageView.this;
                                VisibilityEventKt.c(event, new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                        invoke2(obj);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Object obj) {
                                        SliderPageView.this.isAppear = false;
                                        SliderPageView.this.z();
                                    }
                                });
                                final SliderPageView sliderPageView8 = SliderPageView.this;
                                event.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                        invoke2(obj);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Object obj) {
                                        SliderPageView sliderPageView9 = SliderPageView.this;
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        sliderPageView9.s((com.tencent.kuikly.core.nvi.serialization.json.e) obj);
                                    }
                                });
                                final SliderPageView sliderPageView9 = SliderPageView.this;
                                event.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                        invoke2(scrollParams);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ScrollParams it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        SliderPageView.this.isDragging = true;
                                        SliderPageView.this.z();
                                    }
                                });
                                final SliderPageView sliderPageView10 = SliderPageView.this;
                                event.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView.body.1.1.3.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                        invoke2(scrollParams);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(ScrollParams it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        SliderPageView.this.isDragging = false;
                                        SliderPageView.this.y();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        z();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public SliderPageAttr createAttr() {
        return new SliderPageAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public d createEvent() {
        return new d();
    }

    public final aa<PageListView<?, ?>> t() {
        aa<PageListView<?, ?>> aaVar = this.pageListRef;
        if (aaVar != null) {
            return aaVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pageListRef");
        return null;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void viewDidLoad() {
        super.viewDidLoad();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(int index, boolean animation) {
        PageListView<?, ?> b16 = t().b();
        if (b16 != null) {
            float width = b16.getFlexNode().getLayoutFrame().getWidth();
            float height = b16.getFlexNode().getLayoutFrame().getHeight();
            if (b16.getRenderView() == null || this.isDragging) {
                return;
            }
            if (width <= 0.0f || height <= 0.0f) {
                return;
            }
            float f16 = ((SliderPageAttr) getAttr()).getItemCount() == index ? 0.1f : 0.0f;
            if (((SliderPageAttr) getAttr()).getIsHorizontal()) {
                ScrollerView.setContentOffset$default(b16, ((index + 1) * width) + f16, 0.0f, animation, null, 8, null);
            } else {
                ScrollerView.setContentOffset$default(b16, 0.0f, f16 + ((index + 1) * height), animation, null, 8, null);
            }
        }
    }

    public final void x(aa<PageListView<?, ?>> aaVar) {
        Intrinsics.checkNotNullParameter(aaVar, "<set-?>");
        this.pageListRef = aaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        if (((SliderPageAttr) getAttr()).getItemCount() <= 1 || this.isAutoPlaying || !this.isAppear) {
            return;
        }
        p();
    }

    public final void z() {
        if (this.timeoutTaskCallbackId.length() > 0) {
            GlobalFunctions.f117252a.c(getPagerId(), this.timeoutTaskCallbackId);
            this.timeoutTaskCallbackId = "";
        }
        this.isAutoPlaying = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        this.isAutoPlaying = true;
        if (((SliderPageAttr) getAttr()).getLoopPlayIntervalTimeMs() == 0) {
            z();
        } else {
            this.timeoutTaskCallbackId = TimerKt.e(getPagerId(), ((SliderPageAttr) getAttr()).getLoopPlayIntervalTimeMs(), new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.compose.SliderPageView$autoLoopPlay$1
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
                    if (SliderPageView.j(SliderPageView.this).getLoopPlayIntervalTimeMs() != 0) {
                        SliderPageView.this.v();
                        SliderPageView.this.p();
                    } else {
                        SliderPageView.this.isAutoPlaying = false;
                    }
                }
            });
        }
    }
}
