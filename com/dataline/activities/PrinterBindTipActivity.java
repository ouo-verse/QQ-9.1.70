package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes.dex */
public class PrinterBindTipActivity extends IphoneTitleBarActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private String f32255a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f32256b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f32257c0;

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
        super.doOnCreate(bundle);
        super.getWindow().setBackgroundDrawableResource(R.color.f156897em);
        super.setContentView(R.layout.f168386un);
        super.setTitle(HardCodeUtil.qqStr(R.string.f172314pd1));
        super.setLeftViewName(R.string.amt);
        Button button = (Button) super.findViewById(R.id.a_7);
        this.f32257c0 = button;
        button.setOnClickListener(this);
        this.f32255a0 = super.getIntent().getStringExtra("printer_bind_url");
        this.f32256b0 = r3.getIntExtra("din", 0);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(this.f32255a0)) {
            Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("fromQrcode", true);
            intent.putExtra("url", this.f32255a0);
            super.startActivity(intent);
        }
        super.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
