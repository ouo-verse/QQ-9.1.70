package com.tenpay.sdk.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.data.PayPucAccManager;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.proxy.DataProxy;
import com.tenpay.proxy.DownloadProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.helper.HBShiMingHelper;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.view.QQVideoView;
import com.tenpay.sdk.view.ThreeCircleLoadingView;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GrapMchHbActivity extends NetBaseActivity implements View.OnClickListener {
    private static int HB_ICON_SIZE = 240;
    public static final int HONG_BAO_TYPE = 2;
    private static long lastClickTime;
    private LinearLayout hbInfoLayout;
    private ImageView imSpringBack;
    private boolean isFromHBList;
    private boolean isLoadFirstThumbBackground;
    private boolean isLoadedVideoThumbnail;
    private boolean isPlayingWhenPause;
    private RelativeLayout layoutHbdetail;
    private RelativeLayout layoutNormalHead;
    private RelativeLayout layoutVideo;
    private RelativeLayout layoutVideoHead;
    protected String mAmount;
    protected TextView mBackBtn;
    private String mBusName;
    private int mChannel;
    private CheckBox mCheckFollow;
    protected TextView mErrorText1;
    protected TextView mErrorTips1;
    private String mExtraInfo;
    private ImageView mFullScrPlay;
    private boolean mGraped;
    private String mGroupid;
    private String mGrouptype;
    private String mGroupuin;
    protected TextView mHBAddedToYue;
    protected TextView mHBCount;
    protected TextView mHBCountYuan;
    protected JSONObject mHBdata;
    private boolean mHasStopped;
    protected ImageView mImgRadian;
    private boolean mIsBackKeyPressed;
    private RelativeLayout mLayoutOne;
    private LinearLayout mLayoutQqPubFollow;
    private RelativeLayout mLayoutVideoOthers;
    protected ImageView mMchBgImg;
    private MediaPlayer mMediaPlayer;
    private ImageView mPlay;
    private ThreeCircleLoadingView mProgressBar;
    private String mPubAccUin;
    private int mReportFrom;
    protected ImageView mSenderIcon;
    protected TextView mSenderInfo;
    protected TextView mTitleBtnRightText;
    private TextView mTitleTV;
    private ImageView mTopBlackShadow;
    private TextView mTvFollowTips;
    private ImageView mVideoBack;
    private ImageView mVideoMute;
    private QQVideoView mVideoView;
    protected TextView mWishWord;
    private boolean thisDeviceHas_RENDERING_START;
    private String videoPath;
    private final String TAG = "GrapMchHbActivity-----";
    protected int mProcessFlag = 151;
    private final int TYPE_VIDEO = 10;
    private final int TYPE_PICTURE = 11;
    private int hbType = 11;
    private boolean isNativeVideo = false;
    protected String mListid = "";
    protected String mName = "";
    protected String mAnswer = "";
    protected String mAuthKey = "";
    protected JSONObject mSendObj = null;
    protected JSONObject mRecvObj = null;
    protected JSONObject mSelfObj = null;
    protected JSONArray mRecvArray = null;
    private String sub_mch_id = "";
    private String business_id = "";
    private int positionWhenPause = -1;
    private boolean isMute = false;
    private boolean isInFullScreen = false;
    private boolean mIsFromClickPLay = false;
    private boolean isFromStopClickPLay = false;
    int videoSmallNeedHeight = -1;
    int videoSmallNeedWidth = -1;
    protected int mGrapHBState = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tenpay.sdk.activity.GrapMchHbActivity$5, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass5 implements MediaPlayer.OnPreparedListener {
        AnonymousClass5() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            String str;
            QwLog.i("GrapMchHbActivity-----onPrepared mChannel: " + GrapMchHbActivity.this.mChannel);
            GrapMchHbActivity.this.mMediaPlayer = mediaPlayer;
            if (GrapMchHbActivity.this.mChannel == 4 && (GrapMchHbActivity.this.mReportFrom == 1 || GrapMchHbActivity.this.mReportFrom == 2)) {
                if (GrapMchHbActivity.this.mReportFrom == 1) {
                    str = "ljy.andr.hbsp";
                } else {
                    str = "wdjly.hbsp";
                }
                DataProxy.reportSpringHbAwardPage(str, 0, 0, "", "", "", GrapMchHbActivity.this.mExtraInfo);
            }
            if (GrapMchHbActivity.this.isInFullScreen) {
                GrapMchHbActivity.this.mMediaPlayer.setVolume(1.0f, 1.0f);
            } else {
                GrapMchHbActivity.this.mMediaPlayer.setVolume(0.0f, 0.0f);
            }
            GrapMchHbActivity.this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.5.1
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i3, int i16) {
                    if (i3 == 3) {
                        QwLog.i("GrapMchHbActivity-----MEDIA_INFO_VIDEO_RENDERING_START: " + GrapMchHbActivity.this.mIsFromClickPLay);
                        GrapMchHbActivity.this.thisDeviceHas_RENDERING_START = true;
                        if (GrapMchHbActivity.this.mIsFromClickPLay) {
                            GrapMchHbActivity.this.mIsFromClickPLay = false;
                            if (!GrapMchHbActivity.this.isInFullScreen) {
                                GrapMchHbActivity.this.gotoPlayFullScreen();
                            }
                            GrapMchHbActivity grapMchHbActivity = GrapMchHbActivity.this;
                            grapMchHbActivity.resizeVideoView(grapMchHbActivity.mMediaPlayer);
                        } else {
                            GrapMchHbActivity.this.setProgressBarAndCenterIt(false);
                            GrapMchHbActivity.this.ClearProgressAndBg();
                            GrapMchHbActivity grapMchHbActivity2 = GrapMchHbActivity.this;
                            grapMchHbActivity2.resizeVideoView(grapMchHbActivity2.mMediaPlayer);
                            return true;
                        }
                    } else if (i3 == 702) {
                        if (GrapMchHbActivity.this.thisDeviceHas_RENDERING_START) {
                            return true;
                        }
                        GrapMchHbActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!GrapMchHbActivity.this.isFinishing() && GrapMchHbActivity.this.mProgressBar.getVisibility() == 0) {
                                    GrapMchHbActivity.this.ClearProgressAndBg();
                                    GrapMchHbActivity grapMchHbActivity3 = GrapMchHbActivity.this;
                                    grapMchHbActivity3.resizeVideoView(grapMchHbActivity3.mMediaPlayer);
                                }
                            }
                        }, 2000L);
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ClearProgressAndBg() {
        setProgressBarAndCenterIt(false);
        this.mVideoView.setVisibility(0);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.9
            @Override // java.lang.Runnable
            public void run() {
                GrapMchHbActivity.this.mVideoView.setBackgroundColor(0);
            }
        }, 200);
    }

    private void clickMuteButton() {
        if (this.isMute) {
            this.mVideoMute.setBackgroundResource(R.drawable.e0_);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        } else {
            this.mVideoMute.setBackgroundResource(R.drawable.e0a);
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setVolume(0.0f, 0.0f);
            }
        }
        this.isMute = !this.isMute;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap createVideoThumbnail(String str, boolean z16) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (z16) {
                    mediaMetadataRetriever.setDataSource(str);
                } else {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(0L, 0);
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                mediaMetadataRetriever.release();
                bitmap = null;
                if (bitmap == null) {
                }
            }
        } catch (Throwable unused3) {
            bitmap = null;
            if (bitmap == null) {
            }
        }
        if (bitmap == null) {
            return null;
        }
        return bitmap;
    }

    private void dealFollowPubAccount(Bundle bundle) {
        LinearLayout linearLayout = this.mLayoutQqPubFollow;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            QFuncProxy.followUin(this.mPubAccUin, getContext(), this.mCheckFollow.isChecked());
        }
    }

    private void dealWithGrapped() {
        this.mLayoutOne.setVisibility(0);
        String optString = this.mRecvObj.optString("amount");
        this.mAmount = optString;
        if (!TextUtils.isEmpty(optString)) {
            this.mGraped = true;
            QwLog.e("amount is: " + this.mAmount);
            this.mHBCount.setText(Utils.fen2Yuan(this.mAmount));
            QwLog.e("text on hbcount is: " + this.mHBCount.getText().toString());
            this.mHBCountYuan.setVisibility(0);
            com.tencent.mobileqq.qwallet.c.c("corphb.index.show", Integer.valueOf(getProcessType()));
        }
        this.mBargainorId = this.mSendObj.optString("mch_id");
        this.business_id = this.mSendObj.optString("business_id");
        this.sub_mch_id = this.mSendObj.optString("sub_mch_id");
        setSubscribeCheck();
    }

    private void dealWithHasGrapped() {
        this.mGraped = true;
        this.mLayoutOne.setVisibility(0);
        this.mLayoutQqPubFollow.setVisibility(8);
        this.layoutHbdetail.setVisibility(0);
        this.mHBAddedToYue.setVisibility(8);
        String optString = this.mRecvObj.optString("amount");
        this.mAmount = optString;
        if (!TextUtils.isEmpty(optString)) {
            QwLog.e("amount is: " + this.mAmount);
            this.mHBCount.setText(Utils.fen2Yuan(this.mAmount));
            QwLog.e("text on hbcount is: " + this.mHBCount.getText().toString());
            this.mHBCountYuan.setVisibility(0);
            this.mHBCount.setTextColor(getResources().getColor(R.color.f157617ur));
            this.mHBCountYuan.setTextColor(getResources().getColor(R.color.f157617ur));
            com.tencent.mobileqq.qwallet.c.c("corphb.index.show", Integer.valueOf(getProcessType()));
        }
    }

    private void dealWithWhichLayoutView(int i3) {
        if (i3 == 10) {
            if (Utils.isEmpty(this.videoPath)) {
                this.mMchBgImg.setVisibility(0);
                this.mVideoView.setVisibility(8);
                this.mPlay.setVisibility(8);
                return;
            }
            try {
                this.mMchBgImg.setVisibility(8);
                this.mVideoView.setVisibility(0);
                if (!Utils.isWiFiActive(getContext()) && !this.isNativeVideo) {
                    whenNetIsNotWifi();
                    return;
                }
                this.mPlay.setVisibility(8);
                setProgressBarAndCenterIt(true);
                if (this.isNativeVideo) {
                    this.mVideoView.setVideoPath(this.videoPath);
                } else {
                    this.mVideoView.setVideoURI(Uri.parse(this.videoPath));
                }
                if (!this.mVideoView.isPlaying()) {
                    this.mVideoView.start();
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("GrapMchHbActivity-----", 1, "", th5);
                return;
            }
        }
        this.mVideoView.setVisibility(8);
        this.mMchBgImg.setVisibility(0);
        this.mPlay.setVisibility(8);
        setProgressBarAndCenterIt(false);
    }

    private void downLoadBannerImgIfPic(String str) {
        this.mMchBgImg.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str));
    }

    private void downLoadSenderIcon(String str) {
        this.mSenderIcon.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str));
    }

    private void fitStatusBarHeight(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin += ImmersiveUtils.getStatusBarHeight(getContext());
        view.setLayoutParams(marginLayoutParams);
    }

    private void fullScreenBackToHb() {
        try {
            this.isInFullScreen = false;
            QwLog.i("GrapMchHbActivity-----fullScreenBackToHb()");
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            this.isFromStopClickPLay = false;
            recoverHBGlide();
            if (!this.mVideoView.isPlaying()) {
                this.mVideoView.start();
            }
            this.mFullScrPlay.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.layoutVideo.getLayoutParams();
            layoutParams.addRule(10);
            this.layoutVideo.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVideoView.getLayoutParams();
            layoutParams2.addRule(10);
            this.mVideoView.setLayoutParams(layoutParams2);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
                resizeVideoView(this.mMediaPlayer);
            }
            this.mLayoutVideoOthers.setVisibility(0);
            this.layoutVideoHead.setVisibility(8);
            this.layoutNormalHead.setVisibility(0);
            this.mPlay.setVisibility(8);
            this.mLayoutOne.setBackgroundColor(Color.parseColor("#FF6464"));
        } catch (Throwable th5) {
            QLog.e("GrapMchHbActivity-----", 1, "", th5);
        }
    }

    private void getTheFirstVideoFrame(final String str) {
        if (this.mChannel == 4) {
            this.mLayoutOne.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.14
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!GrapMchHbActivity.this.isLoadFirstThumbBackground) {
                        GrapMchHbActivity.this.isLoadFirstThumbBackground = true;
                        GrapMchHbActivity.this.setFirstVideoThumb(str);
                    }
                }
            });
        } else {
            setFirstVideoThumb(str);
        }
    }

    private void getVideoPathByUrl(String str) {
        if (str.equals("2")) {
            this.hbType = 10;
        }
        String pathByUrl = DownloadProxy.getPathByUrl(this.videoPath);
        QwLog.e("GrapMchHbActivity bg preload path :" + this.videoPath + "|" + pathByUrl);
        if (!Utils.isEmpty(pathByUrl)) {
            QwLog.e("GrapMchHbActivity video use preload path");
            this.videoPath = pathByUrl;
            this.isNativeVideo = true;
        } else {
            QwLog.e("GrapMchHbActivity video real time download");
            if (this.videoPath.contains("https")) {
                this.videoPath = this.videoPath.replaceFirst("https", "http");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPlayFullScreen() {
        QwLog.i("GrapMchHbActivity-----gotoPlayFullScreen()");
        try {
            this.isInFullScreen = true;
            getWindow().setFlags(1024, 1024);
            downHbGlide();
            this.mMchBgImg.setVisibility(8);
            this.layoutNormalHead.setVisibility(8);
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && !this.isMute) {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null) {
                resizeVideoView(mediaPlayer2);
            }
            setProgressBarAndCenterIt(false);
            this.mLayoutOne.setBackgroundColor(-16777216);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.layoutVideo.getLayoutParams();
            layoutParams.removeRule(10);
            layoutParams.addRule(13);
            this.layoutVideo.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVideoView.getLayoutParams();
            layoutParams2.removeRule(10);
            layoutParams2.addRule(10, 0);
            layoutParams2.addRule(13);
            this.mVideoView.setLayoutParams(layoutParams2);
            this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    QwLog.i("GrapMchHbActivity-----postDelayed()  TRANSPARENT");
                    GrapMchHbActivity.this.mVideoView.setBackgroundColor(0);
                }
            }, 200);
        } catch (Throwable th5) {
            QLog.e("GrapMchHbActivity-----", 1, "", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSubscribe(Bundle bundle) throws Exception {
        String string = bundle.getString("tips");
        boolean z16 = bundle.getBoolean("isCheck", false);
        this.mPubAccUin = bundle.getString(IPublicAccountBrowser.KEY_PUB_UIN);
        QwLog.i("tips\uff1a" + string + "isCheck:" + z16);
        if (!Utils.isEmpty(string)) {
            this.mLayoutQqPubFollow.setVisibility(0);
            this.mHBAddedToYue.setVisibility(8);
            QwLog.i("\u8bbe\u7f6e\u4e86\u8d26\u53f7\u6536\u542ccontainer");
            float screenWidth = Utils.getScreenWidth(getContext()) - this.mCheckFollow.getRight();
            QwLog.i("\u5546\u6237\u540d\u4e3a:" + string + ",\u5546\u6237\u540d\u79f0\u5360\u7528\u7684\u6700\u957f\u957f\u5ea6\uff1a" + screenWidth);
            this.mTvFollowTips.setMaxWidth((int) screenWidth);
            float px2Dp = (float) Utils.px2Dp(getContext(), screenWidth);
            String cutTextByPix = Utils.cutTextByPix(getContext(), string, px2Dp, this.mTvFollowTips.getPaint());
            this.mTvFollowTips.setText(cutTextByPix);
            QwLog.i("\u5546\u6237\u540d\u79f0\u88c1\u526a\u540e\u4e3a:" + cutTextByPix + ",\u5546\u6237\u540d\u79f0\u5360\u7528\u7684\u6700\u957f\u957f\u5ea6\uff1a" + px2Dp);
            this.mCheckFollow.setChecked(z16);
            return;
        }
        this.mHBAddedToYue.setVisibility(0);
        this.mLayoutQqPubFollow.setVisibility(8);
    }

    private void initChannel(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.CHANNEL);
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        try {
            this.mChannel = Integer.parseInt(stringExtra);
        } catch (Exception unused) {
            QwLog.e("parse channel exception");
            finish();
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.mUin = intent.getStringExtra("uin");
        this.mListid = intent.getStringExtra("listid");
        this.mName = intent.getStringExtra("name");
        QwLog.e("mName is " + this.mName);
        this.mAnswer = intent.getStringExtra("answer");
        this.mAuthKey = intent.getStringExtra("authkey");
        this.mGrouptype = intent.getStringExtra("grouptype");
        this.mGroupuin = intent.getStringExtra("groupuin");
        this.mGroupid = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        this.isFromHBList = "1".equals(intent.getStringExtra("fromHBList"));
        this.mExtraInfo = intent.getStringExtra("extra_info");
        QwLog.e("mExtraInfo is " + this.mExtraInfo);
    }

    private void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitleTV = textView;
        textView.setText(R.string.e7g);
        this.mProgressBar = (ThreeCircleLoadingView) view.findViewById(R.id.g1o);
        this.mTopBlackShadow = (ImageView) view.findViewById(R.id.dfz);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mTitleBtnRightText = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                String str2;
                EventCollector.getInstance().onViewClickedBefore(view2);
                try {
                    QwLog.i("GrapMchHbActivity  mBackBtn click");
                    if (GrapMchHbActivity.this.mIsBackKeyPressed) {
                        if (GrapMchHbActivity.this.mChannel == 2) {
                            str2 = "corphb.index.keyback";
                        } else {
                            str2 = "theme.grap.keyback";
                        }
                        com.tencent.mobileqq.qwallet.c.c(str2, Integer.valueOf(GrapMchHbActivity.this.getProcessType()));
                    } else {
                        if (GrapMchHbActivity.this.mChannel == 2) {
                            str = "corphb.index.back";
                        } else {
                            str = "theme.grap.back";
                        }
                        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(GrapMchHbActivity.this.getProcessType()));
                    }
                    GrapMchHbActivity.this.sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_CLOSE_RESULT_CODE);
                    GrapMchHbActivity.this.sendMyCallBack(0, "");
                    GrapMchHbActivity.this.finish();
                } catch (Exception e16) {
                    QLog.e("GrapMchHbActivity-----", 1, "", e16);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mSenderIcon = (ImageView) view.findViewById(R.id.f8321int);
        this.mSenderInfo = (TextView) view.findViewById(R.id.inv);
        this.mWishWord = (TextView) view.findViewById(R.id.l48);
        this.mHBCount = (TextView) view.findViewById(R.id.d16);
        this.mHBCountYuan = (TextView) view.findViewById(R.id.d17);
        this.mHBCount.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (GrapMchHbActivity.this.mChannel != 4) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - GrapMchHbActivity.lastClickTime;
                    if (0 >= j3 || j3 >= 800) {
                        GrapMchHbActivity.lastClickTime = currentTimeMillis;
                        if (GrapMchHbActivity.this.mGraped) {
                            com.tencent.mobileqq.qwallet.c.c("redpackets.opened.balance", Integer.valueOf(GrapMchHbActivity.this.getProcessType()));
                            GrapMchHbActivity.this.gotoQWalletActivity(5);
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mHBAddedToYue = (TextView) view.findViewById(R.id.d0z);
        this.mMchBgImg = (ImageView) view.findViewById(R.id.f166201eo3);
        this.mImgRadian = (ImageView) view.findViewById(R.id.dhk);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f166024e50);
        this.mLayoutQqPubFollow = linearLayout;
        linearLayout.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.e3t);
        this.layoutHbdetail = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.hbInfoLayout = (LinearLayout) view.findViewById(R.id.f166053ea4);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.f164793ax3);
        this.mCheckFollow = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                if (z16) {
                    com.tencent.mobileqq.qwallet.c.c("corphb.index.remain", Integer.valueOf(GrapMchHbActivity.this.getProcessType()));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("corphb.index.cancel", Integer.valueOf(GrapMchHbActivity.this.getProcessType()));
                }
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        });
        this.mTvFollowTips = (TextView) view.findViewById(R.id.k87);
        this.mErrorText1 = (TextView) view.findViewById(R.id.byf);
        this.mErrorTips1 = (TextView) view.findViewById(R.id.byh);
        this.mLayoutOne = (RelativeLayout) view.findViewById(R.id.e4i);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.ksc);
        this.mLayoutVideoOthers = relativeLayout2;
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.e4g);
        this.layoutNormalHead = relativeLayout3;
        relativeLayout3.setVisibility(0);
        fitStatusBarHeight(this.layoutNormalHead);
        RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.f166030e63);
        this.layoutVideoHead = relativeLayout4;
        relativeLayout4.setVisibility(8);
        fitStatusBarHeight(this.layoutVideoHead);
        this.layoutVideo = (RelativeLayout) view.findViewById(R.id.f166029e61);
        ImageView imageView = (ImageView) view.findViewById(R.id.ll9);
        this.imSpringBack = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                String str2;
                EventCollector.getInstance().onViewClickedBefore(view2);
                try {
                    QwLog.i("GrapMchHbActivity  imSpringBack click mReportFrom:" + GrapMchHbActivity.this.mReportFrom);
                    if (GrapMchHbActivity.this.mChannel == 4 && (GrapMchHbActivity.this.mReportFrom == 1 || GrapMchHbActivity.this.mReportFrom == 2)) {
                        if (GrapMchHbActivity.this.mReportFrom == 1) {
                            str = "ljy.andr.hbgb";
                        } else {
                            str = "wdjly.fhan";
                        }
                        DataProxy.reportSpringHbAwardPage(str, 1, 0, "", "", "", GrapMchHbActivity.this.mExtraInfo);
                        if (GrapMchHbActivity.this.mReportFrom == 1) {
                            str2 = "ljy.andr.hbspbf";
                        } else {
                            str2 = "wdjly.hbspbf";
                        }
                        DataProxy.reportSpringHbAwardPage(str2, 5, 0, (GrapMchHbActivity.this.mVideoView.getCurrentPosition() / 1000) + "", (GrapMchHbActivity.this.mVideoView.getDuration() / 1000) + "", GrapMchHbActivity.this.mBusName, GrapMchHbActivity.this.mExtraInfo);
                    }
                    GrapMchHbActivity.this.sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_CLOSE_RESULT_CODE);
                    GrapMchHbActivity.this.sendMyCallBack(0, "");
                    GrapMchHbActivity.this.finish();
                } catch (Exception e16) {
                    QLog.e("GrapMchHbActivity-----", 1, "", e16);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mVideoView = new QQVideoView(getContext());
        this.mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mVideoView.setBackgroundColor(-16777216);
        this.layoutVideo.addView(this.mVideoView, 0);
        judgeTheHeightIsEnough(null);
        this.mVideoView.setOnPreparedListener(new AnonymousClass5());
        this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.6
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                GrapMchHbActivity.this.setProgressBarAndCenterIt(false);
                if (GrapMchHbActivity.this.isInFullScreen) {
                    GrapMchHbActivity.this.mFullScrPlay.setVisibility(0);
                } else {
                    GrapMchHbActivity.this.mPlay.setVisibility(0);
                }
            }
        });
        this.mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.7
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                QwLog.i("videoview error " + i3);
                if (!GrapMchHbActivity.this.isInFullScreen) {
                    GrapMchHbActivity.this.mPlay.setVisibility(0);
                    GrapMchHbActivity.this.setProgressBarAndCenterIt(false);
                    GrapMchHbActivity.this.getVideoThumbnail();
                    return true;
                }
                return true;
            }
        });
        this.mVideoView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                String str;
                int[] iArr = new int[2];
                GrapMchHbActivity.this.mSenderIcon.getLocationOnScreen(iArr);
                int i3 = iArr[1];
                int i16 = 8;
                if (GrapMchHbActivity.this.mLayoutVideoOthers.getVisibility() == 0 && motionEvent.getAction() == 0 && motionEvent.getRawY() < i3 && GrapMchHbActivity.this.mProgressBar.getVisibility() == 8 && GrapMchHbActivity.this.mVideoView.isPlaying()) {
                    GrapMchHbActivity.this.gotoPlayFullScreen();
                }
                if (GrapMchHbActivity.this.mLayoutVideoOthers.getVisibility() == 8) {
                    RelativeLayout relativeLayout5 = GrapMchHbActivity.this.layoutVideoHead;
                    if (GrapMchHbActivity.this.layoutVideoHead.getVisibility() != 0) {
                        i16 = 0;
                    }
                    relativeLayout5.setVisibility(i16);
                }
                if (GrapMchHbActivity.this.mChannel == 4 && (GrapMchHbActivity.this.mReportFrom == 1 || GrapMchHbActivity.this.mReportFrom == 2)) {
                    if (GrapMchHbActivity.this.mReportFrom == 1) {
                        str = "ljy.andr.hbsp";
                    } else {
                        str = "wdjly.hbsp";
                    }
                    DataProxy.reportSpringHbAwardPage(str, 1, 0, "", "", "", GrapMchHbActivity.this.mExtraInfo);
                }
                return false;
            }
        });
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f165784di0);
        this.mPlay = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.f165785di1);
        this.mFullScrPlay = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.dhz);
        this.mVideoBack = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) view.findViewById(R.id.dhd);
        this.mVideoMute = imageView5;
        imageView5.setOnClickListener(this);
        if (this.mChannel == 4) {
            this.imSpringBack.setVisibility(0);
            this.layoutHbdetail.setVisibility(4);
            this.mBackBtn.setVisibility(8);
            this.mTitleBtnRightText.setVisibility(8);
            this.mTitleTV.setVisibility(8);
            return;
        }
        this.imSpringBack.setVisibility(8);
        this.mBackBtn.setVisibility(0);
        this.layoutHbdetail.setVisibility(0);
        this.mTitleBtnRightText.setVisibility(0);
        this.mTitleTV.setVisibility(0);
    }

    private int judgeTheHeightIsEnough(Bitmap bitmap) {
        int width;
        int height;
        final int i3 = -1;
        if (bitmap == null) {
            width = 750;
        } else {
            try {
                width = bitmap.getWidth();
            } catch (Throwable th5) {
                QwLog.e("LayoutVideoOthers.post throw exception: " + th5);
            }
        }
        if (bitmap == null) {
            height = 1000;
        } else {
            height = bitmap.getHeight();
        }
        int screenWidth = Utils.getScreenWidth(getContext());
        i3 = (screenWidth * height) / width;
        QwLog.i("[judgeTheHeightIsEnough] width: " + width + " height: " + height + " screenWidth: " + screenWidth);
        if (this.mLayoutVideoOthers.getHeight() == 0) {
            this.mLayoutVideoOthers.measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.mLayoutVideoOthers.requestLayout();
        }
        this.mLayoutVideoOthers.post(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int top = GrapMchHbActivity.this.mLayoutVideoOthers.getTop() + (GrapMchHbActivity.this.mSenderIcon.getHeight() / 2) + Utils.dp2Px(GrapMchHbActivity.this.getContext(), 40.0f) + Utils.getNavigationBarHeight(GrapMchHbActivity.this.getContext());
                    QwLog.i("[judgeTheHeightIsEnough] realHeight: " + i3 + " theMinimumHeight: " + top + " mLayoutVideoOthers.getHeight: " + GrapMchHbActivity.this.mLayoutVideoOthers.getHeight());
                    if (i3 < top) {
                        ((RelativeLayout.LayoutParams) GrapMchHbActivity.this.mLayoutVideoOthers.getLayoutParams()).height = GrapMchHbActivity.this.mLayoutVideoOthers.getHeight() + (top - i3);
                        GrapMchHbActivity.this.mLayoutVideoOthers.requestLayout();
                        QwLog.i("[judgeTheHeightIsEnough] after resize videoOthersLayoutParams.height: " + GrapMchHbActivity.this.mLayoutVideoOthers.getHeight());
                        GrapMchHbActivity.this.hbInfoLayout.getLayoutParams().height = -1;
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
        return i3;
    }

    private void judgeTheVideoHeightIsEnough(MediaPlayer mediaPlayer, int i3, int i16) {
        QwLog.i("judgeTheVideoHeightIsEnough videoWidth: " + i3 + " videoHeigh: " + i16 + " videoHeighDP: " + Utils.px2Dp(getContext(), i16));
        try {
            this.mVideoView.setDimension(i3, i16);
            this.mVideoView.invalidate();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideoThumbnail$0() {
        final Bitmap createVideoThumbnail = createVideoThumbnail(this.videoPath, this.isNativeVideo);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (createVideoThumbnail != null && !GrapMchHbActivity.this.isInFullScreen) {
                        GrapMchHbActivity.this.isLoadedVideoThumbnail = true;
                        GrapMchHbActivity.this.mMchBgImg.setVisibility(0);
                        GrapMchHbActivity.this.resizeMchImg(createVideoThumbnail);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFirstVideoThumb$1(String str) {
        final Bitmap createVideoThumbnail = createVideoThumbnail(str, this.isNativeVideo);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (GrapMchHbActivity.this.isFinishing()) {
                        return;
                    }
                    if (createVideoThumbnail != null) {
                        GrapMchHbActivity.this.mMchBgImg.setVisibility(0);
                        GrapMchHbActivity.this.resizeMchImg(createVideoThumbnail);
                    } else {
                        GrapMchHbActivity.this.mVideoView.setVisibility(8);
                    }
                }
            });
        }
    }

    private void processData(JSONObject jSONObject) {
        this.mHBdata = jSONObject;
        QwLog.e(jSONObject.toString());
        this.mGrapHBState = this.mHBdata.optInt("state", -1);
        sendHBStateBroadcast(IQWalletHelper.TROOP_HBLIST_GRAPHB_RESULT_CODE);
        this.mSendObj = jSONObject.optJSONObject("send_object");
        this.mRecvObj = jSONObject.optJSONObject("recv_object");
        this.mSelfObj = jSONObject.optJSONObject("self_object");
        this.mRecvArray = jSONObject.optJSONArray("recv_array");
        this.hbType = 11;
        JSONObject jSONObject2 = this.mSendObj;
        if (jSONObject2 != null) {
            String optString = jSONObject2.optString("banner_type");
            this.videoPath = this.mSendObj.optString("banner");
            getVideoPathByUrl(optString);
            dealWithWhichLayoutView(this.hbType);
            int optInt = this.mSendObj.optInt(WadlProxyConsts.CHANNEL);
            String optString2 = this.mSendObj.optString("mch_icon");
            String optString3 = this.mSendObj.optString("banner");
            int i3 = this.mGrapHBState;
            if (4 != i3 && -1 != i3 && 6 != i3 && 7 != i3 && HBUtil.isHbForChunMing(optInt)) {
                downLoadSenderIcon(optString2);
                downLoadBannerImgIfPic(optString3);
            }
        }
        showHbDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeMchImg(Bitmap bitmap) {
        int judgeTheHeightIsEnough = judgeTheHeightIsEnough(bitmap);
        if (judgeTheHeightIsEnough > 0) {
            this.mMchBgImg.getLayoutParams().height = judgeTheHeightIsEnough;
        }
        this.mMchBgImg.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeVideoView(MediaPlayer mediaPlayer) {
        int videoWidth;
        int videoHeight;
        try {
            int screenWidth = Utils.getScreenWidth(getContext());
            if (mediaPlayer == null) {
                videoWidth = 750;
            } else {
                videoWidth = mediaPlayer.getVideoWidth();
            }
            if (mediaPlayer == null) {
                videoHeight = 1000;
            } else {
                videoHeight = mediaPlayer.getVideoHeight();
            }
            QwLog.i("GrapMchHbActivity-----resizeVideoView() screenWidth: " + screenWidth + " videoWidth: " + videoWidth + " videoHeigh: " + videoHeight);
            if (videoHeight > 0 && videoWidth > 0) {
                int i3 = (videoHeight * screenWidth) / videoWidth;
                if (!this.isInFullScreen) {
                    int top = this.mLayoutVideoOthers.getTop() + (this.mSenderIcon.getHeight() / 2) + Utils.dp2Px(getContext(), 40.0f) + Utils.getNavigationBarHeight(getContext());
                    QwLog.i("GrapMchHbActivity-----[resizeVideoView] height: " + i3 + " theMinimumHeight: " + top + " mLayoutVideoOthers.getHeight: " + this.mLayoutVideoOthers.getHeight());
                    if (i3 < top) {
                        ((RelativeLayout.LayoutParams) this.mLayoutVideoOthers.getLayoutParams()).height = this.mLayoutVideoOthers.getHeight() + (top - i3);
                        this.hbInfoLayout.getLayoutParams().height = -1;
                    }
                }
                this.mVideoView.setDimension(screenWidth, i3);
                ((RelativeLayout.LayoutParams) this.mVideoView.getLayoutParams()).height = i3;
            }
        } catch (Throwable th5) {
            QLog.e("GrapMchHbActivity-----", 1, "", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendHBStateBroadcast(int i3) {
        int i16 = this.mGrapHBState;
        if (i16 != 5 && i16 != 7) {
            QwLog.i("sendHBStateBroadcast mListid : " + this.mListid);
            QwLog.i("sendHBStateBroadcast isFromHBList : " + this.isFromHBList);
            if (this.isFromHBList) {
                Intent intent = new Intent(IQWalletHelper.TROOP_HBLIST_BROADCAST_ACTION);
                intent.putExtra("grap_hb_state", this.mGrapHBState);
                intent.putExtra("listid", this.mListid);
                intent.putExtra("result_code", i3);
                sendBroadcast(intent);
            }
        }
    }

    private void sendResultToArk(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", this.mGrapHBState);
            jSONObject.put("billno", this.mListid);
            jSONObject.put("result", str);
            jSONObject.put("retmsg", str2);
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.qianbao", "", "GrapRedPackCallback", jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("GrapMchHbActivity-----", 1, "onDestroyView: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirstVideoThumb(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.activity.az
            @Override // java.lang.Runnable
            public final void run() {
                GrapMchHbActivity.this.lambda$setFirstVideoThumb$1(str);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgressBarAndCenterIt(boolean z16) {
        if (z16) {
            this.mProgressBar.setVisibilityAndAnimation(true);
            if (!this.isInFullScreen) {
                int top = this.mLayoutVideoOthers.getTop() / 2;
                if (top <= 0) {
                    top = Utils.dp2Px(getContext(), 200.0f);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mProgressBar.getLayoutParams();
                if (layoutParams.getRules()[13] == -1) {
                    layoutParams.addRule(13, 0);
                }
                layoutParams.setMargins(0, top, 0, 0);
                return;
            }
            ((RelativeLayout.LayoutParams) this.mProgressBar.getLayoutParams()).addRule(13);
            return;
        }
        this.mProgressBar.setVisibilityAndAnimation(false);
    }

    private void setSubscribeCheck() {
        QwLog.i("mServiceId\uff1a" + this.mServiceId + "\uff0cmGuid\uff1a" + this.mGuid + "\uff0cmAppid\uff1a" + this.mAppid + "\uff0cmProssesID\uff1a" + this.mProssesID + "\uff0cmBargainorId\uff1a" + this.mBargainorId);
        if (Utils.isEmpty(this.mBargainorId) && Utils.isEmpty(this.business_id) && Utils.isEmpty(this.sub_mch_id)) {
            this.mHBAddedToYue.setVisibility(0);
            this.mLayoutQqPubFollow.setVisibility(8);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("bargainorId", this.mBargainorId);
        bundle.putString("businessId", this.business_id);
        bundle.putString("subBargainorId", this.sub_mch_id);
        bundle.putInt("payType", 2);
        bundle.putParcelable("callback", new ResultReceiver(this.mHandler) { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.16
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle2) {
                QwLog.i("\u6536\u5230callback\u56de\u8c03\uff0cresultCode\uff1a" + i3);
                try {
                } catch (Exception e16) {
                    QLog.e("GrapMchHbActivity-----", 1, "", e16);
                }
                if (i3 == 0) {
                    GrapMchHbActivity.this.handleSubscribe(bundle2);
                } else if (i3 == 1) {
                    GrapMchHbActivity.this.mHBAddedToYue.setVisibility(0);
                    GrapMchHbActivity.this.mLayoutQqPubFollow.setVisibility(8);
                } else {
                    if (i3 == 2) {
                        GrapMchHbActivity.this.mHBAddedToYue.setVisibility(0);
                        GrapMchHbActivity.this.mLayoutQqPubFollow.setVisibility(8);
                    }
                    super.onReceiveResult(i3, bundle2);
                }
                super.onReceiveResult(i3, bundle2);
            }
        });
        PayPucAccManager.p(bundle);
    }

    private void showHbDetail() {
        this.mTitleBtnRightText.setText("\u7ea2\u5305\u8bb0\u5f55");
        if (this.mHBdata != null) {
            JSONObject jSONObject = this.mSendObj;
            if (jSONObject != null) {
                String optString = jSONObject.optString("wishing");
                if (!TextUtils.isEmpty(optString)) {
                    if (optString.length() > 14) {
                        optString = optString.substring(0, 13) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    if (this.mGrapHBState == 1) {
                        this.mWishWord.setTextSize(24.0f);
                        optString = "\u4f60\u5df2\u9886\u8fc7\u8be5\u7ea2\u5305\u5566~";
                    }
                    this.mWishWord.setText(optString);
                }
                if (HBUtil.isHbForChunMing(this.mChannel)) {
                    String cutTextByPix = Utils.cutTextByPix(getApplicationContext(), this.mSendObj.optString("send_name"), 145.0f, this.mSenderInfo.getPaint());
                    this.mSenderInfo.setText(cutTextByPix + "\u7684\u7ea2\u5305");
                }
            }
            int i3 = this.mGrapHBState;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                showHbPastDue();
                                return;
                            }
                            HBShiMingHelper.doAction(this, GrapHbActivity.HB_ShiMing_BIND_RESULT_CODE, this.mUin, this.mHBdata.optString("returl"), this.mHBdata.optString("retmsg"), new RealNameSource("15"));
                            return;
                        }
                        showHbPastDue();
                        return;
                    }
                    showHbIsNone();
                    return;
                }
                dealWithHasGrapped();
                return;
            }
            dealWithGrapped();
        }
    }

    private void showHbGrappedUI(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        com.tencent.mobileqq.qwallet.c.c("redpackets.opened.show", Integer.valueOf(getProcessType()));
        this.mLayoutOne.setVisibility(0);
        this.mTitleBtnRightText.setText("\u7ea2\u5305\u8bb0\u5f55");
        if (Utils.isEmpty(str)) {
            str8 = "";
        } else {
            str8 = Utils.cutTextByPix(getContext(), String.format(getString(R.string.e8f), str, ""), 160.0f, this.mSenderInfo.getPaint());
        }
        this.mSenderInfo.setText(str8);
        this.mWishWord.setText("");
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() > 14) {
                str2 = str2.substring(0, 13) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            this.mWishWord.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.mHBCount.setText(Utils.fen2Yuan(str3));
            this.mHBCountYuan.setVisibility(0);
            this.mHBAddedToYue.setVisibility(0);
            this.mGraped = true;
            com.tencent.mobileqq.qwallet.c.c("redpackets.opened.success", Integer.valueOf(getProcessType()));
        }
        getVideoPathByUrl(str7);
        dealWithWhichLayoutView(this.hbType);
        if (this.hbType == 11) {
            downLoadBannerImgIfPic(str6);
        }
        downLoadSenderIcon(str5);
    }

    private void showHbIsNone() {
        this.mErrorText1.setText("\u8fd9\u4e2a\u7ea2\u5305\u9886\u5b8c\u4e86\u54e6~");
        this.mErrorText1.setVisibility(0);
        this.mErrorTips1.setVisibility(8);
        this.mLayoutOne.setVisibility(0);
        this.mHBCount.setVisibility(8);
        this.mHBCountYuan.setVisibility(8);
        this.mHBAddedToYue.setVisibility(8);
    }

    private void showHbPastDue() {
        this.mLayoutOne.setVisibility(0);
        this.mErrorText1.setVisibility(0);
        this.mHBCount.setVisibility(8);
        this.mHBCountYuan.setVisibility(8);
        this.mHBAddedToYue.setVisibility(8);
        this.mErrorTips1.setVisibility(0);
        this.mHBAddedToYue.setVisibility(8);
    }

    private void whenNetIsNotWifi() {
        try {
            this.mVideoView.setVisibility(0);
            this.mVideoView.setVideoURI(Uri.parse(this.videoPath));
            this.mMchBgImg.setVisibility(8);
            this.mPlay.setVisibility(0);
            int i3 = this.mGrapHBState;
            if (i3 == 1 || i3 == 0 || this.mChannel == 4) {
                this.mLayoutOne.setVisibility(0);
            }
            getTheFirstVideoFrame(this.videoPath);
        } catch (Throwable th5) {
            QLog.e("GrapMchHbActivity-----", 1, "", th5);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            QwLog.i("onKeyDown---- back click KEYCODE_BACK");
            this.mIsBackKeyPressed = true;
            if (this.mLayoutOne.getVisibility() == 0 && this.mLayoutVideoOthers.getVisibility() == 0) {
                if (this.mChannel == 4) {
                    this.imSpringBack.performClick();
                } else {
                    this.mBackBtn.performClick();
                }
            } else if (this.mLayoutOne.getVisibility() == 0 && this.mLayoutVideoOthers.getVisibility() == 8) {
                this.mVideoBack.performClick();
            } else {
                finish();
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public void downHbGlide() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mLayoutVideoOthers, "translationY", 0.0f, 1000.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.layoutNormalHead, "translationY", -500.0f);
        ofFloat2.setDuration(380L);
        ofFloat2.start();
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                GrapMchHbActivity.this.mLayoutVideoOthers.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.SCALE_SELF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        return this.mProcessFlag;
    }

    public void getVideoThumbnail() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.activity.ba
            @Override // java.lang.Runnable
            public final void run() {
                GrapMchHbActivity.this.lambda$getVideoThumbnail$0();
            }
        }, 64, null, false);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void goToHbDetailActivity() {
        int i3 = this.mGrapHBState;
        if (-1 != i3 && 4 != i3) {
            Intent intent = new Intent();
            intent.putExtra("listid", this.mListid);
            intent.putExtra("isFromHBList", this.isFromHBList);
            intent.putExtra("from_out", true);
            setIntentData(intent);
            HbDetailModule.k(getActivity(), intent, false);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 == GrapHbActivity.HB_ShiMing_BIND_RESULT_CODE) {
                sendMyCallBack(0, "");
                finish();
                QwLog.i("onActivityResult HB_ShiMing_BIND_RESULT_CODE");
            }
            QwLog.i("onActivityResult Activity.RESULT_OK");
            return;
        }
        QwLog.i("onActivityResult Activity.RESULT_CANCELED");
        sendMyCallBack(0, "");
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(final String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("retcode");
        String optString2 = jSONObject.optString("retmsg");
        QwLog.i("err_code = " + optString);
        if (TextUtils.equals(optString, Integer.toString(GrapHbActivity.ERR_GRPB_HB_RETRY))) {
            if (this.mReTryCount <= NetBaseActivity.MAX_RETRY_COUNT) {
                setIsDismissLoading(false);
                int optInt = jSONObject.optInt("refuse_time");
                if (optInt <= 0) {
                    optInt = 500;
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.GrapMchHbActivity.17
                        @Override // java.lang.Runnable
                        public void run() {
                            GrapMchHbActivity.this.sendGrapHbRequest(str, false);
                            GrapMchHbActivity.this.mReTryCount++;
                        }
                    }, optInt);
                }
            } else {
                setIsDismissLoading(true);
            }
        }
        super.onBlError(str, jSONObject);
        sendResultToArk(optString, optString2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        try {
            if (id5 == R.id.ivTitleBtnRightText) {
                com.tencent.mobileqq.qwallet.c.c("redpackets.opened.record", Integer.valueOf(getProcessType()));
                launchFragment(new Intent(), HbListActivity.class);
            } else {
                boolean z16 = true;
                if (id5 == R.id.f166024e50) {
                    CheckBox checkBox = this.mCheckFollow;
                    if (checkBox.isChecked()) {
                        z16 = false;
                    }
                    checkBox.setChecked(z16);
                } else if (id5 == R.id.f165784di0) {
                    this.mIsFromClickPLay = true;
                    this.isLoadedVideoThumbnail = false;
                    if (!this.isNativeVideo && this.mVideoView.getBufferPercentage() != 100) {
                        setProgressBarAndCenterIt(true);
                    }
                    this.mVideoView.setVisibility(0);
                    this.mMchBgImg.setVisibility(8);
                    this.mVideoView.setBackgroundColor(-16777216);
                    if (!this.mVideoView.isPlaying()) {
                        this.mVideoView.start();
                    }
                    this.mPlay.setVisibility(8);
                    if ((this.mVideoView.getBufferPercentage() == 100 || this.isNativeVideo) && !this.isFromStopClickPLay) {
                        this.isFromStopClickPLay = false;
                        gotoPlayFullScreen();
                    }
                } else if (id5 == R.id.dhz) {
                    fullScreenBackToHb();
                } else if (id5 == R.id.dhd) {
                    clickMuteButton();
                } else if (id5 == R.id.f165785di1) {
                    this.mFullScrPlay.setVisibility(8);
                    this.mVideoView.setVisibility(0);
                    if ((this.mVideoView.getBufferPercentage() != 100 && !this.isNativeVideo) || (this.isFromStopClickPLay && !this.isNativeVideo && this.mVideoView.getBufferPercentage() != 100)) {
                        setProgressBarAndCenterIt(true);
                    }
                    if (this.isNativeVideo || this.mVideoView.getBufferPercentage() == 100) {
                        ClearProgressAndBg();
                    }
                    if (!this.mVideoView.isPlaying()) {
                        this.mVideoView.start();
                    }
                } else if (id5 == R.id.e3t && this.mChannel != 4) {
                    goToHbDetailActivity();
                    sendMyCallBack(0, "");
                }
            }
        } catch (Throwable unused) {
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
        }
        initChannel(getIntent());
        initData();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168580ae3, viewGroup, false);
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QwLog.e("GrapMchHbActivity onDestroy");
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        commonBlErrorPros(jSONObject, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        int i3;
        QwLog.e("GrapMchHbActivity onPause ");
        boolean isPlaying = this.mVideoView.isPlaying();
        this.isPlayingWhenPause = isPlaying;
        if (isPlaying) {
            i3 = this.mVideoView.getCurrentPosition();
        } else {
            i3 = 0;
        }
        this.positionWhenPause = i3;
        this.mVideoView.pause();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QwLog.e("GrapMchHbActivity onResume ");
        super.onResume();
        if (this.hbType != 10) {
            return;
        }
        try {
            if (this.mProgressBar.getVisibility() == 0 || (this.positionWhenPause > 0 && !this.mHasStopped)) {
                this.mVideoView.start();
            }
            int i3 = this.positionWhenPause;
            if (i3 > 0 && this.mHasStopped) {
                this.mVideoView.seekTo(i3);
                if (this.isPlayingWhenPause) {
                    this.mVideoView.setBackgroundColor(-16777216);
                    this.mVideoView.start();
                    setProgressBarAndCenterIt(true);
                    this.mFullScrPlay.setVisibility(8);
                    this.mPlay.setVisibility(8);
                    this.mVideoView.requestFocus();
                    this.positionWhenPause = 0;
                }
            }
            if (this.mHasStopped && !this.isPlayingWhenPause && this.mProgressBar.getVisibility() == 8) {
                this.mVideoView.setVisibility(8);
                if (this.isInFullScreen) {
                    this.mFullScrPlay.setVisibility(0);
                    this.mVideoView.setBackgroundColor(-16777216);
                } else if (this.mProgressBar.getVisibility() == 8) {
                    this.mVideoView.setBackgroundColor(-16777216);
                    this.mPlay.setVisibility(0);
                    if (!this.isLoadedVideoThumbnail) {
                        getVideoThumbnail();
                    }
                }
            }
            this.mHasStopped = false;
        } catch (Exception e16) {
            QLog.e("GrapMchHbActivity-----", 1, "", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QwLog.e("GrapMchHbActivity onStop");
        super.onStop();
        if (!this.isInFullScreen) {
            this.mVideoView.setBackgroundColor(-16777216);
            if (this.mPlay.getVisibility() == 0) {
                this.isFromStopClickPLay = true;
            }
        }
        this.mHasStopped = true;
        this.mIsFromClickPLay = false;
        if (this.isNativeVideo) {
            return;
        }
        this.mVideoView.stopPlayback();
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer = null;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (this.mHandler != null && jSONObject != null) {
            processData(jSONObject);
            sendResultToArk("0", "");
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (HBUtil.isHbForChunMing(this.mChannel)) {
            this.mTopBlackShadow.setVisibility(0);
            sendGrapHbRequest(Cgi.URI_HB_NA_MCH_GRAP, true);
            return;
        }
        String stringExtra = getIntent().getStringExtra("detailinfo");
        if (!Utils.isEmpty(stringExtra)) {
            QwLog.e("detailinfo received is " + stringExtra);
            processRefreshHb(stringExtra);
        }
    }

    protected void processRefreshHb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("send_name");
            this.mReportFrom = jSONObject.optInt("report_from", 0);
            this.mBusName = optString;
            QwLog.i("mBusName: " + this.mBusName);
            String optString2 = jSONObject.optString("wishing");
            if (Utils.isEmpty(optString2)) {
                optString2 = "\u606d\u559c\u53d1\u8d22";
            }
            String str2 = optString2;
            String optString3 = jSONObject.optString("amount");
            String optString4 = jSONObject.optString("mch_icon");
            String optString5 = jSONObject.optString("send_uin");
            int optInt = jSONObject.optInt(WadlProxyConsts.CHANNEL);
            this.mChannel = optInt;
            String optString6 = jSONObject.optString("banner_type");
            this.videoPath = jSONObject.optString("banner");
            QwLog.e("SEND CHANNEL IS " + optInt);
            if (optInt == 4) {
                showHbGrappedUI(optString, str2, optString3, optString5, optString4, this.videoPath, optString6);
            }
        } catch (JSONException e16) {
            QLog.e("GrapMchHbActivity-----", 1, "", e16);
        }
    }

    public void recoverHBGlide() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mLayoutVideoOthers, "translationY", 1000.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.layoutNormalHead, "translationY", 0.0f);
        ofFloat2.setDuration(400L);
        ofFloat2.start();
    }

    protected void sendGrapHbRequest(String str, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("listid", this.mListid);
        hashMap.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupid);
        hashMap.put("grouptype", this.mGrouptype);
        hashMap.put("groupuin", this.mGroupuin);
        hashMap.put("name", this.mName);
        hashMap.put("answer", this.mAnswer);
        hashMap.put("authkey", this.mAuthKey);
        hashMap.put("come_from", this.mComeFrom + "");
        hashMap.put("uin", this.mUin);
        hashMap.put("senderuin", getIntent().getStringExtra("senderuin"));
        if (HBUtil.isHbForChunMing(this.mChannel)) {
            hashMap.put(WadlProxyConsts.CHANNEL, "2");
        } else {
            int i3 = this.mChannel;
            if (i3 != -1) {
                hashMap.put(WadlProxyConsts.CHANNEL, String.valueOf(i3));
            }
        }
        httpRequest(str, hashMap, z16);
    }

    public void sendMyCallBack(int i3, String str) {
        Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(i3);
        retCodeAndGetBundle.putString(Cgi.RETURN_MSG_KEY, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", this.mGrapHBState);
            if (!TextUtils.isEmpty(this.mAmount)) {
                jSONObject.put("amount", this.mAmount);
            }
            jSONObject.put("listid", this.mListid);
        } catch (JSONException e16) {
            QLog.e("GrapMchHbActivity-----", 1, "", e16);
        }
        retCodeAndGetBundle.putString("retdata", jSONObject.toString());
        dealFollowPubAccount(retCodeAndGetBundle);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
