package com.tencent.biz.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.out.MapHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements ActionSheet.OnButtonClickListener {
    protected String C;
    protected GeoPoint D;
    protected GeoPoint E;
    protected Context F;
    protected Handler G;
    protected a J;

    /* renamed from: m, reason: collision with root package name */
    protected String f97772m;

    /* renamed from: d, reason: collision with root package name */
    protected ActionSheet f97767d = null;

    /* renamed from: e, reason: collision with root package name */
    protected HashSet<String> f97768e = new HashSet<>();

    /* renamed from: f, reason: collision with root package name */
    protected LinkedHashMap<String, String> f97769f = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    protected HashMap<String, Integer> f97770h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    protected int[] f97771i = new int[6];
    protected int H = 0;
    private QBaseActivity I = null;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
    }

    public d(Context context) {
        this.F = context;
        this.f97769f.put("com.tencent.map", HardCodeUtil.qqStr(R.string.quu));
        this.f97769f.put("com.google.android.apps.maps", "Google\u5730\u56fe");
        this.f97769f.put("com.autonavi.minimap", HardCodeUtil.qqStr(R.string.qus));
        this.f97769f.put(MapHelper.BAIDU_PKGNAME, HardCodeUtil.qqStr(R.string.qut));
        this.f97770h.put("com.tencent.map", 2);
        this.f97770h.put("com.google.android.apps.maps", 5);
        this.f97770h.put("com.autonavi.minimap", 4);
        this.f97770h.put(MapHelper.BAIDU_PKGNAME, 3);
        this.G = new Handler(Looper.getMainLooper());
    }

    public static String b(double d16) {
        if (d16 < 1000.0d) {
            return String.format(HardCodeUtil.qqStr(R.string.f172444qv0), Double.valueOf(d16));
        }
        return String.format(HardCodeUtil.qqStr(R.string.quz), Double.valueOf(d16 / 1000.0d));
    }

    public static double c(double d16, double d17, double d18, double d19) {
        double d26 = (d17 * 3.141592653589793d) / 180.0d;
        double d27 = (d19 * 3.141592653589793d) / 180.0d;
        double sin = Math.sin((d26 - d27) / 2.0d);
        double sin2 = Math.sin((((d16 - d18) * 3.141592653589793d) / 180.0d) / 2.0d);
        return 1.2756274E7d * Math.asin(Math.sqrt((sin * sin) + (Math.cos(d26) * Math.cos(d27) * sin2 * sin2)));
    }

    public static void d(String str) {
        e(str, "");
    }

    public static void e(String str, String str2) {
        f(str, str2, "");
    }

    public static void f(String str, String str2, String str3) {
        ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate_android", str, 0, 0, str2, str3, "", "");
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqmap.report", 2, "opName=" + str + ",extra1=" + str2 + ",extra2=" + str3);
        }
    }

    private void g(String str, String str2) {
        h(str, str2, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0069. Please report as an issue. */
    private void h(String str, String str2, String str3) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(this.I);
        HashMap hashMap = null;
        cVar.b("pg_othermap_actionsheet", null);
        cVar.a(Arrays.asList("em_othermap_tencent", "em_othermap_cancel", "em_othermap_more"));
        if (str3 != null && str3.length() != 0 && str == "em_othermap_more") {
            hashMap = new HashMap();
            char c16 = '\uffff';
            switch (str3.hashCode()) {
                case -103524794:
                    if (str3.equals("com.tencent.map")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 40719148:
                    if (str3.equals("com.google.android.apps.maps")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 744792033:
                    if (str3.equals(MapHelper.BAIDU_PKGNAME)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1254578009:
                    if (str3.equals("com.autonavi.minimap")) {
                        c16 = 3;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    return;
                case 1:
                    str3 = "gg";
                    hashMap.put("map_type", str3);
                    break;
                case 2:
                    str3 = "bd";
                    hashMap.put("map_type", str3);
                    break;
                case 3:
                    str3 = "gd";
                    hashMap.put("map_type", str3);
                    break;
                default:
                    hashMap.put("map_type", str3);
                    break;
            }
        }
        if ("dt_imp".equals(str2)) {
            cVar.d(str, hashMap);
        } else if ("dt_imp_end".equals(str2)) {
            cVar.e(str, hashMap);
        } else if ("dt_clck".equals(str2)) {
            cVar.c(str, hashMap);
        }
    }

    private void i() {
        k("dt_pgin");
        g("em_othermap_tencent", "dt_imp");
        g("em_othermap_cancel", "dt_imp");
    }

    public static void j(String str, String str2) {
        ReportController.o(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "rec_locate", str, 0, 0, str2, "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqmap.report", 2, "opName=" + str + ",extra1=" + str2);
        }
    }

    private void k(String str) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(this.I);
        cVar.b("pg_othermap_actionsheet", null);
        cVar.a(Arrays.asList("em_othermap_tencent", "em_othermap_cancel", "em_othermap_more"));
        if ("dt_pgin".equals(str)) {
            cVar.f();
        } else if ("dt_pgout".equals(str)) {
            cVar.h(null);
        }
    }

    protected void a() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f97768e.clear();
        for (String str : this.f97769f.keySet()) {
            if (PackageUtil.isPackageInstalled(this.F, str)) {
                this.f97768e.add(str);
                h("em_othermap_more", "dt_imp", str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_QQMAP, 2, "checkInstalledMapApp: time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void l(a aVar) {
        this.J = aVar;
    }

    public void m(QBaseActivity qBaseActivity, GeoPoint geoPoint, GeoPoint geoPoint2, String str, String str2) {
        if (qBaseActivity != null) {
            this.I = qBaseActivity;
        }
        int i3 = 1;
        if (geoPoint != null && geoPoint2 != null) {
            this.D = geoPoint;
            this.E = geoPoint2;
            this.f97772m = str;
            this.C = str2;
            if (TextUtils.isEmpty(str)) {
                this.f97772m = HardCodeUtil.qqStr(R.string.quv);
            }
            if (TextUtils.isEmpty(this.C)) {
                this.C = HardCodeUtil.qqStr(R.string.qur);
            }
            double c16 = c(geoPoint.getLongitudeE6() / 1000000.0d, geoPoint.getLatitudeE6() / 1000000.0d, geoPoint2.getLongitudeE6() / 1000000.0d, geoPoint2.getLatitudeE6() / 1000000.0d);
            if (c16 > 1000.0d) {
                this.H = 1;
            } else {
                this.H = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_QQMAP, 2, "showActionSheet: self=" + geoPoint.toString() + ",to=" + geoPoint2.toString() + ",selfPoi=" + str + ",toPoi=" + str2 + ",distance=" + c16);
            }
            a();
            ActionSheet create = ActionSheet.create(this.F);
            this.f97767d = create;
            create.setOnButtonClickListener(this);
            this.f97767d.addButton(this.f97769f.get("com.tencent.map"));
            this.f97771i[0] = 2;
            for (Map.Entry<String, String> entry : this.f97769f.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!key.equals("com.tencent.map") && this.f97768e.contains(key)) {
                    this.f97767d.addButton(value);
                    this.f97771i[i3] = this.f97770h.get(key).intValue();
                    i3++;
                }
            }
            this.f97767d.addCancelButton(R.string.cancel);
            this.f97767d.show();
            i();
            return;
        }
        QQToast.makeText(this.F.getApplicationContext(), 0, HardCodeUtil.qqStr(R.string.qux), 1).show(this.F.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
    public void onClick(View view, int i3) {
        int i16 = this.f97771i[i3];
        if (i16 != 2) {
            if (i16 != 3) {
                if (i16 != 4) {
                    if (i16 == 5) {
                        h("em_othermap_more", "dt_clck", "gg");
                    }
                } else {
                    h("em_othermap_more", "dt_clck", "gd");
                }
            } else {
                h("em_othermap_more", "dt_clck", "bd");
            }
        } else {
            g("em_othermap_tencent", "dt_clck");
        }
        b.h(this.I, this.C, new LatLng(this.D.getLatitudeE6() / 1000000.0d, this.D.getLongitudeE6() / 1000000.0d), new LatLng(this.E.getLatitudeE6() / 1000000.0d, this.E.getLongitudeE6() / 1000000.0d), i16);
        if (this.f97767d.isShowing()) {
            this.f97767d.dismiss();
        }
    }
}
