package com.tencent.luggage.wxa.hf;

import com.tencent.luggage.wxa.gf.c0;
import com.tencent.luggage.wxa.gf.h0;
import com.tencent.luggage.wxa.gf.k;
import com.tencent.luggage.wxa.gf.o;
import com.tencent.luggage.wxa.gf.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f127094a;

    static {
        HashMap hashMap = new HashMap();
        f127094a = hashMap;
        hashMap.put("addMapCircles", 0);
        hashMap.put("addMapMarkers", 1);
        hashMap.put("removeMapMarkers", 2);
        hashMap.put("addMapLines", 3);
        hashMap.put(c0.NAME, 4);
        hashMap.put("includeMapPoints", 5);
        hashMap.put("addMapControls", 6);
        hashMap.put("addMapPolygons", 7);
        hashMap.put("getMapCenterLocation", 8);
        hashMap.put("moveToMapLocation", 9);
        hashMap.put("translateMapMarker", 10);
        hashMap.put("getMapScale", 11);
        hashMap.put("getMapRegion", 12);
        hashMap.put("getMapRotate", 13);
        hashMap.put("getMapSkew", 14);
        hashMap.put(o.NAME, 15);
        hashMap.put(h0.NAME, 16);
        hashMap.put(k.NAME, 17);
        hashMap.put(w.NAME, 18);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str) {
        boolean z16;
        int i3;
        if (w0.c(str)) {
            return;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals("updateMap")) {
                    z16 = false;
                    break;
                }
                z16 = -1;
                break;
            case -384482333:
                if (str.equals("insertMap")) {
                    z16 = true;
                    break;
                }
                z16 = -1;
                break;
            case 1282356792:
                if (str.equals("removeMap")) {
                    z16 = 2;
                    break;
                }
                z16 = -1;
                break;
            default:
                z16 = -1;
                break;
        }
        switch (z16) {
            case false:
                i3 = 3;
                break;
            case true:
                i3 = 0;
                break;
            case true:
                i3 = 6;
                break;
            default:
                Map map = f127094a;
                if (!map.containsKey(str)) {
                    i3 = -1;
                    break;
                } else {
                    i3 = (((Integer) map.get(str)).intValue() * 5) + 20 + 0;
                    break;
                }
        }
        if (i3 == -1) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.MapReporter", "key is -1, may be err");
        } else {
            a(i3);
            com.tencent.luggage.wxa.tn.w.g("Luggage.MapReporter", "name:%s invoke key:%d", str, Integer.valueOf(i3));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str, boolean z16, boolean z17) {
        boolean z18;
        if (w0.c(str)) {
            return;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals("updateMap")) {
                    z18 = false;
                    break;
                }
                z18 = -1;
                break;
            case -384482333:
                if (str.equals("insertMap")) {
                    z18 = true;
                    break;
                }
                z18 = -1;
                break;
            case 1282356792:
                if (str.equals("removeMap")) {
                    z18 = 2;
                    break;
                }
                z18 = -1;
                break;
            default:
                z18 = -1;
                break;
        }
        int i3 = 5;
        switch (z18) {
            case false:
                if (z16) {
                    i3 = 4;
                    break;
                }
                break;
            case true:
                if (!z16) {
                    i3 = 2;
                    break;
                } else {
                    i3 = 1;
                    break;
                }
            case true:
                if (!z16) {
                    i3 = 8;
                    break;
                } else {
                    i3 = 7;
                    break;
                }
            default:
                Map map = f127094a;
                if (!map.containsKey(str)) {
                    i3 = -1;
                    break;
                } else {
                    i3 = (z17 ? z16 ? 3 : 4 : z16 ? 1 : 2) + (((Integer) map.get(str)).intValue() * 5) + 20;
                    break;
                }
        }
        if (i3 == -1) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.MapReporter", "key is -1, may be err");
        } else {
            a(i3);
            com.tencent.luggage.wxa.tn.w.g("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", str, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        }
    }

    public static void a(int i3) {
        com.tencent.luggage.wxa.tn.w.g("Luggage.MapReporter", "reportKey:%d", Integer.valueOf(i3));
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1020L, i3, 1L, false);
    }
}
