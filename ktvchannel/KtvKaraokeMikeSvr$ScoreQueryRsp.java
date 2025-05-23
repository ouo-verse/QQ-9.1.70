package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ScoreQueryRsp extends MessageMicro<KtvKaraokeMikeSvr$ScoreQueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"err_info", "mike_id", "info"}, new Object[]{null, "", null}, KtvKaraokeMikeSvr$ScoreQueryRsp.class);
    public KtvCommon$ErrMsg err_info = new KtvCommon$ErrMsg();
    public final PBStringField mike_id = PBField.initString("");
    public Mem$MemMikeScoreInfo info = new MessageMicro<Mem$MemMikeScoreInfo>() { // from class: ktvchannel.Mem$MemMikeScoreInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64}, new String[]{"lc_score_result", "lc_score_detail", "hc_score_result", "hc_score_detail", "score_record", "total_score", "sentence_count", "sing_type"}, new Object[]{0, null, 0, null, 0, 0, 0, 0}, Mem$MemMikeScoreInfo.class);
        public final PBInt32Field lc_score_result = PBField.initInt32(0);
        public Mem$ScoreDetail lc_score_detail = new Mem$ScoreDetail();
        public final PBInt32Field hc_score_result = PBField.initInt32(0);
        public Mem$ScoreDetail hc_score_detail = new Mem$ScoreDetail();
        public final PBInt32Field score_record = PBField.initInt32(0);
        public final PBInt32Field total_score = PBField.initInt32(0);
        public final PBUInt32Field sentence_count = PBField.initUInt32(0);
        public final PBInt32Field sing_type = PBField.initInt32(0);
    };
}
