package fl2;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import el2.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\n\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\r\u001a\u00020\fJW\u0010\u0014\u001a\u00020\f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lfl2/a;", "", "", "uin", "appId", "", "appType", "Lfl2/a$b;", "callback", "", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lfl2/a$b;)Z", "", "d", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "activityRef", "isSilentLogin", "url", VideoProxy.PARAM_ENABLE_CACHE, "c", "(Lmqq/util/WeakReference;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLfl2/a$b;)V", "Lfl2/a$a;", "Lfl2/a$a;", "callbackCenter", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f399772a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C10326a callbackCenter = new C10326a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J<\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lfl2/a$a;", "", "", "appId", "Lfl2/a$b;", "callback", "", "a", "", "d", "uin", "Lorg/json/JSONObject;", "rawData", "openId", CommonConstant.KEY_ACCESS_TOKEN, QAdRewardDefine$VideoParams.ISCACHE, "", "c", "", "retCode", "retMsg", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackMap", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fl2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C10326a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ConcurrentHashMap<String, List<b>> callbackMap = new ConcurrentHashMap<>();

        public final synchronized boolean a(@NotNull String appId, @NotNull b callback) {
            boolean z16;
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            List<b> list = this.callbackMap.get(appId);
            if (list == null) {
                list = new ArrayList<>();
                this.callbackMap.put(appId, list);
                z16 = false;
            } else {
                z16 = true;
            }
            if (!list.contains(callback)) {
                list.add(callback);
            }
            return z16;
        }

        public final void b(@NotNull String appId, int retCode, @NotNull String retMsg) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            List<b> d16 = d(appId);
            if (d16 != null) {
                for (b bVar : d16) {
                    QLog.w("QWalletOpenLoginManager", 1, "callback onOpenLoginFail " + bVar);
                    bVar.onFail(retCode, retMsg);
                }
            }
        }

        public final void c(@NotNull String appId, @Nullable String uin, @NotNull JSONObject rawData, @Nullable String openId, @Nullable String accessToken, boolean isCache) {
            int i3;
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            List<b> d16 = d(appId);
            if (d16 != null) {
                i3 = d16.size();
            } else {
                i3 = 0;
            }
            QLog.i("QWalletOpenLoginManager", 1, "onSuccess, callback.size " + i3);
            if (d16 != null) {
                for (b bVar : d16) {
                    QLog.i("QWalletOpenLoginManager", 1, "callback onSuccess " + bVar);
                    bVar.a(uin, rawData, openId, accessToken, isCache);
                }
            }
        }

        @Nullable
        public final synchronized List<b> d(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            return this.callbackMap.remove(appId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lfl2/a$b;", "", "", "uin", "Lorg/json/JSONObject;", "rawData", "openId", CommonConstant.KEY_ACCESS_TOKEN, "", QAdRewardDefine$VideoParams.ISCACHE, "", "a", "", "retCode", "retMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void a(@Nullable String uin, @NotNull JSONObject rawData, @Nullable String openId, @Nullable String accessToken, boolean isCache);

        void onFail(int retCode, @NotNull String retMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lfl2/a$c;", "", "", "uin", "appId", "", "appType", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "Lorg/json/JSONObject;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lorg/json/JSONObject;", "result", "", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/json/JSONObject;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f399775a = new c();

        c() {
        }

        private final String a(String uin, String appId, Integer appType) {
            return uin + "_" + appId + "_" + appType;
        }

        @Nullable
        public final JSONObject b(@NotNull String uin, @Nullable String appId, @Nullable Integer appType) {
            boolean z16;
            Intrinsics.checkNotNullParameter(uin, "uin");
            String a16 = a(uin, appId, appType);
            String i3 = g.i("qwallet_kuikly_open_login_cache_" + a16);
            if (i3.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                JSONObject jSONObject = new JSONObject(i3);
                if (jSONObject.optLong(VasQQSettingMeImpl.EXPIRE_TIME) * 1000 > System.currentTimeMillis()) {
                    return jSONObject;
                }
                g.s("qwallet_kuikly_open_login_cache_" + a16);
                return null;
            }
            return null;
        }

        public final void c(@NotNull String uin, @Nullable String appId, @Nullable Integer appType, @NotNull JSONObject result) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(result, "result");
            String a16 = a(uin, appId, appType);
            QLog.i("QWalletOpenLoginManager", 1, "save LoginCache: " + a16 + " " + result);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("qwallet_kuikly_open_login_cache_");
            sb5.append(a16);
            String sb6 = sb5.toString();
            String jSONObject = result.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "result.toString()");
            g.q(sb6, jSONObject);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"fl2/a$d", "Lcom/tencent/mobileqq/Doraemon/a;", "", "code", "", "onPermission", "Lorg/json/JSONObject;", "result", "onSuccess", "", "msg", "onFailure", "onComplete", "onTrigger", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements com.tencent.mobileqq.Doraemon.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f399776a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f399777b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f399778c;

        d(String str, String str2, Integer num) {
            this.f399776a = str;
            this.f399777b = str2;
            this.f399778c = num;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            QLog.w("QWalletOpenLoginManager", 1, "auth onComplete.");
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.w("QWalletOpenLoginManager", 1, "onFailure: " + code + " " + msg2);
            a.callbackCenter.b(this.f399776a, code, msg2);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int code) {
            QLog.w("QWalletOpenLoginManager", 1, "onPermission: " + new a.LoginResult(Integer.valueOf(code), "need permission: " + code, null, null, null, 28, null));
            a.callbackCenter.b(this.f399776a, code, "need permission: " + code);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(@NotNull JSONObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("QWalletOpenLoginManager", 1, "auth success: " + result);
            String optString = result.optString("openid");
            String optString2 = result.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
            c.f399775a.c(this.f399777b, this.f399776a, this.f399778c, result);
            a.callbackCenter.c(this.f399776a, this.f399777b, result, optString, optString2, false);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(@NotNull JSONObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("QWalletOpenLoginManager", 1, "auth onTrigger: " + result);
        }
    }

    a() {
    }

    private final boolean b(String uin, String appId, Integer appType, b callback) {
        JSONObject b16 = c.f399775a.b(uin, appId, appType);
        if (b16 != null) {
            QLog.i("QWalletOpenLoginManager", 1, "callback with cache: " + b16);
            callback.a(com.tencent.mobileqq.base.a.c(), b16, b16.optString("openid"), b16.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN), true);
            return true;
        }
        return false;
    }

    public final void c(@Nullable WeakReference<Activity> activityRef, boolean isSilentLogin, @Nullable String appId, @Nullable Integer appType, @Nullable String url, boolean enableCache, @NotNull b callback) {
        int i3;
        Bundle bundle;
        Activity activity;
        String str;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (appId == null) {
            return;
        }
        String c16 = com.tencent.mobileqq.base.a.c();
        if (enableCache && b(c16, appId, appType, callback)) {
            return;
        }
        if (callbackCenter.a(appId, callback)) {
            QLog.i("QWalletOpenLoginManager", 1, "isRequesting!");
            return;
        }
        if (appType != null) {
            i3 = appType.intValue();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            bundle = new Bundle();
            if (url != null) {
                bundle.putString("urlSummary", url);
            }
        } else {
            bundle = null;
        }
        if (activityRef != null && (activity = activityRef.get()) != null) {
            DoraemonAPIManager createAPIManager = ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(activity, i3, appId, bundle);
            if (isSilentLogin) {
                str = "loginSilent";
            } else {
                str = "login";
            }
            createAPIManager.d(str, null, new d(appId, c16, appType));
        }
    }

    public final void d() {
        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
    }
}
