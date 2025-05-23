package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_detail_content extends JceStruct {
    static ArrayList<byte[]> cache_detail_content;
    public ArrayList<byte[]> detail_content;

    static {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_detail_content = arrayList;
        arrayList.add(new byte[]{0});
    }

    public cell_detail_content() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.detail_content = (ArrayList) jceInputStream.read((JceInputStream) cache_detail_content, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<byte[]> arrayList = this.detail_content;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public cell_detail_content(ArrayList<byte[]> arrayList) {
        this.detail_content = arrayList;
    }
}
