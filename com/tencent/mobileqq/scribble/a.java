package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f282540a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f282541b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f282542c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f282543d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f282544e;

    /* renamed from: f, reason: collision with root package name */
    public static final Long f282545f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SCRIBBLE_FILE_DIR;
        sb5.append(str);
        sb5.append("Config/");
        f282540a = sb5.toString();
        f282541b = str + "Config/paint/";
        f282542c = str + "Config/gif/";
        f282543d = str + "Config/line_icon/";
        f282544e = str + "Config/gif_icon/";
        f282545f = 30000L;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
