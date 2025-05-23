package com.tencent.ecommerce.biz.webview;

import android.app.Activity;
import android.content.Intent;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u00072\u0006\u0010\t\u001a\u00020\nH&J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/webview/IECWebViewPluginModel;", "", "action", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "reqData", "", "", "callBack", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "onActivityResult", "intent", "Landroid/content/Intent;", "requestCode", "", QzoneIPCModule.RESULT_CODE, "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECWebViewPluginModel {
    void action(@Nullable Activity activity, @NotNull Map<String, ?> reqData, @NotNull IECLogicCallback callBack);

    void onActivityResult(@Nullable Intent intent, int requestCode, int resultCode);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static void a(@NotNull IECWebViewPluginModel iECWebViewPluginModel, @Nullable Intent intent, int i3, int i16) {
        }
    }
}
