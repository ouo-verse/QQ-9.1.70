package com.tencent.mobileqq.picbrowser;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.common.galleryactivity.e;
import com.tencent.common.galleryactivity.f;
import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class PicBrowserActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected int f258890a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f258891b0;

    /* renamed from: c0, reason: collision with root package name */
    protected ArrayList<PicInfo> f258892c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f258893d0;

    /* renamed from: e0, reason: collision with root package name */
    protected ImmersiveTitleBar2 f258894e0;

    /* renamed from: f0, reason: collision with root package name */
    public GalleryManager f258895f0;

    /* loaded from: classes16.dex */
    class a extends GalleryManager {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicBrowserActivity.this);
            }
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.a d(Activity activity, e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.common.galleryactivity.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) eVar);
            }
            return super.d(activity, eVar);
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.c g(Activity activity, e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.common.galleryactivity.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) eVar);
            }
            return new b((PicBrowserActivity) activity, eVar);
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public e h(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            }
            PicBrowserActivity picBrowserActivity = PicBrowserActivity.this;
            c cVar = new c(picBrowserActivity, picBrowserActivity.f258892c0);
            cVar.a(PicBrowserActivity.this.f258890a0);
            return cVar;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public f i(Activity activity, e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) eVar);
            }
            return null;
        }
    }

    public PicBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258893d0 = "";
            this.f258895f0 = new a();
        }
    }

    public void F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f258894e0.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!this.f258895f0.o()) {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = true;
        super.doOnCreate(bundle);
        setContentView(R.layout.axx);
        initViews();
        initData();
        this.f258895f0.q(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnDestroy();
            this.f258895f0.r(this);
        }
    }

    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (!this.f258895f0.s(i3, keyEvent)) {
            return super.doOnKeyDown(i3, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            AbstractVideoImage.pauseAll();
            this.f258895f0.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            AbstractVideoImage.resumeAll();
            this.f258895f0.u();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (z16) {
            this.f258895f0.v(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f258890a0 = getIntent().getIntExtra("intent_param_index", 0);
        this.f258892c0 = getIntent().getParcelableArrayListExtra("intent_param_pic_infos");
        this.f258891b0 = getIntent().getBooleanExtra("report_visited_pic", false);
    }

    protected void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ImmersiveTitleBar2 immersiveTitleBar2 = (ImmersiveTitleBar2) findViewById(R.id.jq6);
        this.f258894e0 = immersiveTitleBar2;
        immersiveTitleBar2.setVisibility(0);
        ImmersiveUtils.setStatusBarDarkMode(getWindow(), ThemeUtil.isNowThemeIsDefault(this.app, false, null));
        this.f258894e0.setBackgroundColor(getResources().getColor(R.color.black));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
