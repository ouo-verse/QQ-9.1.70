package com.tencent.mobileqq.app.identity;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static View b(final AppRuntime appRuntime, final Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("SafeUtils", 2, "init phone unity banner");
        }
        String account = appRuntime.getAccount();
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("phone_unity_banner_tips" + account, "");
        ReportController.o(appRuntime, "dc00898", "", "", "0X800B3E9", "0X800B3E9", 0, 0, "", "", "", "");
        return QUINoticeBarManager.l().h(context).setMsg(decodeString).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.app.identity.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.c(context, appRuntime, view);
            }
        }).getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, AppRuntime appRuntime, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QRoute.startUri(context, RouterConstants.UI_ROUTER_PHONE_INFO);
        ReportController.o(appRuntime, "dc00898", "", "", "0X800B3EA", "0X800B3EA", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }
}
