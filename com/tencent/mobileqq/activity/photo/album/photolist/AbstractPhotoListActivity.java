package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class AbstractPhotoListActivity extends PeakFragmentActivity {
    static IPatchRedirector $redirector_ = null;
    static final String SHARE_PREFERENCE_NAME = "share";
    public static final String TAG = "QQAlbum";
    public f<? extends OtherCommonData> mPhotoListCustomization;

    public AbstractPhotoListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AbstractPhotoListActivity,doOnActivityResult:requestCode = " + i3 + ",resultCode=" + i16);
        }
        this.mPhotoListCustomization.G(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AbstractAlbumListFragment abstractAlbumListFragment = this.mPhotoListCustomization.f184313i.f184276e;
        if (abstractAlbumListFragment != null && !abstractAlbumListFragment.isHidden()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.mPhotoListCustomization.I();
        } else {
            this.mPhotoListCustomization.f184313i.c(false);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "QQAlbum onCreate(),extra is:" + intent.getExtras());
            QLog.d("QQAlbum", 2, "QQAlbum,hashCode is:" + System.identityHashCode(this));
        }
        super.adjustStatusBar();
        f<? extends OtherCommonData> generateCustomization = generateCustomization();
        this.mPhotoListCustomization = generateCustomization;
        generateCustomization.E(intent);
        super.setContentView(this.mPhotoListCustomization.f184313i.n());
        getWindow().setBackgroundDrawable(null);
        this.mPhotoListCustomization.F();
        QLog.i("QQAlbum", 1, "doOnCreate cost\uff1a" + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AbstractPhotoListActivity,doOnDestroy");
        }
        this.mPhotoListCustomization.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        intent.putExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, false);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "QQAlbum onNewIntent() is called,extra is:" + intent.getExtras());
            QLog.d("QQAlbum", 2, "QQAlbumhashCode is:" + System.identityHashCode(this));
            QLog.d("QQAlbum", 2, "onNewIntent()");
        }
        processNewIntent(intent);
        PhotoCommonBaseData<? extends OtherCommonData> photoCommonBaseData = this.mPhotoListCustomization.f184310e;
        String str = photoCommonBaseData.albumName;
        if (str == null) {
            if (photoCommonBaseData.showMediaType == 2) {
                str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
            } else {
                str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            }
        }
        setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnPause();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AbstractPhotoListActivity,doOnPause");
        }
        this.mPhotoListCustomization.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AbstractPhotoListActivity,doOnResume");
        }
        this.mPhotoListCustomization.t();
        QLog.i("QQAlbum", 1, "doOnResume cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finish();
        }
    }

    protected f<? extends OtherCommonData> generateCustomization() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new PhotoListCustomizationBase(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void processNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            setIntent(intent);
            this.mPhotoListCustomization.E(intent);
        }
    }
}
