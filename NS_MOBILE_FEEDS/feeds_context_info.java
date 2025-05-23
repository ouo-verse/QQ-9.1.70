package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feeds_context_info extends JceStruct {
    static ArrayList<String> cache_video_tag_list;
    public int index;
    public String summary;
    public String ugckey;
    public String vid;
    public ArrayList<String> video_tag_list;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_video_tag_list = arrayList;
        arrayList.add("");
    }

    public feeds_context_info() {
        this.index = 0;
        this.ugckey = "";
        this.summary = "";
        this.video_tag_list = null;
        this.vid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.index = jceInputStream.read(this.index, 0, false);
        this.ugckey = jceInputStream.readString(1, false);
        this.summary = jceInputStream.readString(2, false);
        this.video_tag_list = (ArrayList) jceInputStream.read((JceInputStream) cache_video_tag_list, 3, false);
        this.vid = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.index, 0);
        String str = this.ugckey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<String> arrayList = this.video_tag_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str3 = this.vid;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public feeds_context_info(int i3, String str, String str2, ArrayList<String> arrayList, String str3) {
        this.index = i3;
        this.ugckey = str;
        this.summary = str2;
        this.video_tag_list = arrayList;
        this.vid = str3;
    }
}
