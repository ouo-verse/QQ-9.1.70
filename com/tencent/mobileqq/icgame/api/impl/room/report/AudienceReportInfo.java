package com.tencent.mobileqq.icgame.api.impl.room.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.techreport.c;
import com.tencent.mobileqq.icgame.techreport.e;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AudienceReportInfo {
    private static final String TAG = "ICGameAudienceReportInfo";
    private static String appVersionCode;
    private static String brand;
    private static String model;
    private static String osVersion;
    private static String userId;
    private static String userName;
    private String networkType = null;
    private String uuid = null;
    private boolean isFirstResolutionChange = true;
    private final Map<String, String> map = new ConcurrentHashMap();

    public AudienceReportInfo() {
        initDefaultMap();
    }

    private String getStr(Object obj) {
        if (obj == null) {
            return "null";
        }
        String valueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(valueOf)) {
            return "null";
        }
        return valueOf;
    }

    private String getVersionCode(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return "" + InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionName;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getLocalizedMessage());
            return "unknown";
        }
    }

    private void initDefaultMap() {
        this.map.put("attaid", AudienceReportConst.VAL_REPORT_ID);
        this.map.put("token", AudienceReportConst.VAL_TOKEN);
        this.map.put(AudienceReportConst.CLIENT_TYPE, "401");
        this.map.put(AudienceReportConst.TERMINAL_TYPE, "Android");
        this.map.put("bundle", AudienceReportConst.VAL_BUNDLE);
        this.map.put(AudienceReportConst.PROTOCOL, "1");
        this.map.put(AudienceReportConst.TERMINAL_BRAND, getStr(null));
        this.map.put(AudienceReportConst.TERMINAL_MODEL, getStr(null));
        this.map.put("os_version", getStr(null));
        this.map.put("app_version_code", getStr(null));
        this.map.put("network_type", getStr(null));
        this.map.put(AudienceReportConst.ANCHOR_ID, getStr(0));
        this.map.put(AudienceReportConst.ANCHOR_NAME, getStr(null));
        this.map.put(AudienceReportConst.ROOM_ID, getStr(0));
        this.map.put(AudienceReportConst.ROOM_NAME, getStr(null));
        this.map.put("user_id", getStr(0));
        this.map.put(AudienceReportConst.USER_NAME, getStr(null));
        this.map.put(AudienceReportConst.ENTER_ROOM_DURATION, getStr(0));
        this.map.put("uuid", getStr(null));
        this.map.put(AudienceReportConst.FIRST_FRAME_DURATION, getStr(0));
        this.map.put("url", getStr(null));
        this.map.put("resolution", getStr(null));
        this.map.put("play_duration", getStr(0));
        this.map.put(AudienceReportConst.LATENCY, getStr(0));
    }

    private void putBaseIntoToMap() {
        this.map.put("attaid", AudienceReportConst.VAL_REPORT_ID);
        this.map.put("token", AudienceReportConst.VAL_TOKEN);
        this.map.put(AudienceReportConst.CLIENT_TYPE, "401");
        this.map.put(AudienceReportConst.TERMINAL_TYPE, "Android");
        this.map.put(AudienceReportConst.TERMINAL_BRAND, getStr(brand));
        this.map.put(AudienceReportConst.TERMINAL_MODEL, getStr(model));
        this.map.put("os_version", getStr(osVersion));
        this.map.put("app_version_code", getStr(appVersionCode));
        this.map.put("bundle", AudienceReportConst.VAL_BUNDLE);
        this.map.put("network_type", getStr(this.networkType));
        this.map.put("user_id", getStr(userId));
        this.map.put(AudienceReportConst.USER_NAME, getStr(userName));
        this.map.put("uuid", getStr(this.uuid));
    }

    private void putEvent(int i3) {
        putEvent(i3, "0");
    }

    private void report() {
        c.m(new ConcurrentHashMap(this.map));
    }

    public void initBaseInfo(Context context, IQQLiveSDK iQQLiveSDK, String str) {
        IQQLiveModuleLogin loginModule;
        LiveUserInfo userInfo;
        if (TextUtils.isEmpty(brand)) {
            brand = Build.BRAND;
        }
        if (TextUtils.isEmpty(model)) {
            model = DeviceInfoMonitor.getModel();
        }
        if (TextUtils.isEmpty(osVersion)) {
            osVersion = "" + Build.VERSION.SDK_INT;
        }
        if (TextUtils.isEmpty(appVersionCode)) {
            appVersionCode = getVersionCode(context);
        }
        if ((TextUtils.isEmpty(userId) || TextUtils.isEmpty(userName)) && (loginModule = iQQLiveSDK.getLoginModule()) != null && (userInfo = loginModule.getUserInfo()) != null) {
            userId = "" + userInfo.uid;
            userName = userInfo.nick;
        }
        this.networkType = e.a(context);
        this.uuid = str;
        putBaseIntoToMap();
    }

    public void onAudioBreak() {
        putEvent(AudienceReportConst.EVENT_ID_AUDIO_BREAK);
    }

    public void onAudioResume() {
        putEvent(AudienceReportConst.EVENT_ID_AUDIO_RESUME);
    }

    public void onBufferEnd(long j3) {
        putEvent(AudienceReportConst.EVENT_ID_BUFFER_END, "" + j3);
    }

    public void onBufferStart() {
        putEvent(AudienceReportConst.EVENT_ID_BUFFER_START);
    }

    public void onDefinitionChange(boolean z16) {
        if (z16) {
            putEvent(AudienceReportConst.EVENT_ID_DEFINITION_CHANGE_SUCCESS);
        } else {
            putEvent(AudienceReportConst.EVENT_ID_DEFINITION_CHANGE_FAILURE);
        }
    }

    public void onEnterRoomFailure(int i3, String str) {
        putEvent(AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE, i3 + " " + str);
    }

    public void onEnterRoomSuccess(long j3) {
        this.map.put(AudienceReportConst.ENTER_ROOM_DURATION, getStr(Long.valueOf(j3)));
        putEvent(AudienceReportConst.EVENT_ID_ENTER_ROOM_SUCCESS);
    }

    public void onFirstFrameEvent(long j3) {
        this.map.put(AudienceReportConst.FIRST_FRAME_DURATION, getStr(Long.valueOf(j3)));
        putEvent(100108);
    }

    public void onLatency(float f16) {
        this.map.put(AudienceReportConst.LATENCY, f16 + "");
        putEvent(AudienceReportConst.EVENT_ID_LATENCY);
    }

    public void onNetworkChange() {
        String b16 = e.b(BaseApplication.getContext());
        this.networkType = b16;
        this.map.put("network_type", getStr(b16));
        putEvent(AudienceReportConst.EVENT_ID_NETWORK_CHANGE);
    }

    public void onPlayEnd(long j3) {
        this.map.put("play_duration", getStr(Long.valueOf(j3)));
        putEvent(100106);
    }

    public void onPlayError(int i3, String str, long j3) {
        this.map.put("play_duration", getStr(Long.valueOf(j3)));
        putEvent(100107, i3 + " " + str);
    }

    public void onPlayPause() {
        putEvent(100104);
    }

    public void onPlayPrepare(StreamType streamType, String str) {
        this.isFirstResolutionChange = true;
        if (streamType == StreamType.TRTC) {
            this.map.put(AudienceReportConst.PROTOCOL, "2");
        } else {
            this.map.put(AudienceReportConst.PROTOCOL, "1");
        }
        this.map.put("url", getStr(str));
    }

    public void onPlayResume() {
        putEvent(100105);
    }

    public void onPlayStart(String str) {
        this.map.put("url", getStr(str));
        putEvent(AudienceReportConst.EVENT_ID_PLAY_START);
    }

    public void onResolutionChange(String str, String str2) {
        this.map.put("url", getStr(str));
        this.map.put("resolution", getStr(str2));
        if (!this.isFirstResolutionChange) {
            putEvent(AudienceReportConst.EVENT_ID_RESOLUTION_CHANGE);
        }
        this.isFirstResolutionChange = false;
    }

    public void setAnchorInfo(long j3, String str) {
        this.map.put(AudienceReportConst.ANCHOR_ID, getStr(Long.valueOf(j3)));
        this.map.put(AudienceReportConst.ANCHOR_NAME, getStr(str));
    }

    public void setRoomInfo(long j3, String str) {
        this.map.put(AudienceReportConst.ROOM_ID, getStr(Long.valueOf(j3)));
        this.map.put(AudienceReportConst.ROOM_NAME, getStr(str));
    }

    private void putEvent(int i3, String str) {
        this.map.put("event_id", getStr(Integer.valueOf(i3)));
        this.map.put("event_code", getStr(str));
        report();
    }
}
