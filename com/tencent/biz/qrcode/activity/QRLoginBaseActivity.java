package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QRLoginBaseActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    protected ImageView f94758a0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QRLoginBaseActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends DefaultActivityModuleProvider {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a extends SystemBarActivityModule {
            a() {
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void setImmersiveStatus() {
                if (QRLoginBaseActivity.this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
                    QRLoginBaseActivity.this.getWindow().addFlags(67108864);
                    QRLoginBaseActivity qRLoginBaseActivity = QRLoginBaseActivity.this;
                    if (qRLoginBaseActivity.mActNeedImmersive) {
                        int color = qRLoginBaseActivity.getResources().getColor(R.color.skin_color_title_immersive_bar);
                        if (this.mSystemBarComp == null) {
                            this.mSystemBarComp = new SystemBarCompact((Activity) this.activity, true, color);
                            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
                                this.mSystemBarComp.setStatusDrawable(QRLoginBaseActivity.this.getResources().getDrawable(R.drawable.bg_texture));
                            } else {
                                this.mSystemBarComp.setStatusDrawable(null);
                            }
                        }
                    }
                    if (!QRLoginBaseActivity.this.isInMultiWindow()) {
                        ImmersiveUtils.clearCoverForStatus(QRLoginBaseActivity.this.getWindow(), QRLoginBaseActivity.this.isClearCoverLayer);
                    }
                }
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            return new a();
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
        initUI();
        hideTitleBar();
        ImageView imageView = (ImageView) super.findViewById(R.id.lpm);
        this.f94758a0 = imageView;
        imageView.setContentDescription(getText(R.string.button_back));
        this.f94758a0.setOnClickListener(new a());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        boolean z16 = false;
        if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null) && !ThemeUtil.isGoldenTheme()) {
            z16 = true;
        }
        if (z16) {
            ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        return new b();
    }

    protected abstract void initUI();

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
