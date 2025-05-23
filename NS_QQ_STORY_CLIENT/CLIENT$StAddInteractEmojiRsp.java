package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StAddInteractEmojiRsp extends MessageMicro<CLIENT$StAddInteractEmojiRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "emojiTotalCount"}, new Object[]{null, 0L}, CLIENT$StAddInteractEmojiRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt64Field emojiTotalCount = PBField.initUInt64(0);
}
