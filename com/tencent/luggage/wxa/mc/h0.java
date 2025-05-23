package com.tencent.luggage.wxa.mc;

import android.content.ContentValues;
import android.database.MatrixCursor;
import com.tencent.luggage.wxa.xn.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h0 extends d {
    public static final String[] Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final a.C6921a f134307a0 = com.tencent.luggage.wxa.q9.d.a(h0.class);

    static {
        String[] strArr = {"appId", "version", "debugType"};
        Z = strArr;
        String str = " PRIMARY KEY (";
        for (int i3 = 0; i3 < 3; i3++) {
            str = str + ", " + strArr[i3];
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder sb5 = new StringBuilder();
        a.C6921a c6921a = f134307a0;
        sb5.append(c6921a.f145162e);
        sb5.append(",");
        sb5.append(str2);
        c6921a.f145162e = sb5.toString();
    }

    public void a(ContentValues contentValues) {
        MatrixCursor b16 = b(contentValues);
        try {
            b16.moveToFirst();
            a(b16);
            b16.close();
        } catch (Throwable th5) {
            if (b16 != null) {
                try {
                    b16.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    @Override // com.tencent.luggage.wxa.xn.a
    public a.C6921a b() {
        return f134307a0;
    }

    public static MatrixCursor b(ContentValues contentValues) {
        int i3 = 0;
        String[] strArr = (String[]) contentValues.keySet().toArray(new String[0]);
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i16 = 0;
        while (i3 < length) {
            objArr[i16] = contentValues.get(strArr[i3]);
            i3++;
            i16++;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }
}
