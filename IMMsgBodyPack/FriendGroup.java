package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FriendGroup extends JceStruct {
    static ArrayList<Long> cache_vNewGroupID;
    static ArrayList<Long> cache_vOldGroupID;
    public long dwFuin;
    public ArrayList<Long> vNewGroupID;
    public ArrayList<Long> vOldGroupID;

    public FriendGroup() {
        this.dwFuin = 0L;
        this.vOldGroupID = null;
        this.vNewGroupID = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwFuin = jceInputStream.read(this.dwFuin, 0, false);
        if (cache_vOldGroupID == null) {
            cache_vOldGroupID = new ArrayList<>();
            cache_vOldGroupID.add(0L);
        }
        this.vOldGroupID = (ArrayList) jceInputStream.read((JceInputStream) cache_vOldGroupID, 1, false);
        if (cache_vNewGroupID == null) {
            cache_vNewGroupID = new ArrayList<>();
            cache_vNewGroupID.add(0L);
        }
        this.vNewGroupID = (ArrayList) jceInputStream.read((JceInputStream) cache_vNewGroupID, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwFuin, 0);
        ArrayList<Long> arrayList = this.vOldGroupID;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<Long> arrayList2 = this.vNewGroupID;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public FriendGroup(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.dwFuin = j3;
        this.vOldGroupID = arrayList;
        this.vNewGroupID = arrayList2;
    }
}
