package com.tencent.mobileqq.data;

import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForRichState extends ChatMessage {
    public static final int CLASS_ICON = 0;
    public static final int CLASS_IMAGE = 1;
    public static final String SIGN_MSG_ACTION_ID_KEY = "aid";
    public static final String SIGN_MSG_ACTION_TEXT_KEY = "actiontext";
    public static final String SIGN_MSG_DATA_ID_KEY = "did";
    public static final String SIGN_MSG_DATA_TEXT_KEY = "datatext";
    public static final String SIGN_MSG_FEED_ID_KEY = "feedid";
    public static final String SIGN_MSG_FEED_NUM_KEY = "feednumtext";
    public static final String SIGN_MSG_FONT_ID = "fontId";
    public static final String SIGN_MSG_FONT_TYPE = "fontType";
    public static final String SIGN_MSG_LOC_TEXT_KEY = "loctext";
    public static final String SIGN_MSG_LOC_TEXT_POS_KEY = "loctextpos";
    public static final String SIGN_MSG_PLAIN_TEXT_KEY = "plaintext";
    public static final String SIGN_MSG_STICKER_KEY = "sticker";
    public static final String SIGN_MSG_TIME_KEY = "time";
    public static final String SIGN_MSG_TOPICS = "topics";
    public static final String SIGN_MSG_TOPICS_POS = "topicsPos";
    public static final String SIGN_MSG_TPL_ID_KEY = "tplid";
    public static final String SIGN_MSG_VER_KEY = "ver";
    public static final String SIGN_MSG_ZAN_COUNT_KEY = "count";
    public static final String SIGN_MSG_ZAN_FLAG_KEY = "zanfalg";
    public String actionId;
    public String actionText;
    public int clazz;
    public int count;
    public int data;
    public String dataId;
    public String dataText;
    public String feedId;
    public String feedNum;
    public int fontId;
    public int fontType;
    public boolean isRickSignState = false;
    public String locPos;
    public String locText;
    public ArrayList<RichStatus.StickerInfo> mStickerInfos;
    public JSONArray plainText;
    public JSONObject signMsg;
    public int size;
    public long time;
    public String topics;
    public String topicsPos;
    public int tplId;
    public int type;
    public String ver;
    public int zanFlag;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.signMsg = jSONObject;
            this.actionText = jSONObject.optString(SIGN_MSG_ACTION_TEXT_KEY);
            String optString = this.signMsg.optString(SIGN_MSG_DATA_TEXT_KEY);
            this.dataText = optString;
            if (optString != null && optString.length() > 0) {
                this.isRickSignState = true;
            } else {
                String str = this.actionText;
                if (str != null && str.length() > 0) {
                    this.isRickSignState = true;
                } else {
                    this.isRickSignState = false;
                }
            }
            String optString2 = this.signMsg.optString("ver");
            this.ver = optString2;
            if (optString2 != null && optString2.equals("1.0")) {
                this.time = Long.parseLong(this.signMsg.optString("time"));
                this.actionId = this.signMsg.optString("aid");
                this.dataId = this.signMsg.optString(SIGN_MSG_DATA_ID_KEY);
                this.plainText = this.signMsg.optJSONArray(SIGN_MSG_PLAIN_TEXT_KEY);
                this.locText = this.signMsg.optString(SIGN_MSG_LOC_TEXT_KEY);
                this.locPos = this.signMsg.optString(SIGN_MSG_LOC_TEXT_POS_KEY);
                this.feedNum = this.signMsg.optString(SIGN_MSG_FEED_NUM_KEY);
                this.feedId = this.signMsg.optString("feedid");
                this.tplId = this.signMsg.optInt(SIGN_MSG_TPL_ID_KEY);
                this.count = this.signMsg.optInt("count");
                this.zanFlag = this.signMsg.optInt(SIGN_MSG_ZAN_FLAG_KEY);
                this.topics = this.signMsg.optString(SIGN_MSG_TOPICS);
                this.topicsPos = this.signMsg.optString(SIGN_MSG_TOPICS_POS);
                JSONArray optJSONArray = this.signMsg.optJSONArray("sticker");
                if (optJSONArray != null) {
                    this.mStickerInfos = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        RichStatus.StickerInfo stickerInfo = new RichStatus.StickerInfo();
                        stickerInfo.f282152id = jSONObject2.optInt("id");
                        stickerInfo.posX = (float) jSONObject2.optDouble("posX");
                        stickerInfo.posY = (float) jSONObject2.optDouble("posY");
                        stickerInfo.width = (float) jSONObject2.optDouble("width");
                        stickerInfo.height = (float) jSONObject2.optDouble("height");
                        this.mStickerInfos.add(stickerInfo);
                    }
                }
                this.fontId = this.signMsg.optInt(SIGN_MSG_FONT_ID);
                this.fontType = this.signMsg.optInt(SIGN_MSG_FONT_TYPE);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOSign", 2, "convert msg to json failed,error msg is:" + e16.getMessage(), e16);
            }
            this.isRickSignState = false;
        }
    }

    public String getPlainMsg() {
        String str;
        JSONArray jSONArray = this.plainText;
        if (jSONArray != null && jSONArray.length() > 0) {
            str = this.plainText.optString(0);
        } else {
            str = "";
        }
        RichStatus richStatus = new RichStatus(str);
        richStatus.topicFromJson(this.topics);
        richStatus.topicPosFromJson(this.topicsPos);
        return richStatus.getPlainText();
    }
}
