package com.tencent.online.push.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$PublicAccountFolderInfo extends MessageMicro<OnlinePushField$PublicAccountFolderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1364008, 1364016, 1364024, 1364032}, new String[]{"folder_type", "folder_unread", "folder_status", "dw_time_stamp"}, new Object[]{0, 0, 0, 0L}, OnlinePushField$PublicAccountFolderInfo.class);
    public final PBUInt32Field folder_type = PBField.initUInt32(0);
    public final PBUInt32Field folder_unread = PBField.initUInt32(0);
    public final PBUInt32Field folder_status = PBField.initUInt32(0);
    public final PBInt64Field dw_time_stamp = PBField.initInt64(0);
}
