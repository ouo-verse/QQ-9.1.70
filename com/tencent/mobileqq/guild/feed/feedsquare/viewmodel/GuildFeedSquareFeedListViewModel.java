package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.DeleteFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.FeedSquareViewModeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.InsertFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgsV2;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.m;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import ij1.GuildFeedsHeaderData;
import ij1.GuildGameDistributeAdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u007f2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u00052\u00020\u00062\u00020\u0007:\u0002\u0080\u0001B-\u0012\u001a\b\u0002\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004070403\u0012\b\b\u0002\u0010`\u001a\u00020]\u00a2\u0006\u0004\b}\u0010~J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J!\u0010\u000f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\t\u001a\u00020\u000eH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u00aa\u0001\u0010)\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00162h\u0010(\u001ad\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\n\u0018\u00010 j\u0004\u0018\u0001`'H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0018H\u0016J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-0,H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u000201H\u0016J\u0016\u00106\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020504\u0018\u000103H\u0016J\u001a\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004070403H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u001603H\u0016J;\u0010;\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040704\u0018\u0001032\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0:\"\u0004\u0018\u00010-H\u0016\u00a2\u0006\u0004\b;\u0010<J'\u0010=\u001a\u00020\n2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0:\"\u0004\u0018\u00010-H\u0016\u00a2\u0006\u0004\b=\u0010>J\u00b6\u0001\u0010A\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u00162j\b\u0002\u0010(\u001ad\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\n\u0018\u00010 j\u0004\u0018\u0001`'H\u0002J \u0010B\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J8\u0010J\u001a\u00020\n2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010G\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010HH\u0002J\u0018\u0010K\u001a\u00020\n2\u0006\u0010G\u001a\u00020F2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0018\u0010L\u001a\u00020\n2\u0006\u0010G\u001a\u00020F2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010M\u001a\u00020\u00162\u0006\u0010G\u001a\u00020FH\u0002J@\u0010O\u001a\u00020\n2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010G\u001a\u00020F2\u0006\u0010N\u001a\u00020\u00162\b\u0010I\u001a\u0004\u0018\u00010HH\u0002J(\u0010S\u001a\u00020\n2\u0012\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000407042\n\b\u0002\u0010R\u001a\u0004\u0018\u00010QH\u0002JL\u0010T\u001a\u00020\n2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010&\u001a\u00020\u00162\u0012\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000407042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u0004072\n\b\u0002\u0010R\u001a\u0004\u0018\u00010QH\u0002J2\u0010V\u001a\u00020\n2\u0006\u0010U\u001a\u00020\u00162\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u0004072\u0012\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040704H\u0002J\u0018\u0010Y\u001a\u00020\u00162\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u0018H\u0002R&\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040704038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u0016038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010[R\u0016\u0010i\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010mR\"\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020504038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010[R\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00040q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001c\u0010y\u001a\u00020\u001a8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bz\u0010{\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareFeedListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/m;", "Lco1/f;", "Lij1/g;", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Lco1/j;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/n;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/b;", "args", "", "J0", "", "newFeedList", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/n;", "J1", "modifyFeed", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/p;", "x1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/q;", "argsV2", "i1", "", "enableUseCache", "", "refreshMode", "", "topFeedId", "topChannelId", MiniChatConstants.MINI_APP_TOP_TYPE, "topBusinessId", "forceScrollTop", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "P0", "sortMode", DomainData.DOMAIN_NAME, "", "", "getExtra", "getDisplaySurfaceType", "p", "", "getToken", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lij1/d;", "X", "", "j", "o", "", "getDisplaySurfaceData", "([Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "loadMoreForDisplaySurface", "([Ljava/lang/Object;)V", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "feedId", "g2", "R1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsReq;", "reqParam", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsRsp;", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "notificationItem", "T1", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "b2", "isFinish", "c2", "data", "Ljava/lang/Runnable;", "extraTask", "f2", "e2", "usePreData", "X1", "isCacheRsp", "newSortMode", "W1", "i", "Landroidx/lifecycle/MutableLiveData;", "mFeedsData", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "mFeedInitBean", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", "mFeedListDataRepo", UserInfo.SEX_FEMALE, "mNewFeedNavBarData", "G", "Ljava/lang/String;", "mAttachInfo", "H", "I", "mSortMode", "[B", "mToken", "J", "mFeedsHeaderData", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "K", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/k;", "publishFeedHelper", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", IECDtReport.ACTION_IDENTIFIER, "S1", "()Ljava/util/List;", "readOnlyList", "<init>", "(Landroidx/lifecycle/MutableLiveData;Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;)V", "L", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareFeedListViewModel extends ViewModel implements m, co1.f<ij1.g>, IDataDisplaySurface<ij1.g>, co1.j, n {
    private final /* synthetic */ co1.i C;
    private final /* synthetic */ UIStateDataUtils.DefaultUIStateDataOperateImpl D;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedListDataRepo mFeedListDataRepo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mNewFeedNavBarData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mAttachInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private int mSortMode;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private byte[] mToken;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<UIStateData<GuildFeedsHeaderData>> mFeedsHeaderData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.feed.feedsquare.utils.k<ij1.g> publishFeedHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<ij1.g>>> mFeedsData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSquareInitBean mFeedInitBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareFeedListViewModel$b", "Lqx1/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/b;", "rsp", "", "f", "", "result", "", "errMsg", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends qx1.a<com.tencent.mobileqq.guild.feed.feedsquare.data.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4<Boolean, String, Integer, Boolean, Unit> f219386a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareFeedListViewModel f219387b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildFeedListDataRepo.b<GProGetGuildFeedsReq> f219388c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f219389d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f219390e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f219391f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f219392g;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> function4, GuildFeedSquareFeedListViewModel guildFeedSquareFeedListViewModel, GuildFeedListDataRepo.b<GProGetGuildFeedsReq> bVar, boolean z16, IPerformanceReportTask iPerformanceReportTask, int i3, boolean z17) {
            this.f219386a = function4;
            this.f219387b = guildFeedSquareFeedListViewModel;
            this.f219388c = bVar;
            this.f219389d = z16;
            this.f219390e = iPerformanceReportTask;
            this.f219391f = i3;
            this.f219392g = z17;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int result, @Nullable String errMsg, @Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.b rsp) {
            List arrayList;
            String str;
            boolean z16;
            Function4<Boolean, String, Integer, Boolean, Unit> function4 = this.f219386a;
            if (function4 != null) {
                Boolean bool = Boolean.FALSE;
                if (errMsg == null) {
                    str = "";
                } else {
                    str = errMsg;
                }
                Integer valueOf = Integer.valueOf(result);
                if (rsp != null) {
                    z16 = rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String();
                } else {
                    z16 = false;
                }
                function4.invoke(bool, str, valueOf, Boolean.valueOf(z16));
            }
            MutableLiveData mutableLiveData = this.f219387b.mFeedsData;
            UIStateData loadMore = UIStateData.obtainError(errMsg).setRetCode(result).setType(this.f219391f).setLoadMore(this.f219392g);
            UIStateData uIStateData = (UIStateData) this.f219387b.mFeedsData.getValue();
            if (uIStateData == null || (arrayList = (List) uIStateData.getData()) == null) {
                arrayList = new ArrayList();
            }
            mutableLiveData.setValue(loadMore.setDataList(arrayList));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.b rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Function4<Boolean, String, Integer, Boolean, Unit> function4 = this.f219386a;
            if (function4 != null) {
                function4.invoke(Boolean.TRUE, "", 0, Boolean.valueOf(rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String()));
            }
            this.f219387b.T1(this.f219388c, rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String(), this.f219389d, rsp.getGProGetGuildFeedsRsp(), rsp.getNotificationItem());
            if (!rsp.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String()) {
                com.tencent.mobileqq.guild.feed.report.c.f223280a.x(this.f219390e, this.f219388c, rsp);
            }
        }
    }

    public GuildFeedSquareFeedListViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final boolean R1(boolean isLoadMore, int sortMode, boolean enableUseCache) {
        this.mFeedInitBean.getGuildId();
        if (this.mFeedsData.getValue() != null) {
            UIStateData<List<ij1.g>> value = this.mFeedsData.getValue();
            Intrinsics.checkNotNull(value);
            if (value.isLoading()) {
                UIStateData<List<ij1.g>> value2 = this.mFeedsData.getValue();
                Intrinsics.checkNotNull(value2);
                if (value2.getType() == sortMode) {
                    QLog.d("GuildFeedSquareFeedListViewModel", 1, "requestNet is loading");
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private final List<ij1.g> S1() {
        UIStateData<List<ij1.g>> value = this.mFeedsData.getValue();
        if (value != null) {
            return value.getData();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(final GuildFeedListDataRepo.b<GProGetGuildFeedsReq> reqParam, final boolean isCache, final boolean forceScrollTop, final GProGetGuildFeedsRsp rsp, final GuildInteractiveNotificationItem notificationItem) {
        Integer num;
        if (W1(isCache, reqParam.getSortMode())) {
            return;
        }
        String p16 = reqParam.p();
        String str = rsp.feedAttchInfo;
        if (str != null) {
            num = Integer.valueOf(str.hashCode());
        } else {
            num = null;
        }
        QLog.d("GuildFeedSquareFeedListViewModel", 1, "handleGetFeedListRsp reqParam=" + p16 + ", isCache=" + isCache + ", feedAttchInfo=" + num + " isFinish=" + rsp.isFinish);
        this.mSortMode = reqParam.getSortMode();
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedSquareFeedListViewModel.U1(GuildFeedSquareFeedListViewModel.this, rsp, isCache, reqParam, forceScrollTop, notificationItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GuildFeedSquareFeedListViewModel this$0, GProGetGuildFeedsRsp rsp, boolean z16, GuildFeedListDataRepo.b reqParam, boolean z17, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(reqParam, "$reqParam");
        this$0.Z1(rsp, z16);
        this$0.a2(rsp, z16);
        this$0.c2(reqParam, z16, z17, rsp, this$0.b2(rsp), guildInteractiveNotificationItem);
    }

    private final boolean W1(boolean isCacheRsp, int newSortMode) {
        boolean z16;
        boolean z17 = false;
        if (isCacheRsp) {
            List<ij1.g> S1 = S1();
            if (S1 != null && !S1.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && newSortMode == this.mSortMode) {
                z17 = true;
            }
        }
        if (z17) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "isInvalidRsp isCacheRsp:true newSortMode:" + newSortMode + " mSortMode:" + this.mSortMode;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedSquareFeedListViewModel", 1, (String) it.next(), null);
            }
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(boolean usePreData, List<ij1.g> newFeedList, UIStateData<List<ij1.g>> data) {
        List<ij1.g> list;
        boolean z16;
        UIStateData<List<ij1.g>> value = this.mFeedsData.getValue();
        if (value != null) {
            list = value.getData();
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (usePreData) {
            FeedSquareViewModeUtils.f219276a.a(list, newFeedList);
            List<ij1.g> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                arrayList.addAll(list2);
            }
        }
        List<ij1.g> list3 = newFeedList;
        if (!list3.isEmpty()) {
            arrayList.addAll(list3);
        }
        data.setDataList(arrayList);
        if (arrayList.size() == 0) {
            data.setState(0);
        }
        this.mFeedsData.setValue(data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0010, code lost:
    
        if (r3 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Z1(GProGetGuildFeedsRsp rsp, boolean isCache) {
        boolean z16;
        synchronized (this.mAttachInfo) {
            if (isCache) {
                if (this.mAttachInfo.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            String str = rsp.feedAttchInfo;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.feedAttchInfo");
            this.mAttachInfo = str;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x000d, code lost:
    
        if (r3 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a2(GProGetGuildFeedsRsp rsp, boolean isCache) {
        boolean z16;
        synchronized (this.mToken) {
            if (isCache) {
                if (this.mToken.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            byte[] bArr = rsp.token;
            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.token");
            this.mToken = bArr;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean b2(GProGetGuildFeedsRsp rsp) {
        if (rsp.isFinish > 0) {
            return true;
        }
        return false;
    }

    private final void c2(GuildFeedListDataRepo.b<GProGetGuildFeedsReq> reqParam, final boolean isCache, boolean forceScrollTop, final GProGetGuildFeedsRsp rsp, final boolean isFinish, final GuildInteractiveNotificationItem notificationItem) {
        String str;
        final String str2;
        ArrayList<ij1.g> arrayList;
        boolean z16;
        Runnable runnable;
        int collectionSizeOrDefault;
        final ArrayList<ij1.g> validBlockDataList = ij1.c.c(rsp.vecFeedList, rsp.traceId);
        com.tencent.mobileqq.guild.feed.feedsquare.utils.k<ij1.g> kVar = this.publishFeedHelper;
        String guildId = this.mFeedInitBean.getGuildId();
        if (guildId == null) {
            str = "";
        } else {
            str = guildId;
        }
        Intrinsics.checkNotNullExpressionValue(validBlockDataList, "validBlockDataList");
        kVar.j(new com.tencent.mobileqq.guild.feed.feedsquare.utils.d<>(str, "", true, validBlockDataList, isFinish, reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), reqParam.getSortMode(), isCache));
        String guildId2 = this.mFeedInitBean.getGuildId();
        if (guildId2 == null) {
            str2 = "";
        } else {
            str2 = guildId2;
        }
        final GuildGameDistributeAdData b16 = ij1.c.b(str2, rsp.advInfo);
        final ArrayList<ij1.h> d16 = ij1.c.d(rsp.topFeeds);
        if (!reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
            arrayList = validBlockDataList;
            z16 = isFinish;
            runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSquareFeedListViewModel.d2(str2, rsp, validBlockDataList, this, isCache, d16, b16, notificationItem, isFinish);
                }
            };
        } else {
            arrayList = validBlockDataList;
            z16 = isFinish;
            runnable = null;
        }
        jj1.b c16 = jj1.b.c();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ij1.g) it.next()).b());
        }
        c16.initOrUpdateGlobalState((List) arrayList2, true);
        int i3 = 0;
        if (arrayList.isEmpty() && !reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String()) {
            UIStateData<List<ij1.g>> finish = UIStateData.obtainEmpty().setData(false, new ArrayList()).setType(reqParam.getSortMode()).setFinish(z16);
            Intrinsics.checkNotNullExpressionValue(finish, "obtainEmpty<MutableList<\u2026     .setFinish(isFinish)");
            f2(finish, runnable);
        } else {
            UIStateData data = UIStateData.obtainSuccess(isCache).setData(reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), arrayList);
            if (!forceScrollTop) {
                i3 = -1;
            }
            UIStateData<List<ij1.g>> finish2 = data.setPos(i3).setType(reqParam.getSortMode()).setFinish(z16);
            Intrinsics.checkNotNullExpressionValue(finish2, "obtainSuccess<MutableLis\u2026     .setFinish(isFinish)");
            e2(reqParam, isCache, finish2, arrayList, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
    
        if ((!r3.isEmpty()) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d2(String guildId, GProGetGuildFeedsRsp rsp, ArrayList validBlockDataList, GuildFeedSquareFeedListViewModel this$0, boolean z16, ArrayList topFeedsDataList, GuildGameDistributeAdData guildGameDistributeAdData, GuildInteractiveNotificationItem guildInteractiveNotificationItem, boolean z17) {
        boolean z18;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ch.n0(guildId) && !rsp.hasFeed) {
            Intrinsics.checkNotNullExpressionValue(validBlockDataList, "validBlockDataList");
            z18 = true;
        }
        z18 = false;
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> mutableLiveData = this$0.mFeedsHeaderData;
        UIStateData obtainSuccess = UIStateData.obtainSuccess(z16);
        Intrinsics.checkNotNullExpressionValue(topFeedsDataList, "topFeedsDataList");
        mutableLiveData.setValue(obtainSuccess.setData(false, new GuildFeedsHeaderData(topFeedsDataList, guildGameDistributeAdData, guildInteractiveNotificationItem, z18)).setFinish(z17));
    }

    private final void e2(final GuildFeedListDataRepo.b<GProGetGuildFeedsReq> reqParam, final boolean isCache, final UIStateData<List<ij1.g>> data, final List<ij1.g> newFeedList, final Runnable extraTask) {
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (!isCache) {
                reqParam.o(true);
            } else if (reqParam.getHasNotCacheFeedHandle()) {
                Logger.f235387a.d().w("GuildFeedSquareFeedListViewModel", 1, "postFeedInMain hasNotCacheFeedHandle");
                return;
            }
            Logger.f235387a.d().i("GuildFeedSquareFeedListViewModel", 1, "postFeedInMain reqParam=" + reqParam.p() + " isCache=" + isCache + " newFeedListSize=" + newFeedList.size());
            X1(reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), newFeedList, data);
            if (extraTask != null) {
                extraTask.run();
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$postFeedInMain$$inlined$ensureUiThread$2
            @Override // java.lang.Runnable
            public final void run() {
                if (!isCache) {
                    reqParam.o(true);
                } else if (reqParam.getHasNotCacheFeedHandle()) {
                    Logger.f235387a.d().w("GuildFeedSquareFeedListViewModel", 1, "postFeedInMain hasNotCacheFeedHandle");
                    return;
                }
                Logger.f235387a.d().i("GuildFeedSquareFeedListViewModel", 1, "postFeedInMain reqParam=" + reqParam.p() + " isCache=" + isCache + " newFeedListSize=" + newFeedList.size());
                this.X1(reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String(), newFeedList, data);
                Runnable runnable = extraTask;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    private final void f2(final UIStateData<List<ij1.g>> data, final Runnable extraTask) {
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (extraTask != null) {
                extraTask.run();
            }
            this.mFeedsData.setValue(data);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$postFeedInMain$$inlined$ensureUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable = extraTask;
                if (runnable != null) {
                    runnable.run();
                }
                this.mFeedsData.setValue(data);
            }
        });
    }

    private final boolean g2(boolean isLoadMore, boolean enableUseCache, int sortMode, String feedId, String topChannelId, int topType, String topBusinessId, boolean forceScrollTop, Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        int i3;
        boolean z16;
        String str;
        String str2;
        if (enableUseCache && TextUtils.isEmpty(feedId)) {
            i3 = sortMode;
            z16 = true;
        } else {
            i3 = sortMode;
            z16 = false;
        }
        if (R1(isLoadMore, i3, z16)) {
            return false;
        }
        String guildId = this.mFeedInitBean.getGuildId();
        if (guildId == null) {
            str = "";
        } else {
            str = guildId;
        }
        if (!isLoadMore) {
            str2 = "";
        } else {
            str2 = this.mAttachInfo;
        }
        GuildFeedListDataRepo.b<GProGetGuildFeedsReq> bVar = new GuildFeedListDataRepo.b<>(str, "", feedId, sortMode, isLoadMore, enableUseCache, str2, topChannelId, null, topType, topBusinessId, 0L, null, 6144, null);
        QLog.i("GuildFeedSquareFeedListViewModel", 1, "requestNet reqParam=" + bVar.p() + " enableUseCache=" + enableUseCache);
        this.mFeedListDataRepo.l(bVar, new b(callback, this, bVar, forceScrollTop, Reporters.f231995a.b().a("feed_top_business"), sortMode, isLoadMore));
        return true;
    }

    static /* synthetic */ boolean h2(GuildFeedSquareFeedListViewModel guildFeedSquareFeedListViewModel, boolean z16, boolean z17, int i3, String str, String str2, int i16, String str3, boolean z18, Function4 function4, int i17, Object obj) {
        boolean z19;
        Function4 function42;
        if ((i17 & 128) != 0) {
            z19 = false;
        } else {
            z19 = z18;
        }
        if ((i17 & 256) != 0) {
            function42 = null;
        } else {
            function42 = function4;
        }
        return guildFeedSquareFeedListViewModel.g2(z16, z17, i3, str, str2, i16, str3, z19, function42);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void C1(boolean z16, int i3, @NotNull String str, int i16, @NotNull String str2, boolean z17, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> function4) {
        m.a.a(this, z16, i3, str, i16, str2, z17, function4);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void J0(@NotNull DeleteFeedArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.D.J0(args);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void J1(@NotNull List<? extends ij1.g> newFeedList, @NotNull InsertFeedArgs args) {
        Intrinsics.checkNotNullParameter(newFeedList, "newFeedList");
        Intrinsics.checkNotNullParameter(args, "args");
        this.D.J1(newFeedList, args);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void P0(boolean enableUseCache, int refreshMode, @NotNull String topFeedId, @NotNull String topChannelId, int topType, @NotNull String topBusinessId, boolean forceScrollTop, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(topFeedId, "topFeedId");
        Intrinsics.checkNotNullParameter(topChannelId, "topChannelId");
        Intrinsics.checkNotNullParameter(topBusinessId, "topBusinessId");
        g2(false, enableUseCache, refreshMode, topFeedId, topChannelId, topType, topBusinessId, forceScrollTop, callback);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    @Nullable
    public MutableLiveData<UIStateData<GuildFeedsHeaderData>> X() {
        return this.mFeedsHeaderData;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    @Nullable
    public MutableLiveData<UIStateData<List<ij1.g>>> getDisplaySurfaceData(@NotNull Object... args) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length < 2 || Intrinsics.areEqual(args[1], this.mFeedInitBean.getGuildId())) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
            if (!Intrinsics.areEqual(firstOrNull, "data_type_feed_list")) {
                return null;
            }
            return this.mFeedsData;
        }
        return null;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        if (this.mSortMode != 2) {
            return 2;
        }
        return 1;
    }

    @Override // co1.f
    @NotNull
    public Map<String, Object> getExtra() {
        HashMap hashMap = new HashMap();
        String str = this.mAttachInfo;
        if (str == null) {
            str = "";
        }
        hashMap.put("attachInfo", str);
        return hashMap;
    }

    @Override // co1.h
    @NotNull
    /* renamed from: getIdentifier */
    public String getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String() {
        return this.C.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.m
    @NotNull
    /* renamed from: getToken, reason: from getter */
    public byte[] getMToken() {
        return this.mToken;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void h() {
        m.a.b(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void i1(@NotNull ModifyFeedArgsV2 argsV2) {
        Intrinsics.checkNotNullParameter(argsV2, "argsV2");
        this.D.i1(argsV2);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    @NotNull
    public MutableLiveData<UIStateData<List<ij1.g>>> j() {
        return this.mFeedsData;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        n(this.mSortMode);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    public void n(int sortMode) {
        UIStateData<List<ij1.g>> value;
        UIStateData<List<ij1.g>> value2 = this.mFeedsData.getValue();
        boolean z16 = false;
        if (value2 != null && value2.isLoading()) {
            z16 = true;
        }
        if (z16) {
            QLog.e("GuildFeedSquareFeedListViewModel", 1, "isLoading Ignore");
        } else if (h2(this, true, false, sortMode, "", "", 0, "", false, null, MsgConstant.KRMFILETHUMBSIZE384, null) && (value = this.mFeedsData.getValue()) != null) {
            value.setLoadingState();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.m
    @NotNull
    public MutableLiveData<Boolean> o() {
        return this.mNewFeedNavBarData;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k
    /* renamed from: p, reason: from getter */
    public int getMSortMode() {
        return this.mSortMode;
    }

    @Override // co1.j
    public void setIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.C.setIdentifier(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.n
    public void x1(@NotNull ij1.g modifyFeed, @NotNull ModifyFeedArgs args) {
        Intrinsics.checkNotNullParameter(modifyFeed, "modifyFeed");
        Intrinsics.checkNotNullParameter(args, "args");
        this.D.x1(modifyFeed, args);
    }

    public /* synthetic */ GuildFeedSquareFeedListViewModel(MutableLiveData mutableLiveData, GuildFeedSquareInitBean guildFeedSquareInitBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i3 & 2) != 0 ? new GuildFeedSquareInitBean() : guildFeedSquareInitBean);
    }

    public GuildFeedSquareFeedListViewModel(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> mFeedsData, @NotNull GuildFeedSquareInitBean mFeedInitBean) {
        Intrinsics.checkNotNullParameter(mFeedsData, "mFeedsData");
        Intrinsics.checkNotNullParameter(mFeedInitBean, "mFeedInitBean");
        this.mFeedsData = mFeedsData;
        this.mFeedInitBean = mFeedInitBean;
        this.C = new co1.i();
        this.D = new UIStateDataUtils.DefaultUIStateDataOperateImpl(mFeedsData);
        if (!ch.j0(mFeedInitBean.getGuildId())) {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).getSimpleProfile(mFeedInitBean.getGuildId(), ch.f(), 100);
        }
        this.mFeedListDataRepo = new GuildFeedListDataRepo("GuildFeedSquareFeedListViewModel", -1);
        this.mNewFeedNavBarData = new MutableLiveData<>();
        this.mAttachInfo = "";
        this.mSortMode = 2;
        this.mToken = new byte[0];
        this.mFeedsHeaderData = new MutableLiveData<>();
        this.publishFeedHelper = new com.tencent.mobileqq.guild.feed.feedsquare.utils.k<>(new Function1<ij1.g, GProStFeed>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$publishFeedHelper$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final GProStFeed invoke(@NotNull ij1.g $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return $receiver.b();
            }
        }, new Function2<ij1.g, GuildTaskProgressState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$publishFeedHelper$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ij1.g gVar, GuildTaskProgressState guildTaskProgressState) {
                invoke2(gVar, guildTaskProgressState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ij1.g $receiver, @NotNull GuildTaskProgressState it) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Intrinsics.checkNotNullParameter(it, "it");
                $receiver.z(it);
            }
        }, new Function1<GProStFeed, ij1.g>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$publishFeedHelper$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final ij1.g invoke(@NotNull GProStFeed it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new ij1.g(it);
            }
        }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g>, List<? extends a.FeedPublishFinish>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$publishFeedHelper$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<a.FeedPublishFinish> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).finishedFeedPublishState(it.getGuildId(), it.getChannelId());
            }
        }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g>, List<? extends FeedPublishStateV2>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel$publishFeedHelper$5
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<FeedPublishStateV2> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.utils.d<ij1.g> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).syncQueryFailPublishStateV2s(it.getGuildId(), it.getChannelId());
            }
        });
    }
}
