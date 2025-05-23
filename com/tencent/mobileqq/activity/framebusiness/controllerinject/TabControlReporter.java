package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TabControlReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static e f182336a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            f182336a = l.f182354a.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("TabControlReporter", 1, "TabUIHelper static statement: ", e16);
        }
    }

    static /* synthetic */ String b() {
        return c();
    }

    private static String c() {
        int modelType = TabDataHelper.getModelType();
        if (modelType != 2) {
            if (modelType != 3) {
                return "\u9ed8\u8ba4\u6a21\u5f0f";
            }
            return "\u9752\u5c11\u5e74\u6a21\u5f0f";
        }
        return "\u7b80\u6d01\u6a21\u5f0f";
    }

    private static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TabControlReporter", 1, "getDlgFirstClkReportType error: configStr is empty");
            return 0;
        }
        if (str.contains("\u201c\u9891\u9053\u201d") && str.contains(n.c())) {
            return 3;
        }
        if (str.contains(n.c())) {
            return 1;
        }
        if (!str.contains("\u201c\u9891\u9053\u201d")) {
            return 0;
        }
        return 2;
    }

    private static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TabControlReporter", 1, "getDlgShowReportType error: configStr is empty");
            return 0;
        }
        if (str.contains(TabDataHelper.TAB_NEW_WORLD) && str.contains("GUILD")) {
            return 3;
        }
        if (str.contains(TabDataHelper.TAB_NEW_WORLD)) {
            return 1;
        }
        if (!str.contains("GUILD")) {
            return 0;
        }
        return 2;
    }

    private static String f(String str) {
        return f182336a.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(String str) {
        return f182336a.f(str);
    }

    public static void h(int i3, int i16, int i17, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_push_from", Integer.valueOf(i3));
        hashMap.put("sgrp_push_id", Integer.valueOf(i16));
        hashMap.put("sgrp_switch_type", Integer.valueOf(i17));
        hashMap.put("sgrp_push_uin", str);
        VideoReport.reportEvent("ev_sgrp_channel_tab_push_type", hashMap);
        QLog.d("TabControlReporter", 1, "reportDT reportEvent sgrp_push_id: " + i16 + " sgrp_switch_type: " + i17);
    }

    public static void i(FrameFragment frameFragment, String str, int i3, boolean z16) {
        String str2;
        String str3;
        if (frameFragment != null && !TextUtils.isEmpty(f(str))) {
            boolean booleanValue = frameFragment.hasRedBadge(f(str)).booleanValue();
            int g16 = g(str);
            if (z16) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            String str4 = str2;
            String str5 = i3 + "";
            String c16 = c();
            if (booleanValue) {
                str3 = "\u6709\u7ea2\u70b9";
            } else {
                str3 = "\u65e0\u7ea2\u70b9";
            }
            ReportController.o(null, "dc00898", "", "", "0X800BE00", "0X800BE00", g16, 0, str5, str4, c16, str3);
        }
    }

    public static void j(String str, boolean z16) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e("TabControlReporter", 1, "reportTabDlgFirstClk error: displayName is empty");
            return;
        }
        int d16 = d(str);
        if (z16) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0X800BE09", "0X800BE09", d16, 0, str2, "", "", "");
    }

    public static void k(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TabControlReporter", 1, "reportTabDlgFirstShow error: configStr is empty");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800BE08", "0X800BE08", e(str), 0, "", "", "", "");
        }
    }

    public static void l(boolean z16, boolean z17) {
        String str;
        String str2;
        if (z17) {
            if (z16) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            ReportController.o(null, "dc00898", "", "", "0X800BE8C", "0X800BE8C", 0, 0, str2, "", "", "");
            return;
        }
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0X800BE83", "0X800BE83", 0, 0, str, "", "", "");
    }

    public static void m(boolean z16) {
        if (z16) {
            ReportController.o(null, "dc00898", "", "", "0X800BE8B", "0X800BE8B", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800BE82", "0X800BE82", 0, 0, "", "", "", "");
        }
    }

    public static void n(boolean z16) {
        String str;
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0X800BE81", "0X800BE81", 0, 0, str, "", "", "");
    }

    public static void o() {
        ReportController.o(null, "dc00898", "", "", "0X800BE80", "0X800BE80", 0, 0, "", "", "", "");
    }

    public static void p(String str, int i3) {
        ReportController.o(null, "dc00898", "", "", "0X800BE01", "0X800BE01", g(str), 0, i3 + "", "", "", "");
    }

    public static void q(FrameFragment.d dVar, ArrayList<FrameFragment.e> arrayList) {
        if (dVar != null && arrayList != null) {
            ThreadManagerV2.excute(new Runnable(new ArrayList(arrayList), dVar.getCurrentTab()) { // from class: com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlReporter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f182337d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f182338e;

                {
                    this.f182337d = r4;
                    this.f182338e = r5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    for (int i3 = 0; i3 < this.f182337d.size(); i3++) {
                        FrameFragment.e eVar = (FrameFragment.e) this.f182337d.get(i3);
                        if (eVar != null) {
                            int g16 = TabControlReporter.g(eVar.getTag());
                            String b16 = TabControlReporter.b();
                            if (this.f182338e == i3) {
                                str = "\u9009\u4e2d";
                            } else {
                                str = "\u975e\u9009\u4e2d";
                            }
                            ReportController.o(null, "dc00898", "", "", "0X800BE2B", "0X800BE2B", g16, 0, "", "", b16, str);
                        }
                    }
                }
            }, 16, null, true);
        }
    }
}
