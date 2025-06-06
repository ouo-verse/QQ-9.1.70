package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$StarInfo extends MessageMicro<ARCloudRecogCustomPb$StarInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 53, 58, 64, 72, 80, 88, 98, 808, 816}, new String[]{"uin", "face_rect_id", "name", "star_wiki", "star_wiki_jumpurl", "confidence", "pinyin_name", "side_face", "mask", "sunglasses", "perspective", "star_wiki_title", "enum_game_id", "uint32_be_killed"}, new Object[]{0L, 0, "", "", "", Float.valueOf(0.0f), "", 0, 0, 0, 0, "", 0, 0}, ARCloudRecogCustomPb$StarInfo.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt32Field face_rect_id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField star_wiki = PBField.initString("");
    public final PBStringField star_wiki_jumpurl = PBField.initString("");
    public final PBFloatField confidence = PBField.initFloat(0.0f);
    public final PBStringField pinyin_name = PBField.initString("");
    public final PBInt32Field side_face = PBField.initInt32(0);
    public final PBInt32Field mask = PBField.initInt32(0);
    public final PBInt32Field sunglasses = PBField.initInt32(0);
    public final PBInt32Field perspective = PBField.initInt32(0);
    public final PBStringField star_wiki_title = PBField.initString("");
    public final PBEnumField enum_game_id = PBField.initEnum(0);
    public final PBUInt32Field uint32_be_killed = PBField.initUInt32(0);
}
