package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$updateOtherFlags extends MessageMicro<ProfileUpdateMsg$updateOtherFlags> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField onlyChat = PBField.initBool(false);
    public final PBBoolField qzoneNotWatch = PBField.initBool(false);
    public final PBBoolField qzoneNotWatched = PBField.initBool(false);
    public final PBBoolField isZPlanCoupleOpen = PBField.initBool(false);
    public final PBUInt32Field zplanCoupleSceneId = PBField.initUInt32(0);
    public final PBUInt32Field teenagerFlag = PBField.initUInt32(0);
    public final PBUInt32Field studyFlag = PBField.initUInt32(0);
    public final PBBoolField isAioShortcutBarOpen = PBField.initBool(false);
    public final PBUInt32Field colorRindId = PBField.initUInt32(0);
    public final PBBoolField isSharingLocation = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{160352, 160360, 160392, 160400, 160408, 160504, 160512, 232008, 232016, 232024}, new String[]{"teenagerFlag", "studyFlag", "onlyChat", "qzoneNotWatch", "qzoneNotWatched", "isZPlanCoupleOpen", "zplanCoupleSceneId", "isAioShortcutBarOpen", "colorRindId", "isSharingLocation"}, new Object[]{0, 0, bool, bool, bool, bool, 0, bool, 0, bool}, ProfileUpdateMsg$updateOtherFlags.class);
    }
}
