package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.util.Log;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
final class s implements hd4.a, md4.a {
    @Override // md4.a
    public boolean a(Map<String, String> map) {
        Log.d("TAB.TabReportImpl", "reportWithEventCode report version!");
        return false;
    }

    @Override // hd4.a
    public boolean b(@NonNull hd4.b bVar) {
        Log.d("TAB.TabReportImpl", "reportBeaconEvent report version!");
        return false;
    }
}
