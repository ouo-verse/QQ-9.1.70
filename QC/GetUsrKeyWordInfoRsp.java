package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetUsrKeyWordInfoRsp extends JceStruct {
    static ArrayList<OneKeyWordItemClient> cache_vBaseWord = new ArrayList<>();
    static ArrayList<OneKeyWordItemClient> cache_vVaWord;
    public int iShowEntry;
    public ArrayList<OneKeyWordItemClient> vBaseWord;
    public ArrayList<OneKeyWordItemClient> vVaWord;

    static {
        cache_vBaseWord.add(new OneKeyWordItemClient());
        cache_vVaWord = new ArrayList<>();
        cache_vVaWord.add(new OneKeyWordItemClient());
    }

    public GetUsrKeyWordInfoRsp() {
        this.vBaseWord = null;
        this.vVaWord = null;
        this.iShowEntry = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vBaseWord = (ArrayList) jceInputStream.read((JceInputStream) cache_vBaseWord, 0, false);
        this.vVaWord = (ArrayList) jceInputStream.read((JceInputStream) cache_vVaWord, 1, false);
        this.iShowEntry = jceInputStream.read(this.iShowEntry, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<OneKeyWordItemClient> arrayList = this.vBaseWord;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        ArrayList<OneKeyWordItemClient> arrayList2 = this.vVaWord;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 1);
        }
        jceOutputStream.write(this.iShowEntry, 2);
    }

    public GetUsrKeyWordInfoRsp(ArrayList<OneKeyWordItemClient> arrayList, ArrayList<OneKeyWordItemClient> arrayList2, int i3) {
        this.vBaseWord = arrayList;
        this.vVaWord = arrayList2;
        this.iShowEntry = i3;
    }
}
