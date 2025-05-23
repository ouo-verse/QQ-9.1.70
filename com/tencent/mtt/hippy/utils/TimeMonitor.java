package com.tencent.mtt.hippy.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TimeMonitor {
    HippyEngineMonitorEvent mCurrentEvent;
    final boolean mEnable;
    List<HippyEngineMonitorEvent> mEvents;
    long mStartTime;
    int mTotalTime;

    public TimeMonitor(boolean z16) {
        this.mEnable = z16;
    }

    public void begine() {
        if (!this.mEnable) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mCurrentEvent = null;
        if (this.mEvents == null) {
            this.mEvents = Collections.synchronizedList(new ArrayList());
        }
        this.mEvents.clear();
        this.mTotalTime = 0;
    }

    public void end() {
        if (!this.mEnable) {
            return;
        }
        HippyEngineMonitorEvent hippyEngineMonitorEvent = this.mCurrentEvent;
        if (hippyEngineMonitorEvent != null) {
            hippyEngineMonitorEvent.endTime = System.currentTimeMillis();
            this.mEvents.add(this.mCurrentEvent);
        }
        this.mTotalTime = (int) (SystemClock.elapsedRealtime() - this.mStartTime);
    }

    public List<HippyEngineMonitorEvent> getEvents() {
        return this.mEvents;
    }

    public int getTotalTime() {
        return this.mTotalTime;
    }

    public void startEvent(String str) {
        if (!this.mEnable) {
            return;
        }
        HippyEngineMonitorEvent hippyEngineMonitorEvent = this.mCurrentEvent;
        if (hippyEngineMonitorEvent != null) {
            hippyEngineMonitorEvent.endTime = System.currentTimeMillis();
            this.mEvents.add(this.mCurrentEvent);
            LogUtils.d("hippy", "hippy endEvent: " + this.mCurrentEvent.eventName);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HippyEngineMonitorEvent hippyEngineMonitorEvent2 = new HippyEngineMonitorEvent();
        this.mCurrentEvent = hippyEngineMonitorEvent2;
        hippyEngineMonitorEvent2.eventName = str;
        hippyEngineMonitorEvent2.startTime = System.currentTimeMillis();
        LogUtils.d("hippy", "hippy startEvent: " + str);
    }
}
