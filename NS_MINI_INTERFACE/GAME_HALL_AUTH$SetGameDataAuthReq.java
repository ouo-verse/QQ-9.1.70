package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GAME_HALL_AUTH$SetGameDataAuthReq extends MessageMicro<GAME_HALL_AUTH$SetGameDataAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{GameHallAuthServerlet.AUTH_STATUS}, new Object[]{0}, GAME_HALL_AUTH$SetGameDataAuthReq.class);
    public final PBEnumField auth_status = PBField.initEnum(0);
}
