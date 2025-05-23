package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J;\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0004H\u0096\u0001R\u0012\u0010\u0003\u001a\u00020\u0004X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0004X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0004X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0004X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\u0004X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0004X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0005\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/impl/RIJImageOptConfigImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig;", "()V", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isReportOn", "isRollbackToDomainConnect", "decodeSharpP", "Landroid/graphics/Bitmap;", "path", "", "dstWidth", "", "dstHeight", DownloadInfo.spKey_Config, "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "filePath", "getMonitorTime", "", "isSharpPAvailable", "useInnerDns", "useIpConnect", "useSharpP", "useWebp", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RIJImageOptConfigImpl implements IRIJImageOptConfig {
    private final /* synthetic */ RIJImageOptConfig $$delegate_0 = RIJImageOptConfig.INSTANCE;

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public Bitmap decodeSharpP(String path, int dstWidth, int dstHeight, Bitmap config, Bitmap reuseBitmap) {
        return this.$$delegate_0.decodeSharpP(path, dstWidth, dstHeight, config, reuseBitmap);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public BitmapFactory.Options decodeSharpPInBounds(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return this.$$delegate_0.decodeSharpPInBounds(filePath);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public long getMonitorTime() {
        return this.$$delegate_0.getMonitorTime();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isBitmapOpt() {
        return this.$$delegate_0.isBitmapOpt();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isDecodeHttpStream() {
        return this.$$delegate_0.isDecodeHttpStream();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isLifoOn() {
        return this.$$delegate_0.isLifoOn();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isRenderFirst() {
        return this.$$delegate_0.isRenderFirst();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isReportOn() {
        return this.$$delegate_0.isReportOn();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isRollbackToDomainConnect() {
        return this.$$delegate_0.isRollbackToDomainConnect();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isSharpPAvailable() {
        return this.$$delegate_0.isSharpPAvailable();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useInnerDns() {
        return this.$$delegate_0.useInnerDns();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useIpConnect() {
        return this.$$delegate_0.useIpConnect();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useSharpP() {
        return this.$$delegate_0.useSharpP();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useWebp() {
        return this.$$delegate_0.useWebp();
    }
}
