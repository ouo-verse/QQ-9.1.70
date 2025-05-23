package msf.msgsvc;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import msf.msgcomm.msg_comm$Msg;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetRoamMsgResp extends MessageMicro<msg_svc$PbGetRoamMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "last_msgtime", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "msg", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{0, "", 0L, 0L, 0L, null, ByteStringMicro.EMPTY}, msg_svc$PbGetRoamMsgResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0);
    public final PBUInt64Field random = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<msg_comm$Msg> f417536msg = PBField.initRepeatMessage(msg_comm$Msg.class);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
