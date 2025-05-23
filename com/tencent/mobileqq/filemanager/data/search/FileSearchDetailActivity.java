package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileSearchDetailActivity extends IphoneTitleBarActivity {

    /* renamed from: b0, reason: collision with root package name */
    static c f207877b0;

    /* renamed from: a0, reason: collision with root package name */
    c f207878a0;

    public static void G2(Context context, String str, c cVar) {
        f207877b0 = cVar;
        Intent intent = new Intent(context, (Class<?>) FileSearchDetailActivity.class);
        intent.putExtra("keyword", str);
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
        List<FileManagerEntity> list;
        super.doOnCreate(bundle);
        c cVar = f207877b0;
        this.f207878a0 = cVar;
        if (cVar != null && (list = cVar.G) != null && list.size() != 0) {
            super.setContentView(R.layout.f167784he);
            super.setTitle(this.f207878a0.G.get(0).fileName);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FileSearchDetailFragment ph5 = FileSearchDetailFragment.ph(getIntent().getStringExtra("keyword"), this.f207878a0);
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.replace(R.id.b9v, ph5);
            beginTransaction.commit();
            return true;
        }
        c cVar2 = this.f207878a0;
        if (cVar2 == null) {
            QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult is null");
        } else {
            List<FileManagerEntity> list2 = cVar2.G;
            if (list2 == null) {
                QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity is null ");
            } else if (list2.size() == 0) {
                QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity.size() is 0 ");
            }
        }
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
