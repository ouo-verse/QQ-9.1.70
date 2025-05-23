package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stExposureFeedInfo extends JceStruct {

    /* renamed from: id, reason: collision with root package name */
    public String f25117id;

    public stExposureFeedInfo() {
        this.f25117id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25117id = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25117id;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public stExposureFeedInfo(String str) {
        this.f25117id = str;
    }
}
