package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.tencent.qcircle.shadow.core.runtime.ShadowActivityLifecycleCallbacks;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class ShadowApplication extends ShadowContext {
    public boolean isCallOnCreate;
    private Map<ShadowActivityLifecycleCallbacks, Application.ActivityLifecycleCallbacks> mActivityLifecycleCallbacksMap = new HashMap();
    private Map<String, List<String>> mBroadcasts;
    private Application mHostApplication;

    public void onCreate() {
        this.isCallOnCreate = true;
        for (Map.Entry<String, List<String>> entry : this.mBroadcasts.entrySet()) {
            try {
                BroadcastReceiver broadcastReceiver = (BroadcastReceiver) this.mPluginClassLoader.loadClass(entry.getKey()).newInstance();
                IntentFilter intentFilter = new IntentFilter();
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    intentFilter.addAction(it.next());
                }
                this.mHostApplication.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        this.mHostApplication.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.tencent.qcircle.shadow.core.runtime.ShadowApplication.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                ShadowApplication.this.onConfigurationChanged(configuration);
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                ShadowApplication.this.onLowMemory();
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i3) {
                ShadowApplication.this.onTrimMemory(i3);
            }
        });
    }

    public void onTerminate() {
        throw new UnsupportedOperationException();
    }

    public void registerActivityLifecycleCallbacks(ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks) {
        ShadowActivityLifecycleCallbacks.Wrapper wrapper = new ShadowActivityLifecycleCallbacks.Wrapper(shadowActivityLifecycleCallbacks, this);
        this.mActivityLifecycleCallbacksMap.put(shadowActivityLifecycleCallbacks, wrapper);
        this.mHostApplication.registerActivityLifecycleCallbacks(wrapper);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mHostApplication.registerComponentCallbacks(componentCallbacks);
    }

    @TargetApi(18)
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mHostApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    public void setBroadcasts(Map<String, List<String>> map) {
        this.mBroadcasts = map;
    }

    public void setHostApplicationContextAsBase(Context context) {
        super.attachBaseContext(context);
        this.mHostApplication = (Application) context;
    }

    public void unregisterActivityLifecycleCallbacks(ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityLifecycleCallbacksMap.get(shadowActivityLifecycleCallbacks);
        if (activityLifecycleCallbacks != null) {
            this.mHostApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.mActivityLifecycleCallbacksMap.remove(shadowActivityLifecycleCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.mHostApplication.unregisterComponentCallbacks(componentCallbacks);
    }

    @TargetApi(18)
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mHostApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.ShadowContext, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    public void onLowMemory() {
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onTrimMemory(int i3) {
    }
}
