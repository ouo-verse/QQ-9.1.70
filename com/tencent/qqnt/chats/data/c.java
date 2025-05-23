package com.tencent.qqnt.chats.data;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR(\u0010\u0013\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chats/data/c;", "T", "", "Lcom/tencent/qqnt/chats/data/c$a;", "update", "", "b", "data", "d", "(Ljava/lang/Object;)V", "", NotificationCompat.CATEGORY_ERROR, "", "msg", "c", "<set-?>", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "curData", "Lcom/tencent/qqnt/chats/data/c$a;", "getUpdate", "()Lcom/tencent/qqnt/chats/data/c$a;", "setUpdate", "(Lcom/tencent/qqnt/chats/data/c$a;)V", "<init>", "()V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T curData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a<T> update;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/data/c$a;", "T", "", "data", "", "a", "(Ljava/lang/Object;)V", "", NotificationCompat.CATEGORY_ERROR, "", "msg", "onFail", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface a<T> {
        void a(T data);

        void onFail(int err, @NotNull String msg2);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.curData;
    }

    public final void b(@NotNull a<T> update) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) update);
            return;
        }
        Intrinsics.checkNotNullParameter(update, "update");
        this.update = update;
        T t16 = this.curData;
        if (t16 != null) {
            update.a(t16);
        }
    }

    public final void c(int err, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, err, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a<T> aVar = this.update;
        if (aVar != null) {
            aVar.onFail(err, msg2);
        }
    }

    public final void d(T data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) data);
            return;
        }
        a<T> aVar = this.update;
        if (aVar != null) {
            aVar.a(data);
        }
        this.curData = data;
    }
}
