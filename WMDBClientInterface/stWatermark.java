package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWatermark extends JceStruct {
    public String categoryId;

    /* renamed from: id, reason: collision with root package name */
    public String f25140id;
    public int mask;
    public int miniSupportVersion;
    public String name;
    public String packageUrl4Android;
    public String packageUrl4iPhone;
    public int priority;
    public String thumbUrl;
    public int version;

    public stWatermark() {
        this.f25140id = "";
        this.name = "";
        this.categoryId = "";
        this.thumbUrl = "";
        this.packageUrl4Android = "";
        this.packageUrl4iPhone = "";
        this.miniSupportVersion = 0;
        this.mask = 1;
        this.version = 1;
        this.priority = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25140id = jceInputStream.readString(0, true);
        this.name = jceInputStream.readString(1, true);
        this.categoryId = jceInputStream.readString(2, true);
        this.thumbUrl = jceInputStream.readString(3, true);
        this.packageUrl4Android = jceInputStream.readString(4, true);
        this.packageUrl4iPhone = jceInputStream.readString(5, true);
        this.miniSupportVersion = jceInputStream.read(this.miniSupportVersion, 6, true);
        this.mask = jceInputStream.read(this.mask, 8, true);
        this.version = jceInputStream.read(this.version, 9, true);
        this.priority = jceInputStream.read(this.priority, 10, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25140id, 0);
        jceOutputStream.write(this.name, 1);
        jceOutputStream.write(this.categoryId, 2);
        jceOutputStream.write(this.thumbUrl, 3);
        jceOutputStream.write(this.packageUrl4Android, 4);
        jceOutputStream.write(this.packageUrl4iPhone, 5);
        jceOutputStream.write(this.miniSupportVersion, 6);
        jceOutputStream.write(this.mask, 8);
        jceOutputStream.write(this.version, 9);
        jceOutputStream.write(this.priority, 10);
    }

    public stWatermark(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, int i17, int i18) {
        this.f25140id = str;
        this.name = str2;
        this.categoryId = str3;
        this.thumbUrl = str4;
        this.packageUrl4Android = str5;
        this.packageUrl4iPhone = str6;
        this.miniSupportVersion = i3;
        this.mask = i16;
        this.version = i17;
        this.priority = i18;
    }
}
