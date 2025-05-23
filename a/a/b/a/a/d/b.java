package a.a.b.a.a.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b extends JceStruct {

    /* renamed from: b, reason: collision with root package name */
    static ArrayList<a> f25192b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f25193a;

    public b() {
        this.f25193a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f25192b == null) {
            f25192b = new ArrayList<>();
            f25192b.add(new a());
        }
        this.f25193a = (ArrayList) jceInputStream.read((JceInputStream) f25192b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.f25193a, 0);
    }

    public b(ArrayList<a> arrayList) {
        this.f25193a = arrayList;
    }
}
