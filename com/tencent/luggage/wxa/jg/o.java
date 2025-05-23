package com.tencent.luggage.wxa.jg;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o extends m {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    public o() {
        this(new d());
    }

    public void a(com.tencent.luggage.wxa.ic.d dVar, Map map) {
    }

    public o(d dVar) {
        super(dVar);
    }

    public static int b(com.tencent.luggage.wxa.ic.d dVar) {
        int drawnStatusBarHeight;
        com.tencent.luggage.wxa.kj.v a16 = o1.a(dVar);
        if (a16 != null && a16.X() != null && (drawnStatusBarHeight = a16.X().getDrawnStatusBarHeight()) != 0) {
            return drawnStatusBarHeight;
        }
        c.C6887c statusBar = dVar.D().getStatusBar();
        com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiGetSystemInfoLU", "getIntersectStatusBarHeight with component(%s %s), use windowStatusBar[%s]", dVar.getAppId(), dVar.getClass().getName(), statusBar);
        if (statusBar != null) {
            return statusBar.f144267a;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.jg.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map b(com.tencent.luggage.wxa.ic.d dVar) {
        Map b16 = super.b((com.tencent.luggage.wxa.xd.d) dVar);
        Context context = dVar.getContext();
        int[] b17 = n0.b(dVar);
        b16.put("windowWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(context, b17[0])));
        b16.put("windowHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(context, b17[1])));
        int[] a16 = n0.a((com.tencent.luggage.wxa.xd.i) dVar);
        int i3 = a16[0];
        int i16 = a16[1];
        b16.put("screenWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(context, i3)));
        b16.put("screenHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(context, i16)));
        b16.put("pixelRatio", Float.valueOf(com.tencent.luggage.wxa.tk.g.a(context)));
        b16.put("statusBarHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(context, b(dVar))));
        b16.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.tencent.luggage.wxa.tn.u.a(dVar.getContext()));
        b16.put("version", com.tencent.luggage.wxa.tn.f.a(null, com.tencent.luggage.wxa.tn.e.f141563e));
        if (dVar.getRuntime() != null && dVar.getRuntime().j0() != null) {
            b16.put("benchmarkLevel", Integer.valueOf(((com.tencent.luggage.wxa.j4.g) dVar.getRuntime().j0()).f130829e0));
        }
        if (dVar.getRuntime() != null && dVar.getRuntime().E() != null && dVar.getRuntime().E().k()) {
            b16.put("theme", com.tencent.luggage.wxa.h6.l.f126905a.a(dVar.getAppId()) ? MiniAppConst.MENU_STYLE_DARK : MiniAppConst.MENU_STYLE_LIGHT);
        }
        try {
            b16.put("screenTop", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(dVar.getContext(), n0.c((com.tencent.luggage.wxa.xd.i) dVar))));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiGetSystemInfoLU", e16.getMessage());
        }
        int i17 = dVar.getContext().getResources().getConfiguration().orientation;
        if (2 == i17) {
            b16.put("deviceOrientation", "landscape");
        } else if (1 == i17) {
            b16.put("deviceOrientation", "portrait");
        }
        a(b16, dVar);
        b(b16, dVar);
        a(b16, dVar, i3, i16);
        a(dVar, b16);
        return b16;
    }

    public final void b(Map map, com.tencent.luggage.wxa.ic.d dVar) {
        HashMap hashMap = new HashMap();
        Context context = dVar.getContext();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (context != null) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                hashMap.put("wifiEnabled", Boolean.valueOf(wifiManager.isWifiEnabled()));
            } else {
                hashMap.put("wifiEnabled", Boolean.FALSE);
            }
            hashMap.put("notificationAuthorized", Boolean.valueOf(NotificationManagerCompat.from(context).areNotificationsEnabled()));
            hashMap.put("locationEnabled", Boolean.valueOf(com.tencent.luggage.wxa.tn.v.a()));
            try {
                hashMap.put("locationAuthorized", Boolean.valueOf(com.tencent.luggage.wxa.h6.k.a(context, "android.permission.ACCESS_FINE_LOCATION")));
                hashMap.put("cameraAuthorized", Boolean.valueOf(com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.CAMERA)));
                hashMap.put("microphoneAuthorized", Boolean.valueOf(com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.RECORD_AUDIO)));
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions exception", e16);
                Boolean bool = Boolean.FALSE;
                hashMap.put("locationAuthorized", bool);
                hashMap.put("cameraAuthorized", bool);
                hashMap.put("microphoneAuthorized", bool);
            }
            boolean z16 = defaultAdapter != null;
            if (z16 && Build.VERSION.SDK_INT >= 31) {
                z16 = com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_CONNECT) && com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_SCAN) && com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
            }
            hashMap.put("bluetoothAuthorized", Boolean.valueOf(z16));
        } else {
            Boolean bool2 = Boolean.FALSE;
            hashMap.put("wifiEnabled", bool2);
            hashMap.put("notificationAuthorized", bool2);
            hashMap.put("locationEnabled", bool2);
            hashMap.put("locationAuthorized", bool2);
            hashMap.put("cameraAuthorized", bool2);
            hashMap.put("microphoneAuthorized", bool2);
        }
        if (defaultAdapter != null) {
            hashMap.put("bluetoothEnabled", Boolean.valueOf(defaultAdapter.isEnabled()));
        } else {
            hashMap.put("bluetoothEnabled", Boolean.FALSE);
        }
        hashMap.put("phoneCalendarAuthorized", Boolean.TRUE);
        com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions:%s", hashMap);
        map.putAll(hashMap);
    }

    public static void a(Map map, com.tencent.luggage.wxa.ic.d dVar, int i3, int i16) {
        HashMap hashMap = new HashMap(6);
        Rect safeAreaInsets = dVar.D().getSafeAreaInsets();
        Context context = dVar.D().getContext();
        if (safeAreaInsets != null) {
            int a16 = com.tencent.luggage.wxa.tk.g.a(context, safeAreaInsets.left);
            int a17 = com.tencent.luggage.wxa.tk.g.a(context, safeAreaInsets.top);
            int a18 = com.tencent.luggage.wxa.tk.g.a(context, Math.min(safeAreaInsets.right, i3));
            int a19 = com.tencent.luggage.wxa.tk.g.a(context, Math.min(safeAreaInsets.bottom, i16));
            hashMap.put("left", Integer.valueOf(a16));
            hashMap.put("top", Integer.valueOf(a17));
            hashMap.put("right", Integer.valueOf(a18));
            hashMap.put("bottom", Integer.valueOf(a19));
            hashMap.put("width", Integer.valueOf(a18 - a16));
            hashMap.put("height", Integer.valueOf(a19 - a17));
            map.put("safeArea", hashMap);
        }
    }

    public static void a(Map map, com.tencent.luggage.wxa.ic.d dVar) {
        com.tencent.luggage.wxa.k0.d.a(dVar.b(e.class));
        map.put("fontSizeSetting", Integer.valueOf(Math.round(16.0f)));
        map.put("fontSizeScaleFactor", Float.valueOf(1.0f));
    }
}
