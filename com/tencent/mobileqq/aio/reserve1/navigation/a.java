package com.tencent.mobileqq.aio.reserve1.navigation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/a;", "", "", "a", "I", "b", "()I", "priority", "c", "showStrResId", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavCorrelation;", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavCorrelation;", "()Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavCorrelation;", "corr", "<init>", "(IILcom/tencent/mobileqq/aio/reserve1/navigation/AIONavCorrelation;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int priority;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int showStrResId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIONavCorrelation corr;

    public a(int i3, int i16, @NotNull AIONavCorrelation corr) {
        Intrinsics.checkNotNullParameter(corr, "corr");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), corr);
            return;
        }
        this.priority = i3;
        this.showStrResId = i16;
        this.corr = corr;
    }

    @NotNull
    public final AIONavCorrelation a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIONavCorrelation) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.corr;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.priority;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.showStrResId;
    }

    public /* synthetic */ a(int i3, int i16, AIONavCorrelation aIONavCorrelation, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? -1 : i16, (i17 & 4) != 0 ? AIONavCorrelation.WEAK : aIONavCorrelation);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), aIONavCorrelation, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
