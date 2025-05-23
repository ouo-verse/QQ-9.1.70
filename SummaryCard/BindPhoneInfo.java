package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class BindPhoneInfo extends JceStruct {
    public String strName;

    public BindPhoneInfo() {
        this.strName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strName = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public BindPhoneInfo(String str) {
        this.strName = str;
    }
}
