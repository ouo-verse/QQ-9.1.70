package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StAddInteractEmojiReq extends MessageMicro<CLIENT$StAddInteractEmojiReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"extInfo", "feedID", "feedPosterUin", "emojiId", "emojiAddCount"}, new Object[]{null, "", "", 1, 0}, CLIENT$StAddInteractEmojiReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField feedPosterUin = PBField.initString("");
    public final PBEnumField emojiId = PBField.initEnum(1);
    public final PBInt32Field emojiAddCount = PBField.initInt32(0);
}
