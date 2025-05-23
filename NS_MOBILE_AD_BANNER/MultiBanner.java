package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MultiBanner extends JceStruct {
    static ArrayList<Long> cache_recomUinList = new ArrayList<>();
    public boolean bNeedPiecewise;
    public boolean bNeedSpread;
    public String coverurl;
    public long createtime;
    public boolean from_now;
    public String jmpUrl;
    public int livetype;
    public int num;
    public ArrayList<Long> recomUinList;
    public String roomid;
    public String schemaurl;
    public String strNicks;
    public int styleType;
    public String summary;
    public long uUin;
    public String videoUrl;

    static {
        cache_recomUinList.add(0L);
    }

    public MultiBanner() {
        this.strNicks = "";
        this.uUin = 0L;
        this.roomid = "";
        this.createtime = 0L;
        this.coverurl = "";
        this.num = 0;
        this.summary = "";
        this.schemaurl = "";
        this.jmpUrl = "";
        this.from_now = false;
        this.videoUrl = "";
        this.recomUinList = null;
        this.styleType = 0;
        this.livetype = 0;
        this.bNeedPiecewise = true;
        this.bNeedSpread = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strNicks = jceInputStream.readString(0, false);
        this.uUin = jceInputStream.read(this.uUin, 1, false);
        this.roomid = jceInputStream.readString(2, false);
        this.createtime = jceInputStream.read(this.createtime, 3, false);
        this.coverurl = jceInputStream.readString(4, false);
        this.num = jceInputStream.read(this.num, 5, false);
        this.summary = jceInputStream.readString(6, false);
        this.schemaurl = jceInputStream.readString(7, false);
        this.jmpUrl = jceInputStream.readString(8, false);
        this.from_now = jceInputStream.read(this.from_now, 9, false);
        this.videoUrl = jceInputStream.readString(10, false);
        this.recomUinList = (ArrayList) jceInputStream.read((JceInputStream) cache_recomUinList, 11, false);
        this.styleType = jceInputStream.read(this.styleType, 12, false);
        this.livetype = jceInputStream.read(this.livetype, 13, false);
        this.bNeedPiecewise = jceInputStream.read(this.bNeedPiecewise, 14, false);
        this.bNeedSpread = jceInputStream.read(this.bNeedSpread, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strNicks;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.uUin, 1);
        String str2 = this.roomid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.createtime, 3);
        String str3 = this.coverurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.num, 5);
        String str4 = this.summary;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.schemaurl;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.jmpUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        jceOutputStream.write(this.from_now, 9);
        String str7 = this.videoUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
        ArrayList<Long> arrayList = this.recomUinList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 11);
        }
        jceOutputStream.write(this.styleType, 12);
        jceOutputStream.write(this.livetype, 13);
        jceOutputStream.write(this.bNeedPiecewise, 14);
        jceOutputStream.write(this.bNeedSpread, 15);
    }

    public MultiBanner(String str, long j3, String str2, long j16, String str3, int i3, String str4, String str5, String str6, boolean z16, String str7, ArrayList<Long> arrayList, int i16, int i17, boolean z17, boolean z18) {
        this.strNicks = str;
        this.uUin = j3;
        this.roomid = str2;
        this.createtime = j16;
        this.coverurl = str3;
        this.num = i3;
        this.summary = str4;
        this.schemaurl = str5;
        this.jmpUrl = str6;
        this.from_now = z16;
        this.videoUrl = str7;
        this.recomUinList = arrayList;
        this.styleType = i16;
        this.livetype = i17;
        this.bNeedPiecewise = z17;
        this.bNeedSpread = z18;
    }
}
