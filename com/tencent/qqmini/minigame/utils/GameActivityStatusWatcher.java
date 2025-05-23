package com.tencent.qqmini.minigame.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameActivityStatusWatcher {
    static final String TAG = "GameActivityStatusWatcher";
    private WeakReference<Context> mContextRef;
    private IntentFilter mFilter;
    private OnWatcherActionListener mListener;
    private InnerRecevier mRecevier;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class InnerRecevier extends BroadcastReceiver {
        public static final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
        public static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        public static final String SYSTEM_DIALOG_REASON_KEY = "reason";
        public static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

        InnerRecevier() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (MiniAppMonitorInfoView.ACTION_SHOW_MONITOR_VIEW.equals(action)) {
                GameActivityStatusWatcher.this.mListener.onShowMonitorView(intent.getBooleanExtra("show", true));
            }
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) && (stringExtra = intent.getStringExtra("reason")) != null && GameActivityStatusWatcher.this.mListener != null) {
                if (stringExtra.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    GameActivityStatusWatcher.this.mListener.onHomePressed();
                } else if (stringExtra.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                    GameActivityStatusWatcher.this.mListener.onRecentTaskPressed();
                }
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) && GameActivityStatusWatcher.this.mListener != null) {
                GameActivityStatusWatcher.this.mListener.onScreenOff();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnWatcherActionListener {
        void onHomePressed();

        void onRecentTaskPressed();

        void onScreenOff();

        void onShowMonitorView(boolean z16);
    }

    public GameActivityStatusWatcher(Context context) {
        this.mContextRef = new WeakReference<>(context);
        IntentFilter intentFilter = new IntentFilter();
        this.mFilter = intentFilter;
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.mFilter.addAction(MiniAppMonitorInfoView.ACTION_SHOW_MONITOR_VIEW);
        this.mFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setOnHomePressedListener(OnWatcherActionListener onWatcherActionListener) {
        this.mListener = onWatcherActionListener;
        this.mRecevier = new InnerRecevier();
    }

    public void startWatch() {
        Context context;
        if (this.mRecevier != null && (context = getContext()) != null) {
            context.registerReceiver(this.mRecevier, this.mFilter);
        }
    }

    public void stopWatch() {
        Context context;
        if (this.mRecevier != null && (context = getContext()) != null) {
            context.unregisterReceiver(this.mRecevier);
        }
    }
}
