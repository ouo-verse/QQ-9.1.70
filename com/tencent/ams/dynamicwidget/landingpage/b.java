package com.tencent.ams.dynamicwidget.landingpage;

import NS_COMM.COMM;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/b;", "Lcom/tencent/ams/dynamicwidget/xjpage/a;", "", "b", "()Ljava/lang/String;", "tag", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class b extends com.tencent.ams.dynamicwidget.xjpage.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final b f70204c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(COMM.mini_webapp);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f70204c = new b();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    b() {
        super("landing-page-mosaic", r0);
        String str;
        if (!com.tencent.ams.dynamicwidget.c.f70185s.k()) {
            str = "landing-page-mosaic";
        } else {
            str = DKEngine.DKModuleID.XJ_PAGE;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.ams.dynamicwidget.xjpage.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "LandingPageTemplateManager";
    }
}
