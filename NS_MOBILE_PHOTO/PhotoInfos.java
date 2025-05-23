package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PhotoInfos extends JceStruct {
    static ArrayList<Float> cache_feature = new ArrayList<>();
    static int cache_mode;
    public ArrayList<Float> feature;
    public String img;
    public int mode;

    static {
        cache_feature.add(Float.valueOf(0.0f));
    }

    public PhotoInfos() {
        this.mode = 0;
        this.feature = null;
        this.img = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mode = jceInputStream.read(this.mode, 0, false);
        this.feature = (ArrayList) jceInputStream.read((JceInputStream) cache_feature, 1, false);
        this.img = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mode, 0);
        ArrayList<Float> arrayList = this.feature;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.img;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public PhotoInfos(int i3, ArrayList<Float> arrayList, String str) {
        this.mode = i3;
        this.feature = arrayList;
        this.img = str;
    }
}
