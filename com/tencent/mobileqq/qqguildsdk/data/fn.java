package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class fn {

    /* renamed from: a, reason: collision with root package name */
    private final String f266058a;

    /* renamed from: b, reason: collision with root package name */
    private final int f266059b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f266060c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final GProRolePermission f266061d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f266062a;

        /* renamed from: b, reason: collision with root package name */
        private int f266063b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f266064c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private GProRolePermission f266065d;

        public fn e() {
            return new fn(this);
        }

        public a f(int i3) {
            this.f266063b = i3;
            return this;
        }

        public a g(boolean z16) {
            this.f266064c = z16;
            return this;
        }

        public a h(String str) {
            this.f266062a = str;
            return this;
        }

        public a i(@NonNull GProRolePermission gProRolePermission) {
            this.f266065d = gProRolePermission;
            return this;
        }
    }

    fn(a aVar) {
        GProRolePermission gProRolePermission;
        this.f266058a = aVar.f266062a;
        this.f266059b = aVar.f266063b;
        this.f266060c = aVar.f266064c;
        if (aVar.f266065d != null) {
            gProRolePermission = aVar.f266065d;
        } else {
            gProRolePermission = new GProRolePermission();
        }
        this.f266061d = gProRolePermission;
    }

    public int a() {
        return this.f266059b;
    }

    public boolean b() {
        return this.f266060c;
    }

    public String c() {
        return this.f266058a;
    }

    @NonNull
    public GProRolePermission d() {
        return this.f266061d;
    }

    @NonNull
    public String toString() {
        return "RoleCreateInfo{name=" + this.f266058a + ",color=" + this.f266059b + ",hoist=" + this.f266060c + ",permission=" + this.f266061d + "}";
    }
}
