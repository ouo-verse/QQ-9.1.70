package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class qqstory_bhd_upload_pic$ReqStoryPic extends MessageMicro<qqstory_bhd_upload_pic$ReqStoryPic> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField img_data;
    public final PBEnumField platform;
    public final PBUInt32Field tojpg;
    public final PBBytesField version;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"img_data", "tojpg", "platform", "version"}, new Object[]{byteStringMicro, 0, 1, byteStringMicro}, qqstory_bhd_upload_pic$ReqStoryPic.class);
    }

    public qqstory_bhd_upload_pic$ReqStoryPic() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.img_data = PBField.initBytes(byteStringMicro);
        this.tojpg = PBField.initUInt32(0);
        this.platform = PBField.initEnum(1);
        this.version = PBField.initBytes(byteStringMicro);
    }
}
