package com.tencent.hippy.qq.preload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ThemeChangedReceiver {
    private static final String ACTION_THEME_CHANGED = "com.tencent.qplus.THEME_INVALIDATE";
    private static final String BROADCAST_PERMISSION = "com.tencent.msg.permission.pushnotify";
    private Listener listener;
    private BroadcastReceiver themeChangeReceiver = new BroadcastReceiver() { // from class: com.tencent.hippy.qq.preload.ThemeChangedReceiver.1
        static final String EXTRA_PROCESS_ID = "pid";

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int myPid = Process.myPid();
            if (intent.getIntExtra("pid", myPid) == myPid && ThemeChangedReceiver.this.listener != null) {
                ThemeChangedReceiver.this.listener.onThemeChanged();
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface Listener {
        void onThemeChanged();
    }

    public ThemeChangedReceiver() {
        BaseApplication.getContext().registerReceiver(this.themeChangeReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
    }

    public void destroy() {
        this.listener = null;
        BaseApplication.getContext().unregisterReceiver(this.themeChangeReceiver);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
