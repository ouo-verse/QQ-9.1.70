package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ComicIPSite$ComicRich extends MessageMicro<ComicIPSite$ComicRich> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extCover", "extName", "extTitle", "extUrl"}, new Object[]{"", "", "", ""}, ComicIPSite$ComicRich.class);
    public final PBStringField extCover = PBField.initString("");
    public final PBStringField extName = PBField.initString("");
    public final PBStringField extTitle = PBField.initString("");
    public final PBStringField extUrl = PBField.initString("");
}
