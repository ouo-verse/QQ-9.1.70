package com.tencent.protofile.source;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QunSourceSvrPB$SourceItem extends MessageMicro<QunSourceSvrPB$SourceItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 74, 80, 90}, new String[]{"id", "name", "url", WidgetCacheConstellationData.NUM, "group_id", "status", AlbumCacheData.CREATE_TIME, "update_time", "desc", "is_use_custom_qr_code", "custom_qr_code_url"}, new Object[]{"", "", "", 0, 0L, 0, 0L, 0L, "", Boolean.FALSE, ""}, QunSourceSvrPB$SourceItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342212id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public final PBStringField desc = PBField.initString("");
    public final PBBoolField is_use_custom_qr_code = PBField.initBool(false);
    public final PBStringField custom_qr_code_url = PBField.initString("");
}
