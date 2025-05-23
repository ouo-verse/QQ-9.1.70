package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class s_CustomPraise extends JceStruct {
    static stcustomPraise cache_customPraise = new stcustomPraise();
    public stcustomPraise customPraise;
    public int iItemId;
    public String strPraisePic;

    public s_CustomPraise() {
        this.iItemId = 0;
        this.strPraisePic = "";
        this.customPraise = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strPraisePic = jceInputStream.readString(1, false);
        this.customPraise = (stcustomPraise) jceInputStream.read((JceStruct) cache_customPraise, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strPraisePic;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        stcustomPraise stcustompraise = this.customPraise;
        if (stcustompraise != null) {
            jceOutputStream.write((JceStruct) stcustompraise, 2);
        }
    }

    public s_CustomPraise(int i3, String str, stcustomPraise stcustompraise) {
        this.iItemId = i3;
        this.strPraisePic = str;
        this.customPraise = stcustompraise;
    }
}
