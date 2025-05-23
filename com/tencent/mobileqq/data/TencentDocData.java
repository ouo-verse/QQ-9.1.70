package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TencentDocData {
    public long aioTime;
    public long appid;
    public String creatorNick;
    public long creatorUid;
    public long creatorUin;
    public String docIcon;
    public int docStatus;
    public int docType;
    public String docUrl;
    public String ownerNick;
    public long ownerUid;
    public long ownerUin;
    public String peerTips;
    public long sendUin;
    public String title;
    public String url;
    String[] docId = new String[2];
    public String action = "web";
    public String sourceAction = HardCodeUtil.qqStr(R.string.u29);
    public int serviceId = 95;
    public String sourceName = HardCodeUtil.qqStr(R.string.f172771u25);
    public String summary = HardCodeUtil.qqStr(R.string.u2c);
    public String icon = ITeamWorkUtils.DOCS_SOURCE_ICON_URL;

    public static void obtainFromJsonObject(JSONObject jSONObject, JSONObject jSONObject2, TencentDocData tencentDocData) throws JSONException {
        JSONObject jSONObject3;
        if (jSONObject != null && (jSONObject3 = (JSONObject) jSONObject.opt("doc_meta")) != null) {
            JSONObject jSONObject4 = (JSONObject) jSONObject3.opt("doc_id");
            if (jSONObject4 != null) {
                tencentDocData.docId[0] = String.valueOf(jSONObject4.optLong("domain_id"));
                tencentDocData.docId[1] = jSONObject4.optString("pad_id");
            }
            tencentDocData.title = jSONObject3.optString("title");
            tencentDocData.creatorUin = jSONObject3.optLong("creator_uin");
            tencentDocData.ownerUin = jSONObject3.optLong(PhotoCacheData.OWNER_UIN);
            tencentDocData.creatorUid = jSONObject3.optLong("creator_uid");
            tencentDocData.ownerUid = jSONObject3.optLong("owner_uid");
            tencentDocData.docType = jSONObject3.optInt("doc_type");
            tencentDocData.docStatus = jSONObject3.optInt("doc_status");
            tencentDocData.docIcon = jSONObject3.optString("doc_icon");
            tencentDocData.creatorNick = jSONObject.optString("creator_nick");
            tencentDocData.ownerNick = jSONObject.optString("owner_nick");
            tencentDocData.docUrl = jSONObject.optString("doc_url");
            tencentDocData.aioTime = jSONObject.optLong("add_list_ts") * 1000;
        }
        if (jSONObject2 != null) {
            tencentDocData.action = jSONObject2.optString("action");
            tencentDocData.sourceAction = jSONObject2.optString("source_name");
            tencentDocData.serviceId = jSONObject2.optInt("service_id");
            tencentDocData.sourceName = jSONObject2.optString("source_name");
            tencentDocData.summary = jSONObject2.optString("summary");
            tencentDocData.icon = jSONObject2.optString("icon");
            tencentDocData.appid = jSONObject2.optLong("appid");
            tencentDocData.url = jSONObject2.optString("url");
            tencentDocData.sendUin = jSONObject2.optLong("send_uin");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TencentDocData)) {
            return false;
        }
        TencentDocData tencentDocData = (TencentDocData) obj;
        if (!tencentDocData.docId[0].equals(this.docId[0]) || !tencentDocData.docId[1].equals(this.docId[1]) || tencentDocData.aioTime != this.aioTime) {
            return false;
        }
        return true;
    }

    public String getBriefDes(Context context) {
        return context.getString(R.string.bai, getTitle());
    }

    public String getTitle() {
        try {
            if (TextUtils.isEmpty(this.title)) {
                return "";
            }
            String replaceAll = this.title.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            this.title = replaceAll;
            return URLDecoder.decode(replaceAll, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "";
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            return "";
        }
    }

    public JSONObject translate2JsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("doc_meta", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("doc_id", jSONObject3);
        jSONObject3.put("domain_id", this.docId[0]);
        jSONObject3.put("pad_id", this.docId[1]);
        long j3 = this.aioTime;
        if (j3 != 0) {
            jSONObject.put("add_list_ts", j3 / 1000);
        }
        return jSONObject;
    }
}
