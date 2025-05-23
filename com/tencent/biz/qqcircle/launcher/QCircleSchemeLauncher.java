package com.tencent.biz.qqcircle.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.utils.k;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.e;
import com.tencent.biz.qqcircle.launcher.parser.g;
import com.tencent.biz.qqcircle.launcher.parser.h;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bx;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSchemeLauncher {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, com.tencent.biz.qqcircle.launcher.parser.a> f91381a;

    static {
        HashMap hashMap = new HashMap();
        f91381a = hashMap;
        hashMap.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL, new QCircleContentDetailSchemeParser());
        hashMap.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_MAIN_PAGE, new e());
        hashMap.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_SHARE_CONTENT_DETAIL, new QCircleContentDetailSchemeParser());
        hashMap.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_SHARE_MAIN_PAGE, new e());
        hashMap.put(QCircleScheme.Q_CIRCLE_WATERFALL, new h());
        hashMap.put(QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_WEBVIEW, new com.tencent.biz.qqcircle.launcher.parser.d());
    }

    public static QCircleInitBean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QCircleSchemeLauncher", 1, "[getInitBeanUseScheme] scheme is empty");
            return null;
        }
        if (context == null) {
            QLog.e("QCircleSchemeLauncher", 1, "[getInitBeanUseScheme] context == null, use RFWApplication");
            context = RFWApplication.getApplication();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e("QCircleSchemeLauncher", 1, "[getInitBeanUseScheme] appRuntime not instanceof BaseQQAppInterfac, scheme = " + str);
            return null;
        }
        ax c16 = bi.c((BaseQQAppInterface) peekAppRuntime, context, str);
        if (c16 == null) {
            QLog.e("QCircleSchemeLauncher", 1, "[getInitBeanUseScheme] jumpAction == null, scheme = " + str);
            return null;
        }
        String str2 = c16.f307440e;
        com.tencent.biz.qqcircle.launcher.parser.a aVar = f91381a.get(str2);
        if (aVar == null) {
            QLog.e("QCircleSchemeLauncher", 1, "[getInitBeanUseScheme] parser == null, scheme = " + str);
            return null;
        }
        if (aVar instanceof QCircleContentDetailSchemeParser) {
            return ((QCircleContentDetailSchemeParser) aVar).K(new QCircleSchemeBean().setSchemeAction(str2).setAttrs(c16.f307441f));
        }
        if (aVar instanceof com.tencent.biz.qqcircle.launcher.parser.c) {
            return ((com.tencent.biz.qqcircle.launcher.parser.c) aVar).o(c16.f307441f, new QCircleSchemeBean().setSchemeAction(str2).setAttrs(c16.f307441f));
        }
        if (aVar instanceof com.tencent.biz.qqcircle.launcher.parser.d) {
            return ((com.tencent.biz.qqcircle.launcher.parser.d) aVar).q(c16.f307441f, new QCircleSchemeBean().setSchemeAction(str2).setAttrs(c16.f307441f));
        }
        if (!(aVar instanceof g)) {
            return null;
        }
        return ((g) aVar).q(new QCircleSchemeBean().setSchemeAction(str2).setAttrs(c16.f307441f));
    }

    public static boolean b(Context context, QCircleSchemeBean qCircleSchemeBean) {
        String schemeAction = qCircleSchemeBean.getSchemeAction();
        QLog.d("QCircleSchemeLauncher", 1, "launchQCircleByScheme actionName" + schemeAction);
        if (TextUtils.isEmpty(schemeAction)) {
            return false;
        }
        com.tencent.biz.qqcircle.launcher.parser.a aVar = f91381a.get(schemeAction);
        if (aVar == null) {
            QLog.e("QCircleSchemeLauncher", 1, "parser is null");
            c(context);
            return true;
        }
        aVar.f(context, qCircleSchemeBean);
        return true;
    }

    private static void c(final Context context) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(context, 1, k.g(), 0).show();
            }
        });
    }

    public static void d(Context context, String str) {
        if (c.b(context, str)) {
            return;
        }
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
    }

    public static void e(Context context, QCircleSchemeBean qCircleSchemeBean) {
        h(qCircleSchemeBean);
        if (g(qCircleSchemeBean)) {
            QCircleToast.m(QCircleToast.f91644d, context.getResources().getString(R.string.f185153nt), 0, true, true, 150L, 0);
            QLog.e("QCircleSchemeLauncher", 1, "not start is study mode");
        } else {
            if (b(context, qCircleSchemeBean)) {
                i(qCircleSchemeBean);
            }
            bx.e();
        }
    }

    public static void f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QCircleSchemeLauncher", 1, "launchH5OrScheme url is empty");
        } else if (!str.startsWith("http") && !str.startsWith("https")) {
            d(context, str);
        } else {
            c.o0(context, str, null, -1);
        }
    }

    private static boolean g(QCircleSchemeBean qCircleSchemeBean) {
        if ((QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE.equals(qCircleSchemeBean.getSchemeAction()) && !uq3.c.U6()) || !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        if (qCircleSchemeBean.getAttrs() != null && "1".equals(qCircleSchemeBean.getAttrs().get("childmode"))) {
            return false;
        }
        return true;
    }

    private static void h(final QCircleSchemeBean qCircleSchemeBean) {
        if (qCircleSchemeBean != null) {
            QCircleDTLoginReporter.jointScheme(qCircleSchemeBean.getSchemeAction(), qCircleSchemeBean.getAttrs());
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher.2
            @Override // java.lang.Runnable
            public void run() {
                QCircleSchemeBean qCircleSchemeBean2 = QCircleSchemeBean.this;
                if (qCircleSchemeBean2 != null && qCircleSchemeBean2.getAttrs() != null) {
                    if (QCircleSchemeBean.this.getAttrs().containsKey("hydtgzh")) {
                        QCircleHostLauncher.reportDC02880(2, 2, null, QCircleSchemeBean.this.getAttrs().get("hydtgzh"), QCircleSchemeBean.this.getAttrs().get("reverses6"));
                    }
                    QCircleDTLoginReporter.daTongLoginReport(QCircleSchemeBean.this.getSchemeAction(), QCircleSchemeBean.this.getAttrs());
                }
            }
        });
    }

    private static void i(@Nullable QCircleSchemeBean qCircleSchemeBean) {
        HashMap<String, String> attrs;
        if (qCircleSchemeBean != null && (attrs = qCircleSchemeBean.getAttrs()) != null) {
            String str = attrs.get(QCircleSchemeAttr.BaseKey.XSJ_SHORT_SESSION_ID);
            if (!TextUtils.isEmpty(str)) {
                QLog.i("QCircleSchemeLauncher", 1, "updateNativeSession, shortSessionId =" + str);
                QCircleNativeSessionManager.g().updateSession(str);
            }
        }
    }
}
