package com.tencent.luggage.wxa.zq;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f146874a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f146875a;

        static {
            int[] iArr = new int[e.values().length];
            f146875a = iArr;
            try {
                iArr[e.kEmbed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146875a[e.kAssets.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146875a[e.kRemote.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146875a[e.kProvider.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static synchronized com.tencent.luggage.wxa.zq.a a(e eVar) {
        com.tencent.luggage.wxa.zq.a aVar;
        synchronized (f.class) {
            Map map = f146874a;
            aVar = (com.tencent.luggage.wxa.zq.a) map.get(eVar);
            if (aVar == null) {
                if (a.f146875a[eVar.ordinal()] == 1) {
                    aVar = new b();
                }
                map.put(eVar, aVar);
            }
        }
        return aVar;
    }
}
