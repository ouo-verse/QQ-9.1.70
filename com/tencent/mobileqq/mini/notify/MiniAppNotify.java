package com.tencent.mobileqq.mini.notify;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppNotify {
    static final String TAG = "MiniAppNotify";

    /* renamed from: g, reason: collision with root package name */
    public static MiniAppNotify f246657g = new MiniAppNotify();
    private ConcurrentLinkedQueue<IMiniAppNotifyListener> listenerList = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface IMiniAppNotifyListener {
        void onNotify(String str, int i3, String str2, String str3, long j3);
    }

    public void notify(String str, int i3, String str2, String str3, long j3) {
        QLog.d(TAG, 1, "appid:" + str + " scene:" + i3 + " via:" + str2 + " event:" + str3 + " timestamp:" + j3);
        Iterator<IMiniAppNotifyListener> it = this.listenerList.iterator();
        while (it.hasNext()) {
            it.next().onNotify(str, i3, str2, str3, j3);
        }
    }

    public void register(IMiniAppNotifyListener iMiniAppNotifyListener) {
        this.listenerList.add(iMiniAppNotifyListener);
    }

    public void remove(IMiniAppNotifyListener iMiniAppNotifyListener) {
        this.listenerList.remove(iMiniAppNotifyListener);
    }
}
