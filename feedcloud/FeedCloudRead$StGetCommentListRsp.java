package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCommentListRsp extends MessageMicro<FeedCloudRead$StGetCommentListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ai_cmt_trans_info;
    public final PBBytesField busiRspData;
    public FeedCloudRead$CmtShowConfig cmt_show_config;
    public final PBRepeatField<String> emojiAfterLikeComment;
    public FeedCloudRead$CmtExps epxs;
    public final PBStringField fastCommentText;
    public FeedCloudRead$GuildDisplayInfo guildDisplayInfo;
    public final PBBoolField is_e_da_xia;
    public final PBBoolField need_ad_req_nextpage;
    public final PBUInt32Field show_qq_lianxiang_emoji;
    public final PBBoolField show_satisfy_vote;
    public final PBStringField tailText;
    public final PBRepeatField<String> textAfterLikeComment;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StComment> vecComment = PBField.initRepeatMessage(FeedCloudMeta$StComment.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 128, 136, 144}, new String[]{"extInfo", "vecComment", "totalNum", "isFinish", "feedAttchInfo", "busiRspData", "tailText", "fastCommentText", "guildDisplayInfo", "textAfterLikeComment", "emojiAfterLikeComment", "show_qq_lianxiang_emoji", "epxs", "ai_cmt_trans_info", "cmt_show_config", "need_ad_req_nextpage", "is_e_da_xia", "show_satisfy_vote"}, new Object[]{null, null, 0, 0, "", byteStringMicro, "", "", null, "", "", 0, null, byteStringMicro, null, bool, bool, bool}, FeedCloudRead$StGetCommentListRsp.class);
    }

    public FeedCloudRead$StGetCommentListRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiRspData = PBField.initBytes(byteStringMicro);
        this.tailText = PBField.initString("");
        this.fastCommentText = PBField.initString("");
        this.guildDisplayInfo = new FeedCloudRead$GuildDisplayInfo();
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.textAfterLikeComment = PBField.initRepeat(pBStringField);
        this.emojiAfterLikeComment = PBField.initRepeat(pBStringField);
        this.show_qq_lianxiang_emoji = PBField.initUInt32(0);
        this.epxs = new FeedCloudRead$CmtExps();
        this.ai_cmt_trans_info = PBField.initBytes(byteStringMicro);
        this.cmt_show_config = new FeedCloudRead$CmtShowConfig();
        this.need_ad_req_nextpage = PBField.initBool(false);
        this.is_e_da_xia = PBField.initBool(false);
        this.show_satisfy_vote = PBField.initBool(false);
    }
}
