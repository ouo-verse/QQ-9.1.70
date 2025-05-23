package com.tencent.mobileqq.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.trpcprotocol.qqva.channel_gift.Msg$ReserveInfo;
import com.tencent.trpcprotocol.qqva.channel_gift.Msg$msg;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForAioGift extends ChatMessage {
    public static int GIFT_LEVEL_ADVANCED = 4;
    public static int GIFT_LEVEL_HIGH_QUALITY = 3;
    public static int GIFT_LEVEL_LUXURY = 5;
    public static int GIFT_LEVEL_NORMAL = 2;
    public static int GIFT_LEVEL_PRIMARY = 1;
    public static int GIFT_TYPE_GUILD = 8;
    private static final String TAG = "MessageForAioGift";
    public long mGiftId = 0;
    public String mGiftName = "";
    public long mRecUin = 0;
    public String mRecNickname = "";
    public long mSendUin = 0;
    public String mSendNickName = "";
    public long mPrice = 0;
    public String mOrderId = "";
    public String mBgImage = "";
    public long mTianQuanId = 0;
    public String mSendIconUrl = "";
    public String mRecIconUrl = "";
    public int mGiftLevel = 0;
    public boolean mNeedShowGift = true;
    public boolean mNeedShowArk = false;
    public String mPaddingTop = "";
    public Msg$ReserveInfo mReserveInfo = null;
    public Msg$msg mGuildMsg = new Msg$msg();

    private void preLoadArk() {
        if (this.mTianQuanId == 0) {
            return;
        }
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(10010);
        com.tencent.mobileqq.qqgift.sdk.config.a b16 = com.tencent.mobileqq.qqgift.sdk.config.a.a().d(10010).a("m9iyc4gnzlkt9g7yq71v3v0oyi2xr3p3").b();
        if (sDKImpl != null && !sDKImpl.isInited()) {
            sDKImpl.c((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null), b16);
        }
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(com.tencent.mobileqq.qqgift.updatasystem.c.class);
        String f16 = qQGiftResourceBusiness.f((int) this.mTianQuanId, 3);
        if (sDKImpl != null && !qQGiftResourceBusiness.isFileExist(f16)) {
            sDKImpl.b().R((int) this.mTianQuanId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        Msg$msg msg$msg = new Msg$msg();
        this.mGuildMsg = msg$msg;
        try {
            msg$msg.mergeFrom(this.msgData);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        this.mGiftName = this.mGuildMsg.giftname.get();
        this.mGiftId = this.mGuildMsg.giftid.get();
        this.mRecUin = this.mGuildMsg.recvuin.get();
        this.mRecNickname = this.mGuildMsg.recvnickname.get();
        this.mSendUin = this.mGuildMsg.senduin.get();
        this.mSendNickName = this.mGuildMsg.sendnickname.get();
        this.mPrice = this.mGuildMsg.price.get();
        this.mOrderId = this.mGuildMsg.orderid.get();
        this.mBgImage = this.mGuildMsg.bgimage.get();
        this.mTianQuanId = this.mGuildMsg.tianquanid.get();
        this.mGiftLevel = this.mGuildMsg.level.get();
        this.mPaddingTop = this.mGuildMsg.padding_top.get();
        this.mReserveInfo = this.mGuildMsg.reserve_info.get();
        this.f203106msg = this.mGuildMsg.getGiftMsg();
        this.mNeedShowArk = true;
        preLoadArk();
    }

    public boolean equals(@Nullable MessageForAioGift messageForAioGift) {
        if (messageForAioGift == null || messageForAioGift.mGiftId != this.mGiftId || messageForAioGift.mSendUin != this.mSendUin || messageForAioGift.mRecUin != this.mRecUin) {
            return false;
        }
        return true;
    }

    public boolean needAutoShowAnim(String str) {
        if (this.mNeedShowGift && !TextUtils.isEmpty(str)) {
            this.mNeedShowGift = false;
            if (this.mGiftLevel >= GIFT_LEVEL_HIGH_QUALITY && (str.equals(String.valueOf(this.mSendUin)) || str.equals(String.valueOf(this.mRecUin)))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        doParse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        this.msgData = this.mGuildMsg.toByteArray();
        this.f203106msg = this.mGuildMsg.getGiftMsg();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return "MessageForAioGift{mGiftId=" + this.mGiftId + ", mGiftName='" + this.mGiftName + "', mRecUin=" + this.mRecUin + ", mRecNickname='" + this.mRecNickname + "', mSendUin=" + this.mSendUin + ", mSendNickName='" + this.mSendNickName + "', mPrice=" + this.mPrice + ", mOrderId='" + this.mOrderId + "', mBgImage='" + this.mBgImage + "', mTianQuanId=" + this.mTianQuanId + ", mSendIconUrl='" + this.mSendIconUrl + "', mRecIconUrl='" + this.mRecIconUrl + "'}";
    }
}
