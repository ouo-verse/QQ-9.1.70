package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_Games_OpData extends JceStruct {
    static ArrayList<Long> cache_vcDataSec = new ArrayList<>();
    public String uBattleNickName;
    public long uBattleuin;
    public long uOpuin;
    public ArrayList<Long> vcDataSec;

    static {
        cache_vcDataSec.add(0L);
    }

    public st_Games_OpData() {
        this.uOpuin = 0L;
        this.vcDataSec = null;
        this.uBattleuin = 0L;
        this.uBattleNickName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uOpuin = jceInputStream.read(this.uOpuin, 0, false);
        this.vcDataSec = (ArrayList) jceInputStream.read((JceInputStream) cache_vcDataSec, 1, false);
        this.uBattleuin = jceInputStream.read(this.uBattleuin, 2, false);
        this.uBattleNickName = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uOpuin, 0);
        ArrayList<Long> arrayList = this.vcDataSec;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.uBattleuin, 2);
        String str = this.uBattleNickName;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public st_Games_OpData(long j3, ArrayList<Long> arrayList, long j16, String str) {
        this.uOpuin = j3;
        this.vcDataSec = arrayList;
        this.uBattleuin = j16;
        this.uBattleNickName = str;
    }
}
