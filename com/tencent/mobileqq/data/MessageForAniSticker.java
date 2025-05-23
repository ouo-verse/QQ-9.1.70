package com.tencent.mobileqq.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype37;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForAniSticker extends ChatMessage {
    public static final int STATE_PLAY_NONE = 0;
    public static final int STATE_PLAY_SECOND_FINISH = 2;
    public static final int STATE_PLAY_START = 1;
    public static final int STATE_PLAY_SURPRISE_FINISH = 3;
    public static final String TAG = "MessageForAniSticker";
    public int msgVia;
    public String packId;
    public String resultId;
    public int sevrId;
    public String stickerId;
    public String surpriseId;
    public String text;
    public int isMsgRead = 0;
    public int isMsgPlay = 0;
    public int randomType = 1;
    public int sourceType = 1;
    public int stickerType = 1;

    public MessageForAniSticker() {
        this.msgtype = -8018;
        this.isFlowMessage = false;
    }

    private void updateMsgRecordStatus() {
        if (this.isread) {
            setIsMsgRead(1);
        }
    }

    public boolean checkMsgCanPreview() {
        int i3;
        if (!isAniStickerRandom() || (i3 = this.isMsgPlay) == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public void deserializeMsgBody(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            hummer_commelem$MsgElemInfo_servtype37 hummer_commelem_msgeleminfo_servtype37 = new hummer_commelem$MsgElemInfo_servtype37();
            try {
                hummer_commelem_msgeleminfo_servtype37.mergeFrom(bArr);
                this.packId = hummer_commelem_msgeleminfo_servtype37.bytes_packid.get().toStringUtf8();
                this.stickerId = hummer_commelem_msgeleminfo_servtype37.bytes_stickerid.get().toStringUtf8();
                this.sevrId = hummer_commelem_msgeleminfo_servtype37.uint32_qsid.get();
                this.resultId = hummer_commelem_msgeleminfo_servtype37.bytes_resultid.get().toStringUtf8();
                this.surpriseId = hummer_commelem_msgeleminfo_servtype37.bytes_surpriseid.get().toStringUtf8();
                this.text = hummer_commelem_msgeleminfo_servtype37.bytes_text.get().toStringUtf8();
                this.randomType = hummer_commelem_msgeleminfo_servtype37.uint32_randomtype.get();
                this.sourceType = hummer_commelem_msgeleminfo_servtype37.uint32_sourcetype.get();
                this.stickerType = hummer_commelem_msgeleminfo_servtype37.uint32_stickertype.get();
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void deserializeMsgData(byte[] bArr) {
        if (bArr != null && bArr.length >= 3) {
            byte b16 = bArr[bArr.length - 1];
            byte b17 = bArr[bArr.length - 2];
            this.isMsgPlay = b16 & 255;
            this.isMsgRead = b17 & 255;
            int length = bArr.length - 2;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            deserializeMsgBody(bArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        synchronized (this) {
            deserializeMsgData(this.msgData);
        }
    }

    public int getAniStickerType() {
        return this.sourceType;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(this.sevrId));
    }

    public boolean isAniStickerRandom() {
        if (this.stickerType == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isFollowMessage() {
        return super.isFollowMessage();
    }

    public boolean isMsgPlayState() {
        int i3 = this.isMsgPlay;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public boolean isMsgReadState() {
        if (this.isMsgRead == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean needVipBubble() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        synchronized (this) {
            this.msgData = serializeMsgData();
        }
    }

    public byte[] serializeMsgBody() {
        hummer_commelem$MsgElemInfo_servtype37 hummer_commelem_msgeleminfo_servtype37 = new hummer_commelem$MsgElemInfo_servtype37();
        hummer_commelem_msgeleminfo_servtype37.setHasFlag(true);
        PBBytesField pBBytesField = hummer_commelem_msgeleminfo_servtype37.bytes_packid;
        String str = this.packId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pBBytesField.set(ByteStringMicro.copyFromUtf8(str));
        PBBytesField pBBytesField2 = hummer_commelem_msgeleminfo_servtype37.bytes_stickerid;
        String str3 = this.stickerId;
        if (str3 == null) {
            str3 = "";
        }
        pBBytesField2.set(ByteStringMicro.copyFromUtf8(str3));
        hummer_commelem_msgeleminfo_servtype37.uint32_qsid.set(this.sevrId);
        PBBytesField pBBytesField3 = hummer_commelem_msgeleminfo_servtype37.bytes_resultid;
        String str4 = this.resultId;
        if (str4 == null) {
            str4 = "";
        }
        pBBytesField3.set(ByteStringMicro.copyFromUtf8(str4));
        PBBytesField pBBytesField4 = hummer_commelem_msgeleminfo_servtype37.bytes_surpriseid;
        String str5 = this.surpriseId;
        if (str5 == null) {
            str5 = "";
        }
        pBBytesField4.set(ByteStringMicro.copyFromUtf8(str5));
        PBBytesField pBBytesField5 = hummer_commelem_msgeleminfo_servtype37.bytes_text;
        String str6 = this.text;
        if (str6 != null) {
            str2 = str6;
        }
        pBBytesField5.set(ByteStringMicro.copyFromUtf8(str2));
        hummer_commelem_msgeleminfo_servtype37.uint32_randomtype.set(this.randomType);
        hummer_commelem_msgeleminfo_servtype37.uint32_sourcetype.set(this.sourceType);
        hummer_commelem_msgeleminfo_servtype37.uint32_stickertype.set(this.stickerType);
        return hummer_commelem_msgeleminfo_servtype37.toByteArray();
    }

    public byte[] serializeMsgData() {
        byte[] serializeMsgBody = serializeMsgBody();
        int length = serializeMsgBody.length + 2;
        byte[] bArr = new byte[length];
        System.arraycopy(serializeMsgBody, 0, bArr, 0, serializeMsgBody.length);
        bArr[length - 1] = (byte) this.isMsgPlay;
        bArr[length - 2] = (byte) this.isMsgRead;
        return bArr;
    }

    public void setIsMsgRead(int i3) {
        if (this.isMsgRead != i3) {
            this.isMsgRead = i3;
        }
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    @NonNull
    public String toString() {
        return String.format("msgseq:%s uid:%s sevrId=%s packId=%s stickerId=%s stickerType=%s sourceType=%s text=%s surpriseId=%s resultId=%s]", Long.valueOf(this.msgseq), Long.valueOf(this.msgUid), Integer.valueOf(this.sevrId), this.packId, this.stickerId, Integer.valueOf(this.stickerType), Integer.valueOf(this.sourceType), this.text, this.surpriseId, this.resultId);
    }
}
