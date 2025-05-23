package com.tencent.guildmedia.aio.msglist.list;

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
import com.tencent.guild.aio.factory.business.holder.msglist.j;
import com.tencent.guild.aio.halfpop.menu.DeleteGrayTipsMsgIntent;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.l;
import com.tencent.guildmedia.aio.msglist.list.b;
import com.tencent.guildmedia.aio.msglist.list.data.GuildMediaMsgRepoDelegate;
import com.tencent.guildmedia.aio.msglist.refresh.GuildMediaRefreshUIState;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$NotifyMsgList;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u00016\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001SB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\"\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J$\u0010#\u001a\u00020\f2\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010%\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\fH\u0007J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010/\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020\f2\u0006\u0010\u000b\u001a\u000201H\u0016J\b\u00103\u001a\u00020\fH\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u00020\u0003H\u0016R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010:R\u0018\u0010@\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010:R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006T"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVM;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "M", "", "", "Z", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", ExifInterface.LATITUDE_SOUTH, "U", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$g;", "W", "T", "", "position", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aio/data/msglist/a;", "msg", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "L", "P", "", "forceUpdate", "", "", "payloads", "X", "source", "aioTopMsg", "aioBottomMsg", "O", FileReaderHelper.OPEN_FILE_FROM_FORCE, "b0", "a0", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "N", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "w", "implState", "D", "com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVM$d", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVM$d;", "mAction", "Lcom/tencent/aio/data/msglist/a;", "firstAIOMsg", "E", "lastAIOMsg", "topAIOMsg", "G", "bottomAIOMsg", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "H", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "eventReceiver", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "I", "Ljava/util/concurrent/CopyOnWriteArrayList;", "visibleIds", "Lcom/tencent/guildmedia/aio/msglist/list/data/GuildMediaMsgRepoDelegate;", "J", "Lcom/tencent/guildmedia/aio/msglist/list/data/GuildMediaMsgRepoDelegate;", "repoDelegate", "K", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", "<init>", "()V", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaMsgListDataVM extends MsgListVMWrapper<at.b, MsgListUiState> implements LifecycleObserver {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a firstAIOMsg;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a lastAIOMsg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a topAIOMsg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a bottomAIOMsg;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GuildMediaMsgRepoDelegate repoDelegate;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d mAction = new d();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final FlowEventReceiver eventReceiver = new FlowEventReceiver(null, 1, null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<Long> visibleIds = new CopyOnWriteArrayList<>();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsObserver = N();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVM$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onMemberTopRoleChanged", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            if (QLog.isDevelopLevel()) {
                GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgListDataVM", "[onMemberTopRoleChanged]  guildId: " + guildId + ", tinyId: " + tinyId);
            }
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildMediaMsgListDataVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId) && tinyId != null) {
                up0.a.f439407a.h("TAG_MEMBER_ROLE_CACHE", h.f112401a.y(tinyId, ((com.tencent.aio.api.runtime.a) GuildMediaMsgListDataVM.this.getMContext()).g().r().c().j()));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVM$c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Object first;
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            if (!displayList.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
                if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() > vs0.a.a((com.tencent.aio.api.runtime.a) GuildMediaMsgListDataVM.this.getMContext())) {
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVM$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildMediaMsgListDataVM.this.S(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final GuildMsgItem L(com.tencent.aio.data.msglist.a msg2) {
        if (msg2 instanceof GuildMsgItem) {
            return (GuildMsgItem) msg2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MsgListRepo M() {
        GuildMsgListRepo guildMsgListRepo = new GuildMsgListRepo((com.tencent.aio.api.runtime.a) getMContext(), vmScope());
        GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate = new GuildMediaMsgRepoDelegate(guildMsgListRepo, new Function1<Long, Unit>() { // from class: com.tencent.guildmedia.aio.msglist.list.GuildMediaMsgListDataVM$createDataRepo$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(long j3) {
                ((com.tencent.aio.api.runtime.a) GuildMediaMsgListDataVM.this.getMContext()).g().l().putLong("extra_key_show_max_msg_seq", j3);
                GuildMediaMsgListDataVM.this.updateUI(new GuildMsgListViewState.GuildInitFirstMsgSeq(j3));
            }
        });
        this.repoDelegate = guildMediaMsgRepoDelegate;
        Intrinsics.checkNotNull(guildMediaMsgRepoDelegate);
        guildMsgListRepo.Y(guildMediaMsgRepoDelegate);
        return guildMsgListRepo;
    }

    private final GPServiceObserver N() {
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(String source, GuildMsgItem aioTopMsg, GuildMsgItem aioBottomMsg) {
        this.topAIOMsg = aioTopMsg;
        this.bottomAIOMsg = aioBottomMsg;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListScrollEvent(source, aioTopMsg, aioBottomMsg, (GuildMsgItem) m().H()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P() {
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getFirstUnreadCommonMsg(l.f112634a.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), new IGuildFetchChannelLatestSeqCallback() { // from class: com.tencent.guildmedia.aio.msglist.list.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback
                public final void onFetchChannelLatestSeq(int i3, String str, long j3) {
                    GuildMediaMsgListDataVM.Q(i3, str, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(int i3, String str, long j3) {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgListDataVM", "fetchNewMsgLineSeq: res:" + i3 + " err:" + str + " v:" + j3);
    }

    private final void R(int position) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3.size() > position) {
            com.tencent.aio.data.msglist.a aVar = l3.get(position);
            if (aVar instanceof GuildMsgItem) {
                updateUI(new HighLightViewHolderUIState(position, ((GuildMsgItem) aVar).getMsgRecord(), 1, new Bundle(), null, 16, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(MsgIntent intent) {
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            Y(this, true, null, 2, null);
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildMsgListRefreshEvent) {
            X(true, ((GuildMsgListIntent.GuildMsgListRefreshEvent) intent).a());
            return;
        }
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            updateUI(new GuildMediaRefreshUIState.PanelVisibleChange(((PanelStatusIntent.PanelStatusChangeIntent) intent).c()));
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay) {
            GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate = this.repoDelegate;
            if (guildMediaMsgRepoDelegate != null) {
                guildMediaMsgRepoDelegate.A();
                return;
            }
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$NotifyMsgList) {
            updateUI(GuildMediaRefreshUIState.NotifyMsgList.f113155d);
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            updateUI(new GuildMsgListViewState.GuildInputBarHeightChangeDataState(((GuildMsgListIntent.GuildInputBarHeightChangEvent) intent).getHeight()));
            return;
        }
        if (intent instanceof DeleteGrayTipsMsgIntent) {
            GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate2 = this.repoDelegate;
            if (guildMediaMsgRepoDelegate2 != null) {
                guildMediaMsgRepoDelegate2.P(((DeleteGrayTipsMsgIntent) intent).getMsgItem());
                return;
            }
            return;
        }
        if (intent instanceof GuildMsgNavigateEvent.GuildNavigateToMsgEvent) {
            m().A(((GuildMsgNavigateEvent.GuildNavigateToMsgEvent) intent).getMsgSeq());
            return;
        }
        if (intent instanceof GuildMsgListIntent.NavigateToDeletedMsgEvent) {
            U();
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$JumpToSeqMsg) {
            com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.d(((GuildMediaOuterMsgIntent$JumpToSeqMsg) intent).getMsgSeq(), true));
            return;
        }
        if (intent instanceof StyleGuildItemMsg) {
            StyleGuildItemMsg styleGuildItemMsg = (StyleGuildItemMsg) intent;
            boolean z16 = false;
            if (!styleGuildItemMsg.getGuildMediaAioCombineStyleChain().getEnableScrollUp()) {
                z16 = fetchVBState(b.a.f113144a).b().getBoolean("is_bottom_range", false);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMediaMsgListDataVM", "[handleIntentAction] isBottomRange:" + z16 + ",  " + styleGuildItemMsg.getGuildMediaAioCombineStyleChain().getEnableScrollUp());
            }
            GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate3 = this.repoDelegate;
            if (guildMediaMsgRepoDelegate3 != null) {
                guildMediaMsgRepoDelegate3.C(styleGuildItemMsg, z16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildMediaMsgListDataVM", false, 2, null));
    }

    private final void U() {
        g.c(0, R.string.f152991aw);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W(a.g intent) {
        if (intent.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.getFirstPosition(), intent.getLastPosition(), new CopyOnWriteArrayList(l())));
        }
    }

    private final void X(boolean forceUpdate, List<Object> payloads) {
        b0(forceUpdate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Y(GuildMediaMsgListDataVM guildMediaMsgListDataVM, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        guildMediaMsgListDataVM.X(z16, list);
    }

    private final List<String> Z() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListRefreshEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$AddEnterAnnounceGrayTipsToDisplay.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$NotifyMsgList.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(DeleteGrayTipsMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToMsgEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.UpdateReeditRecallMsgListEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.NavigateToDeletedMsgEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$JumpToSeqMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(StyleGuildItemMsg.class).getQualifiedName()});
        return listOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r1 > ((com.tencent.aio.data.msglist.a) r3).getMsgSeq()) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a0() {
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

    private final void b0(boolean force) {
        a0();
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
        return new c();
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
            P();
            return;
        }
        if (intent instanceof bq0.c) {
            R(((bq0.c) intent).getPosition());
            return;
        }
        if (intent instanceof a.C1186a) {
            T();
            return;
        }
        if (intent instanceof a.l) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildMediaMsgListDataVM"));
        } else if (intent instanceof a.g) {
            W((a.g) intent);
        } else if (intent instanceof MsgListIntent.b) {
            s((MsgListIntent.b) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        Iterator<String> it = Z().iterator();
        while (it.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(it.next(), this.mAction);
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
        up0.a.f439407a.c();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgListDataVM", "[onResume] ");
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.p(intent);
        O("GuildMediaMsgListDataVM", L(intent.b()), L(intent.d()));
        if (intent.e() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.a(), intent.c(), new CopyOnWriteArrayList(l())));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        z(M());
        super.onCreate(context);
        this.eventReceiver.c(nq0.d.class, true, new GuildMediaMsgListDataVM$onCreate$1(this, null));
        Iterator<String> it = Z().iterator();
        while (it.hasNext()) {
            context.e().d(it.next(), this.mAction);
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

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
    }
}
