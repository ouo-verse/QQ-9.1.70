package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailInteractiveEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.search.searchdetail.SearchPageType;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreState;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreType;
import com.tencent.mobileqq.search.searchdetail.content.repo.PullToRefreshState;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.content.repo.SearchAppendItem;
import com.tencent.mobileqq.search.searchdetail.content.repo.SearchDetailTabContentRepo;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateBannerItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTopicHeaderItem;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchVerticalDetailTemplateItem;
import com.tencent.mobileqq.search.searchdetail.eventbus.QSearchPostEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.UpdateParentTpEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.ad;
import com.tencent.mobileqq.search.util.ae;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchAppendingInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAppendingInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchAppendingInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.SearchChannelConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageExtraInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchFloatButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabContent;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\t*\u0002\u00a7\u0001\b\u0016\u0018\u0000 \u00ad\u00012\u00020\u00012\u00020\u0002:\u0002\u00ae\u0001B\t\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001J^\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u0002J(\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J(\u0010!\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0002J(\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\"2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001bH\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0018\u0010+\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0016\u0010/\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0016\u00100\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0012\u00102\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u00103\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0016\u00104\u001a\u00020\u00142\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J$\u00107\u001a\b\u0012\u0004\u0012\u00020-0,2\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0007\u0018\u000105J\u000e\u00109\u001a\u00020\u00142\u0006\u00108\u001a\u00020-J\u0006\u0010;\u001a\u00020:J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\u0005J\u0006\u0010B\u001a\u00020AJ\u000e\u0010D\u001a\u00020\u00142\u0006\u0010C\u001a\u00020AJ\u000e\u0010G\u001a\u00020\u00142\u0006\u0010F\u001a\u00020EJ\u0016\u0010K\u001a\u00020\u00142\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u0005J\u000e\u0010N\u001a\u00020\u00072\u0006\u0010M\u001a\u00020LJ\b\u0010P\u001a\u00020OH\u0016J\b\u0010Q\u001a\u00020\u0014H\u0014J(\u0010R\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0016JB\u0010S\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0005J\n\u0010U\u001a\u0004\u0018\u00010TH\u0016J*\u0010Y\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u000f2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010,2\b\b\u0002\u0010X\u001a\u00020\u0007H\u0016J \u0010\\\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010[\u001a\u00020Z2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J2\u0010]\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010[\u001a\u00020ZJ\u000e\u0010_\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u0005J\u000e\u0010a\u001a\u00020\u00142\u0006\u0010F\u001a\u00020`J\u000e\u0010c\u001a\u00020\u00142\u0006\u0010F\u001a\u00020bJ\u000e\u0010e\u001a\u00020\u00142\u0006\u0010F\u001a\u00020dJ&\u0010h\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0007R\u0016\u0010k\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020}0|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0082\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001f\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008a\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u0086\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0086\u0001R\"\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050<8\u0006\u00a2\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0087\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R#\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010<8\u0006\u00a2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0087\u0001\u001a\u0006\b\u0098\u0001\u0010\u0094\u0001R#\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010<8\u0006\u00a2\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u0087\u0001\u001a\u0006\b\u009c\u0001\u0010\u0094\u0001R\"\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020d0<8\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u0087\u0001\u001a\u0006\b\u009f\u0001\u0010\u0094\u0001R\"\u0010\u00a3\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050<8\u0006\u00a2\u0006\u0010\n\u0006\b\u00a1\u0001\u0010\u0087\u0001\u001a\u0006\b\u00a2\u0001\u0010\u0094\u0001R\"\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050<8\u0006\u00a2\u0006\u0010\n\u0006\b\u00a4\u0001\u0010\u0087\u0001\u001a\u0006\b\u00a5\u0001\u0010\u0094\u0001R\u0018\u0010\u00aa\u0001\u001a\u00030\u00a7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/app/Activity;", "context", "", "keyword", "", "withLBS", "disableCorrectionQuery", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChannelConditonFilter;", "channelConditionFilter", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupConditonFilter;", "groupConditionFilter", "source", "", "pagemode", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "refreshType", "needNotify", "", "N2", "businessType", "channelExtensionInfo", "searchExtensionInfo", "from", "w2", "", "convertTimeCost", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/d;", "Lkotlin/collections/ArrayList;", "searchResultItem", "v2", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAppendingInfoRsp;", "rsp", "d2", "guildId", "z2", "docId", "x2", "status", "S2", "c2", "", "Lcom/tencent/mobileqq/search/searchdetail/c;", "dataList", "F2", "E2", "extData", "postProcessExtData", "P2", "setItemPageNumAndPosition", "Lkotlin/Function1;", "predicate", "g2", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "J2", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "i2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFloatButton;", "j2", "u2", "k2", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", ICustomDataEditor.STRING_PARAM_2, "searchPageType", "U2", "Lcom/tencent/mobileqq/search/searchdetail/eventbus/OnTabChangedEvent;", "event", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", ISchemeApi.KEY_PAGE_DATA, "pageSessionId", "T2", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "tabInfo", "y2", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "onCleared", "R2", "f2", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", ICustomDataEditor.NUMBER_PARAM_2, QzoneIPCModule.RESULT_CODE, "filters", "fromLoadMore", "B2", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "loadMoreType", NowProxyConstants.AccountInfoKey.A2, "e2", "newState", "Q2", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailViewDestroyEvent;", Constants.MMCCID, "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailInteractiveEvent;", "H2", "Lcom/tencent/mobileqq/search/searchdetail/eventbus/QSearchPostEvent;", "I2", "currentTraceId", "forceReq", "K2", "i", "Landroidx/lifecycle/ViewModelStore;", "_viewModelStore", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", "o2", "()Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;", "setPageData", "(Lcom/tencent/mobileqq/search/searchdetail/content/SearchDetailTabContentFragment$b;)V", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/SearchDetailTabContentRepo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/content/repo/SearchDetailTabContentRepo;", "dataRepo", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/e;", "D", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/e;", "appendDataRepo", "E", "Lcom/tencent/mobileqq/search/searchdetail/SearchPageType;", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", UserInfo.SEX_FEMALE, "Ljava/util/List;", "G", "Z", "dataIsEnd", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "emptyPageExtraInfo", "I", "Landroidx/lifecycle/MutableLiveData;", "floatButtonInfoLiveData", "J", "Ljava/lang/String;", "topicName", "K", "lastRequestLocalTraceId", "L", "pageNum", "M", "totalCountWithoutTitle", "N", "l2", "()Landroidx/lifecycle/MutableLiveData;", "listStateLiveData", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/b;", "P", "p2", "pullToRefreshStateLiveData", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "m2", "loadMoreStateLiveData", BdhLogUtil.LogTag.Tag_Req, "q2", "searchEventPostLiveData", ExifInterface.LATITUDE_SOUTH, "t2", "searchSuccLiveData", "T", "r2", "searchFilterLiveData", "com/tencent/mobileqq/search/searchdetail/content/viewmodel/k$d", "U", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k$d;", "gpServiceObserver", "<init>", "()V", "V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class k extends ViewModel implements ViewModelStoreOwner {

    /* renamed from: G, reason: from kotlin metadata */
    private boolean dataIsEnd;

    /* renamed from: L, reason: from kotlin metadata */
    private int pageNum;

    /* renamed from: M, reason: from kotlin metadata */
    private int totalCountWithoutTitle;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final d gpServiceObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SearchDetailTabContentFragment.PageData pageData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewModelStore _viewModelStore = new ViewModelStore();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final SearchDetailTabContentRepo dataRepo = new SearchDetailTabContentRepo();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.repo.e appendDataRepo = new com.tencent.mobileqq.search.searchdetail.content.repo.e();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private SearchPageType searchPageType = SearchPageType.PAGE_NET_SEARCH_DETAIL;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.search.searchdetail.a> dataList = new ArrayList();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private SearchEmptyPageExtraInfo emptyPageExtraInfo = new SearchEmptyPageExtraInfo();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<SearchFloatButton> floatButtonInfoLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String topicName = "";

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String lastRequestLocalTraceId = "";

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> listStateLiveData = new MutableLiveData<>(HippyPagerPageChangeListener.IDLE);

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PullToRefreshState> pullToRefreshStateLiveData = new MutableLiveData<>();

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LoadMoreState> loadMoreStateLiveData = new MutableLiveData<>();

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QSearchPostEvent> searchEventPostLiveData = new MutableLiveData<>();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> searchSuccLiveData = new MutableLiveData<>();

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> searchFilterLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JF\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/viewmodel/k$b", "Lkn2/b;", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "list", "", "isEnd", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "emptyExtra", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFloatButton;", "floatButton", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "miniAppConditionFilters", "", "extData", "", "onSuccess", "", "errorCode", "errorMsg", "onFailed", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements kn2.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoadMoreType f284337b;

        b(LoadMoreType loadMoreType) {
            this.f284337b = loadMoreType;
        }

        @Override // kn2.b
        public void onFailed(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            k.this.m2().setValue(new LoadMoreState(true, false, this.f284337b, null, k.this.dataIsEnd));
            k.this.B2(-1, null, true);
        }

        @Override // kn2.b
        public void onSuccess(@NotNull List<? extends com.tencent.mobileqq.search.searchdetail.a> list, boolean isEnd, @NotNull SearchEmptyPageExtraInfo emptyExtra, @NotNull SearchFloatButton floatButton, @NotNull List<SearchMiniAppConditonFilter> miniAppConditionFilters, @Nullable String extData) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(emptyExtra, "emptyExtra");
            Intrinsics.checkNotNullParameter(floatButton, "floatButton");
            Intrinsics.checkNotNullParameter(miniAppConditionFilters, "miniAppConditionFilters");
            k.this.F2(list);
            k.this.dataList.addAll(list);
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "doLoadMore onSuccess miniAppConditionFilters:" + miniAppConditionFilters);
            k.this.dataIsEnd = isEnd;
            k.this.emptyPageExtraInfo = emptyExtra;
            k.this.postProcessExtData(extData);
            k.this.m2().setValue(new LoadMoreState(true, true, this.f284337b, list, isEnd));
            k.this.B2(0, null, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/viewmodel/k$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "", "", "deniedPermissions", "", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "onMultiSceneDialogDenied", "Lcom/tencent/mobileqq/qqpermission/view/a;", "onMultiSceneDialogShow", "onAllGranted", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f284339b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f284340c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f284341d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SearchChannelConditonFilter f284342e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SearchGroupConditonFilter f284343f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f284344g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f284345h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ RefreshType f284346i;

        c(Activity activity, String str, boolean z16, SearchChannelConditonFilter searchChannelConditonFilter, SearchGroupConditonFilter searchGroupConditonFilter, String str2, int i3, RefreshType refreshType) {
            this.f284339b = activity;
            this.f284340c = str;
            this.f284341d = z16;
            this.f284342e = searchChannelConditonFilter;
            this.f284343f = searchGroupConditonFilter;
            this.f284344g = str2;
            this.f284345h = i3;
            this.f284346i = refreshType;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "loadData lbs permission ok. send request with lbs ");
            k.this.N2(this.f284339b, this.f284340c, true, this.f284341d, this.f284342e, this.f284343f, this.f284344g, this.f284345h, this.f284346i, false);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            QLog.d("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "onMultiSceneDialogShow");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onMultiSceneDialogDenied() {
            super.onMultiSceneDialogDenied();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onMultiSceneDialogShow(@Nullable com.tencent.mobileqq.qqpermission.view.a dialog) {
            super.onMultiSceneDialogShow(dialog);
            QLog.d("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "onMultiSceneDialogShow");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0014J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/viewmodel/k$d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "", "guildId", "onRemoveGuild", "black", "onBeKickFromGuild", "onDestoryGuild", "onDeleteGuild", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d extends GPServiceObserver {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            super.onAddGuildWithInfo(info, sourceType);
            if (info != null && !TextUtils.isEmpty(info.getGuildID())) {
                boolean isMember = info.isMember();
                k kVar = k.this;
                String guildID = info.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "info.guildID");
                kVar.S2(guildID, isMember ? 1 : 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            super.onBeKickFromGuild(guildId, black);
            if (guildId != null) {
                k.this.S2(guildId, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            super.onDeleteGuild(guildId);
            if (guildId != null) {
                k.this.S2(guildId, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            super.onDestoryGuild(guildId);
            if (guildId != null) {
                k.this.S2(guildId, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            super.onRemoveGuild(guildId);
            if (guildId != null) {
                k.this.S2(guildId, 0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JF\u0010\u0013\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/viewmodel/k$e", "Lkn2/b;", "", "userSource", "", "a", "", "Lcom/tencent/mobileqq/search/searchdetail/a;", "list", "isEnd", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "emptyExtra", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFloatButton;", "floatButton", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "miniAppConditionFilters", "", "extData", "", "onSuccess", "errorCode", "errorMsg", "onFailed", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements kn2.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchMiniAppConditonFilter f284349b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RefreshType f284350c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f284351d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f284352e;

        e(SearchMiniAppConditonFilter searchMiniAppConditonFilter, RefreshType refreshType, boolean z16, String str) {
            this.f284349b = searchMiniAppConditonFilter;
            this.f284350c = refreshType;
            this.f284351d = z16;
            this.f284352e = str;
        }

        private final boolean a(int userSource) {
            if (userSource == 1 || userSource == 6 || userSource == 8 || userSource == 9 || userSource == 10 || userSource == 11) {
                return true;
            }
            return false;
        }

        @Override // kn2.b
        public void onFailed(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            k.this.p2().setValue(new PullToRefreshState(true, false, this.f284350c, null, k.this.dataIsEnd));
            if (k.this.dataList.isEmpty()) {
                k.this.Q2("error");
            } else {
                k.this.Q2("success");
            }
            k.C2(k.this, -1, null, false, 4, null);
        }

        @Override // kn2.b
        public void onSuccess(@NotNull List<? extends com.tencent.mobileqq.search.searchdetail.a> list, boolean isEnd, @NotNull SearchEmptyPageExtraInfo emptyExtra, @NotNull SearchFloatButton floatButton, @NotNull List<SearchMiniAppConditonFilter> miniAppConditionFilters, @Nullable String extData) {
            String str;
            com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar;
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(emptyExtra, "emptyExtra");
            Intrinsics.checkNotNullParameter(floatButton, "floatButton");
            Intrinsics.checkNotNullParameter(miniAppConditionFilters, "miniAppConditionFilters");
            k.this.pageNum = 0;
            k.this.totalCountWithoutTitle = 0;
            k.this.dataList.clear();
            k.this.appendDataRepo.a();
            k.this.F2(list);
            k.this.dataList.addAll(list);
            SearchMiniAppConditonFilter searchMiniAppConditonFilter = this.f284349b;
            Object obj = null;
            if (searchMiniAppConditonFilter != null) {
                for (com.tencent.mobileqq.search.searchdetail.a aVar : k.this.dataList) {
                    if (aVar instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
                        bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) aVar;
                    } else {
                        bVar = null;
                    }
                    if (bVar != null) {
                        String str2 = searchMiniAppConditonFilter.title;
                        Intrinsics.checkNotNullExpressionValue(str2, "currentMiniAppConditionFilter.title");
                        bVar.B(str2);
                    }
                }
            }
            k.C2(k.this, 0, miniAppConditionFilters, false, 4, null);
            k.this.dataIsEnd = isEnd;
            k.this.emptyPageExtraInfo = emptyExtra;
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((com.tencent.mobileqq.search.searchdetail.a) next) instanceof NetSearchTemplateTopicHeaderItem) {
                    obj = next;
                    break;
                }
            }
            com.tencent.mobileqq.search.searchdetail.a aVar2 = (com.tencent.mobileqq.search.searchdetail.a) obj;
            k kVar = k.this;
            if (aVar2 instanceof NetSearchTemplateTopicHeaderItem) {
                NetSearchTemplateTopicHeaderItem netSearchTemplateTopicHeaderItem = (NetSearchTemplateTopicHeaderItem) aVar2;
                Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "search finish topic=" + netSearchTemplateTopicHeaderItem.getTopicHeader().icon.title.text + " floatButton=" + floatButton);
                str = netSearchTemplateTopicHeaderItem.getTopicHeader().icon.title.text;
                Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026ext\n                    }");
            } else {
                str = "";
            }
            kVar.topicName = str;
            k.this.floatButtonInfoLiveData.setValue(floatButton);
            k.this.p2().setValue(new PullToRefreshState(true, true, this.f284350c, list, k.this.dataIsEnd));
            if (k.this.dataList.isEmpty()) {
                k.this.Q2(GlobalUtil.DEF_STRING);
            } else {
                k.this.Q2("success");
            }
            k.this.postProcessExtData(extData);
            SearchDetailTabContentFragment.PageData pageData = k.this.getPageData();
            if (pageData != null) {
                boolean z16 = this.f284351d;
                k kVar2 = k.this;
                String str3 = this.f284352e;
                if (z16 && pageData.getTabInfo().getTabMask() == 1 && a(pageData.getUserSource())) {
                    kVar2.t2().setValue(str3);
                }
            }
        }
    }

    public k() {
        AppInterface appInterface;
        d dVar = new d();
        this.gpServiceObserver = dVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) (appInterface != null ? appInterface.getRuntimeService(IGProGlobalService.class, "") : null);
        if (iGProGlobalService != null) {
            iGProGlobalService.addObserver(dVar);
        }
    }

    public static /* synthetic */ void C2(k kVar, int i3, List list, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                z16 = false;
            }
            kVar.B2(i3, list, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onConditionFilterRsp");
    }

    private final void E2(List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
        NetSearchTemplateBannerItem netSearchTemplateBannerItem;
        ArrayList<NetSearchTemplateBannerItem> arrayList = new ArrayList();
        for (com.tencent.mobileqq.search.searchdetail.c cVar : dataList) {
            if (cVar instanceof NetSearchTemplateBannerItem) {
                netSearchTemplateBannerItem = (NetSearchTemplateBannerItem) cVar;
            } else {
                netSearchTemplateBannerItem = null;
            }
            if (netSearchTemplateBannerItem != null) {
                arrayList.add(netSearchTemplateBannerItem);
            }
        }
        for (NetSearchTemplateBannerItem netSearchTemplateBannerItem2 : arrayList) {
            netSearchTemplateBannerItem2.F(com.tencent.mobileqq.search.searchdetail.banner.k.INSTANCE.a(netSearchTemplateBannerItem2, dataList.indexOf(netSearchTemplateBannerItem2), dataList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2(List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
        E2(dataList);
        P2(dataList);
        setItemPageNumAndPosition(dataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(final k this$0, int i3, String str, SearchAppendingInfoRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.search.util.n.e(i3)) {
            long currentTimeMillis = System.currentTimeMillis();
            final ArrayList<SearchAppendItem> arrayList = new ArrayList<>();
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            this$0.d2(rsp, arrayList);
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.viewmodel.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.M2(k.this, currentTimeMillis2, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(k this$0, long j3, ArrayList searchResultItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(searchResultItem, "$searchResultItem");
        this$0.v2(j3, searchResultItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2(Activity context, String keyword, boolean withLBS, boolean disableCorrectionQuery, SearchChannelConditonFilter channelConditionFilter, SearchGroupConditonFilter groupConditionFilter, String source, int pagemode, RefreshType refreshType, boolean needNotify) {
        SearchMiniAppConditonFilter n26 = n2();
        Logger.f235387a.d().d("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "sendRequest currentMiniAppConditionFilter: " + n26);
        PullToRefreshState value = this.pullToRefreshStateLiveData.getValue();
        if (value != null) {
            value.c(false);
        }
        this.dataRepo.b(context, keyword, withLBS, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, n26, source, 0, pagemode, new e(n26, refreshType, needNotify, keyword));
    }

    static /* synthetic */ void O2(k kVar, Activity activity, String str, boolean z16, boolean z17, SearchChannelConditonFilter searchChannelConditonFilter, SearchGroupConditonFilter searchGroupConditonFilter, String str2, int i3, RefreshType refreshType, boolean z18, int i16, Object obj) {
        boolean z19;
        if (obj == null) {
            if ((i16 & 512) != 0) {
                z19 = true;
            } else {
                z19 = z18;
            }
            kVar.N2(activity, str, z16, z17, searchChannelConditonFilter, searchGroupConditonFilter, str2, i3, refreshType, z19);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendRequest");
    }

    private final void P2(List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
        int i3 = -1;
        int i16 = 0;
        for (Object obj : dataList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.search.searchdetail.c cVar = (com.tencent.mobileqq.search.searchdetail.c) obj;
            if (cVar instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.f) {
                if (i16 == 0) {
                    i3++;
                    ((com.tencent.mobileqq.search.searchdetail.content.template.model.f) cVar).v(i3);
                } else {
                    com.tencent.mobileqq.search.searchdetail.content.template.model.f fVar = (com.tencent.mobileqq.search.searchdetail.content.template.model.f) cVar;
                    float f16 = fVar.getLayoutInfo().marginTop;
                    com.tencent.mobileqq.search.searchdetail.c cVar2 = dataList.get(i16 - 1);
                    if (f16 > 0.0f) {
                        fVar.v(0);
                    } else if (cVar2 instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.f) {
                        i3++;
                        fVar.v(i3);
                    } else {
                        fVar.v(0);
                    }
                    i3 = 0;
                }
            } else {
                i3 = -1;
            }
            i16 = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S2(String guildId, int status) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("guildId", guildId);
        jSONObject.put("status", status);
        I2(new QSearchPostEvent("update_guild_join_status", jSONObject));
    }

    private final void c2(String guildId, int status) {
        Long longOrNull;
        com.tencent.mobileqq.search.searchdetail.content.template.model.k kVar;
        boolean z16;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            List<com.tencent.mobileqq.search.searchdetail.a> list = this.dataList;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = null;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.search.searchdetail.a aVar = (com.tencent.mobileqq.search.searchdetail.a) it.next();
                if (aVar instanceof NetSearchTemplateNineBoxGridItem) {
                    netSearchTemplateNineBoxGridItem = (NetSearchTemplateNineBoxGridItem) aVar;
                }
                if (netSearchTemplateNineBoxGridItem != null) {
                    arrayList.add(netSearchTemplateNineBoxGridItem);
                }
            }
            ArrayList<NetSearchTemplateNineBoxGridItem> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                Long guildId2 = ((NetSearchTemplateNineBoxGridItem) obj).getGuildId();
                if (guildId2 != null && guildId2.longValue() == longValue) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            for (NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 : arrayList2) {
                int indexOf = this.dataList.indexOf(netSearchTemplateNineBoxGridItem2);
                NetSearchTemplateNineBoxGridItem clone = netSearchTemplateNineBoxGridItem2.clone();
                clone.X(status);
                com.tencent.mobileqq.search.searchdetail.content.template.model.k buttonInfo = clone.getButtonInfo();
                if (buttonInfo != null) {
                    kVar = buttonInfo.clone();
                } else {
                    kVar = null;
                }
                if (kVar != null) {
                    kVar.c(status);
                }
                clone.W(kVar);
                this.dataList.remove(indexOf);
                this.dataList.add(indexOf, clone);
            }
        }
    }

    private final void d2(SearchAppendingInfoRsp rsp, ArrayList<SearchAppendItem> searchResultItem) {
        String str;
        ArrayList<SearchAppendingInfo> arrayList = rsp.list;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.list");
        for (SearchAppendingInfo searchAppendingInfo : arrayList) {
            SearchDetailTabContentRepo searchDetailTabContentRepo = this.dataRepo;
            SearchTabContent searchTabContent = searchAppendingInfo.tabContent;
            Intrinsics.checkNotNullExpressionValue(searchTabContent, "appendData.tabContent");
            SearchDetailTabContentFragment.PageData pageData = this.pageData;
            if (pageData == null || (str = pageData.getKeyword()) == null) {
                str = "";
            }
            com.tencent.mobileqq.search.searchdetail.a q16 = searchDetailTabContentRepo.q(searchTabContent, str);
            if (q16 != null && (q16 instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.a)) {
                String str2 = searchAppendingInfo.docId;
                Intrinsics.checkNotNullExpressionValue(str2, "appendData.docId");
                searchResultItem.add(new SearchAppendItem(str2, (com.tencent.mobileqq.search.searchdetail.content.template.model.a) q16));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List h2(k kVar, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                function1 = null;
            }
            return kVar.g2(function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDataList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postProcessExtData(String extData) {
        boolean z16;
        int a16;
        if (extData != null && extData.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (a16 = qp2.f.a(extData)) != -1) {
            this.totalCountWithoutTitle += a16;
        }
    }

    private final void setItemPageNumAndPosition(List<? extends com.tencent.mobileqq.search.searchdetail.c> dataList) {
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar;
        JSONObject jsonReportInfo;
        for (com.tencent.mobileqq.search.searchdetail.c cVar : dataList) {
            cVar.c(this.pageNum);
            Integer num = null;
            if (cVar instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.a) {
                aVar = (com.tencent.mobileqq.search.searchdetail.content.template.model.a) cVar;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = aVar.getReportInfoWrapper();
                if (reportInfoWrapper != null && (jsonReportInfo = reportInfoWrapper.getJsonReportInfo()) != null) {
                    num = Integer.valueOf(jsonReportInfo.optInt("serial_number", -1));
                }
                if (num != null && num.intValue() != -1) {
                    aVar.o(this.totalCountWithoutTitle + num.intValue());
                }
            }
        }
    }

    private final void v2(long convertTimeCost, ArrayList<SearchAppendItem> searchResultItem) {
        Iterator it;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder("handle appendList convertTimeCost=");
        sb5.append(convertTimeCost);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it5 = searchResultItem.iterator();
        boolean z16 = false;
        int i16 = 0;
        while (it5.hasNext()) {
            Object next = it5.next();
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SearchAppendItem searchAppendItem = (SearchAppendItem) next;
            long currentTimeMillis2 = System.currentTimeMillis();
            Iterator<com.tencent.mobileqq.search.searchdetail.a> it6 = this.dataList.iterator();
            int i18 = 0;
            while (true) {
                if (it6.hasNext()) {
                    it = it5;
                    if (Intrinsics.areEqual(it6.next().k(), searchAppendItem.getDocId())) {
                        break;
                    }
                    i18++;
                    it5 = it;
                } else {
                    it = it5;
                    i18 = -1;
                    break;
                }
            }
            sb5.append(" find ");
            sb5.append(i16);
            sb5.append(" item time cost=");
            sb5.append(System.currentTimeMillis() - currentTimeMillis2);
            if (i18 >= 0) {
                if (this.dataList.get(i18) instanceof NetSearchTemplateNineBoxGridItem) {
                    Integer num = (Integer) linkedHashMap.get(searchAppendItem.getDocId());
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    this.dataList.add(i18 + i3 + 1, searchAppendItem.getItem());
                    linkedHashMap.put(searchAppendItem.getDocId(), Integer.valueOf(i3 + 1));
                    Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "appendItem after pos:" + i18 + " hasAppendCount:" + i3 + " item:" + searchAppendItem.getItem().hashCode() + " item:" + searchAppendItem.getItem());
                    z16 = true;
                } else {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "find error item pos:" + i18 + " docId:" + searchAppendItem.getDocId() + " " + searchAppendItem;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it7 = bVar.a().iterator();
                    while (it7.hasNext()) {
                        Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, (String) it7.next(), null);
                    }
                }
            }
            it5 = it;
            i16 = i17;
        }
        if (z16) {
            this.searchEventPostLiveData.setValue(new QSearchPostEvent("event_append_data", new JSONObject()));
        }
        sb5.append(" mainTimeCost=");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
            Log.d("QQSearch.NetDetail.SearchDetailTabContentViewModel", sb6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[LOOP:0: B:32:0x00df->B:57:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w2(int businessType, String channelExtensionInfo, String searchExtensionInfo, String from) {
        byte b16;
        String str;
        long j3;
        byte b17;
        String str2;
        JSONObject jsonReportInfo;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        byte b18;
        SearchDetailTabListViewModel.TabInfo tabInfo2;
        SearchDetailTabListViewModel.TabInfo tabInfo3;
        if (businessType == 29) {
            if (channelExtensionInfo.length() > 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 != false) {
                JSONObject a16 = ad.f284990a.a(searchExtensionInfo);
                Object obj = null;
                r4 = null;
                String str3 = null;
                if (a16 != null) {
                    int optInt = a16.optInt("tabMask", 0);
                    SearchDetailTabContentFragment.PageData pageData = this.pageData;
                    if (pageData != null && (tabInfo3 = pageData.getTabInfo()) != null && optInt == ((int) tabInfo3.getTabMask())) {
                        b18 = true;
                    } else {
                        b18 = false;
                    }
                    if (b18 == false) {
                        Logger.a d16 = Logger.f235387a.d();
                        SearchDetailTabContentFragment.PageData pageData2 = getPageData();
                        if (pageData2 != null && (tabInfo2 = pageData2.getTabInfo()) != null) {
                            str3 = tabInfo2.getTabName();
                        }
                        d16.i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "onReceive tabInfo=" + str3 + " not self " + from + " " + businessType + " " + channelExtensionInfo + " " + searchExtensionInfo);
                        return;
                    }
                }
                Logger.a d17 = Logger.f235387a.d();
                SearchDetailTabContentFragment.PageData pageData3 = getPageData();
                if (pageData3 != null && (tabInfo = pageData3.getTabInfo()) != null) {
                    str = tabInfo.getTabName();
                } else {
                    str = null;
                }
                d17.i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "onReceive " + from + " tabInfo=" + str + " businessType=" + businessType + " " + channelExtensionInfo + " " + searchExtensionInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.dataList);
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    com.tencent.mobileqq.search.searchdetail.a aVar = (com.tencent.mobileqq.search.searchdetail.a) next;
                    if (aVar instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.a) {
                        com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) aVar).getReportInfoWrapper();
                        if (reportInfoWrapper != null && (jsonReportInfo = reportInfoWrapper.getJsonReportInfo()) != null) {
                            str2 = jsonReportInfo.optString("sgrp_channel_extension_info");
                        } else {
                            str2 = null;
                        }
                        if (Intrinsics.areEqual(str2, channelExtensionInfo)) {
                            b17 = true;
                            if (b17 == false) {
                                obj = next;
                                break;
                            }
                        }
                    }
                    b17 = false;
                    if (b17 == false) {
                    }
                }
                com.tencent.mobileqq.search.searchdetail.a aVar2 = (com.tencent.mobileqq.search.searchdetail.a) obj;
                if (aVar2 != null) {
                    Long l3 = aVar2.l();
                    if (l3 != null) {
                        j3 = l3.longValue();
                    } else {
                        j3 = 0;
                    }
                    K2(j3, aVar2.k(), aVar2.getCommonInfo().getTraceId(), Intrinsics.areEqual(from, "GuildFeedDetailInteractiveEvent"));
                }
            }
        }
    }

    private final boolean x2(long guildId, String docId) {
        boolean z16;
        Iterator<com.tencent.mobileqq.search.searchdetail.a> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                com.tencent.mobileqq.search.searchdetail.a next = it.next();
                if ((next instanceof NetSearchVerticalDetailTemplateItem) && ((NetSearchVerticalDetailTemplateItem) next).l().longValue() == guildId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            return false;
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "requestAppendList already has item. guildId=" + guildId + " docId=" + docId);
        return true;
    }

    private final boolean z2(long guildId) {
        boolean z16;
        IGPSService iGPSService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")) != null) {
            z16 = iGPSService.isGuildMember(String.valueOf(guildId));
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailTabContentViewModel", "requestAppendList not guest guildId=" + guildId);
            return true;
        }
        return true;
    }

    public void A2(@NotNull String keyword, @NotNull LoadMoreType loadMoreType, @NotNull String source) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(source, "source");
        e2(keyword, null, null, source, loadMoreType);
    }

    public void B2(int resultCode, @Nullable List<SearchMiniAppConditonFilter> filters, boolean fromLoadMore) {
        this.searchFilterLiveData.setValue("changed");
    }

    public final void D2(@NotNull UpdateParentTpEvent event) {
        SearchDetailTabContentFragment.PageData pageData;
        Intrinsics.checkNotNullParameter(event, "event");
        SearchDetailTabListViewModel.TabInfo tabInfo = event.getTabInfo();
        if ((tabInfo.getTabMask() == 1 || tabInfo.getTabMask() == 7) && (pageData = this.pageData) != null) {
            pageData.p(10);
            pageData.t(event.getWxPreSearchId());
            this.dataRepo.D(pageData.getTabInfo(), pageData.getQuerySource(), pageData.getUserSource(), pageData.getWxPreSearchId(), Integer.valueOf(pageData.getParentType()), null);
        }
    }

    public final void G2(@NotNull GuildFeedDetailViewDestroyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        w2(event.getBusinessType(), event.getChannelExtensionInfo(), event.getSearchExtensionInfo(), "GuildFeedDetailViewDestroyEvent");
    }

    public final void H2(@NotNull GuildFeedDetailInteractiveEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        w2(event.getBusinessType(), event.getChannelExtensionInfo(), event.getSearchExtensionInfo(), "GuildFeedDetailInteractiveEvent");
    }

    public final void I2(@NotNull QSearchPostEvent event) {
        boolean z16;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(event, "event");
        String eventName = event.getEventName();
        int hashCode = eventName.hashCode();
        int i3 = 0;
        if (hashCode != -1956599484) {
            if (hashCode != -561987688) {
                if (hashCode == 680776805 && eventName.equals("update_guild_join_status")) {
                    String guildId = event.getEventData().optString("guildId");
                    int optInt = event.getEventData().optInt("status");
                    for (Object obj : this.dataList) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        Object obj2 = (com.tencent.mobileqq.search.searchdetail.a) obj;
                        if (obj2 instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.g) {
                            List<com.tencent.mobileqq.search.searchdetail.a> list = this.dataList;
                            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                            list.set(i3, ((com.tencent.mobileqq.search.searchdetail.content.template.model.g) obj2).d(guildId, optInt));
                        }
                        i3 = i16;
                    }
                    Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                    c2(guildId, optInt);
                }
            } else if (eventName.equals("update_open_mini_app")) {
                String appId = event.getEventData().optString("mini_app_id");
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                if (appId.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                List<com.tencent.mobileqq.search.searchdetail.a> list2 = this.dataList;
                ArrayList<com.tencent.mobileqq.search.searchdetail.a> arrayList = new ArrayList();
                for (Object obj3 : list2) {
                    com.tencent.mobileqq.search.searchdetail.a aVar = (com.tencent.mobileqq.search.searchdetail.a) obj3;
                    if (!(aVar instanceof NetSearchVerticalDetailTemplateItem)) {
                        areEqual = false;
                    } else {
                        areEqual = Intrinsics.areEqual(((NetSearchVerticalDetailTemplateItem) aVar).getAppId(), appId);
                    }
                    if (areEqual) {
                        arrayList.add(obj3);
                    }
                }
                for (com.tencent.mobileqq.search.searchdetail.a aVar2 : arrayList) {
                    Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchVerticalDetailTemplateItem");
                    NetSearchVerticalDetailTemplateItem netSearchVerticalDetailTemplateItem = (NetSearchVerticalDetailTemplateItem) aVar2;
                    this.dataList.set(this.dataList.indexOf(netSearchVerticalDetailTemplateItem), netSearchVerticalDetailTemplateItem.x());
                }
            }
        } else if (eventName.equals("update_troop_join_status")) {
            String troopUin = event.getEventData().optString("troop_uin");
            int optInt2 = event.getEventData().optInt("status");
            for (Object obj4 : this.dataList) {
                int i17 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Object obj5 = (com.tencent.mobileqq.search.searchdetail.a) obj4;
                if (obj5 instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.g) {
                    List<com.tencent.mobileqq.search.searchdetail.a> list3 = this.dataList;
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    list3.set(i3, ((com.tencent.mobileqq.search.searchdetail.content.template.model.g) obj5).h(troopUin, optInt2));
                }
                i3 = i17;
            }
        }
        this.searchEventPostLiveData.setValue(event);
    }

    public final void J2(@NotNull com.tencent.mobileqq.search.searchdetail.c item) {
        Intrinsics.checkNotNullParameter(item, "item");
        TypeIntrinsics.asMutableCollection(this.dataList).remove(item);
        if (this.dataList.isEmpty()) {
            Q2(GlobalUtil.DEF_STRING);
        }
    }

    public final void K2(long guildId, @NotNull String docId, @NotNull String currentTraceId, boolean forceReq) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(currentTraceId, "currentTraceId");
        if (guildId != 0) {
            boolean z17 = false;
            if (docId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (currentTraceId.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    if (z2(guildId) || x2(guildId, docId)) {
                        return;
                    }
                    com.tencent.mobileqq.search.searchdetail.content.repo.e eVar = this.appendDataRepo;
                    String valueOf = String.valueOf(guildId);
                    SearchDetailTabContentFragment.PageData pageData = this.pageData;
                    if (pageData == null || (str = pageData.getKeyword()) == null) {
                        str = "";
                    }
                    eVar.b(valueOf, docId, str, currentTraceId, forceReq, new IGetSearchAppendingInfoCallback() { // from class: com.tencent.mobileqq.search.searchdetail.content.viewmodel.i
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSearchAppendingInfoCallback
                        public final void onResult(int i3, String str2, SearchAppendingInfoRsp searchAppendingInfoRsp) {
                            k.L2(k.this, i3, str2, searchAppendingInfoRsp);
                        }
                    });
                    return;
                }
            }
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "requestAppendList error guildId=" + guildId + " docId=" + docId + " currentTraceId=" + currentTraceId);
    }

    public final void Q2(@NotNull String newState) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        Intrinsics.checkNotNullParameter(newState, "newState");
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        d16.i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "setListState tabinfo=" + tabInfo + " old=" + ((Object) l2().getValue()) + " new=" + newState);
        if (!Intrinsics.areEqual(this.listStateLiveData.getValue(), newState)) {
            this.listStateLiveData.setValue(newState);
        }
    }

    public void R2(@NotNull Activity context, @NotNull String keyword, @NotNull RefreshType refreshType, @NotNull String source) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(source, "source");
        SearchDetailTabContentFragment.PageData pageData = this.pageData;
        if (pageData != null) {
            z16 = pageData.getDisableCorrectionQuery();
        } else {
            z16 = false;
        }
        f2(context, keyword, z16, refreshType, null, null, source);
    }

    public final void T2(@NotNull SearchDetailTabContentFragment.PageData pageData, @NotNull String pageSessionId) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(pageSessionId, "pageSessionId");
        this.pageData = pageData;
        this.dataRepo.D(pageData.getTabInfo(), pageData.getQuerySource(), pageData.getUserSource(), pageData.getWxPreSearchId(), Integer.valueOf(pageData.getParentType()), pageSessionId);
        this.appendDataRepo.c(pageData);
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabContentViewModel", 1, "updatePageData " + pageData);
        if (y2(pageData.getTabInfo())) {
            this.dataRepo.E(pageData.getFunctionPayload());
        }
    }

    public final void U2(@NotNull SearchPageType searchPageType) {
        Intrinsics.checkNotNullParameter(searchPageType, "searchPageType");
        this.searchPageType = searchPageType;
    }

    public final void e2(@NotNull String keyword, @Nullable SearchChannelConditonFilter channelConditionFilter, @Nullable SearchGroupConditonFilter groupConditionFilter, @NotNull String source, @NotNull LoadMoreType loadMoreType) {
        int i3;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        this.pageNum++;
        SearchDetailTabContentFragment.PageData pageData = this.pageData;
        boolean z16 = false;
        if (pageData != null) {
            i3 = pageData.getPageMode();
        } else {
            i3 = 0;
        }
        LoadMoreState value = this.loadMoreStateLiveData.getValue();
        if (value != null) {
            value.c(false);
        }
        SearchDetailTabContentRepo searchDetailTabContentRepo = this.dataRepo;
        SearchDetailTabContentFragment.PageData pageData2 = this.pageData;
        if (pageData2 != null) {
            z16 = pageData2.getDisableCorrectionQuery();
        }
        searchDetailTabContentRepo.c(keyword, z16, channelConditionFilter, groupConditionFilter, n2(), source, this.pageNum, i3, new b(loadMoreType));
    }

    public final void f2(@NotNull Activity context, @NotNull String keyword, boolean disableCorrectionQuery, @NotNull RefreshType refreshType, @Nullable SearchChannelConditonFilter channelConditionFilter, @Nullable SearchGroupConditonFilter groupConditionFilter, @NotNull String source) {
        boolean isBlank;
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(source, "source");
        isBlank = StringsKt__StringsJVMKt.isBlank(keyword);
        if (isBlank) {
            return;
        }
        if (refreshType != RefreshType.TYPE_FINGER_PULL2REFRESH) {
            Q2(ToastView.ICON_LOADING);
        }
        if (refreshType != RefreshType.TYPE_FIRST_RENDER_SEARCH) {
            this.dataRepo.E("");
        }
        SearchDetailTabContentFragment.PageData pageData = this.pageData;
        if (pageData != null) {
            i3 = pageData.getPageMode();
        } else {
            i3 = 0;
        }
        int i16 = i3;
        ae aeVar = ae.f284991a;
        if (aeVar.f(context)) {
            O2(this, context, keyword, true, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, source, i16, refreshType, false, 512, null);
        } else {
            O2(this, context, keyword, false, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, source, i16, refreshType, false, 512, null);
            aeVar.h(context, new c(context, keyword, disableCorrectionQuery, channelConditionFilter, groupConditionFilter, source, i16, refreshType));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<com.tencent.mobileqq.search.searchdetail.c> g2(@Nullable Function1<? super com.tencent.mobileqq.search.searchdetail.c, Boolean> predicate) {
        ArrayList arrayList = new ArrayList();
        if (predicate != null) {
            List<com.tencent.mobileqq.search.searchdetail.a> list = this.dataList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (predicate.invoke(obj).booleanValue()) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll(arrayList2);
        } else {
            arrayList.addAll(this.dataList);
        }
        return arrayList;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    public ViewModelStore getViewModelStore() {
        return this._viewModelStore;
    }

    @NotNull
    /* renamed from: i2, reason: from getter */
    public final SearchEmptyPageExtraInfo getEmptyPageExtraInfo() {
        return this.emptyPageExtraInfo;
    }

    @NotNull
    public final MutableLiveData<SearchFloatButton> j2() {
        return this.floatButtonInfoLiveData;
    }

    @NotNull
    /* renamed from: k2, reason: from getter */
    public final String getLastRequestLocalTraceId() {
        return this.lastRequestLocalTraceId;
    }

    @NotNull
    public final MutableLiveData<String> l2() {
        return this.listStateLiveData;
    }

    @NotNull
    public final MutableLiveData<LoadMoreState> m2() {
        return this.loadMoreStateLiveData;
    }

    @Nullable
    public SearchMiniAppConditonFilter n2() {
        return null;
    }

    @Nullable
    /* renamed from: o2, reason: from getter */
    public final SearchDetailTabContentFragment.PageData getPageData() {
        return this.pageData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        AppInterface appInterface;
        this._viewModelStore.clear();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService;
        if (iGProGlobalService != null) {
            iGProGlobalService.deleteObserver(this.gpServiceObserver);
        }
    }

    @NotNull
    public final MutableLiveData<PullToRefreshState> p2() {
        return this.pullToRefreshStateLiveData;
    }

    @NotNull
    public final MutableLiveData<QSearchPostEvent> q2() {
        return this.searchEventPostLiveData;
    }

    @NotNull
    public final MutableLiveData<String> r2() {
        return this.searchFilterLiveData;
    }

    @NotNull
    /* renamed from: s2, reason: from getter */
    public final SearchPageType getSearchPageType() {
        return this.searchPageType;
    }

    @NotNull
    public final MutableLiveData<String> t2() {
        return this.searchSuccLiveData;
    }

    @NotNull
    /* renamed from: u2, reason: from getter */
    public final String getTopicName() {
        return this.topicName;
    }

    public final boolean y2(@NotNull SearchDetailTabListViewModel.TabInfo tabInfo) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        if (((int) tabInfo.getTabMask()) == 1) {
            return true;
        }
        return false;
    }
}
