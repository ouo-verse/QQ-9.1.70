package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class oidb_common$DataCardConfig extends MessageMicro<oidb_common$DataCardConfig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_wording;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_tail_wording;
    public final PBUInt32Field uint32_card_wording_color;
    public final PBUInt32Field uint32_entry_ability;
    public final PBUInt32Field uint32_tail_wording_color;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50}, new String[]{"bytes_card_wording", "bytes_tail_wording", "uint32_entry_ability", "uint32_card_wording_color", "uint32_tail_wording_color", "bytes_icon_url"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro}, oidb_common$DataCardConfig.class);
    }

    public oidb_common$DataCardConfig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_card_wording = PBField.initBytes(byteStringMicro);
        this.bytes_tail_wording = PBField.initBytes(byteStringMicro);
        this.uint32_entry_ability = PBField.initUInt32(0);
        this.uint32_card_wording_color = PBField.initUInt32(0);
        this.uint32_tail_wording_color = PBField.initUInt32(0);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
    }
}
