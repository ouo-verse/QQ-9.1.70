package NS_MINI_INTERFACE;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StRankingList extends MessageMicro<INTERFACE$StRankingList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"nick", "avatar", "ranks", LocalPhotoFaceInfo.SCORE, "unit"}, new Object[]{"", "", 0, 0, ""}, INTERFACE$StRankingList.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field ranks = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBStringField unit = PBField.initString("");
}
