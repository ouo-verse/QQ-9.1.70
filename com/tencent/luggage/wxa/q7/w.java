package com.tencent.luggage.wxa.q7;

import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f138211a = new w();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet f138212b = new HashSet();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/os/Bundle;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "callback", "", "a", "(Landroid/os/Bundle;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final a f138213a = new a();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(Bundle bundle, com.tencent.luggage.wxa.ka.i iVar) {
            String string;
            if (bundle != null && (string = bundle.getString("KEY_FROM_APPID")) != null) {
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(KEY_FROM_APPID) ?: return@let");
                String string2 = bundle.getString("KEY_TO_APPID");
                if (string2 != null) {
                    Intrinsics.checkNotNullExpressionValue(string2, "it.getString(KEY_TO_APPID) ?: return@let");
                    w.f138211a.b(string, string2, bundle.getLong("KEY_TIMESTAMP"));
                }
            }
            if (iVar != null) {
                iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
            }
        }
    }

    public final void b(com.tencent.luggage.wxaapi.n nVar) {
        if (nVar == null) {
            return;
        }
        HashSet hashSet = f138212b;
        synchronized (hashSet) {
            hashSet.remove(nVar);
        }
    }

    public final void a(com.tencent.luggage.wxaapi.n nVar) {
        if (nVar == null) {
            return;
        }
        HashSet hashSet = f138212b;
        synchronized (hashSet) {
            hashSet.add(nVar);
        }
    }

    public final void b(String str, String str2, long j3) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = f138212b;
        synchronized (hashSet) {
            linkedList.addAll(hashSet);
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxaapi.n) it.next()).a(str, str2, j3);
        }
    }

    public final void a(String fromAppId, String toAppId, long j3) {
        Intrinsics.checkNotNullParameter(fromAppId, "fromAppId");
        Intrinsics.checkNotNullParameter(toAppId, "toAppId");
        String g16 = com.tencent.luggage.wxa.tn.z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        Bundle bundle = new Bundle();
        bundle.putString("KEY_FROM_APPID", fromAppId);
        bundle.putString("KEY_TO_APPID", toAppId);
        bundle.putLong("KEY_TIMESTAMP", j3);
        com.tencent.luggage.wxa.ka.b.a(g16, bundle, a.f138213a, null, 8, null);
    }
}
