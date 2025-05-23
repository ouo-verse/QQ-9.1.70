package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_video_adapter_req extends JceStruct {
    public int iFlash;
    public String strUserAgent;
    public String strVideoUrl;

    public mobile_video_adapter_req() {
        this.strVideoUrl = "";
        this.strUserAgent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strVideoUrl = jceInputStream.readString(0, false);
        this.iFlash = jceInputStream.read(this.iFlash, 1, false);
        this.strUserAgent = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strVideoUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iFlash, 1);
        String str2 = this.strUserAgent;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public mobile_video_adapter_req(String str, int i3, String str2) {
        this.strVideoUrl = str;
        this.iFlash = i3;
        this.strUserAgent = str2;
    }
}
