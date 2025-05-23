package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_del_visit_req extends JceStruct {
    public boolean add_to_hidelist;
    public String contentid;
    public long hostUin;
    public byte mod;
    public byte source;
    public long uin;
    public long vtime;

    public mobile_sub_del_visit_req() {
        this.contentid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.source = jceInputStream.read(this.source, 1, false);
        this.vtime = jceInputStream.read(this.vtime, 2, false);
        this.hostUin = jceInputStream.read(this.hostUin, 3, false);
        this.mod = jceInputStream.read(this.mod, 4, false);
        this.contentid = jceInputStream.readString(5, false);
        this.add_to_hidelist = jceInputStream.read(this.add_to_hidelist, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.source, 1);
        jceOutputStream.write(this.vtime, 2);
        jceOutputStream.write(this.hostUin, 3);
        jceOutputStream.write(this.mod, 4);
        String str = this.contentid;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.add_to_hidelist, 6);
    }

    public mobile_sub_del_visit_req(long j3, byte b16, long j16, long j17, byte b17, String str, boolean z16) {
        this.uin = j3;
        this.source = b16;
        this.vtime = j16;
        this.hostUin = j17;
        this.mod = b17;
        this.contentid = str;
        this.add_to_hidelist = z16;
    }
}
