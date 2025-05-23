package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoActivity;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.soter.core.biometric.FaceManager;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.util.GpsComplementUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class AEPituQzoneCameraUnit extends AEPituCameraUnit {
    private static final String P1 = "AEPituQzoneCameraUnit";
    private String A1;
    private int B1;
    private String C1;
    private boolean D1;
    private boolean E1;
    private boolean F1;
    private boolean G1;
    private QzoneVerticalVideoTopicInfo H1;
    private String I1;
    private String J1;
    private int K1;
    private qs.c L1;
    public boolean M1;
    public long N1;
    public String O1;

    /* renamed from: v1, reason: collision with root package name */
    private int f65998v1;

    /* renamed from: w1, reason: collision with root package name */
    private Bundle f65999w1;

    /* renamed from: x1, reason: collision with root package name */
    private String f66000x1;

    /* renamed from: y1, reason: collision with root package name */
    private int f66001y1;

    /* renamed from: z1, reason: collision with root package name */
    private int f66002z1;

    public AEPituQzoneCameraUnit(or.e eVar, or.d dVar) {
        super(eVar, dVar);
        this.f65998v1 = 10001;
        this.f66001y1 = -1;
        this.K1 = 0;
        this.L1 = null;
        this.M1 = false;
        this.N1 = System.currentTimeMillis();
        this.O1 = BaseApplication.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + this.N1;
        this.P = new or.a(10001, 122, 3);
        this.V = 12;
    }

    private void D3(AEVideoCaptureResult aEVideoCaptureResult) {
        if (QLog.isColorLevel()) {
            QLog.d(P1, 2, "intentToEditVideoActivityFromQzone start!");
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("entrance_type", w3());
            bundle.putString("extra_publish_text", this.f66000x1);
            bundle.putBoolean("enable_hw_encode", true);
            bundle.putBoolean("extra_enable_revert", true);
            bundle.putBoolean("extra_enable_slow", true);
            QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = this.H1;
            int i3 = (qzoneVerticalVideoTopicInfo == null || !qzoneVerticalVideoTopicInfo.hasMusic()) ? AppConstants.RiskHintTemplate.TEMPLATE_TYPE_RISK_FOR_PROTECT : FaceManager.FACE_ACQUIRED_MULTI_FACE;
            boolean z16 = this.f65999w1.getBoolean(AECameraConstants.KEY_ENABLE_EDIT_BUTTON, true);
            EditTakeVideoSource editTakeVideoSource = new EditTakeVideoSource(aEVideoCaptureResult.videoMp4FilePath, aEVideoCaptureResult.audioDataFilePath, this.N);
            if (!z16) {
                i3 = 0;
            }
            EditVideoParams editVideoParams = new EditVideoParams(3, i3, editTakeVideoSource, bundle);
            editVideoParams.f204058h.putBoolean("enable_hw_encode", true);
            if (QLog.isColorLevel()) {
                QLog.d(P1, 2, "intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:" + editVideoParams.toString() + ", recordFinish---startEdit");
            }
            if (z() != null && !z().isFinishing()) {
                Intent intent = new Intent(z(), (Class<?>) QzoneEditVideoActivity.class);
                intent.putExtra(EditVideoParams.class.getName(), editVideoParams);
                intent.putExtra(AEEditorConstants.KEY_FONT_ID, this.f66001y1);
                intent.putExtra("op_department", "grp_qzone");
                intent.putExtra("op_type", "video_edit");
                intent.putExtra("topic_id", this.I1);
                intent.putExtra(AECameraConstants.KEY_ENABLE_PRIV_LIST, this.D1);
                intent.putExtra(AECameraConstants.KEY_ENABLE_INPUT_TEXT, this.E1);
                intent.putExtra("stop_record_time", System.currentTimeMillis());
                intent.putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, "UseQQCameraCompression", 2));
                intent.putExtra(PeakConstants.KEY_ENTRY_SOURCE, this.f65999w1.getInt(PeakConstants.KEY_ENTRY_SOURCE, 0));
                intent.putExtra(PeakConstants.KEY_TAKE_DANCING_VIDEO, false);
                intent.putExtra(PeakConstants.KEY_QZONE_TOPIC, this.H1);
                this.f61817h.getActivity().startActivityForResult(intent, 1011);
                this.f61817h.getActivity().overridePendingTransition(0, 0);
                if (QLog.isColorLevel()) {
                    QLog.d(P1, 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
                }
            }
        } catch (Exception e16) {
            QLog.e(P1, 1, "intentToEditVideoActivityFromQzone exception:" + e16);
        }
    }

    private void E3(Bundle bundle) {
        if (z() == null || z().isFinishing()) {
            return;
        }
        this.I1 = bundle.getString("topic_id");
        this.J1 = bundle.getString("short_video_refer");
        qs.c cVar = (qs.c) ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback();
        this.L1 = cVar;
        cVar.setRefer(this.J1);
        this.f66000x1 = bundle.getString(AECameraConstants.KEY_CONFIRM_TEXT);
        this.D1 = bundle.getBoolean(AECameraConstants.KEY_ENABLE_PRIV_LIST, true);
        this.E1 = bundle.getBoolean(AECameraConstants.KEY_ENABLE_INPUT_TEXT, true);
        this.F1 = bundle.getBoolean("is_qzone_vip", false);
        this.G1 = bundle.getBoolean(ShortVideoConstants.ENABLE_EDIT_VIDEO, false);
        this.H1 = (QzoneVerticalVideoTopicInfo) bundle.getParcelable(PeakConstants.KEY_QZONE_TOPIC);
        this.K1 = bundle.getInt(PeakConstants.KEY_ENTRY_SOURCE, 0);
    }

    private void H3(String str, int i3, String str2, String str3, String str4, int i16, qs.c cVar, String str5, int i17, ArrayList<String> arrayList, boolean z16, int i18, int i19, String str6, int i26, String str7, boolean z17, boolean z18, boolean z19, boolean z26) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String parent = new File(str2).getParent();
        if (!TextUtils.isEmpty(str4)) {
            PtvFilterUtils.a(parent, str4);
        }
        VideoSendPublicParam videoSendPublicParam = new VideoSendPublicParam();
        videoSendPublicParam.mContext = z();
        videoSendPublicParam.mVideoCacheDir = parent;
        videoSendPublicParam.mEncodeMode = i3;
        videoSendPublicParam.mVideoFilePath = str2;
        videoSendPublicParam.mThumbFilePath = str3;
        videoSendPublicParam.mThumbWidth = 0;
        videoSendPublicParam.mThumbHeight = 0;
        videoSendPublicParam.fakeVid = str4;
        videoSendPublicParam.recordTime = i16;
        videoSendPublicParam.mUserCallBack = cVar;
        videoSendPublicParam.mContent = str5;
        videoSendPublicParam.mPriv = i17;
        videoSendPublicParam.mPrivUinList = arrayList;
        videoSendPublicParam.mEnableEditVideo = this.G1;
        videoSendPublicParam.topicId = this.I1;
        videoSendPublicParam.topicSyncQzone = z16;
        videoSendPublicParam.fontId = i18;
        videoSendPublicParam.fontFormatType = i19;
        videoSendPublicParam.fontUrl = str6;
        videoSendPublicParam.superFontId = i26;
        videoSendPublicParam.superFontInfo = str7;
        videoSendPublicParam.generateGif = z17;
        videoSendPublicParam.timerDelete = z18;
        videoSendPublicParam.qzoneVerticalVideoTopicInfo = this.H1;
        videoSendPublicParam.isUploadOrigin = z26;
        videoSendPublicParam.entrySource = this.f65999w1.getInt(PeakConstants.KEY_ENTRY_SOURCE, 0);
        videoSendPublicParam.mUin = "";
        videoSendPublicParam.mUinType = 0;
        videoSendPublicParam.mTroopUin = "";
        new com.tencent.aelight.camera.aioeditor.c(videoSendPublicParam).execute(new Void[0]);
    }

    private void I3(AEVideoCaptureResult aEVideoCaptureResult) {
        u3();
        if (z() != null) {
            Intent intent = new Intent(z(), (Class<?>) PreviewVideoActivity.class);
            intent.putExtra("from_qzone_camera", true);
            intent.putExtra(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH, aEVideoCaptureResult.videoMp4FilePath);
            intent.putExtra("audio_path", aEVideoCaptureResult.audioDataFilePath);
            this.f61817h.getActivity().startActivityForResult(intent, 1016);
        }
    }

    private void u3() {
        String str = this.O1 + File.separator + "videoThumb.jpg";
        try {
            FileUtils.createDirectory(this.O1);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(P1, 2, "createDirectory error", e16);
            }
        }
        im2.a.b(this.L.videoMp4FilePath, str);
        if (this.N == null) {
            this.N = new LocalMediaInfo();
        }
        this.N.thumbnailPath = str;
    }

    private void v3() {
        try {
            FileUtils.deleteDirectory(this.O1);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(P1, 2, "Delete file error", e16);
            }
        }
    }

    private int w3() {
        int i3 = this.f65999w1.getInt("entrance_type", 99);
        if (i3 != 100) {
            return i3;
        }
        SessionInfo sessionInfo = (SessionInfo) this.f65999w1.getParcelable(PeakConstants.SEND_SESSION_INFO);
        return com.tencent.aelight.camera.aioeditor.a.a(sessionInfo != null ? sessionInfo.f179555d : 0);
    }

    private void y3(int i3, Intent intent) {
        if (this.K1 == 3) {
            super.onActivityResult(1012, i3, intent);
            return;
        }
        if (i3 != -1 || intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
        boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.EXTRA_DIRECTLY_BACK, false);
        if (!booleanExtra) {
            if (booleanExtra2) {
                z().setResult(-1, intent);
                z().finish();
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("key_content");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str = stringExtra;
        int intExtra = intent.getIntExtra("key_priv", 1);
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(AEEditorConstants.KEY_PRIV_UIN_LIST);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = arrayList;
        int intExtra2 = intent.getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
        this.f66002z1 = intent.getIntExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, 0);
        this.A1 = intent.getStringExtra(AEEditorConstants.KEY_FONT_URL);
        this.B1 = intent.getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
        this.C1 = intent.getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        boolean booleanExtra3 = intent.getBooleanExtra(AEEditorConstants.KEY_TIMER_DELETE, false);
        boolean booleanExtra4 = intent.getBooleanExtra(AEEditorConstants.KEY_SYNC_TO_QQSTORY, false);
        QLog.i(P1, 2, "get mSetTimerDelete: " + booleanExtra3);
        QZoneHelper.publishPictureMoodSilently(str, stringArrayListExtra, intExtra, (ArrayList<String>) arrayList2, intExtra2, this.f66002z1, this.A1, booleanExtra3, booleanExtra4, intExtra2, this.C1);
        z().finish();
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit
    public void d2() {
        super.d2();
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
        Activity activity = this.f61817h.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (i3 == 1011) {
            z3(i16, intent);
        } else if (i3 == 1012) {
            y3(i16, intent);
        } else if (i3 != 10001) {
            switch (i3) {
                case 1014:
                    x3(i16);
                    break;
                case 1015:
                    A3(i16);
                    break;
                case 1016:
                    C3(i16);
                    break;
            }
        } else {
            G3(intent);
        }
        qs.c cVar = this.L1;
        if (cVar != null) {
            cVar.onActivityResult(z(), i3, i16, intent);
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
    public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
        if (this.G1) {
            D3(this.L);
        } else {
            I3(this.L);
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            final Intent intent2 = new Intent(BaseApplication.getContext(), (Class<?>) EditLocalVideoActivity.class);
            intent2.putExtras(intent);
            intent2.putExtra("short_video_refer", getClass().getName());
            intent2.putExtra("is_qzone_vip", this.F1);
            intent2.putExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_ID, this.I1);
            intent2.putExtra(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, false);
            intent2.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, this.f66001y1);
            intent2.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, this.f66002z1);
            intent2.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, this.A1);
            intent2.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, this.B1);
            intent2.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, this.C1);
            intent2.putExtra("short_video_refer", this.J1);
            intent2.putExtra("set_user_callback", this.f65999w1.getString("set_user_callback"));
            intent2.putExtra(PeakConstants.KEY_QZONE_TOPIC, this.H1);
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aebase.AEPituQzoneCameraUnit.1
                @Override // java.lang.Runnable
                public void run() {
                    AEPituQzoneCameraUnit.this.z().startActivityForResult(intent2, 1015);
                }
            }, 0L);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(P1, 2, "handleOnNewIntent error ", e16);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void onPhotoCaptured(AEPhotoCaptureResult aEPhotoCaptureResult) {
        super.onPhotoCaptured(aEPhotoCaptureResult);
        if (this.K1 != 3) {
            B3(aEPhotoCaptureResult);
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        or.e eVar = this.f61817h;
        if (eVar != null && eVar.getActivity() != null && this.f61817h.getActivity().getIntent() != null) {
            Bundle extras = this.f61817h.getActivity().getIntent().getExtras();
            this.f65999w1 = extras;
            E3(extras);
        }
        return super.q(viewGroup);
    }

    private void C3(int i3) {
        if (i3 == 0) {
            v3();
        } else if (i3 == -1) {
            F3();
        }
    }

    private void F3() {
        LocalMediaInfo localMediaInfo;
        AEVideoCaptureResult aEVideoCaptureResult = this.L;
        if (aEVideoCaptureResult == null || (localMediaInfo = this.N) == null) {
            return;
        }
        H3(aEVideoCaptureResult.audioDataFilePath, 0, aEVideoCaptureResult.videoMp4FilePath, localMediaInfo.thumbnailPath, null, (int) localMediaInfo.mDuration, this.L1, null, -1, null, false, this.f66001y1, this.f66002z1, this.A1, this.B1, this.C1, false, false, false, false);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
    public void onVideoCaptured(AEVideoCaptureResult aEVideoCaptureResult) {
        if (aEVideoCaptureResult != null) {
            try {
                if (aEVideoCaptureResult.videoMp4FilePath != null) {
                    this.L = aEVideoCaptureResult;
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    this.N = localMediaInfo;
                    localMediaInfo.path = aEVideoCaptureResult.videoMp4FilePath;
                    localMediaInfo.mMimeType = "video";
                    MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(this, this.N);
                    return;
                }
            } catch (Exception e16) {
                QZLog.d(P1, 2, "onVideoCaptured exception!", e16);
                return;
            }
        }
        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.qe8));
        if (z() != null) {
            z().finish();
        }
    }

    private void A3(int i3) {
        if (i3 != -1 || z() == null || z().isFinishing()) {
            return;
        }
        z().finish();
    }

    private void B3(AEPhotoCaptureResult aEPhotoCaptureResult) {
        Intent newPictureEditIntentWithoutPublish;
        try {
            if (z() != null && !z().isFinishing()) {
                if (aEPhotoCaptureResult != null && !TextUtils.isEmpty(aEPhotoCaptureResult.filePath)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(P1, 2, "finishShotPhoto " + aEPhotoCaptureResult.filePath);
                    }
                    boolean z16 = this.f65999w1.getInt("edit_video_type", 0) != 10002;
                    int i3 = this.f65999w1.getInt(PeakConstants.BUSI_TYPE, 2);
                    boolean z17 = this.f65999w1.getBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
                    if (z() == null) {
                        return;
                    }
                    if (i3 == 3) {
                        GpsComplementUtil.complementByLocal(aEPhotoCaptureResult.filePath, this.f65999w1.getDouble(AECameraConstants.KEY_LONGTITUDE, Double.MIN_VALUE), this.f65999w1.getDouble(AECameraConstants.KEY_LATITUDE, Double.MIN_VALUE));
                    }
                    if (z17) {
                        newPictureEditIntentWithoutPublish = QzoneEditPictureActivity.I2(z(), aEPhotoCaptureResult.filePath, z16, i3, w3(), 0);
                    } else {
                        newPictureEditIntentWithoutPublish = QzoneEditPictureActivity.newPictureEditIntentWithoutPublish(z(), aEPhotoCaptureResult.filePath);
                    }
                    newPictureEditIntentWithoutPublish.putExtra("TEMP_PARAM", newPictureEditIntentWithoutPublish.getLongExtra("TEMP_PARAM", 0L) & (-65) & (-129));
                    newPictureEditIntentWithoutPublish.putExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, z17);
                    newPictureEditIntentWithoutPublish.putExtra(PeakConstants.EXTRA_DIRECTLY_BACK, this.f65999w1.getBoolean(PeakConstants.EXTRA_DIRECTLY_BACK, false));
                    newPictureEditIntentWithoutPublish.putExtra("qcamera_photo_filepath", aEPhotoCaptureResult.filePath);
                    newPictureEditIntentWithoutPublish.putExtra("qcamera_rotate", aEPhotoCaptureResult.orientation);
                    newPictureEditIntentWithoutPublish.putExtra(PeakConstants.EDIT_COME_FROM_NEWFLOW, true);
                    newPictureEditIntentWithoutPublish.putExtra("camera_type", 103);
                    newPictureEditIntentWithoutPublish.putExtra(AECameraConstants.KEY_BABYQ_ABILITY, this.f65999w1.getLong(AECameraConstants.KEY_BABYQ_ABILITY, 0L));
                    if (this.f65999w1.getInt(PeakConstants.KEY_ENTRY_SOURCE, 0) == 5) {
                        newPictureEditIntentWithoutPublish.putExtra(AEEditorConstants.PIC_ENTRANCE_TYPE, 13);
                    }
                    String aliasName = SplashActivity.getAliasName();
                    String string = this.f65999w1.getString(AECameraConstants.FROM_AIO_ACTIVITY_NAME);
                    if (string != null && string.equals(ChatActivity.class.getName())) {
                        aliasName = string;
                    }
                    com.tencent.mobileqq.activity.richmedia.f.c("finish");
                    com.tencent.mobileqq.activity.richmedia.f.e(newPictureEditIntentWithoutPublish);
                    String stringExtra = newPictureEditIntentWithoutPublish.getStringExtra(AECameraConstants.KEY_PIC_CONFIRM_TEXT);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        newPictureEditIntentWithoutPublish.putExtra("extra_publish_text", stringExtra);
                    }
                    if (z17) {
                        newPictureEditIntentWithoutPublish.putExtra("extra_publish_text", this.f61817h.getActivity().getString(R.string.d7o));
                    }
                    newPictureEditIntentWithoutPublish.putExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, aliasName);
                    newPictureEditIntentWithoutPublish.putExtra("key_activity_code", this.f65999w1.getString("key_activity_code"));
                    this.f61817h.getActivity().startActivityForResult(newPictureEditIntentWithoutPublish, 1012);
                    com.tencent.mobileqq.activity.richmedia.d.d("", "0X80075C1", "", "", "", "");
                    return;
                }
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.qe_));
                z().finish();
            }
        } catch (Exception e16) {
            QLog.d(P1, 2, "handlePic exception", e16);
        }
    }

    private void G3(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
            int intExtra2 = intent.getIntExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, 0);
            String stringExtra = intent.getStringExtra(AEEditorConstants.KEY_FONT_URL);
            int intExtra3 = intent.getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
            String stringExtra2 = intent.getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
            PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
            if (publishParam == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQAlbum", 2, "handleQzoneEditVideoResult: publishParam == null");
                }
            } else {
                AEVideoCaptureResult aEVideoCaptureResult = this.L;
                H3(aEVideoCaptureResult.audioDataFilePath, 0, aEVideoCaptureResult.videoMp4FilePath, publishParam.f69067e, null, (int) publishParam.E, this.L1, null, -1, null, false, intExtra, intExtra2, stringExtra, intExtra3, stringExtra2, false, false, false, false);
            }
        }
    }

    private void x3(int i3) {
        if (i3 != 0 && i3 == -1) {
            QLog.i(P1, 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
            z().finish();
        }
    }

    private void z3(int i3, Intent intent) {
        if (i3 == 0) {
            v3();
            return;
        }
        if (i3 != -1 || intent == null) {
            return;
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
        int intExtra2 = intent.getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
        this.f66002z1 = intent.getIntExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, 0);
        this.A1 = intent.getStringExtra(AEEditorConstants.KEY_FONT_URL);
        this.B1 = intent.getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
        this.C1 = intent.getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
        boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.KEY_GENERATE_GIF, false);
        boolean booleanExtra2 = intent.getBooleanExtra(AEEditorConstants.KEY_TIMER_DELETE, false);
        PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
        int i16 = publishParam.I;
        if (i16 > 5) {
            i16 = 0;
        }
        H3(publishParam.Q, i16, publishParam.P, publishParam.f69067e, publishParam.f69066d, (int) publishParam.E, this.L1, str, intExtra, arrayList2, false, intExtra2, this.f66002z1, this.A1, this.B1, this.C1, booleanExtra, booleanExtra2, false, intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, false));
    }
}
