package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BottomCell extends JceStruct {
    static ArrayList<String> cache_userAvatar;
    public String content;
    public String jumpUrl;
    public int total;
    public ArrayList<String> userAvatar;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_userAvatar = arrayList;
        arrayList.add("");
    }

    public BottomCell() {
        this.total = 0;
        this.userAvatar = null;
        this.content = "";
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.total = jceInputStream.read(this.total, 0, false);
        this.userAvatar = (ArrayList) jceInputStream.read((JceInputStream) cache_userAvatar, 1, false);
        this.content = jceInputStream.readString(2, false);
        this.jumpUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.total, 0);
        ArrayList<String> arrayList = this.userAvatar;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.jumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public BottomCell(int i3, ArrayList<String> arrayList, String str, String str2) {
        this.total = i3;
        this.userAvatar = arrayList;
        this.content = str;
        this.jumpUrl = str2;
    }
}
