package com.tencent.mobileqq.guild.message;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageRecordForLiveGift extends ChatMessage {
    public static final String EXT_INFO_KEY_COMBO_COUNT = "EXT_INFO_KEY_COMBO_COUNT";
    public static final String EXT_INFO_KEY_GIFT_ID = "EXT_INFO_KEY_GIFT_ID";
    public static final String EXT_INFO_KEY_GIFT_NAME = "EXT_INFO_KEY_GIFT_NAME";
    public static final String EXT_INFO_KEY_RECEIVER_UID = "EXT_INFO_KEY_RECEIVER_UID";
    public static final String EXT_INFO_KEY_SENDER_TINYID = "EXT_INFO_KEY_SENDER_TINYID";
    private static final String TAG = "MessageRecordForLiveGift";
    private String mSenderTinyId = "";
    private String mReceiverUid = "";
    private long mGiftId = 0;
    private long mGiftComboCount = 0;
    private String mGiftName = "";

    public MessageRecordForLiveGift() {
        this.msgtype = MessageRecord.MSG_TYPE_GUILD_LIVE_GIFT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        setSenderTinyId(getExtInfoFromExtStr(EXT_INFO_KEY_SENDER_TINYID));
        setReceiverUid(getExtInfoFromExtStr(EXT_INFO_KEY_RECEIVER_UID));
        setGiftName(getExtInfoFromExtStr(EXT_INFO_KEY_GIFT_NAME));
        String extInfoFromExtStr = getExtInfoFromExtStr(EXT_INFO_KEY_GIFT_ID);
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                this.mGiftId = Long.parseLong(extInfoFromExtStr);
            } catch (NumberFormatException unused) {
                QLog.e(TAG, 1, "doParse: parse giftIdStr error[" + extInfoFromExtStr + "]");
            }
        }
        String extInfoFromExtStr2 = getExtInfoFromExtStr(EXT_INFO_KEY_COMBO_COUNT);
        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
            try {
                this.mGiftComboCount = Long.parseLong(extInfoFromExtStr2);
            } catch (NumberFormatException unused2) {
                QLog.e(TAG, 1, "doParse: parse giftComboCountStr error[" + extInfoFromExtStr2 + "]");
            }
        }
    }

    public long getGiftComboCount() {
        return this.mGiftComboCount;
    }

    public long getGiftId() {
        return this.mGiftId;
    }

    public String getGiftName() {
        return this.mGiftName;
    }

    public String getReceiverUid() {
        return this.mReceiverUid;
    }

    public String getSenderTinyId() {
        return this.mSenderTinyId;
    }

    public void saveData() {
        saveExtInfoToExtStr(EXT_INFO_KEY_SENDER_TINYID, this.mSenderTinyId);
        saveExtInfoToExtStr(EXT_INFO_KEY_RECEIVER_UID, this.mReceiverUid);
        saveExtInfoToExtStr(EXT_INFO_KEY_GIFT_ID, String.valueOf(this.mGiftId));
        saveExtInfoToExtStr(EXT_INFO_KEY_GIFT_NAME, this.mGiftName);
        saveExtInfoToExtStr(EXT_INFO_KEY_COMBO_COUNT, String.valueOf(this.mGiftComboCount));
    }

    public void setGiftComboCount(long j3) {
        this.mGiftComboCount = j3;
    }

    public void setGiftId(long j3) {
        this.mGiftId = j3;
    }

    public void setGiftName(String str) {
        this.mGiftName = str;
    }

    public void setReceiverUid(String str) {
        this.mReceiverUid = str;
    }

    public void setSenderTinyId(String str) {
        this.mSenderTinyId = str;
    }
}
