package c82;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lc82/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "remainMatchTime", "<init>", "(I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: c82.b, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class QQStrangerMsgMatchChatData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int remainMatchTime;

    public QQStrangerMsgMatchChatData() {
        this(0, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getRemainMatchTime() {
        return this.remainMatchTime;
    }

    public int hashCode() {
        return this.remainMatchTime;
    }

    public String toString() {
        return "QQStrangerMsgMatchChatData(remainMatchTime=" + this.remainMatchTime + ")";
    }

    public QQStrangerMsgMatchChatData(int i3) {
        this.remainMatchTime = i3;
    }

    public /* synthetic */ QQStrangerMsgMatchChatData(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 20 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QQStrangerMsgMatchChatData) && this.remainMatchTime == ((QQStrangerMsgMatchChatData) other).remainMatchTime;
    }
}
