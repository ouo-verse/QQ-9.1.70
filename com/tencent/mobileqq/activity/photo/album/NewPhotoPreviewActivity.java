package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.ca;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

@RoutePage(desc = "\u76f8\u518c\u56fe\u7247\u9884\u89c8\u9875\u9762", path = IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI)
@Deprecated
/* loaded from: classes10.dex */
public class NewPhotoPreviewActivity extends BasePhotoPreviewActivity {
    static IPatchRedirector $redirector_;

    /* loaded from: classes10.dex */
    class a extends DefaultActivityModuleProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C7190a extends SystemBarActivityModule {
            static IPatchRedirector $redirector_;

            C7190a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void initNavigationBarColor() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.theme.a.e(NewPhotoPreviewActivity.this.getWindow(), -16777216);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewPhotoPreviewActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IActivityModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new C7190a();
        }
    }

    public NewPhotoPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity, com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQAlbum", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + i3 + "  resultCode:" + i16 + "  ok:-1");
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.initLiuHaiProperty(this);
        if (LiuHaiUtils.needCloseFullScreen()) {
            LiuHaiUtils.closeFullScreen(this);
        }
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        boolean doOnCreate = super.doOnCreate(bundle);
        this.mPhotoPreviewCustomization.v().mRoot.setFitsSystemWindows(true);
        ca.a(this);
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.popup;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnPause();
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.finish();
        if (((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("historicalFunctionalityBug_8_9_25")) {
            QAlbumUtil.anim(this, true, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity
    public com.tencent.mobileqq.activity.photo.album.preview.e<? extends OtherCommonData> generateCustomization() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.activity.photo.album.preview.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int intExtra = getIntent().getIntExtra(IPhotoLogicFactory.ENTER_FROM, 0);
        com.tencent.mobileqq.activity.photo.album.preview.e<? extends OtherCommonData> createPhotoPreviewLogic = ((IPhotoLogicFactory) QRoute.api(IPhotoLogicFactory.class)).createPhotoPreviewLogic(this, getIntent());
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "generateLogic:" + createPhotoPreviewLogic.getClass().getName() + " enterFrom:" + intExtra);
        }
        return createPhotoPreviewLogic;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IActivityModuleProvider) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity
    Class getPhotoListActivityClass() {
        return NewPhotoListActivity.class;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity
    void initSelectedPhotoAdapter(PhotoPreviewCustomizationDefault photoPreviewCustomizationDefault, ArrayList<String> arrayList) {
        f fVar = new f(photoPreviewCustomizationDefault);
        this.selectedPhotoAdapter = fVar;
        fVar.setData(arrayList);
        HorizontalListView horizontalListView = this.selectedPhotoListView;
        if (horizontalListView != null) {
            horizontalListView.setAdapter((ListAdapter) fVar);
            this.selectedPhotoListView.setOnItemClickListener(fVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.BasePhotoPreviewActivity, com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
