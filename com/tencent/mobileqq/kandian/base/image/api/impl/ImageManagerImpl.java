package com.tencent.mobileqq.kandian.base.image.api.impl;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.b;
import java.net.URL;
import k52.a;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0006H\u0096\u0001J\u0015\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u001d\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/impl/ImageManagerImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IImageManager;", "Lcom/tencent/mobileqq/kandian/base/image/b;", Const.BUNDLE_KEY_REQUEST, "", "reason", "", "cancelRequest", "clean", "Lk52/b;", "getBitmap", "Ljava/net/URL;", "url", "", "isLocalFileExist", "Lk52/a;", "uicallback", "loadImage", "pauseDownload", "resume", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ImageManagerImpl implements IImageManager {
    private final /* synthetic */ ImageManager $$delegate_0 = ImageManager.get();

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void cancelRequest(b request, String reason) {
        this.$$delegate_0.cancelRequest(request, reason);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void clean() {
        this.$$delegate_0.clean();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public k52.b getBitmap(b request) {
        return this.$$delegate_0.getBitmap(request);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public boolean isLocalFileExist(URL url) {
        return this.$$delegate_0.isLocalFileExist(url);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void loadImage(b request, a uicallback) {
        this.$$delegate_0.loadImage(request, uicallback);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void pauseDownload() {
        this.$$delegate_0.pauseDownload();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IImageManager
    public void resume() {
        this.$$delegate_0.resume();
    }
}
