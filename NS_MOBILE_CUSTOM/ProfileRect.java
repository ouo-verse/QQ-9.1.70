package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfileRect extends JceStruct {
    static int cache_eAlignType;
    static ArrayList<Integer> cache_vecIndexContainer;
    public int eAlignType;
    public int iHp;
    public int iWp;
    public int iXp;
    public int iYp;
    public ArrayList<Integer> vecIndexContainer;

    public ProfileRect() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iXp = jceInputStream.read(this.iXp, 0, false);
        this.iYp = jceInputStream.read(this.iYp, 1, false);
        this.iWp = jceInputStream.read(this.iWp, 2, false);
        this.iHp = jceInputStream.read(this.iHp, 3, false);
        this.eAlignType = jceInputStream.read(this.eAlignType, 4, false);
        if (cache_vecIndexContainer == null) {
            cache_vecIndexContainer = new ArrayList<>();
            cache_vecIndexContainer.add(0);
        }
        this.vecIndexContainer = (ArrayList) jceInputStream.read((JceInputStream) cache_vecIndexContainer, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iXp, 0);
        jceOutputStream.write(this.iYp, 1);
        jceOutputStream.write(this.iWp, 2);
        jceOutputStream.write(this.iHp, 3);
        jceOutputStream.write(this.eAlignType, 4);
        ArrayList<Integer> arrayList = this.vecIndexContainer;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
    }

    public ProfileRect(int i3, int i16, int i17, int i18, int i19, ArrayList<Integer> arrayList) {
        this.iXp = i3;
        this.iYp = i16;
        this.iWp = i17;
        this.iHp = i18;
        this.eAlignType = i19;
        this.vecIndexContainer = arrayList;
    }
}
