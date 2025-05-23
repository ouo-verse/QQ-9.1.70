package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class m extends BaseJsPlugin implements EIPCResultCallback {

    /* renamed from: d, reason: collision with root package name */
    private RequestEvent f347057d;

    @JsEvent({GroupCheckInUploadPlugin.PLUGIN_NAME})
    public void checkinUploadRes(RequestEvent requestEvent) {
        try {
            this.f347057d = requestEvent;
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            QLog.d(GroupCheckInUploadPlugin.TAG, 1, "data: " + optJSONObject);
            String absolutePath = ((IMiniAppFileManager) this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(optJSONObject.optString("filePath"));
            boolean z16 = optJSONObject.optInt(BaseProfileQZoneComponent.KEY_IS_VIDEO) == 1;
            Bundle bundle = new Bundle();
            if (z16) {
                String absolutePath2 = ((IMiniAppFileManager) this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(optJSONObject.optString("cover"));
                if (FileUtils.fileExists(absolutePath) && FileUtils.fileExists(absolutePath2)) {
                    bundle.putString("BUNDLE_NAME_FILEPATH", absolutePath);
                    bundle.putString("BUNDLE_NAME_COVER", absolutePath2);
                    bundle.putLong("BUNDLE_NAME_VIDEOTIME", optJSONObject.optLong("videoDuration"));
                }
                return;
            }
            if (!FileUtils.fileExists(absolutePath)) {
                return;
            } else {
                bundle.putString("BUNDLE_NAME_FILEPATH", absolutePath);
            }
            if (z16) {
                QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", bundle, this);
            } else {
                QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", bundle, this);
            }
        } catch (JSONException unused) {
            QLog.e(GroupCheckInUploadPlugin.TAG, 1, "checkinUploadRes(). Failed to parse jsonParams=" + requestEvent.jsonParams);
        }
        QLog.d(GroupCheckInUploadPlugin.TAG, 1, "checkin_uploadRes succeed");
        requestEvent.ok();
    }

    @Override // eipc.EIPCResultCallback
    public void onCallback(EIPCResult eIPCResult) {
        int i3 = eIPCResult.code;
        Bundle bundle = eIPCResult.data;
        if (QLog.isColorLevel()) {
            QLog.d(GroupCheckInUploadPlugin.TAG, 2, "result = " + i3 + ", data = " + bundle.toString());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            int i16 = bundle.getInt(BaseProfileQZoneComponent.KEY_IS_VIDEO);
            int i17 = bundle.getInt("result");
            boolean z16 = i17 == 1;
            jSONObject.put(BaseProfileQZoneComponent.KEY_IS_VIDEO, i16);
            jSONObject.put("result", i17);
            if (i16 == 1) {
                if (z16) {
                    jSONObject.put("url", bundle.getString("url"));
                    jSONObject.put("vid", bundle.getString("vid"));
                } else {
                    jSONObject.put("error", bundle.getString("error"));
                }
            } else if (z16) {
                jSONObject.put("url", bundle.getString("url"));
            } else {
                jSONObject.put("error", bundle.getString("error"));
            }
            if (QLog.isColorLevel()) {
                QLog.d(GroupCheckInUploadPlugin.TAG, 2, "onCallback json = " + jSONObject.toString());
            }
            RequestEvent requestEvent = this.f347057d;
            if (requestEvent != null) {
                requestEvent.ok(jSONObject);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            RequestEvent requestEvent2 = this.f347057d;
            if (requestEvent2 != null) {
                requestEvent2.fail(jSONObject, "");
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
    }
}
