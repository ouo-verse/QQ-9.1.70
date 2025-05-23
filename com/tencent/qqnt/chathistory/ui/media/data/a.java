package com.tencent.qqnt.chathistory.ui.media.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.item.d;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/data/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "c", "Lcom/tencent/qqnt/chathistory/ui/media/data/a$a;", "Lcom/tencent/qqnt/chathistory/ui/media/data/a$b;", "Lcom/tencent/qqnt/chathistory/ui/media/data/a$c;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/data/a$a;", "Lcom/tencent/qqnt/chathistory/ui/media/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "info", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.media.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final /* data */ class C9542a extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FileTransNotifyInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9542a(@NotNull FileTransNotifyInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            } else {
                this.info = info;
            }
        }

        @NotNull
        public final FileTransNotifyInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FileTransNotifyInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof C9542a) && Intrinsics.areEqual(this.info, ((C9542a) other).info)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.info.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "DowLoadMediaCompleted(info=" + this.info + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/data/a$b;", "Lcom/tencent/qqnt/chathistory/ui/media/data/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;", "", "a", "", "toString", "", "hashCode", "", "other", "equals", "", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "b", "I", "getRequestCount", "()I", "requestCount", "c", "getReceiveCount", "receiveCount", "<init>", "(Ljava/util/List;II)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class b extends a implements d<SearchMediaItemModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<SearchMediaItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int receiveCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull List<SearchMediaItemModel> data, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, data, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.data = data;
            this.requestCount = i3;
            this.receiveCount = i16;
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (this.receiveCount >= getRequestCount()) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(getData(), bVar.getData()) && getRequestCount() == bVar.getRequestCount() && this.receiveCount == bVar.receiveCount) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        @NotNull
        public List<SearchMediaItemModel> getData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        public int getRequestCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.requestCount;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((getData().hashCode() * 31) + getRequestCount()) * 31) + this.receiveCount;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "GetMediaListCompleted(data=" + getData() + ", requestCount=" + getRequestCount() + ", receiveCount=" + this.receiveCount + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/data/a$c;", "Lcom/tencent/qqnt/chathistory/ui/media/data/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;", "", "a", "", "toString", "", "hashCode", "", "other", "equals", "", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "b", "I", "getRequestCount", "()I", "requestCount", "c", "getReceiveCount", "receiveCount", "<init>", "(Ljava/util/List;II)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class c extends a implements d<SearchMediaItemModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<SearchMediaItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int receiveCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull List<SearchMediaItemModel> data, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, data, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.data = data;
            this.requestCount = i3;
            this.receiveCount = i16;
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (this.receiveCount >= getRequestCount()) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(getData(), cVar.getData()) && getRequestCount() == cVar.getRequestCount() && this.receiveCount == cVar.receiveCount) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        @NotNull
        public List<SearchMediaItemModel> getData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        public int getRequestCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.requestCount;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((getData().hashCode() * 31) + getRequestCount()) * 31) + this.receiveCount;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "GetMoreMediaListCompleted(data=" + getData() + ", requestCount=" + getRequestCount() + ", receiveCount=" + this.receiveCount + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
