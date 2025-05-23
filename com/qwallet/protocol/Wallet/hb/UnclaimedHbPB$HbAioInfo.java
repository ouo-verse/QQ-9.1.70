package com.qwallet.protocol.Wallet.hb;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes3.dex */
public final class UnclaimedHbPB$HbAioInfo extends MessageMicro<UnclaimedHbPB$HbAioInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField aio_body_reserve;
    public final PBBytesField aio_elem_reserve;
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public final PBStringField auth_key = PBField.initString("");
    public final PBInt32Field msg_type = PBField.initInt32(0);
    public final PBInt32Field red_channel = PBField.initInt32(0);
    public final PBRepeatField<Long> grab_uin = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBInt64Field create_time = PBField.initInt64(0);

    static {
        String[] strArr = {"uin", "title", "bill_no", "auth_key", QQHealthReportApiImpl.MSG_TYPE_KEY, "red_channel", "grab_uin", AlbumCacheData.CREATE_TIME, "aio_body_reserve", "aio_elem_reserve"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 74, 82}, strArr, new Object[]{0L, "", "", "", 0, 0, 0L, 0L, byteStringMicro, byteStringMicro}, UnclaimedHbPB$HbAioInfo.class);
    }

    public UnclaimedHbPB$HbAioInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.aio_body_reserve = PBField.initBytes(byteStringMicro);
        this.aio_elem_reserve = PBField.initBytes(byteStringMicro);
    }
}
