package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_bg_music_setting extends JceStruct {
    public byte loop_playback_flag;
    public byte wifi_autu_play_flag;

    public mobile_bg_music_setting() {
        this.wifi_autu_play_flag = (byte) 0;
        this.loop_playback_flag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wifi_autu_play_flag = jceInputStream.read(this.wifi_autu_play_flag, 0, true);
        this.loop_playback_flag = jceInputStream.read(this.loop_playback_flag, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wifi_autu_play_flag, 0);
        jceOutputStream.write(this.loop_playback_flag, 1);
    }

    public mobile_bg_music_setting(byte b16, byte b17) {
        this.wifi_autu_play_flag = b16;
        this.loop_playback_flag = b17;
    }
}
