package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUserConfigRsp extends JceStruct {
    static stCallInfo cache_call_inBg = new stCallInfo();
    public boolean auth_closed;
    public stCallInfo call_inBg;
    public int code;

    /* renamed from: msg, reason: collision with root package name */
    public String f25133msg;

    public stUserConfigRsp() {
        this.code = 0;
        this.f25133msg = "";
        this.auth_closed = true;
        this.call_inBg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.f25133msg = jceInputStream.readString(1, false);
        this.auth_closed = jceInputStream.read(this.auth_closed, 2, false);
        this.call_inBg = (stCallInfo) jceInputStream.read((JceStruct) cache_call_inBg, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        String str = this.f25133msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.auth_closed, 2);
        stCallInfo stcallinfo = this.call_inBg;
        if (stcallinfo != null) {
            jceOutputStream.write((JceStruct) stcallinfo, 3);
        }
    }

    public stUserConfigRsp(int i3, String str, boolean z16, stCallInfo stcallinfo) {
        this.code = i3;
        this.f25133msg = str;
        this.auth_closed = z16;
        this.call_inBg = stcallinfo;
    }
}
