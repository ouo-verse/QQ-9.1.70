package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stResult extends JceStruct {
    static int cache_flag;
    public int flag;

    /* renamed from: msg, reason: collision with root package name */
    public String f25097msg;
    public int ret;

    public stResult() {
        this.ret = 0;
        this.flag = 0;
        this.f25097msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 1, true);
        this.flag = jceInputStream.read(this.flag, 2, true);
        this.f25097msg = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 1);
        jceOutputStream.write(this.flag, 2);
        String str = this.f25097msg;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public stResult(int i3, int i16, String str) {
        this.ret = i3;
        this.flag = i16;
        this.f25097msg = str;
    }
}
