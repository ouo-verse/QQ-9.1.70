package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetWidgetReq extends JceStruct {
    public String attach_info;
    public int time;
    public int widgetid;
    public int zone;

    public GetWidgetReq() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.widgetid = jceInputStream.read(this.widgetid, 0, true);
        this.time = jceInputStream.read(this.time, 1, false);
        this.zone = jceInputStream.read(this.zone, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.widgetid, 0);
        jceOutputStream.write(this.time, 1);
        jceOutputStream.write(this.zone, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public GetWidgetReq(int i3, int i16, int i17, String str) {
        this.widgetid = i3;
        this.time = i16;
        this.zone = i17;
        this.attach_info = str;
    }
}
