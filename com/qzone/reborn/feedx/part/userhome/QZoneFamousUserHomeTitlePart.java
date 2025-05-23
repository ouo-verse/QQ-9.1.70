package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.widget.title.QZoneUserHomeTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/QZoneFamousUserHomeTitlePart;", "Lcom/qzone/reborn/feedx/part/g;", "", "P9", "Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "feedxTitle", "V9", "T9", "M9", "H9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisiblePosition", "I9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "J9", "O9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "L9", "S9", "d", "Landroid/view/View;", "mMoreBtn", "e", "Z", "mDisableTitleAlpha", "Landroid/content/BroadcastReceiver;", "f", "Landroid/content/BroadcastReceiver;", "mPublishBroadcastReceiver", tl.h.F, "Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "K9", "()Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "U9", "(Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;)V", "mFeedxTitle", "Lcom/qzone/reborn/feedx/viewmodel/r;", "i", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/viewmodel/w;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", BdhLogUtil.LogTag.Tag_Conn, "I", "mTotalDistance", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFamousUserHomeTitlePart extends com.qzone.reborn.feedx.part.g {

    /* renamed from: C, reason: from kotlin metadata */
    private int mTotalDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mMoreBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mDisableTitleAlpha;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mPublishBroadcastReceiver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public QZoneUserHomeTitle mFeedxTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/userhome/QZoneFamousUserHomeTitlePart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QZoneFamousUserHomeTitlePart.this.K9().setTitleAlpha(QZoneFamousUserHomeTitlePart.this.I9(recyclerView, ah.a(recyclerView)));
        }
    }

    private final void H9() {
        com.qzone.reborn.feedx.viewmodel.r rVar = this.mScrollViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new b());
    }

    private final void M9() {
        this.mMoreBtn = K9().d(new uh.d(TokenResUtils.getTokenRes(R.drawable.qui_more, R.drawable.qui_more), null, new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeTitlePart.N9(QZoneFamousUserHomeTitlePart.this, view);
            }
        }, null, null, false, 58, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZoneFamousUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("OPEN_USER_HOME_ACTION_PANEL", null);
        this$0.S9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P9() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.B2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFamousUserHomeTitlePart.Q9(QZoneFamousUserHomeTitlePart.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QZoneFamousUserHomeTitlePart this$0, Integer num) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 2) {
            this$0.K9().setTitleAlpha(255);
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.mDisableTitleAlpha = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZoneFamousUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.feedx.viewmodel.w wVar = this$0.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.c3();
        com.qzone.reborn.feedx.viewmodel.w wVar2 = this$0.mUserHomeViewModel;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar2 = null;
        }
        wVar2.l3();
        com.qzone.reborn.feedx.viewmodel.w wVar3 = this$0.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar3 = null;
        }
        wVar3.P1();
        this$0.broadcastMessage("SCROLL_TO_TOP", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9() {
        IntentFilter intentFilter = new IntentFilter(new IntentFilter(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY));
        this.mPublishBroadcastReceiver = new BroadcastReceiver() { // from class: com.qzone.reborn.feedx.part.userhome.QZoneFamousUserHomeTitlePart$registerPublishBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    QZoneFamousUserHomeTitlePart.this.K9().x(intent);
                }
            }
        };
        getActivity().registerReceiver(this.mPublishBroadcastReceiver, intentFilter);
    }

    private final void V9(QZoneUserHomeTitle feedxTitle) {
        int e16 = QZoneFeedxViewUtils.e(getActivity());
        if (feedxTitle.getLayoutParams() == null) {
            feedxTitle.setLayoutParams(new ViewGroup.LayoutParams(-1, e16));
        } else {
            feedxTitle.getLayoutParams().height = e16;
        }
    }

    public boolean J9() {
        return true;
    }

    public final QZoneUserHomeTitle K9() {
        QZoneUserHomeTitle qZoneUserHomeTitle = this.mFeedxTitle;
        if (qZoneUserHomeTitle != null) {
            return qZoneUserHomeTitle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedxTitle");
        return null;
    }

    public int L9() {
        return R.id.ncy;
    }

    public void O9() {
        M9();
    }

    protected void S9() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.K2()) {
            LpReportInfo_pf00064.allReport(308, 9, 2);
        } else {
            LpReportInfo_pf00064.allReport(308, 9, 23);
            com.qzone.misc.network.report.a.k();
        }
    }

    public final void U9(QZoneUserHomeTitle qZoneUserHomeTitle) {
        Intrinsics.checkNotNullParameter(qZoneUserHomeTitle, "<set-?>");
        this.mFeedxTitle = qZoneUserHomeTitle;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFamousUserHomeTitlePart";
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
        View findViewById = rootView.findViewById(L9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(getTitleViewId())");
        U9((QZoneUserHomeTitle) findViewById);
        V9(K9());
        K9().n();
        if (J9()) {
            H9();
        }
        K9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeTitlePart.R9(QZoneFamousUserHomeTitlePart.this, view);
            }
        });
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        com.qzone.reborn.feedx.viewmodel.w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.M2()) {
            T9();
        }
        QZoneUserHomeTitle K9 = K9();
        com.qzone.reborn.feedx.viewmodel.w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar3;
        }
        K9.setIsGuest(wVar2.K2());
        O9();
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BroadcastReceiver broadcastReceiver = this.mPublishBroadcastReceiver;
        if (broadcastReceiver != null) {
            activity.unregisterReceiver(broadcastReceiver);
        }
        K9().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int I9(RecyclerView recyclerView, int firstVisiblePosition) {
        int abs;
        if (firstVisiblePosition > 1 || this.mDisableTitleAlpha) {
            return 255;
        }
        View childAt = recyclerView.getChildAt(0);
        if (!(childAt instanceof com.qzone.reborn.feedx.widget.header.a) || (abs = Math.abs(childAt.getTop())) <= 0) {
            return 0;
        }
        if (this.mTotalDistance <= 0) {
            this.mTotalDistance = ef.d.b(148);
        }
        int i3 = this.mTotalDistance;
        if (abs >= i3) {
            return 255;
        }
        return (abs * 255) / i3;
    }
}
