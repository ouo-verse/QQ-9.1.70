package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$GetRoleByIDRsp extends MessageMicro<GameFriendSelectorSvr$GetRoleByIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"role"}, new Object[]{null}, GameFriendSelectorSvr$GetRoleByIDRsp.class);
    public GameFriendSelectorSvr$Role role = new MessageMicro<GameFriendSelectorSvr$Role>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$Role
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "plat_id", "partition", "role_id", "role_name", "openid", "partition_name", "uin", "gamemsg_role_id"}, new Object[]{0, 0, 0, "", "", "", "", 0L, ""}, GameFriendSelectorSvr$Role.class);
        public final PBInt32Field area = PBField.initInt32(0);
        public final PBInt32Field plat_id = PBField.initInt32(0);
        public final PBInt32Field partition = PBField.initInt32(0);
        public final PBStringField role_id = PBField.initString("");
        public final PBStringField role_name = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField partition_name = PBField.initString("");
        public final PBInt64Field uin = PBField.initInt64(0);
        public final PBStringField gamemsg_role_id = PBField.initString("");
    };
}
