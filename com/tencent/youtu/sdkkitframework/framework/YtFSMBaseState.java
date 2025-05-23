package com.tencent.youtu.sdkkitframework.framework;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.OperateInfoManager;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YtFSMBaseState";
    public boolean isFirstEnter;
    public AtomicBoolean isPause;
    private long printFrameLogTime;
    public HashMap<String, Object> stateData;
    public String stateName;
    public String stateSimpleName;

    public YtFSMBaseState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isFirstEnter = true;
            this.isPause = new AtomicBoolean(false);
        }
    }

    public boolean containsKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        return this.stateData.containsKey(str);
    }

    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        YtSDKStats.getInstance().enterState(this.stateSimpleName);
        if (this.isFirstEnter) {
            this.isFirstEnter = false;
            enterFirst();
        }
        YtLogger.d(TAG, this.stateName + " enter");
    }

    public abstract void enterFirst();

    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        YtLogger.d(TAG, this.stateName + " exit");
    }

    public Object getStateDataBy(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return this.stateData.get(str);
    }

    public String getStateName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.stateName;
    }

    public String getStateSimpleName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.stateSimpleName;
    }

    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) ytFrameworkFireEventType, obj);
        }
    }

    public void handleStateAction(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, obj);
        }
    }

    public void loadStateWith(String str, JSONObject jSONObject, YtSdkConfig ytSdkConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSONObject, ytSdkConfig);
            return;
        }
        this.stateName = str;
        try {
            this.stateSimpleName = Class.forName(str).getSimpleName();
        } catch (Exception e16) {
            this.stateSimpleName = str.split("\\.")[r7.length - 1];
            YtLogger.e(TAG, "load state with catch error:", e16);
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
        }
        YtLogger.i(TAG, "load " + this.stateSimpleName);
        this.stateData = new HashMap<>();
        YtSDKStats.getInstance().registerStateName(this.stateSimpleName);
        updateSDKSetting(jSONObject);
    }

    public JSONObject makeStateInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (JSONObject) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, i3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state_name", str);
            jSONObject.put("state_code", i3);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "make log info error", e16);
        }
        return jSONObject;
    }

    public void moveToNextState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        YtLogger.d(TAG, this.stateName + " move to next");
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.isPause.getAndSet(true);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.isPause.getAndSet(false);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.isFirstEnter = true;
        this.stateData.clear();
        YtLogger.i(TAG, this.stateName + " reset");
    }

    public void sendFSMTransitError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>(str) { // from class: com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState.1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$stateName;

                {
                    this.val$stateName = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YtFSMBaseState.this, (Object) str);
                        return;
                    }
                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                    put("error_code", 3145728);
                    put("message", CommonUtils.makeMessageJson(3145728, StringCode.MSG_INNER_ERROR, "fsm transit next round  error:" + str));
                }
            });
        }
    }

    public void unload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        YtLogger.i(TAG, "unload " + this.stateSimpleName);
        this.stateData.clear();
    }

    public void update(YTImageData yTImageData, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, yTImageData, Long.valueOf(j3));
            return;
        }
        YtSDKStats.getInstance().updateState(this.stateName);
        if (System.currentTimeMillis() - this.printFrameLogTime > 2000) {
            this.printFrameLogTime = System.currentTimeMillis();
            YtLogger.d(TAG, this.stateName + " update bgr image width:" + yTImageData.getWidth() + ",height:" + yTImageData.height);
        }
    }

    public void updateDataBy(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, obj);
        } else {
            this.stateData.put(str, obj);
        }
    }

    public void updateSDKSetting(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSONObject);
        }
    }
}
