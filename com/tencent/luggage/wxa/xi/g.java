package com.tencent.luggage.wxa.xi;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f145050a = new g();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f145051a = new a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int length;
            int length2;
            int compareValues;
            if (obj2 instanceof n0.h) {
                length = ((n0.h) obj2).f125933a.length();
            } else if (obj2 instanceof ModulePkgInfo) {
                length = ((ModulePkgInfo) obj2).name.length();
            } else {
                throw new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
            }
            Integer valueOf = Integer.valueOf(length);
            if (obj instanceof n0.h) {
                length2 = ((n0.h) obj).f125933a.length();
            } else if (obj instanceof ModulePkgInfo) {
                length2 = ((ModulePkgInfo) obj).name.length();
            } else {
                throw new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(length2));
            return compareValues;
        }
    }

    public static final Object a(List list, String pathOrModule, String str) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(pathOrModule, "pathOrModule");
        return a(list, pathOrModule, str, false, 4, null);
    }

    public final boolean b(Object obj) {
        if (obj instanceof n0.h) {
            return ((n0.h) obj).f125935c;
        }
        if (obj instanceof ModulePkgInfo) {
            return ((ModulePkgInfo) obj).independent;
        }
        throw new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
    }

    public final String c(Object obj) {
        if (obj instanceof n0.h) {
            return ((n0.h) obj).f125933a;
        }
        if (obj instanceof ModulePkgInfo) {
            return ((ModulePkgInfo) obj).name;
        }
        throw new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
    }

    public final String[] a(Object obj) {
        if (obj instanceof n0.h) {
            return ((n0.h) obj).f125937e;
        }
        if (obj instanceof ModulePkgInfo) {
            return ((ModulePkgInfo) obj).aliases;
        }
        throw new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
    }

    public static final boolean a(Object obj, String pathOrModuleName, String str) {
        List listOf;
        Intrinsics.checkNotNullParameter(pathOrModuleName, "pathOrModuleName");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(obj);
        return Intrinsics.areEqual(a(listOf, pathOrModuleName, str, false, 4, null), obj);
    }

    public static /* synthetic */ Object a(List list, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return a(list, str, str2, z16);
    }

    public static final Object a(List list, String pathOrModule, String str, boolean z16) {
        String[] strArr;
        String[] a16;
        boolean startsWith$default;
        g gVar;
        String c16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(pathOrModule, "pathOrModule");
        String[] a17 = f145050a.a(pathOrModule);
        Iterator it = a(list).iterator();
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                boolean z17 = false;
                if (next == null || (c16 = (gVar = f145050a).c(next)) == null || (strArr = gVar.a(c16)) == null) {
                    strArr = new String[0];
                }
                g gVar2 = f145050a;
                if (gVar2.a(a17, strArr)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("findModule, hit module(independent:");
                    if (next != null && gVar2.b(next)) {
                        z17 = true;
                    }
                    sb5.append(z17);
                    sb5.append(") by name:");
                    sb5.append(next != null ? gVar2.c(next) : null);
                    sb5.append(", path:");
                    sb5.append(pathOrModule);
                    sb5.append(", message[ ");
                    sb5.append(str);
                    sb5.append(" ]");
                    w.d("Luggage.FULL.WxaRuntimeModularizingUtils", sb5.toString());
                    Intrinsics.checkNotNull(next);
                    return next;
                }
                if (next != null && (a16 = gVar2.a(next)) != null) {
                    int length = a16.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str2 = a16[i3];
                        String[] strArr2 = a17;
                        if (!(str2 == null || str2.length() == 0)) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pathOrModule, str2, false, 2, null);
                            if (startsWith$default) {
                                w.d("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, hit module(independent:" + f145050a.b(next) + ") by alias:" + str2 + ", path:" + pathOrModule + ", message[ " + str + " ]");
                                return next;
                            }
                        }
                        i3++;
                        a17 = strArr2;
                    }
                }
            } else {
                w.d("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, return null with path:" + pathOrModule + ", message[ " + str + " ]");
                return null;
            }
        }
    }

    public final String[] a(String str) {
        List split$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = 0;
                break;
            }
            if (str.charAt(i3) != '/') {
                break;
            }
            i3++;
        }
        int length2 = str.length();
        int length3 = str.length();
        while (true) {
            length3--;
            if (-1 >= length3 || str.charAt(length3) != '/') {
                break;
            }
            length2--;
        }
        String substring = str.substring(i3, length2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{"/"}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final boolean a(String[] strArr, String[] prefixArr) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(prefixArr, "prefixArr");
        if (strArr.length < prefixArr.length) {
            return false;
        }
        int length = prefixArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (!Intrinsics.areEqual(strArr[i3], prefixArr[i3])) {
                return false;
            }
        }
        return true;
    }

    public static final List a(List list) {
        List sortedWith;
        Intrinsics.checkNotNullParameter(list, "<this>");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new b());
        return sortedWith;
    }
}
