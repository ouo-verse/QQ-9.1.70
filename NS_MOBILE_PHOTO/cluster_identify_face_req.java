package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cluster_identify_face_req extends JceStruct {
    static ArrayList<Float> cache_feature = new ArrayList<>();
    static int cache_mode;
    public ArrayList<Float> feature;
    public String img;
    public boolean is_demo;
    public int mode;
    public long op_uin;

    static {
        cache_feature.add(Float.valueOf(0.0f));
        cache_mode = 0;
    }

    public cluster_identify_face_req() {
        this.op_uin = 0L;
        this.feature = null;
        this.mode = 0;
        this.img = "";
        this.is_demo = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_uin = jceInputStream.read(this.op_uin, 0, false);
        this.feature = (ArrayList) jceInputStream.read((JceInputStream) cache_feature, 1, false);
        this.mode = jceInputStream.read(this.mode, 2, false);
        this.img = jceInputStream.readString(3, false);
        this.is_demo = jceInputStream.read(this.is_demo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.op_uin, 0);
        ArrayList<Float> arrayList = this.feature;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.mode, 2);
        String str = this.img;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.is_demo, 4);
    }

    public cluster_identify_face_req(long j3, ArrayList<Float> arrayList, int i3, String str, boolean z16) {
        this.op_uin = j3;
        this.feature = arrayList;
        this.mode = i3;
        this.img = str;
        this.is_demo = z16;
    }
}
