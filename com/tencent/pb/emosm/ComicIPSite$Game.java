package com.tencent.pb.emosm;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ComicIPSite$Game extends MessageMicro<ComicIPSite$Game> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"cover", "desc", "id", WadlProxyConsts.KEY_JUMP_URL, "name", "recommDesc", "rich"}, new Object[]{"", "", "", "", "", "", null}, ComicIPSite$Game.class);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField desc = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342121id = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField recommDesc = PBField.initString("");
    public final PBRepeatMessageField<ComicIPSite$GameRich> rich = PBField.initRepeatMessage(ComicIPSite$GameRich.class);
}
