package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StUserInfo extends MessageMicro<META_PROTOCOL$StUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"nick", "avatar", "gender", "address", IjkMediaMeta.IJKM_KEY_LANGUAGE}, new Object[]{"", "", 0, null, ""}, META_PROTOCOL$StUserInfo.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field gender = PBField.initInt32(0);
    public META_PROTOCOL$StAddressInfo address = new MessageMicro<META_PROTOCOL$StAddressInfo>() { // from class: NS_MINI_META.META_PROTOCOL$StAddressInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"country", "province", "city"}, new Object[]{"", "", ""}, META_PROTOCOL$StAddressInfo.class);
        public final PBStringField country = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField city = PBField.initString("");
    };
    public final PBStringField language = PBField.initString("");
}
