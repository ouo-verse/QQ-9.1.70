package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.go;
import com.xiaomi.push.gq;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.iq;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f389748a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f389749b;

        static {
            int[] iArr = new int[gm.values().length];
            f389749b = iArr;
            try {
                iArr[gm.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f389749b[gm.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f389749b[gm.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f389749b[gm.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[gl.values().length];
            f389748a = iArr2;
            try {
                iArr2[gl.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f389748a[gl.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static int a(ah ahVar, gl glVar) {
        int i3 = 1;
        if (a.f389748a[glVar.ordinal()] != 1) {
            i3 = 0;
        }
        return ahVar.b(glVar, i3);
    }

    private static List<Pair<Integer, Object>> b(List<gq> list, boolean z16) {
        Pair pair;
        if (iq.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gq gqVar : list) {
            int a16 = gqVar.a();
            gm a17 = gm.a(gqVar.b());
            if (a17 != null) {
                if (z16 && gqVar.f24754a) {
                    arrayList.add(new Pair(Integer.valueOf(a16), null));
                } else {
                    int i3 = a.f389749b[a17.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    pair = null;
                                } else {
                                    pair = new Pair(Integer.valueOf(a16), Boolean.valueOf(gqVar.g()));
                                }
                            } else {
                                pair = new Pair(Integer.valueOf(a16), gqVar.m327a());
                            }
                        } else {
                            pair = new Pair(Integer.valueOf(a16), Long.valueOf(gqVar.m326a()));
                        }
                    } else {
                        pair = new Pair(Integer.valueOf(a16), Integer.valueOf(gqVar.c()));
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }

    public static void c(ah ahVar, hc hcVar) {
        jz4.c.y("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", ahVar, ", configMessage=", hcVar);
        ahVar.k(b(hcVar.a(), true));
        ahVar.n();
    }

    public static void d(ah ahVar, hd hdVar) {
        jz4.c.y("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", ahVar, ", configMessage=", hdVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (go goVar : hdVar.a()) {
            arrayList.add(new Pair<>(goVar.m322a(), Integer.valueOf(goVar.a())));
            List<Pair<Integer, Object>> b16 = b(goVar.f24748a, false);
            if (!iq.a(b16)) {
                arrayList2.addAll(b16);
            }
        }
        ahVar.l(arrayList, arrayList2);
        ahVar.n();
    }
}
