package com.tencent.mobileqq.tianjige;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;
import mqq.app.MainService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static void a(FromServiceMsg fromServiceMsg, Map<String, String> map) {
        String str;
        String str2;
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (!(attribute instanceof ToServiceMsg)) {
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) attribute;
        Boolean bool = Boolean.FALSE;
        String str3 = "0";
        if (!((Boolean) toServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue()) {
            str = "0";
        } else {
            str = "1";
        }
        map.put("isBadNetwork", str);
        if (!((String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY, "")).equals("IPv4")) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        map.put("isIPV4", str2);
        if (((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IS_WIFI, bool)).booleanValue()) {
            str3 = "1";
        }
        map.put("isWifi", str3);
        map.put("isPublic", "1");
    }

    public static void b(String str) {
        f.e(2, new a.C8649a().o("qq").m(1.0d).p(str).n(false).k());
        com.tencent.mobileqq.tianjige.metric.f.d(2, new a.C8649a().o("qq").m(1.0d).p(str).n(false).k());
    }
}
