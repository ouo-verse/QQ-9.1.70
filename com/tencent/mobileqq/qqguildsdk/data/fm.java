package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class fm {

    /* renamed from: a, reason: collision with root package name */
    private final int f266056a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f266057a = 0;

        public fm b() {
            return new fm(this);
        }

        public a c(int i3) {
            this.f266057a = i3;
            return this;
        }
    }

    fm(a aVar) {
        this.f266056a = aVar.f266057a;
    }

    public int a() {
        return this.f266056a;
    }

    @NonNull
    public String toString() {
        return "RevokeOptions{msgRevokeType=" + this.f266056a + '}';
    }
}
