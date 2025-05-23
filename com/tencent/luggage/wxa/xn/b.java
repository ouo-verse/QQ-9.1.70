package com.tencent.luggage.wxa.xn;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface b {
    int a(long j3);

    int a(String str, ContentValues contentValues, String str2, String[] strArr);

    int a(String str, String str2, String[] strArr);

    long a(String str, String str2, ContentValues contentValues);

    Cursor a(String str, String[] strArr);

    Cursor a(String str, String[] strArr, int i3);

    Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i3);

    boolean a();

    boolean a(String str, String str2);

    long b(long j3);

    long b(String str, String str2, ContentValues contentValues);

    void close();
}
