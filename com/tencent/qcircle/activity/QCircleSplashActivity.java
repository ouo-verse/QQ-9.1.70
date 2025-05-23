package com.tencent.qcircle.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QCircleSplashActivity extends Activity implements SimpleEventReceiver {

    /* renamed from: f, reason: collision with root package name */
    private static String f342424f = "ASDynamicEngine_qicrlce-app";

    /* renamed from: d, reason: collision with root package name */
    private ASEnterBean f342425d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f342426e;

    private void a(boolean z16) {
        ASEngineEnterEvent aSEngineEnterEvent = new ASEngineEnterEvent(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        aSEngineEnterEvent.setCallBackResult(true);
        aSEngineEnterEvent.setLoadCost(String.valueOf(System.currentTimeMillis() - this.f342425d.getStartTime()));
        SimpleEventBus.getInstance().dispatchEvent(aSEngineEnterEvent);
    }

    private void b() {
        a(true);
        QCircleSchemeLauncher.e(this, new QCircleSchemeBean().setSchemeAction(this.f342425d.getSchemeAction()).setAttrs(this.f342425d.getAttrs()).setByteAttrs(this.f342425d.getByteAttrs()));
    }

    private void c() {
        a(true);
        if (this.f342426e) {
            return;
        }
        QLog.d(f342424f, 1, "QCircleSplashActivity.dealStartAndInstall#first start by activity");
        QCircleSchemeLauncher.e(this, new QCircleSchemeBean().setSchemeAction(this.f342425d.getSchemeAction()).setAttrs(this.f342425d.getAttrs()).setByteAttrs(this.f342425d.getByteAttrs()));
    }

    private void d() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN)) {
            ASEnterBean aSEnterBean = (ASEnterBean) extras.getSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN);
            this.f342425d = aSEnterBean;
            if (aSEnterBean == null) {
                return;
            }
            int loadAction = aSEnterBean.getLoadAction();
            if (loadAction != 1001) {
                if (loadAction == 1002) {
                    c();
                }
            } else {
                b();
            }
            QLog.d(f342424f, 1, "QCircleSplashActivity#start success,time cost:" + (System.currentTimeMillis() - this.f342425d.getStartTime()));
            return;
        }
        a(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(ASEngineEnterEvent.class);
        return arrayList;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        QCircleBlockCheckListBlock.tryInjectBlockLooperListener();
        d();
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ASEngineEnterEvent) {
            ASEngineEnterEvent aSEngineEnterEvent = (ASEngineEnterEvent) simpleBaseEvent;
            if (!aSEngineEnterEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
                return;
            }
            this.f342426e = aSEngineEnterEvent.isCancel();
        }
    }
}
