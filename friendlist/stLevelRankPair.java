package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes28.dex */
public final class stLevelRankPair extends JceStruct {
    public long dwLevel;
    public String strRank;

    public stLevelRankPair() {
        this.dwLevel = 0L;
        this.strRank = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwLevel = jceInputStream.read(this.dwLevel, 0, false);
        this.strRank = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwLevel, 0);
        String str = this.strRank;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stLevelRankPair(long j3, String str) {
        this.dwLevel = j3;
        this.strRank = str;
    }
}
