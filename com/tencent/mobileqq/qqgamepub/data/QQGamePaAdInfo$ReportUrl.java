package com.tencent.mobileqq.qqgamepub.data;

import com.qq.e.comm.constants.Constants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QQGamePaAdInfo$ReportUrl extends MessageMicro<QQGamePaAdInfo$ReportUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{Constants.KEYS.EXPOSED_CLICK_URL_KEY, "exposureUrl", "originalExposureUrl"}, new Object[]{"", "", ""}, QQGamePaAdInfo$ReportUrl.class);
    public final PBStringField clickUrl = PBField.initString("");
    public final PBStringField exposureUrl = PBField.initString("");
    public final PBStringField originalExposureUrl = PBField.initString("");
}
