package com.tencent.ecommerce.biz.pay.api;

import android.app.Activity;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\u000eJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "title", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lorg/json/JSONObject;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/ecommerce/biz/pay/api/IECVasPayObserver;", "ecObserve", "", "openVasRecharge", "Companion", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECVasRechargeApi {

    @NotNull
    public static final String APP_ID = "app_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f103899a;

    @NotNull
    public static final String EXT_PARAMS = "ext_params";

    @NotNull
    public static final String PARAM_ID = "param_id";

    @NotNull
    public static final String PARAM_SUB_ID = "params_sub_id";

    @NotNull
    public static final String SOURCE = "source";

    @NotNull
    public static final String SUB_SCENE_ID = "ec_sub_scene_id";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi$a;", "", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.pay.api.IECVasRechargeApi$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f103899a = new Companion();

        Companion() {
        }
    }

    void openVasRecharge(@NotNull Activity activity, @NotNull String title, @NotNull String businessName, @NotNull JSONObject reportParams, @NotNull IECVasPayObserver ecObserve);
}
