package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupLabel extends JceStruct {
    static Color cache_edging_color;
    static Color cache_text_color;
    public Color edging_color;
    public String strWording;
    public Color text_color;
    public long type;

    public GroupLabel() {
        this.strWording = "";
        this.text_color = null;
        this.type = 0L;
        this.edging_color = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strWording = jceInputStream.readString(0, false);
        if (cache_text_color == null) {
            cache_text_color = new Color();
        }
        this.text_color = (Color) jceInputStream.read((JceStruct) cache_text_color, 1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        if (cache_edging_color == null) {
            cache_edging_color = new Color();
        }
        this.edging_color = (Color) jceInputStream.read((JceStruct) cache_edging_color, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strWording;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Color color = this.text_color;
        if (color != null) {
            jceOutputStream.write((JceStruct) color, 1);
        }
        jceOutputStream.write(this.type, 2);
        Color color2 = this.edging_color;
        if (color2 != null) {
            jceOutputStream.write((JceStruct) color2, 3);
        }
    }

    public GroupLabel(String str, Color color, long j3, Color color2) {
        this.strWording = str;
        this.text_color = color;
        this.type = j3;
        this.edging_color = color2;
    }
}
