package com.tencent.liteav.videoconsumer.renderer;

import android.view.TextureView;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f119556a;

    /* renamed from: b, reason: collision with root package name */
    private final TXCloudVideoView f119557b;

    /* renamed from: c, reason: collision with root package name */
    private final TextureView f119558c;

    k(j jVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        this.f119556a = jVar;
        this.f119557b = tXCloudVideoView;
        this.f119558c = textureView;
    }

    public static Runnable a(j jVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        return new k(jVar, tXCloudVideoView, textureView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a(this.f119556a, this.f119557b, this.f119558c);
    }
}
