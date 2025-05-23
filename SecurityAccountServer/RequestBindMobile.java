package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestBindMobile extends JceStruct {
    static int cache_type;
    public boolean isFromChangeBind;
    public boolean isFromUni;
    public String mobileNo;
    public String nationCode;
    public long originBinder;
    public int type;

    public RequestBindMobile() {
        this.nationCode = "";
        this.mobileNo = "";
        this.originBinder = 0L;
        this.type = 0;
        this.isFromUni = false;
        this.isFromChangeBind = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nationCode = jceInputStream.readString(0, true);
        this.mobileNo = jceInputStream.readString(1, true);
        this.originBinder = jceInputStream.read(this.originBinder, 2, false);
        this.type = jceInputStream.read(this.type, 3, false);
        this.isFromUni = jceInputStream.read(this.isFromUni, 4, false);
        this.isFromChangeBind = jceInputStream.read(this.isFromChangeBind, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nationCode, 0);
        jceOutputStream.write(this.mobileNo, 1);
        jceOutputStream.write(this.originBinder, 2);
        jceOutputStream.write(this.type, 3);
        jceOutputStream.write(this.isFromUni, 4);
        jceOutputStream.write(this.isFromChangeBind, 5);
    }

    public RequestBindMobile(String str, String str2, long j3, int i3, boolean z16, boolean z17) {
        this.nationCode = str;
        this.mobileNo = str2;
        this.originBinder = j3;
        this.type = i3;
        this.isFromUni = z16;
        this.isFromChangeBind = z17;
    }
}
