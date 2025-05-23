package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MemberAttrInfo extends JceStruct {
    public String StrValue;
    public int Value;

    public MemberAttrInfo() {
        this.Value = 0;
        this.StrValue = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Value = jceInputStream.read(this.Value, 0, true);
        this.StrValue = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Value, 0);
        String str = this.StrValue;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public MemberAttrInfo(int i3, String str) {
        this.Value = i3;
        this.StrValue = str;
    }
}
