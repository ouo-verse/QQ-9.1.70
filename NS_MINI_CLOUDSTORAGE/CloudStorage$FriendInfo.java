package NS_MINI_CLOUDSTORAGE;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$FriendInfo extends MessageMicro<CloudStorage$FriendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{PhotoCategorySummaryInfo.AVATAR_URL, "nickname", "openid"}, new Object[]{"", "", ""}, CloudStorage$FriendInfo.class);
    public final PBStringField avatarUrl = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
}
