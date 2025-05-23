package com.tencent.luggage.wxa.r4;

import com.tencent.mm.udr.IUdrResourceFeature;
import com.tencent.mm.udr.api.BatchCheckParameterModel;
import com.tencent.mm.udr.api.IUdrResourceCallback;
import com.tencent.mm.udr.api.WxUdrResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final a f139238a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r4.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6674a implements IUdrResourceCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicReference f139239a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f139240b;

            public C6674a(AtomicReference atomicReference, CountDownLatch countDownLatch) {
                this.f139239a = atomicReference;
                this.f139240b = countDownLatch;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String libName, long j3) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return a(libName, j3, "ilinkres_ae0cf48a");
        }

        public final WxUdrResource b(String str, String str2) {
            return com.tencent.luggage.wxa.eo.g.a(IUdrResourceFeature.class).getResource(str2, str);
        }

        public final int c(String str, String str2) {
            WxUdrResource b16 = b(str, str2);
            if (b16 != null) {
                return b16.getVersion();
            }
            return 0;
        }

        public final boolean a(String libName, long j3, String udrProjectId) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(udrProjectId, "udrProjectId");
            Map a16 = r.f139236a.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : a16.entrySet()) {
                if (Intrinsics.areEqual(((t) entry.getValue()).a(), libName)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(1 << ((Number) ((Map.Entry) it.next()).getKey()).intValue()));
            }
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                arrayList.size();
            }
            if (arrayList.isEmpty()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.NativeDependLibHelper", "haven't match any lib for this libName: " + libName);
                return false;
            }
            return a(((Number) arrayList.get(0)).longValue(), j3, udrProjectId);
        }

        public final boolean a(long j3, long j16, String udrProjectId) {
            Collection collection;
            ArrayList arrayListOf;
            Map mapOf;
            Intrinsics.checkNotNullParameter(udrProjectId, "udrProjectId");
            if (j3 == 0) {
                return true;
            }
            Map a16 = r.f139236a.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = a16.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((1 << ((Number) entry.getKey()).intValue()) & j3) != 0) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                int c16 = s.f139238a.c(((t) entry2.getValue()).a(), udrProjectId);
                if (c16 <= 0 || ((t) entry2.getValue()).b() == 0 || c16 < ((t) entry2.getValue()).b()) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap2.size());
            Iterator it5 = linkedHashMap2.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList.add(((t) ((Map.Entry) it5.next()).getValue()).a());
            }
            collection = CollectionsKt___CollectionsKt.toCollection(arrayList, new ArrayList());
            ArrayList arrayList2 = (ArrayList) collection;
            com.tencent.luggage.wxa.tn.w.d("Luggage.NativeDependLibHelper", "check for depend libs, bit flag: " + j3 + ", checkList: " + arrayList2);
            if (arrayList2.isEmpty()) {
                return true;
            }
            CountDownLatch countDownLatch = new CountDownLatch(arrayList2.size());
            AtomicReference atomicReference = new AtomicReference(Boolean.TRUE);
            IUdrResourceFeature a17 = com.tencent.luggage.wxa.eo.g.a(IUdrResourceFeature.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(udrProjectId);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(udrProjectId, arrayList2));
            a17.batchCheck(new BatchCheckParameterModel(arrayListOf, mapOf, 0, (Map) null), new C6674a(atomicReference, countDownLatch));
            try {
                if (!countDownLatch.await(j16, TimeUnit.MILLISECONDS)) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.NativeDependLibHelper", "download timeout");
                    return false;
                }
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.NativeDependLibHelper", "await got exception: " + e16);
                atomicReference.set(Boolean.FALSE);
            }
            Object obj = atomicReference.get();
            Intrinsics.checkNotNullExpressionValue(obj, "holder.get()");
            return ((Boolean) obj).booleanValue();
        }

        public final String a(String libName) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            WxUdrResource b16 = b(libName, "ilinkres_ae0cf48a");
            if (b16 != null) {
                return b16.getPath();
            }
            return null;
        }

        public final String a(String libName, String udrProjectId) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(udrProjectId, "udrProjectId");
            WxUdrResource b16 = b(libName, udrProjectId);
            if (b16 != null) {
                return b16.getPath();
            }
            return null;
        }
    }

    public static final boolean a(String str, long j3) {
        return f139238a.a(str, j3);
    }

    public static final boolean a(String str, long j3, String str2) {
        return f139238a.a(str, j3, str2);
    }

    public static final String a(String str) {
        return f139238a.a(str);
    }

    public static final String a(String str, String str2) {
        return f139238a.a(str, str2);
    }
}
