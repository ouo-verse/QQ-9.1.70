package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\nH\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020'2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010,\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/RIJImageOptConfig;", "Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig;", "()V", "FILE_TYPE_SHARPP", "", "FILE_TYPE_WEBP", "bitmapOpt", "decodeHttpStream", "fileTypeOpt", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isReportOn", "isRollbackToDomainConnect", "lifoOn", "monitorTime", "", "renderFirst", "reportOn", "rollbackDomainConnect", "useInnerDns", "useKandianIpConnect", "decodeSharpP", "Landroid/graphics/Bitmap;", "path", "", "dstWidth", "dstHeight", DownloadInfo.spKey_Config, "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "filePath", "getMonitorTime", "isSharpPAvailable", "setBitmapOpt", "", "setDecodeHttpStream", "setFileTypeOpt", "setLifoOn", "setMonitorTime", "setRenderFirst", "setReportOn", "setRollbackToDomainConnect", "setUseInnerDns", "setUseKanDianIpConnect", "useKanDianIpConnect", "useIpConnect", "useSharpP", "useWebp", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RIJImageOptConfig implements IRIJImageOptConfig {
    private static int bitmapOpt;
    private static int decodeHttpStream;
    private static int fileTypeOpt;
    private static int lifoOn;
    private static long monitorTime;
    private static int renderFirst;
    private static int reportOn;
    private static int rollbackDomainConnect;
    private static int useInnerDns;
    private static int useKandianIpConnect;
    public static final RIJImageOptConfig INSTANCE = new RIJImageOptConfig();
    private static final int FILE_TYPE_WEBP = 1;
    private static final int FILE_TYPE_SHARPP = 2;

    RIJImageOptConfig() {
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public Bitmap decodeSharpP(String path, int dstWidth, int dstHeight, Bitmap config, Bitmap reuseBitmap) {
        return new f().b(path, dstWidth, dstHeight, Bitmap.Config.ARGB_8888, reuseBitmap);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public BitmapFactory.Options decodeSharpPInBounds(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new f().c(filePath);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public long getMonitorTime() {
        long j3 = monitorTime;
        if (j3 > 0) {
            return j3;
        }
        return 10000L;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isBitmapOpt() {
        return bitmapOpt == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isDecodeHttpStream() {
        return decodeHttpStream == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isLifoOn() {
        return lifoOn == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isRenderFirst() {
        return renderFirst == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isReportOn() {
        return reportOn == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isRollbackToDomainConnect() {
        return rollbackDomainConnect == 1;
    }

    public final void setBitmapOpt(int bitmapOpt2) {
        bitmapOpt = bitmapOpt2;
    }

    public final void setDecodeHttpStream(int decodeHttpStream2) {
        decodeHttpStream = decodeHttpStream2;
    }

    public final void setFileTypeOpt(int fileTypeOpt2) {
        fileTypeOpt = fileTypeOpt2;
    }

    public final void setLifoOn(int lifoOn2) {
        lifoOn = lifoOn2;
    }

    public final void setMonitorTime(long monitorTime2) {
        monitorTime = monitorTime2;
    }

    public final void setRenderFirst(int renderFirst2) {
        renderFirst = renderFirst2;
    }

    public final void setReportOn(int reportOn2) {
        reportOn = reportOn2;
    }

    public final void setRollbackToDomainConnect(int rollbackDomainConnect2) {
        rollbackDomainConnect = rollbackDomainConnect2;
    }

    public final void setUseInnerDns(int useInnerDns2) {
        useInnerDns = useInnerDns2;
    }

    public final void setUseKanDianIpConnect(int useKanDianIpConnect) {
        useKandianIpConnect = useKanDianIpConnect;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useInnerDns() {
        return useInnerDns == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useIpConnect() {
        return useKandianIpConnect == 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useSharpP() {
        return fileTypeOpt == FILE_TYPE_SHARPP;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean useWebp() {
        return fileTypeOpt == FILE_TYPE_WEBP;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
    public boolean isSharpPAvailable() {
        return com.tencent.qqsharpP.a.b(null);
    }
}
