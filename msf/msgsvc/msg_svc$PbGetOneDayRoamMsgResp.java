package msf.msgsvc;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetOneDayRoamMsgResp extends MessageMicro<msg_svc$PbGetOneDayRoamMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "last_msgtime", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "msg", "iscomplete"}, new Object[]{0, "", 0L, 0L, 0L, null, 0}, msg_svc$PbGetOneDayRoamMsgResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0);
    public final PBUInt64Field random = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417535msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBUInt32Field iscomplete = PBField.initUInt32(0);
}
