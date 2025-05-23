package com.tencent.biz.qqstory.network.pb;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes5.dex */
public final class qqstory_struct$POIPosterData extends MessageMicro<qqstory_struct$POIPosterData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField name;
    public final PBBytesField poster_json_layout_desc;
    public final PBBytesField poster_name;
    public final PBBytesField poster_url;
    public final PBBytesField thumb_url;

    static {
        String[] strArr = {FacadeCacheData.THUMB_URL, "poster_name", "poster_url", "name", "poster_json_layout_desc"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 82}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, qqstory_struct$POIPosterData.class);
    }

    public qqstory_struct$POIPosterData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.thumb_url = PBField.initBytes(byteStringMicro);
        this.poster_name = PBField.initBytes(byteStringMicro);
        this.poster_url = PBField.initBytes(byteStringMicro);
        this.poster_json_layout_desc = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
    }
}
