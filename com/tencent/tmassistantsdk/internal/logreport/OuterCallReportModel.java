package com.tencent.tmassistantsdk.internal.logreport;

import android.os.Build;
import android.os.Bundle;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class OuterCallReportModel {
    public static final String COMPONENT_LINKPROXY = "LinkProxyActivity";
    public static final String COMPONENT_SERVICE = "SDKSupportService";
    public static final String COMPONENT_SPLASH = "SplashActivity";
    public static final int OUTER_CALL_MODE_BROWSER = 1;
    public static final int OUTER_CALL_MODE_SILENT = 0;
    public static final int OUTER_CALL_SUPPORT_YYB_VERSION = 7132130;
    public static final int OUTER_CALL_TYPE_ACTIVITY = 1;
    public static final int OUTER_CALL_TYPE_SERVICE = 0;
    private static final String TAG = "OuterCallReportModel";
    public int mOuterCallType = 0;
    public int mOuterCallMode = 0;
    public long mOuterCallTime = 0;
    public String mVia = "";
    public String mComponentName = "";
    public String mFingerprints = "";
    public String mDisplay = "";
    public String mBuildId = "";
    public String mInCremental = "";
    public String mHostVersion = "";
    public String mHostPname = "";
    public String mYYBVersion = "";
    public String mYYBSDKAPILevel = "";

    public static OuterCallReportModel getDefaultModel() {
        OuterCallReportModel outerCallReportModel = new OuterCallReportModel();
        outerCallReportModel.mFingerprints = Build.FINGERPRINT;
        outerCallReportModel.mDisplay = Build.DISPLAY;
        outerCallReportModel.mBuildId = Build.ID;
        outerCallReportModel.mInCremental = Build.VERSION.INCREMENTAL;
        outerCallReportModel.mYYBVersion = String.valueOf(0);
        outerCallReportModel.mHostPname = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        outerCallReportModel.mHostVersion = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
        outerCallReportModel.mYYBSDKAPILevel = String.valueOf(GlobalUtil.getInstance().getQQDownloaderAPILevel());
        outerCallReportModel.mOuterCallTime = System.currentTimeMillis();
        return outerCallReportModel;
    }

    public static boolean isYYBSupportOutcallReport() {
        if (GlobalUtil.getInstance().getQQDownloaderVersionCode() >= 7132130) {
            return true;
        }
        return false;
    }

    public Bundle getBundleData() {
        Bundle bundle = new Bundle();
        bundle.putString("outerCallType", String.valueOf(this.mOuterCallType));
        bundle.putString("outerCallMode", String.valueOf(this.mOuterCallMode));
        bundle.putString("outerCallTime", String.valueOf(this.mOuterCallTime));
        bundle.putString("hostversion", this.mHostVersion);
        bundle.putString("hostpname", GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()));
        return bundle;
    }

    public String getJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("via", String.valueOf(this.mVia));
            jSONObject.put("outerCallType", String.valueOf(this.mOuterCallType));
            jSONObject.put("outerCallMode", String.valueOf(this.mOuterCallMode));
            jSONObject.put("outerCallTime", String.valueOf(this.mOuterCallTime));
            jSONObject.put("hostversion", this.mHostVersion);
            jSONObject.put("hostpname", GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "||||||||" + this.mComponentName + "|" + this.mVia + "|" + this.mOuterCallType + "|" + this.mOuterCallMode + "|" + this.mOuterCallTime + "|" + this.mFingerprints + "|" + this.mDisplay + "|" + this.mBuildId + "|" + this.mInCremental + "|" + this.mHostPname + "|" + this.mHostVersion + "|" + this.mYYBVersion + "|" + this.mYYBSDKAPILevel;
    }
}
