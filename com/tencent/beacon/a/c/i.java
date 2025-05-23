package com.tencent.beacon.a.c;

import android.content.Context;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.QimeiSDK;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f77675a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f77676b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ IAsyncQimeiListener f77677c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, IAsyncQimeiListener iAsyncQimeiListener) {
        this.f77675a = str;
        this.f77676b = context;
        this.f77677c = iAsyncQimeiListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "async getQimeiWithAppkey  appkey is %s", this.f77675a);
        j.c(this.f77676b.getApplicationContext(), this.f77675a);
        QimeiSDK.getInstance(this.f77675a).getQimei(this.f77677c);
    }
}
