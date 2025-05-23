package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqHeader extends JceStruct {
    public int guid;
    public int mask;

    /* renamed from: qq, reason: collision with root package name */
    public long f25880qq;
    public String qua;
    public String sid;
    public int version;

    public ReqHeader() {
        this.version = 0;
        this.qua = "";
        this.f25880qq = 0L;
        this.guid = 0;
        this.sid = "";
        this.mask = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.version = jceInputStream.read(this.version, 0, true);
        this.qua = jceInputStream.readString(1, true);
        this.f25880qq = jceInputStream.read(this.f25880qq, 2, true);
        this.guid = jceInputStream.read(this.guid, 3, true);
        this.sid = jceInputStream.readString(4, false);
        this.mask = jceInputStream.read(this.mask, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.version, 0);
        jceOutputStream.write(this.qua, 1);
        jceOutputStream.write(this.f25880qq, 2);
        jceOutputStream.write(this.guid, 3);
        String str = this.sid;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.mask, 5);
    }

    public ReqHeader(int i3, String str, long j3, int i16, String str2, int i17) {
        this.version = i3;
        this.qua = str;
        this.f25880qq = j3;
        this.guid = i16;
        this.sid = str2;
        this.mask = i17;
    }
}
