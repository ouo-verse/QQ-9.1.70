package dg0;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.pageopener.api.IECMediaSelector;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCameraConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaSelectorConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J)\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J!\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006\u0012"}, d2 = {"Ldg0/a;", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/a;", "cameraConfig", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "selectorResultCallback", "", "openCamera", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/d;", "mediaSelectorConfig", "openCameraAndMediaSelector", DownloadInfo.spKey_Config, "openMediaSelector", "preLoad", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a implements IECMediaSelector {

    /* renamed from: b, reason: collision with root package name */
    public static final a f393682b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IECMediaSelector f393683a = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMediaSelector();

    a() {
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openCamera(Context context, ECCameraConfig cameraConfig, IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback) {
        this.f393683a.openCamera(context, cameraConfig, selectorResultCallback);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openCameraAndMediaSelector(Context context, ECCameraConfig cameraConfig, ECMediaSelectorConfig mediaSelectorConfig, IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback) {
        this.f393683a.openCameraAndMediaSelector(context, cameraConfig, mediaSelectorConfig, selectorResultCallback);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openMediaSelector(Context context, ECMediaSelectorConfig config, IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback) {
        this.f393683a.openMediaSelector(context, config, selectorResultCallback);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void preLoad(Context context) {
        this.f393683a.preLoad(context);
    }
}
