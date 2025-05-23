package com.tencent.aelight.camera.aeeditor;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorActivity extends PeakFragmentActivity {

    /* renamed from: b0, reason: collision with root package name */
    private ViewModelStore f66091b0;

    /* renamed from: c0, reason: collision with root package name */
    private ar.b f66092c0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f66096g0;

    /* renamed from: a0, reason: collision with root package name */
    private final LifecycleRegistry f66090a0 = new LifecycleRegistry(this);

    /* renamed from: d0, reason: collision with root package name */
    private List<b> f66093d0 = new ArrayList();

    /* renamed from: e0, reason: collision with root package name */
    private List<String> f66094e0 = new ArrayList();

    /* renamed from: f0, reason: collision with root package name */
    private List<String> f66095f0 = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements TAVCut.Callback {
        a() {
        }

        @Override // com.tencent.qcircle.tavcut.TAVCut.Callback
        public void onDone(int i3) {
            ms.a.f("AEEditorActivity", "TAVCut init ret code = " + i3);
            if (i3 != 0) {
                AEEditorActivity.this.f66093d0.add(new b(-9));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f66098a;

        public b(int i3) {
            this.f66098a = i3;
        }

        public String toString() {
            switch (this.f66098a) {
                case -9:
                    return "\u521d\u59cb\u5316TAVCut\u5931\u8d25";
                case -8:
                default:
                    return WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
                case -7:
                    return "\u52a0\u8f7dImageAlgo\u5931\u8d25";
                case -6:
                    return "\u52a0\u8f7dPAG\u5931\u8d25";
                case -5:
                    return "\u52a0\u8f7d\u4eba\u8138\u68c0\u6d4b\u5931\u8d25";
                case -4:
                    return "\u52a0\u8f7dPtuAlgo\u5931\u8d25";
                case -3:
                    return "\u52a0\u8f7dPtuTools\u5931\u8d25";
                case -2:
                    return "\u52a0\u8f7dYTCommon\u5931\u8d25";
                case -1:
                    return "\u521d\u59cb\u5316AEKit\u5931\u8d25";
                case 0:
                    return "\u521d\u59cb\u5316\u6210\u529f";
            }
        }
    }

    private void G2() {
        if (this.f66093d0.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<b> it = this.f66093d0.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString() + "\n");
            }
            ms.a.c("AEEditorActivity", "checkInitResult--" + sb5.toString());
            return;
        }
        VideoThumbProviderManager.initLruCacheSize(3072);
        Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.ixi);
        if (drawable instanceof BitmapDrawable) {
            VideoThumbProviderManager.getInstance().setDefaultBitmap(((BitmapDrawable) drawable).getBitmap());
        } else if (drawable instanceof SkinnableBitmapDrawable) {
            VideoThumbProviderManager.getInstance().setDefaultBitmap(((SkinnableBitmapDrawable) drawable).getBitmap());
        }
        H2();
    }

    private void H2() {
        Bundle bundle = new Bundle();
        if (getIntent().getExtras() != null) {
            bundle = getIntent().getExtras();
        }
        ar.b bVar = new ar.b(getSupportFragmentManager());
        this.f66092c0 = bVar;
        bVar.d(bundle);
    }

    private void J2() {
        if (!d.j()) {
            this.f66093d0.add(new b(-1));
        } else {
            K2(FeatureManager.Features.YT_COMMON.init(), -2);
            K2(FeatureManager.Features.PTU_TOOLS.init(), -3);
            K2(FeatureManager.Features.PTU_ALGO.init(), -4);
            K2(d.s(), -8);
            K2(FeatureManager.Features.PAG.init(), -6);
            K2(FeatureManager.Features.IMAGE_ALGO.init(), -7);
        }
        TAVCut.initTAVCut(getApplicationContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.y(), new a());
    }

    private void L2() {
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        if (getIntent().getIntExtra("editorType", 0) == 0) {
            str = QCircleDaTongConstant.PageId.PG_XSJ_EDIT_PICS;
        } else {
            str = QCircleDaTongConstant.PageId.PG_XSJ_EDIT_VIDEOS;
        }
        VideoReport.setPageId(this, str);
        VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("AEEditorActivity"));
        QLog.i("AEEditorActivity", 1, "reportDaTongRegister  subPage: AEEditorActivity");
    }

    private void M2(Lifecycle.Event event) {
        try {
            this.f66090a0.handleLifecycleEvent(event);
        } catch (Throwable unused) {
            QLog.e("AEEditorActivity", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    private void initReport() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("editorType", -1);
        int intExtra2 = intent.getIntExtra("editorFrom", -1);
        if (intExtra2 == js.a.A.b() || intExtra2 == js.a.C.b()) {
            if (intExtra == 0) {
                AEBaseReportParam.U().f().f65729u = AEBaseReportParam.U.longValue();
            } else if (intExtra == 1) {
                AEBaseReportParam.U().f().f65729u = AEBaseReportParam.V.longValue();
            } else {
                AEBaseReportParam.U().f().f65729u = AEBaseReportParam.T.longValue();
            }
        } else if (intExtra2 != js.a.B.b() && intExtra2 != js.a.D.b()) {
            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.T.longValue();
        } else if (intExtra == 0) {
            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.W.longValue();
        } else if (intExtra == 1) {
            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.X.longValue();
        } else {
            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.T.longValue();
        }
        AEBaseReportParam.U().f().f65712d = AEBaseReportParam.U().X();
    }

    public ar.b I2() {
        return this.f66092c0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        ms.a.f("AEEditorActivity", "doOnActivityResult---requestCode=" + i3 + ", resultCode=" + i16);
        ar.b bVar = this.f66092c0;
        if (bVar != null) {
            bVar.b(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        ar.b bVar = this.f66092c0;
        if (bVar != null) {
            bVar.f(this, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        i.c();
        this.f66096g0 = i.a();
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = true;
        SystemBarActivityModule.setImmersiveStatus(this, getResources().getColor(R.color.f9048l));
        try {
            super.doOnCreate(bundle);
        } catch (Exception e16) {
            QLog.e("AEEditorActivity", 4, "super.doOnCreate(savedInstanceState) \u5931\u8d25");
            e16.printStackTrace();
        }
        M2(Lifecycle.Event.ON_CREATE);
        setContentView(R.layout.dni);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f163788s05);
        frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop() + getStatusBarHeight(), frameLayout.getPaddingRight(), frameLayout.getPaddingBottom());
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
        J2();
        G2();
        com.tencent.aelight.camera.aeeditor.manage.a.registerModule();
        initReport();
        L2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        com.tencent.aelight.camera.aeeditor.manage.a.unRegisterModule();
        M2(Lifecycle.Event.ON_DESTROY);
        VideoThumbProviderManager.getInstance().release(String.valueOf(hashCode()));
        if (this.f66091b0 == null || isChangingConfigurations()) {
            return;
        }
        this.f66091b0.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.rnx);
        if (findFragmentById instanceof AEEditorVideoEditFragment) {
            Bundle bundle = new Bundle();
            bundle.putString(AEEditorConstants.AE_EDITOR_VIDEO_TEMPLATE_ID, intent.getExtras().getString(AEEditorConstants.AE_EDITOR_VIDEO_TEMPLATE_ID));
            bundle.putSerializable(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS, intent.getExtras().getSerializable(AEEditorConstants.AE_ALBUM_SELECTED_MEDIA_MODELS));
            bundle.putBoolean(AEEditorConstants.AE_VIDEO_EDITOR_ENTRANCE_MID_PAGE, intent.getExtras().getBoolean(AEEditorConstants.AE_VIDEO_EDITOR_ENTRANCE_MID_PAGE));
            bundle.putSerializable(AEEditorConstants.AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL, intent.getExtras().getSerializable(AEEditorConstants.AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL));
            ((AEEditorBaseFragment) findFragmentById).ph().i(null, bundle);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnPause() {
        super.doOnPause();
        M2(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnResume() {
        super.doOnResume();
        M2(Lifecycle.Event.ON_RESUME);
        VideoThumbProviderManager.getInstance().resume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        M2(Lifecycle.Event.ON_START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        M2(Lifecycle.Event.ON_STOP);
        VideoThumbProviderManager.getInstance().pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        super.doOnWindowFocusChanged(z16);
        ms.a.f("AEEditorActivity", "doOnWindowFocusChanged isFocused:" + z16);
        ar.b bVar = this.f66092c0;
        if (bVar != null) {
            bVar.c(z16);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.ViewModelStoreOwner
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        if (BaseApplicationImpl.getApplication() != null) {
            if (this.f66091b0 == null) {
                this.f66091b0 = new ViewModelStore();
            }
            return this.f66091b0;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    private void K2(boolean z16, int i3) {
        if (z16) {
            return;
        }
        this.f66093d0.add(new b(i3));
    }
}
