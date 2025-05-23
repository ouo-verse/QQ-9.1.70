package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmsqmsp.oaid2.IVendorCallback;
import com.tencent.tmsqmsp.oaid2.VendorManager;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tb {

    /* renamed from: a, reason: collision with root package name */
    private static final String f150430a = "TMS-Oaid";

    /* renamed from: b, reason: collision with root package name */
    private static String f150431b = "";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f150432c = true;

    /* renamed from: d, reason: collision with root package name */
    private static IVendorCallback f150433d = new IVendorCallback() { // from class: com.tencent.mapsdk.internal.tb.1
        @Override // com.tencent.tmsqmsp.oaid2.IVendorCallback
        public final void onResult(boolean z16, String str, String str2) {
            Log.e(tb.f150430a, "isSupport: " + z16 + " s: " + str + " oaid: " + str2);
            boolean unused = tb.f150432c = z16;
            if (z16) {
                String unused2 = tb.f150431b = str2;
            }
        }
    };

    public static String a(Context context) {
        if (!f150432c) {
            return "undefined";
        }
        if (!TextUtils.isEmpty(f150431b) && f150432c) {
            return f150431b;
        }
        try {
            new VendorManager().getVendorInfo(context, f150433d);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return f150431b;
    }
}
