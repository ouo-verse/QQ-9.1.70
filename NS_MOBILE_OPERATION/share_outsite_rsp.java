package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class share_outsite_rsp extends JceStruct {
    static s_arkshare cache_ark_sharedata = new s_arkshare();
    public s_arkshare ark_sharedata;
    public int iShareOutType;

    /* renamed from: msg, reason: collision with root package name */
    public String f25021msg;
    public int ret;
    public String short_url;
    public String strProgramID;
    public String strProgramMsg;
    public String strProgramPath;
    public String url;

    public share_outsite_rsp() {
        this.ret = 0;
        this.f25021msg = "";
        this.url = "";
        this.iShareOutType = 0;
        this.ark_sharedata = null;
        this.strProgramID = "";
        this.strProgramPath = "";
        this.strProgramMsg = "";
        this.short_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25021msg = jceInputStream.readString(1, false);
        this.url = jceInputStream.readString(2, false);
        this.iShareOutType = jceInputStream.read(this.iShareOutType, 3, false);
        this.ark_sharedata = (s_arkshare) jceInputStream.read((JceStruct) cache_ark_sharedata, 4, false);
        this.strProgramID = jceInputStream.readString(5, false);
        this.strProgramPath = jceInputStream.readString(6, false);
        this.strProgramMsg = jceInputStream.readString(7, false);
        this.short_url = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25021msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.iShareOutType, 3);
        s_arkshare s_arkshareVar = this.ark_sharedata;
        if (s_arkshareVar != null) {
            jceOutputStream.write((JceStruct) s_arkshareVar, 4);
        }
        String str3 = this.strProgramID;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.strProgramPath;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.strProgramMsg;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.short_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
    }

    public share_outsite_rsp(int i3, String str, String str2, int i16, s_arkshare s_arkshareVar, String str3, String str4, String str5, String str6) {
        this.ret = i3;
        this.f25021msg = str;
        this.url = str2;
        this.iShareOutType = i16;
        this.ark_sharedata = s_arkshareVar;
        this.strProgramID = str3;
        this.strProgramPath = str4;
        this.strProgramMsg = str5;
        this.short_url = str6;
    }
}
