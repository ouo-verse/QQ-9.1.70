package com.tencent.biz.richframework.eventbus;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SimpleEventBus {
    private static final String TAG = "SimpleEventBus";
    private SimpleEventBusReceiver mSimpleEventBusReceiver;
    private static final SimpleEventBus OUR_INSTANCE = new SimpleEventBus();
    public static String IPC_SERVICE_MODULE_NAME = "SUBSCRIBE_IPC_MODULE";
    public static String ACTION_PRAISED_UPDATE = "ACTION_PRAISED_UPDATE";
    public static String ACTION_DRAFT_SYSTEM_CHANGE = "ACTION_DRAFT_SYSTEM_CHANGE";
    private int mTriggerWarnFrequency = 5;
    private ConcurrentHashMap<String, Long> mEventDispatchRecord = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> mEventSendCount = new ConcurrentHashMap<>();
    private boolean mIsDebuging = false;
    private long mMonitorInterval = 1000;
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<SimpleEventReceiver>>> mEventCenter = new ConcurrentHashMap<>();

    SimpleEventBus() {
        initBroadCastReceiver();
    }

    private void checkEventDispatchFrequency(SimpleBaseEvent simpleBaseEvent) {
        int intValue;
        String simpleName = simpleBaseEvent.getClass().getSimpleName();
        Long l3 = this.mEventDispatchRecord.get(simpleName);
        if (l3 == null) {
            this.mEventDispatchRecord.put(simpleName, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (System.currentTimeMillis() - l3.longValue() > this.mMonitorInterval) {
            this.mEventDispatchRecord.put(simpleName, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        Integer num = this.mEventSendCount.get(simpleName);
        if (num == null) {
            intValue = 1;
        } else {
            intValue = num.intValue() + 1;
        }
        Integer valueOf = Integer.valueOf(intValue);
        this.mEventSendCount.put(simpleName, valueOf);
        if (valueOf.intValue() > this.mTriggerWarnFrequency) {
            RFWLog.e(TAG, RFWLog.USR, "dispatch event" + simpleBaseEvent.getClass().getSimpleName() + "is high frequency, send Count:" + valueOf);
        }
    }

    public static SimpleEventBus getInstance() {
        return OUR_INSTANCE;
    }

    private void initBroadCastReceiver() {
        if (RFWApplication.getApplication() != null) {
            if (this.mSimpleEventBusReceiver == null) {
                this.mSimpleEventBusReceiver = new SimpleEventBusReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(SimpleEventBusReceiver.BROADCAST_RECEIVER_ACTION);
                RFWApplication.getApplication().registerReceiver(this.mSimpleEventBusReceiver, intentFilter);
                return;
            }
            return;
        }
        RFWLog.e(TAG, RFWLog.USR, "initBroadCastReceiver RFWApplication.getApplication is null!");
        if (!RFWApplication.isDebug()) {
        } else {
            throw new RuntimeException("please invoke RFWApplication at your application onCreate Method");
        }
    }

    private void registerEachReceiver(String str, SimpleEventReceiver simpleEventReceiver) {
        ConcurrentHashMap<Integer, WeakReference<SimpleEventReceiver>> concurrentHashMap = this.mEventCenter.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        concurrentHashMap.put(Integer.valueOf(simpleEventReceiver.hashCode()), new WeakReference<>(simpleEventReceiver));
        this.mEventCenter.put(str, concurrentHashMap);
        if (this.mIsDebuging) {
            RFWLog.d(TAG, RFWLog.DEV, "registerReceiver event Name:" + str + ",key\uff1a[" + simpleEventReceiver.getClass().getSimpleName() + ":" + simpleEventReceiver.hashCode() + "], subscribers size:" + concurrentHashMap.size());
        }
    }

    private void unRegisterEachReceiver(String str, SimpleEventReceiver simpleEventReceiver) {
        ConcurrentHashMap<Integer, WeakReference<SimpleEventReceiver>> concurrentHashMap = this.mEventCenter.get(str);
        if (concurrentHashMap == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(simpleEventReceiver.hashCode()));
        if (concurrentHashMap.size() == 0) {
            this.mEventCenter.remove(str);
        }
        if (this.mIsDebuging) {
            RFWLog.d(TAG, RFWLog.DEV, "unRegisterReceiver event Name:" + str + ",key\uff1a[" + simpleEventReceiver.getClass().getSimpleName() + ":" + simpleEventReceiver.hashCode() + "], subscribers size:" + concurrentHashMap.size());
        }
    }

    public void dispatchEvent(SimpleBaseEvent simpleBaseEvent) {
        dispatchEvent(simpleBaseEvent, false);
    }

    public void onDestroy() {
        if (RFWApplication.getApplication() != null && this.mSimpleEventBusReceiver != null) {
            RFWApplication.getApplication().unregisterReceiver(this.mSimpleEventBusReceiver);
        }
    }

    public void registerReceiver(SimpleEventReceiver simpleEventReceiver) {
        ArrayList eventClass;
        if (simpleEventReceiver != null && (eventClass = simpleEventReceiver.getEventClass()) != null) {
            Iterator it = eventClass.iterator();
            while (it.hasNext()) {
                registerEachReceiver(((Class) it.next()).getName(), simpleEventReceiver);
            }
        }
    }

    public void setDebuging(boolean z16) {
        this.mIsDebuging = z16;
    }

    public void setMonitorInterval(long j3) {
        this.mMonitorInterval = j3;
    }

    public void setTriggerWarnFrequency(int i3) {
        this.mTriggerWarnFrequency = i3;
    }

    public void unRegisterReceiver(SimpleEventReceiver simpleEventReceiver) {
        if (simpleEventReceiver != null && simpleEventReceiver.getEventClass() != null) {
            Iterator it = simpleEventReceiver.getEventClass().iterator();
            while (it.hasNext()) {
                unRegisterEachReceiver(((Class) it.next()).getName(), simpleEventReceiver);
            }
        }
    }

    public void dispatchEvent(SimpleBaseEvent simpleBaseEvent, boolean z16) {
        if (simpleBaseEvent == null) {
            RFWLog.e(TAG, RFWLog.USR, "dispatchEvent event is null!");
            return;
        }
        if (RFWApplication.isDebug()) {
            checkEventDispatchFrequency(simpleBaseEvent);
        }
        if (z16) {
            Intent intent = new Intent();
            intent.setAction(SimpleEventBusReceiver.BROADCAST_RECEIVER_ACTION);
            intent.putExtra(SimpleEventBusReceiver.INTENT_KEY_DISPATCH_EVENT, simpleBaseEvent);
            if (RFWApplication.getApplication() != null) {
                RFWApplication.getApplication().sendBroadcast(intent);
                return;
            }
            RFWLog.e(TAG, RFWLog.USR, "dispatchEvent:" + simpleBaseEvent.getClass().getSimpleName() + " ipc RFWApplication.getApplication is null!");
            return;
        }
        ConcurrentHashMap<Integer, WeakReference<SimpleEventReceiver>> concurrentHashMap = this.mEventCenter.get(simpleBaseEvent.getClass().getName());
        if (concurrentHashMap == null) {
            RFWLog.e(TAG, RFWLog.CLR, "dispatchEvent\uff1a" + simpleBaseEvent.getClass().getSimpleName() + "has none subscribers!");
            return;
        }
        for (WeakReference<SimpleEventReceiver> weakReference : concurrentHashMap.values()) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().onReceiveEvent(simpleBaseEvent);
            }
        }
    }
}
