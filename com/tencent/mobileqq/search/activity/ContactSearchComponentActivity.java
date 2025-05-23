package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ContactSearchComponentActivity extends ContactSearchActivity {

    /* renamed from: t0, reason: collision with root package name */
    private static long f282670t0;

    /* renamed from: r0, reason: collision with root package name */
    private int f282671r0;

    /* renamed from: s0, reason: collision with root package name */
    String f282672s0 = "";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Activity activity;
            if (motionEvent.getAction() == 1 && TextUtils.isEmpty(((BaseSearchActivity) ContactSearchComponentActivity.this).f282782a0) && (activity = ContactSearchComponentActivity.this.getActivity()) != null) {
                activity.finish();
                return false;
            }
            return false;
        }
    }

    private void T2() {
        VideoReport.addToDetectionWhitelist(this);
        if (this.f282671r0 != 23) {
            return;
        }
        Z2();
    }

    private void U2(TextView textView) {
        if (this.f282671r0 != 23) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("search_query", "");
        com.tencent.mobileqq.troop.dtreport.a.f(textView, "em_cancel_button", hashMap);
    }

    public static void V2(Activity activity, String str, int i3, int i16, int i17) {
        W2(activity, str, i3, i16, i17, -1L);
    }

    public static void W2(Activity activity, String str, int i3, int i16, int i17, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f282670t0 < 1500) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
                return;
            }
            return;
        }
        f282670t0 = currentTimeMillis;
        Intent intent = new Intent(activity, (Class<?>) ContactSearchComponentActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        intent.putExtra("contactSearchSource", i16);
        if (j3 > 0) {
            intent.putExtra("contactSearchResultFilterType", j3);
        }
        activity.startActivityForResult(intent, i17);
        activity.overridePendingTransition(0, 0);
    }

    public static void Y2(Activity activity, String str, String str2, int i3, int i16, int i17, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f282670t0 < 1500) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
                return;
            }
            return;
        }
        f282670t0 = currentTimeMillis;
        Intent intent = new Intent(activity, (Class<?>) ContactSearchComponentActivity.class);
        intent.putExtra("keyword", str);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        intent.putExtra("contactSearchSource", i16);
        intent.putExtra("specifiedTroopUin", str2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, i17);
        activity.overridePendingTransition(0, 0);
    }

    private void Z2() {
        VideoReport.setPageId(this.f282788g0, "pg_group_batchadd_search_results");
        VideoReport.setPageParams(this.f282788g0, "group_id", this.f282672s0);
        VideoReport.setPageReportPolicy(this.f282788g0, PageReportPolicy.REPORT_ALL);
    }

    private void b3(TextView textView, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("search_query", str);
        VideoReport.setElementParams(textView, hashMap);
    }

    @Override // com.tencent.mobileqq.search.activity.ContactSearchActivity, com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected BaseSearchFragment K2() {
        this.f282671r0 = getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, -1);
        int intExtra = getIntent().getIntExtra("contactSearchSource", 100860733);
        String stringExtra = getIntent().getStringExtra("specifiedTroopUin");
        ArrayList arrayList = new ArrayList();
        int i3 = this.f282671r0;
        if (i3 != 7 && i3 != 6 && i3 != 23) {
            return super.K2();
        }
        arrayList.add(AppConstants.BABY_Q_UIN);
        return (ContactSearchFragment) ContactSearchFragment.yh(this.f282671r0, intExtra, stringExtra, arrayList, null, 0, getIntent().getLongExtra("contactSearchResultFilterType", -1L), true, false, null);
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity
    protected void M2(String str) {
        QUISearchBar qUISearchBar = this.f282783b0;
        if (qUISearchBar != null && this.f282671r0 == 23) {
            b3(qUISearchBar.getCancelView(), str);
        }
    }

    @Override // com.tencent.mobileqq.search.base.activity.BaseSearchActivity, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);
        Z2();
    }

    @Override // com.tencent.mobileqq.search.activity.ContactSearchActivity, com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.search.activity.ContactSearchActivity, com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        ca.a(this);
        super.doOnCreate(bundle);
        this.f282672s0 = getIntent().getStringExtra("specifiedTroopUin");
        T2();
        this.f282783b0.updateStyle(2);
        this.f282783b0.bindSearchChain(1002, true);
        findViewById(R.id.ijj).setOnTouchListener(new a());
        U2(this.f282783b0.getCancelView());
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.search.activity.ContactSearchActivity, com.tencent.mobileqq.search.base.activity.BaseSearchActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
