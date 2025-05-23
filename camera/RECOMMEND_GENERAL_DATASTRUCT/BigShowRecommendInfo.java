package camera.RECOMMEND_GENERAL_DATASTRUCT;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BigShowRecommendInfo extends JceStruct {
    static MetaMaterial cache_MaterialInfo = new MetaMaterial();
    public int Confidence;
    public MetaMaterial MaterialInfo;
    public String Reason;

    public BigShowRecommendInfo() {
        this.MaterialInfo = null;
        this.Reason = "";
        this.Confidence = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MaterialInfo = (MetaMaterial) jceInputStream.read((JceStruct) cache_MaterialInfo, 0, false);
        this.Reason = jceInputStream.readString(1, false);
        this.Confidence = jceInputStream.read(this.Confidence, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        MetaMaterial metaMaterial = this.MaterialInfo;
        if (metaMaterial != null) {
            jceOutputStream.write((JceStruct) metaMaterial, 0);
        }
        String str = this.Reason;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.Confidence, 2);
    }

    public BigShowRecommendInfo(MetaMaterial metaMaterial, String str, int i3) {
        this.MaterialInfo = metaMaterial;
        this.Reason = str;
        this.Confidence = i3;
    }
}
