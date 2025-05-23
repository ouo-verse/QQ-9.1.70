package com.tencent.ams.fusion.service.kv;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a {
    Set<String> a(String str, String str2, Set<String> set);

    void b(String str, String str2, Set<String> set);

    void c(String str, String str2);

    int getInt(String str, String str2, int i3);

    long getLong(String str, String str2, long j3);

    String getString(String str, String str2, String str3);

    void putInt(String str, String str2, int i3);

    void putLong(String str, String str2, long j3);

    void putString(String str, String str2, String str3);
}
