package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForBeancurd extends ChatMessage {
    private static final String TAG = "MessageForBeancurd";
    private String background;
    private int beancurdStyle;
    private String busiExtra;
    private String busi_uuid;
    private long busiid;
    private List<Content> contentList;
    private Content description;
    private String icon;
    private OnlineStatus onlineStatus;
    private List<String> uinList;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Content {
        public String color;
        public String detail;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class OnlineStatus {
    }

    public MessageForBeancurd() {
        this.msgtype = -7016;
    }

    private void parseContentList(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("content_list")) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("content_list");
        this.contentList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Content content = new Content();
            content.detail = jSONObject2.optString("detail");
            content.color = jSONObject2.optString("color");
            this.contentList.add(content);
        }
    }

    private void parseUinList(JSONObject jSONObject) throws JSONException {
        this.uinList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("frd_uin");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.uinList.add(jSONArray.getString(i3));
        }
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public Entity deepCopyByReflect() {
        try {
            Entity deepCopyByReflect = super.deepCopyByReflect();
            ((MessageForBeancurd) deepCopyByReflect).doParse();
            ((MessageForBeancurd) deepCopyByReflect).setOnlineStatus(null);
            return deepCopyByReflect;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "deepCopyByReflect exception", e16);
            return super.deepCopyByReflect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        this.msgtype = -7016;
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.busiid = jSONObject.optLong("busiid");
            this.busi_uuid = jSONObject.optString("busi_uuid");
            this.beancurdStyle = jSONObject.optInt("beancurd_style");
            JSONObject jSONObject2 = jSONObject.getJSONObject("description");
            Content content = new Content();
            this.description = content;
            content.detail = jSONObject2.optString("detail");
            this.description.color = jSONObject2.optString("color");
            parseContentList(jSONObject);
            this.background = jSONObject.optString("background");
            this.icon = jSONObject.optString("busiicon");
            this.busiExtra = jSONObject.optString("busi_extra");
            parseUinList(jSONObject);
        } catch (JSONException e16) {
            QLog.d(TAG, 1, "doParse err: ", e16);
        }
    }

    public String getBackground() {
        return this.background;
    }

    public int getBeancurdStyle() {
        return this.beancurdStyle;
    }

    public String getBusiExtra() {
        return this.busiExtra;
    }

    public String getBusi_uuid() {
        return this.busi_uuid;
    }

    public long getBusiid() {
        return this.busiid;
    }

    public List<Content> getContentList() {
        return this.contentList;
    }

    public Content getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public OnlineStatus getOnlineStatus() {
        return null;
    }

    public List<String> getUinList() {
        return this.uinList;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean needShowTimeStamp() {
        long j3 = this.busiid;
        if (j3 == 0) {
            try {
                j3 = new JSONObject(this.f203106msg).optLong("busiid");
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "parse busiid error " + th5.toString());
            }
        }
        IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
        if (j3 == iZootopiaApi.getSuperQQShowBeancurdId() && iZootopiaApi.shouldHideSmallHomeEntry()) {
            return false;
        }
        return super.needShowTimeStamp();
    }

    public void setOnlineStatus(OnlineStatus onlineStatus) {
    }
}
