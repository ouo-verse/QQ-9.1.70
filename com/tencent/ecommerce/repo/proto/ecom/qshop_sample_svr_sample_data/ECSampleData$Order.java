package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$Order extends MessageMicro<ECSampleData$Order> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 64, 74}, new String[]{"order_id", "order_status", AlbumCacheData.CREATE_TIME, "fulfil_start_time", "fulfil_expire_time", "cooperation_notes", "comments", "last_mofidy_time", "status_extra"}, new Object[]{"", 0, 0L, 0L, 0L, "", "", 0L, null}, ECSampleData$Order.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field order_status = PBField.initUInt32(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field fulfil_start_time = PBField.initInt64(0);
    public final PBInt64Field fulfil_expire_time = PBField.initInt64(0);
    public final PBStringField cooperation_notes = PBField.initString("");
    public final PBStringField comments = PBField.initString("");
    public final PBInt64Field last_mofidy_time = PBField.initInt64(0);
    public ECSampleData$StatusExtra status_extra = new MessageMicro<ECSampleData$StatusExtra>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$StatusExtra
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"status_op_type"}, new Object[]{0}, ECSampleData$StatusExtra.class);
        public final PBUInt32Field status_op_type = PBField.initUInt32(0);
    };
}
