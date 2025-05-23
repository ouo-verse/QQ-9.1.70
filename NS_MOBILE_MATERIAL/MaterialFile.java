package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MaterialFile extends JceStruct {
    public int iFileId;
    public int iFileType;
    public int iHeight;
    public int iSize;
    public int iWidth;
    public String strMd5;
    public String strName;
    public String strUrl;

    public MaterialFile() {
        this.iFileId = 0;
        this.strName = "";
        this.strUrl = "";
        this.strMd5 = "";
        this.iSize = 0;
        this.iFileType = 0;
        this.iWidth = 0;
        this.iHeight = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iFileId = jceInputStream.read(this.iFileId, 0, true);
        this.strName = jceInputStream.readString(1, false);
        this.strUrl = jceInputStream.readString(2, false);
        this.strMd5 = jceInputStream.readString(3, false);
        this.iSize = jceInputStream.read(this.iSize, 4, false);
        this.iFileType = jceInputStream.read(this.iFileType, 5, false);
        this.iWidth = jceInputStream.read(this.iWidth, 6, false);
        this.iHeight = jceInputStream.read(this.iHeight, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iFileId, 0);
        String str = this.strName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strMd5;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.iSize, 4);
        jceOutputStream.write(this.iFileType, 5);
        jceOutputStream.write(this.iWidth, 6);
        jceOutputStream.write(this.iHeight, 7);
    }

    public MaterialFile(int i3, String str, String str2, String str3, int i16, int i17, int i18, int i19) {
        this.iFileId = i3;
        this.strName = str;
        this.strUrl = str2;
        this.strMd5 = str3;
        this.iSize = i16;
        this.iFileType = i17;
        this.iWidth = i18;
        this.iHeight = i19;
    }
}
