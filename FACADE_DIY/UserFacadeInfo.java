package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserFacadeInfo extends JceStruct {
    static UserFacadeElementDetail cache_detail = new UserFacadeElementDetail();
    public String checksum;
    public int code;
    public UserFacadeElementDetail detail;

    /* renamed from: id, reason: collision with root package name */
    public String f24896id;
    public String layout;
    public int switchStatus;

    public UserFacadeInfo() {
        this.code = 0;
        this.layout = "";
        this.checksum = "";
        this.detail = null;
        this.switchStatus = 0;
        this.f24896id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.layout = jceInputStream.readString(1, false);
        this.checksum = jceInputStream.readString(2, false);
        this.detail = (UserFacadeElementDetail) jceInputStream.read((JceStruct) cache_detail, 3, false);
        this.switchStatus = jceInputStream.read(this.switchStatus, 4, false);
        this.f24896id = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        String str = this.layout;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.checksum;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        UserFacadeElementDetail userFacadeElementDetail = this.detail;
        if (userFacadeElementDetail != null) {
            jceOutputStream.write((JceStruct) userFacadeElementDetail, 3);
        }
        jceOutputStream.write(this.switchStatus, 4);
        String str3 = this.f24896id;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public UserFacadeInfo(int i3, String str, String str2, UserFacadeElementDetail userFacadeElementDetail, int i16, String str3) {
        this.code = i3;
        this.layout = str;
        this.checksum = str2;
        this.detail = userFacadeElementDetail;
        this.switchStatus = i16;
        this.f24896id = str3;
    }
}
