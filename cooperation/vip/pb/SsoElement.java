package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SsoElement {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class AIOEntraceReq extends MessageMicro<AIOEntraceReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"co_adopter", "version"}, new Object[]{0L, 0}, AIOEntraceReq.class);
        public final PBUInt64Field co_adopter = PBField.initUInt64(0);
        public final PBUInt32Field version = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class AIOEntraceRsp extends MessageMicro<AIOEntraceRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"element_pic", "tag_pic", "main_title", "content", "element_count"}, new Object[]{"", "", "", "", 0}, AIOEntraceRsp.class);
        public final PBStringField element_pic = PBField.initString("");
        public final PBStringField tag_pic = PBField.initString("");
        public final PBStringField main_title = PBField.initString("");
        public final PBStringField content = PBField.initString("");
        public final PBUInt32Field element_count = PBField.initUInt32(0);
    }

    SsoElement() {
    }
}
