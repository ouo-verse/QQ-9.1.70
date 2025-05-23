package com.tencent.nativepreview.service;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0017J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/nativepreview/service/Reporter;", "Lcom/tencent/nativepreview/service/IReporter;", "()V", "proxy", "report", "", "tag", "", "name", "time", "", QCircleWeakNetReporter.KEY_COST, "extraInfo", "setProxy", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class Reporter implements IReporter {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Reporter INSTANCE;

    @Nullable
    private static IReporter proxy;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15342);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Reporter();
        }
    }

    Reporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.nativepreview.service.IReporter
    @Keep
    public void report(@NotNull String tag, @NotNull String name, long time, long cost, @NotNull String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tag, name, Long.valueOf(time), Long.valueOf(cost), extraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        IReporter iReporter = proxy;
        if (iReporter == null) {
            b.f337874a.report(tag, name, time, cost, extraInfo);
        } else {
            Intrinsics.checkNotNull(iReporter);
            iReporter.report(tag, name, time, cost, extraInfo);
        }
    }

    public final void setProxy(@NotNull IReporter proxy2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) proxy2);
        } else {
            Intrinsics.checkNotNullParameter(proxy2, "proxy");
            proxy = proxy2;
        }
    }
}
