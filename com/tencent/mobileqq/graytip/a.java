package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f213666d;

    /* renamed from: e, reason: collision with root package name */
    private int f213667e;

    /* renamed from: f, reason: collision with root package name */
    private String f213668f;

    /* renamed from: h, reason: collision with root package name */
    private int f213669h;

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f213666d = qQAppInterface;
        this.f213667e = ((Integer) ea.j("gray_tips_wording_id", 0)).intValue();
        this.f213668f = (String) ea.j("add_guide_gray_tips_time", "");
        this.f213669h = ((Integer) ea.j("add_guide_gray_tips_times", 0)).intValue();
    }

    private String a() {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar.get(5);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append(i16);
        sb5.append(i17);
        return sb5.toString();
    }

    public static void b(Context context, String str) {
        if (TextUtils.equals("1", str)) {
            ((ISettingApi) QRoute.api(ISettingApi.class)).startMainSettingPage(context, null);
            ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingPage(context, null);
            String str2 = "https://zb.vip.qq.com/v2/pages/withdrawMessage?_wv=2&dwop_via=" + str;
            if (VasUtil.getTempApi().isCanOpenHippyPage(HippyQQConstants.ModuleName.QQ_GXH_WIDTH_DRAW_MSG)) {
                VasUtil.getTempApi().openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_GXH_WIDTH_DRAW_MSG, "");
                return;
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str2);
            context.startActivity(intent);
            return;
        }
        if (TextUtils.equals("2", str)) {
            String str3 = "https://zb.vip.qq.com/v2/pages/withdrawMessage?_wv=2&dwop_via=" + str;
            if (VasUtil.getTempApi().isCanOpenHippyPage(HippyQQConstants.ModuleName.QQ_GXH_WIDTH_DRAW_MSG)) {
                VasUtil.getTempApi().openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_GXH_WIDTH_DRAW_MSG, "");
            } else {
                Intent intent2 = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", str3);
                context.startActivity(intent2);
            }
            e();
        }
    }

    private static void e() {
        ReportController.o(null, "dc00898", "", "", "0X800B25B", "0X800B25B", 0, 0, "", "", "", "");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f213669h++;
        String a16 = a();
        this.f213668f = a16;
        ea.y2("add_guide_gray_tips_time", a16);
        ea.y2("add_guide_gray_tips_times", Integer.valueOf(this.f213669h));
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f213667e == 0 && this.f213669h < 3) {
            if (!TextUtils.equals(this.f213668f, a())) {
                return true;
            }
        }
        return false;
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f213667e = i3;
        ea.y2("gray_tips_wording_id", Integer.valueOf(i3));
        if (QLog.isColorLevel()) {
            QLog.d("CustomizeGrayTipsManager", 2, "setGrayTipsWordingId, id = " + i3);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
