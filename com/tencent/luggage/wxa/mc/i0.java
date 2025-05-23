package com.tencent.luggage.wxa.mc;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.jk.a;
import com.tencent.luggage.wxa.xn.a;
import java.util.Locale;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i0 extends d implements com.tencent.luggage.wxa.jk.a {

    /* renamed from: a0, reason: collision with root package name */
    public static final String[] f134312a0 = {String.format(Locale.ENGLISH, "CREATE INDEX IF NOT EXISTS %sPkgPathIndex ON %s(%s)", "AppBrandWxaPkgManifestRecordWithDesc", "AppBrandWxaPkgManifestRecordWithDesc", "pkgPath")};

    /* renamed from: b0, reason: collision with root package name */
    public static final String[] f134313b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final a.C6921a f134314c0;
    public String Z;

    static {
        String[] strArr = {"appId", "debugType", "versionDesc"};
        f134313b0 = strArr;
        a.C6921a a16 = com.tencent.luggage.wxa.q9.d.a(i0.class);
        f134314c0 = a16;
        a16.f145160c = (String[]) ArrayUtils.add(a16.f145160c, "versionDesc");
        a16.f145161d.put("versionDesc", "TEXT");
        a16.f145162e += ", versionDesc TEXT ";
        a16.f145162e += a.C6342a.a(strArr);
    }

    @Override // com.tencent.luggage.wxa.q9.d, com.tencent.luggage.wxa.xn.a
    public void a(Cursor cursor) {
        super.a(cursor);
        int columnIndex = cursor.getColumnIndex("versionDesc");
        if (columnIndex >= 0) {
            this.Z = cursor.getString(columnIndex);
        }
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return f134314c0;
    }

    @Override // com.tencent.luggage.wxa.jk.a
    public String[] getKeys() {
        return f134313b0;
    }

    @Override // com.tencent.luggage.wxa.q9.d, com.tencent.luggage.wxa.xn.a
    public ContentValues a() {
        ContentValues a16 = super.a();
        a16.put("versionDesc", this.Z);
        return a16;
    }
}
