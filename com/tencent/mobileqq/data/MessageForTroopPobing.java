package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

/* loaded from: classes10.dex */
public class MessageForTroopPobing extends MessageForStructing {
    public static final int BIG_VIP_TEMPLATE = 2003;
    public static final int DEFAULT_TEMPLATE = 2000;
    public static final int SVIP_TEMPLATE = 2002;
    public static final String TAG = "MessageForTroopPobing";
    public static final int VIP_TEMPLATE = 2001;
    public String mBrief;
    public int mTemplateId;

    public static String buildCompatibleText() {
        return HardCodeUtil.qqStr(R.string.o27);
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        AbsStructMsg absStructMsg = this.structingMsg;
        if (absStructMsg != null) {
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg;
            String str = structMsgForGeneralShare.mMsgBrief;
            this.mBrief = str;
            this.f203106msg = str;
            this.mTemplateId = structMsgForGeneralShare.pobingTemplateId;
        }
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (TextUtils.isEmpty(this.f203106msg)) {
            return HardCodeUtil.qqStr(R.string.f172169o13);
        }
        return this.f203106msg;
    }

    @Override // com.tencent.mobileqq.data.MessageForStructing, com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return "MessageForTroopPobing{}";
    }
}
