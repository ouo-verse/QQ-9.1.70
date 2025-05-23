package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_modify_profile_req extends JceStruct {
    static s_profile_for_set cache_profile;
    public s_profile_for_set profile;
    public long uin;

    public mobile_modify_profile_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        if (cache_profile == null) {
            cache_profile = new s_profile_for_set();
        }
        this.profile = (s_profile_for_set) jceInputStream.read((JceStruct) cache_profile, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        s_profile_for_set s_profile_for_setVar = this.profile;
        if (s_profile_for_setVar != null) {
            jceOutputStream.write((JceStruct) s_profile_for_setVar, 1);
        }
    }

    public mobile_modify_profile_req(long j3, s_profile_for_set s_profile_for_setVar) {
        this.uin = j3;
        this.profile = s_profile_for_setVar;
    }
}
