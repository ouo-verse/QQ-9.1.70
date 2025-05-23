package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.TriangleView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;

@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_ALBUM, scene = QQPermissionConstants.Business.SCENE.OPEN_ALBUM)
@RoutePage(desc = "\u76f8\u518c\u56fe\u7247\u5217\u8868\u9875\u9762", path = IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI)
@Deprecated
/* loaded from: classes10.dex */
public class NewPhotoListActivity extends BasePhotoListActivity {
    static IPatchRedirector $redirector_;
    public static String AIO_PAD_ADAPT_STORY;

    /* loaded from: classes10.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewPhotoListActivity.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            AIO_PAD_ADAPT_STORY = "aio_pad_adapt_story";
        }
    }

    public NewPhotoListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doOnConfigurationChanged$0() {
        try {
            com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar = this.mPhotoListCustomization;
            if (((PhotoListCustomizationDefault) fVar).E != null) {
                ((PhotoListCustomizationDefault) fVar).E.a();
            }
            PhotoListSceneBase photoListSceneBase = this.mPhotoListCustomization.f184313i;
            if (photoListSceneBase != null) {
                photoListSceneBase.m(false);
            }
        } catch (Exception e16) {
            QLog.e("QQAlbum", 1, "doOnConfigurationChanged: " + e16);
        }
    }

    private void setUpOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity
    public void dispatchTakePictureIntent() {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            return;
        }
        Intent intent = new Intent();
        try {
            file = this.mPhotoListCustomization.f184313i.k();
        } catch (IOException unused) {
            file = null;
        }
        if (file != null) {
            FileProvider7Helper.setSystemCapture(this, file, intent);
            startActivityForResult(intent, 16);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity, com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnActivityResult-----");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
            return;
        }
        super.doOnConfigurationChanged(configuration);
        if (((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable(AIO_PAD_ADAPT_STORY) && AppSetting.o(this) && (this.mPhotoListCustomization instanceof PhotoListCustomizationDefault)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.d
                @Override // java.lang.Runnable
                public final void run() {
                    NewPhotoListActivity.this.lambda$doOnConfigurationChanged$0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        setUpOrientation();
        long currentTimeMillis = System.currentTimeMillis();
        super.doOnCreate(bundle);
        if (!PermissionUtil.isHasStorageReadAndWritePermission(this)) {
            QQPermissionFactory.getQQPermission(this).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new a());
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnCreate-----" + this);
        }
        com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar = this.mPhotoListCustomization;
        if (fVar != null && fVar.f184313i != null && QQTheme.isNowSimpleUI()) {
            TextView textView = this.mPhotoListCustomization.f184313i.M;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.skin_album_title_color));
            }
            TriangleView triangleView = this.mPhotoListCustomization.f184313i.N;
            if (triangleView != null) {
                triangleView.setColor(getResources().getColor(R.color.skin_album_title_color));
            }
        }
        QLog.i("QQAlbum", 1, "NewPhotoListActivity doOnCreate cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnDestroy-----" + this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnPause();
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnPause-----" + this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnResume-----" + this);
        }
        if (QQTheme.isDefaultTheme() && ImmersiveUtils.isSupporImmersive() == 1 && SystemBarActivityModule.getSystemBarComp(this) != null) {
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(-1);
            ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
        QLog.i("QQAlbum", 1, "NewPhotoListActivity doOnResume cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnStart();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnStart-----" + this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnStop();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----doOnStop-----" + this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity
    public com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> generateCustomization() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int intExtra = getIntent().getIntExtra(IPhotoLogicFactory.ENTER_FROM, 0);
        com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> createPhotoListLogic = ((IPhotoLogicFactory) QRoute.api(IPhotoLogicFactory.class)).createPhotoListLogic(this, getIntent());
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "generateLogic:" + createPhotoListLogic.getClass().getName() + " enterFrom:" + intExtra);
        }
        return createPhotoListLogic;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity
    Class getPreviewActivityClass() {
        return NewPhotoPreviewActivity.class;
    }

    protected boolean handleCaptureResult(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent)).booleanValue();
        }
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(PeakConstants.EXTRA_DIRECTLY_BACK, false);
            boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.IS_VIDEO_RECORDED, false);
            if (booleanExtra) {
                if (booleanExtra2) {
                    this.mPhotoListCustomization.C(intent);
                    return true;
                }
                this.mPhotoListCustomization.B(intent);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity
    b newPhotoListHandler(com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar) {
        return new e(fVar);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity
    c newPhotoViewHelper(PhotoListSceneBase photoListSceneBase) {
        return new com.tencent.mobileqq.activity.photo.albumlogicImp.view.a(photoListSceneBase);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity, com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity
    public void processNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.EXTRA_DIRECTLY_BACK, false);
        if (intent.getIntExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 0) == 7) {
            com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar = this.mPhotoListCustomization;
            fVar.f184312h.f184298i = false;
            fVar.E(intent);
        } else if (booleanExtra) {
            this.mPhotoListCustomization.f184312h.f184298i = false;
            handleCaptureResult(intent);
            QLog.d("QQAlbum", 2, "QQAlbum onNewIntent() camera back");
        } else {
            setIntent(intent);
            this.mPhotoListCustomization.E(intent);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "-----do ProcessNewIntent-----");
        }
    }
}
