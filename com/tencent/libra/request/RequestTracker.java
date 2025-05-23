package com.tencent.libra.request;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.libra.util.LibraImageUtil;
import com.tencent.libra.util.LibraLogUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RequestTracker {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RequestTracker");
    private boolean isPaused;
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());
    private final Set<Request> pendingRequests = new HashSet();

    @VisibleForTesting
    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public boolean clearAndRemove(@Nullable Request request) {
        boolean z16 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !remove) {
            z16 = false;
        }
        if (z16) {
            request.clear();
        }
        return z16;
    }

    public void clearRequests() {
        Iterator it = LibraImageUtil.getSnapshot(this.requests).iterator();
        while (it.hasNext()) {
            clearAndRemove((Request) it.next());
        }
        this.pendingRequests.clear();
    }

    public int getRequestSize() {
        return this.requests.size();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        for (Request request : LibraImageUtil.getSnapshot(this.requests)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.pendingRequests.add(request);
            }
        }
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (Request request : LibraImageUtil.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }

    public void removeRequest(Request request) {
        this.requests.remove(request);
    }

    public void restartRequests() {
        for (Request request : LibraImageUtil.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (!this.isPaused) {
                    request.begin();
                } else {
                    this.pendingRequests.add(request);
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (Request request : LibraImageUtil.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
            return;
        }
        request.clear();
        String str = TAG;
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "Paused, delaying request");
        }
        this.pendingRequests.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
    }

    public boolean unTrackWithoutClear(@Nullable Request request) {
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (this.pendingRequests.remove(request) || remove) {
            return true;
        }
        return false;
    }
}
