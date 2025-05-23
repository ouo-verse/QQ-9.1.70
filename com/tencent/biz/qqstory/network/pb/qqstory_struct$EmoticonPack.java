package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* loaded from: classes5.dex */
public final class qqstory_struct$EmoticonPack extends MessageMicro<qqstory_struct$EmoticonPack> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField config;
    public final PBBytesField download_icon;
    public final PBBytesField download_url;
    public final PBBytesField icon;
    public final PBBytesField md5;
    public final PBBytesField name;
    public final PBUInt32Field pack_id = PBField.initUInt32(0);
    public final PBEnumField type;
    public final PBUInt32Field version;

    static {
        String[] strArr = {"pack_id", "icon", "name", "download_url", "type", "md5", "version", "download_icon", DownloadInfo.spKey_Config};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 66, 74}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 1, byteStringMicro, 0, byteStringMicro, byteStringMicro}, qqstory_struct$EmoticonPack.class);
    }

    public qqstory_struct$EmoticonPack() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.icon = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
        this.download_url = PBField.initBytes(byteStringMicro);
        this.type = PBField.initEnum(1);
        this.md5 = PBField.initBytes(byteStringMicro);
        this.version = PBField.initUInt32(0);
        this.download_icon = PBField.initBytes(byteStringMicro);
        this.config = PBField.initBytes(byteStringMicro);
    }
}
