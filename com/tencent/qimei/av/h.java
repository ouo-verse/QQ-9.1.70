package com.tencent.qimei.av;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Object f343171a;

    /* renamed from: b, reason: collision with root package name */
    public String f343172b;

    /* renamed from: c, reason: collision with root package name */
    public i f343173c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.qimei.ab.g f343174d;

    public h(String str) {
        Object obj = new Object();
        this.f343171a = obj;
        this.f343172b = str;
        this.f343173c = null;
        this.f343174d = new com.tencent.qimei.ab.g(obj, 30000);
    }

    public void a() {
        com.tencent.qimei.ab.g gVar = this.f343174d;
        gVar.getClass();
        try {
            synchronized (gVar.f342929a) {
                gVar.f342929a.wait(30000);
            }
        } catch (InterruptedException e16) {
            com.tencent.qimei.ad.c.a(e16);
        }
    }

    @JavascriptInterface
    public void callback(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.f343173c = new i(str, this.f343172b, str2, str3, str4);
        }
        com.tencent.qimei.ab.g gVar = this.f343174d;
        synchronized (gVar.f342929a) {
            gVar.f342929a.notifyAll();
        }
    }
}
