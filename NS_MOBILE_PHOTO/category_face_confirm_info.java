package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class category_face_confirm_info extends JceStruct {
    static int cache_op;
    public String label;

    /* renamed from: op, reason: collision with root package name */
    public int f25035op;
    public long uin;

    public category_face_confirm_info() {
        this.f25035op = 0;
        this.label = "";
        this.uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25035op = jceInputStream.read(this.f25035op, 0, false);
        this.label = jceInputStream.readString(1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25035op, 0);
        String str = this.label;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uin, 2);
    }

    public category_face_confirm_info(int i3, String str, long j3) {
        this.f25035op = i3;
        this.label = str;
        this.uin = j3;
    }
}
