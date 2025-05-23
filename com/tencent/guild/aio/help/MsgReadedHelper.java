package com.tencent.guild.aio.help;

import android.os.Looper;
import android.os.Message;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.help.MsgReadedHelper;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\b\t*\u0002/2\u0018\u0000 72\u00020\u0001:\u000289B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001cH\u0016R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/guild/aio/help/MsgReadedHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "j", "i", tl.h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "k", "Lrr1/i;", "notifyData", "p", "v", "Lcom/tencent/guild/aio/help/MsgReadedHelper$ReadedScorce;", "from", "u", HippyTKDListViewAdapter.X, "w", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "", DomainData.DOMAIN_NAME, "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "aioBottomMsg", "f", "latestAioMsg", "Z", "reportWhenMsgLoaded", "com/tencent/guild/aio/help/MsgReadedHelper$b", "Lcom/tencent/guild/aio/help/MsgReadedHelper$b;", "action", "com/tencent/guild/aio/help/MsgReadedHelper$c", "Lcom/tencent/guild/aio/help/MsgReadedHelper$c;", "uiHandler", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "ReadedScorce", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class MsgReadedHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem aioBottomMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem latestAioMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean reportWhenMsgLoaded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action = new b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c uiHandler = new c(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/help/MsgReadedHelper$ReadedScorce;", "", "(Ljava/lang/String;I)V", "READED_FROM_NONE", "READED_FROM_SCROLLEVNET", "READED_FROM_RESUME", "READED_FROM_GESTURE_OPEN", "READED_FROM_PAUSE", "READED_FROM_ONTIMER", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum ReadedScorce {
        READED_FROM_NONE,
        READED_FROM_SCROLLEVNET,
        READED_FROM_RESUME,
        READED_FROM_GESTURE_OPEN,
        READED_FROM_PAUSE,
        READED_FROM_ONTIMER
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/MsgReadedHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            MsgReadedHelper.this.m(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/MsgReadedHelper$c", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends MqqHandler {
        c(Looper looper) {
            super(looper);
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 16711698) {
                MsgReadedHelper.this.y();
            }
        }
    }

    private final void g() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.action);
        this.reportWhenMsgLoaded = false;
    }

    private final void h() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.action);
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar2 = null;
        }
        bVar2.a().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.action);
        this.uiHandler.removeMessages(16711698);
        this.aioBottomMsg = null;
        this.latestAioMsg = null;
    }

    private final void i() {
        x();
    }

    private final void j() {
        v();
    }

    private final String k(GuildMsgItem msgItem) {
        Long l3;
        Long l16 = null;
        if (msgItem != null) {
            l3 = Long.valueOf(msgItem.getMsgId());
        } else {
            l3 = null;
        }
        if (msgItem != null) {
            l16 = Long.valueOf(msgItem.getMsgSeq());
        }
        return "msgId:" + l3 + " msgSeq:" + l16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(MsgIntent i3) {
        long j3;
        long j16;
        long j17;
        if (i3 instanceof MFGestureListIntent.NotifyEvent) {
            p(((MFGestureListIntent.NotifyEvent) i3).getNotifyData());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            GuildMsgItem guildMsgItem = this.aioBottomMsg;
            long j18 = 0;
            if (guildMsgItem != null) {
                j3 = guildMsgItem.getMsgId();
            } else {
                j3 = 0;
            }
            GuildMsgItem guildMsgItem2 = this.latestAioMsg;
            if (guildMsgItem2 != null) {
                j16 = guildMsgItem2.getMsgId();
            } else {
                j16 = 0;
            }
            GuildMsgListIntent.GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListIntent.GuildMsgListScrollEvent) i3;
            if (guildMsgListScrollEvent.getAioBottomMsg() != null) {
                this.aioBottomMsg = guildMsgListScrollEvent.getAioBottomMsg();
            }
            if (guildMsgListScrollEvent.getLatestAioMsg() != null) {
                this.latestAioMsg = guildMsgListScrollEvent.getLatestAioMsg();
            }
            GuildMsgItem guildMsgItem3 = this.aioBottomMsg;
            if (guildMsgItem3 != null) {
                j17 = guildMsgItem3.getMsgId();
            } else {
                j17 = 0;
            }
            if (j3 == j17) {
                GuildMsgItem guildMsgItem4 = this.latestAioMsg;
                if (guildMsgItem4 != null) {
                    j18 = guildMsgItem4.getMsgId();
                }
                if (j16 == j18) {
                    return;
                }
            }
            o();
            if (this.reportWhenMsgLoaded) {
                this.reportWhenMsgLoaded = false;
                s(ReadedScorce.READED_FROM_SCROLLEVNET);
                return;
            }
            if (n()) {
                com.tencent.aio.main.businesshelper.b bVar = this.param;
                com.tencent.aio.main.businesshelper.b bVar2 = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                if (com.tencent.guild.aio.util.ex.a.g(bVar.a())) {
                    com.tencent.aio.main.businesshelper.b bVar3 = this.param;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                    } else {
                        bVar2 = bVar3;
                    }
                    if (bVar2.a().c().isResumed()) {
                        q();
                    }
                }
            }
        }
    }

    private final boolean n() {
        long j3;
        long j16;
        GuildMsgItem guildMsgItem = this.aioBottomMsg;
        if (guildMsgItem != null) {
            j3 = guildMsgItem.getMsgSeq();
        } else {
            j3 = -1;
        }
        GuildMsgItem guildMsgItem2 = this.latestAioMsg;
        if (guildMsgItem2 != null) {
            j16 = guildMsgItem2.getMsgSeq();
        } else {
            j16 = -1;
        }
        if (j3 == -1 || j16 == -1 || j3 != j16) {
            return false;
        }
        return true;
    }

    private final void o() {
        if (QLog.isDevelopLevel()) {
            com.tencent.aio.main.businesshelper.b bVar = this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            QLog.d("MsgReadedHelper", 4, "GuildMsgListScrollEvent channelId: " + com.tencent.guild.aio.util.a.b(g16) + " aioBottomMsg: " + k(this.aioBottomMsg) + " latestAioMsg: " + k(this.latestAioMsg));
        }
    }

    private final void p(rr1.i notifyData) {
        if (notifyData.f() == 3) {
            if (notifyData.c() == 1) {
                u(ReadedScorce.READED_FROM_GESTURE_OPEN);
                return;
            }
            if (notifyData.c() != 1 && notifyData.a() == 1) {
                if (notifyData.g() == 1 || notifyData.g() == 3) {
                    w();
                }
            }
        }
    }

    private final void q() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        final String b16 = com.tencent.guild.aio.util.a.b(g16);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        AIOParam g17 = bVar2.a().g();
        Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
        String g18 = com.tencent.guild.aio.util.a.g(g17);
        QLog.i("MsgReadedHelper", 1, "setLocalReaded channelId=" + b16);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setGProLocalMsgRead(new GProContact(4, b16, g18), new IGuildOperateCallback() { // from class: com.tencent.guild.aio.help.u
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    MsgReadedHelper.r(b16, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String channelId, int i3, String str) {
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        QLog.i("MsgReadedHelper", 1, "setLocalReaded channelId=" + channelId + " result=" + i3 + " msg=" + str);
    }

    private final void s(final ReadedScorce from) {
        List<String> mutableListOf;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        final String b16 = com.tencent.guild.aio.util.a.b(g16);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        AIOParam g17 = bVar2.a().g();
        Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
        String g18 = com.tencent.guild.aio.util.a.g(g17);
        GuildMsgItem guildMsgItem = this.aioBottomMsg;
        if (guildMsgItem != null && this.latestAioMsg != null) {
            if (n()) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                IGuildUnreadService iGuildUnreadService = (IGuildUnreadService) peekAppRuntime.getRuntimeService(IGuildUnreadService.class, "");
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(b16);
                iGuildUnreadService.setChannelRead(g18, mutableListOf, false);
                return;
            }
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Contact contact = new Contact(4, b16, g18);
            GuildMsgItem guildMsgItem2 = this.aioBottomMsg;
            Intrinsics.checkNotNull(guildMsgItem2);
            iMsgService.setMsgReadAndReport(contact, guildMsgItem2.getMsgRecord(), new IOperateCallback() { // from class: com.tencent.guild.aio.help.t
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MsgReadedHelper.t(MsgReadedHelper.ReadedScorce.this, b16, this, i3, str);
                }
            });
            return;
        }
        this.reportWhenMsgLoaded = true;
        QLog.i("MsgReadedHelper", 1, "setReadedAndReport from:" + from + " channelId=" + b16 + " aioBottomMsg: " + k(guildMsgItem) + " latestAioMsg: " + k(this.latestAioMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ReadedScorce from, String channelId, MsgReadedHelper this$0, int i3, String str) {
        Long l3;
        MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMsgItem guildMsgItem = this$0.aioBottomMsg;
        if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null) {
            l3 = Long.valueOf(msgRecord.msgSeq);
        } else {
            l3 = null;
        }
        QLog.i("MsgReadedHelper", 1, "setMsgReadAndReport from:" + from + " channelId=" + channelId + " msgSeq:" + l3 + " result=" + i3 + " msg=" + str);
    }

    private final void u(ReadedScorce from) {
        s(from);
        if (!this.uiHandler.hasMessages(16711698)) {
            this.uiHandler.sendEmptyMessageDelayed(16711698, MiniBoxNoticeInfo.MIN_5);
        }
    }

    private final void v() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        if (!com.tencent.guild.aio.util.ex.a.g(bVar.a())) {
            com.tencent.aio.main.businesshelper.b bVar3 = this.param;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar3;
            }
            AIOParam g16 = bVar2.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            QLog.i("MsgReadedHelper", 1, "setReadedOnOpenWithPosChecking. isAioFullyOpen= false. channelId: " + com.tencent.guild.aio.util.a.b(g16));
            return;
        }
        u(ReadedScorce.READED_FROM_RESUME);
    }

    private final void w() {
        s(ReadedScorce.READED_FROM_PAUSE);
        this.uiHandler.removeMessages(16711698);
    }

    private final void x() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        if (!com.tencent.guild.aio.util.ex.a.g(bVar.a())) {
            com.tencent.aio.main.businesshelper.b bVar3 = this.param;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar3;
            }
            AIOParam g16 = bVar2.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            QLog.i("MsgReadedHelper", 1, "setReadedOnPauseWithPosChecking. isAioFullyOpen= false. channelId: " + com.tencent.guild.aio.util.a.b(g16));
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        this.uiHandler.sendEmptyMessageDelayed(16711698, MiniBoxNoticeInfo.MIN_5);
        s(ReadedScorce.READED_FROM_ONTIMER);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 2;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "MsgReadedHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state != 8) {
                    if (state == 12) {
                        h();
                        return;
                    }
                    return;
                }
                i();
                return;
            }
            j();
            return;
        }
        g();
    }
}
