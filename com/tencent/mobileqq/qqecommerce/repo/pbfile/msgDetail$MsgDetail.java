package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class msgDetail$MsgDetail extends MessageMicro<msgDetail$MsgDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90}, new String[]{"id", "title", "brief", "content", "jump_url", "status", "style", AlbumCacheData.CREATE_TIME, "cover", "src_info", "receiver"}, new Object[]{"", "", "", "", "", 0, 0, 0L, null, null, null}, msgDetail$MsgDetail.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f263436id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField brief = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field style = PBField.initUInt32(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public msgDetail$Image cover = new msgDetail$Image();
    public msgDetail$SourceInfo src_info = new msgDetail$SourceInfo();
    public msgDetail$UserInfo receiver = new msgDetail$UserInfo();
}
