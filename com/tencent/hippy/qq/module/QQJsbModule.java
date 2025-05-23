package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.config.business.QVipHippyProcessor;
import com.tencent.mobileqq.vas.hippy.HippyCallBackWebView;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ag;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import com.vivo.push.PushClientConstants;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@HippyNativeModule(name = QQJsbModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class QQJsbModule extends QQBaseLifecycleModule {
    public static final String CLASS_NAME = "QQJsbModule";
    private static final int DEFAULT_TIMEOUT_AWAIT = 1000;
    private static final String METHOD_CALL_JSB = "callJsBridge";
    private final n13.b mHippyJSBHelper;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class QQJsbModuleAdapter implements n13.c {

        @NotNull
        private final WeakReference<Activity> mActivityRef;

        @NotNull
        private final WeakReference<AppInterface> mAppInterfaceRef;

        @NotNull
        private final WeakReference<HippyEngineContext> mContextRef;

        @NotNull
        private final HippyMap mParams;

        @Nullable
        private final SoftReference<Promise> mPromiseWeakReference;

        public QQJsbModuleAdapter(@Nullable Promise promise, @NotNull Activity activity, @NotNull AppInterface appInterface, @NotNull HippyMap hippyMap, @NotNull HippyEngineContext hippyEngineContext) {
            this.mPromiseWeakReference = new SoftReference<>(promise);
            this.mActivityRef = new WeakReference<>(activity);
            this.mAppInterfaceRef = new WeakReference<>(appInterface);
            this.mParams = hippyMap;
            this.mContextRef = new WeakReference<>(hippyEngineContext);
        }

        private boolean domainAuth(HippyEngineContext hippyEngineContext) {
            HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(hippyEngineContext.getEngineId());
            if (engineInstance != null && engineInstance.getOpenHippyInfo() != null) {
                return QVipHippyProcessor.a().isEnableGetAuth(engineInstance.getModuleName(), engineInstance.getOpenHippyInfo().domain);
            }
            return false;
        }

        @Nullable
        private Object handleListenerArg(Class<?> cls, @NotNull Object obj) {
            if (JsBridgeListener.class.isAssignableFrom(cls) && (obj instanceof WebViewPlugin)) {
                WebViewPlugin webViewPlugin = (WebViewPlugin) obj;
                WebViewPlugin.b bVar = webViewPlugin.mRuntime;
                if (bVar != null && (bVar.e() instanceof HippyCallBackWebView)) {
                    return new com.tencent.mobileqq.vas.hippy.b((HippyCallBackWebView) webViewPlugin.mRuntime.e(), -1L, true);
                }
                QLog.e(QQJsbModule.CLASS_NAME, 1, "handleListenerArg error", webViewPlugin.mRuntime);
                onCallError("handleListenerArg error");
                return null;
            }
            if (WebViewPlugin.class.isAssignableFrom(cls)) {
                return ((IJsApi) QRoute.api(IJsApi.class)).getHippyCallBackListenerWebViewPlugin();
            }
            return null;
        }

        @Override // n13.c
        public boolean isNeedIntercept(HippyMap hippyMap) {
            HippyEngineContext hippyEngineContext = this.mContextRef.get();
            if (hippyEngineContext == null) {
                return true;
            }
            if (VasToggle.FEATURE_VAS_HIPPY_SKIP_AUTH.isEnable(true) && domainAuth(hippyEngineContext)) {
                return false;
            }
            String string = hippyMap.getString(PushClientConstants.TAG_PKG_NAME);
            String string2 = hippyMap.getString("method");
            return !QQJsbModule.hasCommandRight(hippyEngineContext, string + "." + string2);
        }

        @Override // n13.c
        public void onCallError(String str) {
            SoftReference<Promise> softReference = this.mPromiseWeakReference;
            if (softReference == null) {
                QLog.w(QQJsbModule.CLASS_NAME, 1, "onCallError but mPromise is null");
                return;
            }
            Promise promise = softReference.get();
            if (promise == null) {
                QLog.w(QQJsbModule.CLASS_NAME, 1, "onCallJs but mPromise is null");
            } else {
                promise.reject(str);
            }
        }

        @Override // n13.c
        public void onCallJs(Object obj) {
            SoftReference<Promise> softReference = this.mPromiseWeakReference;
            if (softReference == null) {
                QLog.w(QQJsbModule.CLASS_NAME, 1, "onCallJs but mPromise is null");
                return;
            }
            Promise promise = softReference.get();
            if (promise == null) {
                QLog.w(QQJsbModule.CLASS_NAME, 1, "onCallJs but mPromise is null");
                return;
            }
            if (obj.getClass().isArray()) {
                HippyArray hippyArray = new HippyArray();
                for (Object obj2 : (Object[]) obj) {
                    hippyArray.pushObject(obj2);
                }
                promise.resolve(hippyArray);
                return;
            }
            promise.resolve(obj);
        }

        @Override // n13.c
        public Object onCreateFakeWebView(Object obj) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return new HippyCallBackWebView(ContextHolder.getAppContext());
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Object[] objArr = new Object[1];
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.hippy.qq.module.QQJsbModule.QQJsbModuleAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    objArr[0] = new HippyCallBackWebView(ContextHolder.getAppContext());
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                QLog.e(QQJsbModule.CLASS_NAME, 1, "onCreateFakeWebView await e:", e16);
            }
            return objArr[0];
        }

        @Override // n13.c
        public Object onCreateWebViewPlugin(String str) {
            WebViewPlugin b16 = ag.b(str);
            if (b16 == null) {
                onCallError("onCreateWebViewPlugin failed");
                QLog.e(QQJsbModule.CLASS_NAME, 1, "onCreateWebViewPlugin error, webViewPluginOrigin is null");
                return null;
            }
            b16.mRuntime = new WebViewPlugin.b(this.mActivityRef.get(), this.mAppInterfaceRef.get());
            return b16;
        }

        @Override // n13.c
        public String[] onGetDispatchArgsNameList(String str) {
            return new String[]{"listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "args"};
        }

        @Override // n13.c
        public String onGetDispatchMethodName(String str) {
            return "handleJsRequest";
        }

        @Override // n13.c
        public Object onGetInvokeArgs(int i3, Class<?> cls, @NotNull Object obj, String str) {
            Object handleListenerArg;
            if (i3 == 0 && (handleListenerArg = handleListenerArg(cls, obj)) != null) {
                return handleListenerArg;
            }
            if ("args".equals(onGetDispatchArgsNameList(str)[i3])) {
                HippyMap map = this.mParams.getMap("args");
                if (!map.containsKey("callback")) {
                    map.pushString("callback", "promise");
                }
                try {
                    return new String[]{map.toJSONObject().toString()};
                } catch (Exception e16) {
                    QLog.e(QQJsbModule.CLASS_NAME, 1, "onGetInvokeArgs error", e16);
                }
            }
            return null;
        }

        @Override // n13.c
        public String onGetJsbMethod(HippyMap hippyMap) {
            return hippyMap.getString("method");
        }

        @Override // n13.c
        public String onGetJsbNameSpace(HippyMap hippyMap) {
            return hippyMap.getString(PushClientConstants.TAG_PKG_NAME);
        }

        @Override // n13.c
        public Object onGetShareHelper() {
            HippyQQEngine engineInstance;
            HippyEngineContext hippyEngineContext = this.mContextRef.get();
            if (hippyEngineContext == null || (engineInstance = HippyQQEngine.getEngineInstance(hippyEngineContext.getEngineId())) == null) {
                return null;
            }
            return new com.tencent.share.a(engineInstance.getActivity());
        }

        @Override // n13.c
        public String onGetWebViewUrl() {
            HippyQQEngine engineInstance;
            HippyEngineContext hippyEngineContext = this.mContextRef.get();
            if (hippyEngineContext == null || (engineInstance = HippyQQEngine.getEngineInstance(hippyEngineContext.getEngineId())) == null || engineInstance.getPageUrl() == null) {
                return "";
            }
            return engineInstance.getPageUrl();
        }

        @Override // n13.c
        public void onSetWebViewInternal(Object obj, Object obj2) {
            try {
                Field declaredField = WebViewPlugin.b.class.getDeclaredField("a");
                declaredField.setAccessible(true);
                declaredField.set(((WebViewPlugin) obj).mRuntime, new WeakReference(obj2));
            } catch (IllegalAccessException | NoSuchFieldException e16) {
                QLog.e(QQJsbModule.CLASS_NAME, 1, "onSetWebViewInternal error", e16);
            }
        }

        @Override // n13.c
        public void onUpdateActivity(Object obj) {
            if (!(obj instanceof WebViewPlugin)) {
                return;
            }
            WebViewPlugin webViewPlugin = (WebViewPlugin) obj;
            if (webViewPlugin.mRuntime == null) {
                webViewPlugin.mRuntime = new WebViewPlugin.b(this.mActivityRef.get(), this.mAppInterfaceRef.get());
                return;
            }
            try {
                Field declaredField = WebViewPlugin.b.class.getDeclaredField("c");
                declaredField.setAccessible(true);
                declaredField.set(webViewPlugin.mRuntime, this.mActivityRef);
            } catch (IllegalAccessException | NoSuchFieldException e16) {
                QLog.e(QQJsbModule.CLASS_NAME, 1, "onUpdateActivity error", e16);
            }
        }
    }

    public QQJsbModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mHippyJSBHelper = n13.b.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasCommandRight(HippyEngineContext hippyEngineContext, String str) {
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(hippyEngineContext.getEngineId());
        if (engineInstance == null) {
            return false;
        }
        return AuthorizeConfig.y().F(engineInstance.getPageUrl(), str);
    }

    @HippyMethod(name = METHOD_CALL_JSB)
    public void callJsBridge(HippyMap hippyMap, Promise promise) {
        this.mHippyJSBHelper.o(new QQJsbModuleAdapter(promise, getActivity(), getAppInterface(), hippyMap, this.mContext));
        this.mHippyJSBHelper.a(hippyMap);
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        n13.b bVar = this.mHippyJSBHelper;
        if (bVar != null) {
            bVar.n();
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        Object[] objArr = {intent, Byte.valueOf((byte) i3), Integer.valueOf(i16)};
        Object[] objArr2 = {Integer.valueOf(i3), Integer.valueOf(i16), intent};
        HashMap<String, Object[]> hashMap = new HashMap<>();
        hashMap.put("Intent,byte,int", objArr);
        hashMap.put("int,int,Intent", objArr2);
        n13.b bVar = this.mHippyJSBHelper;
        if (bVar != null) {
            bVar.b(hashMap);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
        super.onNewIntent(activity, intent);
        Object[] objArr = {intent};
        HashMap<String, Object[]> hashMap = new HashMap<>();
        hashMap.put("Intent", objArr);
        this.mHippyJSBHelper.c(hashMap);
    }
}
