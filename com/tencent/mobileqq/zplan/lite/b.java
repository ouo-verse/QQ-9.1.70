package com.tencent.mobileqq.zplan.lite;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.model.y;
import com.tencent.zplan.common.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/b;", "", "", "c", "d", "b", "Ljava/lang/String;", "templateConfigJsonStr", "Lcom/tencent/sqshow/utils/featureswitch/model/y;", "Lcom/tencent/sqshow/utils/featureswitch/model/y;", "zplanFilamentResCfg", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f333795a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String templateConfigJsonStr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static y zplanFilamentResCfg;

    static {
        templateConfigJsonStr = "";
        zplanFilamentResCfg = new y();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026essConstant.ALL\n        )");
        JSONObject jSONObject = ((IFeatureRuntimeService) runtimeService).getJSONObject("zplan_lite_resources_url_template", "");
        j74.b bVar = j74.b.f409622a;
        if (!TextUtils.isEmpty(j74.b.e(bVar, null, 1, null))) {
            try {
                jSONObject = new JSONObject(j74.b.e(bVar, null, 1, null));
            } catch (Exception e16) {
                QLog.e("ZPlanFilamentResConfigUtil", 1, "debug url template error, " + e16);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.lite.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.b();
                    }
                });
            }
        }
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "templateJSON.toString()");
            templateConfigJsonStr = jSONObject2;
            Object fromJson = GsonUtil.f385283b.a().fromJson(templateConfigJsonStr, (Class<Object>) y.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "GsonUtil.gson.fromJson(t\u2026lamentResCfg::class.java)");
            zplanFilamentResCfg = (y) fromJson;
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        QQToast.makeText(BaseApplication.getContext(), 1, "\u8f7b\u91cf\u5f15\u64ce\u8d44\u6e90\u4e0b\u8f7d\u914d\u7f6e\u9519\u8bef", 0).show();
    }

    public final String c() {
        return zplanFilamentResCfg.getCdnVersion();
    }

    public final String d() {
        return templateConfigJsonStr;
    }
}
