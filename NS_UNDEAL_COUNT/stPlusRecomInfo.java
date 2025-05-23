package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPlusRecomInfo extends JceStruct {
    public int status;
    public String strMinProgramJson;

    public stPlusRecomInfo() {
        this.status = 0;
        this.strMinProgramJson = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, false);
        this.strMinProgramJson = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        String str = this.strMinProgramJson;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stPlusRecomInfo(int i3, String str) {
        this.status = i3;
        this.strMinProgramJson = str;
    }
}
