package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stLinkConfig extends JceStruct {
    public int callCount;
    public int downloadCount;
    public boolean isOpenVideoPage;
    public boolean openCallWeishi;
    public boolean openDownloadWeishi;

    public stLinkConfig() {
        this.openCallWeishi = false;
        this.openDownloadWeishi = false;
        this.callCount = 0;
        this.downloadCount = 0;
        this.isOpenVideoPage = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.openCallWeishi = jceInputStream.read(this.openCallWeishi, 0, false);
        this.openDownloadWeishi = jceInputStream.read(this.openDownloadWeishi, 1, false);
        this.callCount = jceInputStream.read(this.callCount, 2, false);
        this.downloadCount = jceInputStream.read(this.downloadCount, 3, false);
        this.isOpenVideoPage = jceInputStream.read(this.isOpenVideoPage, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stLinkConfig {openCallWeishi=" + this.openCallWeishi + ", openDownloadWeishi=" + this.openDownloadWeishi + ", callCount=" + this.callCount + ", downloadCount=" + this.downloadCount + ", isOpenVideoPage=" + this.isOpenVideoPage + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.openCallWeishi, 0);
        jceOutputStream.write(this.openDownloadWeishi, 1);
        jceOutputStream.write(this.callCount, 2);
        jceOutputStream.write(this.downloadCount, 3);
        jceOutputStream.write(this.isOpenVideoPage, 4);
    }

    public stLinkConfig(boolean z16, boolean z17, int i3, int i16, boolean z18) {
        this.openCallWeishi = z16;
        this.openDownloadWeishi = z17;
        this.callCount = i3;
        this.downloadCount = i16;
        this.isOpenVideoPage = z18;
    }
}
