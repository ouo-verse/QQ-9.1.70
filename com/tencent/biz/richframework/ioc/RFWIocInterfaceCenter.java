package com.tencent.biz.richframework.ioc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.callback.IocPromiseTask;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWIocInterfaceCenter implements Application.ActivityLifecycleCallbacks {
    private final Map<Integer, HashMap<String, Object>> mIocMap = new HashMap();
    private final Map<Integer, ArrayList<WeakReference<IocPromiseTask>>> mTaskMap = new HashMap();

    public RFWIocInterfaceCenter() {
        RFWLifecycleHelper.getInstance().registerActivityLifecycleCallback(this);
    }

    private void removePageIoc(Context context) {
        if (context == null) {
            RFWLog.e("qioc-RFWIocInterfaceCenter", RFWLog.USR, "removePageIoc  context pageKey == null");
            return;
        }
        RFWLog.d("qioc-RFWIocInterfaceCenter", RFWLog.USR, "removePageIoc  pageKey = " + context.hashCode());
        synchronized (this.mIocMap) {
            this.mIocMap.remove(Integer.valueOf(context.hashCode()));
        }
    }

    private void removePageTaskAndRelease(Context context) {
        if (context == null) {
            RFWLog.e("qioc-RFWIocInterfaceCenter", RFWLog.USR, "removePageTaskAndRelease  context pageKey == null");
            return;
        }
        RFWLog.d("qioc-RFWIocInterfaceCenter", RFWLog.USR, "removePageTaskAndRelease  pageKey = " + context.hashCode());
        synchronized (this.mTaskMap) {
            ArrayList<WeakReference<IocPromiseTask>> remove = this.mTaskMap.remove(Integer.valueOf(context.hashCode()));
            if (remove != null) {
                Iterator<WeakReference<IocPromiseTask>> it = remove.iterator();
                while (it.hasNext()) {
                    IocPromiseTask iocPromiseTask = it.next().get();
                    if (iocPromiseTask != null) {
                        iocPromiseTask.release();
                    }
                }
            }
        }
    }

    public void addIocInterface(int i3, String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("qioc-RFWIocInterfaceCenter", RFWLog.USR, "addIocInterface  key == null");
            return;
        }
        if (obj == null) {
            RFWLog.e("qioc-RFWIocInterfaceCenter", RFWLog.USR, "addIocInterface  ioc == null");
            return;
        }
        synchronized (this.mIocMap) {
            HashMap<String, Object> hashMap = this.mIocMap.get(Integer.valueOf(i3));
            if (hashMap == null) {
                hashMap = new HashMap<>();
                this.mIocMap.put(Integer.valueOf(i3), hashMap);
            }
            hashMap.put(str, obj);
        }
    }

    public Object getSingleIoc(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("qioc-RFWIocInterfaceCenter", RFWLog.USR, "getSingleIoc  key == null");
            return null;
        }
        synchronized (this.mIocMap) {
            HashMap<String, Object> hashMap = this.mIocMap.get(Integer.valueOf(i3));
            if (hashMap == null) {
                RFWLog.w("qioc-RFWIocInterfaceCenter", RFWLog.USR, "getSingleIoc  pageIocMap == null");
                return null;
            }
            return hashMap.get(str);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        removePageIoc(activity);
        removePageTaskAndRelease(activity);
    }

    public Object removeSingleIoc(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("qioc-RFWIocInterfaceCenter", RFWLog.USR, "removeSingleIoc  key == null");
            return null;
        }
        synchronized (this.mIocMap) {
            HashMap<String, Object> hashMap = this.mIocMap.get(Integer.valueOf(i3));
            if (hashMap == null) {
                return null;
            }
            return hashMap.remove(str);
        }
    }

    public void saveIocPromiseTask(IocPromiseTask iocPromiseTask) {
        if (iocPromiseTask != null && iocPromiseTask.getOriginView() != null) {
            int hashCode = iocPromiseTask.getOriginView().getContext().hashCode();
            synchronized (this.mTaskMap) {
                ArrayList<WeakReference<IocPromiseTask>> arrayList = this.mTaskMap.get(Integer.valueOf(hashCode));
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.mTaskMap.put(Integer.valueOf(hashCode), arrayList);
                }
                arrayList.add(new WeakReference<>(iocPromiseTask));
            }
        }
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
