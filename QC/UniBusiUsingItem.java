package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiUsingItem extends JceStruct {
    static ArrayList<String> cache_Nick;
    static ArrayList<String> cache_faceurl;
    static UniBusiItemDetail cache_stUniBusiItem = new UniBusiItemDetail();
    static ArrayList<UniBusiUsingUid> cache_stUniBusiUsingUidList;
    public ArrayList<String> Nick;
    public ArrayList<String> faceurl;
    public int friendcnt;
    public int groupcnt;
    public int isglobal;
    public UniBusiItemDetail stUniBusiItem;
    public ArrayList<UniBusiUsingUid> stUniBusiUsingUidList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_faceurl = arrayList;
        arrayList.add("");
        cache_stUniBusiUsingUidList = new ArrayList<>();
        cache_stUniBusiUsingUidList.add(new UniBusiUsingUid());
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_Nick = arrayList2;
        arrayList2.add("");
    }

    public UniBusiUsingItem() {
        this.stUniBusiItem = null;
        this.friendcnt = 0;
        this.groupcnt = 0;
        this.faceurl = null;
        this.stUniBusiUsingUidList = null;
        this.isglobal = 0;
        this.Nick = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stUniBusiItem = (UniBusiItemDetail) jceInputStream.read((JceStruct) cache_stUniBusiItem, 0, false);
        this.friendcnt = jceInputStream.read(this.friendcnt, 1, false);
        this.groupcnt = jceInputStream.read(this.groupcnt, 2, false);
        this.faceurl = (ArrayList) jceInputStream.read((JceInputStream) cache_faceurl, 3, false);
        this.stUniBusiUsingUidList = (ArrayList) jceInputStream.read((JceInputStream) cache_stUniBusiUsingUidList, 4, false);
        this.isglobal = jceInputStream.read(this.isglobal, 5, false);
        this.Nick = (ArrayList) jceInputStream.read((JceInputStream) cache_Nick, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        UniBusiItemDetail uniBusiItemDetail = this.stUniBusiItem;
        if (uniBusiItemDetail != null) {
            jceOutputStream.write((JceStruct) uniBusiItemDetail, 0);
        }
        jceOutputStream.write(this.friendcnt, 1);
        jceOutputStream.write(this.groupcnt, 2);
        ArrayList<String> arrayList = this.faceurl;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<UniBusiUsingUid> arrayList2 = this.stUniBusiUsingUidList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        jceOutputStream.write(this.isglobal, 5);
        ArrayList<String> arrayList3 = this.Nick;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 6);
        }
    }

    public UniBusiUsingItem(UniBusiItemDetail uniBusiItemDetail, int i3, int i16, ArrayList<String> arrayList, ArrayList<UniBusiUsingUid> arrayList2, int i17, ArrayList<String> arrayList3) {
        this.stUniBusiItem = uniBusiItemDetail;
        this.friendcnt = i3;
        this.groupcnt = i16;
        this.faceurl = arrayList;
        this.stUniBusiUsingUidList = arrayList2;
        this.isglobal = i17;
        this.Nick = arrayList3;
    }
}
