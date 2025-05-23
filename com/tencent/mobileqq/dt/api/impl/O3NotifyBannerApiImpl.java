package com.tencent.mobileqq.dt.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.dt.api.IO3NotifyBannerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class O3NotifyBannerApiImpl implements IO3NotifyBannerApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "O3NotifyBannerApiImpl";

    public O3NotifyBannerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private long getStrategyIdFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "url is empty");
            return 0L;
        }
        JumpParserResult parseUrl = ((ISchemeApi) QRoute.api(ISchemeApi.class)).parseUrl(str);
        if (parseUrl == null) {
            QLog.e(TAG, 1, "parse url error " + str);
            return 0L;
        }
        try {
            return Long.parseLong(parseUrl.getParamMap().get("gray_tip_id"));
        } catch (NumberFormatException unused) {
            QLog.e(TAG, 1, "parse strategy error " + str);
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.dt.api.IO3NotifyBannerApi
    public void onNotifyBannerClick(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i(TAG, 1, "onNotifyBannerCreate " + str2 + "::" + i3);
        HashMap hashMap = new HashMap();
        hashMap.put("sc_strategy_id", Long.valueOf(getStrategyIdFromUrl(str)));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, str2);
        hashMap.put("aio_type", Integer.valueOf(i3));
        hashMap.put("after_click_state", Integer.valueOf(i16));
        VideoReport.reportEvent("ev_bas_aio_secure_msg_clck", hashMap);
    }

    @Override // com.tencent.mobileqq.dt.api.IO3NotifyBannerApi
    public void onNotifyBannerCreate(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
            return;
        }
        QLog.i(TAG, 1, "onNotifyBannerCreate " + str2 + "::" + i3);
        HashMap hashMap = new HashMap();
        hashMap.put("sc_strategy_id", Long.valueOf(getStrategyIdFromUrl(str)));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, str2);
        hashMap.put("aio_type", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_bas_aio_secure_msg_imp", hashMap);
    }
}
