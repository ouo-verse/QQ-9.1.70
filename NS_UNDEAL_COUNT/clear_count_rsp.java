package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class clear_count_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25069msg;
    public int ret;

    public clear_count_rsp() {
        this.f25069msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25069msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25069msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public clear_count_rsp(int i3, String str) {
        this.ret = i3;
        this.f25069msg = str;
    }
}
