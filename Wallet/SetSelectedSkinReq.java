package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetSelectedSkinReq extends JceStruct {
    public int app_type;
    public long op_uin;
    public String phone_model;
    public String phone_os;
    public String qq_version;
    public int skin_id;

    public SetSelectedSkinReq() {
        this.op_uin = 0L;
        this.app_type = 0;
        this.qq_version = "";
        this.phone_os = "";
        this.phone_model = "";
        this.skin_id = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.op_uin = jceInputStream.read(this.op_uin, 0, false);
        this.app_type = jceInputStream.read(this.app_type, 1, false);
        this.qq_version = jceInputStream.readString(2, false);
        this.phone_os = jceInputStream.readString(3, false);
        this.phone_model = jceInputStream.readString(4, false);
        this.skin_id = jceInputStream.read(this.skin_id, 5, true);
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
        jceOutputStream.write(this.skin_id, 5);
    }

    public SetSelectedSkinReq(long j3, int i3, String str, String str2, String str3, int i16) {
        this.op_uin = j3;
        this.app_type = i3;
        this.qq_version = str;
        this.phone_os = str2;
        this.phone_model = str3;
        this.skin_id = i16;
    }
}
