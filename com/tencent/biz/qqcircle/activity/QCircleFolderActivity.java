package com.tencent.biz.qqcircle.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePreInflateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderFragment;
import com.tencent.biz.qqcircle.utils.cg;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.monitor.memory.RFWMemoryLeakUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleActivityFocusChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.application.initprocess.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportHelper;
import gb0.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import l30.a;
import uq3.c;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_qcircle_915_fabu_folder_activity", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes4.dex */
public class QCircleFolderActivity extends QCircleFragmentActivity {

    /* renamed from: l0, reason: collision with root package name */
    private static final Map<Integer, String> f82576l0;

    /* renamed from: j0, reason: collision with root package name */
    private final boolean f82577j0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("argus_qcircle_915_fabu_folder_activity", false);

    /* renamed from: k0, reason: collision with root package name */
    private boolean f82578k0;

    static {
        HashMap hashMap = new HashMap();
        f82576l0 = hashMap;
        hashMap.put(80, "TRIM_MEMORY_COMPLETE");
        hashMap.put(60, "TRIM_MEMORY_MODERATE");
        hashMap.put(40, "TRIM_MEMORY_BACKGROUND");
        hashMap.put(20, "TRIM_MEMORY_UI_HIDDEN");
        hashMap.put(15, "TRIM_MEMORY_RUNNING_CRITICAL");
        hashMap.put(10, "TRIM_MEMORY_RUNNING_LOW");
        hashMap.put(5, "TRIM_MEMORY_RUNNING_MODERATE");
    }

    private void d3() {
        if (!c.f()) {
            return;
        }
        RFWMemoryLeakUtils.fixLoadedApkLeak(this);
    }

    private void e3() {
        if (this.f82578k0) {
            QLog.e("QCirclePreloadProcess", 1, "repeat call preInflateFolderFragments,direct return!");
            return;
        }
        if (!QCirclePluginUtil.isTabMode()) {
            QLog.e("QCirclePreloadProcess", 1, "preInflateFolderFragments pass,is not tab mode");
            return;
        }
        if (!a.a().b()) {
            QLog.e("QCirclePreloadProcess", 1, "preInflateFolderFragments pass,don't support async inflate");
            return;
        }
        RFWLayoutPreLoader layoutLoader = RFWLayoutPreLoaderFactory.getLayoutLoader(a.a().c());
        layoutLoader.preloadView(this, R.layout.gho, 1);
        layoutLoader.preloadView(this, R.layout.g_z, 2);
        layoutLoader.preloadView(this, R.layout.gjb, 1);
        layoutLoader.preloadView(this, R.layout.gjc, 3);
        layoutLoader.preloadView(this, R.layout.gln, 1);
        int d16 = a.a().d();
        if (d16 <= 0) {
            layoutLoader.preloadView(this, R.layout.gen, 1);
        }
        this.f82578k0 = true;
        QLog.d("QCirclePreloadProcess", 1, "preInflateFolderFragments done, preInflateItemViewCount:" + d16);
    }

    private void init() {
        f.i();
        b.j(this);
        if (f.d().c()) {
            QLog.d("QCirclePreloadProcess", 1, "delay preInflateFolderFragment");
        } else {
            e3();
            QLog.d("QCirclePreloadProcess", 1, "preInflateFolderFragment now");
        }
        QCircleReportHelper.getInstance().pushPageScene(0);
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_FOLDER_INIT);
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity
    /* renamed from: c3, reason: merged with bridge method [inline-methods] */
    public QCircleBaseFragment createFragment() {
        return new QFSFolderFragment();
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        QCirclePluginUtil.printTouchEventLog("QCircleFolderActivity", motionEvent);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCirclePreInflateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity
    /* renamed from: isDelegatedInflateEnabled */
    public boolean getMOpenLayoutInflaterDelegate() {
        return this.f82577j0;
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onBackEvent");
        QCircleEeveeMananger.getInstance().onSend(6, null, null);
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if (compatPublicFragment != null && compatPublicFragment.onBackEvent()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnCreate");
        super.onCreate(bundle);
        getWindow().setSoftInputMode(32);
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_FOLDER_CREATE);
        init();
        QCirclePluginGlobalInfo.V(hashCode(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnDestroy");
        QCircleReportHelper.getInstance().popPageScene(0);
        super.onDestroy();
        QCircleFeedPicLoader.g().deleteSdCacheIfNeed();
        d3();
        QCirclePanelStateEvent.resetPanelState();
        cg.d();
        QCirclePluginGlobalInfo.V(hashCode(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnNewIntent");
        super.onNewIntent(intent);
        if (getIntent() != null) {
            getIntent().putExtras(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onPause");
        super.onPause();
    }

    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePreInflateEvent) {
            e3();
        }
        super.onReceiveEvent(simpleBaseEvent);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Serializable serializable = bundle.getSerializable("key_bundle_common_init_bean");
        if (serializable != null) {
            getIntent().putExtra("key_bundle_common_init_bean", serializable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean z16 = true;
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->doOnResume");
        super.onResume();
        QCircleFolderBean qCircleFolderBean = (QCircleFolderBean) getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (qCircleFolderBean == null) {
            QLog.e("QCircleFolderActivity", 1, "onResume folder bean is null");
            return;
        }
        boolean isPublish = qCircleFolderBean.isPublish();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnResume isWrite?");
        sb5.append(isPublish);
        sb5.append(", mQCircleFragment?");
        if (this.mFrag == null) {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("QCircleFolderActivity", 4, sb5.toString());
        if (qCircleFolderBean.getEnterTime() > 0) {
            QLog.d("QCircleFolderActivity", 4, "onResume time:" + (System.currentTimeMillis() - qCircleFolderBean.getEnterTime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("key_bundle_common_init_bean", getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        QLog.d("QCircleFolderActivity", 1, "QCircleFolderActivity->onStop");
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        try {
            super.onTrimMemory(i3);
            f82576l0.get(Integer.valueOf(i3));
        } catch (Throwable th5) {
            QLog.w("QCircleFolderActivity", 1, "[onTrimMemory] ex: " + th5);
        }
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleActivityFocusChangeEvent(z16));
        QLog.d("QCircleFolderActivity", 1, "onWindowFocusChanged:" + z16);
    }
}
