package com.tencent.biz.qqstory.model;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.b;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes5.dex */
public class a extends com.tencent.biz.qqstory.model.c<c> {

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferences f94023d;

    /* renamed from: e, reason: collision with root package name */
    private LbsManager.b f94024e = new C0942a();

    /* renamed from: f, reason: collision with root package name */
    protected boolean f94025f;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqstory.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0942a implements LbsManager.b {
        C0942a() {
        }

        @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.b
        public void a(boolean z16, com.tencent.biz.qqstory.model.lbs.a aVar) {
            hd0.c.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + z16);
            if (z16 && aVar != null) {
                hd0.c.c("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(aVar.f94079b), Integer.valueOf(aVar.f94078a));
                a.this.i(aVar.f94079b, aVar.f94078a);
            } else {
                hd0.c.g("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
                a.this.b(false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements b.InterfaceC0941b<cd0.b, dd0.b> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [DATA, com.tencent.biz.qqstory.model.a$c] */
        @Override // com.tencent.biz.qqstory.channel.b.InterfaceC0941b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void v(@NonNull cd0.b bVar, @Nullable dd0.b bVar2, @NonNull ErrorMessage errorMessage) {
            hd0.c.a("AddressDataProvider", "requestAddress Cmd Respond.");
            if (errorMessage.isSuccess() && bVar2 != null) {
                hd0.c.b("AddressDataProvider", "requestAddress onCmdRespond success : %s .", bVar2.toString());
                a.this.f94038a = new c(bVar2.f393624c, bVar2.f393625d, bVar2.f393626e, bVar2.f393627f, bVar2.f393628g, bVar.f30712g, bVar.f30713h);
                a.this.l("country", bVar2.f393624c);
                a.this.l("province", bVar2.f393625d);
                a.this.l("city", bVar2.f393626e);
                a.this.l("district", bVar2.f393627f);
                a.this.l("street", bVar2.f393628g);
                a.this.j("longitude", bVar.f30712g);
                a.this.j("latitude", bVar.f30713h);
                a.this.k("time", System.currentTimeMillis());
                a aVar = a.this;
                aVar.b(true, (c) aVar.f94038a);
            } else {
                hd0.c.v("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", errorMessage, bVar);
                a.this.b(false, null);
            }
            a.this.f94025f = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f94028a;

        /* renamed from: b, reason: collision with root package name */
        public final String f94029b;

        /* renamed from: c, reason: collision with root package name */
        public final String f94030c;

        /* renamed from: d, reason: collision with root package name */
        public final String f94031d;

        /* renamed from: e, reason: collision with root package name */
        public final String f94032e;

        /* renamed from: f, reason: collision with root package name */
        public final int f94033f;

        /* renamed from: g, reason: collision with root package name */
        public final int f94034g;

        public c(String str, String str2, String str3, String str4, String str5, int i3, int i16) {
            this.f94028a = str;
            this.f94029b = str2;
            this.f94030c = str3;
            this.f94031d = str4;
            this.f94032e = str5;
            this.f94033f = i3;
            this.f94034g = i16;
        }

        public String toString() {
            return "AddressInfo{country='" + this.f94028a + "', province='" + this.f94029b + "', city='" + this.f94030c + "', district='" + this.f94031d + "', street='" + this.f94032e + "', longitude=" + this.f94033f + ", latitude=" + this.f94034g + '}';
        }
    }

    public a() {
        BaseApplicationImpl b16 = QQStoryContext.h().b();
        if (b16 != null) {
            this.f94023d = b16.getSharedPreferences("poi_filter_perferences", 0);
            return;
        }
        throw new IllegalArgumentException("Context should not be null");
    }

    @Override // com.tencent.biz.qqstory.model.c
    protected void a(com.tencent.biz.qqstory.model.lbs.a aVar) {
        hd0.c.a("AddressDataProvider", "requestAddress.");
        if (this.f94025f) {
            hd0.c.t("AddressDataProvider", "is request address ing....");
            return;
        }
        this.f94025f = true;
        LbsManager lbsManager = (LbsManager) i.c(9);
        if (aVar == null) {
            aVar = lbsManager.d();
        }
        if (aVar != null) {
            i(aVar.f94079b, aVar.f94078a);
        } else {
            lbsManager.f(this.f94024e);
            lbsManager.g();
        }
    }

    public boolean h(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f94028a) && !HardCodeUtil.qqStr(R.string.j4r).equals(cVar.f94028a)) {
            return true;
        }
        return false;
    }

    protected void i(int i3, int i16) {
        com.tencent.biz.qqstory.channel.b.a().b(new cd0.b(1, i3, i16), new b());
    }

    protected void j(String str, int i3) {
        this.f94023d.edit().putInt(str, i3).apply();
    }

    protected void k(String str, long j3) {
        this.f94023d.edit().putLong(str, j3).apply();
    }

    protected void l(String str, String str2) {
        this.f94023d.edit().putString(str, str2).apply();
    }
}
