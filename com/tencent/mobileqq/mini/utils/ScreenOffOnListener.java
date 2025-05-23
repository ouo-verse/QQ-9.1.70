package com.tencent.mobileqq.mini.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ScreenOffOnListener {
    private static volatile ScreenOffOnListener instance;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.mini.utils.ScreenOffOnListener.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (StringUtil.isEmpty(intent.getAction()) || ScreenOffOnListener.this.receiveListener == null) {
                return;
            }
            ScreenOffOnListener.this.receiveListener.onReceiveListener(context, intent);
        }
    };
    private ReceiveListener receiveListener;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface ReceiveListener {
        void onReceiveListener(Context context, Intent intent);
    }

    ScreenOffOnListener() {
    }

    public static ScreenOffOnListener getInstance() {
        if (instance == null) {
            synchronized (ScreenOffOnListener.class) {
                if (instance == null) {
                    instance = new ScreenOffOnListener();
                }
            }
        }
        return instance;
    }

    public void registListener(ReceiveListener receiveListener) {
        this.receiveListener = receiveListener;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        BaseApplication.getContext().registerReceiver(this.mReceiver, intentFilter);
    }

    public void unRegistListener() {
        if (this.mReceiver == null || this.receiveListener == null) {
            return;
        }
        BaseApplication.getContext().unregisterReceiver(this.mReceiver);
        this.receiveListener = null;
    }
}
