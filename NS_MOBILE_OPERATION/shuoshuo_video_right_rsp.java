package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class shuoshuo_video_right_rsp extends JceStruct {
    public boolean isverified;

    /* renamed from: msg, reason: collision with root package name */
    public String f25022msg;
    public int remain_times;
    public int ret;

    public shuoshuo_video_right_rsp() {
        this.f25022msg = "";
        this.isverified = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25022msg = jceInputStream.readString(1, false);
        this.isverified = jceInputStream.read(this.isverified, 2, false);
        this.remain_times = jceInputStream.read(this.remain_times, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25022msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.isverified, 2);
        jceOutputStream.write(this.remain_times, 3);
    }

    public shuoshuo_video_right_rsp(int i3, String str, boolean z16, int i16) {
        this.ret = i3;
        this.f25022msg = str;
        this.isverified = z16;
        this.remain_times = i16;
    }
}
