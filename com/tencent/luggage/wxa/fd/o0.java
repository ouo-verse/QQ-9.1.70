package com.tencent.luggage.wxa.fd;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.r0;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f125949a = Uri.parse("content://" + com.tencent.luggage.wxa.o7.a.f136193a + "/WxaAttributesTable");

    /* renamed from: b, reason: collision with root package name */
    public static final o0 f125950b = new o0();

    public static o0 a() {
        return f125950b;
    }

    public n0 b(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long a16 = w0.a();
        n0 a17 = a(strArr, String.format(Locale.ENGLISH, "%s=?", "username"), new String[]{str});
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrsContentResolver", "queryWithUsername username:%s, cost:%dms, columns:%s", str, Long.valueOf(w0.a() - a16), Arrays.toString(strArr));
        return a17;
    }

    public long c(String str) {
        n0 a16 = a(new String[]{"syncTimeSecond"}, String.format("%s=?", "appId"), new String[]{str});
        if (a16 != null) {
            return a16.N;
        }
        return 0L;
    }

    public com.tencent.luggage.wxa.fn.c d(String str) {
        n0 a16 = a(new String[]{"syncVersion"}, String.format("%s=?", "appId"), new String[]{str});
        if (a16 != null && !TextUtils.isEmpty(a16.P)) {
            return k0.b(a16);
        }
        return new com.tencent.luggage.wxa.fn.c(new byte[0]);
    }

    public n0 a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long a16 = w0.a();
        n0 a17 = a(strArr, String.format(Locale.ENGLISH, "%s=?", "appId"), new String[]{str});
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrsContentResolver", "queryWithAppId appId:%s, cost:%dms, columns:%s", str, Long.valueOf(w0.a() - a16), Arrays.toString(strArr));
        return a17;
    }

    public boolean b(String str, se seVar) {
        if (seVar != null && !TextUtils.isEmpty(str)) {
            try {
                byte[] b16 = seVar.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("CONTENT_KEY_SYNC_PROTO", b16);
                contentValues.put("CONTENT_KEY_APPID", str);
                com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f125949a, contentValues);
                return true;
            } catch (Exception unused) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrsContentResolver", "updateAttrsWithProto insert failed");
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long a16 = w0.a();
        try {
            Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f125949a, new String[]{"username"}, String.format(Locale.ENGLISH, "%s=?", "appId"), new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        z16 = true;
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Throwable th5) {
                                th = th5;
                                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrsContentResolver", "containsAppId(%s) cost:%dms ret:%b", str, Long.valueOf(w0.a() - a16), Boolean.valueOf(z16));
                                throw th;
                            }
                        }
                        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrsContentResolver", "containsAppId(%s) cost:%dms ret:%b", str, Long.valueOf(w0.a() - a16), Boolean.valueOf(z16));
                        return z16;
                    }
                } finally {
                }
            }
            z16 = false;
            if (query != null) {
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAttrsContentResolver", "containsAppId(%s) cost:%dms ret:%b", str, Long.valueOf(w0.a() - a16), Boolean.valueOf(z16));
            return z16;
        } catch (Throwable th6) {
            th = th6;
            z16 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r2.moveToFirst() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        r3 = r2.getColumnIndex("appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
    
        if (r3 < 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        r0.add(r2.getString(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r2.moveToNext() != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List b() {
        LinkedList linkedList = new LinkedList();
        Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f125949a, new String[]{"appId"}, null, null, null);
        if (query != null) {
            try {
                if (!query.isClosed()) {
                }
            } catch (Throwable th5) {
                try {
                    query.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
        if (query != null) {
            query.close();
        }
        return linkedList;
    }

    public boolean a(int i3, r0 r0Var) {
        if (r0Var == null) {
            return false;
        }
        try {
            byte[] b16 = r0Var.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_BATCH_SYNC_SCENE", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_BATCH_SYNC_PROTO", b16);
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f125949a, contentValues);
            return true;
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrsContentResolver", "batchUpdateWithProto insert failed");
            return false;
        }
    }

    public String b(String str) {
        n0 a16 = a(str, "username");
        if (a16 != null) {
            return a16.f138465d;
        }
        return null;
    }

    public boolean a(String str, se seVar) {
        if (seVar != null && !TextUtils.isEmpty(str)) {
            try {
                byte[] b16 = seVar.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("CONTENT_KEY_SYNC_PROTO", b16);
                contentValues.put("CONTENT_KEY_USERNAME", str);
                com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f125949a, contentValues);
                return true;
            } catch (Exception unused) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrsContentResolver", "updateAttrsWithProto insert failed");
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (r14.moveToFirst() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        r5 = new com.tencent.luggage.wxa.fd.n0();
        r5.a(r14);
        r0.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        if (r14.moveToNext() != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List a(List list, String... strArr) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList.set(i3, String.format(Locale.ENGLISH, "'%s'", arrayList.get(i3)));
            }
            try {
                Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f125949a, strArr.length <= 0 ? null : strArr, String.format(Locale.ENGLISH, "%s in (%s)", "appId", StringUtils.join(arrayList, ",")), null, null);
                try {
                    LinkedList linkedList = new LinkedList();
                    if (query != null) {
                    }
                    if (query != null) {
                        query.close();
                    }
                    return linkedList;
                } finally {
                }
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaAttrsContentResolver", "batchQueryWithAppIds appIdList.size:%d, t=%s", Integer.valueOf(list.size()), th5);
                return null;
            }
        }
        return Collections.emptyList();
    }

    public final n0 a(String[] strArr, String str, String[] strArr2) {
        Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f125949a, strArr, str, strArr2, null);
        n0 n0Var = null;
        if (query == null) {
            return null;
        }
        if (!query.isClosed() && query.moveToFirst()) {
            n0Var = new n0();
            n0Var.a(query);
        }
        query.close();
        return n0Var;
    }
}
