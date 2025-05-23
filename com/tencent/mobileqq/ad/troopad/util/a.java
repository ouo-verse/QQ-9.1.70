package com.tencent.mobileqq.ad.troopad.util;

import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R,\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\n0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR,\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t \u000b*\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\n0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/ad/troopad/util/a;", "", "", "a", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "b", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mProcessorProxy", "", "", "", "kotlin.jvm.PlatformType", "c", "Ljava/util/Set;", "mOriginExpoReportedData", "d", "mValidExpoReportedData", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f186952a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GdtThirdProcessorProxy mProcessorProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mOriginExpoReportedData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mValidExpoReportedData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f186952a = new a();
        mProcessorProxy = new GdtThirdProcessorProxy();
        mOriginExpoReportedData = Collections.synchronizedSet(new HashSet());
        mValidExpoReportedData = Collections.synchronizedSet(new HashSet());
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            mOriginExpoReportedData.clear();
            mValidExpoReportedData.clear();
        }
    }
}
