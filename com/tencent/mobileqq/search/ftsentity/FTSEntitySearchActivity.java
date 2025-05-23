package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ep2.e;
import vy2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FTSEntitySearchActivity extends BaseSearchActivity {

    /* renamed from: n0, reason: collision with root package name */
    static String f283227n0;

    public static void P2(Context context, String str, int i3) {
        f283227n0 = str;
        Intent intent = new Intent(context, (Class<?>) FTSEntitySearchActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra("extra_key_fts_type", i3);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String I2() {
        return String.valueOf(13);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String J2() {
        return e.d(this, this.f282787f0);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected BaseSearchFragment K2() {
        return FTSEntitySearchFragment.uh(f283227n0);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnStart() {
        super.doOnStart();
        b.a.f443728q = true;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
