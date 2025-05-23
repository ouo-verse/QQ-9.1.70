package com.tencent.biz.qqcircle.richframework.compat;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.part.QCircleMonitorProxyImpl;
import com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.ch;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.biz.richframework.part.IRecyclerViewPoolProvider;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.DisplayMetricsUtil;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.common.event.RFRestartAppEvent;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.IPermissionRequester;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import mqq.util.AndroidOUIWrapperUtil;
import uq3.c;
import uq3.o;
import ya0.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleBaseActivity extends CompatPublicActivity implements IRecyclerViewPoolProvider, IPermissionRequester, SimpleEventReceiver, IProcessStateChangeCallback, IAccountCallback {

    /* renamed from: g0, reason: collision with root package name */
    private static final boolean f91890g0 = c.j6();

    /* renamed from: a0, reason: collision with root package name */
    private Handler f91891a0;

    /* renamed from: b0, reason: collision with root package name */
    private RecyclerView.RecycledViewPool f91892b0;

    /* renamed from: c0, reason: collision with root package name */
    private SparseArray<List> f91893c0 = new SparseArray<>();

    /* renamed from: d0, reason: collision with root package name */
    private boolean f91894d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f91895e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private final xa0.c f91896f0 = new xa0.c(this);

    private void F2() {
        if (c.z() && Build.VERSION.SDK_INT >= 26) {
            GlobalDisplayMetricsManager.adjustDisplayMetrics(this);
            FontSettingManager.resetFontIfNeeded(this, true, false);
            this.f91894d0 = bz.l();
            boolean M1 = o.M1();
            if (this.f91895e0 != M1) {
                QLog.d("ComponentBaseActivity", 1, "[adjustDisplayMetrics] fold | enable = " + this.f91894d0 + APLogFileUtil.SEPARATOR_LOG + M1);
            }
            this.f91895e0 = M1;
        }
    }

    private boolean G2() {
        IASEngineDelegate asEngineDelegate;
        if (!QCirclePluginUtil.isTabMode() || (asEngineDelegate = ASInject.g().getAsEngineDelegate()) == null) {
            return true;
        }
        return !asEngineDelegate.isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
    }

    private boolean H2() {
        if (QCircleApplication.sHasInit) {
            QLog.d("ComponentBaseActivity", 1, "qCircle APP is not null");
            return true;
        }
        if (RFWApplication.getApplication() instanceof Application) {
            QCircleApplication.init(RFWApplication.getApplication());
            QLog.d("ComponentBaseActivity", 1, "qCircle APP try to init");
        }
        if (!QCircleApplication.sHasInit) {
            QLog.d("ComponentBaseActivity", 1, "qCircle APP is null");
            return false;
        }
        QLog.d("ComponentBaseActivity", 1, "qCircle APP init success");
        return true;
    }

    private void I2(boolean z16) {
        if (z16 != BaseGesturePWDUtil.getAppForground(RFWApplication.getApplication())) {
            BaseGesturePWDUtil.setAppForground(RFWApplication.getApplication(), z16);
        }
    }

    private void J2() {
        if (!o.c()) {
            return;
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && guardManager.isApplicationForeground()) {
            QLog.d("ComponentBaseActivity", 4, "delaAccountLoginOut app foreGround return");
            return;
        }
        if (this instanceof QCircleFolderActivity) {
            if (!QCirclePluginUtil.isNewFolderPage(this)) {
                QLog.d("ComponentBaseActivity", 4, "delaAccountLoginOut app isTabFolderPage return");
                return;
            } else if (QCirclePluginUtil.isFromPadNavigation(this)) {
                QLog.d("ComponentBaseActivity", 4, "delaAccountLoginOut app isPad navigation FolderPage return");
                return;
            }
        }
        finish();
        QLog.d("ComponentBaseActivity", 4, "delaAccountLoginOut app backGround finish:" + getClass().getName());
    }

    private void M2() {
        if (MobileQQ.sMobileQQ != null && o.c()) {
            MobileQQ.sMobileQQ.registerAccountCallback(this);
        }
    }

    private void N2() {
        if (MobileQQ.sMobileQQ != null && o.c()) {
            MobileQQ.sMobileQQ.unregisterAccountCallback(this);
        }
    }

    private void disableFragmentRestore(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
            Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle2 != null) {
                bundle2.remove("android:support:fragments");
            }
        }
    }

    public boolean K2() {
        return true;
    }

    public void L2() {
        CompatPublicFragment createFragment = createFragment();
        this.mFrag = createFragment;
        if (createFragment == null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.ckj, this.mFrag).commitAllowingStateLoss();
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(HostActivityResultEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(RFRestartAppEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.IRecyclerViewPoolProvider
    public RecyclerView.RecycledViewPool getRecycledViewPool() {
        if (this.f91892b0 == null) {
            this.f91892b0 = new RecyclerView.RecycledViewPool();
        }
        return this.f91892b0;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NonNull
    public Resources getResources() {
        Resources resources = super.getResources();
        if (!this.f91894d0 && !this.f91895e0) {
            return resources;
        }
        try {
            DisplayMetricsUtil.checkAndCorrectDensity(resources.getDisplayMetrics());
            GlobalDisplayMetricsManager.checkDensity(resources);
        } catch (Throwable unused) {
        }
        return resources;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    public boolean isCloneInflaterInSubThread() {
        return f91890g0;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            this.f91896f0.b(configuration);
            bz.u(this);
            super.onConfigurationChanged(configuration);
            this.f91896f0.a(configuration);
        } catch (Exception e16) {
            QLog.e("ComponentBaseActivity", 1, "onConfigurationChanged exception:", e16);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (bundle != null) {
            disableFragmentRestore(bundle);
            bundle.remove("android:support:next_request_index");
            bundle.remove("android:support:request_indicies");
            bundle.remove("android:support:request_fragment_who");
            bundle.clear();
        }
        if (c.K5() && AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
            QLog.d("ComponentBaseActivity", 1, "[onCreate] execute to fixOrientation.");
        }
        super.onCreate(bundle);
        if (!H2()) {
            finish();
            QLog.d("ComponentBaseActivity", 1, "qCircle APP null finish page");
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWMonitorManager.instance().injectProxyImpl(QCircleMonitorProxyImpl.b());
        if (K2()) {
            QCircleSkinHelper.getInstance().setSkinFactory(this);
        }
        QCircleSkinHelper.getInstance().setContext(QCircleApplication.APP);
        QCircleSkinHelper.getInstance().loadResource();
        QFSDynamicResourceManager.g().init(QCircleSkinHelper.getInstance().getQCircleSkinFactory2(), a.a(), ch.f92746a);
        F2();
        M2();
        this.f91896f0.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f91896f0.e();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Handler handler = this.f91891a0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        N2();
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
        if (logoutReason == Constants.LogoutReason.forceLogout || logoutReason == Constants.LogoutReason.kicked || logoutReason == Constants.LogoutReason.secKicked) {
            J2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        RFWMonitorManager.instance().stop();
        this.f91896f0.f();
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        I2(false);
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessForeground() {
        boolean z16;
        if (c.X0("qqcircle", "qqcircle_gesture_password", 1).intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean jumpLock = BaseGesturePWDUtil.getJumpLock(r.x(this), r.q());
        QLog.d("ComponentBaseActivity", 1, " isOpenLockJump:" + z16 + " needJumpLock:" + jumpLock + this);
        if (jumpLock && z16) {
            Intent unlockActivityIntent = HostRouteUtils.getUnlockActivityIntent(this);
            unlockActivityIntent.addFlags(603979776);
            unlockActivityIntent.putExtra("key_gesture_showgesture_valid", false);
            startActivityForResult(unlockActivityIntent, 12289);
        }
        I2(true);
    }

    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFRestartAppEvent) {
            QLog.d("ComponentBaseActivity", 4, "RFRestartAppEvent close activity");
            finish();
        } else if (simpleBaseEvent instanceof HostActivityResultEvent) {
            HostActivityResultEvent hostActivityResultEvent = (HostActivityResultEvent) simpleBaseEvent;
            QLog.i("ComponentBaseActivity", 1, hashCode() + ": onActivityResult receive event, currentHashCode:" + hashCode() + ",hostHashCode:" + getBaseContext().hashCode() + ", shadowHashCode:" + hostActivityResultEvent.getShadowTopContextHashCode());
            onActivityResult(hostActivityResultEvent.getRequestCode(), hostActivityResultEvent.getResultCode(), hostActivityResultEvent.getIntent());
        }
        this.f91896f0.g(simpleBaseEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        List list = this.f91893c0.get(i3);
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj != null) {
                    if (obj instanceof QQPermissionCallback) {
                        QQPermissionCallback qQPermissionCallback = (QQPermissionCallback) obj;
                        ArrayList arrayList = new ArrayList();
                        for (int i16 = 0; i16 < iArr.length; i16++) {
                            if (iArr[i16] != 0) {
                                arrayList.add(strArr[i16]);
                            }
                        }
                        if (arrayList.size() > 0) {
                            qQPermissionCallback.deny(i3, strArr, iArr);
                        } else {
                            qQPermissionCallback.grant(i3, strArr, iArr);
                        }
                    } else {
                        QQPermissionHelper.requestResult(obj, i3, strArr, iArr);
                    }
                }
            }
        }
        if (list != null) {
            this.f91893c0.remove(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DisplayUtil.reset();
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if ((compatPublicFragment instanceof QCircleBaseFragment) && ((QCircleBaseFragment) compatPublicFragment).enableAudioFocus()) {
            QFSAudioFocusManager.f().i(this);
        }
        RFWMonitorManager.instance().start(this);
        this.f91896f0.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f91896f0.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CompatPublicFragment compatPublicFragment = this.mFrag;
        if ((compatPublicFragment instanceof QCircleBaseFragment) && ((QCircleBaseFragment) compatPublicFragment).enableReleaseAudioFocus() && G2()) {
            QFSAudioFocusManager.f().h();
        }
        this.f91896f0.j();
    }

    @Override // mqq.app.IPermissionRequester
    @TargetApi(24)
    public void requestPermissions(Object obj, int i3, String... strArr) {
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "fight.requestPermissions-", strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            List list = this.f91893c0.get(i3);
            if (list == null) {
                list = new ArrayList();
            }
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 < size) {
                    Object obj2 = list.get(i16);
                    if (obj2 != null && obj2 == obj) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                list.add(obj);
                this.f91893c0.put(i3, list);
            }
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
            return;
        }
        if (obj instanceof QQPermissionCallback) {
            ((QQPermissionCallback) obj).grant(i3, strArr, null);
        } else {
            QQPermissionHelper.doExecuteSuccess(obj, i3);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            super.setRequestedOrientation(i3);
            QLog.d("ComponentBaseActivity", 1, "[setRequestedOrientation] requested orientation: " + i3);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(AppRuntime appRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
    }
}
