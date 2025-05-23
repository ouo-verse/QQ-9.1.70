package com.tencent.biz.qqcircle.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import java.io.Serializable;
import java.util.HashMap;
import l30.a;
import uq3.c;
import uq3.o;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_qcircle_910_fabu_activity", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes4.dex */
public class QCircleFragmentActivity extends QCircleBaseActivity {

    /* renamed from: h0, reason: collision with root package name */
    private boolean f82579h0;

    /* renamed from: i0, reason: collision with root package name */
    private final boolean f82580i0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("argus_qcircle_910_fabu_activity", false);

    private void P2(@NonNull HashMap<String, String> hashMap) {
        QCircleInitBean qCircleInitBean;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_add_schema_param_when_exit_page", true) || (qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(this)) == null || qCircleInitBean.getSchemeAttrs() == null) {
            return;
        }
        String str = qCircleInitBean.getSchemeAttrs().get("key_scheme");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashMap.put("key_scheme", qCircleInitBean.getSchemeAttrs().get("key_scheme"));
        QLog.d("QCircleFragmentActivity", 1, " addSchemaParam" + str);
    }

    private String Q2(String str) {
        if (TextUtils.equals(str, String.valueOf(306))) {
            return QCircleScheme.Q_CIRCLE_WATERFALL;
        }
        return null;
    }

    private boolean R2() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_qcircle_fragment_activity_launcher_multi_fragment", true);
    }

    private String S2() {
        if (getIntent() == null) {
            return null;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (!(serializableExtra instanceof QCircleInitBean)) {
            return null;
        }
        return QCircleLauncherUtil.i(((QCircleInitBean) serializableExtra).getSchemeAttrs(), "ret_pg");
    }

    private boolean T2() {
        if (getSupportFragmentManager().getFragments().size() > 1) {
            return true;
        }
        return false;
    }

    private void U2(String str) {
        String Q2 = Q2(str);
        QLog.d("QCircleFragmentActivity", 1, "[jumpPageByPageId] action is :" + Q2);
        if (TextUtils.isEmpty(Q2)) {
            return;
        }
        QCircleSchemeBean qCircleSchemeBean = new QCircleSchemeBean();
        qCircleSchemeBean.setSchemeAction(Q2);
        HashMap<String, String> hashMap = new HashMap<>();
        P2(hashMap);
        hashMap.put("is_from_return_jump", "1");
        qCircleSchemeBean.setAttrs(hashMap);
        QCircleSchemeLauncher.b(this, qCircleSchemeBean);
    }

    private boolean V2() {
        if (getIntent() == null) {
            return false;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (!(serializableExtra instanceof QCircleInitBean) || !"1".equals(QCircleLauncherUtil.i(((QCircleInitBean) serializableExtra).getSchemeAttrs(), "open_folder_first")) || !o.N0()) {
            return false;
        }
        return true;
    }

    private boolean W2() {
        Serializable serializable;
        Intent intent = getIntent();
        if (intent != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (!(serializable instanceof QCircleFolderBean) && !(serializable instanceof QCircleLayerBean)) {
            return false;
        }
        return true;
    }

    private void Y2() {
        QCircleSchemeBean qCircleSchemeBean = new QCircleSchemeBean();
        qCircleSchemeBean.setSchemeAction(QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("is_force_jump_tab_page", "1");
        P2(hashMap);
        qCircleSchemeBean.setAttrs(hashMap);
        QCircleSchemeLauncher.b(this, qCircleSchemeBean);
    }

    private void Z2() {
        int d16 = a.a().d();
        if (d16 <= 0) {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateLayerItemView] preInflateCount:" + d16 + ", direct return!");
            return;
        }
        RFWLayoutPreLoaderFactory.getLayoutLoader(a.a().c()).preloadView(this, R.layout.gen, d16);
        QLog.d("QCirclePreloadProcess", 1, "[preInflateLayerItemView] done, preInflateCount:" + d16 + ", resId:" + R.layout.gen);
    }

    private void b3() {
        if (this.f82579h0) {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateViews] repeat call, direct return!");
            return;
        }
        QLog.d("QCirclePreloadProcess", 1, "[preInflateViews] device level:" + QCircleDeviceInfoUtils.getLevel());
        if (!a.a().b()) {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateViews] pass, don't support async inflate");
            return;
        }
        if (W2()) {
            Z2();
        } else {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateViews] not folder or layer page");
        }
        this.f82579h0 = true;
    }

    private boolean hackOnResumeException() {
        int i3;
        if (!c.D() || (i3 = Build.VERSION.SDK_INT) < 24 || i3 > 27) {
            return false;
        }
        try {
            super.onResume();
            QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity hackOnResume onResume()");
        } catch (IllegalArgumentException e16) {
            finish();
            QLog.e("QCircleFragmentActivity", 1, "finish QCircleFragmentActivity hackOnResumeExp onResume", e16);
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, android.app.Activity
    public void finish() {
        if (V2()) {
            QLog.d("QCircleFragmentActivity", 1, "[finish] need open folder");
            Y2();
        } else if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_force_jump_by_page_id_when_exit", true)) {
            String S2 = S2();
            if (!TextUtils.isEmpty(S2)) {
                U2(S2);
            }
        }
        super.finish();
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    /* renamed from: isDelegatedInflateEnabled */
    public boolean getMOpenLayoutInflaterDelegate() {
        return this.f82580i0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (256 == i3) {
            QLog.d("QCircleFragmentActivity", 1, "onActivityResult\uff0creturn from qzone publish page");
            QCircleReportHelper.getInstance().recordPageEndShow(36, true);
        }
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (T2() && R2()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            int size = supportFragmentManager.getFragments().size();
            if (size < 1) {
                return;
            }
            Fragment fragment = supportFragmentManager.getFragments().get(size - 1);
            if (fragment instanceof QCircleBaseFragment) {
                ((QCircleBaseFragment) fragment).onBackPressed();
                return;
            }
            return;
        }
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->onBackPressed");
        super.onBackPressed();
        CompatPublicFragment fragment2 = getFragment();
        if (fragment2 instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) fragment2).onBackPressed();
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->before onCreate");
        super.onCreate(bundle);
        bz.u(this);
        b3();
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->after onCreate, orientation: " + getRequestedOrientation());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->onDestroy");
        super.onDestroy();
        VSNetworkHelper.getInstance().cancelRequest(this);
        QCircleReporter.getInstance().flush();
        QCirclePanelStateEvent.resetPanelState(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->onNewIntent");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (hackOnResumeException()) {
            return;
        }
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->before onResume");
        super.onResume();
        QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->after onResume");
    }
}
