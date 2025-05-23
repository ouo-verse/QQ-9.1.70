package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFriendFeed extends JceStruct {
    static ArrayList<stSimpleMetaFeed> cache_friendFeeds = new ArrayList<>();
    public String attachInfo;
    public String dialogTips;
    public ArrayList<stSimpleMetaFeed> friendFeeds;

    static {
        cache_friendFeeds.add(new stSimpleMetaFeed());
    }

    public stFriendFeed() {
        this.friendFeeds = null;
        this.attachInfo = "";
        this.dialogTips = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.friendFeeds = (ArrayList) jceInputStream.read((JceInputStream) cache_friendFeeds, 0, false);
        this.attachInfo = jceInputStream.readString(1, false);
        this.dialogTips = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stSimpleMetaFeed> arrayList = this.friendFeeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.dialogTips;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public stFriendFeed(ArrayList<stSimpleMetaFeed> arrayList, String str, String str2) {
        this.friendFeeds = arrayList;
        this.attachInfo = str;
        this.dialogTips = str2;
    }
}
