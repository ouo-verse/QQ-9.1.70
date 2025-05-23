package com.tencent.hippy.qq.module;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.DeviceInfoUtils;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = JSIDeviceModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class JSIDeviceModule extends QQBaseModule {
    static final String CLASS_NAME = "JSIDeviceModule";

    public JSIDeviceModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private int getRotationDegrees(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    private void putContainerInfo(JSONObject jSONObject, DisplayMetrics displayMetrics) {
        HippyQQEngine hippyQQEngine;
        if (displayMetrics == null || (hippyQQEngine = getHippyQQEngine()) == null) {
            return;
        }
        int containerWidth = hippyQQEngine.getContainerWidth();
        int containerHeight = hippyQQEngine.getContainerHeight();
        try {
            jSONObject.put("containerWidth", containerWidth / displayMetrics.density);
            jSONObject.put("containerHeight", containerHeight / displayMetrics.density);
            jSONObject.put("containerWidthInPixels", containerWidth);
            jSONObject.put("containerHeightInPixels", containerHeight);
        } catch (JSONException e16) {
            QLog.e(CLASS_NAME, 1, "putContainerInfo e:", e16);
        }
    }

    private void putScreenInfo(JSONObject jSONObject, DisplayMetrics displayMetrics, Display display) {
        if (displayMetrics != null && display != null) {
            try {
                jSONObject.put("screenWidth", displayMetrics.widthPixels / displayMetrics.density);
                jSONObject.put("screenHeight", displayMetrics.heightPixels / displayMetrics.density);
                jSONObject.put("screenWidthInPixels", displayMetrics.widthPixels);
                jSONObject.put("screenHeightInPixels", displayMetrics.heightPixels);
                jSONObject.put("screenRotation", getRotationDegrees(display.getRotation()));
                jSONObject.put("scale", displayMetrics.density);
                jSONObject.put("fontScale", displayMetrics.scaledDensity);
                jSONObject.put("densityDpi", displayMetrics.densityDpi);
            } catch (JSONException e16) {
                QLog.e(CLASS_NAME, 1, "putScreenInfo e:", e16);
            }
        }
    }

    @HippyMethod(isSync = true, name = "getClientInfo")
    public String getClientInfo() {
        return DeviceInfoUtils.getClientInfo();
    }

    @HippyMethod(isSync = true, name = "getDeviceInfo")
    public String getDeviceInfo() {
        return DeviceInfoUtils.getDeviceInfo();
    }

    @HippyMethod(isSync = true, name = "getGdtDeviceInfo")
    public String getGdtDeviceInfo(HippyMap hippyMap) {
        return DeviceInfoUtils.getGdtDeviceInfo(hippyMap);
    }

    @HippyMethod(isSync = true, name = "getNetworkType")
    public int getNetworkType() {
        return HttpUtil.getNetWorkType();
    }

    @HippyMethod(isSync = true, name = "getWindowInfo")
    public String getWindowInfo() {
        Display defaultDisplay = ((WindowManager) BaseApplication.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = HippyUtils.getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        putScreenInfo(jSONObject, displayMetrics, defaultDisplay);
        putContainerInfo(jSONObject, displayMetrics);
        return jSONObject.toString();
    }
}
