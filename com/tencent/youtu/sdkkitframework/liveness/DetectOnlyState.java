package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DetectOnlyState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DetectOnlyState";
    private boolean isLoadResourceOnline;
    private int minFaceSize;
    private boolean needBigFaceMode;
    private String resourceDownloadPath;
    private YTFaceTracker tracker;

    public DetectOnlyState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isLoadResourceOnline = false;
        this.resourceDownloadPath = "";
        this.needBigFaceMode = false;
        this.minFaceSize = 80;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject, YtSdkConfig ytSdkConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSONObject, ytSdkConfig);
            return;
        }
        super.loadStateWith(str, jSONObject, ytSdkConfig);
        try {
            if (jSONObject.has("resource_online")) {
                this.isLoadResourceOnline = jSONObject.getBoolean("resource_online");
            }
            if (jSONObject.has("resource_download_path")) {
                this.resourceDownloadPath = jSONObject.getString("resource_download_path");
            }
            if (jSONObject.has("need_big_face_mode")) {
                this.needBigFaceMode = jSONObject.getBoolean("need_big_face_mode");
            }
            if (jSONObject.has("min_face_size")) {
                this.minFaceSize = jSONObject.getInt("min_face_size");
            }
        } catch (Exception e16) {
            YtLogger.e(TAG, "Failed to parse json:", e16);
        }
        if (!this.isLoadResourceOnline) {
            FileUtils.loadLibrary("YTFaceTracker");
        }
        Context context = YtFSM.getInstance().getContext().currentAppContext;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (this.isLoadResourceOnline) {
            absolutePath = this.resourceDownloadPath;
            YtLogger.i(TAG, "Use online path:" + absolutePath);
        } else {
            YtLogger.i(TAG, "Use local path:" + absolutePath);
        }
        try {
            if (!this.isLoadResourceOnline) {
                this.tracker = new YTFaceTracker(context.getAssets(), "models/face-tracker-v001", QCircleSkinHelper.SKIN_CONFIG_FILE_NAME);
            } else {
                this.tracker = new YTFaceTracker(absolutePath, QCircleSkinHelper.SKIN_CONFIG_FILE_NAME);
            }
            YTFaceTracker.Param param = this.tracker.getParam();
            String str2 = TAG;
            YtLogger.i(str2, "big face mode" + this.needBigFaceMode);
            param.biggerFaceMode = this.needBigFaceMode ? 1 : 0;
            param.minFaceSize = this.minFaceSize;
            param.detInterval = -1;
            this.tracker.setParam(param);
            YtLogger.i(str2, "Detect version:" + YTFaceTracker.getVersion());
        } catch (Exception e17) {
            YtLogger.e(TAG, "init YTFaceTracker error", e17);
            e17.printStackTrace();
            YtSDKStats.getInstance().reportError(1, "failed to init face trace sdk");
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DetectOnlyState.this);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED));
                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "\u68c0\u6d4b\u521d\u59cb\u5316\u5931\u8d25"));
                }
            });
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void update(YTImageData yTImageData, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, yTImageData, Long.valueOf(j3));
        } else {
            super.update(yTImageData, j3);
        }
    }
}
