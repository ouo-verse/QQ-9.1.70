package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OneVideoVidInfo extends JceStruct {
    static ArrayList<OneVideoPlayInfo> cache_play_info_vec = new ArrayList<>();
    public int duration;
    public String fileName;
    public String imageUrl;
    public ArrayList<OneVideoPlayInfo> play_info_vec;
    public int status;
    public String vid;

    static {
        cache_play_info_vec.add(new OneVideoPlayInfo());
    }

    public OneVideoVidInfo() {
        this.vid = "";
        this.fileName = "";
        this.duration = 0;
        this.imageUrl = "";
        this.play_info_vec = null;
        this.status = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vid = jceInputStream.readString(0, false);
        this.fileName = jceInputStream.readString(1, false);
        this.duration = jceInputStream.read(this.duration, 2, false);
        this.imageUrl = jceInputStream.readString(3, false);
        this.play_info_vec = (ArrayList) jceInputStream.read((JceInputStream) cache_play_info_vec, 4, false);
        this.status = jceInputStream.read(this.status, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.fileName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.duration, 2);
        String str3 = this.imageUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        ArrayList<OneVideoPlayInfo> arrayList = this.play_info_vec;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.status, 5);
    }

    public OneVideoVidInfo(String str, String str2, int i3, String str3, ArrayList<OneVideoPlayInfo> arrayList, int i16) {
        this.vid = str;
        this.fileName = str2;
        this.duration = i3;
        this.imageUrl = str3;
        this.play_info_vec = arrayList;
        this.status = i16;
    }
}
