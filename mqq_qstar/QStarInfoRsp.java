package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class QStarInfoRsp extends JceStruct {
    static ArrayList<QStarInfoItem> cache_followlist;
    public int cmd;
    public int follow_xylm;
    public ArrayList<QStarInfoItem> followlist;
    public String jumpurl;
    public String logourl;
    public int ret;
    public int seq;
    public int ver;

    public QStarInfoRsp() {
        this.ver = 0;
        this.seq = 0;
        this.cmd = 0;
        this.ret = 0;
        this.follow_xylm = 0;
        this.jumpurl = "";
        this.logourl = "";
        this.followlist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ver = jceInputStream.read(this.ver, 0, false);
        this.seq = jceInputStream.read(this.seq, 1, false);
        this.cmd = jceInputStream.read(this.cmd, 2, false);
        this.ret = jceInputStream.read(this.ret, 3, false);
        this.follow_xylm = jceInputStream.read(this.follow_xylm, 4, false);
        this.jumpurl = jceInputStream.readString(5, false);
        this.logourl = jceInputStream.readString(6, false);
        if (cache_followlist == null) {
            cache_followlist = new ArrayList<>();
            cache_followlist.add(new QStarInfoItem());
        }
        this.followlist = (ArrayList) jceInputStream.read((JceInputStream) cache_followlist, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.seq, 1);
        jceOutputStream.write(this.cmd, 2);
        jceOutputStream.write(this.ret, 3);
        jceOutputStream.write(this.follow_xylm, 4);
        String str = this.jumpurl;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.logourl;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        ArrayList<QStarInfoItem> arrayList = this.followlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
    }

    public QStarInfoRsp(int i3, int i16, int i17, int i18, int i19, String str, String str2, ArrayList<QStarInfoItem> arrayList) {
        this.ver = i3;
        this.seq = i16;
        this.cmd = i17;
        this.ret = i18;
        this.follow_xylm = i19;
        this.jumpurl = str;
        this.logourl = str2;
        this.followlist = arrayList;
    }
}
