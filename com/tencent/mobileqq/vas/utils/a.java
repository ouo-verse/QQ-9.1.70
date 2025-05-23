package com.tencent.mobileqq.vas.utils;

import com.tencent.mobileqq.vas.data.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/a;", "", "Llw4/c;", "rsp", "Lcom/tencent/mobileqq/vas/data/e;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f311243a = new a();

    a() {
    }

    public final e a(lw4.c rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        e eVar = new e();
        String str = rsp.f415701d;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.bubbleText");
        eVar.h(str);
        eVar.g(rsp.f415702e);
        eVar.j(rsp.f415703f);
        String str2 = rsp.f415698a;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.defaultUrl");
        eVar.i(str2);
        String str3 = rsp.f415699b;
        Intrinsics.checkNotNullExpressionValue(str3, "rsp.backgroundUrl");
        eVar.f(str3);
        lw4.e[] eVarArr = rsp.f415700c;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "rsp.woChanges");
        for (lw4.e eVar2 : eVarArr) {
            ArrayList<com.tencent.mobileqq.vas.data.c> c16 = eVar.c();
            com.tencent.mobileqq.vas.data.c cVar = new com.tencent.mobileqq.vas.data.c();
            cVar.d(eVar2.f415706a);
            cVar.e(eVar2.f415708c);
            cVar.f(eVar2.f415707b);
            c16.add(cVar);
        }
        return eVar;
    }
}
