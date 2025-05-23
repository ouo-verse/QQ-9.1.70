package com.tencent.qne.delegate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qne/delegate/e;", "", "Lorg/json/JSONObject;", "f", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "errorCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMessage", "c", "d", "remoteUrl", "localPath", "", "e", "J", "()J", "specificTaskId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errorMessage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String remoteUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String localPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long specificTaskId;

    public e(int i3, @NotNull String errorMessage, @Nullable String str, @Nullable String str2, long j3) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errorMessage, str, str2, Long.valueOf(j3));
            return;
        }
        this.errorCode = i3;
        this.errorMessage = errorMessage;
        this.remoteUrl = str;
        this.localPath = str2;
        this.specificTaskId = j3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.errorMessage;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.localPath;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.remoteUrl;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.specificTaskId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (this.errorCode == eVar.errorCode && Intrinsics.areEqual(this.errorMessage, eVar.errorMessage) && Intrinsics.areEqual(this.remoteUrl, eVar.remoteUrl) && Intrinsics.areEqual(this.localPath, eVar.localPath) && this.specificTaskId == eVar.specificTaskId) {
            return true;
        }
        return false;
    }

    @NotNull
    public final JSONObject f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("specificTaskId", e());
        jSONObject.put("remoteUrl", d());
        return jSONObject;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        int hashCode2 = ((this.errorCode * 31) + this.errorMessage.hashCode()) * 31;
        String str = this.remoteUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.localPath;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i16 + i3) * 31) + androidx.fragment.app.a.a(this.specificTaskId);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "ShiplyResult(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", remoteUrl=" + ((Object) this.remoteUrl) + ", localPath=" + ((Object) this.localPath) + ", specificTaskId=" + this.specificTaskId + ')';
    }

    public /* synthetic */ e(int i3, String str, String str2, String str3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : str3, (i16 & 16) != 0 ? 0L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, Long.valueOf(j3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
