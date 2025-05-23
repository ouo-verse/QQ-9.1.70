package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stWMDBAndroidPushRsp extends JceStruct {
    static stAndroidPush cache_androidPush;
    public stAndroidPush androidPush;
    public int curPushVersion;
    public int retAndroidPush;

    public stWMDBAndroidPushRsp() {
        this.curPushVersion = 0;
        this.retAndroidPush = 0;
        this.androidPush = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.curPushVersion = jceInputStream.read(this.curPushVersion, 0, true);
        this.retAndroidPush = jceInputStream.read(this.retAndroidPush, 1, true);
        if (cache_androidPush == null) {
            cache_androidPush = new stAndroidPush();
        }
        this.androidPush = (stAndroidPush) jceInputStream.read((JceStruct) cache_androidPush, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.curPushVersion, 0);
        jceOutputStream.write(this.retAndroidPush, 1);
        jceOutputStream.write((JceStruct) this.androidPush, 2);
    }

    public stWMDBAndroidPushRsp(int i3, int i16, stAndroidPush standroidpush) {
        this.curPushVersion = i3;
        this.retAndroidPush = i16;
        this.androidPush = standroidpush;
    }
}
