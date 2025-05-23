package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ThemeInfo extends JceStruct {
    static CoverItem cache_stCoverItem;
    static ThemeItem cache_stThemeItem;
    public CoverItem stCoverItem;
    public ThemeItem stThemeItem;
    public long uTotalSize;

    public ThemeInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stThemeItem == null) {
            cache_stThemeItem = new ThemeItem();
        }
        this.stThemeItem = (ThemeItem) jceInputStream.read((JceStruct) cache_stThemeItem, 0, false);
        if (cache_stCoverItem == null) {
            cache_stCoverItem = new CoverItem();
        }
        this.stCoverItem = (CoverItem) jceInputStream.read((JceStruct) cache_stCoverItem, 1, false);
        this.uTotalSize = jceInputStream.read(this.uTotalSize, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ThemeItem themeItem = this.stThemeItem;
        if (themeItem != null) {
            jceOutputStream.write((JceStruct) themeItem, 0);
        }
        CoverItem coverItem = this.stCoverItem;
        if (coverItem != null) {
            jceOutputStream.write((JceStruct) coverItem, 1);
        }
        jceOutputStream.write(this.uTotalSize, 2);
    }

    public ThemeInfo(ThemeItem themeItem, CoverItem coverItem, long j3) {
        this.stThemeItem = themeItem;
        this.stCoverItem = coverItem;
        this.uTotalSize = j3;
    }
}
