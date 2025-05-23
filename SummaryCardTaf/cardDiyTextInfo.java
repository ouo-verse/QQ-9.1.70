package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cardDiyTextInfo extends JceStruct {
    public float fRotationAngle;
    public float fScaling;
    public float fTransparency;
    public int iFontId;
    public String strPoint;
    public String strText;

    public cardDiyTextInfo() {
        this.iFontId = 0;
        this.strText = "";
        this.strPoint = "";
        this.fRotationAngle = 0.0f;
        this.fScaling = 0.0f;
        this.fTransparency = 0.0f;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iFontId = jceInputStream.read(this.iFontId, 1, false);
        this.strText = jceInputStream.readString(2, false);
        this.strPoint = jceInputStream.readString(3, false);
        this.fRotationAngle = jceInputStream.read(this.fRotationAngle, 4, false);
        this.fScaling = jceInputStream.read(this.fScaling, 5, false);
        this.fTransparency = jceInputStream.read(this.fTransparency, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iFontId, 1);
        String str = this.strText;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.strPoint;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.fRotationAngle, 4);
        jceOutputStream.write(this.fScaling, 5);
        jceOutputStream.write(this.fTransparency, 6);
    }

    public cardDiyTextInfo(int i3, String str, String str2, float f16, float f17, float f18) {
        this.iFontId = i3;
        this.strText = str;
        this.strPoint = str2;
        this.fRotationAngle = f16;
        this.fScaling = f17;
        this.fTransparency = f18;
    }
}
