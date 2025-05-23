package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardSetReq extends JceStruct {
    static int cache_cmd;
    public long bgid;
    public long cardid;
    public int cmd;
    public long color;
    public String extInfo;
    public long platform;
    public cardDiyComplicatedInfo stDiyComplicated;
    public cardDiyTextInfo stDiyText;
    public long styleid;
    public long uin;
    public String url;
    public String version;
    static cardDiyTextInfo cache_stDiyText = new cardDiyTextInfo();
    static cardDiyComplicatedInfo cache_stDiyComplicated = new cardDiyComplicatedInfo();

    public SSummaryCardSetReq() {
        this.cmd = 2;
        this.uin = 0L;
        this.cardid = 0L;
        this.version = "4.7.0";
        this.platform = 0L;
        this.styleid = 0L;
        this.bgid = 0L;
        this.url = "";
        this.color = 0L;
        this.stDiyText = null;
        this.extInfo = "";
        this.stDiyComplicated = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.cardid = jceInputStream.read(this.cardid, 2, true);
        this.version = jceInputStream.readString(3, false);
        this.platform = jceInputStream.read(this.platform, 4, false);
        this.styleid = jceInputStream.read(this.styleid, 5, false);
        this.bgid = jceInputStream.read(this.bgid, 6, false);
        this.url = jceInputStream.readString(7, false);
        this.color = jceInputStream.read(this.color, 8, false);
        this.stDiyText = (cardDiyTextInfo) jceInputStream.read((JceStruct) cache_stDiyText, 9, false);
        this.extInfo = jceInputStream.readString(10, false);
        this.stDiyComplicated = (cardDiyComplicatedInfo) jceInputStream.read((JceStruct) cache_stDiyComplicated, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.cardid, 2);
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.platform, 4);
        jceOutputStream.write(this.styleid, 5);
        jceOutputStream.write(this.bgid, 6);
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        jceOutputStream.write(this.color, 8);
        cardDiyTextInfo carddiytextinfo = this.stDiyText;
        if (carddiytextinfo != null) {
            jceOutputStream.write((JceStruct) carddiytextinfo, 9);
        }
        String str3 = this.extInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        cardDiyComplicatedInfo carddiycomplicatedinfo = this.stDiyComplicated;
        if (carddiycomplicatedinfo != null) {
            jceOutputStream.write((JceStruct) carddiycomplicatedinfo, 11);
        }
    }

    public SSummaryCardSetReq(int i3, long j3, long j16, String str, long j17, long j18, long j19, String str2, long j26, cardDiyTextInfo carddiytextinfo, String str3, cardDiyComplicatedInfo carddiycomplicatedinfo) {
        this.cmd = i3;
        this.uin = j3;
        this.cardid = j16;
        this.version = str;
        this.platform = j17;
        this.styleid = j18;
        this.bgid = j19;
        this.url = str2;
        this.color = j26;
        this.stDiyText = carddiytextinfo;
        this.extInfo = str3;
        this.stDiyComplicated = carddiycomplicatedinfo;
    }
}
