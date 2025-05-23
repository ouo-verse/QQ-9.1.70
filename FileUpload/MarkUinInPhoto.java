package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class MarkUinInPhoto extends JceStruct {
    public String groupid;

    /* renamed from: h, reason: collision with root package name */
    public long f24903h;
    public boolean is_recommend;
    public long target_uin;

    /* renamed from: w, reason: collision with root package name */
    public long f24904w;

    /* renamed from: x, reason: collision with root package name */
    public long f24905x;

    /* renamed from: y, reason: collision with root package name */
    public long f24906y;

    public MarkUinInPhoto() {
        this.f24905x = 0L;
        this.f24906y = 0L;
        this.f24904w = 0L;
        this.f24903h = 0L;
        this.target_uin = 0L;
        this.groupid = "";
        this.is_recommend = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24905x = jceInputStream.read(this.f24905x, 0, false);
        this.f24906y = jceInputStream.read(this.f24906y, 1, false);
        this.f24904w = jceInputStream.read(this.f24904w, 2, false);
        this.f24903h = jceInputStream.read(this.f24903h, 3, false);
        this.target_uin = jceInputStream.read(this.target_uin, 4, false);
        this.groupid = jceInputStream.readString(5, false);
        this.is_recommend = jceInputStream.read(this.is_recommend, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24905x, 0);
        jceOutputStream.write(this.f24906y, 1);
        jceOutputStream.write(this.f24904w, 2);
        jceOutputStream.write(this.f24903h, 3);
        jceOutputStream.write(this.target_uin, 4);
        String str = this.groupid;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.is_recommend, 6);
    }

    public MarkUinInPhoto(long j3, long j16, long j17, long j18, long j19, String str, boolean z16) {
        this.f24905x = j3;
        this.f24906y = j16;
        this.f24904w = j17;
        this.f24903h = j18;
        this.target_uin = j19;
        this.groupid = str;
        this.is_recommend = z16;
    }
}
