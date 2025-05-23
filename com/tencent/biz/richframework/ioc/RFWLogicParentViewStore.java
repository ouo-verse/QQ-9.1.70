package com.tencent.biz.richframework.ioc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.operate.api.ILogicParentViewGetter;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class RFWLogicParentViewStore implements ILogicParentViewGetter, Application.ActivityLifecycleCallbacks {
    private final Map<Integer, HashMap<String, WeakReference<ViewGroup>>> mLogicParentViewMap = new HashMap();

    public RFWLogicParentViewStore() {
        RFWLifecycleHelper.getInstance().registerActivityLifecycleCallback(this);
    }

    private void removePageLogicParentView(Context context) {
        if (context == null) {
            RFWLog.e("qioc-RFWLogicParentViewStore", RFWLog.USR, "removePageLogicParentView  context pageKey == null");
            return;
        }
        RFWLog.d("qioc-RFWLogicParentViewStore", RFWLog.USR, "removePageLogicParentView  pageKey = " + context.hashCode());
        synchronized (this.mLogicParentViewMap) {
            this.mLogicParentViewMap.remove(Integer.valueOf(context.hashCode()));
        }
    }

    @Override // com.tencent.biz.richframework.ioc.operate.api.ILogicParentViewGetter
    public ViewGroup getLogicParentView(View view) {
        if (view == null || view.getContext() == null) {
            return null;
        }
        int hashCode = view.getContext().hashCode();
        synchronized (this.mLogicParentViewMap) {
            HashMap<String, WeakReference<ViewGroup>> hashMap = this.mLogicParentViewMap.get(Integer.valueOf(hashCode));
            if (hashMap == null) {
                return null;
            }
            WeakReference<ViewGroup> weakReference = hashMap.get(String.valueOf(view.hashCode()));
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        removePageLogicParentView(activity);
    }

    public void setLogicParentView(View view, ViewGroup viewGroup) {
        if (view != null && viewGroup != null) {
            int hashCode = view.getContext().hashCode();
            String valueOf = String.valueOf(view.hashCode());
            synchronized (this.mLogicParentViewMap) {
                HashMap<String, WeakReference<ViewGroup>> hashMap = this.mLogicParentViewMap.get(Integer.valueOf(hashCode));
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    this.mLogicParentViewMap.put(Integer.valueOf(hashCode), hashMap);
                }
                hashMap.put(valueOf, new WeakReference<>(viewGroup));
            }
            return;
        }
        RFWLog.e("qioc-RFWLogicParentViewStore", RFWLog.USR, "setLogicParentView  params error");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
