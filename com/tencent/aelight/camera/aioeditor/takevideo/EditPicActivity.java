package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.artfilter.ArtFilterBridgeActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicConfig;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.zplan.api.impl.ZPlanEditPicPartManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: classes32.dex */
public class EditPicActivity extends QQStoryBaseActivity implements aa {
    public static final String EXTRA_SKIP_ArtFilterBridgeActivity = "EXTRA_SKIP_ArtFilterBridgeActivity";
    public static final String IMAGE_PATH = "image_path";
    public static final int REQUEST_CODE_RE_CAMERA = 666;
    public static final int REQUEST_PIC_FORWARD_ACTIVITY = 1000;
    public static final int REQUEST_WEBPIC_UPLOAD_ACTIVITY = 1001;
    public static final String SP_KEY_NEW_PATH = "edit_pic_new_path";
    public static final String TAG = "EditPicActivity";
    private EditVideoParams mEditVideoParams;
    protected EditVideoPartManager mEditVideoPartManager;
    public long photoId;
    private RelativeLayout topTransPantH;
    private boolean mUsingNewPicEditor = false;
    public long mCreateTime = -1;
    qs.b mDoodleInfoLoadObserver = new b();

    /* loaded from: classes32.dex */
    class b extends qs.b {
        b() {
        }

        @Override // qs.b
        public void a() {
            hd0.c.k(EditPicActivity.TAG, "DoodleInfoLoadObserver, onLoadSucc");
            d dVar = (d) EditPicActivity.this.mEditVideoPartManager.R(d.class);
            if (dVar != null) {
                dVar.C();
            }
        }
    }

    private void adjustForTalkback(EditVideoParams.EditSource editSource) {
        View findViewById;
        if (!AppSetting.f99565y || (findViewById = findViewById(R.id.rrd)) == null) {
            return;
        }
        if (!(editSource instanceof EditTakePhotoSource) && !(editSource instanceof EditTakeVideoSource)) {
            findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        } else {
            findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.lz8));
        }
    }

    private void adjustUIForEditPage(boolean z16) {
        Resources resources = getResources();
        ImageView imageView = (ImageView) findViewById(R.id.rrd);
        imageView.setPadding(BaseAIOUtils.f(10.0f, resources), 0, BaseAIOUtils.f(10.0f, resources), BaseAIOUtils.f(24.0f, resources));
        imageView.setImageResource(R.drawable.ncv);
        PressDarkImageButton pressDarkImageButton = (PressDarkImageButton) findViewById(R.id.s2v);
        if (z16) {
            pressDarkImageButton.setPadding(0, 0, 0, BaseAIOUtils.f(20.0f, resources));
        } else {
            pressDarkImageButton.setPadding(0, 0, 0, BaseAIOUtils.f(20.0f, resources));
            pressDarkImageButton.setImageResource(R.drawable.ncx);
        }
    }

    private boolean checkPhotoExist(EditVideoParams editVideoParams) {
        return (!TextUtils.isEmpty(editVideoParams.f204059i.getSourcePath()) && FileUtils.fileExists(editVideoParams.f204059i.getSourcePath())) || g.f(editVideoParams.E);
    }

    public static Intent compactAPI21SystemShare(Intent intent) {
        int flags = intent.getFlags();
        if ((524288 & flags) > 0) {
            intent.setFlags(flags & (-524289));
        }
        return intent;
    }

    private EditVideoPartManager createDefaultPartManager() {
        if (isUsingNewPicEditor()) {
            return new k();
        }
        return new EditPicPartManager();
    }

    private void initLiuHaiScreenTopBar() {
        if (LiuHaiUtils.needShowLiuHaiTopBar()) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rwf);
            this.topTransPantH = relativeLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.height = LiuHaiUtils.LiuHaiTopBarHeight();
            this.topTransPantH.setLayoutParams(layoutParams);
            this.topTransPantH.setVisibility(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0056, code lost:
    
        if (r0 != 146) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isUsingNewPicEditor() {
        boolean z16;
        EditVideoParams editVideoParams = this.mEditVideoParams;
        boolean z17 = false;
        if (editVideoParams != null && editVideoParams.r()) {
            EditVideoParams editVideoParams2 = this.mEditVideoParams;
            int i3 = editVideoParams2.f204055d;
            int k3 = editVideoParams2.k();
            if (i3 == 2) {
                if (k3 == 140 || k3 == 142) {
                    AEBaseReportParam.U().I0(2);
                } else if (k3 == 126) {
                    AEBaseReportParam.U().I0(3);
                } else if (k3 == 11 || k3 == 9 || k3 == 10 || k3 == 1000) {
                    AEBaseReportParam.U().I0(1);
                } else if (k3 != 125) {
                    if (k3 != 134) {
                        if (k3 != 128) {
                            if (k3 != 130) {
                                if (k3 != 122) {
                                }
                            }
                        }
                    }
                }
                z16 = true;
                AppInterface appInterface = this.mApp;
                boolean isFeatureSwitchEnable = appInterface == null ? ((IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qq_use_new_aio_pic_editor") : true;
                ms.a.i(TAG, "[doOnCreate] businessId=" + i3 + ", entranceType=" + k3 + ", isConfigUseNewAIOPicEditor=" + isFeatureSwitchEnable);
                if (z16 && isFeatureSwitchEnable) {
                    z17 = true;
                }
                this.mUsingNewPicEditor = z17;
            } else if (i3 == 3) {
                AEBaseReportParam.U().I0(4);
            }
            z16 = false;
            AppInterface appInterface2 = this.mApp;
            if (appInterface2 == null) {
            }
            ms.a.i(TAG, "[doOnCreate] businessId=" + i3 + ", entranceType=" + k3 + ", isConfigUseNewAIOPicEditor=" + isFeatureSwitchEnable);
            if (z16) {
                z17 = true;
            }
            this.mUsingNewPicEditor = z17;
        }
        return z17;
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3) {
        return startEditPic(activity, str, z16, z17, z18, z19, z26, i3, 99, 0, false, null, null);
    }

    protected EditVideoPartManager createEditVideoPartManager() {
        if (this.mEditVideoParams.e() != 16) {
            return createDefaultPartManager();
        }
        return new ZPlanEditPicPartManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        super.doOnActivityResult(i3, i16, intent);
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager == null) {
            QLog.e(TAG, 1, "doOnActivityResult error, mEditVideoPartManager is null!");
            return;
        }
        editVideoPartManager.s0(i3, i16, intent);
        hd0.c.k(TAG, "doOnActivityResult");
        if (i3 != 666) {
            if (i3 == 1000) {
                if (i16 == -1) {
                    finish(i16, intent, R.anim.dialog_exit, 0);
                    this.mEditVideoPartManager.s0(i3, i16, intent);
                    return;
                }
                return;
            }
            if (i3 == 1001) {
                finish(i16, intent, R.anim.dialog_exit, 0);
                return;
            }
            if (i3 == 19003) {
                if (i16 == -1) {
                    finish(i16, intent, R.anim.dialog_exit, 0);
                    return;
                } else {
                    if (i16 == 0 && intent != null && intent.getBooleanExtra("NOCANCEL4DATALIN", false)) {
                        finish(-1, intent, R.anim.dialog_exit, 0);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i16 == -1) {
            Intent intent2 = getIntent();
            intent2.setClass(this, EditPicActivity.class);
            if (intent2.getIntExtra("camera_type", -1) == 103) {
                stringExtra = this.mEditVideoPartManager.C.f204059i.getSourcePath();
            } else {
                stringExtra = intent2.getStringExtra(IMAGE_PATH);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reset2Camera end shoot " + this + " new path " + stringExtra);
            }
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = PreferenceManager.getDefaultSharedPreferences(this).getString(SP_KEY_NEW_PATH, "");
                QLog.d(TAG, 1, " be killed. read sp " + stringExtra);
            }
            if (!FileUtils.fileExists(stringExtra)) {
                QLog.i(TAG, 1, "recamera file not exist " + stringExtra);
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lwk), 0).show();
                finish();
                return;
            }
            EditVideoParams editVideoParams = this.mEditVideoPartManager.C;
            intent2.putExtra(EditVideoParams.class.getName(), new EditVideoParams(editVideoParams.f204055d, editVideoParams.f204057f, new EditTakePhotoSource(stringExtra), new Bundle()));
            finish();
            startActivity(intent2);
            return;
        }
        hd0.c.k(TAG, "recamera cancel, finish");
        finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        hd0.c.k(TAG, "doOnBackPressed");
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager == null || !editVideoPartManager.t0()) {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        i iVar;
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lwl), 0).show();
            finish();
            return true;
        }
        LiuHaiUtils.resetAllLiuHaiStatus();
        LiuHaiUtils.resetFullScreen(this);
        LiuHaiUtils.initLiuHaiBarHeight(this);
        if (LiuHaiUtils.needShowLiuHaiTopBar()) {
            LiuHaiUtils.enableNotch(this);
        }
        com.tencent.sveffects.a.b();
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).initWithConfig();
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        this.isClearCoverLayer = false;
        super.getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        super.doOnCreate(bundle);
        h.a();
        this.mEditVideoParams = (EditVideoParams) getIntent().getParcelableExtra(EditVideoParams.class.getName());
        com.tencent.aelight.camera.aioeditor.activity.richmedia.c.e("finish jump activity", com.tencent.aelight.camera.aioeditor.activity.richmedia.c.a(getIntent()));
        hd0.c.v(TAG, "doOnCreate instance=%d, video params=%s", Integer.valueOf(System.identityHashCode(this)), this.mEditVideoParams);
        if (checkPhotoEmpty(this.mEditVideoParams)) {
            finish();
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "source " + this.mEditVideoParams.f204059i.getSourcePath());
        }
        if (!checkPhotoExist(this.mEditVideoParams)) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.lwo), 0).show();
            finish();
            return true;
        }
        this.photoId = this.mEditVideoParams.E;
        int intExtra = getIntent().getIntExtra(AECameraConstants.KEY_EDITPIC_CAMERATYPE, -1);
        if (intExtra == 1) {
            com.tencent.aelight.camera.aioeditor.activity.richmedia.c.j();
            BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
        } else if (intExtra == 2) {
            com.tencent.aelight.camera.aioeditor.activity.richmedia.c.i();
        }
        vq.a.f443174a.d(this, "pg_ae_camera_photo_save");
        AEBaseReportParam.U().c();
        EditVideoParams.EditSource editSource = this.mEditVideoParams.f204059i;
        if (editSource instanceof EditTakePhotoSource) {
            AEBaseReportParam.U().D0(AEBaseReportParam.U.longValue());
        } else if (editSource instanceof EditTakeVideoSource) {
            AEBaseReportParam.U().D0(AEBaseReportParam.V.longValue());
        } else if (editSource instanceof EditLocalPhotoSource) {
            AEBaseReportParam.U().D0(AEBaseReportParam.W.longValue());
        } else if (editSource instanceof EditLocalVideoSource) {
            AEBaseReportParam.U().D0(AEBaseReportParam.X.longValue());
        }
        EditVideoPartManager createEditVideoPartManager = createEditVideoPartManager();
        this.mEditVideoPartManager = createEditVideoPartManager;
        int W = createEditVideoPartManager.W();
        this.mEditVideoPartManager.g1(getIntent().getIntExtra(IJumpUtil.EDIT_VIDEO_WAY, 0));
        try {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSo();
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSoWithConfig();
            if (VideoEnvironment.loadAVCodecSo() != 0) {
                hd0.c.g(TAG, "load AVCodec so failed");
            }
        } catch (Exception e16) {
            hd0.c.h(TAG, "load so failed", e16);
        }
        this.mEditVideoPartManager.V = true;
        setContentViewC(W);
        EditVideoParams editVideoParams = this.mEditVideoParams;
        if (editVideoParams.f204055d == 2 && editVideoParams.k() == 142) {
            adjustUIForEditPage(this.mUsingNewPicEditor);
        }
        initLiuHaiScreenTopBar();
        this.mEditVideoPartManager.r(this, this.mEditVideoParams);
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        EditPicRawImage editPicRawImage = editVideoPartManager.L;
        if (editPicRawImage != null && (iVar = editVideoPartManager.M) != null) {
            editPicRawImage.f67709h = false;
            iVar.N = false;
        }
        com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
        dVar.l(this.mEditVideoPartManager.C.e());
        this.mEditVideoPartManager.u0();
        adjustForTalkback(editSource);
        PtvTemplateManager.j().m(this.mApp, this.mDoodleInfoLoadObserver);
        Bundle bundle2 = this.mEditVideoParams.f204058h;
        if (bundle2 != null) {
            int i3 = bundle2.getInt(AEEditorConstants.PIC_ENTRANCE_TYPE, 0);
            id0.b.l(i3);
            ms.a.a(TAG, "picEntanceType=" + i3);
        }
        fs.g.b(null);
        this.mCreateTime = System.currentTimeMillis();
        int K = this.mEditVideoPartManager.K();
        int k3 = this.mEditVideoPartManager.C.k();
        int Y = this.mEditVideoPartManager.Y();
        getIntent().putExtra(ShortVideoConstants.CAPTURE_OPERATION_IN, Y);
        id0.a.n("video_edit_new", "edit_exp", Y, 0, id0.a.b(K), "", "", String.valueOf(k3));
        dVar.f(1);
        dVar.p(4);
        com.tencent.mobileqq.shortvideo.c.d("0X800B3C4", this.mEditVideoParams.k());
        com.tencent.aelight.camera.ae.camera.ui.simple.d.c(getIntent());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        hd0.c.l(TAG, "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.w0();
        }
        com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) fr.f.c(13);
        if (dVar != null) {
            dVar.f(1);
        }
        g.g(this.photoId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        hd0.c.k(TAG, "doOnPause");
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.C0();
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        hd0.c.k(TAG, "doOnResume");
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.H0();
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.c.d("resume activity");
        ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).o(1);
        if (Build.VERSION.SDK_INT >= 29) {
            com.tencent.biz.subscribe.utils.g.c(getWindow());
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        hd0.c.k(TAG, "doOnStart");
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.M0();
            id0.b.f407532a = id0.b.a(this.mEditVideoPartManager.C.f204055d);
        }
        id0.b.f407533b = "pic_edit";
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportEditViewExpose();
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setShootTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.N0();
        }
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportEditView();
        ms.a.f(TAG, "\u3010doOnStop\u3011");
        id0.b.f407532a = "";
        id0.b.f407533b = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        super.doOnWindowFocusChanged(z16);
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.P0(z16);
        }
    }

    public void finish(int i3, Intent intent, int i16, int i17) {
        finish(i3, intent, i16, i17, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        return new a();
    }

    public EditVideoPartManager getManager() {
        return this.mEditVideoPartManager;
    }

    public Intent getPublishIntent(fs.b bVar) {
        Intent intent;
        String str;
        EditVideoDoodle editVideoDoodle;
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager == null || (intent = editVideoPartManager.f67789i) == null) {
            intent = getIntent();
        }
        String stringExtra = intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME);
        String stringExtra2 = intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME);
        QLog.d(TAG, 1, "getPublishIntent sessionWrap: " + ((SessionWrap) intent.getParcelableExtra(AECameraConstants.ARG_SESSION_INFO)));
        if (stringExtra != null && stringExtra2 != null) {
            if (SplashActivity.class.getName().equals(stringExtra)) {
                intent.setClassName(stringExtra2, SplashActivity.getAliasName());
            } else {
                intent.setClassName(stringExtra2, stringExtra);
            }
            intent.putExtra("open_chatfragment_fromphoto", true);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        fs.g gVar = bVar.f400395l;
        if (!gVar.f400422h && gVar.f400421g) {
            str = gVar.f400416b;
            if (getIntent().getIntExtra("camera_type", -1) != -1) {
                if (com.tencent.aelight.camera.ae.util.c.f(getContext(), new File(bVar.f400395l.f400415a))) {
                    FileUtils.deleteFile(bVar.f400395l.f400415a);
                }
                BaseImageUtil.savePhotoToSysAlbum(this, bVar.f400395l.f400415a);
            }
            intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        } else {
            QLog.d(TAG, 1, "send sourcePath");
            EditVideoPartManager editVideoPartManager2 = this.mEditVideoPartManager;
            if (editVideoPartManager2 != null) {
                str = editVideoPartManager2.C.f204059i.getSourcePath();
            } else {
                str = "";
            }
        }
        arrayList.add(str);
        EditVideoPartManager editVideoPartManager3 = this.mEditVideoPartManager;
        ArrayList<g.c> arrayList2 = (editVideoPartManager3 == null || (editVideoDoodle = editVideoPartManager3.I) == null || editVideoDoodle.V() == null || this.mEditVideoPartManager.I.V().C0() == null) ? null : this.mEditVideoPartManager.I.V().C0().X;
        JSONArray jSONArray = new JSONArray();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (g.c cVar : arrayList2) {
                DynamicTextItem dynamicTextItem = cVar.f68001z;
                if (dynamicTextItem != null && dynamicTextItem.q() != null) {
                    jSONArray.mo162put(cVar.f68001z.q().toString());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + jSONArray.toString());
        }
        if (jSONArray.length() > 0) {
            intent.putExtra("dynamic_text", jSONArray.toString());
        }
        intent.putExtra(PublishParam.Z, bVar.f400396m);
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
        fs.g gVar2 = bVar.f400395l;
        boolean z16 = gVar2.f400422h || !gVar2.f400421g;
        intent.putExtra(PeakConstants.SEND_PICTURE_ORIGIN, z16);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, z16 ? 2 : 0);
        intent.putExtra(PeakConstants.SEND_FLAG, true);
        intent.addFlags(603979776);
        EditVideoPartManager editVideoPartManager4 = this.mEditVideoPartManager;
        if (editVideoPartManager4 != null && (editVideoPartManager4.C.t() || booleanExtra)) {
            intent.putExtra(PeakConstants.KEY_MULIT_EDIT_SOURTH_PATH, this.mEditVideoPartManager.C.f204059i.getSourcePath());
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + intent.getFlags() + ",data = " + intent.getExtras());
        }
        if (stringExtra != null && stringExtra.contains("ForwardRecentActivity")) {
            intent = compactAPI21SystemShare(intent);
        }
        String stringExtra3 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String stringExtra4 = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initClassName:" + stringExtra3 + ", dstClassName=" + stringExtra4 + ", selClassName=" + stringExtra);
        }
        if (stringExtra3 != null) {
            if (intent.getBooleanExtra(PeakConstants.KEY_BACK_TO_INIT_CLASS, false)) {
                String stringExtra5 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
                if (SplashActivity.class.getName().equals(stringExtra3)) {
                    intent.setClassName(stringExtra5, SplashActivity.getAliasName());
                } else {
                    intent.setClassName(stringExtra5, stringExtra3);
                }
            } else if ((com.tencent.aelight.camera.ae.util.r.a(stringExtra3) || ChatActivity.class.getName().equals(stringExtra3)) && (("com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(stringExtra) || "com.tencent.qqnt.qbasealbum.WinkHomeActivity".equals(stringExtra)) && "com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(stringExtra4))) {
                String stringExtra6 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
                if (SplashActivity.class.getName().equals(stringExtra3)) {
                    intent.setClassName(stringExtra6, SplashActivity.getAliasName());
                } else {
                    intent.setClassName(stringExtra6, stringExtra3);
                }
            } else if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(stringExtra)) {
                intent.setClassName("com.tencent.mobileqq", stringExtra3);
            }
        }
        intent.putExtra("open_chatfragment_fromphoto", true);
        intent.putExtra(PeakConstants.VIDEO_LOCATE_DESCRIPTION, bVar.f400387d.videoLocationDescription);
        intent.putExtra(PeakConstants.VIDEO_LOCAL_LONGITUDE, bVar.f400387d.videoLongitude);
        intent.putExtra(PeakConstants.VIDEO_LOCAL_LATITUDE, bVar.f400387d.videoLatitude);
        ms.a.f(TAG, "AIO send photo---takeSameName=" + intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME));
        com.tencent.aelight.camera.ae.camera.ui.simple.d.d(getIntent());
        return intent;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.aa
    public View getRootView() {
        return getWindow().getDecorView();
    }

    public void setEditVideoPartManager(EditVideoPartManager editVideoPartManager) {
        this.mEditVideoPartManager = editVideoPartManager;
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17) {
        return startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, 0, false, null, null);
    }

    public void finish(int i3, Intent intent, int i16, int i17, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "finish, publishStoryFlag", Boolean.valueOf(z16));
        }
        ((IAECameraUnit) QRoute.api(IAECameraUnit.class)).setPublishStoryFlag(z16);
        setResult(i3, intent);
        finish();
        overridePendingTransition(i17, i16);
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager != null) {
            editVideoPartManager.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    private boolean checkPhotoEmpty(EditVideoParams editVideoParams) {
        return editVideoParams == null || (TextUtils.isEmpty(editVideoParams.f204059i.getSourcePath()) && editVideoParams.E <= 0);
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, HashMap<String, Object> hashMap) {
        return startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, 0, false, hashMap, null);
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, Bundle bundle) {
        return startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, 0, false, null, bundle);
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i3, int i16, int i17, boolean z36, HashMap<String, Object> hashMap) {
        return startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, i17, z36, hashMap, null);
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i3, int i16, int i17, boolean z36, HashMap<String, Object> hashMap, Bundle bundle) {
        return startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, i17, z36, hashMap, bundle);
    }

    public static Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, boolean z27, HashMap<String, Object> hashMap, Bundle bundle) {
        boolean isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady();
        QLog.d(TAG, 1, "startEditPic busi=", Integer.valueOf(i3), ", entranceType=", Integer.valueOf(i16), ", isAEResReady=", Boolean.valueOf(isCameraResReady), ", picEntranceType=", Integer.valueOf(i17), ", extra=", bundle);
        if (!isCameraResReady) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
        }
        Bundle extras = activity.getIntent().getExtras();
        Intent intent = new Intent();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setClass(activity, bundle != null ? bundle.getBoolean(EXTRA_SKIP_ArtFilterBridgeActivity, false) : false ? EditPicActivity.class : ArtFilterBridgeActivity.class);
        if (!intent.hasExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME)) {
            if (activity instanceof SplashActivity) {
                intent.putExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, SplashActivity.getAliasName());
            } else {
                intent.putExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, activity.getClass().getName());
            }
        }
        intent.putExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        if (activity instanceof SplashActivity) {
            intent.putExtra("key_activity_code", ChatActivityUtils.p(activity));
        }
        intent.putExtra("open_chatfragment", true);
        long j3 = z16 ? i3 == 2 ? 132096L : 1024L : 0L;
        if (MosaicConfig.a()) {
            j3 |= 262144;
        }
        if (i3 == 2) {
            j3 |= 524288;
        }
        if (z17) {
            j3 |= 1;
        }
        if (z18) {
            j3 |= 8;
        }
        if (z19) {
            j3 |= 4;
        }
        if (z26) {
            j3 |= 64;
        }
        if (i3 == 2 || i3 == 6) {
            j3 = j3 | 2048 | 512 | 65536 | 64 | 8192;
        }
        if (i3 == 8 || i3 == 4 || i3 == 3) {
            j3 |= 512;
        }
        if (i3 == 15) {
            j3 |= 512;
        }
        if (bundle != null && bundle.getBoolean("key_multi_edit_pic", false)) {
            intent.putExtra("key_multi_edit_pic", true);
        }
        if (i3 != 8) {
            j3 |= 4096;
        }
        if (i16 == 122 || i16 == 125 || i16 == 133 || EditVideoParams.u(i16)) {
            j3 &= -513;
        }
        long j16 = j3;
        SessionWrap sessionWrap = (SessionWrap) activity.getIntent().getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
        if (sessionWrap != null) {
            QLog.d(TAG, 1, "startEditPic SessionWrap: " + sessionWrap);
            intent.putExtra("uin", sessionWrap.f394447d);
            intent.putExtra("uintype", sessionWrap.f394449f);
            intent.putExtra("troop_uin", sessionWrap.f394450h);
            intent.putExtra("uinname", sessionWrap.f394448e);
        }
        QLog.d(TAG, 1, "startEditPic param: " + j16);
        intent.putExtra("EDIT_BUSI", i3);
        intent.putExtra("entrance_type", i16);
        intent.putExtra(AEEditorConstants.PIC_ENTRANCE_TYPE, i17);
        intent.putExtra("TEMP_PARAM", j16);
        intent.putExtra(AEEditorConstants.PATH, str);
        intent.putExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, z27);
        if (hashMap != null) {
            intent.putExtra("user_params", hashMap);
        }
        intent.removeExtra("camera_type");
        return activity.getClass().getName().contains("ForwardRecentActivity") ? compactAPI21SystemShare(intent) : intent;
    }

    /* loaded from: classes32.dex */
    class a extends DefaultActivityModuleProvider {
        a() {
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            return new C0588a();
        }

        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class C0588a extends SystemBarActivityModule {
            C0588a() {
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void initNavigationBarColor() {
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.aa
    public Context getContext() {
        return this;
    }
}
