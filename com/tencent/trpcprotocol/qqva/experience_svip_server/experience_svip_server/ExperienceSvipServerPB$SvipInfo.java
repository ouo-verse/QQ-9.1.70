package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$SvipInfo extends MessageMicro<ExperienceSvipServerPB$SvipInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_new_user = PBField.initBool(false);
    public final PBBoolField is_experience_user = PBField.initBool(false);
    public final PBInt64Field experience_expire_time = PBField.initInt64(0);
    public final PBBoolField is_svip = PBField.initBool(false);
    public final PBInt64Field svip_expire_time = PBField.initInt64(0);
    public final PBStringField buy_btn_title = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"is_new_user", "is_experience_user", "experience_expire_time", "is_svip", "svip_expire_time", "buy_btn_title"}, new Object[]{bool, bool, 0L, bool, 0L, ""}, ExperienceSvipServerPB$SvipInfo.class);
    }
}
