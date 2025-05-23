package com.tencent.map.geolocation.internal;

import android.location.Location;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.t.m.g.a0;
import c.t.m.g.c0;
import c.t.m.g.o3;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentExtraKeys {
    public static boolean COMPHTTPIO = false;
    public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
    public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
    public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
    public static final String LOCATION_KEY_LOCALITY = "locality";
    public static final String LOCATION_KEY_NATION = "nation";
    public static final String LOCATION_KEY_ROUTE = "route";
    public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
    public static final String LOCATION_SOURCE_CELL = "cell";
    public static final String LOCATION_SOURCE_GPS = "gps";
    public static final String LOCATION_SOURCE_WIFI = "wifi";
    public static boolean MOCK_LOCATION_FILTER = true;
    public static final String RAW_DATA = "raw_data";
    public static final String REQUEST_RAW_DATA = "request_raw_data";
    public static final boolean START_LOCAL_SERVER = false;
    public static final boolean STRICT_CELL_FILTER = true;
    public static final boolean TENCENT_INTERNAL = true;
    private static File sLogDir;
    private static TencentLog sTencentLog;
    public static final TencentLog DEFAULT_TENCENT_LOG = new a();
    private static List<TencentLog> sTencentLogs = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements TencentLog {
        @Override // com.tencent.map.geolocation.internal.TencentLog
        public String getDirString() {
            return null;
        }

        @Override // com.tencent.map.geolocation.internal.TencentLog
        public void println(String str, int i3, @NonNull String str2) {
            if (i3 == 4) {
                Log.i(str, str2);
            } else {
                Log.e(str, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements c0 {
        public b() {
        }

        @Override // c.t.m.g.c0
        public void a(int i3, String str, String str2, Throwable th5) {
            b(i3, str, str2, th5);
        }

        public final void b(int i3, String str, String str2, Throwable th5) {
            if (th5 == null) {
                if (i3 == 3) {
                    o3.b(str, str2);
                    return;
                } else {
                    if (i3 == 6) {
                        o3.a(str, str2);
                        return;
                    }
                    return;
                }
            }
            o3.a(str, str2, th5);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized void addTencentLog(TencentLog tencentLog) {
        boolean z16;
        synchronized (TencentExtraKeys.class) {
            Iterator<TencentLog> it = sTencentLogs.iterator();
            while (true) {
                if (it.hasNext()) {
                    TencentLog next = it.next();
                    if (next.getDirString() != null && next.getDirString().equals(tencentLog.getDirString())) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                sTencentLogs.add(tencentLog);
                b bVar = null;
                byte b16 = 0;
                if (tencentLog != null) {
                    bVar = new b(b16 == true ? 1 : 0);
                }
                a0.a(bVar);
            }
        }
    }

    public static String getLocationSource(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return "";
        }
        boolean isFromGps = TencentLocationUtils.isFromGps(tencentLocation);
        boolean isFromNetwork = TencentLocationUtils.isFromNetwork(tencentLocation);
        int i3 = tencentLocation.getExtra().getInt("wifi_ap_num");
        if (isFromGps) {
            return "gps";
        }
        if (isFromNetwork && i3 >= 3) {
            return "wifi";
        }
        return "cell";
    }

    public static synchronized File getLogDir() {
        File file;
        synchronized (TencentExtraKeys.class) {
            file = sLogDir;
        }
        return file;
    }

    public static byte[] getRawData(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra().getByteArray("raw_data");
    }

    public static Location getRawGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return (Location) tencentLocation.getExtra().getParcelable("raw_gps");
    }

    public static String getRawQuery(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra().getString("raw_query");
    }

    @Nullable
    public static synchronized List<TencentLog> getTencentLogs() {
        List<TencentLog> list;
        synchronized (TencentExtraKeys.class) {
            list = sTencentLogs;
        }
        return list;
    }

    public static boolean isAllowedLevel(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 3 || i3 == 4 || i3 == 7) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static synchronized boolean isDebugEnabled() {
        boolean z16;
        synchronized (TencentExtraKeys.class) {
            if (sTencentLog != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public static boolean isRequestRawData(TencentLocationRequest tencentLocationRequest) {
        if (tencentLocationRequest == null) {
            return false;
        }
        return tencentLocationRequest.getExtras().getBoolean("request_raw_data");
    }

    public static void loadLibrary(String str) {
        System.load(str);
    }

    public static synchronized boolean removeTencentLog(TencentLog tencentLog) {
        boolean remove;
        synchronized (TencentExtraKeys.class) {
            a0.a(null);
            remove = sTencentLogs.remove(tencentLog);
        }
        return remove;
    }

    public static synchronized void setLogDir(File file) {
        synchronized (TencentExtraKeys.class) {
            sLogDir = file;
        }
    }

    public static TencentLocation setRawData(TencentLocation tencentLocation, byte[] bArr) {
        tencentLocation.getExtra().putByteArray("raw_data", bArr);
        return tencentLocation;
    }

    public static void setRawGps(TencentLocation tencentLocation, Location location) {
        if (tencentLocation == null) {
            return;
        }
        tencentLocation.getExtra().putParcelable("raw_gps", location);
    }

    public static void setRawQuery(TencentLocation tencentLocation, String str) {
        if (tencentLocation == null) {
            return;
        }
        tencentLocation.getExtra().putString("raw_query", str);
    }

    public static TencentLocationRequest setRequestRawData(TencentLocationRequest tencentLocationRequest, boolean z16) {
        if (tencentLocationRequest != null) {
            tencentLocationRequest.getExtras().putBoolean("request_raw_data", z16);
        }
        return tencentLocationRequest;
    }
}
