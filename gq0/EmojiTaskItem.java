package gq0;

import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u00101\u001a\u00020\u0016\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eJ\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010!\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010.\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b\u001d\u0010 \"\u0004\b,\u0010-R\"\u00101\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lgq0/c;", "Lgq0/d;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "", "b", "", "k", "emoji", "", DomainData.DOMAIN_NAME, "emojiId", "emojiType", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "toString", "hashCode", "", "other", "equals", "", "J", h.F, "()J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "i", "taskType", "c", "Z", "j", "()Z", "isMultiple", "d", "I", "e", "()I", "emojiLocalId", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "o", "(Z)V", "emojiIsClicked", "p", "(J)V", "emojiLikeCnt", "<init>", "(JJZIILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;ZJ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gq0.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class EmojiTaskItem implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long taskType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMultiple;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiLocalId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgRecord msg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean emojiIsClicked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long emojiLikeCnt;

    public EmojiTaskItem(long j3, long j16, boolean z16, int i3, int i16, @NotNull MsgRecord msg2, boolean z17, long j17) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.taskId = j3;
        this.taskType = j16;
        this.isMultiple = z16;
        this.emojiLocalId = i3;
        this.emojiType = i16;
        this.msg = msg2;
        this.emojiIsClicked = z17;
        this.emojiLikeCnt = j17;
    }

    @Override // gq0.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public MsgRecord getMsg() {
        return this.msg;
    }

    @Override // gq0.d
    public int b() {
        return 4;
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
        if (!(other instanceof EmojiTaskItem)) {
            return false;
        }
        EmojiTaskItem emojiTaskItem = (EmojiTaskItem) other;
        if (this.taskId == emojiTaskItem.taskId && this.taskType == emojiTaskItem.taskType && this.isMultiple == emojiTaskItem.isMultiple && this.emojiLocalId == emojiTaskItem.emojiLocalId && this.emojiType == emojiTaskItem.emojiType && Intrinsics.areEqual(this.msg, emojiTaskItem.msg) && this.emojiIsClicked == emojiTaskItem.emojiIsClicked && this.emojiLikeCnt == emojiTaskItem.emojiLikeCnt) {
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

    /* renamed from: h, reason: from getter */
    public final long getTaskId() {
        return this.taskId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((androidx.fragment.app.a.a(this.taskId) * 31) + androidx.fragment.app.a.a(this.taskType)) * 31;
        boolean z16 = this.isMultiple;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode = (((((((a16 + i16) * 31) + this.emojiLocalId) * 31) + this.emojiType) * 31) + this.msg.hashCode()) * 31;
        boolean z17 = this.emojiIsClicked;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((hashCode + i3) * 31) + androidx.fragment.app.a.a(this.emojiLikeCnt);
    }

    /* renamed from: i, reason: from getter */
    public final long getTaskType() {
        return this.taskType;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsMultiple() {
        return this.isMultiple;
    }

    public final void k() {
        boolean z16 = !this.emojiIsClicked;
        this.emojiIsClicked = z16;
        if (z16) {
            this.emojiLikeCnt++;
        } else {
            this.emojiLikeCnt--;
        }
    }

    public final boolean l(int emojiId, int emojiType) {
        if (this.emojiLocalId == emojiId && this.emojiType == emojiType) {
            return true;
        }
        return false;
    }

    public final boolean m(@NotNull MsgEmojiLikes emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (ReactionUtilsKt.i(emoji) == this.emojiLocalId && ((int) emoji.emojiType) == this.emojiType) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0.getEmojiType() == r3.emojiType) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n(@NotNull d emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (emoji instanceof EmojiReactionItem) {
            EmojiReactionItem emojiReactionItem = (EmojiReactionItem) emoji;
            if (emojiReactionItem.getEmojiLocalId() == this.emojiLocalId) {
            }
        }
        if (emoji instanceof EmojiTaskItem) {
            EmojiTaskItem emojiTaskItem = (EmojiTaskItem) emoji;
            if (emojiTaskItem.emojiLocalId == this.emojiLocalId && emojiTaskItem.emojiType == this.emojiType) {
                return true;
            }
        }
        return false;
    }

    public final void o(boolean z16) {
        this.emojiIsClicked = z16;
    }

    public final void p(long j3) {
        this.emojiLikeCnt = j3;
    }

    @NotNull
    public String toString() {
        return "EmojiTaskItem(taskId=" + this.taskId + ", taskType=" + this.taskType + ", isMultiple=" + this.isMultiple + ", emojiLocalId=" + this.emojiLocalId + ", emojiType=" + this.emojiType + ", msg=" + this.msg + ", emojiIsClicked=" + this.emojiIsClicked + ", emojiLikeCnt=" + this.emojiLikeCnt + ")";
    }

    public /* synthetic */ EmojiTaskItem(long j3, long j16, boolean z16, int i3, int i16, MsgRecord msgRecord, boolean z17, long j17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, z16, i3, i16, msgRecord, (i17 & 64) != 0 ? false : z17, (i17 & 128) != 0 ? 0L : j17);
    }
}
