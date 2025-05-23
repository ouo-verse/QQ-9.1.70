package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cardDiyComplicatedInfo extends JceStruct {
    public String detail;

    public cardDiyComplicatedInfo() {
        this.detail = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.detail = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return this.detail;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.detail;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public cardDiyComplicatedInfo(String str) {
        this.detail = str;
    }
}
