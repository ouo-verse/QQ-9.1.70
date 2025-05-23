package com.tencent.mobileqq.vas.qvip;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qqgamepub.data.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.a;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.structmsg.view.c;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQVipMsgInfo implements Serializable {
    public static final int MSG_TYPE_ARK = 1;
    public static final int MSG_TYPE_IMGHEADER = 2;
    public static final int MSG_TYPE_TEXTHEADER = 3;
    public String busInfo;
    public String mActionUrl;
    public String mAdvId;
    public String mAmsMessageClickUrl;
    public String mAmsMessageExposeUrl;
    public String mAmsRPClickUrl;
    public String mAmsRPExposeUrl;
    public String mArkAppConfig;
    public String mArkAppMinVersion;
    public String mArkAppName;
    public String mArkAppView;
    public int mArkHeight;
    public String mArkMetaList;
    public float mArkScale;
    public int mArkWidth;
    public String mContentText;
    public String mCoverUrl;
    public String mDateTitle;
    public String mExtJson;
    public String mFrienduin;
    public String mGameAppId;
    public String mLimitText;
    public long mMsgTime;
    public int mMsgType;
    public String mPaMsgid;
    public String mSortedConfigs;
    public String mTaskId;
    public String mTitle;
    public String mTriggerInfo;
    public long mUniseq;
    public String mUrl;
    public boolean mIsGameArk = false;
    public boolean mIsAmsAdv = false;
    public boolean mAmsAdvHeaderReported = false;
    public boolean mAmsAdvMsgReported = false;
    public boolean isKuikly = false;

    private static boolean a(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo, ArrayList<AbsStructMsgElement> arrayList) {
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) instanceof a) {
                ArrayList<AbsStructMsgElement> arrayList2 = ((a) arrayList.get(i3)).U0;
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    if (arrayList2.get(i16) instanceof StructMsgItemTitle) {
                        z16 = true;
                    } else if (arrayList2.get(i16) instanceof c) {
                        z17 = true;
                    }
                    if (z16 && z17) {
                        i(messageRecord, qQVipMsgInfo);
                        return true;
                    }
                }
            }
        }
        if (!z16) {
            return false;
        }
        l(messageRecord, qQVipMsgInfo);
        return true;
    }

    @Nullable
    private static QQVipMsgInfo b(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        ArrayList arrayList;
        try {
            arrayList = (ArrayList) ((StructMsgForGeneralShare) ((MessageForStructing) messageRecord).structingMsg).getStructMsgItemLists();
        } catch (Throwable th5) {
            QLog.e("QQVipMsgInfo", 1, "createHeader failed structMsg error=" + th5.toString());
        }
        if (arrayList == null) {
            return null;
        }
        if (a(messageRecord, qQVipMsgInfo, arrayList)) {
            return qQVipMsgInfo;
        }
        if (arrayList.size() == 2) {
            l(messageRecord, qQVipMsgInfo);
            return qQVipMsgInfo;
        }
        return qQVipMsgInfo;
    }

    private static boolean c(boolean z16, boolean z17) {
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    private static boolean d(QQVipMsgInfo qQVipMsgInfo, StringBuilder sb5, boolean z16, ArrayList<AbsStructMsgElement> arrayList) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) instanceof ap) {
                String str = ((ap) arrayList.get(i3)).X0;
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                    z16 = true;
                }
            }
            if (arrayList.get(i3) instanceof StructMsgItemButton) {
                String str2 = ((StructMsgItemButton) arrayList.get(i3)).f290327h;
                if (TextUtils.isEmpty(qQVipMsgInfo.mUrl) && !TextUtils.isEmpty(str2)) {
                    qQVipMsgInfo.mUrl = str2;
                }
            }
        }
        return z16;
    }

    private static boolean e(QQVipMsgInfo qQVipMsgInfo, ArrayList<AbsStructMsgElement> arrayList, int i3, ArrayList<AbsStructMsgElement> arrayList2) {
        boolean z16 = false;
        boolean z17 = false;
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            if ((arrayList2.get(i16) instanceof StructMsgItemTitle) && !z16) {
                qQVipMsgInfo.mTitle = ((StructMsgItemTitle) arrayList2.get(i16)).X0;
                z16 = true;
            } else if ((arrayList2.get(i16) instanceof c) && !z17) {
                qQVipMsgInfo.mCoverUrl = ((c) arrayList2.get(i16)).S0;
                z17 = true;
            }
            j(qQVipMsgInfo, arrayList2, i16);
            if (c(z16, z17) && !TextUtils.isEmpty(qQVipMsgInfo.mUrl)) {
                break;
            }
        }
        if (TextUtils.isEmpty(arrayList.get(i3).f290327h)) {
            if (!VasToggle.BUG_YUNYING.isEnable(true)) {
                qQVipMsgInfo.mUrl = arrayList.get(i3).f290327h;
            }
        } else {
            qQVipMsgInfo.mUrl = arrayList.get(i3).f290327h;
        }
        return c(z16, z17);
    }

    private static void f(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        if (messageRecord instanceof MessageForArkApp) {
            MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
            try {
                ArkAppMessage arkAppMessage = messageForArkApp.ark_app_message;
                qQVipMsgInfo.mGameAppId = arkAppMessage.mSourceName;
                qQVipMsgInfo.mArkAppMinVersion = arkAppMessage.appMinVersion;
                qQVipMsgInfo.mArkAppName = arkAppMessage.appName;
                qQVipMsgInfo.mArkAppView = arkAppMessage.appView;
                qQVipMsgInfo.mArkMetaList = arkAppMessage.metaList;
                qQVipMsgInfo.mArkAppConfig = arkAppMessage.config;
                parseArkAdvInfo(messageForArkApp, qQVipMsgInfo);
                return;
            } catch (Throwable th5) {
                QLog.e("QQVipMsgInfo", 1, "MessageForArkApp error =" + th5.toString());
                return;
            }
        }
        if (messageRecord instanceof MessageForStructing) {
            try {
                StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) ((MessageForStructing) messageRecord).structingMsg;
                ArrayList arrayList = (ArrayList) structMsgForGeneralShare.getStructMsgItemLists();
                if (arrayList != null && !k(qQVipMsgInfo, arrayList) && arrayList.size() == 2) {
                    qQVipMsgInfo.mGameAppId = b.c(structMsgForGeneralShare.mMsgUrl);
                }
            } catch (Throwable th6) {
                QLog.e("QQVipMsgInfo", 1, "createHeader failed structMsg error=" + th6.toString());
            }
        }
    }

    private static void g(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        boolean z16;
        String str;
        if (messageRecord instanceof MessageForArkApp) {
            ArkAppMessage arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message;
            if (arkAppMessage != null && (str = arkAppMessage.metaList) != null) {
                z16 = str.contains("posId=237");
            } else {
                z16 = false;
            }
            qQVipMsgInfo.mIsGameArk = z16;
        }
    }

    private static void h(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        qQVipMsgInfo.mMsgType = 1;
        if (messageRecord instanceof MessageForArkApp) {
            try {
                ArkAppMessage arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message;
                qQVipMsgInfo.mArkAppMinVersion = arkAppMessage.appMinVersion;
                qQVipMsgInfo.mArkAppName = arkAppMessage.appName;
                qQVipMsgInfo.mArkAppView = arkAppMessage.appView;
                qQVipMsgInfo.mArkMetaList = arkAppMessage.metaList;
            } catch (Throwable th5) {
                QLog.e("QQVipMsgInfo", 1, "MessageForArkApp error =" + th5.toString());
            }
        }
    }

    private static void i(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        qQVipMsgInfo.mMsgType = 2;
        boolean z16 = messageRecord instanceof MessageForStructing;
        if (!z16) {
            return;
        }
        if (z16) {
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) ((MessageForStructing) messageRecord).structingMsg;
            ArrayList arrayList = (ArrayList) structMsgForGeneralShare.getStructMsgItemLists();
            qQVipMsgInfo.mUrl = structMsgForGeneralShare.mMsgUrl;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if ((arrayList.get(i3) instanceof a) && e(qQVipMsgInfo, arrayList, i3, ((a) arrayList.get(i3)).U0)) {
                    return;
                }
            }
            return;
        }
        if (messageRecord instanceof MessageForPubAccount) {
            MessageForPubAccount messageForPubAccount = (MessageForPubAccount) messageRecord;
            PAMessage pAMessage = (PAMessage) ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(messageForPubAccount.msgData);
            messageForPubAccount.mPAMessage = pAMessage;
            qQVipMsgInfo.mCoverUrl = pAMessage.items.get(0).cover;
            qQVipMsgInfo.mTitle = messageForPubAccount.mPAMessage.items.get(0).title;
            qQVipMsgInfo.mUrl = messageForPubAccount.mPAMessage.items.get(0).url;
        }
    }

    private static void j(QQVipMsgInfo qQVipMsgInfo, ArrayList<AbsStructMsgElement> arrayList, int i3) {
        if ((arrayList.get(i3) instanceof StructMsgItemButton) && TextUtils.isEmpty(qQVipMsgInfo.mUrl)) {
            String str = ((StructMsgItemButton) arrayList.get(i3)).f290327h;
            if (!TextUtils.isEmpty(str)) {
                qQVipMsgInfo.mUrl = str;
            }
        }
    }

    private static boolean k(QQVipMsgInfo qQVipMsgInfo, ArrayList<AbsStructMsgElement> arrayList) {
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) instanceof a) {
                ArrayList<AbsStructMsgElement> arrayList2 = ((a) arrayList.get(i3)).U0;
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    if (arrayList2.get(i16) instanceof StructMsgItemTitle) {
                        z16 = true;
                    } else if (arrayList2.get(i16) instanceof c) {
                        z17 = true;
                    }
                    if (z16 && z17) {
                        qQVipMsgInfo.mGameAppId = b.c(arrayList.get(i3).f290327h);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void l(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        qQVipMsgInfo.mMsgType = 3;
        if (!(messageRecord instanceof MessageForStructing)) {
            return;
        }
        AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
        if (!(absStructMsg instanceof StructMsgForGeneralShare)) {
            return;
        }
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg;
        ArrayList arrayList = (ArrayList) structMsgForGeneralShare.getStructMsgItemLists();
        qQVipMsgInfo.mTitle = ((StructMsgItemTitle) ((a) arrayList.get(0)).U0.get(0)).X0;
        StringBuilder sb5 = new StringBuilder();
        qQVipMsgInfo.mUrl = structMsgForGeneralShare.mMsgUrl;
        boolean z16 = false;
        for (int i3 = 1; i3 < arrayList.size(); i3++) {
            z16 = d(qQVipMsgInfo, sb5, z16, ((a) arrayList.get(i3)).U0);
            if (z16) {
                sb5.append("\n");
                z16 = false;
            }
        }
        qQVipMsgInfo.mContentText = sb5.toString();
    }

    public static void parseArkAdvInfo(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        if (messageRecord instanceof MessageForArkApp) {
            try {
                JSONObject jSONObject = new JSONObject(((MessageForArkApp) messageRecord).ark_app_message.metaList);
                boolean z16 = false;
                if (!jSONObject.keys().hasNext()) {
                    QLog.e("QQVipMsgInfo", 1, "parseArkAdvInfo fail, metaObj err, metaObj=", jSONObject);
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject((String) jSONObject.keys().next());
                if (jSONObject2 == null) {
                    QLog.e("QQVipMsgInfo", 1, "parseArkAdvInfo fail, arkDataObj is null");
                    return;
                }
                if (jSONObject2.optInt("is_ams", 0) == 1) {
                    z16 = true;
                }
                qQVipMsgInfo.mIsAmsAdv = z16;
                if (z16) {
                    qQVipMsgInfo.mAmsRPExposeUrl = jSONObject2.optString("redpoint_expose");
                    qQVipMsgInfo.mAmsRPClickUrl = jSONObject2.optString("redpoint_click");
                    qQVipMsgInfo.mAmsMessageExposeUrl = jSONObject2.optString("message_expose");
                    qQVipMsgInfo.mAmsMessageClickUrl = jSONObject2.optString("message_click");
                }
            } catch (Exception e16) {
                QLog.e("QQVipMsgInfo", 1, "parseArkAdvInfo fail, metaList, err=", e16);
            }
        }
    }

    public static QQVipMsgInfo parseMessageRecord(MessageRecord messageRecord) {
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQVipMsgInfo", 1, "parseMessageRecord-->record is null");
            }
            return null;
        }
        QQVipMsgInfo qQVipMsgInfo = new QQVipMsgInfo();
        qQVipMsgInfo.mUniseq = messageRecord.uniseq;
        qQVipMsgInfo.mFrienduin = messageRecord.frienduin;
        qQVipMsgInfo.mMsgTime = messageRecord.time;
        parseQGameInfo(messageRecord, qQVipMsgInfo);
        if (messageRecord instanceof MessageForArkApp) {
            h(messageRecord, qQVipMsgInfo);
            g(messageRecord, qQVipMsgInfo);
            parseArkAdvInfo(messageRecord, qQVipMsgInfo);
            return qQVipMsgInfo;
        }
        if (messageRecord instanceof MessageForStructing) {
            return b(messageRecord, qQVipMsgInfo);
        }
        if (!(messageRecord instanceof MessageForPubAccount)) {
            return null;
        }
        i(messageRecord, qQVipMsgInfo);
        return qQVipMsgInfo;
    }

    public static void parseQGameInfo(MessageRecord messageRecord, QQVipMsgInfo qQVipMsgInfo) {
        JSONObject jSONObject;
        String str = messageRecord.extStr;
        if (TextUtils.isEmpty(str) && (jSONObject = messageRecord.mExJsonObject) != null) {
            str = jSONObject.toString();
        }
        qQVipMsgInfo.mPaMsgid = q23.a.a(messageRecord);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (VasNormalToggle.VAS_PUBLIC_ACCOUNT_REPORT.isEnable(true)) {
                    String optString = new JSONObject(str).optString("oac_triggle", "");
                    if (!TextUtils.isEmpty(optString)) {
                        qQVipMsgInfo.mTriggerInfo = optString;
                        Bundle i3 = PublicAccountEventReport.i(optString);
                        qQVipMsgInfo.mAdvId = i3.getString("ad_id");
                        qQVipMsgInfo.busInfo = i3.getString("busi_info");
                    }
                } else {
                    String optString2 = new JSONObject(str).optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, "");
                    if (!TextUtils.isEmpty(optString2)) {
                        qQVipMsgInfo.mTriggerInfo = optString2;
                        qQVipMsgInfo.mAdvId = PublicAccountEventReport.d(optString2);
                        String optString3 = new JSONObject(optString2).optString("game_extra", "");
                        if (!TextUtils.isEmpty(optString3)) {
                            JSONObject jSONObject2 = new JSONObject(optString3);
                            JSONArray optJSONArray = jSONObject2.optJSONArray("sorted_configs");
                            if (optJSONArray != null) {
                                qQVipMsgInfo.mSortedConfigs = optJSONArray.toString();
                                qQVipMsgInfo.mGameAppId = optJSONArray.optJSONObject(0).optString("app_id", "");
                                qQVipMsgInfo.mTaskId = optJSONArray.optJSONObject(1).optString("task_id", "");
                            }
                            qQVipMsgInfo.mExtJson = jSONObject2.optString("ext_json", "");
                            return;
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("QQVipMsgInfo", 1, "get getGameMsgInfoByMsg  msg err= " + th5.getMessage());
                }
            }
        }
        f(messageRecord, qQVipMsgInfo);
    }

    public String getBusiInfo() {
        try {
            JSONObject jSONObject = new JSONObject(this.mArkMetaList);
            jSONObject.keys().next();
            String optString = jSONObject.optJSONObject((String) jSONObject.keys().next()).optString("DATA11");
            if (optString.contains("is_clm")) {
                return optString;
            }
            return "";
        } catch (Exception e16) {
            QLog.e("QQVipMsgInfo", 1, e16, new Object[0]);
            return "";
        }
    }
}
