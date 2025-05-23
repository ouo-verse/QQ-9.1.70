package com.tencent.mobileqq.partner.signin.drawer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/drawer/f;", "", "", "a", "J", "c", "()J", "markId", "Lcom/tencent/mobileqq/partner/signin/b;", "b", "Lcom/tencent/mobileqq/partner/signin/b;", "()Lcom/tencent/mobileqq/partner/signin/b;", "data", "", "Ljava/lang/String;", "()Ljava/lang/String;", "detailUrl", "<init>", "(JLcom/tencent/mobileqq/partner/signin/b;Ljava/lang/String;)V", "mutualmark_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long markId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.partner.signin.b data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String detailUrl;

    public f(long j3, @NotNull com.tencent.mobileqq.partner.signin.b data, @Nullable String str) {
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), data, str);
            return;
        }
        this.markId = j3;
        this.data = data;
        this.detailUrl = str;
    }

    @NotNull
    public final com.tencent.mobileqq.partner.signin.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.partner.signin.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.data;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.detailUrl;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.markId;
    }
}
