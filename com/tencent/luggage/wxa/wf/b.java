package com.tencent.luggage.wxa.wf;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.util.ArrayMap;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.vf.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'h' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {
    public static final b C;
    public static final b D;
    public static final /* synthetic */ b[] E;

    /* renamed from: e, reason: collision with root package name */
    public static final a f144216e;

    /* renamed from: f, reason: collision with root package name */
    public static final Map f144217f;

    /* renamed from: g, reason: collision with root package name */
    public static final Map f144218g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f144219h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f144220i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f144221j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f144222k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f144223l;

    /* renamed from: m, reason: collision with root package name */
    public static final b f144224m;

    /* renamed from: a, reason: collision with root package name */
    public final String f144225a;

    /* renamed from: b, reason: collision with root package name */
    public final String f144226b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.vf.c f144227c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayMap f144228d = new ArrayMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map a() {
            return b.f144218g;
        }

        public final Map b() {
            return b.f144217f;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wf.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6883b {

        /* renamed from: a, reason: collision with root package name */
        public final String f144229a;

        /* renamed from: b, reason: collision with root package name */
        public final Class[] f144230b;

        public C6883b(String name, Class[] parameterTypes) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
            this.f144229a = name;
            this.f144230b = parameterTypes;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(C6883b.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
            C6883b c6883b = (C6883b) obj;
            if (Intrinsics.areEqual(this.f144229a, c6883b.f144229a) && Arrays.equals(this.f144230b, c6883b.f144230b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f144229a.hashCode() * 31) + Arrays.hashCode(this.f144230b);
        }

        public String toString() {
            return "MethodSignature(name=" + this.f144229a + ", parameterTypes=" + Arrays.toString(this.f144230b) + ')';
        }
    }

    static {
        Map map;
        Map map2;
        String name = NfcA.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "NfcA::class.java.name");
        f144219h = new b("NFC_A", 0, "NFC-A", name, new com.tencent.luggage.wxa.vf.c() { // from class: com.tencent.luggage.wxa.vf.h

            /* renamed from: b, reason: collision with root package name */
            public static final Lazy f143477b;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public static final a f143478a = new a();

                public a() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final byte[] invoke() {
                    return new byte[0];
                }
            }

            static {
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) a.f143478a);
                f143477b = lazy;
            }

            public final byte[] a() {
                return (byte[]) f143477b.getValue();
            }

            public final short b(NfcA nfcA) {
                return nfcA.getSak();
            }

            @Override // com.tencent.luggage.wxa.vf.c
            public void a(Tag tag, String function, com.tencent.luggage.wxa.wf.a aVar, Function1 callback) {
                g bVar;
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(function, "function");
                Intrinsics.checkNotNullParameter(callback, "callback");
                w.a("MicroMsg.AppBrand.NfcALogic", "execAsync, function: " + function);
                NfcA a16 = a(tag);
                if (a16 == null) {
                    callback.invoke(new g.a(13015, "unavailable tech"));
                    return;
                }
                if (Intrinsics.areEqual(function, "getAtqa")) {
                    bVar = new g.b(a(a16));
                } else {
                    bVar = Intrinsics.areEqual(function, "getSak") ? new g.b(Short.valueOf(b(a16))) : new g.a(13024, "function not support");
                }
                callback.invoke(bVar);
            }

            public final NfcA a(Tag tag) {
                return NfcA.get(tag);
            }

            public final byte[] a(NfcA nfcA) {
                byte[] atqa = nfcA.getAtqa();
                if (atqa == null) {
                    atqa = a();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("atqa: ");
                String arrays = Arrays.toString(atqa);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                sb5.append(arrays);
                w.a("MicroMsg.AppBrand.NfcALogic", sb5.toString());
                return atqa;
            }
        });
        String name2 = NfcB.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "NfcB::class.java.name");
        f144220i = new b("NFC_B", 1, "NFC-B", name2, null);
        String name3 = IsoDep.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "IsoDep::class.java.name");
        f144221j = new b("ISO_DEP", 2, "ISO-DEP", name3, new com.tencent.luggage.wxa.vf.c() { // from class: com.tencent.luggage.wxa.vf.d
            @Override // com.tencent.luggage.wxa.vf.c
            public void a(Tag tag, String function, com.tencent.luggage.wxa.wf.a aVar, Function1 callback) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(function, "function");
                Intrinsics.checkNotNullParameter(callback, "callback");
                w.a("MicroMsg.AppBrand.IsoDepLogic", "execAsync, function: " + function);
                IsoDep a16 = a(tag);
                if (a16 == null) {
                    callback.invoke(new g.a(13015, "unavailable tech"));
                } else {
                    callback.invoke(Intrinsics.areEqual(function, "getHistoricalBytes") ? new g.b(a(a16)) : new g.a(13024, "function not support"));
                }
            }

            public final IsoDep a(Tag tag) {
                return IsoDep.get(tag);
            }

            public final byte[] a(IsoDep isoDep) {
                byte[] historicalBytes = isoDep.getHistoricalBytes();
                if (historicalBytes == null) {
                    return null;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("historicalBytes: ");
                String arrays = Arrays.toString(historicalBytes);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                sb5.append(arrays);
                w.a("MicroMsg.AppBrand.IsoDepLogic", sb5.toString());
                return historicalBytes;
            }
        });
        String name4 = NfcF.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "NfcF::class.java.name");
        f144222k = new b("NFC_F", 3, "NFC-F", name4, null);
        String name5 = NfcV.class.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "NfcV::class.java.name");
        f144223l = new b("NFC_V", 4, "NFC-V", name5, null);
        String name6 = MifareClassic.class.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "MifareClassic::class.java.name");
        f144224m = new b("MIFARE_CLASSIC", 5, "MIFARE Classic", name6, null);
        String name7 = MifareUltralight.class.getName();
        Intrinsics.checkNotNullExpressionValue(name7, "MifareUltralight::class.java.name");
        C = new b("MIFARE_ULTRALIGHT", 6, "MIFARE Ultralight", name7, null);
        String name8 = Ndef.class.getName();
        Intrinsics.checkNotNullExpressionValue(name8, "Ndef::class.java.name");
        D = new b("NDEF", 7, "NDEF", name8, null);
        E = a();
        f144216e = new a(null);
        b[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (b bVar : values) {
            arrayList.add(TuplesKt.to(bVar.f144225a, bVar));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        f144217f = map;
        b[] values2 = values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (b bVar2 : values2) {
            arrayList2.add(TuplesKt.to(bVar2.f144226b, bVar2.f144225a));
        }
        map2 = MapsKt__MapsKt.toMap(arrayList2);
        f144218g = map2;
    }

    public b(String str, int i3, String str2, String str3, com.tencent.luggage.wxa.vf.c cVar) {
        this.f144225a = str2;
        this.f144226b = str3;
        this.f144227c = cVar;
    }

    public static final /* synthetic */ b[] a() {
        return new b[]{f144219h, f144220i, f144221j, f144222k, f144223l, f144224m, C, D};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) E.clone();
    }

    public final String d() {
        return this.f144226b;
    }

    public final com.tencent.luggage.wxa.vf.c e() {
        return this.f144227c;
    }

    public final String f() {
        return this.f144225a;
    }

    public final boolean a(String name, Class... parameterTypes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        C6883b c6883b = new C6883b(name, parameterTypes);
        Boolean bool = (Boolean) this.f144228d.get(c6883b);
        if (bool == null) {
            bool = Boolean.valueOf(a(this, name, parameterTypes, c6883b));
        }
        Intrinsics.checkNotNullExpressionValue(bool, "MethodSignature(name, pa\u2026            }()\n        }");
        return bool.booleanValue();
    }

    public static final boolean a(b bVar, String str, Class[] clsArr, C6883b c6883b) {
        boolean z16;
        try {
            Class.forName(bVar.f144226b).getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            z16 = true;
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get ");
            sb5.append(bVar.f144226b);
            sb5.append('.');
            sb5.append(str);
            sb5.append('(');
            String arrays = Arrays.toString(clsArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            sb5.append(arrays);
            sb5.append(") failed since ");
            sb5.append(e16);
            w.d("MicroMsg.AppBrand.NFCTech", sb5.toString());
            z16 = false;
        }
        bVar.f144228d.put(c6883b, Boolean.valueOf(z16));
        return z16;
    }
}
