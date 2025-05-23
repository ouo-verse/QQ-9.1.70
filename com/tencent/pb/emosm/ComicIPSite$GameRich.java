package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes22.dex */
public final class ComicIPSite$GameRich extends MessageMicro<ComicIPSite$GameRich> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"anchorFaceUrl", "anchorId", "anchorName", "coverUrl", TPReportKeys.Common.COMMON_ONLINE, "title", "richJumpUrl"}, new Object[]{"", "", "", "", "", "", ""}, ComicIPSite$GameRich.class);
    public final PBStringField anchorFaceUrl = PBField.initString("");
    public final PBStringField anchorId = PBField.initString("");
    public final PBStringField anchorName = PBField.initString("");
    public final PBStringField coverUrl = PBField.initString("");
    public final PBStringField online = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField richJumpUrl = PBField.initString("");
}
