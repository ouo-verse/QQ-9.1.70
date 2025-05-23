package com.tencent.rdelivery.reshub.util;

import com.tencent.ads.data.AdParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a8\u0006\r"}, d2 = {"Ljz3/e;", "", AdParam.APPVER, "", "b", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "c", "maxVer", "a", "", "", "d", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {
    private static final boolean a(String str, String str2) {
        List plus;
        List plus2;
        List<Pair> zip;
        String str3 = "AppVer: " + str + " ResAppMaxVer: " + str2;
        List<Integer> d16 = d(str);
        List<Integer> d17 = d(str2);
        if (!d16.isEmpty() && !d17.isEmpty()) {
            int max = Math.max(d16.size(), d17.size());
            List<Integer> list = d16;
            int size = max - d16.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(0);
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
            List<Integer> list2 = d17;
            int size2 = max - d17.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i16 = 0; i16 < size2; i16++) {
                arrayList2.add(0);
            }
            plus2 = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) arrayList2);
            zip = CollectionsKt___CollectionsKt.zip(plus, plus2);
            for (Pair pair : zip) {
                int intValue = ((Number) pair.component1()).intValue();
                int intValue2 = ((Number) pair.component2()).intValue();
                if (intValue > intValue2) {
                    jz3.d.c("ResAppMaxVer", "App Version Not Satisfy Res's AppMaxVersion. " + str3);
                    return true;
                }
                if (intValue != intValue2 && intValue < intValue2) {
                    break;
                }
            }
            return false;
        }
        jz3.d.c("ResAppMaxVer", "Bad Format For App Version Compare. " + str3);
        return false;
    }

    public static final boolean b(@NotNull jz3.e isAppVersionSatisfy, @NotNull String appVer) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(isAppVersionSatisfy, "$this$isAppVersionSatisfy");
        Intrinsics.checkParameterIsNotNull(appVer, "appVer");
        String str = isAppVersionSatisfy.f411277r;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (appVer.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                String app_max_ver = isAppVersionSatisfy.f411277r;
                Intrinsics.checkExpressionValueIsNotNull(app_max_ver, "app_max_ver");
                return !a(appVer, app_max_ver);
            }
        }
        return true;
    }

    public static final boolean c(@NotNull jz3.e isMatchWithHostApp, @NotNull com.tencent.rdelivery.reshub.core.a appInfo) {
        Intrinsics.checkParameterIsNotNull(isMatchWithHostApp, "$this$isMatchWithHostApp");
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        String id5 = isMatchWithHostApp.f411260a;
        Intrinsics.checkExpressionValueIsNotNull(id5, "id");
        int g16 = com.tencent.rdelivery.reshub.core.g.g(id5, appInfo);
        if (isMatchWithHostApp.f411261b < g16) {
            jz3.d.c("ResAppMaxVer", "not match with host app, Res(" + isMatchWithHostApp.f411260a + ") Local Version Not Usable,hostAppAllowedMinVersion: " + g16 + " LocalVer: " + isMatchWithHostApp.f411261b);
            return false;
        }
        if (!b(isMatchWithHostApp, com.tencent.rdelivery.reshub.core.j.L.e(appInfo))) {
            jz3.d.c("ResAppMaxVer", "not match with host app, Res(" + isMatchWithHostApp.f411260a + ") Max App Version Not Satisfy.");
            return false;
        }
        return true;
    }

    private static final List<Integer> d(String str) {
        List<Integer> emptyList;
        List split$default;
        int collectionSizeOrDefault;
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            List list = split$default;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
            }
            return arrayList;
        } catch (Exception unused) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
