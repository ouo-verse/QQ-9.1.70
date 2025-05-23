package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RecordPlayInfo extends JceStruct {
    static ArrayList<OneVideoVidInfo> cache_video_info_vec = new ArrayList<>();
    public String fileName;
    public int status;
    public int totalCount;
    public ArrayList<OneVideoVidInfo> video_info_vec;

    static {
        cache_video_info_vec.add(new OneVideoVidInfo());
    }

    public RecordPlayInfo() {
        this.fileName = "";
        this.totalCount = 0;
        this.status = 0;
        this.video_info_vec = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fileName = jceInputStream.readString(0, false);
        this.totalCount = jceInputStream.read(this.totalCount, 1, false);
        this.status = jceInputStream.read(this.status, 2, false);
        this.video_info_vec = (ArrayList) jceInputStream.read((JceInputStream) cache_video_info_vec, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.fileName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.totalCount, 1);
        jceOutputStream.write(this.status, 2);
        ArrayList<OneVideoVidInfo> arrayList = this.video_info_vec;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public RecordPlayInfo(String str, int i3, int i16, ArrayList<OneVideoVidInfo> arrayList) {
        this.fileName = str;
        this.totalCount = i3;
        this.status = i16;
        this.video_info_vec = arrayList;
    }
}
