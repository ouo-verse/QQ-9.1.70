package msf.msgsvc;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetRoamMsgReq extends MessageMicro<msg_svc$PbGetRoamMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field begin_msgtime;
    public final PBBytesField pwd;
    public final PBUInt32Field req_type;
    public final PBBytesField sig;
    public final PBUInt32Field subcmd;
    public final PBUInt64Field peer_uin = PBField.initUInt64(0);
    public final PBUInt64Field last_msgtime = PBField.initUInt64(0);
    public final PBUInt64Field random = PBField.initUInt64(0);
    public final PBUInt32Field read_cnt = PBField.initUInt32(0);
    public final PBUInt32Field check_pwd = PBField.initUInt32(0);

    static {
        String[] strArr = {ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "last_msgtime", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "read_cnt", "check_pwd", PreloadTRTCPlayerParams.KEY_SIG, "pwd", "subcmd", "begin_msgtime", AppConstants.Key.SHARE_REQ_TYPE};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72, 80}, strArr, new Object[]{0L, 0L, 0L, 0, 0, byteStringMicro, byteStringMicro, 0, 0L, 0}, msg_svc$PbGetRoamMsgReq.class);
    }

    public msg_svc$PbGetRoamMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sig = PBField.initBytes(byteStringMicro);
        this.pwd = PBField.initBytes(byteStringMicro);
        this.subcmd = PBField.initUInt32(0);
        this.begin_msgtime = PBField.initUInt64(0L);
        this.req_type = PBField.initUInt32(0);
    }
}
