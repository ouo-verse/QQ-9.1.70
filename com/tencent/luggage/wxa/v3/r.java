package com.tencent.luggage.wxa.v3;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f143212a = new r();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.vo.a, e0.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f143213a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference f143214b;

        /* renamed from: c, reason: collision with root package name */
        public final e0 f143215c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReference f143216d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReference f143217e;

        /* renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f143218f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v3.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6826a implements com.tencent.luggage.wxa.uo.b {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.v3.r$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6827a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f143220a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143221b;

                public RunnableC6827a(a aVar, com.tencent.luggage.wxa.xo.b bVar) {
                    this.f143220a = aVar;
                    this.f143221b = bVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x0104 A[Catch: Exception -> 0x01b3, TryCatch #0 {Exception -> 0x01b3, blocks: (B:3:0x0008, B:6:0x002f, B:8:0x00cf, B:9:0x00d2, B:10:0x00e9, B:12:0x00ea, B:14:0x00f8, B:19:0x0104, B:21:0x012a, B:24:0x0142, B:25:0x013c, B:26:0x0145, B:28:0x014c, B:30:0x0181, B:31:0x0185, B:33:0x0193, B:34:0x0196, B:35:0x019c, B:37:0x01aa, B:38:0x01ad), top: B:2:0x0008 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    String str;
                    boolean z16;
                    String replaceFirst$default;
                    try {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("https://long.open.weixin.qq.com/wxaruntime/qrconnect?uuid=");
                        sb5.append(this.f143220a.f());
                        if (this.f143220a.c().get()) {
                            str = "&last=404";
                        } else {
                            str = "";
                        }
                        sb5.append(str);
                        String sb6 = sb5.toString();
                        w.d("Luggage.QRCodeTransferLongPullingConnect", "long pulling url = " + sb6);
                        ResponseBody body = com.tencent.luggage.wxa.n3.p.longConnectClient().newCall(new Request.Builder().url(sb6).build()).execute().body();
                        Intrinsics.checkNotNull(body);
                        String respStr = body.string();
                        w.a("Luggage.QRCodeTransferLongPullingConnect", "long pulling uuid = " + this.f143220a.f() + ", resp = " + respStr);
                        r rVar = r.f143212a;
                        Intrinsics.checkNotNullExpressionValue(respStr, "respStr");
                        Map a16 = rVar.a(respStr);
                        int a17 = w0.a((String) a16.get("window.wx_errcode"), -1);
                        w.a("Luggage.QRCodeTransferLongPullingConnect", "long pulling uuid = " + this.f143220a.f() + ", errcode = " + a17);
                        if (a17 != 408) {
                            switch (a17) {
                                case 402:
                                    b bVar = (b) this.f143220a.b().get();
                                    if (bVar != null) {
                                        bVar.a();
                                    }
                                    this.f143220a.i();
                                    break;
                                case 403:
                                    b bVar2 = (b) this.f143220a.b().get();
                                    if (bVar2 != null) {
                                        bVar2.onCancelled();
                                    }
                                    this.f143220a.i();
                                    break;
                                case 404:
                                    w.a("Luggage.QRCodeTransferLongPullingConnect", "long pulling uuid = " + this.f143220a.f() + ", scanned");
                                    this.f143220a.c().set(true);
                                    b bVar3 = (b) this.f143220a.b().get();
                                    if (bVar3 != null) {
                                        bVar3.b();
                                        break;
                                    }
                                    break;
                                case 405:
                                    Object obj = a16.get("window.resp_data");
                                    a aVar = this.f143220a;
                                    String str2 = (String) obj;
                                    if (str2 != null && str2.length() != 0) {
                                        z16 = false;
                                        if (!z16) {
                                            Intrinsics.checkNotNull(str2);
                                            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(str2, "'{", "{", false, 4, (Object) null);
                                            String a18 = rVar.a(replaceFirst$default, "}'", "}");
                                            b bVar4 = (b) aVar.b().get();
                                            if (bVar4 != null) {
                                                String optString = new JSONObject(a18).optString("data");
                                                if (optString == null) {
                                                    optString = "fail";
                                                } else {
                                                    Intrinsics.checkNotNullExpressionValue(optString, "JSONObject(jsonStr).optString(\"data\") ?: \"fail\"");
                                                }
                                                bVar4.a(optString);
                                            }
                                        }
                                        this.f143220a.i();
                                        break;
                                    }
                                    z16 = true;
                                    if (!z16) {
                                    }
                                    this.f143220a.i();
                                    break;
                                default:
                                    throw new IllegalArgumentException("Unknown wx_errcode " + a17);
                            }
                        }
                    } catch (Exception e16) {
                        w.b("Luggage.QRCodeTransferLongPullingConnect", "keepPulling uuid = " + this.f143220a.f() + ", connect e = " + e16);
                        b bVar5 = (b) this.f143220a.b().get();
                        if (bVar5 != null) {
                            bVar5.a(e16);
                        }
                        this.f143220a.i();
                    }
                    this.f143221b.a(null);
                }
            }

            public C6826a() {
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void call(Void r46) {
                com.tencent.luggage.wxa.zp.h.f146825d.execute(new RunnableC6827a(a.this, com.tencent.luggage.wxa.xo.h.b()));
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements e.c {
            public b() {
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(Void r26) {
                a.this.d().set(c.Idle);
            }
        }

        public a(com.tencent.luggage.wxa.xd.i env, String uuid, b callback) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f143213a = uuid;
            this.f143214b = new AtomicReference(env);
            this.f143215c = new e0(Looper.getMainLooper(), (e0.a) this, true);
            this.f143216d = new AtomicReference(callback);
            this.f143217e = new AtomicReference(c.Idle);
            this.f143218f = new AtomicBoolean(false);
            env.getRuntime().b((com.tencent.luggage.wxa.vo.a) this);
        }

        public final AtomicReference b() {
            return this.f143216d;
        }

        public final AtomicBoolean c() {
            return this.f143218f;
        }

        public final AtomicReference d() {
            return this.f143217e;
        }

        public final String f() {
            return this.f143213a;
        }

        @Override // com.tencent.luggage.wxa.vo.a
        public void g() {
            b bVar = (b) this.f143216d.get();
            if (bVar != null) {
                bVar.onCancelled();
            }
            i();
        }

        public final boolean h() {
            if (this.f143216d.get() == null) {
                return false;
            }
            Object obj = this.f143217e.get();
            c cVar = c.Connecting;
            if (obj == cVar) {
                return true;
            }
            this.f143217e.set(cVar);
            com.tencent.luggage.wxa.xo.h.c().c(new C6826a()).a(com.tencent.luggage.wxa.yo.d.f146045b, new b());
            return true;
        }

        public final void i() {
            this.f143215c.f();
            this.f143214b.set(null);
            this.f143216d.set(null);
        }

        public final void j() {
            this.f143215c.a(1000L, 3000L);
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            return h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void a(Exception exc);

        void a(String str);

        void b();

        void onCancelled();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        Idle,
        Connecting
    }

    public static final com.tencent.luggage.wxa.vo.a a(com.tencent.luggage.wxa.xd.i env, String uuid, b callback) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a(env, uuid, callback);
        aVar.j();
        return aVar;
    }

    public final Map a(String str) {
        List emptyList;
        int indexOf$default;
        Map emptyMap;
        if (TextUtils.isEmpty(str)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        HashMap hashMap = new HashMap();
        List<String> split = new Regex(";").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str2 : (String[]) array) {
            if (!TextUtils.isEmpty(str2)) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, '=', 0, false, 6, (Object) null);
                try {
                    String substring = str2.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    String substring2 = str2.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    hashMap.put(substring, substring2);
                } catch (Exception e16) {
                    w.b("Luggage.QRCodeTransferLongPullingConnect", "extractKeyValue kv-pair=" + str2 + ", e=" + e16);
                }
            }
        }
        return hashMap;
    }

    public final String a(String str, String str2, String str3) {
        int lastIndexOf$default;
        CharSequence replaceRange;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            return str;
        }
        replaceRange = StringsKt__StringsKt.replaceRange((CharSequence) str, lastIndexOf$default, str2.length() + lastIndexOf$default, (CharSequence) str3);
        return replaceRange.toString();
    }
}
