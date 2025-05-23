package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.a;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes18.dex */
public class ImageViewVideoPlayer extends LinearLayout implements VideoDrawable.OnPlayRepeatListener, URLDrawableDownListener, VideoDrawable.OnPlayerOneFrameListener {
    public static final int AIO_VIDEO_FRAME_LIMIT_NUM = 3;
    private static final int G_CUT_FRAMES_PLAY = 3;
    public static final int IMV_PLAYER_STATE_INIT = 2;
    public static final int IMV_PLAYER_STATE_START = 3;
    public static final int IMV_PLAYER_STATE_STOP = 4;
    public static final int IMV_PLAYER_STATE_UNINIT = 1;
    public static final int QQSTORY_VIDEO_FRAME_LIMIT_NUM = 3;
    public static final int QZONE_VIDEO_FRAME_LIMIT_NUM = 3;
    public static final int RESULT_ERROR_NO_AUDIO_FILE = -2;
    public static final int RESULT_ERROR_NO_SOURCE = -1;
    public static final int RESULT_ERROR_NO_VIDEO_FILE = -3;
    public static final int RESULT_ERROR_PARAM_INVALID = -4;
    private static final String TAG = "ImageViewVideoPlayer";
    public static final int VIDEO_FRAME_LIMIT_NUM = 11;
    private static ColorDrawable sLoading = new ColorDrawable(-14342358);
    private String mAFile;
    private int mCurrentPlayedFrame;
    private boolean mEnableCyclePlay;
    public IMPFrameListener mFrameListener;
    private boolean mHaveEnded;
    public Bitmap mLastFramePicture;
    public BitmapDrawable mLoadingBitmap;
    private boolean mNeedPlayAudio;
    private boolean mNeedProgress;
    public URLImageView mPlayer;
    public IMPlayerEndListener mPlayerEndListener;
    public int mPlayerState;
    private PlayerProgressBar mProgressBar;
    public boolean mRequireAudioFocus;
    public boolean mSecurityChecked;
    private int mTotalFrame;
    private URLDrawable mUrlDrawable;
    private String mVFile;
    public VideoDrawable mVideoDrawable;

    /* loaded from: classes18.dex */
    public interface IMPFrameListener {
        void onCurrentFrame(int i3);
    }

    /* loaded from: classes18.dex */
    public interface IMPlayerEndListener {
        void onDrawLastFrameEnd();

        void onPlayerEnd();

        void onPlayerRecyle();
    }

    public ImageViewVideoPlayer(Context context) {
        super(context);
        this.mPlayerState = 1;
        this.mHaveEnded = false;
        this.mTotalFrame = 0;
        this.mCurrentPlayedFrame = 0;
        this.mEnableCyclePlay = false;
        this.mNeedProgress = true;
        this.mVideoDrawable = null;
        this.mUrlDrawable = null;
        this.mPlayerEndListener = null;
        this.mFrameListener = null;
        this.mSecurityChecked = false;
        this.mLastFramePicture = null;
        this.mLoadingBitmap = null;
        this.mRequireAudioFocus = true;
        this.mNeedPlayAudio = false;
        this.mVFile = null;
        this.mAFile = null;
        initUI(context);
    }

    private void checkAndGetVideoDrawable() {
        Drawable drawable;
        boolean z16;
        URLDrawable uRLDrawable = this.mUrlDrawable;
        if (uRLDrawable != null) {
            try {
                drawable = uRLDrawable.getCurrDrawable();
            } catch (NullPointerException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "checkAndGetVideoDrawable mUrlDrawable==null", e16);
                }
                drawable = null;
            }
            if (drawable != null && (drawable instanceof VideoDrawable)) {
                VideoDrawable videoDrawable = (VideoDrawable) this.mUrlDrawable.getCurrDrawable();
                this.mVideoDrawable = videoDrawable;
                boolean isAudioPlaying = videoDrawable.isAudioPlaying();
                if (!((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(a.f68989c) && !((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(a.f68990d)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "initPlayer: audioPlaying= " + isAudioPlaying + " black=" + z16);
                }
                if (z16) {
                    this.mVideoDrawable.disableGlobalPause();
                }
            }
        }
    }

    private void endFramePlay() {
        if (!this.mHaveEnded) {
            this.mHaveEnded = true;
            this.mLastFramePicture = getCurrentBitmap();
            stopPlayer();
            releasePlayer();
            getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    IMPlayerEndListener iMPlayerEndListener = ImageViewVideoPlayer.this.mPlayerEndListener;
                    if (iMPlayerEndListener != null) {
                        iMPlayerEndListener.onPlayerEnd();
                    }
                }
            });
        }
    }

    private void initUI(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        URLImageView uRLImageView = new URLImageView(context);
        this.mPlayer = uRLImageView;
        super.addView(uRLImageView, layoutParams);
        PlayerProgressBar playerProgressBar = new PlayerProgressBar(context);
        this.mProgressBar = playerProgressBar;
        super.addView(playerProgressBar, layoutParams);
        super.setVisibility(8);
        this.mPlayerState = 1;
    }

    public boolean checkVideoSourceValidate(RMVideoStateMgr rMVideoStateMgr) {
        return rMVideoStateMgr.h(11);
    }

    public Bitmap getCurrentBitmap() {
        VideoDrawable videoDrawable = this.mVideoDrawable;
        if (videoDrawable != null) {
            return videoDrawable.getCurrentBitmap();
        }
        return null;
    }

    public int getVFileAndAFile(String str) {
        if (str == null) {
            return -4;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getVFileAndAFile(), files = null");
                }
                return -1;
            }
            String str2 = file.getAbsolutePath() + File.separator;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getVFileAndAFile(), sourceDirFile =" + file.getAbsolutePath() + ",files = " + Arrays.toString(list) + ", file count = " + file.listFiles().length);
            }
            for (String str3 : list) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getVFileAndAFile(), current file = " + str3);
                }
                if (str3.endsWith(".af")) {
                    this.mAFile = str2 + str3;
                }
                if (str3.endsWith(".vf")) {
                    if (d.o(str2 + str3) > 0) {
                        this.mVFile = str2 + str3;
                    }
                }
            }
            String str4 = this.mVFile;
            if (str4 != null && !"".equals(str4)) {
                String str5 = this.mAFile;
                if (str5 != null && !"".equals(str5)) {
                    this.mNeedPlayAudio = false;
                    if (d.o(this.mAFile) > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "getVFileAndAFile(), mNeedPlayAudio = " + this.mNeedPlayAudio);
                        }
                        this.mNeedPlayAudio = true;
                    }
                    return 0;
                }
                return -2;
            }
            return -3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getVFileAndAFile(), videoDir not exist");
        }
        return -1;
    }

    public String getmAFile() {
        return this.mAFile;
    }

    public boolean initEditPlayer(int i3, int i16, int i17, String str, String str2, String str3) {
        this.mSecurityChecked = true;
        this.mAFile = str2;
        this.mVFile = str3;
        return initPlayer(i3, i16, i17, str, false);
    }

    public boolean initPlayer(int i3, int i16, int i17, String str) {
        return initPlayer(i3, i16, i17, str, true);
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        checkAndGetVideoDrawable();
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
        checkAndGetVideoDrawable();
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
        checkAndGetVideoDrawable();
        VideoDrawable videoDrawable = this.mVideoDrawable;
        if (videoDrawable != null) {
            videoDrawable.setOnPlayRepeatListener(this);
            this.mVideoDrawable.setOnPlayerOneFrameListener(this);
            if (!this.mRequireAudioFocus) {
                this.mVideoDrawable.disableRequireAudioFocus();
            }
        }
    }

    @Override // com.tencent.image.VideoDrawable.OnPlayRepeatListener
    public void onPlayRepeat(final int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onPlayRepeat: repeatTimes= " + i3);
        }
        if (!this.mEnableCyclePlay) {
            if (this.mNeedProgress) {
                this.mProgressBar.setCurrentProgress(this.mCurrentPlayedFrame, true);
            }
            endFramePlay();
        } else {
            this.mCurrentPlayedFrame = 0;
            getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewVideoPlayer.this.mVideoDrawable != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ImageViewVideoPlayer.this.mVideoDrawable.resetAndPlayAudioOnce();
                        if (QLog.isColorLevel()) {
                            QLog.i(ImageViewVideoPlayer.TAG, 2, "onPlayRepeat: repeatTimes = " + i3 + ", costTime = " + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        IMPlayerEndListener iMPlayerEndListener = ImageViewVideoPlayer.this.mPlayerEndListener;
                        if (iMPlayerEndListener != null) {
                            iMPlayerEndListener.onPlayerRecyle();
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.image.VideoDrawable.OnPlayerOneFrameListener
    public void oneFrameDrawed() {
        boolean z16 = true;
        int i3 = this.mCurrentPlayedFrame + 1;
        this.mCurrentPlayedFrame = i3;
        if (i3 < this.mTotalFrame) {
            z16 = false;
        }
        if (this.mNeedProgress) {
            this.mProgressBar.setCurrentProgress(i3, z16);
        }
        if (z16 && !this.mEnableCyclePlay) {
            endFramePlay();
        }
        IMPFrameListener iMPFrameListener = this.mFrameListener;
        if (iMPFrameListener != null) {
            iMPFrameListener.onCurrentFrame(this.mCurrentPlayedFrame);
        }
    }

    public void releasePlayer() {
        VideoDrawable videoDrawable = this.mVideoDrawable;
        if (videoDrawable != null) {
            videoDrawable.enableGlobalPause();
            this.mVideoDrawable.removeOnPlayRepeatListener(this);
            this.mVideoDrawable.setOnPlayRepeatListener(null);
        }
        this.mUrlDrawable = null;
        this.mTotalFrame = 0;
        this.mCurrentPlayedFrame = 0;
        this.mPlayerState = 1;
    }

    public void resetPlay() {
        VideoDrawable videoDrawable = this.mVideoDrawable;
        if (videoDrawable != null) {
            videoDrawable.resetPlay();
        }
    }

    public void setCyclePlay(boolean z16) {
        this.mEnableCyclePlay = z16;
    }

    public void setIMPFrameListener(IMPFrameListener iMPFrameListener) {
        this.mFrameListener = iMPFrameListener;
    }

    public void setIMPlayerEndListener(IMPlayerEndListener iMPlayerEndListener) {
        this.mPlayerEndListener = iMPlayerEndListener;
    }

    public void setNeedPlayAudio(boolean z16) {
        this.mNeedPlayAudio = z16;
    }

    public void startPlayer() {
        super.setVisibility(0);
        URLImageView uRLImageView = this.mPlayer;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(this.mUrlDrawable);
        }
        this.mPlayerState = 3;
    }

    public void stopPlayer() {
        VideoDrawable videoDrawable;
        if (this.mUrlDrawable != null && (videoDrawable = this.mVideoDrawable) != null) {
            videoDrawable.stopAudio();
        }
        Handler handler = super.getHandler();
        if (handler != null) {
            handler.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    IMPlayerEndListener iMPlayerEndListener = ImageViewVideoPlayer.this.mPlayerEndListener;
                    if (iMPlayerEndListener != null) {
                        iMPlayerEndListener.onDrawLastFrameEnd();
                    }
                    ImageViewVideoPlayer.this.setVisibility(8);
                }
            });
        }
        this.mPlayerState = 4;
    }

    public void updateUISize(int i3, int i16, boolean z16, int i17) {
        this.mPlayer.setLayoutParams(new LinearLayout.LayoutParams(i3, i16));
        this.mNeedProgress = z16;
        if (z16) {
            this.mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(i3, i17));
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }

    public boolean initPlayer(int i3, int i16, int i17, String str, boolean z16) {
        if (!this.mSecurityChecked && getVFileAndAFile(str) != 0) {
            return false;
        }
        this.mVideoDrawable = null;
        this.mSecurityChecked = false;
        this.mLastFramePicture = null;
        this.mTotalFrame = i17 - 3;
        if (this.mNeedProgress) {
            PlayerProgressBar playerProgressBar = this.mProgressBar;
            playerProgressBar.f288282d = i3;
            playerProgressBar.f288283e = i16;
            playerProgressBar.f288284f = i17;
            playerProgressBar.setCurrentProgress(0, false);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = null;
        obtain.mLoadingDrawable = sLoading;
        BitmapDrawable bitmapDrawable = this.mLoadingBitmap;
        if (bitmapDrawable != null) {
            obtain.mLoadingDrawable = bitmapDrawable;
        }
        VideoDrawable.VideoDrawableParams videoDrawableParams = new VideoDrawable.VideoDrawableParams();
        videoDrawableParams.mVideoRoundCorner = 0;
        videoDrawableParams.mRequestedFPS = -1;
        videoDrawableParams.mEnableAntiAlias = true;
        videoDrawableParams.mEnableFilter = true;
        videoDrawableParams.mPlayAudioFrame = this.mNeedPlayAudio;
        videoDrawableParams.mPlayVideoFrame = true;
        videoDrawableParams.mDecodeType = 1;
        videoDrawableParams.mAfPath = this.mAFile;
        videoDrawableParams.mVfPath = this.mVFile;
        videoDrawableParams.mTotalTime = i16;
        videoDrawableParams.mVideoFrames = i17;
        obtain.mExtraInfo = videoDrawableParams;
        if (!this.mEnableCyclePlay || !z16) {
            obtain.mUseMemoryCache = false;
        }
        this.mUrlDrawable = URLDrawable.getDrawable(new File(this.mVFile), obtain);
        this.mPlayer.setURLDrawableDownListener(this);
        checkAndGetVideoDrawable();
        VideoDrawable videoDrawable = this.mVideoDrawable;
        if (videoDrawable != null) {
            videoDrawable.setOnPlayRepeatListener(this);
            this.mVideoDrawable.setOnPlayerOneFrameListener(this);
            if (!this.mEnableCyclePlay) {
                this.mVideoDrawable.resetAndPlayAudioOnce();
            }
        }
        this.mPlayerState = 2;
        this.mHaveEnded = false;
        return true;
    }

    public void updateUISize(int i3, int i16, float f16, boolean z16, int i17) {
        int i18 = (int) (i3 * f16);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateUISize width" + i3 + "height" + i18 + "screenHeight=" + i16);
        }
        if (i18 >= i16) {
            i16 = i18;
        }
        this.mPlayer.setLayoutParams(new LinearLayout.LayoutParams(i3, i16));
        this.mNeedProgress = z16;
        if (z16) {
            this.mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(i3, i17));
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void updateUISize(int i3, float f16, boolean z16, int i16) {
        this.mPlayer.setLayoutParams(new LinearLayout.LayoutParams(i3, (int) (i3 * f16)));
        this.mNeedProgress = z16;
        if (z16) {
            this.mProgressBar.setLayoutParams(new LinearLayout.LayoutParams(i3, i16));
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }

    public ImageViewVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPlayerState = 1;
        this.mHaveEnded = false;
        this.mTotalFrame = 0;
        this.mCurrentPlayedFrame = 0;
        this.mEnableCyclePlay = false;
        this.mNeedProgress = true;
        this.mVideoDrawable = null;
        this.mUrlDrawable = null;
        this.mPlayerEndListener = null;
        this.mFrameListener = null;
        this.mSecurityChecked = false;
        this.mLastFramePicture = null;
        this.mLoadingBitmap = null;
        this.mRequireAudioFocus = true;
        this.mNeedPlayAudio = false;
        this.mVFile = null;
        this.mAFile = null;
        initUI(context);
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
    }

    @Override // com.tencent.image.URLDrawableDownListener
    public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
    }
}
