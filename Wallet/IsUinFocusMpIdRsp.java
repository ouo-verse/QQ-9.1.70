package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class IsUinFocusMpIdRsp extends JceStruct {
    public String account_name;
    public String describe_content;
    public String icon_url;
    public int is_focus_link_mp_id;
    public String link_mp_id;
    public String link_mp_id_admin_uin;
    public int status_code;

    public IsUinFocusMpIdRsp() {
        this.link_mp_id = "";
        this.link_mp_id_admin_uin = "";
        this.is_focus_link_mp_id = 0;
        this.account_name = "";
        this.describe_content = "";
        this.icon_url = "";
        this.status_code = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.link_mp_id = jceInputStream.readString(0, false);
        this.link_mp_id_admin_uin = jceInputStream.readString(1, false);
        this.is_focus_link_mp_id = jceInputStream.read(this.is_focus_link_mp_id, 2, false);
        this.account_name = jceInputStream.readString(3, false);
        this.describe_content = jceInputStream.readString(4, false);
        this.icon_url = jceInputStream.readString(5, false);
        this.status_code = jceInputStream.read(this.status_code, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.link_mp_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.link_mp_id_admin_uin;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.is_focus_link_mp_id, 2);
        String str3 = this.account_name;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.describe_content;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.icon_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.status_code, 6);
    }

    public IsUinFocusMpIdRsp(String str, String str2, int i3, String str3, String str4, String str5, int i16) {
        this.link_mp_id = str;
        this.link_mp_id_admin_uin = str2;
        this.is_focus_link_mp_id = i3;
        this.account_name = str3;
        this.describe_content = str4;
        this.icon_url = str5;
        this.status_code = i16;
    }
}
