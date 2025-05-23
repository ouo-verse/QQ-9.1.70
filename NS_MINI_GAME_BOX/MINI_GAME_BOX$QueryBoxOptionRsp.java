package NS_MINI_GAME_BOX;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MINI_GAME_BOX$QueryBoxOptionRsp extends MessageMicro<MINI_GAME_BOX$QueryBoxOptionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_display_open_btn"}, new Object[]{Boolean.FALSE}, MINI_GAME_BOX$QueryBoxOptionRsp.class);
    public final PBBoolField is_display_open_btn = PBField.initBool(false);
}
