package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.msgb_rapidemotion;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_msgb_rapidemotion extends JceStruct {
    static msgb_rapidemotion cache_emotion = new msgb_rapidemotion();
    public msgb_rapidemotion emotion;

    public cell_msgb_rapidemotion() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.emotion = (msgb_rapidemotion) jceInputStream.read((JceStruct) cache_emotion, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        msgb_rapidemotion msgb_rapidemotionVar = this.emotion;
        if (msgb_rapidemotionVar != null) {
            jceOutputStream.write((JceStruct) msgb_rapidemotionVar, 0);
        }
    }

    public cell_msgb_rapidemotion(msgb_rapidemotion msgb_rapidemotionVar) {
        this.emotion = msgb_rapidemotionVar;
    }
}
