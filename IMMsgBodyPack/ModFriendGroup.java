package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ModFriendGroup extends JceStruct {
    static ArrayList<FriendGroup> cache_vMsgFrdGroup;
    public ArrayList<FriendGroup> vMsgFrdGroup;

    public ModFriendGroup() {
        this.vMsgFrdGroup = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vMsgFrdGroup == null) {
            cache_vMsgFrdGroup = new ArrayList<>();
            cache_vMsgFrdGroup.add(new FriendGroup());
        }
        this.vMsgFrdGroup = (ArrayList) jceInputStream.read((JceInputStream) cache_vMsgFrdGroup, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<FriendGroup> arrayList = this.vMsgFrdGroup;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public ModFriendGroup(ArrayList<FriendGroup> arrayList) {
        this.vMsgFrdGroup = arrayList;
    }
}
