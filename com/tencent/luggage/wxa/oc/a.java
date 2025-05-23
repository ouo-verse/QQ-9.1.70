package com.tencent.luggage.wxa.oc;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.r7;
import com.tencent.luggage.wxa.hn.rh;
import com.tencent.luggage.wxa.hn.s7;
import com.tencent.luggage.wxa.hn.sa;
import com.tencent.luggage.wxa.hn.sh;
import com.tencent.luggage.wxa.hn.ta;
import com.tencent.luggage.wxa.n3.h;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends h {

    /* renamed from: g, reason: collision with root package name */
    public static final C6542a f136276g = new C6542a(null);

    /* renamed from: e, reason: collision with root package name */
    public final int f136277e;

    /* renamed from: f, reason: collision with root package name */
    public final String f136278f;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oc.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6542a {
        public C6542a() {
        }

        public /* synthetic */ C6542a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f136279a;

        /* renamed from: b, reason: collision with root package name */
        public long f136280b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f136281c;

        /* renamed from: e, reason: collision with root package name */
        public int f136283e;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f136281c = obj;
            this.f136283e |= Integer.MIN_VALUE;
            return a.this.a(this);
        }
    }

    public a(String appId, String str, int i3) {
        n0 n0Var;
        n0.g h16;
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f136277e = i3;
        this.f136278f = "/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode";
        super.a(appId);
        r7 r7Var = new r7();
        sa saVar = new sa();
        int i16 = 0;
        try {
            n0Var = o0.a().a(appId, "username", "versionInfo");
        } catch (Exception e16) {
            w.a("Luggage.CgiPreDownloadCode", e16, "<init> query attrs", new Object[0]);
            n0Var = null;
        }
        saVar.f128679d = n0Var != null ? n0Var.f138465d : null;
        saVar.f128683h = appId;
        saVar.f128682g = str;
        if (n0Var != null && (h16 = n0Var.h()) != null) {
            i16 = h16.f125920a;
        }
        saVar.f128680e = i16;
        r7Var.f128588e = saVar;
        r7Var.f128589f = true;
        r7Var.f128590g = this.f136277e;
        super.a(r7Var);
        super.a(s7.class);
    }

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return this.f136278f;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: a -> 0x002f, TryCatch #0 {a -> 0x002f, blocks: (B:11:0x002b, B:12:0x0051, B:14:0x0067, B:15:0x0074, B:17:0x0078, B:18:0x0081, B:19:0x008a, B:22:0x0093, B:25:0x009d, B:28:0x00a1, B:31:0x00b1, B:34:0x00b6, B:44:0x00bd, B:46:0x00c4, B:47:0x00c8, B:49:0x00ce, B:52:0x00d9, B:55:0x00e0, B:58:0x00e4, B:63:0x00eb, B:66:0x00f1), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[Catch: a -> 0x002f, TryCatch #0 {a -> 0x002f, blocks: (B:11:0x002b, B:12:0x0051, B:14:0x0067, B:15:0x0074, B:17:0x0078, B:18:0x0081, B:19:0x008a, B:22:0x0093, B:25:0x009d, B:28:0x00a1, B:31:0x00b1, B:34:0x00b6, B:44:0x00bd, B:46:0x00c4, B:47:0x00c8, B:49:0x00ce, B:52:0x00d9, B:55:0x00e0, B:58:0x00e4, B:63:0x00eb, B:66:0x00f1), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093 A[Catch: a -> 0x002f, TRY_ENTER, TryCatch #0 {a -> 0x002f, blocks: (B:11:0x002b, B:12:0x0051, B:14:0x0067, B:15:0x0074, B:17:0x0078, B:18:0x0081, B:19:0x008a, B:22:0x0093, B:25:0x009d, B:28:0x00a1, B:31:0x00b1, B:34:0x00b6, B:44:0x00bd, B:46:0x00c4, B:47:0x00c8, B:49:0x00ce, B:52:0x00d9, B:55:0x00e0, B:58:0x00e4, B:63:0x00eb, B:66:0x00f1), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4 A[Catch: a -> 0x002f, TryCatch #0 {a -> 0x002f, blocks: (B:11:0x002b, B:12:0x0051, B:14:0x0067, B:15:0x0074, B:17:0x0078, B:18:0x0081, B:19:0x008a, B:22:0x0093, B:25:0x009d, B:28:0x00a1, B:31:0x00b1, B:34:0x00b6, B:44:0x00bd, B:46:0x00c4, B:47:0x00c8, B:49:0x00ce, B:52:0x00d9, B:55:0x00e0, B:58:0x00e4, B:63:0x00eb, B:66:0x00f1), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.luggage.wxa.n3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Continuation continuation) {
        b bVar;
        Object coroutine_suspended;
        int i3;
        a aVar;
        long j3;
        ta resp;
        LinkedList list_resp;
        HashSet hashSet;
        Iterator it;
        sh shVar;
        int i16;
        sh shVar2;
        boolean contains;
        String str;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i17 = bVar.f136283e;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                bVar.f136283e = i17 - Integer.MIN_VALUE;
                Object obj = bVar.f136281c;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = bVar.f136283e;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        bVar.f136279a = this;
                        bVar.f136280b = currentTimeMillis;
                        bVar.f136283e = 1;
                        obj = super.a(bVar);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = this;
                        j3 = currentTimeMillis;
                    } catch (com.tencent.luggage.wxa.bj.a e16) {
                        e = e16;
                        aVar = this;
                        j3 = currentTimeMillis;
                        aVar.a(j3, System.currentTimeMillis(), e.f122899b);
                        throw e;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = bVar.f136280b;
                    aVar = (a) bVar.f136279a;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (com.tencent.luggage.wxa.bj.a e17) {
                        e = e17;
                        aVar.a(j3, System.currentTimeMillis(), e.f122899b);
                        throw e;
                    }
                }
                s7 s7Var = (s7) obj;
                aVar.a(j3, System.currentTimeMillis(), 0);
                LinkedList linkedList = new LinkedList();
                resp = s7Var.f128669e;
                if (resp != null) {
                    Intrinsics.checkNotNullExpressionValue(resp, "resp");
                    Boxing.boxBoolean(linkedList.add(resp));
                }
                list_resp = s7Var.f128670f;
                if (list_resp != null) {
                    Intrinsics.checkNotNullExpressionValue(list_resp, "list_resp");
                    linkedList.addAll(list_resp);
                }
                hashSet = new HashSet();
                it = linkedList.iterator();
                while (it.hasNext()) {
                    ta taVar = (ta) it.next();
                    rh rhVar = taVar.f128747e;
                    if (rhVar != null && (shVar2 = rhVar.f128631e) != null) {
                        int i18 = shVar2.f128700l;
                        int[] LOCAL_SUPPORT_PACKAGE_TYPES_IN_WIDGET_INFO = com.tencent.luggage.wxa.ip.a.f130732b;
                        Intrinsics.checkNotNullExpressionValue(LOCAL_SUPPORT_PACKAGE_TYPES_IN_WIDGET_INFO, "LOCAL_SUPPORT_PACKAGE_TYPES_IN_WIDGET_INFO");
                        contains = ArraysKt___ArraysKt.contains(LOCAL_SUPPORT_PACKAGE_TYPES_IN_WIDGET_INFO, i18);
                        if (contains && (str = taVar.f128748f) != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "info.Appid ?: continue");
                            hashSet.add(str);
                        }
                    }
                }
                if (true ^ hashSet.isEmpty()) {
                    Iterator it5 = linkedList.iterator();
                    while (it5.hasNext()) {
                        ta taVar2 = (ta) it5.next();
                        String str2 = taVar2.f128748f;
                        if (str2 != null) {
                            Intrinsics.checkNotNullExpressionValue(str2, "info.Appid ?: continue");
                            rh rhVar2 = taVar2.f128747e;
                            if (rhVar2 != null && (shVar = rhVar2.f128631e) != null && ((i16 = shVar.f128700l) == 0 || i16 == 4)) {
                                if (hashSet.contains(str2)) {
                                    taVar2.f128747e.f128631e = null;
                                }
                            }
                        }
                    }
                }
                return obj;
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.f136281c;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = bVar.f136283e;
        if (i3 != 0) {
        }
        s7 s7Var2 = (s7) obj2;
        aVar.a(j3, System.currentTimeMillis(), 0);
        LinkedList linkedList2 = new LinkedList();
        resp = s7Var2.f128669e;
        if (resp != null) {
        }
        list_resp = s7Var2.f128670f;
        if (list_resp != null) {
        }
        hashSet = new HashSet();
        it = linkedList2.iterator();
        while (it.hasNext()) {
        }
        if (true ^ hashSet.isEmpty()) {
        }
        return obj2;
    }

    public final void a(long j3, long j16, int i3) {
        n0.b f16;
        d dVar = new d();
        dVar.c(((r7) c()).f128588e.f128679d);
        dVar.b(b());
        n0 a16 = o0.a().a(b(), "appInfo");
        dVar.a(((a16 == null || (f16 = a16.f()) == null) ? 0 : f16.f125867e) + 1000);
        dVar.e(this.f136277e);
        dVar.b(j16 - j3);
        dVar.f(j3);
        dVar.c(j16);
        dVar.a(i3);
        dVar.d(com.tencent.luggage.wxa.ek.a.a());
        dVar.c();
    }
}
