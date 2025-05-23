package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QzoneEditVideoActivity extends EditVideoActivity {

    /* renamed from: g0, reason: collision with root package name */
    private static final String f66354g0 = "QzoneEditVideoActivity";

    /* renamed from: d0, reason: collision with root package name */
    private QzEditVideoPartManager f66355d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f66356e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private QzoneVerticalVideoTopicInfo f66357f0;

    private void R2() {
        boolean booleanExtra = getIntent().getBooleanExtra(AECameraConstants.KEY_ENABLE_INPUT_TEXT, true);
        QzEditVideoPartManager qzEditVideoPartManager = this.f66355d0;
        qzEditVideoPartManager.D0 = booleanExtra;
        qzEditVideoPartManager.E0 = getIntent().getBooleanExtra("enable_sync_qzone", false);
        this.f66355d0.F0 = getIntent().getBooleanExtra(AECameraConstants.KEY_ENABLE_PRIV_LIST, true);
        if (!TextUtils.isEmpty(getIntent().getStringExtra("topic_id"))) {
            this.f66355d0.C0 = true;
        }
        this.f66355d0.H0 = getIntent().getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
        this.f66355d0.K0 = getIntent().getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
        this.f66355d0.L0 = getIntent().getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
    }

    private void S2() {
        this.f66355d0.N0 = U2();
        this.f66355d0.A0 = getIntent().getBooleanExtra("mIsQzoneVip", false);
    }

    private void T2() {
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = (QzoneVerticalVideoTopicInfo) getIntent().getParcelableExtra(PeakConstants.KEY_QZONE_TOPIC);
        this.f66357f0 = qzoneVerticalVideoTopicInfo;
        this.f66355d0.P0 = qzoneVerticalVideoTopicInfo;
    }

    private boolean U2() {
        int intExtra = getIntent().getIntExtra(PeakConstants.KEY_ENTRY_SOURCE, 0);
        return (intExtra == 3 || intExtra == 5) ? false : true;
    }

    private void V2(int i3, Intent intent, int i16, int i17, boolean z16) {
        Y2(intent);
        if (QLog.isColorLevel()) {
            QLog.i(f66354g0, 2, "QzoneEditVideoActivity finish --- resultCode : " + i3);
        }
        super.finish(i3, intent, i16, i17, z16);
    }

    private void Z2(String str, int i3, String str2, String str3, String str4, int i16, qs.c cVar, String str5, int i17, ArrayList<String> arrayList, boolean z16, int i18, int i19, String str6, int i26, String str7, boolean z17, boolean z18, boolean z19, boolean z26) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String parent = new File(str2).getParent();
        if (!TextUtils.isEmpty(str4)) {
            PtvFilterUtils.a(parent, str4);
        }
        VideoSendPublicParamBase videoSendPublicParamBase = new VideoSendPublicParamBase();
        videoSendPublicParamBase.mContext = this;
        videoSendPublicParamBase.mVideoCacheDir = parent;
        videoSendPublicParamBase.mEncodeMode = i3;
        videoSendPublicParamBase.mVideoFilePath = str2;
        videoSendPublicParamBase.mThumbFilePath = str3;
        videoSendPublicParamBase.mThumbWidth = 0;
        videoSendPublicParamBase.mThumbHeight = 0;
        videoSendPublicParamBase.fakeVid = str4;
        videoSendPublicParamBase.recordTime = i16;
        videoSendPublicParamBase.mUserCallBack = cVar;
        videoSendPublicParamBase.mContent = str5;
        videoSendPublicParamBase.mPriv = i17;
        videoSendPublicParamBase.mPrivUinList = arrayList;
        videoSendPublicParamBase.topicSyncQzone = z16;
        videoSendPublicParamBase.fontId = i18;
        videoSendPublicParamBase.fontFormatType = i19;
        videoSendPublicParamBase.fontUrl = str6;
        videoSendPublicParamBase.superFontId = i26;
        videoSendPublicParamBase.superFontInfo = str7;
        videoSendPublicParamBase.generateGif = z17;
        videoSendPublicParamBase.timerDelete = z18;
        videoSendPublicParamBase.isUploadOrigin = z26;
        videoSendPublicParamBase.entrySource = 3;
        videoSendPublicParamBase.mUin = "";
        videoSendPublicParamBase.mUinType = 0;
        videoSendPublicParamBase.mTroopUin = "";
        ((IMediaCodecSendTask) QRoute.api(IMediaCodecSendTask.class)).execute(videoSendPublicParamBase);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity
    protected void J2() {
        QzEditVideoPartManager qzEditVideoPartManager = new QzEditVideoPartManager(this);
        this.f66355d0 = qzEditVideoPartManager;
        this.f67748b0 = qzEditVideoPartManager;
        R2();
        S2();
        T2();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        QzEditVideoPartManager qzEditVideoPartManager = this.f66355d0;
        if (qzEditVideoPartManager != null) {
            qzEditVideoPartManager.V0 = true;
        }
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity, com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean doOnCreate = super.doOnCreate(bundle);
        findViewById(R.id.f163779rz1).setVisibility(8);
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity, com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        if (!this.f66356e0 && SlideShowPhotoListManager.n().m() == 22) {
            if (SlideShowPhotoListManager.n().l() == 19) {
                SlideShowPhotoListManager.n().A(14);
            } else if (SlideShowPhotoListManager.n().l() == 14) {
                SlideShowPhotoListManager.n().B(20);
                SlideShowPhotoListManager.n().A(99);
            }
        }
        if (this.f66356e0) {
            this.f66356e0 = false;
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity, com.tencent.aelight.camera.aioeditor.takevideo.aa
    public void finish(int i3, Intent intent, int i16, int i17) {
        if (this.f66355d0.V0) {
            V2(i3, intent, i16, i17, false);
        } else {
            V2(i3, intent, i16, i17, true);
        }
    }

    private void Y2(Intent intent) {
        QzEditVideoPartManager qzEditVideoPartManager;
        if (intent == null || (qzEditVideoPartManager = this.f66355d0) == null) {
            return;
        }
        intent.putExtra("key_content", qzEditVideoPartManager.f66344z0);
        intent.putExtra(AEEditorConstants.KEY_TOPIC_SYNC_QZONE, this.f66355d0.B0);
        intent.putExtra("key_priv", this.f66355d0.f66341w0);
        intent.putExtra(AEEditorConstants.KEY_PRIV_UIN_LIST, this.f66355d0.f66340v0);
        intent.putExtra(AEEditorConstants.KEY_FONT_ID, this.f66355d0.H0);
        intent.putExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, this.f66355d0.I0);
        intent.putExtra(AEEditorConstants.KEY_FONT_URL, this.f66355d0.J0);
        intent.putExtra(AEEditorConstants.KEY_SUPER_FONT_ID, this.f66355d0.K0);
        intent.putExtra(AEEditorConstants.KEY_SUPER_FONT_INFO, this.f66355d0.L0);
        intent.putExtra(AEEditorConstants.KEY_TIMER_DELETE, this.f66355d0.S0);
        intent.putExtra(AEEditorConstants.KEY_SYNC_TO_QQSTORY, this.f66355d0.Q0);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, this.f66355d0.R0);
        if (SlideShowPhotoListManager.n().l() == 14 || SlideShowPhotoListManager.n().l() == 19) {
            Q2(intent);
        }
        QLog.i(f66354g0, 2, "QzoneEditVideoActivity " + intent.getExtras());
    }

    public void W2(Intent intent) {
        Bundle extras;
        String str;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        EditVideoParams editVideoParams = (EditVideoParams) extras.getParcelable(EditVideoParams.class.getName());
        if (editVideoParams != null) {
            str = editVideoParams.a();
        } else {
            str = "can not find EditVideoParams";
        }
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.rse) + str, 0).show();
            finish();
            return;
        }
        doOnPause();
        doOnStop();
        doOnDestroy();
        setIntent(intent);
        doOnCreate(null);
        doOnResume();
        this.f66355d0.f67794m.dismissLoadingDialog();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity, com.tencent.aelight.camera.aioeditor.takevideo.aa
    public void finish(int i3, Intent intent, int i16, int i17, boolean z16) {
        V2(i3, intent, i16, i17, z16);
    }

    private boolean Q2(Intent intent) {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra("key_content");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str = stringExtra;
        int intExtra = intent.getIntExtra("key_priv", 1);
        ArrayList<String> arrayList = (ArrayList) intent.getSerializableExtra(AEEditorConstants.KEY_PRIV_UIN_LIST);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList<String> arrayList2 = arrayList;
        if (getContext().getIntent() != null) {
            getContext().getIntent().putExtra("from_qzone_slideshow", true);
        }
        int intExtra2 = intent.getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
        int intExtra3 = intent.getIntExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, 0);
        String stringExtra2 = intent.getStringExtra(AEEditorConstants.KEY_FONT_URL);
        int intExtra4 = intent.getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
        String stringExtra3 = intent.getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
        boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.KEY_GENERATE_GIF, false);
        boolean booleanExtra2 = intent.getBooleanExtra(AEEditorConstants.KEY_TIMER_DELETE, false);
        boolean booleanExtra3 = intent.getBooleanExtra(AEEditorConstants.KEY_SYNC_TO_QQSTORY, false);
        PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
        int i3 = publishParam.I;
        Z2(publishParam.Q, i3 <= 5 ? i3 : 0, publishParam.P, publishParam.f69067e, publishParam.f69066d, (int) publishParam.E, null, str, intExtra, arrayList2, false, intExtra2, intExtra3, stringExtra2, intExtra4, stringExtra3, booleanExtra, booleanExtra2, booleanExtra3, intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, false));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity, com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1 && i3 == 666 && intent != null && intent.getBooleanExtra("key_is_qzone_slide_show_edited", false)) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("qzone_slide_show_matters");
            SlideShowPhotoListManager.n().D(parcelableArrayListExtra);
            SlideShowPhotoListManager.n().C(parcelableArrayListExtra);
            getIntent().putExtra("from_qzone_slideshow", true);
            getIntent().putExtra("edit_video_type", 10001);
            getIntent().putExtra("qq_sub_business_id", 3);
            getIntent().putExtra("qzone_slide_enable_mask", 50043L);
            this.f66355d0.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.rsa), false, 500L);
            this.f66355d0.u1();
            this.f66356e0 = true;
            ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).o(this);
            SlideShowPhotoListManager.n().i(this, null, 2);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
    }
}
