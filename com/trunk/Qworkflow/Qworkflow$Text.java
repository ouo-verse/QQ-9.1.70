package com.trunk.Qworkflow;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$Text extends MessageMicro<Qworkflow$Text> {
    public static final int CONTENT_SUMMARY = 3;
    public static final int CONTENT_TYPE_LINK = 1;
    public static final int CONTENT_TYPE_NUMBER = 2;
    public static final int CONTENT_TYPE_TEXT = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content;
    public final PBBytesField bytes_userdef;
    public final PBEnumField enum_type = PBField.initEnum(0);

    static {
        String[] strArr = {"enum_type", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "bytes_userdef"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, strArr, new Object[]{0, byteStringMicro, byteStringMicro}, Qworkflow$Text.class);
    }

    public Qworkflow$Text() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_content = PBField.initBytes(byteStringMicro);
        this.bytes_userdef = PBField.initBytes(byteStringMicro);
    }
}
