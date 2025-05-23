package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class template_gift_getgift_rsp extends JceStruct {
    static s_gift_item cache_common_gift;
    static template_gift_item cache_diy_gift;
    public s_gift_item common_gift;
    public template_gift_item diy_gift;
    public int is_diy;

    public template_gift_getgift_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_diy = jceInputStream.read(this.is_diy, 0, true);
        if (cache_common_gift == null) {
            cache_common_gift = new s_gift_item();
        }
        this.common_gift = (s_gift_item) jceInputStream.read((JceStruct) cache_common_gift, 1, false);
        if (cache_diy_gift == null) {
            cache_diy_gift = new template_gift_item();
        }
        this.diy_gift = (template_gift_item) jceInputStream.read((JceStruct) cache_diy_gift, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_diy, 0);
        s_gift_item s_gift_itemVar = this.common_gift;
        if (s_gift_itemVar != null) {
            jceOutputStream.write((JceStruct) s_gift_itemVar, 1);
        }
        template_gift_item template_gift_itemVar = this.diy_gift;
        if (template_gift_itemVar != null) {
            jceOutputStream.write((JceStruct) template_gift_itemVar, 2);
        }
    }

    public template_gift_getgift_rsp(int i3, s_gift_item s_gift_itemVar, template_gift_item template_gift_itemVar) {
        this.is_diy = i3;
        this.common_gift = s_gift_itemVar;
        this.diy_gift = template_gift_itemVar;
    }
}
