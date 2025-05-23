package feedcloud;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StRelationInfo extends MessageMicro<FeedCloudMeta$StRelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398459id = PBField.initString("");
    public final PBUInt32Field relation = PBField.initUInt32(0);
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field relationState = PBField.initUInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBBoolField isBlock = PBField.initBool(false);
    public final PBBoolField isBlocked = PBField.initBool(false);
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBBoolField isUncare = PBField.initBool(false);
    public final PBUInt64Field imBitMap = PBField.initUInt64(0);
    public final PBBoolField banned = PBField.initBool(false);

    static {
        String[] strArr = {"id", "relation", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "relationState", LocalPhotoFaceInfo.SCORE, "isBlock", "isBlocked", IProfileProtocolConst.PARAM_IS_FRIEND, "isUncare", "imBitMap", "banned"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56, 64, 72, 80, 88}, strArr, new Object[]{"", 0, ByteStringMicro.EMPTY, 0, 0, bool, bool, bool, bool, 0L, bool}, FeedCloudMeta$StRelationInfo.class);
    }
}
