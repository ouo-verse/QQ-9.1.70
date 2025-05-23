package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CircleSearchExhibition$PromptTagInfo extends MessageMicro<CircleSearchExhibition$PromptTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"tag_name", "tag_dec", "tag_icon", "tag_big_back_img", "tag_mid_back_img", "ext_report_info", "jump_url"}, new Object[]{"", "", "", "", "", ByteStringMicro.EMPTY, ""}, CircleSearchExhibition$PromptTagInfo.class);
    public final PBStringField tag_name = PBField.initString("");
    public final PBStringField tag_dec = PBField.initString("");
    public final PBStringField tag_icon = PBField.initString("");
    public final PBStringField tag_big_back_img = PBField.initString("");
    public final PBStringField tag_mid_back_img = PBField.initString("");
    public final PBBytesField ext_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField jump_url = PBField.initString("");
}
