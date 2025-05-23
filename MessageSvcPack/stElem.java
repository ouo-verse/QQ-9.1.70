package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stElem extends JceStruct {
    static stFace cache_face;
    static stText cache_text;

    /* renamed from: face, reason: collision with root package name */
    public stFace f24917face;
    public stText text;

    public stElem() {
        this.text = null;
        this.f24917face = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_text == null) {
            cache_text = new stText();
        }
        this.text = (stText) jceInputStream.read((JceStruct) cache_text, 0, false);
        if (cache_face == null) {
            cache_face = new stFace();
        }
        this.f24917face = (stFace) jceInputStream.read((JceStruct) cache_face, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stText sttext = this.text;
        if (sttext != null) {
            jceOutputStream.write((JceStruct) sttext, 0);
        }
        stFace stface = this.f24917face;
        if (stface != null) {
            jceOutputStream.write((JceStruct) stface, 1);
        }
    }

    public stElem(stText sttext, stFace stface) {
        this.text = sttext;
        this.f24917face = stface;
    }
}
