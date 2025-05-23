package com.tencent.luggage.wxa.xa;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface c {
    c a(String str);

    c a(String str, double d16);

    c a(String str, int i3);

    c a(String str, long j3);

    c a(String str, Object obj);

    c a(String str, boolean z16);

    a b(String str);

    c b(String str, Object obj);

    c c(String str);

    String d(String str);

    a e(String str);

    Object get(String str);

    boolean getBoolean(String str);

    double getDouble(String str);

    int getInt(String str);

    long getLong(String str);

    String getString(String str);

    boolean has(String str);

    boolean isNull(String str);

    Iterator keys();

    int length();

    Object opt(String str);

    boolean optBoolean(String str, boolean z16);

    double optDouble(String str, double d16);

    int optInt(String str, int i3);

    long optLong(String str, long j3);

    String optString(String str, String str2);

    Object remove(String str);
}
