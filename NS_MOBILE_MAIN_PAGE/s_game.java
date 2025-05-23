package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_game extends JceStruct {
    static ArrayList<s_one_game> cache_stVecGame;
    public ArrayList<s_one_game> stVecGame;
    public long uTotalCount;

    public s_game() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uTotalCount = jceInputStream.read(this.uTotalCount, 0, false);
        if (cache_stVecGame == null) {
            cache_stVecGame = new ArrayList<>();
            cache_stVecGame.add(new s_one_game());
        }
        this.stVecGame = (ArrayList) jceInputStream.read((JceInputStream) cache_stVecGame, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uTotalCount, 0);
        ArrayList<s_one_game> arrayList = this.stVecGame;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public s_game(long j3, ArrayList<s_one_game> arrayList) {
        this.uTotalCount = j3;
        this.stVecGame = arrayList;
    }
}
