package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.common.cache.IProcessContextStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bl implements IProcessContextStorage {

    /* renamed from: a, reason: collision with root package name */
    private long f98295a = 0;

    private static void a(ae aeVar, String str, String[] strArr) {
        try {
            int a16 = aeVar.a("t_p_ctx", str, strArr);
            if (a16 < 0) {
                av.a("ProcessContext, deleteExpiredData fail result: %s", Integer.valueOf(a16));
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    private static ContentValues b(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_process_launch_id", str);
        contentValues.put("_key", str2);
        if (str3 == null) {
            str3 = "";
        }
        contentValues.put("_value", str3);
        contentValues.put("_tm", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextStorage
    public final void clearData(String str) {
        ae a16 = ae.a();
        if (a16 == null) {
            return;
        }
        a(a16, "_process_launch_id = ?", new String[]{String.valueOf(str)});
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextStorage
    public final void clearExpiredData() {
        b();
        clearData(a());
        a("clear expired data");
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextStorage
    public final Map<String, String> load(String str) {
        ae a16;
        Cursor cursor = null;
        if (TextUtils.isEmpty(str) || (a16 = ae.a()) == null) {
            return null;
        }
        b();
        HashMap hashMap = new HashMap();
        try {
            cursor = a16.a(false, "t_p_ctx", new String[]{"_process_launch_id", "_key", "_value", "_tm"}, "_process_launch_id = ? ", new String[]{str}, null, "_tm desc", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("_key"));
                    String string2 = cursor.getString(cursor.getColumnIndex("_value"));
                    if (!TextUtils.isEmpty(string)) {
                        if (string2 == null) {
                            string2 = "";
                        }
                        hashMap.put(string, string2);
                    }
                }
            }
        } catch (Throwable unused) {
            av.c("ProcessContext, load count:%s", 0);
        }
        a(cursor);
        a("load");
        return hashMap;
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextStorage
    public final void update(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, str2, str3);
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextStorage
    public final void update(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return;
        }
        b();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a(str, key, entry.getValue());
            }
        }
        a("update-map");
    }

    private static List<String> a() {
        ae a16 = ae.a();
        Cursor cursor = null;
        if (a16 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = a16.a(true, "t_p_ctx", new String[]{"_process_launch_id", "count(*) as ".concat("count"), "max(_tm) as ".concat("max_time")}, null, null, "_process_launch_id", "max_time desc", null);
            if (cursor != null) {
                int i3 = 0;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("_process_launch_id"));
                    int i16 = cursor.getInt(cursor.getColumnIndex("count"));
                    if (i16 >= 0) {
                        i3 += i16;
                    }
                    if (i3 >= 10000) {
                        arrayList.add(string);
                    }
                }
            }
            av.c("ProcessContext, query expired process launch id size {%s}", Integer.valueOf(arrayList.size()));
        } catch (Throwable th5) {
            av.b(th5);
        }
        a(cursor);
        return arrayList;
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextStorage
    public final void clearData(List<String> list) {
        ae a16;
        if (list == null || list.isEmpty() || (a16 = ae.a()) == null) {
            return;
        }
        int size = list.size();
        int i3 = ((size + 30) - 1) % 30;
        StringBuilder sb5 = new StringBuilder(1024);
        int i16 = 0;
        for (int i17 = 0; i17 < i3 && i16 < size; i17++) {
            sb5.setLength(0);
            sb5.append("_process_launch_id IN (");
            for (int i18 = 0; i18 < 30 && i16 < size; i18++) {
                if (i18 > 0) {
                    sb5.append(",");
                }
                sb5.append("\"");
                sb5.append(list.get(i16));
                sb5.append("\"");
                i16++;
            }
            sb5.append(")");
            a(a16, sb5.toString(), (String[]) null);
        }
    }

    private void b() {
        if (av.f98117c) {
            this.f98295a = SystemClock.elapsedRealtime();
        }
    }

    private static void a(String str, String str2, String str3) {
        ae a16 = ae.a();
        if (a16 == null) {
            return;
        }
        try {
            if (a16.a("t_p_ctx", b(str, str2, str3), (ad) null) < 0) {
                av.a("ProcessContext, update fail processLaunchID: %s, key: %s", str, str2);
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    private static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str) {
        if (av.f98117c) {
            av.c("ProcessContext %s cost %s ms", str, Long.valueOf(SystemClock.elapsedRealtime() - this.f98295a));
        }
    }
}
