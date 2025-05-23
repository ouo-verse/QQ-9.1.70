package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PhotoSearchBoxItemElem extends JceStruct {
    static face_show_info cache_face_show = new face_show_info();
    static int cache_type;
    public String categoryid;
    public String desc;
    public face_show_info face_show;
    public int type;
    public String url;

    public PhotoSearchBoxItemElem() {
        this.type = 0;
        this.categoryid = "";
        this.desc = "";
        this.face_show = null;
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.categoryid = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.face_show = (face_show_info) jceInputStream.read((JceStruct) cache_face_show, 3, false);
        this.url = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        face_show_info face_show_infoVar = this.face_show;
        if (face_show_infoVar != null) {
            jceOutputStream.write((JceStruct) face_show_infoVar, 3);
        }
        String str3 = this.url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public PhotoSearchBoxItemElem(int i3, String str, String str2, face_show_info face_show_infoVar, String str3) {
        this.type = i3;
        this.categoryid = str;
        this.desc = str2;
        this.face_show = face_show_infoVar;
        this.url = str3;
    }
}
