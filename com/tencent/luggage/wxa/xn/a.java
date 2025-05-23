package com.tencent.luggage.wxa.xn;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public long f145157a = -1;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xn.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6921a {

        /* renamed from: a, reason: collision with root package name */
        public Field[] f145158a;

        /* renamed from: b, reason: collision with root package name */
        public String f145159b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f145160c;

        /* renamed from: d, reason: collision with root package name */
        public Map f145161d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public String f145162e;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null && bArr2 != null) {
            return false;
        }
        if ((bArr != null && bArr2 == null) || bArr.length != bArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public abstract ContentValues a();

    public abstract void a(Cursor cursor);

    public abstract C6921a b();

    public abstract com.tencent.luggage.wxa.zn.c c();

    public abstract Object d();

    public static boolean a(ContentValues contentValues, Cursor cursor) {
        if (contentValues == null) {
            return cursor == null;
        }
        if (cursor != null && cursor.getCount() == 1) {
            cursor.moveToFirst();
            int columnCount = cursor.getColumnCount();
            int size = contentValues.size();
            if (contentValues.containsKey("rowid")) {
                size--;
            }
            if (cursor.getColumnIndex("rowid") != -1) {
                columnCount--;
            }
            if (size != columnCount) {
                return false;
            }
            try {
                Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!key.equals("rowid")) {
                        int columnIndex = cursor.getColumnIndex(key);
                        if (columnIndex == -1) {
                            return false;
                        }
                        if (contentValues.get(key) instanceof byte[]) {
                            if (!a((byte[]) contentValues.get(key), cursor.getBlob(columnIndex))) {
                                return false;
                            }
                        } else if ((cursor.getString(columnIndex) == null && contentValues.get(key) != null) || contentValues.get(key) == null || !contentValues.get(key).toString().equals(cursor.getString(columnIndex))) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e16) {
                w.a("MicroMsg.SDK.IAutoDBItem", e16, "", new Object[0]);
            }
        }
        return false;
    }
}
