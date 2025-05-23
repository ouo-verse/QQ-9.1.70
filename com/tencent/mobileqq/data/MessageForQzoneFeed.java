package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForQzoneFeed extends ChatMessage {
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final String MSG_QZONE_FEED_KEY_ACTION_URL = "actionUrl";
    public static final String MSG_QZONE_FEED_KEY_APPID = "appid";
    public static final String MSG_QZONE_FEED_KEY_COMMENT_NUMS = "commentNums";
    public static final String MSG_QZONE_FEED_KEY_CONTENT = "content";
    public static final String MSG_QZONE_FEED_KEY_COVER_URL = "coverImageUrl";
    public static final String MSG_QZONE_FEED_KEY_FROM_UIN = "fromuin";
    public static final String MSG_QZONE_FEED_KEY_GENDER = "iGender";
    public static final String MSG_QZONE_FEED_KEY_IMAGE_COUNT = "imageCount";
    public static final String MSG_QZONE_FEED_KEY_IS_FIRST_MSG_WITH_NEWFRIEND = "isFirstMsgWithNewFriend";
    public static final String MSG_QZONE_FEED_KEY_LBS_INFO = "lbsinfo";
    public static final String MSG_QZONE_FEED_KEY_LIKE_NUMS = "likeNums";
    public static final String MSG_QZONE_FEED_KEY_MEDIA_DATAS = "mediaDatas";
    public static final String MSG_QZONE_FEED_KEY_SUMMERY = "summery";
    public static final String MSG_QZONE_FEED_KEY_TIME = "time";
    public static final String MSG_QZONE_FEED_KEY_TITLE = "title";
    public static final String MSG_QZONE_FEED_LEY_EXTEND_INFO = "mapExt";
    public static final String MSG_QZONE_STRUCT_VERSION = "version";
    public static final int MSG_QZONE_VERSION = 2;
    public String actionUrl;
    public int appId;
    public String content;
    public String coverImageUrl;
    public JSONObject feedMsg;
    public long feedTime;
    public long fromUin;
    public boolean hasExposed;
    public int imageCount;
    public String lbsInfo;
    public HashMap<String, String> mapExt;
    public ArrayList<MediaData> mediaDatas;
    public String summery;
    public String title;
    public int uCommentNum;
    public int ulikeNum;
    public int version;
    public boolean isOldStructMsg = false;
    public boolean isFirstMsgWithNewFriend = false;
    public int gender = 0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MediaData {
        public Map<String, String> extendInfo;
        public String strImgUrl;
        public int uType;

        public static MediaData createFromJson(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MediaData mediaData = new MediaData();
            JSONObject jSONObject = new JSONObject(str);
            mediaData.strImgUrl = jSONObject.optString("strImgUrl");
            mediaData.uType = jSONObject.optInt("uType");
            String optString = jSONObject.optString("extendInfo");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                Iterator keys = jSONObject2.keys();
                mediaData.extendInfo = new HashMap();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    mediaData.extendInfo.put(str2, jSONObject2.optString(str2));
                }
            }
            return mediaData;
        }

        public String toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("strImgUrl", this.strImgUrl);
            jSONObject.put("uType", this.uType);
            Map<String, String> map = this.extendInfo;
            if (map != null && !map.isEmpty()) {
                jSONObject.put("extendInfo", new JSONObject(this.extendInfo).toString());
            }
            return jSONObject.toString();
        }
    }

    public MessageForQzoneFeed() {
        this.msgtype = MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            QLog.i("AIOQzoneFeed.QZoneFeeds", 1, "MessageForQzoneFeed doParse feedMsg:" + this.f203106msg);
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.feedMsg = jSONObject;
            this.appId = jSONObject.optInt("appid");
            this.fromUin = this.feedMsg.optLong("fromuin");
            this.feedTime = this.feedMsg.optLong("time");
            this.lbsInfo = this.feedMsg.optString("lbsinfo");
            this.summery = this.feedMsg.optString("summery");
            this.title = this.feedMsg.optString("title");
            this.content = this.feedMsg.optString("content");
            this.coverImageUrl = this.feedMsg.optString("coverImageUrl");
            this.imageCount = this.feedMsg.optInt("imageCount");
            this.actionUrl = this.feedMsg.optString("actionUrl");
            this.ulikeNum = this.feedMsg.optInt("likeNums");
            this.uCommentNum = this.feedMsg.optInt("commentNums");
            this.isFirstMsgWithNewFriend = this.feedMsg.optBoolean("isFirstMsgWithNewFriend");
            this.gender = this.feedMsg.optInt(MSG_QZONE_FEED_KEY_GENDER);
            int optInt = this.feedMsg.optInt("version");
            this.version = optInt;
            if (optInt < 2) {
                this.isOldStructMsg = true;
            }
            String optString = this.feedMsg.optString("mediaDatas");
            if (!TextUtils.isEmpty(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    this.mediaDatas = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        this.mediaDatas.add(MediaData.createFromJson(jSONArray.getString(i3)));
                    }
                }
            }
            String optString2 = this.feedMsg.optString("mapExt");
            if (!TextUtils.isEmpty(optString2)) {
                JSONObject jSONObject2 = new JSONObject(optString2);
                Iterator keys = jSONObject2.keys();
                this.mapExt = new HashMap<>();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    this.mapExt.put(str, jSONObject2.optString(str));
                }
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOQzoneFeed", 2, "convert msg to json failed,error msg is:" + e16.getMessage(), e16);
            }
            this.isread = true;
        }
    }

    public MessageForQzoneFeed(MessageRecord messageRecord) {
        this.extInt = messageRecord.extInt;
        this.extLong = messageRecord.extLong;
        this.extraflag = messageRecord.extraflag;
        this.extStr = messageRecord.extStr;
        this.frienduin = messageRecord.frienduin;
        this.isread = messageRecord.isread;
        this.issend = messageRecord.issend;
        this.istroop = messageRecord.istroop;
        this.isValid = messageRecord.isValid;
        this.longMsgCount = messageRecord.longMsgCount;
        this.longMsgId = messageRecord.longMsgId;
        this.longMsgIndex = messageRecord.longMsgIndex;
        this.f203106msg = messageRecord.f203106msg;
        this.msgData = messageRecord.msgData;
        this.msgseq = messageRecord.msgseq;
        this.msgtype = MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED;
        this.msgUid = messageRecord.msgUid;
        this.selfuin = messageRecord.selfuin;
        this.senderuin = messageRecord.senderuin;
        this.sendFailCode = messageRecord.sendFailCode;
        this.shmsgseq = messageRecord.shmsgseq;
        this.time = messageRecord.time;
        this.uniseq = messageRecord.uniseq;
        this.versionCode = messageRecord.versionCode;
        this.vipBubbleID = messageRecord.vipBubbleID;
    }
}
