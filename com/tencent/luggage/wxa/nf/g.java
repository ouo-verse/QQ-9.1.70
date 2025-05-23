package com.tencent.luggage.wxa.nf;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 1056;
    public static final String NAME = "getIPAddress";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f135790a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f135791b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f135790a = dVar;
            this.f135791b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            long a16 = w0.a();
            if (!k.a(this.f135790a.getContext(), this.f135790a, "android.permission.ACCESS_FINE_LOCATION")) {
                this.f135790a.a(this.f135791b, g.this.makeReturnJson("fail:may be not obtain GPS Perrmission"));
                w.b("MicroMsg.JsApiGetIPAddress", "wifiInfo is empty, may be not obtain GPS Perrmission");
                return;
            }
            String a17 = g.this.a(this.f135790a.getContext());
            String b16 = q.b(q.b(a17));
            long e16 = w0.e(a16);
            w.d("MicroMsg.JsApiGetIPAddress", "localip:%s,netmask:%s,cost:%d", a17, b16, Long.valueOf(e16));
            HashMap hashMap = new HashMap();
            hashMap.put("localip", a17);
            hashMap.put("netmask", b16);
            hashMap.put(QCircleWeakNetReporter.KEY_COST, Long.valueOf(e16));
            this.f135790a.a(this.f135791b, g.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    public String a(Context context) {
        String str;
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            try {
                int ipAddress = NetworkMonitor.getIpAddress((WifiInfo) com.tencent.luggage.wxa.ia.a.a(wifiManager, "com/tencent/mm/plugin/appbrand/jsapi/network/JsApiGetIPAddress", "getLocalIPAddress", "(Landroid/content/Context;)Ljava/lang/String;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;"));
                String c16 = q.c(ipAddress);
                DhcpInfo dhcpInfo = NetworkMonitor.getDhcpInfo(wifiManager);
                if (dhcpInfo == null) {
                    str = "";
                } else {
                    str = q.c(dhcpInfo.netmask);
                }
                w.d("MicroMsg.JsApiGetIPAddress", "ip:%d,Ipv4Address:%s,newmask:%s", Integer.valueOf(ipAddress), c16, str);
                return c16;
            } catch (Exception e16) {
                w.a("MicroMsg.JsApiGetIPAddress", e16, "lm:getLocalIPAddress failed", new Object[0]);
            }
        }
        return "";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.zp.h.f146825d.c(new a(dVar, i3));
    }
}
