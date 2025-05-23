package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UserPersonalData extends JceStruct {
    static Map<Long, UserPersonalProfile> cache_mpUinToProfile = new HashMap();
    public String bigVipJumpUrl;
    public String lJumpUrl;
    public Map<Long, UserPersonalProfile> mpUinToProfile;
    public String yJumpUrl;

    static {
        cache_mpUinToProfile.put(0L, new UserPersonalProfile());
    }

    public UserPersonalData() {
        this.mpUinToProfile = null;
        this.yJumpUrl = "";
        this.lJumpUrl = "";
        this.bigVipJumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mpUinToProfile = (Map) jceInputStream.read((JceInputStream) cache_mpUinToProfile, 0, false);
        this.yJumpUrl = jceInputStream.readString(1, false);
        this.lJumpUrl = jceInputStream.readString(2, false);
        this.bigVipJumpUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, UserPersonalProfile> map = this.mpUinToProfile;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.yJumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.lJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.bigVipJumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public UserPersonalData(Map<Long, UserPersonalProfile> map, String str, String str2, String str3) {
        this.mpUinToProfile = map;
        this.yJumpUrl = str;
        this.lJumpUrl = str2;
        this.bigVipJumpUrl = str3;
    }
}
