package com.tencent.ttpic.openapi.tips;

import android.os.Handler;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AETipsManager {
    public static final int MSG_CP_MATERIAL_DETECT_LESS_THAN_TWO_FACE = 1009;
    public static final int MSG_CP_MATERIAL_DETECT_TWO_OR_MORE_THAN_TWO_FACE = 1010;
    public static final int MSG_HIDE_NO_BODY_TIPS = 1019;
    public static final int MSG_HIDE_NO_FACE_TIPS = 1018;
    public static final int MSG_SHOW_NO_BODY_TIPS = 1017;
    public static final int MSG_SHOW_NO_FACE_TIPS = 1004;
    private static final String TAG = "AETipsManager";
    private static final AETipsManager ourInstance = new AETipsManager();
    private String customTipIcon;
    private String customTipText;
    private String defaultTipText;
    private double faceDetScale;
    private int height;
    private boolean isShowBody;
    private boolean isShowFace;
    private VideoMaterial mVideoMaterial;
    private Handler uiHandler;
    private int width;
    private boolean mIsCosmeticItemEnabled = false;
    private boolean mIsBodyBeautyItemEnabled = false;
    private boolean mIsVideoItemEnabled = false;
    private HashMap<Integer, String> actionTipsMap = new HashMap<>();
    private boolean isPhoneSupport = true;

    public static AETipsManager getInstance() {
        return ourInstance;
    }

    public void checkVideoShowBodyView() {
        boolean z16;
        VideoMaterial videoMaterial = this.mVideoMaterial;
        if (videoMaterial != null && videoMaterial.needBodyDetect()) {
            VideoMaterial videoMaterial2 = this.mVideoMaterial;
            if (videoMaterial2 != null && (videoMaterial2.needBodySegment() || this.mVideoMaterial.isNeedFreezeFrame())) {
                z16 = this.isShowBody;
            } else {
                z16 = !this.isShowBody;
            }
            showBodyTips(z16, this.uiHandler, 1017);
        }
    }

    public String getActionTipString(int i3) {
        HashMap<Integer, String> hashMap = this.actionTipsMap;
        if (hashMap == null || !hashMap.containsKey(Integer.valueOf(i3))) {
            return "";
        }
        return this.actionTipsMap.get(Integer.valueOf(i3));
    }

    public String getCustomTipIcon() {
        return this.customTipIcon;
    }

    public String getCustomTipText() {
        return this.customTipText;
    }

    public VideoMaterial getVideoMaterial() {
        return this.mVideoMaterial;
    }

    public void isBodyDetected(boolean z16) {
        this.isShowBody = z16;
    }

    public void isPhoneSupport(boolean z16) {
        this.isPhoneSupport = z16;
    }

    public void pickUpTheBestTips(VideoMaterial videoMaterial) {
        this.mVideoMaterial = videoMaterial;
        if (videoMaterial != null) {
            if (this.isPhoneSupport && DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
                if (this.mVideoMaterial.getTipsIcon() != null) {
                    this.customTipIcon = this.mVideoMaterial.getTipsIcon();
                    this.customTipText = this.mVideoMaterial.getTipsText();
                    return;
                } else {
                    this.customTipIcon = "";
                    return;
                }
            }
            this.customTipText = "\u5f53\u524d\u673a\u578b\u4e0d\u652f\u6301\u8be5\u6302\u4ef6\u7279\u6548";
            this.customTipIcon = "";
        }
    }

    public void removeNoFaceMessageShow(Handler handler, int i3) {
        if (handler != null && handler.hasMessages(i3)) {
            handler.removeMessages(i3);
            handler.sendEmptyMessage(1018);
        }
    }

    public void sendNoFaceMessageDelay(Handler handler, int i3) {
        if (handler != null && !handler.hasMessages(i3)) {
            handler.removeMessages(1018);
            handler.sendEmptyMessageDelayed(i3, 2000L);
        }
    }

    public void setUIHandler(Handler handler, int i3, int i16, double d16) {
        this.uiHandler = handler;
        this.width = i3;
        this.height = i16;
        this.faceDetScale = d16;
    }

    public synchronized void setVideoMaterial(VideoMaterial videoMaterial) {
        pickUpTheBestTips(videoMaterial);
    }

    public void showBodyTips(boolean z16, Handler handler, int i3) {
        if (z16) {
            if (handler != null && !handler.hasMessages(i3)) {
                handler.removeMessages(1019);
                handler.sendEmptyMessageDelayed(i3, 2000L);
                return;
            }
            return;
        }
        if (handler != null && handler.hasMessages(i3)) {
            handler.removeMessages(i3);
            handler.sendEmptyMessage(1019);
        }
    }

    public void showFaceTips(boolean z16, Handler handler, int i3) {
        if (z16) {
            if (handler != null && !handler.hasMessages(i3)) {
                handler.removeMessages(1018);
                handler.sendEmptyMessageDelayed(i3, 2000L);
                return;
            }
            return;
        }
        if (handler != null && handler.hasMessages(i3)) {
            handler.removeMessages(i3);
            handler.sendEmptyMessage(1018);
        }
    }

    public void updateActionTipsString(HashMap<Integer, String> hashMap) {
        this.actionTipsMap = hashMap;
    }
}
