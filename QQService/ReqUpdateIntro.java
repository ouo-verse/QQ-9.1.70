package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqUpdateIntro extends JceStruct {
    static ReqHead cache_stHeader;
    static Intro cache_stIntro;
    public ReqHead stHeader;
    public Intro stIntro;

    public ReqUpdateIntro() {
        this.stHeader = null;
        this.stIntro = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stIntro == null) {
            cache_stIntro = new Intro();
        }
        this.stIntro = (Intro) jceInputStream.read((JceStruct) cache_stIntro, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stIntro, 1);
    }

    public ReqUpdateIntro(ReqHead reqHead, Intro intro) {
        this.stHeader = reqHead;
        this.stIntro = intro;
    }
}
