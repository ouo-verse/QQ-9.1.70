package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import photo_share_struct.uin_nick_info;

/* compiled from: P */
/* loaded from: classes.dex */
public final class face_show_info extends JceStruct {
    static ArrayList<String> cache_groupids;
    static uin_nick_info cache_pic_host = new uin_nick_info();
    static int cache_status;
    public ArrayList<String> groupids;
    public uin_nick_info pic_host;
    public int status;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_groupids = arrayList;
        arrayList.add("");
    }

    public face_show_info() {
        this.status = 0;
        this.pic_host = null;
        this.groupids = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, false);
        this.pic_host = (uin_nick_info) jceInputStream.read((JceStruct) cache_pic_host, 1, false);
        this.groupids = (ArrayList) jceInputStream.read((JceInputStream) cache_groupids, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        uin_nick_info uin_nick_infoVar = this.pic_host;
        if (uin_nick_infoVar != null) {
            jceOutputStream.write((JceStruct) uin_nick_infoVar, 1);
        }
        ArrayList<String> arrayList = this.groupids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public face_show_info(int i3, uin_nick_info uin_nick_infoVar, ArrayList<String> arrayList) {
        this.status = i3;
        this.pic_host = uin_nick_infoVar;
        this.groupids = arrayList;
    }
}
