package com.qzone.business.lbsv2.business;

import android.os.Handler;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e implements d {

    /* renamed from: f, reason: collision with root package name */
    private static Object f44578f = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static ConcurrentHashMap<String, e> f44579h = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private String f44580d;

    /* renamed from: e, reason: collision with root package name */
    private d f44581e;

    e(String str) {
        this.f44580d = str;
        this.f44581e = QZoneNewLbsService.P(str);
    }

    public static e c(String str) {
        e eVar = f44579h.get(str);
        if (eVar == null) {
            synchronized (f44578f) {
                eVar = f44579h.get(str);
                if (eVar == null) {
                    eVar = new e(str);
                    f44579h.put(str, eVar);
                }
            }
        }
        return eVar;
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void A(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16) {
        this.f44581e.A(handler, i3, arrayList, i16);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void B(Handler handler, String str, String str2, boolean z16, int i3, LocalImageShootInfo localImageShootInfo) {
        this.f44581e.B(handler, str, str2, z16, i3, localImageShootInfo);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void a(Handler handler, String str, String str2, int i3) {
        this.f44581e.a(handler, str, str2, i3);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void b(Handler handler, int i3) {
        this.f44581e.b(handler, i3);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void f(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16, String str) {
        this.f44581e.f(handler, i3, arrayList, i16, str);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void i(Handler handler, String str, int i3) {
        this.f44581e.i(handler, str, i3);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void k(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16) {
        this.f44581e.k(handler, i3, arrayList, i16);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void m(Handler handler, String str, int i3, int i16, boolean z16, LocalImageShootInfo localImageShootInfo, ArrayList<String> arrayList) {
        this.f44581e.m(handler, str, i3, i16, z16, localImageShootInfo, arrayList);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void n(Handler handler, int i3, LocalImageShootInfo localImageShootInfo, int i16, int i17) {
        this.f44581e.n(handler, i3, localImageShootInfo, i16, i17);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public WidgetWeatherData q(boolean z16) {
        return this.f44581e.q(z16);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void y(Handler handler, String str, int i3, int i16, boolean z16, ArrayList<String> arrayList) {
        this.f44581e.y(handler, str, i3, i16, z16, arrayList);
    }
}
