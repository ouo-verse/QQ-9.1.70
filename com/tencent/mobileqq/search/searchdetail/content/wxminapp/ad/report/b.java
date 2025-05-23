package com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes18.dex */
final class b {

    @SerializedName("advert_group_id")
    public String advertGroupId;

    @SerializedName("aid")
    public String aid;

    @SerializedName(SsoReporter.POS_ID_KEY)
    public String posId;

    @SerializedName("query")
    public String query;

    @SerializedName("report_link")
    public String reportLink;

    @SerializedName("search_ad_extra_data")
    public String searchAdExtraData;

    @SerializedName("trace_id")
    public String traceId;

    @SerializedName(TVKDataBinder.KEY_REPORT_TYPE)
    public int reportType = 0;

    @SerializedName("exposure_type")
    public int exposureType = 0;

    @SerializedName("client_timestamp")
    public long clientTimestamp = 0;

    public boolean a() {
        boolean z16;
        if (this.reportType != 0 && !TextUtils.isEmpty(this.reportLink) && !TextUtils.isEmpty(this.advertGroupId) && !TextUtils.isEmpty(this.aid) && !TextUtils.isEmpty(this.traceId) && this.clientTimestamp != 0 && !TextUtils.isEmpty(this.query) && !TextUtils.isEmpty(this.posId) && !TextUtils.isEmpty(this.searchAdExtraData)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.reportType == 1) {
            if (!z16 || this.exposureType == 0) {
                return false;
            }
            return true;
        }
        return z16;
    }

    @NonNull
    public String toString() {
        return op2.a.e(this, "{}");
    }
}
