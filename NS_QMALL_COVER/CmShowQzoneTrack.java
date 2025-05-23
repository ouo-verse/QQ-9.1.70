package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CmShowQzoneTrack extends JceStruct {
    public int iItemType;
    public String strItemId;
    public String strName;
    public String strThumb;

    public CmShowQzoneTrack() {
        this.strThumb = "";
        this.iItemType = 0;
        this.strItemId = "";
        this.strName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strThumb = jceInputStream.readString(0, false);
        this.iItemType = jceInputStream.read(this.iItemType, 1, false);
        this.strItemId = jceInputStream.readString(2, false);
        this.strName = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strThumb;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iItemType, 1);
        String str2 = this.strItemId;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strName;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public CmShowQzoneTrack(String str, int i3, String str2, String str3) {
        this.strThumb = str;
        this.iItemType = i3;
        this.strItemId = str2;
        this.strName = str3;
    }
}
