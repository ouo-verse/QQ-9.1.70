package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestHeader extends JceStruct {
    static int cache_assistImport;
    public String account;
    public int appid;
    public int assistImport;
    public String channel_id;
    public int cmd;
    public String ksid;
    public int requestID;
    public String sbid;
    public int svrSeqNo;
    public long uin;
    public int ver;

    public RequestHeader() {
        this.ver = 0;
        this.cmd = 0;
        this.requestID = 0;
        this.svrSeqNo = 0;
        this.account = "";
        this.appid = 0;
        this.sbid = "";
        this.channel_id = "";
        this.ksid = "";
        this.uin = 0L;
        this.assistImport = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ver = jceInputStream.read(this.ver, 0, true);
        this.cmd = jceInputStream.read(this.cmd, 1, true);
        this.requestID = jceInputStream.read(this.requestID, 2, true);
        this.svrSeqNo = jceInputStream.read(this.svrSeqNo, 3, true);
        this.account = jceInputStream.readString(4, true);
        this.appid = jceInputStream.read(this.appid, 5, true);
        this.sbid = jceInputStream.readString(6, true);
        this.channel_id = jceInputStream.readString(7, true);
        this.ksid = jceInputStream.readString(8, true);
        this.uin = jceInputStream.read(this.uin, 9, false);
        this.assistImport = jceInputStream.read(this.assistImport, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.cmd, 1);
        jceOutputStream.write(this.requestID, 2);
        jceOutputStream.write(this.svrSeqNo, 3);
        jceOutputStream.write(this.account, 4);
        jceOutputStream.write(this.appid, 5);
        jceOutputStream.write(this.sbid, 6);
        jceOutputStream.write(this.channel_id, 7);
        jceOutputStream.write(this.ksid, 8);
        jceOutputStream.write(this.uin, 9);
        jceOutputStream.write(this.assistImport, 10);
    }

    public RequestHeader(int i3, int i16, int i17, int i18, String str, int i19, String str2, String str3, String str4, long j3, int i26) {
        this.ver = i3;
        this.cmd = i16;
        this.requestID = i17;
        this.svrSeqNo = i18;
        this.account = str;
        this.appid = i19;
        this.sbid = str2;
        this.channel_id = str3;
        this.ksid = str4;
        this.uin = j3;
        this.assistImport = i26;
    }
}
