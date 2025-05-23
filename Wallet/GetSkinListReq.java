package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSkinListReq extends JceStruct {
    public int app_type;
    public String busi_type;
    public String hb_from_type;
    public long op_uin;
    public String phone_model;
    public String phone_os;
    public String qq_version;
    public int selected_id;

    public GetSkinListReq() {
        this.op_uin = 0L;
        this.app_type = 0;
        this.qq_version = "";
        this.phone_os = "";
        this.phone_model = "";
        this.busi_type = "";
        this.hb_from_type = "";
        this.selected_id = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_uin = jceInputStream.read(this.op_uin, 0, false);
        this.app_type = jceInputStream.read(this.app_type, 1, false);
        this.qq_version = jceInputStream.readString(2, false);
        this.phone_os = jceInputStream.readString(3, false);
        this.phone_model = jceInputStream.readString(4, false);
        this.busi_type = jceInputStream.readString(5, false);
        this.hb_from_type = jceInputStream.readString(6, false);
        this.selected_id = jceInputStream.read(this.selected_id, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.op_uin, 0);
        jceOutputStream.write(this.app_type, 1);
        String str = this.qq_version;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.phone_os;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.phone_model;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.busi_type;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.hb_from_type;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.selected_id, 7);
    }

    public GetSkinListReq(long j3, int i3, String str, String str2, String str3, String str4, String str5, int i16) {
        this.op_uin = j3;
        this.app_type = i3;
        this.qq_version = str;
        this.phone_os = str2;
        this.phone_model = str3;
        this.busi_type = str4;
        this.hb_from_type = str5;
        this.selected_id = i16;
    }
}
