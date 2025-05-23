package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_videourl extends JceStruct {
    public String url;
    public byte videoprior;
    public int videorate;

    public s_videourl() {
        this.url = "";
        this.videoprior = (byte) 0;
        this.videorate = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.videoprior = jceInputStream.read(this.videoprior, 1, false);
        this.videorate = jceInputStream.read(this.videorate, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.videoprior, 1);
        jceOutputStream.write(this.videorate, 2);
    }

    public s_videourl(String str, byte b16, int i3) {
        this.url = str;
        this.videoprior = b16;
        this.videorate = i3;
    }
}
