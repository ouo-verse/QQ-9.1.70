package NS_NEXTRADIO_QZONEBGMUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BGMusicForQzone extends JceStruct {
    public String showAudioUrl;
    public int showDuration;
    public String showID;
    public String showName;
    public String showPicurl;

    public BGMusicForQzone() {
        this.showID = "";
        this.showName = "";
        this.showAudioUrl = "";
        this.showPicurl = "";
        this.showDuration = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.showID = jceInputStream.readString(0, false);
        this.showName = jceInputStream.readString(1, false);
        this.showAudioUrl = jceInputStream.readString(2, false);
        this.showPicurl = jceInputStream.readString(3, false);
        this.showDuration = jceInputStream.read(this.showDuration, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.showID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.showName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.showAudioUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.showPicurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.showDuration, 4);
    }

    public BGMusicForQzone(String str, String str2, String str3, String str4, int i3) {
        this.showID = str;
        this.showName = str2;
        this.showAudioUrl = str3;
        this.showPicurl = str4;
        this.showDuration = i3;
    }
}
