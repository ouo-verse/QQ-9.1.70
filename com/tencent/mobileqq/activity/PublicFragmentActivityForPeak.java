package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.activity.result.ActivityResultCaller;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class PublicFragmentActivityForPeak extends PublicFragmentActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name */
    private ArrayList<WeakReference<en>> f176718d0;

    public PublicFragmentActivityForPeak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void start(Context context, Intent intent, Class<? extends PublicBaseFragment> cls) {
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForPeak.class, cls);
    }

    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        en enVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ActivityResultCaller G2 = super.G2();
        if (G2 instanceof en) {
            if (this.f176718d0 == null) {
                this.f176718d0 = new ArrayList<>(2);
            }
            this.f176718d0.add(new WeakReference<>((en) G2));
        }
        ArrayList<WeakReference<en>> arrayList = this.f176718d0;
        if (arrayList != null) {
            Iterator<WeakReference<en>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<en> next = it.next();
                if (next != null && (enVar = next.get()) != null) {
                    enVar.onBackPressed();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        return super.doOnCreate(bundle);
    }

    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
