package ew3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lew3/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "Lew3/b$a;", "Lew3/b$b;", "Lew3/b$c;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lew3/b$a;", "Lew3/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "msgId", "b", "c", "msgTime", "msgSeq", "d", "I", "()I", "requestCount", "<init>", "(JJJI)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ew3.b$a, reason: from toString */
    /* loaded from: classes23.dex */
    public static final /* data */ class GetMoreShortVideoList extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgSeq;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int requestCount;

        public GetMoreShortVideoList(long j3, long j16, long j17, int i3) {
            super(null);
            this.msgId = j3;
            this.msgTime = j16;
            this.msgSeq = j17;
            this.requestCount = i3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgId() {
            return this.msgId;
        }

        /* renamed from: b, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }

        /* renamed from: c, reason: from getter */
        public final long getMsgTime() {
            return this.msgTime;
        }

        /* renamed from: d, reason: from getter */
        public final int getRequestCount() {
            return this.requestCount;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetMoreShortVideoList)) {
                return false;
            }
            GetMoreShortVideoList getMoreShortVideoList = (GetMoreShortVideoList) other;
            if (this.msgId == getMoreShortVideoList.msgId && this.msgTime == getMoreShortVideoList.msgTime && this.msgSeq == getMoreShortVideoList.msgSeq && this.requestCount == getMoreShortVideoList.requestCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((androidx.fragment.app.a.a(this.msgId) * 31) + androidx.fragment.app.a.a(this.msgTime)) * 31) + androidx.fragment.app.a.a(this.msgSeq)) * 31) + this.requestCount;
        }

        @NotNull
        public String toString() {
            return "GetMoreShortVideoList(msgId=" + this.msgId + ", msgTime=" + this.msgTime + ", msgSeq=" + this.msgSeq + ", requestCount=" + this.requestCount + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lew3/b$b;", "Lew3/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "requestCount", "<init>", "(I)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ew3.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes23.dex */
    public static final /* data */ class GetShortVideoList extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int requestCount;

        public GetShortVideoList(int i3) {
            super(null);
            this.requestCount = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getRequestCount() {
            return this.requestCount;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetShortVideoList) && this.requestCount == ((GetShortVideoList) other).requestCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.requestCount;
        }

        @NotNull
        public String toString() {
            return "GetShortVideoList(requestCount=" + this.requestCount + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lew3/b$c;", "Lew3/b;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f397306a = new c();

        c() {
            super(null);
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
