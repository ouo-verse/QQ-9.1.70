package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cluster_search_result extends JceStruct {
    public String categoryid;
    public float confidence;
    public String groupid;
    public boolean has_identify;
    public String nickname;
    public long uin;

    public cluster_search_result() {
        this.categoryid = "";
        this.confidence = 0.0f;
        this.uin = 0L;
        this.has_identify = false;
        this.groupid = "";
        this.nickname = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.categoryid = jceInputStream.readString(0, false);
        this.confidence = jceInputStream.read(this.confidence, 1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
        this.has_identify = jceInputStream.read(this.has_identify, 3, false);
        this.groupid = jceInputStream.readString(4, false);
        this.nickname = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.confidence, 1);
        jceOutputStream.write(this.uin, 2);
        jceOutputStream.write(this.has_identify, 3);
        String str2 = this.groupid;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.nickname;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public cluster_search_result(String str, float f16, long j3, boolean z16, String str2, String str3) {
        this.categoryid = str;
        this.confidence = f16;
        this.uin = j3;
        this.has_identify = z16;
        this.groupid = str2;
        this.nickname = str3;
    }
}
