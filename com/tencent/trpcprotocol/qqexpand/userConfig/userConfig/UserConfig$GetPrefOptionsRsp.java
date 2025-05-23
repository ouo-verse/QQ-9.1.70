package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class UserConfig$GetPrefOptionsRsp extends MessageMicro<UserConfig$GetPrefOptionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 8010}, new String[]{"tag_id", "title", "tips_wording", "default_selected_id", "pref_info"}, new Object[]{0, "", "", 0, null}, UserConfig$GetPrefOptionsRsp.class);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField tips_wording = PBField.initString("");
    public final PBEnumField default_selected_id = PBField.initEnum(0);
    public final PBRepeatMessageField<UserConfig$PrefInfo> pref_info = PBField.initRepeatMessage(UserConfig$PrefInfo.class);
}
