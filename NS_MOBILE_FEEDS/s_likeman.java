package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_likeman extends JceStruct {
    public s_PolyPraise cpolyPraise;
    public s_CustomPraise customPraise;
    public String refer;
    public int superflag;
    public s_user user;
    static s_user cache_user = new s_user();
    static s_CustomPraise cache_customPraise = new s_CustomPraise();
    static s_PolyPraise cache_cpolyPraise = new s_PolyPraise();

    public s_likeman() {
        this.user = null;
        this.refer = "";
        this.superflag = 0;
        this.customPraise = null;
        this.cpolyPraise = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        this.refer = jceInputStream.readString(1, false);
        this.superflag = jceInputStream.read(this.superflag, 2, false);
        this.customPraise = (s_CustomPraise) jceInputStream.read((JceStruct) cache_customPraise, 3, false);
        this.cpolyPraise = (s_PolyPraise) jceInputStream.read((JceStruct) cache_cpolyPraise, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        String str = this.refer;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.superflag, 2);
        s_CustomPraise s_custompraise = this.customPraise;
        if (s_custompraise != null) {
            jceOutputStream.write((JceStruct) s_custompraise, 3);
        }
        s_PolyPraise s_polypraise = this.cpolyPraise;
        if (s_polypraise != null) {
            jceOutputStream.write((JceStruct) s_polypraise, 4);
        }
    }

    public s_likeman(s_user s_userVar, String str, int i3, s_CustomPraise s_custompraise, s_PolyPraise s_polypraise) {
        this.user = s_userVar;
        this.refer = str;
        this.superflag = i3;
        this.customPraise = s_custompraise;
        this.cpolyPraise = s_polypraise;
    }
}
