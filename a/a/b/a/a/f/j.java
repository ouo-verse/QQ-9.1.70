package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class j extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static byte[] f25277f;

    /* renamed from: g, reason: collision with root package name */
    static byte[] f25278g;

    /* renamed from: h, reason: collision with root package name */
    static ArrayList<b> f25279h;

    /* renamed from: a, reason: collision with root package name */
    public byte f25280a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f25281b;

    /* renamed from: c, reason: collision with root package name */
    public String f25282c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f25283d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<b> f25284e;

    public j() {
        this.f25280a = (byte) 0;
        this.f25281b = null;
        this.f25282c = "";
        this.f25283d = null;
        this.f25284e = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25280a = jceInputStream.read(this.f25280a, 1, true);
        if (f25277f == null) {
            f25277f = r0;
            byte[] bArr = {0};
        }
        this.f25281b = jceInputStream.read(f25277f, 2, true);
        this.f25282c = jceInputStream.readString(3, true);
        if (f25278g == null) {
            f25278g = r0;
            byte[] bArr2 = {0};
        }
        this.f25283d = jceInputStream.read(f25278g, 4, true);
        if (f25279h == null) {
            f25279h = new ArrayList<>();
            f25279h.add(new b());
        }
        this.f25284e = (ArrayList) jceInputStream.read((JceInputStream) f25279h, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25280a, 1);
        jceOutputStream.write(this.f25281b, 2);
        jceOutputStream.write(this.f25282c, 3);
        jceOutputStream.write(this.f25283d, 4);
        ArrayList<b> arrayList = this.f25284e;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
    }

    public j(byte b16, byte[] bArr, String str, byte[] bArr2, ArrayList<b> arrayList) {
        this.f25280a = b16;
        this.f25281b = bArr;
        this.f25282c = str;
        this.f25283d = bArr2;
        this.f25284e = arrayList;
    }
}
