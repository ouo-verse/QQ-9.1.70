package com.tencent.guild.aio.msglist.graytips.special.emojireply;

import com.tencent.qqnt.kernelpublic.nativeinterface.EmojiReplyElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b;", "Lol3/b;", "<init>", "()V", "a", "b", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b$a;", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b$b;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class b implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b$a;", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "d", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "a", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "emojiReplyElement", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EmojiReplyElement emojiReplyElement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull EmojiReplyElement emojiReplyElement) {
            super(null);
            Intrinsics.checkNotNullParameter(emojiReplyElement, "emojiReplyElement");
            this.emojiReplyElement = emojiReplyElement;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EmojiReplyElement getEmojiReplyElement() {
            return this.emojiReplyElement;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b$b;", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/b;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "d", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "a", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "emojiReplyElement", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.graytips.special.emojireply.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1197b extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EmojiReplyElement emojiReplyElement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1197b(@NotNull EmojiReplyElement emojiReplyElement) {
            super(null);
            Intrinsics.checkNotNullParameter(emojiReplyElement, "emojiReplyElement");
            this.emojiReplyElement = emojiReplyElement;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final EmojiReplyElement getEmojiReplyElement() {
            return this.emojiReplyElement;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
