package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFloatingLayerCardStyle extends JceStruct {
    public int cardType;
    public boolean commentHidden;
    public boolean dingHidden;
    public boolean shareHidden;

    public stFloatingLayerCardStyle() {
        this.cardType = 0;
        this.dingHidden = false;
        this.commentHidden = false;
        this.shareHidden = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cardType = jceInputStream.read(this.cardType, 0, false);
        this.dingHidden = jceInputStream.read(this.dingHidden, 1, false);
        this.commentHidden = jceInputStream.read(this.commentHidden, 2, false);
        this.shareHidden = jceInputStream.read(this.shareHidden, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cardType, 0);
        jceOutputStream.write(this.dingHidden, 1);
        jceOutputStream.write(this.commentHidden, 2);
        jceOutputStream.write(this.shareHidden, 3);
    }

    public stFloatingLayerCardStyle(int i3, boolean z16, boolean z17, boolean z18) {
        this.cardType = i3;
        this.dingHidden = z16;
        this.commentHidden = z17;
        this.shareHidden = z18;
    }
}
