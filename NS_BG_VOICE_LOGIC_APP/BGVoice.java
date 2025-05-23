package NS_BG_VOICE_LOGIC_APP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BGVoice extends JceStruct {
    static BGFM cache_bgFmLists = new BGFM();
    static BGMusic cache_bgMusicLists = new BGMusic();
    static int cache_iTypeValue;
    public BGFM bgFmLists;
    public BGMusic bgMusicLists;
    public int iTypeValue;

    public BGVoice() {
        this.iTypeValue = 0;
        this.bgFmLists = null;
        this.bgMusicLists = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTypeValue = jceInputStream.read(this.iTypeValue, 0, false);
        this.bgFmLists = (BGFM) jceInputStream.read((JceStruct) cache_bgFmLists, 1, false);
        this.bgMusicLists = (BGMusic) jceInputStream.read((JceStruct) cache_bgMusicLists, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTypeValue, 0);
        BGFM bgfm = this.bgFmLists;
        if (bgfm != null) {
            jceOutputStream.write((JceStruct) bgfm, 1);
        }
        BGMusic bGMusic = this.bgMusicLists;
        if (bGMusic != null) {
            jceOutputStream.write((JceStruct) bGMusic, 2);
        }
    }

    public BGVoice(int i3, BGFM bgfm, BGMusic bGMusic) {
        this.iTypeValue = i3;
        this.bgFmLists = bgfm;
        this.bgMusicLists = bGMusic;
    }
}
