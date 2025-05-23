package com.tencent.luggage.wxa.rc;

import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface p {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED,
        MEMORY_ISSUE,
        VALUE_PROCESS_FAIL
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f139565a;

        /* renamed from: b, reason: collision with root package name */
        public String f139566b;

        /* renamed from: c, reason: collision with root package name */
        public String f139567c;

        public b(String str, String str2, String str3) {
            this.f139565a = str;
            this.f139566b = str2;
            this.f139567c = str3;
        }
    }

    a a(int i3, String str, String str2, String str3, String str4);

    a a(int i3, String str, List list);

    Object[] a(int i3, String str);

    Object[] a(int i3, String str, String str2);

    int b(String str);

    a b(int i3, String str, String str2);

    List b(int i3, String str, List list);

    void b(int i3, String str);
}
