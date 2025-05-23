package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PushCardMsg extends JceStruct {
    static int cache_ePushType;
    static byte[] cache_vPushInfo;
    public int ePushType;
    public byte[] vPushInfo;

    public PushCardMsg() {
        this.ePushType = PushType.PUSH_TYPE_NONE.value();
        this.vPushInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ePushType = jceInputStream.read(this.ePushType, 0, true);
        if (cache_vPushInfo == null) {
            cache_vPushInfo = r0;
            byte[] bArr = {0};
        }
        this.vPushInfo = jceInputStream.read(cache_vPushInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ePushType, 0);
        jceOutputStream.write(this.vPushInfo, 1);
    }

    public PushCardMsg(int i3, byte[] bArr) {
        PushType.PUSH_TYPE_NONE.value();
        this.ePushType = i3;
        this.vPushInfo = bArr;
    }
}
