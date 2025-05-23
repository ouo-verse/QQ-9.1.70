package com.tencent.mobileqq.activity.recent.guidebanner;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private oidb_0x59f$Guidelines_8410 f185600a;

    /* renamed from: b, reason: collision with root package name */
    e f185601b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185601b = e.f185602a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = this.f185600a;
        if (oidb_0x59f_guidelines_8410 != null && oidb_0x59f_guidelines_8410.uint32_banner_id.has()) {
            return this.f185600a.uint32_banner_id.get();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        String str = "";
        if (this.f185600a == null) {
            return "";
        }
        if (o() && this.f185600a.str_res_url_night.has()) {
            str = this.f185600a.str_res_url_night.get();
        }
        if (TextUtils.isEmpty(str) && this.f185600a.str_res_url.has()) {
            return this.f185600a.str_res_url.get();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = this.f185600a;
        if (oidb_0x59f_guidelines_8410 != null && oidb_0x59f_guidelines_8410.uint32_jump_type.has()) {
            return this.f185600a.uint32_jump_type.get();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = this.f185600a;
        if (oidb_0x59f_guidelines_8410 == null || !oidb_0x59f_guidelines_8410.str_jump_url.has()) {
            return "";
        }
        return this.f185600a.str_jump_url.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = this.f185600a;
        if (oidb_0x59f_guidelines_8410 != null && oidb_0x59f_guidelines_8410.str_trace_info.has()) {
            return this.f185600a.str_trace_info.get();
        }
        return "";
    }

    boolean o() {
        return ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(null, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(AppRuntime appRuntime) {
        String b16 = this.f185601b.b(appRuntime.getCurrentAccountUin());
        if (!TextUtils.isEmpty(b16)) {
            try {
                Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).parse(b16);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(new Date());
                if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1)) {
                    if (calendar.get(6) == calendar2.get(6)) {
                        return true;
                    }
                }
            } catch (Throwable th5) {
                QLog.e("NewerGuideBannerModel", 1, th5, new Object[0]);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410) {
        this.f185600a = oidb_0x59f_guidelines_8410;
    }
}
