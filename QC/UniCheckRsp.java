package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniCheckRsp extends JceStruct {
    static ArrayList<UniBusinessCheckItem> cache_uniBusinessItemList = new ArrayList<>();
    public String errmsg;
    public int ret;
    public ArrayList<UniBusinessCheckItem> uniBusinessItemList;

    static {
        cache_uniBusinessItemList.add(new UniBusinessCheckItem());
    }

    public UniCheckRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.uniBusinessItemList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.uniBusinessItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_uniBusinessItemList, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<UniBusinessCheckItem> arrayList = this.uniBusinessItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public UniCheckRsp(int i3, String str, ArrayList<UniBusinessCheckItem> arrayList) {
        this.ret = i3;
        this.errmsg = str;
        this.uniBusinessItemList = arrayList;
    }
}
