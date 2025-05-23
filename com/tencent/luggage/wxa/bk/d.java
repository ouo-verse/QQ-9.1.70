package com.tencent.luggage.wxa.bk;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f122980a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f122981b = new SparseIntArray();

    public static final int a(String str) {
        return a(str, 0, 2, null);
    }

    public static /* synthetic */ int a(String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return a(str, i3);
    }

    public static final int a(String str, int i3) {
        int i16;
        if (str == null) {
            return i3;
        }
        int hashCode = str.hashCode();
        SparseIntArray sparseIntArray = f122981b;
        synchronized (sparseIntArray) {
            i16 = sparseIntArray.get(hashCode, i3);
        }
        w.a("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + str + ", ret " + i16);
        return i16;
    }
}
