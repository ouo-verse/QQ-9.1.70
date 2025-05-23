package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FacadeEditData extends JceStruct {
    public int iIndexId;
    public String strImageUrl;
    public String strText;

    public FacadeEditData() {
        this.strText = "";
        this.strImageUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iIndexId = jceInputStream.read(this.iIndexId, 0, false);
        this.strText = jceInputStream.readString(1, false);
        this.strImageUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iIndexId, 0);
        String str = this.strText;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strImageUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public FacadeEditData(int i3, String str, String str2) {
        this.iIndexId = i3;
        this.strText = str;
        this.strImageUrl = str2;
    }
}
