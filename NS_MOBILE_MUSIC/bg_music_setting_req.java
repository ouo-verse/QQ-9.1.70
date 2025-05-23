package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class bg_music_setting_req extends JceStruct {
    public int setting_type;
    public int setting_value;
    public long uin;

    public bg_music_setting_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.setting_type = jceInputStream.read(this.setting_type, 1, true);
        this.setting_value = jceInputStream.read(this.setting_value, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.setting_type, 1);
        jceOutputStream.write(this.setting_value, 2);
    }

    public bg_music_setting_req(long j3, int i3, int i16) {
        this.uin = j3;
        this.setting_type = i3;
        this.setting_value = i16;
    }
}
