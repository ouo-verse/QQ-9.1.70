package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class readItemInfoRsp extends JceStruct {
    static ArrayList<GroupNickEmoji> cache_emojilist = new ArrayList<>();
    static ArrayList<GroupNickItem> cache_itemlist;
    public ArrayList<GroupNickEmoji> emojilist;
    public int index;
    public ArrayList<GroupNickItem> itemlist;
    public int left;
    public String urlprefix;

    static {
        cache_emojilist.add(new GroupNickEmoji());
        cache_itemlist = new ArrayList<>();
        cache_itemlist.add(new GroupNickItem());
    }

    public readItemInfoRsp() {
        this.emojilist = null;
        this.itemlist = null;
        this.index = 0;
        this.left = 0;
        this.urlprefix = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.emojilist = (ArrayList) jceInputStream.read((JceInputStream) cache_emojilist, 0, false);
        this.itemlist = (ArrayList) jceInputStream.read((JceInputStream) cache_itemlist, 1, false);
        this.index = jceInputStream.read(this.index, 2, false);
        this.left = jceInputStream.read(this.left, 3, false);
        this.urlprefix = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<GroupNickEmoji> arrayList = this.emojilist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<GroupNickItem> arrayList2 = this.itemlist;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
        jceOutputStream.write(this.index, 2);
        jceOutputStream.write(this.left, 3);
        String str = this.urlprefix;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public readItemInfoRsp(ArrayList<GroupNickEmoji> arrayList, ArrayList<GroupNickItem> arrayList2, int i3, int i16, String str) {
        this.emojilist = arrayList;
        this.itemlist = arrayList2;
        this.index = i3;
        this.left = i16;
        this.urlprefix = str;
    }
}
