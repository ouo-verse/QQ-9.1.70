package cooperation.vip.ad;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody$WebSsoRequestBody;
import com.tencent.mobileqq.WebSsoBody$WebSsoResponseBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQVASHippySSOModule.TAG, thread = HippyNativeModule.Thread.MAIN)
/* loaded from: classes28.dex */
public class QQVASHippySSOModule extends HippyNativeModuleBase {
    private static final int CRET_CODE_COMMON_FAIL = 2;
    private static final int CRET_CODE_EXCEPTION = 3;
    private static final int CRET_CODE_NO_APPRUNTIME = 1;
    private static final int CRET_CODE_NO_CMD = 4;
    private static final int CRET_CODE_NO_DATA = 6;
    private static final int CRET_CODE_NO_HOST = 5;
    private static final int CRET_CODE_SUCCESS = 0;
    private static final String KEY_CMD = "cmd";
    private static final String KEY_CRET = "cret";
    private static final String KEY_DATA = "data";
    private static final String KEY_HOST = "host";
    private static final String KEY_RET_CODE = "retcode";
    private static final String TAG = "QQVASHippySSOModule";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f391041d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Promise f391042e;

        a(String str, Promise promise) {
            this.f391041d = str;
            this.f391042e = promise;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QQVASHippySSOModule.this.handleSSOResult(z16, this.f391041d, bundle, this.f391042e);
        }
    }

    public QQVASHippySSOModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private HippyMap buildChanelErrorResult(int i3) {
        QLog.i(TAG, 1, "buildChanelErrorResult, channelRetCode =" + i3);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt(KEY_CRET, i3);
        return hippyMap;
    }

    private HippyMap buildChannelSuccessResult(int i3, String str) {
        if (str == null) {
            str = "";
        }
        QLog.i(TAG, 1, "buildChannelSuccessResult, bizRetCode =" + i3 + ", data.length=" + str.length());
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("data", str);
        hippyMap.pushInt("retcode", i3);
        hippyMap.pushInt(KEY_CRET, 0);
        return hippyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSSOResult(boolean z16, String str, Bundle bundle, Promise promise) {
        QLog.i(TAG, 1, "handleSSOResult, isSuccess=" + z16 + "cmd=" + str);
        if (!z16) {
            promise.resolve(buildChanelErrorResult(2));
            return;
        }
        byte[] byteArray = bundle.getByteArray("data");
        if (byteArray == null) {
            QLog.e(TAG, 1, "request web sso success, but byte data is null, cmd: " + str);
            promise.resolve(buildChanelErrorResult(6));
            return;
        }
        WebSsoBody$WebSsoResponseBody webSsoBody$WebSsoResponseBody = new WebSsoBody$WebSsoResponseBody();
        try {
            webSsoBody$WebSsoResponseBody.mergeFrom(byteArray);
            promise.resolve(buildChannelSuccessResult(webSsoBody$WebSsoResponseBody.ret.get(), webSsoBody$WebSsoResponseBody.data.get()));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "handleSSOResult exception", e16);
            promise.resolve(buildChanelErrorResult(3));
        }
    }

    @HippyMethod(name = "send")
    public void send(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject = hippyMap.toJSONObject();
        String optString = jSONObject.optString("host");
        String optString2 = jSONObject.optString("cmd");
        String optString3 = jSONObject.optString("data");
        QLog.i(TAG, 1, "send, params=" + jSONObject);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (optString2.isEmpty()) {
            promise.resolve(buildChanelErrorResult(4));
            return;
        }
        if (optString.isEmpty()) {
            promise.resolve(buildChanelErrorResult(5));
            return;
        }
        if (peekAppRuntime == null) {
            promise.resolve(buildChanelErrorResult(1));
            return;
        }
        String[] split = optString.split("\\.");
        StringBuilder sb5 = new StringBuilder();
        for (int length = split.length - 1; length >= 0; length--) {
            sb5.append(split[length]);
            if (length != 0) {
                sb5.append("_");
            }
        }
        String str = "MQUpdateSvc_" + ((Object) sb5) + ".web." + optString2;
        QLog.i(TAG, 1, "fullCmd=" + str);
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), com.tencent.biz.m.class);
        newIntent.putExtra("cmd", str);
        WebSsoBody$WebSsoRequestBody webSsoBody$WebSsoRequestBody = new WebSsoBody$WebSsoRequestBody();
        webSsoBody$WebSsoRequestBody.type.set(0);
        webSsoBody$WebSsoRequestBody.data.set(optString3);
        newIntent.putExtra("data", webSsoBody$WebSsoRequestBody.toByteArray());
        newIntent.setObserver(new a(str, promise));
        peekAppRuntime.startServlet(newIntent);
    }
}
