package aj;

import com.qzone.proxy.feedcomponent.model.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yi.DownLoadParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Laj/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "Laj/b$a;", "Laj/b$b;", "Laj/b$c;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Laj/b$a;", "Laj/b;", "Lyi/a;", "a", "Lyi/a;", "()Lyi/a;", "param", "<init>", "(Lyi/a;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final DownLoadParam param;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DownLoadParam param) {
            super(null);
            Intrinsics.checkNotNullParameter(param, "param");
            this.param = param;
        }

        /* renamed from: a, reason: from getter */
        public final DownLoadParam getParam() {
            return this.param;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Laj/b$b;", "Laj/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "requestCount", "<init>", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aj.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class GetMediaList extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int requestCount;

        /* renamed from: a, reason: from getter */
        public final int getRequestCount() {
            return this.requestCount;
        }

        public int hashCode() {
            return this.requestCount;
        }

        public String toString() {
            return "GetMediaList(requestCount=" + this.requestCount + ")";
        }

        public GetMediaList(int i3) {
            super(null);
            this.requestCount = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetMediaList) && this.requestCount == ((GetMediaList) other).requestCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Laj/b$c;", "Laj/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "msgId", "b", "c", "msgTime", "msgSeq", "d", "I", "()I", "requestCount", "<init>", "(JJJI)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aj.b$c, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class GetMoreMediaList extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgSeq;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int requestCount;

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

        public int hashCode() {
            return (((((n.a(this.msgId) * 31) + n.a(this.msgTime)) * 31) + n.a(this.msgSeq)) * 31) + this.requestCount;
        }

        public String toString() {
            return "GetMoreMediaList(msgId=" + this.msgId + ", msgTime=" + this.msgTime + ", msgSeq=" + this.msgSeq + ", requestCount=" + this.requestCount + ")";
        }

        public GetMoreMediaList(long j3, long j16, long j17, int i3) {
            super(null);
            this.msgId = j3;
            this.msgTime = j16;
            this.msgSeq = j17;
            this.requestCount = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetMoreMediaList)) {
                return false;
            }
            GetMoreMediaList getMoreMediaList = (GetMoreMediaList) other;
            return this.msgId == getMoreMediaList.msgId && this.msgTime == getMoreMediaList.msgTime && this.msgSeq == getMoreMediaList.msgSeq && this.requestCount == getMoreMediaList.requestCount;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
