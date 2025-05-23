package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SearchTypeDetailActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    private int f207911a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f207912b0;

    /* renamed from: c0, reason: collision with root package name */
    private SparseArray<String> f207913c0 = new SparseArray<>();

    /* renamed from: d0, reason: collision with root package name */
    private List<Integer> f207914d0;

    public static void G2(Context context, int i3, String str, List<Integer> list) {
        Intent intent = new Intent(context, (Class<?>) SearchTypeDetailActivity.class);
        intent.putExtra("qfile_search_param_type", i3);
        intent.putExtra("qfile_search_param_uin", str);
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("qfile_search_param_others", (ArrayList) list);
        intent.putExtra("qfile_search_param_others", bundle);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        this.f207911a0 = super.getIntent().getIntExtra("qfile_search_param_type", -1);
        this.f207912b0 = super.getIntent().getStringExtra("qfile_search_param_uin");
        this.f207914d0 = super.getIntent().getBundleExtra("qfile_search_param_others").getIntegerArrayList("qfile_search_param_others");
        this.f207913c0.put(3, HardCodeUtil.qqStr(R.string.t7r));
        this.f207913c0.put(2, HardCodeUtil.qqStr(R.string.t7v));
        this.f207913c0.put(0, HardCodeUtil.qqStr(R.string.t7u));
        this.f207913c0.put(1, HardCodeUtil.qqStr(R.string.t7t));
        this.f207913c0.put(11, HardCodeUtil.qqStr(R.string.t7s));
        super.setContentView(R.layout.f167784he);
        super.setTitle(this.f207913c0.get(this.f207911a0));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        ChatFileSearchFragment chatFileSearchFragment = new ChatFileSearchFragment();
        chatFileSearchFragment.F = 2;
        chatFileSearchFragment.f207844c0 = 2;
        chatFileSearchFragment.f207845d0 = this.f207911a0;
        chatFileSearchFragment.f207846e0 = this.f207914d0;
        chatFileSearchFragment.f207843b0 = this.f207912b0;
        beginTransaction.replace(R.id.b9v, chatFileSearchFragment);
        beginTransaction.commit();
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
