package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPoi extends JceStruct {
    public String poi_address;
    public String poi_id;
    public String poi_name;
    public int poi_type;
    public String poi_x;
    public String poi_y;

    public stPoi() {
        this.poi_id = "";
        this.poi_x = "";
        this.poi_y = "";
        this.poi_name = "";
        this.poi_address = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.poi_id = jceInputStream.readString(0, true);
        this.poi_x = jceInputStream.readString(1, true);
        this.poi_y = jceInputStream.readString(2, true);
        this.poi_name = jceInputStream.readString(3, true);
        this.poi_address = jceInputStream.readString(4, true);
        this.poi_type = jceInputStream.read(this.poi_type, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.poi_id, 0);
        jceOutputStream.write(this.poi_x, 1);
        jceOutputStream.write(this.poi_y, 2);
        jceOutputStream.write(this.poi_name, 3);
        jceOutputStream.write(this.poi_address, 4);
        jceOutputStream.write(this.poi_type, 5);
    }

    public stPoi(String str, String str2, String str3, String str4, String str5, int i3) {
        this.poi_id = str;
        this.poi_x = str2;
        this.poi_y = str3;
        this.poi_name = str4;
        this.poi_address = str5;
        this.poi_type = i3;
    }
}
