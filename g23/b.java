package g23;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f401119a = new b();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f401120a = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/QQMonetary/87b560a77c3018e181c5ea76c2c6c558.png";

        /* renamed from: b, reason: collision with root package name */
        public String f401121b = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/QQMonetary/87b560a77c3018e181c5ea76c2c6c558.png";

        /* renamed from: c, reason: collision with root package name */
        public String f401122c = "\u91d1\u5e01\u5145\u503c\u53ca\u4f7f\u7528\u8bb0\u5f55\u53ef\u5728\u300c\u5145\u503c\u9762\u677f-\u6211\u7684\u8d44\u4ea7\u300d\u4e2d\u67e5\u770b";

        /* renamed from: d, reason: collision with root package name */
        public String f401123d = "https://h5.qzone.qq.com/v2/vip/qun-gift/qq-coin-wallet?_wv=2&_wwv=640";

        /* renamed from: e, reason: collision with root package name */
        public String f401124e = "https://qqvip-web.cdn-go.cn/QQCoinCharge/latest/static/charge.html";

        public a() {
        }
    }

    b() {
    }

    @Nullable
    private IFeatureRuntimeService a() {
        AppInterface a16 = com.tencent.mobileqq.vas.pay.api.impl.helper.a.a();
        if (a16 == null) {
            return null;
        }
        return (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all");
    }

    public static b c() {
        return f401119a;
    }

    public a b() {
        JSONObject jSONObject;
        a aVar = new a();
        IFeatureRuntimeService a16 = a();
        if (a16 == null) {
            return aVar;
        }
        try {
            jSONObject = a16.getJSONObject("TOP_UP_SDK_CONFIG", "");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (jSONObject == null) {
            return aVar;
        }
        String string = jSONObject.getString("myPropertyURL");
        if (!TextUtils.isEmpty(string)) {
            aVar.f401123d = string;
        }
        String string2 = jSONObject.getString("topUpPolicyURL");
        if (!TextUtils.isEmpty(string2)) {
            aVar.f401124e = string2;
        }
        String string3 = jSONObject.getString("checkPropertyImageURL");
        if (!TextUtils.isEmpty(string3)) {
            aVar.f401120a = string3;
        }
        String string4 = jSONObject.getString("checkPropertyImageNightURL");
        if (!TextUtils.isEmpty(string4)) {
            aVar.f401121b = string4;
        }
        String string5 = jSONObject.getString("checkPropertyDesc");
        if (!TextUtils.isEmpty(string5)) {
            aVar.f401122c = string5;
        }
        return aVar;
    }

    public boolean d() {
        IFeatureRuntimeService a16 = a();
        if (a16 == null) {
            return false;
        }
        return a16.isFeatureSwitchEnable("TOP_UP_SDK_CONFIG");
    }
}
