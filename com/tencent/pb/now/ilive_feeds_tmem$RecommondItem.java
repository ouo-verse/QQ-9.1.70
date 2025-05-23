package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$RecommondItem extends MessageMicro<ilive_feeds_tmem$RecommondItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"id", "start_time", "end_time", "recom_pos", "uin_lists_key"}, new Object[]{"", 0, 0, 0, ""}, ilive_feeds_tmem$RecommondItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342146id = PBField.initString("");
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBUInt32Field recom_pos = PBField.initUInt32(0);
    public final PBStringField uin_lists_key = PBField.initString("");
}
