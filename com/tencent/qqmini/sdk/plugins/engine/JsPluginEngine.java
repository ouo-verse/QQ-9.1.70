package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import com.tencent.qqmini.sdk.action.RepeatRequestEvent;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public abstract class JsPluginEngine extends BaseJsPluginEngine {
    public static final String TAG = "JsPluginEngine[Dispatcher]";
    protected final Map<Class, IJsPlugin> mActivatedPlugins;
    protected final Map<String, Class> mEventPluginMap;
    protected final Map<String, Class> mSecondaryEventPluginMap;

    public JsPluginEngine(Context context) {
        super(context);
        HashMap hashMap = new HashMap();
        this.mEventPluginMap = hashMap;
        HashMap hashMap2 = new HashMap();
        this.mSecondaryEventPluginMap = hashMap2;
        this.mActivatedPlugins = new ConcurrentHashMap();
        fillEventPluginMap(hashMap, hashMap2);
    }

    private static String buildMessage(String str, RequestEvent requestEvent) {
        return str + "eventName=" + requestEvent.event + ", jsonParams=" + requestEvent.jsonParams + ", callbackId=" + requestEvent.callbackId + "jsService=" + requestEvent.jsService;
    }

    public void addJsPlugin(String str, Class cls) {
        this.mSecondaryEventPluginMap.put(str, cls);
    }

    public boolean checkJsPluginExists(String str) {
        return this.mSecondaryEventPluginMap.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized IJsPlugin createJsPlugin(Class cls) {
        if (this.mMiniAppContext == null) {
            QMLog.w(TAG, "Can NOT create js plugin with null MiniAppContext");
            return null;
        }
        IJsPlugin iJsPlugin = this.mActivatedPlugins.get(cls);
        if (iJsPlugin != null) {
            return iJsPlugin;
        }
        try {
            Object newInstance = cls.newInstance();
            if (newInstance instanceof IJsPlugin) {
                IJsPlugin iJsPlugin2 = (IJsPlugin) newInstance;
                try {
                    iJsPlugin2.onCreate(this.mMiniAppContext);
                    this.mActivatedPlugins.put(cls, iJsPlugin2);
                    return iJsPlugin2;
                } catch (Exception e16) {
                    e = e16;
                    iJsPlugin = iJsPlugin2;
                    QMLog.e(TAG, "Failed to create plugin " + iJsPlugin, e);
                    return null;
                }
            }
            QMLog.e(TAG, "Illegal plugin" + iJsPlugin);
            return null;
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine
    protected String dispatchRequestEvent(RequestEvent requestEvent) {
        IJsPlugin eventHandler = getEventHandler(requestEvent.event);
        if (eventHandler == null) {
            if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                QMLog.w(TAG, buildMessage("handleNativeRequest failed, event not support! ", requestEvent));
            }
            return "";
        }
        if (eventHandler.onInterceptJsEvent(requestEvent)) {
            QMLog.i(TAG, buildMessage("handleNativeRequest aborted, event is intercepted. ", requestEvent));
            return "";
        }
        reportApiInvoke(this.mMiniAppContext.getMiniAppInfo(), requestEvent.event);
        return dispatchRequestEventToPlugin(requestEvent, eventHandler);
    }

    protected abstract String dispatchRequestEventToPlugin(RequestEvent requestEvent, IJsPlugin iJsPlugin);

    public String dispatchSecondaryRequestEvent(RepeatRequestEvent repeatRequestEvent) {
        IJsPlugin secondaryEventHandler = getSecondaryEventHandler(repeatRequestEvent.event);
        if (secondaryEventHandler == null) {
            QMLog.w(TAG, buildMessage("handleNativeRequest failed, secondary event not support! ", repeatRequestEvent));
            return "";
        }
        if (secondaryEventHandler.onInterceptJsEvent(repeatRequestEvent)) {
            QMLog.i(TAG, buildMessage("handleNativeRequest aborted, secondary event is intercepted. ", repeatRequestEvent));
            return "";
        }
        return dispatchRequestEventToPlugin(repeatRequestEvent, secondaryEventHandler);
    }

    protected abstract void fillEventPluginMap(Map<String, Class> map, Map<String, Class> map2);

    public IJsPlugin getEventHandler(String str) {
        Class cls = this.mEventPluginMap.get(str);
        if (cls == null) {
            return null;
        }
        IJsPlugin iJsPlugin = this.mActivatedPlugins.get(cls);
        if (iJsPlugin != null) {
            return iJsPlugin;
        }
        return createJsPlugin(cls);
    }

    protected IJsPlugin getSecondaryEventHandler(String str) {
        Class cls = this.mSecondaryEventPluginMap.get(str);
        if (cls == null) {
            return null;
        }
        IJsPlugin iJsPlugin = this.mActivatedPlugins.get(cls);
        if (iJsPlugin != null) {
            return iJsPlugin;
        }
        return createJsPlugin(cls);
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        Iterator<Class> it = JsPluginList.getPreloadPlugins(iMiniAppContext.isMiniGame()).iterator();
        while (it.hasNext()) {
            createJsPlugin(it.next());
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mActivatedPlugins.clear();
        this.mEventPluginMap.clear();
        this.mSecondaryEventPluginMap.clear();
        JsPluginList.clear();
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        super.onPause();
        Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onRestart() {
        super.onRestart();
        Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().onRestart();
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
        Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onStart() {
        Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onStop() {
        Iterator<IJsPlugin> it = this.mActivatedPlugins.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void reportApiInvoke(final MiniAppInfo miniAppInfo, final String str) {
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine.1
            @Override // java.lang.Runnable
            public void run() {
                List<String> apiReportConfig;
                List<String> list = ReportConst.apiReportList;
                WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
                if (wnsConfigProxy != null && (apiReportConfig = wnsConfigProxy.getApiReportConfig()) != null && apiReportConfig.size() > 0) {
                    list = apiReportConfig;
                }
                if (list != null && list.contains(str)) {
                    SDKMiniProgramLpReportDC04239.reportApiInvoke(miniAppInfo, str);
                }
            }
        });
    }
}
