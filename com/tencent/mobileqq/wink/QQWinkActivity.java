package com.tencent.mobileqq.wink;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.p;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkActivity extends CompatPublicActivity implements SimpleEventReceiver, SkinnableActivityProcesser.Callback {

    /* renamed from: c0, reason: collision with root package name */
    private volatile h93.a f317639c0;

    /* renamed from: e0, reason: collision with root package name */
    private SkinnableActivityProcesser f317641e0;

    /* renamed from: a0, reason: collision with root package name */
    private final p f317637a0 = new p();

    /* renamed from: b0, reason: collision with root package name */
    private final b93.e f317638b0 = new b93.e();

    /* renamed from: d0, reason: collision with root package name */
    private boolean f317640d0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private String f317642f0 = "";

    private void G2() {
        final int name2Type = WinkPublishConfigConstant.INSTANCE.name2Type(WinkContext.INSTANCE.d().businessConfig.a());
        Wink.INSTANCE.i().a(new Runnable() { // from class: com.tencent.mobileqq.wink.a
            @Override // java.lang.Runnable
            public final void run() {
                QQWinkActivity.K2(name2Type);
            }
        }, 0L);
    }

    private h93.a H2() {
        if (this.f317639c0 == null) {
            synchronized (this) {
                if (this.f317639c0 == null) {
                    this.f317639c0 = ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).getWinkProfileTheme(this, false);
                }
            }
        }
        return this.f317639c0;
    }

    private void I2() {
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).initialize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K2(int i3) {
        WinkPublishHelper2.INSTANCE.bindService(i3, null);
    }

    private void L2() {
        this.f317642f0 = WinkContext.INSTANCE.d().getTraceId();
        w53.b.a("QQWinkActivity", "initTraceIdFromIntent:" + this.f317642f0);
    }

    private void M2() {
        N2();
        WinkDTParamBuilder.setDtParams(getIntent());
    }

    private void N2() {
        String str = "";
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, "");
        if (WinkContext.INSTANCE.d().u("QZONE")) {
            if (getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_PART_NAME) != null) {
                str = getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_PART_NAME);
            }
            QLog.i("QQWinkActivity", 1, "setWhichFrom from :" + str);
            if (QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_ALBUM.equals(str)) {
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDaTongReportConstant.ElementParamValue.XSJ_SUB_ENTRY_BUSINESS_QZONE_ALBUM);
                return;
            }
            if (QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO.equals(str)) {
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDaTongReportConstant.ElementParamValue.XSJ_SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO);
            } else if (QQWinkConstants.QZONE_LIBTEMPLATE.equals(str)) {
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, QQWinkConstants.QZONE_LIBTEMPLATE);
            } else if (QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_RECOMMEND.equals(str)) {
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, "qz_recommend_for_you");
            }
        }
    }

    private Boolean P2() {
        boolean z16;
        WinkContext.Companion companion = WinkContext.INSTANCE;
        boolean z17 = true;
        if (companion.l() && companion.d().u("QCIRCLE")) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        Boolean valueOf2 = Boolean.valueOf(getIntent().getBooleanExtra(QQWinkConstants.WINK_USE_PROFILE_THEME, false));
        if (valueOf2.booleanValue()) {
            getIntent().removeExtra(QQWinkConstants.WINK_USE_PROFILE_THEME);
        }
        if (!valueOf2.booleanValue() || !valueOf.booleanValue()) {
            z17 = false;
        }
        return Boolean.valueOf(z17);
    }

    public boolean J2() {
        return this.f317640d0;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(HostActivityResultEvent.class);
        arrayList.add(WinkFinishActivityEvent.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NonNull
    public Resources getResources() {
        if (this.f317640d0) {
            return H2().b(super.getResources());
        }
        return super.getResources();
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NonNull String str) {
        if (this.f317640d0 && "layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            if (systemService instanceof LayoutInflater) {
                return H2().a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(str);
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersiveUtils.resetDensity();
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        this.f317637a0.a(bundle, getIntent());
        L2();
        boolean booleanValue = P2().booleanValue();
        this.f317640d0 = booleanValue;
        if (booleanValue) {
            this.f317641e0 = new SkinnableActivityProcesser(this, this);
        }
        super.onCreate(bundle);
        I2();
        SimpleEventBus.getInstance().registerReceiver(this);
        M2();
        G2();
        if (Build.VERSION.SDK_INT >= 24) {
            GlobalDisplayMetricsManager.adjustDisplayMetrics(this);
            FontSettingManager.resetFontIfNeeded(this, true, false);
        }
        if (r93.h.f430993a.g()) {
            com.tencent.mobileqq.wink.picker.report.b.f325261a.e(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SkinnableActivityProcesser skinnableActivityProcesser = this.f317641e0;
        if (skinnableActivityProcesser != null) {
            try {
                unregisterReceiver(skinnableActivityProcesser);
            } catch (Exception e16) {
                QLog.e("QQWinkActivity", 1, "skinnableActivityPro unregisterReceiver err:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f317638b0.b(this);
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        QLog.i("QQWinkActivity", 1, "[onPostThemeChanged]");
        getWindow().getDecorView().invalidate();
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        QLog.i("QQWinkActivity", 1, "[onPreThemeChanged]");
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return WinkContext.INSTANCE.k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof WinkFinishActivityEvent) && !isFinishing()) {
            WinkFinishActivityEvent winkFinishActivityEvent = (WinkFinishActivityEvent) simpleBaseEvent;
            if (this.f317638b0.e(winkFinishActivityEvent, this.f317642f0)) {
                QLog.i("QQWinkActivity", 1, "[onReceiveEvent] receive finish event, frag=" + getFragment());
                this.f317638b0.a(this, winkFinishActivityEvent);
                return;
            }
        }
        if (simpleBaseEvent instanceof HostActivityResultEvent) {
            HostActivityResultEvent hostActivityResultEvent = (HostActivityResultEvent) simpleBaseEvent;
            QLog.i("QQWinkActivity", 1, hashCode() + ": onActivityResult receive event, currentHashCode:" + hashCode() + ",hostHashCode:" + getBaseContext().hashCode() + ", shadowHashCode:" + hostActivityResultEvent.getShadowTopContextHashCode());
            onActivityResult(hostActivityResultEvent.getRequestCode(), hostActivityResultEvent.getResultCode(), hostActivityResultEvent.getIntent());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments == null) {
            return;
        }
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                fragment.onRequestPermissionsResult(i3, strArr, iArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f317637a0.a(null, getIntent());
        this.f317638b0.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f317637a0.c(bundle);
    }
}
