package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$EmojiMetaWithUser extends MessageMicro<META$EmojiMetaWithUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"emojiMeta", QCircleAlphaUserReporter.KEY_USER}, new Object[]{null, null}, META$EmojiMetaWithUser.class);
    public META$EmojiMeta emojiMeta = new MessageMicro<META$EmojiMeta>() { // from class: NS_QQ_STORY_META.META$EmojiMeta
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"emojiType", "count", "createtime"}, new Object[]{1, 0L, 0L}, META$EmojiMeta.class);
        public final PBEnumField emojiType = PBField.initEnum(1);
        public final PBUInt64Field count = PBField.initUInt64(0);
        public final PBUInt64Field createtime = PBField.initUInt64(0);
    };
    public META$StUser user = new META$StUser();
}
