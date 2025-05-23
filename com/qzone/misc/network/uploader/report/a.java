package com.qzone.misc.network.uploader.report;

import SLICE_UPLOAD.cnst.appid_upp;
import SLICE_UPLOAD.cnst.appid_ups;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheFlowerData;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.component.network.module.report.ExtendData;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QUA;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.cache.CacheManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: n, reason: collision with root package name */
    public static final String f48577n = QUA.getVersionForPic();

    /* renamed from: o, reason: collision with root package name */
    public static boolean f48578o = false;

    /* renamed from: f, reason: collision with root package name */
    public int f48584f;

    /* renamed from: i, reason: collision with root package name */
    public long f48587i;

    /* renamed from: j, reason: collision with root package name */
    public long f48588j;

    /* renamed from: m, reason: collision with root package name */
    private String f48591m;

    /* renamed from: a, reason: collision with root package name */
    public int f48579a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f48580b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f48581c = "";

    /* renamed from: d, reason: collision with root package name */
    public long f48582d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f48583e = 0;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f48585g = new StringBuilder();

    /* renamed from: h, reason: collision with root package name */
    public ExtendData f48586h = null;

    /* renamed from: k, reason: collision with root package name */
    public String f48589k = "";

    /* renamed from: l, reason: collision with root package name */
    public boolean f48590l = false;

    public static String c(int i3, int i16) {
        String str = ("https://expeva.store.qq.com/" + a(i3)) + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (i16 == 0) {
            return str + "op=upload";
        }
        if (i16 == 1) {
            return str + "op=down";
        }
        return "";
    }

    private static String f(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3 & 255);
        stringBuffer.append('.');
        int i16 = i3 >>> 8;
        stringBuffer.append(i16 & 255);
        stringBuffer.append('.');
        int i17 = i16 >>> 8;
        stringBuffer.append(i17 & 255);
        stringBuffer.append('.');
        stringBuffer.append((i17 >>> 8) & 255);
        return stringBuffer.toString();
    }

    protected String b() {
        if (this.f48590l) {
            return WidgetCacheFlowerData.WATER;
        }
        return "mqq";
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }

    public void g(int i3) {
        this.f48591m = a(i3);
    }

    public JSONObject h() throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        String str2 = this.f48589k;
        if (str2 != null) {
            jSONObject.put("cmdId", str2);
        }
        jSONObject.put("size", this.f48582d);
        jSONObject.put("delay", this.f48583e);
        jSONObject.put("network", this.f48579a);
        jSONObject.put("terminal", "Android-QZoneInQQ");
        jSONObject.put("terminalver", f48577n);
        jSONObject.put("refer", b());
        jSONObject.put("errcode", this.f48580b);
        jSONObject.put("uin", LoginData.getInstance().getUin());
        jSONObject.put("time", this.f48588j / 1000);
        jSONObject.put("flow", this.f48584f);
        jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_S_IP, this.f48581c);
        if (!TextUtils.isEmpty(this.f48591m)) {
            jSONObject.put("appid", this.f48591m);
        }
        StringBuilder sb5 = this.f48585g;
        if (sb5 != null && sb5.length() > 0) {
            jSONObject.put("msg", this.f48585g.toString());
            if (this.f48586h == null) {
                this.f48586h = new ExtendData();
            }
            DhcpInfo dhcpInfo = NetworkMonitor.getDhcpInfo((WifiManager) BaseApplication.getContext().getSystemService("wifi"));
            if (dhcpInfo != null) {
                str = f(dhcpInfo.dns1) + "," + f(dhcpInfo.dns2);
            } else {
                str = null;
            }
            this.f48586h.put(0, DeviceInfoMonitor.getModel());
            this.f48586h.put(1, Build.VERSION.RELEASE);
            this.f48586h.put(2, String.valueOf(CacheManager.isExternalAvailable() ? 1 : 0));
            this.f48586h.put(3, CacheManager.getSDCardCapabilityForDisplay());
            this.f48586h.put(4, CacheManager.getSDCardRemainForDisplay());
            ExtendData extendData = this.f48586h;
            if (str == null) {
                str = "";
            }
            extendData.put(6, str);
            this.f48586h.put(7, String.valueOf(f48578o ? 1 : 0));
            jSONObject.put(QFSEdgeItem.KEY_EXTEND, this.f48586h.getExtendString() + "|" + this.f48585g.toString());
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("networkType = ");
        int i3 = this.f48579a;
        if (i3 == 1) {
            sb5.append(Global.TRACKING_WIFI);
        } else if (i3 == 2) {
            sb5.append("2G");
        } else if (i3 != 3) {
            sb5.append("\u672a\u77e5");
        } else {
            sb5.append("3G");
        }
        sb5.append(" retCode = ");
        sb5.append(this.f48580b);
        sb5.append(" serverIP = ");
        sb5.append(this.f48581c);
        sb5.append(" fileSize = ");
        sb5.append(this.f48582d);
        sb5.append(" elapse = ");
        sb5.append(this.f48583e);
        sb5.append(" errMsg = ");
        sb5.append(this.f48585g.toString());
        return sb5.toString();
    }

    public static String a(int i3) {
        if (i3 == 0) {
            return "photo";
        }
        if (i3 == 2) {
            return "qzone_video";
        }
        if (i3 == 4) {
            return "qzone_sound";
        }
        if (i3 == 6) {
            return "qzone_head";
        }
        if (i3 == 8) {
            return appid_upp.value;
        }
        if (i3 == 10) {
            return "groupphoto";
        }
        if (i3 == 12) {
            return appid_ups.value;
        }
        if (i3 != 14) {
            return "";
        }
        return "photowall";
    }
}
