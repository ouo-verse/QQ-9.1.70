package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class fd_comm$PicInfo extends MessageMicro<fd_comm$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pic_url"}, new Object[]{""}, fd_comm$PicInfo.class);
    public final PBStringField pic_url = PBField.initString("");
}
