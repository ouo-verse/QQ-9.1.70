package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniGetRsp extends JceStruct {
    static NamePlate cache_stNamePlate;
    static ArrayList<UniBusinessItem> cache_uniBusinessItemList = new ArrayList<>();
    public String errmsg;
    public int ret;
    public NamePlate stNamePlate;
    public ArrayList<UniBusinessItem> uniBusinessItemList;

    static {
        cache_uniBusinessItemList.add(new UniBusinessItem());
        cache_stNamePlate = new NamePlate();
    }

    public UniGetRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.uniBusinessItemList = null;
        this.stNamePlate = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.uniBusinessItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_uniBusinessItemList, 2, false);
        this.stNamePlate = (NamePlate) jceInputStream.read((JceStruct) cache_stNamePlate, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<UniBusinessItem> arrayList = this.uniBusinessItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        NamePlate namePlate = this.stNamePlate;
        if (namePlate != null) {
            jceOutputStream.write((JceStruct) namePlate, 3);
        }
    }

    public UniGetRsp(int i3, String str, ArrayList<UniBusinessItem> arrayList, NamePlate namePlate) {
        this.ret = i3;
        this.errmsg = str;
        this.uniBusinessItemList = arrayList;
        this.stNamePlate = namePlate;
    }
}
