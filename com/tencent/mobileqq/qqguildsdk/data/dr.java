package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface dr {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f266007a;

        /* renamed from: b, reason: collision with root package name */
        private final String f266008b;

        /* renamed from: c, reason: collision with root package name */
        private final String f266009c;

        public a(String str, String str2, String str3) {
            this.f266007a = str;
            this.f266008b = str3;
            this.f266009c = str2;
        }

        public String a() {
            return this.f266008b;
        }

        public String b() {
            return this.f266009c;
        }

        public String c() {
            return this.f266007a;
        }
    }

    int a();

    String b();

    @NonNull
    List<a> getMemberList();
}
