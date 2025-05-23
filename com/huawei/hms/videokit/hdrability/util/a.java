package com.huawei.hms.videokit.hdrability.util;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.SurfaceView;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static com.huawei.hms.videokit.hdrability.a f37733a;

    public static int a(SurfaceView surfaceView, double d16) {
        Log.i("AbilityUtil", "setHdrLayerMetaData enter, ratio:" + d16);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putDouble("hdrLumaRatio", d16);
        Object b16 = b.b("android.view.SurfaceViewEx", "setHdrLayerMetaData", new Class[]{SurfaceView.class, PersistableBundle.class}, surfaceView, persistableBundle);
        if (b16 == null) {
            Log.e("AbilityUtil", "setHdrLayerMetaData failed, obj is null");
            return 1;
        }
        if (!(b16 instanceof Integer) || ((Integer) b16).intValue() != 0) {
            return -1;
        }
        Log.i("AbilityUtil", "setHdrLayerMetaData success, ret:" + b16);
        return 0;
    }

    public static int a(SurfaceView surfaceView, boolean z16) {
        Log.i("AbilityUtil", "setHdrLayerMetaData enter, enable:" + z16);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("isProcessedHdr", z16 ? 1 : 0);
        Object b16 = b.b("android.view.SurfaceViewEx", "setHdrLayerMetaData", new Class[]{SurfaceView.class, PersistableBundle.class}, surfaceView, persistableBundle);
        if (b16 == null) {
            Log.e("AbilityUtil", "setHdrLayerMetaData failed, obj is null");
            return 1;
        }
        if (!(b16 instanceof Integer) || ((Integer) b16).intValue() != 0) {
            return -1;
        }
        Log.i("AbilityUtil", "setHdrLayerMetaData success, ret:" + b16);
        return 0;
    }

    public static int a(boolean z16) {
        Class[] clsArr = {String.class, String.class};
        Object[] objArr = new Object[2];
        objArr[0] = "SCENE_HDR";
        objArr[1] = z16 ? "ACTION_MODE_ON" : "ACTION_MODE_OFF";
        Object a16 = b.a("com.huawei.displayengine.DisplayEngineInterface", "setScene", clsArr, objArr);
        if (a16 == null) {
            Log.e("AbilityUtil", "setHdrLayerMetaData failed, obj is null");
            return 1;
        }
        if (a16 instanceof Integer) {
            return ((Integer) a16).intValue();
        }
        return -1;
    }

    public static com.huawei.hms.videokit.hdrability.a a() {
        if (f37733a == null) {
            f37733a = new com.huawei.hms.videokit.hdrability.a();
            Bundle bundle = new Bundle();
            Object a16 = b.a("com.huawei.displayengine.DisplayEngineInterface", "getEffect", new Class[]{String.class, String.class, Bundle.class}, "FEATURE_HDR", "EFFECT_TYPE_HDR", bundle);
            if (a16 == null) {
                Log.e("AbilityUtil", "getEffectFeatureHdr failed, obj is null");
            } else if ((a16 instanceof Integer) && ((Integer) a16).intValue() == 0) {
                f37733a.a(bundle.getBoolean("IsPanelHdrSupport"));
                f37733a.a(bundle.getString("SupportHdrType"));
                f37733a.a(bundle.getInt("PeakMaxBrightness"));
                Log.d("AbilityUtil", "getHdrEffect:" + f37733a.c() + " " + f37733a.b() + " " + f37733a.a());
            }
        }
        return f37733a;
    }
}
