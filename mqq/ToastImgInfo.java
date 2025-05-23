package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ToastImgInfo extends JceStruct {
    public int iOpen;
    public int iShowTime;
    public int iToastVer;
    public String sShortText;
    public String sText;

    public ToastImgInfo() {
        this.iOpen = 0;
        this.iToastVer = 0;
        this.sText = "";
        this.iShowTime = 0;
        this.sShortText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iOpen = jceInputStream.read(this.iOpen, 0, false);
        this.iToastVer = jceInputStream.read(this.iToastVer, 1, false);
        this.sText = jceInputStream.readString(2, false);
        this.iShowTime = jceInputStream.read(this.iShowTime, 3, false);
        this.sShortText = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iOpen, 0);
        jceOutputStream.write(this.iToastVer, 1);
        String str = this.sText;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iShowTime, 3);
        String str2 = this.sShortText;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public ToastImgInfo(int i3, int i16, String str, int i17, String str2) {
        this.iOpen = i3;
        this.iToastVer = i16;
        this.sText = str;
        this.iShowTime = i17;
        this.sShortText = str2;
    }
}
