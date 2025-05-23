package com.tencent.mobileqq.tvideo.account.qqconnect;

import android.app.Activity;
import bu2.c;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/qqconnect/c;", "", "Lcom/tencent/mobileqq/Doraemon/DoraemonAPIManager;", "mgr", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/a;", "callback", "", "d", "Lorg/json/JSONObject;", "result", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "", "a", "Z", "isTVideoQQConnectRequesting", "<init>", "()V", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isTVideoQQConnectRequesting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/tvideo/account/qqconnect/c$b", "Lcom/tencent/mobileqq/Doraemon/a;", "", "code", "", "onPermission", "Lorg/json/JSONObject;", "result", "onSuccess", "", "msg", "onFailure", "onComplete", "onTrigger", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.Doraemon.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f303484a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f303485b;

        b(a aVar, c cVar) {
            this.f303484a = aVar;
            this.f303485b = cVar;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            QLog.i("TVideoQQLoginManager", 1, "invoke login onComplete.");
            this.f303485b.isTVideoQQConnectRequesting = false;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("TVideoQQLoginManager", 1, "invoke login onFailure: code " + code + ", msg " + msg2 + ".");
            a aVar = this.f303484a;
            if (aVar != null) {
                aVar.b(new c.a(Integer.valueOf(code), msg2));
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int code) {
            a aVar = this.f303484a;
            if (aVar != null) {
                aVar.b(new c.b(Integer.valueOf(code), "\u6743\u9650\u9519\u8bef"));
            }
            QLog.i("TVideoQQLoginManager", 1, "invoke login onPermission: " + code);
            this.f303485b.isTVideoQQConnectRequesting = false;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(@NotNull JSONObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            TVideoQQConnectToken c16 = this.f303485b.c(result);
            a aVar = this.f303484a;
            if (aVar != null) {
                aVar.a(c16);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(@NotNull JSONObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("TVideoQQLoginManager", 1, "invoke login onTrigger: " + result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TVideoQQConnectToken c(JSONObject result) {
        String openId = result.optString("openid");
        String accessToken = result.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
        String qqUin = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(qqUin, "qqUin");
        Intrinsics.checkNotNullExpressionValue(openId, "openId");
        Intrinsics.checkNotNullExpressionValue(accessToken, "accessToken");
        TVideoQQConnectToken tVideoQQConnectToken = new TVideoQQConnectToken(qqUin, openId, accessToken);
        QLog.i("TVideoQQLoginManager", 1, "invoke login onSuccess");
        return tVideoQQConnectToken;
    }

    private final void d(DoraemonAPIManager mgr, a callback) {
        mgr.d("loginSilent", null, new b(callback, this));
    }

    public final void e(@NotNull Activity activity, @Nullable a callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isTVideoQQConnectRequesting) {
            return;
        }
        this.isTVideoQQConnectRequesting = true;
        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
        DoraemonAPIManager apiMgr = ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(activity, 6, "102031143");
        Intrinsics.checkNotNullExpressionValue(apiMgr, "apiMgr");
        d(apiMgr, callback);
    }
}
