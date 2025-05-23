package gq0;

import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u001f\u0012\u0006\u0010'\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eJ\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b&\u0010\u001eR\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lgq0/b;", "Lgq0/d;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "", "b", "", h.F, "emoji", "", "k", "emojiId", "emojiType", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "j", "", "toString", "hashCode", "", "other", "equals", "Z", "c", "()Z", "setEmojiIsClicked", "(Z)V", "emojiIsClicked", "I", "f", "()I", "", "J", "d", "()J", "setEmojiLikeCnt", "(J)V", "emojiLikeCnt", "e", "emojiLocalId", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(ZIJILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gq0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class EmojiReactionItem implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean emojiIsClicked;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long emojiLikeCnt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiLocalId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgRecord msg;

    public EmojiReactionItem(boolean z16, int i3, long j3, int i16, @NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.emojiIsClicked = z16;
        this.emojiType = i3;
        this.emojiLikeCnt = j3;
        this.emojiLocalId = i16;
        this.msg = msg2;
    }

    @Override // gq0.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public MsgRecord getMsg() {
        return this.msg;
    }

    @Override // gq0.d
    public int b() {
        return 1;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEmojiIsClicked() {
        return this.emojiIsClicked;
    }

    /* renamed from: d, reason: from getter */
    public final long getEmojiLikeCnt() {
        return this.emojiLikeCnt;
    }

    /* renamed from: e, reason: from getter */
    public final int getEmojiLocalId() {
        return this.emojiLocalId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiReactionItem)) {
            return false;
        }
        EmojiReactionItem emojiReactionItem = (EmojiReactionItem) other;
        if (this.emojiIsClicked == emojiReactionItem.emojiIsClicked && this.emojiType == emojiReactionItem.emojiType && this.emojiLikeCnt == emojiReactionItem.emojiLikeCnt && this.emojiLocalId == emojiReactionItem.emojiLocalId && Intrinsics.areEqual(this.msg, emojiReactionItem.msg)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getEmojiType() {
        return this.emojiType;
    }

    @NotNull
    public final MsgRecord g() {
        return this.msg;
    }

    public final void h() {
        boolean z16 = !this.emojiIsClicked;
        this.emojiIsClicked = z16;
        if (z16) {
            this.emojiLikeCnt++;
        } else {
            this.emojiLikeCnt--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z16 = this.emojiIsClicked;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((r06 * 31) + this.emojiType) * 31) + androidx.fragment.app.a.a(this.emojiLikeCnt)) * 31) + this.emojiLocalId) * 31) + this.msg.hashCode();
    }

    public final boolean i(int emojiId, int emojiType) {
        if (this.emojiLocalId == emojiId && this.emojiType == emojiType) {
            return true;
        }
        return false;
    }

    public final boolean j(@NotNull MsgEmojiLikes emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (ReactionUtilsKt.i(emoji) == this.emojiLocalId && ((int) emoji.emojiType) == this.emojiType) {
            return true;
        }
        return false;
    }

    public final boolean k(@NotNull d emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (emoji instanceof EmojiReactionItem) {
            EmojiReactionItem emojiReactionItem = (EmojiReactionItem) emoji;
            if (emojiReactionItem.emojiLocalId == this.emojiLocalId && emojiReactionItem.emojiType == this.emojiType) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "EmojiReactionItem(emojiIsClicked=" + this.emojiIsClicked + ", emojiType=" + this.emojiType + ", emojiLikeCnt=" + this.emojiLikeCnt + ", emojiLocalId=" + this.emojiLocalId + ", msg=" + this.msg + ")";
    }
}
