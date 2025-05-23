package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Font extends JceStruct {
    public int forbidThemeFont;
    public int isBlackWhiteFont;
    public int isWithTheme;

    public Font() {
        this.isWithTheme = 0;
        this.isBlackWhiteFont = 0;
        this.forbidThemeFont = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isWithTheme = jceInputStream.read(this.isWithTheme, 0, false);
        this.isBlackWhiteFont = jceInputStream.read(this.isBlackWhiteFont, 1, false);
        this.forbidThemeFont = jceInputStream.read(this.forbidThemeFont, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isWithTheme, 0);
        jceOutputStream.write(this.isBlackWhiteFont, 1);
        jceOutputStream.write(this.forbidThemeFont, 2);
    }

    public Font(int i3, int i16, int i17) {
        this.isWithTheme = i3;
        this.isBlackWhiteFont = i16;
        this.forbidThemeFont = i17;
    }
}
