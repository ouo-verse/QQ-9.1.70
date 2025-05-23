package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AlbumThemeSkin extends JceStruct {
    public int iColor;
    public int iItemId;
    public long lTabBarSelectedFontColor;
    public long lTabBarUnselectedFontColor;
    public long lTabbarUnderLineColor;
    public long lVideoButonColor;
    public long lVideoButtonBgColor;
    public String strPicZipUrl;

    public AlbumThemeSkin() {
        this.iItemId = -1;
        this.iColor = 0;
        this.strPicZipUrl = "";
        this.lTabBarSelectedFontColor = 0L;
        this.lTabBarUnselectedFontColor = 0L;
        this.lVideoButtonBgColor = 0L;
        this.lVideoButonColor = 0L;
        this.lTabbarUnderLineColor = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.iColor = jceInputStream.read(this.iColor, 1, false);
        this.strPicZipUrl = jceInputStream.readString(2, false);
        this.lTabBarSelectedFontColor = jceInputStream.read(this.lTabBarSelectedFontColor, 3, false);
        this.lTabBarUnselectedFontColor = jceInputStream.read(this.lTabBarUnselectedFontColor, 4, false);
        this.lVideoButtonBgColor = jceInputStream.read(this.lVideoButtonBgColor, 5, false);
        this.lVideoButonColor = jceInputStream.read(this.lVideoButonColor, 6, false);
        this.lTabbarUnderLineColor = jceInputStream.read(this.lTabbarUnderLineColor, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        jceOutputStream.write(this.iColor, 1);
        String str = this.strPicZipUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.lTabBarSelectedFontColor, 3);
        jceOutputStream.write(this.lTabBarUnselectedFontColor, 4);
        jceOutputStream.write(this.lVideoButtonBgColor, 5);
        jceOutputStream.write(this.lVideoButonColor, 6);
        jceOutputStream.write(this.lTabbarUnderLineColor, 7);
    }

    public AlbumThemeSkin(int i3, int i16, String str, long j3, long j16, long j17, long j18, long j19) {
        this.iItemId = i3;
        this.iColor = i16;
        this.strPicZipUrl = str;
        this.lTabBarSelectedFontColor = j3;
        this.lTabBarUnselectedFontColor = j16;
        this.lVideoButtonBgColor = j17;
        this.lVideoButonColor = j18;
        this.lTabbarUnderLineColor = j19;
    }
}
