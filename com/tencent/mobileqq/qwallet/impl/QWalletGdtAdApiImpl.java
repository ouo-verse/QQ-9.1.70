package com.tencent.mobileqq.qwallet.impl;

import android.text.TextUtils;
import com.qwallet.temp.IStructmsgApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QWalletGdtAdApiImpl implements IQWalletGdtAdApi {
    private String getMsgExtendStr(generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.bytes_oac_msg_extend.has() && generalflags_resvattr.bytes_oac_msg_extend.get() != null) {
            String trim = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8().trim();
            if (trim.startsWith("{") && trim.endsWith("}")) {
                return trim;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletGdtAdApi
    public void handlePubRefreshList(List<ChatMessage> list) {
        String account = d.g().getAccount();
        String string = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(account, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_TITLE, "");
        String string2 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(account, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_JUMP_URL, "");
        boolean z16 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            ChatMessage chatMessage = list.get(size);
            if (!z16 && ((IStructmsgApi) QRoute.api(IStructmsgApi.class)).instanceofMessageForStructing(chatMessage) && "1".equals(chatMessage.getExtInfoFromExtStr("wallet_ad_msg")) && (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2))) {
                chatMessage.isShowQWalletPubAd = true;
                z16 = true;
            } else {
                chatMessage.isShowQWalletPubAd = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(IQWalletGdtAdApi.TAG, 2, "list,time:" + en.i(chatMessage.time * 1000) + ",isShowQWalletPubAd:" + chatMessage.isShowQWalletPubAd);
            }
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletGdtAdApi
    public void handlePubTailMsg(im_msg_body$GeneralFlags im_msg_body_generalflags, MessageRecord messageRecord) {
        if (!TextUtils.isEmpty(((IStructmsgApi) QRoute.api(IStructmsgApi.class)).getBirthdayReminder(messageRecord))) {
            com.tencent.mobileqq.qwallet.c.e("public.birthmessage.receive", NetConnInfoCenter.getServerTimeMillis() + "", "", "", "");
        }
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                String msgExtendStr = getMsgExtendStr(generalflags_resvattr);
                if (msgExtendStr != null) {
                    String optString = new JSONObject(msgExtendStr).optString("money_extra");
                    if (!TextUtils.isEmpty(optString) && new JSONObject(optString).optInt("gdt_flg") == 1) {
                        ((IStructmsgApi) QRoute.api(IStructmsgApi.class)).handleStructMsgElement(messageRecord);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(IQWalletGdtAdApi.TAG, 1, "parse wallet ad tail fail:", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletGdtAdApi
    public void reportEvent(String str, String str2, String str3, String str4, String str5) {
        if (d.n() == null) {
            return;
        }
        com.tencent.mobileqq.qwallet.c.e(str, str2, str3, str4, str5);
    }
}
