package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl;

/* loaded from: classes22.dex */
public final class CouponProto$GetShopsByBidsReq extends MessageMicro<CouponProto$GetShopsByBidsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY, "source_ids"}, new Object[]{0, 0}, CouponProto$GetShopsByBidsReq.class);
    public final PBRepeatField<Integer> bids;
    public final PBRepeatField<Integer> source_ids;

    public CouponProto$GetShopsByBidsReq() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.bids = PBField.initRepeat(pBUInt32Field);
        this.source_ids = PBField.initRepeat(pBUInt32Field);
    }
}
