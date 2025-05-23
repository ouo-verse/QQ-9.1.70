package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public abstract class BasePhotoListActivity extends AbstractPhotoListActivity {
    static IPatchRedirector $redirector_;
    public TextView imgCountTipsTv;
    public TextView magicStickBtn;
    public TextView previewTv;
    public CheckBox qualityCheckBox;
    public TextView qualityCountTv;
    public TextView qualityTv;

    public BasePhotoListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void dispatchTakePictureIntent();

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Class getPreviewActivityClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract b newPhotoListHandler(com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract c newPhotoViewHelper(PhotoListSceneBase photoListSceneBase);

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
