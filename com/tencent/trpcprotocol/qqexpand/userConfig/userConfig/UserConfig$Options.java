package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$Options extends MessageMicro<UserConfig$Options> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"wangzheOptions", "expandWallOptions", "pref_ids", "expandEntranceOptions"}, new Object[]{null, null, 0, null}, UserConfig$Options.class);
    public UserConfig$WangzheOptions wangzheOptions = new MessageMicro<UserConfig$WangzheOptions>() { // from class: com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig$WangzheOptions
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField IsAllowDisplayRecord = PBField.initBool(false);
        public final PBBoolField IsShowWangzheDD = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"IsAllowDisplayRecord", "IsShowWangzheDD"}, new Object[]{bool, bool}, UserConfig$WangzheOptions.class);
        }
    };
    public UserConfig$ExpandWallOptions expandWallOptions = new MessageMicro<UserConfig$ExpandWallOptions>() { // from class: com.tencent.trpcprotocol.qqexpand.userConfig.userConfig.UserConfig$ExpandWallOptions
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"IsAllowEntryExpandWall"}, new Object[]{Boolean.FALSE}, UserConfig$ExpandWallOptions.class);
        public final PBBoolField IsAllowEntryExpandWall = PBField.initBool(false);
    };
    public final PBRepeatField<Integer> pref_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public UserConfig$ExpandEntranceOptions expandEntranceOptions = new UserConfig$ExpandEntranceOptions();
}
