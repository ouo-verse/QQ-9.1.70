package com.tencent.mobileqq.intervideo.now;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: z, reason: collision with root package name */
    public static long f238308z;

    /* renamed from: a, reason: collision with root package name */
    String f238309a;

    /* renamed from: b, reason: collision with root package name */
    String f238310b;

    /* renamed from: c, reason: collision with root package name */
    String f238311c;

    /* renamed from: o, reason: collision with root package name */
    protected int f238323o;

    /* renamed from: p, reason: collision with root package name */
    protected String f238324p;

    /* renamed from: s, reason: collision with root package name */
    protected String f238327s;

    /* renamed from: u, reason: collision with root package name */
    protected int f238329u;

    /* renamed from: x, reason: collision with root package name */
    String f238332x;

    /* renamed from: d, reason: collision with root package name */
    protected String f238312d = "";

    /* renamed from: e, reason: collision with root package name */
    protected String f238313e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f238314f = "";

    /* renamed from: g, reason: collision with root package name */
    protected String f238315g = "";

    /* renamed from: h, reason: collision with root package name */
    protected String f238316h = "";

    /* renamed from: i, reason: collision with root package name */
    protected String f238317i = "";

    /* renamed from: j, reason: collision with root package name */
    protected String f238318j = "";

    /* renamed from: k, reason: collision with root package name */
    protected String f238319k = "";

    /* renamed from: l, reason: collision with root package name */
    protected int f238320l = 0;

    /* renamed from: m, reason: collision with root package name */
    protected int f238321m = 0;

    /* renamed from: n, reason: collision with root package name */
    protected int f238322n = 0;

    /* renamed from: t, reason: collision with root package name */
    protected int f238328t = 2;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f238330v = false;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f238331w = false;

    /* renamed from: y, reason: collision with root package name */
    HashMap<Long, JSONObject> f238333y = new HashMap<>();

    /* renamed from: q, reason: collision with root package name */
    protected String f238325q = Build.VERSION.RELEASE;

    /* renamed from: r, reason: collision with root package name */
    protected String f238326r = DeviceInfoMonitor.getModel();

    public a(QQAppInterface qQAppInterface) {
        g("now_plugin");
    }

    private void a(long j3, String str, String str2, String str3, String str4, boolean z16, int i3, int i16, String str5, String str6, String str7, String str8, String str9, boolean z17) {
        JSONObject jSONObject;
        if (j3 == 0) {
            return;
        }
        if (!this.f238333y.containsKey(Long.valueOf(j3))) {
            jSONObject = new JSONObject();
            this.f238333y.put(Long.valueOf(j3), jSONObject);
        } else {
            jSONObject = this.f238333y.get(Long.valueOf(j3));
        }
        try {
            if (!jSONObject.optBoolean("noneedadd")) {
                jSONObject.put("opname", str4);
                jSONObject.put("roomid", str2);
                jSONObject.put("roomtype", str3);
                jSONObject.put("source", str);
                jSONObject.put("d1", str5);
                jSONObject.put("d2", str6);
                jSONObject.put("d3", str7);
                jSONObject.put("d4", str8);
                jSONObject.put("op_in", i3);
                jSONObject.put("op_result", i16);
                jSONObject.put("noneedadd", z16);
                jSONObject.put("timelong", str9);
            } else {
                QLog.i("NowDataReporter", 1, "\u672c\u6b21opname\u4e0d\u5f71\u54cd\u4e0a\u62a5");
            }
            this.f238333y.put(Long.valueOf(j3), jSONObject);
            if (z17) {
                j(j3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public a b(String str) {
        this.f238316h = str;
        return this;
    }

    public a c(String str) {
        this.f238317i = str;
        return this;
    }

    public a d(String str) {
        this.f238318j = str;
        return this;
    }

    public a f(String str) {
        this.f238314f = str;
        return this;
    }

    public a g(String str) {
        this.f238313e = str;
        return this;
    }

    public void h() {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date(System.currentTimeMillis()));
        String valueOf = String.valueOf(com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext()));
        this.f238312d = HttpUtil.getNetWorkType() + "";
        QLog.i("NowDataReporter", 1, "nowDatareport: source = " + this.f238309a + " roomid = " + this.f238310b + " roomType = " + this.f238311c + " op_name = " + this.f238314f + " op_in = " + this.f238329u + " d1= " + this.f238316h + " d2=" + this.f238317i + " d3=" + this.f238318j + " d4=" + this.f238319k + " timelong=" + this.f238324p + " op_result = " + this.f238323o + " qq_version = " + valueOf + "  optime = " + format + " lastOpName = " + this.f238327s + " pluginstatus =" + this.f238321m + " preloadStatus =" + this.f238322n + " sdkversion = " + this.f238332x + "useShadow =" + this.f238331w);
        ReportController.n(null, "dc02882", "grp_lbs", this.f238315g, this.f238313e, this.f238314f, this.f238329u, 1, this.f238323o, this.f238316h, this.f238317i, this.f238318j, this.f238319k + "|" + this.f238324p + "|" + this.f238310b + "|" + this.f238311c + "|" + this.f238309a + "|" + this.f238312d + "|" + this.f238328t + "|" + this.f238326r + "|" + this.f238325q + "|" + this.f238320l + "|" + this.f238332x + "|" + valueOf + "|" + format + "|" + this.f238327s + "|" + this.f238321m + "|" + this.f238322n + "|" + this.f238331w);
    }

    public void j(long j3) {
        JSONObject jSONObject = this.f238333y.get(Long.valueOf(j3));
        if (jSONObject == null || !jSONObject.has("opname")) {
            return;
        }
        i("last_op_name", jSONObject);
        this.f238333y.remove(Long.valueOf(j3));
    }

    public void k(int i3, String str, long j3, int i16) {
        try {
            f("get_record_res").b(String.valueOf(i3)).c(str).d(String.valueOf(i16)).l(String.valueOf(j3)).h();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("NowDataReporter", 2, "reportRecordCgi Exception");
            }
        }
    }

    public a l(String str) {
        this.f238324p = str;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x01d7 A[Catch: Exception -> 0x01f7, TRY_LEAVE, TryCatch #0 {Exception -> 0x01f7, blocks: (B:6:0x000a, B:9:0x001a, B:12:0x0042, B:14:0x0048, B:15:0x004e, B:17:0x007d, B:18:0x0093, B:20:0x00a2, B:22:0x00ad, B:23:0x00b1, B:26:0x00c0, B:29:0x00cf, B:31:0x00da, B:33:0x00e2, B:35:0x00ed, B:37:0x00f8, B:39:0x0103, B:41:0x010e, B:43:0x0119, B:45:0x0124, B:49:0x0133, B:52:0x0142, B:55:0x014c, B:57:0x0157, B:60:0x0166, B:63:0x0174, B:66:0x017f, B:68:0x018a, B:71:0x0193, B:73:0x019b, B:76:0x01a4, B:78:0x01af, B:81:0x01b4, B:83:0x01bf, B:86:0x01c4, B:88:0x01cf, B:92:0x01d7), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(Bundle bundle) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("op_name");
            this.f238314f = string;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f238329u = bundle.getInt("op_in");
            this.f238323o = bundle.getInt("op_result");
            this.f238324p = bundle.getString("timeconsume");
            String string2 = bundle.getString(AdParam.SDKVERSION);
            if (!TextUtils.isEmpty(string2) && !string2.equals("0")) {
                this.f238332x = bundle.getString(AdParam.SDKVERSION);
            }
            this.f238316h = bundle.getString("d1");
            this.f238317i = bundle.getString("d2");
            this.f238318j = bundle.getString("d3");
            this.f238319k = bundle.getString("d4");
            if (this.f238314f.equals("enter_shadow")) {
                this.f238321m = Integer.parseInt(bundle.getString("status1", "0"));
                this.f238320l = bundle.getInt("frameVersion");
            }
            h();
            boolean z27 = false;
            if (this.f238314f.equals("check_version_complete") && this.f238318j.equals("1")) {
                this.f238330v = false;
                this.f238321m = 0;
            }
            if (!this.f238333y.containsKey(Long.valueOf(f238308z))) {
                return;
            }
            if (!this.f238314f.equals("cancel_run") && !this.f238314f.equals("cancel_in_plugin") && !this.f238314f.equals("download_fail") && !this.f238314f.equals("boot_fail") && !this.f238314f.equals("login_fail") && !this.f238314f.equals("enter_fail") && !this.f238314f.equals("user_cancel_in_plugin") && !this.f238314f.equals("enter_room") && !this.f238314f.equals("jump_h5") && !this.f238314f.equals("jump_app")) {
                z16 = false;
                z17 = z16;
                if (this.f238314f.equals("download_biz_plugin") && this.f238316h.equals("fail")) {
                    z16 = true;
                    z17 = true;
                }
                if (this.f238314f.equals("unzip_biz_plugin") || !this.f238316h.equals("fail")) {
                    z18 = z16;
                    z19 = z17;
                } else {
                    z18 = true;
                    z19 = true;
                }
                z26 = this.f238314f.equals("download_start") || !this.f238316h.equals("2");
                if (this.f238314f.equals("download_complete") && this.f238316h.equals("2")) {
                    z26 = false;
                }
                if (this.f238314f.equals("download_fail") && this.f238316h.equals("2")) {
                    z26 = false;
                }
                if (this.f238314f.equals("install_start") && this.f238329u != 1) {
                    z26 = false;
                }
                if (this.f238314f.equals("install_complete") && this.f238329u != 1) {
                    z26 = false;
                }
                if (this.f238314f.equals("install_fail") || this.f238329u == 1) {
                    z27 = z26;
                }
                if (z27) {
                    return;
                }
                a(f238308z, this.f238309a, this.f238310b, this.f238311c, this.f238314f, z18, this.f238329u, this.f238323o, this.f238316h, this.f238317i, this.f238318j, this.f238319k, this.f238324p, z19);
                return;
            }
            z16 = true;
            z17 = z16;
            if (this.f238314f.equals("download_biz_plugin")) {
                z16 = true;
                z17 = true;
            }
            if (this.f238314f.equals("unzip_biz_plugin")) {
            }
            z18 = z16;
            z19 = z17;
            if (this.f238314f.equals("download_start")) {
            }
            if (this.f238314f.equals("download_complete")) {
                z26 = false;
            }
            if (this.f238314f.equals("download_fail")) {
                z26 = false;
            }
            if (this.f238314f.equals("install_start")) {
                z26 = false;
            }
            if (this.f238314f.equals("install_complete")) {
                z26 = false;
            }
            if (this.f238314f.equals("install_fail")) {
            }
            z27 = z26;
            if (z27) {
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("NowDataReporter", 2, "onReportFromXProxy Exception");
            }
        }
    }

    public void i(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("opname");
        int optInt = jSONObject.optInt("op_in");
        int optInt2 = jSONObject.optInt("op_result");
        String optString2 = jSONObject.optString("d1");
        String optString3 = jSONObject.optString("d2");
        String optString4 = jSONObject.optString("d3");
        String optString5 = jSONObject.optString("d4");
        String optString6 = jSONObject.optString("source");
        String optString7 = jSONObject.optString("roomid");
        String optString8 = jSONObject.optString("roomtype");
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date(System.currentTimeMillis()));
        String valueOf = String.valueOf(com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext()));
        this.f238312d = HttpUtil.getNetWorkType() + "";
        QLog.i("NowDataReporter", 2, "nowDatareportlastop: source = " + optString6 + " roomid = " + optString7 + " roomType = " + optString8 + " op_name = " + str + " op_in = " + optInt + " d1= " + optString2 + " d2=" + optString3 + " d3=" + optString4 + " d4=" + optString5 + " timelong=" + this.f238324p + " op_result = " + optInt2 + " qq_version = " + valueOf + "  optime = " + format + " lastOpName = " + optString + " pluginstatus =" + this.f238321m + " preloadStatus =" + this.f238322n + " sdkversion = " + this.f238332x + " useShadow =" + this.f238331w);
        String str2 = this.f238315g;
        String str3 = this.f238313e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(optString5);
        sb5.append("|");
        sb5.append(this.f238324p);
        sb5.append("|");
        sb5.append(optString7);
        sb5.append("|");
        sb5.append(optString8);
        sb5.append("|");
        sb5.append(optString6);
        sb5.append("|");
        sb5.append(this.f238312d);
        sb5.append("|");
        sb5.append(this.f238328t);
        sb5.append("|");
        sb5.append(this.f238326r);
        sb5.append("|");
        sb5.append(this.f238325q);
        sb5.append("|");
        sb5.append(this.f238320l);
        sb5.append("|");
        sb5.append(this.f238332x);
        sb5.append("|");
        sb5.append(valueOf);
        sb5.append("|");
        sb5.append(format);
        sb5.append("|");
        sb5.append(optString);
        sb5.append("|");
        sb5.append(this.f238321m);
        sb5.append("|");
        sb5.append(this.f238322n);
        sb5.append("|");
        sb5.append(this.f238331w);
        ReportController.n(null, "dc02882", "grp_lbs", str2, str3, str, optInt, 1, optInt2, optString2, optString3, optString4, sb5.toString());
    }
}
