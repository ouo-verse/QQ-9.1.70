package com.tencent.youtu.sdkkitframework.liveness;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.OperateInfoManager;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtVideoEncoderHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YtVideoEncoderHelper";
    public JSONArray actionVideoFrames;
    private final int codecSettingBitRate;
    private final int codecSettingFrameRate;
    private final int codecSettingiFrameInterval;
    public String config;
    private boolean debug;
    private final String innerMp4Path;
    public boolean isPrepare;
    private boolean isReportEncodeVideoError;
    private boolean isVideoStarted;
    private String supportCodecJSONStr;
    private YtVideoEncoder videoEncoder;

    public YtVideoEncoderHelper(String str, int i3, int i16, int i17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2);
            return;
        }
        this.debug = false;
        this.config = str2;
        this.innerMp4Path = str;
        this.codecSettingBitRate = i3;
        this.codecSettingFrameRate = i16;
        this.codecSettingiFrameInterval = i17;
        this.videoEncoder = new YtVideoEncoder();
        this.isPrepare = YtVideoEncoder.getMediaCodecInfo() == 0;
    }

    private void sendEncodeData(String str) {
        if (!this.isReportEncodeVideoError) {
            this.isReportEncodeVideoError = true;
            YtLogger.d(TAG, "supportCodecJSONStr:" + str);
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(OperateInfoManager.getInstance().conservationVideoErrorData(str, Integer.valueOf(ErrorCode.YT_SDK_ACTION_VIDEO_CONSERVATION_FAIL))) { // from class: com.tencent.youtu.sdkkitframework.liveness.YtVideoEncoderHelper.1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$msg;

                {
                    this.val$msg = r5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) YtVideoEncoderHelper.this, (Object) r5);
                    } else {
                        put(StateEvent.Name.CONSERVATION_VIDEO_MESSAGE, r5);
                    }
                }
            });
        }
    }

    private int startVideoEncoding(int i3, int i16, int i17) {
        try {
            this.videoEncoder.startEncoding(i3, i16, new File(this.innerMp4Path), this.codecSettingBitRate, this.codecSettingFrameRate, this.codecSettingiFrameInterval, i17);
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    private void videoEncode(byte[] bArr, int i3, int i16) {
        this.videoEncoder.queueFrame(new YTImageData(bArr, i3, i16));
        this.videoEncoder.encode(this.codecSettingFrameRate);
    }

    public void conservationVideo(YTActRefImage[] yTActRefImageArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) yTActRefImageArr);
            return;
        }
        String[] split = this.config.split(ContainerUtils.FIELD_DELIMITER);
        if (split.length > 0) {
            i3 = 0;
            for (String str : split) {
                String[] split2 = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length > 1 && split2[0].equals("action_video_shorten_strategy")) {
                    i3 = Integer.parseInt(split2[1]);
                }
            }
        } else {
            i3 = 0;
        }
        if (i3 != 1) {
            StringBuilder sb5 = new StringBuilder();
            if (split.length > 0) {
                for (String str2 : split) {
                    String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3.length > 1 && !split3[0].equals("action_video_shorten_strategy") && !split3[0].equals("reflect_images_shorten_strategy")) {
                        sb5.append(split3[0]);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(split3[1]);
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
            }
            sb5.append("reflect_images_shorten_strategy=1&action_video_shorten_strategy=1");
            this.config = sb5.toString();
        }
        this.supportCodecJSONStr = this.videoEncoder.getSupportCodecJSONStr();
        JSONArray jSONArray = new JSONArray();
        for (int i16 = 0; i16 < yTActRefImageArr.length; i16++) {
            YTActRefImage yTActRefImage = yTActRefImageArr[i16];
            if (yTActRefImage != null && yTActRefImage.encodeImage != null) {
                YTActRefImage yTActRefImage2 = yTActRefImageArr[i16];
                jSONArray.mo162put(new YTImageData(yTActRefImage2.f385207w, yTActRefImage2.f385206h, yTActRefImage2.encodeImage).toJSON64Img());
            }
        }
        setActionVideoFrames(jSONArray);
    }

    public int getColorFormat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.videoEncoder.getColorFormat();
    }

    public String getSupportCodecJSONStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.supportCodecJSONStr;
    }

    public boolean isVideoStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isVideoStarted;
    }

    public boolean makeActionOneVideoData(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        try {
            videoEncode(bArr, i3, i16);
            return true;
        } catch (Exception e16) {
            YtLogger.e(TAG, "encode frame error:", e16);
            return false;
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.videoEncoder.abortEncoding();
        }
    }

    public void setActionVideoFrames(JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONArray);
            return;
        }
        if (this.actionVideoFrames == null) {
            this.actionVideoFrames = jSONArray;
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                this.actionVideoFrames.mo162put(jSONArray.get(i3));
            } catch (JSONException e16) {
                YtLogger.e(TAG, "JSONArray put error", e16);
            }
        }
    }

    public boolean startActionVideo(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        this.isVideoStarted = true;
        if (this.isPrepare && (this.videoEncoder.isEncodingStarted() || startVideoEncoding(i3, i16, i17) == 0)) {
            return true;
        }
        YtLogger.e(TAG, "sunny-start video encode error", null);
        return false;
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.videoEncoder.stopEncoding();
        }
    }

    public void unload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        YtVideoEncoder ytVideoEncoder = this.videoEncoder;
        if (ytVideoEncoder != null) {
            this.isVideoStarted = false;
            try {
                try {
                    ytVideoEncoder.abortEncoding();
                    this.videoEncoder.stopEncoding();
                } catch (Exception e16) {
                    YtLogger.e(TAG, "video release error:", e16);
                }
            } finally {
                this.videoEncoder = null;
            }
        }
    }
}
