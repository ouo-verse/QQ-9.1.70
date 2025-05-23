package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_profile_rsp extends JceStruct {
    static s_profile_for_get cache_profile;
    static s_user cache_user;
    public s_profile_for_get profile;
    public s_user user;

    public mobile_get_profile_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_user == null) {
            cache_user = new s_user();
        }
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        if (cache_profile == null) {
            cache_profile = new s_profile_for_get();
        }
        this.profile = (s_profile_for_get) jceInputStream.read((JceStruct) cache_profile, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        s_profile_for_get s_profile_for_getVar = this.profile;
        if (s_profile_for_getVar != null) {
            jceOutputStream.write((JceStruct) s_profile_for_getVar, 1);
        }
    }

    public mobile_get_profile_rsp(s_user s_userVar, s_profile_for_get s_profile_for_getVar) {
        this.user = s_userVar;
        this.profile = s_profile_for_getVar;
    }
}
