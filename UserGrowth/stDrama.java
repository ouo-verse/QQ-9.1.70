package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDrama extends JceStruct {
    static stDramaInfo cache_dramaInfo = new stDramaInfo();
    public String barText;
    public stDramaInfo dramaInfo;
    public boolean showUpdate;
    public String tagIcon;

    public stDrama() {
        this.dramaInfo = null;
        this.tagIcon = "";
        this.showUpdate = true;
        this.barText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dramaInfo = (stDramaInfo) jceInputStream.read((JceStruct) cache_dramaInfo, 0, false);
        this.tagIcon = jceInputStream.readString(1, false);
        this.showUpdate = jceInputStream.read(this.showUpdate, 2, false);
        this.barText = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stDramaInfo stdramainfo = this.dramaInfo;
        if (stdramainfo != null) {
            jceOutputStream.write((JceStruct) stdramainfo, 0);
        }
        String str = this.tagIcon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.showUpdate, 2);
        String str2 = this.barText;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public stDrama(stDramaInfo stdramainfo, String str, boolean z16, String str2) {
        this.dramaInfo = stdramainfo;
        this.tagIcon = str;
        this.showUpdate = z16;
        this.barText = str2;
    }
}
