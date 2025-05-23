package com.tencent.common.config.provider;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface d {
    public static final IPatchRedirector $redirector_ = null;
    public static final Uri A3;
    public static final Uri B3;
    public static final Uri C3;
    public static final Uri D3;
    public static final Uri E3;
    public static final Uri v3;
    public static final Uri w3;

    /* renamed from: z3, reason: collision with root package name */
    public static final Uri f99596z3;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(41486), (Class<?>) d.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        v3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_configs");
        w3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_cookie");
        f99596z3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_update");
        A3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_delete");
        B3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_isp_config");
        C3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_check_time");
        D3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_navigator_bar");
        E3 = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/table_qz_unread");
    }
}
