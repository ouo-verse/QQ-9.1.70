package com.tencent.mobileqq.redtouch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes17.dex */
public class RedPointBroadcastReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f280245a;

    public RedPointBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f280245a = null;
        }
    }

    private void a(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("RedPointBroadcastReceiver clearRed", 2, "path = " + str);
        }
        ((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(str);
    }

    private String b(String str) {
        int i3;
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo;
        if (QLog.isColorLevel()) {
            QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "path = " + str);
        }
        QQAppInterface qQAppInterface = this.f280245a;
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "qqapp = null");
            }
            return null;
        }
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(str);
        if (appInfoByPath == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "appinfo = null");
            }
            return null;
        }
        int i16 = appInfoByPath.iNewFlag.get();
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfoByPath.red_display_info.red_type_info.get();
        if (list != null && list.size() >= 2 && (redTypeInfo = list.get(1)) != null) {
            i3 = redTypeInfo.red_type.get();
        } else {
            i3 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("iNewFlag", i16);
            jSONObject.put("type", i3);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "jsonexception");
            }
            return null;
        }
    }

    private void c(QQAppInterface qQAppInterface, String str, int i3) {
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("RedPointBroadcastReceiver reportRedInfo", 2, "path = " + str);
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
            IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f280245a.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(str);
            jSONObject.put("service_type", 0);
            jSONObject.put("act_id", i3);
            jSONObject.put(QCircleQualityReporter.KEY_OBJ_ID, "");
            jSONObject.put("pay_amt", 0);
            jSONObject.put("service_id", i16);
            iRedTouchManager.onReportBusinessRedTouch(appInfoByPath, jSONObject.toString());
        } catch (JSONException e17) {
            QLog.e("RedPointBroadcastReceiver", 1, "report redinfo error " + e17);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof QQAppInterface) {
            this.f280245a = (QQAppInterface) waitAppRuntime;
        }
        String action = intent.getAction();
        if ("com.tencent.redpoint.get".equals(action)) {
            intent.setAction("com.tencent.redpoint.get.resp");
            if (this.f280245a != null) {
                intent.putExtra("redPointResp", b(intent.getStringExtra("path")));
                this.f280245a.getApplication().sendBroadcast(intent);
                return;
            } else {
                intent.putExtra("redPointResp", "");
                waitAppRuntime.getApplication().sendBroadcast(intent);
                return;
            }
        }
        if ("com.tencent.redpoint.report".equals(action)) {
            if (this.f280245a != null) {
                c(this.f280245a, intent.getStringExtra("path"), intent.getIntExtra(GameCenterCommonApiImpl.KEY_ACT_ID, 1001));
                return;
            }
            return;
        }
        if ("com.tencent.redpoint.clear".equals(action) && this.f280245a != null) {
            a(this.f280245a, intent.getStringExtra("path"));
        }
    }
}
