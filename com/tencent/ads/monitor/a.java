package com.tencent.ads.monitor;

import android.text.TextUtils;
import java.net.HttpCookie;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
final class a implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f61666d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.f61666d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f61666d)) {
            String[] split = this.f61666d.split("Set-Cookie: ");
            ArrayList<HttpCookie> arrayList = new ArrayList();
            for (String str : split) {
                String replace = str.trim().replace("\r\n", "");
                if (replace.length() != 0) {
                    arrayList.addAll(HttpCookie.parse("Set-Cookie: " + replace));
                }
            }
            for (HttpCookie httpCookie : arrayList) {
                com.tencent.ads.service.b.a();
                com.tencent.ads.service.b.b().a(httpCookie);
            }
        }
        com.tencent.ads.service.b.a().c();
    }
}
