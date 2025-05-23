package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PushVoteIncreaseInfo extends JceStruct {
    static ArrayList<Visitor> cache_vVoterList;
    public int iIncrement;
    public int lTime;
    public ArrayList<Visitor> vVoterList;

    public PushVoteIncreaseInfo() {
        this.iIncrement = 0;
        this.lTime = 0;
        this.vVoterList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iIncrement = jceInputStream.read(this.iIncrement, 0, true);
        this.lTime = jceInputStream.read(this.lTime, 1, true);
        if (cache_vVoterList == null) {
            cache_vVoterList = new ArrayList<>();
            cache_vVoterList.add(new Visitor());
        }
        this.vVoterList = (ArrayList) jceInputStream.read((JceInputStream) cache_vVoterList, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iIncrement, 0);
        jceOutputStream.write(this.lTime, 1);
        ArrayList<Visitor> arrayList = this.vVoterList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public PushVoteIncreaseInfo(int i3, int i16, ArrayList<Visitor> arrayList) {
        this.iIncrement = i3;
        this.lTime = i16;
        this.vVoterList = arrayList;
    }
}
