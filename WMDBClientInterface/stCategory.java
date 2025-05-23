package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCategory extends JceStruct {
    public String iconSelectedUrl;
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    public String f25138id;
    public String name;
    public int priority;

    public stCategory() {
        this.f25138id = "";
        this.name = "";
        this.iconUrl = "";
        this.iconSelectedUrl = "";
        this.priority = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25138id = jceInputStream.readString(0, true);
        this.name = jceInputStream.readString(1, true);
        this.iconUrl = jceInputStream.readString(2, true);
        this.iconSelectedUrl = jceInputStream.readString(3, true);
        this.priority = jceInputStream.read(this.priority, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25138id, 0);
        jceOutputStream.write(this.name, 1);
        jceOutputStream.write(this.iconUrl, 2);
        jceOutputStream.write(this.iconSelectedUrl, 3);
        jceOutputStream.write(this.priority, 4);
    }

    public stCategory(String str, String str2, String str3, String str4, int i3) {
        this.f25138id = str;
        this.name = str2;
        this.iconUrl = str3;
        this.iconSelectedUrl = str4;
        this.priority = i3;
    }
}
