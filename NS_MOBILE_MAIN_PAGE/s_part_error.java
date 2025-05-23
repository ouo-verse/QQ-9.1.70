package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_part_error extends JceStruct {
    public int is_happen;
    public String part_error_msg;
    public int part_error_place;

    public s_part_error() {
        this.part_error_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_happen = jceInputStream.read(this.is_happen, 0, false);
        this.part_error_place = jceInputStream.read(this.part_error_place, 1, false);
        this.part_error_msg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_happen, 0);
        jceOutputStream.write(this.part_error_place, 1);
        String str = this.part_error_msg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public s_part_error(int i3, int i16, String str) {
        this.is_happen = i3;
        this.part_error_place = i16;
        this.part_error_msg = str;
    }
}
