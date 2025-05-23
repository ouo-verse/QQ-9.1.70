package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WEISHI$stMetaUgcImage extends MessageMicro<WEISHI$stMetaUgcImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"url", "width", "height", "type", "sprite_width", "sprite_height", "sprite_span"}, new Object[]{"", 0, 0, 0, 0, 0, 0}, WEISHI$stMetaUgcImage.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field sprite_width = PBField.initInt32(0);
    public final PBInt32Field sprite_height = PBField.initInt32(0);
    public final PBInt32Field sprite_span = PBField.initInt32(0);
}
