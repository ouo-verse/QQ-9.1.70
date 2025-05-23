package com.tencent.gamecenter.wadl.sdk.common.d.k.a;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.gamecenter.wadl.sdk.common.d.i;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f107142b = new b();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f107143a = new a(this, 8, 1.0f, true);

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends LinkedHashMap<String, String> {
        a(b bVar, int i3, float f16, boolean z16) {
            super(i3, f16, z16);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            if (size() > 8) {
                return true;
            }
            return false;
        }
    }

    b() {
        a(i.a(b(), "", true), false);
    }

    public static b a() {
        return f107142b;
    }

    private String b() {
        return "WadlOperInfo_" + com.tencent.gamecenter.wadl.sdk.common.a.c();
    }

    public String c() {
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f107143a) {
            ArrayList arrayList = new ArrayList(this.f107143a.keySet());
            ArrayList arrayList2 = new ArrayList(this.f107143a.values());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = (String) arrayList.get(i3);
                String str2 = (String) arrayList2.get(i3);
                sb5.append(str);
                sb5.append("h,l");
                sb5.append(str2);
                sb5.append("h;l");
            }
        }
        return sb5.toString();
    }

    public static String a(int i3) {
        return i3 == 1 ? "cm" : i3 == 3 ? LinkReportConstant$GlobalKey.CONNECT_TYPE : i3 == 2 ? "uni" : "";
    }

    public String a(String str) {
        if (g.e(str) || "unknown".equals(str)) {
            return "";
        }
        synchronized (this.f107143a) {
            String str2 = this.f107143a.get(str);
            return !g.e(str2) ? str2 : "";
        }
    }

    public void a(String str, String str2) {
        if (g.e(str) || "unknown".equals(str) || g.e(str2) || "unknown".equals(str2)) {
            return;
        }
        synchronized (this.f107143a) {
            if (!str2.equals(this.f107143a.get(str))) {
                this.f107143a.put(str, str2);
                i.b(b(), c(), true);
            }
        }
    }

    public void a(String str, boolean z16) {
        try {
            if (g.e(str)) {
                return;
            }
            synchronized (this.f107143a) {
                this.f107143a.clear();
                String[] split = str.split("h;l");
                if (split != null) {
                    for (String str2 : split) {
                        String[] split2 = str2.split("h,l");
                        if (split2.length == 2) {
                            this.f107143a.put(split2[0], split2[1]);
                        }
                    }
                }
            }
            if (z16) {
                i.b(b(), str, true);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
