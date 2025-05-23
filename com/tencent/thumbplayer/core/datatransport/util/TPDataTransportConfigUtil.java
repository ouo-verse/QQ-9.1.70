package com.tencent.thumbplayer.core.datatransport.util;

import android.content.SharedPreferences;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportFactory;

/* loaded from: classes26.dex */
public class TPDataTransportConfigUtil {
    private static final String DATA_TRANSPORT_CONFIG_KEY = "tp_data_transport_config";

    /* renamed from: sp, reason: collision with root package name */
    private static SharedPreferences f376099sp;

    public static boolean getBooleanConfig(String str, boolean z16) {
        if (getSharedPreferences() != null) {
            return f376099sp.getBoolean(str, z16);
        }
        return z16;
    }

    public static int getIntConfig(String str, int i3) {
        if (getSharedPreferences() != null) {
            return f376099sp.getInt(str, i3);
        }
        return i3;
    }

    private static SharedPreferences getSharedPreferences() {
        if (f376099sp == null && TPDataTransportFactory.getInstance().getContext() != null) {
            f376099sp = TPDataTransportFactory.getInstance().getContext().getSharedPreferences(DATA_TRANSPORT_CONFIG_KEY, 0);
        }
        return f376099sp;
    }

    public static void putBooleanConfig(String str, boolean z16) {
        if (getSharedPreferences() != null) {
            SharedPreferences.Editor edit = f376099sp.edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }
    }

    public static void putIntConfig(String str, int i3) {
        if (getSharedPreferences() != null) {
            SharedPreferences.Editor edit = f376099sp.edit();
            edit.putInt(str, i3);
            edit.apply();
        }
    }
}
