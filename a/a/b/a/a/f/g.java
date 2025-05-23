package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class g extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f25259a;

    public g() {
        this.f25259a = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25259a = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25259a, 1);
    }

    public g(String str) {
        this.f25259a = str;
    }
}
