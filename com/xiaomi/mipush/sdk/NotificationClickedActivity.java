package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.xiaomi.push.ie;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class NotificationClickedActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f388004a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f24703a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            jz4.c.w("clicked activity finish by normal.");
            NotificationClickedActivity.this.finish();
        }
    }

    private void a(Intent intent) {
        try {
            if (intent != null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    jz4.c.n("PushClickedActivity", "clicked activity start service.");
                    startService(intent2);
                } else {
                    jz4.c.C("PushClickedActivity", "clicked activity start service, newIntent is null");
                }
            } else {
                jz4.c.C("PushClickedActivity", "clicked activity start service, missing intent");
            }
        } catch (Exception e16) {
            jz4.c.q(e16);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 8388659;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f24703a = handler;
        handler.postDelayed(new Runnable() { // from class: com.xiaomi.mipush.sdk.NotificationClickedActivity.1
            @Override // java.lang.Runnable
            public void run() {
                jz4.c.D("clicked activity finish by timeout.");
                NotificationClickedActivity.this.finish();
            }
        }, 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        a aVar = new a();
        this.f388004a = aVar;
        try {
            ie.d(this, aVar, intentFilter, t.a(this), null, 4);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f24703a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.f388004a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a(getIntent());
    }
}
