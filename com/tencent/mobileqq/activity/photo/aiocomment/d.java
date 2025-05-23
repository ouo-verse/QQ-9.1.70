package com.tencent.mobileqq.activity.photo.aiocomment;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static boolean a(AppRuntime appRuntime, SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            QLog.i("PhotoPreviewAIOCommentLogic", 1, "isSupportCommentInPreview sessionInfo == null");
            return false;
        }
        StringBuilder sb5 = new StringBuilder("isSupportCommentInPreview sessionInfo.curType=");
        sb5.append(sessionInfo.f179555d);
        int i3 = sessionInfo.f179555d;
        if (i3 != 0 && i3 != 1) {
            QLog.i("PhotoPreviewAIOCommentLogic", 1, sb5.toString());
            return false;
        }
        if (((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_comment_send_pic")) {
            return true;
        }
        sb5.append(",switch no enable");
        QLog.i("PhotoPreviewAIOCommentLogic", 1, sb5.toString());
        return false;
    }

    public static void b(String str) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
}
