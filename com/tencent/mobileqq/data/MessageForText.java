package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.eqq.CrmIvrText;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.f;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForText extends BaseMessageForText {
    private static final boolean DEBUG_LOG = true;
    public static final int SPAN_TYPE_EMOJI = 1;
    public static final int SPAN_TYPE_LINK = 0;
    public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
    private static final String TAG = "MessageForText";
    public String action;
    public CharSequence charStr;
    public CharSequence charStr2;
    public boolean mIsMsgSignalOpen;
    public long mMsgSendTime;
    public int mMsgSignalCount;
    public int mMsgSignalNetType;
    public int mMsgSignalSum;
    public int mPasswdRedBagFlag;
    public long mPasswdRedBagSender;
    public long mWantGiftSenderUin;
    public int msgVia;
    public boolean mPlaySendAnimation = false;
    public boolean mAddPreObersever = false;

    public static ArrayList<AtTroopMemberInfo> getTroopMemberInfoFromExtrJson(String str) {
        if (str.startsWith("{")) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("0");
                if (optJSONArray != null) {
                    str = optJSONArray.toString();
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        ArrayList<AtTroopMemberInfo> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                AtTroopMemberInfo fromJson = AtTroopMemberInfo.setFromJson(jSONArray.getJSONObject(i3));
                if (fromJson != null) {
                    arrayList.add(fromJson);
                }
            }
            return arrayList;
        } catch (JSONException e17) {
            QLog.e(TAG, 1, e17, new Object[0]);
            return null;
        }
    }

    private void parseStickerMsg() {
        StickerInfo transformFromJson;
        if (EmojiStickerManager.t(this) && (this.extLong & 4) > 0 && EmojiStickerManager.f204583t) {
            System.currentTimeMillis();
            String extInfoFromExtStr = getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                if (this.msgtype == -1000) {
                    this.msgtype = MessageRecord.MSG_TYPE_STICKER_MSG;
                }
                StickerInfo transformFromJson2 = StickerInfo.transformFromJson(extInfoFromExtStr);
                if (transformFromJson2 != null) {
                    transformFromJson2.isDisplayed = this.isread;
                    this.stickerInfo = transformFromJson2;
                    System.currentTimeMillis();
                    return;
                }
                return;
            }
            return;
        }
        if (this.msgtype == -2058) {
            String extInfoFromExtStr2 = getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr2) && (transformFromJson = StickerInfo.transformFromJson(extInfoFromExtStr2)) != null) {
                transformFromJson.isDisplayed = this.isread;
                this.stickerInfo = transformFromJson;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[RETURN] */
    @Override // com.tencent.mobileqq.data.RecommendCommonMessage, com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        boolean parseBoolean;
        super.doParse();
        boolean z16 = false;
        doParse(false);
        String extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_need_parse");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                parseBoolean = Boolean.parseBoolean(extInfoFromExtStr);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (parseBoolean && (BaseActivity.sTopActivity instanceof MultiForwardActivity)) {
                parseBoolean = false;
            }
            if (parseBoolean) {
                return;
            }
            String extInfoFromExtStr2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
            if (TextUtils.isEmpty(extInfoFromExtStr2)) {
                return;
            }
            String extInfoFromExtStr3 = getExtInfoFromExtStr("sens_msg_confirmed");
            if (!TextUtils.isEmpty(extInfoFromExtStr3) && extInfoFromExtStr3.equalsIgnoreCase("1")) {
                z16 = true;
            }
            if (!z16) {
                saveExtInfoToExtStr("sens_msg_original_text", this.f203106msg);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(this);
            MQPSensitiveMsgUtil.k(this, copyOnWriteArrayList, z16, HexUtil.hexStr2Bytes(extInfoFromExtStr2));
            return;
        }
        parseBoolean = true;
        if (parseBoolean) {
            parseBoolean = false;
        }
        if (parseBoolean) {
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        CharSequence charSequence = this.charStr;
        if (charSequence == null) {
            return this.f203106msg;
        }
        return charSequence.toString();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        return ad.s(this.istroop);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
        parseStickerMsg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        String extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_original_text");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            extInfoFromExtStr = this.f203106msg;
        }
        this.f203106msg = extInfoFromExtStr;
        this.msgData = extInfoFromExtStr.getBytes();
    }

    public void setSendMsgParams(ChatActivityFacade.d dVar) {
        this.mMsgSignalSum = dVar.f175139c;
        this.mMsgSignalCount = dVar.f175140d;
        this.mIsMsgSignalOpen = dVar.f175141e;
        this.mMsgSignalNetType = dVar.f175142f;
        this.mMsgSendTime = dVar.f175143g;
        this.mPasswdRedBagFlag = dVar.f175153q;
        this.mPasswdRedBagSender = dVar.f175152p;
        if (this instanceof MessageForFoldMsg) {
            ((MessageForFoldMsg) this).foldFlagTemp = dVar.f175154r;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    public void doParse(boolean z16) {
        String str;
        int i3;
        int i16;
        String str2 = this.f203106msg;
        if (this.msgtype == -1003) {
            MsgBody a16 = com.tencent.mobileqq.utils.c.a(str2);
            this.action = a16.action;
            str2 = a16.f24895msg;
        }
        if (this.msgtype == -2039) {
            str2 = ((IApolloUtil) QRoute.api(IApolloUtil.class)).getApolloMessageDesc(this);
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        int i17 = this.istroop;
        if (i17 == 1008) {
            com.tencent.biz.widgets.c cVar = new com.tencent.biz.widgets.c(str3, 45);
            this.charStr = cVar;
            cVar.f97765d = this.selfuin;
            cVar.f97766e = this.frienduin;
            cVar.setBizSrc(((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(this.frienduin));
            str = TAG;
            i3 = 45;
            i16 = 2;
        } else {
            if (i17 == 1024 && !isSendFromLocal()) {
                ?? r16 = 0;
                r16 = 0;
                r16 = 0;
                AppRuntime appRuntime = null;
                try {
                    appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin);
                    if (QQAppInterface.class.isInstance(appRuntime)) {
                        r16 = CrmUtils.o((QQAppInterface) appRuntime, this.frienduin, this.istroop);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "We get error AppRuntime");
                    }
                } catch (AccountNotMatchException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[1];
                        objArr[r16] = this.selfuin;
                        QLog.e(TAG, 2, String.format("User %s don't match current accound", objArr));
                    }
                }
                if (r16 != 0) {
                    str = TAG;
                    i3 = 45;
                    this.charStr = new CrmIvrText(str3, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this, this.frienduin, this.selfuin, (QQAppInterface) appRuntime);
                } else {
                    str = TAG;
                    i3 = 45;
                    this.charStr = new QQText(str3, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this);
                }
                ((QQText) this.charStr).setBizSrc("biz_src_jc_aio");
            } else {
                str = TAG;
                i3 = 45;
                int i18 = this.istroop;
                if (i18 == 1045 || i18 == 1044 || i18 == 1046) {
                    this.charStr = new QQText(str3, 5, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this);
                    if (QLog.isColorLevel()) {
                        i16 = 2;
                        QLog.d(str, 2, "limit chat, dont parse url:" + this.uniseq);
                    }
                }
            }
            i16 = 2;
        }
        if (this.istroop == 1047) {
            this.charStr = new com.tencent.mobileqq.matchfriend.b(str3, 5, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this);
        } else {
            this.charStr = f.u(str3, this, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), i3);
            String extInfoFromExtStr = getExtInfoFromExtStr("disc_at_info_list");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                StringBuilder sb5 = new StringBuilder(str3);
                try {
                    AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
                    if (QQAppInterface.class.isInstance(runtime)) {
                        String sb6 = com.tencent.mobileqq.troop.text.a.k((QQAppInterface) runtime, sb5, extInfoFromExtStr, this.frienduin, isSend()).toString();
                        this.msg2 = sb6;
                        CharSequence u16 = f.u(sb6, this, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), i3);
                        this.charStr2 = u16;
                        if (u16 instanceof QQText) {
                            ((QQText) u16).setBizSrc("biz_src_jc_aio");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(str, i16, "We get error AppRuntime");
                    }
                } catch (Exception e17) {
                    QLog.e(str, 1, "replaceAtMsgByMarkName", e17);
                }
            }
        }
        CharSequence charSequence = this.charStr;
        if (charSequence instanceof QQText) {
            ((QQText) charSequence).setBizSrc("biz_src_jc_aio");
        }
    }
}
