package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWeishiDengtaReportRsp extends JceStruct {
    public int code;

    /* renamed from: msg, reason: collision with root package name */
    public String f25134msg;

    public stWeishiDengtaReportRsp() {
        this.code = 0;
        this.f25134msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.f25134msg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        String str = this.f25134msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stWeishiDengtaReportRsp(int i3, String str) {
        this.code = i3;
        this.f25134msg = str;
    }
}
