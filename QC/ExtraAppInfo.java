package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ExtraAppInfo extends JceStruct {
    static ArrayList<FuncallOp> cache_funcallOplist;
    static ArrayList<Integer> cache_usableScene = new ArrayList<>();
    public String desc;
    public int fontType;
    public ArrayList<FuncallOp> funcallOplist;
    public String hideWordName;
    public int ringid;
    public int specialType;
    public int styleid;
    public ArrayList<Integer> usableScene;

    static {
        cache_usableScene.add(0);
        cache_funcallOplist = new ArrayList<>();
        cache_funcallOplist.add(new FuncallOp());
    }

    public ExtraAppInfo() {
        this.fontType = 0;
        this.specialType = 0;
        this.desc = "";
        this.usableScene = null;
        this.hideWordName = "";
        this.styleid = 0;
        this.ringid = 0;
        this.funcallOplist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fontType = jceInputStream.read(this.fontType, 0, false);
        this.specialType = jceInputStream.read(this.specialType, 1, false);
        this.desc = jceInputStream.readString(2, false);
        this.usableScene = (ArrayList) jceInputStream.read((JceInputStream) cache_usableScene, 3, false);
        this.hideWordName = jceInputStream.readString(4, false);
        this.styleid = jceInputStream.read(this.styleid, 5, false);
        this.ringid = jceInputStream.read(this.ringid, 6, false);
        this.funcallOplist = (ArrayList) jceInputStream.read((JceInputStream) cache_funcallOplist, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fontType, 0);
        jceOutputStream.write(this.specialType, 1);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        ArrayList<Integer> arrayList = this.usableScene;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str2 = this.hideWordName;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.styleid, 5);
        jceOutputStream.write(this.ringid, 6);
        ArrayList<FuncallOp> arrayList2 = this.funcallOplist;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
    }

    public ExtraAppInfo(int i3, int i16, String str, ArrayList<Integer> arrayList, String str2, int i17, int i18, ArrayList<FuncallOp> arrayList2) {
        this.fontType = i3;
        this.specialType = i16;
        this.desc = str;
        this.usableScene = arrayList;
        this.hideWordName = str2;
        this.styleid = i17;
        this.ringid = i18;
        this.funcallOplist = arrayList2;
    }
}
