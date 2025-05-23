package com.tencent.mobileqq.utils.confighandler;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QAVFunCallConfig extends ConfigInfo {
    public static final String TAG = "QAVConfig_382";
    final TreeMap<Integer, FCItem> fcItems = new TreeMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class FCItem {
        int fcid = 0;
        long begin = 0;
        long end = 0;
        String media = null;
        int downloadStatus = 0;

        public String toString() {
            return "fcid[" + this.fcid + "], begin[" + this.begin + "], end[" + this.end + "], media[" + this.media + "], edownloadStatusnd[" + this.downloadStatus + "]";
        }
    }

    public int getActivityFCId() {
        for (Map.Entry<Integer, FCItem> entry : this.fcItems.entrySet()) {
            if (ConfigUtil.isActivity(entry.getValue().begin, entry.getValue().end)) {
                return entry.getValue().fcid;
            }
        }
        return 0;
    }

    public FCItem getFCItem(int i3) {
        for (FCItem fCItem : this.fcItems.values()) {
            if (fCItem.fcid == i3) {
                return fCItem;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigInfo
    protected boolean parse(JSONObject jSONObject) {
        ConfigHandler.checkUin(TAG, this.mUin);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    if (jSONObject2.has("fcid") && jSONObject2.has("begin") && jSONObject2.has("end") && jSONObject2.has(QAdVrReportParams.ParamKey.MEDIA)) {
                        FCItem fCItem = new FCItem();
                        fCItem.fcid = jSONObject2.optInt("fcid");
                        fCItem.begin = simpleDateFormat.parse(jSONObject2.optString("begin")).getTime();
                        fCItem.end = simpleDateFormat.parse(jSONObject2.optString("end")).getTime();
                        fCItem.media = jSONObject2.optString(QAdVrReportParams.ParamKey.MEDIA);
                        this.fcItems.put(Integer.valueOf(fCItem.fcid), fCItem);
                    }
                    QLog.w(TAG, 1, "parse, \u7f3a\u5c11\u5b57\u6bb5\uff0c[" + jSONObject2.toString() + "]");
                }
            }
            return true;
        } catch (Exception e16) {
            this.fcItems.clear();
            QLog.w(TAG, 1, "parseJson, Exception", e16);
            return false;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("Size[");
        sb5.append(this.fcItems.size());
        sb5.append("]");
        for (FCItem fCItem : this.fcItems.values()) {
            sb5.append("\n");
            sb5.append(fCItem);
        }
        return sb5.toString();
    }
}
