package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg$FoldMsg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForFoldMsg extends MessageForText {
    public boolean foldFlag;
    public boolean foldFlagTemp;
    public String redBagId;
    public String redBagIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.RecommendCommonMessage, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        doParse(false);
    }

    public void init(boolean z16, String str, String str2, long j3, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.redBagId = str;
        this.redBagIndex = str2;
        this.mPasswdRedBagSender = j3;
        this.foldFlag = z16;
        if (z17) {
            if (z16) {
                this.msgtype = -2006;
            } else {
                this.msgtype = -1000;
            }
            saveExtInfoToExtStr("redbag_fold_msg", "true");
        }
    }

    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        if (!this.foldFlag) {
            return super.isSupportFTS();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        boolean z16 = true;
        if (this.istroop != 1) {
            super.postRead();
            return;
        }
        RichMsg$FoldMsg richMsg$FoldMsg = new RichMsg$FoldMsg();
        try {
            richMsg$FoldMsg.mergeFrom(this.msgData);
            if (richMsg$FoldMsg.fold_flags.get() != 1) {
                z16 = false;
            }
            this.foldFlag = z16;
            this.redBagId = richMsg$FoldMsg.redbag_id.get().toStringUtf8();
            this.f203106msg = richMsg$FoldMsg.msg_content.get().toStringUtf8();
            this.mPasswdRedBagSender = richMsg$FoldMsg.redbag_sender_uin.get();
            String stringUtf8 = richMsg$FoldMsg.redbag_index.get().toStringUtf8();
            this.redBagIndex = stringUtf8;
            init(this.foldFlag, this.redBagId, stringUtf8, this.mPasswdRedBagSender, false);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("msgFold", 2, "MessageForFoldMsg postRead error ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        if (this.istroop != 1) {
            super.prewrite();
            return;
        }
        RichMsg$FoldMsg richMsg$FoldMsg = new RichMsg$FoldMsg();
        richMsg$FoldMsg.fold_flags.set(this.foldFlag ? 1 : 0);
        richMsg$FoldMsg.redbag_sender_uin.set(this.mPasswdRedBagSender);
        richMsg$FoldMsg.redbag_id.set(ByteStringMicro.copyFromUtf8(this.redBagId));
        richMsg$FoldMsg.msg_content.set(ByteStringMicro.copyFromUtf8(this.f203106msg));
        richMsg$FoldMsg.redbag_index.set(ByteStringMicro.copyFromUtf8(this.redBagIndex));
        this.msgData = richMsg$FoldMsg.toByteArray();
    }
}
