package com.tencent.trpcprotocol.qbox.datacard_manager.datacard_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class DatacardManagerPB$GetActionRsp extends MessageMicro<DatacardManagerPB$GetActionRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField can_show = PBField.initBool(false);
    public DatacardManagerPB$ActionInfo action = new DatacardManagerPB$ActionInfo();
    public final PBBoolField is_black = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"can_show", "action", "is_black"}, new Object[]{bool, null, bool}, DatacardManagerPB$GetActionRsp.class);
    }
}
