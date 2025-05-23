package com.tencent.mobileqq.leba.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static a a(String str) {
        a aVar = new a();
        aVar.f240750b = "trends_tab";
        aVar.f240751c = "trends_plugin";
        aVar.f240752d = str;
        return aVar;
    }

    public static int b(boolean z16, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (z16 && redTypeInfo != null) {
            if (redTypeInfo.red_type.get() == 0) {
                return 1;
            }
            if (redTypeInfo.red_type.get() == 5) {
                return 2;
            }
            return 3;
        }
        return 0;
    }

    public static void c(com.tencent.mobileqq.leba.entity.f fVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (fVar == null) {
            QLog.i("LebaReportUtils", 1, "reportPluginClick  reportInfo == null ");
            return;
        }
        QLog.i("LebaReportUtils", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", Long.valueOf(fVar.f240477a), Integer.valueOf(fVar.f240478b), Integer.valueOf(fVar.f240479c), Boolean.valueOf(fVar.f240480d), Integer.valueOf(fVar.f240482f)));
        if (fVar.f240480d) {
            a a16 = a("plugin_clk");
            a16.f240741i = String.valueOf(fVar.f240477a);
            a16.f240743k = String.valueOf(fVar.f240478b);
            a16.f240744l = String.valueOf(fVar.f240479c);
            a16.f240745m = String.valueOf(fVar.f240482f);
            a16.f240746n = String.valueOf(fVar.f240483g);
            a16.f240747o = ThemeUtil.getCurrentThemeId();
            a16.f240748p = "2";
            c.d(peekAppRuntime, a16);
            return;
        }
        ReportController.r(peekAppRuntime, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(fVar.f240477a), String.valueOf(fVar.f240478b), String.valueOf(fVar.f240479c), "");
    }
}
