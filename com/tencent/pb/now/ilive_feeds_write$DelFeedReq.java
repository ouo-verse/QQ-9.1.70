package com.tencent.pb.now;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$DelFeedReq extends MessageMicro<ilive_feeds_write$DelFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 56}, new String[]{PictureConst.KEY_DEL_TYPE, "uid", "del_st", "select_all", "del_source", "vid", "anchor_del_user"}, new Object[]{1, 0L, null, 0, 1, ByteStringMicro.EMPTY, 0}, ilive_feeds_write$DelFeedReq.class);
    public final PBEnumField del_type = PBField.initEnum(1);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBRepeatMessageField<ilive_feeds_write$DelFeedStuct> del_st = PBField.initRepeatMessage(ilive_feeds_write$DelFeedStuct.class);
    public final PBUInt32Field select_all = PBField.initUInt32(0);
    public final PBEnumField del_source = PBField.initEnum(1);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field anchor_del_user = PBField.initUInt32(0);
}
