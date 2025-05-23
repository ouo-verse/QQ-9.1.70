package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRegionData extends JceStruct {
    static stPoints cache_leftTopP = new stPoints();
    static stPoints cache_rightBottomP = new stPoints();
    public int actionType;
    public String actionUrl;
    public String backgroundImg;
    public stPoints leftTopP;
    public stPoints rightBottomP;
    public int urlShowType;

    public stRegionData() {
        this.leftTopP = null;
        this.rightBottomP = null;
        this.actionType = 0;
        this.actionUrl = "";
        this.urlShowType = 0;
        this.backgroundImg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.leftTopP = (stPoints) jceInputStream.read((JceStruct) cache_leftTopP, 0, false);
        this.rightBottomP = (stPoints) jceInputStream.read((JceStruct) cache_rightBottomP, 1, false);
        this.actionType = jceInputStream.read(this.actionType, 2, false);
        this.actionUrl = jceInputStream.readString(4, false);
        this.urlShowType = jceInputStream.read(this.urlShowType, 5, false);
        this.backgroundImg = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stPoints stpoints = this.leftTopP;
        if (stpoints != null) {
            jceOutputStream.write((JceStruct) stpoints, 0);
        }
        stPoints stpoints2 = this.rightBottomP;
        if (stpoints2 != null) {
            jceOutputStream.write((JceStruct) stpoints2, 1);
        }
        jceOutputStream.write(this.actionType, 2);
        String str = this.actionUrl;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.urlShowType, 5);
        String str2 = this.backgroundImg;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
    }

    public stRegionData(stPoints stpoints, stPoints stpoints2, int i3, String str, int i16, String str2) {
        this.leftTopP = stpoints;
        this.rightBottomP = stpoints2;
        this.actionType = i3;
        this.actionUrl = str;
        this.urlShowType = i16;
        this.backgroundImg = str2;
    }
}
