package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFriendLikes extends JceStruct {
    static ArrayList<stFriendLike> cache_likeFriends = new ArrayList<>();
    public ArrayList<stFriendLike> likeFriends;
    public int total;

    static {
        cache_likeFriends.add(new stFriendLike());
    }

    public stFriendLikes() {
        this.likeFriends = null;
        this.total = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.likeFriends = (ArrayList) jceInputStream.read((JceInputStream) cache_likeFriends, 0, false);
        this.total = jceInputStream.read(this.total, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stFriendLike> arrayList = this.likeFriends;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.total, 1);
    }

    public stFriendLikes(ArrayList<stFriendLike> arrayList, int i3) {
        this.likeFriends = arrayList;
        this.total = i3;
    }
}
