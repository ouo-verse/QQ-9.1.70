package com.tencent.mobileqq.search.searchdetail.content.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.qqmc.SearchQQMC;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.base.c;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreState;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreType;
import com.tencent.mobileqq.search.searchdetail.content.repo.PullToRefreshState;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.content.repo.c;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailTroopTabViewModel;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SortRule;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppExposeReportManager;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppStayReportManager;
import com.tencent.mobileqq.search.searchdetail.eventbus.CancelCorrectionEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.ContentScrollStateChangeEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.ModifyCorrectionWordEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.QSearchPostEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.SearchWithNewQueryEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartScrollingView;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\t*\u0002rx\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0001\u007fB-\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00108\u001a\u00020\u000f\u00a2\u0006\u0004\b|\u0010}J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0012\u0010!\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020(H\u0002R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010;R\u0016\u0010_\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R \u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00190`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0017\u0010q\u001a\u00020l8\u0006\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010XR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010z\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/search/tux/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "onPartResume", "onPartPause", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "removeTuxItem", "da", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", LocaleUtils.L_JAPANESE, "", "isPullToRefresh", "ta", "ma", "ra", "pa", "", "count", "qa", "", "renderStartTime", "wa", "xa", "na", "ua", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/c$a;", "sa", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lcom/tencent/mobileqq/search/tux/b;", "f", "Lcom/tencent/mobileqq/search/tux/b;", "searchTuxStatisticIoc", tl.h.F, "Ljava/lang/String;", "miniAppSessionId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPullToRefreshing", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isLoadingMore", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/search/searchdetail/content/base/e;", "E", "Lcom/tencent/mobileqq/search/searchdetail/content/base/e;", "searchResultListAdapter", "Lmp2/b;", UserInfo.SEX_FEMALE, "Lmp2/b;", "loadMoreAdapter", "Lcom/tencent/mobileqq/search/searchdetail/content/part/u;", "G", "Lcom/tencent/mobileqq/search/searchdetail/content/part/u;", "videoPlayController", "Ljava/util/concurrent/ConcurrentHashMap;", "H", "Ljava/util/concurrent/ConcurrentHashMap;", "pageCacheData", "Lu60/c;", "I", "Lu60/c;", "searchPageReporter", "J", "isFirstFrameRecorded", "K", "Z", "enableShowTux", "Lkotlin/Function1;", "L", "Lkotlin/jvm/functions/Function1;", "tuxItemPredicate", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager;", "M", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppExposeReportManager;", "wxMiniAppExposeReportManager", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppStayReportManager;", "N", "Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/report/SearchWXMiniAppStayReportManager;", "wxMiniAppStayReportManager", "Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "P", "Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "la", "()Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "dtReport", "com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$e", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart$e;", "reportParamIoc", BdhLogUtil.LogTag.Tag_Req, "curLoadMoreIndex", "com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$f", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/search/searchdetail/content/part/ContentPart$f;", "scrollListener", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/search/tux/b;Ljava/lang/String;)V", "T", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ContentPart extends Part implements com.tencent.mobileqq.search.tux.a {

    /* renamed from: C, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.search.searchdetail.content.base.e searchResultListAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private mp2.b loadMoreAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private u videoPlayController;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> pageCacheData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final u60.c searchPageReporter;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isFirstFrameRecorded;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean enableShowTux;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Function1<com.tencent.mobileqq.search.searchdetail.c, Boolean> tuxItemPredicate;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private SearchWXMiniAppExposeReportManager wxMiniAppExposeReportManager;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private SearchWXMiniAppStayReportManager wxMiniAppStayReportManager;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.base.c dtReport;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final e reportParamIoc;

    /* renamed from: R, reason: from kotlin metadata */
    private int curLoadMoreIndex;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final f scrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.search.tux.b searchTuxStatisticIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String miniAppSessionId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isPullToRefreshing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isLoadingMore;

    @Metadata(d1 = {"\u0000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$H\u0016J(\u0010+\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0004H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0004H\u0016J\n\u00100\u001a\u0004\u0018\u00010/H\u0016\u00a8\u00061"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$b", "Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecyclerOwner", "", "getKeyword", "getTabName", "", "getTabMask", "", "getQuerySource", "getUserSource", "getPageMode", "getSessionId", "getSugTraceId", "", "c", "", "", "getPageCacheMap", "getStartSearchTimeStamps", "getAllItemNums", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "getPageType", "getMiniAppSessionId", "correctionQuery", "", "d", "originKeyword", "g", "query", "b", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "Lorg/json/JSONObject;", "f", "Lcom/tencent/mobileqq/search/searchdetail/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "guildId", "docId", "likeStatus", "currentTraceId", tl.h.F, "e", "clickId", "onClickMiniApp", "", "i", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.search.searchdetail.content.base.c {
        b() {
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public void a(@NotNull com.tencent.mobileqq.search.searchdetail.c item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof com.tencent.mobileqq.search.searchdetail.content.model.a) {
                u uVar = ContentPart.this.videoPlayController;
                RecyclerView recyclerView = null;
                if (uVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoPlayController");
                    uVar = null;
                }
                RecyclerView recyclerView2 = ContentPart.this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView2;
                }
                uVar.f(recyclerView, (com.tencent.mobileqq.search.searchdetail.content.model.a) item);
            }
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public void b(@NotNull String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            c.a.a(this, query);
            SimpleEventBus.getInstance().dispatchEvent(new SearchWithNewQueryEvent(query));
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                pageData.n(query);
            }
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public boolean c() {
            if (SearchDetailFragment.Companion.PageMode.INSTANCE.a(getPageMode()) || ap2.b.INSTANCE.a().getExpandAICard()) {
                return false;
            }
            return !ContentPart.this.pa();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public void d(@NotNull String correctionQuery) {
            Intrinsics.checkNotNullParameter(correctionQuery, "correctionQuery");
            QLog.d("QQSearch.NetDetail.ContentPart", 1, " onCorrectionQuery keyword=correctionQuery");
            SimpleEventBus.getInstance().dispatchEvent(new ModifyCorrectionWordEvent(correctionQuery));
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                pageData.m(true);
            }
            SearchDetailTabContentFragment.PageData pageData2 = ContentPart.this.viewModel.getPageData();
            if (pageData2 != null) {
                pageData2.n(correctionQuery);
            }
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public void e(long guildId, @NotNull String docId, @NotNull String currentTraceId) {
            Intrinsics.checkNotNullParameter(docId, "docId");
            Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
            ContentPart.this.viewModel.K2(guildId, docId, currentTraceId, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        @NotNull
        public JSONObject f() {
            String str;
            Object firstOrNull;
            List listOf;
            String joinToString$default;
            byte b16;
            JSONObject jSONObject = new JSONObject();
            if (ContentPart.this.viewModel instanceof SearchDetailTroopTabViewModel) {
                SortRule W2 = ((SearchDetailTroopTabViewModel) ContentPart.this.viewModel).W2();
                if (W2 == null || (str = W2.getText()) == null) {
                    str = "\u667a\u80fd\u6392\u5e8f";
                }
                jSONObject.put("sort_type", str);
                ArrayList<String> arrayList = ((SearchDetailTroopTabViewModel) ContentPart.this.viewModel).getGroupFilter().tags;
                Intrinsics.checkNotNullExpressionValue(arrayList, "viewModel.groupFilter.tags");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                String str2 = (String) firstOrNull;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("tag_type", str2);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{((SearchDetailTroopTabViewModel) ContentPart.this.viewModel).getGroupFilter().geoInfo.province, ((SearchDetailTroopTabViewModel) ContentPart.this.viewModel).getGroupFilter().geoInfo.city, ((SearchDetailTroopTabViewModel) ContentPart.this.viewModel).getGroupFilter().geoInfo.district});
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listOf) {
                    String it = (String) obj;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.length() > 0) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    if (b16 != false) {
                        arrayList2.add(obj);
                    }
                }
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
                jSONObject.put("regional_type", joinToString$default);
                jSONObject.put("grp_search_exist_grp", !ContentPart.this.ja().isEmpty() ? 1 : 0);
            }
            return jSONObject;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public void g(@NotNull String originKeyword) {
            Intrinsics.checkNotNullParameter(originKeyword, "originKeyword");
            c.a.b(this, originKeyword);
            QLog.d("QQSearch.NetDetail.ContentPart", 1, "onCancelCorrection originKeyword=" + originKeyword);
            SimpleEventBus.getInstance().dispatchEvent(new CancelCorrectionEvent(originKeyword));
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                pageData.m(true);
            }
            SearchDetailTabContentFragment.PageData pageData2 = ContentPart.this.viewModel.getPageData();
            if (pageData2 != null) {
                pageData2.n(originKeyword);
            }
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public int getAllItemNums() {
            com.tencent.mobileqq.search.searchdetail.content.base.e eVar = ContentPart.this.searchResultListAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
                eVar = null;
            }
            return eVar.getNUM_BACKGOURND_ICON();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @Nullable
        public CoroutineScope getCoroutineScope() {
            return ViewModelKt.getViewModelScope(ContentPart.this.viewModel);
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public /* bridge */ /* synthetic */ String getDtAppKey() {
            return (String) i();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public String getKeyword() {
            String keyword;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData == null || (keyword = pageData.getKeyword()) == null) {
                return "";
            }
            return keyword;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public LifecycleOwner getLifecyclerOwner() {
            return ContentPart.this.viewLifecycleOwner;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public String getMiniAppSessionId() {
            return ContentPart.this.miniAppSessionId;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public Map<String, Object> getPageCacheMap() {
            return ContentPart.this.pageCacheData;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public int getPageMode() {
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                return pageData.getPageMode();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public SearchPageType getPageType() {
            return ContentPart.this.viewModel.getSearchPageType();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public int getQuerySource() {
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                return pageData.getQuerySource();
            }
            QLog.w("QQSearch.NetDetail.ContentPart", 4, " getQuerySource empty");
            return 0;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public String getSessionId() {
            String sessionId;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData == null || (sessionId = pageData.getSessionId()) == null) {
                return "";
            }
            return sessionId;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public long getStartSearchTimeStamps() {
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                return pageData.getStartSearchTimeStamps();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public String getSugTraceId() {
            String sugTraceId;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData == null || (sugTraceId = pageData.getSugTraceId()) == null) {
                return "";
            }
            return sugTraceId;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public long getTabMask() {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null && (tabInfo = pageData.getTabInfo()) != null) {
                return tabInfo.getTabMask();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        @NotNull
        public String getTabName() {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            String tabName;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData == null || (tabInfo = pageData.getTabInfo()) == null || (tabName = tabInfo.getTabName()) == null) {
                return "";
            }
            return tabName;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public int getUserSource() {
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                return pageData.getUserSource();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.base.c
        public void h(long guildId, @NotNull String docId, int likeStatus, @NotNull String currentTraceId) {
            Intrinsics.checkNotNullParameter(docId, "docId");
            Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
            if (likeStatus != 1) {
                ContentPart.this.viewModel.K2(guildId, docId, currentTraceId, true);
            }
        }

        @Nullable
        public Void i() {
            return null;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.d
        public void onClickMiniApp(@NotNull String clickId) {
            Intrinsics.checkNotNullParameter(clickId, "clickId");
            SearchWXMiniAppStayReportManager searchWXMiniAppStayReportManager = ContentPart.this.wxMiniAppStayReportManager;
            if (searchWXMiniAppStayReportManager != null) {
                searchWXMiniAppStayReportManager.onClickMiniApp(clickId);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$d", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f283945e;

        d(long j3) {
            this.f283945e = j3;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            RecyclerView recyclerView = ContentPart.this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
            ContentPart.this.isFirstFrameRecorded.set(true);
            ContentPart.this.searchPageReporter.b(true, "qsearch_detail_native");
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null && (tabInfo = pageData.getTabInfo()) != null) {
                long tabMask = tabInfo.getTabMask();
                long j3 = this.f283945e;
                com.tencent.mobileqq.search.searchdetail.searchbox.f fVar = com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a;
                fVar.h(System.currentTimeMillis() - j3, tabMask);
                fVar.d(true, tabMask);
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$e", "Lqp2/b;", "", "getKeyword", "", "getStartSearchTimeStamps", "", "getQuerySource", "getTabMask", "getMiniAppSessionId", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements qp2.b {
        e() {
        }

        @Override // qp2.b
        @NotNull
        public String getKeyword() {
            String keyword;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData == null || (keyword = pageData.getKeyword()) == null) {
                return "";
            }
            return keyword;
        }

        @Override // qp2.b
        @NotNull
        public String getMiniAppSessionId() {
            return ContentPart.this.miniAppSessionId;
        }

        @Override // qp2.b
        public int getQuerySource() {
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                return pageData.getQuerySource();
            }
            return 2;
        }

        @Override // qp2.b
        public long getStartSearchTimeStamps() {
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null) {
                return pageData.getStartSearchTimeStamps();
            }
            return 0L;
        }

        @Override // qp2.b
        public int getTabMask() {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null && (tabInfo = pageData.getTabInfo()) != null) {
                return (int) tabInfo.getTabMask();
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "d", "I", "currentScrollState", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int currentScrollState;

        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            int i3 = this.currentScrollState;
            if (i3 != newState && i3 == 1) {
                SimpleEventBus.getInstance().dispatchEvent(new StartScrollingView(this.currentScrollState));
            }
            if (this.currentScrollState != newState) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
                if (pageData != null) {
                    tabInfo = pageData.getTabInfo();
                } else {
                    tabInfo = null;
                }
                simpleEventBus.dispatchEvent(new ContentScrollStateChangeEvent(newState, tabInfo));
            }
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
            this.currentScrollState = newState;
        }
    }

    public /* synthetic */ ContentPart(com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar, LifecycleOwner lifecycleOwner, com.tencent.mobileqq.search.tux.b bVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(kVar, lifecycleOwner, (i3 & 4) != 0 ? null : bVar, (i3 & 8) != 0 ? "" : str);
    }

    private final void da() {
        String keyword;
        boolean isBlank;
        MutableLiveData<PullToRefreshState> p26 = this.viewModel.p2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<PullToRefreshState, Unit> function1 = new Function1<PullToRefreshState, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$1

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$bindData$1$1", "Ljava/lang/Runnable;", TencentLocation.RUN_MODE, "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$1$1, reason: invalid class name */
            /* loaded from: classes18.dex */
            public static final class AnonymousClass1 implements Runnable {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ PullToRefreshState f283941d;
                final /* synthetic */ ContentPart this$0;

                AnonymousClass1(ContentPart contentPart, PullToRefreshState pullToRefreshState) {
                    this.this$0 = contentPart;
                    this.f283941d = pullToRefreshState;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(ContentPart this$0) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    RecyclerView recyclerView = this$0.recyclerView;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView = null;
                    }
                    recyclerView.scrollToPosition(0);
                }

                @Override // java.lang.Runnable
                public void run() {
                    RecyclerView recyclerView = this.this$0.recyclerView;
                    RecyclerView recyclerView2 = null;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView = null;
                    }
                    final ContentPart contentPart = this.this$0;
                    recyclerView.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: INVOKE 
                          (r0v2 'recyclerView' androidx.recyclerview.widget.RecyclerView)
                          (wrap:java.lang.Runnable:0x0014: CONSTRUCTOR (r3v0 'contentPart' com.tencent.mobileqq.search.searchdetail.content.part.ContentPart A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.search.searchdetail.content.part.ContentPart):void (m), WRAPPED] (LINE:21) call: com.tencent.mobileqq.search.searchdetail.content.part.k.<init>(com.tencent.mobileqq.search.searchdetail.content.part.ContentPart):void type: CONSTRUCTOR)
                          (200 long)
                         VIRTUAL call: android.view.View.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:26) in method: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$1.1.run():void, file: classes18.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.search.searchdetail.content.part.k, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart r0 = r7.this$0
                        androidx.recyclerview.widget.RecyclerView r0 = com.tencent.mobileqq.search.searchdetail.content.part.ContentPart.J9(r0)
                        java.lang.String r1 = "recyclerView"
                        r2 = 0
                        if (r0 != 0) goto L10
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                        r0 = r2
                    L10:
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart r3 = r7.this$0
                        com.tencent.mobileqq.search.searchdetail.content.part.k r4 = new com.tencent.mobileqq.search.searchdetail.content.part.k
                        r4.<init>(r3)
                        r5 = 200(0xc8, double:9.9E-322)
                        r0.postDelayed(r4, r5)
                        com.tencent.mobileqq.search.searchdetail.content.repo.b r0 = r7.f283941d
                        boolean r0 = r0.getIsEnd()
                        if (r0 != 0) goto L29
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart r0 = r7.this$0
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart.ca(r0)
                    L29:
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart r0 = r7.this$0
                        com.tencent.mobileqq.search.searchdetail.content.part.u r0 = com.tencent.mobileqq.search.searchdetail.content.part.ContentPart.O9(r0)
                        if (r0 != 0) goto L38
                        java.lang.String r0 = "videoPlayController"
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        r0 = r2
                    L38:
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart r3 = r7.this$0
                        androidx.recyclerview.widget.RecyclerView r3 = com.tencent.mobileqq.search.searchdetail.content.part.ContentPart.J9(r3)
                        if (r3 != 0) goto L44
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                        r3 = r2
                    L44:
                        r0.h(r3, r5)
                        com.tencent.mobileqq.search.searchdetail.content.part.ContentPart r0 = r7.this$0
                        androidx.recyclerview.widget.RecyclerView r0 = com.tencent.mobileqq.search.searchdetail.content.part.ContentPart.J9(r0)
                        if (r0 != 0) goto L53
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                        goto L54
                    L53:
                        r2 = r0
                    L54:
                        com.tencent.qqlive.module.videoreport.VideoReport.traversePage(r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$1.AnonymousClass1.run():void");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PullToRefreshState pullToRefreshState) {
                invoke2(pullToRefreshState);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:27:0x00b8, code lost:
            
                if (r0 != false) goto L21;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(PullToRefreshState pullToRefreshState) {
                SearchDetailTabListViewModel.TabInfo tabInfo;
                SmartRefreshLayout smartRefreshLayout;
                boolean ra5;
                boolean qa5;
                boolean z16 = false;
                if (ContentPart.this.isPullToRefreshing.get()) {
                    ContentPart.this.isPullToRefreshing.set(false);
                }
                SmartRefreshLayout smartRefreshLayout2 = null;
                if (!pullToRefreshState.getIsSuccess()) {
                    ContentPart.this.searchPageReporter.b(false, "qsearch_detail_native");
                    SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
                    if (pageData != null && (tabInfo = pageData.getTabInfo()) != null) {
                        com.tencent.mobileqq.search.searchdetail.searchbox.f.f284591a.d(false, tabInfo.getTabMask());
                    }
                    Logger logger = Logger.f235387a;
                    ContentPart contentPart = ContentPart.this;
                    Logger.a d16 = logger.d();
                    SearchDetailTabContentFragment.PageData pageData2 = contentPart.viewModel.getPageData();
                    d16.w("QQSearch.NetDetail.ContentPart", 1, (pageData2 != null ? pageData2.getTabInfo() : null) + " pull2Refresh error, " + pullToRefreshState);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    ContentPart.this.curLoadMoreIndex = 0;
                    ContentPart.this.loadMoreAdapter.setLoadState(false, !pullToRefreshState.getIsEnd());
                    com.tencent.mobileqq.search.searchdetail.content.base.e eVar = ContentPart.this.searchResultListAdapter;
                    if (eVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
                        eVar = null;
                    }
                    eVar.setItems(ContentPart.this.ja(), new AnonymousClass1(ContentPart.this, pullToRefreshState));
                    ContentPart.this.wa(currentTimeMillis);
                    ra5 = ContentPart.this.ra();
                    if (ra5) {
                        ContentPart.this.loadMoreAdapter.hide();
                        Logger logger2 = Logger.f235387a;
                        ContentPart contentPart2 = ContentPart.this;
                        Logger.a d17 = logger2.d();
                        SearchDetailTabContentFragment.PageData pageData3 = contentPart2.viewModel.getPageData();
                        SearchDetailTabListViewModel.TabInfo tabInfo2 = pageData3 != null ? pageData3.getTabInfo() : null;
                        d17.i("QQSearch.NetDetail.ContentPart", 1, tabInfo2 + " pull2Refresh finish, isEnd=" + pullToRefreshState.getIsEnd() + " only ai mode hideLoadMore");
                    } else {
                        if (!ContentPart.this.pa()) {
                            qa5 = ContentPart.this.qa(5);
                        }
                        if (pullToRefreshState.getIsEnd()) {
                            z16 = true;
                        }
                        if (z16) {
                            ContentPart.this.loadMoreAdapter.hide();
                        } else if (!ContentPart.this.ja().isEmpty()) {
                            ContentPart.this.loadMoreAdapter.show();
                        }
                        Logger logger3 = Logger.f235387a;
                        ContentPart contentPart3 = ContentPart.this;
                        Logger.a d18 = logger3.d();
                        SearchDetailTabContentFragment.PageData pageData4 = contentPart3.viewModel.getPageData();
                        SearchDetailTabListViewModel.TabInfo tabInfo3 = pageData4 != null ? pageData4.getTabInfo() : null;
                        d18.i("QQSearch.NetDetail.ContentPart", 1, tabInfo3 + " pull2Refresh finish, isEnd=" + pullToRefreshState.getIsEnd() + " hideLoadMore=" + z16);
                    }
                    ContentPart.this.ta(true);
                }
                smartRefreshLayout = ContentPart.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                } else {
                    smartRefreshLayout2 = smartRefreshLayout;
                }
                smartRefreshLayout2.finishRefresh();
            }
        };
        p26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContentPart.ea(Function1.this, obj);
            }
        });
        MutableLiveData<LoadMoreState> m26 = this.viewModel.m2();
        LifecycleOwner lifecycleOwner2 = this.viewLifecycleOwner;
        final Function1<LoadMoreState, Unit> function12 = new Function1<LoadMoreState, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoadMoreState loadMoreState) {
                invoke2(loadMoreState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final LoadMoreState loadMoreState) {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                if (loadMoreState.getIsSuccess()) {
                    ContentPart.this.loadMoreAdapter.setLoadState(false, !loadMoreState.getIsEnd());
                    com.tencent.mobileqq.search.searchdetail.content.base.e eVar = ContentPart.this.searchResultListAdapter;
                    if (eVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
                        eVar = null;
                    }
                    List ja5 = ContentPart.this.ja();
                    final ContentPart contentPart = ContentPart.this;
                    eVar.setItems(ja5, new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RecyclerView recyclerView = ContentPart.this.recyclerView;
                            if (recyclerView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                recyclerView = null;
                            }
                            VideoReport.traversePage(recyclerView);
                            if (!loadMoreState.getIsEnd()) {
                                ContentPart.this.xa();
                            }
                        }
                    });
                    ContentPart.this.ta(false);
                }
                atomicBoolean = ContentPart.this.isLoadingMore;
                if (atomicBoolean.get()) {
                    atomicBoolean2 = ContentPart.this.isLoadingMore;
                    atomicBoolean2.set(false);
                }
                Logger logger = Logger.f235387a;
                ContentPart contentPart2 = ContentPart.this;
                Logger.a d16 = logger.d();
                SearchDetailTabContentFragment.PageData pageData = contentPart2.viewModel.getPageData();
                SearchDetailTabListViewModel.TabInfo tabInfo = pageData != null ? pageData.getTabInfo() : null;
                d16.i("QQSearch.NetDetail.ContentPart", 1, "tabinfo=" + tabInfo + " loadMore result=" + loadMoreState.getIsSuccess() + " isEnd=" + loadMoreState.getIsEnd());
            }
        };
        m26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContentPart.ga(Function1.this, obj);
            }
        });
        MutableLiveData<QSearchPostEvent> q26 = this.viewModel.q2();
        LifecycleOwner lifecycleOwner3 = this.viewLifecycleOwner;
        final Function1<QSearchPostEvent, Unit> function13 = new Function1<QSearchPostEvent, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QSearchPostEvent qSearchPostEvent) {
                invoke2(qSearchPostEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QSearchPostEvent qSearchPostEvent) {
                QLog.i("QQSearch.NetDetail.ContentPart", 1, "QSearchPostEvent:" + qSearchPostEvent);
                String eventName = qSearchPostEvent.getEventName();
                switch (eventName.hashCode()) {
                    case -1956599484:
                        if (!eventName.equals("update_troop_join_status")) {
                            return;
                        }
                        break;
                    case -889850998:
                        if (!eventName.equals("event_append_data")) {
                            return;
                        }
                        break;
                    case -561987688:
                        if (!eventName.equals("update_open_mini_app")) {
                            return;
                        }
                        break;
                    case 680776805:
                        if (!eventName.equals("update_guild_join_status")) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                com.tencent.mobileqq.search.searchdetail.content.base.e eVar = ContentPart.this.searchResultListAdapter;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
                    eVar = null;
                }
                List ja5 = ContentPart.this.ja();
                final ContentPart contentPart = ContentPart.this;
                eVar.setItems(ja5, new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RecyclerView recyclerView = ContentPart.this.recyclerView;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView = null;
                        }
                        VideoReport.traversePage(recyclerView);
                    }
                });
            }
        };
        q26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContentPart.ha(Function1.this, obj);
            }
        });
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null && (keyword = pageData.getKeyword()) != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(keyword);
            if (!isBlank) {
                SearchDetailTabContentFragment.PageData pageData2 = this.viewModel.getPageData();
                if (pageData2 != null) {
                    pageData2.r(System.currentTimeMillis());
                }
                this.isPullToRefreshing.set(true);
                Activity activity = getActivity();
                if (activity != null) {
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar = this.viewModel;
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    kVar.R2(activity2, keyword, RefreshType.TYPE_FIRST_RENDER_SEARCH, "firstFetch");
                }
            }
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableRefresh(true ^ ra());
        MutableLiveData<String> l26 = this.viewModel.l2();
        LifecycleOwner lifecycleOwner4 = this.viewLifecycleOwner;
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$bindData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                SmartRefreshLayout smartRefreshLayout2;
                SmartRefreshLayout smartRefreshLayout3;
                QLog.i("QQSearch.NetDetail.ContentPart", 1, "ListState change:" + str + ", querySource:" + ContentPart.this.getDtReport().getQuerySource());
                boolean areEqual = Intrinsics.areEqual(str, GlobalUtil.DEF_STRING) ? true : Intrinsics.areEqual(str, "error");
                SmartRefreshLayout smartRefreshLayout4 = null;
                if (areEqual) {
                    smartRefreshLayout3 = ContentPart.this.refreshLayout;
                    if (smartRefreshLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    } else {
                        smartRefreshLayout4 = smartRefreshLayout3;
                    }
                    smartRefreshLayout4.setVisibility(8);
                    return;
                }
                smartRefreshLayout2 = ContentPart.this.refreshLayout;
                if (smartRefreshLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                } else {
                    smartRefreshLayout4 = smartRefreshLayout2;
                }
                smartRefreshLayout4.setVisibility(0);
            }
        };
        l26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContentPart.ia(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.search.searchdetail.c> ja() {
        return this.viewModel.g2(this.tuxItemPredicate);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ma(boolean isPullToRefresh) {
        Unit unit;
        String str;
        int i3;
        int i16;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b m3 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.j.m(ja());
        if (m3 != null) {
            if (this.wxMiniAppExposeReportManager == null) {
                RecyclerView recyclerView = this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                SearchWXMiniAppExposeReportManager searchWXMiniAppExposeReportManager = new SearchWXMiniAppExposeReportManager(recyclerView, this.reportParamIoc);
                this.wxMiniAppExposeReportManager = searchWXMiniAppExposeReportManager;
                searchWXMiniAppExposeReportManager.start();
            }
            qp2.a backEndReportInfo = m3.getBackEndReportInfo();
            if (backEndReportInfo != null) {
                if (this.wxMiniAppStayReportManager == null || isPullToRefresh) {
                    SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
                    if (pageData == null || (str = pageData.getKeyword()) == null) {
                        str = "";
                    }
                    String str2 = str;
                    SearchDetailTabContentFragment.PageData pageData2 = this.viewModel.getPageData();
                    if (pageData2 != null && (tabInfo = pageData2.getTabInfo()) != null) {
                        i3 = (int) tabInfo.getTabMask();
                    } else {
                        i3 = 0;
                    }
                    int i17 = i3;
                    SearchDetailTabContentFragment.PageData pageData3 = this.viewModel.getPageData();
                    if (pageData3 != null) {
                        i16 = pageData3.getQuerySource();
                    } else {
                        i16 = 2;
                    }
                    SearchWXMiniAppStayReportManager searchWXMiniAppStayReportManager = new SearchWXMiniAppStayReportManager(str2, i16, i17, this.miniAppSessionId, backEndReportInfo.getSearchId(), backEndReportInfo.getParentSearchId());
                    this.wxMiniAppStayReportManager = searchWXMiniAppStayReportManager;
                    searchWXMiniAppStayReportManager.onFirstFrame();
                }
                unit = Unit.INSTANCE;
                if (unit != null) {
                    SearchWXMiniAppExposeReportManager searchWXMiniAppExposeReportManager2 = this.wxMiniAppExposeReportManager;
                    if (searchWXMiniAppExposeReportManager2 != null) {
                        searchWXMiniAppExposeReportManager2.stop();
                    }
                    this.wxMiniAppExposeReportManager = null;
                    this.wxMiniAppStayReportManager = null;
                    return;
                }
                return;
            }
        }
        unit = null;
        if (unit != null) {
        }
    }

    private final void na(View rootView) {
        View findViewById = rootView.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.j
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                ContentPart.oa(ContentPart.this, iRefreshLayout);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.recycler_view)");
        this.recyclerView = (RecyclerView) findViewById2;
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar = new com.tencent.mobileqq.search.searchdetail.content.base.e(new com.tencent.mobileqq.search.searchdetail.content.base.d(), new com.tencent.mobileqq.search.searchdetail.content.base.f());
        eVar.setHasStableIds(true);
        this.searchResultListAdapter = eVar;
        this.loadMoreAdapter.hide();
        this.loadMoreAdapter.registerLoadMoreListener(new c());
        this.loadMoreAdapter.setMaxAutoLoadMoreTimes(3);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar2 = this.searchResultListAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
            eVar2 = null;
        }
        adapterArr[0] = eVar2;
        adapterArr[1] = this.loadMoreAdapter;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(rFWConcatAdapter);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        g16.registerIoc(recyclerView2, this.dtReport, com.tencent.mobileqq.search.searchdetail.content.base.c.class);
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar3 = this.searchResultListAdapter;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
            eVar3 = null;
        }
        this.videoPlayController = new u(this, eVar3);
        RFWIocAbilityProvider g17 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        u uVar = this.videoPlayController;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoPlayController");
            uVar = null;
        }
        g17.registerIoc(recyclerView3, uVar, r.class);
        RFWIocAbilityProvider g18 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        g18.registerIoc(recyclerView4, this.searchTuxStatisticIoc, com.tencent.mobileqq.search.tux.b.class);
        u uVar2 = this.videoPlayController;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoPlayController");
            uVar2 = null;
        }
        recyclerView.addOnScrollListener(uVar2);
        recyclerView.addOnScrollListener(this.scrollListener);
        recyclerView.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(ContentPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.ua();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean pa() {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        Object first;
        List<com.tencent.mobileqq.search.searchdetail.c> ja5 = ja();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        if (tabInfo != null && this.viewModel.y2(tabInfo) && ja5.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) ja5);
            if (((com.tencent.mobileqq.search.searchdetail.c) first).getItemType() == 19) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean qa(int count) {
        if (ja().size() <= count) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ra() {
        int value;
        SearchDetailFragment.Companion.PageMode.Companion companion = SearchDetailFragment.Companion.PageMode.INSTANCE;
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null) {
            value = pageData.getPageMode();
        } else {
            value = SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }
        return companion.a(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(c.LoadMoreMessage args) {
        SearchDetailTabContentFragment.PageData pageData;
        String keyword;
        QLog.i("QQSearch.NetDetail.ContentPart", 1, "onLoadMore isLoadingMore = " + this.isLoadingMore.get() + " callSource = " + args.getCallSource() + " loadMoreType = " + args.getLoadMoreType());
        if (this.isLoadingMore.compareAndSet(false, true) && (pageData = this.viewModel.getPageData()) != null && (keyword = pageData.getKeyword()) != null) {
            this.isLoadingMore.set(true);
            this.viewModel.A2(keyword, args.getLoadMoreType(), args.getCallSource());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(boolean isPullToRefresh) {
        ma(isPullToRefresh);
    }

    private final void ua() {
        String str;
        String keyword;
        Unit unit;
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        SmartRefreshLayout smartRefreshLayout = null;
        if (pageData != null) {
            str = pageData.getKeyword();
        } else {
            str = null;
        }
        d16.i("QQSearch.NetDetail.ContentPart", 1, "receive MESSAGE_PULL_TO_REFRESH keyword=" + str + " isPullToRefreshing = " + this.isPullToRefreshing.get());
        if (this.isPullToRefreshing.compareAndSet(false, true)) {
            SearchDetailTabContentFragment.PageData pageData2 = this.viewModel.getPageData();
            if (pageData2 != null && (keyword = pageData2.getKeyword()) != null) {
                this.isPullToRefreshing.set(true);
                Activity activity = getActivity();
                if (activity != null) {
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    com.tencent.mobileqq.search.searchdetail.content.viewmodel.k kVar = this.viewModel;
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    kVar.R2(activity2, keyword, RefreshType.TYPE_FINGER_PULL2REFRESH, "pull2refresh");
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            smartRefreshLayout.finishRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(List originItems, ContentPart this$0) {
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar;
        Object obj;
        Intrinsics.checkNotNullParameter(originItems, "$originItems");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = originItems;
        Iterator it = list.iterator();
        while (true) {
            eVar = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.search.searchdetail.c) obj) instanceof com.tencent.mobileqq.search.tux.d) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.search.searchdetail.c cVar = (com.tencent.mobileqq.search.searchdetail.c) obj;
        if (cVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (!(((com.tencent.mobileqq.search.searchdetail.c) obj2) instanceof com.tencent.mobileqq.search.tux.d)) {
                arrayList.add(obj2);
            }
        }
        if (originItems.size() == arrayList.size()) {
            return;
        }
        this$0.viewModel.J2(cVar);
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar2 = this$0.searchResultListAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
            eVar2 = null;
        }
        eVar2.setItems(this$0.ja());
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar3 = this$0.searchResultListAdapter;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
        } else {
            eVar = eVar3;
        }
        eVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(long renderStartTime) {
        if (!this.isFirstFrameRecorded.get()) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.getViewTreeObserver().addOnPreDrawListener(new d(renderStartTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa() {
        int i3;
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar = this.searchResultListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
            eVar = null;
        }
        if (eVar.getNUM_BACKGOURND_ICON() < 15 && (i3 = this.curLoadMoreIndex) < 3) {
            this.curLoadMoreIndex = i3 + 1;
            this.loadMoreAdapter.j0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
    }

    @NotNull
    /* renamed from: la, reason: from getter */
    public final com.tencent.mobileqq.search.searchdetail.content.base.c getDtReport() {
        return this.dtReport;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        this.searchPageReporter.c();
        na(rootView);
        da();
        Logger.f235387a.d().i("QQSearch.NetDetail.ContentPart", 1, "onInitView pageData = " + this.viewModel.getPageData());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        com.tencent.mobileqq.search.tux.b bVar = this.searchTuxStatisticIoc;
        if (bVar != null) {
            bVar.g(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        yp2.d.f450780a.b(String.valueOf(this.dtReport.hashCode()));
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        g16.unregisterSingleIoc(recyclerView, com.tencent.mobileqq.search.searchdetail.content.base.c.class);
        RFWIocAbilityProvider g17 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        g17.unregisterSingleIoc(recyclerView2, com.tencent.mobileqq.search.tux.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        SearchWXMiniAppExposeReportManager searchWXMiniAppExposeReportManager = this.wxMiniAppExposeReportManager;
        if (searchWXMiniAppExposeReportManager != null) {
            searchWXMiniAppExposeReportManager.pause();
        }
        SearchWXMiniAppStayReportManager searchWXMiniAppStayReportManager = this.wxMiniAppStayReportManager;
        if (searchWXMiniAppStayReportManager != null) {
            searchWXMiniAppStayReportManager.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        u uVar;
        RecyclerView recyclerView;
        super.onPartResume(activity);
        u uVar2 = this.videoPlayController;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoPlayController");
            uVar = null;
        } else {
            uVar = uVar2;
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        } else {
            recyclerView = recyclerView2;
        }
        u.i(uVar, recyclerView, 0L, 2, null);
        SearchWXMiniAppExposeReportManager searchWXMiniAppExposeReportManager = this.wxMiniAppExposeReportManager;
        if (searchWXMiniAppExposeReportManager != null) {
            searchWXMiniAppExposeReportManager.resume();
        }
        SearchWXMiniAppStayReportManager searchWXMiniAppStayReportManager = this.wxMiniAppStayReportManager;
        if (searchWXMiniAppStayReportManager != null) {
            searchWXMiniAppStayReportManager.onResume();
        }
    }

    @Override // com.tencent.mobileqq.search.tux.a
    public void removeTuxItem() {
        com.tencent.mobileqq.search.searchdetail.content.base.e eVar = this.searchResultListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultListAdapter");
            eVar = null;
        }
        final List<com.tencent.mobileqq.search.searchdetail.c> items = eVar.getItems();
        if (items == null || items.isEmpty()) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.e
            @Override // java.lang.Runnable
            public final void run() {
                ContentPart.va(items, this);
            }
        });
    }

    public ContentPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel, @NotNull LifecycleOwner viewLifecycleOwner, @Nullable com.tencent.mobileqq.search.tux.b bVar, @NotNull String miniAppSessionId) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(miniAppSessionId, "miniAppSessionId");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.searchTuxStatisticIoc = bVar;
        this.miniAppSessionId = miniAppSessionId;
        boolean z16 = false;
        this.isPullToRefreshing = new AtomicBoolean(false);
        this.isLoadingMore = new AtomicBoolean(false);
        this.loadMoreAdapter = new mp2.b(viewModel);
        this.pageCacheData = new ConcurrentHashMap<>();
        this.searchPageReporter = new u60.c();
        this.isFirstFrameRecorded = new AtomicBoolean(false);
        if (SearchQQMC.INSTANCE.enableSearchTux().getEnableNet() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            z16 = true;
        }
        this.enableShowTux = z16;
        this.tuxItemPredicate = new Function1<com.tencent.mobileqq.search.searchdetail.c, Boolean>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.ContentPart$tuxItemPredicate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
            
                return java.lang.Boolean.valueOf(r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
            
                if ((r4 instanceof com.tencent.mobileqq.search.tux.d) == false) goto L13;
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            
                if ((r0 != null && r0.getHasSearchTuxClosed()) != false) goto L11;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
            
                r1 = true;
             */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke(@NotNull com.tencent.mobileqq.search.searchdetail.c item) {
                boolean z17;
                com.tencent.mobileqq.search.tux.b bVar2;
                Intrinsics.checkNotNullParameter(item, "item");
                z17 = ContentPart.this.enableShowTux;
                boolean z18 = false;
                if (z17) {
                    bVar2 = ContentPart.this.searchTuxStatisticIoc;
                }
            }
        };
        this.dtReport = new b();
        this.reportParamIoc = new e();
        this.scrollListener = new f();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/part/ContentPart$c", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements ILoadMoreProvider$LoadMoreListener {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onLoadMoreStart() {
            boolean z16;
            String keyword;
            boolean z17;
            SearchDetailTabContentFragment.PageData pageData = ContentPart.this.viewModel.getPageData();
            if (pageData != null && (keyword = pageData.getKeyword()) != null) {
                if (keyword.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    SearchDetailTabListViewModel.TabInfo tabInfo = null;
                    if (!z16) {
                        Logger logger = Logger.f235387a;
                        ContentPart contentPart = ContentPart.this;
                        Logger.a d16 = logger.d();
                        SearchDetailTabContentFragment.PageData pageData2 = contentPart.viewModel.getPageData();
                        if (pageData2 != null) {
                            tabInfo = pageData2.getTabInfo();
                        }
                        d16.i("QQSearch.NetDetail.ContentPart", 1, "tabinfo=" + tabInfo + " keyword is empty can't loadmore");
                        ContentPart.this.loadMoreAdapter.setLoadState(false, false);
                        return;
                    }
                    if (!ContentPart.this.isPullToRefreshing.get()) {
                        ContentPart.this.sa(new c.LoadMoreMessage(LoadMoreType.TYPE_FINGER_SLIDING, "onLoadMoreStart"));
                        return;
                    }
                    Logger logger2 = Logger.f235387a;
                    ContentPart contentPart2 = ContentPart.this;
                    Logger.a d17 = logger2.d();
                    SearchDetailTabContentFragment.PageData pageData3 = contentPart2.viewModel.getPageData();
                    if (pageData3 != null) {
                        tabInfo = pageData3.getTabInfo();
                    }
                    d17.w("QQSearch.NetDetail.ContentPart", 1, "tabinfo=" + tabInfo + " can't loadmore on pulling");
                    ContentPart.this.loadMoreAdapter.setLoadState(false, true);
                    return;
                }
            }
            z16 = false;
            SearchDetailTabListViewModel.TabInfo tabInfo2 = null;
            if (!z16) {
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
