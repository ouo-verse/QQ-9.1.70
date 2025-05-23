package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniLoginCheckRsp extends JceStruct {
    static ArrayList<HamletCheck> cache_stHamletList = new ArrayList<>();
    static GetUsrKeyWordInfoRsp cache_stKeyWord;
    public String errmsg;
    public int ret;
    public ArrayList<HamletCheck> stHamletList;
    public GetUsrKeyWordInfoRsp stKeyWord;

    static {
        cache_stHamletList.add(new HamletCheck());
        cache_stKeyWord = new GetUsrKeyWordInfoRsp();
    }

    public UniLoginCheckRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.stHamletList = null;
        this.stKeyWord = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.stHamletList = (ArrayList) jceInputStream.read((JceInputStream) cache_stHamletList, 2, false);
        this.stKeyWord = (GetUsrKeyWordInfoRsp) jceInputStream.read((JceStruct) cache_stKeyWord, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<HamletCheck> arrayList = this.stHamletList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        GetUsrKeyWordInfoRsp getUsrKeyWordInfoRsp = this.stKeyWord;
        if (getUsrKeyWordInfoRsp != null) {
            jceOutputStream.write((JceStruct) getUsrKeyWordInfoRsp, 3);
        }
    }

    public UniLoginCheckRsp(int i3, String str, ArrayList<HamletCheck> arrayList, GetUsrKeyWordInfoRsp getUsrKeyWordInfoRsp) {
        this.ret = i3;
        this.errmsg = str;
        this.stHamletList = arrayList;
        this.stKeyWord = getUsrKeyWordInfoRsp;
    }
}
