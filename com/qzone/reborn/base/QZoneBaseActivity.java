package com.qzone.reborn.base;

import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QZoneQUIProfileResources;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.SparseArray;
import android.view.LayoutInflater;
import com.qzone.app.QZoneAppInterface;
import com.qzone.app.ResourcePreloader;
import com.qzone.reborn.feedx.util.ae;
import com.qzone.reborn.runtime.QZoneRuntime;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.datacenter.QzoneDataCenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.QUIProfileConstants;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.ProcessUtils;
import d5.r;
import java.util.ArrayList;
import java.util.List;
import mqq.app.IPermissionRequester;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import mqq.util.AndroidOUIWrapperUtil;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneBaseActivity extends CompatPublicActivity implements IPermissionRequester {
    private static final String PROCESS_ID = "process_id";
    private static final String TAG = "QZoneBaseActivity";
    private final boolean mCloneInSubThread;
    private final boolean mIsDelegateLayoutInflater;
    private final boolean mIsDelegateResource;
    private final RFWThreadLocal<LayoutInflater> mLayoutInflaters;
    private SparseArray<List> mPermissionCallerMap = new SparseArray<>();
    private final RFWThreadLocal<Resources> mQuiProfileResources;
    private final boolean mUseCompatFactory2;

    public QZoneBaseActivity() {
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        this.mUseCompatFactory2 = gVar.b().K1();
        this.mCloneInSubThread = gVar.b().w1();
        this.mIsDelegateResource = gVar.b().x1();
        this.mIsDelegateLayoutInflater = gVar.b().y1();
        this.mQuiProfileResources = new RFWThreadLocal<>();
        this.mLayoutInflaters = new RFWThreadLocal<>();
    }

    private void checkQZoneInitState() {
        if (!km.a.f412646a.a()) {
            RFWLog.i(TAG, RFWLog.USR, this + " qzone process do not need init env");
            return;
        }
        if (QZoneApiProxy.isQZonePluginInit()) {
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            RFWLog.i(TAG, RFWLog.USR, this + " checkQZoneInitState error, peekAppRuntime is null");
            if (!com.qzone.reborn.configx.g.f53821a.l().r()) {
                return;
            } else {
                MobileQQ.sMobileQQ.waitAppRuntime();
            }
        }
        QZoneApiProxy.initEnv(this, MobileQQ.sMobileQQ.peekAppRuntime());
        QZoneApiProxy.initServlet(this, MobileQQ.sMobileQQ.peekAppRuntime());
    }

    private void endOnCreateStep() {
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.m("ACTIVITY_ON_CREATE");
        }
    }

    private LayoutInflater getLayoutInflaterInner() {
        r qUIProfileTheme = getQUIProfileTheme();
        if (qUIProfileTheme != null) {
            Object systemService = super.getSystemService("layout_inflater");
            if (systemService instanceof LayoutInflater) {
                return qUIProfileTheme.a((LayoutInflater) systemService);
            }
        }
        LayoutInflater layoutInflater = this.mLayoutInflaters.get();
        if (layoutInflater == null) {
            Object systemService2 = super.getSystemService("layout_inflater");
            if (systemService2 instanceof LayoutInflater) {
                LayoutInflater layoutInflater2 = (LayoutInflater) systemService2;
                if (ae.a() && enableQUIProfile()) {
                    layoutInflater = new QUIProfileLayoutInflater(layoutInflater2, this, "qzone");
                    be0.a.b("qzone").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
                } else {
                    layoutInflater = layoutInflater2;
                }
                this.mLayoutInflaters.set(layoutInflater);
            }
        }
        return layoutInflater;
    }

    private boolean hackOnResumeException() {
        int i3;
        if (!xe.a.f447839a.f() || (i3 = Build.VERSION.SDK_INT) < 24 || i3 > 27) {
            return false;
        }
        try {
            super.onResume();
            QLog.d(TAG, 1, "QZoneBaseActivity hackOnResume onResume()");
        } catch (IllegalArgumentException e16) {
            finish();
            QLog.e(TAG, 1, "finish QZoneBaseActivity hackOnResumeExp onResume", e16);
        }
        return true;
    }

    private void setupOrientation() {
        if (shouldSetOrientation()) {
            com.tencent.mobileqq.pad.c.c(this);
        }
    }

    private boolean shouldSetOrientation() {
        return true;
    }

    private void startOnCreateStep() {
        jo.g c16 = jo.h.f410717a.c();
        if (c16 != null) {
            c16.x("ACTIVITY_ON_CREATE");
        }
    }

    protected boolean enableQUIProfile() {
        return true;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, android.app.Activity
    public void finish() {
        if (isNeedQZoneStyleActivityAnim()) {
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
        super.finish();
        setActivityCloseAnimation();
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return getLayoutInflaterInner();
    }

    protected r getQUIProfileTheme() {
        return null;
    }

    public BasePartFragment getQZoneBaseFragment() {
        return (BasePartFragment) getFragment();
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        r qUIProfileTheme = getQUIProfileTheme();
        if (qUIProfileTheme != null) {
            return qUIProfileTheme.b(super.getResources());
        }
        if (ae.a() && enableQUIProfile()) {
            Resources resources = this.mQuiProfileResources.get();
            if (resources != null) {
                return resources;
            }
            QZoneQUIProfileResources qZoneQUIProfileResources = new QZoneQUIProfileResources(super.getResources(), this, "qzone");
            be0.a.b("qzone").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
            this.mQuiProfileResources.set(qZoneQUIProfileResources);
            return qZoneQUIProfileResources;
        }
        return super.getResources();
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            return getLayoutInflaterInner();
        }
        return super.getSystemService(str);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    public boolean isCloneInflaterInSubThread() {
        return this.mCloneInSubThread;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    public boolean isDelegateResourceEnabled() {
        return this.mIsDelegateResource;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    public boolean isDelegatedInflateEnabled() {
        return this.mIsDelegateLayoutInflater;
    }

    protected boolean isNeedQZoneStyleActivityAnim() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        startOnCreateStep();
        if (isNeedQZoneStyleActivityAnim()) {
            overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
        if (checkIsRebootInDiffProcessId(bundle)) {
            QLog.e(TAG, 1, "is reboot scene, finish self");
            getIntent().putExtra("public_fragment_class", "");
            super.onCreate(null);
            super.finish();
            return;
        }
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        QZoneRuntime.j().l();
        super.onCreate(bundle);
        checkQZoneInitState();
        ProcessUtils.setTopActivity(this, getClass().getSimpleName());
        ResourcePreloader.b().f44470a = true;
        setupOrientation();
        QZoneLoginReportHelper.handleLoginFromIntent(getIntent());
        QZoneAppInterface.initActivityStartParameters();
        VideoReport.addToDetectionWhitelist(this);
        endOnCreateStep();
        setActivityOpenAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QzoneDataCenter.INSTANCE.releasePageObservers(String.valueOf(hashCode()));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        List list;
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0 || (list = this.mPermissionCallerMap.get(i3)) == null || list.size() == 0) {
            return;
        }
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
        this.mPermissionCallerMap.remove(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (hackOnResumeException()) {
            return;
        }
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        QLog.e(TAG, 1, "onSaveInstanceState" + Process.myPid());
        bundle.putInt("process_id", Process.myPid());
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity
    /* renamed from: preloadCompatFactory2Enabled */
    public boolean getPreloadCompatFactory2Enable() {
        return this.mUseCompatFactory2;
    }

    @Override // mqq.app.IPermissionRequester
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
            List list = this.mPermissionCallerMap.get(i3);
            if (list == null) {
                list = new ArrayList();
            }
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    z16 = false;
                    break;
                }
                Object obj2 = list.get(i16);
                if (obj2 != null && obj2 == obj) {
                    break;
                } else {
                    i16++;
                }
            }
            if (!z16) {
                list.add(obj);
                this.mPermissionCallerMap.put(i3, list);
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

    protected void setActivityCloseAnimation() {
        if (getIntent().getBooleanExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, false)) {
            overridePendingTransition(getIntent().getIntExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0), getIntent().getIntExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0));
            return;
        }
        String stringExtra = getIntent().getStringExtra(QBaseActivity.KEY_TYPE_ACTIVITY_ANIMATION);
        if (stringExtra != null) {
            com.tencent.mobileqq.app.anim.b.b(stringExtra, this);
        }
    }

    protected void setActivityOpenAnimation() {
        if (getIntent().getBooleanExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, false)) {
            overridePendingTransition(getIntent().getIntExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, 0), getIntent().getIntExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, 0));
            return;
        }
        String stringExtra = getIntent().getStringExtra(QBaseActivity.KEY_TYPE_ACTIVITY_ANIMATION);
        if (stringExtra != null) {
            com.tencent.mobileqq.app.anim.b.c(stringExtra, this);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i3) {
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            return;
        }
        super.setRequestedOrientation(i3);
    }

    private boolean checkIsRebootInDiffProcessId(Bundle bundle) {
        if (bundle == null) {
            QLog.e(TAG, 1, "onCreate outState is null");
            return false;
        }
        if (!QZoneConfigHelper.b()) {
            QLog.e(TAG, 1, "onCreate canFinishActivityWhenReboot false");
            return false;
        }
        Object obj = bundle.get("process_id");
        if (obj instanceof Integer) {
            QLog.e(TAG, 1, "onCreate Process.myPid():" + Process.myPid() + " oldProcessId:" + obj);
            return Process.myPid() != ((Integer) obj).intValue();
        }
        QLog.e(TAG, 1, "onCreate oldProcessId type error");
        return false;
    }
}
