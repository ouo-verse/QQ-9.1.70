package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_video_action extends JceStruct {
    static s_button cache_rooftop_button = new s_button();
    public String relation_desc;
    public s_button rooftop_button;

    public cell_video_action() {
        this.relation_desc = "";
        this.rooftop_button = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.relation_desc = jceInputStream.readString(0, false);
        this.rooftop_button = (s_button) jceInputStream.read((JceStruct) cache_rooftop_button, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.relation_desc;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        s_button s_buttonVar = this.rooftop_button;
        if (s_buttonVar != null) {
            jceOutputStream.write((JceStruct) s_buttonVar, 1);
        }
    }

    public cell_video_action(String str, s_button s_buttonVar) {
        this.relation_desc = str;
        this.rooftop_button = s_buttonVar;
    }
}
