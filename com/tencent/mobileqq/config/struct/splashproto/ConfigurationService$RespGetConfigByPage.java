package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes10.dex */
public final class ConfigurationService$RespGetConfigByPage extends MessageMicro<ConfigurationService$RespGetConfigByPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 808, 816, 824, 832, 840, 1600}, new String[]{"result", "type", "content", "page_info", "delay_time", "wording_no", "seed_ids", "show_time", "show_strategy", "stagger_version"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null, 0, 0, 0, 0, 0, 0}, ConfigurationService$RespGetConfigByPage.class);
    public final PBRepeatField<Integer> delay_time;
    public final PBRepeatField<Integer> seed_ids;
    public final PBUInt32Field show_strategy;
    public final PBUInt32Field show_time;
    public final PBUInt32Field stagger_version;
    public final PBUInt32Field wording_no;
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public ConfigurationService$PageRespInfo page_info = new ConfigurationService$PageRespInfo();

    public ConfigurationService$RespGetConfigByPage() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.delay_time = PBField.initRepeat(pBUInt32Field);
        this.wording_no = PBField.initUInt32(0);
        this.seed_ids = PBField.initRepeat(pBUInt32Field);
        this.show_time = PBField.initUInt32(0);
        this.show_strategy = PBField.initUInt32(0);
        this.stagger_version = PBField.initUInt32(0);
    }
}
