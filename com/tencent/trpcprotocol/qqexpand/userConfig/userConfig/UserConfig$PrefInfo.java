package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class UserConfig$PrefInfo extends MessageMicro<UserConfig$PrefInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56}, new String[]{"describe", "icon_url", "pref_wording", "time_limit_info", "selected_wording", "selected_status", "pref_id"}, new Object[]{"", "", "", null, "", Boolean.FALSE, 0}, UserConfig$PrefInfo.class);
    public final PBStringField describe = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField pref_wording = PBField.initString("");
    public UserConfig$TimeLimitInfo time_limit_info = new MessageMicro<UserConfig$TimeLimitInfo>() { // from class: com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig$TimeLimitInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"limit_wording", "jump_wording", "jump_url"}, new Object[]{"", "", ""}, UserConfig$TimeLimitInfo.class);
        public final PBStringField limit_wording = PBField.initString("");
        public final PBStringField jump_wording = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    };
    public final PBStringField selected_wording = PBField.initString("");
    public final PBBoolField selected_status = PBField.initBool(false);
    public final PBEnumField pref_id = PBField.initEnum(0);
}
