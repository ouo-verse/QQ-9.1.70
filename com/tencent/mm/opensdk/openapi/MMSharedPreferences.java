package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import py3.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";

    /* renamed from: cr, reason: collision with root package name */
    private final ContentResolver f151803cr;
    private final String[] columns = {"_id", "key", "type", "value"};
    private final HashMap<String, Object> values = new HashMap<>();
    private REditor editor = null;

    public MMSharedPreferences(Context context) {
        this.f151803cr = context.getContentResolver();
    }

    private Object getValue(String str) {
        Object obj;
        try {
            Cursor query = ContactsMonitor.query(this.f151803cr, a.f151805a, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("type");
            int columnIndex2 = query.getColumnIndex("value");
            if (query.moveToFirst()) {
                obj = com.tencent.mm.opensdk.channel.a.a.a(query.getInt(columnIndex), query.getString(columnIndex2));
            } else {
                obj = null;
            }
            query.close();
            return obj;
        } catch (Exception e16) {
            Log.e(TAG, "getValue exception:" + e16.getMessage());
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (getValue(str) != null) {
            return true;
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new REditor(this.f151803cr);
        }
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            Cursor query = ContactsMonitor.query(this.f151803cr, a.f151805a, this.columns, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), com.tencent.mm.opensdk.channel.a.a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.values;
        } catch (Exception e16) {
            Log.e(TAG, "getAll exception:" + e16.getMessage());
            return this.values;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        Object value = getValue(str);
        if (value != null && (value instanceof Boolean)) {
            return ((Boolean) value).booleanValue();
        }
        return z16;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        Object value = getValue(str);
        if (value != null && (value instanceof Float)) {
            return ((Float) value).floatValue();
        }
        return f16;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        Object value = getValue(str);
        if (value != null && (value instanceof Integer)) {
            return ((Integer) value).intValue();
        }
        return i3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        Object value = getValue(str);
        if (value != null && (value instanceof Long)) {
            return ((Long) value).longValue();
        }
        return j3;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object value = getValue(str);
        if (value != null && (value instanceof String)) {
            return (String) value;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    /* loaded from: classes9.dex */
    private static class REditor implements SharedPreferences.Editor {

        /* renamed from: cr, reason: collision with root package name */
        private ContentResolver f151804cr;
        private Map<String, Object> values = new HashMap();
        private Set<String> remove = new HashSet();
        private boolean clear = false;

        public REditor(ContentResolver contentResolver) {
            this.f151804cr = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean commit() {
            String str;
            int i3;
            boolean z16;
            ContentValues contentValues = new ContentValues();
            if (this.clear) {
                b.e(this.f151804cr, a.f151805a, null, null);
                this.clear = false;
            }
            Iterator<String> it = this.remove.iterator();
            while (it.hasNext()) {
                b.e(this.f151804cr, a.f151805a, "key = ?", new String[]{it.next()});
            }
            for (Map.Entry<String, Object> entry : this.values.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    str = "unresolve failed, null value";
                } else {
                    if (value instanceof Integer) {
                        i3 = 1;
                    } else if (value instanceof Long) {
                        i3 = 2;
                    } else if (value instanceof String) {
                        i3 = 3;
                    } else if (value instanceof Boolean) {
                        i3 = 4;
                    } else if (value instanceof Float) {
                        i3 = 5;
                    } else if (value instanceof Double) {
                        i3 = 6;
                    } else {
                        str = "unresolve failed, unknown type=" + value.getClass().toString();
                    }
                    if (i3 != 0) {
                        z16 = false;
                    } else {
                        contentValues.put("type", Integer.valueOf(i3));
                        contentValues.put("value", value.toString());
                        z16 = true;
                    }
                    if (!z16) {
                        this.f151804cr.update(a.f151805a, contentValues, "key = ?", new String[]{entry.getKey()});
                    }
                }
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", str);
                i3 = 0;
                if (i3 != 0) {
                }
                if (!z16) {
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            this.values.put(str, Boolean.valueOf(z16));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            this.values.put(str, Float.valueOf(f16));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            this.values.put(str, Integer.valueOf(i3));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            this.values.put(str, Long.valueOf(j3));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.remove.add(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
