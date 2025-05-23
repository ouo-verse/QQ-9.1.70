package a.a.b.a.a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f extends JceStruct {

    /* renamed from: h, reason: collision with root package name */
    static b f25225h;

    /* renamed from: i, reason: collision with root package name */
    static ArrayList<Long> f25226i;

    /* renamed from: j, reason: collision with root package name */
    static ArrayList<a> f25227j;

    /* renamed from: k, reason: collision with root package name */
    static byte[] f25228k;

    /* renamed from: a, reason: collision with root package name */
    public b f25229a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<Long> f25230b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<a> f25231c;

    /* renamed from: d, reason: collision with root package name */
    public String f25232d;

    /* renamed from: e, reason: collision with root package name */
    public String f25233e;

    /* renamed from: f, reason: collision with root package name */
    public byte f25234f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f25235g;

    public f() {
        this.f25229a = null;
        this.f25230b = null;
        this.f25231c = null;
        this.f25232d = "";
        this.f25233e = "";
        this.f25234f = (byte) 0;
        this.f25235g = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f25225h == null) {
            f25225h = new b();
        }
        this.f25229a = (b) jceInputStream.read((JceStruct) f25225h, 0, true);
        if (f25226i == null) {
            f25226i = new ArrayList<>();
            f25226i.add(0L);
        }
        this.f25230b = (ArrayList) jceInputStream.read((JceInputStream) f25226i, 1, true);
        if (f25227j == null) {
            f25227j = new ArrayList<>();
            f25227j.add(new a());
        }
        this.f25231c = (ArrayList) jceInputStream.read((JceInputStream) f25227j, 2, true);
        this.f25232d = jceInputStream.readString(3, false);
        this.f25233e = jceInputStream.readString(4, false);
        this.f25234f = jceInputStream.read(this.f25234f, 5, false);
        if (f25228k == null) {
            f25228k = r0;
            byte[] bArr = {0};
        }
        this.f25235g = jceInputStream.read(f25228k, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.f25229a, 0);
        jceOutputStream.write((Collection) this.f25230b, 1);
        jceOutputStream.write((Collection) this.f25231c, 2);
        String str = this.f25232d;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.f25233e;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.f25234f, 5);
        byte[] bArr = this.f25235g;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
    }

    public f(b bVar, ArrayList<Long> arrayList, ArrayList<a> arrayList2, String str, String str2, byte b16, byte[] bArr) {
        this.f25229a = bVar;
        this.f25230b = arrayList;
        this.f25231c = arrayList2;
        this.f25232d = str;
        this.f25233e = str2;
        this.f25234f = b16;
        this.f25235g = bArr;
    }
}
