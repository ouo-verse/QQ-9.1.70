package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GameRaffleInfo$StDoGameRaffleRsp extends MessageMicro<GameRaffleInfo$StDoGameRaffleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"state", "pack", "onlinePrizeImg", "active_id"}, new Object[]{0, null, "", 0}, GameRaffleInfo$StDoGameRaffleRsp.class);
    public final PBEnumField state = PBField.initEnum(0);
    public GameRaffleInfo$Pack pack = new GameRaffleInfo$Pack();
    public final PBStringField onlinePrizeImg = PBField.initString("");
    public final PBUInt32Field active_id = PBField.initUInt32(0);
}
