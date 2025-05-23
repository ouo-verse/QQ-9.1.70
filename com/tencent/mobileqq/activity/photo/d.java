package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import cooperation.peak.PeakConstants;

/* compiled from: P */
@Deprecated
/* loaded from: classes10.dex */
public interface d {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final int f184448a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f184449b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f184450c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f184451d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f184452e;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(37470), (Class<?>) d.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        f184448a = PeakConstants.Menu.MENU_WATERMARK;
        f184449b = PeakConstants.Menu.MENU_DOODLE;
        f184450c = PeakConstants.Menu.MENU_CUT_AND_ROTATE;
        f184451d = PeakConstants.Menu.MENU_SEND_NOMAL;
        f184452e = PeakConstants.Menu.MENU_SEND_RAW;
    }
}
