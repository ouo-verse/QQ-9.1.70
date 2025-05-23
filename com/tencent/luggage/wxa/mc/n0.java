package com.tencent.luggage.wxa.mc;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f134345a = new n0();

    public static final String a(String appId, int i3) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(appId, "appId");
        int[] WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130735e;
        Intrinsics.checkNotNullExpressionValue(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
        ArrayList arrayList = new ArrayList(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES.length);
        for (int i16 : WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES) {
            arrayList.add("appId='" + new r(appId, "", i16) + '\'');
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " or ", null, null, 0, null, null, 62, null);
        return '(' + joinToString$default + ") and debugType=" + i3;
    }

    public static final String b(String appId, int i3) {
        String joinToString$default;
        String trimIndent;
        Intrinsics.checkNotNullParameter(appId, "appId");
        int[] WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130735e;
        Intrinsics.checkNotNullExpressionValue(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
        ArrayList arrayList = new ArrayList(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES.length);
        for (int i16 : WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES) {
            arrayList.add("appId!='" + new r(appId, "", i16) + '\'');
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " and ", null, null, 0, null, null, 62, null);
        trimIndent = StringsKt__IndentKt.trimIndent("\n            appId like '" + appId + "$%' and " + joinToString$default + " and debugType=" + i3 + "\n        ");
        return trimIndent;
    }
}
