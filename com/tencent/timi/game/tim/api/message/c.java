package com.tencent.timi.game.tim.api.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.MessageOuterClass$TimiEmoData;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH&J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002H&J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002H&\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/tim/api/message/c;", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/tim/api/message/a;", h.F, "j", "Ltrpc/yes/common/MessageOuterClass$TimiEmoData;", "emoData", "d", "", "type", "c", "msg", "", "e", "f", "Lcom/tencent/timi/game/tim/api/message/b;", "listener", "b", "k", "lastMsg", "i", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "sender", "", "g", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface c {
    boolean a(@NotNull MessageOuterClass$TimMsgBody timMsgBody, @NotNull CommonOuterClass$QQUserId sender);

    void b(@Nullable b listener);

    @Nullable
    a c(@NotNull CommonOuterClass$QQUserId userId, int type, @NotNull MessageOuterClass$MsgContent content);

    @Nullable
    a d(@NotNull CommonOuterClass$QQUserId userId, @NotNull MessageOuterClass$TimiEmoData emoData);

    void e(@NotNull a msg2);

    void f(@NotNull a msg2);

    boolean g(@NotNull MessageOuterClass$TimMsgBody timMsgBody, @NotNull CommonOuterClass$QQUserId sender);

    @Nullable
    a h(@NotNull CommonOuterClass$QQUserId userId, @NotNull String text, @NotNull MessageOuterClass$MsgContent content);

    void i(@Nullable a lastMsg);

    @Nullable
    a j(@NotNull CommonOuterClass$QQUserId userId, @NotNull String text);

    void k(@Nullable b listener);
}
