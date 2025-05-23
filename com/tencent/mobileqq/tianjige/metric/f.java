package com.tencent.mobileqq.tianjige.metric;

import androidx.collection.ArrayMap;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Map;
import mqq.app.MainService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, h> f292986a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f292986a = new ArrayMap();
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(FromServiceMsg fromServiceMsg, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (!(attribute instanceof ToServiceMsg)) {
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) attribute;
        Boolean bool = Boolean.FALSE;
        if (((Boolean) toServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue()) {
            str = "bad_network";
        } else {
            str = "normal_network";
        }
        map.put("network_strength", str);
        if (((String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY, "")).equals("IPv4")) {
            str2 = "ipv4";
        } else {
            str2 = "ipv6";
        }
        map.put("ipfamily", str2);
        if (((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IS_WIFI, bool)).booleanValue()) {
            str3 = "wifi";
        } else {
            str3 = DeviceType.DeviceCategory.MOBILE;
        }
        map.put("network_type", str3);
    }

    public static h b(int i3) {
        h hVar = f292986a.get(Integer.valueOf(i3));
        if (hVar == null) {
            synchronized (f.class) {
                hVar = f292986a.get(Integer.valueOf(i3));
                if (hVar == null) {
                    hVar = new h(i3);
                    f292986a.put(Integer.valueOf(i3), hVar);
                }
            }
        }
        return hVar;
    }

    public static h c() {
        return b(2);
    }

    public static void d(int i3, com.tencent.mobileqq.tianjige.a aVar) {
        b(i3).s(aVar);
    }
}
