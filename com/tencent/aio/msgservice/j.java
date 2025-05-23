package com.tencent.aio.msgservice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u001a\u0010\u0015\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0004\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/msgservice/j;", "T", "", "", "a", "Z", "d", "()Z", "isSuccess", "", "b", "I", "c", "()I", "result", "", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ZILjava/lang/String;Ljava/lang/Object;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class j<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final T data;

    public j(boolean z16, int i3, @Nullable String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, t16);
            return;
        }
        this.isSuccess = z16;
        this.result = i3;
        this.errMsg = str;
        this.data = t16;
    }

    public T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.data;
    }

    @Nullable
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.errMsg;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.result;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }
}
