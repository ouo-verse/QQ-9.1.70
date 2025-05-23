package com.tencent.mobileqq.gateway.localphone.ecdh;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/i;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "f", "(I)V", "ret", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "d", "(Ljava/lang/Object;)V", "data", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "errorMsg", "<init>", "(ILjava/lang/Object;Ljava/lang/String;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class i<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int ret;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String errorMsg;

    public i(int i3, @Nullable T t16, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), t16, str);
            return;
        }
        this.ret = i3;
        this.data = t16;
        this.errorMsg = str;
    }

    @Nullable
    public final T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.data;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.errorMsg;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.ret;
    }

    public final void d(@Nullable T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) t16);
        } else {
            this.data = t16;
        }
    }

    public final void e(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.errorMsg = str;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof i)) {
            return false;
        }
        i iVar = (i) other;
        if (this.ret == iVar.ret && Intrinsics.areEqual(this.data, iVar.data) && Intrinsics.areEqual(this.errorMsg, iVar.errorMsg)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.ret = i3;
        }
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int i3 = this.ret * 31;
        T t16 = this.data;
        int i16 = 0;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str = this.errorMsg;
        if (str != null) {
            i16 = str.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "LocalPhoneInnerData(ret=" + this.ret + ", data=" + this.data + ", errorMsg=" + this.errorMsg + ")";
    }
}
