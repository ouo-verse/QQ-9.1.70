package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MaterialRaceInfo extends JceStruct {
    static int cache_Level;
    public String CategoryId;
    public String CategoryName;
    public int Level;
    public String MaterialId;
    public int Position;
    public String RaceId;

    public MaterialRaceInfo() {
        this.MaterialId = "";
        this.RaceId = "";
        this.Level = 0;
        this.CategoryId = "";
        this.CategoryName = "";
        this.Position = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.MaterialId = jceInputStream.readString(0, false);
        this.RaceId = jceInputStream.readString(1, false);
        this.Level = jceInputStream.read(this.Level, 2, false);
        this.CategoryId = jceInputStream.readString(3, false);
        this.CategoryName = jceInputStream.readString(4, false);
        this.Position = jceInputStream.read(this.Position, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.MaterialId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.RaceId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.Level, 2);
        String str3 = this.CategoryId;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.CategoryName;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.Position, 5);
    }

    public MaterialRaceInfo(String str, String str2, int i3, String str3, String str4, int i16) {
        this.MaterialId = str;
        this.RaceId = str2;
        this.Level = i3;
        this.CategoryId = str3;
        this.CategoryName = str4;
        this.Position = i16;
    }
}
