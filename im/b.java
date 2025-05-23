package im;

import android.app.Activity;
import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002JE\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lim/b;", "", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isSilentLogin", "", "appId", "", "appType", "url", "Lim/b$a;", "callback", "a", "(Landroid/app/Activity;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lim/b$a;)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f407938a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lim/b$a;", "", "", "openId", "uin", CommonConstant.KEY_ACCESS_TOKEN, "", "onSuccess", "", "retCode", "retMsg", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void onFail(int retCode, String retMsg);

        void onSuccess(String openId, String uin, String accessToken);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lim/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "retCode", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "retMsg", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "openId", "getOpenId", CommonConstant.KEY_ACCESS_TOKEN, "getAccessToken", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: im.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class LoginResult {

        @SerializedName(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN)
        private final String accessToken;

        @SerializedName("open_id")
        private final String openId;

        @SerializedName("ret_code")
        private final Integer retCode;

        @SerializedName("ret_msg")
        private final String retMsg;

        public LoginResult() {
            this(null, null, null, null, 15, null);
        }

        public int hashCode() {
            Integer num = this.retCode;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.retMsg;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.openId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.accessToken;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "LoginResult(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", openId=" + this.openId + ", accessToken=" + this.accessToken + ")";
        }

        public LoginResult(Integer num, String str, String str2, String str3) {
            this.retCode = num;
            this.retMsg = str;
            this.openId = str2;
            this.accessToken = str3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoginResult)) {
                return false;
            }
            LoginResult loginResult = (LoginResult) other;
            return Intrinsics.areEqual(this.retCode, loginResult.retCode) && Intrinsics.areEqual(this.retMsg, loginResult.retMsg) && Intrinsics.areEqual(this.openId, loginResult.openId) && Intrinsics.areEqual(this.accessToken, loginResult.accessToken);
        }

        public /* synthetic */ LoginResult(Integer num, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"im/b$c", "Lcom/tencent/mobileqq/Doraemon/a;", "", "code", "", "onPermission", "Lorg/json/JSONObject;", "result", "onSuccess", "", "msg", "onFailure", "onComplete", "onTrigger", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements com.tencent.mobileqq.Doraemon.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f407939a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f407940b;

        c(a aVar, String str) {
            this.f407939a = aVar;
            this.f407940b = str;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.w("QZoneOpenLoginManager", 1, "onFailure: " + new LoginResult(Integer.valueOf(code), msg2, null, null, 12, null));
            this.f407939a.onFail(code, msg2);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int code) {
            QLog.w("QZoneOpenLoginManager", 1, "onPermission: " + new LoginResult(Integer.valueOf(code), "need permission: " + code, null, null, 12, null));
            this.f407939a.onFail(code, "need permission: " + code);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("QZoneOpenLoginManager", 1, "auth success: " + new LoginResult(0, null, result.optString("openid"), result.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN)));
            this.f407939a.onSuccess(result.optString("openid"), this.f407940b, result.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN));
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("QZoneOpenLoginManager", 1, "auth onTrigger: " + result);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            QLog.w("QZoneOpenLoginManager", 1, "auth onComplete.");
        }
    }

    b() {
    }

    public final void a(Activity activity, boolean isSilentLogin, String appId, Integer appType, String url, a callback) {
        Bundle bundle;
        String str;
        Intrinsics.checkNotNullParameter(callback, "callback");
        String c16 = com.tencent.mobileqq.base.a.c();
        int intValue = appType != null ? appType.intValue() : 1;
        if (intValue == 0) {
            bundle = new Bundle();
            if (url != null) {
                bundle.putString("urlSummary", url);
            }
        } else {
            bundle = null;
        }
        if (activity == null) {
            return;
        }
        DoraemonAPIManager createAPIManager = ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(activity, intValue, appId, bundle);
        if (isSilentLogin) {
            str = "loginSilent";
        } else {
            str = "login";
        }
        createAPIManager.d(str, null, new c(callback, c16));
    }

    public final void b() {
        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
    }
}
