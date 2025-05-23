package com.tenpay.sdk.activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.proxy.DownloadProxy;
import com.tenpay.sdk.view.ThreeCircleLoadingView;
import com.tenpay.util.Utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FullVideoActivity extends NetBaseActivity implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, View.OnClickListener {
    private boolean isImaxPlayed;
    boolean isLocalVideo;
    private boolean isMute;
    private boolean isNeedPlay;
    private boolean isWiFi;
    private ImageView mBackView;
    private LinearLayout mErrorTips;
    private ThreeCircleLoadingView mLoadingBar;
    private MediaPlayer mMediaPlayer;
    private TextView mTextTips;
    private String mUri;
    private ImageView mVideoMute;
    private VideoView mVideoView;
    private int maxMusicVolume;
    private int positionPlaying = -1;
    private AudioManager audioManager = null;
    private boolean isBrokenByUserClick = false;
    private boolean isBrokenByUserClip = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVolumeFadeIn() {
        try {
            if (!this.isImaxPlayed) {
                this.isImaxPlayed = true;
                QwLog.i("audioFadeinDuration is 3, maxMusicVolume is " + this.maxMusicVolume);
                int i3 = this.maxMusicVolume;
                if (i3 == 0) {
                    return;
                }
                this.audioManager.setStreamVolume(3, (int) (i3 * 0.2d), 0);
                final int i16 = (int) ((3 * 1000.0f) / this.maxMusicVolume);
                this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.FullVideoActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FullVideoActivity.this.audioManager == null) {
                            return;
                        }
                        if (FullVideoActivity.this.isBrokenByUserClick) {
                            QwLog.i("is broken by user click");
                            return;
                        }
                        if (FullVideoActivity.this.isBrokenByUserClip) {
                            QwLog.i("is broken by user clip");
                            return;
                        }
                        int streamVolume = SystemMethodProxy.getStreamVolume(FullVideoActivity.this.audioManager, 3);
                        QwLog.i("change volume is " + streamVolume);
                        if (streamVolume < FullVideoActivity.this.maxMusicVolume) {
                            FullVideoActivity.this.audioManager.adjustStreamVolume(3, 1, 0);
                            FullVideoActivity.this.mHandler.postDelayed(this, i16);
                            return;
                        }
                        QwLog.i("smoothAdjustVolume() mTargetMusicVolume = " + FullVideoActivity.this.maxMusicVolume + ", SET mIsSmoothRaiseFinished = true, FINISHED");
                    }
                }, i16);
            }
        } catch (Throwable th5) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", th5);
        }
    }

    private void clickMuteButton() {
        if (this.isMute) {
            this.mVideoMute.setBackgroundResource(R.drawable.e0_);
            this.audioManager.setStreamVolume(3, this.maxMusicVolume, 0);
        } else {
            this.mVideoMute.setBackgroundResource(R.drawable.e0a);
            this.audioManager.setStreamVolume(3, 0, 0);
        }
        this.isMute = !this.isMute;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 24 || i3 == 25) {
            try {
                this.isBrokenByUserClip = true;
                this.maxMusicVolume = SystemMethodProxy.getStreamVolume(this.audioManager, 3);
            } catch (Throwable th5) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", th5);
            }
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dhz) {
            finish();
        } else if (view.getId() == R.id.dhd) {
            this.isBrokenByUserClick = true;
            clickMuteButton();
        } else if (view.getId() == R.id.byh) {
            this.mTextTips.setText("");
            this.mLoadingBar.setVisibilityAndAnimation(false);
            if (this.isNeedPlay) {
                this.mVideoView.setVideoPath(this.mUri);
                this.mVideoView.start();
            } else if (!this.mVideoView.isPlaying()) {
                int i3 = this.positionPlaying;
                if (i3 > 0) {
                    this.mVideoView.seekTo(i3);
                }
                this.mVideoView.start();
            }
            this.mErrorTips.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        QwLog.i("\u64ad\u653e\u5b8c\u6210");
        this.positionPlaying = 0;
        this.mLoadingBar.setVisibilityAndAnimation(false);
        this.mVideoView.seekTo(0);
        this.mErrorTips.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        View inflate = layoutInflater.inflate(R.layout.f168578ae0, viewGroup, false);
        AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
        this.audioManager = audioManager;
        if (audioManager != null) {
            int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
            this.maxMusicVolume = streamVolume;
            this.audioManager.setStreamVolume(3, (int) (streamVolume * 0.2d), 0);
        }
        this.mVideoView = (VideoView) inflate.findViewById(R.id.f163994gb);
        this.mLoadingBar = (ThreeCircleLoadingView) inflate.findViewById(R.id.g1o);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dhz);
        this.mBackView = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.dhd);
        this.mVideoMute = imageView2;
        imageView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.byh);
        this.mErrorTips = linearLayout;
        linearLayout.setOnClickListener(this);
        this.mTextTips = (TextView) inflate.findViewById(R.id.f166978jj4);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnErrorListener(this);
        this.mVideoView.setOnPreparedListener(this);
        String stringExtra = getIntent().getStringExtra(LayoutAttrDefine.CLICK_URI);
        this.mUri = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            String pathByUrl = DownloadProxy.getPathByUrl(this.mUri);
            if (!TextUtils.isEmpty(pathByUrl)) {
                this.isLocalVideo = true;
                this.mUri = pathByUrl;
            } else if (this.mUri.startsWith("https")) {
                this.mUri = this.mUri.replaceFirst("https", "http");
            }
            boolean isWiFiActive = Utils.isWiFiActive(getContext());
            this.isWiFi = isWiFiActive;
            if (!this.isLocalVideo && !isWiFiActive) {
                this.isNeedPlay = true;
                this.mErrorTips.setVisibility(0);
            } else {
                this.mVideoView.setVideoPath(this.mUri);
                this.mVideoView.start();
                this.mLoadingBar.setVisibilityAndAnimation(true);
            }
        } else {
            QQToast.makeText(getContext(), "Url\u4e3a\u7a7a", 0).show();
            finish();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            this.mVideoView.stopPlayback();
            this.mVideoView.setOnPreparedListener(null);
            this.mVideoView.setOnErrorListener(null);
            this.mVideoView.setOnCompletionListener(null);
            if (!this.isBrokenByUserClip) {
                this.audioManager.setStreamVolume(3, this.maxMusicVolume, 0);
            }
        } catch (Throwable th5) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", th5);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        String str;
        QwLog.i("onError : " + i3 + ProgressTracer.SEPARATOR + i16);
        this.mLoadingBar.setVisibility(8);
        if (i16 != -1004 && i16 != -1005) {
            if (i16 == -110) {
                str = "\u7f51\u7edc\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            } else {
                str = "[" + i3 + "|" + i16 + "]\u64ad\u653e\u51fa\u95ee\u9898\u5566\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
        } else {
            str = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
        }
        this.mErrorTips.setVisibility(0);
        this.mTextTips.setText(str);
        return true;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.positionPlaying = this.mVideoView.getCurrentPosition();
        this.mVideoView.pause();
        this.mErrorTips.setVisibility(0);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mLoadingBar.setVisibilityAndAnimation(false);
        QwLog.i("\u51c6\u5907\u5b8c\u6210,\u5f00\u59cb\u64ad\u653e");
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tenpay.sdk.activity.FullVideoActivity.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer2, int i3, int i16) {
                QwLog.i("onInfo : " + i3 + APLogFileUtil.SEPARATOR_LOG + i16);
                if (i3 == 701) {
                    FullVideoActivity.this.mLoadingBar.setVisibilityAndAnimation(true);
                } else if (i3 == 702) {
                    if (mediaPlayer2.isPlaying()) {
                        FullVideoActivity.this.mLoadingBar.setVisibilityAndAnimation(false);
                    }
                    FullVideoActivity.this.mVideoView.setBackgroundColor(0);
                } else if (i3 == 3) {
                    FullVideoActivity.this.mErrorTips.setVisibility(8);
                    FullVideoActivity.this.mLoadingBar.setVisibilityAndAnimation(false);
                    FullVideoActivity.this.mVideoView.setBackgroundColor(0);
                    FullVideoActivity.this.changeVolumeFadeIn();
                }
                return true;
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        try {
            this.mVideoView.setBackgroundColor(-16777216);
            this.mVideoView.stopPlayback();
        } catch (Throwable th5) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", th5);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
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
