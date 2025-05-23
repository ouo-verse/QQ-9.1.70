package com.tencent.robot.adelie.oidb;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes25.dex */
public final class MybotCreatePB$RedDotsInfo extends MessageMicro<MybotCreatePB$RedDotsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 88, 98, 162}, new String[]{"style_type", "text", "master_id", "sub_service_type", AlbumCacheData.CREATE_TIME, "ctrl_type", "link_url", "revoke_id"}, new Object[]{0, "", "", "", 0L, 0, "", ""}, MybotCreatePB$RedDotsInfo.class);
    public final PBEnumField style_type = PBField.initEnum(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField master_id = PBField.initString("");
    public final PBStringField sub_service_type = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBEnumField ctrl_type = PBField.initEnum(0);
    public final PBStringField link_url = PBField.initString("");
    public final PBStringField revoke_id = PBField.initString("");
}
