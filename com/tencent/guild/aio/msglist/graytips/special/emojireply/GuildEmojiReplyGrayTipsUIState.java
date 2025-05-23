package com.tencent.guild.aio.msglist.graytips.special.emojireply;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "SetEmojiReplyText", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsUIState$SetEmojiReplyText;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildEmojiReplyGrayTipsUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsUIState$SetEmojiReplyText;", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsUIState;", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "nickName", "e", "b", "tailText", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SetEmojiReplyText extends GuildEmojiReplyGrayTipsUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence nickName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence tailText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetEmojiReplyText(@NotNull CharSequence nickName, @NotNull CharSequence tailText) {
            super(null);
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(tailText, "tailText");
            this.nickName = nickName;
            this.tailText = tailText;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CharSequence getNickName() {
            return this.nickName;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CharSequence getTailText() {
            return this.tailText;
        }
    }

    public /* synthetic */ GuildEmojiReplyGrayTipsUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildEmojiReplyGrayTipsUIState() {
    }
}
