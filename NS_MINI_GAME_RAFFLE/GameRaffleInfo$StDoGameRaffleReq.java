package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GameRaffleInfo$StDoGameRaffleReq extends MessageMicro<GameRaffleInfo$StDoGameRaffleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "uin"}, new Object[]{"", ""}, GameRaffleInfo$StDoGameRaffleReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
}
