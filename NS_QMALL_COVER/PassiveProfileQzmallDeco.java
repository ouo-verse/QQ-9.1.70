package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PassiveProfileQzmallDeco extends JceStruct {
    static ReturnToPraise cache_stReturnToPraise = new ReturnToPraise();
    public ReturnToPraise stReturnToPraise;

    public PassiveProfileQzmallDeco() {
        this.stReturnToPraise = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stReturnToPraise = (ReturnToPraise) jceInputStream.read((JceStruct) cache_stReturnToPraise, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ReturnToPraise returnToPraise = this.stReturnToPraise;
        if (returnToPraise != null) {
            jceOutputStream.write((JceStruct) returnToPraise, 0);
        }
    }

    public PassiveProfileQzmallDeco(ReturnToPraise returnToPraise) {
        this.stReturnToPraise = returnToPraise;
    }
}
