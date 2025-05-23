package ig0;

import android.content.Context;
import com.tencent.ecommerce.base.pageopener.api.IECMediaSelector;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCameraConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaSelectorConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lig0/a;", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/d;", DownloadInfo.spKey_Config, "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "selectorResultCallback", "", "openMediaSelector", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/a;", "cameraConfig", "openCamera", "mediaSelectorConfig", "openCameraAndMediaSelector", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECMediaSelector {
    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void preLoad(@NotNull Context context) {
        IECMediaSelector.a.a(this, context);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openCamera(@NotNull Context context, @NotNull ECCameraConfig cameraConfig, @NotNull IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback) {
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openMediaSelector(@NotNull Context context, @NotNull ECMediaSelectorConfig config, @NotNull IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback) {
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openCameraAndMediaSelector(@NotNull Context context, @NotNull ECCameraConfig cameraConfig, @NotNull ECMediaSelectorConfig mediaSelectorConfig, @NotNull IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback) {
    }
}
