package ew3;

import com.tencent.qqnt.chathistory.ui.base.item.d;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lew3/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "Lew3/a$a;", "Lew3/a$b;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u000e\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lew3/a$a;", "Lew3/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;", "", "b", "", "toString", "", "hashCode", "", "other", "equals", "", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "I", "getRequestCount", "()I", "requestCount", "c", "receiveCount", "<init>", "(Ljava/util/List;II)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ew3.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes23.dex */
    public static final /* data */ class GetMoreShortVideoListCompleted extends a implements d<ChatHistoryShortVideoItemModel> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<ChatHistoryShortVideoItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int receiveCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetMoreShortVideoListCompleted(@NotNull List<ChatHistoryShortVideoItemModel> data, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.requestCount = i3;
            this.receiveCount = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getReceiveCount() {
            return this.receiveCount;
        }

        public boolean b() {
            if (this.receiveCount >= getRequestCount()) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetMoreShortVideoListCompleted)) {
                return false;
            }
            GetMoreShortVideoListCompleted getMoreShortVideoListCompleted = (GetMoreShortVideoListCompleted) other;
            if (Intrinsics.areEqual(getData(), getMoreShortVideoListCompleted.getData()) && getRequestCount() == getMoreShortVideoListCompleted.getRequestCount() && this.receiveCount == getMoreShortVideoListCompleted.receiveCount) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        @NotNull
        public List<ChatHistoryShortVideoItemModel> getData() {
            return this.data;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        public int getRequestCount() {
            return this.requestCount;
        }

        public int hashCode() {
            return (((getData().hashCode() * 31) + getRequestCount()) * 31) + this.receiveCount;
        }

        @NotNull
        public String toString() {
            return "GetMoreShortVideoListCompleted(data=" + getData() + ", requestCount=" + getRequestCount() + ", receiveCount=" + this.receiveCount + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u000e\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lew3/a$b;", "Lew3/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;", "", "b", "", "toString", "", "hashCode", "", "other", "equals", "", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "I", "getRequestCount", "()I", "requestCount", "c", "receiveCount", "<init>", "(Ljava/util/List;II)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ew3.a$b, reason: from toString */
    /* loaded from: classes23.dex */
    public static final /* data */ class GetShortVideoListCompleted extends a implements d<ChatHistoryShortVideoItemModel> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<ChatHistoryShortVideoItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int receiveCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetShortVideoListCompleted(@NotNull List<ChatHistoryShortVideoItemModel> data, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.requestCount = i3;
            this.receiveCount = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getReceiveCount() {
            return this.receiveCount;
        }

        public boolean b() {
            if (this.receiveCount >= getRequestCount()) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetShortVideoListCompleted)) {
                return false;
            }
            GetShortVideoListCompleted getShortVideoListCompleted = (GetShortVideoListCompleted) other;
            if (Intrinsics.areEqual(getData(), getShortVideoListCompleted.getData()) && getRequestCount() == getShortVideoListCompleted.getRequestCount() && this.receiveCount == getShortVideoListCompleted.receiveCount) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        @NotNull
        public List<ChatHistoryShortVideoItemModel> getData() {
            return this.data;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        public int getRequestCount() {
            return this.requestCount;
        }

        public int hashCode() {
            return (((getData().hashCode() * 31) + getRequestCount()) * 31) + this.receiveCount;
        }

        @NotNull
        public String toString() {
            return "GetShortVideoListCompleted(data=" + getData() + ", requestCount=" + getRequestCount() + ", receiveCount=" + this.receiveCount + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
