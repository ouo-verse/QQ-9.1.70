package SWEET_NEW_BASE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sweet_req_comm extends JceStruct {
    static int cache_pf;
    static int cache_src;
    public long loveuin;
    public long opuin;

    /* renamed from: pf, reason: collision with root package name */
    public int f25098pf;
    public String qua;
    public int src;
    public long uin;

    public sweet_req_comm() {
        this.opuin = 0L;
        this.uin = 0L;
        this.loveuin = 0L;
        this.qua = "";
        this.src = 0;
        this.f25098pf = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.opuin = jceInputStream.read(this.opuin, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.loveuin = jceInputStream.read(this.loveuin, 2, false);
        this.qua = jceInputStream.readString(3, false);
        this.src = jceInputStream.read(this.src, 4, false);
        this.f25098pf = jceInputStream.read(this.f25098pf, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.opuin, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.loveuin, 2);
        String str = this.qua;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.src, 4);
        jceOutputStream.write(this.f25098pf, 5);
    }

    public sweet_req_comm(long j3, long j16, long j17, String str, int i3, int i16) {
        this.opuin = j3;
        this.uin = j16;
        this.loveuin = j17;
        this.qua = str;
        this.src = i3;
        this.f25098pf = i16;
    }
}
