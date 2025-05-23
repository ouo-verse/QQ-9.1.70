package com.tencent.mobileqq.tvideo.hippy;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bu2.TVideoAccountInfo;
import bu2.c;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.tvideo.webview.d;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import jy2.g;
import mqq.app.Foreground;
import org.json.JSONObject;
import zt2.e;

@HippyNativeModule(name = TVideoPublicAccountHippyModule.MODULE_NAME)
/* loaded from: classes19.dex */
public class TVideoPublicAccountHippyModule extends QQBaseModule {
    static final String MODULE_NAME = "tvideoPublicAccount";

    public TVideoPublicAccountHippyModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private void handleMethod(String str, Promise promise) {
        QLog.i(MODULE_NAME, 1, "hippyMethod:" + str);
        if (promise == null) {
            return;
        }
        try {
            JSONObject o16 = d.o(str, null, null, g.B());
            if (o16 != null) {
                promise.resolve(o16.toString());
                return;
            }
        } catch (Exception e16) {
            QLog.d(MODULE_NAME, 4, e16, new Object[0]);
        }
        promise.resolve("fail");
    }

    @HippyMethod(name = "getAppInfo")
    public void getAppInfo(Promise promise) {
        handleMethod("getAppInfo", promise);
    }

    @HippyMethod(name = "getAppSetting")
    public void getAppSetting(Promise promise) {
        handleMethod("getAppSetting", promise);
    }

    @HippyMethod(name = "getReportMap")
    public void getReportMap(Promise promise) {
        handleMethod("getReportMap", promise);
    }

    @HippyMethod(name = "getUserInfo")
    public void getUserInfo(Promise promise) {
        handleMethod("getUserInfo", promise);
    }

    @HippyMethod(name = "login")
    public void login(Promise promise) {
        QLog.i(MODULE_NAME, 1, "hippyMethod:login");
        if (promise == null) {
            return;
        }
        e eVar = e.f453199a;
        if (eVar.k()) {
            promise.resolve(getUserInfo());
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            promise.resolve("fail");
        } else {
            eVar.m(topActivity, new a(promise));
        }
    }

    @HippyMethod(name = "pauseVideo")
    public void pauseVideo(Promise promise) {
        handleMethod("pauseVideo", promise);
    }

    @HippyMethod(name = "resumeVideo")
    public void resumeVideo(Promise promise) {
        handleMethod("resumeVideo", promise);
    }

    @HippyMethod(name = "updateAppSetting")
    public void updateAppSetting(HippyMap hippyMap, Promise promise) {
        QLog.i(MODULE_NAME, 1, "hippyMethod:updateAppSetting");
        if (hippyMap == null) {
            promise.resolve("fail");
            return;
        }
        String string = hippyMap.getString("key");
        String string2 = hippyMap.getString("value");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            d.A(string, string2);
            promise.resolve("success");
        } else {
            promise.resolve("fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUserInfo() {
        JSONObject k3 = d.k(d.j(), g.B());
        return k3 == null ? "" : k3.toString();
    }

    /* loaded from: classes19.dex */
    class a implements eu2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f304452a;

        a(Promise promise) {
            this.f304452a = promise;
        }

        @Override // eu2.a
        public void c(@NonNull TVideoAccountInfo tVideoAccountInfo) {
            this.f304452a.resolve(TVideoPublicAccountHippyModule.this.getUserInfo());
        }

        @Override // eu2.a
        public void e() {
        }

        @Override // eu2.a
        public void a(@NonNull c.C0152c c0152c) {
        }

        @Override // eu2.a
        public void b(@NonNull c.C0152c c0152c) {
        }

        @Override // eu2.a
        public void d(@NonNull TVideoAccountInfo tVideoAccountInfo) {
        }

        @Override // eu2.a
        public void f(@NonNull c.C0152c c0152c) {
        }
    }
}
