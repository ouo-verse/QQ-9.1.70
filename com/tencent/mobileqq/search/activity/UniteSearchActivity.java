package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.fragment.UniteSearchFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.util.SearchEnginePerfReporter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.j;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ca;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UniteSearchActivity extends BaseActivity {

    /* renamed from: b0, reason: collision with root package name */
    public static int f282684b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    public static volatile boolean f282685c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public static HotWordSearchEntryDataModel.HotSearchItem f282686d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    public static String f282687e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    public static String f282688f0 = "";

    /* renamed from: g0, reason: collision with root package name */
    public static String f282689g0 = "";

    /* renamed from: h0, reason: collision with root package name */
    public static String f282690h0;

    /* renamed from: a0, reason: collision with root package name */
    private UniteSearchFragment f282691a0;

    private static boolean H2(Context context, int i3) {
        if (AppSetting.t(context) && (i3 == 1 || i3 == 2 || i3 == 21 || i3 == 28)) {
            return true;
        }
        return false;
    }

    public static void I2(Context context, String str, int i3) {
        K2(context, str, i3, null, 0);
    }

    public static void J2(Context context, String str, int i3, int i16, ArrayList<String> arrayList) {
        L2(context, str, i3, null, i16, null, arrayList);
    }

    public static void K2(Context context, String str, int i3, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i16) {
        L2(context, str, i3, hotSearchItem, i16, null, null);
    }

    public static void L2(Context context, String str, int i3, HotWordSearchEntryDataModel.HotSearchItem hotSearchItem, int i16, HotWordSearchEntryDataModel.GIFInfo gIFInfo, ArrayList<String> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "fromType:" + i3);
        }
        if (i3 == 12) {
            ReportController.o(null, "CliOper", "", "", "0X8006501", "0X8006501", i3, 0, "1", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8005021", "0X8005021", i3, 0, "1", "", "", "");
        }
        f282684b0 = i3;
        Intent intent = new Intent(context, (Class<?>) UniteSearchActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        intent.putExtra("source", i16);
        intent.putExtra("home_hot_word", hotSearchItem);
        intent.putExtra("home_gif_info", gIFInfo);
        if (arrayList != null && !arrayList.isEmpty()) {
            intent.putStringArrayListExtra("home_hint_words", arrayList);
        }
        if (H2(context, i3)) {
            UniteSearchFragment.startPadLogic(context, intent.getExtras());
        } else {
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, R.anim.f155053hw);
            }
        }
        SearchUtils.V0("search", "tab", "searchbar", 0, 0, SearchUtils.b0(i3));
    }

    public void F2(String str, boolean z16, boolean z17) {
        UniteSearchFragment uniteSearchFragment = this.f282691a0;
        if (uniteSearchFragment != null) {
            uniteSearchFragment.changeText(str, z16, z17);
        }
    }

    public UniteSearchFragment G2() {
        return this.f282691a0;
    }

    public void M2(int i3, String str) {
        UniteSearchFragment uniteSearchFragment = this.f282691a0;
        if (uniteSearchFragment == null) {
            return;
        }
        uniteSearchFragment.setResultSourceType(i3);
        this.f282691a0.setHotSearchKeyWord(str);
        this.f282691a0.changeText(str, true, false);
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
        UniteSearchFragment uniteSearchFragment = this.f282691a0;
        if (uniteSearchFragment == null || !uniteSearchFragment.finish()) {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        y.f();
        getWindow().setSoftInputMode(16);
        getWindow().getDecorView().setSystemUiVisibility(1024);
        this.mActNeedImmersive = !j.g();
        ca.a(this);
        super.doOnCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.root);
        setContentView(frameLayout);
        this.f282691a0 = UniteSearchFragment.newInstance(this, getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.root, this.f282691a0).show(this.f282691a0).commitAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        f282684b0 = -1;
        SearchEnginePerfReporter.r();
    }

    public int getCurrentPageType() {
        UniteSearchFragment uniteSearchFragment = this.f282691a0;
        if (uniteSearchFragment != null) {
            return uniteSearchFragment.getCurrentPageType();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
