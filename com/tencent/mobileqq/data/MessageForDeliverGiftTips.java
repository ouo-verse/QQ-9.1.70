package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForDeliverGiftTips extends MessageForGrayTips implements AIOAnimationControlManager.h {
    public static final String MESSAGERECORD_EXTSTR_TYPE = "troop_send_gift_ext_remind";
    public static final int VERSION = 2;
    public String activity_text;
    public String activity_text_color;
    public String activity_url;
    public long alreadyPlayMicroseconds;
    public int animationPackageId;
    public int animationType;
    public String bagId;
    public int btFlag;
    public int exflag;
    public int giftCount;
    public int giftId;
    public String grayTipContent;
    public TroopTipsEntity grayTipsEntity;
    public boolean hasFetchButFailed;
    public long interactFirstUin;
    public String interactId;
    public boolean isFromNearby;
    public String jumpUrl;
    public int objColor;
    public int participateNum;
    public long playTotalMicroseconds;
    public String rcvName;
    public String receiveAvatarUrl;
    public String receiverHead;
    public String receiverName;
    public long receiverUin;
    public int recvScore;
    public String resultText;
    public int resultType;
    public int sendScore;
    public String senderAvatarUrl;
    public String senderName;
    public long senderUin;
    public boolean showButton;
    public String summary;
    public int version;
    public String subtitle = "";
    public String animationPackageUrl = "";
    public String remindBrief = "";
    public String animationBrief = "";
    public boolean showCloseBtn = true;
    public String charmHeroism = "";
    public int is_activity_gift = 0;
    public int interactState = 0;
    public String interactText = "";
    public String interactFirstNickname = "";
    public String interacEndtUrl = "";

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public String getFriendUin() {
        return this.frienduin;
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public int getLimitType() {
        return 0;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public long getShmsgseq() {
        return this.shmsgseq;
    }

    public boolean isInteract() {
        return !TextUtils.isEmpty(this.interactId);
    }

    public boolean isReaded() {
        return this.isread;
    }

    public boolean isToAll() {
        int i3;
        if (this.animationPackageId == 0 && (i3 = this.exflag) > 1000 && i3 <= 2000) {
            return true;
        }
        return false;
    }
}
