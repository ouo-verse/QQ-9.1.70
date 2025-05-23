package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class text_region extends JceStruct {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f25049x;

    /* renamed from: y, reason: collision with root package name */
    public int f25050y;

    public text_region() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25049x = jceInputStream.read(this.f25049x, 0, true);
        this.f25050y = jceInputStream.read(this.f25050y, 1, true);
        this.width = jceInputStream.read(this.width, 2, true);
        this.height = jceInputStream.read(this.height, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25049x, 0);
        jceOutputStream.write(this.f25050y, 1);
        jceOutputStream.write(this.width, 2);
        jceOutputStream.write(this.height, 3);
    }

    public text_region(int i3, int i16, int i17, int i18) {
        this.f25049x = i3;
        this.f25050y = i16;
        this.width = i17;
        this.height = i18;
    }
}
