package com.qzone.reborn.feedx.part.moodlist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.feedx.viewmodel.r;
import com.qzone.reborn.feedx.widget.header.QZoneMoodListHeaderContainerView;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import eo.c;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/part/moodlist/c;", "Lcom/qzone/reborn/base/k;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "F9", "H9", "Landroid/view/View;", "v", "E9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "mHeaderView", "e", "mFloatEditIcon", "", "f", "Z", "mIsReportPublishExplore", h.F, "mApngPlaying", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "i", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "mFeedDataViewModel", "Lcom/qzone/reborn/feedx/viewmodel/r;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mHeaderView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mFloatEditIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsReportPublishExplore;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mApngPlaying = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxMoodListViewModel mFeedDataViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private r mScrollViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/moodlist/c$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            c.this.F9(recyclerView);
        }
    }

    private final void E9(View v3) {
        if (getActivity() == null) {
            return;
        }
        eo.c.f396879a.b();
        RDMEtraMsgCollector.getInstance().addNoramlClickAction(getActivity().getLocalClassName(), v3);
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoFeeds");
        qZonePublishMoodInitBean.O0(22);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        i.w().c(getActivity(), qZonePublishMoodInitBean);
        com.qzone.misc.network.report.b.d();
        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 21, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(RecyclerView recyclerView) {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = this.mFeedDataViewModel;
        if ((qZoneFeedxMoodListViewModel != null && qZoneFeedxMoodListViewModel.B2()) || recyclerView == null) {
            return;
        }
        if (recyclerView.getChildCount() > 1 && recyclerView.getChildAt(1) != null && (recyclerView.getChildAt(1) instanceof QZoneMoodListHeaderContainerView)) {
            this.mHeaderView = recyclerView.getChildAt(1);
        }
        View view = this.mHeaderView;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (iArr[1] + ViewUtils.dip2px(20.0f) >= 0 && iArr[1] != 0) {
                View view2 = this.mFloatEditIcon;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            } else {
                View view3 = this.mFloatEditIcon;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                H9();
            }
        }
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr2);
        if (iArr2[1] + recyclerView.getHeight() <= 0) {
            if (this.mApngPlaying) {
                return;
            }
            ApngImage.playByTag(24);
            this.mApngPlaying = true;
            return;
        }
        if (this.mApngPlaying) {
            ApngImage.pauseByTag(24);
            this.mApngPlaying = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(c this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.E9(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void H9() {
        if (this.mIsReportPublishExplore) {
            return;
        }
        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 21, 1);
        this.mIsReportPublishExplore = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxMoodListFloatIconPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mFeedDataViewModel = (QZoneFeedxMoodListViewModel) getViewModel(QZoneFeedxMoodListViewModel.class);
        this.mScrollViewModel = (r) getViewModel(r.class);
        View findViewById = rootView.findViewById(R.id.f162768mj1);
        this.mFloatEditIcon = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.moodlist.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.G9(c.this, view);
                }
            });
        }
        fo.c.o(this.mFloatEditIcon, "em_qz_plus_suspend", new fo.b().h(new c.a()));
        r rVar = this.mScrollViewModel;
        Intrinsics.checkNotNull(rVar);
        rVar.N1(new a());
    }
}
