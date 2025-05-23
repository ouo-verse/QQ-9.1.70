package com.tencent.mobileqq.guild.robot.scheme.impl;

import android.content.Context;
import android.net.Uri;
import android.widget.EditText;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.util.e;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import go0.f;
import go0.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr0.a;
import n14.c;
import org.jetbrains.annotations.NotNull;
import rq0.GuildRobotSchemeActionContext;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J2\u0010\f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J4\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0005H\u0002J4\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H\u0002J \u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u000e\u0010\u001f\u001a\u0004\u0018\u00010\u0012*\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0014J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020#H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/robot/scheme/impl/GuildParameterCmdSchemeAction;", "Ln14/b;", "Lrq0/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/aio/api/runtime/a;", "context", "", "isReply", "", "cmdName", "ctx", "j", "aioContext", "cmd", "msgItemForReply", "atTinyId", "i", "Landroid/widget/EditText;", "editText", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lkotlin/Function0;", "block", DomainData.DOMAIN_NAME, "isDirectMsg", "guildId", "channelId", "f", h.F, "Landroid/net/Uri;", ZPlanPublishSource.FROM_SCHEME, "g", "Ln14/c;", "c", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildParameterCmdSchemeAction extends n14.b<GuildRobotSchemeActionContext> {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/robot/scheme/impl/GuildParameterCmdSchemeAction$b", "Lgo0/f;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f232288b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f232289c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f232290d;

        b(a aVar, boolean z16, String str) {
            this.f232288b = aVar;
            this.f232289c = z16;
            this.f232290d = str;
        }

        @Override // go0.f
        public void a(@NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            GuildParameterCmdSchemeAction.this.i(this.f232288b, this.f232289c, this.f232290d, msgItem, msgItem.getMsgRecord().senderUid);
        }
    }

    private final boolean f(boolean isDirectMsg, String guildId, String channelId) {
        int a16 = fo0.h.a(guildId, channelId);
        if (isDirectMsg) {
            return GuildSpeakLimitStatus.INSTANCE.e(a16);
        }
        return GuildSpeakLimitStatus.INSTANCE.d(a16, guildId);
    }

    private final EditText h(a aVar) {
        a.C10677a c10677a;
        k k3 = aVar.e().k(new GuildAioInputMsgIntent.GetInputEditTextEventR());
        if (k3 instanceof a.C10677a) {
            c10677a = (a.C10677a) k3;
        } else {
            c10677a = null;
        }
        if (c10677a == null) {
            return null;
        }
        return c10677a.getInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(final com.tencent.aio.api.runtime.a aioContext, final boolean isReply, String cmd, final GuildMsgItem msgItemForReply, final String atTinyId) {
        final EditText h16 = h(aioContext);
        if (h16 == null || !n(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.robot.scheme.impl.GuildParameterCmdSchemeAction$handleInsertAtAndCmdInChannel$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean m3;
                m3 = GuildParameterCmdSchemeAction.this.m(isReply, h16, aioContext, msgItemForReply, atTinyId);
                return Boolean.valueOf(m3);
            }
        })) {
            return false;
        }
        l(cmd, h16, aioContext);
        return true;
    }

    private final boolean j(GuildMsgItem msgItem, com.tencent.aio.api.runtime.a context, boolean isReply, String cmdName, GuildRobotSchemeActionContext ctx) {
        if (msgItem != null) {
            i iVar = i.f402720a;
            Context requireContext = context.c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "context.fragment.requireContext()");
            iVar.g(msgItem, requireContext, new b(context, isReply, cmdName));
            return true;
        }
        return i(context, false, cmdName, null, ctx.getAtTinyId());
    }

    private final boolean k(com.tencent.aio.api.runtime.a aioContext, boolean isReply, String cmdName, GuildMsgItem msgItemForReply) {
        EditText h16 = h(aioContext);
        boolean z16 = false;
        if (h16 == null) {
            return false;
        }
        if (isReply) {
            h16.getEditableText().clear();
            j e16 = aioContext.e();
            Intrinsics.checkNotNull(msgItemForReply);
            e16.h(new GuildMsgSendEvent.MsgOnClickReplyEvent(msgItemForReply));
            if (cmdName.length() > 0) {
                z16 = true;
            }
            if (z16) {
                h16.getEditableText().insert(h16.getSelectionStart(), cmdName + " ");
            }
            aioContext.e().h(new InputMsg$ShowKeyboardMsg());
        } else {
            if (cmdName.length() > 0) {
                z16 = true;
            }
            if (z16) {
                h16.getEditableText().clear();
                h16.getEditableText().insert(h16.getSelectionStart(), cmdName + " ");
                aioContext.e().h(new InputMsg$ShowKeyboardMsg());
            }
        }
        return true;
    }

    private final void l(String cmd, EditText editText, com.tencent.aio.api.runtime.a aioContext) {
        boolean z16;
        if (cmd.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            editText.getEditableText().insert(editText.getSelectionStart(), cmd + " ");
        }
        aioContext.e().h(new InputMsg$ShowKeyboardMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(boolean isReply, EditText editText, com.tencent.aio.api.runtime.a aioContext, GuildMsgItem msgItemForReply, String atTinyId) {
        if (isReply) {
            editText.getEditableText().clear();
            j e16 = aioContext.e();
            Intrinsics.checkNotNull(msgItemForReply);
            e16.h(new GuildMsgSendEvent.MsgOnClickReplyEvent(msgItemForReply));
        } else if (atTinyId != null) {
            editText.getEditableText().clear();
            e eVar = e.f112380a;
            Context requireContext = aioContext.c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "aioContext.fragment.requireContext()");
            AIOParam g16 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            e.i(eVar, requireContext, editText, atTinyId, iq0.a.u(atTinyId, com.tencent.guild.aio.util.a.g(g16)), 0, 16, null);
        } else {
            QLog.e("GuildParameterCmdSchemeAction", 1, "[handleInsertAtAndCmdInChannel]| atTinyId is null");
            return false;
        }
        return true;
    }

    private final boolean n(Function0<Boolean> block) {
        ap0.f.isAtListeningBlocked = true;
        boolean booleanValue = block.invoke().booleanValue();
        ap0.f.isAtListeningBlocked = false;
        return booleanValue;
    }

    @Override // n14.b
    public boolean c(@NotNull c ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return ctx instanceof GuildRobotSchemeActionContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // n14.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull GuildRobotSchemeActionContext ctx, @NotNull Uri scheme) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        com.tencent.aio.api.runtime.a aioContext = ctx.getAioContext();
        String queryParameter = scheme.getQueryParameter("command");
        if (queryParameter == null) {
            queryParameter = "";
        }
        String str = queryParameter;
        GuildMsgItem msgItemRef = ctx.getMsgItemRef();
        if (msgItemRef != null && scheme.getBooleanQueryParameter("reply", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean i3 = com.tencent.guild.aio.util.ex.a.i(aioContext);
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g18, "context.aioParam");
        if (!f(i3, g17, com.tencent.guild.aio.util.a.b(g18))) {
            return false;
        }
        if (com.tencent.guild.aio.util.ex.a.i(aioContext)) {
            return k(aioContext, z16, str, msgItemRef);
        }
        return j(msgItemRef, aioContext, z16, str, ctx);
    }
}
