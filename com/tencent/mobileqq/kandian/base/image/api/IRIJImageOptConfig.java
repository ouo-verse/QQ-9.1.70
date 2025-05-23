package com.tencent.mobileqq.kandian.base.image.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J:\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0004\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isReportOn", "isRollbackToDomainConnect", "decodeSharpP", "Landroid/graphics/Bitmap;", "path", "", "dstWidth", "", "dstHeight", DownloadInfo.spKey_Config, "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "filePath", "getMonitorTime", "", "isSharpPAvailable", "useInnerDns", "useIpConnect", "useSharpP", "useWebp", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IRIJImageOptConfig extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ Bitmap a(IRIJImageOptConfig iRIJImageOptConfig, String str, int i3, int i16, Bitmap bitmap, Bitmap bitmap2, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 16) != 0) {
                    bitmap2 = null;
                }
                return iRIJImageOptConfig.decodeSharpP(str, i3, i16, bitmap, bitmap2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSharpP");
        }
    }

    @Nullable
    Bitmap decodeSharpP(@Nullable String path, int dstWidth, int dstHeight, @Nullable Bitmap config, @Nullable Bitmap reuseBitmap);

    @NotNull
    BitmapFactory.Options decodeSharpPInBounds(@NotNull String filePath);

    long getMonitorTime();

    boolean isBitmapOpt();

    boolean isDecodeHttpStream();

    boolean isLifoOn();

    boolean isRenderFirst();

    boolean isReportOn();

    boolean isRollbackToDomainConnect();

    boolean isSharpPAvailable();

    boolean useInnerDns();

    boolean useIpConnect();

    boolean useSharpP();

    boolean useWebp();
}
