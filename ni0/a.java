package ni0;

import android.content.Context;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J0\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lni0/a;", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isReleaseEnv", "loggable", "", "a", "", "goodsTokenUrl", "", "from", "payTypeId", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "payCallBack", "b", "Lkotlin/NotImplementedError;", "Lkotlin/NotImplementedError;", "notImplementError", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECPayApi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final NotImplementedError notImplementError = new NotImplementedError("IECPayApi \u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002");

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void init(@NotNull Context activity, boolean isReleaseEnv, boolean loggable) {
        throw this.notImplementError;
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void pay(@NotNull Context activity, @NotNull String goodsTokenUrl, int from, int payTypeId, @NotNull IECPayApi.ECPayCallback payCallBack) {
        throw this.notImplementError;
    }
}
