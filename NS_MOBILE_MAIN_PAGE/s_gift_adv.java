package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_TEMPLATE_GIFT.template_gift_getgift_rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_gift_adv extends JceStruct {
    static template_gift_getgift_rsp cache_adv_gift_info;
    static int cache_adv_type;
    public template_gift_getgift_rsp adv_gift_info;
    public int adv_section_id;
    public int adv_type;
    public String img_url;

    public s_gift_adv() {
        this.img_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.img_url = jceInputStream.readString(0, true);
        this.adv_type = jceInputStream.read(this.adv_type, 1, true);
        if (cache_adv_gift_info == null) {
            cache_adv_gift_info = new template_gift_getgift_rsp();
        }
        this.adv_gift_info = (template_gift_getgift_rsp) jceInputStream.read((JceStruct) cache_adv_gift_info, 2, true);
        this.adv_section_id = jceInputStream.read(this.adv_section_id, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.img_url, 0);
        jceOutputStream.write(this.adv_type, 1);
        jceOutputStream.write((JceStruct) this.adv_gift_info, 2);
        jceOutputStream.write(this.adv_section_id, 3);
    }

    public s_gift_adv(String str, int i3, template_gift_getgift_rsp template_gift_getgift_rspVar, int i16) {
        this.img_url = str;
        this.adv_type = i3;
        this.adv_gift_info = template_gift_getgift_rspVar;
        this.adv_section_id = i16;
    }
}
