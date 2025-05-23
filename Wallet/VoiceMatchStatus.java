package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VoiceMatchStatus extends JceStruct {
    public int clientTryTime;
    public int isCliVoiceSDKReady;
    public String libVersion;
    public int serverTryTime;

    public VoiceMatchStatus() {
        this.isCliVoiceSDKReady = 0;
        this.clientTryTime = 0;
        this.serverTryTime = 0;
        this.libVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isCliVoiceSDKReady = jceInputStream.read(this.isCliVoiceSDKReady, 0, false);
        this.clientTryTime = jceInputStream.read(this.clientTryTime, 1, false);
        this.serverTryTime = jceInputStream.read(this.serverTryTime, 2, false);
        this.libVersion = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isCliVoiceSDKReady, 0);
        jceOutputStream.write(this.clientTryTime, 1);
        jceOutputStream.write(this.serverTryTime, 2);
        String str = this.libVersion;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public VoiceMatchStatus(int i3, int i16, int i17, String str) {
        this.isCliVoiceSDKReady = i3;
        this.clientTryTime = i16;
        this.serverTryTime = i17;
        this.libVersion = str;
    }
}
