package pe3;

import android.app.Activity;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ipc.j;
import com.tencent.mobileqq.zootopia.ipc.z;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lpe3/a;", "", "", "url", "b", "", "a", "c", "thirdType", "resultJson", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f426058a = new a();

    a() {
    }

    private final String b(String url) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", url);
        jSONObject.put("title", "QQ\u97f3\u4e50\u7b2c\u4e09\u65b9\u6388\u6743");
        jSONObject.put("titleColor", "#FF000000");
        jSONObject.put("needCallbackThirdAuth", true);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final void a() {
        Uri.Builder buildUpon = Uri.parse("https://y.qq.com/m/unionlogin/dist/index.html?appId=2000000318&changeLogin=0&needNotifyErr=1&loginType=qq&packageName=com.tencent.mobileqq").buildUpon();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE, "code");
        jSONObject.put("state", String.valueOf(NetConnInfoCenter.getServerTime()));
        buildUpon.appendQueryParameter("encryptString", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
        buildUpon.appendQueryParameter("callbackUrl", "mqqapi://zplan/thirdAuth?thirdType=1");
        QLog.i("QQMusicAuthHelper", 1, "authQQMusic :: url == " + buildUpon);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            a aVar = f426058a;
            String builder = buildUpon.toString();
            Intrinsics.checkNotNullExpressionValue(builder, "uri.toString()");
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(topActivity, "mqqapi://zplan/openPage?src_type=app&version=1.0&pageID=6&pageData=" + URLEncoder.encode(aVar.b(builder), "UTF-8"));
        }
    }

    public final void c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thirdType", 1);
        jSONObject.put("isCancel", 1);
        QLog.i("QQMusicAuthHelper", 1, "handleThirdAuthCallback :: params == " + jSONObject);
        z zVar = (z) i.INSTANCE.a(z.class);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "luaParams.toString()");
        zVar.callN2L("N2L_ReceivedThirdAuth", jSONObject2);
    }

    public final void d(String thirdType, String resultJson) {
        Intrinsics.checkNotNullParameter(thirdType, "thirdType");
        Intrinsics.checkNotNullParameter(resultJson, "resultJson");
        ((j) i.INSTANCE.a(j.class)).closeWebView();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thirdType", Integer.parseInt(thirdType));
        jSONObject.put("result", URLDecoder.decode(resultJson, "UTF-8"));
        jSONObject.put("isCancel", 0);
        QLog.i("QQMusicAuthHelper", 1, "handleThirdAuthCallback :: params == " + jSONObject);
        ar.f328509a.a("N2L_ReceivedThirdAuth", jSONObject.toString());
    }
}
