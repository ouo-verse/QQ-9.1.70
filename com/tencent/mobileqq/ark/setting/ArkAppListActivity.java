package com.tencent.mobileqq.ark.setting;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppListActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    private ViewGroup f199624a0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f199625d;

        a(String str) {
            this.f199625d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent(ArkAppListActivity.this, (Class<?>) ArkAuthorityInfoActivity.class);
            intent.putExtra("intent_extra_authority_app_name", this.f199625d);
            ArkAppListActivity.this.startActivity(intent);
            EventCollector.getInstance().onViewClicked(view);
        }
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
        super.doOnCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setBackgroundResource(R.drawable.bg_texture_theme_version2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, BaseAIOUtils.f(20.0f, getResources()), 0, 0);
        this.f199624a0 = linearLayout;
        String[] stringArrayExtra = getIntent().getStringArrayExtra("intent_extra_authority_app_list");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            for (String str : stringArrayExtra) {
                if (!TextUtils.isEmpty(str)) {
                    FormSimpleItem formSimpleItem = new FormSimpleItem(this);
                    formSimpleItem.setLeftText(str);
                    formSimpleItem.h(true);
                    formSimpleItem.setOnClickListener(new a(str));
                    this.f199624a0.addView(formSimpleItem);
                }
            }
        }
        super.setContentView(this.f199624a0);
        super.setTitle(R.string.f170432qo);
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
