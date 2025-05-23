package com.tencent.sqshow.zootopia.utils;

import android.text.TextUtils;
import com.epicgames.ue4.ZPlanVersion;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.config.AppSetting;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ab;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f373250b;

    /* renamed from: c, reason: collision with root package name */
    private static String f373251c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ab$a;", "", "", "b", "d", "c", "a", "IPV4_BETA_VIP", "Ljava/lang/String;", "TAG", "UE_ENV_DEFAULT_DEV", "UE_ENV_DEFAULT_PREVIEW_SHIPPING", "UE_ENV_DEFAULT_SHIPPING", "UE_ENV_ONLINE_KEY", "", "defaultUeEnvMap", "Ljava/util/Map;", "ueEnv", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.utils.ab$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String ret = AppSetting.f99554n;
            Intrinsics.checkNotNullExpressionValue(ret, "ret");
            return ret;
        }

        public final String b() {
            return "";
        }

        public final String c() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, d());
            jSONObject.put("qqVersion", a());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "extraJson.toString()");
            QLog.e("ZPlanEnvUtil", 1, "getUEStartUpExtraConfig - " + jSONObject2);
            return jSONObject2;
        }

        public final String d() {
            if (!TextUtils.isEmpty(ab.f373251c)) {
                return ab.f373251c;
            }
            Map<String, String> zPlanUeEnvConfig = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanUeEnvConfig();
            String str = zPlanUeEnvConfig.get("other");
            if (str == null) {
                str = ZPlanVersion.ZPlanBranch;
            }
            ab.f373251c = str;
            QLog.e("ZPlanEnvUtil", 1, "getZPlanUeEnv - " + ab.f373251c + ", configMap= " + zPlanUeEnvConfig);
            return ab.f373251c;
        }

        Companion() {
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("191", "previewshipping");
        linkedHashMap.put("417", "previewshipping");
        linkedHashMap.put("419", APMidasPayAPI.ENV_DEV);
        f373250b = linkedHashMap;
        f373251c = "";
    }
}
