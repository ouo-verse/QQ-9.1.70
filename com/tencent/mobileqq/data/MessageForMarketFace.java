package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.msg.im_msg_body$MarketFace;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForMarketFace extends ChatMessage {
    public static final String TAG = "MessageForMarketFace";
    public int msgVia;
    public float playProgress;
    public String timeStr;
    public MarkFaceMessage mMarkFaceMessage = null;
    public String sendFaceName = null;
    public boolean needToPlay = false;

    public static MessageForMarketFace parsePb(im_msg_body$MarketFace im_msg_body_marketface) {
        MarkFaceMessage markFaceMessage = new MarkFaceMessage();
        markFaceMessage.cFaceInfo = im_msg_body_marketface.uint32_face_info.get();
        markFaceMessage.cSubType = im_msg_body_marketface.uint32_sub_type.get();
        markFaceMessage.dwMSGItemType = im_msg_body_marketface.uint32_item_type.get();
        markFaceMessage.dwTabID = im_msg_body_marketface.uint32_tab_id.get();
        markFaceMessage.sbfKey = im_msg_body_marketface.bytes_key.get().toByteArray();
        markFaceMessage.sbufID = im_msg_body_marketface.bytes_face_id.get().toByteArray();
        markFaceMessage.mediaType = im_msg_body_marketface.uint32_media_type.get();
        markFaceMessage.mobileparam = im_msg_body_marketface.bytes_mobileparam.get().toByteArray();
        markFaceMessage.resvAttr = im_msg_body_marketface.bytes_pb_reserve.get().toByteArray();
        MessageForMarketFace messageForMarketFace = new MessageForMarketFace();
        messageForMarketFace.mMarkFaceMessage = markFaceMessage;
        return messageForMarketFace;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        MarkFaceMessage markFaceMessage;
        StickerInfo stickerInfo;
        try {
            this.mMarkFaceMessage = (MarkFaceMessage) MessagePkgUtils.getObjectFromBytes(this.msgData);
            if (((IEmosmService) QRoute.api(IEmosmService.class)).getEmojiStickerSwitch(this.istroop) && (markFaceMessage = this.mMarkFaceMessage) != null && (stickerInfo = markFaceMessage.stickerInfo) != null) {
                if (this.msgtype == -2007) {
                    this.msgtype = MessageRecord.MSG_TYPE_STICKER_MSG;
                }
                stickerInfo.isDisplayed = this.isread;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "doParse: ", e16);
        }
    }

    public String getMarketFaceId() {
        MarkFaceMessage markFaceMessage = this.mMarkFaceMessage;
        if (markFaceMessage != null) {
            return e.a(markFaceMessage.sbufID, markFaceMessage.mediaType);
        }
        return null;
    }

    public int getMarketFacePackageId() {
        MarkFaceMessage markFaceMessage = this.mMarkFaceMessage;
        if (markFaceMessage != null) {
            return markFaceMessage.dwTabID;
        }
        return 0;
    }

    public im_msg_body$MarketFace getSerialPB() {
        im_msg_body$MarketFace im_msg_body_marketface = new im_msg_body$MarketFace();
        byte[] bArr = this.mMarkFaceMessage.sbufID;
        if (bArr != null) {
            im_msg_body_marketface.bytes_face_id.set(ByteStringMicro.copyFrom(bArr));
        }
        byte[] bArr2 = this.mMarkFaceMessage.sbfKey;
        if (bArr2 != null) {
            im_msg_body_marketface.bytes_key.set(ByteStringMicro.copyFrom(bArr2));
        }
        im_msg_body_marketface.uint32_face_info.set(this.mMarkFaceMessage.cFaceInfo);
        im_msg_body_marketface.uint32_item_type.set(this.mMarkFaceMessage.dwMSGItemType);
        im_msg_body_marketface.uint32_sub_type.set(this.mMarkFaceMessage.cSubType);
        im_msg_body_marketface.uint32_tab_id.set(this.mMarkFaceMessage.dwTabID);
        im_msg_body_marketface.uint32_media_type.set(this.mMarkFaceMessage.mediaType);
        im_msg_body_marketface.bytes_mobileparam.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.mobileparam));
        im_msg_body_marketface.bytes_pb_reserve.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.resvAttr));
        return im_msg_body_marketface;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        MarkFaceMessage markFaceMessage = this.mMarkFaceMessage;
        if (markFaceMessage != null && !TextUtils.isEmpty(markFaceMessage.faceName)) {
            return "[" + this.mMarkFaceMessage.faceName + "]";
        }
        return HardCodeUtil.qqStr(R.string.f209375f9);
    }

    public boolean isNewSoundType() {
        List<Integer> list;
        MarkFaceMessage markFaceMessage = this.mMarkFaceMessage;
        if (markFaceMessage != null && (list = markFaceMessage.voicePrintItems) != null && !list.isEmpty()) {
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
        MarkFaceMessage markFaceMessage = this.mMarkFaceMessage;
        if (markFaceMessage != null) {
            try {
                this.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "prewrite: ", e16);
            }
        }
    }
}
