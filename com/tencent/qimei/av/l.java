package com.tencent.qimei.av;

/* compiled from: P */
/* loaded from: classes22.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f343181a;

    public l(m mVar) {
        this.f343181a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            m.a(this.f343181a);
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
        }
    }
}
