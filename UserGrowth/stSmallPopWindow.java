package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stSmallPopWindow extends JceStruct {
    public int direction;
    public String imgurl;
    public int time_to_open;
    public int y_percent;

    public stSmallPopWindow() {
        this.imgurl = "";
        this.direction = 0;
        this.y_percent = 0;
        this.time_to_open = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imgurl = jceInputStream.readString(1, false);
        this.direction = jceInputStream.read(this.direction, 2, false);
        this.y_percent = jceInputStream.read(this.y_percent, 3, false);
        this.time_to_open = jceInputStream.read(this.time_to_open, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imgurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.direction, 2);
        jceOutputStream.write(this.y_percent, 3);
        jceOutputStream.write(this.time_to_open, 4);
    }

    public stSmallPopWindow(String str, int i3, int i16, int i17) {
        this.imgurl = str;
        this.direction = i3;
        this.y_percent = i16;
        this.time_to_open = i17;
    }
}
