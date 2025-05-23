package com.tencent.gdtad.basics.motivevideo.report;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtADFlyingStreamingReportHelper {
    public static final long EVENT_CODE_1020006 = 1020006;
    public static final long EVENT_CODE_1020007 = 1020007;
    public static final long EVENT_CODE_1020008 = 1020008;
    public static final long EVENT_CODE_1020009 = 1020009;
    public static final long EVENT_CODE_1020010 = 1020010;
    public static final long EVENT_CODE_1020011 = 1020011;
    public static final long EVENT_CODE_1020012 = 1020012;
    public static final long EVENT_CODE_1020013 = 1020013;
    public static final long EVENT_CODE_1020014 = 1020014;
    public static final long EVENT_CODE_1020015 = 1020015;
    public static final long EVENT_CODE_1020016 = 1020016;
    public static final long EVENT_CODE_1020021 = 1020021;
    public static final long EVENT_CODE_1020022 = 1020022;
    public static final long EVENT_CODE_1020025 = 1020025;
    public static final long EVENT_CODE_1020026 = 1020026;
    public static final long EVENT_CODE_1020028 = 1020028;
    public static final long EVENT_CODE_1020029 = 1020029;
    public static final long EVENT_CODE_1020030 = 1020030;
    public static final long EVENT_CODE_1020033 = 1020033;
    public static final long EVENT_CODE_1020034 = 1020034;
    public static final long EVENT_CODE_1020035 = 1020035;
    public static final long EVENT_CODE_1020036 = 1020036;
    public static final long EVENT_CODE_1020037 = 1020037;
    public static final long EVENT_CODE_1020038 = 1020038;
    public static final long EVENT_CODE_1020040 = 1020040;
    public static final long EVENT_CODE_1020041 = 1020041;
    public static final long EVENT_CODE_1020043 = 1020043;
    public static final long EVENT_CODE_40062 = 40062;
    public static final long EVENT_CODE_40092 = 40092;
    private static volatile GdtADFlyingStreamingReportHelper INSTANCE = null;
    public static final String PARAM_KEY_AID = "aid";
    public static final String PARAM_KEY_APP = "app";
    public static final String PARAM_KEY_AV = "av";
    public static final String PARAM_KEY_EI = "ei";
    public static final String PARAM_KEY_LID = "lid";
    public static final String PARAM_KEY_MN = "mn";
    public static final String PARAM_KEY_OS = "os";
    public static final String PARAM_KEY_OV = "ov";
    public static final String PARAM_KEY_PID = "pid";
    public static final String PARAM_KEY_PKG = "pkg";
    public static final String PARAM_KEY_SDK_ST = "sdk_st";
    public static final String PARAM_KEY_SEQ = "seq";
    public static final String PARAM_KEY_SV = "sv";
    public static final String PARAM_KEY_TRACEID = "traceid";
    public static final String PARAM_KEY_TS = "ts";
    public static final int SHOW_BOTTOM_CARD = 1;
    public static final int SHOW_END_CARD = 2;
    public static final int SHOW_MOTIVE_BROWSING = 3;
    public static final int SHOW_NATIVE = 0;
    public static final String TAG = "GdtADFlyingStreamingReportHelper";
    private String mAid;

    @Nullable
    private String mAppID;

    @Nullable
    private String mPid;
    private int mShowCardStatus = 0;

    @Nullable
    private String mTraceID;

    GdtADFlyingStreamingReportHelper() {
    }

    public static GdtADFlyingStreamingReportHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (GdtADFlyingStreamingReportHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GdtADFlyingStreamingReportHelper();
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    protected JSONObject buildParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app", String.valueOf(this.mAppID));
            jSONObject.put("pkg", MobileQQ.sMobileQQ.getPackageName());
            String str = AppSetting.f99551k;
            jSONObject.put(PARAM_KEY_SV, str);
            jSONObject.put("av", str);
            jSONObject.put("sdk_st", 9);
            jSONObject.put(PARAM_KEY_OV, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("os", 2);
            jSONObject.put(PARAM_KEY_MN, ah.F());
            jSONObject.put("lid", getUin());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "buildParams", th5);
        }
        return jSONObject;
    }

    protected long changeToServerTime(long j3) {
        return j3 + (NetConnInfoCenter.servetTimeSecondInterv * 1000);
    }

    public int getShowCardStatus() {
        return this.mShowCardStatus;
    }

    public String getUin() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return "";
        }
        return waitAppRuntime.getAccount();
    }

    public void init(@Nullable GdtMotiveVideoModel gdtMotiveVideoModel) {
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null) {
            GdtAd gdtAd = gdtMotiveVideoModel.getGdtAd();
            this.mTraceID = gdtAd.getTraceId();
            this.mPid = gdtAd.getPosId();
            this.mAid = String.valueOf(gdtAd.getAId());
        }
        this.mAppID = String.valueOf(AppSetting.f());
    }

    public void onDestroy() {
        this.mTraceID = null;
        this.mAppID = null;
        this.mShowCardStatus = 0;
    }

    public void reportADEvent(long j3) {
        reportADEvent(j3, null, null);
    }

    public void setShowCardStatus(int i3) {
        this.mShowCardStatus = i3;
    }

    public boolean reportADEvent(long j3, JSONObject jSONObject) {
        return reportADEvent(j3, jSONObject, null);
    }

    public boolean reportADEvent(long j3, GdtReportForAntiSpam.ReportCallback reportCallback) {
        return reportADEvent(j3, null, reportCallback);
    }

    public boolean reportADEvent(long j3, @Nullable JSONObject jSONObject, GdtReportForAntiSpam.ReportCallback reportCallback) {
        if (TextUtils.isEmpty(this.mTraceID)) {
            QLog.i(TAG, 1, "reportADEvent traceId is empty");
            return false;
        }
        JSONObject buildParams = buildParams();
        if (buildParams == null) {
            QLog.i(TAG, 1, "reportADEvent local param is null");
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            buildParams.put(LinkReportConstant$GlobalKey.EVENTS, jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("seq", 1);
            jSONObject2.put("ts", changeToServerTime(System.currentTimeMillis()));
            jSONObject2.put("ei", j3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject2.put("biz", jSONObject3);
            jSONObject3.put("traceid", this.mTraceID);
            jSONObject3.put("pid", this.mPid);
            jSONObject3.put("aid", this.mAid);
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            jSONArray.mo162put(jSONObject2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportADEvent buildParams", th5);
        }
        QLog.i(TAG, 1, "reportADEvent " + buildParams.toString());
        GdtReportForAntiSpam.reportFlyingStreaming(buildParams, reportCallback);
        return true;
    }
}
