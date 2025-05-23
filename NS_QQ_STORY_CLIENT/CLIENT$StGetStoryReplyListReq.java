package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StComment;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetStoryReplyListReq extends MessageMicro<CLIENT$StGetStoryReplyListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "storyFeed", "comment", "listNum"}, new Object[]{null, null, null, 0}, CLIENT$StGetStoryReplyListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public META$StStoryFeed storyFeed = new META$StStoryFeed();
    public META$StComment comment = new MessageMicro<META$StComment>() { // from class: NS_QQ_STORY_META.META$StComment
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 58}, new String[]{"id", "postUser", WadlProxyConsts.CREATE_TIME, "content", "vecAtUin", "replyCount", "vecReply"}, new Object[]{"", null, 0L, "", 0L, 0, null}, META$StComment.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f25064id = PBField.initString("");
        public META$StUser postUser = new META$StUser();
        public final PBUInt64Field createTime = PBField.initUInt64(0);
        public final PBStringField content = PBField.initString("");
        public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field replyCount = PBField.initUInt32(0);
        public final PBRepeatMessageField<META$StReply> vecReply = PBField.initRepeatMessage(META$StReply.class);
    };
    public final PBUInt32Field listNum = PBField.initUInt32(0);
}
