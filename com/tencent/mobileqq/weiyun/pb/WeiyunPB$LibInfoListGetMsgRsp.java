package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WeiyunPB$LibInfoListGetMsgRsp extends MessageMicro<WeiyunPB$LibInfoListGetMsgRsp> {
    public static final int FILEITEM_ITEMS_FIELD_NUMBER = 40;
    public static final int FINISH_FLAG_FIELD_NUMBER = 10;
    public static final int OVERFLOW_FLAG_FIELD_NUMBER = 20;
    public static final int SERVER_VERSION_FIELD_NUMBER = 30;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 242, 322}, new String[]{"finish_flag", "overflow_flag", DeviceProfileManager.KEY_SERVER_VISION, "FileItem_items"}, new Object[]{0, Boolean.FALSE, "", null}, WeiyunPB$LibInfoListGetMsgRsp.class);
    public final PBInt32Field finish_flag = PBField.initInt32(0);
    public final PBBoolField overflow_flag = PBField.initBool(false);
    public final PBStringField server_version = PBField.initString("");
    public final PBRepeatMessageField<WeiyunPB$FileItem> FileItem_items = PBField.initRepeatMessage(WeiyunPB$FileItem.class);
}
