package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWMDBCombinReq extends JceStruct {
    static stVersions cache_versions;
    public String flashId;
    public int richFlagMask;
    public stVersions versions;

    public stWMDBCombinReq() {
        this.versions = null;
        this.richFlagMask = 1;
        this.flashId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_versions == null) {
            cache_versions = new stVersions();
        }
        this.versions = (stVersions) jceInputStream.read((JceStruct) cache_versions, 0, true);
        this.richFlagMask = jceInputStream.read(this.richFlagMask, 1, true);
        this.flashId = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.versions, 0);
        jceOutputStream.write(this.richFlagMask, 1);
        jceOutputStream.write(this.flashId, 2);
    }

    public stWMDBCombinReq(stVersions stversions, int i3, String str) {
        this.versions = stversions;
        this.richFlagMask = i3;
        this.flashId = str;
    }
}
