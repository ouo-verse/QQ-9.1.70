package com.tencent.luggage.wxa.q7;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f138189a = new u();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet f138190b = new HashSet();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "<anonymous parameter 1>", "", "a", "(Landroid/os/Bundle;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final a f138191a = new a();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(Bundle bundle, com.tencent.luggage.wxa.ka.i iVar) {
            long j3 = bundle.getLong("KEY_TIMESTAMP", 0L);
            String appId = bundle.getString("KEY_APPID", "");
            u uVar = u.f138189a;
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            uVar.a(j3, appId);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.ka.i {

        /* renamed from: a, reason: collision with root package name */
        public static final b f138192a = new b();

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(com.tencent.luggage.wxa.va.e eVar) {
        }
    }

    public final void a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    public final void b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    public final synchronized void b(com.tencent.luggage.wxaapi.k kVar) {
        if (kVar != null) {
            HashSet hashSet = f138190b;
            hashSet.remove(kVar);
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAppCloseEventLogic", "remove listener: " + hashSet.size());
        }
    }

    public final synchronized void a(com.tencent.luggage.wxaapi.k kVar) {
        if (kVar != null) {
            HashSet hashSet = f138190b;
            hashSet.add(kVar);
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAppCloseEventLogic", "add listener: " + hashSet.size());
        }
    }

    public final void b(long j3, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAppCloseEventLogic", "notifyCloseByClientProcess timestamp:" + j3 + " appId:" + appId);
        String g16 = com.tencent.luggage.wxa.tn.z.g();
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_TIMESTAMP", j3);
        bundle.putString("KEY_APPID", appId);
        com.tencent.luggage.wxa.ka.o.a(g16, bundle, a.f138191a.getClass(), b.f138192a);
    }

    public final void a(long j3, String str) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaAppCloseEventLogic", "notifyClose timestamp:" + j3 + " appId:" + str);
        if (j3 != 0 && !w0.c(str)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                arrayList.addAll(f138190b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxaapi.k) it.next()).a(j3, str);
            }
            b(str);
            return;
        }
        com.tencent.luggage.wxa.tn.w.f("Luggage.WxaAppCloseEventLogic", "timestamp:" + j3 + " appId:" + str + " is error, return");
    }
}
