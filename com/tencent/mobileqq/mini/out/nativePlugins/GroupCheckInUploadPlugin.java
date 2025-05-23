package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class GroupCheckInUploadPlugin implements NativePlugin, EIPCResultCallback {
    public static final String PLUGIN_NAME = "checkin_uploadRes";
    public static final String TAG = "GroupCheckInUploadPlugin";
    JSContext mContext;

    @Override // eipc.EIPCResultCallback
    public void onCallback(EIPCResult eIPCResult) {
        int i3 = eIPCResult.code;
        Bundle bundle = eIPCResult.data;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "result = " + i3 + ", data = " + bundle.toString());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            int i16 = bundle.getInt(BaseProfileQZoneComponent.KEY_IS_VIDEO);
            int i17 = bundle.getInt("result");
            boolean z16 = true;
            boolean z17 = i17 == 1;
            jSONObject.put(BaseProfileQZoneComponent.KEY_IS_VIDEO, i16);
            jSONObject.put("result", i17);
            if (i16 == 1) {
                if (z17) {
                    jSONObject.put("url", bundle.getString("url"));
                    jSONObject.put("vid", bundle.getString("vid"));
                } else {
                    jSONObject.put("error", bundle.getString("error"));
                }
            } else if (z17) {
                jSONObject.put("url", bundle.getString("url"));
            } else {
                jSONObject.put("error", bundle.getString("error"));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onCallback json = " + jSONObject.toString());
            }
            JSContext jSContext = this.mContext;
            if (i17 != 1) {
                z16 = false;
            }
            jSContext.evaluateCallback(z16, jSONObject, "");
        } catch (Exception e16) {
            e16.printStackTrace();
            this.mContext.evaluateCallback(false, jSONObject, "");
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
        QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        this.mContext = jSContext;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        QLog.d(TAG, 1, "data: " + optJSONObject);
        String absolutePath = MiniAppFileManager.getInstance().getAbsolutePath(optJSONObject.optString("filePath"));
        boolean z16 = optJSONObject.optInt(BaseProfileQZoneComponent.KEY_IS_VIDEO) == 1;
        Bundle bundle = new Bundle();
        if (z16) {
            String absolutePath2 = MiniAppFileManager.getInstance().getAbsolutePath(optJSONObject.optString("cover"));
            if (!FileUtils.fileExists(absolutePath) || !FileUtils.fileExists(absolutePath2)) {
                return;
            }
            bundle.putString("BUNDLE_NAME_FILEPATH", absolutePath);
            bundle.putString("BUNDLE_NAME_COVER", absolutePath2);
            bundle.putLong("BUNDLE_NAME_VIDEOTIME", optJSONObject.optLong("videoDuration"));
        } else if (!FileUtils.fileExists(absolutePath)) {
            return;
        } else {
            bundle.putString("BUNDLE_NAME_FILEPATH", absolutePath);
        }
        if (z16) {
            QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", bundle, this);
        } else {
            QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", bundle, this);
        }
    }
}
