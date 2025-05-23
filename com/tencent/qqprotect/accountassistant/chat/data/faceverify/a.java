package com.tencent.qqprotect.accountassistant.chat.data.faceverify;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqprotect/accountassistant/chat/data/faceverify/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "idName", "b", "idNo", "c", "e", "temKey", "", "d", "J", "()J", "nonce", "", "[B", "()[B", "smsToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J[B)V", "qqprotect-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String idName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String idNo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String temKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long nonce;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] smsToken;

    public a(@NotNull String idName, @NotNull String idNo, @NotNull String temKey, long j3, @NotNull byte[] smsToken) {
        Intrinsics.checkNotNullParameter(idName, "idName");
        Intrinsics.checkNotNullParameter(idNo, "idNo");
        Intrinsics.checkNotNullParameter(temKey, "temKey");
        Intrinsics.checkNotNullParameter(smsToken, "smsToken");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, idName, idNo, temKey, Long.valueOf(j3), smsToken);
            return;
        }
        this.idName = idName;
        this.idNo = idNo;
        this.temKey = temKey;
        this.nonce = j3;
        this.smsToken = smsToken;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.idName;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.idNo;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.nonce;
    }

    @NotNull
    public final byte[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.smsToken;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.temKey;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.idName, aVar.idName) && Intrinsics.areEqual(this.idNo, aVar.idNo) && Intrinsics.areEqual(this.temKey, aVar.temKey) && this.nonce == aVar.nonce && Intrinsics.areEqual(this.smsToken, aVar.smsToken)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((((this.idName.hashCode() * 31) + this.idNo.hashCode()) * 31) + this.temKey.hashCode()) * 31) + androidx.fragment.app.a.a(this.nonce)) * 31) + Arrays.hashCode(this.smsToken);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "FaceVerifyUserData(idName=" + this.idName + ", idNo=" + this.idNo + ", temKey=" + this.temKey + ", nonce=" + this.nonce + ", smsToken=" + Arrays.toString(this.smsToken) + ')';
    }
}
