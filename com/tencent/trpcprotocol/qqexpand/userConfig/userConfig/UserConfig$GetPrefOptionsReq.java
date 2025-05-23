package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class UserConfig$GetPrefOptionsReq extends MessageMicro<UserConfig$GetPrefOptionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"tag_id"}, new Object[]{0}, UserConfig$GetPrefOptionsReq.class);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
}
