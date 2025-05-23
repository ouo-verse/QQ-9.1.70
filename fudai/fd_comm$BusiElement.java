package fudai;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fd_comm$BusiElement extends MessageMicro<fd_comm$BusiElement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66}, new String[]{"busi_id", "biz_desc", "biz_logo", "ad_type", QCircleLpReportDc05507.KEY_PIC_INFO, "video_info", "audio_info", "official_account_info"}, new Object[]{0, "", "", 1, null, null, null, null}, fd_comm$BusiElement.class);
    public final PBUInt32Field busi_id = PBField.initUInt32(0);
    public final PBStringField biz_desc = PBField.initString("");
    public final PBStringField biz_logo = PBField.initString("");
    public final PBEnumField ad_type = PBField.initEnum(1);
    public fd_comm$PicInfo pic_info = new fd_comm$PicInfo();
    public fd_comm$VideoInfo video_info = new MessageMicro<fd_comm$VideoInfo>() { // from class: fudai.fd_comm$VideoInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cover_info", "video_url"}, new Object[]{null, ""}, fd_comm$VideoInfo.class);
        public fd_comm$PicInfo cover_info = new fd_comm$PicInfo();
        public final PBStringField video_url = PBField.initString("");
    };
    public fd_comm$AudioInfo audio_info = new MessageMicro<fd_comm$AudioInfo>() { // from class: fudai.fd_comm$AudioInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cover_info", AppConstants.Key.SHARE_REQ_AUDIO_URL}, new Object[]{null, ""}, fd_comm$AudioInfo.class);
        public fd_comm$PicInfo cover_info = new fd_comm$PicInfo();
        public final PBStringField audio_url = PBField.initString("");
    };
    public fd_comm$OfficialAccountInfo official_account_info = new MessageMicro<fd_comm$OfficialAccountInfo>() { // from class: fudai.fd_comm$OfficialAccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"official_uin", "official_nick"}, new Object[]{0L, ""}, fd_comm$OfficialAccountInfo.class);
        public final PBUInt64Field official_uin = PBField.initUInt64(0);
        public final PBStringField official_nick = PBField.initString("");
    };
}
