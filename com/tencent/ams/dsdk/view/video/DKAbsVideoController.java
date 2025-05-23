package com.tencent.ams.dsdk.view.video;

import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class DKAbsVideoController extends HippyViewController<DKVideoView> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKVideoViewController";
    private static final float TIME_UNIT = 1000.0f;
    int mEngineId;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface ErrorCode {
        public static final int FUNCTION_EXCEPTION = -1;
    }

    public DKAbsVideoController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mEngineId = -1;
        }
    }

    private void reject(Promise promise, int i3, String str) {
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("code", i3);
            hippyMap.pushString("message", str);
            promise.reject(hippyMap);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "autoplay")
    public void setAutoPlay(DKVideoView dKVideoView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, dKVideoView, Boolean.valueOf(z16));
            return;
        }
        DLog.d(TAG, "setAutoPlay: " + z16);
        if (dKVideoView != null) {
            dKVideoView.setAutoPlay(z16);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "loop")
    public void setLoop(DKVideoView dKVideoView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, dKVideoView, Boolean.valueOf(z16));
            return;
        }
        DLog.d(TAG, "setLoop:" + z16);
        if (dKVideoView != null) {
            dKVideoView.setLoop(z16);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = "muted")
    public void setMuted(DKVideoView dKVideoView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, dKVideoView, Boolean.valueOf(z16));
            return;
        }
        DLog.d(TAG, "setMuted:" + z16);
        if (dKVideoView != null) {
            dKVideoView.setMute(z16);
        }
    }

    @HippyControllerProps(defaultString = "inherit", defaultType = HippyControllerProps.STRING, name = "objectFit")
    public void setObjectFit(DKVideoView dKVideoView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dKVideoView, (Object) str);
            return;
        }
        DLog.d(TAG, "objectFit: " + str);
        if (dKVideoView != null) {
            DKVideoPlayer.ObjectFit objectFit = DKVideoPlayer.ObjectFit.FILL;
            if (HVideoConstants.ResizeType.RESIZE_CONTAIN.equalsIgnoreCase(str)) {
                objectFit = DKVideoPlayer.ObjectFit.CONTAIN;
            } else if ("cover".equalsIgnoreCase(str)) {
                objectFit = DKVideoPlayer.ObjectFit.COVER;
            }
            dKVideoView.setObjectFit(objectFit);
        }
    }

    @HippyControllerProps(defaultString = "", defaultType = HippyControllerProps.STRING, name = "src")
    public void setSrc(DKVideoView dKVideoView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKVideoView, (Object) str);
            return;
        }
        DLog.d(TAG, "setSrc, path: " + str);
        if (dKVideoView != null) {
            dKVideoView.setVideoPath(str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00ac, code lost:
    
        if (r13.equals("play") == false) goto L14;
     */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchFunction(DKVideoView dKVideoView, String str, HippyArray hippyArray, Promise promise) {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, dKVideoView, str, hippyArray, promise);
            return;
        }
        super.dispatchFunction((DKAbsVideoController) dKVideoView, str, hippyArray, promise);
        HippyMap map = hippyArray == null ? null : hippyArray.getMap(0);
        DLog.d(TAG, "dispatchFunction, functionName: " + str + ", view: " + dKVideoView + ", params: " + map);
        str.hashCode();
        switch (str.hashCode()) {
            case -1472517089:
                if (str.equals("setVideoParams")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1073342556:
                if (str.equals("isPlaying")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -39033168:
                if (str.equals("getCurrentTime")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3327206:
                if (str.equals("load")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3443508:
                break;
            case 3526264:
                if (str.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 85887754:
                if (str.equals("getDuration")) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            case 670514716:
                if (str.equals("setVolume")) {
                    c16 = '\t';
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                if (map != null) {
                    try {
                        JSONObject jSONObject = map.toJSONObject();
                        DLog.d(TAG, "dispatch videoParams with params:" + jSONObject);
                        if (dKVideoView != null) {
                            dKVideoView.setVideoParams(jSONObject);
                        }
                    } catch (Throwable th5) {
                        DLog.e("fail to setVideoParams", th5);
                        reject(promise, -1, th5.getMessage());
                        return;
                    }
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            case 1:
                boolean z16 = dKVideoView != null && dKVideoView.isPlaying();
                if (promise != null) {
                    promise.resolve(Boolean.valueOf(z16));
                    return;
                }
                return;
            case 2:
                if (promise != null) {
                    promise.resolve(Float.valueOf((dKVideoView != null ? dKVideoView.getCurrentPosition() : 0) / 1000.0f));
                    return;
                }
                return;
            case 3:
                if (dKVideoView != null) {
                    dKVideoView.load();
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            case 4:
                if (dKVideoView != null) {
                    dKVideoView.start();
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            case 5:
                if (map != null) {
                    double d16 = map.getDouble("position");
                    DLog.d(TAG, "dispatch seek with params:" + d16);
                    if (dKVideoView != null) {
                        dKVideoView.seekTo((int) (d16 * 1000.0d));
                    }
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            case 6:
                if (dKVideoView != null) {
                    dKVideoView.stop();
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            case 7:
                if (promise != null) {
                    promise.resolve(Float.valueOf((dKVideoView != null ? dKVideoView.getDuration() : 0) / 1000.0f));
                    return;
                }
                return;
            case '\b':
                if (dKVideoView != null) {
                    dKVideoView.pause();
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            case '\t':
                if (map != null) {
                    float f16 = (float) map.getDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                    DLog.d(TAG, "dispatch setVolume with params:" + f16);
                    if (dKVideoView != null) {
                        dKVideoView.setVolume(f16);
                    }
                }
                if (promise != null) {
                    promise.resolve(null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(DKVideoView dKVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dKVideoView);
            return;
        }
        DLog.i(TAG, "onViewDestroy, " + dKVideoView);
        super.onViewDestroy((DKAbsVideoController) dKVideoView);
        if (dKVideoView != null) {
            dKVideoView.onDestroy();
        }
    }
}
