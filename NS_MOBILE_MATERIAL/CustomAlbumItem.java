package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomAlbumItem extends JceStruct {
    public int iAlignment;
    public int iContentWidth;
    public int iDiameter;
    public int iItemType;
    public int iLargeFontSize;
    public int iMarginTop;
    public int iMiddleFontSize;
    public int iSmallFontSize;
    public long iTextColor;
    public long iTextColorClick;
    public MaterialFile stBgImage;
    public MaterialFile stBgImageClick;
    public MaterialFile stH5BgImage;
    public MaterialFile stLeftImage;
    public MaterialFile stRightImage;
    static MaterialFile cache_stBgImage = new MaterialFile();
    static MaterialFile cache_stBgImageClick = new MaterialFile();
    static MaterialFile cache_stLeftImage = new MaterialFile();
    static MaterialFile cache_stRightImage = new MaterialFile();
    static MaterialFile cache_stH5BgImage = new MaterialFile();

    public CustomAlbumItem() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemType = jceInputStream.read(this.iItemType, 0, true);
        this.iAlignment = jceInputStream.read(this.iAlignment, 1, false);
        this.iLargeFontSize = jceInputStream.read(this.iLargeFontSize, 2, false);
        this.iMiddleFontSize = jceInputStream.read(this.iMiddleFontSize, 3, false);
        this.iSmallFontSize = jceInputStream.read(this.iSmallFontSize, 4, false);
        this.iTextColor = jceInputStream.read(this.iTextColor, 5, false);
        this.iTextColorClick = jceInputStream.read(this.iTextColorClick, 6, false);
        this.stBgImage = (MaterialFile) jceInputStream.read((JceStruct) cache_stBgImage, 7, false);
        this.stBgImageClick = (MaterialFile) jceInputStream.read((JceStruct) cache_stBgImageClick, 8, false);
        this.iMarginTop = jceInputStream.read(this.iMarginTop, 9, false);
        this.stLeftImage = (MaterialFile) jceInputStream.read((JceStruct) cache_stLeftImage, 10, false);
        this.stRightImage = (MaterialFile) jceInputStream.read((JceStruct) cache_stRightImage, 11, false);
        this.iDiameter = jceInputStream.read(this.iDiameter, 12, false);
        this.iContentWidth = jceInputStream.read(this.iContentWidth, 13, false);
        this.stH5BgImage = (MaterialFile) jceInputStream.read((JceStruct) cache_stH5BgImage, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemType, 0);
        jceOutputStream.write(this.iAlignment, 1);
        jceOutputStream.write(this.iLargeFontSize, 2);
        jceOutputStream.write(this.iMiddleFontSize, 3);
        jceOutputStream.write(this.iSmallFontSize, 4);
        jceOutputStream.write(this.iTextColor, 5);
        jceOutputStream.write(this.iTextColorClick, 6);
        MaterialFile materialFile = this.stBgImage;
        if (materialFile != null) {
            jceOutputStream.write((JceStruct) materialFile, 7);
        }
        MaterialFile materialFile2 = this.stBgImageClick;
        if (materialFile2 != null) {
            jceOutputStream.write((JceStruct) materialFile2, 8);
        }
        jceOutputStream.write(this.iMarginTop, 9);
        MaterialFile materialFile3 = this.stLeftImage;
        if (materialFile3 != null) {
            jceOutputStream.write((JceStruct) materialFile3, 10);
        }
        MaterialFile materialFile4 = this.stRightImage;
        if (materialFile4 != null) {
            jceOutputStream.write((JceStruct) materialFile4, 11);
        }
        jceOutputStream.write(this.iDiameter, 12);
        jceOutputStream.write(this.iContentWidth, 13);
        MaterialFile materialFile5 = this.stH5BgImage;
        if (materialFile5 != null) {
            jceOutputStream.write((JceStruct) materialFile5, 14);
        }
    }

    public CustomAlbumItem(int i3, int i16, int i17, int i18, int i19, long j3, long j16, MaterialFile materialFile, MaterialFile materialFile2, int i26, MaterialFile materialFile3, MaterialFile materialFile4, int i27, int i28, MaterialFile materialFile5) {
        this.iItemType = i3;
        this.iAlignment = i16;
        this.iLargeFontSize = i17;
        this.iMiddleFontSize = i18;
        this.iSmallFontSize = i19;
        this.iTextColor = j3;
        this.iTextColorClick = j16;
        this.stBgImage = materialFile;
        this.stBgImageClick = materialFile2;
        this.iMarginTop = i26;
        this.stLeftImage = materialFile3;
        this.stRightImage = materialFile4;
        this.iDiameter = i27;
        this.iContentWidth = i28;
        this.stH5BgImage = materialFile5;
    }
}
