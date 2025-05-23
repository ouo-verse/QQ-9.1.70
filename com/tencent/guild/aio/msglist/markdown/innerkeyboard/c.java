package com.tencent.guild.aio.msglist.markdown.innerkeyboard;

import android.text.TextUtils;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/c;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/IGuildInlineKeyboardClickHandler;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> {
    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, @NotNull InlineBtnView<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable GuildMsgItem payload) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        String a16 = btnModel.a().a();
        if (TextUtils.isEmpty(a16) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).onInlineBtnClick(peekAppRuntime, ctx.getContext(), a16);
    }
}
