package com.tencent.av.utils.api.impl;

import android.os.IBinder;
import com.tencent.av.utils.api.IVideoProcessMonitor;

/* loaded from: classes3.dex */
public class VideoProcessMonitorImpl implements IVideoProcessMonitor {
    private IBinder mMonitorBinder;

    @Override // com.tencent.av.utils.api.IVideoProcessMonitor
    public void clearMonitorBinder() {
        this.mMonitorBinder = null;
    }

    @Override // com.tencent.av.utils.api.IVideoProcessMonitor
    public boolean isVideoProcessAlive() {
        if (this.mMonitorBinder != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.utils.api.IVideoProcessMonitor
    public void setMonitorBinder(IBinder iBinder) {
        this.mMonitorBinder = iBinder;
    }
}
