package a.a.b.a.a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e extends JceStruct {

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<d> f25222c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<d> f25223a;

    /* renamed from: b, reason: collision with root package name */
    public int f25224b;

    public e() {
        this.f25223a = null;
        this.f25224b = 64;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f25222c == null) {
            f25222c = new ArrayList<>();
            f25222c.add(new d());
        }
        this.f25223a = (ArrayList) jceInputStream.read((JceInputStream) f25222c, 1, true);
        this.f25224b = jceInputStream.read(this.f25224b, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.f25223a, 1);
        jceOutputStream.write(this.f25224b, 2);
    }

    public e(ArrayList<d> arrayList, int i3) {
        this.f25223a = arrayList;
        this.f25224b = i3;
    }
}
