package com.tencent.liteav.videoconsumer.renderer;

import android.view.TextureView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f119559a;

    /* renamed from: b, reason: collision with root package name */
    private final TextureView f119560b;

    l(j jVar, TextureView textureView) {
        this.f119559a = jVar;
        this.f119560b = textureView;
    }

    public static Runnable a(j jVar, TextureView textureView) {
        return new l(jVar, textureView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119559a.a(this.f119560b);
    }
}
