package com.tencent.qqmini.sdk.core.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ScreenOffOnListener {
    private static volatile ScreenOffOnListener instance;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!StringUtil.isEmpty(intent.getAction()) && ScreenOffOnListener.this.receiveListener != null) {
                ScreenOffOnListener.this.receiveListener.onReceiveListener(context, intent);
            }
        }
    };
    private ReceiveListener receiveListener;

    /* compiled from: P */
    /* loaded from: classes23.dex */
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
        AppLoaderFactory.g().getContext().registerReceiver(this.mReceiver, intentFilter);
    }

    public void unRegistListener() {
        if (this.mReceiver != null && this.receiveListener != null) {
            AppLoaderFactory.g().getContext().unregisterReceiver(this.mReceiver);
            this.receiveListener = null;
        }
    }
}
