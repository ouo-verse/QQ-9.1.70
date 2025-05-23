package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MusicID extends JceStruct {
    public long song_id;
    public int type;

    public MusicID() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.song_id = jceInputStream.read(this.song_id, 0, false);
        this.type = jceInputStream.read(this.type, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.song_id, 0);
        jceOutputStream.write(this.type, 1);
    }

    public MusicID(long j3, int i3) {
        this.song_id = j3;
        this.type = i3;
    }
}
