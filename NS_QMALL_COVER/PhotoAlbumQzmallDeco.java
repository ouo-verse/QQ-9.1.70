package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PhotoAlbumQzmallDeco extends JceStruct {
    static AlbumThemeSkin cache_stAlbumSkin = new AlbumThemeSkin();
    public AlbumThemeSkin stAlbumSkin;

    public PhotoAlbumQzmallDeco() {
        this.stAlbumSkin = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stAlbumSkin = (AlbumThemeSkin) jceInputStream.read((JceStruct) cache_stAlbumSkin, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AlbumThemeSkin albumThemeSkin = this.stAlbumSkin;
        if (albumThemeSkin != null) {
            jceOutputStream.write((JceStruct) albumThemeSkin, 0);
        }
    }

    public PhotoAlbumQzmallDeco(AlbumThemeSkin albumThemeSkin) {
        this.stAlbumSkin = albumThemeSkin;
    }
}
