package com.tencent.biz.qqcircle.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.anim.b;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.like.QFSTVideoEnterReloadEvent;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import gy2.c;
import java.io.Serializable;
import java.util.HashMap;
import jy2.g;
import qx2.a;
import tvideo.Video;
import zt2.e;

/* compiled from: P */
/* loaded from: classes4.dex */
public class TVideoFragmentActivity extends QCircleFragmentActivity {

    /* renamed from: j0, reason: collision with root package name */
    private QCircleInitBean f82581j0;

    /* renamed from: k0, reason: collision with root package name */
    private TVideoLayerBean f82582k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f82583l0;

    private void d3(Intent intent) {
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        if (!(serializableExtra instanceof TVideoLayerBean)) {
            return;
        }
        TVideoLayerBean tVideoLayerBean = (TVideoLayerBean) serializableExtra;
        this.f82582k0 = tVideoLayerBean;
        HashMap<String, String> schemeAttrs = tVideoLayerBean.getSchemeAttrs();
        if (schemeAttrs == null) {
            return;
        }
        if (schemeAttrs.containsKey("frome_like") || schemeAttrs.containsKey("need_reload")) {
            this.f82583l0 = true;
            QLog.d("TVideoFragmentActivity", 1, "needReloadTabPage");
        }
    }

    private void e3() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.activity.TVideoFragmentActivity.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("TVideoFragmentActivity", 1, "sendReloadEvent");
                QFSTVideoEnterReloadEvent qFSTVideoEnterReloadEvent = new QFSTVideoEnterReloadEvent();
                qFSTVideoEnterReloadEvent.setLayerBean(TVideoFragmentActivity.this.f82582k0);
                SimpleEventBus.getInstance().dispatchEvent(qFSTVideoEnterReloadEvent);
                a.c().n(false);
            }
        }, 100L);
    }

    private void f3() {
        if (getIntent() != null) {
            getIntent().putExtra("orientation_type_flag", 1);
        }
    }

    private void g3() {
        e eVar = e.f453199a;
        if (eVar.k() && eVar.i() != null) {
            c.D(eVar.i());
        } else {
            c.D(null);
        }
    }

    private void h3() {
        QCircleInitBean qCircleInitBean = this.f82581j0;
        if (qCircleInitBean instanceof TVideoLayerBean) {
            Video q16 = g.q(qCircleInitBean.getFeed());
            if (q16 != null && q16.video_base_info != null) {
                c.y("qqpa#" + q16.video_base_info.material_aspect_vid);
            }
            if (((TVideoLayerBean) this.f82581j0).getBusinessReportMap() != null) {
                c.w(((TVideoLayerBean) this.f82581j0).getBusinessReportMap());
            }
        }
        g3();
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, android.app.Activity
    public void finish() {
        super.finish();
        b.b("aio", this);
    }

    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b.c("aio", this);
        QLog.d("TVideoFragmentActivity", 1, "onCreate");
        g.t();
        this.f82581j0 = QCirclePluginUtil.getQCircleInitBean(this);
        new com.tencent.mobileqq.tvideo.base.b().d(QCircleApplication.APP.getApplicationContext(), getLifecycle());
        e.f453199a.r();
        f3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        d3(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.activity.QCircleFragmentActivity, com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        h3();
        if (this.f82583l0) {
            this.f82583l0 = false;
            e3();
        }
    }
}
