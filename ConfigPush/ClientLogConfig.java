package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ClientLogConfig extends JceStruct {
    static TimeStamp cache_time_finish;
    static TimeStamp cache_time_start;
    public int cookie;
    public byte loglevel;
    public long lseq;
    public TimeStamp time_finish;
    public TimeStamp time_start;
    public int type;

    public ClientLogConfig() {
        this.type = 0;
        this.time_start = null;
        this.time_finish = null;
        this.loglevel = (byte) 0;
        this.cookie = 0;
        this.lseq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 1, true);
        if (cache_time_start == null) {
            cache_time_start = new TimeStamp();
        }
        this.time_start = (TimeStamp) jceInputStream.read((JceStruct) cache_time_start, 2, false);
        if (cache_time_finish == null) {
            cache_time_finish = new TimeStamp();
        }
        this.time_finish = (TimeStamp) jceInputStream.read((JceStruct) cache_time_finish, 3, false);
        this.loglevel = jceInputStream.read(this.loglevel, 4, false);
        this.cookie = jceInputStream.read(this.cookie, 5, false);
        this.lseq = jceInputStream.read(this.lseq, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 1);
        TimeStamp timeStamp = this.time_start;
        if (timeStamp != null) {
            jceOutputStream.write((JceStruct) timeStamp, 2);
        }
        TimeStamp timeStamp2 = this.time_finish;
        if (timeStamp2 != null) {
            jceOutputStream.write((JceStruct) timeStamp2, 3);
        }
        jceOutputStream.write(this.loglevel, 4);
        jceOutputStream.write(this.cookie, 5);
        jceOutputStream.write(this.lseq, 6);
    }

    public ClientLogConfig(int i3, TimeStamp timeStamp, TimeStamp timeStamp2, byte b16, int i16, long j3) {
        this.type = i3;
        this.time_start = timeStamp;
        this.time_finish = timeStamp2;
        this.loglevel = b16;
        this.cookie = i16;
        this.lseq = j3;
    }
}
