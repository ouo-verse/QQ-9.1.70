package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoActivity extends QQStoryBaseActivity implements aa, m.c {

    /* renamed from: a0, reason: collision with root package name */
    public long f67747a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    protected EditVideoPartManager f67748b0;

    /* renamed from: c0, reason: collision with root package name */
    private RelativeLayout f67749c0;

    private void L2() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).loadEffectSo();
                com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().x(EditVideoActivity.this.getApplicationContext(), EditVideoActivity.this, true);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        long longExtra = getIntent().getLongExtra("stop_record_time", -1L);
        int K = this.f67748b0.K();
        int k3 = this.f67748b0.C.k();
        if (com.tencent.mobileqq.monitor.a.f247270d && longExtra != -1) {
            com.tencent.mobileqq.monitor.a.f247271e.f();
            com.tencent.mobileqq.monitor.b bVar = com.tencent.mobileqq.monitor.a.f247271e;
            bVar.f247275c = this.f67748b0.C.f204055d;
            bVar.d(0, longExtra);
            com.tencent.mobileqq.monitor.a.f247271e.d(1, this.f67747a0);
        }
        int Y = this.f67748b0.Y();
        getIntent().putExtra(ShortVideoConstants.CAPTURE_OPERATION_IN, Y);
        id0.a.l("edit_exp", Y, 0, id0.a.b(K), "", "", String.valueOf(k3));
    }

    private void P2() {
        long j3 = Runtime.getRuntime().totalMemory() / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024;
        long freeMemory = j3 - (Runtime.getRuntime().freeMemory() / 1024);
        long j16 = maxMemory - freeMemory;
        hd0.c.e("EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(freeMemory), Long.valueOf(j3), Long.valueOf(maxMemory), Long.valueOf(j16));
        if (j16 < 10240) {
            hd0.c.v("EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", Long.valueOf(freeMemory), Long.valueOf(j3), Long.valueOf(maxMemory), Long.valueOf(j16), Long.valueOf(com.tencent.cache.core.manager.api.c.f98725d.g() / 1024));
            ((TrimmableManager) com.tencent.biz.qqstory.model.i.c(26)).c(2);
        } else {
            ((TrimmableManager) com.tencent.biz.qqstory.model.i.c(26)).c(0);
        }
    }

    private void initLiuHaiScreenTopBar() {
        if (LiuHaiUtils.needShowLiuHaiTopBar()) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rwf);
            this.f67749c0 = relativeLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.height = LiuHaiUtils.LiuHaiTopBarHeight();
            this.f67749c0.setLayoutParams(layoutParams);
            this.f67749c0.setVisibility(0);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.m.c
    public void C2(boolean z16) {
        if (this.f67748b0.H != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoActivity.this.f67748b0.H.L0(true);
                }
            });
        }
    }

    protected void I2() {
        if (this.f67748b0.C.e() == 14) {
            com.tencent.aelight.camera.aioeditor.editipc.b.registerModule();
        }
    }

    protected void J2() {
        if (this.f67748b0 == null) {
            this.f67748b0 = new EditVideoPartManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        this.f67748b0.s0(i3, i16, intent);
        hd0.c.k("EditVideoActivity", "doOnActivityResult requestCode=" + i3 + " resultCode=" + i16);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        hd0.c.k("EditVideoActivity", "doOnBackPressed");
        if (!this.f67748b0.t0()) {
            super.doOnBackPressed();
        }
        M2();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        super.doOnConfigurationChanged(configuration);
        LiuHaiUtils.resetAllLiuHaiStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String str;
        com.tencent.sveffects.a.b();
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).initWithConfig();
        hd0.c.a("EditVideoActivity", "EditVideoActivity doOnCreate start");
        J2();
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        this.isClearCoverLayer = false;
        L2();
        super.getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        super.doOnCreate(bundle);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                qr.a.a();
                h.a();
            }
        });
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSo();
                    ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSoWithConfig();
                    if (VideoEnvironment.loadAVCodecSo() != 0) {
                        hd0.c.g("EditVideoActivity", "load AVCodec so failed");
                        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IAECameraGetInfoServer.NAME, "ACTION_DOWNLOAD_AVCODEC", new Bundle());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (EditVideoActivity.this.isDestroyed() || EditVideoActivity.this.isFinishing()) {
                                    return;
                                }
                                QQToast.makeText(EditVideoActivity.this, HardCodeUtil.qqStr(R.string.lyx), 0).show();
                                EditVideoActivity.this.finish();
                            }
                        });
                    }
                } catch (Exception e16) {
                    hd0.c.h("EditVideoActivity", "load AVCodec so failed", e16);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (EditVideoActivity.this.isDestroyed() || EditVideoActivity.this.isFinishing()) {
                                return;
                            }
                            EditVideoActivity.this.finish();
                        }
                    });
                }
            }
        });
        EditVideoParams editVideoParams = (EditVideoParams) getIntent().getParcelableExtra(EditVideoParams.class.getName());
        hd0.c.v("EditVideoActivity", "doOnCreate instance=%d, video params=%s", Integer.valueOf(System.identityHashCode(this)), editVideoParams);
        if (editVideoParams != null) {
            str = editVideoParams.a();
        } else {
            str = "can not find EditVideoParams";
        }
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.m3f) + str, 0).show();
            finish();
            return true;
        }
        String stringExtra = getIntent().getStringExtra("op_department");
        String stringExtra2 = getIntent().getStringExtra("op_type");
        hd0.c.v("EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", Integer.valueOf(System.identityHashCode(this)), stringExtra, stringExtra2);
        vq.a.f443174a.d(this, "pg_ae_camera_video_save");
        LiuHaiUtils.resetAllLiuHaiStatus();
        LiuHaiUtils.resetFullScreen(this);
        LiuHaiUtils.initLiuHaiBarHeight(this);
        if (LiuHaiUtils.needShowLiuHaiTopBar()) {
            LiuHaiUtils.enableNotch(this);
        }
        this.f67748b0.V = true;
        setContentViewC(R.layout.dof);
        K2(bundle);
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lxi), 0).show();
            finish();
            return true;
        }
        initLiuHaiScreenTopBar();
        this.f67748b0.g1(getIntent().getIntExtra(IJumpUtil.EDIT_VIDEO_WAY, 0));
        this.f67748b0.r(this, editVideoParams);
        com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
        dVar.p(8);
        dVar.l(this.f67748b0.C.e());
        this.f67748b0.u0();
        com.tencent.biz.qqstory.utils.d.t(vc0.a.f441365e);
        id0.b.f407532a = stringExtra;
        id0.b.f407533b = stringExtra2;
        id0.b.i("0X80076B5");
        id0.a.n("aio_shoot", "exp_edit", 0, 0, "1");
        LpReportInfo_pf00064.allReport(628, 1);
        hd0.c.a("EditVideoActivity", "EditVideoActivity doOnCreate end");
        sendBroadcast(new Intent("action_fire_get_config"));
        P2();
        ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).f(1);
        I2();
        this.f67747a0 = System.currentTimeMillis();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.N2();
            }
        });
        com.tencent.aelight.camera.ae.camera.ui.simple.d.c(getIntent());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        hd0.c.v("EditVideoActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
        this.f67748b0.w0();
        id0.b.f407532a = "";
        id0.b.f407533b = "";
        com.tencent.mobileqq.monitor.a.f247269c.g();
        ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).f(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        hd0.c.k("EditVideoActivity", "doOnPause");
        this.f67748b0.C0();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.6
            @Override // java.lang.Runnable
            public void run() {
                yq2.a.f();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        super.doOnRestoreInstanceState(bundle);
        hd0.c.k("EditVideoActivity", "doOnRestoreInstanceState");
        this.f67748b0.G0(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        hd0.c.k("EditVideoActivity", "doOnResume");
        this.f67748b0.H0();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                yq2.a.a();
            }
        }, 16, null, false);
        ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).o(1);
        if (Build.VERSION.SDK_INT >= 29) {
            com.tencent.biz.subscribe.utils.g.c(getWindow());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        super.doOnSaveInstanceState(bundle);
        hd0.c.k("EditVideoActivity", "doOnSaveInstanceState");
        this.f67748b0.K0(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        hd0.c.k("EditVideoActivity", "doOnStart");
        this.f67748b0.M0();
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportEditViewExpose();
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setShootTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        hd0.c.k("EditVideoActivity", "doOnStop");
        this.f67748b0.N0();
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportEditView();
        ms.a.f("EditVideoActivity", "\u3010doOnStop\u3011");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        super.doOnWindowFocusChanged(z16);
        this.f67748b0.P0(z16);
    }

    public void finish(int i3, Intent intent, int i16, int i17) {
        finish(i3, intent, i16, i17, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        return new a();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.aa
    public Intent getPublishIntent(fs.b bVar) {
        Bundle bundle;
        Intent intent = this.f67748b0.f67789i;
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
        String stringExtra = getIntent().getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra);
        ms.a.f("EditVideoActivity", "AIO send video---takeSameName=" + stringExtra);
        EditVideoDoodle editVideoDoodle = this.f67748b0.I;
        ArrayList<g.c> arrayList = (editVideoDoodle == null || editVideoDoodle.V() == null || this.f67748b0.I.V().C0() == null) ? null : this.f67748b0.I.V().C0().X;
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            for (g.c cVar : arrayList) {
                DynamicTextItem dynamicTextItem = cVar.f68001z;
                if (dynamicTextItem != null && dynamicTextItem.q() != null) {
                    jSONArray.mo162put(cVar.f68001z.q().toString());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + jSONArray.toString());
        }
        intent.putExtra("dynamic_text", jSONArray.toString());
        intent.putExtra(PublishParam.Z, bVar.f400396m);
        EditVideoParams editVideoParams = bVar.f400384a;
        if (editVideoParams != null && (bundle = editVideoParams.f204058h) != null) {
            intent.putExtra(AECameraConstants.ARG_AIO_CLASS, bundle.getString(AECameraConstants.ARG_AIO_CLASS));
        }
        com.tencent.aelight.camera.ae.camera.ui.simple.d.d(getIntent());
        return intent;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.aa
    public View getRootView() {
        return getWindow().getDecorView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity
    public void onOutOfMemory() {
        super.onOutOfMemory();
        hd0.c.t("EditVideoActivity", "onOutOfMemory");
        P2();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        hd0.c.v("EditVideoActivity", "onTrimMemory %d", Integer.valueOf(i3));
        P2();
    }

    public void finish(int i3, Intent intent, int i16, int i17, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("EditVideoActivity", 2, "finish, publishStoryFlag ", Boolean.valueOf(z16));
        }
        ((IAECameraUnit) QRoute.api(IAECameraUnit.class)).setPublishStoryFlag(z16);
        if (this.f67748b0.C.f204055d != 3) {
            com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().U(null, this, this.f67748b0.L());
            com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().T(null);
        }
        Bundle bundle = this.f67748b0.C.f204058h;
        if (bundle != null) {
            boolean z17 = bundle.getBoolean(PeakConstants.FROM_QQSTORY_SLIDESHOW, false);
            String string = this.f67748b0.C.f204058h.getString(PeakConstants.FROM_QQSTORY_SLIDESHOW_FILE_DATA);
            if (z17 && !TextUtils.isEmpty(string)) {
                if (intent == null) {
                    intent = new Intent();
                }
                intent.putExtra(PeakConstants.FROM_QQSTORY_SLIDESHOW_FILE_DATA, string);
            }
        }
        if (this.f67748b0.o1()) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(PeakConstants.KEY_EDIT_TO_PHOTO_LIST, true);
        }
        setResult(i3, intent);
        finish();
        overridePendingTransition(i17, i16);
        this.f67748b0.r0();
        P2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    private void M2() {
        View findViewById;
        View findViewById2 = findViewById(R.id.rpy);
        if (findViewById2 == null || !(findViewById2 instanceof ViewGroup) || (findViewById = findViewById(R.id.glm)) == null) {
            return;
        }
        ((ViewGroup) findViewById2).removeView(findViewById);
    }

    protected void K2(Bundle bundle) {
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends DefaultActivityModuleProvider {
        a() {
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            return new C0596a();
        }

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class C0596a extends SystemBarActivityModule {
            C0596a() {
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void initNavigationBarColor() {
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.aa
    /* renamed from: H2, reason: merged with bridge method [inline-methods] */
    public Activity getContext() {
        return this;
    }
}
