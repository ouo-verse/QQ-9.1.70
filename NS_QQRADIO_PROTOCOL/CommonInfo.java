package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommonInfo extends JceStruct {
    public String cookie;
    public String debugModeInfo;
    public byte hasMore;
    public byte isRefresh;
    public byte noUpdate;

    public CommonInfo() {
        this.cookie = "";
        this.isRefresh = (byte) 0;
        this.hasMore = (byte) 0;
        this.noUpdate = (byte) 0;
        this.debugModeInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cookie = jceInputStream.readString(0, false);
        this.isRefresh = jceInputStream.read(this.isRefresh, 1, false);
        this.hasMore = jceInputStream.read(this.hasMore, 2, false);
        this.noUpdate = jceInputStream.read(this.noUpdate, 3, false);
        this.debugModeInfo = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cookie;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.isRefresh, 1);
        jceOutputStream.write(this.hasMore, 2);
        jceOutputStream.write(this.noUpdate, 3);
        String str2 = this.debugModeInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public CommonInfo(String str, byte b16, byte b17, byte b18, String str2) {
        this.cookie = str;
        this.isRefresh = b16;
        this.hasMore = b17;
        this.noUpdate = b18;
        this.debugModeInfo = str2;
    }
}
