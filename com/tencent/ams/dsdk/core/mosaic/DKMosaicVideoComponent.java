package com.tencent.ams.dsdk.core.mosaic;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKCustomAbilityProvider;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.DKDefaultVideoView;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dsdk.view.video.DKVideoPlayerCreator;
import com.tencent.ams.dsdk.view.video.VideoLoader;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.video.VideoComponent;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicVideoComponent extends BasicComponent implements VideoComponent, DKVideoPlayer.OnVideoPlayListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicVideoComponent";
    private final Context mContext;
    private JSFunction mPlayListener;

    @NonNull
    private DKVideoPlayer mPlayer;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayEventType {
        public static final int PLAY_COMPLETE = 2;
        public static final int PLAY_ERROR = 3;
        public static final int PLAY_PAUSE = 4;
        public static final int PLAY_START = 1;
    }

    public DKMosaicVideoComponent(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mContext = context;
        }
    }

    private void callbackJsPlayEvent(int i3, int i16) {
        if (this.mPlayListener != null) {
            getJSEngine().u(this.mPlayListener, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DKVideoPlayer createPlayer(Context context, VideoLoader videoLoader) {
        DKVideoPlayer createPlayer;
        DKVideoPlayerCreator playerCreator = DKConfiguration.getPlayerCreator();
        if (playerCreator != null) {
            try {
                createPlayer = playerCreator.createPlayer();
            } catch (Throwable th5) {
                DLog.e(TAG, "create outside video player error.", th5);
            }
            if (createPlayer != null) {
                DLog.d(TAG, "create default video player.");
                return new DKDefaultVideoView(context, videoLoader);
            }
            return createPlayer;
        }
        createPlayer = null;
        if (createPlayer != null) {
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mPlayer.getCurrentPosition();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mPlayer.getDuration();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mPlayer.getView();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public boolean isFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mPlayer.isPlaying();
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onEnded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        DLog.d(TAG, "onEnded");
        if (this.mPlayListener != null) {
            callbackJsPlayEvent(2, 0);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) str);
            return;
        }
        DLog.d(TAG, "onError what:" + i3 + ", extra:" + str);
        if (this.mPlayListener != null) {
            callbackJsPlayEvent(3, i3);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        DLog.d(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (this.mPlayListener != null) {
            callbackJsPlayEvent(4, 0);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        DLog.d(TAG, "onPlay");
        if (this.mPlayListener != null) {
            callbackJsPlayEvent(1, 0);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            DLog.d(TAG, "onReady");
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onSeeked(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        DLog.d(TAG, "onSeeked: " + i3);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onSeeking(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
            return;
        }
        DLog.d(TAG, "onSeeking: " + i3);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onTimeUpdate(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        DLog.d(TAG, "onTimeUpdate currentTime:" + i3 + ", duration:" + i16);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onVolumeChange(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Float.valueOf(f16));
            return;
        }
        DLog.d(TAG, "onVolumeChange: " + f16);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
    public void onWaiting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            DLog.d(TAG, "onWaiting");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            DLog.d(TAG, "pause");
            this.mPlayer.pause();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        f.e(TAG, "seekTo: " + i3);
        this.mPlayer.seekTo(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        DLog.d(TAG, "setAutoPlay: " + z16);
        this.mPlayer.setAutoPlay(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setControllerVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setFullScreen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setFullScreenMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        VideoLoader videoLoader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        super.setJSEngine(aVar);
        DKMosaicEngine dKMosaicEngine = DKMosaicEngine.getDKMosaicEngine(aVar);
        DKVideoPlayer dKVideoPlayer = null;
        if (dKMosaicEngine != null) {
            DKCustomAbilityProvider customAbilityProvider = dKMosaicEngine.getCustomAbilityProvider();
            if (customAbilityProvider != null) {
                dKVideoPlayer = customAbilityProvider.getDKVideoPlayer(this.mContext);
            }
            videoLoader = dKMosaicEngine.getVideoLoader();
        } else {
            videoLoader = null;
        }
        if (dKVideoPlayer != null) {
            this.mPlayer = dKVideoPlayer;
        } else {
            this.mPlayer = createPlayer(this.mContext, videoLoader);
        }
        this.mPlayer.setVideoPlayListener(this);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        DLog.d(TAG, "setLoop: " + z16);
        this.mPlayer.setLoop(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setOutputMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        DLog.d(TAG, "setOutputMute: " + z16);
        this.mPlayer.setMute(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPlayListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSFunction);
        } else {
            this.mPlayListener = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPlayerEventListener(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) jSObject);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPoster(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPosterData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setScaleType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        DLog.d(TAG, "setScaleType: " + str);
        if ("centerCrop".equals(str)) {
            this.mPlayer.setObjectFit(DKVideoPlayer.ObjectFit.COVER);
        } else if ("fitCenter".equals(str)) {
            this.mPlayer.setObjectFit(DKVideoPlayer.ObjectFit.CONTAIN);
        } else {
            this.mPlayer.setObjectFit(DKVideoPlayer.ObjectFit.FILL);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setVideoParams(String str) {
        JSONObject jSONObject;
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        DLog.d(TAG, "setVideoParams: " + str);
        try {
            jSONObject = new JSONObject(str);
            optString = jSONObject.optString("src");
        } catch (Exception e16) {
            f.i(TAG, "setVideoParams failed", e16);
        }
        if (!TextUtils.isEmpty(optString)) {
            this.mPlayer.setVideoPath(optString);
            return;
        }
        String optString2 = jSONObject.optString("vid");
        if (!TextUtils.isEmpty(optString2)) {
            this.mPlayer.setVid(optString2);
            return;
        }
        f.h(TAG, "setVideoParams failed: invalid videoParams: " + str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        DLog.i(TAG, "setVolume, volume: " + i3);
        if (i3 >= 0 && i3 <= 100) {
            DKVideoPlayer dKVideoPlayer = this.mPlayer;
            if (dKVideoPlayer != null) {
                dKVideoPlayer.setVolume(i3 / 100.0f);
                return;
            }
            return;
        }
        DLog.w(TAG, "invalid volume value.");
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            DLog.d(TAG, "start");
            this.mPlayer.start();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            DLog.d(TAG, "stop");
            this.mPlayer.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }
}
