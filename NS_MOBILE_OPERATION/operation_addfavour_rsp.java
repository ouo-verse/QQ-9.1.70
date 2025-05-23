package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_addfavour_rsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25010msg;
    public int ret;
    public String strFavID;

    public operation_addfavour_rsp() {
        this.f25010msg = "";
        this.strFavID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25010msg = jceInputStream.readString(1, false);
        this.strFavID = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25010msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strFavID;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public operation_addfavour_rsp(int i3, String str, String str2) {
        this.ret = i3;
        this.f25010msg = str;
        this.strFavID = str2;
    }
}
