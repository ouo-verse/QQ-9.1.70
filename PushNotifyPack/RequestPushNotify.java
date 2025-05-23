package PushNotifyPack;

import OnlinePushPack.MsgInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RequestPushNotify extends JceStruct {
    static byte[] cache_bytes_server_buf;
    static MsgInfo cache_stMsgInfo = new MsgInfo();
    static byte[] cache_vNotifyCookie;
    public byte[] bytes_server_buf;
    public byte cType;
    public long lBindedUin;
    public long lUin;
    public String msg_ctrl_buf;
    public long ping_flag;
    public MsgInfo stMsgInfo;
    public String strCmd;
    public String strService;
    public int svrip;
    public int usMsgType;
    public byte[] vNotifyCookie;
    public int wGeneralFlag;
    public int wUserActive;

    static {
        cache_vNotifyCookie = r1;
        byte[] bArr = {0};
        cache_bytes_server_buf = r0;
        byte[] bArr2 = {0};
    }

    public RequestPushNotify() {
        this.lUin = 0L;
        this.cType = (byte) 0;
        this.strService = "";
        this.strCmd = "";
        this.vNotifyCookie = null;
        this.usMsgType = 0;
        this.wUserActive = 0;
        this.wGeneralFlag = 0;
        this.lBindedUin = 0L;
        this.stMsgInfo = null;
        this.msg_ctrl_buf = "";
        this.bytes_server_buf = null;
        this.ping_flag = 0L;
        this.svrip = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cType = jceInputStream.read(this.cType, 1, true);
        this.strService = jceInputStream.readString(2, true);
        this.strCmd = jceInputStream.readString(3, true);
        this.vNotifyCookie = jceInputStream.read(cache_vNotifyCookie, 4, false);
        this.usMsgType = jceInputStream.read(this.usMsgType, 5, false);
        this.wUserActive = jceInputStream.read(this.wUserActive, 6, false);
        this.wGeneralFlag = jceInputStream.read(this.wGeneralFlag, 7, false);
        this.lBindedUin = jceInputStream.read(this.lBindedUin, 8, false);
        this.stMsgInfo = (MsgInfo) jceInputStream.read((JceStruct) cache_stMsgInfo, 9, false);
        this.msg_ctrl_buf = jceInputStream.readString(10, false);
        this.bytes_server_buf = jceInputStream.read(cache_bytes_server_buf, 11, false);
        this.ping_flag = jceInputStream.read(this.ping_flag, 12, false);
        this.svrip = jceInputStream.read(this.svrip, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cType, 1);
        jceOutputStream.write(this.strService, 2);
        jceOutputStream.write(this.strCmd, 3);
        byte[] bArr = this.vNotifyCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        jceOutputStream.write(this.usMsgType, 5);
        jceOutputStream.write(this.wUserActive, 6);
        jceOutputStream.write(this.wGeneralFlag, 7);
        jceOutputStream.write(this.lBindedUin, 8);
        MsgInfo msgInfo = this.stMsgInfo;
        if (msgInfo != null) {
            jceOutputStream.write((JceStruct) msgInfo, 9);
        }
        String str = this.msg_ctrl_buf;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        byte[] bArr2 = this.bytes_server_buf;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 11);
        }
        jceOutputStream.write(this.ping_flag, 12);
        jceOutputStream.write(this.svrip, 13);
    }

    public RequestPushNotify(long j3, byte b16, String str, String str2, byte[] bArr, int i3, int i16, int i17, long j16, MsgInfo msgInfo, String str3, byte[] bArr2, long j17, int i18) {
        this.lUin = j3;
        this.cType = b16;
        this.strService = str;
        this.strCmd = str2;
        this.vNotifyCookie = bArr;
        this.usMsgType = i3;
        this.wUserActive = i16;
        this.wGeneralFlag = i17;
        this.lBindedUin = j16;
        this.stMsgInfo = msgInfo;
        this.msg_ctrl_buf = str3;
        this.bytes_server_buf = bArr2;
        this.ping_flag = j17;
        this.svrip = i18;
    }
}
