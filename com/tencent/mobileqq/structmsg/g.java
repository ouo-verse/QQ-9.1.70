package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface g {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: l4, reason: collision with root package name */
    public static final String f290419l4;

    /* renamed from: m4, reason: collision with root package name */
    public static final String f290420m4;

    /* renamed from: n4, reason: collision with root package name */
    public static final String f290421n4;

    /* renamed from: o4, reason: collision with root package name */
    public static final String f290422o4;

    /* renamed from: q4, reason: collision with root package name */
    public static final String f290423q4;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(43615), (Class<?>) g.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        f290419l4 = HardCodeUtil.qqStr(R.string.twb);
        f290420m4 = HardCodeUtil.qqStr(R.string.f172743tw4);
        f290421n4 = HardCodeUtil.qqStr(R.string.tvx);
        f290422o4 = HardCodeUtil.qqStr(R.string.tw8);
        f290423q4 = AppConstants.SDCARD_PATH + "photo/temp/";
    }
}
