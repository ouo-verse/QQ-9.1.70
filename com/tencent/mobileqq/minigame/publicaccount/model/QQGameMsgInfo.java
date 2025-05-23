package com.tencent.mobileqq.minigame.publicaccount.model;

import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQGameMsgInfo implements Serializable {
    public static final int MSG_TYPE_ARK = 1;
    private static final String TAG = "QQGameMsgInfo";
    public String actionUrl;
    public String advId;
    public String arkAppConfig;
    public String arkAppMinVersion;
    public String arkAppName;
    public String arkAppView;
    public String arkMetaList;
    public String contentText;
    public String coverUrl;
    public String dateTitle;
    public String extJson;
    public String frienduin;
    public String gameAppId;
    public String limitText;
    public long msgTime;
    public int msgType;
    public String paMsgid;
    public String sortedConfigs;
    public String taskId;
    public String title;
    public String triggerInfo;
    public long uniseq;
    public String url;

    public static QQGameMsgInfo parseMsgRecord(MsgRecord msgRecord) {
        if (11 != msgRecord.getMsgType()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "parseMessageRecord not valid message type");
            }
            return null;
        }
        QQGameMsgInfo qQGameMsgInfo = new QQGameMsgInfo();
        qQGameMsgInfo.uniseq = msgRecord.getMsgId();
        qQGameMsgInfo.frienduin = String.valueOf(msgRecord.getSenderUin());
        qQGameMsgInfo.msgTime = msgRecord.getMsgTime();
        if (msgRecord.getMsgType() != 11) {
            return null;
        }
        parseArkView(msgRecord, qQGameMsgInfo);
        return qQGameMsgInfo;
    }

    private static void parseArkView(MsgRecord msgRecord, QQGameMsgInfo qQGameMsgInfo) {
        ArkElement arkElement;
        qQGameMsgInfo.msgType = 1;
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        ArrayList<MsgElement> elements = msgRecord.getElements();
        if (elements.isEmpty() || (arkElement = elements.get(0).getArkElement()) == null) {
            return;
        }
        try {
            arkAppMessage.fromAppXml(arkElement.getBytesData());
            qQGameMsgInfo.arkAppMinVersion = arkAppMessage.appMinVersion;
            qQGameMsgInfo.arkAppName = arkAppMessage.appName;
            qQGameMsgInfo.arkAppView = arkAppMessage.appView;
            String str = arkAppMessage.metaList;
            qQGameMsgInfo.arkAppConfig = arkAppMessage.config;
            qQGameMsgInfo.arkMetaList = str;
            qQGameMsgInfo.contentText = arkAppMessage.promptText;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "MessageForArkApp error =" + th5.toString());
        }
    }
}
