package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tag_deatail_info extends JceStruct {
    static ArrayList<String> cache_vecReferenceTagList;
    static ArrayList<String> cache_vecTagList;
    public long uFirstClassId;
    public long uSecondClassId;
    public ArrayList<String> vecReferenceTagList;
    public ArrayList<String> vecTagList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecTagList = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_vecReferenceTagList = arrayList2;
        arrayList2.add("");
    }

    public tag_deatail_info() {
        this.vecTagList = null;
        this.uFirstClassId = 0L;
        this.uSecondClassId = 0L;
        this.vecReferenceTagList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecTagList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTagList, 0, false);
        this.uFirstClassId = jceInputStream.read(this.uFirstClassId, 1, false);
        this.uSecondClassId = jceInputStream.read(this.uSecondClassId, 2, false);
        this.vecReferenceTagList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecReferenceTagList, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.vecTagList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.uFirstClassId, 1);
        jceOutputStream.write(this.uSecondClassId, 2);
        ArrayList<String> arrayList2 = this.vecReferenceTagList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
    }

    public tag_deatail_info(ArrayList<String> arrayList, long j3, long j16, ArrayList<String> arrayList2) {
        this.vecTagList = arrayList;
        this.uFirstClassId = j3;
        this.uSecondClassId = j16;
        this.vecReferenceTagList = arrayList2;
    }
}
