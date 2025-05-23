package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_detail_actshuoshuo_rsp extends JceStruct {
    static ArrayList<s_user> cache_close_fri = new ArrayList<>();
    public String act_content;
    public String act_content_after;
    public ArrayList<s_user> close_fri;
    public String no_img_tips;
    public boolean require_img;

    static {
        cache_close_fri.add(new s_user());
    }

    public mobile_detail_actshuoshuo_rsp() {
        this.act_content = "";
        this.act_content_after = "";
        this.require_img = true;
        this.no_img_tips = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.act_content = jceInputStream.readString(0, false);
        this.close_fri = (ArrayList) jceInputStream.read((JceInputStream) cache_close_fri, 1, false);
        this.act_content_after = jceInputStream.readString(2, false);
        this.require_img = jceInputStream.read(this.require_img, 3, false);
        this.no_img_tips = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.act_content;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<s_user> arrayList = this.close_fri;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str2 = this.act_content_after;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.require_img, 3);
        String str3 = this.no_img_tips;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public mobile_detail_actshuoshuo_rsp(String str, ArrayList<s_user> arrayList, String str2, boolean z16, String str3) {
        this.act_content = str;
        this.close_fri = arrayList;
        this.act_content_after = str2;
        this.require_img = z16;
        this.no_img_tips = str3;
    }
}
