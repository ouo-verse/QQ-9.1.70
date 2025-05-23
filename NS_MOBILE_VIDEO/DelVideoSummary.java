package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DelVideoSummary extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25053msg;
    public int ret;
    public String vid;

    public DelVideoSummary() {
        this.vid = "";
        this.f25053msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vid = jceInputStream.readString(0, false);
        this.ret = jceInputStream.read(this.ret, 1, false);
        this.f25053msg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.ret, 1);
        String str2 = this.f25053msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public DelVideoSummary(String str, int i3, String str2) {
        this.vid = str;
        this.ret = i3;
        this.f25053msg = str2;
    }
}
