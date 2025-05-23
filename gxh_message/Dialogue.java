package gxh_message;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Dialogue extends MessageMicro<Dialogue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"nameplate_pendant_itemid", "diyfontid", "game_nameplate", "vipstar_flag", "diy_nameplate_ids", "qqvadata_changerand", "aio_badge_show_switch"}, new Object[]{0, 0, 0, 0, 0, 0, 0}, Dialogue.class);
    public final PBInt32Field nameplate_pendant_itemid = PBField.initInt32(0);
    public final PBInt32Field diyfontid = PBField.initInt32(0);
    public final PBInt32Field game_nameplate = PBField.initInt32(0);
    public final PBInt32Field vipstar_flag = PBField.initInt32(0);
    public final PBRepeatField<Integer> diy_nameplate_ids = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field qqvadata_changerand = PBField.initInt32(0);
    public final PBInt32Field aio_badge_show_switch = PBField.initInt32(0);
}
