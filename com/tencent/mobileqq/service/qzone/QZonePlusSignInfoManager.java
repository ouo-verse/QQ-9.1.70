package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Map;
import org.json.JSONObject;
import uq3.k;

/* loaded from: classes18.dex */
public class QZonePlusSignInfoManager {
    static IPatchRedirector $redirector_;

    public static long b() {
        return k.a().f("plus_menu_last_show_time", 0L);
    }

    public static int c() {
        int e16 = k.a().e("sign_entrance_red_dot_type", 0);
        QLog.d("QZonePlusSignInfoManager", 2, "get sign entrance red dot type is " + e16);
        return e16;
    }

    public static void d(mobile_count_rsp_new mobile_count_rsp_newVar, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZonePlusSignInfoManager", 1, "uin is null");
            return;
        }
        e();
        Map<Integer, count_info> map = mobile_count_rsp_newVar.stMapCountInfo;
        if (map == null) {
            QLog.e("QZonePlusSignInfoManager", 1, "stMapCountInfo is null, return");
            return;
        }
        if (!map.containsKey(1019)) {
            QLog.e("QZonePlusSignInfoManager", 1, "stMapCountInfo no _ENUM_QZONE_TYPE_SIGN_IN_BADGE");
            return;
        }
        count_info count_infoVar = map.get(1019);
        if (count_infoVar == null) {
            QLog.e("QZonePlusSignInfoManager", 1, "signInfo is null, return");
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.service.qzone.QZonePlusSignInfoManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) count_info.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        QZonePlusSignInfoManager.f(count_info.this);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public static void e() {
        g(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(count_info count_infoVar) {
        if (count_infoVar == null) {
            QLog.e("QZonePlusSignInfoManager", 1, "[savePlusSignConfig] signInfo is null");
            return;
        }
        i(count_infoVar.ext);
        j(count_infoVar.ext);
        h(count_infoVar.strShowMsg);
        g(true);
    }

    public static void g(boolean z16) {
        boolean z17;
        if (z16 && c() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        k.a().j("sign_entrance_has_red_dot", z17);
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("QZonePlusSignInfoManager", 2, "sign entrance red dot msg: " + str);
        k.a().p("sign_entrance_red_dot_msg", str);
    }

    public static void i(Map<String, String> map) {
        int i3;
        if (map == null) {
            QLog.e("QZonePlusSignInfoManager", 1, "[saveSignEntranceRedDotType] ext is null");
            return;
        }
        String str = map.get("type");
        if (!TextUtils.isEmpty(str)) {
            QLog.e("QZonePlusSignInfoManager", 1, "[saveSignEntranceRedDotType] type is null");
            i3 = Integer.parseInt(str);
        } else {
            i3 = 0;
        }
        k.a().m("sign_entrance_red_dot_type", i3);
    }

    public static void j(Map<String, String> map) {
        if (map == null) {
            QLog.e("QZonePlusSignInfoManager", 1, "[saveSignRedDotAttachInfo] ext is null");
            return;
        }
        String str = map.get("attach");
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZonePlusSignInfoManager", 1, "[saveSignEntranceRedDotType] attachInfo is null");
            return;
        }
        try {
            String string = new JSONObject(str).getString("last_show_badge_time");
            if (!TextUtils.isEmpty(string)) {
                Long.parseLong(string);
            }
        } catch (Exception e16) {
            QLog.e("QZonePlusSignInfoManager", 1, e16, new Object[0]);
        }
    }
}
