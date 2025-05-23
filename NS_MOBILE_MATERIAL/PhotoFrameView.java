package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PhotoFrameView extends JceStruct {
    public int iContentWidth;
    public long iTextColor;
    public MaterialFile stBgImagePhoto;
    public MaterialFile stBgImagePhotoOnly;
    public MaterialFile stBgImageText;
    public MaterialFile stH5BgImagePhoto;
    public MaterialFile stH5BgImagePhotoOnly;
    public MaterialFile stH5BgImageText;
    static MaterialFile cache_stBgImagePhotoOnly = new MaterialFile();
    static MaterialFile cache_stBgImageText = new MaterialFile();
    static MaterialFile cache_stBgImagePhoto = new MaterialFile();
    static MaterialFile cache_stH5BgImagePhotoOnly = new MaterialFile();
    static MaterialFile cache_stH5BgImageText = new MaterialFile();
    static MaterialFile cache_stH5BgImagePhoto = new MaterialFile();

    public PhotoFrameView() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iContentWidth = jceInputStream.read(this.iContentWidth, 0, false);
        this.stBgImagePhotoOnly = (MaterialFile) jceInputStream.read((JceStruct) cache_stBgImagePhotoOnly, 1, false);
        this.stBgImageText = (MaterialFile) jceInputStream.read((JceStruct) cache_stBgImageText, 2, false);
        this.stBgImagePhoto = (MaterialFile) jceInputStream.read((JceStruct) cache_stBgImagePhoto, 3, false);
        this.stH5BgImagePhotoOnly = (MaterialFile) jceInputStream.read((JceStruct) cache_stH5BgImagePhotoOnly, 4, false);
        this.stH5BgImageText = (MaterialFile) jceInputStream.read((JceStruct) cache_stH5BgImageText, 5, false);
        this.stH5BgImagePhoto = (MaterialFile) jceInputStream.read((JceStruct) cache_stH5BgImagePhoto, 6, false);
        this.iTextColor = jceInputStream.read(this.iTextColor, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iContentWidth, 0);
        MaterialFile materialFile = this.stBgImagePhotoOnly;
        if (materialFile != null) {
            jceOutputStream.write((JceStruct) materialFile, 1);
        }
        MaterialFile materialFile2 = this.stBgImageText;
        if (materialFile2 != null) {
            jceOutputStream.write((JceStruct) materialFile2, 2);
        }
        MaterialFile materialFile3 = this.stBgImagePhoto;
        if (materialFile3 != null) {
            jceOutputStream.write((JceStruct) materialFile3, 3);
        }
        MaterialFile materialFile4 = this.stH5BgImagePhotoOnly;
        if (materialFile4 != null) {
            jceOutputStream.write((JceStruct) materialFile4, 4);
        }
        MaterialFile materialFile5 = this.stH5BgImageText;
        if (materialFile5 != null) {
            jceOutputStream.write((JceStruct) materialFile5, 5);
        }
        MaterialFile materialFile6 = this.stH5BgImagePhoto;
        if (materialFile6 != null) {
            jceOutputStream.write((JceStruct) materialFile6, 6);
        }
        jceOutputStream.write(this.iTextColor, 7);
    }

    public PhotoFrameView(int i3, MaterialFile materialFile, MaterialFile materialFile2, MaterialFile materialFile3, MaterialFile materialFile4, MaterialFile materialFile5, MaterialFile materialFile6, long j3) {
        this.iContentWidth = i3;
        this.stBgImagePhotoOnly = materialFile;
        this.stBgImageText = materialFile2;
        this.stBgImagePhoto = materialFile3;
        this.stH5BgImagePhotoOnly = materialFile4;
        this.stH5BgImageText = materialFile5;
        this.stH5BgImagePhoto = materialFile6;
        this.iTextColor = j3;
    }
}
