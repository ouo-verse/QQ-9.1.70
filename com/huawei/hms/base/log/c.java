package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private d f36769a;

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f36769a;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f36769a = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i3, String str2, String str3) {
        Log.println(i3, "HMSSDK_" + str2, str3);
        d dVar = this.f36769a;
        if (dVar != null) {
            dVar.a(str, i3, str2, str3);
        }
    }
}
