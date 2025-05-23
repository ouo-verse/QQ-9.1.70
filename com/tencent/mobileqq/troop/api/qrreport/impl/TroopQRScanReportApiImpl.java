package com.tencent.mobileqq.troop.api.qrreport.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.qrreport.ITroopQRScanReportApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopQRScanReportApiImpl implements ITroopQRScanReportApi {
    static IPatchRedirector $redirector_;

    public TroopQRScanReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.qrreport.ITroopQRScanReportApi
    public void troopQRScanJumpTargetDTReport(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("target_url", str2);
            hashMap.put("group_id", str);
            VideoReport.reportEvent("ev_group_qrcode_jump", hashMap);
        }
    }
}
