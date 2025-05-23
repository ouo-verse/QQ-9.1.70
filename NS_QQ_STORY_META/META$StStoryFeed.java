package NS_QQ_STORY_META;

import NS_COMM.COMM;
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
public final class META$StStoryFeed extends MessageMicro<META$StStoryFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 72, 82, 90, 98, 106, 114, 122, 128}, new String[]{"id", "desc", "postUser", "coverImage", "storyVideo", WadlProxyConsts.CREATE_TIME, "vecText", "likeInfo", "commentCount", "vecComment", "cellComm", "vecExtInfo", "storyMusic", "emojiInfo", "vecBytesExt", "secureHit"}, new Object[]{"", "", null, null, null, 0L, "", null, 0, null, null, null, null, null, null, 0}, META$StStoryFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f25067id = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public META$StUser postUser = new META$StUser();
    public META$StImage coverImage = new META$StImage();
    public META$StVideo storyVideo = new MessageMicro<META$StVideo>() { // from class: NS_QQ_STORY_META.META$StVideo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72, 82, 88, 98}, new String[]{"fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl", "playCount", "vecExtInfo"}, new Object[]{"", 0, 0, 0, 0, "", 0, 0, 0, null, 0, null}, META$StVideo.class);
        public final PBStringField fileId = PBField.initString("");
        public final PBUInt32Field fileSize = PBField.initUInt32(0);
        public final PBUInt32Field duration = PBField.initUInt32(0);
        public final PBUInt32Field width = PBField.initUInt32(0);
        public final PBUInt32Field height = PBField.initUInt32(0);
        public final PBStringField playUrl = PBField.initString("");
        public final PBUInt32Field transStatus = PBField.initUInt32(0);
        public final PBUInt32Field videoPrior = PBField.initUInt32(0);
        public final PBUInt32Field videoRate = PBField.initUInt32(0);
        public final PBRepeatMessageField<META$StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(META$StVideoUrl.class);
        public final PBUInt32Field playCount = PBField.initUInt32(0);
        public final PBRepeatMessageField<COMM.Entry> vecExtInfo = PBField.initRepeatMessage(COMM.Entry.class);
    };
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBRepeatField<String> vecText = PBField.initRepeat(PBStringField.__repeatHelper__);
    public META$StLike likeInfo = new MessageMicro<META$StLike>() { // from class: NS_QQ_STORY_META.META$StLike
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"id", "count", "status", "vecUser"}, new Object[]{"", 0, 0, null}, META$StLike.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f25065id = PBField.initString("");
        public final PBUInt32Field count = PBField.initUInt32(0);
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBRepeatMessageField<META$StUser> vecUser = PBField.initRepeatMessage(META$StUser.class);
    };
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<META$StComment> vecComment = PBField.initRepeatMessage(META$StComment.class);
    public META$StCellComm cellComm = new MessageMicro<META$StCellComm>() { // from class: NS_QQ_STORY_META.META$StCellComm
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"operateMask", "feedsAttr", "operateMask2", "feedsAttr2"}, new Object[]{0, 0, 0, 0}, META$StCellComm.class);
        public final PBUInt32Field operateMask = PBField.initUInt32(0);
        public final PBUInt32Field feedsAttr = PBField.initUInt32(0);
        public final PBUInt32Field operateMask2 = PBField.initUInt32(0);
        public final PBUInt32Field feedsAttr2 = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<COMM.Entry> vecExtInfo = PBField.initRepeatMessage(COMM.Entry.class);
    public META$StMusic storyMusic = new META$StMusic();
    public META$StEmoji emojiInfo = new MessageMicro<META$StEmoji>() { // from class: NS_QQ_STORY_META.META$StEmoji
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"emojiList", "totalCount"}, new Object[]{null, 0L}, META$StEmoji.class);
        public final PBRepeatMessageField<META$EmojiMeta> emojiList = PBField.initRepeatMessage(META$EmojiMeta.class);
        public final PBUInt64Field totalCount = PBField.initUInt64(0);
    };
    public final PBRepeatMessageField<COMM.BytesEntry> vecBytesExt = PBField.initRepeatMessage(COMM.BytesEntry.class);
    public final PBUInt32Field secureHit = PBField.initUInt32(0);
}
