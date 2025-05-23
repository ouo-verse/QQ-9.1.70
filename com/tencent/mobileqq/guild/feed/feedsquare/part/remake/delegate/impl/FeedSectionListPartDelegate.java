package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import ak1.b;
import android.app.Activity;
import android.view.View;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import ck1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareEmptyAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListAdapterWorker;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultLoadMoreAdapterWorker;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ff\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\b*\u0003\u0003\u008f\u0001\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0095\u0001B#\u0012\b\b\u0002\u0010B\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020\r0C\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J0\u0010\u0011\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001c\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0016J\u001c\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 H\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016J\u0094\u0001\u00108\u001a\u00020\b2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010-2h\u00107\u001ad\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\b\u0018\u00010/j\u0004\u0018\u0001`6H\u0016J\u0010\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0014J\u0012\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016R\u0017\u0010B\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR \u0010H\u001a\b\u0012\u0004\u0012\u00020\r0C8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\"\u0010$\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010\u001f\u001a\u00020\u001e8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR,\u0010!\u001a\f\u0012\u0004\u0012\u00020U0 j\u0002`V8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010c\u001a\u00020]8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010eR8\u0010n\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i0\f0\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bM\u0010k\u001a\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010w\u001a\u00020s8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\ba\u0010t\u001a\u0004\bu\u0010vR\u001a\u0010{\u001a\u00020\u00178\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b[\u0010x\u001a\u0004\by\u0010zR\u001b\u0010\u0080\u0001\u001a\u00020\u00198\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007fR\u001f\u0010\u0085\u0001\u001a\u00030\u0081\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\b)\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R9\u0010\u008e\u0001\u001a\u0014\u0012\u000f\u0012\r\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020-0\u0087\u00010\u0086\u00018\u0016X\u0096\u0004\u00a2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u0012\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate;", "Lbk1/a;", "Lcom/tencent/input/base/mvicompat/ex/a;", "com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$b", "j", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "B", "", "isScrolling", "Lkotlin/Pair;", "", "visiblePositionPair", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "completelyVisiblePositionPair", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "uiStateData", "y", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListAdapterWorker;", "o", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultLoadMoreAdapterWorker;", "p", "", "", "f0", "Lcom/tencent/biz/richframework/part/Part;", "part", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "q7", "Lak1/a;", "partApi", "M2", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "Lcom/tencent/mvi/base/route/k;", "I", "enableUseCache", "isShowHeadRefresher", "forceScrollTop", "", "extendArgs", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "X4", "args", HippyTKDListViewAdapter.X, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "getSortMode", "()Landroidx/lifecycle/LiveData;", "sortMode", "f", "Lak1/a;", ReportConstant.COSTREPORT_PREFIX, "()Lak1/a;", "D", "(Lak1/a;)V", tl.h.F, "Lcom/tencent/biz/richframework/part/Part;", "r", "()Lcom/tencent/biz/richframework/part/Part;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/biz/richframework/part/Part;)V", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "i", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "u", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "G", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;)V", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "t", "()Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageRegistry", "Ljava/lang/Class;", "Lyj1/f;", "Lkotlin/Function0;", "Lyj1/c;", "Ljava/util/List;", "getIocConstructorList", "()Ljava/util/List;", "iocConstructorList", "Lyj1/e;", "E", "Lyj1/e;", "videoPlayManager", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSquareVideoPlayManagerInjectRecyclerViewInitializer;", "feedViewInitializer", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListAdapterWorker;", "getFeedListWorker", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListAdapterWorker;", "feedListWorker", "H", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultLoadMoreAdapterWorker;", "getLoadMoreWorker", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultLoadMoreAdapterWorker;", "loadMoreWorker", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/a;", "getEmptyAdapterWorker", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/a;", "emptyAdapterWorker", "", "Lbk1/a$a;", "J", "[Lbk1/a$a;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()[Lbk1/a$a;", "getWorkers$annotations", "()V", "workers", "com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$d", "K", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$d;", "loadMoreListener", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/LiveData;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedSectionListPartDelegate implements bk1.a, com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageRegistry;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<Class<yj1.f>, Function0<yj1.c>>> iocConstructorList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final yj1.e videoPlayManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final FeedSquareVideoPlayManagerInjectRecyclerViewInitializer feedViewInitializer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final DefaultFeedListAdapterWorker feedListWorker;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final DefaultLoadMoreAdapterWorker loadMoreWorker;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.a emptyAdapterWorker;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a.AbstractC0131a<?, Object>[] workers;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final d loadMoreListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Integer> sortMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected ak1.a partApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected Part part;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareEmptyAdapter$a;", "", UserInfo.SEX_FEMALE, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedSquareEmptyAdapter.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareEmptyAdapter.a
        public void F() {
            b.a.a(FeedSectionListPartDelegate.this.s(), false, true, true, null, null, 24, null);
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/Pair;", "", "e", "d", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "", "Z", "mScrolling", "I", "mScrollingCookie", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean mScrolling;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int mScrollingCookie = -1;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ FeedSectionListPartDelegate f218947h;

        public c(FeedSectionListPartDelegate feedSectionListPartDelegate) {
            this.f218947h = feedSectionListPartDelegate;
        }

        private final Pair<Integer, Integer> d(RecyclerView recyclerView) {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                return new Pair<>(Integer.valueOf(linearLayoutManager.findFirstCompletelyVisibleItemPosition()), Integer.valueOf(linearLayoutManager.findLastCompletelyVisibleItemPosition()));
            }
            return null;
        }

        private final Pair<Integer, Integer> e(RecyclerView recyclerView) {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                return new Pair<>(Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()), Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()));
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Pair<Integer, Integer> e16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traverseExposure();
                if (this.mScrolling && (e16 = e(recyclerView)) != null) {
                    this.f218947h.z(false, e16);
                }
                this.mScrolling = false;
                TraceUtils.j("feed_scrolling", this.mScrollingCookie);
                return;
            }
            if (!this.mScrolling) {
                this.mScrolling = true;
                Pair<Integer, Integer> e17 = e(recyclerView);
                if (e17 != null) {
                    this.f218947h.z(true, e17);
                }
                this.mScrollingCookie = TraceUtils.g("feed_scrolling");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Pair<Integer, Integer> d16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            Pair<Integer, Integer> e16 = e(recyclerView);
            if (e16 != null && (d16 = d(recyclerView)) != null) {
                FeedSectionListPartDelegate.this.A(e16, d16);
            }
        }
    }

    public FeedSectionListPartDelegate() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(Pair<Integer, Integer> visiblePositionPair, Pair<Integer, Integer> completelyVisiblePositionPair) {
        u().getMessenger().h(new FeedSectionListPartMsgIntent.OnScrolledChangeMsgIntent(u().d(), visiblePositionPair, completelyVisiblePositionPair));
    }

    private final void B() {
        GuildFeedVideoPlayParamManager.f223979d.a();
        this.videoPlayManager.c();
    }

    private final b j() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleOwner k(FeedSectionListPartDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.u().getLifecycleOwner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerView l(FeedSectionListPartDelegate this$0, RecyclerView recyclerView, View rootView, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(config, "config");
        j jVar = j.f218969a;
        RecyclerView a16 = jVar.a(jVar.b(new IocInjectHelperRecyclerViewInitializer(new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.b(0, 1, null), this$0.iocConstructorList).a(recyclerView, rootView, config)));
        a16.addOnScrollListener(new c(this$0));
        RecyclerView a17 = i.a(a16);
        a17.setOverScrollMode(2);
        a17.setTag(com.tencent.mobileqq.guild.feed.feedsquare.utils.g.a(), GuildFeedMediaSizeUtils.f219296d);
        this$0.F(a17);
        this$0.feedListWorker.w(a17);
        return a17;
    }

    private final a m() {
        Integer valueOf;
        int p16 = u().getVmApi().p();
        if (p16 == 0) {
            Integer value = this.sortMode.getValue();
            Intrinsics.checkNotNull(value);
            valueOf = value;
        } else {
            valueOf = Integer.valueOf(p16);
        }
        Intrinsics.checkNotNullExpressionValue(valueOf, "when (val mode = section\u2026   else -> mode\n        }");
        return new a(valueOf.intValue(), false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerView.Adapter q(FeedSectionListPartDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.feedListWorker.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(UIStateData<List<ij1.g>> uiStateData) {
        boolean z16;
        int state = uiStateData.getState();
        if (state == 2 || state == 3) {
            List<ij1.g> data = uiStateData.getData();
            if (data != null && !data.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !uiStateData.getIsLoadMore()) {
                this.videoPlayManager.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean isScrolling, Pair<Integer, Integer> visiblePositionPair) {
        boolean z16;
        boolean z17;
        boolean z18;
        UIStateData<List<ij1.g>> value = u().getVmApi().j().getValue();
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> items = this.feedListWorker.b().getItems();
        com.tencent.mvi.base.route.j messenger = u().getMessenger();
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<GuildFeedMainInitBean> d16 = u().d();
        if (value != null) {
            z16 = value.getIsFinish();
        } else {
            z16 = false;
        }
        if (value != null) {
            z17 = value.getIsLoadMore();
        } else {
            z17 = false;
        }
        if (value != null) {
            z18 = value.isLoading();
        } else {
            z18 = false;
        }
        messenger.h(new FeedSectionListPartMsgIntent.OnScrollStateChangeMsgIntent(d16, isScrolling, visiblePositionPair, new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.a(items, z16, z17, z18, items.size())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<set-?>");
        this.part = part;
    }

    protected final void D(@NotNull ak1.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.partApi = aVar;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent msgIntent) {
        a.C5857a.c(this, msgIntent);
    }

    protected final void F(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    protected final void G(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.sectionContext = bVar;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public com.tencent.mvi.base.route.k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedSectionListPartMsgIntent.GetFeedListSortModeMsgIntent) {
            Integer value = this.sortMode.getValue();
            Intrinsics.checkNotNull(value);
            return new a.b(value.intValue());
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> J2() {
        return a.C5857a.a(this);
    }

    @Override // bk1.a
    public void M2(@NotNull Part part, @NotNull ak1.a partApi) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(partApi, "partApi");
        D(partApi);
        this.loadMoreWorker.b().registerLoadMoreListener(this.loadMoreListener);
        this.emptyAdapterWorker.b().F0(j());
        this.feedListWorker.h(partApi);
        this.loadMoreWorker.h(partApi);
    }

    @Override // ak1.b
    public void X4(boolean enableUseCache, boolean isShowHeadRefresher, boolean forceScrollTop, @Nullable Object extendArgs, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        a aVar;
        B();
        if (extendArgs instanceof a) {
            aVar = (a) extendArgs;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = m();
        }
        a x16 = x(aVar);
        if (x16.getIsDelayRefresh()) {
            u().getVmApi().C1(enableUseCache, x16.getRefreshMode(), x16.getTopChannelId(), x16.getTopType(), x16.getTopBusinessId(), forceScrollTop, callback);
            return;
        }
        k.a.c(u().getVmApi(), enableUseCache, x16.getRefreshMode(), null, x16.getTopChannelId(), x16.getTopType(), x16.getTopBusinessId(), forceScrollTop, callback, 4, null);
    }

    @Override // bk1.a
    @NotNull
    public a.AbstractC0131a<?, Object>[] a2() {
        return this.workers;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> f0() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(FeedSectionListPartMsgIntent.GetFeedListSortModeMsgIntent.class).getQualifiedName());
        return listOf;
    }

    @Override // bk1.a
    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @Override // bk1.a
    public void h() {
        a.c.a(this);
    }

    @Override // bk1.a
    @NotNull
    /* renamed from: n, reason: from getter and merged with bridge method [inline-methods] */
    public FeedSquareVideoPlayManagerInjectRecyclerViewInitializer v5() {
        return this.feedViewInitializer;
    }

    @NotNull
    protected DefaultFeedListAdapterWorker o() {
        return new DefaultFeedListAdapterWorker(this.tag);
    }

    @Override // com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        com.tencent.biz.richframework.part.b.b(this, activity);
        for (a.AbstractC0131a<?, Object> abstractC0131a : a2()) {
            abstractC0131a.destroy();
        }
        t().setAdapter(null);
        this.videoPlayManager.d();
        this.messageRegistry.e(u().getMessenger());
        this.loadMoreWorker.b().unRegisterLoadMoreListener(this.loadMoreListener);
    }

    @NotNull
    protected DefaultLoadMoreAdapterWorker p() {
        return new DefaultLoadMoreAdapterWorker(0, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.h
            @Override // androidx.core.util.Supplier
            public final Object get() {
                RecyclerView.Adapter q16;
                q16 = FeedSectionListPartDelegate.q(FeedSectionListPartDelegate.this);
                return q16;
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bk1.a
    public void q7(@NotNull Part part, @NotNull final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<?> sectionContext) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(sectionContext, "sectionContext");
        C(part);
        G(sectionContext);
        for (a.AbstractC0131a<?, Object> abstractC0131a : a2()) {
            abstractC0131a.e(sectionContext);
        }
        this.messageRegistry.d(sectionContext.getMessenger());
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.a aVar = this.emptyAdapterWorker;
        ViewModel viewModel = part.getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.k.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "part.getViewModel(GuildI\u2026gerViewModel::class.java)");
        aVar.i((com.tencent.mobileqq.guild.feed.viewmodel.k) viewModel);
        DefaultLoadMoreAdapterWorker defaultLoadMoreAdapterWorker = this.loadMoreWorker;
        ViewModel viewModel2 = part.getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.k.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "part.getViewModel(GuildI\u2026gerViewModel::class.java)");
        defaultLoadMoreAdapterWorker.q((com.tencent.mobileqq.guild.feed.viewmodel.k) viewModel2);
        MutableLiveData<UIStateData<List<ij1.g>>> j3 = u().getVmApi().j();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(part);
        final FeedSectionListPartDelegate$onAttachPart$2 feedSectionListPartDelegate$onAttachPart$2 = new FeedSectionListPartDelegate$onAttachPart$2(this);
        j3.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSectionListPartDelegate.v(Function1.this, obj);
            }
        });
        LiveData<Integer> liveData = this.sortMode;
        LifecycleOwner c17 = com.tencent.mobileqq.guild.feed.part.a.c(part);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate$onAttachPart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer sortMode) {
                GuildFeedMainInitBean guildFeedMainInitBean;
                QLog.d(FeedSectionListPartDelegate.this.getTag(), 1, "[sortMode] updated, new mode: " + sortMode);
                GuildFeedMainInitBean guildFeedMainInitBean2 = (GuildFeedMainInitBean) sectionContext.d().b();
                if (!(guildFeedMainInitBean2 != null && guildFeedMainInitBean2.getBusinessType() == 15) && (guildFeedMainInitBean = (GuildFeedMainInitBean) sectionContext.d().b()) != null) {
                    av avVar = av.f223852a;
                    Intrinsics.checkNotNullExpressionValue(sortMode, "sortMode");
                    guildFeedMainInitBean.setBusinessType(avVar.b(sortMode.intValue()));
                }
                com.tencent.mvi.base.route.j messenger = sectionContext.getMessenger();
                com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<?> d16 = sectionContext.d();
                Intrinsics.checkNotNullExpressionValue(sortMode, "sortMode");
                messenger.h(new FeedSectionListPartMsgIntent.OnSortModeChangedMsgIntent(d16, sortMode.intValue()));
                sectionContext.getMessenger().h(new FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent(sectionContext.d().a(), true, true, true, new FeedSectionListPartDelegate.a(sortMode.intValue(), true, false)));
            }
        };
        liveData.observe(c17, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSectionListPartDelegate.w(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Part r() {
        Part part = this.part;
        if (part != null) {
            return part;
        }
        Intrinsics.throwUninitializedPropertyAccessException("part");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ak1.a s() {
        ak1.a aVar = this.partApi;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("partApi");
        return null;
    }

    @NotNull
    protected final RecyclerView t() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> u() {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar = this.sectionContext;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sectionContext");
        return null;
    }

    @NotNull
    protected a x(@NotNull a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return args;
    }

    public FeedSectionListPartDelegate(@NotNull String tag, @NotNull LiveData<Integer> sortMode) {
        List<Pair<Class<yj1.f>, Function0<yj1.c>>> listOf;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(sortMode, "sortMode");
        this.tag = tag;
        this.sortMode = sortMode;
        this.messageRegistry = new VMMessengerProtocolSupport(this);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TuplesKt.to(yj1.f.class, new Function0<yj1.c>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate$iocConstructorList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yj1.c invoke() {
                return new yj1.c(com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(1, FeedSectionListPartDelegate.this.u().d().b()));
            }
        }));
        this.iocConstructorList = listOf;
        yj1.e eVar = new yj1.e();
        this.videoPlayManager = eVar;
        this.feedViewInitializer = new FeedSquareVideoPlayManagerInjectRecyclerViewInitializer(eVar, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.d
            @Override // androidx.core.util.Supplier
            public final Object get() {
                LifecycleOwner k3;
                k3 = FeedSectionListPartDelegate.k(FeedSectionListPartDelegate.this);
                return k3;
            }
        }, new a.d() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.e
            @Override // bk1.a.d
            public final RecyclerView a(RecyclerView recyclerView, View view, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j jVar) {
                RecyclerView l3;
                l3 = FeedSectionListPartDelegate.l(FeedSectionListPartDelegate.this, recyclerView, view, jVar);
                return l3;
            }
        });
        DefaultFeedListAdapterWorker o16 = o();
        this.feedListWorker = o16;
        DefaultLoadMoreAdapterWorker p16 = p();
        this.loadMoreWorker = p16;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.a aVar = new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.a();
        this.emptyAdapterWorker = aVar;
        this.workers = new a.AbstractC0131a[]{o16, p16, aVar};
        this.loadMoreListener = new d();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\n\u0010\u0017\"\u0004\b \u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$a;", "", "", "toString", "", "a", "I", "()I", "refreshMode", "", "b", "Z", "f", "()Z", "isFirstRefresh", "c", "e", "g", "(Z)V", "isDelayRefresh", "d", "Ljava/lang/String;", "getTopFeedId", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "topFeedId", "i", "topChannelId", "k", "(I)V", MiniChatConstants.MINI_APP_TOP_TYPE, tl.h.F, "topBusinessId", "<init>", "(IZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int refreshMode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFirstRefresh;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isDelayRefresh;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String topFeedId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String topChannelId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int topType;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String topBusinessId;

        public a(int i3, boolean z16, boolean z17) {
            this.refreshMode = i3;
            this.isFirstRefresh = z16;
            this.isDelayRefresh = z17;
            this.topFeedId = "";
            this.topChannelId = "";
            this.topBusinessId = "";
        }

        /* renamed from: a, reason: from getter */
        public final int getRefreshMode() {
            return this.refreshMode;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTopBusinessId() {
            return this.topBusinessId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTopChannelId() {
            return this.topChannelId;
        }

        /* renamed from: d, reason: from getter */
        public final int getTopType() {
            return this.topType;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsDelayRefresh() {
            return this.isDelayRefresh;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsFirstRefresh() {
            return this.isFirstRefresh;
        }

        public final void g(boolean z16) {
            this.isDelayRefresh = z16;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.topBusinessId = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.topChannelId = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.topFeedId = str;
        }

        public final void k(int i3) {
            this.topType = i3;
        }

        @NotNull
        public String toString() {
            return "{refreshMode=" + this.refreshMode + ", isFirstRefresh=" + this.isFirstRefresh + ", isDelayRefresh=" + this.isDelayRefresh + ", topChannelId=" + this.topChannelId + ", topType=" + this.topType + ", topBusinessId=" + this.topBusinessId + "}";
        }

        public /* synthetic */ a(int i3, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? false : z17);
        }
    }

    public /* synthetic */ FeedSectionListPartDelegate(String str, LiveData liveData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "ListPartDefaultDelegate" : str, (i3 & 2) != 0 ? new MutableLiveData(3) : liveData);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$d", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ILoadMoreProvider$LoadMoreListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            Boolean bool;
            String tag = FeedSectionListPartDelegate.this.getTag();
            UIStateData<List<ij1.g>> value = FeedSectionListPartDelegate.this.u().getVmApi().j().getValue();
            if (value != null) {
                bool = Boolean.valueOf(value.isCacheData());
            } else {
                bool = null;
            }
            QLog.d(tag, 1, "[FeedsLoad][onLoadMoreStart] begin load more, isCache=" + bool);
            FeedSectionListPartDelegate.this.u().getVmApi().n(FeedSectionListPartDelegate.this.u().getVmApi().p());
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
