package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class category_info extends JceStruct {
    public int categoryId;
    public String name;

    public category_info() {
        this.name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, true);
        this.categoryId = jceInputStream.read(this.categoryId, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.name, 0);
        jceOutputStream.write(this.categoryId, 1);
    }

    public category_info(String str, int i3) {
        this.name = str;
        this.categoryId = i3;
    }
}
