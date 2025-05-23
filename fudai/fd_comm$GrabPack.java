package fudai;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.oskplayer.util.SecretUtils;

/* loaded from: classes28.dex */
public final class fd_comm$GrabPack extends MessageMicro<fd_comm$GrabPack> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"pack_type", "none_pack_desc", "monay_pack_info", "card_pack_info", "bless_pack_info"}, new Object[]{0, "", null, null, null}, fd_comm$GrabPack.class);
    public final PBEnumField pack_type = PBField.initEnum(0);
    public final PBStringField none_pack_desc = PBField.initString("");
    public fd_comm$MoneyPackInfo monay_pack_info = new MessageMicro<fd_comm$MoneyPackInfo>() { // from class: fudai.fd_comm$MoneyPackInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{WidgetCacheConstellationData.MONEY, SecretUtils.DES, "money_id"}, new Object[]{0, "", 0}, fd_comm$MoneyPackInfo.class);
        public final PBUInt32Field money = PBField.initUInt32(0);
        public final PBStringField des = PBField.initString("");
        public final PBUInt32Field money_id = PBField.initUInt32(0);
    };
    public fd_comm$CardPackInfo card_pack_info = new MessageMicro<fd_comm$CardPackInfo>() { // from class: fudai.fd_comm$CardPackInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"card_id", "card_des", "jmp_url", "url_suffix"}, new Object[]{0, "", "", ""}, fd_comm$CardPackInfo.class);
        public final PBUInt32Field card_id = PBField.initUInt32(0);
        public final PBStringField card_des = PBField.initString("");
        public final PBStringField jmp_url = PBField.initString("");
        public final PBStringField url_suffix = PBField.initString("");
    };
    public fd_comm$BlessPackInfo bless_pack_info = new MessageMicro<fd_comm$BlessPackInfo>() { // from class: fudai.fd_comm$BlessPackInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bless_des", "jmp_url", "bless_id"}, new Object[]{"", "", 0}, fd_comm$BlessPackInfo.class);
        public final PBStringField bless_des = PBField.initString("");
        public final PBStringField jmp_url = PBField.initString("");
        public final PBUInt32Field bless_id = PBField.initUInt32(0);
    };
}
