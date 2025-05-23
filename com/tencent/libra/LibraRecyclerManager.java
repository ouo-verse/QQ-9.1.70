package com.tencent.libra;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraRecyclerManager implements Application.ActivityLifecycleCallbacks {
    private static final long RECYCLE_DELAY_TIME = 10000;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraRecyclerManager");
    private static volatile LibraRecyclerManager sInstance;
    private final Map<Integer, WeakReference<Option>> mViewBindOptions = new HashMap();
    private final Map<Integer, Set<WeakReference<Option>>> mAllOptions = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class InnerRecyclerTask implements Runnable {
        private final WeakReference<Option> mOptionWrf;

        InnerRecyclerTask(Option option) {
            this.mOptionWrf = new WeakReference<>(option);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mOptionWrf.get() != null) {
                this.mOptionWrf.get().recycle();
            }
        }
    }

    LibraRecyclerManager() {
        if (RFWApplication.getApplication() instanceof Application) {
            RFWApplication.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public static LibraRecyclerManager getInstance() {
        if (sInstance == null) {
            synchronized (LibraRecyclerManager.class) {
                if (sInstance == null) {
                    sInstance = new LibraRecyclerManager();
                }
            }
        }
        return sInstance;
    }

    private void log(String str) {
        RFWLog.d(TAG, RFWLog.USR, str);
    }

    @UiThread
    private void registerOption(Context context, Option option) {
        Set<WeakReference<Option>> set = this.mAllOptions.get(Integer.valueOf(context.hashCode()));
        if (set == null) {
            set = new LinkedHashSet<>();
        }
        set.add(new WeakReference<>(option));
        this.mAllOptions.put(Integer.valueOf(context.hashCode()), set);
    }

    @UiThread
    private void removeTargetOption(Context context) {
        log("remove context:" + context.hashCode());
        Set<WeakReference<Option>> set = this.mAllOptions.get(Integer.valueOf(context.hashCode()));
        if (set == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("remove by context ");
        Iterator<WeakReference<Option>> it = set.iterator();
        while (it.hasNext()) {
            Option option = it.next().get();
            if (option != null) {
                sb5.append(option.getSeq());
                sb5.append(" ");
                ImageView targetView = option.getTargetView();
                if (targetView != null) {
                    this.mViewBindOptions.remove(Integer.valueOf(targetView.hashCode()));
                }
                option.recycle();
            }
        }
        log(sb5.toString());
    }

    @UiThread
    public void addToRecyclePool(Option option) {
        Option option2;
        if (option != null && option.isSupportReuse()) {
            ImageView targetView = option.getTargetView();
            if (targetView != null) {
                WeakReference<Option> weakReference = this.mViewBindOptions.get(Integer.valueOf(targetView.hashCode()));
                if (weakReference != null && (option2 = weakReference.get()) != null && option2 != option) {
                    LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[addToRecyclePool] remove by bind same View");
                    option2.recycle();
                }
                this.mViewBindOptions.put(Integer.valueOf(targetView.hashCode()), new WeakReference<>(option));
                registerOption(targetView.getContext(), option);
                return;
            }
            RFWThreadManager.getInstance().runOnUiThread(new InnerRecyclerTask(option), 10000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        removeTargetOption(activity);
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
