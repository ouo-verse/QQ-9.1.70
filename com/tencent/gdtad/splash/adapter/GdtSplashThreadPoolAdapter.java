package com.tencent.gdtad.splash.adapter;

import com.qq.e.comm.managers.thread.GdtSDKThreadManagerAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class GdtSplashThreadPoolAdapter implements GdtSDKThreadManagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Integer> f109353a = new HashMap<Integer, Integer>() { // from class: com.tencent.gdtad.splash.adapter.GdtSplashThreadPoolAdapter.1
        {
            put(1, 16);
            put(2, 128);
            put(3, 64);
        }
    };

    @Override // com.qq.e.comm.managers.thread.GdtSDKThreadManagerAdapter
    public void runOnThread(int i3, Runnable runnable, long j3) {
        Map<Integer, Integer> map = f109353a;
        if (map.containsKey(Integer.valueOf(i3))) {
            ThreadManagerV2.executeDelay(runnable, map.get(Integer.valueOf(i3)).intValue(), null, false, j3);
            return;
        }
        QLog.e("GdtSplashThreadPoolAdapter", 1, "[runOnThread] type error" + i3);
    }
}
