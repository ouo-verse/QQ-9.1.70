package com.tencent.libra.request;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.richframework.lifecycle.RFWViewLifecycleUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LifecycleRequestManagerRetriever implements LifecycleEventObserver {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LifecycleRequestManagerRetriever");
    private static volatile LifecycleRequestManagerRetriever sInstance;
    final Map<Integer, RequestManager> lifecycleToRequestManager = new HashMap();

    public static LifecycleRequestManagerRetriever g() {
        if (sInstance == null) {
            synchronized (LifecycleRequestManagerRetriever.class) {
                if (sInstance == null) {
                    sInstance = new LifecycleRequestManagerRetriever();
                }
            }
        }
        return sInstance;
    }

    RequestManager getOnly(@NonNull Lifecycle lifecycle) {
        return this.lifecycleToRequestManager.get(Integer.valueOf(lifecycle.hashCode()));
    }

    public RequestManager getOrCreate(Lifecycle lifecycle) {
        if (lifecycle == null) {
            return null;
        }
        RequestManager only = getOnly(lifecycle);
        if (only != null) {
            return only;
        }
        RequestManager requestManager = new RequestManager(lifecycle);
        lifecycle.addObserver(this);
        this.lifecycleToRequestManager.put(Integer.valueOf(lifecycle.hashCode()), requestManager);
        return requestManager;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            try {
                Lifecycle lifecycle = lifecycleOwner.getLifecycle();
                this.lifecycleToRequestManager.remove(Integer.valueOf(lifecycle.hashCode()));
                lifecycle.removeObserver(this);
            } catch (Exception e16) {
                RFWLog.e(TAG, RFWLog.USR, e16);
            }
        }
    }

    public RequestManager getOrCreate(View view) {
        LifecycleOwner viewLifecycleOwner = RFWViewLifecycleUtil.getViewLifecycleOwner(view, true);
        if (viewLifecycleOwner != null) {
            return getOrCreate(viewLifecycleOwner.getLifecycle());
        }
        return null;
    }
}
