package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Nudge extends JceStruct {
    public String customtext;
    public int effectid;
    public int ischangecustomtext;
    public int ischangeswitch;
    public int isclose;

    public Nudge() {
        this.effectid = 0;
        this.ischangeswitch = 0;
        this.isclose = 0;
        this.ischangecustomtext = 0;
        this.customtext = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.effectid = jceInputStream.read(this.effectid, 0, false);
        this.ischangeswitch = jceInputStream.read(this.ischangeswitch, 1, false);
        this.isclose = jceInputStream.read(this.isclose, 2, false);
        this.ischangecustomtext = jceInputStream.read(this.ischangecustomtext, 3, false);
        this.customtext = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.effectid, 0);
        jceOutputStream.write(this.ischangeswitch, 1);
        jceOutputStream.write(this.isclose, 2);
        jceOutputStream.write(this.ischangecustomtext, 3);
        String str = this.customtext;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public Nudge(int i3, int i16, int i17, int i18, String str) {
        this.effectid = i3;
        this.ischangeswitch = i16;
        this.isclose = i17;
        this.ischangecustomtext = i18;
        this.customtext = str;
    }
}
