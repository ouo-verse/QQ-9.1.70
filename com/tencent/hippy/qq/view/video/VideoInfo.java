package com.tencent.hippy.qq.view.video;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class VideoInfo {
    public int busiType;
    public String coverUrl;
    public Map<String, Object> dtExtraParams = new HashMap();
    public int dtPageId;
    public int duration;
    public int fromType;
    public int height;
    public boolean isAd;
    public String recommendBitrate;
    public String rowkey;
    public String title;
    public String vid;
    public String videoUrl;
    public int width;
    public long xgFileSize;

    public VideoInfo() {
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("business_type", this.busiType);
        jSONObject.put("vid", this.vid);
        jSONObject.put("width", this.width);
        jSONObject.put("height", this.height);
        jSONObject.put("duration", this.duration);
        jSONObject.put("cover_url", this.coverUrl);
        jSONObject.put("title", this.title);
        jSONObject.put("xg_file_size", this.xgFileSize);
        jSONObject.put("video_url", this.videoUrl);
        jSONObject.put("recommendBitrate", this.recommendBitrate);
        return jSONObject;
    }

    public String toString() {
        return "VideoInfo{busiType=" + this.busiType + ", vid='" + this.vid + "', width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", coverUrl='" + this.coverUrl + "', title='" + this.title + "', xgFileSize=" + this.xgFileSize + ", videoUrl='" + this.videoUrl + "', recommendBitrate=" + this.recommendBitrate + "'}";
    }

    public VideoInfo(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY)) {
            this.busiType = jSONObject.getInt(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY);
        }
        if (jSONObject.has("vid")) {
            this.vid = jSONObject.getString("vid");
        }
        if (jSONObject.has("width")) {
            this.width = jSONObject.getInt("width");
        }
        if (jSONObject.has("height")) {
            this.height = jSONObject.getInt("height");
        }
        if (jSONObject.has("duration")) {
            this.duration = jSONObject.getInt("duration");
        }
        if (jSONObject.has(QAdVrReport.ElementID.AD_POSTER)) {
            this.coverUrl = jSONObject.getString(QAdVrReport.ElementID.AD_POSTER);
        }
        if (jSONObject.has("title")) {
            this.title = jSONObject.getString("title");
        }
        if (jSONObject.has("xgFileSize")) {
            this.xgFileSize = jSONObject.getLong("xgFileSize");
        }
        if (jSONObject.has(AppConstants.Key.KEY_QZONE_VIDEO_URL)) {
            this.videoUrl = jSONObject.getString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        }
        if (jSONObject.has(IProfileCardConst.KEY_FROM_TYPE)) {
            this.fromType = jSONObject.getInt(IProfileCardConst.KEY_FROM_TYPE);
        }
        if (jSONObject.has("dt_pgid")) {
            this.dtPageId = jSONObject.optInt("dt_pgid");
        }
        if (jSONObject.has("isAd")) {
            this.isAd = jSONObject.optBoolean("isAd");
        }
        if (jSONObject.has("dt_extraParams") && (optJSONObject = jSONObject.optJSONObject("dt_extraParams")) != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.dtExtraParams.put(str, optJSONObject.optString(str));
            }
            this.rowkey = optJSONObject.optString("rowkey");
        }
        if (jSONObject.has("recommendBitrate")) {
            this.recommendBitrate = jSONObject.getString("recommendBitrate");
        }
    }
}
