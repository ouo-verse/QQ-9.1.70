package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WidgetMargin extends JceStruct {
    public int iToRightBorderMargin;
    public int iToTopBorderMargin;

    public WidgetMargin() {
        this.iToRightBorderMargin = 0;
        this.iToTopBorderMargin = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iToRightBorderMargin = jceInputStream.read(this.iToRightBorderMargin, 0, false);
        this.iToTopBorderMargin = jceInputStream.read(this.iToTopBorderMargin, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iToRightBorderMargin, 0);
        jceOutputStream.write(this.iToTopBorderMargin, 1);
    }

    public WidgetMargin(int i3, int i16) {
        this.iToRightBorderMargin = i3;
        this.iToTopBorderMargin = i16;
    }
}
