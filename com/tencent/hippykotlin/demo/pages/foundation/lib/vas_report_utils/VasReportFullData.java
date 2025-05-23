package com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VasReportFullData {
    public final String app_version;
    public final String bundle_name;
    public final VasBusinessReportData businessData;
    public final int delta_time;
    public final int duration_time;
    public final int event_code;
    public final long event_time;
    public final String page_name;
    public final String platform;
    public final String session_id;
    public final String web_version;
    public final String sdk_version = "1.0.1";
    public final String report_src = "kuikly";

    public VasReportFullData(int i3, long j3, String str, String str2, String str3, String str4, String str5, String str6, int i16, int i17, VasBusinessReportData vasBusinessReportData) {
        this.event_code = i3;
        this.event_time = j3;
        this.session_id = str;
        this.bundle_name = str2;
        this.page_name = str3;
        this.platform = str4;
        this.app_version = str5;
        this.web_version = str6;
        this.duration_time = i16;
        this.delta_time = i17;
        this.businessData = vasBusinessReportData;
    }

    public final int hashCode() {
        BoxType$EnumUnboxingSharedUtility.ordinal(this.event_code);
        d.a(this.event_time);
        this.session_id.getClass();
        this.sdk_version.getClass();
        this.bundle_name.getClass();
        this.page_name.getClass();
        this.platform.getClass();
        this.app_version.getClass();
        this.web_version.getClass();
        this.report_src.getClass();
        this.businessData.getClass();
        throw null;
    }

    public final String toString() {
        this.businessData.getClass();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VasReportFullData)) {
            return false;
        }
        VasReportFullData vasReportFullData = (VasReportFullData) obj;
        return this.event_code == vasReportFullData.event_code && this.event_time == vasReportFullData.event_time && Intrinsics.areEqual(this.session_id, vasReportFullData.session_id) && Intrinsics.areEqual(this.sdk_version, vasReportFullData.sdk_version) && Intrinsics.areEqual(this.bundle_name, vasReportFullData.bundle_name) && Intrinsics.areEqual(this.page_name, vasReportFullData.page_name) && Intrinsics.areEqual(this.platform, vasReportFullData.platform) && Intrinsics.areEqual(this.app_version, vasReportFullData.app_version) && Intrinsics.areEqual(this.web_version, vasReportFullData.web_version) && this.duration_time == vasReportFullData.duration_time && this.delta_time == vasReportFullData.delta_time && Intrinsics.areEqual(this.report_src, vasReportFullData.report_src) && Intrinsics.areEqual(this.businessData, vasReportFullData.businessData);
    }
}
