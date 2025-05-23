package msf.msgsvc;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetOneDayRoamMsgReq extends MessageMicro<msg_svc$PbGetOneDayRoamMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "last_msgtime", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "read_cnt"}, new Object[]{0L, 0L, 0L, 0}, msg_svc$PbGetOneDayRoamMsgReq.class);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0);
    public final PBUInt64Field random = PBField.initUInt64(0);
    public final PBUInt32Field read_cnt = PBField.initUInt32(0);
}
