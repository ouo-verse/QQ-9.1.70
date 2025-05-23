package com.tencent.hippy.qq.view.video;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.Window;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.hippy.qq.view.video.HippyQQVideoView;
import com.tencent.mobileqq.kandian.base.video.player.f;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import f62.a;
import f62.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HVideoDelegate implements HippyQQVideoView.OnVideoViewControlListener, IVideoVolumeController.a, f {
    private static final int CODE_VIDEO_ERROR = 101;
    private static final String RESIZE_CONTAIN = "contain";
    private static final String RESIZE_COVER = "cover";
    private static final String TAG = "VVideoControlListenerImpl";
    protected Activity mActivity;
    private int mOriginSystemUIVisibility;
    a mPlayer;
    private long mStartPosition;

    @Nullable
    private VideoInfo mVideoInfo;
    protected HippyQQVideoView mVideoView;
    private int mMaxVolume = -1;
    private boolean mCoverFrame = false;
    private boolean mIsShowingFull = false;

    public HVideoDelegate(Activity activity, HippyQQVideoView hippyQQVideoView, int i3) {
        this.mPlayer = ((IReadInJoyPlayerFactory) QRoute.api(IReadInJoyPlayerFactory.class)).createPlayer(i3);
        this.mVideoView = hippyQQVideoView;
        this.mActivity = activity;
        ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).inKandianModule(activity);
        ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).addEventListener(this);
        this.mPlayer.i(this);
        this.mPlayer.h(hippyQQVideoView);
    }

    private void callJsStateChange(int i3, HippyMap hippyMap) {
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushInt("state", i3);
        if (hippyMap != null) {
            hippyMap2.pushMap("message", hippyMap);
        }
        HippyMap hippyMap3 = new HippyMap();
        hippyMap3.pushInt("width", this.mPlayer.getVideoWidth());
        hippyMap3.pushInt("height", this.mPlayer.getVideoHeight());
        hippyMap2.pushMap(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, hippyMap3);
        this.mVideoView.videoViewFireEvent("stateChange", hippyMap2);
    }

    private int getVideoState() {
        int currentState = this.mPlayer.getCurrentState();
        if (currentState != 0) {
            if (currentState == 1 || currentState == 2) {
                return 1;
            }
            if (currentState == 3) {
                return 2;
            }
            if (currentState == 4) {
                return 3;
            }
            if (currentState == 5) {
                return 4;
            }
            if (currentState != 7) {
                return 6;
            }
        }
        return 5;
    }

    private void onOrientationChanged() {
        if (this.mIsShowingFull) {
            try {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("hasUI", 0);
                this.mVideoView.videoViewFireEvent("didEnterFullScreen", hippyMap);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "initChangeFullScreenAnim onAnimationEnd error = : " + e16.getMessage());
                    return;
                }
                return;
            }
        }
        this.mVideoView.videoViewFireEvent("didExitFullScreen", null);
    }

    public static final int parseTimeToSeconds(long j3) {
        if (j3 >= 500) {
            return (int) ((j3 / 1000) + 0.5d);
        }
        return 0;
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void afterChangeFullScreen(HippyQQVideoView hippyQQVideoView) {
        this.mPlayer.j();
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void beforeChangeFullScreen(HippyQQVideoView hippyQQVideoView) {
        this.mPlayer.n();
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void enterFullScreen(int i3, HippyQQVideoView hippyQQVideoView, boolean z16, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deal enterFullScreen: ");
        }
        this.mIsShowingFull = true;
        if (!z16) {
            if (i3 == 0) {
                this.mActivity.setRequestedOrientation(0);
            } else {
                this.mActivity.setRequestedOrientation(8);
            }
        }
        Activity activity = this.mActivity;
        Window window = activity.getWindow();
        this.mOriginSystemUIVisibility = window.getDecorView().getSystemUiVisibility();
        if (z16) {
            window.setFlags(1024, 1024);
            ((IVideoFeedsHelper) QRoute.api(IVideoFeedsHelper.class)).hideNavigationBar(this.mActivity);
        } else {
            ((IVideoFeedsHelper) QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(activity);
        }
        onOrientationChanged();
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean("hasUI", false);
            promise.resolve(hippyMap);
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void exitFullScreen(HippyQQVideoView hippyQQVideoView, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deal exitFullScreen: ");
        }
        this.mIsShowingFull = false;
        this.mActivity.setRequestedOrientation(1);
        this.mActivity.setRequestedOrientation(1);
        Window window = this.mActivity.getWindow();
        window.getDecorView().setSystemUiVisibility(this.mOriginSystemUIVisibility);
        window.clearFlags(1024);
        onOrientationChanged();
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean("hasUI", false);
            promise.resolve(hippyMap);
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void getPlayInfo(HippyQQVideoView hippyQQVideoView, Promise promise) {
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("state", getVideoState());
            hippyMap.pushInt(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, parseTimeToSeconds(this.mPlayer.getCurrentPosition()));
            hippyMap.pushDouble("totalTime", this.mPlayer.getDuration() / 1000);
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushInt("width", this.mPlayer.getVideoWidth());
            hippyMap2.pushInt("height", this.mPlayer.getVideoHeight());
            hippyMap.pushMap(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, hippyMap2);
            promise.resolve(hippyMap);
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public boolean isFullScreen() {
        return this.mIsShowingFull;
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void onActivityDestroy() {
        this.mPlayer.onDestroy();
        ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).outKandianModule(this.mActivity);
        ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).removeEventListener(this);
        this.mActivity = null;
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void onActivityPause() {
        this.mPlayer.onPause();
        ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).requestOrAbandonAudioFocus(false, "viola video");
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void onActivityResume() {
        this.mPlayer.onResume();
        ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).requestOrAbandonAudioFocus(true, "viola video");
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onBufferEnd() {
        if (this.mPlayer.isPlaying()) {
            callJsStateChange(2, null);
        } else if (this.mPlayer.b()) {
            callJsStateChange(4, null);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onBufferStart() {
        callJsStateChange(3, null);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onCompletion() {
        callJsStateChange(5, null);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.a
    public void onHeadsetStateChanged(boolean z16) {
        this.mPlayer.setMute(!z16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.a
    public void onPhoneCome() {
        this.mPlayer.pause();
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onProgressChanged(long j3) {
        try {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushObject(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, Integer.valueOf(parseTimeToSeconds(j3)));
            hippyMap.pushObject("totalTime", Long.valueOf(this.mPlayer.getDuration() / 1000));
            this.mVideoView.videoViewFireEvent("playTimeChange", hippyMap);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.a
    public void onSystemVolumeChanged(int i3) {
        boolean z16;
        a aVar = this.mPlayer;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.setMute(z16);
        try {
            HippyMap hippyMap = new HippyMap();
            if (this.mMaxVolume == -1) {
                this.mMaxVolume = ((IVideoVolumeController) QRoute.api(IVideoVolumeController.class)).getStreamMaxVolume(3);
            }
            hippyMap.pushObject("value", Float.valueOf(i3 / this.mMaxVolume));
            this.mVideoView.videoViewFireEvent("volumeChange", hippyMap);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoEnd(int i3) {
        callJsStateChange(5, null);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoError(int i3, int i16, String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("code", 101);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushString("code", i3 + "-" + i16);
        hippyMap2.pushString("msg", str);
        hippyMap.pushMap("extra", hippyMap2);
        callJsStateChange(6, hippyMap);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoPause() {
        callJsStateChange(4, null);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoPrepared() {
        callJsStateChange(1, null);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoRestart() {
        callJsStateChange(2, null);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoStart() {
        callJsStateChange(2, null);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoStop() {
        callJsStateChange(7, null);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void open(HippyQQVideoView hippyQQVideoView, JSONObject jSONObject) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "open: " + jSONObject);
        }
        try {
            boolean optBoolean = jSONObject.optBoolean("autoplay", true);
            boolean optBoolean2 = jSONObject.optBoolean("autoPreplay", false);
            setResize(hippyQQVideoView, jSONObject.optString("resize"));
            setTimeInterval(hippyQQVideoView, jSONObject.optInt("timeupdateRate"));
            setEndWithLastFrame(jSONObject.optBoolean("endWithLastFrame"));
            this.mCoverFrame = jSONObject.optBoolean("cover_frame", false);
            this.mStartPosition = jSONObject.optLong("start_position", 0L) * 1000;
            this.mVideoInfo = new VideoInfo(jSONObject.getJSONObject("video_info"));
            this.mPlayer.setMute(jSONObject.optBoolean("muted", false));
            if (optBoolean) {
                a aVar = this.mPlayer;
                VideoInfo videoInfo = this.mVideoInfo;
                aVar.k(videoInfo.busiType, videoInfo.vid, videoInfo.videoUrl, this.mStartPosition, videoInfo.duration);
            } else if (optBoolean2) {
                preplay(null);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void pause(HippyQQVideoView hippyQQVideoView) {
        this.mPlayer.pause();
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void play(HippyQQVideoView hippyQQVideoView) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "play: status=" + this.mPlayer.getCurrentState() + ", isPreload=" + this.mPlayer.c() + ", videoinfo=" + this.mVideoInfo + ", mStartPosition:" + this.mStartPosition);
        }
        if (this.mVideoInfo != null && this.mPlayer.c()) {
            a aVar = this.mPlayer;
            VideoInfo videoInfo = this.mVideoInfo;
            aVar.k(videoInfo.busiType, videoInfo.vid, videoInfo.videoUrl, this.mStartPosition, videoInfo.duration);
        } else {
            if (this.mPlayer.g()) {
                this.mPlayer.start();
                return;
            }
            VideoInfo videoInfo2 = this.mVideoInfo;
            if (videoInfo2 != null) {
                this.mPlayer.k(videoInfo2.busiType, videoInfo2.vid, videoInfo2.videoUrl, this.mStartPosition, videoInfo2.duration);
            }
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void preplay(HippyQQVideoView hippyQQVideoView) {
        if (this.mVideoInfo != null && !this.mPlayer.c()) {
            this.mPlayer.m(this.mCoverFrame);
            a aVar = this.mPlayer;
            VideoInfo videoInfo = this.mVideoInfo;
            aVar.k(videoInfo.busiType, videoInfo.vid, videoInfo.videoUrl, this.mStartPosition, videoInfo.duration);
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void replay(HippyQQVideoView hippyQQVideoView) {
        this.mPlayer.stop();
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo != null) {
            this.mPlayer.k(videoInfo.busiType, videoInfo.vid, videoInfo.videoUrl, this.mStartPosition, videoInfo.duration);
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void resetSrc(HippyQQVideoView hippyQQVideoView, JSONObject jSONObject) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resetSrc: " + jSONObject);
        }
        this.mPlayer.stop();
        open(hippyQQVideoView, jSONObject);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void seek(HippyQQVideoView hippyQQVideoView, int i3) {
        this.mPlayer.seekTo(i3);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void setEndWithLastFrame(boolean z16) {
        this.mPlayer.d(z16);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void setLoopBack(boolean z16) {
        this.mPlayer.setLoopback(z16);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void setMuted(HippyQQVideoView hippyQQVideoView, boolean z16) {
        this.mPlayer.setMute(z16);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void setResize(HippyQQVideoView hippyQQVideoView, String str) {
        if (str.equals("contain")) {
            this.mPlayer.setXYaxis(0);
        } else if (str.equals("cover")) {
            this.mPlayer.setXYaxis(2);
        }
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void setStartPosition(int i3) {
        this.mStartPosition = i3 * 1000;
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void setTimeInterval(HippyQQVideoView hippyQQVideoView, int i3) {
        this.mPlayer.e(i3);
    }

    public void setVideoPreDownloadMgr(b bVar) {
        this.mPlayer.f(bVar);
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void stop(HippyQQVideoView hippyQQVideoView) {
        this.mPlayer.stop();
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void beforeVideoStart() {
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void onActivityCreate() {
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void onActivityStart() {
    }

    @Override // com.tencent.hippy.qq.view.video.HippyQQVideoView.OnVideoViewControlListener
    public void onActivityStop() {
    }

    public void onDownloadFinished() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onFirstFrameRendered() {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.a
    public void onFocusGain() {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.a
    public void onFocusLoss() {
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.f
    public void onVideoOpen() {
    }
}
