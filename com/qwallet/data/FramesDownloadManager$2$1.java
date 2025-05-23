package com.qwallet.data;

import com.qwallet.data.ImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;

/* compiled from: P */
/* loaded from: classes3.dex */
class FramesDownloadManager$2$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageManager.b f41471d;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2 = this.f41471d.f41496o;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        str = a.f41551a;
        sb5.append(str);
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).unzipAtomically(str2, sb5.toString());
        throw null;
    }
}
