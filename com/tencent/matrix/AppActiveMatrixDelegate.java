package com.tencent.matrix;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import g51.b;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum AppActiveMatrixDelegate {
    INSTANCE;

    private static final String TAG = "Matrix.AppActiveDelegate";
    private String currentFragmentName;
    private Handler handler;
    private final Set<d51.a> listeners = new HashSet();
    private boolean isAppForeground = false;
    private String visibleScene = "default";
    private a controller = new a();
    private boolean isInit = false;

    AppActiveMatrixDelegate() {
    }

    public static String getTopActivityName() {
        ArrayMap arrayMap;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                arrayMap = (ArrayMap) declaredField.get(invoke);
            } catch (Exception e16) {
                e16.printStackTrace();
                b.a(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            if (arrayMap.size() < 1) {
                b.a(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    declaredField3.setAccessible(true);
                    String name = ((Activity) declaredField3.get(obj)).getClass().getName();
                    b.a(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return name;
                }
            }
            b.a(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return null;
        } catch (Throwable th5) {
            b.a(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchBackground(String str) {
        if (this.isAppForeground && this.isInit) {
            b.c(TAG, "onBackground... visibleScene[%s]", str);
            this.handler.post(new Runnable() { // from class: com.tencent.matrix.AppActiveMatrixDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    AppActiveMatrixDelegate.this.isAppForeground = false;
                    synchronized (AppActiveMatrixDelegate.this.listeners) {
                        Iterator it = AppActiveMatrixDelegate.this.listeners.iterator();
                        while (it.hasNext()) {
                            ((d51.a) it.next()).a(false);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchForeground(String str) {
        if (!this.isAppForeground && this.isInit) {
            b.c(TAG, "onForeground... visibleScene[%s]", str);
            this.handler.post(new Runnable() { // from class: com.tencent.matrix.AppActiveMatrixDelegate.1
                @Override // java.lang.Runnable
                public void run() {
                    AppActiveMatrixDelegate.this.isAppForeground = true;
                    synchronized (AppActiveMatrixDelegate.this.listeners) {
                        Iterator it = AppActiveMatrixDelegate.this.listeners.iterator();
                        while (it.hasNext()) {
                            ((d51.a) it.next()).a(true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScene(Activity activity) {
        this.visibleScene = activity.getClass().getName();
    }

    public void addListener(d51.a aVar) {
        synchronized (this.listeners) {
            this.listeners.add(aVar);
        }
    }

    public String getCurrentFragmentName() {
        return this.currentFragmentName;
    }

    public String getVisibleScene() {
        return this.visibleScene;
    }

    public void init(Application application) {
        if (this.isInit) {
            b.b(TAG, "has inited!", new Object[0]);
            return;
        }
        this.isInit = true;
        if (g51.a.a() != null) {
            this.handler = new Handler(g51.a.a().getLooper());
        }
        application.registerComponentCallbacks(this.controller);
        application.registerActivityLifecycleCallbacks(this.controller);
    }

    public boolean isAppForeground() {
        return this.isAppForeground;
    }

    public void removeListener(d51.a aVar) {
        synchronized (this.listeners) {
            this.listeners.remove(aVar);
        }
    }

    public void setCurrentFragmentName(String str) {
        b.c(TAG, "[setCurrentFragmentName] fragmentName:%s", str);
        this.currentFragmentName = str;
        updateScene(str);
    }

    private void updateScene(String str) {
        StringBuilder sb5 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        sb5.append(str);
        this.visibleScene = sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            AppActiveMatrixDelegate.this.updateScene(activity);
            AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.this;
            appActiveMatrixDelegate.onDispatchForeground(appActiveMatrixDelegate.getVisibleScene());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (AppActiveMatrixDelegate.getTopActivityName() == null) {
                AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.this;
                appActiveMatrixDelegate.onDispatchBackground(appActiveMatrixDelegate.getVisibleScene());
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            b.c(AppActiveMatrixDelegate.TAG, "[onTrimMemory] level:%s", Integer.valueOf(i3));
            if (i3 == 20 && AppActiveMatrixDelegate.this.isAppForeground) {
                AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.this;
                appActiveMatrixDelegate.onDispatchBackground(appActiveMatrixDelegate.visibleScene);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
