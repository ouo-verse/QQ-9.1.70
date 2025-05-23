package com.tencent.bugly.common.reporter.link;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LinkData {
    private static final String LINK = ".";
    public static final long LINK_AFTER_INTERVAL_IN_SEC = 60;
    public static final long LINK_BEFORE_INTERVAL_IN_SEC = 3600;
    public String baseType = "";
    public String subType = "";
    public String launchID = "";
    public String processLaunchID = "";
    public String clientIdentify = "";
    public long eventTime = 0;
    public long eventTimeInMS = 0;

    public static LinkData fromJson(JSONObject jSONObject) {
        LinkData linkData = new LinkData();
        try {
            linkData.baseType = jSONObject.optString(ReportDataBuilder.KEY_BASE_TYPE);
            linkData.subType = jSONObject.optString("sub_type");
            linkData.launchID = jSONObject.optString(ReportDataBuilder.KEY_LAUNCH_ID);
            linkData.processLaunchID = jSONObject.optString(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID);
            linkData.clientIdentify = jSONObject.optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
            linkData.eventTime = jSONObject.optLong("event_time");
            linkData.eventTimeInMS = jSONObject.optLong(ReportDataBuilder.KEY_EVENT_TIME_IN_MS);
            return linkData;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkData linkData = (LinkData) obj;
        if (TextUtils.equals(this.baseType, linkData.baseType) && TextUtils.equals(this.subType, linkData.subType) && TextUtils.equals(this.launchID, linkData.launchID) && TextUtils.equals(this.processLaunchID, linkData.processLaunchID) && TextUtils.equals(this.clientIdentify, linkData.clientIdentify) && this.eventTime == linkData.eventTime && this.eventTimeInMS == linkData.eventTimeInMS) {
            return true;
        }
        return false;
    }

    public String getKey() {
        return this.baseType + "." + this.subType;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        String str = this.baseType;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = (527 + i3) * 31;
        String str2 = this.subType;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str3 = this.launchID;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str4 = this.processLaunchID;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str5 = this.clientIdentify;
        if (str5 != null) {
            i19 = str5.hashCode();
        }
        long j3 = this.eventTime;
        int i36 = (((i29 + i19) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.eventTimeInMS;
        return i36 + ((int) (j16 ^ (j16 >>> 32)));
    }

    public boolean isDesiredLinkage(LinkData linkData) {
        if (linkData == null || linkData.isInvalid() || !TextUtils.equals(this.processLaunchID, linkData.processLaunchID)) {
            return false;
        }
        long j3 = this.eventTime;
        long j16 = linkData.eventTime;
        long j17 = j3 - j16;
        long j18 = j16 - j3;
        if (j17 >= 3600 || j18 >= 60) {
            return false;
        }
        return true;
    }

    public boolean isInvalid() {
        if (!TextUtils.isEmpty(this.baseType) && !TextUtils.isEmpty(this.subType) && !TextUtils.isEmpty(this.launchID) && !TextUtils.isEmpty(this.processLaunchID) && this.eventTime != 0 && this.eventTimeInMS != 0) {
            return false;
        }
        return true;
    }
}
