package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForQCircleFeed extends ChatMessage {
    public static final String MSG_QCIRCLE_FEED_KEY_ACTION_URL = "actionUrl";
    public static final String MSG_QCIRCLE_FEED_KEY_APPID = "appid";
    public static final String MSG_QCIRCLE_FEED_KEY_COMMENT_NUMS = "commentNums";
    public static final String MSG_QCIRCLE_FEED_KEY_CONTENT = "content";
    public static final String MSG_QCIRCLE_FEED_KEY_CONTENT_JUMP_URL = "contentJumpUrl";
    public static final String MSG_QCIRCLE_FEED_KEY_COVER_URL = "coverImageUrl";
    public static final String MSG_QCIRCLE_FEED_KEY_FEEDID = "feedid";
    public static final String MSG_QCIRCLE_FEED_KEY_FROM_UIN = "fromuin";
    public static final String MSG_QCIRCLE_FEED_KEY_IMAGE_COUNT = "imageCount";
    public static final String MSG_QCIRCLE_FEED_KEY_IS_FIRST_MSG_WITH_NEWFRIEND = "isFirstMsgWithNewFriend";
    public static final String MSG_QCIRCLE_FEED_KEY_LBS_INFO = "lbsinfo";
    public static final String MSG_QCIRCLE_FEED_KEY_LIKE_COUNT = "likeCount";
    public static final String MSG_QCIRCLE_FEED_KEY_LIKE_NUMS = "likeNums";
    public static final String MSG_QCIRCLE_FEED_KEY_MEDIA_DATAS = "mediaDatas";
    public static final String MSG_QCIRCLE_FEED_KEY_PUSH_COUNT = "pushCount";
    public static final String MSG_QCIRCLE_FEED_KEY_SUMMERY = "summery";
    public static final String MSG_QCIRCLE_FEED_KEY_TIME = "time";
    public static final String MSG_QCIRCLE_FEED_KEY_TITLE = "title";
    public static final String MSG_QCIRCLE_FEED_KEY_TYPE = "type";
    public static final String MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT = "videoCount";
    public static final String MSG_QCIRCLE_FEED_LEY_BUSI_DATA = "busiData";
    public static final String MSG_QCIRCLE_FEED_LEY_EXTEND_INFO = "mapExt";
    public static final String MSG_QCIRCLE_STRUCT_VERSION = "version";
    public static final int MSG_QCIRCLE_VERSION = 2;
    public String actionUrl;
    public int appId;
    public String content;
    public String contentJumpUrl;
    public String coverImageUrl;
    public String feedId;
    public JSONObject feedMsg;
    public long feedTime;
    public long fromUin;
    public boolean hasExposed;
    public int imageCount;
    public String lbsInfo;
    public int likeCount;
    public HashMap<String, String> mapExt;
    public ArrayList<MediaData> mediaDatas;
    public int pushCount;
    public String summery;
    public String title;
    public int type;
    public int uCommentNum;
    public int ulikeNum;
    public int version;
    public boolean isOldStructMsg = false;
    public boolean isFirstMsgWithNewFriend = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MediaData {
        public String mediaUrl;
        public int type;

        public static MediaData createFromJson(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MediaData mediaData = new MediaData();
            JSONObject jSONObject = new JSONObject(str);
            mediaData.mediaUrl = jSONObject.optString("mediaUrl");
            mediaData.type = jSONObject.optInt("type");
            return mediaData;
        }

        public String toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mediaUrl", this.mediaUrl);
            jSONObject.put("type", this.type);
            return jSONObject.toString();
        }
    }

    public MessageForQCircleFeed() {
        this.msgtype = MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            if (QLog.isColorLevel()) {
                QLog.i("AIOQCircleFeed.QCircleFeeds", 2, "MessageForQCircleFeed doParse feedMsg:" + this.f203106msg);
            }
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.feedMsg = jSONObject;
            this.appId = jSONObject.optInt("appid");
            this.feedId = this.feedMsg.optString("feedid");
            this.fromUin = this.feedMsg.optLong("fromuin");
            this.feedTime = this.feedMsg.optLong("time");
            this.lbsInfo = this.feedMsg.optString("lbsinfo");
            this.summery = this.feedMsg.optString("summery");
            this.title = this.feedMsg.optString("title");
            this.content = this.feedMsg.optString("content");
            this.coverImageUrl = this.feedMsg.optString("coverImageUrl");
            this.imageCount = this.feedMsg.optInt("imageCount");
            this.pushCount = this.feedMsg.optInt(MSG_QCIRCLE_FEED_KEY_PUSH_COUNT);
            this.likeCount = this.feedMsg.optInt(MSG_QCIRCLE_FEED_KEY_LIKE_COUNT);
            this.actionUrl = this.feedMsg.optString("actionUrl");
            this.ulikeNum = this.feedMsg.optInt("likeNums");
            this.uCommentNum = this.feedMsg.optInt("commentNums");
            this.isFirstMsgWithNewFriend = this.feedMsg.optBoolean("isFirstMsgWithNewFriend");
            this.type = this.feedMsg.optInt("type");
            this.version = this.feedMsg.optInt("version");
            this.contentJumpUrl = this.feedMsg.optString(MSG_QCIRCLE_FEED_KEY_CONTENT_JUMP_URL);
            if (this.version < 2) {
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
                QLog.d("AIOQCircleFeed", 2, "convert msg to json failed,error msg is:" + e16.getMessage(), e16);
            }
            this.isread = true;
        }
    }

    public MessageForQCircleFeed(MessageRecord messageRecord) {
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
        this.msgtype = MessageRecord.MSG_TYPE_QCIRCLE_NEWEST_FEED;
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
