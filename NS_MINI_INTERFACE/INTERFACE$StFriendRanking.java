package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StFriendRanking extends MessageMicro<INTERFACE$StFriendRanking> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, new String[]{"gameInfo", "friendsNum", "rankingList", "hasmore", "animationPic"}, new Object[]{null, 0, null, 0, ""}, INTERFACE$StFriendRanking.class);
    public INTERFACE$StUserAppInfo gameInfo = new INTERFACE$StUserAppInfo();
    public final PBInt32Field friendsNum = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE$StRankingList> rankingList = PBField.initRepeatMessage(INTERFACE$StRankingList.class);
    public final PBInt32Field hasmore = PBField.initInt32(0);
    public final PBStringField animationPic = PBField.initString("");
}
