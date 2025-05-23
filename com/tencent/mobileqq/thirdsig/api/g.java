package com.tencent.mobileqq.thirdsig.api;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/g;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "a", "[B", "()[B", PreloadTRTCPlayerParams.KEY_SIG, "b", "sigKey", "<init>", "([B[B)V", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] sig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final byte[] sigKey;

    public g(@NotNull byte[] sig, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(sig, "sig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sig, (Object) bArr);
        } else {
            this.sig = sig;
            this.sigKey = bArr;
        }
    }

    @NotNull
    public final byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sig;
    }

    @Nullable
    public final byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sigKey;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(g.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.thirdsig.api.ThirdSigInfo");
        g gVar = (g) other;
        if (!Arrays.equals(this.sig, gVar.sig)) {
            return false;
        }
        byte[] bArr = this.sigKey;
        if (bArr != null) {
            byte[] bArr2 = gVar.sigKey;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (gVar.sigKey != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int hashCode = Arrays.hashCode(this.sig) * 31;
        byte[] bArr = this.sigKey;
        if (bArr != null) {
            i3 = Arrays.hashCode(bArr);
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "ThirdSigInfo(sig=" + Arrays.toString(this.sig) + ", sigKey=" + Arrays.toString(this.sigKey) + ")";
    }
}
