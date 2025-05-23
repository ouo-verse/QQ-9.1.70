package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.widget.title.QZoneUserHomeTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x6.QZoneUrgePublishInfo;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 X2\u00020\u0001:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0002H\u0014R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00104\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010+R\u0018\u00107\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0016\u0010@\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010K\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010Q\u00a8\u0006Z"}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/QZoneUserHomeTitlePart;", "Lcom/qzone/reborn/feedx/part/g;", "", "Y9", "sa", "ua", "Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "feedxTitle", "Ba", "ma", "za", "ia", "oa", "Z9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisiblePosition", "aa", "Lx6/a;", "userInfoData", "Ea", "Landroid/view/View;", "anchorView", "ba", "ha", "Ca", "ga", "ra", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "ca", "la", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "ea", "xa", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mUrgePublishIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mUrgePublishButton", "f", "mSendMessageButton", tl.h.F, "mSendMessageIcon", "i", "Landroid/view/View;", "mUrgePublishLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mSendMessageLayout", BdhLogUtil.LogTag.Tag_Conn, "mSettingBtn", "D", "mMoreBtn", "E", "Z", "mDisableTitleAlpha", "Landroid/content/BroadcastReceiver;", UserInfo.SEX_FEMALE, "Landroid/content/BroadcastReceiver;", "mPublishBroadcastReceiver", "G", "Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "da", "()Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;", "Aa", "(Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle;)V", "mFeedxTitle", "Lcom/qzone/reborn/feedx/viewmodel/r;", "H", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/viewmodel/w;", "I", "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "J", "mTotalDistance", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneUserHomeTitlePart extends com.qzone.reborn.feedx.part.g {

    /* renamed from: C, reason: from kotlin metadata */
    private View mSettingBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private View mMoreBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mDisableTitleAlpha;

    /* renamed from: F, reason: from kotlin metadata */
    private BroadcastReceiver mPublishBroadcastReceiver;

    /* renamed from: G, reason: from kotlin metadata */
    public QZoneUserHomeTitle mFeedxTitle;

    /* renamed from: H, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private int mTotalDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mUrgePublishIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mUrgePublishButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mSendMessageButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mSendMessageIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mUrgePublishLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mSendMessageLayout;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/part/userhome/QZoneUserHomeTitlePart$b", "Lcom/qzone/reborn/feedx/widget/title/QZoneUserHomeTitle$b;", "", "color", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneUserHomeTitle.b {
        b() {
        }

        @Override // com.qzone.reborn.feedx.widget.title.QZoneUserHomeTitle.b
        public void a(int color) {
            if (QZoneUserHomeTitlePart.this.mUrgePublishLayout != null) {
                QZoneUserHomeTitlePart qZoneUserHomeTitlePart = QZoneUserHomeTitlePart.this;
                QZoneUserHomeTitle da5 = qZoneUserHomeTitlePart.da();
                View view = qZoneUserHomeTitlePart.mUrgePublishLayout;
                Intrinsics.checkNotNull(view);
                da5.f(view);
            }
            TextView textView = QZoneUserHomeTitlePart.this.mUrgePublishButton;
            if (textView != null) {
                textView.setTextColor(color);
            }
            com.tencent.mobileqq.qzone.picload.c.a().m(QZoneUserHomeTitlePart.this.mUrgePublishIcon, color);
            if (QZoneUserHomeTitlePart.this.mSendMessageLayout != null) {
                QZoneUserHomeTitlePart qZoneUserHomeTitlePart2 = QZoneUserHomeTitlePart.this;
                QZoneUserHomeTitle da6 = qZoneUserHomeTitlePart2.da();
                View view2 = qZoneUserHomeTitlePart2.mSendMessageLayout;
                Intrinsics.checkNotNull(view2);
                da6.f(view2);
            }
            TextView textView2 = QZoneUserHomeTitlePart.this.mSendMessageButton;
            if (textView2 != null) {
                textView2.setTextColor(color);
            }
            com.tencent.mobileqq.qzone.picload.c.a().m(QZoneUserHomeTitlePart.this.mSendMessageIcon, color);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/userhome/QZoneUserHomeTitlePart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QZoneUserHomeTitlePart.this.da().setTitleAlpha(QZoneUserHomeTitlePart.this.aa(recyclerView, ah.a(recyclerView)));
        }
    }

    private final void Ba(QZoneUserHomeTitle feedxTitle) {
        int e16 = QZoneFeedxViewUtils.e(getActivity());
        if (feedxTitle.getLayoutParams() == null) {
            feedxTitle.setLayoutParams(new ViewGroup.LayoutParams(-1, e16));
        } else {
            feedxTitle.getLayoutParams().height = e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca(x6.a userInfoData) {
        if (this.mSendMessageLayout == null) {
            ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.mjj);
            View inflate = viewStub != null ? viewStub.inflate() : null;
            this.mSendMessageLayout = inflate;
            this.mSendMessageIcon = inflate != null ? (ImageView) inflate.findViewById(R.id.mjk) : null;
            View view = this.mSendMessageLayout;
            this.mSendMessageButton = view != null ? (TextView) view.findViewById(R.id.mji) : null;
            com.tencent.mobileqq.qzone.picload.c.a().m(this.mSendMessageIcon, getActivity().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            TextView textView = this.mSendMessageButton;
            if (textView != null) {
                textView.setText(getActivity().getString(R.string.wbl));
            }
            View view2 = this.mSendMessageLayout;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.ac
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        QZoneUserHomeTitlePart.Da(QZoneUserHomeTitlePart.this, view3);
                    }
                });
            }
            View view3 = this.mSendMessageLayout;
            if (view3 != null) {
                fo.c.o(view3, "em_qz_send_msg", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(QZoneUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ra();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(final x6.a userInfoData) {
        if (this.mUrgePublishLayout == null) {
            ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.mjo);
            View inflate = viewStub != null ? viewStub.inflate() : null;
            this.mUrgePublishLayout = inflate;
            this.mUrgePublishButton = inflate != null ? (TextView) inflate.findViewById(R.id.mjn) : null;
            View view = this.mUrgePublishLayout;
            this.mUrgePublishIcon = view != null ? (ImageView) view.findViewById(R.id.mjp) : null;
            com.tencent.mobileqq.qzone.picload.c.a().m(this.mUrgePublishIcon, getActivity().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            TextView textView = this.mUrgePublishButton;
            if (textView != null) {
                textView.setText(userInfoData.urgePublishInfo.getButtonText());
            }
            View view2 = this.mUrgePublishLayout;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.ab
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        QZoneUserHomeTitlePart.Fa(QZoneUserHomeTitlePart.this, userInfoData, view3);
                    }
                });
            }
            ba(this.mUrgePublishLayout);
            fo.c.o(this.mUrgePublishButton, "em_qz_update_button", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(QZoneUserHomeTitlePart this$0, x6.a userInfoData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userInfoData, "$userInfoData");
        this$0.broadcastMessage("URGE_PUBLISH", userInfoData);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y9() {
        da().c(new b());
    }

    private final void Z9() {
        com.qzone.reborn.feedx.viewmodel.r rVar = this.mScrollViewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        View view = this.mSendMessageLayout;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha() {
        View view = this.mUrgePublishLayout;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final void ia() {
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_more, R.drawable.qui_more);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeTitlePart.ja(QZoneUserHomeTitlePart.this, view);
            }
        };
        String string = getContext().getResources().getString(R.string.w_g);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.qzone_more)");
        this.mMoreBtn = da().d(new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(QZoneUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("OPEN_USER_HOME_ACTION_PANEL", null);
        this$0.xa();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ma() {
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_search, R.drawable.qui_search);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeTitlePart.na(QZoneUserHomeTitlePart.this, view);
            }
        };
        String string = getContext().getResources().getString(R.string.wbj);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.qzone_search)");
        fo.c.o(da().d(new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null)), "em_qz_search_entry", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(QZoneUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ho.j) ho.i.t(ho.j.class)).u(this$0.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void oa() {
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_setting, R.drawable.qui_setting);
        com.qzone.reborn.feedx.viewmodel.w wVar = null;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeTitlePart.pa(QZoneUserHomeTitlePart.this, view);
            }
        };
        String string = getContext().getResources().getString(R.string.wbm);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026g(R.string.qzone_setting)");
        this.mSettingBtn = da().d(new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null));
        com.qzone.reborn.feedx.viewmodel.w wVar2 = this.mUserHomeViewModel;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar2 = null;
        }
        if (wVar2.K2()) {
            View view = this.mSettingBtn;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
                view = null;
            }
            view.setVisibility(8);
            com.qzone.reborn.feedx.viewmodel.w wVar3 = this.mUserHomeViewModel;
            if (wVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            } else {
                wVar = wVar3;
            }
            wVar.C2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneUserHomeTitlePart.qa(QZoneUserHomeTitlePart.this, (x6.a) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(QZoneUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.j jVar = (ho.j) ho.i.t(ho.j.class);
        Context context = this$0.getContext();
        com.qzone.reborn.feedx.viewmodel.w wVar = this$0.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        jVar.v(context, wVar.getMUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(QZoneUserHomeTitlePart this$0, x6.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.feedx.viewmodel.w wVar = this$0.mUserHomeViewModel;
        View view = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.Q2(aVar)) {
            View view2 = this$0.mSettingBtn;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this$0.mSettingBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final void ra() {
        String str;
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        com.qzone.reborn.feedx.viewmodel.w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        x6.a value = wVar.C2().getValue();
        if (value != null) {
            str = value.nickName;
        } else {
            str = "";
        }
        ho.d g16 = ho.i.g();
        Activity activity = getActivity();
        com.qzone.reborn.feedx.viewmodel.w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar3;
        }
        g16.b(activity, wVar2.F2(), str);
    }

    private final void sa() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.B2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneUserHomeTitlePart.ta(QZoneUserHomeTitlePart.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(QZoneUserHomeTitlePart this$0, Integer num) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 2) {
            this$0.da().setTitleAlpha(255);
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.mDisableTitleAlpha = z16;
    }

    private final void ua() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        MutableLiveData<x6.a> C2 = wVar.C2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<x6.a, Unit> function1 = new Function1<x6.a, Unit>() { // from class: com.qzone.reborn.feedx.part.userhome.QZoneUserHomeTitlePart$observeUserInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(x6.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(x6.a it) {
                com.qzone.reborn.feedx.viewmodel.w wVar2;
                com.qzone.reborn.feedx.viewmodel.w wVar3;
                QZoneUrgePublishInfo qZoneUrgePublishInfo;
                QLog.d("QZoneUserHomeTitlePart", 4, "urgePublishInfo: " + it.urgePublishInfo);
                wVar2 = QZoneUserHomeTitlePart.this.mUserHomeViewModel;
                com.qzone.reborn.feedx.viewmodel.w wVar4 = null;
                if (wVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                    wVar2 = null;
                }
                if (!wVar2.K2() || (qZoneUrgePublishInfo = it.urgePublishInfo) == null || !qZoneUrgePublishInfo.getShowUrgePublish()) {
                    QZoneUserHomeTitlePart.this.ha();
                } else {
                    QZoneUserHomeTitlePart qZoneUserHomeTitlePart = QZoneUserHomeTitlePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qZoneUserHomeTitlePart.Ea(it);
                }
                wVar3 = QZoneUserHomeTitlePart.this.mUserHomeViewModel;
                if (wVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                } else {
                    wVar4 = wVar3;
                }
                if (!wVar4.I2(it)) {
                    QZoneUserHomeTitlePart.this.ga();
                    return;
                }
                QZoneUserHomeTitlePart qZoneUserHomeTitlePart2 = QZoneUserHomeTitlePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneUserHomeTitlePart2.Ca(it);
            }
        };
        C2.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneUserHomeTitlePart.va(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(QZoneUserHomeTitlePart this$0, View view) {
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

    private final void za() {
        IntentFilter intentFilter = new IntentFilter(new IntentFilter(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY));
        this.mPublishBroadcastReceiver = new BroadcastReceiver() { // from class: com.qzone.reborn.feedx.part.userhome.QZoneUserHomeTitlePart$registerPublishBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    QZoneUserHomeTitlePart.this.da().x(intent);
                }
            }
        };
        getActivity().registerReceiver(this.mPublishBroadcastReceiver, intentFilter);
    }

    public final void Aa(QZoneUserHomeTitle qZoneUserHomeTitle) {
        Intrinsics.checkNotNullParameter(qZoneUserHomeTitle, "<set-?>");
        this.mFeedxTitle = qZoneUserHomeTitle;
    }

    public boolean ca() {
        return true;
    }

    public final QZoneUserHomeTitle da() {
        QZoneUserHomeTitle qZoneUserHomeTitle = this.mFeedxTitle;
        if (qZoneUserHomeTitle != null) {
            return qZoneUserHomeTitle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedxTitle");
        return null;
    }

    public int ea() {
        return R.id.ncy;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeTitlePart";
    }

    public void la() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.M2() && ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).isEnableQzoneSearch()) {
            ma();
        }
        oa();
        ia();
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
        View findViewById = rootView.findViewById(ea());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(getTitleViewId())");
        Aa((QZoneUserHomeTitle) findViewById);
        Ba(da());
        da().n();
        if (ca()) {
            Z9();
        }
        da().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeTitlePart.wa(QZoneUserHomeTitlePart.this, view);
            }
        });
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        com.qzone.reborn.feedx.viewmodel.w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        if (wVar.M2()) {
            za();
        }
        QZoneUserHomeTitle da5 = da();
        com.qzone.reborn.feedx.viewmodel.w wVar3 = this.mUserHomeViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar2 = wVar3;
        }
        da5.setIsGuest(wVar2.K2());
        la();
        sa();
        ua();
        Y9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BroadcastReceiver broadcastReceiver = this.mPublishBroadcastReceiver;
        if (broadcastReceiver != null) {
            activity.unregisterReceiver(broadcastReceiver);
        }
        da().p();
    }

    protected void xa() {
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

    private final void ba(View anchorView) {
        if (anchorView == null || com.qzone.reborn.util.i.b().d("URGE_PUBLISH_TIPS_SHOWN", false)) {
            return;
        }
        QUIDefaultBubbleTip.r(getContext()).S(anchorView).m0(3).o0(getActivity().getString(R.string.wbt)).R(0).k0(1).f0(false).s0();
        com.qzone.reborn.util.i.b().l("URGE_PUBLISH_TIPS_SHOWN", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int aa(RecyclerView recyclerView, int firstVisiblePosition) {
        if (firstVisiblePosition > 1 || this.mDisableTitleAlpha) {
            return 255;
        }
        View childAt = recyclerView.getChildAt(0);
        if (!(childAt instanceof com.qzone.reborn.feedx.widget.header.a)) {
            return 0;
        }
        int abs = Math.abs(childAt.getTop());
        int e16 = ((com.qzone.reborn.feedx.widget.header.a) childAt).e();
        if (e16 == 0) {
            e16 = childAt.getMeasuredHeight();
        }
        if (abs <= 0 || e16 <= 0) {
            return 0;
        }
        if (this.mTotalDistance <= 0) {
            this.mTotalDistance = e16 - da().getMeasuredHeight();
        }
        int i3 = this.mTotalDistance;
        if (abs >= i3) {
            return 255;
        }
        return (abs * 255) / i3;
    }
}
