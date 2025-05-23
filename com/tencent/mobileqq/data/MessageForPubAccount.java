package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class MessageForPubAccount extends ChatMessage {
    public static long INVALID_PUB_ACC_NUM;
    public long associatePubAccUin = INVALID_PUB_ACC_NUM;
    public PAMessage mPAMessage = null;

    public static String getMsgSummary(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        String str;
        ArrayList<PAMessage.Item> arrayList;
        String str2;
        String str3;
        PAMessage b16 = ap.b(messageRecord);
        if (b16 != null && (arrayList = b16.items) != null && arrayList.size() != 0) {
            String str4 = b16.items.get(0).title;
            String str5 = b16.items.get(0).cover;
            if (z16) {
                str2 = String.format(qQAppInterface.getApp().getString(R.string.etg), ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(qQAppInterface, BaseApplication.getContext()));
            } else {
                str2 = "";
            }
            if (str5 == null && b16.items.get(0).digestList != null) {
                str3 = str2 + str4 + "\uff1a" + b16.items.get(0).digestList.get(0);
            } else {
                str3 = str2 + str4;
            }
            if (TextUtils.isEmpty(str3)) {
                return qQAppInterface.getApp().getString(R.string.cqa);
            }
            return str3;
        }
        if (b16 == null || (str = b16.f203110msg) == null) {
            return qQAppInterface.getApp().getString(R.string.cqa);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        String str;
        try {
            PAMessage pAMessage = (PAMessage) ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(this.msgData);
            this.mPAMessage = pAMessage;
            if (pAMessage != null) {
                ArrayList<PAMessage.Item> arrayList = pAMessage.items;
                if ((arrayList == null || arrayList.size() == 0) && (str = this.mPAMessage.f203110msg) != null) {
                    this.f203106msg = str;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean isTextMsg() {
        PAMessage pAMessage;
        ArrayList<PAMessage.Item> arrayList;
        PAMessage pAMessage2 = this.mPAMessage;
        if ((pAMessage2 == null || (arrayList = pAMessage2.items) == null || arrayList.size() == 0) && (pAMessage = this.mPAMessage) != null && pAMessage.f203110msg != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        if (this.mPAMessage != null) {
            try {
                this.msgData = ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(this.mPAMessage);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
