package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$KTVMikeInfo extends MessageMicro<KtvKaraokeMikeSvr$KTVMikeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 32}, new String[]{"mike_detail", "song_info", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME}, new Object[]{null, null, 0}, KtvKaraokeMikeSvr$KTVMikeInfo.class);
    public KtvKaraokeMikeSvr$MikeDetail mike_detail = new MessageMicro<KtvKaraokeMikeSvr$MikeDetail>() { // from class: ktvchannel.KtvKaraokeMikeSvr$MikeDetail
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 210}, new String[]{AudienceReportConst.ROOM_ID, "mike_id", "mike_duration", "sing_type", "song_mid", "lc_user_info", "hc_user_info", "mike_start_time", "mike_end_time", "mike_status", "sequence_id", "lc_video_ts", "lc_accompany_ts", "hc_video_ts", "hc_accompany_ts", "lc_sing_part", "play_state", "lc_user_status", "hc_user_status", "notice_time", "song_duration", "lc_device_type", "hc_device_type", "wait_time", "mike_type", "ext_info"}, new Object[]{"", "", 0, 0, "", null, null, 0, 0, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null}, KtvKaraokeMikeSvr$MikeDetail.class);
        public final PBStringField room_id = PBField.initString("");
        public final PBStringField mike_id = PBField.initString("");
        public final PBInt32Field mike_duration = PBField.initInt32(0);
        public final PBInt32Field sing_type = PBField.initInt32(0);
        public final PBStringField song_mid = PBField.initString("");
        public Mem$UserInfo lc_user_info = new Mem$UserInfo();
        public Mem$UserInfo hc_user_info = new Mem$UserInfo();
        public final PBUInt32Field mike_start_time = PBField.initUInt32(0);
        public final PBUInt32Field mike_end_time = PBField.initUInt32(0);
        public final PBInt32Field mike_status = PBField.initInt32(0);
        public final PBUInt64Field sequence_id = PBField.initUInt64(0);
        public final PBUInt32Field lc_video_ts = PBField.initUInt32(0);
        public final PBUInt32Field lc_accompany_ts = PBField.initUInt32(0);
        public final PBUInt32Field hc_video_ts = PBField.initUInt32(0);
        public final PBUInt32Field hc_accompany_ts = PBField.initUInt32(0);
        public final PBInt32Field lc_sing_part = PBField.initInt32(0);
        public final PBInt32Field play_state = PBField.initInt32(0);
        public final PBInt32Field lc_user_status = PBField.initInt32(0);
        public final PBInt32Field hc_user_status = PBField.initInt32(0);
        public final PBUInt32Field notice_time = PBField.initUInt32(0);
        public final PBUInt32Field song_duration = PBField.initUInt32(0);
        public final PBInt32Field lc_device_type = PBField.initInt32(0);
        public final PBInt32Field hc_device_type = PBField.initInt32(0);
        public final PBUInt32Field wait_time = PBField.initUInt32(0);
        public final PBInt32Field mike_type = PBField.initInt32(0);
        public final PBRepeatMessageField<KtvCommon$KVItem> ext_info = PBField.initRepeatMessage(KtvCommon$KVItem.class);
    };
    public KtvKaraokeMikeSvr$SongInfo song_info = new MessageMicro<KtvKaraokeMikeSvr$SongInfo>() { // from class: ktvchannel.KtvKaraokeMikeSvr$SongInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"song_name", "song_mid", "singer_name", "song_duration", "song_cover_url"}, new Object[]{"", "", "", 0, ""}, KtvKaraokeMikeSvr$SongInfo.class);
        public final PBStringField song_name = PBField.initString("");
        public final PBStringField song_mid = PBField.initString("");
        public final PBStringField singer_name = PBField.initString("");
        public final PBInt32Field song_duration = PBField.initInt32(0);
        public final PBStringField song_cover_url = PBField.initString("");
    };
    public final PBInt32Field play_time = PBField.initInt32(0);
}
