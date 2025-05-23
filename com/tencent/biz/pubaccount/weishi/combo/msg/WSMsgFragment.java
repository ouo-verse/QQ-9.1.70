package com.tencent.biz.pubaccount.weishi.combo.msg;

import UserGrowth.stMsgRedDotCount;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.combo.msg.WSMsgFragment;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import com.tencent.biz.pubaccount.weishi.view.topnav.WSTopNavigationBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import xy.a;
import xy.g;
import xy.h;
import xy.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 h2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00022\u00020\u00042\u00020\u0005:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u0003H\u0016J&\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H\u0016J\u001a\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0018\u00101\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u00100\u001a\u00020*H\u0016J\u0012\u00102\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016J(\u00106\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*H\u0016J \u0010:\u001a\u00020\b2\u0006\u00107\u001a\u00020\u001b2\u0006\u00109\u001a\u0002082\u0006\u00103\u001a\u00020*H\u0016J\b\u0010;\u001a\u00020\bH\u0016J\b\u0010<\u001a\u00020\bH\u0016R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010T\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0016\u0010V\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010KR\u0016\u0010X\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010KR\u0016\u0010Z\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010KR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006j"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/combo/msg/WSMsgFragment;", "Lcom/tencent/biz/pubaccount/weishi/WSBaseFragment;", "Lxy/c;", "Lxy/g;", "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "initData", "Ph", "Nh", "Lxy/i;", "topBarController", "Sh", "Vh", "Hh", "Jh", "Lcom/tencent/widget/pull2refresh/RecyclerViewHeaderViewAdapter;", "Kh", "Oh", "v", "Mh", "Lh", "LUserGrowth/stMsgRedDotCount;", "redDot", "", AdMetricTag.Report.TYPE, "Qh", "Lyy/b;", ISchemeApi.KEY_PAGE_DATA, "Rh", "Gh", "Ih", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "", "isVisibleToUser", "setUserVisibleHint", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "invokeInResumeOrPause", "o0", NodeProps.ON_CLICK, "isFirst", "isRefresh", "canLoadMore", "U4", "code", "", "msg", "Q0", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "hideLoadingView", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/view/WSSwipeRefreshLayout;", "M", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/view/WSSwipeRefreshLayout;", "mSwipeRefreshView", "Lcom/tencent/biz/pubaccount/weishi/view/WSXRecyclerView;", "N", "Lcom/tencent/biz/pubaccount/weishi/view/WSXRecyclerView;", "mXRecyclerView", "Lxy/a;", "P", "Lxy/a;", "mAdapter", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "mEmptyView", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "mRlLike", ExifInterface.LATITUDE_SOUTH, "mRlFans", "T", "mRlMsgPrivate", "U", "mTvLikeNum", "V", "mTvFansNum", "W", "mTvMsgPrivateNum", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "X", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "mTopNavigationBar", "Y", "Lxy/i;", "mTopBarController", "Lcom/tencent/widget/immersive/SystemBarCompact;", "Z", "Lcom/tencent/widget/immersive/SystemBarCompact;", "systemBarComp", "<init>", "()V", "a0", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSMsgFragment extends WSBaseFragment<xy.c, g> implements xy.c, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: M, reason: from kotlin metadata */
    private WSSwipeRefreshLayout mSwipeRefreshView;

    /* renamed from: N, reason: from kotlin metadata */
    private WSXRecyclerView mXRecyclerView;

    /* renamed from: P, reason: from kotlin metadata */
    private a mAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView mEmptyView;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout mRlLike;

    /* renamed from: S, reason: from kotlin metadata */
    private LinearLayout mRlFans;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout mRlMsgPrivate;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView mTvLikeNum;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView mTvFansNum;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView mTvMsgPrivateNum;

    /* renamed from: X, reason: from kotlin metadata */
    private WSTopNavigationBar mTopNavigationBar;

    /* renamed from: Y, reason: from kotlin metadata */
    private i mTopBarController;

    /* renamed from: Z, reason: from kotlin metadata */
    private SystemBarCompact systemBarComp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/combo/msg/WSMsgFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "IS_USE_H5", "Z", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.combo.msg.WSMsgFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            PublicFragmentActivity.start(context, intent, WSMsgFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/pubaccount/weishi/combo/msg/WSMsgFragment$c", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/view/WSSwipeRefreshLayout$a;", "", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements WSSwipeRefreshLayout.a {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout.a
        public boolean a() {
            return false;
        }

        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout.a
        public boolean b() {
            WSXRecyclerView wSXRecyclerView = WSMsgFragment.this.mXRecyclerView;
            if (wSXRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
                wSXRecyclerView = null;
            }
            return !wSXRecyclerView.getRecyclerView().canScrollVertically(-1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/combo/msg/WSMsgFragment$d", "Lxy/h$a;", "", "actionId", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d implements h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stMsgRedDotCount f80484a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f80485b;

        d(stMsgRedDotCount stmsgreddotcount, int i3) {
            this.f80484a = stmsgreddotcount;
            this.f80485b = i3;
        }

        @Override // xy.h.a
        public void a(int actionId) {
            stMsgRedDotCount stmsgreddotcount = this.f80484a;
            xy.b.f(stmsgreddotcount != null ? stmsgreddotcount.count : 0, this.f80485b, actionId);
        }
    }

    private final void Gh() {
        a aVar = this.mAdapter;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            aVar = null;
        }
        if (aVar.getFooterExtraViewCount() > 0) {
            return;
        }
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.fx5, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((TextView) inflate.findViewById(R.id.xux)).setText(R.string.x9d);
        a aVar3 = this.mAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            aVar2 = aVar3;
        }
        aVar2.addFooterView(inflate);
    }

    private final void Hh() {
        RecyclerViewHeaderViewAdapter<?> Kh = Kh();
        if (Kh != null) {
            Kh.addHeader(Jh());
        }
    }

    private final View Jh() {
        LinearLayout linearLayout = null;
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.d1_, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R\u2026shi_message_header, null)");
        View findViewById = inflate.findViewById(R.id.f163262p60);
        Intrinsics.checkNotNullExpressionValue(findViewById, "headerView.findViewById(R.id.rl_msg_like)");
        this.mRlLike = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.p5z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "headerView.findViewById(R.id.rl_msg_fans)");
        this.mRlFans = (LinearLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f163263p61);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "headerView.findViewById(R.id.rl_msg_private)");
        this.mRlMsgPrivate = (LinearLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.p7o);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "headerView.findViewById(R.id.tv_msg_like_num)");
        this.mTvLikeNum = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.p7n);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "headerView.findViewById(R.id.tv_msg_fans_num)");
        this.mTvFansNum = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.p7q);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "headerView.findViewById(R.id.tv_msg_private_num)");
        this.mTvMsgPrivateNum = (TextView) findViewById6;
        LinearLayout linearLayout2 = this.mRlLike;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRlLike");
            linearLayout2 = null;
        }
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = this.mRlFans;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRlFans");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = this.mRlMsgPrivate;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRlMsgPrivate");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.setOnClickListener(this);
        return inflate;
    }

    private final RecyclerViewHeaderViewAdapter<?> Kh() {
        WSXRecyclerView wSXRecyclerView = this.mXRecyclerView;
        if (wSXRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
            wSXRecyclerView = null;
        }
        RecyclerView.Adapter adapter = wSXRecyclerView.getRecyclerView().getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter<*>");
        return (RecyclerViewHeaderViewAdapter) adapter;
    }

    private final void Lh(View v3) {
        yy.b mPageData = getPresenter().getMPageData();
        TextView textView = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f163262p60) {
            stMsgRedDotCount c16 = mPageData != null ? mPageData.c() : null;
            TextView textView2 = this.mTvLikeNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            Qh(c16, 1);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.p5z) {
            stMsgRedDotCount b16 = mPageData != null ? mPageData.b() : null;
            TextView textView3 = this.mTvFansNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
            Qh(b16, 2);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.f163263p61) {
            stMsgRedDotCount d16 = mPageData != null ? mPageData.d() : null;
            TextView textView4 = this.mTvMsgPrivateNum;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
            Qh(d16, 3);
        }
    }

    private final void Mh(View v3) {
        stMsgRedDotCount b16;
        stMsgRedDotCount c16;
        yy.b mPageData = getPresenter().getMPageData();
        Integer num = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f163262p60) {
            TextView textView = this.mTvLikeNum;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
                textView = null;
            }
            textView.setVisibility(8);
            String string = this.C.getString(R.string.f169725x90);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.ws_like)");
            h hVar = h.f449023a;
            Context mContext = this.C;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            if (mPageData != null && (c16 = mPageData.c()) != null) {
                num = Integer.valueOf(c16.subjectID);
            }
            hVar.f(mContext, "from_like", string, num);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.p5z) {
            TextView textView2 = this.mTvFansNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
                textView2 = null;
            }
            textView2.setVisibility(8);
            String string2 = this.C.getString(R.string.x8c);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.string.ws_fans)");
            h hVar2 = h.f449023a;
            Context mContext2 = this.C;
            Intrinsics.checkNotNullExpressionValue(mContext2, "mContext");
            if (mPageData != null && (b16 = mPageData.b()) != null) {
                num = Integer.valueOf(b16.subjectID);
            }
            hVar2.f(mContext2, "from_fans", string2, num);
            return;
        }
        if (valueOf != null && valueOf.intValue() == R.id.f163263p61) {
            Lh(v3);
        }
    }

    private final void Nh() {
        WSXRecyclerView wSXRecyclerView = this.mXRecyclerView;
        WSXRecyclerView wSXRecyclerView2 = null;
        if (wSXRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
            wSXRecyclerView = null;
        }
        LoadingMoreHelper loadMoreLayoutHelper = wSXRecyclerView.getLoadMoreLayoutHelper();
        if (loadMoreLayoutHelper != null) {
            loadMoreLayoutHelper.setPreLoaderCount(12);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.C, 1, false);
        Context mContext = this.C;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        this.mAdapter = new a(mContext);
        WSXRecyclerView wSXRecyclerView3 = this.mXRecyclerView;
        if (wSXRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
            wSXRecyclerView3 = null;
        }
        wSXRecyclerView3.setRefreshEnable(false);
        WSXRecyclerView wSXRecyclerView4 = this.mXRecyclerView;
        if (wSXRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
            wSXRecyclerView4 = null;
        }
        wSXRecyclerView4.setIsAutoScrolling(true);
        WSXRecyclerView wSXRecyclerView5 = this.mXRecyclerView;
        if (wSXRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
            wSXRecyclerView5 = null;
        }
        RecyclerViewWithHeaderFooter recyclerView = wSXRecyclerView5.getRecyclerView();
        a aVar = this.mAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            aVar = null;
        }
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
        WSXRecyclerView wSXRecyclerView6 = this.mXRecyclerView;
        if (wSXRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
        } else {
            wSXRecyclerView2 = wSXRecyclerView6;
        }
        wSXRecyclerView2.setRefreshCallback(new b());
        Hh();
    }

    private final void Oh() {
        WSSwipeRefreshLayout wSSwipeRefreshLayout = this.mSwipeRefreshView;
        WSSwipeRefreshLayout wSSwipeRefreshLayout2 = null;
        if (wSSwipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshView");
            wSSwipeRefreshLayout = null;
        }
        wSSwipeRefreshLayout.setOnRefreshListener(this);
        WSSwipeRefreshLayout wSSwipeRefreshLayout3 = this.mSwipeRefreshView;
        if (wSSwipeRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshView");
        } else {
            wSSwipeRefreshLayout2 = wSSwipeRefreshLayout3;
        }
        wSSwipeRefreshLayout2.setOnInterceptTouchEventListener(new c());
    }

    private final void Qh(stMsgRedDotCount redDot, int reportType) {
        h hVar = h.f449023a;
        Context mContext = this.C;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        hVar.d(mContext, redDot != null ? redDot.schema : null, new d(redDot, reportType));
    }

    private final void Rh(yy.b pageData) {
        stMsgRedDotCount c16 = pageData.c();
        stMsgRedDotCount b16 = pageData.b();
        stMsgRedDotCount d16 = pageData.d();
        int i3 = c16 != null ? c16.count : 0;
        int i16 = b16 != null ? b16.count : 0;
        int i17 = d16 != null ? d16.count : 0;
        TextView textView = null;
        if (i3 > 0) {
            TextView textView2 = this.mTvLikeNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.mTvLikeNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
                textView3 = null;
            }
            textView3.setText(String.valueOf(i3));
        } else {
            TextView textView4 = this.mTvLikeNum;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
                textView4 = null;
            }
            textView4.setVisibility(8);
        }
        if (i16 > 0) {
            TextView textView5 = this.mTvFansNum;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = this.mTvFansNum;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
                textView6 = null;
            }
            textView6.setText(String.valueOf(i16));
        } else {
            TextView textView7 = this.mTvFansNum;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvFansNum");
                textView7 = null;
            }
            textView7.setVisibility(8);
        }
        if (i17 > 0) {
            TextView textView8 = this.mTvMsgPrivateNum;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
                textView8 = null;
            }
            textView8.setVisibility(0);
            TextView textView9 = this.mTvMsgPrivateNum;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
            } else {
                textView = textView9;
            }
            textView.setText(String.valueOf(i17));
        } else {
            TextView textView10 = this.mTvMsgPrivateNum;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvMsgPrivateNum");
            } else {
                textView = textView10;
            }
            textView.setVisibility(8);
        }
        xy.b.g(i3, i16, i17);
    }

    private final void Sh(i topBarController) {
        topBarController.b(new View.OnClickListener() { // from class: xy.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSMsgFragment.Th(WSMsgFragment.this, view);
            }
        });
        topBarController.c(new View.OnClickListener() { // from class: xy.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSMsgFragment.Uh(WSMsgFragment.this, view);
            }
        });
        String string = getString(R.string.f169728x93);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ws_message)");
        topBarController.d(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(WSMsgFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBaseActivity().doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(WSMsgFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Vh();
    }

    private final void Vh() {
        uy.c.d("message");
        bb.O(getBaseActivity());
    }

    private final void initData() {
        g presenter = getPresenter();
        if (presenter != null) {
            presenter.A0(true, true);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Ih, reason: merged with bridge method [inline-methods] */
    public g V() {
        return new g();
    }

    @Override // xy.c
    public void Q0(int code, String msg2, boolean isFirst) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (isFirst) {
            a aVar = this.mAdapter;
            WSXRecyclerView wSXRecyclerView = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                aVar = null;
            }
            if (aVar.getDataList().size() == 0) {
                TextView textView = this.mEmptyView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                    textView = null;
                }
                textView.setVisibility(0);
                WSXRecyclerView wSXRecyclerView2 = this.mXRecyclerView;
                if (wSXRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
                } else {
                    wSXRecyclerView = wSXRecyclerView2;
                }
                wSXRecyclerView.loadMoreComplete(false, false);
            }
        }
    }

    @Override // xy.c
    public void U4(yy.b pageData, boolean isFirst, boolean isRefresh, boolean canLoadMore) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        a aVar = null;
        if ((isRefresh || isFirst) && pageData.e().size() == 0) {
            TextView textView = this.mEmptyView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                textView = null;
            }
            textView.setVisibility(0);
        } else {
            TextView textView2 = this.mEmptyView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                textView2 = null;
            }
            textView2.setVisibility(8);
        }
        if (!isFirst && !isRefresh) {
            a aVar2 = this.mAdapter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                aVar2 = null;
            }
            aVar2.appendList(pageData.e());
        } else {
            Rh(pageData);
            a aVar3 = this.mAdapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                aVar3 = null;
            }
            aVar3.fillList(pageData.e());
            WSXRecyclerView wSXRecyclerView = this.mXRecyclerView;
            if (wSXRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
                wSXRecyclerView = null;
            }
            wSXRecyclerView.backToTopAtOnce();
        }
        WSXRecyclerView wSXRecyclerView2 = this.mXRecyclerView;
        if (wSXRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRecyclerView");
            wSXRecyclerView2 = null;
        }
        wSXRecyclerView2.loadMoreComplete(true, canLoadMore);
        if (canLoadMore) {
            return;
        }
        a aVar4 = this.mAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            aVar = aVar4;
        }
        if (aVar.getDataList().size() > 0) {
            Gh();
        }
    }

    @Override // xy.c
    public void hideLoadingView() {
        WSSwipeRefreshLayout wSSwipeRefreshLayout = this.mSwipeRefreshView;
        if (wSSwipeRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeRefreshView");
            wSSwipeRefreshLayout = null;
        }
        wSSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.pubaccount.weishi.j.b
    public void o0(boolean isVisibleToUser, boolean invokeInResumeOrPause) {
        super.o0(isVisibleToUser, invokeInResumeOrPause);
        if (isVisibleToUser) {
            WSPublicAccReport.getInstance().reportPageVisitEnter("message");
        } else {
            WSPublicAccReport.getInstance().reportPageVisitExit("message");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Mh(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.d0s, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026essage, container, false)");
        initView(inflate);
        return inflate;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        getPresenter().A0(false, true);
        a aVar = this.mAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            aVar = null;
        }
        aVar.removeFooterView();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SystemBarCompact systemBarCompact = this.systemBarComp;
        if (systemBarCompact != null) {
            systemBarCompact.setStatusBarVisible(2, 0);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph(!this.L);
        initData();
        this.systemBarComp = SystemBarActivityModule.getSystemBarComp(getBaseActivity());
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            ph(true);
            initData();
        }
    }

    private final void Ph(View rootView) {
        View findViewById = rootView.findViewById(R.id.p6r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.top_navigation_bar)");
        WSTopNavigationBar wSTopNavigationBar = (WSTopNavigationBar) findViewById;
        this.mTopNavigationBar = wSTopNavigationBar;
        WSTopNavigationBar wSTopNavigationBar2 = null;
        if (this.L) {
            if (wSTopNavigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopNavigationBar");
                wSTopNavigationBar = null;
            }
            wSTopNavigationBar.setTopBarStyle(2, true, false);
        } else {
            if (wSTopNavigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopNavigationBar");
                wSTopNavigationBar = null;
            }
            wSTopNavigationBar.setTopBarStyle(1, true, false);
        }
        WSTopNavigationBar wSTopNavigationBar3 = this.mTopNavigationBar;
        if (wSTopNavigationBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopNavigationBar");
        } else {
            wSTopNavigationBar2 = wSTopNavigationBar3;
        }
        i iVar = new i(wSTopNavigationBar2);
        this.mTopBarController = iVar;
        Sh(iVar);
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.p6h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.srl_msg)");
        this.mSwipeRefreshView = (WSSwipeRefreshLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f163265p63);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rv_msg)");
        this.mXRecyclerView = (WSXRecyclerView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.p7m);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_msg_empty)");
        this.mEmptyView = (TextView) findViewById3;
        Ph(rootView);
        Nh();
        Oh();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/pubaccount/weishi/combo/msg/WSMsgFragment$b", "Lcom/tencent/widget/pull2refresh/XRecyclerView$RefreshCallback;", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "recyclerView", "", "isMachineRefresh", "", "startTopRefresh", "", "reqType", "startLoadMore", "endOfRefresh", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements XRecyclerView.RefreshCallback {
        b() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView recyclerView, int reqType) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            WSMsgFragment.this.getPresenter().A0(false, false);
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView recyclerView, boolean isMachineRefresh) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
        }
    }
}
