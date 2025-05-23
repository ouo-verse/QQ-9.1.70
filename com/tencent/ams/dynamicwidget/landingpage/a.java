package com.tencent.ams.dynamicwidget.landingpage;

import android.annotation.SuppressLint;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/a;", "Lcom/tencent/ams/dynamicwidget/b;", "", "f", "()Ljava/lang/String;", "tag", "getModuleId", "moduleId", "getAdType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class a extends com.tencent.ams.dynamicwidget.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final a f70203f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17881);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f70203f = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.ams.dynamicwidget.b
    @NotNull
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "LandingPageEngineHelper";
    }

    @Override // com.tencent.ams.dynamicwidget.f
    @NotNull
    public String getAdType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "2";
    }

    @Override // com.tencent.ams.dynamicwidget.f
    @NotNull
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (com.tencent.ams.dynamicwidget.c.f70185s.k()) {
            return DKEngine.DKModuleID.XJ_PAGE;
        }
        return "landing-page-mosaic";
    }
}
