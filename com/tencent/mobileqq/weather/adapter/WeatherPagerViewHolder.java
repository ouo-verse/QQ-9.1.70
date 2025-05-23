package com.tencent.mobileqq.weather.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.image.URLDrawable;
import com.tencent.jungle.weather.proto.WeatherInfo$Weather;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.weather.event.WeatherBannerTitleShowEvent;
import com.tencent.mobileqq.weather.event.WeatherScrollStateChanged;
import com.tencent.mobileqq.weather.event.WeatherTitleBgChangeEvent;
import com.tencent.mobileqq.weather.event.WeatherViewPageSelectChangeEvent;
import com.tencent.mobileqq.weather.part.WeatherPendantView;
import com.tencent.mobileqq.weather.part.WeatherRefreshHeader;
import com.tencent.mobileqq.weather.part.WeatherTianShuPushMaskView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 x2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001yB\u000f\u0012\u0006\u0010u\u001a\u000200\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0016\u0010\u001f\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010'\u001a\u00020&H\u0002J\u001e\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0019J\b\u0010-\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0019H\u0016J\u0010\u00103\u001a\u0004\u0018\u0001022\u0006\u00101\u001a\u000200J\u0006\u00105\u001a\u000204J\u0012\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030908H\u0016J\b\u0010;\u001a\u00020\u0006H\u0007R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010GR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R:\u0010b\u001a&\u0012\f\u0012\n a*\u0004\u0018\u00010`0` a*\u0012\u0012\f\u0012\n a*\u0004\u0018\u00010`0`\u0018\u00010\u00140_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010eR\u0016\u0010i\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010eR\u0016\u0010j\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010eR\u0016\u0010k\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010eR\u0016\u0010l\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010gR\u0016\u0010m\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010eR\"\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020\r0n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010pR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001b0n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010pR\"\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00140n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010pR\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u001b0n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010p\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/WeatherPagerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initLayout", "initObserver", "requestFirstScreenAd", "requestTianShuAd", "requestTianShuMask", "assembleAdapterList", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "weatherReply", "initData", "weather", "updateHeaderBg", "initItemList", "handWeatherData", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAds", "handFirstScreenAdData", "gdtAd", "", "showMaskAd", "Lcom/tencent/mobileqq/weather/data/o;", "dataItem", "handlePendantData", VideoTemplateParser.ITEM_LIST, "handleRecommendBannerData", "handleTianShuPushDialogData", "", "position", "notifyItemChangedSafely", "notifyDataSetChangedSafely", "returnPageTop", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "pagePosition", "onlyUpdateWeatherData", "bind", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "Landroid/view/View;", "view", "Landroid/app/Activity;", "getActivityFromView", "Lcom/tencent/mobileqq/weather/mvvm/c;", "getAdViewModel", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onLifecycleDestroy", "Landroid/widget/FrameLayout;", "mPageViewContainer", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/widget/ImageView;", "mBackTopBtn", "Landroid/widget/ImageView;", "Lcom/tencent/mobileqq/weather/part/WeatherPendantView;", "mPendant", "Lcom/tencent/mobileqq/weather/part/WeatherPendantView;", "mHeaderBg", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Lcom/tencent/mobileqq/weather/adapter/m;", "mListAdapter", "Lcom/tencent/mobileqq/weather/adapter/m;", "Lcom/tencent/mobileqq/weather/adapter/n;", "mMainLoadMoreAdapter", "Lcom/tencent/mobileqq/weather/adapter/n;", "Lcom/tencent/mobileqq/weather/mvvm/f;", "mMainViewModel", "Lcom/tencent/mobileqq/weather/mvvm/f;", "Lcom/tencent/mobileqq/weather/mvvm/i;", "mTianShuModel", "Lcom/tencent/mobileqq/weather/mvvm/i;", "mAdViewModel", "Lcom/tencent/mobileqq/weather/mvvm/c;", "mDefaultWeatherReply", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "", "Lcom/tencent/mobileqq/weather/data/k;", "kotlin.jvm.PlatformType", "mItemList", "Ljava/util/List;", "mIsOnlyUpdateWeatherData", "Z", "mAdCode", "I", "mNeedShowAdMask", "mAdMaskShowIng", "mTianShuMaskShowIng", "mIsTianShuMaskRequested", "mPagePosition", "mIsTopVideoFullyVisible", "Landroidx/lifecycle/Observer;", "mAdObserver", "Landroidx/lifecycle/Observer;", "mMainWeatherObserver", "mPendantObserver", "mRecommendBannerObserver", "mTianShuPushDialogObserver", "itemView", "<init>", "(Landroid/view/View;)V", "Companion", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherPagerViewHolder extends RecyclerView.ViewHolder implements SimpleEventReceiver<SimpleBaseEvent>, LifecycleObserver, ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int POS_AD_FIRST = 3;
    private static final int POS_AD_SECOND = 6;
    private static final int POS_ALMANAC = 5;
    private static final int POS_BASE = 0;
    private static final int POS_CONSTELLATION = 7;
    private static final int POS_DAY_FORECAST = 4;
    private static final int POS_HOUR_FORECAST = 1;
    private static final int POS_QUOTE = 8;
    private static final int POS_RECOMMEND_BANNER = 10;
    private static final int POS_RECOMMEND_BANNER_TITLE = 9;
    private static final int POS_TOMORROW_CARE = 2;
    private static final int POS_TOP_VIDEO = 0;

    @NotNull
    private static final String TAG = "WeatherPagerViewHolder";
    private int mAdCode;
    private volatile boolean mAdMaskShowIng;

    @NotNull
    private Observer<List<GdtAd>> mAdObserver;

    @NotNull
    private com.tencent.mobileqq.weather.mvvm.c mAdViewModel;

    @Nullable
    private ImageView mBackTopBtn;
    private RFWConcatAdapter mConcatAdapter;

    @NotNull
    private final weather$GetConcernWeatherReply mDefaultWeatherReply;

    @Nullable
    private ImageView mHeaderBg;
    private boolean mIsOnlyUpdateWeatherData;
    private boolean mIsTianShuMaskRequested;
    private boolean mIsTopVideoFullyVisible;
    private List<com.tencent.mobileqq.weather.data.k> mItemList;
    private m mListAdapter;

    @Nullable
    private n mMainLoadMoreAdapter;

    @NotNull
    private final com.tencent.mobileqq.weather.mvvm.f mMainViewModel;

    @NotNull
    private Observer<weather$GetConcernWeatherReply> mMainWeatherObserver;
    private boolean mNeedShowAdMask;
    private int mPagePosition;

    @Nullable
    private FrameLayout mPageViewContainer;

    @Nullable
    private WeatherPendantView mPendant;

    @NotNull
    private Observer<com.tencent.mobileqq.weather.data.o> mPendantObserver;

    @NotNull
    private Observer<List<com.tencent.mobileqq.weather.data.o>> mRecommendBannerObserver;

    @Nullable
    private RecyclerView mRecyclerView;

    @Nullable
    private SmartRefreshLayout mRefreshLayout;
    private volatile boolean mTianShuMaskShowIng;

    @NotNull
    private final com.tencent.mobileqq.weather.mvvm.i mTianShuModel;

    @NotNull
    private Observer<com.tencent.mobileqq.weather.data.o> mTianShuPushDialogObserver;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/WeatherPagerViewHolder$a;", "", "", "POS_AD_FIRST", "I", "POS_AD_SECOND", "POS_ALMANAC", "POS_BASE", "POS_CONSTELLATION", "POS_DAY_FORECAST", "POS_HOUR_FORECAST", "POS_QUOTE", "POS_RECOMMEND_BANNER", "POS_RECOMMEND_BANNER_TITLE", "POS_TOMORROW_CARE", "POS_TOP_VIDEO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.adapter.WeatherPagerViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/weather/adapter/WeatherPagerViewHolder$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f313237d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeatherPagerViewHolder f313238e;

        b(RecyclerView recyclerView, WeatherPagerViewHolder weatherPagerViewHolder) {
            this.f313237d = recyclerView;
            this.f313238e = weatherPagerViewHolder;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) weatherPagerViewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            WeatherPendantView weatherPendantView;
            View findViewByPosition;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            RecyclerView.LayoutManager layoutManager = this.f313237d.getLayoutManager();
            boolean z16 = false;
            if (layoutManager != null && (findViewByPosition = layoutManager.findViewByPosition(0)) != null) {
                Rect rect = new Rect();
                findViewByPosition.getGlobalVisibleRect(rect);
                if (rect.height() == findViewByPosition.getHeight()) {
                    z16 = true;
                }
            }
            if (z16 != this.f313238e.mIsTopVideoFullyVisible) {
                this.f313238e.mIsTopVideoFullyVisible = z16;
                SimpleEventBus.getInstance().dispatchEvent(new WeatherTitleBgChangeEvent(z16));
            }
            if (newState != 0) {
                if (newState == 1 && (weatherPendantView = this.f313238e.mPendant) != null) {
                    weatherPendantView.j();
                    return;
                }
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new WeatherScrollStateChanged(this.f313238e.mPagePosition));
            WeatherPendantView weatherPendantView2 = this.f313238e.mPendant;
            if (weatherPendantView2 != null) {
                weatherPendantView2.i();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
            } else {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/weather/adapter/WeatherPagerViewHolder$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherPagerViewHolder.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            MutableLiveData<weather$GetConcernWeatherReply> L1 = WeatherPagerViewHolder.this.mMainViewModel.L1();
            Object context = WeatherPagerViewHolder.this.itemView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            L1.observe((LifecycleOwner) context, WeatherPagerViewHolder.this.mMainWeatherObserver);
            WeatherPagerViewHolder.this.requestFirstScreenAd();
            WeatherPagerViewHolder.this.requestTianShuAd();
            SimpleEventBus.getInstance().registerReceiver(WeatherPagerViewHolder.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            WeatherPagerViewHolder.this.mMainViewModel.L1().removeObserver(WeatherPagerViewHolder.this.mMainWeatherObserver);
            WeatherPagerViewHolder.this.mAdViewModel.M1().removeObserver(WeatherPagerViewHolder.this.mAdObserver);
            SimpleEventBus.getInstance().unRegisterReceiver(WeatherPagerViewHolder.this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherPagerViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        this.mMainViewModel = new com.tencent.mobileqq.weather.mvvm.f();
        this.mTianShuModel = new com.tencent.mobileqq.weather.mvvm.i();
        this.mDefaultWeatherReply = new weather$GetConcernWeatherReply();
        this.mItemList = Collections.synchronizedList(new ArrayList());
        this.mIsTopVideoFullyVisible = true;
        this.mAdObserver = new Observer() { // from class: com.tencent.mobileqq.weather.adapter.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherPagerViewHolder.mAdObserver$lambda$0(WeatherPagerViewHolder.this, (List) obj);
            }
        };
        this.mMainWeatherObserver = new Observer() { // from class: com.tencent.mobileqq.weather.adapter.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherPagerViewHolder.mMainWeatherObserver$lambda$1(WeatherPagerViewHolder.this, (weather$GetConcernWeatherReply) obj);
            }
        };
        this.mPendantObserver = new Observer() { // from class: com.tencent.mobileqq.weather.adapter.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherPagerViewHolder.mPendantObserver$lambda$2(WeatherPagerViewHolder.this, (com.tencent.mobileqq.weather.data.o) obj);
            }
        };
        this.mRecommendBannerObserver = new Observer() { // from class: com.tencent.mobileqq.weather.adapter.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherPagerViewHolder.mRecommendBannerObserver$lambda$3(WeatherPagerViewHolder.this, (List) obj);
            }
        };
        this.mTianShuPushDialogObserver = new Observer() { // from class: com.tencent.mobileqq.weather.adapter.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherPagerViewHolder.mTianShuPushDialogObserver$lambda$4(WeatherPagerViewHolder.this, (com.tencent.mobileqq.weather.data.o) obj);
            }
        };
        this.mAdViewModel = getAdViewModel();
        initLayout();
        initObserver();
    }

    private final void assembleAdapterList() {
        m mVar = new m();
        mVar.setHasStableIds(true);
        this.mListAdapter = mVar;
        n nVar = new n();
        nVar.setHasStableIds(true);
        if (!this.mIsOnlyUpdateWeatherData) {
            nVar.registerLoadMoreListener(this);
        }
        this.mMainLoadMoreAdapter = nVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        m mVar2 = this.mListAdapter;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            mVar2 = null;
        }
        adapterArr[0] = mVar2;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        this.mConcatAdapter = rFWConcatAdapter;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(rFWConcatAdapter);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LifecycleOwner getLifecycleOwner(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    private final void handFirstScreenAdData(List<? extends GdtAd> gdtAds) {
        boolean showMaskAd;
        boolean z16;
        com.tencent.mobileqq.weather.data.a aVar = new com.tencent.mobileqq.weather.data.a(this.mDefaultWeatherReply, this.mPagePosition, 1);
        com.tencent.mobileqq.weather.data.a aVar2 = new com.tencent.mobileqq.weather.data.a(this.mDefaultWeatherReply, this.mPagePosition, 2);
        if (gdtAds.isEmpty()) {
            aVar.j(new GdtAd(), true);
            aVar2.j(new GdtAd(), true);
            z16 = true;
        } else {
            if (gdtAds.size() == 1) {
                GdtAd gdtAd = gdtAds.get(0);
                aVar.i(gdtAd);
                aVar2.j(new GdtAd(), true);
                showMaskAd = showMaskAd(gdtAd);
            } else {
                GdtAd gdtAd2 = gdtAds.get(0);
                aVar.i(gdtAd2);
                aVar2.i(gdtAds.get(1));
                showMaskAd = showMaskAd(gdtAd2);
            }
            z16 = !showMaskAd;
        }
        this.mItemList.set(3, aVar);
        this.mItemList.set(6, aVar2);
        notifyItemChangedSafely(3);
        notifyItemChangedSafely(6);
        QLog.d(TAG, 1, "canShowTianShuMask:", Boolean.valueOf(z16));
        if (z16 && this.mPagePosition == 0) {
            requestTianShuMask();
        }
        QLog.d(TAG, 1, "handFirstScreenAdData pagePos:", Integer.valueOf(this.mPagePosition));
    }

    private final void handWeatherData(weather$GetConcernWeatherReply weather) {
        this.mItemList.set(0, new com.tencent.mobileqq.weather.data.t(weather, this.mPagePosition));
        this.mItemList.set(1, new com.tencent.mobileqq.weather.data.i(weather, this.mPagePosition));
        this.mItemList.set(2, new com.tencent.mobileqq.weather.data.q(weather, this.mPagePosition));
        this.mItemList.set(4, new com.tencent.mobileqq.weather.data.g(weather, this.mPagePosition));
        this.mItemList.set(8, new com.tencent.mobileqq.weather.data.l(weather, this.mPagePosition));
        this.mItemList.set(5, new com.tencent.mobileqq.weather.data.b(weather, this.mPagePosition));
        this.mItemList.set(7, new com.tencent.mobileqq.weather.data.e(weather, this.mPagePosition));
        notifyDataSetChangedSafely();
        com.tencent.mobileqq.weather.util.h.f313657a.b();
    }

    private final void handlePendantData(com.tencent.mobileqq.weather.data.o dataItem) {
        WeatherPendantView weatherPendantView;
        if (this.mPagePosition == 0 && (weatherPendantView = this.mPendant) != null) {
            weatherPendantView.e(dataItem);
        }
    }

    private final void handleRecommendBannerData(List<com.tencent.mobileqq.weather.data.o> itemList) {
        com.tencent.mobileqq.weather.data.n nVar = new com.tencent.mobileqq.weather.data.n(this.mDefaultWeatherReply, this.mPagePosition);
        nVar.f(itemList);
        this.mItemList.set(10, nVar);
        notifyItemChangedSafely(10);
    }

    private final void handleTianShuPushDialogData(com.tencent.mobileqq.weather.data.o dataItem) {
        if (!this.mTianShuMaskShowIng && !this.mAdMaskShowIng && !TextUtils.isEmpty(dataItem.n()) && this.mPagePosition == 0) {
            this.mTianShuMaskShowIng = true;
            if (this.mPageViewContainer != null) {
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                View rootView = this.itemView.getRootView();
                Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                new WeatherTianShuPushMaskView(context, (ViewGroup) rootView, dataItem, null, 8, null).q();
            }
        }
    }

    private final void initData(weather$GetConcernWeatherReply weatherReply) {
        QLog.d(TAG, 1, "initData pagePos:", Integer.valueOf(this.mPagePosition));
        initItemList(weatherReply);
        updateHeaderBg(weatherReply);
        this.mAdCode = weatherReply.weather.adcode.get();
        if (this.mPagePosition == 0) {
            com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
            WeatherInfo$Weather weatherInfo$Weather = weatherReply.weather;
            Intrinsics.checkNotNullExpressionValue(weatherInfo$Weather, "weatherReply.weather");
            String v3 = gVar.v(weatherInfo$Weather);
            if (!TextUtils.isEmpty(v3)) {
                com.tencent.mobileqq.weather.data.f.f313296a.t(v3);
            }
        }
    }

    private final void initItemList(weather$GetConcernWeatherReply weatherReply) {
        List<com.tencent.mobileqq.weather.data.k> mutableListOf;
        List<com.tencent.mobileqq.weather.data.k> mItemList = this.mItemList;
        Intrinsics.checkNotNullExpressionValue(mItemList, "mItemList");
        if (!mItemList.isEmpty()) {
            handWeatherData(weatherReply);
        } else {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.weather.data.t(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.i(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.q(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.a(weatherReply, this.mPagePosition, 1), new com.tencent.mobileqq.weather.data.g(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.b(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.a(weatherReply, this.mPagePosition, 2), new com.tencent.mobileqq.weather.data.e(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.l(weatherReply, this.mPagePosition), new com.tencent.mobileqq.weather.data.p(weatherReply, this.mPagePosition, 2), new com.tencent.mobileqq.weather.data.n(weatherReply, this.mPagePosition));
            this.mItemList = mutableListOf;
        }
        m mVar = this.mListAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            mVar = null;
        }
        mVar.setItems(this.mItemList);
    }

    private final void initLayout() {
        View view = this.itemView;
        this.mPageViewContainer = (FrameLayout) view.findViewById(R.id.f121317ax);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.itemView.findViewById(R.id.f86434rn);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.weather.adapter.u
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                WeatherPagerViewHolder.initLayout$lambda$11$lambda$6$lambda$5(WeatherPagerViewHolder.this, iRefreshLayout);
            }
        });
        this.mRefreshLayout = smartRefreshLayout;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f120967_z);
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView.addOnScrollListener(new b(recyclerView, this));
        this.mRecyclerView = recyclerView;
        ImageView imageView = (ImageView) view.findViewById(R.id.f120797_i);
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(imageView, "findViewById<ImageView>(\u2026id.weather_back_top_icon)");
            imageView.setImageDrawable(com.tencent.mobileqq.weather.util.b.e("https://qq-weather.cdn-go.cn/hippy-weather/latest/back-top.png"));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.adapter.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WeatherPagerViewHolder.initLayout$lambda$11$lambda$10$lambda$9(WeatherPagerViewHolder.this, view2);
                }
            });
        } else {
            imageView = null;
        }
        this.mBackTopBtn = imageView;
        this.mPendant = (WeatherPendantView) view.findViewById(R.id.f121327ay);
        View findViewById = view.findViewById(R.id.f86424rm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.smart_refresh_header)");
        this.mHeaderBg = (ImageView) ((WeatherRefreshHeader) findViewById).findViewById(R.id.f72243qb);
        assembleAdapterList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$11$lambda$10$lambda$9(WeatherPagerViewHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.returnPageTop();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$11$lambda$6$lambda$5(WeatherPagerViewHolder this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.mMainViewModel.M1(this$0.mAdCode);
        this$0.mAdViewModel.P1(false, true, this$0.mPagePosition);
        com.tencent.mobileqq.weather.util.report.r.f313695a.b(this$0.mPagePosition);
    }

    private final void initObserver() {
        Lifecycle lifecycle;
        this.itemView.addOnAttachStateChangeListener(new c());
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        LifecycleOwner lifecycleOwner = getLifecycleOwner(context);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAdObserver$lambda$0(WeatherPagerViewHolder this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.handFirstScreenAdData(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mMainWeatherObserver$lambda$1(WeatherPagerViewHolder this$0, weather$GetConcernWeatherReply it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "Observe weather data changed, pagePos:", Integer.valueOf(this$0.mPagePosition));
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.handWeatherData(it);
        this$0.updateHeaderBg(it);
        SmartRefreshLayout smartRefreshLayout = this$0.mRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
        this$0.mAdCode = it.weather.adcode.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPendantObserver$lambda$2(WeatherPagerViewHolder this$0, com.tencent.mobileqq.weather.data.o oVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handlePendantData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRecommendBannerObserver$lambda$3(WeatherPagerViewHolder this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.handleRecommendBannerData(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mTianShuPushDialogObserver$lambda$4(WeatherPagerViewHolder this$0, com.tencent.mobileqq.weather.data.o it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.handleTianShuPushDialogData(it);
    }

    private final void notifyDataSetChangedSafely() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            boolean z16 = false;
            if (recyclerView != null && recyclerView.isComputingLayout()) {
                z16 = true;
            }
            if (z16) {
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.weather.adapter.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            WeatherPagerViewHolder.notifyDataSetChangedSafely$lambda$17(WeatherPagerViewHolder.this);
                        }
                    });
                    return;
                }
                return;
            }
        }
        m mVar = this.mListAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            mVar = null;
        }
        mVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyDataSetChangedSafely$lambda$17(WeatherPagerViewHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m mVar = this$0.mListAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            mVar = null;
        }
        mVar.notifyDataSetChanged();
    }

    private final void notifyItemChangedSafely(final int position) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            boolean z16 = false;
            if (recyclerView != null && recyclerView.isComputingLayout()) {
                z16 = true;
            }
            if (z16) {
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.weather.adapter.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            WeatherPagerViewHolder.notifyItemChangedSafely$lambda$16(WeatherPagerViewHolder.this, position);
                        }
                    });
                    return;
                }
                return;
            }
        }
        m mVar = this.mListAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            mVar = null;
        }
        mVar.notifyItemChanged(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemChangedSafely$lambda$16(WeatherPagerViewHolder this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m mVar = this$0.mListAdapter;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            mVar = null;
        }
        mVar.notifyItemChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFirstScreenAd() {
        MutableLiveData<List<GdtAd>> M1 = this.mAdViewModel.M1();
        Object context = this.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        M1.observe((LifecycleOwner) context, this.mAdObserver);
        this.mAdViewModel.P1(false, false, this.mPagePosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestTianShuAd() {
        if (this.mPagePosition == 0 && !this.mIsOnlyUpdateWeatherData && com.tencent.mobileqq.weather.util.g.f313646a.k() != 2) {
            MutableLiveData<com.tencent.mobileqq.weather.data.o> N1 = this.mTianShuModel.N1();
            Object context = this.itemView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            N1.observe((LifecycleOwner) context, this.mPendantObserver);
            MutableLiveData<List<com.tencent.mobileqq.weather.data.o>> P1 = this.mTianShuModel.P1();
            Object context2 = this.itemView.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            P1.observe((LifecycleOwner) context2, this.mRecommendBannerObserver);
            this.mTianShuModel.Q1();
        }
    }

    private final void requestTianShuMask() {
        if (this.mIsTianShuMaskRequested) {
            return;
        }
        this.mIsTianShuMaskRequested = true;
        if (!SimpleUIUtil.isNowElderMode() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d(TAG, 1, "requestTianShuMask page:", Integer.valueOf(this.mPagePosition));
            MutableLiveData<com.tencent.mobileqq.weather.data.o> O1 = this.mTianShuModel.O1();
            Object context = this.itemView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            O1.observe((LifecycleOwner) context, this.mTianShuPushDialogObserver);
            this.mTianShuModel.R1();
            return;
        }
        QLog.d(TAG, 1, "requestTianShuMask return: elder or study mode");
    }

    private final void returnPageTop() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    private final boolean showMaskAd(GdtAd gdtAd) {
        if (!this.mNeedShowAdMask || this.mAdMaskShowIng || !MaskAdClickHelper.INSTANCE.isMaskAd(gdtAd.getInnerShowType())) {
            return false;
        }
        QLog.d(TAG, 1, "showMaskAd");
        this.mAdMaskShowIng = true;
        com.tencent.mobileqq.weather.util.f fVar = com.tencent.mobileqq.weather.util.f.f313645a;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        com.tencent.mobileqq.weather.util.g.f313646a.Q(MaskAdvName.QQ_WEATHER, AdHippyFragment.MASK_AD_DISPLAY_REQUEST_SUCCESS, fVar.d(getActivityFromView(itemView), gdtAd, this.mAdViewModel.N1().getValue()));
        return true;
    }

    private final void updateHeaderBg(weather$GetConcernWeatherReply weather) {
        Drawable colorDrawable;
        String str = weather.config.pulldownRefreshPicPath.get();
        if (TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
            str = gVar.o(weather.weather.weather_info.concrete_type.get(), ".png", gVar.E(weather.weather));
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ImageView imageView = this.mHeaderBg;
        if (imageView == null || (colorDrawable = imageView.getDrawable()) == null) {
            colorDrawable = new ColorDrawable(0);
        }
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mRequestWidth = ViewUtils.dip2px(375.0f);
        obtain.mRequestHeight = ViewUtils.dip2px(206.0f);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(imgUrl, options)");
        ImageView imageView2 = this.mHeaderBg;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public final void bind(int pagePosition, @NotNull weather$GetConcernWeatherReply weatherReply, boolean onlyUpdateWeatherData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(pagePosition), weatherReply, Boolean.valueOf(onlyUpdateWeatherData));
            return;
        }
        Intrinsics.checkNotNullParameter(weatherReply, "weatherReply");
        QLog.e(TAG, 1, "bind data pagePosition:", Integer.valueOf(pagePosition));
        this.mPagePosition = pagePosition;
        if (pagePosition == 0 && ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).isShowMaskAdForWeather()) {
            z16 = true;
        }
        this.mNeedShowAdMask = z16;
        this.mIsOnlyUpdateWeatherData = onlyUpdateWeatherData;
        initData(weatherReply);
    }

    @Nullable
    public final Activity getActivityFromView(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Activity) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.weather.mvvm.c getAdViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.weather.mvvm.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.mPagePosition == 0) {
            return com.tencent.mobileqq.weather.mvvm.d.E;
        }
        return new com.tencent.mobileqq.weather.mvvm.c();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherViewPageSelectChangeEvent.class, WeatherBannerTitleShowEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy() {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d(TAG, 2, "onLifecycleDestroy");
        this.mAdViewModel.clear();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        LifecycleOwner lifecycleOwner = getLifecycleOwner(context);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if (event instanceof WeatherViewPageSelectChangeEvent) {
            WeatherViewPageSelectChangeEvent weatherViewPageSelectChangeEvent = (WeatherViewPageSelectChangeEvent) event;
            if (this.mPagePosition == weatherViewPageSelectChangeEvent.getPagePosition()) {
                int lastPagePosition = weatherViewPageSelectChangeEvent.getLastPagePosition();
                int i3 = this.mPagePosition;
                if (lastPagePosition != i3) {
                    this.mAdViewModel.P1(false, true, i3);
                    SimpleEventBus.getInstance().dispatchEvent(new WeatherTitleBgChangeEvent(this.mIsTopVideoFullyVisible));
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof WeatherBannerTitleShowEvent) {
            notifyItemChangedSafely(9);
        }
    }
}
