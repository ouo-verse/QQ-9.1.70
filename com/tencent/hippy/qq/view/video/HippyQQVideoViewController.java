package com.tencent.hippy.qq.view.video;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.video.HippyQQVideoView;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyController(name = HippyQQVideoViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyQQVideoViewController extends HippyViewController<HippyQQVideoView> {
    public static final String CLASS_NAME = "tkdVideoView";
    private static final String TAG = "HippyVideoController";
    private String mCurrentVid;
    private String mCurrentVideoUrl;
    private HippyQQVideoView mHostView;

    private void dealFullScreen(int i3, boolean z16, Promise promise) {
        this.mHostView.enterFullScreen(0);
        getVideoViewControlListener().enterFullScreen(i3, this.mHostView, z16, promise);
    }

    public boolean consumeBackKeyEvent() {
        if (getVideoViewControlListener() == null || !getVideoViewControlListener().isFullScreen()) {
            return false;
        }
        this.mHostView.exitFullScreen(1);
        getVideoViewControlListener().exitFullScreen(this.mHostView, null);
        return true;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    public HippyQQVideoView.OnVideoViewControlListener getVideoViewControlListener() {
        HippyQQVideoView hippyQQVideoView = this.mHostView;
        if (hippyQQVideoView != null && hippyQQVideoView.getVideoViewControlListener() != null) {
            return this.mHostView.getVideoViewControlListener();
        }
        return null;
    }

    public JSONObject initCurrentVideoData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("muted", false);
            jSONObject.put("autoplay", true);
            jSONObject.put("resize", HVideoConstants.ResizeType.RESIZE_CONTAIN);
            jSONObject.put("timeupdateRate", 1000);
            jSONObject.put("disableFullScreen", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public void onActivityCreate() {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().onActivityCreate();
        }
    }

    public void onActivityDestroy() {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().onActivityDestroy();
        }
    }

    public void onActivityPause() {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().onActivityPause();
        }
    }

    public void onActivityResume() {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().onActivityResume();
        }
    }

    public void onActivityStart() {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().onActivityStart();
        }
    }

    public void onActivityStop() {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().onActivityStop();
        }
    }

    public void resetSrc(Object obj) {
        if (getVideoViewControlListener() != null) {
            JSONObject initCurrentVideoData = initCurrentVideoData();
            try {
                if ((obj instanceof String) && !this.mCurrentVideoUrl.equals(obj)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, obj);
                    initCurrentVideoData.put("video_info", jSONObject);
                    this.mCurrentVideoUrl = (String) obj;
                    getVideoViewControlListener().resetSrc(this.mHostView, initCurrentVideoData);
                } else if (obj instanceof HippyMap) {
                    HippyMap hippyMap = (HippyMap) obj;
                    String string = hippyMap.getString("vid");
                    if (!this.mCurrentVid.equals(string)) {
                        initCurrentVideoData.put("video_info", hippyMap.toJSONObject());
                        this.mCurrentVid = string;
                        getVideoViewControlListener().resetSrc(this.mHostView, initCurrentVideoData);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "setSrc error :" + e16.getMessage());
            }
        }
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "endWithLastFrame")
    public void setEndWithLastFrame(HippyQQVideoView hippyQQVideoView, boolean z16) {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().setEndWithLastFrame(z16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "muted")
    public void setMuted(HippyQQVideoView hippyQQVideoView, boolean z16) {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().setMuted(hippyQQVideoView, z16);
        }
    }

    @HippyControllerProps(defaultString = HVideoConstants.ResizeType.RESIZE_CONTAIN, defaultType = HippyControllerProps.STRING, name = "resize")
    public void setResize(HippyQQVideoView hippyQQVideoView, String str) {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().setResize(hippyQQVideoView, str);
        }
    }

    @HippyControllerProps(defaultNumber = 1000.0d, defaultType = "number", name = MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL)
    public void setTimeInterval(HippyQQVideoView hippyQQVideoView, int i3) {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().setTimeInterval(hippyQQVideoView, i3);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "start_position")
    public void setstartPosition(HippyQQVideoView hippyQQVideoView, int i3) {
        if (getVideoViewControlListener() != null) {
            getVideoViewControlListener().setStartPosition(i3);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyQQVideoView hippyQQVideoView = new HippyQQVideoView(context);
        this.mHostView = hippyQQVideoView;
        hippyQQVideoView.initView();
        if (hippyMap != null) {
            try {
                JSONObject initDefaultVideoData = VVideoInit.initDefaultVideoData();
                for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                    String key = entry.getKey();
                    if ("src".equals(key)) {
                        if (entry.getValue() instanceof String) {
                            JSONObject jSONObject = new JSONObject();
                            this.mCurrentVideoUrl = (String) entry.getValue();
                            jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, entry.getValue());
                            initDefaultVideoData.put("video_info", jSONObject);
                        } else if (entry.getValue() instanceof HippyMap) {
                            HippyMap hippyMap2 = (HippyMap) entry.getValue();
                            this.mCurrentVid = hippyMap2.getString("vid");
                            initDefaultVideoData.put("video_info", hippyMap2.toJSONObject());
                        }
                    } else if (MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL.equals(key)) {
                        initDefaultVideoData.put("timeupdateRate", entry.getValue());
                    } else if ("autoPlay".equals(key)) {
                        initDefaultVideoData.put("autoplay", entry.getValue());
                    } else if (entry.getValue() instanceof HippyMap) {
                        initDefaultVideoData.put(key, ((HippyMap) entry.getValue()).toJSONObject());
                    } else if (entry.getValue() instanceof HippyArray) {
                        initDefaultVideoData.put(key, ((HippyArray) entry.getValue()).toJSONArray());
                    } else {
                        initDefaultVideoData.put(key, entry.getValue());
                    }
                }
                this.mHostView.getVideoViewControlListener().open(this.mHostView, initDefaultVideoData);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return this.mHostView;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyQQVideoView hippyQQVideoView, String str, HippyArray hippyArray) {
        if (getVideoViewControlListener() != null) {
            if ("preplay".equals(str)) {
                getVideoViewControlListener().preplay(hippyQQVideoView);
                return;
            }
            if ("play".equals(str)) {
                getVideoViewControlListener().play(hippyQQVideoView);
                return;
            }
            if ("pause".equals(str)) {
                getVideoViewControlListener().pause(hippyQQVideoView);
                return;
            }
            if ("stop".equals(str)) {
                getVideoViewControlListener().stop(hippyQQVideoView);
                return;
            }
            if ("replay".equals(str)) {
                getVideoViewControlListener().replay(hippyQQVideoView);
                return;
            }
            if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(str)) {
                getVideoViewControlListener().seek(hippyQQVideoView, hippyArray.getInt(0) * 1000);
            } else if ("setLoopBack".equals(str)) {
                getVideoViewControlListener().setLoopBack(hippyArray.getBoolean(0));
            } else if ("resetSrc".equals(str)) {
                resetSrc(hippyArray.getObject(0));
            }
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyQQVideoView hippyQQVideoView, String str, HippyArray hippyArray, Promise promise) {
        if (getVideoViewControlListener() != null) {
            if ("getPlayInfo".equals(str)) {
                getVideoViewControlListener().getPlayInfo(hippyQQVideoView, promise);
                return;
            }
            if ("exitFullScreen".equals(str)) {
                hippyQQVideoView.exitFullScreen(1);
                getVideoViewControlListener().exitFullScreen(hippyQQVideoView, promise);
            } else if ("fullLandspaceScreen".equals(str)) {
                dealFullScreen(0, false, promise);
            } else if ("fullLandspaceScreenWithType".equals(str)) {
                dealFullScreen(hippyArray.getInt(0), false, promise);
            } else if ("fullPortraitScreen".equals(str)) {
                dealFullScreen(0, true, promise);
            }
        }
    }
}
