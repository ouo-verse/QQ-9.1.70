package a.a.b.a.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static ArrayList<a> f25169f;

    /* renamed from: g, reason: collision with root package name */
    static byte[] f25170g;

    /* renamed from: a, reason: collision with root package name */
    public short f25171a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<a> f25172b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f25173c;

    /* renamed from: d, reason: collision with root package name */
    public long f25174d;

    /* renamed from: e, reason: collision with root package name */
    public long f25175e;

    public b() {
        this.f25171a = (short) 0;
        this.f25172b = null;
        this.f25173c = null;
        this.f25174d = 0L;
        this.f25175e = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25171a = jceInputStream.read(this.f25171a, 0, false);
        if (f25169f == null) {
            f25169f = new ArrayList<>();
            f25169f.add(new a());
        }
        this.f25172b = (ArrayList) jceInputStream.read((JceInputStream) f25169f, 1, false);
        if (f25170g == null) {
            f25170g = r0;
            byte[] bArr = {0};
        }
        this.f25173c = jceInputStream.read(f25170g, 2, false);
        this.f25174d = jceInputStream.read(this.f25174d, 3, false);
        this.f25175e = jceInputStream.read(this.f25175e, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25171a, 0);
        ArrayList<a> arrayList = this.f25172b;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        byte[] bArr = this.f25173c;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        jceOutputStream.write(this.f25174d, 3);
        jceOutputStream.write(this.f25175e, 4);
    }

    public b(short s16, ArrayList<a> arrayList, byte[] bArr, long j3, long j16) {
        this.f25171a = s16;
        this.f25172b = arrayList;
        this.f25173c = bArr;
        this.f25174d = j3;
        this.f25175e = j16;
    }
}
