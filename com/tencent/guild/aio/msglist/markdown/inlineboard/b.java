package com.tencent.guild.aio.msglist.markdown.inlineboard;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0002`\u0006H&J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0002`\u0006H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;", "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnView;", "btnView", "", "a", "btnKey", "", "b", "c", "", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface b {
    @NotNull
    String a(@NotNull InlineBtnView<a, GuildMsgItem> btnView);

    void b(@NotNull String btnKey, @NotNull InlineBtnView<a, GuildMsgItem> btnView);

    void c(@NotNull String btnKey);

    boolean d(@NotNull String btnKey);
}
