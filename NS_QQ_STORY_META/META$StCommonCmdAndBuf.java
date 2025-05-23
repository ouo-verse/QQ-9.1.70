package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StCommonCmdAndBuf extends MessageMicro<META$StCommonCmdAndBuf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"cmd", "busiBuf"}, new Object[]{1, ByteStringMicro.EMPTY}, META$StCommonCmdAndBuf.class);
    public final PBEnumField cmd = PBField.initEnum(1);
    public final PBBytesField busiBuf = PBField.initBytes(ByteStringMicro.EMPTY);
}
