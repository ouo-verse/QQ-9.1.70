package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$ConfigSeq extends MessageMicro<ConfigurationService$ConfigSeq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"type", "version", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "tab_rule"}, new Object[]{0, 0, 0, null}, ConfigurationService$ConfigSeq.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBInt32Field compress = PBField.initInt32(0);
    public ConfigurationService$TabRule tab_rule = new ConfigurationService$TabRule();
}
