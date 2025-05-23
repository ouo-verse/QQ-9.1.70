package com.tencent.mobileqq.search.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ca;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageSearchDetailActivity extends IphoneTitleBarActivity {

    /* renamed from: c0, reason: collision with root package name */
    private static FullMessageSearchResult.SearchResultItem f282674c0;

    /* renamed from: a0, reason: collision with root package name */
    private FullMessageSearchResult.SearchResultItem f282675a0;

    /* renamed from: b0, reason: collision with root package name */
    protected CancelReceiver f282676b0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class CancelReceiver extends BroadcastReceiver {
        public CancelReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.mobileqq.search.cancel".equals(intent.getAction())) {
                MessageSearchDetailActivity.this.finish();
            }
        }
    }

    public static void H2(Context context, String str, FullMessageSearchResult.SearchResultItem searchResultItem) {
        f282674c0 = searchResultItem;
        Intent intent = new Intent(context, (Class<?>) MessageSearchDetailActivity.class);
        intent.putExtra("keyword", str);
        context.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d1, code lost:
    
        if (r9.length() <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
    
        r13 = r9 + "\u2026";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void G2(String str, String str2, TextView textView) {
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageSearchDetailActivity", 2, "genDiscussTitle, name == null");
                return;
            }
            return;
        }
        int q16 = ((n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(str2);
        if (q16 <= 0) {
            textView.setText(str);
            return;
        }
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int f16 = i3 - BaseAIOUtils.f(207.0f, getResources());
        TextPaint paint = textView.getPaint();
        float measureText = (f16 - paint.measureText(String.format("(%d\u4eba)", Integer.valueOf(q16)))) - (getResources().getDisplayMetrics().density * 4.0f);
        if (measureText > 0.0f) {
            float measureText2 = paint.measureText(str);
            if (measureText2 > measureText) {
                float measureText3 = measureText - paint.measureText("\u2026");
                String str3 = str;
                while (measureText3 > 0.0f && measureText2 > measureText3 && str3.length() > 0) {
                    str3 = str3.substring(0, str3.length() - 1);
                    measureText2 = paint.measureText(str3);
                    if (measureText2 == 0.0f && str3.length() > 0) {
                        measureText2 = 1.0f + measureText3;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MessageSearchDetailActivity", 2, "genDiscussTitle : name widht = " + measureText2);
                    }
                }
            }
        }
        textView.setText(String.format("%s(%d\u4eba)", str, Integer.valueOf(q16)));
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        ca.a(this);
        super.doOnCreate(bundle);
        FullMessageSearchResult.SearchResultItem searchResultItem = f282674c0;
        this.f282675a0 = searchResultItem;
        if (searchResultItem == null) {
            finish();
            return false;
        }
        super.setContentView(R.layout.f167784he);
        if (this.f282675a0.user.getType() == 3000) {
            QQAppInterface qQAppInterface = this.app;
            RecentUser recentUser = this.f282675a0.user;
            G2(ac.Q(qQAppInterface, recentUser.uin, recentUser.getType()), this.f282675a0.user.uin, this.centerView);
        } else {
            QQAppInterface qQAppInterface2 = this.app;
            RecentUser recentUser2 = this.f282675a0.user;
            super.setTitle(ac.Q(qQAppInterface2, recentUser2.uin, recentUser2.getType()));
        }
        FragmentManager supportFragmentManager = super.getSupportFragmentManager();
        MessageSearchDetailFragment qh5 = MessageSearchDetailFragment.qh(getIntent().getStringExtra("keyword"), this.f282675a0);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.b9v, qh5);
        beginTransaction.commit();
        this.f282676b0 = new CancelReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.search.cancel");
        super.registerReceiver(this.f282676b0, intentFilter);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        CancelReceiver cancelReceiver = this.f282676b0;
        if (cancelReceiver != null) {
            super.unregisterReceiver(cancelReceiver);
            this.f282676b0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
