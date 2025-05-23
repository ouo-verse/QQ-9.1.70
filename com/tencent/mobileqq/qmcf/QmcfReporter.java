package com.tencent.mobileqq.qmcf;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QmcfReporter {
    static IPatchRedirector $redirector_ = null;
    public static final String SVAF_EVENT_INIT_BLOCK = "svaf_init_block";
    public static final String SVAF_EVENT_INIT_COST3S = "svaf_init_cost3s";
    public static final String SVAF_EVENT_INIT_ERROR = "svaf_init_error";
    public static final String SVAF_EVENT_NOSUPPORT_OCL = "svaf_nosupport_ocl";
    public static final String SVAF_EVENT_RECORD_INFO = "svaf_record_info";
    public static final String SVAF_PARAM_BUSI_TYPE = "svaf_busiType";
    public static final String SVAF_PARAM_CAMERA_TYPE = "svaf_cameraType";
    public static final String SVAF_PARAM_COST = "svaf_cost";
    public static final String SVAF_PARAM_ENTRANCE_STATE = "qmcf_entrState";
    public static final String SVAF_PARAM_FRAMETYPE = "qmcf_frameType";
    public static final String SVAF_PARAM_FRAME_COST = "svaf_frameCost";
    public static final String SVAF_PARAM_GPUINFO = "svaf_gpuinfo";
    public static final String SVAF_PARAM_HAS_ENTRANCE = "qmcf_hasEntrance";
    public static final String SVAF_PARAM_PROCESS_COST = "qmcf_processCost";
    public static final String SVAF_PARAM_QMCF_MODE = "svaf_qmcf_mode";
    public static final String SVAF_PARAM_RESULT = "svaf_result";
    public static final String SVAF_PARAM_TEMPLATE_ID = "svaf_templateID";
    public static final String SVAF_PARAM_WHICH_COMPONENT = "svaf_which_component";
    private static final String TAG = "GMCF_REPORTER";
    public float avgFrameConsume;
    public float avgProcessConsume;
    public int processCount;
    public int updateCount;

    public QmcfReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.avgFrameConsume = -1.0f;
        this.updateCount = 0;
        this.avgProcessConsume = -1.0f;
        this.processCount = 0;
    }

    public static void report(String str, HashMap hashMap, boolean z16) {
        if (z16 && hashMap != null) {
            hashMap.put("manufacture", DeviceInstance.getPhoneManufacturer());
            hashMap.put("model", DeviceInstance.PHONE_MODEL);
            hashMap.put("sdk", String.valueOf(DeviceInstance.getSDKVersion()));
        }
        SdkContext.getInstance().getReporter().reportToBeacon(str, true, 0L, 0L, hashMap);
    }

    public static void reportTime(String str, HashMap hashMap, int i3, boolean z16) {
        if (z16 && hashMap != null) {
            hashMap.put("manufacture", DeviceInstance.getPhoneManufacturer());
            hashMap.put("model", DeviceInstance.PHONE_MODEL);
            hashMap.put("sdk", String.valueOf(DeviceInstance.getSDKVersion()));
        }
        SdkContext.getInstance().getReporter().reportToBeacon(str, true, i3, 0L, hashMap);
    }

    public void clearReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.avgFrameConsume = -1.0f;
        this.updateCount = 0;
        this.avgProcessConsume = -1.0f;
        this.processCount = 0;
    }

    public void reportMtaFrameCost(int i3, int i16, String str, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QmcfManager.getInstance().isQmcfWork() && this.avgFrameConsume != -1.0f) {
            HashMap hashMap = new HashMap();
            hashMap.put(SVAF_PARAM_FRAME_COST, String.valueOf(this.avgFrameConsume));
            hashMap.put(SVAF_PARAM_PROCESS_COST, String.valueOf(this.avgProcessConsume));
            hashMap.put(SVAF_PARAM_CAMERA_TYPE, String.valueOf(i3));
            hashMap.put(SVAF_PARAM_BUSI_TYPE, String.valueOf(i16));
            hashMap.put(SVAF_PARAM_WHICH_COMPONENT, "qmcf");
            hashMap.put(SVAF_PARAM_QMCF_MODE, String.valueOf(i17));
            hashMap.put(SVAF_PARAM_FRAMETYPE, String.valueOf(i18));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(SVAF_PARAM_TEMPLATE_ID, String.valueOf(i16));
            } else {
                str = "non";
            }
            reportTime(SVAF_EVENT_RECORD_INFO, hashMap, (int) this.avgFrameConsume, true);
            if (SLog.isEnable()) {
                SLog.d(TAG, String.format("reportMtaQmcf, frameCost[%s], proCost[%s], cameraType[%s], busiType[%s], templateId[%s], qmcfmode[%s], frameTpye[%s]", Float.valueOf(this.avgFrameConsume), Float.valueOf(this.avgProcessConsume), Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Integer.valueOf(i18)));
            }
        }
        clearReporter();
    }

    public void updateFrameConsume(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else if (j3 > 0) {
            float f16 = this.avgFrameConsume;
            int i3 = this.updateCount;
            this.avgFrameConsume = ((f16 * i3) + ((float) j3)) / (i3 + 1);
            this.updateCount = i3 + 1;
        }
    }

    public void updateProcessConsume(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else if (j3 > 0) {
            float f16 = this.avgProcessConsume;
            int i3 = this.processCount;
            this.avgProcessConsume = ((f16 * i3) + ((float) j3)) / (i3 + 1);
            this.processCount = i3 + 1;
        }
    }
}
