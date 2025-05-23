package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$PromoteViewItem extends MessageMicro<OpenSdkRecCommon$PromoteViewItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"type", "id", "name", "describe", "icon_url", "channel_extra_info"}, new Object[]{0, "", "", "", "", null}, OpenSdkRecCommon$PromoteViewItem.class);
    public final PBEnumField type = PBField.initEnum(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f342463id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField describe = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public OpenSdkRecCommon$ChannelExtraInfo channel_extra_info = new MessageMicro<OpenSdkRecCommon$ChannelExtraInfo>() { // from class: com.tencent.qconn.protofile.OpenSdkRecCommon$ChannelExtraInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], OpenSdkRecCommon$ChannelExtraInfo.class);
    };
}
