package com.tencent.mobileqq.data;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.MonitorManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForBirthdayNotice extends ChatMessage {
    public static final String MSG_BIRTHDAY_NOTICE_BACKGROUND = "background";
    public static final String MSG_BIRTHDAY_NOTICE_BLESSING = "blessing";
    public static final String MSG_BIRTHDAY_NOTICE_FRIEND_UIN = "friendUin";
    public static final String MSG_BIRTHDAY_NOTICE_ICON = "icon";
    public static final String MSG_BIRTHDAY_NOTICE_LINK = "link";
    public static final String MSG_BIRTHDAY_NOTICE_TIME = "time";
    private static final String TAG = "MessageForBirthdayNotice";
    public JSONObject feedMsg;
    public String friendUin = "";
    public String birthday = "";
    public String icon = "";
    public String blessing = "";
    public String doufu_link = "";
    public String background = "";

    public MessageForBirthdayNotice() {
        this.msgtype = MessageRecord.MSG_TYPE_BIRTHDAY_NOTICE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "MessageForBirthdayNotice doParse feedMsg:" + this.f203106msg);
            }
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            this.feedMsg = jSONObject;
            this.friendUin = jSONObject.optString("friendUin");
            String optString = this.feedMsg.optString("time");
            try {
                long parseLong = Long.parseLong(optString) * 24 * 60 * 60 * 1000;
                Date parse = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).parse(optString);
                Calendar.getInstance().setTimeInMillis(parseLong);
                this.birthday = new SimpleDateFormat("M\u6708d\u65e5").format(parse);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "exception getting time");
                MonitorManager.f().h(19, 9, "\u89e3\u6790\u65e5\u671f\u9519\u8bef " + optString + e16, false);
            }
            this.icon = this.feedMsg.optString("icon");
            this.blessing = this.feedMsg.optString(MSG_BIRTHDAY_NOTICE_BLESSING);
            this.doufu_link = this.feedMsg.optString(MSG_BIRTHDAY_NOTICE_LINK);
            this.background = this.feedMsg.optString("background");
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "convert msg to json failed,error msg is:" + e17.getMessage(), e17);
            }
            MonitorManager.f().h(19, 4, " json \u89e3\u6790\u5f02\u5e38 " + e17, false);
            this.isread = true;
        }
    }
}
