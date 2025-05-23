package com.tencent.beacon.c;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.net.b.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f77807a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.a.d.a f77808b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f77809c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, String str, com.tencent.beacon.a.d.a aVar) {
        this.f77809c = cVar;
        this.f77807a = str;
        this.f77808b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean c16;
        boolean z16;
        if (d.d()) {
            c16 = this.f77809c.c();
            z16 = this.f77809c.f77812c;
            if (z16 && c16) {
                com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success : " + this.f77807a, new Object[0]);
                a.SharedPreferencesEditorC0784a edit = this.f77808b.edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("active_user_date", this.f77807a).commit();
                    edit.putString("HEART_DENGTA", this.f77807a).commit();
                }
            }
        }
    }
}
