package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feed_host_info extends JceStruct {
    static yellow_info cache_OpuinYellowInfo;
    static ArrayList<feed_info> cache_vec_feedInfos = new ArrayList<>();
    public yellow_info OpuinYellowInfo;
    public String actiondesc;
    public String nickname;
    public String strWords;
    public long uUin;
    public ArrayList<feed_info> vec_feedInfos;

    static {
        cache_vec_feedInfos.add(new feed_info());
        cache_OpuinYellowInfo = new yellow_info();
    }

    public feed_host_info() {
        this.uUin = 0L;
        this.nickname = "";
        this.actiondesc = "";
        this.vec_feedInfos = null;
        this.OpuinYellowInfo = null;
        this.strWords = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uUin = jceInputStream.read(this.uUin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.actiondesc = jceInputStream.readString(2, false);
        this.vec_feedInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_feedInfos, 3, false);
        this.OpuinYellowInfo = (yellow_info) jceInputStream.read((JceStruct) cache_OpuinYellowInfo, 4, false);
        this.strWords = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uUin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.actiondesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<feed_info> arrayList = this.vec_feedInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        yellow_info yellow_infoVar = this.OpuinYellowInfo;
        if (yellow_infoVar != null) {
            jceOutputStream.write((JceStruct) yellow_infoVar, 4);
        }
        String str3 = this.strWords;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public feed_host_info(long j3, String str, String str2, ArrayList<feed_info> arrayList, yellow_info yellow_infoVar, String str3) {
        this.uUin = j3;
        this.nickname = str;
        this.actiondesc = str2;
        this.vec_feedInfos = arrayList;
        this.OpuinYellowInfo = yellow_infoVar;
        this.strWords = str3;
    }
}
