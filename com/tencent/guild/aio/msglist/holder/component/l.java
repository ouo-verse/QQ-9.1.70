package com.tencent.guild.aio.msglist.holder.component;

import android.content.Context;
import android.view.View;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.halfpop.menu.GuildVideoMsgResendIntent;
import com.tencent.guild.aio.msglist.holder.state.MsgListCancelSendVideoMsgState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoSendState;
import com.tencent.guild.aio.msglist.holder.state.MsgListVideoState;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/l;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", "videoView", "", "playPos", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "imageView", "l", "Lcom/tencent/aio/api/runtime/a;", "onCreate", "Lol3/b;", "intent", "handleIntent", "Lcom/tencent/mvi/base/route/a;", "d", "Lcom/tencent/mvi/base/route/a;", "getAction", "()Lcom/tencent/mvi/base/route/a;", "action", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class l extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a action = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/l$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof GuildVideoMsgResendIntent) {
                l.this.updateUI(new MsgListVideoSendState(((GuildVideoMsgResendIntent) i3).getMsgId()));
                return;
            }
            if (i3 instanceof GuildMsgListIntent.GuildVideoPlayEvent) {
                GuildMsgListIntent.GuildVideoPlayEvent guildVideoPlayEvent = (GuildMsgListIntent.GuildVideoPlayEvent) i3;
                l.this.updateUI(new MsgListVideoState(guildVideoPlayEvent.getPause(), guildVideoPlayEvent.getMute()));
            } else if (i3 instanceof GuildMsgSendEvent.CancelSendVideoMsg) {
                l.this.updateUI(new MsgListCancelSendVideoMsgState(((GuildMsgSendEvent.CancelSendVideoMsg) i3).getMsgId()));
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(MsgRecord msgRecord, PicElement picElement, View imageView) {
        i.c cVar;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new GuildMsgListIntent.GetAIORichMediaMsgListEvent(msgRecord));
        List<MsgRecord> list = null;
        if (k3 instanceof i.c) {
            cVar = (i.c) k3;
        } else {
            cVar = null;
        }
        UIUtil uIUtil = UIUtil.f112434a;
        if (cVar != null) {
            list = cVar.a();
        }
        uIUtil.C(imageView, msgRecord, picElement, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(Context context, MsgRecord msgRecord, View videoView, long playPos) {
        i.c cVar;
        List<MsgRecord> list;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new GuildMsgListIntent.GetAIORichMediaMsgListEvent(msgRecord));
        if (k3 instanceof i.c) {
            cVar = (i.c) k3;
        } else {
            cVar = null;
        }
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(app, "app");
        if (cVar != null) {
            list = cVar.a();
        } else {
            list = null;
        }
        iGuildRichMediaBrowserApi.enterVideoPreview(app, context, msgRecord, videoView, playPos, false, false, null, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildVideoMsgResendIntent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildVideoPlayEvent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.CancelSendVideoMsg.class).getQualifiedName(), this.action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.m) {
            a.m mVar = (a.m) intent;
            m(mVar.getContext(), mVar.getMsgRecord(), mVar.getVideoView(), mVar.getPlayPos());
            return;
        }
        if (intent instanceof a.j) {
            a.j jVar = (a.j) intent;
            l(jVar.getMsgRecord(), jVar.getPicElement(), jVar.getClickedView());
        } else {
            if (intent instanceof a.p) {
                com.tencent.guild.aio.msglist.video.e.f111990a.d(((a.p) intent).getMsgRecord(), (com.tencent.aio.api.runtime.a) getMContext());
                return;
            }
            if (intent instanceof a.n) {
                com.tencent.guild.aio.msglist.video.e.f111990a.b(((a.n) intent).getMsgRecord(), (com.tencent.aio.api.runtime.a) getMContext());
            } else if (intent instanceof a.o) {
                com.tencent.guild.aio.msglist.video.e.f111990a.c(((a.o) intent).getMsgRecord(), (com.tencent.aio.api.runtime.a) getMContext());
            } else {
                super.handleIntent(intent);
            }
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        n();
    }
}
