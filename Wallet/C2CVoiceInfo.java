package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class C2CVoiceInfo extends JceStruct {
    public String uuid;

    public C2CVoiceInfo() {
        this.uuid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uuid = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uuid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public C2CVoiceInfo(String str) {
        this.uuid = str;
    }
}
