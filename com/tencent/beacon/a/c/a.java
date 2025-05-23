package com.tencent.beacon.a.c;

import android.content.SharedPreferences;
import com.tencent.beacon.a.d.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.a.d.a f77627a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77628b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f77629c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tencent.beacon.a.d.a aVar, String str, long j3) {
        this.f77627a = aVar;
        this.f77628b = str;
        this.f77629c = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.SharedPreferencesEditorC0784a edit = this.f77627a.edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
            edit.putLong(this.f77628b, this.f77629c);
        }
    }
}
