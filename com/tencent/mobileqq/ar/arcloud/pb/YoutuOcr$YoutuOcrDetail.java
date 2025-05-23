package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import cooperation.qzone.remote.ServiceConst;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YoutuOcr$YoutuOcrDetail extends MessageMicro<YoutuOcr$YoutuOcrDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO}, new String[]{"errorcode", "errormsg", ServiceConst.PARA_SESSION_ID, "ocr_item", IjkMediaMeta.IJKM_KEY_LANGUAGE, "ocr_language_list", "dst_translate_language_list", "language_list"}, new Object[]{0, "", "", null, "", "", "", null}, YoutuOcr$YoutuOcrDetail.class);
    public final PBRepeatField<String> dst_translate_language_list;
    public final PBRepeatMessageField<YoutuOcr$Language> language_list;
    public final PBRepeatField<String> ocr_language_list;
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<YoutuOcr$OcrItem> ocr_item = PBField.initRepeatMessage(YoutuOcr$OcrItem.class);
    public final PBStringField language = PBField.initString("");

    public YoutuOcr$YoutuOcrDetail() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.ocr_language_list = PBField.initRepeat(pBStringField);
        this.dst_translate_language_list = PBField.initRepeat(pBStringField);
        this.language_list = PBField.initRepeatMessage(YoutuOcr$Language.class);
    }
}
