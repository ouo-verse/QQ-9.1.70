package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt;
import com.tencent.mobileqq.guild.feed.nativeinterface.kt.GProStFeedKt;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishSuccessGetFeedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import in1.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kn1.FeedPublishStateV2;
import kn1.a;
import kn1.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0003DEFB\u0007\u00a2\u0006\u0004\bA\u0010BJ1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0003H\u0096\u0001J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001eH\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\rH\u0016R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R8\u00109\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000307\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b08068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R*\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/IFeedPublishServiceV2;", "", "", "guild", WadlProxyConsts.CHANNEL, "", "forceDB", "", "Lkn1/b;", "queryFeedPublishStateV2s", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guildId", "", "invalidateCache", "onQuitGuild", "isNewFeed", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "progressState", "stateV2FromProgressState", "mainTaskId", "Lin1/d;", "getPostFeedMainTaskFacade", "innerOnPublishBegin", "", "topicId", "syncQueryFailPublishStateV2s", "activePublishingFeed", "Lkn1/a$b;", "finishedFeedPublishState", "Lkotlinx/coroutines/flow/Flow;", "Lkn1/a$a;", "publishBeginFlow", "Lkn1/a$c;", "publishUpdateFlow", "publishEndFlow", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "activePublishingFeedFlag", "Z", "", "activePublishingFeedSet", "Ljava/util/Set;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$a$a;", "config$delegate", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "getConfig", "()Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$a$a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/AsyncDataMemoryStorage;", "Lkotlin/Pair;", "Lkotlinx/coroutines/Deferred;", "memoryStorage", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/AsyncDataMemoryStorage;", "Lkotlin/Function2;", "_publishBeginEvent", "Lkotlin/jvm/functions/Function2;", "Lkn1/a;", "publishEvents", "Lkotlinx/coroutines/flow/Flow;", "<init>", "()V", "Companion", "a", "Holder", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedPublishServiceV2Impl implements IFeedPublishServiceV2 {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FeedPublishServiceV2Impl.class, DownloadInfo.spKey_Config, "getConfig()Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$Companion$AutoResendConfig;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "FeedPublishServiceV2Impl";

    @Nullable
    private Function2<? super Boolean, ? super GuildTaskProgressState, Unit> _publishBeginEvent;
    private boolean activePublishingFeedFlag;

    /* renamed from: config$delegate, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.utils.a config;

    @NotNull
    private final AsyncDataMemoryStorage<Pair<String, String>, Deferred<List<FeedPublishStateV2>>> memoryStorage;

    @NotNull
    private final Flow<kn1.a> publishEvents;

    @NotNull
    private final CoroutineScope scope;
    private final /* synthetic */ a $$delegate_0 = new a();

    @NotNull
    private Set<String> activePublishingFeedSet = new LinkedHashSet();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR2\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$Holder;", "", "Lkn1/a$b;", "finish", "", "a", "b", "", "guild", WadlProxyConsts.CHANNEL, "", "c", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Ljava/util/concurrent/ConcurrentHashMap;", "finishedMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Holder {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Holder f223068a = new Holder();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Handler handler = new Handler(Looper.getMainLooper());

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final ConcurrentHashMap<Pair<String, String>, List<a.FeedPublishFinish>> finishedMap = new ConcurrentHashMap<>();

        Holder() {
        }

        public final void a(@NotNull a.FeedPublishFinish finish) {
            List<a.FeedPublishFinish> plus;
            List<a.FeedPublishFinish> plus2;
            Intrinsics.checkNotNullParameter(finish, "finish");
            Pair<String, String> pair = TuplesKt.to(finish.getState().getTaskState().getGuildId(), finish.getState().getTaskState().getChannelId());
            ConcurrentHashMap<Pair<String, String>, List<a.FeedPublishFinish>> concurrentHashMap = finishedMap;
            List<a.FeedPublishFinish> list = concurrentHashMap.get(pair);
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(list, "finishedMap[this] ?: emptyList()");
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends a.FeedPublishFinish>) ((Collection<? extends Object>) list), finish);
            concurrentHashMap.put(pair, plus);
            Pair<String, String> pair2 = TuplesKt.to(finish.getState().getTaskState().getGuildId(), "");
            List<a.FeedPublishFinish> list2 = concurrentHashMap.get(pair2);
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(list2, "finishedMap[this] ?: emptyList()");
            }
            plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends a.FeedPublishFinish>) ((Collection<? extends Object>) list2), finish);
            concurrentHashMap.put(pair2, plus2);
            Handler handler2 = handler;
            handler2.removeCallbacksAndMessages(null);
            handler2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$Holder$add$$inlined$postDelayed$default$1
                @Override // java.lang.Runnable
                public final void run() {
                    FeedPublishServiceV2Impl.Holder.f223068a.b();
                }
            }, 3000L);
        }

        public final void b() {
            finishedMap.clear();
        }

        @NotNull
        public final List<a.FeedPublishFinish> c(@NotNull String guild2, @NotNull String channel) {
            List<a.FeedPublishFinish> emptyList;
            Intrinsics.checkNotNullParameter(guild2, "guild");
            Intrinsics.checkNotNullParameter(channel, "channel");
            List<a.FeedPublishFinish> list = finishedMap.get(TuplesKt.to(guild2, channel));
            if (list == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return list;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u00020\u0003*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$a;", "", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "", "b", "(Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;)J", "needUploadSize", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "resendAllGuild", "", "b", "J", "()J", "uploadLimit", "<init>", "(ZJ)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes13.dex */
        public static final /* data */ class AutoResendConfig {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean resendAllGuild;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final long uploadLimit;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$a$a$a;", "", "", "jsonStr", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$a$a;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$a$a$a, reason: collision with other inner class name and from kotlin metadata */
            /* loaded from: classes13.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @NotNull
                public final AutoResendConfig a(@NotNull String jsonStr) {
                    Object m476constructorimpl;
                    Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(new JSONObject(jsonStr));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                        m476constructorimpl = new JSONObject();
                    }
                    JSONObject jSONObject = (JSONObject) m476constructorimpl;
                    long j3 = 1024;
                    return new AutoResendConfig(jSONObject.optBoolean("resendAllGuild", true), jSONObject.optLong("uploadLimitMB", 100L) * j3 * j3);
                }

                Companion() {
                }
            }

            public AutoResendConfig(boolean z16, long j3) {
                this.resendAllGuild = z16;
                this.uploadLimit = j3;
            }

            /* renamed from: a, reason: from getter */
            public final boolean getResendAllGuild() {
                return this.resendAllGuild;
            }

            /* renamed from: b, reason: from getter */
            public final long getUploadLimit() {
                return this.uploadLimit;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AutoResendConfig)) {
                    return false;
                }
                AutoResendConfig autoResendConfig = (AutoResendConfig) other;
                if (this.resendAllGuild == autoResendConfig.resendAllGuild && this.uploadLimit == autoResendConfig.uploadLimit) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z16 = this.resendAllGuild;
                ?? r06 = z16;
                if (z16) {
                    r06 = 1;
                }
                return (r06 * 31) + androidx.fragment.app.a.a(this.uploadLimit);
            }

            @NotNull
            public String toString() {
                return "AutoResendConfig(resendAllGuild=" + this.resendAllGuild + ", uploadLimit=" + this.uploadLimit + ")";
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long b(GuildTaskProgressState guildTaskProgressState) {
            boolean z16;
            List<GuildMediaProgressState> mediaProgressStates = guildTaskProgressState.getMediaProgressStates();
            Intrinsics.checkNotNullExpressionValue(mediaProgressStates, "mediaProgressStates");
            ArrayList arrayList = new ArrayList();
            for (Object obj : mediaProgressStates) {
                if (((GuildMediaProgressState) obj).getState() != 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                j3 += cq.v(((GuildMediaProgressState) it.next()).getPath());
            }
            return j3;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J1\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R3\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/FeedPublishServiceV2Impl$b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "e", "Lmqq/app/AppRuntime;", "appRuntime", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "guild", "cb", "f", "b", "onRemoveGuild", "", "black", "onBeKickFromGuild", "onDestoryGuild", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "_service", "Lkotlin/jvm/functions/Function1;", "_cb", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f223075d = new b();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static IGProGlobalService _service;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static Function1<? super String, Unit> _cb;

        b() {
        }

        private final void e(String guildId) {
            boolean z16;
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            Logger.f235387a.d().i(FeedPublishServiceV2Impl.TAG, 1, "innerDelete: " + guildId);
            Function1<? super String, Unit> function1 = _cb;
            if (function1 != null) {
                function1.invoke(guildId);
            }
        }

        public final void b() {
            IGProGlobalService iGProGlobalService = _service;
            if (iGProGlobalService != null) {
                iGProGlobalService.deleteObserver(this);
            }
        }

        public final void f(@NotNull AppRuntime appRuntime, @NotNull Function1<? super String, Unit> cb5) {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(cb5, "cb");
            _cb = cb5;
            IGProGlobalService iGProGlobalService = (IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "");
            _service = iGProGlobalService;
            if (iGProGlobalService != null) {
                iGProGlobalService.addObserver(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            e(guildId);
        }
    }

    public FeedPublishServiceV2Impl() {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(ae.a().d()));
        this.scope = CoroutineScope;
        this.config = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a(FeedPublishServiceV2Impl$config$2.INSTANCE, ComputedKt.a(), new Function1<String, Companion.AutoResendConfig>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$config$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FeedPublishServiceV2Impl.Companion.AutoResendConfig invoke(String str) {
                return FeedPublishServiceV2Impl.Companion.AutoResendConfig.INSTANCE.a(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("guild_feed_auto_resend", "{}"));
            }
        });
        this.memoryStorage = new AsyncDataMemoryStorage<>(new FeedPublishServiceV2Impl$memoryStorage$1(this, null), null, 2, null);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        final Flow onEach = FlowKt.onEach(FlowKt.callbackFlow(new FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$eventFlow$1(simpleEventBus, null)), new FeedPublishServiceV2Impl$publishEvents$1$startFlow$1(linkedHashMap2, null));
        Flow<Void> flow = new Flow<Void>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<FeedEditorEvent.OnStartPublishFeedEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223043d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f223043d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223043d;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(null, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Void> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        final Flow callbackFlow = FlowKt.callbackFlow(new FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1(this, linkedHashMap2, null));
        Flow<a.FeedPublishBegin> flow2 = new Flow<a.FeedPublishBegin>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<FeedPublishStateV2> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223056d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f223057e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {139}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Map map) {
                    this.f223056d = flowCollector;
                    this.f223057e = map;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(FeedPublishStateV2 feedPublishStateV2, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223056d;
                                FeedPublishStateV2 feedPublishStateV22 = feedPublishStateV2;
                                this.f223057e.put(feedPublishStateV22.getTaskId(), feedPublishStateV22);
                                a.FeedPublishBegin feedPublishBegin = new a.FeedPublishBegin(feedPublishStateV22);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(feedPublishBegin, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishBegin> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, linkedHashMap), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        final Flow callbackFlow2 = FlowKt.callbackFlow(new FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$eventFlow$2(simpleEventBus2, null));
        final Flow<FeedPublishStateV2> flow3 = new Flow<FeedPublishStateV2>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildTaskProgressStateEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223060d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f223061e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$2$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {139}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$2$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Map map) {
                    this.f223060d = flowCollector;
                    this.f223061e = map;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildTaskProgressStateEvent guildTaskProgressStateEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    FeedPublishStateV2 feedPublishStateV2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223060d;
                                GuildTaskProgressStateEvent guildTaskProgressStateEvent2 = guildTaskProgressStateEvent;
                                FeedPublishStateV2 feedPublishStateV22 = (FeedPublishStateV2) this.f223061e.get(guildTaskProgressStateEvent2.getTaskProgressState().getMainTaskId());
                                if (feedPublishStateV22 != null) {
                                    GuildTaskProgressState m184clone = guildTaskProgressStateEvent2.getTaskProgressState().m184clone();
                                    Intrinsics.checkNotNullExpressionValue(m184clone, "it.taskProgressState.clone()");
                                    feedPublishStateV2 = FeedPublishStateV2.b(feedPublishStateV22, false, null, null, m184clone, null, 23, null);
                                } else {
                                    feedPublishStateV2 = null;
                                }
                                if (feedPublishStateV2 != null) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishStateV2, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super FeedPublishStateV2> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, linkedHashMap), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        Flow<kn1.a> flow4 = new Flow<kn1.a>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<FeedPublishStateV2> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223046d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f223047e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$2$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$2$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Map map) {
                    this.f223046d = flowCollector;
                    this.f223047e = map;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(FeedPublishStateV2 feedPublishStateV2, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    kn1.a feedPublishUpdate;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223046d;
                                FeedPublishStateV2 feedPublishStateV22 = feedPublishStateV2;
                                this.f223047e.put(feedPublishStateV22.getTaskId(), feedPublishStateV22);
                                if (c.a(feedPublishStateV22.getTaskState())) {
                                    feedPublishUpdate = new a.FeedPublishFinish(feedPublishStateV22);
                                } else {
                                    feedPublishUpdate = new a.FeedPublishUpdate(feedPublishStateV22);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(feedPublishUpdate, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super kn1.a> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, linkedHashMap), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        SimpleEventBus simpleEventBus3 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus3, "getInstance()");
        final Flow callbackFlow3 = FlowKt.callbackFlow(new FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$eventFlow$3(simpleEventBus3, null));
        final Flow<FeedPublishStateV2> flow5 = new Flow<FeedPublishStateV2>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$3

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$3$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildPublishSuccessGetFeedEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223064d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f223065e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$3$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {139}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$mapNotNull$3$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Map map) {
                    this.f223064d = flowCollector;
                    this.f223065e = map;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    FeedPublishStateV2 feedPublishStateV2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223064d;
                                GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent2 = guildPublishSuccessGetFeedEvent;
                                FeedPublishStateV2 feedPublishStateV22 = (FeedPublishStateV2) this.f223065e.get(guildPublishSuccessGetFeedEvent2.getMainTaskId());
                                if (feedPublishStateV22 != null) {
                                    GProStFeed stFeed = guildPublishSuccessGetFeedEvent2.getStFeed();
                                    Intrinsics.checkNotNullExpressionValue(stFeed, "it.stFeed");
                                    GuildTaskProgressState m184clone = feedPublishStateV22.getTaskState().m184clone();
                                    Intrinsics.checkNotNullExpressionValue(m184clone, "old.taskState.clone()");
                                    feedPublishStateV2 = FeedPublishStateV2.b(feedPublishStateV22, false, null, stFeed, m184clone, null, 19, null);
                                } else {
                                    feedPublishStateV2 = null;
                                }
                                if (feedPublishStateV2 != null) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishStateV2, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super FeedPublishStateV2> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, linkedHashMap), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        this.publishEvents = FlowKt.shareIn(FlowKt.onEach(FlowKt.flowOn(FlowKt.onEach(FlowKt.filterNotNull(FlowKt.merge(flow, flow2, flow4, new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$3

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$3$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<FeedPublishStateV2> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223051d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f223052e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Map f223053f;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$3$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$lambda$7$$inlined$map$3$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Map map, Map map2) {
                    this.f223051d = flowCollector;
                    this.f223052e = map;
                    this.f223053f = map2;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(FeedPublishStateV2 feedPublishStateV2, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223051d;
                                FeedPublishStateV2 feedPublishStateV22 = feedPublishStateV2;
                                this.f223052e.remove(feedPublishStateV22.getTaskId());
                                this.f223053f.remove(feedPublishStateV22.getTaskId());
                                a.FeedPublishFinish feedPublishFinish = new a.FeedPublishFinish(feedPublishStateV22);
                                FeedPublishServiceV2Impl.Holder.f223068a.a(feedPublishFinish);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, linkedHashMap, linkedHashMap2), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        })), new FeedPublishServiceV2Impl$publishEvents$1$1(this, null)), Dispatchers.getIO()), new FeedPublishServiceV2Impl$publishEvents$1$2(null)), CoroutineScope, SharingStarted.INSTANCE.getEagerly(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Companion.AutoResendConfig getConfig() {
        return (Companion.AutoResendConfig) this.config.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onQuitGuild(String guild2) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FeedPublishServiceV2Impl$onQuitGuild$1(this, guild2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object queryFeedPublishStateV2s(String str, String str2, boolean z16, Continuation<? super List<FeedPublishStateV2>> continuation) {
        FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1 feedPublishServiceV2Impl$queryFeedPublishStateV2s$1;
        Object coroutine_suspended;
        int i3;
        Deferred deferred;
        String str3;
        String str4;
        List<FeedPublishStateV2> list;
        IGPSService d16;
        String str5;
        IGProSimpleProfile iGProSimpleProfile;
        IGProGuildRoleInfo iGProGuildRoleInfo;
        String str6;
        IGProChannelInfo B;
        if (continuation instanceof FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1) {
            feedPublishServiceV2Impl$queryFeedPublishStateV2s$1 = (FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1) continuation;
            int i16 = feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.label = i16 - Integer.MIN_VALUE;
                Object obj = feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            str4 = (String) feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$1;
                            str3 = (String) feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            list = (List) obj;
                            if (list == null) {
                                String str7 = str3;
                                str2 = str4;
                                str = str7;
                                list = CollectionsKt__CollectionsKt.emptyList();
                                String str8 = str2;
                                str3 = str;
                                str4 = str8;
                            }
                            String f16 = ch.f();
                            Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
                            d16 = at.d();
                            str5 = null;
                            if (d16 == null) {
                                iGProSimpleProfile = d16.getSimpleProfile(str3, f16, 100);
                            } else {
                                iGProSimpleProfile = null;
                            }
                            if (iGProSimpleProfile == null) {
                                iGProGuildRoleInfo = d16.getRoleInfo(iGProSimpleProfile.getGuildId(), iGProSimpleProfile.getRoleId());
                            } else {
                                iGProGuildRoleInfo = null;
                            }
                            if (iGProSimpleProfile == null) {
                                str6 = d16.getFullAvatarUrl(new cw(f16, iGProSimpleProfile.getAvatarMeta()), 0);
                            } else {
                                str6 = null;
                            }
                            String str9 = "";
                            if (str6 == null) {
                                str6 = "";
                            }
                            B = ch.B(str4);
                            if (B != null) {
                                str5 = B.getChannelName();
                            }
                            if (str5 != null) {
                                Intrinsics.checkNotNullExpressionValue(str5, "QQGuildUtil.getChannelIn\u2026annel)?.channelName ?: \"\"");
                                str9 = str5;
                            }
                            for (FeedPublishStateV2 feedPublishStateV2 : list) {
                                if (iGProSimpleProfile != null) {
                                    com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.f(feedPublishStateV2.getStFeed(), iGProSimpleProfile, iGProGuildRoleInfo, str6, str9);
                                } else {
                                    GProStFeed stFeed = feedPublishStateV2.getStFeed();
                                    String f17 = ch.f();
                                    Intrinsics.checkNotNullExpressionValue(f17, "accountTinyId()");
                                    com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.g(stFeed, str3, str4, f17);
                                }
                            }
                            return list;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$1;
                    str = (String) feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    AsyncDataMemoryStorage<Pair<String, String>, Deferred<List<FeedPublishStateV2>>> asyncDataMemoryStorage = this.memoryStorage;
                    Pair<String, String> pair = TuplesKt.to(str, str2);
                    feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$0 = str;
                    feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$1 = str2;
                    feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.label = 1;
                    obj = asyncDataMemoryStorage.a(pair, z16, feedPublishServiceV2Impl$queryFeedPublishStateV2s$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                deferred = (Deferred) obj;
                if (deferred != null) {
                    feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$0 = str;
                    feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.L$1 = str2;
                    feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.label = 2;
                    obj = deferred.await(feedPublishServiceV2Impl$queryFeedPublishStateV2s$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str10 = str2;
                    str3 = str;
                    str4 = str10;
                    list = (List) obj;
                    if (list == null) {
                    }
                    String f162 = ch.f();
                    Intrinsics.checkNotNullExpressionValue(f162, "accountTinyId()");
                    d16 = at.d();
                    str5 = null;
                    if (d16 == null) {
                    }
                    if (iGProSimpleProfile == null) {
                    }
                    if (iGProSimpleProfile == null) {
                    }
                    String str92 = "";
                    if (str6 == null) {
                    }
                    B = ch.B(str4);
                    if (B != null) {
                    }
                    if (str5 != null) {
                    }
                    while (r2.hasNext()) {
                    }
                    return list;
                }
                list = CollectionsKt__CollectionsKt.emptyList();
                String str82 = str2;
                str3 = str;
                str4 = str82;
                String f1622 = ch.f();
                Intrinsics.checkNotNullExpressionValue(f1622, "accountTinyId()");
                d16 = at.d();
                str5 = null;
                if (d16 == null) {
                }
                if (iGProSimpleProfile == null) {
                }
                if (iGProSimpleProfile == null) {
                }
                String str922 = "";
                if (str6 == null) {
                }
                B = ch.B(str4);
                if (B != null) {
                }
                if (str5 != null) {
                }
                while (r2.hasNext()) {
                }
                return list;
            }
        }
        feedPublishServiceV2Impl$queryFeedPublishStateV2s$1 = new FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1(this, continuation);
        Object obj2 = feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = feedPublishServiceV2Impl$queryFeedPublishStateV2s$1.label;
        if (i3 == 0) {
        }
        deferred = (Deferred) obj2;
        if (deferred != null) {
        }
        list = CollectionsKt__CollectionsKt.emptyList();
        String str822 = str2;
        str3 = str;
        str4 = str822;
        String f16222 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16222, "accountTinyId()");
        d16 = at.d();
        str5 = null;
        if (d16 == null) {
        }
        if (iGProSimpleProfile == null) {
        }
        if (iGProSimpleProfile == null) {
        }
        String str9222 = "";
        if (str6 == null) {
        }
        B = ch.B(str4);
        if (B != null) {
        }
        if (str5 != null) {
        }
        while (r2.hasNext()) {
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedPublishStateV2 stateV2FromProgressState(boolean isNewFeed, GuildTaskProgressState progressState) {
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (progressState == null) {
                return null;
            }
            String feedJson = new JSONObject(progressState.mJson).optString("jsonFeed");
            JSONObject jSONObject = new JSONObject(feedJson);
            GProStFeedKt gProStFeedKt = GProStFeedKt.f221782a;
            Intrinsics.checkNotNullExpressionValue(feedJson, "feedJson");
            GProStFeed a16 = gProStFeedKt.a(feedJson, com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.k(jSONObject), jSONObject.optString("patternInfo"), jSONObject.optJSONObject("third_bar"));
            if (a16 != null) {
                String mainTaskId = progressState.getMainTaskId();
                Intrinsics.checkNotNullExpressionValue(mainTaskId, "progressState.mainTaskId");
                GProStFeed h16 = com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.h(a16, mainTaskId, progressState.getTriggerPublishTimeNs());
                if (h16 != null) {
                    String str = progressState.mTaskId;
                    Intrinsics.checkNotNullExpressionValue(str, "progressState.mTaskId");
                    return new FeedPublishStateV2(isNewFeed, str, h16, progressState, null, 16, null);
                }
            }
            return null;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (!Result.m482isFailureimpl(m476constructorimpl)) {
                obj = m476constructorimpl;
            }
            return (FeedPublishStateV2) obj;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    public void activePublishingFeed(@NotNull String guildId) {
        Pair pair;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger logger = Logger.f235387a;
        logger.d().i(TAG, 1, "activePublishingFeed: begin " + getConfig());
        if (getConfig().getResendAllGuild() && AppNetConnInfo.isWifiConn()) {
            pair = TuplesKt.to(Boolean.valueOf(!this.activePublishingFeedFlag), "");
            this.activePublishingFeedFlag = true;
        } else {
            pair = TuplesKt.to(Boolean.valueOf(!this.activePublishingFeedSet.contains(guildId)), guildId);
            this.activePublishingFeedSet.add(guildId);
        }
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        String str = (String) pair.component2();
        if (!booleanValue) {
            logger.d().i(TAG, 1, "activePublishingFeed: already active " + guildId + " " + getConfig() + " " + AppNetConnInfo.isWifiConn());
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new FeedPublishServiceV2Impl$activePublishingFeed$5(FlowKt.launchIn(FlowKt.onEach(publishEndFlow(), new FeedPublishServiceV2Impl$activePublishingFeed$job$1(linkedHashSet, null)), this.scope), str, linkedHashSet, this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @NotNull
    public List<a.FeedPublishFinish> finishedFeedPublishState(@NotNull String guild2, @NotNull String channel) {
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return Holder.f223068a.c(guild2, channel);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @Nullable
    public d getPostFeedMainTaskFacade(@NotNull String mainTaskId) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        return this.$$delegate_0.a(mainTaskId);
    }

    public final void innerOnPublishBegin(boolean isNewFeed, @NotNull GuildTaskProgressState progressState) {
        Intrinsics.checkNotNullParameter(progressState, "progressState");
        Logger.f235387a.d().i(TAG, 1, "saveTaskStFeed " + isNewFeed + " " + progressState);
        Function2<? super Boolean, ? super GuildTaskProgressState, Unit> function2 = this._publishBeginEvent;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(isNewFeed), progressState);
        }
    }

    public final void invalidateCache(@NotNull String guildId, @NotNull String channel) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.memoryStorage.d(TuplesKt.to(guildId, channel));
        this.memoryStorage.d(TuplesKt.to(guildId, ""));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        GuildTaskQueueManager.m().C();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new FeedPublishServiceV2Impl$onCreate$$inlined$eventFlow$1(simpleEventBus, null)), new FeedPublishServiceV2Impl$onCreate$1(this, null)), this.scope);
        b.f223075d.f(appRuntime, new FeedPublishServiceV2Impl$onCreate$2(this));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        b.f223075d.b();
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @NotNull
    public Flow<a.FeedPublishBegin> publishBeginFlow() {
        final Flow<kn1.a> flow = this.publishEvents;
        return new Flow<Object>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishBeginFlow$$inlined$filterIsInstance$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\t"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishBeginFlow$$inlined$filterIsInstance$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<Object> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223033d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishBeginFlow$$inlined$filterIsInstance$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishBeginFlow$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f223033d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.f223033d;
                                if (obj instanceof a.FeedPublishBegin) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @NotNull
    public Flow<a.FeedPublishFinish> publishEndFlow() {
        final Flow<kn1.a> flow = this.publishEvents;
        return new Flow<Object>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEndFlow$$inlined$filterIsInstance$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\t"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEndFlow$$inlined$filterIsInstance$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<Object> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223035d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEndFlow$$inlined$filterIsInstance$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEndFlow$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f223035d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.f223035d;
                                if (obj instanceof a.FeedPublishFinish) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @NotNull
    public Flow<a.FeedPublishUpdate> publishUpdateFlow() {
        final Flow<kn1.a> flow = this.publishEvents;
        return new Flow<Object>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishUpdateFlow$$inlined$filterIsInstance$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\t"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishUpdateFlow$$inlined$filterIsInstance$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<Object> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223067d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishUpdateFlow$$inlined$filterIsInstance$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishUpdateFlow$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f223067d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.f223067d;
                                if (obj instanceof a.FeedPublishUpdate) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @NotNull
    public List<FeedPublishStateV2> syncQueryFailPublishStateV2s(@NotNull String guild2, @NotNull String channel, long topicId) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(channel, "channel");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$1(topicId, this, guild2, channel, null), 1, null);
        return (List) runBlocking$default;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2
    @NotNull
    public List<FeedPublishStateV2> syncQueryFailPublishStateV2s(@NotNull String guild2, @NotNull String channel) {
        Object runBlocking$default;
        int collectionSizeOrDefault;
        List<FeedPublishStateV2> take;
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(channel, "channel");
        IGProGuildInfo L = ch.L(guild2);
        long joinTime = L != null ? L.getJoinTime() : Long.MAX_VALUE;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2(this, guild2, channel, null), 1, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) runBlocking$default).iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            FeedPublishStateV2 feedPublishStateV2 = (FeedPublishStateV2) next;
            if (c.b(feedPublishStateV2.getTaskState()) && INSTANCE.b(feedPublishStateV2.getTaskState()) > getConfig().getUploadLimit()) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((FeedPublishStateV2) it5.next()).getTaskState());
        }
        GuildTaskQueueManager.m().g(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : (Iterable) runBlocking$default) {
            long j3 = 1000;
            if (((((FeedPublishStateV2) obj).getTaskState().getTriggerPublishTimeNs() / j3) / j3) / j3 > joinTime) {
                arrayList3.add(obj);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList3, 50);
        return take;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateCache(final String guildId) {
        this.memoryStorage.e(new Function1<Pair<? extends String, ? extends String>, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$invalidateCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@NotNull Pair<String, String> pair) {
                Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                return Boolean.valueOf(Intrinsics.areEqual(pair.component1(), guildId));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        });
    }
}
