package NS_QQ_STORY_CLIENT;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StUinStory extends MessageMicro<CLIENT$StUinStory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "storyBuff"}, new Object[]{0L, ByteStringMicro.EMPTY}, CLIENT$StUinStory.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBytesField storyBuff = PBField.initBytes(ByteStringMicro.EMPTY);
}
