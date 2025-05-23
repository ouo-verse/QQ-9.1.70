package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCategoryDetailReqItem extends JceStruct {
    static int cache_type;
    public String categoryid;
    public String page_str;
    public int type;

    public GetCategoryDetailReqItem() {
        this.categoryid = "";
        this.page_str = "";
        this.type = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.categoryid = jceInputStream.readString(0, false);
        this.page_str = jceInputStream.readString(1, false);
        this.type = jceInputStream.read(this.type, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.page_str;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.type, 2);
    }

    public GetCategoryDetailReqItem(String str, String str2, int i3) {
        this.categoryid = str;
        this.page_str = str2;
        this.type = i3;
    }
}
