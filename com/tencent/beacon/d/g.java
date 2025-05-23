package com.tencent.beacon.d;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;

/* compiled from: P */
/* loaded from: classes2.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f77854a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f77855b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, String str) {
        this.f77855b = hVar;
        this.f77854a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.SharedPreferencesEditorC0784a edit = com.tencent.beacon.a.d.a.a().edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putString("ias_cookie", this.f77854a);
        }
    }
}
