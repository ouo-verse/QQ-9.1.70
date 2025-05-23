package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$UserVipInfo extends MessageMicro<ExperienceSvipServerPB$UserVipInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_member = PBField.initBool(false);
    public final PBUInt64Field expire_time = PBField.initUInt64(0);
    public final PBBoolField is_renewal = PBField.initBool(false);
    public final PBBoolField is_year = PBField.initBool(false);
    public final PBBoolField is_phone_pay = PBField.initBool(false);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBEnumField state = PBField.initEnum(0);

    static {
        String[] strArr = {"is_member", VasQQSettingMeImpl.EXPIRE_TIME, "is_renewal", "is_year", "is_phone_pay", "level", "state"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, strArr, new Object[]{bool, 0L, bool, bool, bool, 0, 0}, ExperienceSvipServerPB$UserVipInfo.class);
    }
}
