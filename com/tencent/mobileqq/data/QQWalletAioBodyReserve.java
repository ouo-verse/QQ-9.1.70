package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body$QQWalletAioBody;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_body_resv;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQWalletAioBodyReserve {
    public int avatarId;
    public int coverId;
    public int hbFlag;
    public String makeHbExtend;
    public int payFlag;
    public int pfaType;
    public String poemRule;
    public int subChannel;
    public String zplanSenderUin;
    public String feedId = "";
    public String shengpiziMask = "";
    public String shengpiziMD5 = "";

    public QQWalletAioBodyReserve() {
    }

    public void init(byte[] bArr) {
        int indexOf;
        try {
            qqwalletaio_resv$qqwalletaio_body_resv qqwalletaio_resv_qqwalletaio_body_resv = new qqwalletaio_resv$qqwalletaio_body_resv();
            qqwalletaio_resv_qqwalletaio_body_resv.mergeFrom(bArr);
            if (qqwalletaio_resv_qqwalletaio_body_resv.uint32_pfa_type.has()) {
                this.pfaType = qqwalletaio_resv_qqwalletaio_body_resv.uint32_pfa_type.get();
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.bytes_feeds_id.has()) {
                this.feedId = qqwalletaio_resv_qqwalletaio_body_resv.bytes_feeds_id.get().toStringUtf8();
            } else {
                this.feedId = "";
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.uint32_subchannel.has()) {
                this.subChannel = qqwalletaio_resv_qqwalletaio_body_resv.uint32_subchannel.get();
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.bytes_poem_rule.has()) {
                this.poemRule = qqwalletaio_resv_qqwalletaio_body_resv.bytes_poem_rule.get().toStringUtf8();
            } else {
                this.poemRule = "";
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.bytes_client_extend.has()) {
                this.makeHbExtend = qqwalletaio_resv_qqwalletaio_body_resv.bytes_client_extend.get().toStringUtf8();
            } else {
                this.makeHbExtend = "";
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.bytes_rareword_rule.has()) {
                String stringUtf8 = qqwalletaio_resv_qqwalletaio_body_resv.bytes_rareword_rule.get().toStringUtf8();
                if (!TextUtils.isEmpty(stringUtf8) && (indexOf = stringUtf8.indexOf("|")) > -1) {
                    this.shengpiziMask = stringUtf8.substring(0, indexOf);
                    this.shengpiziMD5 = stringUtf8.substring(indexOf + 1);
                }
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.uint32_pay_flag.has()) {
                this.payFlag = qqwalletaio_resv_qqwalletaio_body_resv.uint32_pay_flag.get();
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.uint32_hb_flag.has()) {
                this.hbFlag = qqwalletaio_resv_qqwalletaio_body_resv.uint32_hb_flag.get();
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.uint32_cover_id.has()) {
                this.coverId = qqwalletaio_resv_qqwalletaio_body_resv.uint32_cover_id.get();
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.uint32_avatar_id.has()) {
                this.avatarId = qqwalletaio_resv_qqwalletaio_body_resv.uint32_avatar_id.get();
            }
            if (qqwalletaio_resv_qqwalletaio_body_resv.bytes_zplan_uin.has()) {
                this.zplanSenderUin = qqwalletaio_resv_qqwalletaio_body_resv.bytes_zplan_uin.get().toStringUtf8();
            }
        } catch (Throwable th5) {
            QLog.e("QQWalletAioBodyReserve", 1, "error msg in qqpay-api module: ", th5);
        }
    }

    public String toString() {
        return "QQWalletAioBodyReserve{pfa_type=" + this.pfaType + ", feedId='" + this.feedId + "'}";
    }

    public QQWalletAioBodyReserve(im_msg_body$QQWalletAioBody im_msg_body_qqwalletaiobody) {
        if (im_msg_body_qqwalletaiobody != null && im_msg_body_qqwalletaiobody.bytes_pb_reserve.has()) {
            try {
                init(im_msg_body_qqwalletaiobody.bytes_pb_reserve.get().toByteArray());
            } catch (Throwable th5) {
                QLog.e("QQWalletAioBodyReserve", 1, "error msg in qqpay-api module: ", th5);
            }
        }
    }
}
