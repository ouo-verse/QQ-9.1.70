package com.tencent.ecommerce.repo.proto.ecom.cir_main_svr;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* loaded from: classes31.dex */
public final class ECQCirMainPageSvr$CirStRelationInfo extends MessageMicro<ECQCirMainPageSvr$CirStRelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField uin = PBField.initString("");
    public final PBUInt32Field relation = PBField.initUInt32(0);
    public final PBUInt32Field relationState = PBField.initUInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBBoolField isBlock = PBField.initBool(false);
    public final PBBoolField isBlocked = PBField.initBool(false);
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBBoolField isUncare = PBField.initBool(false);

    static {
        String[] strArr = {"uin", "relation", "relationState", LocalPhotoFaceInfo.SCORE, "isBlock", "isBlocked", IProfileProtocolConst.PARAM_IS_FRIEND, "isUncare"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 32, 40, 48, 56, 64, 72}, strArr, new Object[]{"", 0, 0, 0, bool, bool, bool, bool}, ECQCirMainPageSvr$CirStRelationInfo.class);
    }
}
