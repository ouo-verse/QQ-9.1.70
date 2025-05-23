package com.tencent.ams.dsdk.view.video;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKCustomAbilityProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.DKHippyViewEvent;
import com.tencent.ams.dsdk.core.hippy.DKEngineInstanceManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.reflect.Constructor;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKVideoView extends FrameLayout implements HippyViewBase {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKVideoView";
    private NativeGestureDispatcher mGestureDispatcher;
    private String videoPath;
    private DKVideoPlayer videoPlayer;

    public DKVideoView(Context context, int i3) {
        super(context);
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        DKVideoPlayer createPlayer = createPlayer(context, i3);
        this.videoPlayer = createPlayer;
        if (createPlayer == null) {
            DLog.i(TAG, "videoPlayer = null.");
            return;
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer == null) {
            view = null;
        } else {
            view = dKVideoPlayer.getView();
        }
        if (view != null) {
            addView(view, layoutParams);
        }
        this.videoPlayer.setVideoPlayListener(new DKVideoPlayer.OnVideoPlayListener() { // from class: com.tencent.ams.dsdk.view.video.DKVideoView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKVideoView.this);
                }
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onEnded() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                } else {
                    new DKHippyViewEvent("onEnded").send(DKVideoView.this, null);
                }
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onError(int i16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, i16, (Object) str);
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("errorCode", i16);
                hippyMap.pushString("errorInfo", str);
                new DKHippyViewEvent("onError").send(DKVideoView.this, hippyMap);
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onPause() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                } else {
                    new DKHippyViewEvent(MiniSDKConst.NOTIFY_EVENT_ONPAUSE).send(DKVideoView.this, null);
                }
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onPlay() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                } else {
                    new DKHippyViewEvent("onPlay").send(DKVideoView.this, null);
                }
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onReady() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    new DKHippyViewEvent("onReady").send(DKVideoView.this, null);
                }
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onSeeked(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 10)) {
                    iPatchRedirector2.redirect((short) 10, (Object) this, i16);
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble("position", DKVideoView.this.transferToSec(i16));
                new DKHippyViewEvent("onSeeked").send(DKVideoView.this, hippyMap);
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onSeeking(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 11)) {
                    iPatchRedirector2.redirect((short) 11, (Object) this, i16);
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble("position", DKVideoView.this.transferToSec(i16));
                new DKHippyViewEvent("onSeeking").send(DKVideoView.this, hippyMap);
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onTimeUpdate(int i16, int i17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Integer.valueOf(i16), Integer.valueOf(i17));
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, DKVideoView.this.transferToSec(i16));
                hippyMap.pushDouble("duration", DKVideoView.this.transferToSec(i17));
                new DKHippyViewEvent("onTimeUpdate").send(DKVideoView.this, hippyMap);
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onVolumeChange(float f16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, this, Float.valueOf(f16));
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, f16);
                new DKHippyViewEvent("onVolumeChange").send(DKVideoView.this, hippyMap);
            }

            @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer.OnVideoPlayListener
            public void onWaiting() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                    iPatchRedirector2.redirect((short) 9, (Object) this);
                } else {
                    new DKHippyViewEvent("onWaiting").send(DKVideoView.this, null);
                }
            }
        });
    }

    private DKVideoPlayer createDefaultVideoPlayer(Context context, VideoLoader videoLoader) {
        DLog.d(TAG, "create default video player.");
        return new DKDefaultVideoView(context, videoLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double transferToSec(int i3) {
        return i3 / 1000.0d;
    }

    protected DKVideoPlayer createPlayer(Context context, int i3) {
        VideoLoader videoLoader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKVideoPlayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
        DKEngine engine = DKEngineInstanceManager.getEngine(i3);
        DKVideoPlayer dKVideoPlayer = null;
        if (engine != null) {
            DKCustomAbilityProvider customAbilityProvider = engine.getCustomAbilityProvider();
            if (customAbilityProvider != null) {
                DLog.i(TAG, "use engine provider video player.");
                dKVideoPlayer = customAbilityProvider.getDKVideoPlayer(context);
            }
            videoLoader = engine.getVideoLoader();
        } else {
            videoLoader = null;
        }
        if (dKVideoPlayer == null) {
            DLog.i(TAG, "use global video player provider.");
            dKVideoPlayer = createPlayer(context);
        }
        return dKVideoPlayer == null ? createDefaultVideoPlayer(context, videoLoader) : dKVideoPlayer;
    }

    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            return dKVideoPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            return dKVideoPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (NativeGestureDispatcher) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mGestureDispatcher;
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            return dKVideoPlayer.isPlaying();
        }
        return false;
    }

    public void load() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setVideoPath(this.videoPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            DLog.i(TAG, NodeProps.ON_ATTACHED_TO_WINDOW);
            super.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroy() {
        DLog.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.onDestroy();
            this.videoPlayer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            DLog.i(TAG, NodeProps.ON_DETACHED_FROM_WINDOW);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher = this.mGestureDispatcher;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.pause();
        }
    }

    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.seekTo(i3);
        }
    }

    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setAutoPlay(z16);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) nativeGestureDispatcher);
        } else {
            this.mGestureDispatcher = nativeGestureDispatcher;
        }
    }

    public void setLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setLoop(z16);
        }
    }

    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setMute(z16);
        }
    }

    public void setObjectFit(DKVideoPlayer.ObjectFit objectFit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) objectFit);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setObjectFit(objectFit);
        }
    }

    public void setVideoParams(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) jSONObject);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setVideoParams(jSONObject);
        }
    }

    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        this.videoPath = str;
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setVideoPath(str);
        }
    }

    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.setVolume(f16);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.start();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        DKVideoPlayer dKVideoPlayer = this.videoPlayer;
        if (dKVideoPlayer != null) {
            dKVideoPlayer.stop();
        }
    }

    protected DKVideoPlayer createPlayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DKVideoPlayer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Class<? extends DKVideoPlayer> playerClass = DKConfiguration.getPlayerClass();
        if (playerClass == null) {
            return null;
        }
        try {
            Constructor<? extends DKVideoPlayer> constructor = playerClass.getConstructor(Context.class);
            if (constructor != null) {
                return constructor.newInstance(context);
            }
            return null;
        } catch (Throwable th5) {
            DLog.e(TAG, "create outside video player error.", th5);
            return null;
        }
    }
}
