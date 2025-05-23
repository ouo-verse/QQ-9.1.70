package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_coordinate extends JceStruct {
    public int x_axis;
    public int y_axis;

    public s_coordinate() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.x_axis = jceInputStream.read(this.x_axis, 0, false);
        this.y_axis = jceInputStream.read(this.y_axis, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.x_axis, 0);
        jceOutputStream.write(this.y_axis, 1);
    }

    public s_coordinate(int i3, int i16) {
        this.x_axis = i3;
        this.y_axis = i16;
    }
}
