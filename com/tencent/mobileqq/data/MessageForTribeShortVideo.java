package com.tencent.mobileqq.data;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTribeShortVideo extends MessageForStructing {
    public static final String KEY_BRIEF_BG_COLOR = "briefBgColor";
    public static final String KEY_THEME_NAME = "tribe_video_theme";
    public static final String KEY_TRIBE_NAME = "tribe_name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VID = "tribe_video_vid";
    public static final String KEY_VIDEO_HEIGHT = "tribe_video_height";
    public static final String KEY_VIDEO_URL = "tribe_video_url";
    public static final String KEY_VIDEO_WIDTH = "tribe_video_width";
    public static final String TAG = "MessageForTribeShortVideo";
    public String bid;
    public String brief;
    public int briefBgColor;
    public String coverImgUrl;
    public String jumpUrl;
    public String mVid;
    public String msgAction;
    public String pid;
    public String sourceActionType;
    public String sourceJumpUrl;
    public String srcAction;
    public String srcName;
    public String themeName;
    public int videoHeight;
    public String videoUrl;
    public int videoWidth;

    public static String buildCompatibleText() {
        return HardCodeUtil.qqStr(R.string.f172170o14) + "QQ" + HardCodeUtil.qqStr(R.string.o1v);
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) this.structingMsg;
        if (structMsgForGeneralShare.mMsgBrief.length() > 68) {
            this.brief = structMsgForGeneralShare.mMsgBrief.substring(0, 68);
        } else {
            this.brief = structMsgForGeneralShare.mMsgBrief;
        }
        this.srcAction = structMsgForGeneralShare.mSourceAction;
        this.msgAction = structMsgForGeneralShare.mMsgAction;
        this.jumpUrl = structMsgForGeneralShare.mMsgUrl;
        this.sourceJumpUrl = structMsgForGeneralShare.mSourceUrl;
        this.coverImgUrl = structMsgForGeneralShare.mContentCover;
        try {
            JSONObject jSONObject = new JSONObject(structMsgForGeneralShare.mTribeShortVideoExtra);
            this.srcName = jSONObject.optString("tribe_name");
            this.videoUrl = jSONObject.optString("tribe_video_url");
            this.briefBgColor = jSONObject.optInt("briefBgColor");
            this.videoWidth = jSONObject.optInt("tribe_video_width");
            this.videoHeight = jSONObject.optInt("tribe_video_height");
            this.mVid = jSONObject.optString("tribe_video_vid");
            this.themeName = jSONObject.optString("tribe_video_theme");
            this.bid = jSONObject.optString("tribe_bid");
            this.pid = jSONObject.optString("tribe_pid");
            if (this.themeName.length() > 68) {
                this.themeName = this.themeName.substring(0, 68);
            }
            if (this.briefBgColor == 0) {
                this.briefBgColor = Color.parseColor("#000000");
            }
            this.briefBgColor = (this.briefBgColor & 16777215) | (-671088640);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "doParse exp:" + structMsgForGeneralShare.mTribeShortVideoExtra + ", " + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (!TextUtils.isEmpty(this.themeName)) {
            return HardCodeUtil.qqStr(R.string.o1m) + this.themeName;
        }
        if (!TextUtils.isEmpty(this.brief)) {
            return HardCodeUtil.qqStr(R.string.o0y) + this.brief;
        }
        return HardCodeUtil.qqStr(R.string.f172175o23);
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return "MessageForTribeShortVideo{mVid='" + this.mVid + "', videoUrl='" + this.videoUrl + "', coverImgUrl=" + this.coverImgUrl + ", srcName='" + this.srcName + "', srcAction='" + this.sourceActionType + "', sourceJumpUrl='" + this.sourceJumpUrl + "'}";
    }
}
