package aj;

import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Laj/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "c", "Laj/a$a;", "Laj/a$b;", "Laj/a$c;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {
    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Laj/a$a;", "Laj/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "info", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aj.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class DowLoadMediaCompleted extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final FileTransNotifyInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DowLoadMediaCompleted(FileTransNotifyInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        /* renamed from: a, reason: from getter */
        public final FileTransNotifyInfo getInfo() {
            return this.info;
        }

        public int hashCode() {
            return this.info.hashCode();
        }

        public String toString() {
            return "DowLoadMediaCompleted(info=" + this.info + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DowLoadMediaCompleted) && Intrinsics.areEqual(this.info, ((DowLoadMediaCompleted) other).info);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Laj/a$b;", "Laj/a;", "", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "", "c", "", "toString", "", "hashCode", "other", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "b", "I", "()I", "requestCount", "getReceiveCount", "receiveCount", "<init>", "(Ljava/util/List;II)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aj.a$b, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class GetMediaListCompleted extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<SearchMediaItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int receiveCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetMediaListCompleted(List<SearchMediaItemModel> data, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.requestCount = i3;
            this.receiveCount = i16;
        }

        public List<SearchMediaItemModel> a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public int getRequestCount() {
            return this.requestCount;
        }

        public boolean c() {
            return this.receiveCount >= getRequestCount();
        }

        public int hashCode() {
            return (((a().hashCode() * 31) + getRequestCount()) * 31) + this.receiveCount;
        }

        public String toString() {
            return "GetMediaListCompleted(data=" + a() + ", requestCount=" + getRequestCount() + ", receiveCount=" + this.receiveCount + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetMediaListCompleted)) {
                return false;
            }
            GetMediaListCompleted getMediaListCompleted = (GetMediaListCompleted) other;
            return Intrinsics.areEqual(a(), getMediaListCompleted.a()) && getRequestCount() == getMediaListCompleted.getRequestCount() && this.receiveCount == getMediaListCompleted.receiveCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Laj/a$c;", "Laj/a;", "", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "", "c", "", "toString", "", "hashCode", "other", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "data", "b", "I", "()I", "requestCount", "getReceiveCount", "receiveCount", "<init>", "(Ljava/util/List;II)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aj.a$c, reason: from toString */
    /* loaded from: classes39.dex */
    public static final /* data */ class GetMoreMediaListCompleted extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<SearchMediaItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int receiveCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetMoreMediaListCompleted(List<SearchMediaItemModel> data, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.requestCount = i3;
            this.receiveCount = i16;
        }

        public List<SearchMediaItemModel> a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public int getRequestCount() {
            return this.requestCount;
        }

        public boolean c() {
            return this.receiveCount >= getRequestCount();
        }

        public int hashCode() {
            return (((a().hashCode() * 31) + getRequestCount()) * 31) + this.receiveCount;
        }

        public String toString() {
            return "GetMoreMediaListCompleted(data=" + a() + ", requestCount=" + getRequestCount() + ", receiveCount=" + this.receiveCount + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetMoreMediaListCompleted)) {
                return false;
            }
            GetMoreMediaListCompleted getMoreMediaListCompleted = (GetMoreMediaListCompleted) other;
            return Intrinsics.areEqual(a(), getMoreMediaListCompleted.a()) && getRequestCount() == getMoreMediaListCompleted.getRequestCount() && this.receiveCount == getMoreMediaListCompleted.receiveCount;
        }
    }
}
