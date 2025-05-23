package com.tencent.qqnt.chathistory.ui.file.c2c.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.item.d;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$a;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$b;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$a;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b;", "Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "", "b", "I", "getRequestCount", "()I", "requestCount", "<init>", "(Ljava/util/List;I)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends b implements d<FileItemModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<FileItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull List<FileItemModel> data, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data, i3);
            } else {
                this.data = data;
                this.requestCount = i3;
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return d.a.a(this);
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        @NotNull
        public List<FileItemModel> getData() {
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
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$b;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b;", "Lcom/tencent/qqnt/chathistory/ui/base/item/d;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "", "b", "I", "getRequestCount", "()I", "requestCount", "<init>", "(Ljava/util/List;I)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.file.c2c.data.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9534b extends b implements d<FileItemModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<FileItemModel> data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9534b(@NotNull List<FileItemModel> data, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data, i3);
            } else {
                this.data = data;
                this.requestCount = i3;
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return d.a.a(this);
        }

        @Override // com.tencent.qqnt.chathistory.ui.base.item.d
        @NotNull
        public List<FileItemModel> getData() {
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
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
