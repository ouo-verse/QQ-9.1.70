package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForQQStory extends MessageForStructing {
    public static final String KEY_AUTHOR_NAME = "authorName";
    public static final String KEY_BRIEF_BG_COLOR = "briefBgColor";
    public static final String KEY_COVER_IMG_URL = "coverImgUrl";
    public static final String KEY_HEAD_TIP = "headtip";
    public static final String KEY_LOGO_IMG_URL = "logoImgUrl";
    public static final String KEY_STORY_BRIEF = "storyBrief";
    public static final String KEY_STORY_TITLE = "storyTitle";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VID = "vid";
    public static final String TAG = "MessageForQQStory";
    public static final int TYPE_GUEST_FEED_LIST = 9;
    public static final int TYPE_GUEST_SINGLE = 6;
    public static final int TYPE_INFO_CARD = 7;
    public static final int TYPE_PGC_STORY = 0;
    public static final int TYPE_SELF_FEED_LIST = 8;
    public static final int TYPE_SHARE_BANNER = 13;
    public static final int TYPE_SHARE_GROUP_CARD_SHARE = 10;
    public static final int TYPE_SHARE_GROUP_MULTI_VIDEO = 11;
    public static final int TYPE_SHARE_GROUP_SINGLE_VIDEO = 12;
    public static final int TYPE_UGC_HOT_STORY = 2;
    public static final int TYPE_UGC_MY_STORY = 1;
    public String authorName;
    public String brief;
    public int briefBgColor;
    public String coverImgUrl;
    public String logoImgUrl;
    public Map<String, String> mAttrMap;
    public String mHeadTip;
    public int mShareType;
    public String mVid;
    public String msgAction;
    public String srcAction;
    public String srcName;
    public String storyBrief;
    public String storyTitle;
    public int type = 1;

    public static String buildCompatibleText(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str2 + HardCodeUtil.qqStr(R.string.o2b) + str3 + HardCodeUtil.qqStr(R.string.o28) + "QQ" + HardCodeUtil.qqStr(R.string.o1g);
        }
        return str + "-" + str2 + HardCodeUtil.qqStr(R.string.o1r) + str3 + HardCodeUtil.qqStr(R.string.o26) + "QQ" + HardCodeUtil.qqStr(R.string.o1b);
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) this.structingMsg;
        this.brief = structMsgForGeneralShare.mMsgBrief;
        this.srcName = structMsgForGeneralShare.mSourceName;
        this.srcAction = structMsgForGeneralShare.mSourceAction;
        this.msgAction = structMsgForGeneralShare.mMsgAction;
        try {
            JSONObject jSONObject = new JSONObject(structMsgForGeneralShare.mQQStoryExtra);
            this.coverImgUrl = jSONObject.optString(KEY_COVER_IMG_URL);
            this.logoImgUrl = jSONObject.optString(KEY_LOGO_IMG_URL);
            this.briefBgColor = jSONObject.optInt("briefBgColor");
            this.mHeadTip = jSONObject.optString(KEY_HEAD_TIP);
            this.mVid = jSONObject.optString("vid");
            this.mAttrMap = URLUtil.getArgumentsFromURL(this.msgAction);
            if (TextUtils.isEmpty(this.mVid)) {
                String str = this.mAttrMap.get("videoId");
                this.mVid = str;
                if (TextUtils.isEmpty(str)) {
                    this.mVid = this.mAttrMap.get("videoid");
                }
            }
            if (this.briefBgColor == 0) {
                this.briefBgColor = Color.parseColor("#000000");
            }
            this.briefBgColor = (this.briefBgColor & 16777215) | (-671088640);
            this.authorName = jSONObject.optString(KEY_AUTHOR_NAME);
            this.storyTitle = jSONObject.optString(KEY_STORY_TITLE);
            this.storyBrief = jSONObject.optString(KEY_STORY_BRIEF);
            this.type = jSONObject.optInt("type");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.qqstory.share", 2, "doParse exp:" + structMsgForGeneralShare.mQQStoryExtra + ", " + e16.toString());
            }
        }
        this.f203106msg = getSummaryMsg();
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return "[" + this.srcName + "]" + this.brief;
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        String str;
        try {
            str = String.format("#%x", Integer.valueOf(this.briefBgColor));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.qqstory.share", 2, "toString exp:", e16);
            }
            str = "";
        }
        return "MessageForQQStory{coverImgUrl='" + this.coverImgUrl + "', logoImgUrl='" + this.logoImgUrl + "', brief='" + this.brief + "', briefBgColor=" + str + ", srcName='" + this.srcName + "', srcAction='" + this.srcAction + "', msgAction='" + this.msgAction + "', authorName='" + this.authorName + "', type='" + this.type + "', storyTitle='" + this.storyTitle + "', storyBrief='" + this.storyBrief + "'}";
    }
}
