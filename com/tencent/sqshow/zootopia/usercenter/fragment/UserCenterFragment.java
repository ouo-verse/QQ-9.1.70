package com.tencent.sqshow.zootopia.usercenter.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity;
import com.tencent.sqshow.zootopia.recommend.main.dress.entrance.PublishEntranceView;
import com.tencent.sqshow.zootopia.usercenter.view.items.UserCenterInfoCard;
import com.tencent.sqshow.zootopia.usercenter.view.ui.UserCenterUgcRecyclerView;
import com.tencent.sqshow.zootopia.usercenter.view.ui.UserCenterWearPageView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.r;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.sqshow.zootopia.view.ZootopiaViewPager;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.RecyclerViewXWithHeaderFooter;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.ZootopiaPullRefreshLayoutV2;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabView;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc4.UserCenterCardData;
import jc4.UserCenterReqData;
import jc4.UserCenterTitleCardData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import n74.dk;
import n74.dl;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t*\u0001}\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0084\u0001B\t\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J$\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0017J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u000202H\u0014J\b\u00104\u001a\u00020\u0010H\u0016J\b\u00105\u001a\u00020\u0010H\u0016J\b\u00106\u001a\u00020\u0013H\u0016J\b\u00107\u001a\u00020\u0010H\u0016J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0013H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u000202H\u0016J\b\u0010?\u001a\u00020>H\u0016J\u0012\u0010B\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010@H\u0016R\u0016\u0010E\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010KR\u0014\u0010Z\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010NR\u0014\u0010\\\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010NR\u0016\u0010^\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010DR\u0016\u0010`\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010DR\u0014\u0010c\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010|\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007f\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "Lcom/tencent/mobileqq/zootopia/api/c;", "", "initData", "Ljc4/f;", "reqData", "Yh", "Landroid/content/Intent;", "intent", "Xh", "Ln74/dl;", "binding", "gi", "bi", "", "ki", "ei", "", "count", "Landroidx/viewpager/widget/PagerAdapter;", "Wh", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/ZootopiaPullRefreshLayoutV2;", "refreshView", "Vh", "fi", "di", "Zh", "handleBackEvent", "li", "pi", "qi", "mi", "ni", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getSubSource", "onBackPressedEvent", "isWrapContent", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "j8", "Qa", "E3", "getStatusBarHeight", "", "getCurrentUin", "ua", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "H1", "Landroid/view/KeyEvent;", "event", "J5", "N", "Z", "forceReturnPortal", "P", "Ln74/dl;", "mBinding", "Lhu4/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lhu4/f;", "mUserInfo", BdhLogUtil.LogTag.Tag_Req, "I", "mStatus", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "mCurrentUin", "Ljc4/b;", "T", "Ljc4/b;", "mFetcher", "U", "mCurrentPersonInfo", "V", "mLeftMargin", "W", "mRightMargin", "X", "mDataRequesting", "Y", "mNeedReRequest", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "Ljc4/e;", "a0", "Ljc4/e;", "reddotManager", "Lcom/tencent/sqshow/zootopia/usercenter/view/items/UserCenterInfoCard;", "b0", "Lcom/tencent/sqshow/zootopia/usercenter/view/items/UserCenterInfoCard;", "userInfoCard", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView;", "c0", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView;", "tabView", "Lcom/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterUgcRecyclerView;", "d0", "Lcom/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterUgcRecyclerView;", "ugcRecyclerView", "Lcom/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterWearPageView;", "e0", "Lcom/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterWearPageView;", "wearRecyclerView", "f0", "Ljc4/f;", "g0", "Landroidx/viewpager/widget/PagerAdapter;", "pageAdapter", "com/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$f", "h0", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$f;", "mScrollListener", "<init>", "()V", "i0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserCenterFragment extends ZootopiaBaseFragment implements a, com.tencent.mobileqq.zootopia.api.c {

    /* renamed from: N, reason: from kotlin metadata */
    private boolean forceReturnPortal;

    /* renamed from: P, reason: from kotlin metadata */
    private dl mBinding;

    /* renamed from: U, reason: from kotlin metadata */
    private hu4.f mCurrentPersonInfo;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean mDataRequesting;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean mNeedReRequest;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private UserCenterInfoCard userInfoCard;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ZPlanTabView tabView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private UserCenterUgcRecyclerView ugcRecyclerView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private UserCenterWearPageView wearRecyclerView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private UserCenterReqData reqData;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private PagerAdapter pageAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private hu4.f mUserInfo = new hu4.f();

    /* renamed from: R, reason: from kotlin metadata */
    private int mStatus = 1;

    /* renamed from: S, reason: from kotlin metadata */
    private String mCurrentUin = "";

    /* renamed from: T, reason: from kotlin metadata */
    private final jc4.b mFetcher = new jc4.b();

    /* renamed from: V, reason: from kotlin metadata */
    private final int mLeftMargin = i.b(16);

    /* renamed from: W, reason: from kotlin metadata */
    private final int mRightMargin = i.b(16);

    /* renamed from: Z, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter = new ZplanViewReportHelper();

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final jc4.e reddotManager = new jc4.e();

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final f mScrollListener = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            PublishEntranceView publishEntranceView;
            RecyclerView.OnScrollListener m3;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            dl dlVar = UserCenterFragment.this.mBinding;
            if (dlVar == null || (publishEntranceView = dlVar.f419295h) == null || (m3 = publishEntranceView.m()) == null) {
                return;
            }
            m3.onScrollStateChanged(null, newState);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int dx5, int dy5) {
            PublishEntranceView publishEntranceView;
            RecyclerView.OnScrollListener m3;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            dl dlVar = UserCenterFragment.this.mBinding;
            if (dlVar == null || (publishEntranceView = dlVar.f419295h) == null || (m3 = publishEntranceView.m()) == null) {
                return;
            }
            m3.onScrolled(null, dx5, dy5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$c", "Landroidx/viewpager/widget/PagerAdapter;", "", "getCount", "Landroid/view/View;", "view", "", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "instantiateItem", "", "destroyItem", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f373114d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UserCenterFragment f373115e;

        c(int i3, UserCenterFragment userCenterFragment) {
            this.f373114d = i3;
            this.f373115e = userCenterFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object any) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(any, "any");
            container.removeView((View) any);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount, reason: from getter */
        public int getF373114d() {
            return this.f373114d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            UserCenterUgcRecyclerView userCenterUgcRecyclerView;
            Intrinsics.checkNotNullParameter(container, "container");
            if (position == 0) {
                UserCenterReqData userCenterReqData = this.f373115e.reqData;
                boolean z16 = false;
                if (userCenterReqData != null && userCenterReqData.getIsShowSquare()) {
                    z16 = true;
                }
                if (z16) {
                    Context requireContext = this.f373115e.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    UserCenterWearPageView userCenterWearPageView = new UserCenterWearPageView(requireContext, this.f373115e);
                    this.f373115e.wearRecyclerView = userCenterWearPageView;
                    this.f373115e.Vh(userCenterWearPageView.getRefreshView());
                    userCenterUgcRecyclerView = userCenterWearPageView;
                    container.addView(userCenterUgcRecyclerView);
                    return userCenterUgcRecyclerView;
                }
            }
            Context requireContext2 = this.f373115e.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            UserCenterUgcRecyclerView userCenterUgcRecyclerView2 = new UserCenterUgcRecyclerView(requireContext2, this.f373115e);
            this.f373115e.ugcRecyclerView = userCenterUgcRecyclerView2;
            this.f373115e.Vh(userCenterUgcRecyclerView2);
            userCenterUgcRecyclerView = userCenterUgcRecyclerView2;
            container.addView(userCenterUgcRecyclerView);
            return userCenterUgcRecyclerView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object any) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(any, "any");
            return Intrinsics.areEqual(view, any);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$e", "Lcom/tencent/sqshow/zootopia/portal/detail/scrollingheader/ScrollingHeaderLayout$c;", "Lcom/tencent/sqshow/zootopia/portal/detail/scrollingheader/ScrollingHeaderLayout;", "appBarLayout", "", "verticalOffset", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements ScrollingHeaderLayout.c {
        e() {
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout.b
        public void a(ScrollingHeaderLayout appBarLayout, int verticalOffset) {
            UserCenterFragment.this.Zh();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            UserCenterFragment.this.Zh();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            UserCenterFragment.this.Zh();
        }
    }

    private final PagerAdapter Wh(int count) {
        return new c(count, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if (r7.getBooleanExtra("force_return_portal", false) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Xh(Intent intent) {
        int i3;
        boolean z16;
        String b16 = w.f373306a.b();
        String stringExtra = intent.getStringExtra("uid");
        if (stringExtra == null) {
            stringExtra = b16;
        }
        this.mCurrentUin = stringExtra;
        if (Intrinsics.areEqual(stringExtra, b16) || Intrinsics.areEqual(this.mCurrentUin, "0")) {
            this.mCurrentUin = b16;
            i3 = 1;
        } else {
            i3 = 2;
        }
        this.mStatus = i3;
        String stringExtra2 = intent.getStringExtra("from");
        if (!Intrinsics.areEqual("publish", stringExtra2)) {
            z16 = false;
        }
        z16 = true;
        this.forceReturnPortal = z16;
        QLog.i("UserCenterFragment_", 1, "handleIntent mCurrentUin:" + this.mCurrentUin + ", mStatus:" + this.mStatus + ", source " + stringExtra2 + ", forceReturnPortal:" + z16);
    }

    private final void Yh(UserCenterReqData reqData) {
        Object obj;
        UserCenterWearPageView userCenterWearPageView;
        ArrayList<ZootopiaDetailFeedsCardData> a16;
        boolean isShowSquare = reqData.getIsShowSquare();
        ZootopiaDetailFeedsListData feedsList = reqData.getFeedsList();
        Integer valueOf = (feedsList == null || (a16 = feedsList.a()) == null) ? null : Integer.valueOf(a16.size());
        QLog.i("UserCenterFragment_", 1, "reqData :: isShowSquare == " + isShowSquare + " , squareList.size == " + valueOf + " , ugcList.size == " + reqData.a().size());
        this.reqData = reqData;
        PagerAdapter pagerAdapter = this.pageAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.notifyDataSetChanged();
        }
        if (reqData.getErrorCode() != 0) {
            pi();
            return;
        }
        Iterator<T> it = reqData.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((UserCenterCardData) obj).getItemType() == 202230) {
                    break;
                }
            }
        }
        UserCenterCardData userCenterCardData = (UserCenterCardData) obj;
        this.mCurrentPersonInfo = userCenterCardData != null ? userCenterCardData.getPersonalInfo() : null;
        li();
        fi();
        di();
        if (!reqData.a().isEmpty()) {
            UserCenterInfoCard userCenterInfoCard = this.userInfoCard;
            if (userCenterInfoCard != null) {
                userCenterInfoCard.w0(reqData.a().get(0), 0);
            }
            UserCenterUgcRecyclerView userCenterUgcRecyclerView = this.ugcRecyclerView;
            if (userCenterUgcRecyclerView != null) {
                userCenterUgcRecyclerView.O(reqData.a());
            }
        }
        UserCenterWearPageView userCenterWearPageView2 = this.wearRecyclerView;
        if ((userCenterWearPageView2 != null && userCenterWearPageView2.i() == 0) && (userCenterWearPageView = this.wearRecyclerView) != null) {
            userCenterWearPageView.o(reqData.getFeedsList());
        }
        mi();
        ni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh() {
        int argb;
        Context context = getContext();
        if (context == null) {
            return;
        }
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache(context, ZplanCacheComponentType.USER_CENTER_USER_INFO_CARD);
        View view = cache instanceof View ? (View) cache : null;
        if (view != null && view.isAttachedToWindow()) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i3 = iArr[1] * (-1);
            if (i3 <= 176) {
                argb = Color.argb(0, 255, 255, 255);
            } else if (i3 >= 392) {
                argb = Color.argb(255, 255, 255, 255);
            } else {
                argb = Color.argb((int) (255 * (((i3 - 176) * 1.0f) / 216)), 255, 255, 255);
            }
            dl dlVar = this.mBinding;
            FrameLayout frameLayout = dlVar != null ? dlVar.f419298k : null;
            if (frameLayout != null) {
                frameLayout.setBackground(new ColorDrawable(argb));
            }
            ZPlanTabView zPlanTabView = this.tabView;
            if (zPlanTabView == null) {
                return;
            }
            zPlanTabView.setBackground(new ColorDrawable(argb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(UserCenterFragment this$0, UserCenterReqData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Yh(it);
        this$0.mDataRequesting = false;
        this$0.mNeedReRequest = false;
    }

    private final void bi(final dl binding) {
        PublishEntranceView publishEntranceView;
        if (!Qa() || w84.a.f445029a.b()) {
            return;
        }
        ScrollingHeaderLayout scrollingHeaderLayout = binding.f419289b;
        dl dlVar = this.mBinding;
        scrollingHeaderLayout.b((dlVar == null || (publishEntranceView = dlVar.f419295h) == null) ? null : publishEntranceView.l());
        binding.f419295h.setVisibility(0);
        PublishEntranceView publishEntranceView2 = binding.f419295h;
        ZootopiaSource H1 = H1();
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        ZootopiaSource H12 = H1();
        Bundle bundle = new Bundle();
        bundle.putString("uid", getMCurrentUin());
        bundle.putBoolean("force_return_portal", true);
        Unit unit = Unit.INSTANCE;
        publishEntranceView2.setSource(H1, ZPlanPublishSource.FROM_USER_CENTER, iSchemeApi.buildPageScheme(H12, 8, bundle));
        binding.f419295h.h(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterFragment.ci(UserCenterFragment.this, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ci(UserCenterFragment this$0, dl binding, View view) {
        UserCenterTitleCardData titleData;
        u more;
        String str;
        List<UserCenterCardData> a16;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        String str2 = "";
        if (this$0.ki()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_tab_id", "0");
            Context context = this$0.getContext();
            if (context != null && (string2 = context.getString(R.string.f169844xx2)) != null) {
                str2 = string2;
            }
            linkedHashMap.put("zplan_tab_name", str2);
            ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
            PublishEntranceView publishEntranceView = binding.f419295h;
            Intrinsics.checkNotNullExpressionValue(publishEntranceView, "binding.publishEntrance");
            zplanViewReportHelper.e(publishEntranceView, "em_zplan_publisher_entrance", linkedHashMap);
            binding.f419295h.p();
            return;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("zplan_tab_id", "1");
        Context context2 = this$0.getContext();
        if (context2 != null && (string = context2.getString(R.string.f169843xx1)) != null) {
            str2 = string;
        }
        linkedHashMap2.put("zplan_tab_name", str2);
        ZplanViewReportHelper zplanViewReportHelper2 = this$0.mReporter;
        PublishEntranceView publishEntranceView2 = binding.f419295h;
        Intrinsics.checkNotNullExpressionValue(publishEntranceView2, "binding.publishEntrance");
        zplanViewReportHelper2.e(publishEntranceView2, "em_zplan_publisher_entrance", linkedHashMap2);
        UserCenterReqData userCenterReqData = this$0.reqData;
        UserCenterCardData userCenterCardData = null;
        if (userCenterReqData != null && (a16 = userCenterReqData.a()) != null) {
            Iterator<T> it = a16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((UserCenterCardData) next).getItemType() == 202231) {
                    userCenterCardData = next;
                    break;
                }
            }
            userCenterCardData = userCenterCardData;
        }
        if (userCenterCardData == null || (titleData = userCenterCardData.getTitleData()) == null || (more = titleData.getMore()) == null || (str = more.f427703b) == null) {
            return;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iSchemeApi.launchScheme(requireContext, str);
    }

    private final void di() {
        ScrollingHeaderLayout scrollingHeaderLayout;
        UserCenterReqData userCenterReqData = this.reqData;
        boolean z16 = false;
        if (userCenterReqData != null && userCenterReqData.getIsShowSquare()) {
            z16 = true;
        }
        if (z16 && this.tabView == null) {
            ZPlanTabView zPlanTabView = new ZPlanTabView(getContext());
            this.tabView = zPlanTabView;
            zPlanTabView.setLayoutParams(new LinearLayout.LayoutParams(-1, i.b(42)));
            ZPlanTabView zPlanTabView2 = this.tabView;
            if (zPlanTabView2 != null) {
                ArrayList arrayList = new ArrayList();
                String string = getString(R.string.f169844xx2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zplan_user_center_tab_wear)");
                arrayList.add(new ZPlanTabTitleData(0, string, null, 4, null));
                String string2 = getString(R.string.f169843xx1);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.zplan_user_center_tab_ugc)");
                arrayList.add(new ZPlanTabTitleData(1, string2, null, 4, null));
                zPlanTabView2.setTabData(arrayList);
            }
            ZPlanTabView zPlanTabView3 = this.tabView;
            if (zPlanTabView3 != null) {
                dl dlVar = this.mBinding;
                zPlanTabView3.setViewPager(dlVar != null ? dlVar.f419291d : null);
            }
            dl dlVar2 = this.mBinding;
            if (dlVar2 == null || (scrollingHeaderLayout = dlVar2.f419289b) == null) {
                return;
            }
            scrollingHeaderLayout.addView(this.tabView);
        }
    }

    private final void ei(dl binding) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.userInfoCard = new UserCenterInfoCard(requireContext, this);
        int b16 = i.b(42);
        UserCenterInfoCard userCenterInfoCard = this.userInfoCard;
        if (userCenterInfoCard != null) {
            userCenterInfoCard.setMinimumHeight(Bh() + b16);
        }
        binding.f419289b.addView(this.userInfoCard, 0);
    }

    private final void fi() {
        ZootopiaViewPager zootopiaViewPager;
        if (this.pageAdapter == null) {
            UserCenterReqData userCenterReqData = this.reqData;
            boolean z16 = false;
            if (userCenterReqData != null && userCenterReqData.getIsShowSquare()) {
                z16 = true;
            }
            PagerAdapter Wh = Wh(z16 ? 2 : 1);
            this.pageAdapter = Wh;
            dl dlVar = this.mBinding;
            ZootopiaViewPager zootopiaViewPager2 = dlVar != null ? dlVar.f419291d : null;
            if (zootopiaViewPager2 != null) {
                zootopiaViewPager2.setAdapter(Wh);
            }
            dl dlVar2 = this.mBinding;
            if (dlVar2 == null || (zootopiaViewPager = dlVar2.f419291d) == null) {
                return;
            }
            zootopiaViewPager.addOnPageChangeListener(new d());
        }
    }

    private final boolean handleBackEvent() {
        QLog.i("UserCenterFragment_", 1, "handleBackEvent forceReturnPortal= " + this.forceReturnPortal);
        if (!this.forceReturnPortal) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ZPlanMainRecommendActivity.INSTANCE.b(activity, Ch(), null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(UserCenterFragment this$0, dl binding, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        ImageView imageView = binding.f419290c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backIcon");
        ZplanViewReportHelper.f(zplanViewReportHelper, imageView, "em_zplan_back_btn", null, 4, null);
        if (this$0.handleBackEvent()) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(UserCenterFragment this$0, dl binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iZPlanApi.startSettingActivity(context, IZPlanApi.FROM_QQ_SETTING);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        ImageView imageView = binding.f419297j;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.settingIcon");
        ZplanViewReportHelper.f(zplanViewReportHelper, imageView, "em_zplan_setting_btn", null, 4, null);
    }

    private final void initData() {
        this.mFetcher.c().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserCenterFragment.ai(UserCenterFragment.this, (UserCenterReqData) obj);
            }
        });
        this.mDataRequesting = true;
        this.mFetcher.g(getCurrentUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(UserCenterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qi();
        this$0.mFetcher.g(this$0.getCurrentUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ki() {
        ZootopiaViewPager zootopiaViewPager;
        dl dlVar = this.mBinding;
        if ((dlVar == null || (zootopiaViewPager = dlVar.f419291d) == null || zootopiaViewPager.getCurrentItem() != 0) ? false : true) {
            UserCenterReqData userCenterReqData = this.reqData;
            if (userCenterReqData != null && userCenterReqData.getIsShowSquare()) {
                return true;
            }
        }
        return false;
    }

    private final void li() {
        hu4.f fVar = this.mCurrentPersonInfo;
        if (fVar == null) {
            return;
        }
        dl dlVar = this.mBinding;
        TextView textView = dlVar != null ? dlVar.f419299l : null;
        if (textView == null) {
            return;
        }
        textView.setText(fVar.f406351b);
    }

    private final void mi() {
        dk dkVar;
        ShimmerLinearLayout shimmerLinearLayout;
        dk dkVar2;
        dl dlVar = this.mBinding;
        ShimmerLinearLayout shimmerLinearLayout2 = null;
        ZootopiaLoadFailView zootopiaLoadFailView = dlVar != null ? dlVar.f419293f : null;
        if (zootopiaLoadFailView != null) {
            zootopiaLoadFailView.setVisibility(8);
        }
        dl dlVar2 = this.mBinding;
        ZootopiaViewPager zootopiaViewPager = dlVar2 != null ? dlVar2.f419291d : null;
        if (zootopiaViewPager != null) {
            zootopiaViewPager.setVisibility(0);
        }
        ZPlanTabView zPlanTabView = this.tabView;
        if (zPlanTabView != null) {
            zPlanTabView.setVisibility(0);
        }
        UserCenterInfoCard userCenterInfoCard = this.userInfoCard;
        if (userCenterInfoCard != null) {
            userCenterInfoCard.setVisibility(0);
        }
        dl dlVar3 = this.mBinding;
        if (dlVar3 != null && (dkVar2 = dlVar3.f419294g) != null) {
            shimmerLinearLayout2 = dkVar2.f419287c;
        }
        if (shimmerLinearLayout2 != null) {
            shimmerLinearLayout2.setVisibility(8);
        }
        dl dlVar4 = this.mBinding;
        if (dlVar4 == null || (dkVar = dlVar4.f419294g) == null || (shimmerLinearLayout = dkVar.f419287c) == null) {
            return;
        }
        shimmerLinearLayout.d();
    }

    private final void ni() {
        dl dlVar;
        PublishEntranceView publishEntranceView;
        if (!Qa() || (dlVar = this.mBinding) == null || (publishEntranceView = dlVar.f419295h) == null) {
            return;
        }
        publishEntranceView.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                UserCenterFragment.oi(UserCenterFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(UserCenterFragment this$0) {
        PublishEntranceView publishEntranceView;
        PublishEntranceView publishEntranceView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dl dlVar = this$0.mBinding;
        if (dlVar != null && (publishEntranceView2 = dlVar.f419295h) != null) {
            publishEntranceView2.show();
        }
        dl dlVar2 = this$0.mBinding;
        if (dlVar2 == null || (publishEntranceView = dlVar2.f419295h) == null) {
            return;
        }
        this$0.mReporter.g(publishEntranceView, "em_zplan_publisher_entrance", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void pi() {
        dk dkVar;
        ShimmerLinearLayout shimmerLinearLayout;
        dk dkVar2;
        ZootopiaLoadFailView zootopiaLoadFailView;
        dl dlVar = this.mBinding;
        if (dlVar != null && (zootopiaLoadFailView = dlVar.f419293f) != null) {
            zootopiaLoadFailView.c();
        }
        dl dlVar2 = this.mBinding;
        ShimmerLinearLayout shimmerLinearLayout2 = null;
        ZootopiaLoadFailView zootopiaLoadFailView2 = dlVar2 != null ? dlVar2.f419293f : null;
        if (zootopiaLoadFailView2 != null) {
            zootopiaLoadFailView2.setVisibility(0);
        }
        dl dlVar3 = this.mBinding;
        ZootopiaViewPager zootopiaViewPager = dlVar3 != null ? dlVar3.f419291d : null;
        if (zootopiaViewPager != null) {
            zootopiaViewPager.setVisibility(4);
        }
        ZPlanTabView zPlanTabView = this.tabView;
        if (zPlanTabView != null) {
            zPlanTabView.setVisibility(4);
        }
        UserCenterInfoCard userCenterInfoCard = this.userInfoCard;
        if (userCenterInfoCard != null) {
            userCenterInfoCard.setVisibility(8);
        }
        dl dlVar4 = this.mBinding;
        if (dlVar4 != null && (dkVar2 = dlVar4.f419294g) != null) {
            shimmerLinearLayout2 = dkVar2.f419287c;
        }
        if (shimmerLinearLayout2 != null) {
            shimmerLinearLayout2.setVisibility(8);
        }
        dl dlVar5 = this.mBinding;
        if (dlVar5 == null || (dkVar = dlVar5.f419294g) == null || (shimmerLinearLayout = dkVar.f419287c) == null) {
            return;
        }
        shimmerLinearLayout.d();
    }

    private final void qi() {
        dk dkVar;
        ShimmerLinearLayout shimmerLinearLayout;
        dk dkVar2;
        dk dkVar3;
        RoundCornerImageView roundCornerImageView;
        dk dkVar4;
        RoundCornerImageView roundCornerImageView2;
        dl dlVar = this.mBinding;
        if (dlVar != null && (dkVar4 = dlVar.f419294g) != null && (roundCornerImageView2 = dkVar4.f419286b) != null) {
            roundCornerImageView2.setImageResource(R.drawable.imn);
        }
        dl dlVar2 = this.mBinding;
        if (dlVar2 != null && (dkVar3 = dlVar2.f419294g) != null && (roundCornerImageView = dkVar3.f419286b) != null) {
            RoundCornerImageView.setRadius$default(roundCornerImageView, 0.0f, 0.0f, i.e(16), i.e(16), 3, null);
        }
        dl dlVar3 = this.mBinding;
        ShimmerLinearLayout shimmerLinearLayout2 = null;
        ZootopiaLoadFailView zootopiaLoadFailView = dlVar3 != null ? dlVar3.f419293f : null;
        if (zootopiaLoadFailView != null) {
            zootopiaLoadFailView.setVisibility(8);
        }
        dl dlVar4 = this.mBinding;
        ZootopiaViewPager zootopiaViewPager = dlVar4 != null ? dlVar4.f419291d : null;
        if (zootopiaViewPager != null) {
            zootopiaViewPager.setVisibility(4);
        }
        ZPlanTabView zPlanTabView = this.tabView;
        if (zPlanTabView != null) {
            zPlanTabView.setVisibility(4);
        }
        UserCenterInfoCard userCenterInfoCard = this.userInfoCard;
        if (userCenterInfoCard != null) {
            userCenterInfoCard.setVisibility(8);
        }
        dl dlVar5 = this.mBinding;
        if (dlVar5 != null && (dkVar2 = dlVar5.f419294g) != null) {
            shimmerLinearLayout2 = dkVar2.f419287c;
        }
        if (shimmerLinearLayout2 != null) {
            shimmerLinearLayout2.setVisibility(0);
        }
        dl dlVar6 = this.mBinding;
        if (dlVar6 == null || (dkVar = dlVar6.f419294g) == null || (shimmerLinearLayout = dkVar.f419287c) == null) {
            return;
        }
        shimmerLinearLayout.c();
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    public boolean E3() {
        hu4.f fVar = this.mCurrentPersonInfo;
        if (fVar != null) {
            return fVar.f406369t;
        }
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    public ZootopiaSource H1() {
        return Ch();
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    public boolean Qa() {
        return getMStatus() == 1;
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    public long getCurrentUin() {
        CharSequence trim;
        Long longOrNull;
        trim = StringsKt__StringsKt.trim((CharSequence) this.mCurrentUin);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(trim.toString());
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    /* renamed from: getStatus, reason: from getter */
    public int getMStatus() {
        return this.mStatus;
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    public int getStatusBarHeight() {
        return Bh();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    protected String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_USER_CENTER;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    public boolean j8() {
        return getMStatus() == 2;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return handleBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        ZootopiaPullRefreshLayoutV2 refreshView;
        RecyclerViewXWithHeaderFooter E;
        RecyclerView.Adapter adapter;
        RecyclerViewXWithHeaderFooter E2;
        RecyclerView.Adapter adapter2;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        try {
            UserCenterUgcRecyclerView userCenterUgcRecyclerView = this.ugcRecyclerView;
            if (userCenterUgcRecyclerView != null && (E2 = userCenterUgcRecyclerView.E()) != null && (adapter2 = E2.getAdapter()) != null) {
                adapter2.notifyItemRangeChanged(0, adapter2.getItemCount());
            }
            UserCenterWearPageView userCenterWearPageView = this.wearRecyclerView;
            if (userCenterWearPageView == null || (refreshView = userCenterWearPageView.getRefreshView()) == null || (E = refreshView.E()) == null || (adapter = E.getAdapter()) == null) {
                return;
            }
            adapter.notifyItemRangeChanged(0, adapter.getItemCount());
        } catch (Exception e16) {
            QLog.e("UserCenterFragment_", 1, "refresh error ", e16);
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        Window window;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            r.c(window);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            Xh(intent);
        }
        this.reddotManager.a(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.UserCenterFragment$onCreate$3
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
                jc4.b bVar;
                if (UserCenterFragment.this.Qa()) {
                    bVar = UserCenterFragment.this.mFetcher;
                    bVar.g(UserCenterFragment.this.getCurrentUin());
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        dl g16 = dl.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.mBinding = g16;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch()));
            if (Qa()) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put(SquareReportConst.Key.KEY_ZPLAN_HOST_GUEST_TYPE, str);
            ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
            FrameLayout frameLayout = g16.f419296i;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.root");
            zplanViewReportHelper.a(activity, frameLayout, "pg_zplan_personal_center", hashMap);
        }
        gi(g16);
        qi();
        initData();
        FrameLayout frameLayout2 = g16.f419296i;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.root");
        return frameLayout2;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.reddotManager.c();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mNeedReRequest = true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("UserCenterFragment_", 1, "onResume mNeedReRequest:" + this.mNeedReRequest + ", mDataRequesting:" + this.mDataRequesting);
        if (this.mNeedReRequest && !this.mDataRequesting) {
            this.mNeedReRequest = false;
            this.mFetcher.g(getCurrentUin());
        }
        ag.f373258a.f(new ZootopiaSource(Source.UserCenter, getSubSource(), null, 4, null));
    }

    @Override // com.tencent.sqshow.zootopia.usercenter.fragment.a
    /* renamed from: ua, reason: from getter */
    public String getMCurrentUin() {
        return this.mCurrentUin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(ZootopiaPullRefreshLayoutV2 refreshView) {
        RecyclerViewXWithHeaderFooter E;
        if (refreshView == null || (E = refreshView.E()) == null) {
            return;
        }
        E.addOnScrollListener(new b());
    }

    @Override // com.tencent.mobileqq.zootopia.api.c
    public boolean J5(KeyEvent event) {
        if (event != null && event.getKeyCode() == 4) {
            return handleBackEvent();
        }
        return false;
    }

    private final void gi(final dl binding) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        binding.f419298k.setPadding(0, CommonExKt.e(activity), 0, 0);
        binding.f419290c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterFragment.hi(UserCenterFragment.this, binding, activity, view);
            }
        });
        ImageView imageView = binding.f419297j;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.settingIcon");
        aa.f(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterFragment.ii(UserCenterFragment.this, binding, view);
            }
        }, 500L, getMCurrentUin());
        binding.f419297j.setVisibility(8);
        ei(binding);
        bi(binding);
        binding.f419289b.b(new e());
        aa.f(binding.f419293f.getBtnNetworkError(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterFragment.ji(UserCenterFragment.this, view);
            }
        }, 500L, getMCurrentUin());
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        ImageView imageView2 = binding.f419290c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.backIcon");
        zplanViewReportHelper.g(imageView2, "em_zplan_back_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper zplanViewReportHelper2 = this.mReporter;
        ImageView imageView3 = binding.f419297j;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.settingIcon");
        zplanViewReportHelper2.g(imageView3, "em_zplan_setting_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/fragment/UserCenterFragment$d", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ViewPager.OnPageChangeListener {
        d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            PublishEntranceView publishEntranceView;
            if (UserCenterFragment.this.ki() || UserCenterFragment.this.E3()) {
                dl dlVar = UserCenterFragment.this.mBinding;
                publishEntranceView = dlVar != null ? dlVar.f419295h : null;
                if (publishEntranceView == null) {
                    return;
                }
                publishEntranceView.setVisibility(0);
                return;
            }
            dl dlVar2 = UserCenterFragment.this.mBinding;
            publishEntranceView = dlVar2 != null ? dlVar2.f419295h : null;
            if (publishEntranceView == null) {
                return;
            }
            publishEntranceView.setVisibility(8);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
