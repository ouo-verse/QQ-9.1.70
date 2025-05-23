package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVLoadingDialogActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    final String f74714a0;

    /* renamed from: b0, reason: collision with root package name */
    Handler f74715b0;

    /* renamed from: c0, reason: collision with root package name */
    BroadcastReceiver f74716c0 = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH")) {
                AVLoadingDialogActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final String f74718a;

        b(String str) {
            this.f74718a = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference;
            WeakReference weakReference2;
            Object obj;
            Object obj2 = message.obj;
            if (obj2 != null && (obj2 instanceof WeakReference) && (weakReference2 = (WeakReference) obj2) != null && (obj = weakReference2.get()) != null && (obj instanceof AVLoadingDialogActivity)) {
                weakReference = new WeakReference((AVLoadingDialogActivity) obj);
            } else {
                weakReference = null;
            }
            if (message.what == 1 && weakReference != null && weakReference.get() != null) {
                ((AVLoadingDialogActivity) weakReference.get()).finish();
            }
        }
    }

    public AVLoadingDialogActivity() {
        String str = "AVLoadingDialogActivity_" + com.tencent.av.utils.e.d();
        this.f74714a0 = str;
        this.f74715b0 = new b(str);
    }

    Dialog F2() {
        ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f168383uh);
        reportDialog.setCancelable(false);
        TextView textView = (TextView) reportDialog.findViewById(R.id.photo_prievew_progress_dialog_text);
        if (textView != null) {
            textView.setText(R.string.dkl);
        }
        return reportDialog;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Bundle bundle2;
        boolean doOnCreate = super.doOnCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
        registerReceiver(this.f74716c0, intentFilter);
        QLog.d(this.f74714a0, 1, "avideo doOnCreate");
        Intent intent = getIntent();
        String str = this.f74714a0 + ".doOnCreate";
        if (intent != null) {
            bundle2 = intent.getExtras();
        } else {
            bundle2 = null;
        }
        com.tencent.av.utils.e.m(str, bundle2);
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        QLog.d(this.f74714a0, 1, "doOnDestroy");
        this.f74715b0.removeMessages(0);
        this.f74715b0.removeMessages(1);
        unregisterReceiver(this.f74716c0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        QLog.d(this.f74714a0, 1, "doOnResume");
        showDialog(0);
        WeakReference weakReference = new WeakReference(this);
        Message message = new Message();
        message.what = 1;
        message.obj = weakReference;
        this.f74715b0.sendMessageDelayed(message, 10000L);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        if (i3 != 0) {
            return null;
        }
        return F2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
