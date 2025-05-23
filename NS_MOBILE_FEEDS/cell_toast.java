package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_toast extends JceStruct {
    static ArrayList<Integer> cache_channels = new ArrayList<>();
    public ArrayList<Integer> channels;
    public String content;
    public String cover;
    public String scenes;
    public String title;

    static {
        cache_channels.add(0);
    }

    public cell_toast() {
        this.cover = "";
        this.title = "";
        this.content = "";
        this.channels = null;
        this.scenes = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cover = jceInputStream.readString(0, false);
        this.title = jceInputStream.readString(1, false);
        this.content = jceInputStream.readString(2, false);
        this.channels = (ArrayList) jceInputStream.read((JceInputStream) cache_channels, 3, false);
        this.scenes = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cover;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<Integer> arrayList = this.channels;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str4 = this.scenes;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public cell_toast(String str, String str2, String str3, ArrayList<Integer> arrayList, String str4) {
        this.cover = str;
        this.title = str2;
        this.content = str3;
        this.channels = arrayList;
        this.scenes = str4;
    }
}
