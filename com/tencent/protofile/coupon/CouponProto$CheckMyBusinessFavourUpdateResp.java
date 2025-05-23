package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl;

/* loaded from: classes22.dex */
public final class CouponProto$CheckMyBusinessFavourUpdateResp extends MessageMicro<CouponProto$CheckMyBusinessFavourUpdateResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"retcode", QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY, "source_ids", "ts_list"}, new Object[]{0, 0, 0, 0L}, CouponProto$CheckMyBusinessFavourUpdateResp.class);
    public final PBRepeatField<Integer> bids;
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatField<Integer> source_ids;
    public final PBRepeatField<Long> ts_list;

    public CouponProto$CheckMyBusinessFavourUpdateResp() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.bids = PBField.initRepeat(pBUInt32Field);
        this.source_ids = PBField.initRepeat(pBUInt32Field);
        this.ts_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }
}
