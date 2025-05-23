package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ElementInfo extends JceStruct {
    static int cache_elementType;
    public int appid;
    public String data;
    public int elementId;
    public int elementType;
    public int itemId;

    public ElementInfo() {
        this.elementId = 0;
        this.elementType = 0;
        this.appid = 0;
        this.itemId = 0;
        this.data = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.elementId = jceInputStream.read(this.elementId, 0, false);
        this.elementType = jceInputStream.read(this.elementType, 1, false);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.itemId = jceInputStream.read(this.itemId, 3, false);
        this.data = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.elementId, 0);
        jceOutputStream.write(this.elementType, 1);
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.itemId, 3);
        String str = this.data;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public ElementInfo(int i3, int i16, int i17, int i18, String str) {
        this.elementId = i3;
        this.elementType = i16;
        this.appid = i17;
        this.itemId = i18;
        this.data = str;
    }
}
