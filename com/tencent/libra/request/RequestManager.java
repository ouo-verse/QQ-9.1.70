package com.tencent.libra.request;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RequestManager implements LifecycleEventObserver {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RequestManager");
    protected final RequestTracker mRequestTracker = new RequestTracker();

    public RequestManager(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, -1, "[onStateChanged] source:", lifecycleOwner, " requestManager:", Integer.valueOf(hashCode()), " event:", event, " mRequestTracker size:", Integer.valueOf(this.mRequestTracker.getRequestSize()));
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.mRequestTracker.clearRequests();
        }
        if (event == Lifecycle.Event.ON_STOP) {
            this.mRequestTracker.pauseRequests();
        } else if (event == Lifecycle.Event.ON_START) {
            this.mRequestTracker.resumeRequests();
        }
    }

    public synchronized void track(@NonNull Request request) {
        this.mRequestTracker.addRequest(request);
    }

    public synchronized void unTrack(@NonNull Request request) {
        this.mRequestTracker.clearAndRemove(request);
    }

    public synchronized void unTrackWithoutClear(@NonNull Request request) {
        this.mRequestTracker.unTrackWithoutClear(request);
    }
}
