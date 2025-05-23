package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoAddr extends MessageMicro<PttShortVideo$PttShortVideoAddr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82, 90, 170, 178}, new String[]{"uint32_host_type", "rpt_str_host", "str_url_args", "rpt_str_host_ipv6", "rpt_str_domain"}, new Object[]{0, "", "", "", ""}, PttShortVideo$PttShortVideoAddr.class);
    public final PBRepeatField<String> rpt_str_domain;
    public final PBRepeatField<String> rpt_str_host;
    public final PBRepeatField<String> rpt_str_host_ipv6;
    public final PBStringField str_url_args;
    public final PBUInt32Field uint32_host_type = PBField.initUInt32(0);

    public PttShortVideo$PttShortVideoAddr() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.rpt_str_host = PBField.initRepeat(pBStringField);
        this.str_url_args = PBField.initString("");
        this.rpt_str_host_ipv6 = PBField.initRepeat(pBStringField);
        this.rpt_str_domain = PBField.initRepeat(pBStringField);
    }
}
