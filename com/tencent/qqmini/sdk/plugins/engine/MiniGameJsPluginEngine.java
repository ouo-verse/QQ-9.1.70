package com.tencent.qqmini.sdk.plugins.engine;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class MiniGameJsPluginEngine extends JsPluginEngine {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f348275f = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, b> f348276d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.qqmini.sdk.auth.a f348277e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass2 implements AsyncResult {
        AnonymousClass2() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QMLog.d(JsPluginEngine.TAG, "onFirstFrame. getUserSetting ret = " + jSONObject.toString());
            if (jSONObject.optInt("authState", 3) == 0) {
                final Activity attachActivity = MiniGameJsPluginEngine.this.mMiniAppContext.getAttachActivity();
                final MiniAppInfo miniAppInfo = MiniGameJsPluginEngine.this.mMiniAppContext.getMiniAppInfo();
                MiniGameJsPluginEngine miniGameJsPluginEngine = MiniGameJsPluginEngine.this;
                if (!miniGameJsPluginEngine.checkPrivacyAgreementAgreed(miniGameJsPluginEngine.getAppId(), AuthorizeCenter.SETTING_SHARE_PLATRANK) && attachActivity != null && miniAppInfo != null) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine.2.1

                        /* renamed from: com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine$2$1$a */
                        /* loaded from: classes23.dex */
                        class a implements Function1<Boolean, Unit> {
                            a() {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public Unit invoke(Boolean bool) {
                                QMLog.i(JsPluginEngine.TAG, "onFirstFrame showUserAgreement result:" + bool);
                                if (bool.booleanValue()) {
                                    MiniGameJsPluginEngine.this.authDialogRequestEnqueue(new RequestEvent(), AuthorizeCenter.SETTING_SHARE_PLATRANK);
                                    return null;
                                }
                                return null;
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            MiniGameUserAgreementManager.f348129b.k(attachActivity, miniAppInfo, new a());
                        }
                    });
                } else {
                    MiniGameJsPluginEngine.this.authDialogRequestEnqueue(new RequestEvent(), AuthorizeCenter.SETTING_SHARE_PLATRANK);
                }
            }
        }
    }

    public MiniGameJsPluginEngine(Context context) {
        super(context);
        this.f348276d = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(Method method, IJsPlugin iJsPlugin, RequestEvent requestEvent) {
        try {
            return method.invoke(iJsPlugin, requestEvent);
        } catch (IllegalAccessException e16) {
            QMLog.w(JsPluginEngine.TAG, "dispatchEvent " + requestEvent.event + " failed, method = " + method + ", access exception " + e16.getMessage(), e16);
            return f348275f;
        } catch (OutOfMemoryError e17) {
            QMLog.w(JsPluginEngine.TAG, "dispatchEvent " + requestEvent.event + " failed, method = " + method + ", invoke exception " + e17.getMessage(), e17);
            return f348275f;
        } catch (InvocationTargetException e18) {
            QMLog.w(JsPluginEngine.TAG, "dispatchEvent " + requestEvent.event + " failed, method = " + method + ", invoke exception " + e18.getMessage(), e18);
            return f348275f;
        }
    }

    @Nullable
    private b d(RequestEvent requestEvent, IJsPlugin iJsPlugin) {
        String str = iJsPlugin.getClass().getCanonicalName() + "." + requestEvent.event;
        b bVar = this.f348276d.get(str);
        if (bVar == null) {
            bVar = JsPluginList.getMethodItem(iJsPlugin.getClass(), requestEvent.event);
            if (bVar != null) {
                bVar.f348298a.setAccessible(true);
                this.f348276d.put(str, bVar);
            } else {
                QMLog.e(JsPluginEngine.TAG, "cannot find jsPlugin event, name=" + str);
            }
        }
        return bVar;
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine
    public String checkAuthorization(RequestEvent requestEvent) {
        String requestScopePermission = getRequestScopePermission(requestEvent.event, requestEvent.jsonParams);
        com.tencent.qqmini.sdk.auth.a aVar = this.f348277e;
        if (aVar != null && !aVar.b(requestScopePermission, requestEvent)) {
            return "";
        }
        return super.checkAuthorization(requestEvent);
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
    protected boolean checkPrivacyAgreementAgreed(String str, String str2) {
        boolean z16 = !MiniGameUserAgreementManager.f348129b.j(str);
        QMLog.i(JsPluginEngine.TAG, "checkPrivacyAgreementAgreed appId:" + str + ", event=" + str2 + ", isAgreed=" + z16);
        return z16;
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
    @NonNull
    protected f createPermissionReqImpl() {
        return new a();
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
    protected String dispatchRequestEventToPlugin(final RequestEvent requestEvent, final IJsPlugin iJsPlugin) {
        b d16 = d(requestEvent, iJsPlugin);
        if (d16 == null) {
            requestEvent.fail();
            return "";
        }
        final Method method = d16.f348298a;
        if (!d16.f348299b) {
            ThreadManager.runComputationTask(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniGameJsPluginEngine.this.c(method, iJsPlugin, requestEvent) == MiniGameJsPluginEngine.f348275f) {
                        requestEvent.fail();
                    }
                }
            });
            return "";
        }
        Object c16 = c(method, iJsPlugin, requestEvent);
        if (c16 == f348275f) {
            requestEvent.fail();
            return "";
        }
        if (c16 == null) {
            return "";
        }
        return c16.toString();
    }

    public void e() {
        QMLog.i(JsPluginEngine.TAG, "onFirstFrame");
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", AuthorizeCenter.SETTING_SHARE_PLATRANK, null, new AnonymousClass2());
    }

    public void f(com.tencent.qqmini.sdk.auth.a aVar) {
        this.f348277e = aVar;
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine
    protected void fillEventPluginMap(Map<String, Class> map, Map<String, Class> map2) {
        map.putAll(JsPluginList.getEventPluginMap(true));
        map2.putAll(JsPluginList.getSecondaryEventPluginMap(true));
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
    protected void onPermissionDialogDismissed() {
        com.tencent.qqmini.sdk.auth.a aVar = this.f348277e;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
    protected void showUserAgreementDialog(final Activity activity, final MiniAppInfo miniAppInfo, final RequestEvent requestEvent, final AuthState authState, final String str) {
        QMLog.i(JsPluginEngine.TAG, "showUserAgreementDialog appid:" + miniAppInfo.appId + ", event:" + requestEvent.event);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine.3

            /* renamed from: com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine$3$a */
            /* loaded from: classes23.dex */
            class a implements Function1<Boolean, Unit> {
                a() {
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(Boolean bool) {
                    QMLog.i(JsPluginEngine.TAG, "showUserAgreement result:" + bool);
                    if (bool.booleanValue()) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        MiniGameJsPluginEngine.this.showRequestPermissionDialog(requestEvent, str);
                        return null;
                    }
                    AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                    authState.setAuthState(str, false);
                    return null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                MiniGameUserAgreementManager.f348129b.k(activity, miniAppInfo, new a());
            }
        });
    }
}
