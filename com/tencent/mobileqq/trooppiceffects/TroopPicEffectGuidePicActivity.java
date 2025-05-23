package com.tencent.mobileqq.trooppiceffects;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

/* loaded from: classes19.dex */
public class TroopPicEffectGuidePicActivity extends BaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected ImageButton f303265a0;

    /* renamed from: b0, reason: collision with root package name */
    protected ImageButton f303266b0;

    /* renamed from: c0, reason: collision with root package name */
    protected URLImageView f303267c0;

    /* renamed from: d0, reason: collision with root package name */
    protected ImageView f303268d0;

    /* loaded from: classes19.dex */
    class a extends DefaultActivityModuleProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        class C8847a extends SystemBarActivityModule {
            static IPatchRedirector $redirector_;

            C8847a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void setImmersiveStatus() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (TroopPicEffectGuidePicActivity.this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
                    TroopPicEffectGuidePicActivity.this.getWindow().addFlags(67108864);
                    if (TroopPicEffectGuidePicActivity.this.mActNeedImmersive && this.mSystemBarComp == null) {
                        this.mSystemBarComp = new SystemBarCompact((Activity) this.activity, true, 0);
                    }
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPicEffectGuidePicActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IActivityModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new C8847a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPicEffectGuidePicActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.5f);
                return false;
            }
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
    }

    public TroopPicEffectGuidePicActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void F2(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            view.setOnTouchListener(new b());
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.c26);
        this.f303265a0 = (ImageButton) findViewById(R.id.k0y);
        this.f303266b0 = (ImageButton) findViewById(R.id.k0z);
        this.f303267c0 = (URLImageView) findViewById(R.id.f167019k10);
        this.f303268d0 = (ImageView) findViewById(R.id.f167021k12);
        this.f303265a0.setOnClickListener(this);
        this.f303266b0.setOnClickListener(this);
        F2(this.f303265a0);
        F2(this.f303266b0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        this.f303267c0.setImageDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_effect_pic_preview_img.png", obtain));
        this.f303267c0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = getResources().getDrawable(R.drawable.h7i);
        obtain2.mFailedDrawable = drawable;
        obtain2.mLoadingDrawable = drawable;
        this.f303265a0.setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_button.png", obtain2));
        URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable2 = new ColorDrawable(0);
        obtain3.mFailedDrawable = colorDrawable2;
        obtain3.mLoadingDrawable = colorDrawable2;
        this.f303268d0.setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_wording.png", obtain3));
        com.tencent.mobileqq.trooppiceffects.a.a("app_entry_guide", "page_exp");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IActivityModuleProvider) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view == this.f303265a0) {
            TroopPicEffectsEditActivity.K2(this, getIntent().getStringExtra("friendUin"), getIntent().getStringExtra("troopUin"));
            finish();
        } else if (view == this.f303266b0) {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
