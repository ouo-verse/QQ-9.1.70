package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.rc.p;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements p {

    /* renamed from: d, reason: collision with root package name */
    public static final a f139521d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final Map f139522e = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name */
    public f0 f139523a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f139524b;

    /* renamed from: c, reason: collision with root package name */
    public final Function2 f139525c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(long j3) {
            synchronized (f.f139522e) {
                if (!f.f139522e.keySet().contains(Long.valueOf(j3))) {
                    f.f139522e.put(Long.valueOf(j3), new f(j3, null, 2, null));
                }
                Unit unit = Unit.INSTANCE;
            }
            Object obj = f.f139522e.get(Long.valueOf(j3));
            Intrinsics.checkNotNull(obj);
            return (f) obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f139526a;

        /* renamed from: b, reason: collision with root package name */
        public final String f139527b;

        /* renamed from: c, reason: collision with root package name */
        public final String f139528c;

        public b(String data, String type, String size) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(size, "size");
            this.f139526a = data;
            this.f139527b = type;
            this.f139528c = size;
        }

        public final String a() {
            return this.f139526a;
        }

        public final String b() {
            return this.f139528c;
        }

        public final String c() {
            return this.f139527b;
        }

        public final boolean d() {
            boolean z16;
            boolean z17;
            boolean z18;
            if (this.f139526a.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.f139527b.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (this.f139528c.length() == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            String string = f.this.b().getString(key, "");
            if (string == null) {
                return "";
            }
            return string;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function2 {
        public d() {
            super(2);
        }

        public final void a(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            f.this.b().putString(key, value);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    public f(long j3, String storageFileNamePrefix) {
        f0 e16;
        Intrinsics.checkNotNullParameter(storageFileNamePrefix, "storageFileNamePrefix");
        com.tencent.luggage.wxa.tn.w.d("AppBrandMMKVStorage", "getMMKV uin:" + j3);
        if (storageFileNamePrefix.length() > 0) {
            e16 = f0.e(storageFileNamePrefix + j3);
            Intrinsics.checkNotNullExpressionValue(e16, "{\n            MultiProce\u2026mePrefix + uin)\n        }");
        } else {
            e16 = f0.e("AppBrandMMKVStorage" + j3);
            Intrinsics.checkNotNullExpressionValue(e16, "{\n            MultiProce\u2026MKV(NAME + uin)\n        }");
        }
        this.f139523a = e16;
        this.f139524b = new c();
        this.f139525c = new d();
    }

    public final f0 b() {
        return this.f139523a;
    }

    public final boolean c(int i3, String str, int i16) {
        return d(i3, str) + i16 >= c(i3, str);
    }

    public final int d(int i3, String str) {
        return w0.a(this.f139523a.getString(v.a(i3, str, "@@@TOTAL@DATA@SIZE@@@", "++"), ""), 0);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public Object[] a(int i3, String str, String str2) {
        if (w0.c(str) || w0.c(str2)) {
            return new Object[]{p.a.MISSING_PARAMS};
        }
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(str2);
        String string = this.f139523a.getString(v.a(i3, str, str2, "__"), "");
        b c16 = c(string != null ? string : "");
        return !c16.d() ? new Object[]{p.a.NONE, c16.a(), c16.c()} : v.f139570c;
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public List b(int i3, String str, List keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        ArrayList arrayList = new ArrayList();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            arrayList.add(a(i3, str, (String) it.next()));
        }
        return arrayList;
    }

    public final boolean c(int i3, String str, List list) {
        Iterator it = list.iterator();
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            p.b bVar = (p.b) it.next();
            i16 += v.a(bVar.f139565a, bVar.f139566b);
            String str2 = bVar.f139565a;
            Intrinsics.checkNotNull(str2);
            i17 += a(v.a(i3, str, str2, "__"));
        }
        return c(i3, str, i16 - i17);
    }

    public final void b(int i3, String str, int i16) {
        this.f139523a.putString(v.a(i3, str, "@@@TOTAL@DATA@SIZE@@@", "++"), String.valueOf(i16));
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public p.a b(int i3, String str, String str2) {
        if (!w0.c(str) && !w0.c(str2)) {
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNull(str2);
            String a16 = v.a(i3, str, str2, "__");
            int a17 = a(i3, str, -a(a16));
            this.f139523a.remove(a16);
            if (a17 <= 0) {
                v.b(str, i3, this.f139524b, this.f139525c);
            }
            return p.a.NONE;
        }
        return p.a.MISSING_PARAMS;
    }

    public final b c(String str) {
        Object[] array = new Regex("#").split(str, 3).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 3) {
            return new b(strArr[2], strArr[0], strArr[1]);
        }
        return new b("", "", "");
    }

    public /* synthetic */ f(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? "" : str);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public p.a a(int i3, String str, String str2, String str3, String dataType) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        return a(i3, str, str2, str3, dataType, v.a(str2, str3));
    }

    public p.a a(int i3, String str, String str2, String str3, String dataType, int i16) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        if (!w0.c(str) && !w0.c(str2)) {
            Intrinsics.checkNotNull(str);
            return a(i3, str, str2, str3, i16, dataType, true);
        }
        return p.a.MISSING_PARAMS;
    }

    public final void c() {
        f0 f0Var = this.f139523a;
        if (f0Var != null) {
            com.tencent.luggage.wxa.tn.w.d("AppBrandMMKVStorage", "reset " + this.f139523a);
            f0Var.b();
        }
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public void b(int i3, String str) {
        boolean startsWith$default;
        if (w0.c(str)) {
            return;
        }
        String str2 = i3 == 0 ? str + "__" : i3 + "__" + str + "__";
        String[] a16 = this.f139523a.a();
        if (a16 == null) {
            a16 = new String[0];
        }
        for (String key : a16) {
            Intrinsics.checkNotNullExpressionValue(key, "key");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, str2, false, 2, null);
            if (startsWith$default) {
                this.f139523a.remove(key);
            }
        }
        Intrinsics.checkNotNull(str);
        b(i3, str, 0);
        v.b(str, i3, this.f139524b, this.f139525c);
    }

    public final p.a a(int i3, String str, String str2, String str3, int i16, String str4, boolean z16) {
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(str2);
        String a16 = v.a(i3, str, str2, "__");
        int a17 = i16 - a(a16);
        if (z16 && c(i3, str, a17)) {
            return p.a.QUOTA_REACHED;
        }
        this.f139523a.putString(a16, a(str3, str4, i16));
        a(i3, str, a17);
        v.a(str, i3, this.f139524b, this.f139525c);
        return p.a.NONE;
    }

    public final int c(int i3, String str) {
        return v.a(i3, str);
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public int b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        int i3 = 0;
        for (int i16 : v.a(appId, this.f139524b, this.f139525c)) {
            i3 += d(i16, appId);
        }
        return i3;
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public p.a a(int i3, String str, List kvInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kvInfo, "kvInfo");
        if (!w0.c(str)) {
            if (!(kvInfo instanceof Collection) || !kvInfo.isEmpty()) {
                Iterator it = kvInfo.iterator();
                while (it.hasNext()) {
                    if (w0.c(((p.b) it.next()).f139565a)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                Intrinsics.checkNotNull(str);
                if (c(i3, str, kvInfo)) {
                    return p.a.QUOTA_REACHED;
                }
                Iterator it5 = kvInfo.iterator();
                while (it5.hasNext()) {
                    p.b bVar = (p.b) it5.next();
                    String str2 = bVar.f139565a;
                    String str3 = bVar.f139566b;
                    int a16 = v.a(str2, str3);
                    String str4 = bVar.f139567c;
                    Intrinsics.checkNotNullExpressionValue(str4, "info.dataType");
                    a(i3, str, str2, str3, a16, str4, false);
                }
                return p.a.NONE;
            }
        }
        return p.a.MISSING_PARAMS;
    }

    public final int a(int i3, String str, int i16) {
        int max = Math.max(0, d(i3, str) + i16);
        b(i3, str, max);
        return max;
    }

    public final int a(String str) {
        String string = this.f139523a.getString(str, "");
        try {
            return Integer.parseInt(c(string != null ? string : "").b());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final String a(String str, String str2, int i3) {
        return "" + str2 + '#' + i3 + '#' + str;
    }

    @Override // com.tencent.luggage.wxa.rc.p
    public Object[] a(int i3, String str) {
        String str2;
        boolean startsWith$default;
        int i16;
        int i17;
        String replace$default;
        List emptyList;
        if (str == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new Object[]{emptyList, 0, 0};
        }
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            str2 = str + "__";
        } else {
            str2 = i3 + "__" + str + "__";
        }
        String[] a16 = this.f139523a.a();
        if (a16 == null) {
            a16 = new String[0];
        }
        String[] strArr = a16;
        int length = strArr.length;
        int i18 = 0;
        while (i18 < length) {
            String key = strArr[i18];
            Intrinsics.checkNotNullExpressionValue(key, "key");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, str2, false, 2, null);
            if (startsWith$default) {
                i16 = i18;
                i17 = length;
                replace$default = StringsKt__StringsJVMKt.replace$default(key, str2, "", false, 4, (Object) null);
                arrayList.add(replace$default);
            } else {
                i16 = i18;
                i17 = length;
            }
            i18 = i16 + 1;
            length = i17;
        }
        return new Object[]{arrayList, Integer.valueOf(d(i3, str)), Integer.valueOf(c(i3, str))};
    }
}
