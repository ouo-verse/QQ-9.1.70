package com.tencent.protofile.join_group_link;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.ProfileContants;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class join_group_link$GroupInfo extends MessageMicro<join_group_link$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_face;
    public final PBBytesField group_finger_memo;
    public final PBUInt32Field group_member_max_num = PBField.initUInt32(0);
    public final PBUInt32Field group_member_num = PBField.initUInt32(0);
    public final PBBytesField group_name;
    public final PBBytesField join_group_auth;

    static {
        String[] strArr = {"group_member_max_num", "group_member_num", "group_name", ProfileContants.CMD_PARAM_GROUP_FINGER_MEMO, "join_group_auth", "group_face"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{40, 48, 122, 138, 746, 8002}, strArr, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, join_group_link$GroupInfo.class);
    }

    public join_group_link$GroupInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.group_finger_memo = PBField.initBytes(byteStringMicro);
        this.join_group_auth = PBField.initBytes(byteStringMicro);
        this.group_face = PBField.initBytes(byteStringMicro);
    }
}
