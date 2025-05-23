package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_video_list_req extends JceStruct {
    public String attach_info_new;
    public String attach_info_old;
    public long uin;

    public get_video_list_req() {
        this.attach_info_new = "";
        this.attach_info_old = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.attach_info_new = jceInputStream.readString(1, false);
        this.attach_info_old = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.attach_info_new;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.attach_info_old;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public get_video_list_req(long j3, String str, String str2) {
        this.uin = j3;
        this.attach_info_new = str;
        this.attach_info_old = str2;
    }
}
