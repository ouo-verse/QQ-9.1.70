package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_canvas extends JceStruct {
    public String canvas_data;
    public String guide_text;
    public int jump_type;
    public boolean show_breath_light;
    public boolean show_guide_bar;

    public cell_canvas() {
        this.guide_text = "";
        this.canvas_data = "";
        this.jump_type = 0;
        this.show_breath_light = true;
        this.show_guide_bar = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.guide_text = jceInputStream.readString(0, false);
        this.canvas_data = jceInputStream.readString(1, false);
        this.jump_type = jceInputStream.read(this.jump_type, 2, false);
        this.show_breath_light = jceInputStream.read(this.show_breath_light, 3, false);
        this.show_guide_bar = jceInputStream.read(this.show_guide_bar, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.guide_text;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.canvas_data;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.jump_type, 2);
        jceOutputStream.write(this.show_breath_light, 3);
        jceOutputStream.write(this.show_guide_bar, 4);
    }

    public cell_canvas(String str, String str2, int i3, boolean z16, boolean z17) {
        this.guide_text = str;
        this.canvas_data = str2;
        this.jump_type = i3;
        this.show_breath_light = z16;
        this.show_guide_bar = z17;
    }
}
