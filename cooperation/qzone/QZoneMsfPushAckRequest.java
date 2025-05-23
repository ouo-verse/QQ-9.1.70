package cooperation.qzone;

import PUSHAPI.PushRsp;
import com.qq.taf.jce.JceStruct;
import common.config.service.d;

/* loaded from: classes38.dex */
public class QZoneMsfPushAckRequest extends QzoneExternalRequest {
    public static final String CMD_STRING = "wns.pushrsp";
    private static final String CMD_STRING_BUFFER = "wns.pushrsp";
    public static final int ERR_MSF_RESP_IS_NULL = 1000000;
    public static final int ERR_NO_NET = 1000006;
    private static final String unikey = "wns.pushrsp";
    private long flag;
    private long lastTimeStamp;
    private String mask;

    public QZoneMsfPushAckRequest(long j3, long j16, String str, long j17, String str2) {
        this.flag = 0L;
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        super.setRefer(str);
        this.lastTimeStamp = j16;
        this.flag = j17;
        this.mask = str2;
        this.needCompress = false;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_STRING;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    protected byte[] getEncodedUniParameter() {
        PushRsp pushRsp = new PushRsp();
        pushRsp.ptime = this.lastTimeStamp;
        pushRsp.is_bgd = (byte) 0;
        pushRsp.sUID = "<JIEHEBAN>";
        pushRsp.flag = this.flag;
        pushRsp.Mark = this.mask;
        return d.b(pushRsp);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return null;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
