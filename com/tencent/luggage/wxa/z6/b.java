package com.tencent.luggage.wxa.z6;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f146344a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f146345b = new SparseIntArray();

    public static final void a(String str, int i3) {
        if (str != null) {
            w.a("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + str + ", serviceType: " + i3);
            f146345b.put(str.hashCode(), i3);
        }
    }

    public static final int b(String str, int i3) {
        if (str != null) {
            int i16 = f146345b.get(str.hashCode(), -1);
            w.a("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + str + ", ret " + i16);
            return i16;
        }
        return i3;
    }

    public static /* synthetic */ int a(String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return b(str, i3);
    }
}
