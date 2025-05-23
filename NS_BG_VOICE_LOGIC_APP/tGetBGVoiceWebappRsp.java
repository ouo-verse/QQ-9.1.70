package NS_BG_VOICE_LOGIC_APP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tGetBGVoiceWebappRsp extends JceStruct {
    static BGVoice cache_stBGVoice = new BGVoice();
    public int iRet;
    public byte loop_playback_flag;
    public byte play_mode_flag;
    public BGVoice stBGVoice;
    public String strErrMsg;
    public byte wifi_auto_play;

    public tGetBGVoiceWebappRsp() {
        this.iRet = 0;
        this.strErrMsg = "";
        this.stBGVoice = null;
        this.wifi_auto_play = (byte) 0;
        this.play_mode_flag = (byte) 0;
        this.loop_playback_flag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, false);
        this.strErrMsg = jceInputStream.readString(1, false);
        this.stBGVoice = (BGVoice) jceInputStream.read((JceStruct) cache_stBGVoice, 2, false);
        this.wifi_auto_play = jceInputStream.read(this.wifi_auto_play, 3, false);
        this.play_mode_flag = jceInputStream.read(this.play_mode_flag, 4, false);
        this.loop_playback_flag = jceInputStream.read(this.loop_playback_flag, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        String str = this.strErrMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        BGVoice bGVoice = this.stBGVoice;
        if (bGVoice != null) {
            jceOutputStream.write((JceStruct) bGVoice, 2);
        }
        jceOutputStream.write(this.wifi_auto_play, 3);
        jceOutputStream.write(this.play_mode_flag, 4);
        jceOutputStream.write(this.loop_playback_flag, 5);
    }

    public tGetBGVoiceWebappRsp(int i3, String str, BGVoice bGVoice, byte b16, byte b17, byte b18) {
        this.iRet = i3;
        this.strErrMsg = str;
        this.stBGVoice = bGVoice;
        this.wifi_auto_play = b16;
        this.play_mode_flag = b17;
        this.loop_playback_flag = b18;
    }
}
