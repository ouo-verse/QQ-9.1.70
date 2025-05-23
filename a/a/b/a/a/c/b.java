package a.a.b.a.a.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static ArrayList<a> f25181d;

    /* renamed from: a, reason: collision with root package name */
    public long f25182a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<a> f25183b;

    /* renamed from: c, reason: collision with root package name */
    public int f25184c;

    public b() {
        this.f25182a = 0L;
        this.f25183b = null;
        this.f25184c = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25182a = jceInputStream.read(this.f25182a, 0, true);
        if (f25181d == null) {
            f25181d = new ArrayList<>();
            f25181d.add(new a());
        }
        this.f25183b = (ArrayList) jceInputStream.read((JceInputStream) f25181d, 1, true);
        this.f25184c = jceInputStream.read(this.f25184c, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25182a, 0);
        jceOutputStream.write((Collection) this.f25183b, 1);
        jceOutputStream.write(this.f25184c, 2);
    }

    public b(long j3, ArrayList<a> arrayList, int i3) {
        this.f25182a = j3;
        this.f25183b = arrayList;
        this.f25184c = i3;
    }
}
