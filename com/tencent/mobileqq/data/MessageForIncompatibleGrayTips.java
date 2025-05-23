package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForIncompatibleGrayTips extends ChatMessage {
    private String TAG = "Q.msg.IncompatibleGrayTips";
    public int linkStart = 0;
    public int linkEnd = 0;
    public String url = null;

    public MessageForIncompatibleGrayTips() {
        this.msgtype = MessageRecord.MSG_TYPE_INCOMPATIBLE_GRAY_TIPS;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        IncompatibleGrayTipsMessage incompatibleGrayTipsMessage;
        try {
            incompatibleGrayTipsMessage = (IncompatibleGrayTipsMessage) MessagePkgUtils.getObjectFromBytes(this.msgData);
        } catch (Exception e16) {
            e16.printStackTrace();
            incompatibleGrayTipsMessage = null;
        }
        if (incompatibleGrayTipsMessage != null) {
            this.linkStart = incompatibleGrayTipsMessage.linkStart;
            this.linkEnd = incompatibleGrayTipsMessage.linkEnd;
            this.f203106msg = incompatibleGrayTipsMessage.f203086msg;
            this.url = incompatibleGrayTipsMessage.url;
        }
    }

    public Boolean parseTextXML(String str) {
        Boolean bool = Boolean.FALSE;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            String str2 = null;
            String str3 = null;
            String str4 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 2) {
                    if (eventType == 3 && "PromptConfig".equalsIgnoreCase(newPullParser.getName()) && str4 != null) {
                        bool = Boolean.TRUE;
                    }
                } else if ("PromptConfig".equalsIgnoreCase(newPullParser.getName())) {
                    str4 = newPullParser.getAttributeValue(null, "content").trim();
                    str3 = newPullParser.getAttributeValue(null, "urlshowtext").trim();
                    str2 = newPullParser.getAttributeValue(null, "url").trim();
                }
            }
            if (bool.booleanValue()) {
                if (str2 != null && str2.length() > 0 && str3 != null && str3.length() > 0) {
                    int indexOf = str4.indexOf("$URL$");
                    if (indexOf >= 0) {
                        this.linkStart = indexOf;
                        this.linkEnd = indexOf + str3.length();
                        this.url = str2;
                        this.f203106msg = str4.replace("$URL$", str3);
                    }
                } else {
                    this.linkStart = 0;
                    this.linkEnd = 0;
                    this.f203106msg = str4;
                    this.url = null;
                }
            }
        } catch (Exception e16) {
            this.linkStart = 0;
            this.linkEnd = 0;
            this.f203106msg = null;
            this.url = null;
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, e16.getMessage(), e16);
            }
        }
        if (bool.booleanValue()) {
            serial();
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
        ReportController.o(null, "CliOper", "", String.valueOf(this.frienduin), "0X800491A", "0X800491A", 0, 0, "", "", "", "");
    }

    public void serial() {
        IncompatibleGrayTipsMessage incompatibleGrayTipsMessage = new IncompatibleGrayTipsMessage();
        incompatibleGrayTipsMessage.linkStart = this.linkStart;
        incompatibleGrayTipsMessage.linkEnd = this.linkEnd;
        incompatibleGrayTipsMessage.f203086msg = this.f203106msg;
        incompatibleGrayTipsMessage.url = this.url;
        try {
            this.msgData = MessagePkgUtils.getBytesFromObject(incompatibleGrayTipsMessage);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
