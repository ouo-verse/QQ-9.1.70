package com.tencent.mobileqq.activity.shortvideo;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.MtpConstants;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.activity.aio.y;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.DragView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.sdk.util.QWSoterConstans;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.widget.a;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@RoutePage(desc = "\u89c6\u9891\u5168\u5c4f\u64ad\u653e\u754c\u9762", path = "/business/shortvideoplay")
@TargetApi(11)
@Deprecated
/* loaded from: classes10.dex */
public class ShortVideoPlayActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener, ISPlayerVideoView.IVideoViewCallBack, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnTVideoNetInfoListener, r, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnInfoListener, DragView.OnGestureChangeListener {
    private static final int MAX_PROGRESS = 10000;
    public static final int MSG_TYPE_MOBILE_2_WIFE = 5;
    public static final int MSG_TYPE_WIFI_2_MOBILE = 4;
    static final int OPERATOR_BAR_HIDE_DELAY = 2500;
    public static final int PLAY_STATE_BUFFERING = 4;
    public static final int PLAY_STATE_ERROR = 3;
    public static final int PLAY_STATE_IDLE = 0;
    public static final int PLAY_STATE_PAUSE = 2;
    public static final int PLAY_STATE_PLAYING = 1;
    static final int PROGRESS_REFRESH_INTERNAL = 50;
    private static final int REQUEST_TO_QZONE = 10001;
    public static final int SDK_INSTALL_FAILED = 3000;
    static final String STATE_PLAY_POSITION = "state_play_position";
    public static final String TAG = "ShortVideoPlayActivity";
    public static final String TAG2 = "ShortVideoPlayerInner";
    public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
    static String mCfgString;
    static String[] mListString;
    boolean isFromMultiMsg;
    private long mBufferCost;
    private RelativeLayout mBufferLayout;
    private long mBufferStart;
    private int mBufferTimes;
    Bundle mBundle;
    private int mCacheProgress;
    ImageView mCloseBtn;
    private String mContentType;
    Context mContext;
    URLImageView mCoverIV;
    private long mCurPlayPosition;
    long mCurrentPosition;
    String mCurrentUin;
    private int mDataFromCacheSize;
    String mDomain;
    DragView mDragView;
    String mDurationStr;
    public cooperation.qqfav.widget.a mFavActionSheet;
    long mFavGroupId;
    long mFavId;
    long mFileSize;
    int mFileType;
    final WeakReference<MqqHandler> mHandler;
    boolean mHidden;
    private String mHotVideoCertificatedIconUrl;
    private String mHotVideoIconUrl;
    private String mHotVideoJumpUrl;
    private String mHotVideoTitle;
    private int mHttpConnectCost;
    private long mHttpCost;
    private int mHttpDNSCost;
    private int mHttpDownloadCount;
    private int mHttpDownloadSum;
    private int mHttpFirstRecvCost;
    private int mHttpRedirectCostMs;
    private int mHttpRedirectNum;
    private long mHttpStart;
    private int mHttpStatus;
    private String mHttpUrl;
    TextView mLoadingText;
    String mMd5;
    WeakReference<ISuperPlayer> mMediaPlayer;
    protected ImageView mMenuBtn;
    private long mMessageClickCost;
    private long mMessageClickStart;
    MessageForShortVideo mMsg;
    boolean mNeedHideTitleBar;
    boolean mNeedReportProgressive;
    int mNewSeekTimes;
    LinearLayout mNormalOperateLayout;
    SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
    private long mOpenPlayerCost;
    private long mOpenPlayerStart;
    View mOperatorBar;
    ImageView mOperatorBtn;
    private int mPauseTimes;
    private long mPlayCost;
    private int mPlayProgress;
    int mPlayReadyTime;
    private long mPlayStart;
    private boolean mPlayWithDownload;
    final Runnable mProgressChecker;
    TextView mProgressTime;
    private TextView mRateText;
    private int mRealPlayTimes;
    BroadcastReceiver mReceiver;
    private int mReplayTimes;
    TextView mReturnBtn;
    RelativeLayout mRoot;
    private int mScreenDisplayHeight;
    private int mScreenDisplayWidth;
    private int mSdkDetailErrorCode;
    private int mSdkErrorCode;
    long mSec;
    SeekBar mSeekBar;
    int mSeekTimes;
    private int mSpeedKBS;
    final Runnable mStartHidingRunnable;
    private long mStepUrlCost;
    private long mTCOfMCFirstFrame;
    Bitmap mThumbBitmap;
    String mThumbMd5;
    RelativeLayout mTitleBar;
    TextView mTotalTime;
    long mTransferredSize;
    int mUinType;
    private long mUpdateSDKCost;
    private long mUpdateSDKStart;
    RelativeLayout mUploadOperateLayout;
    TextView mUploadProgress;
    SeekBar mUploadingSeekBar;
    private String mUserReturnCode;
    private String mUuid;
    ValueAnimator mValueAnimator;
    RelativeLayout mVideoController;
    String mVideoInfo;
    RelativeLayout mVideoLayout;
    String mVideoPath;
    String[] mVideoUrls;
    ISPlayerVideoView mVideoView;
    private String mXRtFlag;
    Rect originRect;
    String publicAccountLocalPath;
    boolean seekFlagForCacheProgress;
    LinearLayout top_blackLH;
    boolean mIsSDKInit = false;
    int mPlayState = 0;
    int mPlayCallerType = 0;
    String ad_gdt = "";
    String msg_id = "";
    int sourceEntrance = -1;
    long mDuration = -1;
    boolean mPlaySucReported = false;
    boolean mPlayFailReported = false;
    long mPlayTimeCost = -1;
    long mStartPlayTime = -1;
    public int mCurSessionType = -1;
    public String mCurSessionUin = "0";
    boolean mPlayTimeCostReported = false;
    int mPlayResult = 1;
    boolean mNeedDownload = false;
    boolean mIsUploading = false;
    private boolean mCompleted = false;
    boolean mNeedPlay = false;
    boolean mInterrupted = false;
    private boolean mIsUpdateSDK = false;
    private boolean mUpdateSDKResult = false;
    private boolean mNeedReportAioVideo = true;
    private boolean mNeedDownloadReport = true;
    private boolean mNeedUpdateMsg = true;
    private int mErrCode = 0;
    private int mStatus = -1;
    private boolean mSurfaceViewDestroyed = false;
    private boolean mIsHotVideo = false;
    private boolean mUserDragging = false;
    private long playDurationForReport = 0;
    private boolean hasUserSeeked = false;
    boolean hasSeeked = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ShortVideoPlayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ShortVideoPlayActivity.this.userBackPressed();
        }
    }

    /* loaded from: classes10.dex */
    class d implements SeekBar.OnSeekBarChangeListener {
        d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPlayActivity.TAG, 2, "onProgressChanged: progress = " + i3 + ",fromUser=" + z16);
            }
            ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
            shortVideoPlayActivity.hasSeeked = true;
            if (z16) {
                shortVideoPlayActivity.mSeekTimes++;
                shortVideoPlayActivity.mUserDragging = true;
                ShortVideoPlayActivity.this.hasUserSeeked = true;
            }
            ShortVideoPlayActivity shortVideoPlayActivity2 = ShortVideoPlayActivity.this;
            shortVideoPlayActivity2.setProgressTime((i3 * shortVideoPlayActivity2.mDuration) / 10000);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            int progress = ShortVideoPlayActivity.this.mSeekBar.getProgress();
            ShortVideoPlayActivity.this.mUserDragging = true;
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPlayActivity.TAG, 2, "onStartTrackingTouch: progress = " + progress);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            ShortVideoPlayActivity.this.showAnimation();
            ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
            shortVideoPlayActivity.mNewSeekTimes++;
            shortVideoPlayActivity.seekFlagForCacheProgress = true;
            int progress = shortVideoPlayActivity.mSeekBar.getProgress();
            int i3 = (int) ((progress * ShortVideoPlayActivity.this.mDuration) / 10000);
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPlayActivity.TAG, 2, "onStopTrackingTouch: seekProgress = " + progress + ", mCacheProgress= " + ShortVideoPlayActivity.this.mCacheProgress + ", timestamp = " + i3);
            }
            ShortVideoPlayActivity shortVideoPlayActivity2 = ShortVideoPlayActivity.this;
            if (shortVideoPlayActivity2.mMediaPlayer != null) {
                if (shortVideoPlayActivity2.mPlayState == 2) {
                    shortVideoPlayActivity2.resume();
                }
                if (progress != 10000) {
                    ShortVideoPlayActivity.this.play(i3);
                } else {
                    ShortVideoPlayActivity.this.pause();
                }
            }
            ShortVideoPlayActivity.this.mUserDragging = false;
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        final /* synthetic */ String C;
        final /* synthetic */ String D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f186261d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f186262e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f186263f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f186264h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f186265i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f186266m;

        e(ActionSheet actionSheet, String str, String str2, String str3, boolean z16, String str4, String str5, String str6) {
            this.f186261d = actionSheet;
            this.f186262e = str;
            this.f186263f = str2;
            this.f186264h = str3;
            this.f186265i = z16;
            this.f186266m = str4;
            this.C = str5;
            this.D = str6;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            this.f186261d.dismiss();
            String content = this.f186261d.getContent(i3);
            if (content != null) {
                if (content.equals(this.f186262e)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "click menu to forward shortVideo......");
                    }
                    ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
                    Bundle extras = ShortVideoPlayActivity.super.getIntent().getExtras();
                    extras.putInt("forward_type", 21);
                    extras.putBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
                    extras.putString(AppConstants.Key.FORWARD_THUMB, com.tencent.mobileqq.shortvideo.j.l(ShortVideoPlayActivity.this.mThumbMd5, "jpg"));
                    extras.putString("file_send_path", this.f186263f);
                    if (FileUtils.fileExistsAndNotEmpty(this.f186263f)) {
                        extras.putBoolean("k_dataline", true);
                        extras.putString(AppConstants.Key.FORWARD_EXTRA, this.f186263f);
                        extras.putBoolean("direct_send_if_dataline_forward", true);
                    }
                    Intent intent = new Intent();
                    intent.putExtras(extras);
                    ForwardBaseOption.startForwardActivity(shortVideoPlayActivity, intent);
                    ShortVideoPlayActivity.super.finish();
                    if (ShortVideoPlayActivity.this.isFromMultiMsg) {
                        com.tencent.mobileqq.multimsg.i.r("0X8009ABC");
                    }
                    ReportController.o(ShortVideoPlayActivity.this.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
                    return;
                }
                if (content.equals(this.f186264h)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "click menu to share to qzone, finalVideoExists=" + this.f186265i);
                    }
                    if (this.f186265i) {
                        ShortVideoPlayActivity.this.forwardToQzone();
                        return;
                    } else {
                        QQToast.makeText(ShortVideoPlayActivity.this.mContext, 0, R.string.hkh, 0).show(ShortVideoPlayActivity.this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        return;
                    }
                }
                if (content.equals(this.f186266m)) {
                    if (!this.f186265i) {
                        QQToast.makeText(ShortVideoPlayActivity.this.mContext, 0, R.string.hkh, 0).show(ShortVideoPlayActivity.this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        return;
                    }
                    if (ShortVideoPlayActivity.this.mHandler.get() != null) {
                        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.C, ShortVideoPlayActivity.this.mHandler.get(), ShortVideoPlayActivity.this.mMd5 + ".mp4", false));
                    }
                    ShortVideoPlayActivity shortVideoPlayActivity2 = ShortVideoPlayActivity.this;
                    int i16 = shortVideoPlayActivity2.mUinType;
                    if (i16 == 0) {
                        ReportController.o(shortVideoPlayActivity2.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    } else if (i16 == 3000) {
                        ReportController.o(shortVideoPlayActivity2.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    } else if (i16 == 1) {
                        ReportController.o(shortVideoPlayActivity2.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    } else {
                        ReportController.o(shortVideoPlayActivity2.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    }
                    DCShortVideo dCShortVideo = new DCShortVideo(BaseApplication.getContext());
                    ShortVideoPlayActivity shortVideoPlayActivity3 = ShortVideoPlayActivity.this;
                    dCShortVideo.h(shortVideoPlayActivity3.app, 2002, shortVideoPlayActivity3.mCurSessionType, shortVideoPlayActivity3.mCurSessionUin);
                    if (ShortVideoPlayActivity.this.isFromMultiMsg) {
                        com.tencent.mobileqq.multimsg.i.r("0X8009ABD");
                        return;
                    }
                    return;
                }
                if (content.equals(this.D)) {
                    if (!this.f186265i) {
                        QQToast.makeText(ShortVideoPlayActivity.this.mContext, 0, R.string.hkh, 0).show(ShortVideoPlayActivity.this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        return;
                    }
                    Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent2.setDataAndType(Uri.parse("file://" + this.C), "video/*");
                    ShortVideoPlayActivity.this.startActivity(intent2);
                    ShortVideoPlayActivity shortVideoPlayActivity4 = ShortVideoPlayActivity.this;
                    int i17 = shortVideoPlayActivity4.mUinType;
                    if (i17 == 0) {
                        ReportController.o(shortVideoPlayActivity4.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    } else if (i17 == 3000) {
                        ReportController.o(shortVideoPlayActivity4.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    } else if (i17 == 1) {
                        ReportController.o(shortVideoPlayActivity4.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    } else {
                        ReportController.o(shortVideoPlayActivity4.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                        ShortVideoPlayActivity.this.mPlaySucReported = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = Float.valueOf(valueAnimator.getAnimatedValue().toString()).floatValue();
            if (ShortVideoPlayActivity.this.mOperatorBar.getVisibility() == 0 && Math.abs(ShortVideoPlayActivity.this.mOperatorBar.getAlpha() - floatValue) >= 0.02f) {
                ShortVideoPlayActivity.this.mOperatorBar.setAlpha(floatValue);
            }
            if (ShortVideoPlayActivity.this.mTitleBar.getVisibility() == 0 && Math.abs(ShortVideoPlayActivity.this.mOperatorBar.getAlpha() - floatValue) >= 0.02f) {
                ShortVideoPlayActivity.this.mTitleBar.setAlpha(Float.valueOf(floatValue).floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ShortVideoPlayActivity.this.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class j extends a.c {

        /* loaded from: classes10.dex */
        class a extends QQPermission.BasePermissionsListener {
            a() {
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                ShortVideoPlayActivity.this.saveToPhone();
            }
        }

        j() {
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void a() {
            if (ShortVideoPlayActivity.this.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                ShortVideoPlayActivity.this.saveToPhone();
            } else {
                QQPermissionFactory.getQQPermission((Activity) ShortVideoPlayActivity.this.mContext, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
            }
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void c() {
            ShortVideoPlayActivity.this.openWithOtherApp();
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void d(Bundle bundle) {
            Intent intentForStartForwardRecentActivity = ShortVideoPlayActivity.this.getIntentForStartForwardRecentActivity();
            intentForStartForwardRecentActivity.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult((Activity) ShortVideoPlayActivity.this.mContext, intentForStartForwardRecentActivity, (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_shoucang");
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void e() {
            ShortVideoPlayActivity.this.forwardFavorite();
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public int m() {
            return ShortVideoPlayActivity.this.getActionTypes();
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void n() {
            ShortVideoPlayActivity.this.shareToPC();
        }

        @Override // cooperation.qqfav.widget.a.c, cooperation.qqfav.widget.a.b
        public void o() {
            ShortVideoPlayActivity.this.moveToGroup();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class k extends cooperation.qqfav.widget.a {
        k(Activity activity, a.b bVar, int i3, int i16, AppRuntime appRuntime) {
            super(activity, bVar, i3, i16, appRuntime);
        }

        @Override // cooperation.qqfav.widget.a, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            super.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class l implements DialogInterface.OnClickListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
            if (shortVideoPlayActivity.mMediaPlayer != null) {
                if (shortVideoPlayActivity.mPlayState == 2) {
                    shortVideoPlayActivity.resume();
                }
                ShortVideoPlayActivity shortVideoPlayActivity2 = ShortVideoPlayActivity.this;
                shortVideoPlayActivity2.play(shortVideoPlayActivity2.mCurrentPosition);
            }
            com.tencent.mobileqq.shortvideo.h.f287890b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class m implements DialogInterface.OnClickListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            WeakReference<ISuperPlayer> weakReference = ShortVideoPlayActivity.this.mMediaPlayer;
            if (weakReference != null && weakReference.get() != null) {
                ShortVideoPlayActivity.this.mMediaPlayer.get().pauseDownload();
            }
        }
    }

    /* loaded from: classes10.dex */
    class n extends BroadcastReceiver {
        n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPlayActivity.TAG, 2, "onReceive ===>" + action);
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) || ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                WeakReference<ISuperPlayer> weakReference = ShortVideoPlayActivity.this.mMediaPlayer;
                if (weakReference != null && weakReference.get() != null && ShortVideoPlayActivity.this.mMediaPlayer.get().isPlaying()) {
                    ShortVideoPlayActivity.this.mNeedPlay = true;
                }
                ShortVideoPlayActivity.this.pause();
            }
        }
    }

    /* loaded from: classes10.dex */
    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ShortVideoPlayActivity.this.startActivity(new Intent(ShortVideoPlayActivity.this, (Class<?>) QQBrowserActivity.class).putExtra("url", ShortVideoPlayActivity.this.mHotVideoJumpUrl));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ShortVideoPlayActivity.this.startActivity(new Intent(ShortVideoPlayActivity.this, (Class<?>) QQBrowserActivity.class).putExtra("url", ShortVideoPlayActivity.this.mHotVideoJumpUrl));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        String Q1 = ea.Q1(BaseApplication.getContext());
        mCfgString = Q1;
        if (Q1 != null && Q1.length() > 0) {
            mListString = mCfgString.split("\\|");
        }
    }

    public ShortVideoPlayActivity() {
        this.mValueAnimator = null;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f);
        this.mValueAnimator = ofFloat;
        ofFloat.setDuration(2500L);
        this.mValueAnimator.addUpdateListener(new f());
        this.mHandler = new WeakReference<>(new g());
        this.mProgressChecker = new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (ShortVideoPlayActivity.this.isPlaying()) {
                    ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
                    if (shortVideoPlayActivity.mDuration <= 0) {
                        shortVideoPlayActivity.initDuration();
                    }
                    WeakReference<ISuperPlayer> weakReference = ShortVideoPlayActivity.this.mMediaPlayer;
                    if (weakReference != null && weakReference.get() != null) {
                        ShortVideoPlayActivity shortVideoPlayActivity2 = ShortVideoPlayActivity.this;
                        shortVideoPlayActivity2.mCurPlayPosition = shortVideoPlayActivity2.mMediaPlayer.get().getCurrentPositionMs();
                    }
                    if (ShortVideoPlayActivity.this.mCurPlayPosition != 0) {
                        ShortVideoPlayActivity.this.mPlayProgress = (int) (((r0.mCurPlayPosition * 10000) / ShortVideoPlayActivity.this.mDuration) + 0.5d);
                        if (!ShortVideoPlayActivity.this.hasUserSeeked) {
                            ShortVideoPlayActivity shortVideoPlayActivity3 = ShortVideoPlayActivity.this;
                            shortVideoPlayActivity3.playDurationForReport = shortVideoPlayActivity3.mCurPlayPosition;
                        }
                        if (!ShortVideoPlayActivity.this.mUserDragging) {
                            ShortVideoPlayActivity shortVideoPlayActivity4 = ShortVideoPlayActivity.this;
                            shortVideoPlayActivity4.mSeekBar.setProgress(shortVideoPlayActivity4.mPlayProgress);
                            ShortVideoPlayActivity shortVideoPlayActivity5 = ShortVideoPlayActivity.this;
                            shortVideoPlayActivity5.setProgressTime(shortVideoPlayActivity5.mCurPlayPosition);
                        }
                    }
                }
                ShortVideoPlayActivity shortVideoPlayActivity6 = ShortVideoPlayActivity.this;
                if (shortVideoPlayActivity6.mMediaPlayer != null) {
                    long j3 = shortVideoPlayActivity6.mFileSize;
                    if (j3 != 0) {
                        if (shortVideoPlayActivity6.mNeedDownload) {
                            try {
                                shortVideoPlayActivity6.mCacheProgress = (int) ((shortVideoPlayActivity6.mTransferredSize * 10000) / j3);
                            } catch (Throwable unused) {
                            }
                        } else {
                            shortVideoPlayActivity6.mCacheProgress = 10000;
                        }
                        if (ShortVideoPlayActivity.this.mSeekBar.getSecondaryProgress() != ShortVideoPlayActivity.this.mCacheProgress) {
                            ShortVideoPlayActivity shortVideoPlayActivity7 = ShortVideoPlayActivity.this;
                            shortVideoPlayActivity7.mSeekBar.setSecondaryProgress(shortVideoPlayActivity7.mCacheProgress);
                        }
                    }
                }
                if (ShortVideoPlayActivity.this.isBuffering() && ShortVideoPlayActivity.this.mSpeedKBS > 0 && ShortVideoPlayActivity.this.mRateText != null && ShortVideoPlayActivity.this.mRateText.getVisibility() == 0) {
                    String stringForFileSize = ShortVideoUtils.stringForFileSize(ShortVideoPlayActivity.this.mContext, r0.mSpeedKBS * 1024);
                    ShortVideoPlayActivity.this.mRateText.setText(stringForFileSize + "/s");
                }
                if (ShortVideoPlayActivity.this.isFinishing()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "check progress, while finishing");
                    }
                } else if (ShortVideoPlayActivity.this.mHandler.get() != null) {
                    ShortVideoPlayActivity.this.mHandler.get().postDelayed(ShortVideoPlayActivity.this.mProgressChecker, 50L);
                }
            }
        };
        this.mStartHidingRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoPlayActivity.TAG, 2, "mStartHidingRunnable run");
                }
                ShortVideoPlayActivity.this.startHiding();
            }
        };
        this.mHidden = true;
        this.mReceiver = new n();
        this.mOnSeekBarChangeListener = new d();
    }

    private boolean checkHaveSdCard(Context context) {
        boolean z16;
        boolean z17;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Environment.getExternalStorageState().equals("mounted") && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        QQToast.makeText(context, 1, R.string.h9v, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return false;
    }

    private com.tencent.mobileqq.shortvideo.n creatDownloadInfo() {
        com.tencent.mobileqq.shortvideo.n nVar = new com.tencent.mobileqq.shortvideo.n();
        try {
            JSONObject jSONObject = new JSONObject(this.mVideoInfo);
            nVar.f288040c = jSONObject.getInt(QWSoterConstans.CGI_KEY_BUSI_TYPE);
            nVar.f288039b = jSONObject.getString(ShortVideoConstants.FILE_UUID);
            String string = jSONObject.getString("file_md5");
            nVar.f288047j = string;
            this.mMd5 = string;
            nVar.f288192p = jSONObject.getInt("file_size");
            nVar.f288041d = this.mCurSessionType;
            nVar.f288042e = this.mCurrentUin;
            String str = this.mCurSessionUin;
            nVar.f288043f = str;
            nVar.f288044g = str;
            nVar.f288195s = 1001;
            this.mFileType = 1001;
            nVar.f288193q = getPubAccountLocalPath(nVar.f288047j);
            return nVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private void createActionSheet() {
        if (this.mPlayCallerType != 3) {
            return;
        }
        this.mFavActionSheet = new k(this, new j(), getActionTypes(), 5, this.app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardToQzone() {
        QZoneHelper.forwardToPublishMood(getActivity(), QZoneHelper.UserInfo.getInstance(), this.mVideoPath, 10001);
        ReportController.o(this.app, "dc00898", "", "", "0X800753A", "0X800753A", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getActionTypes() {
        int i3;
        if (this.mFavId != -1) {
            i3 = 16456;
        } else {
            i3 = MtpConstants.TYPE_AUINT64;
        }
        return i3 | 512;
    }

    private String getFileSizeString(long j3) {
        if (j3 < 1024) {
            return j3 + "B";
        }
        if (j3 < 1048576) {
            return String.format("%.2f", Float.valueOf(((float) j3) / 1024.0f)) + "K";
        }
        return String.format("%.2f", Float.valueOf(((float) j3) / 1048576.0f)) + "M";
    }

    private void getHttpHeaderInfo(String str) throws IOException {
        String[] split;
        String str2;
        String str3;
        if (StringUtil.isEmpty(str) || (split = str.split("\r\n")) == null) {
            return;
        }
        this.mHttpStatus = getHttpResponseCode(split[0]);
        boolean z16 = true;
        for (int i3 = 1; i3 < split.length; i3++) {
            String str4 = split[i3];
            if (str4.startsWith(HttpMsg.USERRETURNCODE)) {
                this.mUserReturnCode = getHttpValue(str4);
            } else if (str4.startsWith(HttpMsg.XRetryFlag)) {
                this.mXRtFlag = getHttpValue(str4);
            } else if (str4.startsWith("Content-Type")) {
                this.mContentType = getHttpValue(str4);
            }
        }
        String[] strArr = mListString;
        if (strArr != null && strArr.length > 0 && (str2 = this.mContentType) != null && str2.length() > 0) {
            String[] strArr2 = mListString;
            if (strArr2.length == 1 && (str3 = strArr2[0]) != null && str3.toLowerCase().equals("allin")) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "check content all in");
                }
            } else {
                String[] strArr3 = mListString;
                int length = strArr3.length;
                int i16 = 0;
                while (true) {
                    if (i16 < length) {
                        String str5 = strArr3[i16];
                        if (str5 != null && this.mContentType.contains(str5)) {
                            break;
                        } else {
                            i16++;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            }
            if (!z16) {
                StringBuilder sb5 = new StringBuilder();
                for (String str6 : mListString) {
                    if (str6 != null) {
                        sb5.append(str6);
                        sb5.append("|");
                    }
                }
                String str7 = "not accept content type: real:" + this.mContentType + ". whiteList_type :" + sb5.toString();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, str7);
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                hashMap.put("Content-Type", this.mContentType);
                hashMap.put("White-List", sb5.toString());
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SDK_DOWNLOAD_HIJACKED, true, 0L, 0L, hashMap, "");
                throw new IOException(str7);
            }
        }
    }

    private int getHttpResponseCode(String str) {
        String trim;
        int indexOf;
        int i3;
        String substring;
        if (str != null && (indexOf = (trim = str.trim()).indexOf(32)) >= 0 && (i3 = indexOf + 1) < trim.length() && (substring = trim.substring(i3)) != null) {
            String trim2 = substring.trim();
            try {
                return Integer.parseInt(trim2.substring(0, trim2.indexOf(32)));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return -1;
    }

    private String getHttpValue(String str) {
        int indexOf;
        int i3;
        String substring;
        if (str != null && (indexOf = str.indexOf(58)) >= 0 && (i3 = indexOf + 1) < str.length() && (substring = str.substring(i3)) != null) {
            return substring.trim();
        }
        return null;
    }

    private String getPubAccountLocalPath(String str) {
        StringBuilder sb5 = new StringBuilder(AppConstants.SDCARD_PATH);
        sb5.append("shortvideo");
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(IPublicAccountWebviewPlugin.SCHEME);
        sb5.append(str2);
        sb5.append(this.mCurrentUin);
        sb5.append(str2);
        sb5.append(str);
        sb5.append(".");
        sb5.append("mp4");
        return sb5.toString();
    }

    private void initVideoData() {
        v c16;
        if (this.mIsUploading) {
            ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
            MessageForShortVideo messageForShortVideo = this.mMsg;
            IHttpCommunicatorListener findProcessor = iTransFileController.findProcessor(messageForShortVideo.frienduin, messageForShortVideo.uniseq);
            if (findProcessor instanceof IShortVideoUploadProcessor) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) findProcessor;
                updateUploadInfo(baseTransProcessor.getTransferedSize(), baseTransProcessor.getFileSize());
            }
            y d16 = y.d(this.app);
            if (d16 != null) {
                d16.a(this.mRoot, this);
            }
            this.mVideoPath = com.tencent.mobileqq.shortvideo.j.j(this.mMsg, "mp4");
            if (new File(this.mVideoPath).exists()) {
                long j3 = this.mMsg.videoFileSize;
                this.mFileSize = j3;
                this.mTransferredSize = j3;
                this.mCacheProgress = 10000;
            } else {
                showErrorDlg(HardCodeUtil.qqStr(R.string.thy));
            }
            play(this.mCurrentPosition);
            return;
        }
        showAnimation();
        int i3 = this.mPlayCallerType;
        if (i3 != 1 && i3 != 2 && i3 != 4 && this.mUinType != 9501 && i3 != 6) {
            if (i3 == 0 || i3 == 5) {
                if (this.mMsg.getBitValue(1) == 0) {
                    this.mMsg.setBitValue(1, (byte) 1);
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.12
                        @Override // java.lang.Runnable
                        public void run() {
                            ShortVideoPlayActivity.this.mMsg.serial();
                            QQMessageFacade messageFacade = ShortVideoPlayActivity.this.app.getMessageFacade();
                            MessageForShortVideo messageForShortVideo2 = ShortVideoPlayActivity.this.mMsg;
                            messageFacade.Y0(messageForShortVideo2.frienduin, messageForShortVideo2.istroop, messageForShortVideo2.uniseq, messageForShortVideo2.msgData);
                        }
                    });
                }
                this.mVideoPath = com.tencent.mobileqq.shortvideo.j.j(this.mMsg, "mp4");
                File file = new File(this.mVideoPath);
                if (file.exists()) {
                    this.mTransferredSize = file.length();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.mTransferredSize + " msg.size=" + this.mMsg.videoFileSize + " status=" + this.mMsg.videoFileStatus);
                    }
                    this.mFileSize = this.mMsg.videoFileSize;
                    this.mCacheProgress = 10000;
                    this.mSeekBar.setSecondaryProgress(10000);
                    this.mNeedReportProgressive = false;
                    if (this.mTransferredSize < this.mFileSize) {
                        this.mNeedDownload = true;
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
                    }
                    this.mNeedDownload = true;
                }
                if (this.mNeedDownload) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
                    }
                    if (checkHaveSdCard(this.mContext) && (c16 = com.tencent.mobileqq.shortvideo.h.c(this.app, this.mMsg, 1)) != null) {
                        com.tencent.mobileqq.shortvideo.l.e(c16, this.app);
                        this.mFileType = c16.f288268i.f288195s;
                        reportDownloadVideo(this.mMsg);
                    }
                    y d17 = y.d(this.app);
                    if (d17 != null) {
                        d17.a(this.mRoot, this);
                    }
                    long j16 = this.mMsg.videoFileSize;
                    this.mFileSize = j16;
                    int i16 = (int) ((this.mTransferredSize * 10000) / j16);
                    this.mCacheProgress = i16;
                    this.mPlayProgress = 0;
                    this.mCurPlayPosition = 0L;
                    this.mNeedReportProgressive = true;
                    this.mSeekBar.setSecondaryProgress(i16);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onCreateVideoSdkView() mCacheProgress=" + this.mCacheProgress + ",mTransferredSize=" + this.mTransferredSize);
                    }
                }
                if (this.mPlayCallerType == 5) {
                    this.mMenuBtn.setVisibility(8);
                }
            }
        } else {
            this.mMenuBtn.setVisibility(8);
            if (this.mPlayCallerType == 2 && this.mVideoInfo != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mVideoInfo);
                    this.mFileType = 1001;
                    this.mVideoPath = getPubAccountLocalPath(jSONObject.getString("file_md5"));
                    this.mFileSize = jSONObject.getInt("file_size");
                    this.mUuid = jSONObject.getString(ShortVideoConstants.FILE_UUID);
                } catch (Exception unused) {
                }
                File file2 = new File(this.mVideoPath);
                if (file2.exists() && file2.isFile()) {
                    this.mTransferredSize = file2.length();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.mTransferredSize + " msg.size=" + this.mFileSize);
                    }
                    if (this.mTransferredSize < this.mFileSize) {
                        this.mNeedDownload = true;
                    }
                } else {
                    this.mNeedDownload = true;
                }
                if (this.mNeedDownload) {
                    startDownLoadVideoForPubAccount();
                    y d18 = y.d(this.app);
                    if (d18 != null) {
                        d18.a(this.mRoot, this);
                    }
                    this.mSeekBar.setSecondaryProgress(this.mCacheProgress);
                }
            }
        }
        boolean z16 = this.mNeedDownload;
        this.mPlayWithDownload = z16;
        if (!z16) {
            play(this.mCurrentPosition);
        } else {
            dismissLoadingView();
            changePlayState(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToGroup() {
        QfavHelper.w(this.mContext, this.app.getCurrentUin(), this.mFavId, this.mFavGroupId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWithOtherApp() {
        String videoPath = getVideoPath();
        if (!isVideoExist(videoPath)) {
            QQToast.makeText(this.mContext, 0, R.string.hkh, 0).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setDataAndType(Uri.parse("file://" + videoPath), "video/*");
        startActivity(intent);
        int i3 = this.mUinType;
        if (i3 == 0) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
            this.mPlaySucReported = true;
        } else if (i3 == 3000) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
            this.mPlaySucReported = true;
        } else if (i3 == 1) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
            this.mPlaySucReported = true;
        } else {
            ReportController.o(this.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
            this.mPlaySucReported = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remindIfContinueDownload() {
        boolean z16 = this.mNeedDownload;
        if (com.tencent.mobileqq.shortvideo.h.f287890b || System.currentTimeMillis() - com.tencent.mobileqq.shortvideo.h.f287889a < MiniBoxNoticeInfo.MIN_5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "needRemind=false");
            }
            z16 = false;
        }
        if (z16) {
            String string = this.mContext.getString(R.string.f173150hl4);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mContext, 230, (String) null, string, R.string.f171142no, R.string.ihc, new l(), new m());
            CharSequence c16 = CUOpenCardGuideMng.c(this.mContext, this.app, 1, string);
            if (c16 instanceof SpannableString) {
                createCustomDialog.setMessageWithoutAutoLink(c16);
            }
            pause();
            this.mNeedPlay = false;
            showDialogSafe(createCustomDialog);
        }
    }

    private void removeAllListener() {
        ISuperPlayer iSuperPlayer = this.mMediaPlayer.get();
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnCompletionListener(null);
            iSuperPlayer.setOnErrorListener(null);
            iSuperPlayer.setOnVideoPreparedListener(null);
            iSuperPlayer.setOnSeekCompleteListener(null);
            iSuperPlayer.setOnInfoListener(null);
            iSuperPlayer.setOnCaptureImageListener(null);
        }
    }

    private void reportDownloadResult(boolean z16) {
        String str;
        if (!this.mNeedDownloadReport || !this.mPlayWithDownload) {
            return;
        }
        if (this.mErrCode == 0) {
            z16 = true;
        }
        if (this.mMsg == null) {
            return;
        }
        this.mNeedDownloadReport = false;
        HashMap<String, String> hashMap = new HashMap<>();
        int i3 = this.mFileType;
        if (i3 == 6 || (i3 != 9 && i3 != 17)) {
            str = StatisticCollector.C2C_SHORTVIDEO_DOWNLOAD_VIDEO;
        } else {
            hashMap.put(ReportConstant.KEY_GROUP_ID, this.mCurSessionUin);
            str = StatisticCollector.GROUP_SHORTVIDEO_DOWNLOAD_VIDEO;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportTag = " + str);
        }
        hashMap.put(ReportConstant.KEY_UUID, this.mUuid);
        hashMap.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
        hashMap.put(ReportConstant.KEY_FILE_MD5, this.mMd5);
        hashMap.put("param_busiType", this.mPlayCallerType + "");
        hashMap.put("param_videoDuration", String.valueOf(this.mMsg.videoFileTime));
        if (z16) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, this.mHttpCost, this.mFileSize, hashMap, "");
            return;
        }
        if (this.mErrCode != -9527) {
            hashMap.remove("param_rspHeader");
        }
        hashMap.put("param_FailCode", String.valueOf(this.mErrCode));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, false, this.mHttpCost, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToPhone() {
        String videoPath = getVideoPath();
        if (!isVideoExist(videoPath)) {
            QQToast.makeText(this.mContext, 0, R.string.hkh, 0).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (this.mHandler.get() != null) {
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(videoPath, this.mHandler.get(), this.mMd5 + ".mp4", false));
        }
        int i3 = this.mUinType;
        if (i3 == 0) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
            this.mPlaySucReported = true;
        } else if (i3 == 3000) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
            this.mPlaySucReported = true;
        } else if (i3 == 1) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
            this.mPlaySucReported = true;
        } else {
            ReportController.o(this.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
            this.mPlaySucReported = true;
        }
        new DCShortVideo(BaseApplication.getContext()).h(this.app, 2002, this.mCurSessionType, this.mCurSessionUin);
        if (this.isFromMultiMsg) {
            com.tencent.mobileqq.multimsg.i.r("0X8009ABD");
        }
    }

    private void setSystemUiVisibility() {
        RelativeLayout relativeLayout;
        if (VersionUtils.isJellyBean() && !ShortVideoUtils.isInFullScreenBlackList() && (relativeLayout = this.mRoot) != null) {
            relativeLayout.setSystemUiVisibility(1284);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogSafe(Dialog dialog) {
        if (QBaseActivity.mAppForground && !isFinishing()) {
            try {
                dialog.show();
            } catch (Throwable unused) {
            }
        }
    }

    private void startDownLoadVideoForPubAccount() {
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startDownLoadVideoForPubAccount: " + this.mVideoInfo);
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Environment.getExternalStorageState().equals("mounted") && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            QQToast.makeText(this.mContext, 1, R.string.h9v, 0).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        v b16 = com.tencent.mobileqq.shortvideo.h.b(2, 0);
        com.tencent.mobileqq.shortvideo.n creatDownloadInfo = creatDownloadInfo();
        if (!AppNetConnInfo.isWifiConn() && creatDownloadInfo != null && creatDownloadInfo.f288192p > 204800) {
            showDialogSafe(DialogUtil.createCustomDialog(this, 230, getString(R.string.hl5), getString(R.string.hl6), new a(), new b()));
        }
        if (creatDownloadInfo != null) {
            creatDownloadInfo.f288198v = true;
            b16.f288268i = creatDownloadInfo;
            com.tencent.mobileqq.shortvideo.l.e(b16, this.app);
            this.publicAccountLocalPath = creatDownloadInfo.f288193q;
        }
    }

    private void switchToNormalPlayUI() {
        RelativeLayout relativeLayout = this.mUploadOperateLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        this.mNormalOperateLayout.setVisibility(0);
    }

    private void updateMsgStatus() {
        int i3;
        int i16;
        int i17;
        String str;
        MessageForShortVideo messageForShortVideo = this.mMsg;
        if (messageForShortVideo == null || (i3 = this.mStatus) == -1 || (i16 = messageForShortVideo.videoFileStatus) == 2003 || !this.mNeedUpdateMsg) {
            return;
        }
        this.mNeedUpdateMsg = false;
        long j3 = this.mFileSize;
        if (j3 == 0) {
            i17 = 0;
        } else {
            i17 = (int) ((this.mTransferredSize * 100) / j3);
        }
        if (messageForShortVideo.videoFileProgress < 0) {
            messageForShortVideo.videoFileProgress = 0;
        }
        int i18 = messageForShortVideo.videoFileProgress;
        if ((i16 == 1002 || i16 == 2002) && i16 == i3 && i17 - i18 < 10) {
            return;
        }
        int i19 = this.mFileType;
        if (i19 == 6 || i19 == 17 || i19 == 9 || i19 == 67 || i19 == 20) {
            if (i3 == 2002) {
                messageForShortVideo.transferedSize = (int) this.mTransferredSize;
            }
            if (i3 == 2003) {
                messageForShortVideo.transferedSize = 0;
                i17 = 100;
            }
        }
        if ((i16 != 2004 && i16 != 1004) || (i3 != 1002 && i3 != 2002)) {
            messageForShortVideo.videoFileStatus = i3;
            messageForShortVideo.fileType = i19;
            messageForShortVideo.videoFileProgress = i17;
            if (messageForShortVideo.mPreUpload && i3 == 1003 && (str = this.mMd5) != null) {
                messageForShortVideo.md5 = str;
            }
            if (i3 == 2003 && !StringUtil.isEmpty(this.mVideoPath)) {
                this.mMsg.lastModified = new File(this.mVideoPath).lastModified();
            }
            this.mMsg.serial();
            QQMessageFacade messageFacade = this.app.getMessageFacade();
            MessageForShortVideo messageForShortVideo2 = this.mMsg;
            messageFacade.Y0(messageForShortVideo2.frienduin, this.mUinType, messageForShortVideo2.uniseq, messageForShortVideo2.msgData);
        }
    }

    private void updateUploadInfo(long j3, long j16) {
        int i3;
        if (j16 != 0) {
            i3 = (int) ((100 * j3) / j16);
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateUploadInfo " + i3 + " " + j3 + " " + j16);
        }
        TextView textView = this.mUploadProgress;
        if (textView != null) {
            textView.setText(getFileSizeString(j3) + "/" + getFileSizeString(j16));
        }
        SeekBar seekBar = this.mUploadingSeekBar;
        if (seekBar != null) {
            seekBar.setProgress(i3);
        }
    }

    public void adMsgVideoReport(String str, int i3, int i16, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String str3 = "0";
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ad_id")) {
                    str3 = jSONObject.getString("ad_id");
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parse ad_id error");
                }
            }
            ReportController.n(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005D93", "0X8005D93", i16, 1, i3, str3, str2, "", "");
        }
    }

    void changePlayState(final int i3) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.16
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPlayActivity.this.innerChangePlayerState(i3);
            }
        });
    }

    void delayStartHiding() {
        WeakReference<ISuperPlayer> weakReference;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "delayStartHiding");
        }
        if (this.mHandler.get() != null) {
            this.mHandler.get().removeCallbacks(this.mStartHidingRunnable);
            if (this.mPlayState == 1 && (weakReference = this.mMediaPlayer) != null && weakReference.get() != null && this.mMediaPlayer.get().isPlaying()) {
                this.mHandler.get().postDelayed(this.mStartHidingRunnable, 2500L);
            }
        }
    }

    void dismissLoadingImage() {
        URLImageView uRLImageView = this.mCoverIV;
        if (uRLImageView != null && uRLImageView.getVisibility() == 0) {
            this.mCoverIV.setVisibility(8);
        }
    }

    void dismissLoadingView() {
        TextView textView = this.mLoadingText;
        if (textView != null && textView.getVisibility() == 0) {
            this.mLoadingText.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void doNewReport() {
        int i3;
        int i16;
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        String str5;
        if (!this.mNeedReportAioVideo || this.mMsg == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.mNeedDownload) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (this.mPlayResult == 0) {
            i3 = 3;
        }
        hashMap.put("player_state", String.valueOf(i3));
        stringBuffer.append(" player_state " + i3);
        hashMap.put("Download", String.valueOf(this.mPlayWithDownload));
        stringBuffer.append(" Download" + this.mPlayWithDownload);
        hashMap.put("FileSize", String.valueOf(this.mFileSize));
        stringBuffer.append(" FileSize" + this.mFileSize);
        hashMap.put("HttpDownloadSum", String.valueOf(this.mHttpDownloadSum));
        stringBuffer.append(" HttpDownloadSum" + this.mHttpDownloadSum);
        if (!this.mPlayWithDownload) {
            hashMap.put("DataFromCacheSize", String.valueOf(this.mFileSize));
            stringBuffer.append(" DataFromCacheSize" + this.mFileSize);
        } else {
            hashMap.put("DataFromCacheSize", String.valueOf(this.mDataFromCacheSize));
            stringBuffer.append(" DataFromCacheSize" + this.mDataFromCacheSize);
        }
        hashMap.put("FileDuration", String.valueOf(this.mDuration));
        stringBuffer.append(" FileDuration" + this.mDuration);
        hashMap.put("PlayTime", String.valueOf(this.mPlayCost));
        stringBuffer.append(" PlayTime" + this.mPlayCost);
        hashMap.put("PlayStateCount", String.valueOf(this.mRealPlayTimes));
        stringBuffer.append(" PlayStateCount" + this.mRealPlayTimes);
        hashMap.put("PlayProgress", String.valueOf(this.mPlayProgress / 100));
        stringBuffer.append(" PlayProgress" + (this.mPlayProgress / 100));
        hashMap.put("FirstPlayTime", String.valueOf(this.mMessageClickCost));
        stringBuffer.append(" FirstPlayTime" + this.mMessageClickCost);
        hashMap.put("FirstBufferTime", String.valueOf(this.mOpenPlayerCost));
        stringBuffer.append(" FirstBufferTime" + this.mOpenPlayerCost);
        hashMap.put("SeekTimes", String.valueOf(this.mNewSeekTimes));
        stringBuffer.append(" SeekTimes" + this.mNewSeekTimes);
        int i17 = this.mBufferTimes;
        if (i17 != 0) {
            i17--;
        }
        hashMap.put("BufferTimes", String.valueOf(i17));
        stringBuffer.append(" BufferTimes" + i17);
        hashMap.put("BufferCostTime", String.valueOf(this.mBufferCost));
        stringBuffer.append(" BufferCostTime" + this.mBufferCost);
        if (this.mHttpStart != 0) {
            this.mHttpCost = System.currentTimeMillis() - this.mHttpStart;
            this.mHttpStart = 0L;
        }
        int i18 = this.mHttpDownloadCount;
        if (i18 != 0) {
            i16 = this.mHttpDownloadSum / (i18 * 1000);
        } else {
            i16 = 0;
        }
        hashMap.put("SpeedKBS", String.valueOf(i16));
        stringBuffer.append(" SpeedKBS" + i16);
        String str6 = "1";
        if (this.mReplayTimes > 0) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("IsRePlay", str);
        stringBuffer.append(" IsRePlay" + this.mReplayTimes);
        hashMap.put("SuspendTimes", String.valueOf(this.mPauseTimes));
        stringBuffer.append(" SuspendTimes" + this.mPauseTimes);
        int i19 = this.mErrCode;
        if (i19 != 0) {
            hashMap.put("param_FailCode", String.valueOf(i19));
            z16 = false;
        } else {
            z16 = true;
        }
        hashMap.put("ErrorCode", String.valueOf(this.mSdkErrorCode));
        hashMap.put("ErrorDetailCode", String.valueOf(this.mSdkDetailErrorCode));
        hashMap.put("HttpStatus", String.valueOf(this.mHttpStatus));
        stringBuffer.append(" HttpStatus" + this.mHttpStatus);
        hashMap.put(HttpMsg.USERRETURNCODE, this.mUserReturnCode);
        stringBuffer.append(" User-ReturnCode" + this.mUserReturnCode);
        hashMap.put(HttpMsg.XRetryFlag, this.mXRtFlag);
        stringBuffer.append(" X-RtFlag" + this.mXRtFlag);
        StringBuffer stringBuffer2 = new StringBuffer("");
        if (!StringUtil.isEmpty(this.mHttpUrl)) {
            str2 = InnerDns.getHostFromUrl(this.mHttpUrl);
        } else {
            str2 = null;
        }
        String[] strArr = this.mVideoUrls;
        int i26 = -1;
        if (strArr != null && strArr.length > 0) {
            int i27 = -1;
            int i28 = 0;
            while (true) {
                String[] strArr2 = this.mVideoUrls;
                if (i28 >= strArr2.length) {
                    break;
                }
                String hostFromUrl = InnerDns.getHostFromUrl(strArr2[i28]);
                stringBuffer2.append(hostFromUrl + ",");
                if (i27 == -1 && !StringUtil.isEmpty(str2) && str2.equals(hostFromUrl)) {
                    i27 = i28;
                }
                i28++;
            }
            i26 = i27;
        }
        hashMap.put("IpList", stringBuffer2.toString());
        int i29 = i26 + 1;
        hashMap.put("SuccIpIndex", String.valueOf(i29));
        stringBuffer.append(" SuccIpIndex" + i29);
        hashMap.put("HttpDomain", this.mDomain);
        stringBuffer.append(" HttpDomain" + this.mDomain);
        hashMap.put("HttpRedirectNum", String.valueOf(this.mHttpRedirectNum));
        stringBuffer.append(" HttpRedirectNum" + this.mHttpRedirectNum);
        hashMap.put("HttpRedirectCostMs", String.valueOf(this.mHttpRedirectCostMs));
        stringBuffer.append(" HttpRedirectCostMs" + this.mHttpRedirectCostMs);
        hashMap.put("HttpDnsCostMs", String.valueOf(this.mHttpDNSCost));
        stringBuffer.append(" HttpDnsCostMs" + this.mHttpDNSCost);
        hashMap.put("HttpConnectCostMs", String.valueOf(this.mHttpConnectCost));
        stringBuffer.append(" HttpConnectCostMs" + this.mHttpConnectCost);
        hashMap.put("HttpFirstRecvCostMs", String.valueOf(this.mHttpFirstRecvCost));
        stringBuffer.append(" HttpFirstRecvCostMs" + this.mHttpFirstRecvCost);
        hashMap.put("RetrySuccessTimes", "0");
        hashMap.put("RetryFailedTimes", "0");
        hashMap.put("ApplyCostTime", String.valueOf(this.mStepUrlCost));
        stringBuffer.append(" ApplyCostTime" + this.mStepUrlCost);
        hashMap.put("HttpCostTime", String.valueOf(this.mHttpCost));
        stringBuffer.append(" HttpCostTime" + this.mHttpCost);
        hashMap.put("DownType", "1");
        hashMap.put("SceneType", "2");
        hashMap.put("BusiType", String.valueOf(this.mPlayCallerType));
        hashMap.put("SubBusiType", String.valueOf(this.mMsg.subBusiType));
        hashMap.put("FromUin", String.valueOf(this.mCurrentUin));
        hashMap.put("GrpUin", String.valueOf(this.mCurSessionUin));
        hashMap.put("Uuid", String.valueOf(this.mUuid));
        hashMap.put("MsgFileMd5", String.valueOf(this.mMd5));
        hashMap.put("DownFileMd5", String.valueOf(this.mMd5));
        String valueOf = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
        hashMap.put("NetworkInfo", valueOf);
        stringBuffer.append(" NetworkInfo" + valueOf);
        hashMap.put("ProductVersion", String.valueOf(this.app.getAppid()));
        hashMap.put("EncryptKey", "0");
        if (this.mIsUpdateSDK) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("IsUpdateSuit", str3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" IsUpdateSuit");
        if (this.mIsUpdateSDK) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        sb5.append(str4);
        stringBuffer.append(sb5.toString());
        hashMap.put("UpdateSuitCostTime", String.valueOf(this.mUpdateSDKCost));
        stringBuffer.append(" UpdateSuitCostTime" + this.mUpdateSDKCost);
        if (this.mUpdateSDKResult) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        hashMap.put("UpdateSuitResult", str5);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(" UpdateSuitResult");
        if (!this.mUpdateSDKResult) {
            str6 = "0";
        }
        sb6.append(str6);
        stringBuffer.append(sb6.toString());
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, stringBuffer.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.STREAM_VIDEO_PLAY, z16, this.mHttpCost, this.mFileSize, hashMap, "");
        this.mNeedReportAioVideo = false;
        this.mRealPlayTimes = 0;
        this.mNewSeekTimes = 0;
        this.mBufferTimes = 0;
        this.mPauseTimes = 0;
        this.mBufferCost = 0L;
        this.mHttpCost = 0L;
        this.mPlayCost = 0L;
        this.mHttpConnectCost = 0;
        this.mHttpDNSCost = 0;
        this.mMessageClickCost = 0L;
        this.mOpenPlayerCost = 0L;
        this.mStepUrlCost = 0L;
        this.mHttpFirstRecvCost = 0;
        this.mHttpRedirectCostMs = 0;
        this.mUpdateSDKCost = 0L;
        this.mSdkErrorCode = 0;
        this.mSdkDetailErrorCode = 0;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 10001) {
            if (i16 == -1) {
                QQToast.makeText(this, R.string.hky, 0).show();
            }
        } else if (i3 == 21 && i16 == -1) {
            ForwardUtils.w((QQAppInterface) getAppRuntime(), this, getApplicationContext(), intent, null);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        releaseMediaPlayer();
        overridePendingTransition(0, R.anim.f155121ig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        LiuHaiUtils.initLiuHaiProperty(this);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            LiuHaiUtils.enableNotch(this);
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.b2t);
        getWindow().addFlags(128);
        this.mScreenDisplayWidth = getResources().getDisplayMetrics().widthPixels;
        this.mScreenDisplayHeight = getResources().getDisplayMetrics().heightPixels;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aau);
        this.top_blackLH = linearLayout;
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = LiuHaiUtils.sNotchHeight;
            this.top_blackLH.setLayoutParams(layoutParams);
            this.top_blackLH.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "DeviceInfo:PRODUCT=" + Build.PRODUCT + "|MODEL=" + DeviceInfoMonitor.getModel() + "|BOARD=" + Build.BOARD + "|BOOTLOADER=" + Build.BOOTLOADER + "|CPU_ABI=" + Build.CPU_ABI + "|CPU_ABI2=" + Build.CPU_ABI2 + "|DEVICE=" + Build.DEVICE + "|DISPLAY=" + Build.DISPLAY + "|FLNGERPRINT=" + Build.FINGERPRINT + "|HARDWARE=" + Build.HARDWARE + "|ID=" + Build.ID + "|MANUFACTURER=" + Build.MANUFACTURER + "|SDK_INT=" + Build.VERSION.SDK_INT + "|");
        }
        if (bundle != null) {
            this.mCurrentPosition = bundle.getInt(STATE_PLAY_POSITION);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onCreate(), savedInstanceState != null, mCurrentPosition : " + this.mCurrentPosition);
            }
        }
        this.mContext = this;
        this.mBundle = super.getIntent().getExtras();
        initData(super.getIntent());
        if (this.mIsHotVideo) {
            URLImageView uRLImageView = (URLImageView) findViewById(R.id.dzn);
            String str = this.mHotVideoIconUrl;
            if (str != null && !str.isEmpty()) {
                try {
                    uRLImageView.setVisibility(0);
                    uRLImageView.setImageDrawable(URLDrawable.getDrawable(this.mHotVideoIconUrl));
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onCreate(), IsHotVideo  URLDrawable.getDrawable(mHotVideoIconUrl) Exception", e16);
                    }
                    uRLImageView.setVisibility(8);
                }
                String str2 = this.mHotVideoJumpUrl;
                if (str2 != null && !str2.isEmpty()) {
                    uRLImageView.setClickable(true);
                    uRLImageView.setOnClickListener(new o());
                }
            } else {
                uRLImageView.setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onCreate(), IsHotVideo  mHotVideoIconUrl = null");
                }
            }
            URLImageView uRLImageView2 = (URLImageView) findViewById(R.id.ass);
            String str3 = this.mHotVideoCertificatedIconUrl;
            if (str3 != null && !str3.isEmpty()) {
                try {
                    uRLImageView2.setVisibility(0);
                    uRLImageView2.setImageDrawable(URLDrawable.getDrawable(this.mHotVideoCertificatedIconUrl));
                } catch (Exception e17) {
                    uRLImageView2.setVisibility(8);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onCreate(), IsHotVideo  URLDrawable.getDrawable(mHotVideoCertificatedIconUrl) Exception", e17);
                    }
                }
            } else {
                uRLImageView2.setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onCreate(), IsHotVideo  mHotVideoCertificatedIconUrl = null");
                }
            }
            String str4 = this.mHotVideoTitle;
            if (str4 != null && !str4.isEmpty()) {
                TextView textView = (TextView) findViewById(R.id.d9c);
                textView.setVisibility(0);
                textView.setText(this.mHotVideoTitle);
                String str5 = this.mHotVideoJumpUrl;
                if (str5 != null && !str5.isEmpty()) {
                    textView.setClickable(true);
                    textView.setOnClickListener(new p());
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onCreate(), IsHotVideo  mHotVideoTitle = null");
            }
        }
        onCreateController();
        initSDK();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        registerReceiver(this.mReceiver, intentFilter);
        this.app.setHandler(ShortVideoPlayActivity.class, this.mHandler.get());
        this.mStartPlayTime = System.currentTimeMillis();
        ReportController.o(this.app, "dc00898", "", "", "0X8007425", "0X8007425", 0, 0, "", "", "", "");
        ReportController.o(this.app, "dc00898", "", "", "0X8007427", "0X8007427", 0, 0, "", "", "", "");
        RelativeLayout relativeLayout = this.mTitleBar;
        if (relativeLayout != null && this.mNeedHideTitleBar) {
            relativeLayout.setVisibility(8);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        DragView dragView;
        String str;
        super.doOnDestroy();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnDestroy");
        }
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null && this.mMediaPlayer.get().isPlaying()) {
            this.mCurrentPosition = this.mMediaPlayer.get().getCurrentPositionMs();
        }
        releaseMediaPlayer();
        RelativeLayout relativeLayout = this.mVideoLayout;
        if (relativeLayout != null) {
            relativeLayout.removeView((View) this.mVideoView);
        }
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.removeViewCallBack(this);
            this.mVideoView = null;
        }
        try {
            unregisterReceiver(this.mReceiver);
        } catch (IllegalArgumentException unused) {
        }
        this.app.removeHandler(ShortVideoPlayActivity.class);
        if (this.mStartPlayTime >= 0) {
            this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
            if (!this.mPlayTimeCostReported) {
                new DCShortVideo(BaseApplication.getContext()).f(this.app, 2002, (int) (this.mDuration / 1000), this.mCurSessionType, this.mCurSessionUin, this.mPlayTimeCost / 1000);
                this.mPlayTimeCostReported = true;
            }
        }
        if (this.mNeedReportProgressive) {
            new DCShortVideo(BaseApplication.getContext()).g(true, this.mPlayReadyTime, this.mPlayProgress / 100, this.mCacheProgress / 100, (int) this.mDuration, (int) this.mFileSize, 0, this.mSeekTimes, this.mPlayResult, this.mPlayTimeCost);
        }
        if (!this.mIsUploading) {
            doNewReport();
            reportDownloadResult(true);
            updateMsgStatus();
        }
        MessageForShortVideo messageForShortVideo = this.mMsg;
        if (messageForShortVideo != null && messageForShortVideo.uiOperatorFlag == 2 && messageForShortVideo.videoFileProgress != 100) {
            messageForShortVideo.videoFileStatus = 2009;
            messageForShortVideo.serial();
            QQMessageFacade messageFacade = this.app.getMessageFacade();
            MessageForShortVideo messageForShortVideo2 = this.mMsg;
            messageFacade.Y0(messageForShortVideo2.frienduin, this.mUinType, messageForShortVideo2.uniseq, messageForShortVideo2.msgData);
        }
        if (this.mHandler.get() != null) {
            dragView = null;
            this.mHandler.get().removeCallbacksAndMessages(null);
        } else {
            dragView = null;
        }
        DragView dragView2 = this.mDragView;
        if (dragView2 != null) {
            dragView2.removeAllViews();
            this.mDragView = dragView;
        }
        QQAppInterface qQAppInterface = this.app;
        int i3 = this.mCurSessionType;
        MessageForShortVideo messageForShortVideo3 = this.mMsg;
        if (messageForShortVideo3 != null) {
            str = messageForShortVideo3.frienduin;
        } else {
            str = "";
        }
        ShortVideoUtils.reportVideoPlayEvent(qQAppInterface, i3, str, 2, 1, this.mDuration, this.playDurationForReport);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 82 && this.mOperatorBar.getVisibility() == 0) {
            if (this.mUinType != 9501 || this.mPlayCallerType == 5) {
                showActionSheet();
                return true;
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        if (this.mCompleted) {
            changePlayState(0);
        } else {
            this.mInterrupted = true;
            WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
            if (weakReference != null && weakReference.get() != null && this.mMediaPlayer.get().isPlaying()) {
                this.mCurrentPosition = this.mMediaPlayer.get().getCurrentPositionMs();
                this.mNeedPlay = true;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "pause mCurrentPosition:" + this.mCurrentPosition);
                }
            } else if (isBuffering()) {
                this.mNeedPlay = true;
            }
            pause();
        }
        super.doOnPause();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(10)
    public void doOnResume() {
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnResume: mInterrupted = " + this.mInterrupted + ", mNeedPlay = " + this.mNeedPlay + " mSurfaceViewDestroyed=" + this.mSurfaceViewDestroyed);
        }
        setSystemUiVisibility();
        if (this.mInterrupted || this.mCompleted) {
            if (this.mNeedPlay) {
                WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
                if (weakReference != null && weakReference.get() != null && !this.mMediaPlayer.get().isPlaying() && !resume()) {
                    play(this.mCurrentPosition);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onResume, restore last pause, mCurrentPosition=" + this.mCurrentPosition);
            }
            if (!this.mSurfaceViewDestroyed) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResume, restore last pause mSurfaceViewDestroyed=" + this.mSurfaceViewDestroyed);
                    return;
                }
                return;
            }
            int i3 = this.mPlayCallerType;
            if (i3 != 0 && i3 != 5) {
                if (i3 == 1) {
                    this.mCoverIV.setImageDrawable(new ColorDrawable(0));
                }
            } else if (!TextUtils.isEmpty(this.mVideoPath) && FileUtils.fileExistsAndNotEmpty(this.mVideoPath)) {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.mVideoPath);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.mCurrentPosition * 1000);
                    this.mThumbBitmap = frameAtTime;
                    this.mCoverIV.setImageBitmap(frameAtTime);
                    mediaMetadataRetriever.release();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    this.mCoverIV.setImageDrawable(new ColorDrawable(0));
                }
            }
            this.mCoverIV.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        MediaPlayerManager.q(this.app).D(true);
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 2);
        }
        super.doOnStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        if (!this.mCompleted) {
            this.mInterrupted = true;
        }
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        }
        super.doOnStop();
    }

    void forwardFavorite() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "click menu to forward shortVideo......");
        }
        Bundle extras = super.getIntent().getExtras();
        extras.putInt("forward_type", 21);
        extras.putBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        extras.putString(AppConstants.Key.FORWARD_THUMB, com.tencent.mobileqq.shortvideo.j.l(this.mThumbMd5, "jpg"));
        extras.putString("file_send_path", getVideoPath());
        Intent intent = new Intent();
        intent.putExtras(extras);
        ForwardBaseOption.startForwardActivity(this, intent);
        super.finish();
        if (this.isFromMultiMsg) {
            com.tencent.mobileqq.multimsg.i.r("0X8009ABC");
        }
        ReportController.o(this.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
    }

    public Intent getIntentForStartForwardRecentActivity() {
        String videoPath = getVideoPath();
        Bundle extras = super.getIntent().getExtras();
        extras.putInt("forward_type", 21);
        extras.putBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        extras.putString(AppConstants.Key.FORWARD_THUMB, com.tencent.mobileqq.shortvideo.j.l(this.mThumbMd5, "jpg"));
        extras.putString("file_send_path", videoPath);
        Intent intent = new Intent();
        intent.putExtras(extras);
        return intent;
    }

    String getPlayStateStr(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return "null";
                        }
                        return " buffering ";
                    }
                    return " error ";
                }
                return " pause ";
            }
            return " playing ";
        }
        return " idle ";
    }

    String getVideoPath() {
        if (this.mPlayCallerType == 0) {
            return com.tencent.mobileqq.shortvideo.j.j(this.mMsg, "mp4");
        }
        return this.mVideoPath;
    }

    void handleClick() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleClick: mPlayState = " + getPlayStateStr(this.mPlayState) + ", mCurrentPosition = " + this.mCurrentPosition);
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_117905223", true) && !QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        int i3 = this.mPlayState;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        play(0L);
                        return;
                    }
                    return;
                } else {
                    resume();
                    long j3 = this.mCurrentPosition;
                    if (j3 != 0 && this.mSurfaceViewDestroyed) {
                        play(j3);
                        return;
                    }
                    return;
                }
            }
            pause();
            return;
        }
        play(this.mCurrentPosition);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleError(int i3, int i16) {
        String string;
        String str;
        int i17 = 0;
        this.mPlayResult = 0;
        this.mErrCode = 9001;
        String string2 = getString(R.string.hlb);
        int i18 = this.mPlayCallerType;
        if (i18 == 1) {
            dismissLoadingView();
            dismissLoadingImage();
            string = getString(R.string.hl9);
        } else {
            if (i18 == 0) {
                if (!this.mPlayFailReported) {
                    int X = (int) (ah.X() / 1024);
                    if (!StringUtil.isEmpty(this.mVideoPath)) {
                        i17 = (int) (new File(this.mVideoPath).length() / 1024);
                    }
                    String s16 = ah.s();
                    ReportController.o(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + X, "" + i17, s16, this.mMd5);
                    this.mPlayFailReported = true;
                }
            } else if (i18 == 2) {
                adMsgVideoReport(this.ad_gdt, 0, 1002, this.msg_id);
                string = getString(R.string.hl9);
            }
            str = string2;
            showDialogSafe(DialogUtil.createCustomDialog(this, 232, null, str, new c(), null));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleError\uff0cmPlayCallerType = " + this.mPlayCallerType);
            }
            this.mPlayTimeCost = -1L;
            this.mStartPlayTime = -1L;
        }
        str = string;
        showDialogSafe(DialogUtil.createCustomDialog(this, 232, null, str, new c(), null));
        if (QLog.isColorLevel()) {
        }
        this.mPlayTimeCost = -1L;
        this.mStartPlayTime = -1L;
    }

    @Override // com.tencent.mobileqq.activity.aio.r
    public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
        MessageForShortVideo messageForShortVideo = this.mMsg;
        if ((messageForShortVideo == null || messageForShortVideo.uniseq != fileMsg.uniseq) && this.mPlayCallerType != 2) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " handleMessage what==" + i3 + ", arg1:" + i16);
        }
        if (QLog.isColorLevel() && this.mMsg != null) {
            QLog.d(TAG, 2, "handleMessage msg.uniseq:" + this.mMsg.uniseq + ",fileType:" + com.tencent.mobileqq.shortvideo.j.b(fileMsg.fileType) + " ===> fileStatus:" + com.tencent.mobileqq.shortvideo.j.a(fileMsg.status));
        }
        int i17 = fileMsg.fileType;
        if (i17 == 6 || i17 == 17 || i17 == 9 || i17 == 20 || i17 == 67) {
            int i18 = fileMsg.status;
            if (i18 != 1002) {
                if (i18 != 1003) {
                    if (i18 != 2002) {
                        if (i18 != 2003) {
                            if (i18 != 2005) {
                                if (i18 != 5001) {
                                    if (i18 == 5002) {
                                        QQToast.makeText(this.mContext, R.string.hll, 0).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                        this.mErrCode = fileMsg.errorCode;
                                        return;
                                    }
                                    return;
                                }
                                QQToast.makeText(this.mContext, R.string.hlk, 0).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                this.mErrCode = fileMsg.errorCode;
                                return;
                            }
                            QQToast.makeText(this.mContext, R.string.hlm, 0).show(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            this.mErrCode = fileMsg.errorCode;
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "handleMessage STATUS_RECV_FINISHED");
                        }
                        this.mCacheProgress = 10000;
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "STATUS_RECV_PROCESS: get url finished");
                    }
                    this.mPlayReadyTime = (int) (System.currentTimeMillis() - this.mStartPlayTime);
                    String[] strArr = fileMsg.urls;
                    if (strArr != null) {
                        this.mVideoUrls = strArr;
                        String str = fileMsg.domain;
                        this.mDomain = str;
                        this.mStepUrlCost = fileMsg.stepUrlCost;
                        if (!StringUtil.isEmpty(str)) {
                            StringBuilder sb5 = new StringBuilder();
                            String[] strArr2 = this.mVideoUrls;
                            sb5.append(strArr2[0]);
                            sb5.append("&txhost=");
                            sb5.append(this.mDomain);
                            strArr2[0] = sb5.toString();
                        }
                        play(0L);
                        return;
                    }
                    return;
                }
                switchToNormalPlayUI();
                return;
            }
            updateUploadInfo(fileMsg.transferedSize, fileMsg.fileSize);
        }
    }

    void initData(Intent intent) {
        if (intent.getExtras() == null) {
            return;
        }
        this.mVideoPath = intent.getExtras().getString("file_send_path");
        this.mPlayCallerType = intent.getExtras().getInt(ShortVideoConstants.VIDEO_PLAY_CALLER, 0);
        this.mFavId = intent.getExtras().getLong(ShortVideoConstants.FAV_ID, 0L);
        this.mFavGroupId = intent.getExtras().getInt(ShortVideoConstants.FAV_GROUP_ID, 0);
        this.mNeedHideTitleBar = intent.getExtras().getBoolean(ShortVideoConstants.VIDEO_TITLE_BAR_HIDE, false);
        this.ad_gdt = intent.getExtras().getString("ad_gdt");
        this.msg_id = intent.getExtras().getString("msg_id");
        this.mCurSessionType = intent.getExtras().getInt(ShortVideoConstants.FROM_UIN_TYPE);
        this.mCurSessionUin = intent.getExtras().getString(ShortVideoConstants.FROM_SESSION_UIN);
        this.mUinType = intent.getExtras().getInt("uintype");
        this.mVideoInfo = intent.getExtras().getString(ShortVideoConstants.STRUCT_MSG_VIDEO_INFO);
        this.mCurrentUin = intent.getExtras().getString(ShortVideoConstants.FROM_UIN);
        this.mMessageClickStart = intent.getExtras().getLong(ShortVideoConstants.MESSAGE_CLICK_START);
        this.mUuid = intent.getExtras().getString(ShortVideoConstants.FILE_UUID);
        this.mMd5 = intent.getExtras().getString(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
        this.mThumbMd5 = intent.getExtras().getString(ShortVideoConstants.THUMBFILE_MD5);
        this.originRect = (Rect) intent.getExtras().getParcelable("KEY_THUMBNAL_BOUND");
        this.sourceEntrance = intent.getExtras().getInt(RichMediaBrowserConstants.INTERNAL_EXTRA_ENTRANCE);
        this.isFromMultiMsg = intent.getExtras().getBoolean("extra.IS_FROM_MULTI_MSG");
        this.mIsHotVideo = intent.getExtras().getBoolean(ShortVideoConstants.IS_HOTVIDEO);
        this.mHotVideoIconUrl = intent.getExtras().getString(ShortVideoConstants.HOT_VIDEO_ICON);
        this.mHotVideoCertificatedIconUrl = intent.getExtras().getString(ShortVideoConstants.HOT_VIDEO_ICON_SUB);
        this.mHotVideoJumpUrl = intent.getExtras().getString(ShortVideoConstants.HOT_VIDEO_URL);
        this.mHotVideoTitle = intent.getExtras().getString(ShortVideoConstants.HOT_VIDEO_TITLE);
        if (this.mFavId != -1) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_shoucang");
        }
        int i3 = this.mPlayCallerType;
        if (i3 == 0 || i3 == 5) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) intent.getExtras().getParcelable(ShortVideoConstants.KEY_MESSAGE_FOR_SHORTVIDEO);
            this.mMsg = messageForShortVideo;
            if (messageForShortVideo == null) {
                QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.tgr), 0).show(getTitleBarHeight());
                finish();
                return;
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initData(), PLAY_CALLER_SHORT_VIDEO, msg = " + this.mMsg.toLogString() + ", mUinType = " + this.mUinType);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initData(): mVideoPath=" + this.mVideoPath + ", mPlayCallerType=" + this.mPlayCallerType + ", mCursessionType = " + this.mCurSessionType + ", mCurSessionUin = " + this.mCurSessionUin + ", mUinType = " + this.mUinType);
        }
    }

    void initDuration() {
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null) {
            long durationMs = this.mMediaPlayer.get().getDurationMs();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initDuration: duration=" + durationMs);
            }
            if (durationMs != 0) {
                long j3 = (int) durationMs;
                this.mDuration = j3;
                this.mDurationStr = ShortVideoUtils.stringForTime(j3);
                TextView textView = this.mTotalTime;
                if (textView != null && !textView.getText().equals(this.mDurationStr)) {
                    runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.15
                        @Override // java.lang.Runnable
                        public void run() {
                            ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
                            shortVideoPlayActivity.mTotalTime.setText(shortVideoPlayActivity.mDurationStr);
                        }
                    });
                }
            }
        }
    }

    public void initSDK() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new SDKInitListener() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.10
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    if (!z16) {
                        QLog.e(ShortVideoPlayActivity.TAG, 1, "initSDKAsync failed!");
                        return;
                    }
                    QLog.d(ShortVideoPlayActivity.TAG, 1, "initSDKAsync succeed!");
                    if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_117905223", true)) {
                        ShortVideoPlayActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShortVideoPlayActivity.this.onCreateVideoSdkView();
                            }
                        });
                    }
                }
            });
            QLog.d(TAG, 1, "superplayer not ready !");
        } else {
            onCreateVideoSdkView();
        }
    }

    void innerChangePlayerState(int i3) {
        if ((i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) || i3 == this.mPlayState) {
            return;
        }
        if (isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "changePlayState, while finishing");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "changePlayState, " + getPlayStateStr(this.mPlayState) + " ==> " + getPlayStateStr(i3));
        }
        int i16 = this.mPlayState;
        if (i16 == 1 && i3 != 1) {
            if (this.mPlayStart != 0) {
                this.mPlayCost += System.currentTimeMillis() - this.mPlayStart;
            }
        } else if (i16 == 4 && i3 != 4 && this.mBufferStart != 0) {
            this.mBufferCost += System.currentTimeMillis() - this.mBufferStart;
        }
        this.mPlayState = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.mBufferStart = System.currentTimeMillis();
                            this.mBufferTimes++;
                            if (this.mNeedDownload) {
                                this.mBufferLayout.setVisibility(0);
                            }
                            if (this.mHandler.get() != null) {
                                this.mHandler.get().removeCallbacks(this.mProgressChecker);
                                this.mHandler.get().postDelayed(this.mProgressChecker, 50L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.mOperatorBtn.setImageResource(R.drawable.agf);
                    this.mOperatorBtn.setContentDescription(HardCodeUtil.qqStr(R.string.th9));
                    if (this.mHandler.get() != null) {
                        this.mHandler.get().removeCallbacks(this.mProgressChecker);
                        return;
                    }
                    return;
                }
                this.mPauseTimes++;
                this.mOperatorBtn.setImageResource(R.drawable.agf);
                this.mOperatorBtn.setContentDescription(HardCodeUtil.qqStr(R.string.thh));
                return;
            }
            this.mPlayStart = System.currentTimeMillis();
            this.mRealPlayTimes++;
            this.mOperatorBtn.setImageResource(R.drawable.agh);
            this.mOperatorBtn.setContentDescription(HardCodeUtil.qqStr(R.string.thf));
            this.mCoverIV.setVisibility(8);
            if (this.mHandler.get() != null) {
                this.mHandler.get().removeCallbacks(this.mProgressChecker);
                this.mHandler.get().postDelayed(this.mProgressChecker, 50L);
            }
            delayStartHiding();
            dismissLoadingView();
            dismissLoadingImage();
            RelativeLayout relativeLayout = this.mBufferLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mHandler.get() != null) {
            this.mHandler.get().removeCallbacks(this.mProgressChecker);
        }
        this.mOperatorBtn.setImageResource(R.drawable.agf);
        this.mOperatorBtn.setContentDescription(HardCodeUtil.qqStr(R.string.thz));
    }

    void innerOnCompletion(ISuperPlayer iSuperPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.mPlayProgress + ", mCacheProgress=" + this.mCacheProgress + ", mCurPlayPosition" + this.mCurPlayPosition + ", mDuration=" + this.mDuration);
        }
        this.mPlayProgress = 10000;
        if (!this.hasUserSeeked) {
            this.playDurationForReport = this.mDuration;
        }
        this.mSeekBar.setProgress(10000);
        if (this.mPlayCallerType == 2 && this.mPlayState == 1) {
            adMsgVideoReport(this.ad_gdt, 2, 1002, this.msg_id);
        }
        changePlayState(0);
        this.mProgressTime.setText(this.mTotalTime.getText());
        startShowing();
        this.mCurrentPosition = 0L;
        this.mCompleted = true;
        if (iSuperPlayer != null) {
            iSuperPlayer.reset();
        }
        if (this.mStartPlayTime >= 0) {
            this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
            if (!this.mPlayTimeCostReported) {
                new DCShortVideo(BaseApplication.getContext()).f(this.app, 2002, (int) (this.mDuration / 1000), this.mCurSessionType, this.mCurSessionUin, this.mPlayTimeCost / 1000);
                this.mPlayTimeCostReported = true;
            }
        }
        doNewReport();
    }

    public void innerOnError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        this.mSdkErrorCode = i3;
        this.mSdkDetailErrorCode = i16;
        doNewReport();
        reportDownloadResult(false);
        this.mStatus = 2005;
        changePlayState(3);
        reset();
        handleError(i3, i16);
    }

    boolean isBuffering() {
        if (this.mPlayState == 4) {
            return true;
        }
        return false;
    }

    boolean isPlaying() {
        WeakReference<ISuperPlayer> weakReference;
        if (this.mPlayState == 1 && (weakReference = this.mMediaPlayer) != null && weakReference.get() != null && this.mMediaPlayer.get().isPlaying()) {
            return true;
        }
        return false;
    }

    boolean isVideoExist(String str) {
        boolean fileExists = FileUtils.fileExists(str);
        if (this.mNeedDownload) {
            return false;
        }
        return fileExists;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        userBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.ffe) {
            if (id5 == R.id.gsr) {
                userBackPressed();
            } else if (id5 == R.id.f164822az1) {
                QQAppInterface qQAppInterface = this.app;
                MessageForShortVideo messageForShortVideo = this.mMsg;
                com.tencent.mobileqq.video.a.b(qQAppInterface, messageForShortVideo.frienduin, messageForShortVideo.uniseq);
                userBackPressed();
            } else if (id5 == R.id.fff) {
                showAnimation();
                handleClick();
            } else if (id5 == R.id.epq) {
                showAnimation();
                if (this.mPlayState == 1) {
                    pause();
                }
                cooperation.qqfav.widget.a aVar = this.mFavActionSheet;
                if (aVar != null) {
                    aVar.onClick(view);
                }
            } else if (id5 == R.id.a47) {
                userBackPressed();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onClickDragView() {
        userBackPressed();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(final ISuperPlayer iSuperPlayer) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.22
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPlayActivity.this.innerOnCompletion(iSuperPlayer);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mIsHotVideo) {
            if (configuration.orientation == 2) {
                ((RelativeLayout) findViewById(R.id.d9d)).setVisibility(8);
            } else {
                ((RelativeLayout) findViewById(R.id.d9d)).setVisibility(0);
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onContentMove(float f16) {
        RelativeLayout relativeLayout = this.mVideoLayout;
        if (relativeLayout != null) {
            Drawable background = relativeLayout.getBackground();
            if (background != null) {
                background.mutate().setAlpha((int) (255.0f * f16));
            }
            if (f16 < 0.8f) {
                this.mVideoController.setVisibility(4);
                this.mTitleBar.setVisibility(4);
            }
        }
    }

    void onCreateController() {
        MessageForShortVideo messageForShortVideo;
        int i3;
        int i16;
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.b2u, (ViewGroup) null, false);
        this.mVideoController = relativeLayout;
        this.mRoot = (RelativeLayout) relativeLayout.findViewById(R.id.root);
        this.mNormalOperateLayout = (LinearLayout) this.mVideoController.findViewById(R.id.fac);
        setSystemUiVisibility();
        View findViewById = this.mVideoController.findViewById(R.id.ffe);
        this.mOperatorBar = findViewById;
        findViewById.setOnClickListener(this);
        this.mCoverIV = (URLImageView) this.mVideoController.findViewById(R.id.bau);
        this.mLoadingText = (TextView) this.mVideoController.findViewById(R.id.ef5);
        ImageView imageView = (ImageView) this.mVideoController.findViewById(R.id.epq);
        this.mMenuBtn = imageView;
        imageView.setOnClickListener(this);
        this.mMenuBtn.setOnLongClickListener(this);
        this.mProgressTime = (TextView) this.mVideoController.findViewById(R.id.g1m);
        this.mTotalTime = (TextView) this.mVideoController.findViewById(R.id.jut);
        SeekBar seekBar = (SeekBar) this.mVideoController.findViewById(R.id.ilh);
        this.mSeekBar = seekBar;
        seekBar.setMax(10000);
        ImageView imageView2 = (ImageView) this.mVideoController.findViewById(R.id.fff);
        this.mOperatorBtn = imageView2;
        imageView2.setOnClickListener(this);
        this.mSeekBar.setOnSeekBarChangeListener(this.mOnSeekBarChangeListener);
        this.mBufferLayout = (RelativeLayout) this.mVideoController.findViewById(R.id.alq);
        this.mRateText = (TextView) this.mVideoController.findViewById(R.id.hvh);
        int i17 = this.mPlayCallerType;
        if ((i17 == 0 || i17 == 5) && (messageForShortVideo = this.mMsg) != null && ((i3 = messageForShortVideo.videoFileStatus) == 1001 || i3 == 1002)) {
            ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
            MessageForShortVideo messageForShortVideo2 = this.mMsg;
            if (iTransFileController.findProcessor(messageForShortVideo2.frienduin, messageForShortVideo2.uniseq) != null) {
                this.mIsUploading = true;
                RelativeLayout relativeLayout2 = (RelativeLayout) this.mVideoController.findViewById(R.id.kjb);
                this.mUploadOperateLayout = relativeLayout2;
                relativeLayout2.setVisibility(0);
                this.mNormalOperateLayout.setVisibility(4);
                SeekBar seekBar2 = (SeekBar) this.mVideoController.findViewById(R.id.kjd);
                this.mUploadingSeekBar = seekBar2;
                seekBar2.setMax(100);
                ImageView imageView3 = (ImageView) this.mVideoController.findViewById(R.id.f164822az1);
                this.mCloseBtn = imageView3;
                imageView3.setOnClickListener(this);
                this.mUploadProgress = (TextView) this.mVideoController.findViewById(R.id.kjc);
            }
        }
        this.mDragView = new DragView(this);
        this.mDragView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mDragView.setGestureChangeListener(this);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            i16 = LiuHaiUtils.sNotchHeight;
        } else {
            i16 = 0;
        }
        Rect rect = this.originRect;
        if (rect != null) {
            rect.top -= i16;
            rect.bottom -= i16;
        }
        this.mDragView.setOriginRect(rect);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.gsr);
        this.mVideoLayout = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        this.mVideoLayout.setOnLongClickListener(this);
        this.mVideoController.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mVideoLayout.addView(this.mVideoController);
        RelativeLayout relativeLayout4 = (RelativeLayout) this.mVideoLayout.findViewById(R.id.e5u);
        this.mTitleBar = relativeLayout4;
        relativeLayout4.setVisibility(0);
        this.mTitleBar.bringToFront();
        RelativeLayout relativeLayout5 = (RelativeLayout) this.mVideoLayout.findViewById(R.id.e5t);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout5.getLayoutParams();
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getApplicationContext());
        relativeLayout5.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.mVideoLayout.findViewById(R.id.a47);
        this.mReturnBtn = textView;
        textView.setOnClickListener(this);
        setProgressTime(0L);
        this.mTotalTime.setText(ShortVideoUtils.stringForTime(0L));
        showLoadingView();
        showLoadingImage();
        createActionSheet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void onCreateVideoSdkView() {
        try {
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(getApplicationContext());
            this.mVideoView = createPlayerVideoView;
            ((View) createPlayerVideoView).setBackgroundColor(-16777216);
            ((View) this.mVideoView).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ((View) this.mVideoView).setVisibility(0);
            this.mVideoView.addViewCallBack(this);
            if (this.originRect != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                ((View) this.mVideoView).setLayoutParams(layoutParams);
                this.mDragView.addView((View) this.mVideoView);
                this.mVideoLayout.addView(this.mDragView, 0);
            } else {
                this.mVideoLayout.addView((View) this.mVideoView, 0);
            }
            initVideoData();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(final ISuperPlayer iSuperPlayer, final int i3, final int i16, final int i17, final String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onError what=" + i3 + ",extra=" + i16 + ",mCacheProgress=" + this.mCacheProgress + ", mPlayProgress=" + this.mPlayProgress + ", mCurPlayPosition=" + this.mCurPlayPosition);
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.23
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPlayActivity.this.innerOnError(iSuperPlayer, i3, i16, i17, str);
            }
        });
        return false;
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onGestureFinish() {
        ReportController.o(null, "dc00898", "", "", "0X8009AB3", "0X8009AB3", this.sourceEntrance, 0, "", "", "", "");
        releaseMediaPlayer();
        finish();
        try {
            overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[MediaPlayer] overridePendingTransition=" + e16);
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onInfo what=" + i3 + ",extra=" + obj + ",mCacheProgress=" + this.mCacheProgress + ", mPlayProgress=" + this.mPlayProgress + ", mCurPlayPosition=" + this.mCurPlayPosition);
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.gsr && id5 != R.id.epq) {
            z16 = false;
        } else {
            showAnimation();
            if (this.mPlayState == 1) {
                pause();
            }
            cooperation.qqfav.widget.a aVar = this.mFavActionSheet;
            if (aVar != null) {
                aVar.onClick(view);
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onResetPosition() {
        this.mVideoController.setVisibility(0);
        this.mTitleBar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!this.mCompleted) {
            this.mInterrupted = true;
        }
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null && this.mMediaPlayer.get().isPlaying()) {
            this.mCurrentPosition = this.mMediaPlayer.get().getCurrentPositionMs();
            this.mNeedPlay = true;
        }
        bundle.putLong(STATE_PLAY_POSITION, this.mCurrentPosition);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSaveInstanceState: mCurrentPosition: " + this.mCurrentPosition);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.mCacheProgress + ", mPlayProgress=" + this.mPlayProgress + ", mCurPlayPosition=" + this.mCurPlayPosition);
        }
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null) {
            this.mMediaPlayer.get().start();
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceDestroy(Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onSurfaceDestory");
        }
        this.mSurfaceViewDestroyed = true;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
    public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onTVideoNetInfoUpdate ,mCacheProgress=" + this.mCacheProgress + ", mPlayProgress=" + this.mPlayProgress + ", mCurPlayPosition=" + this.mCurPlayPosition);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.mDuration + " mInterrupted" + this.mInterrupted + " mNeedPlay" + this.mNeedPlay);
        }
        this.mSurfaceViewDestroyed = false;
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.24
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPlayActivity.this.dismissLoadingView();
            }
        });
        if (this.mPlayCallerType == 2) {
            adMsgVideoReport(this.ad_gdt, 1, 1002, this.msg_id);
        }
        if (this.mMessageClickStart != 0) {
            this.mMessageClickCost = System.currentTimeMillis() - this.mMessageClickStart;
            this.mMessageClickStart = 0L;
        }
        if (this.mOpenPlayerStart != 0) {
            this.mOpenPlayerCost = System.currentTimeMillis() - this.mOpenPlayerStart;
            this.mOpenPlayerStart = 0L;
        }
        if (this.mInterrupted) {
            this.mInterrupted = false;
            if (!this.mNeedPlay) {
                return;
            }
        }
        this.mNeedPlay = false;
        if (this.mDuration <= 0) {
            initDuration();
        }
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null) {
            this.mMediaPlayer.get().start();
            if (this.mSec > 0) {
                this.mMediaPlayer.get().seekTo((int) this.mSec);
            }
            changePlayState(1);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            setSystemUiVisibility();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onWindowFocusChanged: hasFocus: " + z16);
        }
    }

    void pause() {
        WeakReference<ISuperPlayer> weakReference;
        if (isPlaying() && (weakReference = this.mMediaPlayer) != null && weakReference.get() != null) {
            this.mCurrentPosition = this.mMediaPlayer.get().getCurrentPositionMs();
            this.mMediaPlayer.get().pause();
        }
        changePlayState(2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "#pause# , mCurrentPosition = " + this.mCurrentPosition);
        }
        if (this.mStartPlayTime >= 0) {
            this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089 A[Catch: Exception -> 0x027b, TryCatch #0 {Exception -> 0x027b, blocks: (B:3:0x000c, B:5:0x0013, B:6:0x0025, B:8:0x002d, B:12:0x0085, B:14:0x0089, B:19:0x0099, B:21:0x00a1, B:23:0x00ab, B:25:0x00af, B:26:0x00bc, B:28:0x00c1, B:30:0x00c5, B:35:0x00da, B:37:0x00de, B:38:0x00e0, B:40:0x00e6, B:41:0x011f, B:42:0x01b1, B:44:0x01b7, B:46:0x01bb, B:48:0x01bf, B:51:0x01ea, B:53:0x0213, B:54:0x023c, B:55:0x0262, B:57:0x0268, B:58:0x0274, B:61:0x013d, B:63:0x0143, B:66:0x00cc, B:68:0x00d0, B:69:0x015b, B:71:0x0163, B:73:0x0169, B:74:0x0180, B:75:0x0198, B:77:0x019e, B:80:0x01a5, B:81:0x0036), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bf A[Catch: Exception -> 0x027b, TryCatch #0 {Exception -> 0x027b, blocks: (B:3:0x000c, B:5:0x0013, B:6:0x0025, B:8:0x002d, B:12:0x0085, B:14:0x0089, B:19:0x0099, B:21:0x00a1, B:23:0x00ab, B:25:0x00af, B:26:0x00bc, B:28:0x00c1, B:30:0x00c5, B:35:0x00da, B:37:0x00de, B:38:0x00e0, B:40:0x00e6, B:41:0x011f, B:42:0x01b1, B:44:0x01b7, B:46:0x01bb, B:48:0x01bf, B:51:0x01ea, B:53:0x0213, B:54:0x023c, B:55:0x0262, B:57:0x0268, B:58:0x0274, B:61:0x013d, B:63:0x0143, B:66:0x00cc, B:68:0x00d0, B:69:0x015b, B:71:0x0163, B:73:0x0169, B:74:0x0180, B:75:0x0198, B:77:0x019e, B:80:0x01a5, B:81:0x0036), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0268 A[Catch: Exception -> 0x027b, TryCatch #0 {Exception -> 0x027b, blocks: (B:3:0x000c, B:5:0x0013, B:6:0x0025, B:8:0x002d, B:12:0x0085, B:14:0x0089, B:19:0x0099, B:21:0x00a1, B:23:0x00ab, B:25:0x00af, B:26:0x00bc, B:28:0x00c1, B:30:0x00c5, B:35:0x00da, B:37:0x00de, B:38:0x00e0, B:40:0x00e6, B:41:0x011f, B:42:0x01b1, B:44:0x01b7, B:46:0x01bb, B:48:0x01bf, B:51:0x01ea, B:53:0x0213, B:54:0x023c, B:55:0x0262, B:57:0x0268, B:58:0x0274, B:61:0x013d, B:63:0x0143, B:66:0x00cc, B:68:0x00d0, B:69:0x015b, B:71:0x0163, B:73:0x0169, B:74:0x0180, B:75:0x0198, B:77:0x019e, B:80:0x01a5, B:81:0x0036), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a5 A[Catch: Exception -> 0x027b, TryCatch #0 {Exception -> 0x027b, blocks: (B:3:0x000c, B:5:0x0013, B:6:0x0025, B:8:0x002d, B:12:0x0085, B:14:0x0089, B:19:0x0099, B:21:0x00a1, B:23:0x00ab, B:25:0x00af, B:26:0x00bc, B:28:0x00c1, B:30:0x00c5, B:35:0x00da, B:37:0x00de, B:38:0x00e0, B:40:0x00e6, B:41:0x011f, B:42:0x01b1, B:44:0x01b7, B:46:0x01bb, B:48:0x01bf, B:51:0x01ea, B:53:0x0213, B:54:0x023c, B:55:0x0262, B:57:0x0268, B:58:0x0274, B:61:0x013d, B:63:0x0143, B:66:0x00cc, B:68:0x00d0, B:69:0x015b, B:71:0x0163, B:73:0x0169, B:74:0x0180, B:75:0x0198, B:77:0x019e, B:80:0x01a5, B:81:0x0036), top: B:2:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void play(long j3) {
        boolean z16;
        int i3;
        MessageForShortVideo messageForShortVideo;
        String j16;
        MessageForShortVideo messageForShortVideo2;
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "#play#, msec=" + j3);
            }
            this.mSec = j3;
            this.mNeedReportAioVideo = true;
            WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
            if (weakReference != null && weakReference.get() != null) {
                z16 = false;
                if (this.mCompleted) {
                    this.mReplayTimes++;
                    z16 = true;
                }
                if (!z16) {
                    if (j3 == 0 && this.mSeekBar.getProgress() > 0 && this.mSeekBar.getProgress() < 10000 && (messageForShortVideo2 = this.mMsg) != null) {
                        long progress = ((messageForShortVideo2.videoFileTime * 1000) * this.mSeekBar.getProgress()) / 100;
                    }
                    if (this.mVideoUrls != null && this.mNeedDownload) {
                        int i16 = this.mPlayCallerType;
                        if ((i16 == 0 || i16 == 5) && (messageForShortVideo = this.mMsg) != null) {
                            j16 = com.tencent.mobileqq.shortvideo.j.j(messageForShortVideo, "mp4");
                        } else if (i16 == 2 && this.mVideoInfo != null) {
                            j16 = this.publicAccountLocalPath;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "#play#, mVideo caller type not right:" + this.mPlayCallerType);
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "#play#, setVid =" + this.mMd5 + " videoPath=" + j16);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("#play#, url0 =");
                            sb5.append(this.mVideoUrls[0]);
                            QLog.d(TAG, 2, sb5.toString());
                        }
                        this.mHttpStart = System.currentTimeMillis();
                        this.mMediaPlayer.get().openMediaPlayer(this.mContext.getApplicationContext(), SuperPlayerFactory.createVideoInfoForUrl(this.mVideoUrls, 100, (String) null), 0L);
                    } else if (!TextUtils.isEmpty(this.mVideoPath)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "#play#, videoPath=" + this.mVideoPath);
                        }
                        this.mMediaPlayer.get().openMediaPlayer(this.mContext.getApplicationContext(), SuperPlayerFactory.createVideoInfoForUrl(this.mVideoPath, 100, (String) null), 0L);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "#play#, mVideoPath should not be null!");
                            return;
                        }
                        return;
                    }
                } else {
                    this.mMediaPlayer.get().seekTo((int) j3);
                }
                this.mCompleted = false;
                if (this.mPlayCallerType == 0 && !this.mPlaySucReported) {
                    i3 = this.mUinType;
                    if (i3 != 0) {
                        ReportController.o(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
                        this.mPlaySucReported = true;
                    } else if (i3 == 3000) {
                        ReportController.o(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
                        this.mPlaySucReported = true;
                    } else if (i3 == 1) {
                        ReportController.o(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
                        this.mPlaySucReported = true;
                    } else {
                        ReportController.o(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
                        this.mPlaySucReported = true;
                    }
                }
                if (this.mStartPlayTime >= 0) {
                    this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
                }
                this.mStartPlayTime = System.currentTimeMillis();
            }
            WeakReference<ISuperPlayer> weakReference2 = new WeakReference<>(SuperPlayerFactory.createMediaPlayer(getApplicationContext(), 101, this.mVideoView));
            this.mMediaPlayer = weakReference2;
            weakReference2.get().setOnCompletionListener(this);
            this.mMediaPlayer.get().setOnErrorListener(this);
            this.mMediaPlayer.get().setOnVideoPreparedListener(this);
            this.mMediaPlayer.get().setOnSeekCompleteListener(this);
            this.mMediaPlayer.get().setOnInfoListener(this);
            this.mOpenPlayerStart = System.currentTimeMillis();
            z16 = true;
            if (this.mCompleted) {
            }
            if (!z16) {
            }
            this.mCompleted = false;
            if (this.mPlayCallerType == 0) {
                i3 = this.mUinType;
                if (i3 != 0) {
                }
            }
            if (this.mStartPlayTime >= 0) {
            }
            this.mStartPlayTime = System.currentTimeMillis();
        } catch (Exception e16) {
            QLog.d(TAG, 1, "#play#, msec=" + j3, e16);
            reset();
            handleError(0, 0);
        }
    }

    void releaseMediaPlayer() {
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null) {
            this.mMediaPlayer.get().stop();
            this.mMediaPlayer.get().release();
            removeAllListener();
            this.mMediaPlayer = null;
        }
        changePlayState(0);
    }

    protected void reportDownloadVideo(MessageForShortVideo messageForShortVideo) {
        String netTypeStr = ShortVideoUtils.getNetTypeStr(NetworkUtil.getSystemNetwork(this.mContext));
        int i3 = messageForShortVideo.istroop;
        if (i3 != 0 && i3 != 1008) {
            if (i3 == 3000) {
                ReportController.o(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", netTypeStr, "");
                return;
            } else if (i3 == 1) {
                ReportController.o(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", netTypeStr, "");
                return;
            } else {
                ReportController.o(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", netTypeStr, "");
                return;
            }
        }
        ReportController.o(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", netTypeStr, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    void reset() {
        changePlayState(0);
    }

    boolean resume() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "#resume#");
        }
        WeakReference<ISuperPlayer> weakReference = this.mMediaPlayer;
        if (weakReference != null && weakReference.get() != null && this.mPlayState == 2) {
            this.mMediaPlayer.get().start();
            z16 = true;
            changePlayState(1);
        } else {
            z16 = false;
        }
        if (this.mStartPlayTime >= 0) {
            this.mPlayTimeCost += System.currentTimeMillis() - this.mStartPlayTime;
        }
        this.mStartPlayTime = System.currentTimeMillis();
        return z16;
    }

    void setProgressTime(long j3) {
        TextView textView = this.mProgressTime;
        if (textView != null) {
            if (j3 < 0) {
                j3 = 0;
            }
            textView.setText(ShortVideoUtils.stringForTime(j3));
        }
    }

    protected void shareToPC() {
        String str = AppConstants.DATALINE_PC_UIN;
        Intent intentForStartForwardRecentActivity = getIntentForStartForwardRecentActivity();
        intentForStartForwardRecentActivity.putExtra("toUin", str);
        intentForStartForwardRecentActivity.putExtra("uinType", 6000);
        intentForStartForwardRecentActivity.setClass(this.mContext, DirectForwardActivity.class);
        intentForStartForwardRecentActivity.putExtra(AppConstants.Key.FORWARD_FILEPATH, getVideoPath());
        intentForStartForwardRecentActivity.putExtra(AppConstants.Key.FORWARD_EXTRA, getVideoPath());
        intentForStartForwardRecentActivity.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        this.mContext.startActivity(intentForStartForwardRecentActivity);
        com.tencent.mobileqq.filemanager.fileassistant.util.g.d(2);
    }

    protected void showActionSheet() {
        String str;
        boolean z16;
        String string = getResources().getString(R.string.hlv);
        String string2 = getResources().getString(R.string.hlw);
        String string3 = getResources().getString(R.string.hkq);
        String string4 = getResources().getString(R.string.hl_);
        String string5 = getResources().getString(R.string.cancel);
        if (this.mPlayCallerType == 0) {
            str = com.tencent.mobileqq.shortvideo.j.j(this.mMsg, "mp4");
        } else {
            str = this.mVideoPath;
        }
        String str2 = str;
        boolean fileExists = FileUtils.fileExists(str2);
        boolean z17 = false;
        if (this.mNeedDownload) {
            z16 = false;
        } else {
            z16 = fileExists;
        }
        boolean equals = "1".equals(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.shortvideo_forward_switch.name(), "1"));
        if (getIntent().getIntExtra(ShortVideoConstants.FROM_BUSI_TYPE, 0) == 2) {
            z17 = true;
        }
        ActionSheet create = ActionSheet.create(this);
        if (equals && this.mUinType != 9501 && !z17) {
            create.addButton(string);
        }
        MessageForShortVideo messageForShortVideo = this.mMsg;
        if (messageForShortVideo != null && messageForShortVideo.videoFileStatus != 5001) {
            create.addButton(string2);
        }
        if (this.mPlayCallerType != 3) {
            if (z16) {
                create.addButton(string3);
                create.addButton(string4);
            } else {
                create.addButton(string3, 7);
                create.addButton(string4, 7);
            }
        }
        create.addCancelButton(string5);
        create.show();
        create.setOnButtonClickListener(new e(create, string, str2, string2, z16, string3, str2, string4));
    }

    public void showAnimation() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onClick surfaceView, mHidden=" + this.mHidden);
        }
        if (this.mHidden) {
            startShowing();
            delayStartHiding();
        }
    }

    public void showErrorDlg(final String str) {
        if (this.mHandler.get() != null) {
            this.mHandler.get().post(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.11

                /* renamed from: com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity$11$a */
                /* loaded from: classes10.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        ShortVideoPlayActivity.this.userBackPressed();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ShortVideoPlayActivity.this.showDialogSafe(DialogUtil.createCustomDialog(ShortVideoPlayActivity.this, 232, null, str, new a(), null));
                }
            });
        }
    }

    void showLoadingImage() {
        MessageForShortVideo messageForShortVideo = this.mMsg;
        if (messageForShortVideo != null) {
            String l3 = com.tencent.mobileqq.shortvideo.j.l(messageForShortVideo.thumbMD5, "jpg");
            if (FileUtils.fileExistsAndNotEmpty(l3)) {
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = new ColorDrawable(-16777216);
                    this.mCoverIV.setImageDrawable(URLDrawable.getDrawable(new File(l3), obtain));
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "showLoadingImage crashed =" + e16.toString());
                    }
                }
                this.mCoverIV.setVisibility(0);
            }
        }
    }

    void showLoadingView() {
        if (this.mLoadingText.getVisibility() != 0) {
            this.mLoadingText.setVisibility(0);
        }
    }

    void showNetAlertDlg() {
        showDialogSafe(DialogUtil.createCustomDialog(this, 232, null, getString(R.string.hlc), new h(), new i()));
    }

    void startHiding() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startHiding : mHidden = " + this.mHidden + ",playState:" + getPlayStateStr(this.mPlayState));
        }
        if (this.mHidden || this.mPlayState != 1) {
            return;
        }
        this.mHidden = true;
        if (this.mOperatorBar.getVisibility() == 0 || this.mTitleBar.getVisibility() == 0) {
            this.mValueAnimator.cancel();
            this.mValueAnimator.start();
        }
    }

    void startShowing() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startShowing : mHidden = " + this.mHidden);
        }
        if (!this.mHidden) {
            return;
        }
        if (this.mHandler.get() != null) {
            this.mHandler.get().removeCallbacks(this.mStartHidingRunnable);
        }
        this.mOperatorBar.clearAnimation();
        this.mOperatorBar.setAlpha(1.0f);
        this.mTitleBar.clearAnimation();
        this.mTitleBar.setAlpha(1.0f);
        this.mHidden = false;
    }

    void userBackPressed() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "userBackPressed");
        }
        releaseMediaPlayer();
        setResult(-1, getIntent());
        finish();
        try {
            overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[MediaPlayer] overridePendingTransition=" + e16);
            }
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceChanged(Object obj) {
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceCreated(Object obj) {
    }

    /* loaded from: classes10.dex */
    class g extends MqqHandler {

        /* loaded from: classes10.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (ShortVideoPlayActivity.this.mHandler.get() != null) {
                    MqqHandler fileThreadHandler = ThreadManager.getFileThreadHandler();
                    ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
                    fileThreadHandler.post(new ShortVideoUtils.VideoFileSaveRunnable(shortVideoPlayActivity.mVideoPath, shortVideoPlayActivity.mHandler.get(), ShortVideoPlayActivity.this.mMd5 + ".mp4", true));
                }
            }
        }

        g() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(ShortVideoPlayActivity.TAG, 2, "...mobile/none => wifi...");
                                }
                                WeakReference<ISuperPlayer> weakReference = ShortVideoPlayActivity.this.mMediaPlayer;
                                if (weakReference != null) {
                                    weakReference.get();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(ShortVideoPlayActivity.TAG, 2, "...wifi/none => mobile...");
                        }
                        WeakReference<ISuperPlayer> weakReference2 = ShortVideoPlayActivity.this.mMediaPlayer;
                        if (weakReference2 != null) {
                            weakReference2.get();
                        }
                        ShortVideoPlayActivity shortVideoPlayActivity = ShortVideoPlayActivity.this;
                        int i16 = shortVideoPlayActivity.mPlayCallerType;
                        if (i16 != 1 && i16 != 2) {
                            if (i16 == 0 || i16 == 5) {
                                shortVideoPlayActivity.remindIfContinueDownload();
                                return;
                            }
                            return;
                        }
                        if (shortVideoPlayActivity.isPlaying()) {
                            ShortVideoPlayActivity.this.pause();
                            ShortVideoPlayActivity.this.showNetAlertDlg();
                            return;
                        }
                        return;
                    }
                    Context context = ShortVideoPlayActivity.this.mContext;
                    ShortVideoPlayActivity.this.showDialogSafe(DialogUtil.createCustomDialog(context, 232, context.getResources().getString(R.string.hlo), ShortVideoPlayActivity.this.mContext.getResources().getString(R.string.hln), R.string.hl7, R.string.h1a, new a(), new b()));
                    return;
                }
                String string = ShortVideoPlayActivity.this.getString(R.string.hkt);
                String str = (String) message.obj;
                QQToast.makeText(ShortVideoPlayActivity.this.mContext, 2, string + str, 0).show();
                BaseImageUtil.savePhotoToSysAlbum(ShortVideoPlayActivity.this, str);
                return;
            }
            QQToast.makeText(ShortVideoPlayActivity.this, R.string.hks, 0).show();
        }

        /* loaded from: classes10.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
