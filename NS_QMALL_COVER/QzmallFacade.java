package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.Facade;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallFacade extends JceStruct {
    static Facade cache_stFacade = new Facade();
    public int iShowOnFriDyn;
    public Facade stFacade;

    public QzmallFacade() {
        this.stFacade = null;
        this.iShowOnFriDyn = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stFacade = (Facade) jceInputStream.read((JceStruct) cache_stFacade, 0, false);
        this.iShowOnFriDyn = jceInputStream.read(this.iShowOnFriDyn, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Facade facade = this.stFacade;
        if (facade != null) {
            jceOutputStream.write((JceStruct) facade, 0);
        }
        jceOutputStream.write(this.iShowOnFriDyn, 1);
    }

    public QzmallFacade(Facade facade, int i3) {
        this.stFacade = facade;
        this.iShowOnFriDyn = i3;
    }
}
