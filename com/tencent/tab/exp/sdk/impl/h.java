package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
final class h {
    private static boolean a(@Nullable hd4.a aVar, @NonNull q qVar, @Nullable k kVar, @NonNull boolean z16, @NonNull int i3) {
        String j3 = qVar.j();
        if (aVar != null && !TextUtils.isEmpty(j3) && kVar != null && z16) {
            if (!kVar.g(i3)) {
                Log.d("TAB.TabExpDataReporter", "isNeedReportExpose false, report interval not match, ignore");
                return false;
            }
            if (!TextUtils.isEmpty(kVar.d()) && !TextUtils.equals(kVar.a(), "")) {
                return true;
            }
            Log.d("TAB.TabExpDataReporter", "isNeedReportExpose false, expGroupKey empty or assignment default, ignore");
            return false;
        }
        Log.d("TAB.TabExpDataReporter", "isNeedReportExpose false, guid or expInfo null or isUsing false, ignore");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(@Nullable hd4.a aVar, @NonNull q qVar, @Nullable k kVar, @NonNull boolean z16, @NonNull int i3) {
        if (a(aVar, qVar, kVar, z16, i3) && aVar.b(c.h(qVar.f(), qVar.j(), qVar.h(), kVar))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(@Nullable hd4.a aVar, @NonNull q qVar, @Nullable k kVar, @NonNull boolean z16, @NonNull int i3) {
        if (a(aVar, qVar, kVar, z16, i3) && aVar.b(c.i(qVar.f(), qVar.j(), qVar.h(), kVar))) {
            return true;
        }
        return false;
    }
}
