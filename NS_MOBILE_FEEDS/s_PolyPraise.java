package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class s_PolyPraise extends JceStruct {
    public int iItemId;
    public int itype;
    public int pokeLikeCombo;
    public int resourceId;
    public String strPicUrl;
    public String strText;

    public s_PolyPraise() {
        this.iItemId = 0;
        this.strPicUrl = "";
        this.strText = "";
        this.itype = 0;
        this.resourceId = 0;
        this.pokeLikeCombo = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strPicUrl = jceInputStream.readString(1, false);
        this.strText = jceInputStream.readString(2, false);
        this.itype = jceInputStream.read(this.itype, 3, false);
        this.resourceId = jceInputStream.read(this.resourceId, 4, false);
        this.pokeLikeCombo = jceInputStream.read(this.pokeLikeCombo, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strPicUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strText;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.itype, 3);
        jceOutputStream.write(this.resourceId, 4);
        jceOutputStream.write(this.pokeLikeCombo, 5);
    }

    public s_PolyPraise(int i3, String str, String str2, int i16, int i17, int i18) {
        this.iItemId = i3;
        this.strPicUrl = str;
        this.strText = str2;
        this.itype = i16;
        this.resourceId = i17;
        this.pokeLikeCombo = i18;
    }
}
