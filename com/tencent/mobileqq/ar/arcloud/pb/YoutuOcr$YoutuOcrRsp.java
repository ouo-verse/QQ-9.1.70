package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YoutuOcr$YoutuOcrRsp extends MessageMicro<YoutuOcr$YoutuOcrRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"youtu_ocr_errorcode", "youtu_ocr_errormsg", "youtu_orc_detail"}, new Object[]{0, "", null}, YoutuOcr$YoutuOcrRsp.class);
    public final PBInt32Field youtu_ocr_errorcode = PBField.initInt32(0);
    public final PBStringField youtu_ocr_errormsg = PBField.initString("");
    public YoutuOcr$YoutuOcrDetail youtu_orc_detail = new YoutuOcr$YoutuOcrDetail();
}
