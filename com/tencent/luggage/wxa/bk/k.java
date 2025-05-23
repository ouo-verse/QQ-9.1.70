package com.tencent.luggage.wxa.bk;

import android.content.Context;
import com.tencent.luggage.wxa.jg.j;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f123003a = new k();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f123004a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final String f123005b = j.g.Unknown.f131107a;

        /* renamed from: c, reason: collision with root package name */
        public static final String f123006c = j.g.Wifi.f131107a;

        /* renamed from: d, reason: collision with root package name */
        public static final String f123007d = j.g.Mobile_2g.f131107a;

        /* renamed from: e, reason: collision with root package name */
        public static final String f123008e = j.g.Mobile_3g.f131107a;

        /* renamed from: f, reason: collision with root package name */
        public static final String f123009f = j.g.Mobile_4g.f131107a;

        /* renamed from: g, reason: collision with root package name */
        public static final String f123010g = j.g.Mobile_5g.f131107a;

        /* renamed from: h, reason: collision with root package name */
        public static final String f123011h = "offline";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f123012a;

        static {
            int[] iArr = new int[j.g.values().length];
            iArr[j.g.None.ordinal()] = 1;
            f123012a = iArr;
        }
    }

    public static /* synthetic */ String a(Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = null;
        }
        return a(context);
    }

    public static final String a(Context context) {
        String str;
        if (context == null) {
            context = z.c();
        }
        j.g a16 = com.tencent.luggage.wxa.jg.j.a(context);
        if (b.f123012a[a16.ordinal()] == 1) {
            str = a.f123011h;
        } else {
            str = a16.f131107a;
        }
        Intrinsics.checkNotNullExpressionValue(str, "getNetworkType(context?:\u2026e\n            }\n        }");
        return str;
    }
}
