package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes18.dex */
public class PublicAcntSearchActivity extends BaseSearchActivity {

    /* renamed from: n0, reason: collision with root package name */
    static int f282683n0 = -1;

    public static void P2(Context context, String str, int i3) {
        f282683n0 = i3;
        Intent intent = new Intent(context, (Class<?>) PublicAcntSearchActivity.class);
        intent.putExtra("keyword", str);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String J2() {
        if (f282683n0 == 12) {
            return HardCodeUtil.qqStr(R.string.plo) + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((AppInterface) getAppRuntime(), getApplicationContext());
        }
        return HardCodeUtil.qqStr(R.string.pn9);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected BaseSearchFragment K2() {
        return PublicAcntSearchFragment.Ah(f282683n0);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
