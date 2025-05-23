package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQWalletGdtAdApi extends QRouteApi {
    public static final String TAG = "QWalletGdtAdApi";
    public static final String WALLET_PUB_AD_TAG = "isShowQWalletPubAd";

    void handlePubRefreshList(List<ChatMessage> list);

    void handlePubTailMsg(im_msg_body$GeneralFlags im_msg_body_generalflags, MessageRecord messageRecord);

    void reportEvent(String str, String str2, String str3, String str4, String str5);
}
