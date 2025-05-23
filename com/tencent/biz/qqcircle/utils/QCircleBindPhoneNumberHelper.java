package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.beans.QFSIdentityBean;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;

/* loaded from: classes5.dex */
public class QCircleBindPhoneNumberHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements AccountIdentityCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f92525a;

        a(boolean z16) {
            this.f92525a = z16;
        }

        @Override // com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack
        public void onSuccess(boolean z16, String str) {
            int i3;
            int i16 = 2;
            if ((str != null && str.trim().length() > 0) || z16) {
                com.tencent.biz.qqcircle.f v3 = com.tencent.biz.qqcircle.f.v();
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                v3.T(i3);
                v3.P(str);
                QLog.i("QCircleBindPhoneNumberHelper", 1, "refreshAccountState  getAccountIdentitySuccess  isAuthenticated : " + z16 + "  \uff0c url \uff1a " + str);
            }
            if (this.f92525a) {
                QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(4);
                if (z16) {
                    i16 = 1;
                }
                QCircleLpReportDc05504.report(subActionType.setThrActionType(i16));
            }
        }
    }

    public static boolean a() {
        return true;
    }

    public static void b(Context context, int i3) {
        QFSIdentityBean qFSIdentityBean = new QFSIdentityBean();
        qFSIdentityBean.setSource(i3);
        com.tencent.biz.qqcircle.launcher.c.Q(context, qFSIdentityBean);
    }

    public static void c(boolean z16) {
        QLog.i("QCircleBindPhoneNumberHelper", 1, "refreshAccountState  isBackFromH5 : " + z16);
        HostStaticInvokeHelper.sendQCircleAccountIdentityRequest(new a(z16));
    }

    public static void d() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.qqcircle.f v3 = com.tencent.biz.qqcircle.f.v();
                if (v3 != null && v3.w() == 1) {
                    return;
                }
                QCircleBindPhoneNumberHelper.c(false);
            }
        });
    }
}
