package com.tencent.mobileqq.leba.report;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    static d f240756c;

    /* renamed from: a, reason: collision with root package name */
    long f240757a;

    /* renamed from: b, reason: collision with root package name */
    IGuardInterface f240758b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                d.this.f240757a = d.b();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f240756c = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240757a = b();
        a aVar = new a();
        this.f240758b = aVar;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(aVar);
        } else {
            QLog.e("Leba.DaTong", 1, "LebaDaTong construct GuardManager.sInstance is null");
        }
    }

    public static String a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "other";
                    }
                    return "little_red_dot";
                }
                return "num_red_dot";
            }
            return "little_red_dot";
        }
        return "";
    }

    static long b() {
        return System.currentTimeMillis();
    }

    public static d c() {
        return f240756c;
    }

    public static String d(n nVar) {
        LebaPluginInfo lebaPluginInfo;
        if (nVar == null) {
            return "default";
        }
        int i3 = nVar.f240507d;
        if (i3 == 2) {
            return "more";
        }
        if (i3 != 1 || (lebaPluginInfo = nVar.f240505b) == null) {
            return "default";
        }
        return lebaPluginInfo.getDaTongID();
    }

    public static String e() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return "simple";
        }
        return "default";
    }

    public static void g(View view, n nVar, int i3, String str) {
        if (str != null && view != null) {
            VideoReport.setElementReuseIdentifier(view, str);
            j(view, nVar, i3 + 1);
            TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
            u(view, String.valueOf(companion.g(str)), companion.f(str));
        }
    }

    public static void h(View view) {
        if (view == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Leba.DaTong", 4, "reportExposure, view=" + view.toString());
        }
        VideoReport.reportEvent("imp", view, null);
    }

    public static void i(View view, n nVar) {
        k(view, d(nVar));
    }

    public static void j(View view, n nVar, int i3) {
        l(view, d(nVar), i3);
    }

    static void k(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_discover_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "discover_feature_name", str);
        VideoReport.setElementParam(view, "is_red_tips_em", "0");
        VideoReport.setElementParam(view, "qq_red_tips_type", "no_red_dot");
        VideoReport.setElementParam(view, "discover_sequence_em", 1);
    }

    public static void l(View view, String str, int i3) {
        if (view == null) {
            return;
        }
        k(view, str);
        VideoReport.setElementParam(view, "discover_sequence_em", Integer.valueOf(i3));
    }

    public static void m(View view) {
        VideoReport.setElementId(view, "em_discover_compile_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void n(Activity activity, View view, boolean z16) {
        if (view == null) {
            return;
        }
        q(activity, view, "pg_bas_dynamic_mode_selection");
        x(view, z16);
    }

    public static void o(View view, boolean z16, String str) {
        String str2;
        if (z16) {
            str2 = "em_discover_del_button";
        } else {
            str2 = "em_discover_add_button";
        }
        VideoReport.setElementId(view, str2);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "discover_feature_name", str);
    }

    public static void p(View view, String str) {
        VideoReport.setElementId(view, "em_discover_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "discover_feature_name", str);
    }

    public static void q(Activity activity, View view, String str) {
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, "qq_session_id", c().f());
        VideoReport.setPageParams(view, QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, e());
        VideoReport.setPageParams(view, "SourceID", "");
        if (QLog.isDevelopLevel()) {
            QLog.d("Leba.DaTong", 4, "set da-tong page param, page-id=" + str + ", view=" + view + ", session-id=" + c().f() + ", qq-mode=" + e());
        }
    }

    public static void r(Activity activity, View view, String str, boolean z16) {
        String str2;
        if (view == null) {
            return;
        }
        q(activity, view, str);
        QLog.d("Leba.DaTong", 4, "set da-tong page param, isAvatarDisplay= " + z16);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        VideoReport.setPageParams(view, "is_avatar_display", str2);
    }

    public static void s(Activity activity, View view, String str, boolean z16, String str2) {
        if (view == null) {
            return;
        }
        r(activity, view, str, z16);
        VideoReport.setPageParams(view, QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, str2);
    }

    public static void t(View view, int i3) {
        if (view == null) {
            return;
        }
        if (TianshuRedTouch.INSTANCE.j()) {
            u(view, "", String.valueOf(i3));
        } else {
            u(view, "", a(i3));
        }
    }

    public static void u(View view, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            VideoReport.setElementParam(view, "is_red_tips_em", "0");
            VideoReport.setElementParam(view, "qq_red_tips_type", "no_red_dot");
        } else {
            VideoReport.setElementParam(view, "is_red_tips_em", str);
            VideoReport.setElementParam(view, "qq_red_tips_type", str2);
        }
    }

    public static void v(Activity activity, View view, String str) {
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static void w(View view, boolean z16, String str) {
        String str2;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_type_selection");
        if (z16) {
            str2 = "feeds";
        } else {
            str2 = "list";
        }
        VideoReport.setElementParam(view, "type_selection", str2);
        VideoReport.setElementParam(view, "type_selection_zplan_avatar", str);
    }

    public static void x(@NonNull View view, boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        VideoReport.setPageParams(view, "current_mode", Integer.valueOf(i3));
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.valueOf(this.f240757a);
    }
}
