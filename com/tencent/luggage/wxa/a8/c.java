package com.tencent.luggage.wxa.a8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ag.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c implements q {

    /* renamed from: b, reason: collision with root package name */
    private static final String f120900b = "MicroMsg.AppBrand.AbsXWebPipInfoProvider";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final com.tencent.luggage.wxa.k8.a f120901a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ag.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b.EnumC6005b f120902a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Boolean f120903b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b.a f120904c;

        public a(b.EnumC6005b enumC6005b, Boolean bool, b.a aVar) {
            this.f120902a = enumC6005b;
            this.f120903b = bool;
            this.f120904c = aVar;
        }

        @Override // com.tencent.luggage.wxa.ag.b
        public Boolean a() {
            return this.f120903b;
        }

        @Override // com.tencent.luggage.wxa.ag.b
        public b.a b() {
            return this.f120904c;
        }

        @Override // com.tencent.luggage.wxa.ag.b
        public b.EnumC6005b c() {
            return this.f120902a;
        }
    }

    public c(com.tencent.luggage.wxa.k8.a aVar) {
        this.f120901a = aVar;
    }

    @Nullable
    public com.tencent.luggage.wxa.ag.b a(@Nullable String str) {
        try {
            com.tencent.luggage.wxa.xa.h hVar = new com.tencent.luggage.wxa.xa.h(str);
            return new a(com.tencent.luggage.wxa.ag.c.b(hVar), com.tencent.luggage.wxa.ag.c.c(hVar), com.tencent.luggage.wxa.ag.c.a(hVar));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a(d(), e16, "getPipExtra fail", new Object[0]);
            return null;
        }
    }

    public final String d() {
        return "MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.f120901a.getId();
    }
}
