package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$SetUserMatchReq extends MessageMicro<userInfo$SetUserMatchReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField match_obj = PBField.initEnum(0);
    public final PBBoolField shield_qq_friend = PBField.initBool(false);
    public userInfo$UpdateUserTagsReq update_user_tags_req = new userInfo$UpdateUserTagsReq();
    public userInfo$UpdateDatingPurposesReq update_dating_purposes_req = new userInfo$UpdateDatingPurposesReq();
    public final PBBoolField is_new_kuolie_req = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"match_obj", "shield_qq_friend", "update_user_tags_req", "update_dating_purposes_req", "is_new_kuolie_req"}, new Object[]{0, bool, null, null, bool}, userInfo$SetUserMatchReq.class);
    }
}
