package WEISHI_USER_GROWTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WEISHI$stMetaFeed extends MessageMicro<WEISHI$stMetaFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 58, 210, 218}, new String[]{"id", "wording", "type", "poster_id", "images", "video_url", "material_thumburl"}, new Object[]{"", "", 0, "", null, "", ""}, WEISHI$stMetaFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f25137id = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField poster_id = PBField.initString("");
    public final PBRepeatMessageField<WEISHI$stMetaUgcImage> images = PBField.initRepeatMessage(WEISHI$stMetaUgcImage.class);
    public final PBStringField video_url = PBField.initString("");
    public final PBStringField material_thumburl = PBField.initString("");
}
