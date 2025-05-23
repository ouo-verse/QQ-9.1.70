package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TipsInfo extends JceStruct {
    public String title = "";

    /* renamed from: msg, reason: collision with root package name */
    public String f24910msg = "";
    public int type = 0;
    public int askType = 0;
    public int iconType = 0;
    public int bgColor = 0;

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new TipsInfo();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.f24910msg = jceInputStream.readString(1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.askType = jceInputStream.read(this.askType, 3, false);
        this.iconType = jceInputStream.read(this.iconType, 4, false);
        this.bgColor = jceInputStream.read(this.bgColor, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f24910msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        int i3 = this.type;
        if (i3 != 0) {
            jceOutputStream.write(i3, 2);
        }
        int i16 = this.askType;
        if (i16 != 0) {
            jceOutputStream.write(i16, 3);
        }
        int i17 = this.iconType;
        if (i17 != 0) {
            jceOutputStream.write(i17, 4);
        }
        int i18 = this.bgColor;
        if (i18 != 0) {
            jceOutputStream.write(i18, 5);
        }
    }
}
