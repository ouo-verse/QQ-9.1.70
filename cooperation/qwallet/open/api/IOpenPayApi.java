package cooperation.qwallet.open.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qwallet.open.data.PayInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH&J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J&\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\rH&J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u0018"}, d2 = {"Lcooperation/qwallet/open/api/IOpenPayApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "callbackOpenPayResult", "", "context", "Landroid/content/Context;", "payInfo", "Lcooperation/qwallet/open/data/PayInfo;", "retCode", "", "retMsg", "", "getConfirmTransactionClazz", "Ljava/lang/Class;", "launchCompatOpenPay", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "launchQWalletFragment", "fragmentClass", "parseResponseFromJson", "serialNumber", "qwallet-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IOpenPayApi extends QRouteApi {
    void callbackOpenPayResult(@Nullable Context context, @NotNull PayInfo payInfo, int retCode, @NotNull String retMsg);

    @NotNull
    Class<?> getConfirmTransactionClazz();

    boolean launchCompatOpenPay(@Nullable Activity activity, @Nullable Intent intent);

    void launchQWalletFragment(@Nullable Context context, @NotNull Intent intent, @NotNull Class<?> fragmentClass);

    @NotNull
    String parseResponseFromJson(int retCode, @Nullable String retMsg, @Nullable String serialNumber);
}
