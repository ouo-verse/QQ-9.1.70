package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$RichTitleElement extends MessageMicro<FeedsProtocol$RichTitleElement> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField text;
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "text", "url"}, new Object[]{0, byteStringMicro, byteStringMicro}, FeedsProtocol$RichTitleElement.class);
    }

    public FeedsProtocol$RichTitleElement() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.text = PBField.initBytes(byteStringMicro);
        this.url = PBField.initBytes(byteStringMicro);
    }
}
