package com.tencent.ecommerce.base.pageopener.api;

import android.content.Context;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCameraConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaSelectorConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH&J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "", "Landroid/content/Context;", "context", "", "preLoad", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/d;", DownloadInfo.spKey_Config, "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "selectorResultCallback", "openMediaSelector", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/a;", "cameraConfig", "openCamera", "mediaSelectorConfig", "openCameraAndMediaSelector", "ECMediaSelectorResultCallback", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECMediaSelector {
    void openCamera(@NotNull Context context, @NotNull ECCameraConfig cameraConfig, @NotNull ECMediaSelectorResultCallback selectorResultCallback);

    void openCameraAndMediaSelector(@NotNull Context context, @NotNull ECCameraConfig cameraConfig, @NotNull ECMediaSelectorConfig mediaSelectorConfig, @NotNull ECMediaSelectorResultCallback selectorResultCallback);

    void openMediaSelector(@NotNull Context context, @NotNull ECMediaSelectorConfig config, @NotNull ECMediaSelectorResultCallback selectorResultCallback);

    void preLoad(@NotNull Context context);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "medias", "", "onCameraCaptureResultCallback", "onAlbumSelectedResultCallback", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface ECMediaSelectorResultCallback {
        void onAlbumSelectedResultCallback(@NotNull List<ECMediaInfo> medias);

        void onCameraCaptureResultCallback(@NotNull List<ECMediaInfo> medias);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes5.dex */
        public static final class a {
            public static void a(@NotNull ECMediaSelectorResultCallback eCMediaSelectorResultCallback, @NotNull List<ECMediaInfo> list) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static void a(@NotNull IECMediaSelector iECMediaSelector, @NotNull Context context) {
        }
    }
}
