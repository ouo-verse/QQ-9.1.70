package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f280292d;

    /* renamed from: e, reason: collision with root package name */
    public String f280293e;

    /* renamed from: f, reason: collision with root package name */
    public int f280294f;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f280292d = "";
        this.f280293e = "";
        this.f280294f = 1001;
    }

    private void e(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("GetRedPointInfoReq clearRed", 2, "path = " + str);
        }
        ((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(str);
    }

    private RedAppInfo f(String str, QQAppInterface qQAppInterface) {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        if (QLog.isColorLevel()) {
            QLog.d("GetRedPointInfoReq getRedPointInfo", 2, "path = " + str);
        }
        if ("7720.772004".equals(str)) {
            appInfoByPath = MatchChatMsgUtil.c(qQAppInterface, str);
        } else {
            appInfoByPath = ((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(str);
        }
        return g.a(appInfoByPath);
    }

    private void g(QQAppInterface qQAppInterface, String str, int i3) {
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("GetRedPointInfoReq reportRedInfo", 2, "path = " + str + "actId == " + i3);
        }
        if (str == null) {
            return;
        }
        try {
            if (str.contains("\\.")) {
                i16 = Integer.parseInt(str.split("\\.")[0]);
            } else {
                i16 = Integer.parseInt(str);
            }
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            i16 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(str);
            jSONObject.put("service_type", 0);
            jSONObject.put(GameCenterCommonApiImpl.KEY_ACT_ID, i3);
            jSONObject.put(QCircleQualityReporter.KEY_OBJ_ID, "");
            jSONObject.put("pay_amt", 0);
            jSONObject.put("service_id", i16);
            iRedTouchManager.onReportBusinessRedTouch(appInfoByPath, jSONObject.toString());
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.redtouch.b, com.tencent.mobileqq.redtouch.a
    public void a(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.a(bundle);
        this.f280292d = bundle.getString("path");
        this.f280294f = bundle.getInt("act_id");
        this.f280293e = bundle.getString("reportPath");
    }

    @Override // com.tencent.mobileqq.redtouch.b
    public void d(QQAppInterface qQAppInterface, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) bundle);
            return;
        }
        String string = bundle.getString("cmd");
        if ("getRedInfo".equals(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + string);
            }
            RedAppInfo f16 = f(this.f280292d, qQAppInterface);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("redInfoResp", f16);
            bundle.putBundle("keyResponse", bundle2);
            super.b(bundle);
            return;
        }
        if ("reportRedInfo".equals(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + string);
            }
            g(qQAppInterface, this.f280292d, this.f280294f);
            return;
        }
        if ("clearRedInfo".equals(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + string);
            }
            e(qQAppInterface, this.f280292d);
        }
    }
}
