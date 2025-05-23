package com.tencent.luggage.wxa.pe;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f137500a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static final boolean a(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        return k.a(z.c(), permission);
    }

    public static final boolean b() {
        boolean z16;
        BluetoothAdapter e16 = c.e();
        if (e16 == null) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isPeripheralBleSupported: isMultipleAdvertisementSupported = ");
        sb5.append(e16.isMultipleAdvertisementSupported());
        sb5.append("\nisOffloadedFilteringSupported = ");
        sb5.append(e16.isOffloadedFilteringSupported());
        sb5.append("\nisOffloadedScanBatchingSupported = ");
        sb5.append(e16.isOffloadedScanBatchingSupported());
        sb5.append("\nbluetoothLeAdvertiser != null? = ");
        if (e16.getBluetoothLeAdvertiser() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append('\n');
        w.a("MicroMsg.BLE.BleHelpExt", sb5.toString());
        if (e16.getBluetoothLeAdvertiser() == null) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.xd.a aVar, int i3, d dVar, HashMap hashMap, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            hashMap = null;
        }
        a(aVar, i3, dVar, hashMap);
    }

    public static final void a(com.tencent.luggage.wxa.xd.a aVar, int i3, d env, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        w.a("MicroMsg.BLE.BleHelpExt", "callbackSuccess: api = " + aVar.getClass().getSimpleName());
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put("errCode", 0);
        env.a(i3, aVar.makeReturnJson(e.f121305a, hashMap));
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.xd.a aVar, int i3, d dVar, int i16, String str, HashMap hashMap, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            hashMap = null;
        }
        a(aVar, i3, dVar, i16, str, hashMap);
    }

    public static final void a(com.tencent.luggage.wxa.xd.a aVar, int i3, d env, int i16, String errMsg, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        w.a("MicroMsg.BLE.BleHelpExt", "callbackFail: api = %s, reason = %s", aVar.getClass().getSimpleName(), errMsg);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put("errCode", Integer.valueOf(i16));
        env.a(i3, aVar.makeReturnJson(errMsg, hashMap));
    }

    public static final int a() {
        return RandomKt.Random(System.currentTimeMillis()).nextInt(1, Integer.MAX_VALUE);
    }
}
