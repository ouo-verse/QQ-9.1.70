package com.tencent.mobileqq.vas.novelspecies.data;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes20.dex */
public final class WidgetPB$SsoGetWidgetNotifyInfoRsp extends MessageMicro<WidgetPB$SsoGetWidgetNotifyInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{LocalPhotoFaceInfo.SCORE, "coin", "default_info", "last_info"}, new Object[]{0, 0L, null, null}, WidgetPB$SsoGetWidgetNotifyInfoRsp.class);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt64Field coin = PBField.initInt64(0);
    public WidgetPB$WidgetNotifyInfo default_info = new WidgetPB$WidgetNotifyInfo();
    public WidgetPB$WidgetNotifyInfo last_info = new WidgetPB$WidgetNotifyInfo();
}
