package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetMyRefMaterialsReq extends MessageMicro<GameStrategyQA$GetMyRefMaterialsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"ref_type", AppConstants.Key.SHARE_REQ_TYPE, ThemeDIYDownloader.HEADER_PAGEINDEX, "page_size"}, new Object[]{0, 0, 0, 0}, GameStrategyQA$GetMyRefMaterialsReq.class);
    public final PBEnumField ref_type = PBField.initEnum(0);
    public final PBEnumField req_type = PBField.initEnum(0);
    public final PBUInt32Field page_index = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
}
