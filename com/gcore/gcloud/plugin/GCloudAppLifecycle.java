package com.gcore.gcloud.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.gcore.abase.GCloudCore;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudAppLifecycle {
    public static final GCloudAppLifecycle Instance = new GCloudAppLifecycle();
    private static final String TAG = "GCloudCore";
    List<GCloudAppLifecycleObserver> _observers = new ArrayList();
    List<Object> _genericobservers = new ArrayList();

    public void addGenericoObserver(Object obj) {
        Log.i(TAG, "addGenericoObserver begin _genericobservers.size():" + this._genericobservers.size());
        if (obj == null) {
            return;
        }
        this._genericobservers.add(obj);
    }

    public void addObserver(GCloudAppLifecycleObserver gCloudAppLifecycleObserver) {
        Log.i(TAG, "addObserver begin _observers.size():" + this._observers.size());
        if (gCloudAppLifecycleObserver == null) {
            return;
        }
        this._observers.add(gCloudAppLifecycleObserver);
    }

    public void addObserverByName(String str) {
        Log.i(TAG, "addObserverByName Name:" + str);
        if (str == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (GCloudAppLifecycleObserver.class.isAssignableFrom(cls)) {
                Log.i(TAG, "GCloudAppLifecycleObserver.class.isAssignableFrom(clz) true");
                cls.newInstance();
                Log.i(TAG, "addObserverByName Success, observerName:" + str);
            } else {
                Log.i(TAG, "GCloudAppLifecycleObserver.class.isAssignableFrom(clz) false");
                this._genericobservers.add(cls.newInstance());
                Log.i(TAG, "addGenericObserverByName Success, observerName:" + str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        for (int i17 = 0; i17 < this._observers.size(); i17++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i17);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i17 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onActivityResult(i3, i16, intent);
            }
        }
        for (int i18 = 0; i18 < this._genericobservers.size(); i18++) {
            Object obj = this._genericobservers.get(i18);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i18 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    Class<?> cls = obj.getClass();
                    Class<?> cls2 = Integer.TYPE;
                    cls.getMethod("onActivityResult", cls2, cls2, Intent.class).invoke(obj, Integer.valueOf(i3), Integer.valueOf(i16), intent);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onCreate(Context context) {
        GCloudCore.Instance.Initialize2(context);
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                try {
                    gCloudAppLifecycleObserver.getClass().getMethod("onCreate", Context.class).invoke(gCloudAppLifecycleObserver, context);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onCreate", Context.class).invoke(obj, context);
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            }
        }
        PluginUtils.Startup();
        PluginUtils.PostStartup();
    }

    public void onDestroy() {
        GCloudCore.Instance.Destroy();
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onDestroy();
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onNewIntent(Intent intent) {
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onNewIntent(intent);
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onNewIntent", Intent.class).invoke(obj, intent);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onPause() {
        GCloudCore.Instance.Pause();
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onPause();
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        for (int i16 = 0; i16 < this._observers.size(); i16++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i16);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i16 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onRequestPermissionsResult(i3, strArr, iArr);
            }
        }
        for (int i17 = 0; i17 < this._genericobservers.size(); i17++) {
            Object obj = this._genericobservers.get(i17);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i17 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onRequestPermissionsResult", Integer.TYPE, String[].class, int[].class).invoke(obj, Integer.valueOf(i3), strArr, iArr);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onRestart() {
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onRestart();
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onRestart", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onResume() {
        GCloudCore.Instance.Resume();
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onResume();
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onResume", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onStart() {
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onStart();
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onStart", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void onStop() {
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onStop();
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod(DKHippyEvent.EVENT_STOP, new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public void removeObserver(GCloudAppLifecycleObserver gCloudAppLifecycleObserver) {
        if (gCloudAppLifecycleObserver != null && this._observers.size() > 0) {
            gCloudAppLifecycleObserver.equals(this._observers.get(0));
            this._observers.remove(0);
        }
    }

    public void onCreate(Activity activity, Bundle bundle) {
        GCloudCore.Instance.Initialize(activity);
        for (int i3 = 0; i3 < this._observers.size(); i3++) {
            GCloudAppLifecycleObserver gCloudAppLifecycleObserver = this._observers.get(i3);
            if (gCloudAppLifecycleObserver != null) {
                try {
                    Log.i(TAG, "observer pos:" + i3 + " className:" + gCloudAppLifecycleObserver.getClass().getName());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                gCloudAppLifecycleObserver.onCreate(bundle);
                gCloudAppLifecycleObserver.onCreate(activity, bundle);
            }
        }
        for (int i16 = 0; i16 < this._genericobservers.size(); i16++) {
            Object obj = this._genericobservers.get(i16);
            if (obj != null) {
                try {
                    Log.i(TAG, "genericobserver pos:" + i16 + " className:" + obj.getClass().getName());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                try {
                    obj.getClass().getMethod("onCreate", Bundle.class).invoke(obj, bundle);
                    obj.getClass().getMethod("onCreate", Activity.class, Bundle.class).invoke(obj, activity, bundle);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        }
        PluginUtils.Startup();
        PluginUtils.PostStartup();
    }
}
