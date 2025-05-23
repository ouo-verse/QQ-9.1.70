package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import localpb.richMsg.RichMsg$PicRec;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ResvAttr;

/* loaded from: classes10.dex */
public class MessageForTroopEffectPic extends MessageForPic implements AIOAnimationControlManager.h {
    public int effectId;

    @Override // com.tencent.mobileqq.data.MessageForPic, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        super.doParse();
        RichMsg$PicRec richMsg$PicRec = new RichMsg$PicRec();
        try {
            richMsg$PicRec.mergeFrom(this.msgData);
            if (richMsg$PicRec.bytes_pb_reserved.has()) {
                CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr = new CustomFaceExtPb$ResvAttr();
                try {
                    customFaceExtPb$ResvAttr.mergeFrom(richMsg$PicRec.bytes_pb_reserved.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (customFaceExtPb$ResvAttr.msg_image_show.has()) {
                    this.effectId = customFaceExtPb$ResvAttr.msg_image_show.get().int32_product_id.get();
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public String getFriendUin() {
        return this.frienduin;
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public int getLimitType() {
        return 0;
    }

    public long getSenderUin() {
        return Long.parseLong(this.senderuin);
    }

    @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
    public long getShmsgseq() {
        return this.shmsgseq;
    }

    @Override // com.tencent.mobileqq.data.MessageForPic, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.f172171o15);
    }

    public boolean isReaded() {
        return this.isRead;
    }
}
