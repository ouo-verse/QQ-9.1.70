package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.peak.PeakConstants;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$PicInfo extends MessageMicro<ECQqShopDetailSvr$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 56}, new String[]{"url", "width", "height", "desc", "thumbnail_url", PeakConstants.VIDEO_THUMBNAIL_WIDTH, PeakConstants.VIDEO_THUMBNAIL_HEIGHT}, new Object[]{"", 0, 0, "", "", 0, 0}, ECQqShopDetailSvr$PicInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField thumbnail_url = PBField.initString("");
    public final PBInt32Field thumbnail_width = PBField.initInt32(0);
    public final PBInt32Field thumbnail_height = PBField.initInt32(0);
}
