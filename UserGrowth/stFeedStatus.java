package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFeedStatus extends JceStruct {
    public String feedId;

    /* renamed from: msg, reason: collision with root package name */
    public String f25118msg;
    public int status;

    public stFeedStatus() {
        this.feedId = "";
        this.status = 0;
        this.f25118msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feedId = jceInputStream.readString(0, false);
        this.status = jceInputStream.read(this.status, 1, false);
        this.f25118msg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.feedId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.status, 1);
        String str2 = this.f25118msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public stFeedStatus(String str, int i3, String str2) {
        this.feedId = str;
        this.status = i3;
        this.f25118msg = str2;
    }
}
