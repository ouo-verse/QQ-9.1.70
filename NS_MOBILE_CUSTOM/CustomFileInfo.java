package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomFileInfo extends JceStruct {
    static int cache_iFileType;
    public int iFileSize;
    public int iFileType;
    public int iImageHeight;
    public int iImageWidth;
    public String strFileMd5;
    public String strFileUrl;

    public CustomFileInfo() {
        this.strFileUrl = "";
        this.strFileMd5 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iFileType = jceInputStream.read(this.iFileType, 0, false);
        this.strFileUrl = jceInputStream.readString(1, false);
        this.strFileMd5 = jceInputStream.readString(2, false);
        this.iFileSize = jceInputStream.read(this.iFileSize, 3, false);
        this.iImageWidth = jceInputStream.read(this.iImageWidth, 4, false);
        this.iImageHeight = jceInputStream.read(this.iImageHeight, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iFileType, 0);
        String str = this.strFileUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strFileMd5;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.iFileSize, 3);
        jceOutputStream.write(this.iImageWidth, 4);
        jceOutputStream.write(this.iImageHeight, 5);
    }

    public CustomFileInfo(int i3, String str, String str2, int i16, int i17, int i18) {
        this.iFileType = i3;
        this.strFileUrl = str;
        this.strFileMd5 = str2;
        this.iFileSize = i16;
        this.iImageWidth = i17;
        this.iImageHeight = i18;
    }
}
