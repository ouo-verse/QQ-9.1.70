package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_pwdright extends JceStruct {
    static s_user cache_data;
    public s_user data;

    public s_pwdright() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_data == null) {
            cache_data = new s_user();
        }
        this.data = (s_user) jceInputStream.read((JceStruct) cache_data, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.data;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
    }

    public s_pwdright(s_user s_userVar) {
        this.data = s_userVar;
    }
}
