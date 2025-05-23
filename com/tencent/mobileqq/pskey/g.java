package com.tencent.mobileqq.pskey;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB\t\b\u0016\u00a2\u0006\u0004\b\"\u0010#B1\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010$J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/pskey/g;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", "b", "setDomain", "domain", "c", "setPskey", "pskey", "e", "setUskey", "uskey", "", "J", "()J", "setExpiredTime", "(J)V", "expiredTime", "f", "()Z", "isExpired", "<init>", "()V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Cryptor f261169g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String domain;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pskey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uskey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long expiredTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/pskey/g$a;", "", "Lcom/tencent/mobileqq/pskey/g;", "entry", "", "c", "b", "", HippyControllerProps.STRING, "a", "TAG", "Ljava/lang/String;", "Lcom/tencent/qphone/base/util/Cryptor;", "mCryptor", "Lcom/tencent/qphone/base/util/Cryptor;", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pskey.g$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final g a(@NotNull String string) {
            List split$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (g) iPatchRedirector.redirect((short) 4, (Object) this, (Object) string);
            }
            Intrinsics.checkNotNullParameter(string, "string");
            try {
                split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{"|"}, false, 0, 6, (Object) null);
                if (split$default.size() != 5) {
                    return new g();
                }
                return new g((String) split$default.get(0), (String) split$default.get(1), (String) split$default.get(2), (String) split$default.get(3), Long.parseLong((String) split$default.get(4)));
            } catch (Throwable th5) {
                QLog.e("PskeyLocalDataEntry", 1, th5, new Object[0]);
                return new g();
            }
        }

        public final boolean b(@Nullable g entry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) entry)).booleanValue();
            }
            if (c(entry)) {
                return false;
            }
            Intrinsics.checkNotNull(entry);
            return entry.f();
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        
            if (r1 == false) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean c(@Nullable g entry) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry)).booleanValue();
            }
            if (entry == null) {
                return true;
            }
            if (entry.d().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (entry.a().length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (entry.c().length() == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (entry.e().length() == 0) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                    }
                    if (entry.b() > 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35077);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
            f261169g = new Cryptor();
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.uin = "";
        this.domain = "";
        this.pskey = "";
        this.uskey = "";
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.domain;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.expiredTime;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.pskey;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.uin;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.uskey;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(g.class, other.getClass())) {
            g gVar = (g) other;
            if (Intrinsics.areEqual(this.uin, gVar.uin) && Intrinsics.areEqual(this.domain, gVar.domain) && Intrinsics.areEqual(this.pskey, gVar.pskey) && this.expiredTime == gVar.expiredTime) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (System.currentTimeMillis() > this.expiredTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        int hashCode = ((((this.uin.hashCode() * 31) + this.domain.hashCode()) * 31) + this.pskey.hashCode()) * 31;
        long j3 = this.expiredTime;
        return hashCode + ((int) (j3 ^ (j3 >>> 32)));
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.uin + "|" + this.domain + "|" + this.pskey + "|" + this.uskey + "|" + this.expiredTime;
    }

    public g(@NotNull String uin, @NotNull String domain, @NotNull String pskey, @NotNull String uskey, long j3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(pskey, "pskey");
        Intrinsics.checkNotNullParameter(uskey, "uskey");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, uin, domain, pskey, uskey, Long.valueOf(j3));
            return;
        }
        this.uin = uin;
        this.domain = domain;
        this.pskey = pskey;
        this.uskey = uskey;
        this.expiredTime = j3;
    }
}
