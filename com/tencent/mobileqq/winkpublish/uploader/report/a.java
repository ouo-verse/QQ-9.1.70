package com.tencent.mobileqq.winkpublish.uploader.report;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheFlowerData;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.QUA;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: n, reason: collision with root package name */
    public static final String f327425n = QUA.getVersionForPic();

    /* renamed from: o, reason: collision with root package name */
    public static boolean f327426o = false;

    /* renamed from: f, reason: collision with root package name */
    public int f327432f;

    /* renamed from: h, reason: collision with root package name */
    public long f327434h;

    /* renamed from: i, reason: collision with root package name */
    public long f327435i;

    /* renamed from: l, reason: collision with root package name */
    public int f327438l;

    /* renamed from: m, reason: collision with root package name */
    private String f327439m;

    /* renamed from: a, reason: collision with root package name */
    public int f327427a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f327428b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f327429c = "";

    /* renamed from: d, reason: collision with root package name */
    public long f327430d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f327431e = 0;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f327433g = new StringBuilder();

    /* renamed from: j, reason: collision with root package name */
    public String f327436j = "";

    /* renamed from: k, reason: collision with root package name */
    public boolean f327437k = false;

    protected String a() {
        if (this.f327437k) {
            return WidgetCacheFlowerData.WATER;
        }
        return "mqq";
    }

    public boolean b() {
        return true;
    }

    public HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = this.f327436j;
        if (str != null) {
            hashMap.put("cmdId", str);
        }
        hashMap.put("size", String.valueOf(this.f327430d));
        hashMap.put("delay", String.valueOf(this.f327431e));
        hashMap.put("network", String.valueOf(this.f327427a));
        hashMap.put("terminal", "Android-QZoneInQQ");
        hashMap.put("terminalver", f327425n);
        hashMap.put("refer", a());
        hashMap.put("errcode", String.valueOf(this.f327428b));
        hashMap.put("uin", String.valueOf(ua3.a.d().f()));
        hashMap.put("time", String.valueOf(this.f327435i / 1000));
        hashMap.put("flow", String.valueOf(this.f327432f));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_S_IP, this.f327429c);
        if (!TextUtils.isEmpty(this.f327439m)) {
            hashMap.put("appid", this.f327439m);
        }
        StringBuilder sb5 = this.f327433g;
        if (sb5 != null && sb5.length() > 0) {
            hashMap.put("msg", this.f327433g.toString());
        }
        return hashMap;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("networkType = ");
        int i3 = this.f327427a;
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
        sb5.append(this.f327428b);
        sb5.append(" serverIP = ");
        sb5.append(this.f327429c);
        sb5.append(" fileSize = ");
        sb5.append(this.f327430d);
        sb5.append(" elapse = ");
        sb5.append(this.f327431e);
        sb5.append(" errMsg = ");
        sb5.append(this.f327433g.toString());
        return sb5.toString();
    }
}
