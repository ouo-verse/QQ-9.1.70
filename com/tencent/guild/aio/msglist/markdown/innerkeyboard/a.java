package com.tencent.guild.aio.msglist.markdown.innerkeyboard;

import android.net.Uri;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.robot.action.api.IRobotActionApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq0.GuildRobotSchemeActionContext;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/IGuildInlineKeyboardClickHandler;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "b", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final C1203a f111779a = new C1203a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/a$a;", "", "", "AUTHORITY", "Ljava/lang/String;", "PARAM_ANCHOR", "PARAM_CMD", "PARAM_ENTER", "PARAM_REPLY", AEEditorConstants.PATH, "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.markdown.innerkeyboard.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static final class C1203a {
        public /* synthetic */ C1203a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        C1203a() {
        }
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, @NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable GuildMsgItem payload) {
        InlineKeyboardButton inlineKeyboardButton;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        com.tencent.aio.api.runtime.a aioContext = ctx.getAioContext();
        if (aioContext == null || payload == null) {
            return;
        }
        Object e16 = btnModel.e();
        if (e16 instanceof InlineKeyboardButton) {
            inlineKeyboardButton = (InlineKeyboardButton) e16;
        } else {
            inlineKeyboardButton = null;
        }
        if (inlineKeyboardButton == null) {
            return;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(SchemaUtils.SCHEMA_MQQAPI).authority("aio").path("/inlinecmd").appendQueryParameter("command", btnModel.a().a()).appendQueryParameter("reply", String.valueOf(btnModel.a().e())).appendQueryParameter(BaseConstants.BROADCAST_USERSYNC_ENTER, String.valueOf(inlineKeyboardButton.enter)).appendQueryParameter("anchor", String.valueOf(inlineKeyboardButton.anchor));
        IRobotActionApi iRobotActionApi = (IRobotActionApi) QRoute.api(IRobotActionApi.class);
        GuildRobotSchemeActionContext guildRobotSchemeActionContext = new GuildRobotSchemeActionContext(aioContext, payload, null, 4, null);
        String uri = appendQueryParameter.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        iRobotActionApi.doSchemeAction(guildRobotSchemeActionContext, uri);
    }
}
