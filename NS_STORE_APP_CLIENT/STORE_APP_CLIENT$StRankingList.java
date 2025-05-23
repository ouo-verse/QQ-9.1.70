package NS_STORE_APP_CLIENT;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class STORE_APP_CLIENT$StRankingList extends MessageMicro<STORE_APP_CLIENT$StRankingList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"nick", "avatar", "ranks", LocalPhotoFaceInfo.SCORE, "unit", "uid"}, new Object[]{"", "", 0, 0, "", ""}, STORE_APP_CLIENT$StRankingList.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field ranks = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBStringField unit = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
}
