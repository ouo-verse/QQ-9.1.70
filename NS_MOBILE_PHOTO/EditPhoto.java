package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class EditPhoto extends JceStruct {
    public String desc;
    public int modifytime;
    public String name;
    public int uploadtime;

    public EditPhoto() {
        this.name = "";
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        this.desc = jceInputStream.readString(1, false);
        this.uploadtime = jceInputStream.read(this.uploadtime, 2, false);
        this.modifytime = jceInputStream.read(this.modifytime, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.uploadtime, 2);
        jceOutputStream.write(this.modifytime, 3);
    }

    public EditPhoto(String str, String str2, int i3, int i16) {
        this.name = str;
        this.desc = str2;
        this.uploadtime = i3;
        this.modifytime = i16;
    }
}
