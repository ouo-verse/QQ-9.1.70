package com.tencent.luggage.wxa.xn;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xn.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c extends d {

    /* renamed from: c, reason: collision with root package name */
    public int f145163c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final b f145164d;

    /* renamed from: e, reason: collision with root package name */
    public final a.C6921a f145165e;

    /* renamed from: f, reason: collision with root package name */
    public final String f145166f;

    public c(b bVar, a.C6921a c6921a, String str, String[] strArr) {
        String str2;
        this.f145164d = bVar;
        this.f145165e = c6921a;
        if (w0.c(c6921a.f145159b)) {
            str2 = "rowid";
        } else {
            str2 = c6921a.f145159b;
        }
        c6921a.f145159b = str2;
        this.f145166f = str;
        a(strArr);
    }

    public static String a(a.C6921a c6921a, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        sb5.append(c6921a.f145162e);
        sb5.append(");");
        return sb5.toString();
    }

    public boolean b(a aVar, String... strArr) {
        ContentValues a16 = aVar.a();
        if (a16 != null && a16.size() > 0) {
            if (strArr != null && strArr.length > 0) {
                StringBuilder a17 = a(a16, strArr);
                if (a17 == null) {
                    e("get failed, check keys failed");
                    return false;
                }
                Cursor a18 = this.f145164d.a(d(), this.f145165e.f145160c, a17.toString(), a(strArr, a16), null, null, null, 2);
                if (a18.moveToFirst()) {
                    aVar.a(a18);
                    a18.close();
                    return true;
                }
                a18.close();
                c("get failed, not found");
                return false;
            }
            Cursor a19 = this.f145164d.a(d(), this.f145165e.f145160c, this.f145165e.f145159b + " = ?", new String[]{w0.d(a16.getAsString(this.f145165e.f145159b))}, null, null, null, 2);
            if (a19.moveToFirst()) {
                aVar.a(a19);
                a19.close();
                return true;
            }
            a19.close();
            return false;
        }
        e("get failed, value.size <= 0");
        return false;
    }

    public boolean c(a aVar, String... strArr) {
        return b(aVar, true, strArr);
    }

    public String d() {
        return this.f145166f;
    }

    public final void e(String str) {
        w.b("MicroMsg.SDK.MAutoStorage", d() + ":" + str);
    }

    public final void c(String str) {
        w.a("MicroMsg.SDK.MAutoStorage", d() + ":" + str);
    }

    public static List a(a.C6921a c6921a, String str, b bVar) {
        ArrayList arrayList = new ArrayList();
        if (bVar != null && str != null) {
            Cursor a16 = bVar.a("PRAGMA table_info( " + str + " )", new String[0], 2);
            if (a16 == null) {
                return arrayList;
            }
            HashMap hashMap = new HashMap();
            int columnIndex = a16.getColumnIndex("name");
            int columnIndex2 = a16.getColumnIndex("type");
            while (a16.moveToNext()) {
                hashMap.put(a16.getString(columnIndex), a16.getString(columnIndex2));
            }
            a16.close();
            for (Map.Entry entry : c6921a.f145161d.entrySet()) {
                String str2 = (String) entry.getValue();
                String str3 = (String) entry.getKey();
                if (str2 != null && str2.length() > 0) {
                    String str4 = (String) hashMap.get(str3);
                    if (str4 == null) {
                        arrayList.add("ALTER TABLE " + str + " ADD COLUMN " + str3 + " " + str2 + ";");
                        hashMap.remove(str3);
                    } else if (!str2.toLowerCase().startsWith(str4.toLowerCase())) {
                        w.b("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + str3 + ", " + str4 + "<o-n>" + str2);
                        hashMap.remove(str3);
                    }
                }
            }
            return arrayList;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = str;
        w.b("MicroMsg.SDK.MAutoStorage", "dk getUpdateSQLs db==null :%b  table:%s", objArr);
        return arrayList;
    }

    public boolean b(a aVar, boolean z16, String... strArr) {
        ContentValues a16 = aVar.a();
        if (a16 != null && a16.size() > 0) {
            if (strArr != null && strArr.length > 0) {
                StringBuilder a17 = a(a16, strArr);
                if (a17 == null) {
                    e("update failed, check keys failed");
                    return false;
                }
                if (this.f145164d.a(d(), a16, a17.toString(), a(strArr, a16)) <= 0) {
                    e("update failed");
                    return false;
                }
                if (z16) {
                    a(a16.getAsString(this.f145165e.f145159b), 3, aVar);
                }
                return true;
            }
            c("update with primary key");
            if (a(a16)) {
                c("no need replace , fields no change");
                return true;
            }
            b bVar = this.f145164d;
            String d16 = d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f145165e.f145159b);
            sb5.append(" = ?");
            boolean z17 = bVar.a(d16, a16, sb5.toString(), new String[]{w0.d(a16.getAsString(this.f145165e.f145159b))}) > 0;
            if (z17 && z16) {
                a(a16.getAsString(this.f145165e.f145159b), 3, aVar);
            }
            return z17;
        }
        e("update failed, value.size <= 0");
        return false;
    }

    public final void a(String[] strArr) {
        b bVar = this.f145164d;
        if (bVar == null) {
            return;
        }
        String str = this.f145166f;
        bVar.a(str, a(this.f145165e, str));
        List a16 = a(this.f145165e, d(), this.f145164d);
        for (int i3 = 0; i3 < a16.size(); i3++) {
            if (!this.f145164d.a(this.f145166f, (String) a16.get(i3))) {
                w.d("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", this.f145166f, a16.get(i3));
            }
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str2 : strArr) {
            this.f145164d.a(this.f145166f, str2);
        }
    }

    public boolean b(a aVar) {
        return b(aVar, true);
    }

    public boolean b(a aVar, boolean z16) {
        com.tencent.luggage.wxa.er.a.b("replace primaryKey == null", !w0.c(this.f145165e.f145159b));
        ContentValues a16 = aVar.a();
        if (a16 != null && a16.size() == aVar.b().f145158a.length + (a16.containsKey("rowid") ? 1 : 0)) {
            if (a(a16)) {
                c("no need replace , fields no change");
                return true;
            }
            long b16 = this.f145164d.b(d(), this.f145165e.f145159b, a16);
            aVar.f145157a = b16;
            boolean z17 = b16 > 0;
            if (z17 && z16) {
                a(this.f145165e.f145159b, 4, aVar);
                return true;
            }
            if (!z17) {
                e("replace failed");
            }
            return z17;
        }
        e("replace failed, cv.size() != item.fields().length");
        return false;
    }

    public boolean a(a aVar) {
        return a(aVar, true);
    }

    public boolean a(a aVar, boolean z16) {
        ContentValues a16 = aVar.a();
        if (a16 != null && a16.size() > 0) {
            long a17 = this.f145164d.a(d(), this.f145165e.f145159b, a16);
            aVar.f145157a = a17;
            if (a17 <= 0 && (!(aVar.d() instanceof Integer) || aVar.f145157a != ((Integer) aVar.d()).intValue())) {
                e("insert failed");
                return false;
            }
            a16.put("rowid", Long.valueOf(aVar.f145157a));
            if (!z16) {
                return true;
            }
            a(a16.getAsString(this.f145165e.f145159b), 2, aVar);
            return true;
        }
        e("insert failed, value.size <= 0");
        return false;
    }

    public boolean a(a aVar, boolean z16, String... strArr) {
        ContentValues a16 = aVar.a();
        if (a16 != null && a16.size() > 0) {
            if (strArr != null && strArr.length > 0) {
                StringBuilder a17 = a(a16, strArr);
                if (a17 == null) {
                    e("delete failed, check keys failed");
                    return false;
                }
                if (this.f145164d.a(d(), a17.toString(), a(strArr, a16)) > 0 && z16) {
                    a(a16.getAsString(this.f145165e.f145159b), 5, aVar);
                    return true;
                }
                e("delete failed");
                return false;
            }
            c("delete with primary key");
            b bVar = this.f145164d;
            String d16 = d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f145165e.f145159b);
            sb5.append(" = ?");
            boolean z17 = bVar.a(d16, sb5.toString(), new String[]{w0.d(a16.getAsString(this.f145165e.f145159b))}) > 0;
            if (z17 && z16) {
                a(a16.getAsString(this.f145165e.f145159b), 5, aVar);
            }
            return z17;
        }
        e("delete failed, value.size <= 0");
        return false;
    }

    public boolean a(a aVar, String... strArr) {
        return a(aVar, true, strArr);
    }

    public final boolean a(ContentValues contentValues) {
        Cursor a16 = this.f145164d.a(d(), this.f145165e.f145160c, this.f145165e.f145159b + " = ?", new String[]{w0.d(contentValues.getAsString(this.f145165e.f145159b))}, null, null, null);
        boolean a17 = a.a(contentValues, a16);
        a16.close();
        return a17;
    }

    public static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        for (String str : strArr) {
            sb5.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        sb5.append(" 1=1");
        return sb5;
    }

    public static String[] a(String[] strArr, ContentValues contentValues) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            strArr2[i3] = w0.d(contentValues.getAsString(strArr[i3]));
        }
        return strArr2;
    }
}
