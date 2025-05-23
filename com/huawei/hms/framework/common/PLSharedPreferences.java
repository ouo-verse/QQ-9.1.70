package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PLSharedPreferences {
    private static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
    private static final String TAG = "PLSharedPreferences";

    /* renamed from: sp, reason: collision with root package name */
    private final SharedPreferences f36905sp;

    public PLSharedPreferences(Context context, String str) {
        this.f36905sp = getSharedPreferences(context, str);
    }

    private SharedPreferences getSharedPreferences(Context context, String str) {
        Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (context == null) {
            Logger.e(TAG, "context is null, must call init method to set context");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences(MOVE_TO_DE_RECORDS, 0);
            if (!sharedPreferences.getBoolean(str, false)) {
                moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str);
                if (moveSharedPreferencesFrom) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
            }
            context = createDeviceProtectedStorageContext;
        }
        return context.getSharedPreferences(str, 0);
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public Map<String, ?> getAll() {
        int size;
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sp size ");
        if (all == null) {
            size = 0;
        } else {
            size = all.size();
        }
        sb5.append(size);
        Logger.i(TAG, sb5.toString());
        return all;
    }

    public Map<String, String> getHashMap(String str) {
        HashMap hashMap = new HashMap();
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return hashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, ""));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i16 = 0; i16 < names.length(); i16++) {
                        String string = names.getString(i16);
                        hashMap.put(string, jSONObject.getString(string));
                    }
                }
            }
        } catch (JSONException e16) {
            Logger.w(TAG, "getHashMap parse Json to map error: %s", StringUtils.anonymizeMessage(e16.getMessage()));
        }
        return hashMap;
    }

    public long getLong(String str, long j3) {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return j3;
        }
        return sharedPreferences.getLong(str, j3);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public void putHashMap(String str, Map<String, String> map) {
        if (this.f36905sp != null && map != null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e16) {
                    Logger.w(TAG, "putHashMap one object error: %s", StringUtils.anonymizeMessage(e16.getMessage()));
                }
            }
            jSONArray.mo162put(jSONObject);
            this.f36905sp.edit().putString(str, jSONArray.toString()).apply();
        }
    }

    public void putLong(String str, long j3) {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j3).apply();
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void removeKeyValue(String str) {
        SharedPreferences sharedPreferences = this.f36905sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f36905sp;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }
}
