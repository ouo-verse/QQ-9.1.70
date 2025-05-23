package com.tencent.qqnt.aio.palette;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/palette/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "chatType", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "<init>", "(ILandroid/os/Bundle;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle bundle;

    public a(int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bundle);
        } else {
            this.chatType = i3;
            this.bundle = bundle;
        }
    }

    @Nullable
    public final Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.bundle;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.chatType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.chatType == aVar.chatType && Intrinsics.areEqual(this.bundle, aVar.bundle)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int i3 = this.chatType * 31;
        Bundle bundle = this.bundle;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "AIOPaletteParam(chatType=" + this.chatType + ", bundle=" + this.bundle + ")";
    }
}
