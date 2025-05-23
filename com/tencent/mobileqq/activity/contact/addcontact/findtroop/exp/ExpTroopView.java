package com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.AVUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.h;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.guild.component.banner.indicator.SimpleBannerIndicator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.util.SearchBoxWordsUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Banner;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$RecommendTab;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00ba\u0001B\u001b\u0012\b\u0010\u00b7\u0001\u001a\u00030\u00b6\u0001\u0012\u0006\u0010V\u001a\u00020Q\u00a2\u0006\u0006\b\u00b8\u0001\u0010\u00b9\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0002J \u0010*\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010)\u001a\u00020(H\u0002J(\u0010-\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010,\u001a\u00020+H\u0002Jd\u0010:\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\n\b\u0002\u00100\u001a\u0004\u0018\u00010%2\n\b\u0002\u00101\u001a\u0004\u0018\u00010%2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0002\b\u0003\u0018\u0001022\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\n\b\u0002\u00107\u001a\u0004\u0018\u0001062\n\b\u0002\u00109\u001a\u0004\u0018\u000108H\u0002J\b\u0010;\u001a\u00020\u0004H\u0002J\b\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010%J\u0010\u0010B\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010@J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020\u0004H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\b\u0010F\u001a\u00020\u0004H\u0016J\u0006\u0010G\u001a\u00020\u0004J\u0006\u0010H\u001a\u00020\u0004J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010J\u001a\u00020IH\u0016J\n\u0010M\u001a\u0004\u0018\u00010LH\u0016J$\u0010P\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010%2\b\u0010O\u001a\u0004\u0018\u00010%H\u0016R\u0017\u0010V\u001a\u00020Q8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR$\u0010^\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010x\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010zR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R0\u0010\u0087\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0017\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\"\u0010\u0089\u0001R\u001b\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u008c\u0001R\u001b\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b \u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010:R\u0017\u0010\u0092\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010:R\u001a\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001c\u0010\u0093\u0001R\u001b\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bG\u0010\u0096\u0001R\u0018\u0010\u0099\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\b\u0010\u0098\u0001R\u001b\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0006\u0010\u009b\u0001R\u001b\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b*\u0010\u009e\u0001R\u001b\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u009b\u0001R(\u0010\u00a2\u0001\u001a\u0012\u0012\u0004\u0012\u00020%0\u0014j\b\u0012\u0004\u0012\u00020%`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0005\u0010\u00a1\u0001R\u0017\u0010\u00a5\u0001\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u001c\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0018\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0018\u0010\u00b5\u0001\u001a\u00030\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001\u00a8\u0006\u00bb\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/findtroop/exp/ExpTroopView;", "Lcom/tencent/mobileqq/activity/contact/addcontact/ContactBaseView;", "Lcom/tencent/mobileqq/troop/findTroop/util/b;", "Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;", "", "a0", "U", "X", "T", "O", "", "position", "g0", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "dataList", "m0", "l0", "n0", "recommendItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "Lkotlin/collections/ArrayList;", "K", "icon", "msgId", "r0", "q0", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "M", "", "N", "Lcom/tencent/mobileqq/troop/exp/model/b;", "L", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "errorMsg", "p0", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "V", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", "H", "Landroid/view/View;", "view", "pageId", "elementId", "", "param", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "I", "s0", "W", "j0", "type", "setTroopRecommendType", "Lns2/a;", "stickyListener", "setNavStickyListener", "c", "f", "e", "d", ExifInterface.LATITUDE_SOUTH, "k0", "", "event", "R2", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "F5", "hintText", "reportData", "onHintChange", "Landroidx/lifecycle/ViewModelStoreOwner;", tl.h.F, "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "i", "Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "getExpTroopViewModel", "()Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "setExpTroopViewModel", "(Lcom/tencent/mobileqq/troop/exp/viewmodel/b;)V", "expTroopViewModel", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isNavSticked", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "troopRecommendType", "Landroid/widget/ProgressBar;", "D", "Landroid/widget/ProgressBar;", "waittingProgressBar", "Lu60/c;", "E", "Lu60/c;", "searchPagePerfReporter", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/CommonRefreshLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/CommonRefreshLayout;", "commonRefreshWrapperLayout", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/ContactRefreshHeader;", "G", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/ContactRefreshHeader;", "commonRefreshHeader", "Lcom/tencent/mobileqq/activity/contacts/base/HeaderScrollView;", "Lcom/tencent/mobileqq/activity/contacts/base/HeaderScrollView;", "headerScrollView", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "quiSearchBar", "Landroid/widget/EditText;", "J", "Landroid/widget/EditText;", "searchEditText", "", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/f;", "Ljava/util/List;", "P", "()Ljava/util/List;", "setTroopClassifyInfos", "(Ljava/util/List;)V", "troopClassifyInfos", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "quiTabPageBar", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsViewPager;", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsViewPager;", "troopFragmentViewPager", "Lcom/tencent/mobileqq/activity/contact/addcontact/findtroop/a;", "Lcom/tencent/mobileqq/activity/contact/addcontact/findtroop/a;", "troopFragmentViewPagerAdapter", "currentClassifyPos", "previousClassifyPos", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "mGestureLayout", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "bannerLayout", "Lcom/tencent/mobileqq/troop/exp/model/b;", "bannerLayoutAdapter", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "bannerArea", "Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator;", "Lcom/tencent/mobileqq/guild/component/banner/indicator/SimpleBannerIndicator;", "bannerIndicator", "emptyLayout", "Ljava/util/ArrayList;", "hintWords", "b0", "Lcom/tencent/mobileqq/troop/findTroop/util/c;", "troopTabNodeManager", "Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "c0", "Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "hintChangeListenerImpWithEditAreaAdjustWidth", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "d0", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "guildSearchRecommendObserver", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsBaseFragment$c;", "e0", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsBaseFragment$c;", "fragmentRefreshDataResultListener", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/a;", "f0", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/a;", "onRefreshListener", "Lcom/tencent/mobileqq/activity/contact/addcontact/ContactBaseView$a;", "context", "<init>", "(Lcom/tencent/mobileqq/activity/contact/addcontact/ContactBaseView$a;Landroidx/lifecycle/ViewModelStoreOwner;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ExpTroopView extends ContactBaseView implements com.tencent.mobileqq.troop.findTroop.util.b, AutoHintLayout.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String troopRecommendType;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ProgressBar waittingProgressBar;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final u60.c searchPagePerfReporter;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private CommonRefreshLayout commonRefreshWrapperLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ContactRefreshHeader commonRefreshHeader;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private HeaderScrollView headerScrollView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUISearchBar quiSearchBar;

    /* renamed from: J, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public EditText searchEditText;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.activity.contacts.base.tabs.f> troopClassifyInfos;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QUIPageTabBar quiTabPageBar;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ContactsViewPager troopFragmentViewPager;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.contact.addcontact.findtroop.a troopFragmentViewPagerAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    private int currentClassifyPos;

    /* renamed from: Q, reason: from kotlin metadata */
    private int previousClassifyPos;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TopGestureLayout mGestureLayout;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private BannerLayout bannerLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.exp.model.b bannerLayoutAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private FrameLayout bannerArea;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private SimpleBannerIndicator bannerIndicator;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private FrameLayout emptyLayout;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> hintWords;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.findTroop.util.c troopTabNodeManager;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.searchdetail.content.view.a hintChangeListenerImpWithEditAreaAdjustWidth;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.exp.viewmodel.d guildSearchRecommendObserver;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ContactsBaseFragment.c fragmentRefreshDataResultListener;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.contacts.pullrefresh.a onRefreshListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner viewModelStoreOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.exp.viewmodel.b expTroopViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isNavSticked;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/findtroop/exp/ExpTroopView$a;", "", "", "KEY_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.ExpTroopView$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/findtroop/exp/ExpTroopView$b", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsBaseFragment$c;", "", "position", "", "success", "", "data", "", "c", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements ContactsBaseFragment.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpTroopView.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (ExpTroopView.this.headerScrollView != null) {
                HeaderScrollView headerScrollView = ExpTroopView.this.headerScrollView;
                Intrinsics.checkNotNull(headerScrollView);
                if (!headerScrollView.f()) {
                    HeaderScrollView headerScrollView2 = ExpTroopView.this.headerScrollView;
                    Intrinsics.checkNotNull(headerScrollView2);
                    HeaderScrollView headerScrollView3 = ExpTroopView.this.headerScrollView;
                    Intrinsics.checkNotNull(headerScrollView3);
                    headerScrollView2.scrollTo(0, headerScrollView3.c());
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.c
        public void c(int position, boolean success, @Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), Boolean.valueOf(success), data);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ExpTroopView", 2, "onRefreshResult. position:" + position + " success:" + success);
            }
            ContactRefreshHeader contactRefreshHeader = ExpTroopView.this.commonRefreshHeader;
            if (contactRefreshHeader != null) {
                contactRefreshHeader.l(0);
            }
            ExpTroopView.this.S();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/findtroop/exp/ExpTroopView$c", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "", "isSuccess", "", "itemType", "", "keyWord", "serverPageID", "isEnd", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mobileqq.troop.exp.viewmodel.d {
        c() {
        }

        @Override // com.tencent.mobileqq.troop.exp.viewmodel.d
        public void a(boolean isSuccess, int itemType, @Nullable String keyWord, int serverPageID, boolean isEnd, @Nullable List<? extends c.a> dataList, @NotNull guildSearchRecommendSvr$FirstShow firstShow, @NotNull ByteStringMicro sessionInfo, boolean isLoadMore) {
            Intrinsics.checkNotNullParameter(firstShow, "firstShow");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            ExpTroopView.this.R();
            boolean z16 = true;
            if (!isSuccess) {
                ExpTroopView.this.r0(1, R.string.hqe);
            }
            CommonRefreshLayout commonRefreshLayout = ExpTroopView.this.commonRefreshWrapperLayout;
            if (commonRefreshLayout == null || !commonRefreshLayout.p()) {
                z16 = false;
            }
            if (z16) {
                ExpTroopView.this.S();
            }
            if (firstShow.recommend_tab.size() > 0) {
                ExpTroopView.this.Q();
                ExpTroopView.this.V(dataList, firstShow);
                ExpTroopView.this.H(dataList, firstShow, sessionInfo);
            }
            if (ExpTroopView.this.P().size() == 0) {
                ExpTroopView.this.p0(16, "\u6682\u65e0\u6570\u636e");
            }
            ExpTroopView.this.m0(dataList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/findtroop/exp/ExpTroopView$d", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends ViewPager.SimpleOnPageChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpTroopView.this);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
            } else if (state == 1) {
                ExpTroopView expTroopView = ExpTroopView.this;
                ContactsViewPager contactsViewPager = expTroopView.troopFragmentViewPager;
                Intrinsics.checkNotNull(contactsViewPager);
                expTroopView.previousClassifyPos = contactsViewPager.getCurrentItem();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ExpTroopView.this.g0(position);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/findtroop/exp/ExpTroopView$e", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends ViewModelProvider.NewInstanceFactory {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpTroopView.this);
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
                QQAppInterface app = ExpTroopView.this.f180748f;
                Intrinsics.checkNotNullExpressionValue(app, "app");
                return new com.tencent.mobileqq.troop.exp.viewmodel.b(app);
            }
            return (T) super.create(modelClass);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpTroopView(@NotNull ContactBaseView.a context, @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) viewModelStoreOwner);
            return;
        }
        this.viewModelStoreOwner = viewModelStoreOwner;
        this.troopRecommendType = "";
        this.searchPagePerfReporter = new u60.c();
        this.troopClassifyInfos = new ArrayList();
        this.previousClassifyPos = -1;
        this.bannerLayoutAdapter = L();
        this.hintWords = new ArrayList<>();
        this.troopTabNodeManager = new com.tencent.mobileqq.troop.findTroop.util.c(this);
        this.guildSearchRecommendObserver = new c();
        this.fragmentRefreshDataResultListener = new b();
        this.onRefreshListener = new com.tencent.mobileqq.activity.contacts.pullrefresh.a() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.a
            @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.a
            public final void onRefresh() {
                ExpTroopView.f0(ExpTroopView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(List<? extends c.a> dataList, guildSearchRecommendSvr$FirstShow firstShow, ByteStringMicro sessionInfo) {
        com.tencent.mobileqq.troop.exp.a aVar = com.tencent.mobileqq.troop.exp.a.f295373a;
        aVar.e(new com.tencent.mobileqq.troop.exp.model.a(dataList, firstShow, sessionInfo));
        aVar.d(System.currentTimeMillis());
    }

    private final void I(View view, String pageId, String elementId, Map<String, ?> param, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy) {
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
    public static /* synthetic */ void J(ExpTroopView expTroopView, View view, String str, String str2, Map map, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, int i3, Object obj) {
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
        expTroopView.I(view, str3, str4, map2, exposurePolicy2, endExposurePolicy2, clickPolicy2);
    }

    private final ArrayList<RecommendTroopItem> K(List<? extends c.a> recommendItemList) {
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

    private final com.tencent.mobileqq.troop.exp.model.b L() {
        com.tencent.mobileqq.troop.exp.model.b bVar = new com.tencent.mobileqq.troop.exp.model.b();
        bVar.k0(new ExpTroopView$createBannerAdapter$1$1(this));
        return bVar;
    }

    private final TopGestureLayout M() {
        View decorView = this.f180746d.getActivity().getWindow().getDecorView();
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

    private final long N() {
        return System.currentTimeMillis();
    }

    private final void O() {
        if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            q0();
            com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
            if (bVar != null) {
                bVar.R1(2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExpTroopView", 2, "initData falied. network unavailable");
        }
        r0(1, R.string.f171139ci4);
        p0(5, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        ProgressBar progressBar = this.waittingProgressBar;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(8);
    }

    private final void T() {
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

    private final void U() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.troop.exp.a aVar = com.tencent.mobileqq.troop.exp.a.f295373a;
        if (currentTimeMillis - aVar.a() <= 1800000 && aVar.b() != null) {
            com.tencent.mobileqq.troop.exp.model.a b16 = aVar.b();
            Intrinsics.checkNotNull(b16);
            V(b16.a(), b16.b());
            com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
            if (bVar != null) {
                bVar.Z1("TroopSearchRecommendHandler" + b16.b().recommend_tab.get(0).name.get(), b16.c());
                return;
            }
            return;
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(List<? extends c.a> dataList, guildSearchRecommendSvr$FirstShow firstShow) {
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
        aVar.g(K(dataList));
        com.tencent.mobileqq.activity.contact.addcontact.findtroop.a aVar2 = this.troopFragmentViewPagerAdapter;
        Intrinsics.checkNotNull(aVar2);
        aVar2.i(arrayList);
        ContactsViewPager contactsViewPager = this.troopFragmentViewPager;
        Intrinsics.checkNotNull(contactsViewPager);
        contactsViewPager.setCurrentItem(i16, false);
        g0(i16);
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
        n0();
    }

    private final void W() {
        final QUISearchBar qUISearchBar = this.quiSearchBar;
        if (qUISearchBar != null) {
            qUISearchBar.getAutoHintLayout().setHintHelperGravity(17);
            qUISearchBar.getAutoHintLayout().setInterval(5000L);
            qUISearchBar.getAutoHintLayout().setAnimDuration(400);
            this.hintChangeListenerImpWithEditAreaAdjustWidth = new com.tencent.mobileqq.search.searchdetail.content.view.a(qUISearchBar, this);
            qUISearchBar.getAutoHintLayout().m(this.hintChangeListenerImpWithEditAreaAdjustWidth);
            SearchBoxWordsUtil.c(5, new Function1<ArrayList<String>, Unit>(qUISearchBar) { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.ExpTroopView$initShadingHintWords$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUISearchBar $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = qUISearchBar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpTroopView.this, (Object) qUISearchBar);
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
                        ExpTroopView.this.hintWords = words;
                        this.$this_apply.setClipChildren(false);
                        this.$this_apply.getFlSearchExt().setVisibility(8);
                        this.$this_apply.getAutoHintLayout().setEnableFrondIconRunInAnim(true, this.$this_apply);
                        AutoHintLayout autoHintLayout = this.$this_apply.getAutoHintLayout();
                        arrayList = ExpTroopView.this.hintWords;
                        autoHintLayout.setHintList(arrayList);
                        AutoHintLayout autoHintLayout2 = this.$this_apply.getAutoHintLayout();
                        arrayList2 = ExpTroopView.this.hintWords;
                        autoHintLayout2.setReportDataList(arrayList2);
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_shading", Integer.valueOf(i3)));
                    qUISearchBar2 = ExpTroopView.this.quiSearchBar;
                    VideoReport.setElementParams(qUISearchBar2, mapOf);
                }
            });
        }
    }

    private final void X() {
        QUIPageTabBar qUIPageTabBar = this.quiTabPageBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setVisibility(0);
        }
        com.tencent.mobileqq.activity.contact.addcontact.findtroop.a aVar = new com.tencent.mobileqq.activity.contact.addcontact.findtroop.a(this.f180746d.getFragmentManager(), this.f180746d.getApp(), new ArrayList());
        this.troopFragmentViewPagerAdapter = aVar;
        aVar.h(this.troopTabNodeManager);
        ContactsViewPager contactsViewPager = this.troopFragmentViewPager;
        if (contactsViewPager != null) {
            contactsViewPager.setAdapter(this.troopFragmentViewPagerAdapter);
        }
        ContactsViewPager contactsViewPager2 = this.troopFragmentViewPager;
        if (contactsViewPager2 != null) {
            contactsViewPager2.setOffscreenPageLimit(9);
        }
        ContactsViewPager contactsViewPager3 = this.troopFragmentViewPager;
        if (contactsViewPager3 != null) {
            contactsViewPager3.setOnPageChangeListener(new d());
        }
        QUIPageTabBar qUIPageTabBar2 = this.quiTabPageBar;
        if (qUIPageTabBar2 != null) {
            qUIPageTabBar2.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.g
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                public final void I0(int i3, boolean z16) {
                    ExpTroopView.Z(ExpTroopView.this, i3, z16);
                }
            });
        }
        QUIPageTabBar qUIPageTabBar3 = this.quiTabPageBar;
        if (qUIPageTabBar3 != null) {
            qUIPageTabBar3.setOnCurrentTabClickListener(new QUIPageTabBar.h() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.h
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
                public final void k1(int i3) {
                    ExpTroopView.Y(ExpTroopView.this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ExpTroopView this$0, int i3) {
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
    public static final void Z(ExpTroopView this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("ExpTroopView", 2, "quiTabPageBar TabChange. position:" + i3);
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

    private final void a0() {
        ContactRefreshHeader contactRefreshHeader;
        Map mapOf;
        this.headerScrollView = (HeaderScrollView) findViewById(R.id.b8a);
        this.quiSearchBar = (QUISearchBar) findViewById(R.id.duk);
        EditText editText = (EditText) findViewById(R.id.f66003_g);
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
            qUISearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpTroopView.b0(ExpTroopView.this, view);
                }
            });
        }
        this.commonRefreshWrapperLayout = (CommonRefreshLayout) findViewById(R.id.j8z);
        this.troopFragmentViewPager = (ContactsViewPager) findViewById(R.id.b8d);
        CommonRefreshLayout commonRefreshLayout = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout != null) {
            contactRefreshHeader = (ContactRefreshHeader) commonRefreshLayout.findViewById(R.id.j8x);
        } else {
            contactRefreshHeader = null;
        }
        this.commonRefreshHeader = contactRefreshHeader;
        this.quiTabPageBar = (QUIPageTabBar) findViewById(R.id.f220502o);
        this.bannerLayout = (BannerLayout) findViewById(R.id.t3n);
        this.bannerArea = (FrameLayout) findViewById(R.id.t3o);
        this.bannerIndicator = (SimpleBannerIndicator) findViewById(R.id.djp);
        this.emptyLayout = (FrameLayout) findViewById(R.id.bwi);
        X();
        T();
        CommonRefreshLayout commonRefreshLayout2 = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout2 != null) {
            commonRefreshLayout2.setRefreshCompleteDelayDuration(0);
        }
        ContactRefreshHeader contactRefreshHeader2 = this.commonRefreshHeader;
        if (contactRefreshHeader2 != null) {
            contactRefreshHeader2.setRefreshHeaderUpdateListener(new ContactRefreshHeader.b() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.c
                @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader.b
                public final long a() {
                    long c06;
                    c06 = ExpTroopView.c0(ExpTroopView.this);
                    return c06;
                }
            });
        }
        CommonRefreshLayout commonRefreshLayout3 = this.commonRefreshWrapperLayout;
        if (commonRefreshLayout3 != null) {
            commonRefreshLayout3.setOnRefreshListener(this.onRefreshListener);
        }
        HeaderScrollView headerScrollView = this.headerScrollView;
        if (headerScrollView != null) {
            headerScrollView.setOnScrollListener(new HeaderScrollView.a() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.d
                @Override // com.tencent.mobileqq.activity.contacts.base.HeaderScrollView.a
                public final void onScroll(int i3, int i16) {
                    ExpTroopView.d0(ExpTroopView.this, i3, i16);
                }
            });
        }
        EditText editText3 = this.searchEditText;
        if (editText3 != null) {
            editText3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpTroopView.e0(ExpTroopView.this, view);
                }
            });
        }
        EditText editText4 = this.searchEditText;
        if (editText4 != null) {
            editText4.setHint(R.string.f213905rg);
        }
        this.mGestureLayout = M();
        ao.b().e();
        QUISearchBar qUISearchBar2 = this.quiSearchBar;
        if (qUISearchBar2 != null) {
            J(this, qUISearchBar2, null, "em_bas_search_box", null, null, null, ClickPolicy.REPORT_ALL, 58, null);
            QuickPinyinEditText inputWidget = qUISearchBar2.getInputWidget();
            Intrinsics.checkNotNullExpressionValue(inputWidget, "this.inputWidget");
            J(this, inputWidget, null, "em_search_grey_word", null, ExposurePolicy.REPORT_NONE, null, null, 106, null);
        }
        if (!SearchBoxWordsUtil.f284723a.e() || StudyModeManager.t()) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_shading", 0));
            VideoReport.setElementParams(this.quiSearchBar, mapOf);
        } else {
            W();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ExpTroopView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
        this$0.j0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c0(ExpTroopView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(ExpTroopView this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.activity.contact.addcontact.findtroop.a aVar = this$0.troopFragmentViewPagerAdapter;
        EditText editText = this$0.searchEditText;
        if (editText != null) {
            i16 = editText.getHeight();
        }
        if (i3 >= i16) {
            if (!this$0.isNavSticked) {
                this$0.isNavSticked = true;
            }
        } else if (this$0.isNavSticked) {
            this$0.isNavSticked = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ExpTroopView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ExpTroopView this$0) {
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
            this$0.O();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExpTroopView", 2, "refresh falied. network unavailable");
        }
        this$0.S();
        if (this$0.troopClassifyInfos.size() == 0) {
            this$0.p0(5, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(int position) {
        if (QLog.isColorLevel()) {
            QLog.d("ExpTroopView", 2, "onSelectedNewClassifyPostion. position:" + position);
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
        headerScrollView.setCurrentScrollableContainer(new h.a() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.f
            @Override // com.tencent.mobileqq.activity.contacts.base.h.a
            public final View getScrollableView() {
                View i06;
                i06 = ExpTroopView.i0(ExpTroopView.this, currentTabText);
                return i06;
            }
        });
        ao.b().h(this.troopClassifyInfos.get(position).f181556c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View i0(ExpTroopView this$0, String currentTabText) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(null);
        com.tencent.mobileqq.troop.findTroop.util.c cVar = this$0.troopTabNodeManager;
        Intrinsics.checkNotNullExpressionValue(currentTabText, "currentTabText");
        cVar.c(currentTabText, new a.e(mutableListOf));
        return (View) mutableListOf.get(0);
    }

    private final void j0() {
        QUISearchBar qUISearchBar;
        Map mapOf;
        if ((!this.hintWords.isEmpty()) && (qUISearchBar = this.quiSearchBar) != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("literal_text", qUISearchBar.getAutoHintLayout().i()));
            VideoReport.reportEvent("dt_clck", qUISearchBar.getInputWidget(), mapOf);
        }
    }

    private final void l0(List<? extends c.a> dataList) {
        int i3;
        Activity activity = this.f180747e;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(this, com.tencent.mobileqq.activity.contact.addcontact.findtroop.b.f181089a);
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
    public final void m0(List<? extends c.a> dataList) {
        l0(dataList);
    }

    private final void n0() {
        final QUIPageTabBar qUIPageTabBar = this.quiTabPageBar;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.findtroop.exp.i
                @Override // java.lang.Runnable
                public final void run() {
                    ExpTroopView.o0(QUIPageTabBar.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(QUIPageTabBar this_apply, ExpTroopView this$0) {
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
                J(this$0, child, null, str, mapOf, ExposurePolicy.REPORT_ALL, null, ClickPolicy.REPORT_ALL, 34, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int imageType, String errorMsg) {
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

    private final void q0() {
        ProgressBar progressBar = this.waittingProgressBar;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(int icon, int msgId) {
        Activity activity = this.f180747e;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type mqq.app.AppActivity");
        if (((AppActivity) activity).isResume()) {
            QQToast makeText = QQToast.makeText(this.f180747e, icon, getResources().getString(msgId), 0);
            Activity activity2 = this.f180747e;
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
            makeText.show(((BaseActivity) activity2).getTitleBarHeight());
        }
    }

    private final void s0() {
        AutoHintLayout autoHintLayout;
        Activity activity = this.f180746d.getActivity();
        Intent intent = new Intent(activity, (Class<?>) SearchContactsActivity.class);
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
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
        SearchUtils.V0("add_page", "search", "active_frame", 2, 0, "");
        ReportController.o(this.f180748f, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.troop.findTroop.util.b
    @Nullable
    public com.tencent.mobileqq.troop.findTroop.util.c F5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.troop.findTroop.util.c) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.troopTabNodeManager;
    }

    @NotNull
    public final List<com.tencent.mobileqq.activity.contacts.base.tabs.f> P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.troopClassifyInfos;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, event);
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
                S();
            }
        }
    }

    public final void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return b.a.a(this);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.c();
        super.setContentView(R.layout.fuv);
        this.searchPagePerfReporter.c();
        this.waittingProgressBar = (ProgressBar) findViewById(R.id.efn);
        this.expTroopViewModel = (com.tencent.mobileqq.troop.exp.viewmodel.b) new ViewModelProvider(this.viewModelStoreOwner, new e()).get(com.tencent.mobileqq.troop.exp.viewmodel.b.class);
        a0();
        com.tencent.mobileqq.troop.exp.viewmodel.b bVar = this.expTroopViewModel;
        if (bVar != null) {
            bVar.O1(this.guildSearchRecommendObserver);
        }
        U();
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            com.tencent.mobileqq.guild.report.b.g("functional_qq_group_recommend", "ExpTroopView");
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void d() {
        AutoHintLayout autoHintLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
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
        super.d();
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void e() {
        AutoHintLayout autoHintLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.e();
        TopGestureLayout topGestureLayout = this.mGestureLayout;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(true);
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

    @Override // com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
    public void f() {
        AutoHintLayout autoHintLayout;
        String hintText;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.f();
        TopGestureLayout topGestureLayout = this.mGestureLayout;
        boolean z17 = false;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(false);
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

    public final void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        HeaderScrollView headerScrollView = this.headerScrollView;
        if (headerScrollView != null) {
            headerScrollView.i();
        }
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int position, @Nullable String hintText, @Nullable String reportData) {
        Map mapOf;
        Map mapOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(position), hintText, reportData);
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

    public final void setExpTroopViewModel(@Nullable com.tencent.mobileqq.troop.exp.viewmodel.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.expTroopViewModel = bVar;
        }
    }

    public final void setNavStickyListener(@Nullable ns2.a stickyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) stickyListener);
        }
    }

    public final void setTroopClassifyInfos(@NotNull List<com.tencent.mobileqq.activity.contacts.base.tabs.f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.troopClassifyInfos = list;
        }
    }

    public final void setTroopRecommendType(@Nullable String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) type);
        } else {
            this.troopRecommendType = type;
        }
    }
}
