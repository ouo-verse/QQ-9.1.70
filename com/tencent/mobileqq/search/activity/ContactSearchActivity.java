package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ContactSearchActivity extends BaseSearchActivity {

    /* renamed from: n0, reason: collision with root package name */
    private int f282666n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f282667o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f282668p0;

    /* renamed from: q0, reason: collision with root package name */
    private IPerformanceReportTask f282669q0;

    @NonNull
    private static IPerformanceReportTask P2(String str, int i3, int i16, int i17, boolean z16) {
        IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_local_info_more_page");
        a16.setParam("keyword", str);
        a16.setParam(IProfileCardConst.KEY_FROM_TYPE, i3 + "");
        a16.setParam(ForwardRecentActivity.KEY_SEARCH_SOURCE, i16 + "");
        a16.setParam("combineType", i17 + "");
        if (z16) {
            a16.setParam("useNt", "1");
        }
        return a16;
    }

    public static void Q2(Context context, String str, int i3, int i16, int i17) {
        IPerformanceReportTask P2 = P2(str, i3, i16, i17, false);
        Intent intent = new Intent(context, (Class<?>) ContactSearchActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        intent.putExtra("contactSearchSource", i16);
        intent.putExtra("ContactCombineType", i17);
        qw1.b.r(intent, P2);
        context.startActivity(intent);
    }

    public static void R2(Context context, String str, int i3, int i16, int i17) {
        IPerformanceReportTask P2 = P2(str, i3, i16, i17, true);
        Intent intent = new Intent(context, (Class<?>) ContactSearchActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        intent.putExtra("contactSearchSource", i16);
        intent.putExtra("ContactCombineType", i17);
        intent.putExtra("BUNDLE_KEY_USE_NT_SEARCH_ENGINE", true);
        qw1.b.r(intent, P2);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String I2() {
        String valueOf = String.valueOf(0);
        int i3 = this.f282668p0;
        if (i3 == 1) {
            return String.valueOf(6);
        }
        if (i3 == 2) {
            return String.valueOf(7);
        }
        if (i3 == 3) {
            return String.valueOf(22);
        }
        return valueOf;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected String J2() {
        int i3 = this.f282668p0;
        if (i3 == 2) {
            return HardCodeUtil.qqStr(R.string.f20670591);
        }
        if (i3 != 1 && this.f282666n0 != 100860733) {
            return HardCodeUtil.qqStr(R.string.l3g);
        }
        return HardCodeUtil.qqStr(R.string.f171802l30);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    public BaseSearchFragment K2() {
        ContactSearchFragment contactSearchFragment = (ContactSearchFragment) ContactSearchFragment.yh(this.f282667o0, this.f282666n0, null, null, null, this.f282668p0, -1L, true, false, null);
        boolean booleanExtra = getIntent().getBooleanExtra("BUNDLE_KEY_USE_NT_SEARCH_ENGINE", false);
        if (contactSearchFragment.getArguments() != null) {
            contactSearchFragment.getArguments().putBoolean("BUNDLE_KEY_USE_NT_SEARCH_ENGINE", booleanExtra);
            if (this.f282669q0 != null) {
                qw1.b.t(contactSearchFragment.getArguments(), this.f282669q0, "_extra_param_report_task");
            }
        }
        return contactSearchFragment;
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        if (i3 == 1300 && -1 == i16 && intent != null && (stringExtra = intent.getStringExtra("roomId")) != null) {
            TroopUtils.e(this, stringExtra, true);
            ReportController.o(getAppRuntime(), "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.f282789h0 = true;
        this.f282667o0 = getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, -1);
        this.f282666n0 = getIntent().getIntExtra("contactSearchSource", 100860733);
        this.f282668p0 = getIntent().getIntExtra("ContactCombineType", 0);
        this.f282669q0 = qw1.b.e(getIntent());
        super.doOnCreate(bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
