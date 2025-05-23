package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public abstract class BasePhotoPreviewActivity extends AbstractPhotoPreviewActivity {
    static IPatchRedirector $redirector_;
    public boolean enableLiuHai;
    public BubblePopupWindow popup;
    public BaseAdapter selectedPhotoAdapter;
    public View selectedPhotoListDivider;
    public HorizontalListView selectedPhotoListView;

    public BasePhotoPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Class getPhotoListActivityClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void initSelectedPhotoAdapter(PhotoPreviewCustomizationDefault photoPreviewCustomizationDefault, ArrayList<String> arrayList);

    @Override // com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity, com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
