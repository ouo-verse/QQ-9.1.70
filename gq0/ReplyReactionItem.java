package gq0;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lgq0/e;", "Lgq0/d;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "", "b", "", "toString", "hashCode", "", "other", "", "equals", "", "J", "c", "()J", "replyCnt", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsg", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(JLcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gq0.e, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class ReplyReactionItem implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long replyCnt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgRecord msg;

    public ReplyReactionItem(long j3, @NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.replyCnt = j3;
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
        return 2;
    }

    /* renamed from: c, reason: from getter */
    public final long getReplyCnt() {
        return this.replyCnt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplyReactionItem)) {
            return false;
        }
        ReplyReactionItem replyReactionItem = (ReplyReactionItem) other;
        if (this.replyCnt == replyReactionItem.replyCnt && Intrinsics.areEqual(this.msg, replyReactionItem.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.replyCnt) * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReplyReactionItem(replyCnt=" + this.replyCnt + ", msg=" + this.msg + ")";
    }
}
