package NS_MINI_APP_MISC;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class MISC$StGetFriendPlayListRsp extends MessageMicro<MISC$StGetFriendPlayListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBBoolField finish = PBField.initBool(false);
    public final PBRepeatMessageField<MISC$StAppPlayingInfo> appPlayingInfos = PBField.initRepeatMessage(MISC$StAppPlayingInfo.class);
    public final PBStringField moreJumpLink = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBBoolField showOtherFriPlay = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"total", "finish", "appPlayingInfos", "moreJumpLink", "ext", "showOtherFriPlay"}, new Object[]{0, bool, null, "", null, bool}, MISC$StGetFriendPlayListRsp.class);
    }
}
