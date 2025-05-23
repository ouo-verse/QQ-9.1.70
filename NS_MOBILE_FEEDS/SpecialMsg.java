package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SpecialMsg extends JceStruct {
    static byte[] cache_msg;

    /* renamed from: msg, reason: collision with root package name */
    public byte[] f24982msg;
    public int type;

    static {
        cache_msg = r0;
        byte[] bArr = {0};
    }

    public SpecialMsg() {
        this.type = 0;
        this.f24982msg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.f24982msg = jceInputStream.read(cache_msg, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        byte[] bArr = this.f24982msg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public SpecialMsg(int i3, byte[] bArr) {
        this.type = i3;
        this.f24982msg = bArr;
    }
}
