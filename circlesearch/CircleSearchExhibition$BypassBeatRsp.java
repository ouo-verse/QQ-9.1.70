package circlesearch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$BypassBeatRsp extends MessageMicro<CircleSearchExhibition$BypassBeatRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "errormsg"}, new Object[]{0, ByteStringMicro.EMPTY}, CircleSearchExhibition$BypassBeatRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBBytesField errormsg = PBField.initBytes(ByteStringMicro.EMPTY);
}
