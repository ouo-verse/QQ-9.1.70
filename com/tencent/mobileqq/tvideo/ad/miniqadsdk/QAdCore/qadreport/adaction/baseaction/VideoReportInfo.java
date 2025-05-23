package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VideoReportInfo implements Serializable {
    static final String OMGBIZID = "omgbizid";
    static final String USID = "usid";
    private final Map<String, Object> mPageReportInfo = new HashMap();
    private final Map<String, Object> mClickReportInfo = new HashMap();

    private void a() {
        Map<String, Object> d16 = w.d();
        if (d16 == null) {
            return;
        }
        Object obj = d16.get("usid");
        if (obj != null) {
            this.mClickReportInfo.put("usid", obj);
        }
        Object obj2 = d16.get(OMGBIZID);
        if (obj2 != null) {
            this.mClickReportInfo.put(OMGBIZID, obj2);
        }
    }

    public String getAllReportInfoJsonStr() {
        Map<String, Object> map;
        if (!y.i(this.mClickReportInfo) && (map = this.mPageReportInfo) != null) {
            map.putAll(this.mClickReportInfo);
            this.mPageReportInfo.put(QAdVrReportParams.ParamKey.REF_ELE, this.mClickReportInfo);
            return mw2.b.a(this.mPageReportInfo);
        }
        return null;
    }

    @NonNull
    public Map<String, Object> getClickReportInfo() {
        return this.mClickReportInfo;
    }

    @NonNull
    Map<String, Object> getPageReportInfo() {
        return this.mPageReportInfo;
    }

    public Map<String, Object> getReportInfoWithoutCurPg() {
        HashMap hashMap = new HashMap(this.mClickReportInfo);
        hashMap.remove("cur_pg");
        return hashMap;
    }

    public void setClickReportParams(Map<String, Object> map) {
        this.mClickReportInfo.clear();
        if (map != null && !map.isEmpty()) {
            this.mClickReportInfo.putAll(map);
            a();
        }
    }

    public void setPageReportParams(Map<String, Object> map) {
        this.mPageReportInfo.clear();
        if (map != null && !map.isEmpty()) {
            this.mPageReportInfo.putAll(map);
        }
    }
}
