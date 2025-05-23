package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRandomHbIdiomRsp extends JceStruct {
    static ArrayList<String> cache_suggestIdioms;
    public long makeUin;
    public ArrayList<String> suggestIdioms;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_suggestIdioms = arrayList;
        arrayList.add("");
    }

    public GetRandomHbIdiomRsp() {
        this.makeUin = 0L;
        this.suggestIdioms = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.makeUin = jceInputStream.read(this.makeUin, 0, false);
        this.suggestIdioms = (ArrayList) jceInputStream.read((JceInputStream) cache_suggestIdioms, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.makeUin, 0);
        ArrayList<String> arrayList = this.suggestIdioms;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public GetRandomHbIdiomRsp(long j3, ArrayList<String> arrayList) {
        this.makeUin = j3;
        this.suggestIdioms = arrayList;
    }
}
