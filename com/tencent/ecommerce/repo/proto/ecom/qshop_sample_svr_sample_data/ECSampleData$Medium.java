package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$Medium extends MessageMicro<ECSampleData$Medium> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"medium_type", QQWinkConstants.ENTRY_QQ_VIDEO, "qq_live", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "total_amount"}, new Object[]{0, null, null, 0, 0}, ECSampleData$Medium.class);
    public final PBUInt32Field medium_type = PBField.initUInt32(0);
    public ECSampleData$QQVideo qq_video = new MessageMicro<ECSampleData$QQVideo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$QQVideo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 88, 96}, new String[]{"content_id", "video_id", "title", "sub_title", "desc", "cover", "start_time", VasQQSettingMeImpl.EXPIRE_TIME, "total_play_time", "ave_play_time", "video_viewers", "invalid_time"}, new Object[]{"", "", "", "", "", "", 0L, 0L, 0, 0, 0, 0L}, ECSampleData$QQVideo.class);
        public final PBStringField content_id = PBField.initString("");
        public final PBStringField video_id = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField sub_title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField cover = PBField.initString("");
        public final PBInt64Field start_time = PBField.initInt64(0);
        public final PBInt64Field expire_time = PBField.initInt64(0);
        public final PBUInt32Field total_play_time = PBField.initUInt32(0);
        public final PBUInt32Field ave_play_time = PBField.initUInt32(0);
        public final PBUInt32Field video_viewers = PBField.initUInt32(0);
        public final PBInt64Field invalid_time = PBField.initInt64(0);
    };
    public ECSampleData$QQLive qq_live = new MessageMicro<ECSampleData$QQLive>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$QQLive
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 64, 72, 80, 88, 96}, new String[]{"user_id", ServiceConst.PARA_SESSION_ID, AudienceReportConst.ROOM_ID, "title", "sub_title", "desc", "cover", "start_time", "end_time", "live_viewers", "explain_time", "cancel_explain_time"}, new Object[]{"", "", 0L, "", "", "", "", 0L, 0L, 0, 0L, 0L}, ECSampleData$QQLive.class);
        public final PBStringField user_id = PBField.initString("");
        public final PBStringField session_id = PBField.initString("");
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField title = PBField.initString("");
        public final PBStringField sub_title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField cover = PBField.initString("");
        public final PBInt64Field start_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
        public final PBUInt32Field live_viewers = PBField.initUInt32(0);
        public final PBInt64Field explain_time = PBField.initInt64(0);
        public final PBInt64Field cancel_explain_time = PBField.initInt64(0);
    };
    public final PBUInt32Field volume = PBField.initUInt32(0);
    public final PBUInt32Field total_amount = PBField.initUInt32(0);
}
