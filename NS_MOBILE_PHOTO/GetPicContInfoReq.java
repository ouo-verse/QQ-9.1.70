package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetPicContInfoReq extends JceStruct {
    static ArrayList<String> cache_pic_url;
    public ArrayList<String> pic_url;
    public long uin;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_pic_url = arrayList;
        arrayList.add("");
    }

    public GetPicContInfoReq() {
        this.pic_url = null;
        this.uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pic_url = (ArrayList) jceInputStream.read((JceInputStream) cache_pic_url, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.pic_url;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.uin, 1);
    }

    public GetPicContInfoReq(ArrayList<String> arrayList, long j3) {
        this.pic_url = arrayList;
        this.uin = j3;
    }
}
