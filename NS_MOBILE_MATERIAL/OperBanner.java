package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OperBanner extends JceStruct {
    static MaterialFile cache_stFile = new MaterialFile();
    public MaterialFile stFile;
    public String strH5JumpUrl;
    public String strSchema;

    public OperBanner() {
        this.stFile = null;
        this.strSchema = "";
        this.strH5JumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFile = (MaterialFile) jceInputStream.read((JceStruct) cache_stFile, 0, true);
        this.strSchema = jceInputStream.readString(1, false);
        this.strH5JumpUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stFile, 0);
        String str = this.strSchema;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strH5JumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public OperBanner(MaterialFile materialFile, String str, String str2) {
        this.stFile = materialFile;
        this.strSchema = str;
        this.strH5JumpUrl = str2;
    }
}
