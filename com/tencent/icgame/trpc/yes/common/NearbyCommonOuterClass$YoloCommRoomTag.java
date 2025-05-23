package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class NearbyCommonOuterClass$YoloCommRoomTag extends MessageMicro<NearbyCommonOuterClass$YoloCommRoomTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"tag_id", "tag_desc", "tag_bg_img", "tag_bg_color"}, new Object[]{0, "", "", ""}, NearbyCommonOuterClass$YoloCommRoomTag.class);
    public final PBInt32Field tag_id = PBField.initInt32(0);
    public final PBStringField tag_desc = PBField.initString("");
    public final PBStringField tag_bg_img = PBField.initString("");
    public final PBStringField tag_bg_color = PBField.initString("");
}
