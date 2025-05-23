package com.tencent.hippy.qq.module;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = HippyQQBridgeModule.CLASSNAME)
/* loaded from: classes7.dex */
public class HippyQQBridgeModule extends HippyNativeModuleBase {
    static final String CLASSNAME = "bridge";
    private QQBridgeModule mBridgeModule;

    public HippyQQBridgeModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        QQBridgeModule qQBridgeModule = new QQBridgeModule();
        this.mBridgeModule = qQBridgeModule;
        qQBridgeModule.setEngineId(hippyEngineContext.getEngineId());
    }

    @HippyMethod(name = "addFavorite")
    public void addFavorite(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.addFavorite(jSONObject);
    }

    @HippyMethod(name = "c2sReport")
    public void c2sReport(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.c2sReport(jSONObject);
    }

    @HippyMethod(name = "cancelUploadingVideo")
    public void cancelUploadingVideo(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.cancelUploadingVideo(jSONObject, promise);
    }

    @HippyMethod(name = "cancelVideoPreDownload")
    public void cancelVideoPreDownload() {
        this.mBridgeModule.cancelVideoPreDownload();
    }

    @HippyMethod(name = "dwellTimeMillisReport")
    public void dwellTimeMillisReport(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.dwellTimeMillisReport(jSONObject);
    }

    @HippyMethod(name = "getALDConfig")
    public void getALDConfig(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.getALDConfig(jSONObject, promise);
    }

    @HippyMethod(name = "getAllowedStateOfOperationAction")
    public void getAllowedStateOfOperationAction(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.getAllowedStateOfOperationAction(jSONObject, promise);
    }

    @HippyMethod(name = "getDeviceInfo")
    public void getDeviceInfo(Promise promise) {
        this.mBridgeModule.getDeviceInfo(promise, false);
    }

    @HippyMethod(name = "getGdtDeviceInfo")
    public void getGdtDeviceInfo(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.getGdtDeviceInfo(promise, jSONObject, true);
    }

    @HippyMethod(name = "getMotiveAd")
    public void getMotiveAd(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.getMotiveAd(promise, jSONObject);
    }

    @HippyMethod(name = "getNetType")
    public void getNetType(Promise promise) {
        this.mBridgeModule.getNetType(promise, false);
    }

    @HippyMethod(name = "getUploadVideoPermission")
    public void getUploadVideoPermission(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.getUploadVideoPermission(jSONObject, promise);
    }

    @HippyMethod(name = "getUploadingVideoInfo")
    public void getUploadingVideoInfo(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.getUploadingVideoInfo(jSONObject, promise);
    }

    @HippyMethod(name = "getUserInfo")
    public void getUserInfo(Promise promise) {
        this.mBridgeModule.getUserInfo(promise, false);
    }

    @HippyMethod(name = "handleClick")
    public void handleClick(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.handleClick(jSONObject);
    }

    @HippyMethod(name = "hasApp")
    public void hasApp(String str, Promise promise) {
        this.mBridgeModule.hasApp(str, promise, false);
    }

    @HippyMethod(name = "hideTopicVideoComment")
    public void hideTopicVideoComment(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.hideTopicVideoComment(jSONObject);
    }

    @HippyMethod(name = "invoke")
    public void invoke(HippyMap hippyMap, final Promise promise) {
        final JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: com.tencent.hippy.qq.module.HippyQQBridgeModule.2
            @Override // java.lang.Runnable
            public void run() {
                HippyQQBridgeModule.this.mBridgeModule.invoke(jSONObject, promise);
            }
        });
    }

    @HippyMethod(name = "openAddVideoView")
    public void openAddVideoView(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.openAddVideoView(jSONObject, promise);
    }

    @HippyMethod(name = "openApp")
    public void openApp(String str) {
        this.mBridgeModule.openApp(str);
    }

    @HippyMethod(name = "openTopicVideoComment")
    public void openTopicVideoComment(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.openTopicVideoComment(jSONObject, promise);
    }

    @HippyMethod(name = "openVideo")
    public void openVideo(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.openVideo(jSONObject);
    }

    @HippyMethod(name = "pauseUploadingVideo")
    public void pauseUploadingVideo(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.pauseUploadingVideo(jSONObject, promise);
    }

    @HippyMethod(name = "performLikeAnimation")
    public void performLikeAnimation(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.performLikeAnimation(jSONObject);
    }

    @HippyMethod(name = "resetSatusBarBlackStyle")
    public void resetSatusBarBlackStyle(HippyMap hippyMap, Promise promise) {
        this.mBridgeModule.resetSatusBarBlackStyle();
    }

    @HippyMethod(name = "resetSatusBarWhiteStyle")
    public void resetSatusBarWhiteStyle(HippyMap hippyMap, Promise promise) {
        this.mBridgeModule.resetSatusBarWhiteStyle();
    }

    @HippyMethod(name = "resumeUploadingVideo")
    public void resumeUploadingVideo(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.resumeUploadingVideo(jSONObject, promise);
    }

    @HippyMethod(name = "setNavBtn")
    public void setNavBtn(HippyMap hippyMap, final Promise promise) {
        final JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: com.tencent.hippy.qq.module.HippyQQBridgeModule.1
            @Override // java.lang.Runnable
            public void run() {
                HippyQQBridgeModule.this.mBridgeModule.setNavBtn(jSONObject, promise);
            }
        });
    }

    @HippyMethod(name = "shareVideoWithFriend")
    public void shareVideoWithFriend(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.shareVideoWithFriend(jSONObject, promise);
    }

    @HippyMethod(name = "shareVideoWithGPro")
    public void shareVideoWithGPro(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "shareVideoWithGPron is called! params = [" + hippyMap + "], promise = [" + promise + "]");
        }
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.shareVideoWithGPro(jSONObject, promise);
    }

    @HippyMethod(name = "showLevelDialog")
    public void showLevelDialog(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.openUserLevelDialog(jSONObject, promise);
    }

    @HippyMethod(name = "showMotiveAd")
    public void showMotiveAd(HippyMap hippyMap, Promise promise) {
        if (hippyMap != null) {
            hippyMap.toJSONObject();
        } else {
            new JSONObject();
        }
    }

    @HippyMethod(name = "startImagePreDownload")
    public void startImagePreDownload(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.startImagePreDownload(jSONObject);
    }

    @HippyMethod(name = "startVideoPreDownload")
    public void startVideoPreDownload(HippyMap hippyMap) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.startVideoPreDownload(jSONObject);
    }

    @HippyMethod(name = "updateIndepentTabState")
    public void updateIndepentTabState(HippyMap hippyMap) {
        final JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: com.tencent.hippy.qq.module.HippyQQBridgeModule.3
            @Override // java.lang.Runnable
            public void run() {
                HippyQQBridgeModule.this.mBridgeModule.updateIndepentTabState(jSONObject);
            }
        });
    }

    @HippyMethod(name = "vaNetworkChange")
    public void vaNetworkChange(Promise promise) {
        this.mBridgeModule.vaNetworkChange(promise);
    }

    @HippyMethod(name = "videoPlayFeedback")
    public void videoPlayFeedback(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mBridgeModule.videoPlayFeedback(jSONObject, promise);
    }

    @HippyMethod(name = "susCommentViewHide")
    public void susCommentViewHide() {
    }

    @HippyMethod(name = "susCommentViewShow")
    public void susCommentViewShow() {
    }

    @HippyMethod(name = "isKindCard")
    public void isKindCard(Promise promise) {
    }

    public void popFromBottomStateChange(Promise promise) {
    }

    public void setPresentPopFromBottom(int i3) {
    }
}
