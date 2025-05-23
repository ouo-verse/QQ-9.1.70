package com.tencent.qqnt.chathistory.ui.file.c2c.dialog.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/b;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/b$a;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/b$a;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/viewmodel/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", "a", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", "data", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
            } else {
                this.data = data;
            }
        }

        @NotNull
        public final com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof a) && Intrinsics.areEqual(this.data, ((a) other).data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SearchFileListCompleted(data=" + this.data + ")";
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
