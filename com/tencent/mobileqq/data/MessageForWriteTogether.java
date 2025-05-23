package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForWriteTogether extends MessageForText {
    private static final String TAG = "MessageForWriteTogether";
    public int baseRev;
    public boolean isLongMsg;
    public String padId;
    public int partCnt;
    public String token;

    public MessageForWriteTogether() {
        this.msgtype = -7014;
        this.isFlowMessage = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.RecommendCommonMessage, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        this.token = getExtInfoFromExtStr("write_together_token");
        this.padId = getExtInfoFromExtStr("write_together_pad_id");
        try {
            this.baseRev = Integer.valueOf(getExtInfoFromExtStr("write_together_base_rev")).intValue();
        } catch (Exception e16) {
            this.baseRev = 0;
            QLog.e(TAG, 1, "[doParse] read from db, baseRev parse error.", e16);
        }
        try {
            this.partCnt = Integer.valueOf(getExtInfoFromExtStr("write_together_part_cnt")).intValue();
        } catch (Exception e17) {
            this.partCnt = 1;
            QLog.e(TAG, 1, "[doParse] read from db, partCnt parse error.", e17);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[doParse] padId: " + this.padId + ", baseRev: " + this.baseRev + ", partCnt: " + this.partCnt);
        }
        this.isLongMsg = Boolean.parseBoolean(getExtInfoFromExtStr("write_together_long_msg"));
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isFollowMessage() {
        return false;
    }
}
