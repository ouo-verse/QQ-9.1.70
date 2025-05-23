package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.itemview.memoryseal.QZoneMemorySealFeedItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.widget.QZoneLoadMoreUpView;
import com.qzone.reborn.feedx.widget.homepage.QZoneMessageBoardView;
import com.qzone.reborn.feedx.widget.userhome.QZoneFeedMemorySealView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/QZoneUserHomeMemorySealPart;", "Lcom/qzone/reborn/feedx/part/g;", "Landroid/view/View;", "memoryItemView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "J9", "", "titleHeight", "K9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "getLogTag", "", "d", "Z", "mIsClose", "e", "I", "mMemoryItemPosition", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "mViewStub", "Lcom/qzone/reborn/feedx/viewmodel/w;", tl.h.F, "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedx/viewmodel/r;", "i", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", "mMemoryBar", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneUserHomeMemorySealPart extends com.qzone.reborn.feedx.part.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsClose;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMemoryItemPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewStub mViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedMemorySealView mMemoryBar;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/feedx/part/userhome/QZoneUserHomeMemorySealPart$a", "Lcom/qzone/reborn/feedx/viewmodel/s;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "updateCount", "", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends com.qzone.reborn.feedx.viewmodel.s {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void a(List<? extends BusinessFeedData> feedsData, int updateCount) {
            QZoneUserHomeMemorySealPart.this.mMemoryItemPosition = 0;
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void b(List<? extends BusinessFeedData> feedsData) {
            Intrinsics.checkNotNullParameter(feedsData, "feedsData");
            QZoneUserHomeMemorySealPart.this.mMemoryItemPosition = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/userhome/QZoneUserHomeMemorySealPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            QZoneFeedMemorySealView qZoneFeedMemorySealView;
            QZoneFeedMemorySealView qZoneFeedMemorySealView2;
            CellFeedCommInfo feedCommInfo;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (QZoneUserHomeMemorySealPart.this.mIsClose) {
                return;
            }
            int a16 = ah.a(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Long l3 = null;
            l3 = null;
            View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(a16) : null;
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            View findViewByPosition2 = layoutManager2 != null ? layoutManager2.findViewByPosition(a16 + 1) : null;
            if (findViewByPosition2 instanceof QZoneMessageBoardView) {
                RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
                View findViewByPosition3 = layoutManager3 != null ? layoutManager3.findViewByPosition(a16 + 2) : null;
                QZoneUserHomeMemorySealPart.this.mMemoryItemPosition = a16 + 2;
                QZoneUserHomeMemorySealPart.this.J9(findViewByPosition3, recyclerView);
                return;
            }
            if (findViewByPosition2 instanceof QZoneMemorySealFeedItemView) {
                QZoneUserHomeMemorySealPart.this.mMemoryItemPosition = a16 + 1;
                QZoneUserHomeMemorySealPart.this.J9(findViewByPosition2, recyclerView);
                return;
            }
            boolean z16 = findViewByPosition instanceof QZoneMemorySealFeedItemView;
            if (z16) {
                QZoneFeedMemorySealView qZoneFeedMemorySealView3 = QZoneUserHomeMemorySealPart.this.mMemoryBar;
                if (qZoneFeedMemorySealView3 == null) {
                    return;
                }
                qZoneFeedMemorySealView3.setVisibility(0);
                return;
            }
            if (findViewByPosition instanceof QZoneLoadMoreUpView) {
                if (findViewByPosition2 instanceof QZoneBaseFeedItemView) {
                    BusinessFeedData businessFeedData = ((QZoneBaseFeedItemView) findViewByPosition2).C;
                    if (businessFeedData != null && (feedCommInfo = businessFeedData.getFeedCommInfo()) != null) {
                        l3 = Long.valueOf(feedCommInfo.time);
                    }
                    if (l3 != null) {
                        long longValue = l3.longValue();
                        Long memory_time = QZoneFeedService.f47176h0;
                        Intrinsics.checkNotNullExpressionValue(memory_time, "memory_time");
                        if (longValue >= memory_time.longValue() || z16 || (qZoneFeedMemorySealView2 = QZoneUserHomeMemorySealPart.this.mMemoryBar) == null) {
                            return;
                        }
                        qZoneFeedMemorySealView2.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if ((findViewByPosition instanceof QZoneBaseFeedItemView) || (qZoneFeedMemorySealView = QZoneUserHomeMemorySealPart.this.mMemoryBar) == null) {
                return;
            }
            qZoneFeedMemorySealView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(View memoryItemView, final RecyclerView recyclerView) {
        if (memoryItemView instanceof QZoneMemorySealFeedItemView) {
            int e16 = QZoneFeedxViewUtils.e(getActivity());
            QZoneMemorySealFeedItemView qZoneMemorySealFeedItemView = (QZoneMemorySealFeedItemView) memoryItemView;
            if (qZoneMemorySealFeedItemView.getTop() < e16) {
                QZoneFeedMemorySealView qZoneFeedMemorySealView = this.mMemoryBar;
                if (qZoneFeedMemorySealView != null && qZoneFeedMemorySealView.getVisibility() == 0) {
                    return;
                }
                if (this.mMemoryBar == null) {
                    K9(e16);
                }
                QZoneFeedMemorySealView qZoneFeedMemorySealView2 = this.mMemoryBar;
                if (qZoneFeedMemorySealView2 != null) {
                    qZoneFeedMemorySealView2.setVisibility(0);
                }
                QZoneFeedMemorySealView qZoneFeedMemorySealView3 = this.mMemoryBar;
                if (qZoneFeedMemorySealView3 != null) {
                    qZoneFeedMemorySealView3.c(qZoneMemorySealFeedItemView.C);
                }
                QZoneFeedMemorySealView qZoneFeedMemorySealView4 = this.mMemoryBar;
                if (qZoneFeedMemorySealView4 != null) {
                    qZoneFeedMemorySealView4.setOnCloseListener(new Function0<Unit>() { // from class: com.qzone.reborn.feedx.part.userhome.QZoneUserHomeMemorySealPart$checkShowMemoryBar$1
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
                            int i3;
                            RecyclerView recyclerView2;
                            RecyclerView.Adapter adapter;
                            int i16;
                            QZoneUserHomeMemorySealPart.this.mIsClose = true;
                            i3 = QZoneUserHomeMemorySealPart.this.mMemoryItemPosition;
                            if (i3 <= 0 || (recyclerView2 = recyclerView) == null || (adapter = recyclerView2.getAdapter()) == null) {
                                return;
                            }
                            i16 = QZoneUserHomeMemorySealPart.this.mMemoryItemPosition;
                            adapter.notifyItemRemoved(i16);
                        }
                    });
                    return;
                }
                return;
            }
            QZoneFeedMemorySealView qZoneFeedMemorySealView5 = this.mMemoryBar;
            if (qZoneFeedMemorySealView5 == null) {
                return;
            }
            qZoneFeedMemorySealView5.setVisibility(8);
        }
    }

    private final void K9(int titleHeight) {
        ViewStub viewStub = this.mViewStub;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewStub");
            viewStub = null;
        }
        View inflate = viewStub.inflate();
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.qzone.reborn.feedx.widget.userhome.QZoneFeedMemorySealView");
        QZoneFeedMemorySealView qZoneFeedMemorySealView = (QZoneFeedMemorySealView) inflate;
        this.mMemoryBar = qZoneFeedMemorySealView;
        ViewGroup.LayoutParams layoutParams = qZoneFeedMemorySealView != null ? qZoneFeedMemorySealView.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, ef.d.b(48));
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = titleHeight;
            QZoneFeedMemorySealView qZoneFeedMemorySealView2 = this.mMemoryBar;
            if (qZoneFeedMemorySealView2 != null) {
                qZoneFeedMemorySealView2.setLayoutParams(layoutParams);
            }
        }
        QZoneFeedMemorySealView qZoneFeedMemorySealView3 = this.mMemoryBar;
        if (qZoneFeedMemorySealView3 != null) {
            qZoneFeedMemorySealView3.setBackgroundResource(R.drawable.qzone_common_bg_card_bg);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeMemorySealPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneUserHomeViewModel::class.java)");
        this.mUserHomeViewModel = (com.qzone.reborn.feedx.viewmodel.w) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneFriend\u2026ollViewModel::class.java)");
        this.mScrollViewModel = (com.qzone.reborn.feedx.viewmodel.r) viewModel2;
        View findViewById = rootView.findViewById(R.id.n0v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026dx_memory_seal_view_stub)");
        this.mViewStub = (ViewStub) findViewById;
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        com.qzone.reborn.feedx.viewmodel.r rVar = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.f3(new a());
        com.qzone.reborn.feedx.viewmodel.r rVar2 = this.mScrollViewModel;
        if (rVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
        } else {
            rVar = rVar2;
        }
        rVar.N1(new b());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneFeedService.f47176h0 = 0L;
        QZoneFeedService.f47181m0 = false;
    }
}
