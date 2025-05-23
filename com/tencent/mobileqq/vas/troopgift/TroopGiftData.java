package com.tencent.mobileqq.vas.troopgift;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class TroopGiftData implements AIOAnimationControlManager.h {
    private static final String GIFT_TYPE_COMMON = "0";
    private static final String GIFT_TYPE_GESTURE = "2";
    private static final String GIFT_TYPE_GUILD = "7";
    private static final String GIFT_TYPE_STAFF = "1";
    public GiftDataBean giftData = new GiftDataBean();
    private long shmsgseq = 0;
    private boolean isReaded = true;

    /* compiled from: P */
    @Keep
    /* loaded from: classes20.dex */
    public static class GiftDataBean {
        public String giftName = "";
        public String giftImg = "";
        public String receiverNick = "";
        public String bgColor = "";
        public String count = "";
        public String bgImg = "";
        public String troopUin = "";
        public String btnTxt = "";
        public String score = "";
        public DataForClientBean dataForClient = new DataForClientBean();

        /* compiled from: P */
        @Keep
        /* loaded from: classes20.dex */
        public static class DataForClientBean {

            @SerializedName("SendUin")
            public String sendUin = "";

            @SerializedName("RecvUin")
            public String recvUin = "";

            @SerializedName("GiftId")
            public String giftId = "";

            @SerializedName("GiftResourceAnd")
            public String giftResourceAnd = "";

            @SerializedName("GiftResourceIos")
            public String giftResourceIos = "";

            @SerializedName("TroopUin")
            public String troopUin = "";

            @SerializedName("AnonymousPortraitIdx")
            public String anonymousPortraitIdx = "";

            @SerializedName("SendCount")
            public String sendCount = "";

            @SerializedName("ContinueAnimationAnd")
            public String continueAnimationAnd = "";

            @SerializedName("ContinueAnimationIos")
            public String continueAnimationIos = "";

            @SerializedName("GiftType")
            public String giftType = "";

            @SerializedName("OrderId")
            public String orderId = "";
        }
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public String getFriendUin() {
        return this.giftData.dataForClient.troopUin;
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public int getLimitType() {
        return 0;
    }

    public long getSenderUin() {
        return Long.parseLong(this.giftData.dataForClient.sendUin);
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public long getShmsgseq() {
        return this.shmsgseq;
    }

    public boolean isCommonGift() {
        return this.giftData.dataForClient.giftType.equals("0");
    }

    public boolean isGestureGift() {
        return this.giftData.dataForClient.giftType.equals("2");
    }

    public boolean isGuildGift() {
        return this.giftData.dataForClient.giftType.equals("7");
    }

    public boolean isReaded() {
        return this.isReaded;
    }

    public boolean isResInvalid() {
        return TextUtils.isEmpty(this.giftData.dataForClient.giftResourceAnd);
    }

    public boolean isStaffGift() {
        return this.giftData.dataForClient.giftType.equals("1");
    }

    public void setReaded(boolean z16) {
        this.isReaded = z16;
    }

    public void setShmsgseq(long j3) {
        this.shmsgseq = j3;
    }
}
