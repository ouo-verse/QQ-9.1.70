package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class mobileqq_dynamic_search$ResultItemGroup extends MessageMicro<mobileqq_dynamic_search$ResultItemGroup> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field group_id;
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField group_name;
    public final PBBytesField more_name;
    public final PBBytesField more_url;
    public final PBRepeatMessageField<mobileqq_dynamic_search$ResultItem> result_items;
    public final PBUInt64Field total_result_count;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56}, new String[]{"group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name", "group_id"}, new Object[]{0, byteStringMicro, null, 0L, byteStringMicro, byteStringMicro, 0}, mobileqq_dynamic_search$ResultItemGroup.class);
    }

    public mobileqq_dynamic_search$ResultItemGroup() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.result_items = PBField.initRepeatMessage(mobileqq_dynamic_search$ResultItem.class);
        this.total_result_count = PBField.initUInt64(0L);
        this.more_url = PBField.initBytes(byteStringMicro);
        this.more_name = PBField.initBytes(byteStringMicro);
        this.group_id = PBField.initUInt32(0);
    }
}
