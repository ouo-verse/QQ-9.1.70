package NS_MINI_GAME_RAFFLE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GameRaffleInfo$StGetGameRaffleMaterialRsp extends MessageMicro<GameRaffleInfo$StGetGameRaffleMaterialRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72, 82}, new String[]{"ret", "raffleImg", "shareImg", "shareBtn", "openedPackImg", "backBtn", "wishingImg", "promotion_id", "active_id", "watchAdBtn"}, new Object[]{0, "", "", "", "", "", "", 0, 0, ""}, GameRaffleInfo$StGetGameRaffleMaterialRsp.class);
    public final PBEnumField ret = PBField.initEnum(0);
    public final PBStringField raffleImg = PBField.initString("");
    public final PBStringField shareImg = PBField.initString("");
    public final PBStringField shareBtn = PBField.initString("");
    public final PBStringField openedPackImg = PBField.initString("");
    public final PBStringField backBtn = PBField.initString("");
    public final PBStringField wishingImg = PBField.initString("");
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field active_id = PBField.initUInt32(0);
    public final PBStringField watchAdBtn = PBField.initString("");
}
