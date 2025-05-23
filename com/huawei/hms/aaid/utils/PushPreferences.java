package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class PushPreferences {
    public static final String TAG = "PushPreferences";

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f36603a;

    public PushPreferences(Context context, String str) {
        Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
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
            SharedPreferences b16 = b(context, str);
            this.f36603a = b16;
            if (b16 == null) {
                HMSLog.w(TAG, "get new sharedPreferences failed,start to get from context. ");
                this.f36603a = context.getSharedPreferences(str, 0);
                return;
            }
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public final File a(Context context, String str) {
        File file;
        File dataDir;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb5 = new StringBuilder();
                dataDir = context.getDataDir();
                sb5.append(dataDir);
                sb5.append("/shared_prefs");
                file = new File(sb5.toString(), str + ".xml");
            } else {
                file = new File(context.getFilesDir().getParent() + "/shared_prefs", str + ".xml");
            }
            if (!file.exists()) {
                return null;
            }
            return file;
        } catch (Exception e16) {
            HMSLog.e(TAG, "get failed error." + e16.getMessage());
            return null;
        }
    }

    public final SharedPreferences b(Context context, String str) {
        File a16 = a(context, str);
        if (a16 == null) {
            return null;
        }
        try {
            Constructor<?> declaredConstructor = Class.forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(File.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return (SharedPreferences) declaredConstructor.newInstance(a16, 0);
        } catch (Exception e16) {
            HMSLog.e(TAG, "get SharedPreferences error." + e16.getMessage());
            return null;
        }
    }

    public boolean clear() {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public boolean containsKey(String str) {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            return true;
        }
        return false;
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return new HashMap();
    }

    public boolean getBoolean(String str) {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null || !sharedPreferences.getBoolean(str, false)) {
            return false;
        }
        return true;
    }

    public int getInt(String str) {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    public long getLong(String str) {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str, "");
    }

    public ContentValues read() {
        Map<String, ?> all;
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(key, String.valueOf(value));
            } else if (!(value instanceof Integer) && !(value instanceof Short) && !(value instanceof Byte)) {
                if (value instanceof Long) {
                    contentValues.put(key, (Long) value);
                } else if (value instanceof Float) {
                    contentValues.put(key, (Float) value);
                } else if (value instanceof Double) {
                    contentValues.put(key, Float.valueOf((float) ((Double) value).doubleValue()));
                } else if (value instanceof Boolean) {
                    contentValues.put(key, (Boolean) value);
                }
            } else {
                contentValues.put(key, (Integer) value);
            }
        }
        return contentValues;
    }

    public boolean removeKey(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.f36603a.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }

    public boolean save(String str, Object obj) {
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof String) {
            edit.putString(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            edit.putInt(str, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            edit.putInt(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            edit.putFloat(str, (float) ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return edit.commit();
    }

    public void saveBoolean(String str, boolean z16) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putBoolean(str, z16).commit();
        }
    }

    public void saveInt(String str, Integer num) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt(str, num.intValue()).commit();
        }
    }

    public void saveLong(String str, Long l3) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putLong(str, l3.longValue()).commit();
        }
    }

    public void saveMap(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            save(entry.getKey(), entry.getValue());
        }
    }

    public boolean saveString(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36603a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public boolean write(ContentValues contentValues) {
        if (this.f36603a == null || contentValues == null) {
            return false;
        }
        boolean z16 = true;
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            if (!save(entry.getKey(), entry.getValue())) {
                z16 = false;
            }
        }
        return z16;
    }

    public boolean removeKey(String[] strArr) {
        if (this.f36603a == null) {
            return false;
        }
        for (String str : strArr) {
            if (this.f36603a.contains(str)) {
                this.f36603a.edit().remove(str);
            }
        }
        this.f36603a.edit().commit();
        return true;
    }
}
