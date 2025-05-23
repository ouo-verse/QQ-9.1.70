package com.tencent.pb.emosm;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ComicIPSite$Comic extends MessageMicro<ComicIPSite$Comic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"comicType", "cover", "desc", "id", WadlProxyConsts.KEY_JUMP_URL, "name", "recommDesc", "typeName", "rich"}, new Object[]{0, "", "", "", "", "", "", "", null}, ComicIPSite$Comic.class);
    public final PBInt32Field comicType = PBField.initInt32(0);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342120id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField recommDesc = PBField.initString("");
    public final PBStringField typeName = PBField.initString("");
    public final PBRepeatMessageField<ComicIPSite$ComicRich> rich = PBField.initRepeatMessage(ComicIPSite$ComicRich.class);
}
