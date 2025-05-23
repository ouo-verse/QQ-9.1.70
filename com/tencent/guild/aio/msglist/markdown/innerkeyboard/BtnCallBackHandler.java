package com.tencent.guild.aio.msglist.markdown.innerkeyboard;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.guild.aio.msglist.markdown.innerkeyboard.BtnCallBackHandler;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildInnerKeyboardApi;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xw1.RobotClickReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u001f2\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002JD\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00022\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0012j\u0002`\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0017\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/BtnCallBackHandler;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/IGuildInlineKeyboardClickHandler;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;", "inlineKeyboardApi", "", "btnKey", "Lkotlinx/coroutines/Job;", "job", "", "e", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "d", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "f", "", "a", "J", "TIME_OUT", "<init>", "()V", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class BtnCallBackHandler implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long TIME_OUT = 30000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/BtnCallBackHandler$a;", "", "", "promptIcon", "b", "Landroid/content/Context;", "context", "status", "promptType", "", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "", "c", "TEXT_OK", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.markdown.innerkeyboard.BtnCallBackHandler$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int b(int promptIcon) {
            if (promptIcon != 0) {
                if (promptIcon != 2) {
                    if (promptIcon == 3) {
                        return 2;
                    }
                    return 0;
                }
                return 1;
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }

        public final void c(@NotNull Context context, int status, int promptType, @NotNull String promptText, int promptIcon) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(promptText, "promptText");
            if (promptType != 1) {
                if (promptType == 2) {
                    QQToast.makeText(context, b(promptIcon), promptText, 0).show();
                    return;
                }
                return;
            }
            com.tencent.mobileqq.guild.util.qqui.c.b(context, 230, promptText, "", "", "\u597d\u7684", new DialogInterface.OnClickListener() { // from class: com.tencent.guild.aio.msglist.markdown.innerkeyboard.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    BtnCallBackHandler.Companion.d(dialogInterface, i3);
                }
            }, null).show();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guild/aio/msglist/markdown/innerkeyboard/BtnCallBackHandler$b", "Lvw1/a;", "Lxw1/a;", "reply", "", "a", "", "errCode", "", "msg", "onError", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements vw1.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.guild.aio.msglist.markdown.inlineboard.b f111775b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f111776c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qcoroutine.api.coroutine.b f111777d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.guild.aio.msglist.markdown.inlineboard.a f111778e;

        b(com.tencent.guild.aio.msglist.markdown.inlineboard.b bVar, String str, com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2, com.tencent.guild.aio.msglist.markdown.inlineboard.a aVar) {
            this.f111775b = bVar;
            this.f111776c = str;
            this.f111777d = bVar2;
            this.f111778e = aVar;
        }

        @Override // vw1.a
        public void a(@NotNull RobotClickReply reply) {
            Job job;
            Intrinsics.checkNotNullParameter(reply, "reply");
            BtnCallBackHandler btnCallBackHandler = BtnCallBackHandler.this;
            com.tencent.guild.aio.msglist.markdown.inlineboard.b bVar = this.f111775b;
            String str = this.f111776c;
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.f111777d;
            if (bVar2 != null) {
                job = bVar2.a();
            } else {
                job = null;
            }
            btnCallBackHandler.e(bVar, str, job);
            BtnCallBackHandler.INSTANCE.c(this.f111778e.getContext(), reply.getStatus(), reply.getPromptType(), reply.getPromptText(), reply.getPromptIcon());
        }

        @Override // vw1.a
        public void onError(int errCode, @NotNull String msg2) {
            Job job;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            BtnCallBackHandler btnCallBackHandler = BtnCallBackHandler.this;
            com.tencent.guild.aio.msglist.markdown.inlineboard.b bVar = this.f111775b;
            String str = this.f111776c;
            com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.f111777d;
            if (bVar2 != null) {
                job = bVar2.a();
            } else {
                job = null;
            }
            btnCallBackHandler.e(bVar, str, job);
            QQToast.makeText(this.f111778e.getContext(), msg2, 0).show();
        }
    }

    private final MsgElement d(GuildMsgItem msgItem) {
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 17) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(com.tencent.guild.aio.msglist.markdown.inlineboard.b inlineKeyboardApi, String btnKey, Job job) {
        if (job != null && !job.isCompleted()) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "BtnCallBackHandler_hideLoading", null, null, null, new BtnCallBackHandler$hideLoading$1(inlineKeyboardApi, btnKey, null), 14, null);
        }
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, @NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable GuildMsgItem payload) {
        InlineKeyboardElement inlineKeyboardElement;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        if (payload == null) {
            return;
        }
        com.tencent.guild.aio.msglist.markdown.inlineboard.b inlineKeyboardApi = ctx.getInlineKeyboardApi();
        String a16 = inlineKeyboardApi.a(btnView);
        if (inlineKeyboardApi.d(a16)) {
            return;
        }
        MsgElement d16 = d(payload);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
        if (d16 != null) {
            inlineKeyboardElement = d16.inlineKeyboardElement;
        } else {
            inlineKeyboardElement = null;
        }
        if (inlineKeyboardElement != null) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            if (f16 != null) {
                bVar = CorountineFunKt.e(f16, "BtnCallBackHandler_click", null, null, null, new BtnCallBackHandler$performClick$job$1(this, inlineKeyboardApi, a16, null), 14, null);
            }
            inlineKeyboardApi.b(a16, btnView);
            ((IGuildInnerKeyboardApi) QRoute.api(IGuildInnerKeyboardApi.class)).clickCallbackButton(btnModel.c(), com.tencent.guild.aio.input.at.utils.g.a(payload.getMsgRecord().guildId, 0L), com.tencent.guild.aio.input.at.utils.g.a(payload.getMsgRecord().channelId, 0L), inlineKeyboardElement.botAppid, payload.getMsgRecord().msgSeq, btnModel.a().a(), new b(inlineKeyboardApi, a16, bVar, ctx));
        }
    }
}
