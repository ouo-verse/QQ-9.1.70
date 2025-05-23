package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class StateByPass extends JceStruct {
    static stRishState cache_oRishState;
    public stRishState oRishState;

    public StateByPass() {
        this.oRishState = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_oRishState == null) {
            cache_oRishState = new stRishState();
        }
        this.oRishState = (stRishState) jceInputStream.read((JceStruct) cache_oRishState, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.oRishState, 0);
    }

    public StateByPass(stRishState strishstate) {
        this.oRishState = strishstate;
    }
}
