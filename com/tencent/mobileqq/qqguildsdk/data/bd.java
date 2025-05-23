package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.bc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bd {

    /* renamed from: a, reason: collision with root package name */
    private final String f265733a;

    /* renamed from: b, reason: collision with root package name */
    private final String f265734b;

    /* renamed from: c, reason: collision with root package name */
    private final String f265735c;

    /* renamed from: d, reason: collision with root package name */
    private final int f265736d;

    /* renamed from: e, reason: collision with root package name */
    private final bc f265737e;

    /* renamed from: f, reason: collision with root package name */
    private final String f265738f;

    /* renamed from: g, reason: collision with root package name */
    private final int f265739g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f265740a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f265741b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f265742c = "";

        /* renamed from: d, reason: collision with root package name */
        private int f265743d = -1;

        /* renamed from: e, reason: collision with root package name */
        private bc f265744e = new bc.a().e();

        /* renamed from: f, reason: collision with root package name */
        private String f265745f = "";

        /* renamed from: g, reason: collision with root package name */
        private int f265746g = 0;

        public bd h() {
            return new bd(this);
        }

        public a i(@Nullable bc bcVar) {
            if (bcVar != null) {
                this.f265744e = bcVar;
            }
            return this;
        }

        public a j(@NonNull String str) {
            this.f265745f = str;
            return this;
        }

        public a k(int i3) {
            if (i3 >= 0) {
                this.f265746g = i3;
            }
            return this;
        }

        public a l(@NonNull String str) {
            this.f265741b = str;
            return this;
        }

        public a m(@NonNull String str) {
            this.f265740a = str;
            return this;
        }

        public a n(int i3) {
            this.f265743d = i3;
            return this;
        }
    }

    bd(a aVar) {
        this.f265733a = aVar.f265740a;
        this.f265734b = aVar.f265741b;
        this.f265735c = aVar.f265742c;
        this.f265736d = aVar.f265743d;
        this.f265737e = aVar.f265744e;
        this.f265738f = aVar.f265745f;
        this.f265739g = aVar.f265746g;
    }

    public bc a() {
        return this.f265737e;
    }

    public String b() {
        return this.f265738f;
    }

    public int c() {
        return this.f265739g;
    }

    public String d() {
        return this.f265734b;
    }

    public String e() {
        return this.f265735c;
    }

    public String f() {
        return this.f265733a;
    }

    public int g() {
        return this.f265736d;
    }

    public String toString() {
        return "GProMsgSearchReqParams{mTinyId='" + this.f265733a + "', mGuildId='" + this.f265734b + "', mQuery='" + this.f265735c + "', mType=" + this.f265736d + ", mCond=" + this.f265737e + ", mCookie='" + this.f265738f + "', mCount=" + this.f265739g + '}';
    }
}
