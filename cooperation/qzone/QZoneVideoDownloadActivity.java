package cooperation.qzone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qzone.common.activities.base.ak;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.download.api.a;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistArrowLayer;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.o;
import com.tencent.mobileqq.shortvideo.util.f;
import com.tencent.mobileqq.shortvideo.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AVDecodeError;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneVideoDownloadActivity extends IphoneTitleBarActivity implements x.a, ShortVideoResourceManager.e, a {
    private static final String EXTRA_FROM_TAKE_PHOTO_USING_QQ_CAMERA = "extra_from_take_photo_using_qq_camera";
    public static final int MSG_DOWNLOAD_PLUGIN_PROGRESS = 1004;
    public static final int MSG_DOWNLOAD_SO_ERROR = 1002;
    public static final int MSG_DOWNLOAD_SO_PROGRESS = 1001;
    public static final int MSG_INIT_UI = 1000;
    public static final int MSG_INSTALL_PLUGIN_ERROR = 1003;
    public static final String TAG = "QZoneVideoDownloadActivity";
    public static final String VideoIntroduceImageUrl = "https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png";
    private String confirmText;
    private String donaXiaoCallback;
    private String dongXiaoId;
    private HashMap<Integer, String> downloadError;
    private boolean enableEditButton;
    private boolean enableInputText;
    private boolean enableLocalButton;
    private boolean enableOriginVideo;
    private boolean enablePrivList;
    private boolean enableQzoneSync;
    private long endTime;
    private boolean enterPtu;
    private int entrySource;
    public int filerType;
    private boolean isGlanceVideo;
    private boolean isPreviewVideo;
    public boolean isQzoneVip;
    public boolean isSupportDynamicVideo;
    public boolean isSupportEditVideo;
    public boolean isSupportJumpToGifChooser;
    public boolean isSupportPic;
    public boolean isSupportRecord;
    public boolean isSupportTrim;
    public ProgressBar mDownloadingBar;
    public URLImageView mDownloadingImage;
    public TextView mDownloadingText;
    public PluginManagerClient mPluginManager;
    private Bundle mVideoExtras;
    private long startTime;
    private String topicId;
    public String uin;
    public String videoPath;
    private String videoRefer;
    public long videoSize;
    private int videoType;
    public boolean isEditVideo = false;
    private boolean isGoPublish = false;
    private int doQZoneAlbumShortcut = 0;
    private long avCodecCurOffset = 0;
    private long avCodecTotalLen = 0;
    private long aekitCurOffset = 0;
    private long aekitTotalLen = 0;
    private long lightSDKCurOffset = 0;
    private long lightSDKTotalLen = 0;
    private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
    Handler mHandler = new Handler() { // from class: cooperation.qzone.QZoneVideoDownloadActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            switch (message.what) {
                case 1000:
                    if (QLog.isDevelopLevel()) {
                        QLog.d(QZoneVideoDownloadActivity.TAG, 4, "mIsUIInited=" + QZoneVideoDownloadActivity.this.mIsUIInited);
                    }
                    if (QZoneVideoDownloadActivity.this.mIsUIInited.get()) {
                        return;
                    }
                    QZoneVideoDownloadActivity.this.setContentView(R.layout.c4h);
                    QZoneVideoDownloadActivity.this.initUI();
                    QZoneVideoDownloadActivity.this.mIsUIInited.set(true);
                    return;
                case 1001:
                    QZoneVideoDownloadActivity qZoneVideoDownloadActivity = QZoneVideoDownloadActivity.this;
                    TextView textView = qZoneVideoDownloadActivity.mDownloadingText;
                    if (textView == null || qZoneVideoDownloadActivity.mDownloadingBar == null) {
                        return;
                    }
                    int i3 = message.arg1;
                    textView.setText(HardCodeUtil.qqStr(R.string.sct) + i3 + HardCodeUtil.qqStr(R.string.sbl));
                    QZoneVideoDownloadActivity.this.mDownloadingBar.setProgress(i3);
                    return;
                case 1002:
                    String qqStr = HardCodeUtil.qqStr(R.string.f172594sd0);
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof String)) {
                        qqStr = (String) obj;
                    }
                    QQToast.makeText(QZoneVideoDownloadActivity.this.getApplicationContext(), qqStr, 1).show();
                    QzoneVideoBeaconReport.reportVideoEvent(QZoneVideoDownloadActivity.this.uin, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, null);
                    QZoneVideoDownloadActivity.this.finish();
                    return;
                case 1003:
                    QQToast.makeText(QZoneVideoDownloadActivity.this.getApplicationContext(), HardCodeUtil.qqStr(R.string.seu), 1).show();
                    QzoneVideoBeaconReport.reportVideoEvent(QZoneVideoDownloadActivity.this.uin, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, null);
                    QZoneVideoDownloadActivity.this.finish();
                    return;
                case 1004:
                    QZoneVideoDownloadActivity qZoneVideoDownloadActivity2 = QZoneVideoDownloadActivity.this;
                    TextView textView2 = qZoneVideoDownloadActivity2.mDownloadingText;
                    if (textView2 == null || qZoneVideoDownloadActivity2.mDownloadingBar == null) {
                        return;
                    }
                    int i16 = message.arg1;
                    textView2.setText(HardCodeUtil.qqStr(R.string.sbu) + i16 + HardCodeUtil.qqStr(R.string.sbo));
                    QZoneVideoDownloadActivity.this.mDownloadingBar.setProgress(i16);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean isAVCodecDownloadOk = true;
    private boolean isAEBaseSoDownloadOk = true;
    private boolean isLightBaseSoDownloadOk = true;
    private boolean isArtSoDownloadOk = true;
    private boolean isTrackingDownloadOk = true;

    private boolean checkIsOK() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkIsOK()=");
        sb5.append(this.isAVCodecDownloadOk && this.isAEBaseSoDownloadOk && this.isLightBaseSoDownloadOk && this.isArtSoDownloadOk);
        VideoEnvironment.LogDownLoad(TAG, sb5.toString(), null);
        return this.isAVCodecDownloadOk && this.isAEBaseSoDownloadOk && this.isLightBaseSoDownloadOk && this.isArtSoDownloadOk;
    }

    private void entrySourceReport() {
        int i3 = this.entrySource;
        if (i3 == 1) {
            LpReportInfo_pf00064.allReport(612, 1, 1);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "entry source plus report");
                return;
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        LpReportInfo_pf00064.allReport(612, 1, 2);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "entry source quick left slide report");
        }
    }

    private String getDownloadErrorConfig(int i3) {
        HashMap<Integer, String> hashMap = this.downloadError;
        if (hashMap == null) {
            return String.valueOf(i3);
        }
        String str = hashMap.get(Integer.valueOf(i3));
        return TextUtils.isEmpty(str) ? String.valueOf(i3) : str;
    }

    private void initDownloadErrorConfig() {
        if (this.downloadError == null) {
            this.downloadError = new HashMap<>();
        }
        this.downloadError.put(-1, HardCodeUtil.qqStr(R.string.sdz));
        this.downloadError.put(-2, HardCodeUtil.qqStr(R.string.sbg));
        this.downloadError.put(-2, HardCodeUtil.qqStr(R.string.sd9));
        this.downloadError.put(-3, HardCodeUtil.qqStr(R.string.sel));
        this.downloadError.put(-4, HardCodeUtil.qqStr(R.string.sdo));
        this.downloadError.put(-100, HardCodeUtil.qqStr(R.string.sdt));
        this.downloadError.put(-101, HardCodeUtil.qqStr(R.string.f172597sd4));
        this.downloadError.put(-105, HardCodeUtil.qqStr(R.string.f172599se1));
        this.downloadError.put(-106, "MD5\u4e3a\u7a7a\u9519\u8bef");
        this.downloadError.put(-107, HardCodeUtil.qqStr(R.string.sed));
        this.downloadError.put(Integer.valueOf(AVDecodeError.VIDEO_DECODE_V_ERR), "MD5\u6821\u9a8c\u9519\u8bef");
        this.downloadError.put(-117, HardCodeUtil.qqStr(R.string.sbq));
        this.downloadError.put(Integer.valueOf(CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE), HardCodeUtil.qqStr(R.string.f172590sb3));
        this.downloadError.put(-125, HardCodeUtil.qqStr(R.string.sdw));
        this.downloadError.put(Integer.valueOf(Constants.BINARY_PERF_STATS), HardCodeUtil.qqStr(R.string.f172596sd3));
        this.downloadError.put(-127, "UTF-8\u7f16\u7801\u9519\u8bef");
        this.downloadError.put(-127, "UTF-8\u7f16\u7801\u9519\u8bef");
        this.downloadError.put(-128, HardCodeUtil.qqStr(R.string.sb6));
        this.downloadError.put(-1000, HardCodeUtil.qqStr(R.string.ser));
        this.downloadError.put(Integer.valueOf(LightConstants.ErrorCode.BONE_NOT_SUPPORT), HardCodeUtil.qqStr(R.string.sec));
        this.downloadError.put(-1501, HardCodeUtil.qqStr(R.string.seb));
    }

    private boolean isAllReady(QQAppInterface qQAppInterface) {
        boolean z16;
        boolean checkAndLoadAVCodec = VideoEnvironment.checkAndLoadAVCodec();
        int aEResStatus = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
        int aEResStatus2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
        if (aEResStatus != 2) {
            if (aEResStatus2 != 2) {
                z16 = true;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isAllReady()=");
                sb5.append(!checkAndLoadAVCodec && z16);
                VideoEnvironment.LogDownLoad(TAG, sb5.toString(), null);
                return !checkAndLoadAVCodec && z16;
            }
        }
        z16 = false;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("isAllReady()=");
        sb52.append(!checkAndLoadAVCodec && z16);
        VideoEnvironment.LogDownLoad(TAG, sb52.toString(), null);
        if (checkAndLoadAVCodec) {
        }
    }

    private void onDownloadFinishAndJudge(String str, int i3, String str2) {
        if (str.startsWith("new_qq_android_native_short_video_") && i3 != 0) {
            sendErrorMessage(HardCodeUtil.qqStr(R.string.sdn) + getDownloadErrorConfig(i3) + "]");
            o.c(2, i3);
        }
        if (!isFinishing() && isAllReady(this.app) && checkIsOK()) {
            startQZoneVideo();
        } else {
            VideoEnvironment.LogDownLoad(TAG, "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
        }
        VideoEnvironment.LogDownLoad(TAG, "name=" + str + ",result=" + i3 + ",filePath=" + str2, null);
    }

    private void sendErrorMessage(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1002);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            ShortVideoResourceManager.k(qQAppInterface, this);
        }
        ((IAEResDownload) QRoute.api(IAEResDownload.class)).removeCallBack(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        finish();
    }

    @Override // com.tencent.mobileqq.shortvideo.x.a
    public void onConfigResult(int i3, int i16) {
        VideoEnvironment.LogDownLoad(TAG, "result=" + i3 + ",serverError=" + i16, null);
        if (i3 != 1 && i3 != 0) {
            sendErrorMessage(HardCodeUtil.qqStr(R.string.sby) + getDownloadErrorConfig(i16) + "]");
            o.c(1, i16);
            return;
        }
        if (i16 != 0) {
            sendErrorMessage(HardCodeUtil.qqStr(R.string.sba) + getDownloadErrorConfig(i16) + "]");
            o.c(1, i16);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        int f16 = ShortVideoResourceManager.f(this.app, arrayList);
        if (f16 == 0) {
            VideoEnvironment.LogDownLoad(TAG, "onConfigResult| check config success...", null);
            this.isAVCodecDownloadOk = false;
            ShortVideoResourceManager.q(this.app, arrayList, this);
            if (f.l()) {
                this.isArtSoDownloadOk = false;
                ShortVideoResourceManager.r(this.app, arrayList, this);
                return;
            }
            return;
        }
        sendErrorMessage(HardCodeUtil.qqStr(R.string.sdp) + getDownloadErrorConfig(f16) + "]");
        o.c(1, f16);
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
    public void onDownloadFinish(String str, int i3, String str2) {
        VideoEnvironment.LogDownLoad(TAG, "onDownloadFinish| name=" + str + ",result=" + i3 + ",filePath=" + str2, null);
        if (str.startsWith("new_qq_android_native_short_video_")) {
            this.isAVCodecDownloadOk = true;
        } else if (str.startsWith("new_qq_android_native_art_filter_")) {
            this.isArtSoDownloadOk = true;
        }
        onDownloadFinishAndJudge(str, i3, str2);
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
    public void onNetWorkNone() {
        VideoEnvironment.LogDownLoad(TAG, "onNetWorkNone...", null);
        this.mDownloadingBar.post(new Runnable() { // from class: cooperation.qzone.QZoneVideoDownloadActivity.2
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(QZoneVideoDownloadActivity.this.getApplicationContext(), HardCodeUtil.qqStr(R.string.scw), 1).show();
            }
        });
        o.c(3, LightConstants.ErrorCode.BONE_NOT_SUPPORT);
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
    public void onUpdateProgress(String str, long j3, long j16) {
        this.avCodecCurOffset = j3;
        this.avCodecTotalLen = j16;
        long j17 = this.aekitTotalLen;
        int i3 = j16 + j17 > 0 ? (int) ((((float) (this.aekitCurOffset + j3)) * 100.0f) / ((float) (j17 + j16))) : 0;
        if (str.startsWith("new_qq_android_native_short_video_")) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1004, i3, 0));
        }
        VideoEnvironment.LogDownLoad(TAG, "name=" + str + ",totalLen=" + j16 + ",curOffset=" + j3 + ",localProgress=" + i3, null);
    }

    private void startDownloadConfig() {
        QQAppInterface qQAppInterface;
        if (NetworkUtil.isNetworkAvailable(null) && (qQAppInterface = this.app) != null) {
            this.aekitTotalLen = 0L;
            this.aekitCurOffset = 0L;
            this.avCodecTotalLen = 0L;
            this.avCodecCurOffset = 0L;
            ShortVideoResourceManager.M(qQAppInterface, this);
            IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo = AEResInfo.AE_RES_BASE_PACKAGE;
            if (iAEResUtil.getAEResStatus(aEResInfo) == 2) {
                this.isAEBaseSoDownloadOk = false;
                ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo, this, false);
            }
            IAEResUtil iAEResUtil2 = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo2 = AEResInfo.LIGHT_RES_BASE_PACKAGE;
            if (iAEResUtil2.getAEResStatus(aEResInfo2) == 2) {
                this.isLightBaseSoDownloadOk = false;
                ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(aEResInfo2, this, false);
                return;
            }
            return;
        }
        this.mHandler.sendEmptyMessage(1002);
    }

    private void startQZoneVideo() {
        String str;
        if (getAppRuntime() == null && TextUtils.isEmpty(this.uin)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "startQZoneVideo, getAppRunime and uin are null");
            }
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.sdi), 0).show();
            QzoneVideoBeaconReport.reportVideoEvent(null, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, "1000", null);
            finish();
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        if (TextUtils.isEmpty(this.uin)) {
            str = getAppRuntime().getAccount();
        } else {
            str = this.uin;
        }
        userInfo.qzone_uin = str;
        String stringExtra = getIntent().getStringExtra("refer");
        QLog.i(TAG, 1, "isSupportRecord=" + this.isSupportRecord + ",isSupportTrim=" + this.isSupportTrim + ",isPreviewVideo" + this.isPreviewVideo + ",refer=" + stringExtra + ",videoRefer=" + this.videoRefer);
        Bundle bundle = new Bundle();
        if (getIntent().hasExtra(QzoneVerticalVideoConst.KEY_SUPPORTPIC) && !getIntent().getBooleanExtra(QzoneVerticalVideoConst.KEY_SUPPORTPIC, false)) {
            bundle.putBoolean("flow_camera_capture_mode", false);
            bundle.putBoolean("flow_camera_capture_mode", false);
        } else {
            bundle.putBoolean("flow_camera_capture_mode", getIntent().getBooleanExtra("flow_camera_capture_mode", true));
        }
        if (getIntent().hasExtra("enable_local_button")) {
            bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, getIntent().getBooleanExtra("enable_local_button", true));
        }
        bundle.putBoolean("flow_camera_video_mode", getIntent().getBooleanExtra("flow_camera_video_mode", true));
        bundle.putString(VideoEnvironment.SHORT_VIDEO_CONFIG, getIntent().getStringExtra(VideoEnvironment.SHORT_VIDEO_CONFIG));
        bundle.putInt("UseQQCameraCompression", getIntent().getIntExtra("UseQQCameraCompression", 0));
        bundle.putBoolean(PeakConstants.ARG_BEAUTY, getIntent().getBooleanExtra(PeakConstants.ARG_BEAUTY, true));
        bundle.putBoolean(PeakConstants.ARG_SUPPORT_FILTER, getIntent().getBooleanExtra(PeakConstants.ARG_SUPPORT_FILTER, true));
        bundle.putBoolean(PeakConstants.ARG_SUPPORT_DD, getIntent().getBooleanExtra(PeakConstants.ARG_SUPPORT_DD, true));
        bundle.putBoolean(PeakConstants.ARG_UNFOLD_DD, getIntent().getBooleanExtra(PeakConstants.ARG_UNFOLD_DD, false));
        bundle.putString(PeakConstants.ARG_DD_CATEGORY_NAME, getIntent().getStringExtra(PeakConstants.ARG_DD_CATEGORY_NAME));
        bundle.putString(PeakConstants.ARG_DD_ITEM_ID, getIntent().getStringExtra(PeakConstants.ARG_DD_ITEM_ID));
        bundle.putBoolean(PeakConstants.ARG_UNFOLD_FILTER, getIntent().getBooleanExtra(PeakConstants.ARG_UNFOLD_FILTER, false));
        bundle.putString(PeakConstants.ARG_FILTER_CATEGORY_NAME, getIntent().getStringExtra(PeakConstants.ARG_FILTER_CATEGORY_NAME));
        bundle.putString(PeakConstants.ARG_FILTER_ITEM_ID, getIntent().getStringExtra(PeakConstants.ARG_FILTER_ITEM_ID));
        bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, getIntent().getIntExtra(PeakConstants.ARG_FORCE_CAMERA, 0));
        bundle.putBoolean(PeakConstants.EXTRA_DIRECTLY_BACK, getIntent().getBooleanExtra(PeakConstants.EXTRA_DIRECTLY_BACK, false));
        bundle.putDouble(AECameraConstants.KEY_LATITUDE, getIntent().getDoubleExtra(AECameraConstants.KEY_LATITUDE, Double.MIN_VALUE));
        bundle.putDouble(AECameraConstants.KEY_LONGTITUDE, getIntent().getDoubleExtra(AECameraConstants.KEY_LONGTITUDE, Double.MIN_VALUE));
        bundle.putParcelable(PeakConstants.KEY_QZONE_TOPIC, getIntent().getParcelableExtra(PeakConstants.KEY_QZONE_TOPIC));
        int i3 = this.entrySource;
        if (i3 == 3) {
            bundle.putString("qcamera_photo_filepath", getIntent().getStringExtra("qcamera_photo_filepath"));
            bundle.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, getIntent().getBooleanExtra(QzoneVerticalVideoConst.KEY_SUPPORTPIC, false));
            bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, getIntent().getBooleanExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, false));
            bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, getIntent().getBooleanExtra(AECameraConstants.ENABLE_LOCAL_VIDEO, false));
            bundle.putString("qzone_plugin_activity_name", getIntent().getStringExtra("qzone_plugin_activity_name"));
            bundle.putBoolean(EXTRA_FROM_TAKE_PHOTO_USING_QQ_CAMERA, getIntent().getBooleanExtra(EXTRA_FROM_TAKE_PHOTO_USING_QQ_CAMERA, false));
        } else if (i3 == 5) {
            bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, getIntent().getBooleanExtra(AECameraConstants.ENABLE_LOCAL_VIDEO, false));
        } else if (i3 == 7) {
            bundle.putInt("ability_flag", 3);
            bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
        } else if (i3 == 9) {
            bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
            bundle.putInt("ability_flag", 3);
        }
        if (this.isSupportRecord) {
            QZoneHelper.forwardToQzoneVideoCaptureNew(this.app, this, userInfo, 10009, this.isSupportTrim, this.isSupportPic, stringExtra, this.videoRefer, this.isQzoneVip, this.isEditVideo, this.topicId, this.enterPtu, this.donaXiaoCallback, this.dongXiaoId, this.enableInputText, this.enablePrivList, this.enableQzoneSync, this.enableOriginVideo, this.confirmText, this.enableEditButton, this.enableLocalButton, this.isGlanceVideo, this.entrySource, this.isGoPublish, bundle);
            QzoneVideoBeaconReport.reportVideoEvent(userInfo.qzone_uin, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, "0", QQPermissionConstants.Permission.AUIDO_GROUP);
            entrySourceReport();
            finish();
            return;
        }
        if (this.isSupportTrim) {
            QZoneHelper.forwardToQzoneVideoTrim(this, userInfo, this.videoPath, this.videoSize, 10009, this.filerType, stringExtra, this.videoRefer);
            QzoneVideoBeaconReport.reportVideoEvent(userInfo.qzone_uin, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, "1", "trim");
            finish();
            return;
        }
        if (this.isPreviewVideo) {
            Intent P = ak.P(getActivity().getApplicationContext());
            P.putExtra("video_type", 1);
            P.putExtra("video_source_path", this.videoPath);
            P.putExtra("start_time", this.startTime);
            P.putExtra("end_time", this.endTime);
            startActivity(P);
            overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            finish();
            return;
        }
        if (this.isSupportEditVideo) {
            return;
        }
        if (this.isSupportJumpToGifChooser) {
            Intent intent = getIntent();
            intent.setClassName(getIntent().getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME), getIntent().getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME));
            intent.addFlags(603979776);
            QZoneHelper.launchQZone(this, "", intent, -1);
            finish();
            return;
        }
        finish();
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
        if (z16) {
            if (aEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
                this.isAEBaseSoDownloadOk = true;
            } else if (aEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
                this.isLightBaseSoDownloadOk = true;
            }
            if (!isFinishing() && isAllReady(this.app) && checkIsOK()) {
                startQZoneVideo();
                return;
            } else {
                VideoEnvironment.LogDownLoad(TAG, "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
                return;
            }
        }
        sendErrorMessage(HardCodeUtil.qqStr(R.string.sc_) + getDownloadErrorConfig(i3) + "]");
        o.c(2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(-16777216);
        Intent intent = getIntent();
        if (intent == null) {
            QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.sds), 1).show();
            QzoneVideoBeaconReport.reportVideoEvent(null, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, "1002", null);
            return;
        }
        this.isSupportRecord = intent.getBooleanExtra("support_record", false);
        this.isSupportTrim = intent.getBooleanExtra("support_trim", false);
        this.isSupportEditVideo = intent.getBooleanExtra("support_edit_video", false);
        this.isSupportJumpToGifChooser = intent.getBooleanExtra("support_jump_gif_chooser", false);
        this.isSupportPic = intent.getBooleanExtra(QzoneVerticalVideoConst.KEY_SUPPORTPIC, false);
        this.isSupportDynamicVideo = intent.getBooleanExtra(QzoneVerticalVideoConst.KEY_SUPPORT_DYNAMIC_VIDEO, false);
        this.entrySource = intent.getIntExtra(PeakConstants.KEY_ENTRY_SOURCE, 0);
        this.isQzoneVip = intent.getBooleanExtra("is_qzone_vip", false);
        this.isEditVideo = intent.getBooleanExtra(ShortVideoConstants.ENABLE_EDIT_VIDEO, false);
        this.uin = intent.getStringExtra("uin");
        this.videoPath = intent.getStringExtra("file_send_path");
        this.videoSize = intent.getLongExtra(PeakConstants.VIDEO_SIZE, 0L);
        this.filerType = intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 2);
        this.isPreviewVideo = intent.getBooleanExtra("preview_video", false);
        this.videoType = intent.getIntExtra("video_type", 0);
        this.startTime = intent.getLongExtra("start_time", 0L);
        this.endTime = intent.getLongExtra("end_time", 0L);
        this.videoRefer = intent.getStringExtra(PeakConstants.VIDEO_REFER);
        this.mVideoExtras = intent.getBundleExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS);
        this.topicId = intent.getStringExtra("topicId");
        this.enterPtu = intent.getBooleanExtra("enterPtu", false);
        this.donaXiaoCallback = intent.getStringExtra("callback");
        this.dongXiaoId = intent.getStringExtra("dongxiao_id");
        this.enablePrivList = intent.getBooleanExtra(AECameraConstants.KEY_ENABLE_PRIV_LIST, true);
        this.enableInputText = intent.getBooleanExtra(AECameraConstants.KEY_ENABLE_INPUT_TEXT, true);
        this.enableQzoneSync = intent.getBooleanExtra("enable_sync_qzone", false);
        this.enableOriginVideo = intent.getBooleanExtra("enable_origin_video", false);
        this.confirmText = intent.getStringExtra(AECameraConstants.KEY_CONFIRM_TEXT);
        this.enableEditButton = intent.getBooleanExtra(AECameraConstants.KEY_ENABLE_EDIT_BUTTON, true);
        this.enableLocalButton = intent.getBooleanExtra("enable_local_button", true);
        this.isGlanceVideo = intent.getBooleanExtra("is_glance_video", false);
        this.isGoPublish = intent.getBooleanExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
        this.doQZoneAlbumShortcut = intent.getIntExtra(QZoneHelper.QZONE_ALBUM_SHORTCUT_ACTION_TYPE, 0);
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            if (TextUtils.isEmpty(this.uin)) {
                str = getAppRuntime().getAccount();
            } else {
                str = this.uin;
            }
            this.uin = str;
            int i3 = this.doQZoneAlbumShortcut;
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                if (qQAppInterface.isVideoChatting()) {
                    QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.sdk), 1).show();
                    QzoneVideoBeaconReport.reportVideoEvent(this.uin, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, "1003", null);
                    finish();
                    return;
                } else if (QavCameraUsage.a(BaseApplication.getContext())) {
                    QzoneVideoBeaconReport.reportVideoEvent(this.uin, QzoneVideoBeaconReport.EVEVT_VIDEO_TRIMRECORD, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, null);
                    finish();
                    return;
                } else {
                    if (!isAllReady(qQAppInterface)) {
                        setContentView(R.layout.c4h);
                        initUI();
                        this.mIsUIInited.set(true);
                        initDownloadErrorConfig();
                        startDownloadConfig();
                        return;
                    }
                    if (this.isSupportDynamicVideo) {
                        setContentView(R.layout.c4h);
                        initUI();
                    }
                }
            } else {
                String stringExtra = intent.getStringExtra("UploadPhoto.key_album_id");
                String stringExtra2 = intent.getStringExtra("UploadPhoto.key_album_name");
                Bitmap bitmap = (Bitmap) intent.getParcelableExtra("UploadPhoto.key_album_cover");
                long longExtra = intent.getLongExtra(QZoneHelper.Constants.KEY_ALBUM_OWNER_UID, 0L);
                int i16 = this.doQZoneAlbumShortcut;
                if (i16 == 1) {
                    QZoneHelper.createAlbumShortCut((QQAppInterface) appRuntime, stringExtra, stringExtra2, bitmap, longExtra);
                } else if (i16 == 2 || i16 == 3) {
                    QZoneHelper.updateAlbumShortCut((QQAppInterface) appRuntime, stringExtra, stringExtra2, bitmap, longExtra);
                }
                finish();
                return;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "app is not QQAppInterface");
        }
        startQZoneVideo();
    }

    public void initUI() {
        setTitle(HardCodeUtil.qqStr(R.string.sd6));
        this.mDownloadingBar = (ProgressBar) findViewById(R.id.fvn);
        this.mDownloadingText = (TextView) findViewById(R.id.fvm);
        URLImageView uRLImageView = (URLImageView) findViewById(R.id.fvq);
        this.mDownloadingImage = uRLImageView;
        uRLImageView.setImageURL(VideoIntroduceImageUrl);
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        int i16;
        if (aEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
            this.aekitCurOffset = j3;
            this.aekitTotalLen = j16;
            long j17 = this.avCodecTotalLen;
            long j18 = this.lightSDKTotalLen;
            if (j17 + j16 + j18 > 0) {
                str5 = ",curOffset=";
                str6 = ",totalLen=";
                i16 = (int) ((((float) ((this.avCodecCurOffset + j3) + this.lightSDKCurOffset)) * 100.0f) / ((float) ((j17 + j16) + j18)));
            } else {
                str5 = ",curOffset=";
                str6 = ",totalLen=";
                i16 = 0;
            }
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1004, i16, 0));
            VideoEnvironment.LogDownLoad(TAG, "packageIdx=" + aEResInfo.index + str6 + j16 + str5 + j3 + ",localProgress=" + i16, null);
            return;
        }
        if (aEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
            this.lightSDKCurOffset = j3;
            this.lightSDKTotalLen = j16;
            long j19 = this.avCodecTotalLen;
            long j26 = this.aekitTotalLen;
            if (j19 + j26 + j16 > 0) {
                str = ",localProgress=";
                str2 = ",totalLen=";
                long j27 = this.avCodecCurOffset;
                str3 = "packageIdx=";
                str4 = TAG;
                i3 = (int) ((((float) ((j27 + this.aekitCurOffset) + j3)) * 100.0f) / ((float) ((j19 + j26) + j16)));
            } else {
                str = ",localProgress=";
                str2 = ",totalLen=";
                str3 = "packageIdx=";
                str4 = TAG;
                i3 = 0;
            }
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1004, i3, 0));
            VideoEnvironment.LogDownLoad(str4, str3 + aEResInfo.index + str2 + j16 + ",curOffset=" + j3 + str + i3, null);
        }
    }
}
