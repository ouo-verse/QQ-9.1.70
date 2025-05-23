package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class t extends com.tencent.mobileqq.troop.api.config.s {
    static IPatchRedirector $redirector_;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.s
    public void a(@NonNull AppInterface appInterface, @NonNull ToServiceMsg toServiceMsg, String str, @NonNull oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, toServiceMsg, str, oidb_sso_oidbssopkg);
            return;
        }
        oidb_cmd0xb36$RspBody oidb_cmd0xb36_rspbody = new oidb_cmd0xb36$RspBody();
        try {
            oidb_cmd0xb36_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            ((IBizTroopInfoService) appInterface.getRuntimeService(IBizTroopInfoService.class, "")).updateTroopSurveyList(oidb_cmd0xb36_rspbody);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handle_oidb_0xb36_1:", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.s
    public void b(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.test.groupDragon", "", "UpdateDragonTitle", jSONObject.toString());
                ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.groupDragon", "", "UpdateDragonTitle", jSONObject.toString());
            } catch (UnsatisfiedLinkError e16) {
                QLog.e(LogTag.TAG_TROOP_SURVEY, 2, "Error: arkNotify com.tencent.groupDragon error, .so notloaded", e16);
            }
        } catch (JSONException e17) {
            QLog.e(LogTag.TAG_TROOP_SURVEY, 2, "Error: json decode error, string is " + str, e17);
        }
    }
}
