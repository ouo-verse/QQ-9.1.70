package a.a.b.a.a.f;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class i extends JceStruct {

    /* renamed from: k, reason: collision with root package name */
    static ArrayList<b> f25266k;

    /* renamed from: a, reason: collision with root package name */
    public String f25267a;

    /* renamed from: b, reason: collision with root package name */
    public byte f25268b;

    /* renamed from: c, reason: collision with root package name */
    public String f25269c;

    /* renamed from: d, reason: collision with root package name */
    public String f25270d;

    /* renamed from: e, reason: collision with root package name */
    public String f25271e;

    /* renamed from: f, reason: collision with root package name */
    public byte f25272f;

    /* renamed from: g, reason: collision with root package name */
    public byte f25273g;

    /* renamed from: h, reason: collision with root package name */
    public byte f25274h;

    /* renamed from: i, reason: collision with root package name */
    public String f25275i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<b> f25276j;

    public i() {
        this.f25267a = "";
        this.f25268b = (byte) 0;
        this.f25269c = "";
        this.f25270d = "";
        this.f25271e = "";
        this.f25272f = (byte) 0;
        this.f25273g = (byte) 0;
        this.f25274h = (byte) 0;
        this.f25275i = "";
        this.f25276j = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25267a = jceInputStream.readString(1, true);
        this.f25268b = jceInputStream.read(this.f25268b, 2, true);
        this.f25269c = jceInputStream.readString(3, true);
        this.f25270d = jceInputStream.readString(4, true);
        this.f25271e = jceInputStream.readString(5, true);
        this.f25272f = jceInputStream.read(this.f25272f, 6, true);
        this.f25273g = jceInputStream.read(this.f25273g, 7, true);
        this.f25274h = jceInputStream.read(this.f25274h, 8, true);
        this.f25275i = jceInputStream.readString(9, true);
        if (f25266k == null) {
            f25266k = new ArrayList<>();
            f25266k.add(new b());
        }
        this.f25276j = (ArrayList) jceInputStream.read((JceInputStream) f25266k, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25267a, 1);
        jceOutputStream.write(this.f25268b, 2);
        jceOutputStream.write(this.f25269c, 3);
        jceOutputStream.write(this.f25270d, 4);
        jceOutputStream.write(this.f25271e, 5);
        jceOutputStream.write(this.f25272f, 6);
        jceOutputStream.write(this.f25273g, 7);
        jceOutputStream.write(this.f25274h, 8);
        jceOutputStream.write(this.f25275i, 9);
        ArrayList<b> arrayList = this.f25276j;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
    }

    public i(String str, byte b16, String str2, String str3, String str4, byte b17, byte b18, byte b19, String str5, ArrayList<b> arrayList) {
        this.f25267a = str;
        this.f25268b = b16;
        this.f25269c = str2;
        this.f25270d = str3;
        this.f25271e = str4;
        this.f25272f = b17;
        this.f25273g = b18;
        this.f25274h = b19;
        this.f25275i = str5;
        this.f25276j = arrayList;
    }
}
