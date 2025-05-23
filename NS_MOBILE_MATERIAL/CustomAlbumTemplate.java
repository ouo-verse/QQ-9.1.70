package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomAlbumTemplate extends JceStruct {
    static MaterialFile cache_stTmpBgImageLarge = new MaterialFile();
    static MaterialFile cache_stTmpBgImageMiddle = new MaterialFile();
    static MaterialFile cache_stTmpBgImageSmall = new MaterialFile();
    static ArrayList<CustomAlbumItem> cache_vecItems = new ArrayList<>();
    static ArrayList<PhotoFrameView> cache_vecPhotoFrameView;
    public MaterialFile stTmpBgImageLarge;
    public MaterialFile stTmpBgImageMiddle;
    public MaterialFile stTmpBgImageSmall;
    public ArrayList<CustomAlbumItem> vecItems;
    public ArrayList<PhotoFrameView> vecPhotoFrameView;

    static {
        cache_vecItems.add(new CustomAlbumItem());
        cache_vecPhotoFrameView = new ArrayList<>();
        cache_vecPhotoFrameView.add(new PhotoFrameView());
    }

    public CustomAlbumTemplate() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stTmpBgImageLarge = (MaterialFile) jceInputStream.read((JceStruct) cache_stTmpBgImageLarge, 0, false);
        this.stTmpBgImageMiddle = (MaterialFile) jceInputStream.read((JceStruct) cache_stTmpBgImageMiddle, 1, false);
        this.stTmpBgImageSmall = (MaterialFile) jceInputStream.read((JceStruct) cache_stTmpBgImageSmall, 2, false);
        this.vecItems = (ArrayList) jceInputStream.read((JceInputStream) cache_vecItems, 3, false);
        this.vecPhotoFrameView = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPhotoFrameView, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        MaterialFile materialFile = this.stTmpBgImageLarge;
        if (materialFile != null) {
            jceOutputStream.write((JceStruct) materialFile, 0);
        }
        MaterialFile materialFile2 = this.stTmpBgImageMiddle;
        if (materialFile2 != null) {
            jceOutputStream.write((JceStruct) materialFile2, 1);
        }
        MaterialFile materialFile3 = this.stTmpBgImageSmall;
        if (materialFile3 != null) {
            jceOutputStream.write((JceStruct) materialFile3, 2);
        }
        ArrayList<CustomAlbumItem> arrayList = this.vecItems;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<PhotoFrameView> arrayList2 = this.vecPhotoFrameView;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public CustomAlbumTemplate(MaterialFile materialFile, MaterialFile materialFile2, MaterialFile materialFile3, ArrayList<CustomAlbumItem> arrayList, ArrayList<PhotoFrameView> arrayList2) {
        this.stTmpBgImageLarge = materialFile;
        this.stTmpBgImageMiddle = materialFile2;
        this.stTmpBgImageSmall = materialFile3;
        this.vecItems = arrayList;
        this.vecPhotoFrameView = arrayList2;
    }
}
