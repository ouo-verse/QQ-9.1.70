package com.tencent.guildlive.aio.msglist.list;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.component.combinestyle.StyleGuildItemMsg;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.factory.business.holder.msglist.j;
import com.tencent.guild.aio.factory.business.holder.msglist.k;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.msglist.highlight.BeforeNavigateToMsgEvent;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.l;
import com.tencent.guildlive.aio.input.GuildLiveInputMsgIntent$OnAddGuildWithInfoMsgIntent;
import com.tencent.guildlive.aio.msglist.list.d;
import com.tencent.guildlive.aio.msglist.list.data.GuildLiveGuestMsgRepoDelegate;
import com.tencent.guildlive.aio.msglist.refresh.GuildLiveRefreshUIState;
import com.tencent.guildlive.aio.reserve2.excellent.ExcellentMsgViewVisibleChangeMsgIntent;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$CheckToAddSecurityTipMsg;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$NotifyMsgList;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002D_\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002ijB\u0011\u0012\b\b\u0002\u0010C\u001a\u00020@\u00a2\u0006\u0004\bg\u0010hJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0007J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020$H\u0002J\u0014\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\"\u00106\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u0002012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0002J$\u0010:\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010.2\b\u00109\u001a\u0004\u0018\u00010.H\u0002J\u0012\u0010<\u001a\u00020\u00072\b\b\u0002\u0010;\u001a\u000201H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\b\u0010?\u001a\u00020>H\u0002R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010HR\u0018\u0010N\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010HR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010PR\u001c\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR$\u0010[\u001a\u0012\u0012\u0004\u0012\u00020S0Wj\b\u0012\u0004\u0012\u00020S`X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR(\u0010f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020_0c0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010e\u00a8\u0006k"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "intent", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "w", "implState", "D", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", BdhLogUtil.LogTag.Tag_Req, "", "", "k0", "Lcom/tencent/mvi/base/route/MsgIntent;", "b0", "P", "g0", "h0", "d0", "i", "Lcom/tencent/mvi/base/route/k;", "I", "Z", "Y", "", "videoScreenState", "X", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$g;", "e0", "c0", "position", "a0", "Lcom/tencent/aio/data/msglist/a;", "msg", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "O", "U", "", "forceUpdate", "", "", "payloads", "i0", "source", "aioTopMsg", "aioBottomMsg", "T", FileReaderHelper.OPEN_FILE_FROM_FORCE, "m0", "l0", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$b;", "repoProvider", "com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$e", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$e;", "mAction", "E", "Lcom/tencent/aio/data/msglist/a;", "firstAIOMsg", "lastAIOMsg", "G", "topAIOMsg", "H", "bottomAIOMsg", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "eventReceiver", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "J", "Ljava/util/concurrent/CopyOnWriteArrayList;", "visibleIds", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "K", "Ljava/util/HashSet;", "pendingHighLightMsgSeqSet", "L", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", "com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$f", "M", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$f;", "mActionR", "Lkotlin/Pair;", "N", "Ljava/util/List;", "messageRList", "<init>", "(Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$b;)V", "a", "b", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveMsgListDataVM extends MsgListVMWrapper<at.b, MsgListUiState> implements LifecycleObserver {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b repoProvider;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e mAction;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a firstAIOMsg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a lastAIOMsg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a topAIOMsg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a bottomAIOMsg;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final FlowEventReceiver eventReceiver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<Long> visibleIds;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Long> pendingHighLightMsgSeqSet;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsObserver;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final f mActionR;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, f>> messageRList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$a;", "", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$b;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVM$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$a$a", "Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$b;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "a", "Lcom/tencent/guildlive/aio/msglist/list/data/e;", "c", "Lcom/tencent/guildlive/aio/msglist/list/data/e;", "repoDelegate", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVM$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1228a implements b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private com.tencent.guildlive.aio.msglist.list.data.e repoDelegate;

            C1228a() {
            }

            @Override // com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVM.b
            @NotNull
            public MsgListRepo a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope coroutineScope) {
                com.tencent.guildlive.aio.msglist.list.data.e eVar;
                Intrinsics.checkNotNullParameter(aioContext, "aioContext");
                Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
                GuildMsgListRepo guildMsgListRepo = new GuildMsgListRepo(aioContext, coroutineScope);
                IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
                AIOParam g16 = aioContext.g();
                Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
                String b16 = com.tencent.guild.aio.util.a.b(g16);
                AIOParam g17 = aioContext.g();
                Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
                boolean isSelfGuest = iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17));
                if (isSelfGuest) {
                    eVar = new GuildLiveGuestMsgRepoDelegate(guildMsgListRepo);
                } else {
                    eVar = new com.tencent.guildlive.aio.msglist.list.data.e(guildMsgListRepo);
                }
                this.repoDelegate = eVar;
                GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgListDataVM", "[provide] isGuest = " + isSelfGuest + ", repoDelegate = " + eVar);
                com.tencent.guildlive.aio.msglist.list.data.e eVar2 = this.repoDelegate;
                Intrinsics.checkNotNull(eVar2);
                guildMsgListRepo.Y(eVar2);
                return guildMsgListRepo;
            }

            @Override // com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVM.b
            @Nullable
            /* renamed from: c, reason: from getter */
            public com.tencent.guildlive.aio.msglist.list.data.e getRepoDelegate() {
                return this.repoDelegate;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b b() {
            return new C1228a();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$b;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "a", "Lcom/tencent/guildlive/aio/msglist/list/data/e;", "c", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface b {
        @NotNull
        MsgListRepo a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope coroutineScope);

        @Nullable
        /* renamed from: c */
        com.tencent.guildlive.aio.msglist.list.data.e getRepoDelegate();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onMemberTopRoleChanged", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            if (QLog.isDevelopLevel()) {
                GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgListDataVM", "[onMemberTopRoleChanged]  guildId: " + guildId + ", tinyId: " + tinyId);
            }
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildLiveMsgListDataVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId) && tinyId != null) {
                up0.a.f439407a.h("TAG_MEMBER_ROLE_CACHE", h.f112401a.y(tinyId, ((com.tencent.aio.api.runtime.a) GuildLiveMsgListDataVM.this.getMContext()).g().r().c().j()));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$d", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Object first;
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            if (!displayList.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
                if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() > yr0.a.a((com.tencent.aio.api.runtime.a) GuildLiveMsgListDataVM.this.getMContext())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Object last;
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            if ((!displayList.isEmpty()) && lastMsg != null) {
                long msgSeq = lastMsg.getMsgSeq();
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
                if (msgSeq > ((com.tencent.aio.data.msglist.a) last).getMsgSeq()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$e", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements com.tencent.mvi.base.route.a {
        e() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildLiveMsgListDataVM.this.b0(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/aio/msglist/list/GuildLiveMsgListDataVM$f", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f implements com.tencent.mvi.base.route.b {
        f() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildLiveMsgListDataVM.this.I(i3);
        }
    }

    public GuildLiveMsgListDataVM() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GetAIOTopMsgEvent) {
            return new i.d(this.topAIOMsg);
        }
        if (i3 instanceof GuildMsgListIntent.GetAIOBottomMsgEvent) {
            com.tencent.aio.data.msglist.a aVar = this.bottomAIOMsg;
            if (aVar == null) {
                aVar = m().H();
            }
            return new i.a(aVar);
        }
        if (i3 instanceof GuildMsgListIntent.GetLastMsgPosEvent) {
            return Z();
        }
        if (i3 instanceof GuildMsgListIntent.GetAIOExtremalMsgEvent) {
            return Y();
        }
        return pn0.b.f426490a;
    }

    private final GuildMsgItem O(com.tencent.aio.data.msglist.a msg2) {
        if (msg2 instanceof GuildMsgItem) {
            return (GuildMsgItem) msg2;
        }
        return null;
    }

    private final void P() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guildlive.aio.msglist.list.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveMsgListDataVM.Q(GuildLiveMsgListDataVM.this);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(GuildLiveMsgListDataVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.guildlive.aio.msglist.list.data.e repoDelegate = this$0.repoProvider.getRepoDelegate();
        if (repoDelegate != null) {
            repoDelegate.H();
            repoDelegate.k(repoDelegate.g());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MsgListRepo R() {
        return this.repoProvider.a((com.tencent.aio.api.runtime.a) getMContext(), vmScope());
    }

    private final GPServiceObserver S() {
        return new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T(String source, GuildMsgItem aioTopMsg, GuildMsgItem aioBottomMsg) {
        this.topAIOMsg = aioTopMsg;
        this.bottomAIOMsg = aioBottomMsg;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListScrollEvent(source, aioTopMsg, aioBottomMsg, (GuildMsgItem) m().H()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U() {
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getFirstUnreadCommonMsg(l.f112634a.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), new IGuildFetchChannelLatestSeqCallback() { // from class: com.tencent.guildlive.aio.msglist.list.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback
                public final void onFetchChannelLatestSeq(int i3, String str, long j3) {
                    GuildLiveMsgListDataVM.W(i3, str, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(int i3, String str, long j3) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgListDataVM", "fetchNewMsgLineSeq: res:" + i3 + " err:" + str + " v:" + j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X(int videoScreenState) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent("GuildAioDefaultReserve2Model"));
        updateUI(new GuildLiveRefreshUIState.VideoScreenChange(videoScreenState));
    }

    private final k Y() {
        Long l3;
        Long l16;
        Long l17;
        com.tencent.mvi.api.ability.e fetchVBState = fetchVBState(k.a.f110626a);
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) fetchVBState.b().getSerializable("aio_top_msg");
        com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) fetchVBState.b().getSerializable("aio_bottom_msg");
        com.tencent.aio.data.msglist.a H = m().H();
        Long l18 = null;
        if (aVar2 != null) {
            l3 = Long.valueOf(aVar2.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aVar2 != null) {
            l16 = Long.valueOf(aVar2.getMsgId());
        } else {
            l16 = null;
        }
        if (H != null) {
            l17 = Long.valueOf(H.getMsgSeq());
        } else {
            l17 = null;
        }
        if (H != null) {
            l18 = Long.valueOf(H.getMsgId());
        }
        QLog.i("GuildLiveMsgListDataVM", 1, "handleGetAIOLatestAndBottomMsgResult, bottomMsg seq = " + l3 + ", id = " + l16 + ", latestMsg seq = " + l17 + ", id = " + l18);
        return new i.b(aVar, aVar2, H);
    }

    private final com.tencent.mvi.base.route.k Z() {
        com.tencent.mvi.api.ability.e fetchVBState = fetchVBState(new k.b(l().size() - 1));
        return new i.f(new Rect(fetchVBState.b().getInt("left", 0), fetchVBState.b().getInt("top", 0), fetchVBState.b().getInt("right", 0), fetchVBState.b().getInt("bottom", 0)));
    }

    private final void a0(int position) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3.size() > position) {
            com.tencent.aio.data.msglist.a aVar = l3.get(position);
            long msgSeq = aVar.getMsgSeq();
            if (!this.pendingHighLightMsgSeqSet.contains(Long.valueOf(msgSeq))) {
                return;
            }
            QLog.i("GuildLiveMsgListDataVM", 1, "handleHighLightViewHolder|msgSeq=" + msgSeq + ", position:" + position);
            if (aVar instanceof GuildMsgItem) {
                updateUI(new HighLightViewHolderUIState(position, ((GuildMsgItem) aVar).getMsgRecord(), 1, new Bundle(), null, 16, null));
                this.pendingHighLightMsgSeqSet.remove(Long.valueOf(msgSeq));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(MsgIntent intent) {
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            j0(this, true, null, 2, null);
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildMsgListRefreshEvent) {
            i0(true, ((GuildMsgListIntent.GuildMsgListRefreshEvent) intent).a());
            return;
        }
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            updateUI(new GuildLiveRefreshUIState.PanelVisibleChange(((PanelStatusIntent.PanelStatusChangeIntent) intent).c()));
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$LiveVideoScreenChange) {
            X(((GuildLiveOuterMsgIntent$LiveVideoScreenChange) intent).getVideoScreenState());
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$CheckToAddSecurityTipMsg) {
            P();
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$NotifyMsgList) {
            g0();
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay) {
            com.tencent.guildlive.aio.msglist.list.data.e repoDelegate = this.repoProvider.getRepoDelegate();
            if (repoDelegate != null) {
                repoDelegate.u();
                return;
            }
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            updateUI(new GuildMsgListViewState.GuildInputBarHeightChangeDataState(((GuildMsgListIntent.GuildInputBarHeightChangEvent) intent).getHeight()));
            return;
        }
        if (intent instanceof DeleteGrayTipsMsgIntent) {
            com.tencent.guildlive.aio.msglist.list.data.e repoDelegate2 = this.repoProvider.getRepoDelegate();
            if (repoDelegate2 != null) {
                repoDelegate2.F(((DeleteGrayTipsMsgIntent) intent).getMsgItem());
                return;
            }
            return;
        }
        if (intent instanceof GuildMsgNavigateEvent.GuildNavigateToMsgEvent) {
            m().A(((GuildMsgNavigateEvent.GuildNavigateToMsgEvent) intent).getMsgSeq());
            return;
        }
        if (intent instanceof GuildMsgListIntent.NavigateToDeletedMsgEvent) {
            d0();
            return;
        }
        if (intent instanceof ExcellentMsgViewVisibleChangeMsgIntent) {
            updateUI(new GuildLiveRefreshUIState.ExcellentMsgViewVisibleChangeUIState(((ExcellentMsgViewVisibleChangeMsgIntent) intent).getHeightSpace()));
            return;
        }
        if (intent instanceof BeforeNavigateToMsgEvent) {
            this.pendingHighLightMsgSeqSet.add(Long.valueOf(((BeforeNavigateToMsgEvent) intent).getMsgSeq()));
            return;
        }
        if (intent instanceof GuildLiveInputMsgIntent$OnAddGuildWithInfoMsgIntent) {
            h0();
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$JumpToSeqMsg) {
            com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.d(((GuildLiveOuterMsgIntent$JumpToSeqMsg) intent).getMsgSeq(), true));
            return;
        }
        if (intent instanceof StyleGuildItemMsg) {
            StyleGuildItemMsg styleGuildItemMsg = (StyleGuildItemMsg) intent;
            boolean z16 = false;
            if (!styleGuildItemMsg.getGuildMediaAioCombineStyleChain().getEnableScrollUp()) {
                z16 = fetchVBState(d.a.f112913a).b().getBoolean("is_bottom_range", false);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildLiveMsgListDataVM", "[handleIntentAction] isBottomRange:" + z16 + ",  " + styleGuildItemMsg.getGuildMediaAioCombineStyleChain().getEnableScrollUp());
            }
            com.tencent.guildlive.aio.msglist.list.data.e repoDelegate3 = this.repoProvider.getRepoDelegate();
            if (repoDelegate3 != null) {
                repoDelegate3.x(styleGuildItemMsg, z16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildLiveMsgListDataVM", false, 2, null));
    }

    private final void d0() {
        g.c(0, R.string.f152991aw);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e0(a.g intent) {
        if (intent.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.getFirstPosition(), intent.getLastPosition(), new CopyOnWriteArrayList(l())));
        }
    }

    private final void g0() {
        updateUI(GuildLiveRefreshUIState.NotifyMsgList.f112933d);
    }

    private final void h0() {
        com.tencent.guildlive.aio.msglist.list.data.e repoDelegate = this.repoProvider.getRepoDelegate();
        if (repoDelegate instanceof GuildLiveGuestMsgRepoDelegate) {
            ((GuildLiveGuestMsgRepoDelegate) repoDelegate).V();
        }
    }

    private final void i0(boolean forceUpdate, List<Object> payloads) {
        m0(forceUpdate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void j0(GuildLiveMsgListDataVM guildLiveMsgListDataVM, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        guildLiveMsgListDataVM.i0(z16, list);
    }

    private final List<String> k0() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListRefreshEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveVideoScreenChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$NotifyMsgList.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$CheckToAddSecurityTipMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(DeleteGrayTipsMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToMsgEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.UpdateReeditRecallMsgListEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.NavigateToDeletedMsgEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ExcellentMsgViewVisibleChangeMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(BeforeNavigateToMsgEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveInputMsgIntent$OnAddGuildWithInfoMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$JumpToSeqMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(StyleGuildItemMsg.class).getQualifiedName()});
        return listOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r1 > ((com.tencent.aio.data.msglist.a) r3).getMsgSeq()) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l0() {
        Object first;
        Object last;
        Object last2;
        Object first2;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3.isEmpty()) {
            return;
        }
        com.tencent.aio.data.msglist.a aVar = this.firstAIOMsg;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            long msgSeq = aVar.getMsgSeq();
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) l3);
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) l3);
        this.firstAIOMsg = (com.tencent.aio.data.msglist.a) first;
        com.tencent.aio.data.msglist.a aVar2 = this.lastAIOMsg;
        if (aVar2 != null) {
            Intrinsics.checkNotNull(aVar2);
            long msgSeq2 = aVar2.getMsgSeq();
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) l3);
            if (msgSeq2 >= ((com.tencent.aio.data.msglist.a) last2).getMsgSeq()) {
                return;
            }
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) l3);
        this.lastAIOMsg = (com.tencent.aio.data.msglist.a) last;
    }

    private final void m0(boolean force) {
        l0();
        updateUI(new GuildMsgListDataState(l(), force, m().H(), 0, null, 24, null));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @Nullable
    public MsgListUiState D(@NotNull MsgListUiState implState) {
        Intrinsics.checkNotNullParameter(implState, "implState");
        if (implState instanceof MsgListState) {
            MsgListState msgListState = (MsgListState) implState;
            return new GuildMsgListDataState((Collection) implState, false, m().H(), msgListState.getUpdateType(), msgListState.getExtra());
        }
        return null;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d F() {
        return new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgListIntent.a) {
            p((MsgListIntent.a) intent);
            return;
        }
        if (intent instanceof MsgListIntent.b) {
            s((MsgListIntent.b) intent);
            return;
        }
        if (intent instanceof a.d) {
            w();
            return;
        }
        if (intent instanceof a.c) {
            m().x();
            return;
        }
        if (intent instanceof a.C0640a) {
            m().w();
            return;
        }
        if (intent instanceof a.t) {
            U();
            return;
        }
        if (intent instanceof bq0.c) {
            a0(((bq0.c) intent).getPosition());
            return;
        }
        if (intent instanceof a.C1186a) {
            c0();
        } else if (intent instanceof a.l) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildLiveMsgListDataVM"));
        } else if (intent instanceof a.g) {
            e0((a.g) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        Iterator<String> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(it.next(), this.mAction);
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) ((Pair) it5.next()).getFirst());
        }
        this.eventReceiver.d();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.gpsObserver);
        }
        this.pendingHighLightMsgSeqSet.clear();
        up0.a.f439407a.c();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgListDataVM", "[onResume] ");
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.p(intent);
        T("GuildLiveMsgListDataVM", O(intent.b()), O(intent.d()));
        if (intent.e() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.a(), intent.c(), new CopyOnWriteArrayList(l())));
        }
    }

    public /* synthetic */ GuildLiveMsgListDataVM(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? INSTANCE.b() : bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        z(R());
        super.onCreate(context);
        this.eventReceiver.c(nq0.d.class, true, new GuildLiveMsgListDataVM$onCreate$1(this, null));
        Iterator<String> it = k0().iterator();
        while (it.hasNext()) {
            context.e().d(it.next(), this.mAction);
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            Pair pair = (Pair) it5.next();
            context.e().j((String) pair.getFirst(), (com.tencent.mvi.base.route.b) pair.getSecond());
        }
        m().v("from_first_screen");
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpsObserver);
        }
        j.f110625a.a(context);
    }

    public GuildLiveMsgListDataVM(@NotNull b repoProvider) {
        List<Pair<String, f>> listOf;
        Intrinsics.checkNotNullParameter(repoProvider, "repoProvider");
        this.repoProvider = repoProvider;
        this.mAction = new e();
        this.eventReceiver = new FlowEventReceiver(null, 1, null);
        this.visibleIds = new CopyOnWriteArrayList<>();
        this.pendingHighLightMsgSeqSet = new HashSet<>();
        this.gpsObserver = S();
        f fVar = new f();
        this.mActionR = fVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIOTopMsgEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIOBottomMsgEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLastMsgPosEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIOExtremalMsgEvent.class).getQualifiedName(), fVar)});
        this.messageRList = listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
    }
}
