package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.utils.AVUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.h;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.guild.component.banner.indicator.SimpleBannerIndicator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.util.SearchBoxWordsUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.exp.model.c;
import com.tencent.mobileqq.troop.findTroop.util.a;
import com.tencent.mobileqq.troop.findTroop.util.b;
import com.tencent.mobileqq.troop.recommend.c;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.ao;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.videocut.utils.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Banner;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$RecommendTab;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00b5\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00b6\u0001B\t\u00a2\u0006\u0006\b\u00b3\u0001\u0010\u00b4\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0002J \u0010*\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010)\u001a\u00020(H\u0002J(\u0010-\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010,\u001a\u00020+H\u0002Jd\u0010:\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\n\b\u0002\u00100\u001a\u0004\u0018\u00010%2\n\b\u0002\u00101\u001a\u0004\u0018\u00010%2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0002\b\u0003\u0018\u0001022\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\n\b\u0002\u00107\u001a\u0004\u0018\u0001062\n\b\u0002\u00109\u001a\u0004\u0018\u000108H\u0002J\b\u0010;\u001a\u00020\u0004H\u0002J\b\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020\u0004H\u0002J\b\u0010>\u001a\u00020\nH\u0014J\b\u0010@\u001a\u00020?H\u0016J\u001a\u0010C\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u00020\u0004H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\b\u0010F\u001a\u00020\u0004H\u0016J\u0006\u0010G\u001a\u00020\u0004J\u0006\u0010H\u001a\u00020\u0004J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020IH\u0016J\b\u0010M\u001a\u00020LH\u0016J$\u0010P\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010%2\b\u0010O\u001a\u0004\u0018\u00010%H\u0016R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR(\u0010|\u001a\b\u0012\u0004\u0012\u00020u0t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008a\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010iR\u0018\u0010\u008c\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010iR\u001b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0096\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0099\u0001R)\u0010\u00a3\u0001\u001a\u0012\u0012\u0004\u0012\u00020%0\u0014j\b\u0012\u0004\u0012\u00020%`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0017\u0010\u00a6\u0001\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001c\u0010\u00aa\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u0018\u0010\u00ae\u0001\u001a\u00030\u00ab\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u0018\u0010\u00b2\u0001\u001a\u00030\u00af\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001\u00a8\u0006\u00b7\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/troop/findTroop/util/b;", "Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;", "", "initView", "initData", "ai", "Xh", "Th", "", "position", "ii", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "dataList", "mi", "li", "ni", "recommendItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "Lkotlin/collections/ArrayList;", "Ph", "icon", "msgId", "qi", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "Rh", "", "Sh", "Lcom/tencent/mobileqq/troop/exp/model/b;", "Qh", "Vh", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "errorMsg", "pi", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Yh", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", "Mh", "Landroid/view/View;", "view", "pageId", "elementId", "", "param", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Nh", "ri", "Zh", "ki", "getContentLayoutId", "", "useQUISecNavBar", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Wh", "scrollToTop", "", "event", "R2", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "F5", "hintText", "reportData", "onHintChange", "Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "expTroopViewModel", "D", "Ljava/lang/String;", "troopRecommendType", "Landroid/widget/ProgressBar;", "E", "Landroid/widget/ProgressBar;", "waitingProgressBar", "Lu60/c;", UserInfo.SEX_FEMALE, "Lu60/c;", "searchPagePerfReporter", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/CommonRefreshLayout;", "G", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/CommonRefreshLayout;", "commonRefreshWrapperLayout", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/ContactRefreshHeader;", "H", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/ContactRefreshHeader;", "commonRefreshHeader", "Lcom/tencent/mobileqq/activity/contacts/base/HeaderScrollView;", "I", "Lcom/tencent/mobileqq/activity/contacts/base/HeaderScrollView;", "headerScrollView", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "J", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "quiSearchBar", "Landroid/widget/EditText;", "K", "Landroid/widget/EditText;", "searchEditText", "", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/f;", "L", "Ljava/util/List;", "Uh", "()Ljava/util/List;", "setTroopClassifyInfos", "(Ljava/util/List;)V", "troopClassifyInfos", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "M", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "quiTabPageBar", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsViewPager;", "N", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsViewPager;", "troopFragmentViewPager", "Lcom/tencent/mobileqq/activity/contact/addcontact/findtroop/a;", "P", "Lcom/tencent/mobileqq/activity/contact/addcontact/findtroop/a;", "troopFragmentViewPagerAdapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "currentClassifyPos", BdhLogUtil.LogTag.Tag_Req, "previousClassifyPos", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "mGestureLayout", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "T", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "bannerLayout", "U", "Lcom/tencent/mobileqq/troop/exp/model/b;", "bannerLayoutAdapter", "Landroid/widget/FrameLayout;", "V", "Landroid/widget/FrameLayout;", "bannerArea", "Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator;", "W", "Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator;", "bannerIndicator", "X", "emptyLayout", "Y", "Ljava/util/ArrayList;", "hintWords", "Z", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "troopTabNodeManager", "Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "a0", "Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "hintChangeListenerImpWithEditAreaAdjustWidth", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "b0", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "guildSearchRecommendObserver", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/a;", "c0", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/a;", "onRefreshListener", "<init>", "()V", "d0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class RecommendTroopFragment extends QIphoneTitleBarFragment implements com.tencent.mobileqq.troop.findTroop.util.b, AutoHintLayout.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.exp.viewmodel.b expTroopViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final String troopRecommendType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ProgressBar waitingProgressBar;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final u60.c searchPagePerfReporter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private CommonRefreshLayout commonRefreshWrapperLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ContactRefreshHeader commonRefreshHeader;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private HeaderScrollView headerScrollView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QUISearchBar quiSearchBar;

    /* renamed from: K, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public EditText searchEditText;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.activity.contacts.base.tabs.f> troopClassifyInfos;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QUIPageTabBar quiTabPageBar;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ContactsViewPager troopFragmentViewPager;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.contact.addcontact.findtroop.a troopFragmentViewPagerAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private int currentClassifyPos;

    /* renamed from: R, reason: from kotlin metadata */
    private int previousClassifyPos;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private TopGestureLayout mGestureLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private BannerLayout bannerLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.exp.model.b bannerLayoutAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private FrameLayout bannerArea;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private SimpleBannerIndicator bannerIndicator;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private FrameLayout emptyLayout;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private ArrayList<String> hintWords;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.findTroop.util.c troopTabNodeManager;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.searchdetail.content.view.a hintChangeListenerImpWithEditAreaAdjustWidth;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.exp.viewmodel.d guildSearchRecommendObserver;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.contacts.pullrefresh.a onRefreshListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopFragment$a;", "", "", "KEY_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopFragment$b", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "", "isSuccess", "", "itemType", "", "keyWord", "serverPageID", "isEnd", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.troop.exp.viewmodel.d {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.exp.viewmodel.d
        public void a(boolean isSuccess, int itemType, @Nullable String keyWord, int serverPageID, boolean isEnd, @Nullable List<? extends c.a> dataList, @NotNull guildSearchRecommendSvr$FirstShow firstShow, @NotNull ByteStringMicro sessionInfo, boolean isLoadMore) {
            Intrinsics.checkNotNullParameter(firstShow, "firstShow");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            RecommendTroopFragment.this.hideLoading();
            boolean z16 = true;
            if (!isSuccess) {
                RecommendTroopFragment.this.qi(1, R.string.hqe);
            }
            CommonRefreshLayout commonRefreshLayout = RecommendTroopFragment.this.commonRefreshWrapperLayout;
            if (commonRefreshLayout == null || !commonRefreshLayout.p()) {
                z16 = false;
            }
            if (z16) {
                RecommendTroopFragment.this.Wh();
            }
            if (firstShow.recommend_tab.size() > 0) {
                RecommendTroopFragment.this.Vh();
                RecommendTroopFragment.this.Yh(dataList, firstShow);
                RecommendTroopFragment.this.Mh(dataList, firstShow, sessionInfo);
            }
            if (RecommendTroopFragment.this.Uh().size() == 0) {
                RecommendTroopFragment.this.pi(16, "\u6682\u65e0\u6570\u636e");
            }
            RecommendTroopFragment.this.mi(dataList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopFragment$c", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends ViewPager.SimpleOnPageChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendTroopFragment.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
            } else if (state == 1) {
                RecommendTroopFragment recommendTroopFragment = RecommendTroopFragment.this;
                ContactsViewPager contactsViewPager = recommendTroopFragment.troopFragmentViewPager;
                Intrinsics.checkNotNull(contactsViewPager);
                recommendTroopFragment.previousClassifyPos = contactsViewPager.getCurrentItem();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RecommendTroopFragment.this.ii(position);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopFragment$d", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends ViewModelProvider.NewInstanceFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppInterface f181314c;

        d(AppInterface appInterface) {
            this.f181314c = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (modelClass.isAssignableFrom(com.tencent.mobileqq.troop.exp.viewmodel.b.class)) {
                return new com.tencent.mobileqq.troop.exp.viewmodel.b(this.f181314c);
            }
            return (T) super.create(modelClass);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RecommendTroopFragment() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("first_classific", "");
        } else {
            str = null;
        }
        this.troopRecommendType = str;
        this.searchPagePerfReporter = new u60.c();
        this.troopClassifyInfos = new ArrayList();
        this.previousClassifyPos = -1;
        this.bannerLayoutAdapter = Qh();
        this.hintWords = new ArrayList<>();
        this.troopTabNodeManager = new com.tencent.mobileqq.troop.findTroop.util.c(this);
        this.guildSearchRecommendObserver = new b();
        this.onRefreshListener = new com.tencent.mobileqq.activity.contacts.pullrefresh.a() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.a
            @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.a
            public final void onRefresh() {
                RecommendTroopFragment.hi(RecommendTroopFragment.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(List<? extends c.a> dataList, guildSearchRecommendSvr$FirstShow firstShow, ByteStringMicro sessionInfo) {
        com.tencent.mobileqq.troop.exp.a aVar = com.tencent.mobileqq.troop.exp.a.f295373a;
        aVar.e(new com.tencent.mobileqq.troop.exp.model.a(dataList, firstShow, sessionInfo));
        aVar.d(System.currentTimeMillis());
    }

    private final void Nh(View view, String pageId, String elementId, Map<String, ?> param, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy) {
        if (pageId != null) {
            VideoReport.setPageId(view, pageId);
        }
        if (elementId != null) {
            VideoReport.setElementId(view, elementId);
        }
        if (param != null) {
            VideoReport.setElementParams(view, param);
        }
        if (exposurePolicy != null) {
            VideoReport.setElementExposePolicy(view, exposurePolicy);
        }
        if (endExposurePolicy != null) {
            VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
        }
        if (clickPolicy != null) {
            VideoReport.setElementClickPolicy(view, clickPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Oh(RecommendTroopFragment recommendTroopFragment, View view, String str, String str2, Map map, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, int i3, Object obj) {
        String str3;
        String str4;
        Map map2;
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        ClickPolicy clickPolicy2 = null;
        if ((i3 & 2) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i3 & 4) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 8) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i3 & 16) != 0) {
            exposurePolicy2 = null;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 32) != 0) {
            endExposurePolicy2 = null;
        } else {
            endExposurePolicy2 = endExposurePolicy;
        }
        if ((i3 & 64) == 0) {
            clickPolicy2 = clickPolicy;
        }
        recommendTroopFragment.Nh(view, str3, str4, map2, exposurePolicy2, endExposurePolicy2, clickPolicy2);
    }

    private final ArrayList<RecommendTroopItem> Ph(List<? extends c.a> recommendItemList) {
        ArrayList<RecommendTroopItem> arrayList = new ArrayList<>();
        for (c.a aVar : recommendItemList) {
            RecommendTroopItem recommendTroopItem = new RecommendTroopItem();
            recommendTroopItem.uin = aVar.f298245a;
            recommendTroopItem.name = aVar.f298246b;
            recommendTroopItem.intro = aVar.f298247c;
            recommendTroopItem.labelList = com.tencent.mobileqq.troop.recommend.b.b(aVar.f298249e);
            recommendTroopItem.stateList = com.tencent.mobileqq.troop.recommend.b.b(aVar.f298251g);
            recommendTroopItem.icon = aVar.f298258n;
            recommendTroopItem.type = aVar.f298257m;
            recommendTroopItem.memberNum = aVar.f298248d;
            recommendTroopItem.authSig = aVar.f298254j;
            recommendTroopItem.activity = aVar.f298255k;
            recommendTroopItem.privilege = aVar.f298256l;
            recommendTroopItem.recomAlgol = aVar.f298253i;
            recommendTroopItem.labels = aVar.f298250f;
            recommendTroopItem.medalInfoList = aVar.f298252h;
            recommendTroopItem.gameGradeIcon = com.tencent.mobileqq.troop.recommend.b.a(aVar.f298249e);
            recommendTroopItem.recommendTrace = aVar.f298259o;
            arrayList.add(recommendTroopItem);
        }
        return arrayList;
    }

    private final com.tencent.mobileqq.troop.exp.model.b Qh() {
        com.tencent.mobileqq.troop.exp.model.b bVar = new com.tencent.mobileqq.troop.exp.model.b();
        bVar.k0(new RecommendTroopFragment$createBannerAdapter$1$1(this));
        return bVar;
    }

    private final TopGestureLayout Rh() {
        View decorView = getQBaseActivity().getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null && (childAt instanceof ViewGroup)) {
            viewGroup = (ViewGroup) childAt;
        }
        if (viewGroup instanceof TopGestureLayout) {
            return (TopGestureLayout) viewGroup;
        }
        return null;
    }

    private final long Sh() {
        return System.currentTimeMillis();
    }

    private final void Th() {
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            showLoading();
            com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
            if (bVar != null) {
                bVar.R1(2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecommendTroopFragment", 2, "initData falied. network unavailable");
        }
        qi(1, R.string.f171139ci4);
        pi(5, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = this.emptyLayout;
        boolean z16 = false;
        if (frameLayout2 != null && frameLayout2.getVisibility() == 8) {
            z16 = true;
        }
        if (!z16 && (frameLayout = this.emptyLayout) != null) {
            frameLayout.setVisibility(8);
        }
    }

    private final void Xh() {
        ViewGroup.LayoutParams layoutParams;
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAdapter(this.bannerLayoutAdapter);
        }
        double g16 = (o.g() - al.a(getContext(), 32.0f)) / 2.5d;
        FrameLayout frameLayout = this.bannerArea;
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.height = (int) g16;
        com.tencent.mobileqq.guild.component.banner.a aVar = com.tencent.mobileqq.guild.component.banner.a.f215813a;
        BannerLayout bannerLayout2 = this.bannerLayout;
        Intrinsics.checkNotNull(bannerLayout2);
        ViewPager2 viewPager2 = bannerLayout2.getViewPager2();
        SimpleBannerIndicator simpleBannerIndicator = this.bannerIndicator;
        Intrinsics.checkNotNull(simpleBannerIndicator);
        aVar.a(viewPager2, simpleBannerIndicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(List<? extends c.a> dataList, guildSearchRecommendSvr$FirstShow firstShow) {
        int collectionSizeOrDefault;
        List<com.tencent.mobileqq.troop.exp.model.c> list;
        ArrayList<com.tencent.mobileqq.activity.contacts.base.tabs.f> arrayList = new ArrayList<>();
        List<guildSearchRecommendSvr$RecommendTab> list2 = firstShow.recommend_tab.get();
        Intrinsics.checkNotNullExpressionValue(list2, "firstShow.recommend_tab.get()");
        int i3 = 0;
        int i16 = 0;
        for (Object obj : list2) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.activity.contacts.base.tabs.f fVar = new com.tencent.mobileqq.activity.contacts.base.tabs.f();
            String str = ((guildSearchRecommendSvr$RecommendTab) obj).name.get();
            fVar.f181556c = str;
            fVar.f181554a = i3 + 100;
            if (TextUtils.equals(this.troopRecommendType, str)) {
                i16 = i3;
            }
            arrayList.add(fVar);
            i3 = i17;
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i18 = 0; i18 < size; i18++) {
            String str2 = arrayList.get(i18).f181556c;
            Intrinsics.checkNotNullExpressionValue(str2, "tabList[index].tabText");
            strArr[i18] = str2;
        }
        QUIPageTabBar qUIPageTabBar = this.quiTabPageBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setTabData(strArr);
        }
        this.troopClassifyInfos.clear();
        this.troopClassifyInfos.addAll(arrayList);
        com.tencent.mobileqq.activity.contact.addcontact.findtroop.a aVar = this.troopFragmentViewPagerAdapter;
        Intrinsics.checkNotNull(aVar);
        Intrinsics.checkNotNull(dataList);
        aVar.g(Ph(dataList));
        com.tencent.mobileqq.activity.contact.addcontact.findtroop.a aVar2 = this.troopFragmentViewPagerAdapter;
        Intrinsics.checkNotNull(aVar2);
        aVar2.i(arrayList);
        ContactsViewPager contactsViewPager = this.troopFragmentViewPager;
        Intrinsics.checkNotNull(contactsViewPager);
        contactsViewPager.setCurrentItem(i16, false);
        ii(i16);
        this.searchPagePerfReporter.a(com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181089a);
        if (firstShow.banners.size() > 0) {
            FrameLayout frameLayout = this.bannerArea;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            List<guildSearchRecommendSvr$Banner> list3 = firstShow.banners.get();
            Intrinsics.checkNotNullExpressionValue(list3, "firstShow.banners.get()");
            List<guildSearchRecommendSvr$Banner> list4 = list3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (guildSearchRecommendSvr$Banner it : list4) {
                c.Companion companion = com.tencent.mobileqq.troop.exp.model.c.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList2.add(companion.a(it));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList2);
            this.bannerLayoutAdapter.l0(list);
        } else {
            FrameLayout frameLayout2 = this.bannerArea;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        ni();
    }

    private final void Zh() {
        final QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null) {
            qUISearchBar.getAutoHintLayout().setInterval(5000L);
            qUISearchBar.getAutoHintLayout().setAnimDuration(400);
            this.hintChangeListenerImpWithEditAreaAdjustWidth = new com.tencent.mobileqq.search.searchdetail.content.view.a(qUISearchBar, this);
            qUISearchBar.getAutoHintLayout().m(this.hintChangeListenerImpWithEditAreaAdjustWidth);
            SearchBoxWordsUtil.c(5, new Function1<ArrayList<String>, Unit>(qUISearchBar) { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopFragment$initShadingHintWords$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUISearchBar $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = qUISearchBar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendTroopFragment.this, (Object) qUISearchBar);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull ArrayList<String> words) {
                    Map mapOf;
                    QUISearchBar qUISearchBar2;
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) words);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(words, "words");
                    int i3 = !words.isEmpty() ? 1 : 0;
                    if (i3 != 0) {
                        RecommendTroopFragment.this.hintWords = words;
                        this.$this_apply.setClipChildren(false);
                        this.$this_apply.getFlSearchExt().setVisibility(8);
                        this.$this_apply.getAutoHintLayout().setEnableFrondIconRunInAnim(true, this.$this_apply);
                        AutoHintLayout autoHintLayout = this.$this_apply.getAutoHintLayout();
                        arrayList = RecommendTroopFragment.this.hintWords;
                        autoHintLayout.setHintList(arrayList);
                        AutoHintLayout autoHintLayout2 = this.$this_apply.getAutoHintLayout();
                        arrayList2 = RecommendTroopFragment.this.hintWords;
                        autoHintLayout2.setReportDataList(arrayList2);
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_shading", Integer.valueOf(i3)));
                    qUISearchBar2 = RecommendTroopFragment.this.quiSearchBar;
                    VideoReport.setElementParams(qUISearchBar2, mapOf);
                }
            });
        }
    }

    private final void ai() {
        QUIPageTabBar qUIPageTabBar = this.quiTabPageBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        com.tencent.mobileqq.activity.contact.addcontact.findtroop.a aVar = new com.tencent.mobileqq.activity.contact.addcontact.findtroop.a(getFragmentManager(), (QQAppInterface) peekAppRuntime, arrayList);
        this.troopFragmentViewPagerAdapter = aVar;
        aVar.h(this.troopTabNodeManager);
        ContactsViewPager contactsViewPager = this.troopFragmentViewPager;
        if (contactsViewPager != null) {
            contactsViewPager.setAdapter(this.troopFragmentViewPagerAdapter);
        }
        ContactsViewPager contactsViewPager2 = this.troopFragmentViewPager;
        if (contactsViewPager2 != null) {
            contactsViewPager2.setOffscreenPageLimit(3);
        }
        ContactsViewPager contactsViewPager3 = this.troopFragmentViewPager;
        if (contactsViewPager3 != null) {
            contactsViewPager3.setOnPageChangeListener(new c());
        }
        QUIPageTabBar qUIPageTabBar2 = this.quiTabPageBar;
        if (qUIPageTabBar2 != null) {
            qUIPageTabBar2.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.f
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                public final void I0(int i3, boolean z16) {
                    RecommendTroopFragment.ci(RecommendTroopFragment.this, i3, z16);
                }
            });
        }
        QUIPageTabBar qUIPageTabBar3 = this.quiTabPageBar;
        if (qUIPageTabBar3 != null) {
            qUIPageTabBar3.setOnCurrentTabClickListener(new QUIPageTabBar.h() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.g
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
                public final void k1(int i3) {
                    RecommendTroopFragment.bi(RecommendTroopFragment.this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(RecommendTroopFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommonRefreshLayout commonRefreshLayout = this$0.commonRefreshWrapperLayout;
        if (commonRefreshLayout != null) {
            commonRefreshLayout.setRefreshing(true);
        }
        ContactRefreshHeader contactRefreshHeader = this$0.commonRefreshHeader;
        if (contactRefreshHeader != null) {
            contactRefreshHeader.h(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(RecommendTroopFragment this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("RecommendTroopFragment", 2, "quiTabPageBar TabChange. position:" + i3);
        }
        ContactsViewPager contactsViewPager = this$0.troopFragmentViewPager;
        Intrinsics.checkNotNull(contactsViewPager);
        this$0.previousClassifyPos = contactsViewPager.getCurrentItem();
        this$0.currentClassifyPos = i3;
        ContactsViewPager contactsViewPager2 = this$0.troopFragmentViewPager;
        if (contactsViewPager2 != null) {
            contactsViewPager2.setCurrentItem(i3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(RecommendTroopFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ri();
        this$0.ki();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ei(RecommendTroopFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.Sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(RecommendTroopFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ri();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(RecommendTroopFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scrollToTop();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(RecommendTroopFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.searchPagePerfReporter.c();
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            if (this$0.troopClassifyInfos.size() > 0) {
                if (this$0.troopFragmentViewPagerAdapter != null && this$0.troopFragmentViewPager != null) {
                    String nodeId = this$0.troopClassifyInfos.get(this$0.currentClassifyPos).f181556c;
                    com.tencent.mobileqq.troop.findTroop.util.c cVar = this$0.troopTabNodeManager;
                    Intrinsics.checkNotNullExpressionValue(nodeId, "nodeId");
                    cVar.c(nodeId, a.b.f296033a);
                    return;
                }
                return;
            }
            this$0.Th();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecommendTroopFragment", 2, "refresh falied. network unavailable");
        }
        this$0.Wh();
        if (this$0.troopClassifyInfos.size() == 0) {
            this$0.pi(5, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        ProgressBar progressBar = this.waitingProgressBar;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii(int position) {
        if (QLog.isColorLevel()) {
            QLog.d("RecommendTroopFragment", 2, "onSelectedNewClassifyPosition. position:" + position);
        }
        QUIPageTabBar qUIPageTabBar = this.quiTabPageBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setCurrentPosition(position, true);
        }
        String lastTabText = this.troopClassifyInfos.get(this.currentClassifyPos).f181556c;
        final String currentTabText = this.troopClassifyInfos.get(position).f181556c;
        if (this.currentClassifyPos != position) {
            com.tencent.mobileqq.troop.findTroop.util.c cVar = this.troopTabNodeManager;
            Intrinsics.checkNotNullExpressionValue(lastTabText, "lastTabText");
            cVar.c(lastTabText, new a.d(false));
        }
        com.tencent.mobileqq.troop.findTroop.util.c cVar2 = this.troopTabNodeManager;
        Intrinsics.checkNotNullExpressionValue(currentTabText, "currentTabText");
        cVar2.c(currentTabText, new a.d(true));
        this.currentClassifyPos = position;
        HeaderScrollView headerScrollView = this.headerScrollView;
        Intrinsics.checkNotNull(headerScrollView);
        headerScrollView.setCurrentScrollableContainer(new h.a() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.h
            @Override // com.tencent.mobileqq.activity.contacts.base.h.a
            public final View getScrollableView() {
                View ji5;
                ji5 = RecommendTroopFragment.ji(RecommendTroopFragment.this, currentTabText);
                return ji5;
            }
        });
        ao.b().h(this.troopClassifyInfos.get(position).f181556c);
    }

    private final void initData() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.troop.exp.a aVar = com.tencent.mobileqq.troop.exp.a.f295373a;
        if (currentTimeMillis - aVar.a() <= 1800000 && aVar.b() != null) {
            com.tencent.mobileqq.troop.exp.model.a b16 = aVar.b();
            Intrinsics.checkNotNull(b16);
            Yh(b16.a(), b16.b());
            com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
            if (bVar != null) {
                bVar.Z1("TroopSearchRecommendHandler" + b16.b().recommend_tab.get(0).name.get(), b16.c());
                return;
            }
            return;
        }
        Th();
    }

    private final void initView() {
        ContactRefreshHeader contactRefreshHeader;
        Map mapOf;
        this.headerScrollView = (HeaderScrollView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.b8a);
        this.quiSearchBar = (QUISearchBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.duk);
        EditText editText = (EditText) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f66003_g);
        this.searchEditText = editText;
        if (editText != null) {
            editText.setFocusableInTouchMode(false);
        }
        EditText editText2 = this.searchEditText;
        if (editText2 != null) {
            editText2.setCursorVisible(false);
        }
        QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null) {
            qUISearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendTroopFragment.di(RecommendTroopFragment.this, view);
                }
            });
        }
        this.commonRefreshWrapperLayout = (CommonRefreshLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.j8z);
        this.troopFragmentViewPager = (ContactsViewPager) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.b8d);
        CommonRefreshLayout commonRefreshLayout = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout != null) {
            contactRefreshHeader = (ContactRefreshHeader) commonRefreshLayout.findViewById(R.id.j8x);
        } else {
            contactRefreshHeader = null;
        }
        this.commonRefreshHeader = contactRefreshHeader;
        this.quiTabPageBar = (QUIPageTabBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f220502o);
        this.bannerLayout = (BannerLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.t3n);
        this.bannerArea = (FrameLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.t3o);
        this.bannerIndicator = (SimpleBannerIndicator) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.djp);
        this.emptyLayout = (FrameLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bwi);
        ai();
        Xh();
        CommonRefreshLayout commonRefreshLayout2 = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout2 != null) {
            commonRefreshLayout2.setRefreshCompleteDelayDuration(0);
        }
        ContactRefreshHeader contactRefreshHeader2 = this.commonRefreshHeader;
        if (contactRefreshHeader2 != null) {
            contactRefreshHeader2.setRefreshHeaderUpdateListener(new ContactRefreshHeader.b() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.c
                @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader.b
                public final long a() {
                    long ei5;
                    ei5 = RecommendTroopFragment.ei(RecommendTroopFragment.this);
                    return ei5;
                }
            });
        }
        CommonRefreshLayout commonRefreshLayout3 = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout3 != null) {
            commonRefreshLayout3.setOnRefreshListener(this.onRefreshListener);
        }
        EditText editText3 = this.searchEditText;
        if (editText3 != null) {
            editText3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendTroopFragment.fi(RecommendTroopFragment.this, view);
                }
            });
        }
        EditText editText4 = this.searchEditText;
        if (editText4 != null) {
            editText4.setHint(R.string.f213905rg);
        }
        ao.b().e();
        QUISearchBar qUISearchBar2 = this.quiSearchBar;
        if (qUISearchBar2 != null) {
            Oh(this, qUISearchBar2, null, "em_bas_search_box", null, null, null, ClickPolicy.REPORT_ALL, 58, null);
            QuickPinyinEditText inputWidget = qUISearchBar2.getInputWidget();
            Intrinsics.checkNotNullExpressionValue(inputWidget, "this.inputWidget");
            Oh(this, inputWidget, null, "em_search_grey_word", null, ExposurePolicy.REPORT_NONE, null, null, 106, null);
        }
        if (!SearchBoxWordsUtil.f284723a.e() || StudyModeManager.t()) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_shading", 0));
            VideoReport.setElementParams(this.quiSearchBar, mapOf);
        } else {
            Zh();
        }
        this.quiSecNavBar.setCenterText("\u627e\u7fa4");
        this.quiSecNavBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendTroopFragment.gi(RecommendTroopFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View ji(RecommendTroopFragment this$0, String currentTabText) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(null);
        com.tencent.mobileqq.troop.findTroop.util.c cVar = this$0.troopTabNodeManager;
        Intrinsics.checkNotNullExpressionValue(currentTabText, "currentTabText");
        cVar.c(currentTabText, new a.e(mutableListOf));
        return (View) mutableListOf.get(0);
    }

    private final void ki() {
        QUISearchBar qUISearchBar;
        Map mapOf;
        if ((!this.hintWords.isEmpty()) && (qUISearchBar = this.quiSearchBar) != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("literal_text", qUISearchBar.getAutoHintLayout().i()));
            VideoReport.reportEvent("dt_clck", qUISearchBar.getInputWidget(), mapOf);
        }
    }

    private final void li(List<? extends c.a> dataList) {
        int i3;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181089a);
        HashMap hashMap = new HashMap();
        boolean isShowGuildTabCached = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
        int i16 = 0;
        if (dataList != null) {
            Iterator<? extends c.a> it = dataList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().f298257m == 1) {
                    i3 = 1;
                } else {
                    i16 = 1;
                }
            }
        } else {
            i3 = 0;
        }
        String PG_TAB_STATUS = com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181090b;
        Intrinsics.checkNotNullExpressionValue(PG_TAB_STATUS, "PG_TAB_STATUS");
        hashMap.put(PG_TAB_STATUS, Integer.valueOf(isShowGuildTabCached ? 1 : 0));
        String PG_EXIST_GROUP = com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181091c;
        Intrinsics.checkNotNullExpressionValue(PG_EXIST_GROUP, "PG_EXIST_GROUP");
        hashMap.put(PG_EXIST_GROUP, Integer.valueOf(i16));
        String PG_EXIST_CHANNEL = com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181092d;
        Intrinsics.checkNotNullExpressionValue(PG_EXIST_CHANNEL, "PG_EXIST_CHANNEL");
        hashMap.put(PG_EXIST_CHANNEL, Integer.valueOf(i3));
        VideoReport.setPageParams(this, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(List<? extends c.a> dataList) {
        li(dataList);
    }

    private final void ni() {
        final QUIPageTabBar qUIPageTabBar = this.quiTabPageBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.recommendtroop.i
                @Override // java.lang.Runnable
                public final void run() {
                    RecommendTroopFragment.oi(QUIPageTabBar.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(QUIPageTabBar this_apply, RecommendTroopFragment this$0) {
        ViewGroup viewGroup;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View childAt = this_apply.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            viewGroup = (ViewGroup) childAt;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View child = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(child, "child");
                String str = com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181105q;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tab_name", this$0.troopClassifyInfos.get(i3).f181556c));
                Oh(this$0, child, null, str, mapOf, ExposurePolicy.REPORT_ALL, null, ClickPolicy.REPORT_ALL, 34, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(int imageType, String errorMsg) {
        FrameLayout frameLayout = this.emptyLayout;
        if (frameLayout != null) {
            if (frameLayout.getVisibility() != 0) {
                frameLayout.setVisibility(0);
            }
            if (frameLayout.getChildCount() == 0) {
                frameLayout.addView(new QUIEmptyState.Builder(frameLayout.getContext()).setImageType(imageType).setDesc(errorMsg).build(), -1, -1);
                return;
            }
            View childAt = frameLayout.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tencent.biz.qui.quiemptystate.QUIEmptyState");
            QUIEmptyState qUIEmptyState = (QUIEmptyState) childAt;
            qUIEmptyState.setImageView(imageType);
            qUIEmptyState.setDesc(errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(int icon, int msgId) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type mqq.app.AppActivity");
        if (((AppActivity) context).isResume()) {
            QQToast.makeText(getContext(), icon, getResources().getString(msgId), 0).show();
        }
    }

    private final void ri() {
        AutoHintLayout autoHintLayout;
        Intent intent = new Intent(getActivity(), (Class<?>) SearchContactsActivity.class);
        intent.putExtra("from_key", 1);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 13);
        QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null && (autoHintLayout = qUISearchBar.getAutoHintLayout()) != null) {
            Intrinsics.checkNotNullExpressionValue(autoHintLayout, "autoHintLayout");
            String i3 = autoHintLayout.i();
            if (!TextUtils.isEmpty(i3)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(i3);
                intent.putStringArrayListExtra("home_hint_words", arrayList);
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    private final void showLoading() {
        ProgressBar progressBar = this.waitingProgressBar;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    @NotNull
    public com.tencent.mobileqq.troop.findTroop.util.c F5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.troop.findTroop.util.c) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.troopTabNodeManager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r4.p() == true) goto L16;
     */
    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R2(@NotNull Object event) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof a.c) {
            CommonRefreshLayout commonRefreshLayout = this.commonRefreshWrapperLayout;
            if (commonRefreshLayout != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                ContactRefreshHeader contactRefreshHeader = this.commonRefreshHeader;
                if (contactRefreshHeader != null) {
                    contactRefreshHeader.l(0);
                }
                Wh();
            }
        }
    }

    @NotNull
    public final List<com.tencent.mobileqq.activity.contacts.base.tabs.f> Uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopClassifyInfos;
    }

    public final void Wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        CommonRefreshLayout commonRefreshLayout = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout != null) {
            commonRefreshLayout.setRefreshing(false);
        }
        ContactRefreshHeader contactRefreshHeader = this.commonRefreshHeader;
        if (contactRefreshHeader != null) {
            contactRefreshHeader.setRefresh(false);
        }
    }

    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    @NotNull
    public String af() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return b.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.hz9;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AutoHintLayout autoHintLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
        if (bVar != null) {
            bVar.U1(this.guildSearchRecommendObserver);
        }
        com.tencent.mobileqq.troop.exp.a aVar = com.tencent.mobileqq.troop.exp.a.f295373a;
        if (aVar.b() != null) {
            aVar.d(System.currentTimeMillis());
        }
        this.troopTabNodeManager.b();
        AVUtil.d(getContext());
        QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null && (autoHintLayout = qUISearchBar.getAutoHintLayout()) != null) {
            autoHintLayout.u(this.hintChangeListenerImpWithEditAreaAdjustWidth);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int position, @Nullable String hintText, @Nullable String reportData) {
        Map mapOf;
        Map mapOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(position), hintText, reportData);
            return;
        }
        if (hintText == null || hintText.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_shading", 1));
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("literal_text", hintText));
            QUISearchBar qUISearchBar = this.quiSearchBar;
            if (qUISearchBar != null) {
                VideoReport.setElementParams(qUISearchBar, mapOf);
                VideoReport.setElementParams(qUISearchBar.getInputWidget(), mapOf2);
                VideoReport.reportEvent("dt_imp", qUISearchBar.getInputWidget(), mapOf2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        AutoHintLayout autoHintLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        TopGestureLayout Rh = Rh();
        this.mGestureLayout = Rh;
        if (Rh != null) {
            Rh.setInterceptTouchFlag(true);
        }
        QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null && (autoHintLayout = qUISearchBar.getAutoHintLayout()) != null) {
            autoHintLayout.s();
        }
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAutoScroll(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        AutoHintLayout autoHintLayout;
        String hintText;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        TopGestureLayout Rh = Rh();
        this.mGestureLayout = Rh;
        boolean z17 = false;
        if (Rh != null) {
            Rh.setInterceptTouchFlag(false);
        }
        SearchUtils.V0("add_page", "search_grp", "exp", 0, 0, "", "", "", "");
        QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null) {
            AutoHintLayout autoHintLayout2 = qUISearchBar.getAutoHintLayout();
            if (autoHintLayout2 != null && (hintText = autoHintLayout2.i()) != null) {
                Intrinsics.checkNotNullExpressionValue(hintText, "hintText");
                if (hintText.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17 && (autoHintLayout = qUISearchBar.getAutoHintLayout()) != null) {
                autoHintLayout.q();
            }
        }
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAutoScroll(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.searchPagePerfReporter.c();
        this.waitingProgressBar = (ProgressBar) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.efn);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        this.expTroopViewModel = (com.tencent.mobileqq.troop.exp.viewmodel.b) new ViewModelProvider(this, new d((AppInterface) peekAppRuntime)).get(com.tencent.mobileqq.troop.exp.viewmodel.b.class);
        initView();
        com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
        if (bVar != null) {
            bVar.O1(this.guildSearchRecommendObserver);
        }
        initData();
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            com.tencent.mobileqq.guild.report.b.g("functional_qq_group_recommend", "RecommendTroopFragment");
        }
    }

    public final void scrollToTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        HeaderScrollView headerScrollView = this.headerScrollView;
        if (headerScrollView != null) {
            headerScrollView.i();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
